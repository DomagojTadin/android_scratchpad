package com.REST

import com.REST.RESTClients.HttpClient
import com.REST.RESTCalls.RESTCall

class RESTHandler {

    HttpClient httpClient

    Queue<RESTCall> restCallQueue = new LinkedList<RESTCall>()

    public RESTHandler(HttpClient httpClient){
        this.httpClient = httpClient
    }

    public RESTHandler queue(RESTCall restCall){
        this.restCallQueue.add(restCall)
        return this
    }

    public void send() {
        for (c in restCallQueue){
            c.constructCall()
            constructCurl(c)
            def response = httpClient.send(c)
            c.handleResponse(response)
        }
    }

    private void constructCurl(currentRestCall) {

        String curl = "\n\ncurl -iX " + currentRestCall.getRestMethod().toString() + " '" + currentRestCall.getEndpoint()

        if (currentRestCall.getRESTCall.path) {
            curl = curl + "/" + currentRestCall.getRESTCall.path + "'"
        } else {
            curl = curl + "'"
        }

        for (String h in currentRestCall.getRESTCall.headers) {
            curl = curl + " -H " + "'" + h + "'"
        }

        curl = curl + " -H 'Content-Type: application/json'"
        curl = curl.replace("=", ": ")

        /*
        Needs work:  this is currently to just construct the string in cURL command format.
        OSS timestamps are not being formatted properly.
        */
        if (currentRestCall.getRestMethod().toString().toLowerCase() != 'get' || currentRestCall.getRestMethod().toString().toLowerCase() != 'delete') {
            String body = currentRestCall.getRESTCall.body.toString()
            body = body.replace('[', '"')
            body = body.replace(':', '":"')
            body = body.replace(', ', '", "')
            body = body.replace(']', '"')
            curl = curl + " -d '{" + body + "}'"
            curl = curl.replace('{""', '{["')
            curl = curl.replace(':"""', ':""]')
        }

        println(curl + "\n\n")
    }
}
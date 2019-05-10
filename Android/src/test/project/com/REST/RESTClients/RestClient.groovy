package com.api.httpClients

import com.api.restCalls.RESTCall
import groovyx.net.http.Method
import groovyx.net.http.RESTClient

/**
 * Created by dtadin on 4/29/19.
 */
class RestClient implements HttpClient {

    public RestClient(){

    }

    def send (RESTCall restCall){
        def request = restCall.getRESTCall()

        RESTClient restClient = new RESTClient(restCall.getEndpoint() + '/')
        restClient.ignoreSSLIssues()
        restClient.setContentType(request.requestContentType)

        restClient.handler.failure = restClient.handler.success

        def response = restClient.request(Method.valueOf(restCall.getRestMethod())
        ) { req ->
            uri.path = request.path
            headers = request.headers
            body = request.body
        }

        return responseJson(response)
    }

    Map responseJson(def response){

        Map responseMap = ["status":response.status,
        "data":response.data]

        return responseMap
    }
}

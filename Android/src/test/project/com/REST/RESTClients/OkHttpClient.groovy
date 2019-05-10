package com.RESTClients

import com.api.RESTCalls.RESTCall
import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import okhttp3.Call
import okhttp3.Headers
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response

/**
 * Created by dtadin on 4/29/19.
 */
class OkHttp implements RESTClient{

    public OkHttp(){

    }

    OkHttpClient client = new OkHttpClient();
    JsonSlurper jsonSlurper = new JsonSlurper()

    def send(RESTCall restCall){

        String url = restCall.endpoint+"/"+restCall.restCall.path
        MediaType mediaType = MediaType.parse(restCall.restCall.requestContentType)
        def body

        if(restCall.restMethod == 'GET'){
            body = null
        } else {
            JsonBuilder jsonBuilder = new JsonBuilder()
            jsonBuilder.call(restCall.restCall["body"])
            body = RequestBody.create(mediaType, jsonBuilder.toString())
        }

        Headers.Builder builder = new Headers.Builder();
        for (h in restCall.restCall["headers"]) {
            builder.add(h.key.toString(), h.value.toString())
        }
        Headers headers = builder.build()

        Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .method(restCall.restMethod, body)
                .build()

        Call call = client.newCall(request)
        Response response = call.execute()

        Map responseMap = responseJson(response)
        return responseMap

    }

    Map responseJson(def response){

        String body = response.body().string()
        def responseParsed = jsonSlurper.parseText(body)

        Map responseMap = ["status" : response.code(),
                           "headers": response.headers(),
                           "data"   : responseParsed]

        return responseMap
    }
}

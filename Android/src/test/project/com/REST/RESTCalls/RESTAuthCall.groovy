package com.REST.RESTCalls

import com.REST.RESTResponseDatastore
import com.testData.TestData
import com.utilities.ConfigReader
import groovyx.net.http.Method

import static java.util.UUID.randomUUID

/**
 * Created by dtadin on 1/21/19.
 */
class RESTAuthCall implements ApiCall {

    RESTResponseDatastore restResponseDatastore

    public RESTAuthCall(RESTResponseDatastore restResponseDataStore, String username, String password) {
        this.RESTResponseDatastore = RESTResponseDatastore
        this.username = username
        this.password = password
    }

    private String methodType = 'POST'
    private String endpoint = "dummyURL.com/v1/endpoint/"
    private String username
    private String password

    private Map restCall = [:]

    public void constructCall(){
        apiCall.putAll(['path'              : 'auth',
                        'requestContentType': 'application/json',
                        'headers'           : ['headerKey'    : "headerValue"],
                        'body'              : [
                                "username": username,
                                "password": password
                        ]])
    }

    public void handleResponse(def response) {
        println("response status: "+response.status)
        if (response.status != 201){
            println("Auth Failure")
        } else {
            println("Auth response \n" + response.data)
            RESTResponseDatastore.setAuthToken("authToken", response.data.dummyAuthToken)
        }

    }

    public String getRestMethod() {
        return methodType
    }

    public String getEndpoint() {
        return endpoint
    }

    public Map getRESTCall() {
        return restCall
    }
}

package com.api.RESTClients

import com.api.RESTCalls.RESTCall

/**
 * Created by dtadin on 05/09/19.
 */

interface HttpClient {

    def send(RESTCall restCall);

    Map responseJson(def response);

}
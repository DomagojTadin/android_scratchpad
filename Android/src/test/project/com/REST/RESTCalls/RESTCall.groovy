package com.REST.RESTCalls

/**
 * Created by dtadin on 1/18/19.
 */
interface RESTCall {

    public void constructCall();

    public void handleResponse(def response);

    public String getRestMethod();

    public String getEndpoint();

    public Map getRESTCall();
}
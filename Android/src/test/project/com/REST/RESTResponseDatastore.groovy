package com.REST

/**
 * Created by dtadin on 05/09/19.
 */

class RESTResponseDatastore {

    private Map authTokens = [:],
                responseHeaders = [:],
                RESTData = [:]

    public Map getAuthTokens() {
        return authTokens
    }

    public void setAuthToken(String tokenName, String tokenValue) {
        this.authTokens.put(tokenName, tokenValue)
    }

    public Map getResponseHeader() {
        return responseHeaders
    }

    public void setResponseHeader(String responseHeaderKey, String responseHeader) {
        this.responseHeaders.put(responseHeaderKey, responseHeader)
    }

    public Map getRESTDataStore() {
        return RESTData
    }

    public void setRESTResponseDataStoreEntry(def RESTDataKey, def RESTDataValue) {
        this.RESTData.put(RESTDataKey, RESTDataValue);
    }

    public void setRESTResponseDataStoreEntry(Map map) {
        for (p in map) {
            this.RESTData.put(p.key, p.value)
        }
    }
}

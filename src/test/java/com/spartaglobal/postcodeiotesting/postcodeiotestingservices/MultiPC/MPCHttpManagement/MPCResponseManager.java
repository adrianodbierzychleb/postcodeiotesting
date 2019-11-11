package com.spartaglobal.postcodeiotesting.postcodeiotestingservices.MultiPC.MPCHttpManagement;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class MPCResponseManager {

    private CloseableHttpResponse mpcResponse;

    public void setFullResponse(CloseableHttpResponse mpcResponse){
        this.mpcResponse = mpcResponse;
    }

    public String getResponseBody(){
        String responseBody = null;
        try {
            responseBody = EntityUtils.toString(mpcResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseBody;
    }

}

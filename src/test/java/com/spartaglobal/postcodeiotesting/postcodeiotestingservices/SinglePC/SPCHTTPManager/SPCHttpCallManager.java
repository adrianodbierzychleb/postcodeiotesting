package com.spartaglobal.postcodeiotesting.postcodeiotestingservices.SinglePC.SPCHTTPManager;

import com.spartaglobal.postcodeiotesting.postcodeiotestingservices.URLConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class SPCHttpCallManager {


    public CloseableHttpResponse executeSPCGetrequest(String postcode){

        CloseableHttpResponse SCGetResponse = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet getSPC = new HttpGet(URLConfig.BASEURL + URLConfig.POSTCODESENDPOINT + postcode);
        try {
            SCGetResponse = httpClient.execute(getSPC);
        }catch(IOException e)
        {
            e.printStackTrace();
        }

        return SCGetResponse;
    }

}

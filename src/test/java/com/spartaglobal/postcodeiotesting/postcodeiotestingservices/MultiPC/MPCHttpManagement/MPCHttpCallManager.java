package com.spartaglobal.postcodeiotesting.postcodeiotestingservices.MultiPC.MPCHttpManagement;

import com.spartaglobal.postcodeiotesting.postcodeiotestingservices.MultiPC.MPCJsonGenerator.MPCJsonGenerator;
import com.spartaglobal.postcodeiotesting.postcodeiotestingservices.URLConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class MPCHttpCallManager {

    MPCJsonGenerator mpcJsonGenerator;


    public MPCHttpCallManager(){
        mpcJsonGenerator = new MPCJsonGenerator();
    }

    public CloseableHttpResponse executeMPCPostRequest(String listOfPostCodesSplitByComma){
        CloseableHttpResponse mpcResponse = null;

        try{
            CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
            HttpPost postMPC = new HttpPost(URLConfig.BASEURL+ URLConfig.POSTCODESENDPOINT);
            postMPC.setHeader("Content-Type", "application/json");
            postMPC.setEntity(mpcJsonGenerator.createMPCJsonQuery(listOfPostCodesSplitByComma));
            mpcResponse = closeableHttpClient.execute(postMPC);
        }catch(IOException e)
        {
            e.printStackTrace();
        }

        return mpcResponse;
    }

}

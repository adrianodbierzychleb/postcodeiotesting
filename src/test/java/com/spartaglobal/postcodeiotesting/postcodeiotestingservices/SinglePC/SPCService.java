package com.spartaglobal.postcodeiotesting.postcodeiotestingservices.SinglePC;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spartaglobal.postcodeiotesting.postcodeiotestingservices.SinglePC.SPCDTO.SPCDTO;
import com.spartaglobal.postcodeiotesting.postcodeiotestingservices.SinglePC.SPCHTTPManager.SPCHttpCallManager;
import com.spartaglobal.postcodeiotesting.postcodeiotestingservices.SinglePC.SPCHTTPManager.SPCHttpResponseManager;

import java.io.IOException;

public class SPCService {

    private SPCHttpResponseManager spcHttpResponseManager;
    private SPCHttpCallManager spcHttpCallManager;
    private ObjectMapper objectMapper;

    public SPCService() {
        spcHttpCallManager = new SPCHttpCallManager();
        spcHttpResponseManager = new SPCHttpResponseManager();
        objectMapper = new ObjectMapper();
    }

    public void executeSinglePostcodeCall(String postcode){
        spcHttpResponseManager.setFullResponse(spcHttpCallManager.executeSPCGetrequest(postcode));
    }

    public SPCDTO getParsedJSONResponse(){
        SPCDTO parsedResponse = null;
        try {
            parsedResponse =objectMapper.readValue(spcHttpResponseManager.getResponseBody(), SPCDTO.class);
        }catch(IOException e){
            e.printStackTrace();
        }
        return parsedResponse;
    }


}

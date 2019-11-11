package com.spartaglobal.postcodeiotesting.postcodeiotestingservices.MultiPC;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spartaglobal.postcodeiotesting.postcodeiotestingservices.MultiPC.MPCDTO.MPCDTO;
import com.spartaglobal.postcodeiotesting.postcodeiotestingservices.MultiPC.MPCHttpManagement.MPCHttpCallManager;
import com.spartaglobal.postcodeiotesting.postcodeiotestingservices.MultiPC.MPCHttpManagement.MPCResponseManager;

import java.io.IOException;

public class MPCService {

    private MPCHttpCallManager mpcHttpCallManager;
    private MPCResponseManager mpcResponseManager;
    private ObjectMapper objectMapper;

    public MPCService(){
        this.mpcHttpCallManager = new MPCHttpCallManager();
        this.mpcResponseManager = new MPCResponseManager();
        this.objectMapper = new ObjectMapper();
    }

    public void executeMPCPostRequest(String listOfPostcodesSplitByComma){
        mpcResponseManager.setFullResponse(mpcHttpCallManager.executeMPCPostRequest(listOfPostcodesSplitByComma));

    }

    public MPCDTO getParsedJSONResponse(){
        MPCDTO parsedResponse = null;
        try{
            parsedResponse = objectMapper.readValue(mpcResponseManager.getResponseBody(), MPCDTO.class);
        }catch(IOException e){
            e.printStackTrace();
        }
        return parsedResponse;
    }





}

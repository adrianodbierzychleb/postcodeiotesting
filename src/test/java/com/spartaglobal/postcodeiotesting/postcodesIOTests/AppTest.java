package com.spartaglobal.postcodeiotesting.postcodesIOTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.spartaglobal.postcodeiotesting.postcodeiotestingservices.MultiPC.MPCHttpManagement.MPCHttpCallManager;
import com.spartaglobal.postcodeiotesting.postcodeiotestingservices.MultiPC.MPCJsonGenerator.MPCJsonGenerator;
import com.spartaglobal.postcodeiotesting.postcodeiotestingservices.MultiPC.MPCService;
import com.spartaglobal.postcodeiotesting.postcodeiotestingservices.SinglePC.SPCDTO.SPCDTO;
import com.spartaglobal.postcodeiotesting.postcodeiotestingservices.SinglePC.SPCHTTPManager.SPCHttpCallManager;
import com.spartaglobal.postcodeiotesting.postcodeiotestingservices.SinglePC.SPCHTTPManager.SPCHttpResponseManager;
import com.spartaglobal.postcodeiotesting.postcodeiotestingservices.SinglePC.SPCService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

//    private static SPCService spcService;
//    private static MPCJsonGenerator mpcJsonGenerator;
//    private static MPCHttpCallManager mpcHttpCallManager;

    private static MPCService mpcService;
    private static Map<String, Object> firstResponse;
    private static Map<String, Object> secondResponse;

    @BeforeClass
    public static void setup()
    {
        mpcService = new MPCService();
        mpcService.executeMPCPostRequest("SE12 0nb, Se3 8pf");
//        mpcHttpCallManager = new MPCHttpCallManager();
//        mpcJsonGenerator = new MPCJsonGenerator();
//        spcService = new SPCService();
//        spcService.executeSinglePostcodeCall("se120ng");
        firstResponse = mpcService.getParsedJSONResponse().getResult().get(0);
        secondResponse = mpcService.getParsedJSONResponse().getResult().get(1);
    }



    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println(secondResponse.get("postcode"));
        //System.out.println(mpcService.getParsedJSONResponse().getStatus());
        //System.out.println(mpcService.getParsedJSONResponse().getResult().get(1));
        //mpcJsonGenerator.createMPCJsonQuery("SE12 0nb, Se3 8pf");
        //Assert.assertEquals(200, spcService.getParsedJSONResponse().getStatus());
        //Assert.assertEquals("se120nb", spcService.getParsedJSONResponse().getPostcode());
    }
}

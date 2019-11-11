package com.spartaglobal.postcodeiotesting.postcodesIOTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.spartaglobal.postcodeiotesting.postcodeiotestingservices.SinglePC.SPCDTO.SPCDTO;
import com.spartaglobal.postcodeiotesting.postcodeiotestingservices.SinglePC.SPCHTTPManager.SPCHttpCallManager;
import com.spartaglobal.postcodeiotesting.postcodeiotestingservices.SinglePC.SPCHTTPManager.SPCHttpResponseManager;
import com.spartaglobal.postcodeiotesting.postcodeiotestingservices.SinglePC.SPCService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    private static SPCService spcService;


    @BeforeClass
    public static void setup()
    {
        spcService = new SPCService();
        spcService.executeSinglePostcodeCall("se120ng");
    }



    @Test
    public void shouldAnswerWithTrue()
    {
        Assert.assertEquals(200, spcService.getParsedJSONResponse().getStatus());
        //Assert.assertEquals("se120nb", spcService.getParsedJSONResponse().getPostcode());
    }
}

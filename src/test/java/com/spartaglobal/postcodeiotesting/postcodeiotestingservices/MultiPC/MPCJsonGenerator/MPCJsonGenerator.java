package com.spartaglobal.postcodeiotesting.postcodeiotestingservices.MultiPC.MPCJsonGenerator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.apache.http.entity.StringEntity;

import javax.swing.text.html.parser.Entity;

public class MPCJsonGenerator {
    // {"postcodes":["se120nb","se38pf"]}

    private ObjectMapper objectMapper = new ObjectMapper();

    public StringEntity createMPCJsonQuery(String listOfPostcodesSplitByComma)
    {
        ArrayNode postcodeArrayNode = objectMapper.createArrayNode();
        String MPCBaseNode = "{\"postcodes\":";
        String closingJsonBracket = "}";
        String[] postcodeArray = listOfPostcodesSplitByComma.split(",");

        for (String postcode: postcodeArray)
        {
            postcodeArrayNode.add(postcode.replaceAll("\\s",""));
        }
        System.out.println(MPCBaseNode + postcodeArrayNode + closingJsonBracket);
        return new StringEntity(MPCBaseNode + postcodeArrayNode + closingJsonBracket, "UTF-8");

    }

}

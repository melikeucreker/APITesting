package tests;

import TestDatas.TestDataJsonPlaceHolder;
import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_TestDataClassKullanimi extends BaseUrlJsonPlaceHolder {
    @Test
    public void test01(){
        specJsonPlaceHolder.pathParams("pp1","posts","pp2",70);
        JSONObject requestBody= TestDataJsonPlaceHolder.responseJsonBodyOlustur(10,70,"Ahmet","Merhaba");
        JSONObject expectedData=TestDataJsonPlaceHolder.responseJsonBodyOlustur(10,70,"Ahmet","Merhaba");
        Response response=given().spec(specJsonPlaceHolder).contentType(ContentType.JSON)
        .when().body(requestBody.toString()).put("{pp1}/{pp2}");
        //response.prettyPrint();

        JsonPath responseJsonPath=response.jsonPath();

        assertEquals(TestDataJsonPlaceHolder.basariliSorguStatusCode,response.statusCode());
        assertEquals(TestDataJsonPlaceHolder.contentType,response.contentType());
        assertEquals(TestDataJsonPlaceHolder.headerConnection,response.header("connection"));
        assertEquals(expectedData.get("userId"),responseJsonPath.get("userId"));
        assertEquals(expectedData.get("id"),responseJsonPath.get("id"));
        assertEquals(expectedData.get("title"),responseJsonPath.get("title"));
        assertEquals(expectedData.get("body"),responseJsonPath.get("body"));





    }

}

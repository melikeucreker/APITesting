package tests;

import TestDatas.TestDataJsonPlaceHolder;
import baseUrl.BaseUrlJsonPlaceHolder;
import com.beust.ah.A;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C23_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceHolder {
    @Test
    public void test01(){
        //1-end point ve request body olustur
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","22");
        //2-expected data olustur
        JSONObject expectedData= TestDataJsonPlaceHolder.responseBodyOlustur22();
      //  System.out.println(expectedData);


        //3-Request gonder response ı kaydet
        Response response=given().spec(specJsonPlaceHolder).when().get("/{pp1}/{pp2}");
        //response.prettyPrint();

        JsonPath responseJsonPath=response.jsonPath();

        //4-assertion
        Assert.assertEquals(TestDataJsonPlaceHolder.basariliSorguStatusCode,response.statusCode());
        Assert.assertEquals(expectedData.getInt("userId"),responseJsonPath.getInt("userId"));
        Assert.assertEquals(expectedData.getInt("id"),responseJsonPath.getInt("id"));
        Assert.assertEquals(expectedData.get("title"),responseJsonPath.get("title"));
        Assert.assertEquals(expectedData.get("body"),responseJsonPath.get("body"));






    }
}

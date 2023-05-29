package tests;

import TestDatas.TestDataJsonDummyExample;
import baseUrl.BaseUrlDummyExample;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C26_Get_TestDataKullanimi extends BaseUrlDummyExample {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request gonderdigimizde
donen response’un status code’unun 200, content Type’inin application/json ve body’sinin
asagidaki gibi oldugunu test edin.
Response Body
{
"status": "success",
"data": {
"id": 3,
"employee_name": "Ashton Cox",
"employee_salary": 86000,
"employee_age": 66,
"profile_image": ""
},
"message": "Successfully!
     */
    @Test
    public void test01(){
        //1-end point ve request body hazırla
        specDummyExample.pathParams("pp1","api","pp2","v1","pp3","employee","pp4","3");
        //2-expectedData olustur
        JSONObject expectedData= TestDataJsonDummyExample.jsonResponseBodyOlustur(3,"Ashton Cox",
                86000,66,"");
        //System.out.println(expectedData);
        //3)request gönderip response'ı kaydet
        Response response=given().spec(specDummyExample).when().get("{pp1}/{pp2}/{pp3}/{pp4}");
        response.prettyPrint();
        //assertion
        JsonPath responseJsonPath=response.jsonPath();
       assertEquals(TestDataJsonDummyExample.basariliSorguStatusCode,response.statusCode());
        assertEquals(TestDataJsonDummyExample.contentType,response.contentType());
        assertEquals(expectedData.getJSONObject("data").getString("profile_image")
                ,responseJsonPath.getString("data.profile_image"));
        assertEquals(expectedData.getJSONObject("data").getString("employee_name"),
                responseJsonPath.getString("data.employee_name"));
        assertEquals(expectedData.getJSONObject("data").getInt("employee_salary")
                ,responseJsonPath.getInt("data.employee_salary"));
        assertEquals(expectedData.getJSONObject("data").getInt("id")
                ,responseJsonPath.getInt("data.id"));
        assertEquals(expectedData.getJSONObject("data").getString("employee_age")
                ,responseJsonPath.getString("data.employee_age"));
        assertEquals(expectedData.get("message"),responseJsonPath.get("message"));
        //message a hemen ulasabildigimiz icin bir daha getJsonObject dememize gerek yok.
        assertEquals(expectedData.get("status"),responseJsonPath.get("status"));










    }
}

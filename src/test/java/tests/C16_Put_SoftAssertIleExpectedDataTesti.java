package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C16_Put_SoftAssertIleExpectedDataTesti {
    @Test
    public void test01(){
        /*
        http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT
request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
Request Body
{
"status": "success",
"data": {
"name": “Ahmet",
"salary": "1230",
"age": "44",
"id": 40
}
}
Response Body
{ "status": "success",
"data": {
"status": "success",
"data": {
"name": “Ahmet",
"salary": "1230",
"age": "44",
"id": 40 }
},
"message": "Successfully! Record has been updated."}
         */
        //1-end point ve request body olustur.
        String url="http://dummy.restapiexample.com/api/v1/update/21";
        JSONObject requestBody=new JSONObject();
        JSONObject dataBilgileri=new JSONObject();
        dataBilgileri.put("name","Ahmet");
        dataBilgileri.put("salary","1230");
        dataBilgileri.put("age","44");
        dataBilgileri.put("id",40);
        requestBody.put("status","success");
        requestBody.put("data",dataBilgileri);

        //2-expected data olustur.
        JSONObject expectedData=new JSONObject();
        expectedData.put("status","success");
        expectedData.put("data",requestBody);
        expectedData.put("message","Successfully! Record has been updated.");

        //3-request gonder,response'ı kaydet


        Response response=given().contentType(ContentType.JSON).when().body(requestBody.toString()).put(url);

        //4-Assertions
        JsonPath responseJsonPath= response.jsonPath();

        SoftAssert softAssert=new SoftAssert();


        assertEquals(responseJsonPath.getJsonObject("status"),expectedData.get("status"));
        assertEquals(responseJsonPath.get("message"),expectedData.get("message"));
        assertEquals(responseJsonPath.get("data.status"),expectedData.getJSONObject("data").get("status"));
        assertEquals(responseJsonPath.get("data.data.name"),expectedData.getJSONObject("data")
                .getJSONObject("data").get("name"));
        assertEquals(responseJsonPath.get("data.data.id"),expectedData
                .getJSONObject("data").getJSONObject("data").get("id"));
        assertEquals(responseJsonPath.get("data.data.salary"),expectedData.
                getJSONObject("data").getJSONObject("data").get("salary"));
        assertEquals(responseJsonPath.get("data.data.age"),expectedData
                .getJSONObject("data").getJSONObject("data").get("age"));

        softAssert.assertAll();








    }

}

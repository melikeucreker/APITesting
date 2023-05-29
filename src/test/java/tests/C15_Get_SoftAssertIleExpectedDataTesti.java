package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C15_Get_SoftAssertIleExpectedDataTesti {
    @Test
    public void test01(){
        /*
        http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
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
"message": "Successfully! Record has been fetched."
}
         */
        //1-end point ve request body olustur

        String url=" http://dummy.restapiexample.com/api/v1/employee/3";
        //2-expected data olustur.

        JSONObject expectedData= new JSONObject();
        JSONObject dataBilgileriJsonObj=new JSONObject();
        dataBilgileriJsonObj.put("id",3);
        dataBilgileriJsonObj.put("employee_name","Ashton Cox");
        dataBilgileriJsonObj.put("employee_salary",86000);
        dataBilgileriJsonObj.put("employee_age",66);
        dataBilgileriJsonObj.put("profile_image","");
        expectedData.put("status","success");
        expectedData.put("data",dataBilgileriJsonObj);
        expectedData.put("message","Successfully! Record has been fetched.");

        //System.out.println(expectedData.toString());
        //3-request gönder,response'ı kaydet
        Response response=given().when().get(url);

        //4-Assertion

        //öncelikle response üzerindeki bilgileri kolay almak icin JsonPath'e cast edelim.

        JsonPath responseJsonPath=response.jsonPath();
        //Assertionları soft assert ile yapalım.

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertAll(); //bu olmazsa gerçekten assertion yapılmış olmaz gerçek bir raporlama olmaz

        assertEquals(responseJsonPath.get("status"),
                expectedData.get("status")
                );

        assertEquals(responseJsonPath.get("data.id"),expectedData.getJSONObject("data").get("id")
                );
        assertEquals(responseJsonPath.get("data.employee_name"),expectedData.getJSONObject("data").get("employee_name"));
        assertEquals(responseJsonPath.get("data.employee_salary"),expectedData.getJSONObject("data").get("employee_salary"));
        assertEquals(responseJsonPath.get("data.employee_age"),expectedData.getJSONObject("data").get("employee_age"));
        assertEquals(responseJsonPath.get("data.profile_image"),expectedData.getJSONObject("data").get("profile_image"));
        assertEquals(responseJsonPath.get("message"),expectedData.get("message"));











    }
}

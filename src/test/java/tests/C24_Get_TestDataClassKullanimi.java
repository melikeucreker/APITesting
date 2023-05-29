package tests;

import TestDatas.TestDataJsonPlaceHolder;
import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C24_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceHolder {
    /*
    https://jsonplaceholder.typicode.com/posts/10 url'ine bir GET request yolladigimizda donen
response’in status kodunun 200 ve response body’sinin asagida verilen ile ayni oldugunutest
ediniz
Response body :
{
"userId": 4,
"id": 40,
"title": "enim quo cumque",
"body": "ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia
quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam"
}
     */
    @Test
    public void test01(){
        //1-end point ve request body hazırla
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","10");
        //2-expected data olustur
        JSONObject expectedData= TestDataJsonPlaceHolder.responseJsonBodyOlustur(1,10,"optio molestias id quia eum",
                "quo et expedita modi cum officia vel magni\ndoloribus qui repudiandae\nvero nisi sit\nquos veniam quod sed accusamus veritatis error");
        //3-Request gönder ve response ı kaydet
        Response response=given().spec(specJsonPlaceHolder).when().get("{pp1}/{pp2}");

        // response.prettyPrint();
        JsonPath responseJsonPath=response.jsonPath();
        //4_assertion
        assertEquals(TestDataJsonPlaceHolder.basariliSorguStatusCode,response.statusCode());
        assertEquals(expectedData.get("userId"),responseJsonPath.get("userId"));
        assertEquals(expectedData.getInt("id"),responseJsonPath.getInt("id"));
        assertEquals(expectedData.get("title"),responseJsonPath.get("title"));
        assertEquals(expectedData.get("body"),responseJsonPath.get("body"));






    }
}

package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class C13_Get_ExpectedDataOlusturma {
    @Test
    public void test01(){
        /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunutest ediniz
Response body :
{
"userId": 3,
"id": 22,
"title": "dolor sint quo a velit explicabo quia nam",
"body": "eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita earum mollitia molestiae aut atque rem suscipitnam impedit esse"
}
JUnit ASSERT
JsonPath
         */
        //1-endpoint ve request body hazırla
        String url="https://jsonplaceholder.typicode.com/posts/22";
        //2-expected data olustur
        JSONObject expectedData =new JSONObject();
        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.
                put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");
        //3-request gönder ve dönen response ı kaydet
        Response response=given().when().get(url);
        //response.prettyPrint();
        //4-Assertion
        /* buraya kadar yaptığımız yöntemle de testlerimizi yapabiliriz ancak,Framework'umuzu gelistirmelyiz.
        response.then().assertThat().body("userId",equalTo(3),"id",equalTo(22),

                "title",equalTo("dolor sint quo a velit explicabo quia nam"),
                "body", "eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita earum mollitia \n" +
                        "molestiae aut atque rem suscipitnam impedit esse");

                 */

        JsonPath responseJsonPath=response.jsonPath();
        Assert.assertEquals(expectedData.get("id"),responseJsonPath.get("id"));
        Assert.assertEquals(expectedData.get("title"),responseJsonPath.get("title"));
        Assert.assertEquals(expectedData.get("body"),responseJsonPath.get("body"));
        Assert.assertEquals(expectedData.get("userId"),responseJsonPath.get("userId"));

    }
}

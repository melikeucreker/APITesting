package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class C17_BaseUrlDummyRestapi extends BaseUrlJsonPlaceHolder {
    @Test
    public void test01(){
        //1-end point ve request body olustur.

        specJsonPlaceHolder.pathParam("pp1","posts");
        //2-expected data olustur
        //3-request gönded ve response ı kaydet
        Response response=given().when().spec(specJsonPlaceHolder).get("/{pp1}");

        //4-assertion
        response.then().assertThat().statusCode(200).body("title", Matchers.hasSize(100));




        /*
        Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request gonderdigimizde
donen response’un status code’unun 200 oldugunu ve Response’ta 100 kayit oldugunu test
edin
2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request gonderdigimizde
donen response’un status code’unun 200 oldugunu ve “title” degerinin
“optio dolor molestias sit” oldugunu test edin
3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve response body’sinin
null oldugunu test edin
         */

    }
    @Test
    public void test02(){
        /*
        2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request gonderdigimizde
donen response’un status code’unun 200 oldugunu ve “title” degerinin
“optio dolor molestias sit” oldugunu test edin
         */
        specJsonPlaceHolder.pathParams("pp1","posts","pp2",44);
        Response response=given().when().spec(specJsonPlaceHolder).get("/{pp1}/{pp2}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).body("title",Matchers.equalTo("optio dolor molestias sit"));

    }
}

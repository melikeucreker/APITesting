package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_Put_ResponseBilgileriAssertion {
    @Test
    public void test01(){
        /*
        https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki Json formatindaki body ile bir
      PUT request gonderdigimizde
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
donen Response’un,
status code’unun 200,
ve content type’inin application/json; charset=utf-8,
ve Server isimli Header’in degerinin cloudflare,
ve status Line’in HTTP/1.1 200 OK
         */

        //1-end point ve request body hazırla

        String url=" https://jsonplaceholder.typicode.com/posts/70";

        JSONObject requestbody=new JSONObject();
        requestbody.put("title","Ahmet");
        requestbody.put("body","Merhaba");
        requestbody.put("userId",10);
        requestbody.put("id",70);
        //2-expected body olustur

        //3-request gönder ve dönen response'ı kaydet

        Response response=given()
                .contentType(ContentType.JSON)// bizim gönderdigimiz bodynin json tipinde oldugunu söylememiz lazım.
                .when()
                .body(requestbody.toString())//requestbody json objesiyfi biz burda onu stringecevirdik.
                .put(url); //hangi http methouyla islm yapıyorsk onu yazıcaz.
       // response.prettyPrint();normalde yazdırılmaz ama calısırken kodumuzun calisip calismadigini test etmek
        //icin bakabiliriz.

        //4.Assertion
        response
                .then()
                .assertThat().statusCode(200).contentType(" application/json; charset=utf-8")
                .header("Server","cloudflare").statusLine("HTTP/1.1 200 OK");










    }
}

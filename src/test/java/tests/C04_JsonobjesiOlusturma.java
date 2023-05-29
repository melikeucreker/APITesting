package tests;

import org.json.JSONObject;
import org.junit.Test;

public class C04_JsonobjesiOlusturma {
    @Test
    public void test01(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("title","Ahmet");
        jsonObject.put("body","Merhaba");
        jsonObject.put("userid",1);
        System.out.println(jsonObject);
        /*
         {
         "title":"Ahmet",
         "body":"Merhaba",
         "userid":1
         }
          */

    }
}

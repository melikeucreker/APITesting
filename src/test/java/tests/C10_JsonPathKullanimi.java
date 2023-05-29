package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonPathKullanimi {
    @Test
 public void test01 (){
        JSONObject kisiBilgileriJsonObj=new JSONObject();
        JSONObject adresBilgileriJsonObj=new JSONObject();
        JSONArray telefonBilgileriARR=new JSONArray();

        JSONObject cepTelefonObj=new JSONObject();
        JSONObject evTelefonuObj=new JSONObject();

        adresBilgileriJsonObj.put("streetAddress","naist street");
        adresBilgileriJsonObj.put("city","Nara");
        adresBilgileriJsonObj.put("postalcode","630_0912");

        cepTelefonObj.put("type","iphone");
        cepTelefonObj.put("number","0123-4567-8888");
        evTelefonuObj.put("type","home");
        evTelefonuObj.put("number","0123-4567-8910");

        telefonBilgileriARR.put(cepTelefonObj);
        telefonBilgileriARR.put(evTelefonuObj);

        kisiBilgileriJsonObj.put("firstname","John");
        kisiBilgileriJsonObj.put("lastname","Doe");
        kisiBilgileriJsonObj.put("age",26);
        kisiBilgileriJsonObj.put("adress",adresBilgileriJsonObj);
        kisiBilgileriJsonObj.put("phoneNumbers",telefonBilgileriARR);
        System.out.println(kisiBilgileriJsonObj);
        /*
        {"firstname":"John","adress":
        {"streetAddress":"naist street","city":"Nara","postalcode":"630_0912"},
        "age":26,"phoneNumbers":[{"number":"0123-4567-8888","type":"iphone"},{"number":"0123-4567-8910","type":"home"}],
        "lastname":"doe"}


         */



    }
}

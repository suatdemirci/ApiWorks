package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testDataKlasoru.TestDataJsonPlace;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C18_Get_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {
    /*
  https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET
  request yolladigimizda donen response’in status kodunun 200 ve
  response body’sinin asagida verilen ile ayni oldugunu test ediniz
   Response body = Expected Body
    {
    "userId":3,
    "id":22,
    "title":"dolor sint quo a velit explicabo quia nam",
    "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
    um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
     */

    @Test
    public void get01(){

        //1-Url hazirla
        specJsonPlaceHolder.pathParams( "pp1","posts","pp2",22 );

        //2-Expected Data hazirla

        TestDataJsonPlace testDataJsonPlace=new TestDataJsonPlace();
        JSONObject expData=testDataJsonPlace.expectedBodyOlusturJSON();

        //3-response kaydet

        Response response=given().spec( specJsonPlaceHolder ).when().get( "/{pp1}/{pp2}" );

        //4-Assertion


        JsonPath respJP=response.jsonPath();


        assertEquals( testDataJsonPlace.succededStatusCode,response.getStatusCode() );
        assertEquals(expData.get( "userId" ),respJP.get("userId")  );
        assertEquals(expData.get("id"),respJP.get("id") );
        assertEquals(expData.get( "title" ),respJP.get("title")  );
        assertEquals(expData.get( "body" ),respJP.get("body")  );







    }
}

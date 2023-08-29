package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testDataKlasoru.TestDataJsonPlace;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C19_Put_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {

    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT
    request yolladigimizda donen response’in
    status kodunun 200, content type’inin “application/json; charset=utf-8”,
    Connection header degerinin “keep-alive”
    ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
        {
        "title":"Ali",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Expected Data
        {
        "title":"Ali",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
  */

    @Test
    public void put01(){
        //1-URL ve request body hazirla
        specJsonPlaceHolder.pathParams( "pp1","posts","pp2",70 );

        TestDataJsonPlace testDataJsonPlace=new TestDataJsonPlace();
        JSONObject reqBody=testDataJsonPlace.requestBodyOlusturJSON();

        //2-Expected body olustur
        JSONObject expData=testDataJsonPlace.requestBodyOlusturJSON();

        //3-Response kaydet

        Response response=given().spec( specJsonPlaceHolder )
                .contentType( ContentType.JSON )
                .body( reqBody.toString() )
                .when().put("/{pp1}/{pp2}");

        //4-Assertion

        JsonPath respJP=response.jsonPath();

        assertEquals(testDataJsonPlace.succededStatusCode, response.getStatusCode());
        assertEquals( testDataJsonPlace.contentType,response.getContentType() );
        assertEquals( testDataJsonPlace.connectionHeader,response.getHeader( "Connection" ) );

        assertEquals(expData.get( "title" ),respJP.get("title")  );
        assertEquals(expData.get("body"),respJP.get("body") );
        assertEquals(expData.get( "userId" ),respJP.get("userId")  );
        assertEquals(expData.get( "id" ),respJP.get("id")  );






    }
}

package test;

import baseUrl.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C14_Put_SoftAssertIleExpectedDataTesti extends DummyRestApiBaseUrl {

    /*
    https://dummy.restapiexample.com/api/v1/update/21 url'ine asagidaki
    body'ye sahip bir PUT request gonderdigimizde donen response'un asagidaki gibi
    oldugunu test edin.

     Request Body                         Response Body
     {                                   {  "status":"success",
       "status":"success",                  "data": {
       "data":{                                     "status":"success",
          "name" : "Ahmet",                          "data":{
          "salary":"1230",                               "name":"Ahmet"
          "age":"44",                                    "salary":1230
          "id":40                                        "age":"44"
           }                                              "id":40}
       }                                              }
                                               "message":"Successfully!Record
                                               has been updated."}
     */

    @Test
    public void put01(){
        //1-Url ve request body hazirla
        String url="https://dummy.restapiexample.com/api/v1/update/21";

        JSONObject data=new JSONObject();
        data.put( "name" , "Ahmet" );
        data.put( "salary" , "1230" );
        data.put( "age" , "44" );
        data.put( "id" , "40" );

        JSONObject reqBody=new JSONObject();
        reqBody.put("status","success"  );
        reqBody.put( "data",data );

        //2-Expected Body olustur

        JSONObject expData=new JSONObject();

        expData.put( "status","success" );
        expData.put( "data",reqBody );
        expData.put( "message","Successfully! Record has been updated." );

        //3-Response kaydet

        Response response=given().contentType( ContentType.JSON ).when().body( reqBody.toString() ).put(url);

        //4- Assertion

        JsonPath respJP=response.jsonPath();

        SoftAssert softAssert=new SoftAssert();

        //assertEquals( expData.get( "status" ),respJP.get("status"));

        //assertEquals(expData.getJSONObject("data").get( "status" ),respJP.get("data.status"));
        //assertEquals(expData.getJSONObject("data").getJSONObject( "data" ).get( "name" ),respJP.get("data.data.name"));
        //assertEquals(expData.getJSONObject("data").getJSONObject( "data" ).get( "salary" ),respJP.get("data.data.salary"));
        //assertEquals(expData.getJSONObject("data").getJSONObject( "data" ).get( "age" ),respJP.get("data.data.age"));
        //assertEquals(expData.getJSONObject("data").getJSONObject( "data" ).get( "id" ),respJP.get("data.data.id"));
        //assertEquals( expData.get( "message" ),respJP.get( "message" ) );

        softAssert.assertEquals( respJP.get("status"),expData.get( "status" ) );
        softAssert.assertEquals(respJP.get("data.status"), expData.getJSONObject("data").get( "status" ) );
        softAssert.assertEquals(respJP.get("data.data.name"),expData.getJSONObject("data").getJSONObject( "data" ).get( "name" ));
        softAssert.assertEquals(respJP.get("data.data.salary"),expData.getJSONObject("data").getJSONObject( "data" ).get( "salary" ));
        softAssert.assertEquals(respJP.get("data.data.age"),expData.getJSONObject("data").getJSONObject( "data" ).get( "age" ));
        softAssert.assertEquals(respJP.get("data.data.id"),expData.getJSONObject("data").getJSONObject( "data" ).get( "id" ));
        softAssert.assertEquals( respJP.get( "message" ),expData.get( "message" ) );

        softAssert.assertAll();








    }
}

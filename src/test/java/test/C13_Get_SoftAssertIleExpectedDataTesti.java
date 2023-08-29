package test;

import baseUrl.DummyRestApiBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C13_Get_SoftAssertIleExpectedDataTesti extends DummyRestApiBaseUrl {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Response Body
        {
        "status":"success",
        "data":{
                "id":3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
        }
     */

    @Test
    public void get01(){
        //1-Url hazirla
        String url="http://dummy.restapiexample.com/api/v1/employee/3";

        //2-Expected Data hazirla

        JSONObject data=new JSONObject();
        data.put( "id",3 );
        data.put( "employee_name","Ashton Cox" );
        data.put( "employee_salary",86000 );
        data.put( "employee_age",66 );
        data.put( "profile_image","" );


        JSONObject expData=new JSONObject();
        expData.put( "status","success" );
        expData.put( "data",data );
        expData.put("message","Successfully! Record has been fetched."  );

        //3-Response kaydet

        Response response=given().when().get( url );

        //4-Assert
         JsonPath jsonPath=response.jsonPath();


        // assertEquals( expData.get( "status" ),jsonPath.get("status") );
        // assertEquals( expData.getJSONObject( "data" ).get("id"),jsonPath.get("data.id") );
        // assertEquals( expData.getJSONObject( "data" ).get("employee_name"),jsonPath.get("data.employee_name") );
        // assertEquals( expData.getJSONObject( "data" ).get("employee_salary"),jsonPath.get("data.employee_salary") );
        // assertEquals( expData.getJSONObject( "data" ).get("employee_age"),jsonPath.get("data.employee_age") );
        // assertEquals( expData.getJSONObject( "data" ).get("profile_image"),jsonPath.get("data.profile_image") );
        // assertEquals( expData.get("message"),jsonPath.get("message") );
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals( jsonPath.get("status"),expData.get( "status" ));
        softAssert.assertEquals( jsonPath.get("data.id"),expData.getJSONObject( "data" ).get("id"));
        softAssert.assertEquals( jsonPath.get("data.employee_name"),expData.getJSONObject( "data" ).get("employee_name"));
        softAssert.assertEquals( jsonPath.get("data.employee_salary") ,expData.getJSONObject( "data" ).get("employee_salary"));
        softAssert.assertEquals( jsonPath.get("data.employee_age"),expData.getJSONObject( "data" ).get("employee_age"));
        softAssert.assertEquals( jsonPath.get("data.profile_image"),expData.getJSONObject( "data" ).get("profile_image"));
        softAssert.assertEquals( jsonPath.get("message"),expData.get("message"));


        softAssert.assertAll();




    }
}

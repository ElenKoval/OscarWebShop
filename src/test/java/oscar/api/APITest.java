package oscar.api;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class APITest {

    //Ru2oMUmc5qxSidMuiUrWJcFfZ74LVVR2PZScJlOEl52rfA7bW3qAfUJtoRkTtM8x
    //
    @Test
    public void PositiveTest(){
        RequestSpecification requestSpecification=io.restassured.RestAssured.given();

        Response response = requestSpecification
                .given().body("{\n" +
                        "    \"username\": \"cyprus@gmail.com\",\n" +
                        "    \"password\": \"Draft123456!\"\n" +
                        "}")
                .when().post("http://selenium1py.pythonanywhere.com/en-gb/accounts/login/");
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
    }
}

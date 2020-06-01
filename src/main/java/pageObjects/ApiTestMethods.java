package pageObjects;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import utilities.Log;


public class ApiTestMethods {

    public int status() throws Exception {

        RequestSpecification request = RestAssured.given();

        Response response = request.get("http://generator.swagger.io/api/swagger.json");
        return response.getStatusCode();

    }
}

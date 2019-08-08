package RestAssured;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class GetRequest {

	//this is get request
	public static String url = "https://t8d0j8mnug.execute-api.us-east-1.amazonaws.com/V1/employee/";
	public static String appId = "cloudAPI-1294609943";
	public static String merchantId = "d74c2645-2529-462b-80e6-f61bc2b467d0";
	
	public static RequestSpecification request;
	public static Response response;
	
	public static GetToken gat = new GetToken ();
	public static String Token = GetToken.POST_GetAccessToken();
	
	@BeforeClass
	public static void start()
	{
		RestAssured.baseURI = url;
		request = RestAssured.given();
		request.header("Authorization", Token);
	}
	
	@Test
	public void GET_EmployeeList()
	{
		response = request.get("?appId=" + appId + "&merchantId=" + merchantId);		
		System.out.println(response.getBody().asString());
		
		JsonPath jp = response.jsonPath();
		String ExpectedLocationAddress = "test,Haifa,1234,North,IL";
		String ActualLocationAddress = jp.get("data.employees[0].locationAddress");
		
	    assertEquals(ActualLocationAddress, ExpectedLocationAddress);
		
	}

}

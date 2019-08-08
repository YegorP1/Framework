package RestAssured;

import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class GetToken {
	public static String getTokenUrl = "https://qa.account.verifonecp.com/oauth2/token";

	public static String scope = "openid";
	public static String grant_type = "password";
	public static String username = "t4891@getnada.com";
	public static String password = "Veri1234";
	
	public static RequestSpecification request;
	public static Response response;
	
	public static String POST_GetAccessToken()
	{

		RestAssured.baseURI = getTokenUrl;
		request = RestAssured.given();
		request.header("Authorization","Basic SThKMmVJTEpqQnIxUGxZTDU1NW5JOXdDMFIwYTpNNWs0YXBxbDdwem9QUjdIVVRmMk0zUTZJREFh");
		request.header("Content-Type","application/x-www-form-urlencoded");
		
		
		response = request.post("?scope="+ scope + "&grant_type=" + grant_type + "&username=" + username +"&password="+password);
		
		System.out.println(response.getBody().asString());
		
		JsonPath jp = response.jsonPath();
		
		String AccessToken = jp.get("access_token");
		
		return AccessToken;		 
	}


}





package Informatorio.testing;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestAssuredTest {

	@BeforeMethod
	public void setUP() {
		RestAssured.baseURI= "http://localhost";
		RestAssured.port =3000;
		RestAssured.basePath = "/api/product";
	}
	@Test(enabled=true)
	public void getByIdUsingPathParam() {
		Response response = RestAssured.given().log().all()
		 			.pathParam("productId", "1").get("/{productId}");
		response.prettyPrint();
		assertEquals(response.getStatusCode(), 200);
		JsonPath json = response.jsonPath();		
		assertEquals(json.getInt("id"),1);		
		assertEquals(json.getString("nombre"),"monitor");	
		assertEquals(json.getInt("cantidad"),12);		
	

			
		
		
		
		}
/*	@Test(enabled=false)
	public void GetFirst() {
		Response response = RestAssured.get("/1");
		response.prettyPrint();
	}
	@Test(enabled=false)
	public void AddProduct() {
		Product product = new Product(666,"Objetulio",3);
		Response response = RestAssured.given().log().all().contentType(ContentType.JSON).body(product).post();
		response.prettyPrint();
		assertEquals(response.statusCode(), 200);
		JsonPath json = response.jsonPath();
		assertFalse(json.getList("products").isEmpty(),"La lista de productos esta vacia gato");
		
		assertEquals(json.getInt("products[0].id"),1);
		assertEquals(json.getString("products[0].nombre"),"monitor");
		assertEquals(json.getInt("products[0].cantidad"),12);		
		}
	
	*/
}

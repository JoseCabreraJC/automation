package Informatorio.testing;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class InsumoTest {
	
		private Insumo insumo = new Insumo(	8,"PostIt",50);
		
		@BeforeMethod
		public void setUp(){
			RestAssured.baseURI = "http://localhost";
			RestAssured.port = 3000;
			RestAssured.basePath = "/api/insumo";
		}
		@Test(enabled=false)
		public void getAll() {
			Response response = RestAssured.given().log().all().get();
			response.prettyPrint();	
		
			assertEquals(response.getStatusCode(),200);
			JsonPath json = response.jsonPath();
			assertFalse(json.getList("insumos").isEmpty(),"Lista de insumo vacias");
			assertEquals(json.getInt("insumos[1].id"),2);
			assertEquals(json.getString("insumos[1].nombre"),"papel A4");
			assertEquals(json.getInt("insumos[1].cantidad"),5);
			
		}
		
		@Test(enabled=false)
		public void getByIdUsingPathParam() {
			Response response = RestAssured.given().log().all()
					.pathParam("insumoId", 2).get("/{insumoId}");
			response.prettyPrint();
			assertEquals(response.getStatusCode(),200);
			JsonPath json = response.jsonPath();
			
			assertEquals(json.getInt("id"),2);
			assertEquals(json.getString("nombre"),"papel A4");
			assertEquals(json.getInt("cantidad"),5);
		}
		@Test(enabled=true)
		public void addInsumo() {
			Response response = RestAssured.given().log().all().
								contentType(ContentType.JSON).body(insumo).post();
			response.prettyPrint();
			assertEquals(response.getStatusCode(),201);
			JsonPath json = response.jsonPath();
			
			assertEquals(json.getString("mensaje"),"El insumo se ha agregado");
		}
		
		
		@Test(dependsOnMethods="addInsumo")
		public void getByIdUsingQueryParam() {
			Response response = RestAssured.given().log().all()
					.queryParam("insumoId",insumo.getId()).get();
			response.prettyPrint();
			assertEquals(response.statusCode(),200);
			JsonPath json = response.jsonPath();
			
			assertEquals(json.getInt("insumos[2].id"),insumo.getId());
			assertEquals(json.getString("insumos[2].nombre"),insumo.getNombre());
			assertEquals(json.getInt("insumos[2].cantidad"),insumo.getCantidad());
	}
		
		@Test(dependsOnMethods = "getByIdUsingQueryParam")
		public void deleteInsumo() {
			Response response = RestAssured.given().log().all()
					.pathParam("id",insumo.getId()).delete("/{id}");
			response.prettyPrint();
			assertEquals(response.statusCode(),200);
			JsonPath json = response.jsonPath();
			assertEquals(json.getString("message"),"El insumo ha sido eliminado exitosamente.");
		}
	



}



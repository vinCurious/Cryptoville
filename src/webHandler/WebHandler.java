package webHandler;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Machine.Machine;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Set;

import webHandler.WebHandlerConfig;

public class WebHandler {

	public WebHandler() {

	}

	@SuppressWarnings("unchecked")
	@GET
	@Path(WebHandlerConfig.URL_METHOD_GET_ALL_FARMERS_FOR_PRODUCT)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray findAllFarmersForProduct(int productID) {
		JSONArray farmerDetailsArray = new JSONArray();
		try {
			Class.forName("org.sqlite.JDBC");

			Connection c = DriverManager.getConnection("jdbc:sqlite:cryptoville.db");
			Statement stmt = c.createStatement();

			String sql = "SELECT T.farmerID, F.NAME, F.STREET, F.CITY, F.STATE, F.ZIPCODE, T.productPrice FROM Transactions as T INNER JOIN Farmer as F ON T.farmerID=F.ID where T.productID="
					+ productID + ";";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int farmerID = rs.getInt("farmerID");
				String name = rs.getString("NAME");
				String street = rs.getString("STREET");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				String zipCode = rs.getString("ZIPCODE");
				double price = rs.getDouble("productPrice");

				System.out.println(
						farmerID + ":" + name + ":" + street + ":" + city + ":" + state + ":" + zipCode + ":" + price);

				JSONObject currentFarmer = new JSONObject();
				currentFarmer.put("id", farmerID);
				currentFarmer.put("name", name);
				currentFarmer.put("street", street);
				currentFarmer.put("city", city);
				currentFarmer.put("state", state);
				currentFarmer.put("zipCode", zipCode);
				currentFarmer.put("price", price);

				farmerDetailsArray.add(currentFarmer);
			}
			rs.close();
			c.close();
			System.out.println("JSONArray:" + farmerDetailsArray);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return farmerDetailsArray;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path(WebHandlerConfig.URL_METHOD_GET_PRODUCT_DETAILS)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject findProductDetails(String productName) {
		JSONObject productDetails = new JSONObject();

		try {
			Class.forName("org.sqlite.JDBC");

			Connection c = DriverManager.getConnection("jdbc:sqlite:cryptoville.db");
			Statement stmt = c.createStatement();

			String sql = "SELECT DISTINCT count(T.farmerID) FROM Transactions as T where T.productID="
					+ Machine.productListReverse.get(productName) + ";";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				int count = rs.getInt("count(T.farmerID)");
				double price = Machine.productValues.get(Machine.productListReverse.get(productName));

				System.out.println(productName + ":" + price + ":" + count);
				productDetails.put("name", productName);
				productDetails.put("price", price);
				productDetails.put("farmerCount", count);
			}
			rs.close();
			c.close();
			System.out.println("JSONObject:" + productDetails);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productDetails;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path(WebHandlerConfig.URL_METHOD_GET_FARMER_DETAILS)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject findFarmerDetails(int farmerID) {
		JSONObject farmerDetails = new JSONObject();
		try {
			Class.forName("org.sqlite.JDBC");

			Connection c = DriverManager.getConnection("jdbc:sqlite:cryptoville.db");
			Statement stmt = c.createStatement();

			String sql = "SELECT F.ID, F.NAME, F.STREET, F.CITY, F.STATE, F.ZIPCODE FROM Farmer as F  where F.ID="
					+ farmerID + ";";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String street = rs.getString("STREET");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				String zipCode = rs.getString("ZIPCODE");
				int count = Machine.farmerProducts.get(id).size();

				System.out.println(
						id + ":" + name + ":" + street + ":" + city + ":" + state + ":" + zipCode + ":" + count);

				farmerDetails.put("id", id);
				farmerDetails.put("name", name);
				farmerDetails.put("street", street);
				farmerDetails.put("city", city);
				farmerDetails.put("state", state);
				farmerDetails.put("zipCode", zipCode);
				farmerDetails.put("produceCount", count);

			}
			rs.close();
			c.close();
			System.out.println("JSONObject:" + farmerDetails);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * ```GET /farmer/{id}: { id: <STRING>, name: <STRING>, location:
		 * <STRING>, produceCount: <INT> }
		 */
		return farmerDetails;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path(WebHandlerConfig.URL_METHOD_GET_PRODUCT_FARMER_DETAILS)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray findProductFarmerDetails(int farmerID) {
		JSONArray productFarmerArray = new JSONArray();
		try {
			Class.forName("org.sqlite.JDBC");

			Connection c = DriverManager.getConnection("jdbc:sqlite:cryptoville.db");
			Statement stmt = c.createStatement();

			Set<Integer> productIDs = Machine.farmerProducts.get(farmerID);

			for (Integer i : productIDs) {

				String productName = Machine.productList.get(i);
				double productPrice = Machine.productValues.get(i);

				Class.forName("org.sqlite.JDBC");

				String sql = "SELECT DISTINCT count(T.farmerID) FROM Transactions as T where T.productID=" + i + ";";

				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					JSONObject productFarmerDetails = new JSONObject();

					int count = rs.getInt("count(T.farmerID)");

					System.out.println(productName + ":" + productPrice + ":" + count);
					productFarmerDetails.put("name", productName);
					productFarmerDetails.put("price", productPrice);
					productFarmerDetails.put("farmerCount", count);

					productFarmerArray.add(productFarmerDetails);
				}
				rs.close();
			}
			c.close();
			System.out.println("JSONArray:" + productFarmerArray);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * ```GET /farmer/produces/{id}: [ { name: <STRING>, price: <INT>,
		 * farmerCount: <INT> } ]```
		 */

		return productFarmerArray;
	}

	public static void main(String args[]) {
		WebHandler wb = new WebHandler();
		wb.findProductFarmerDetails(2);
	}

}
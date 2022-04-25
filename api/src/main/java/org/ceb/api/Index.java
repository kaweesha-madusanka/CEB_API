package org.ceb.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import services.UserService;


@Path("user")
public class Index {
	UserService user = new UserService();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readUsers() {
		return user.readUsers();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertUser(
			@FormParam("uid") String uid,
			@FormParam("name") String name, 
			@FormParam("nic") String nic,
			@FormParam("address") String address, 
			@FormParam("mobile") String mobile, 
			@FormParam("email") String email, 
			@FormParam("ebill") String ebill, 
			@FormParam("created_at") String created_at){
				String output = user.insertUser(uid, name, nic, address, mobile, email, ebill, created_at);
				return output;
				}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateUser(String userData) {
		// Convert the input string to a JSON object
		JsonObject customerObject = new JsonParser().parse(userData).getAsJsonObject();
		// Read the values from the JSON object
		String uid = customerObject.get("uid").getAsString();
		String name = customerObject.get("name").getAsString();
		String nic = customerObject.get("nic").getAsString();
		String address = customerObject.get("address").getAsString();
		String mobile = customerObject.get("mobile").getAsString();
		String email = customerObject.get("email").getAsString();
		String ebill = customerObject.get("ebill").getAsString();
		String created_at = customerObject.get("created_at").getAsString();
		
		String output = user.updateUser(uid, name, nic, address, mobile, email, ebill, created_at);
		return output;
	}
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCustomer(String userData) {
		// Convert the input string to a JSON object
				JsonObject customerObject = new JsonParser().parse(userData).getAsJsonObject();

		// Read the value from the JSON object
		String uid = customerObject.get("uid").getAsString();
		String output = user.deleteUser(uid);
		return output;
	}
}

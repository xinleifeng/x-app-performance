package sap.crun.performance.api.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * The class HDIEnvironment retrieves the JSON node VCAP_SERVICES from the
 * environment. The node is parsed, and values such as user, passowrd, url and
 * port can be used to establish a JDBC connection in order to perform queries.
 * 
 */
public class HDIConnection {

	private String vcap_services = "";
	private String host = "";
	private String port = "";
	private String user = "";
	private String pwd = "";
	private String url = "";
	private String schema = "";
	
	private Connection jdbcconn = null;


	public HDIConnection() {
		
		JSONObject obj;
		try {
			obj = new JSONObject(System.getenv("VCAP_SERVICES"));
			
			JSONArray arr = obj.getJSONArray("hana");
			host = arr.getJSONObject(0).getJSONObject("credentials").getString("host");
			port = arr.getJSONObject(0).getJSONObject("credentials").getString("port");
			user = arr.getJSONObject(0).getJSONObject("credentials").getString("user");
			pwd = arr.getJSONObject(0).getJSONObject("credentials").getString("password");
			url = arr.getJSONObject(0).getJSONObject("credentials").getString("url");
			schema = arr.getJSONObject(0).getJSONObject("credentials").getString("schema");
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

//		// Register JDBC driver
//		try {
//
//			Class.forName("com.sap.db.jdbc.Driver");
//
//			// Open a connection
//			jdbcconn = DriverManager.getConnection(url, user, pwd);
//			// Execute SQL query
//			
//			stmt = jdbcconn.createStatement();
//			ResultSet rs = null;
//			String sql = "SELECT TRANSID FROM SNGLRECOUT";
//			rs = stmt.executeQuery(sql);
//			
//			// Extract data from result set
//			while (rs.next()) {
//				results.add(rs.getString("TRANSID"));
//			}
//			// Clean-up environment
//			rs.close();
//			stmt.close();
//			jdbcconn.close();
//		} catch (ClassNotFoundException e1) {
//			e1.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
	
	}
	
	public Connection openConnection(String url, String user, String pwd) {
		
		// Register JDBC driver
		try {
			Class.forName("com.sap.db.jdbc.Driver");

			// Open a connection
			jdbcconn = DriverManager.getConnection(url, user, pwd);
		
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return jdbcconn;
	}
	public void closeConnection(Connection jdbcconn) {
		try {
			jdbcconn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	

	public String getVcap_services() {
		return vcap_services;
	}

	public void setVcap_services(String vcap_services) {
		this.vcap_services = vcap_services;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

}
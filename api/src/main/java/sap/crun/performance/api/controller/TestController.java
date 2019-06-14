package sap.crun.performance.api.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sap.crun.performance.api.util.HDIConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.DriverManager;

@Controller
@EnableAutoConfiguration
public class TestController {

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/plain")
	@ResponseBody
	String home() {

		StringBuilder builder = new StringBuilder();
		builder.append("Hello World !!");

		HDIConnection hdiConn = new HDIConnection();
		Connection jdbcconn = null;
		Statement stmt = null;
		List<String> results = new ArrayList<>();

		builder.append("schema: " + hdiConn.getSchema() + "\n");
		builder.append("getURL: " + hdiConn.getUrl() + "\n");
		builder.append("hdiUsr: " + hdiConn.getUser() + "\n");
		builder.append("hdiPwd: " + hdiConn.getPwd() + "\n");
		//
		// // Register JDBC driver
		try {

			Class.forName("com.sap.db.jdbc.Driver");
			// Open a connection
			jdbcconn = hdiConn.openConnection(hdiConn.getUrl(), hdiConn.getUser(), hdiConn.getPwd());
			// Execute SQL query
			stmt = jdbcconn.createStatement();

			ResultSet rs = null;

			// String sql = "SELECT TRANSID FROM
			// \"X_APP_PERFORMANCE_X_APP_PERFORMANCE_DB_HDI_CONTAINER_1\".\"SAP_CRUN_PERFORMANCE_SNGLRECOUT\"";
			String sql = "SELECT TRANSID FROM SAP_CRUN_PERFORMANCE_SNGLRECOUT";

			builder.append(sql + "\n");

			rs = stmt.executeQuery(sql);

			// Extract data from result set
			while (rs.next()) {
				results.add(rs.getString("TRANSID"));
			}
			// Clean-up environment
			rs.close();
			stmt.close();
			hdiConn.closeConnection(jdbcconn);

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//
		//
		results.forEach(item -> {
			builder.append(item + "\n");
		});

		return builder.toString();
	}

	private String getCurrentUser(Connection conn) throws SQLException {
		String currentUser = "";
		PreparedStatement prepareStatement = conn.prepareStatement("SELECT CURRENT_USER \"current_user\" FROM DUMMY;");
		ResultSet resultSet = prepareStatement.executeQuery();
		int column = resultSet.findColumn("current_user");
		while (resultSet.next()) {
			currentUser += resultSet.getString(column);
		}
		return currentUser;
	}

	private String getCurrentSchema(Connection conn) throws SQLException {
		String currentSchema = "";
		PreparedStatement prepareStatement = conn
				.prepareStatement("SELECT CURRENT_SCHEMA \"current_schema\" FROM DUMMY;");
		ResultSet resultSet = prepareStatement.executeQuery();
		int column = resultSet.findColumn("current_schema");
		while (resultSet.next()) {
			currentSchema += resultSet.getString(column);
		}
		return currentSchema;
	}

	private Connection getConnection() {
		Connection conn = null;
		String DB_USERNAME = "";
		String DB_PASSWORD = "";
		String DB_HOST = "";
		String DB_PORT = "";

		try {
			JSONObject obj = new JSONObject(System.getenv("VCAP_SERVICES"));
			JSONArray arr = obj.getJSONArray("hana");
			DB_USERNAME = arr.getJSONObject(0).getJSONObject("credentials").getString("user");
			DB_PASSWORD = arr.getJSONObject(0).getJSONObject("credentials").getString("password");
			DB_HOST = arr.getJSONObject(0).getJSONObject("credentials").getString("host").split(",")[0];
			DB_PORT = arr.getJSONObject(0).getJSONObject("credentials").getString("port");
			String DB_READ_CONNECTION_URL = "jdbc:sap://" + DB_HOST + ":" + DB_PORT;

			conn = (Connection) DriverManager.getConnection(DB_READ_CONNECTION_URL, DB_USERNAME, DB_PASSWORD);
		} catch (Exception e) {
			System.out.println("Connection Error");
		}

		return conn;
	}
}

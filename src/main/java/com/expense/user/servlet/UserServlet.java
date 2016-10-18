package com.expense.user.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@WebServlet(name = "UserServlet", urlPatterns = { "/user" })
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		resp.setContentType("application/json");
		ServletOutputStream out = resp.getOutputStream();
		out.write(convertToJson(getUserData()).getBytes());
		out.flush();
		out.close();
	}

	public static String convertToJson(Object object) throws JsonProcessingException {
		final ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(object);
		return json;
	}

	private Map<String, Map<String, String>> getUserData() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("binay", 	"Binay Mishra");
		map.put("amit",  	"Amit Kumar");
		map.put("pravat", 	"Pravat Ranjan Mohanta");
		map.put("prithavi",	"Prithaviraj Mishra");
		map.put("sushant",	"Sushant Kumar Dash");

		Map<String, Map<String, String>> users = new HashMap<String, Map<String, String>>();
		users.put("users", map);
		return users;
	}

}
package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import com.google.sps.data.PersonalDetails;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/details")
public class PersonalDetailsServlet extends HttpServlet {
 @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
  
    String firstName = "Mark";
    String lastName = "Gacoka";
    int currentAge = 20;
    String schoolYear = "Sophomore";
    
    PersonalDetails personalDetails = new PersonalDetails(firstName, lastName, currentAge, schoolYear);
    String json = convertToJson(personalDetails);
    
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }
  
  private String convertToJson(PersonalDetails personalDetails) {
    String json = "{";
    json += "\"firstName\": ";
    json += "\"" + personalDetails.getFirstName() + "\"";
    json += ", ";
    json += "\"lastName\": ";
    json += "\"" + personalDetails.getLastName() + "\"";
    json += ", ";
    json += "\"currentAge\": ";
    json += personalDetails.getCurrentAge();
    json += ", ";
    json += "\"schoolYear\": ";
    json += "\"" + personalDetails.getSchoolYear() + "\"";
    json += "}";
    return json;
  }
  
    private String convertToJsonUsingGson(PersonalDetails personalDetails) {
    Gson gson = new Gson();
    String json = gson.toJson(personalDetails);
    return json;
  }
}

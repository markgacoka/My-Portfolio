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
    String[] randomFacts = {"I am 5'9\"", "I was born in Kenya", "I have had multiple near death experiences", "I can type upto 170 wpm"};

    PersonalDetails personalDetails = new PersonalDetails(firstName, lastName, currentAge, randomFacts);
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
    json += "\"randomFact\": ";
    json += "\"" + personalDetails.getRandomFact() + "\"";
    json += "}";
    return json;
  }

    private String convertToJsonUsingGson(PersonalDetails personalDetails) {
    Gson gson = new Gson();
    String json = gson.toJson(personalDetails);
    return json;
  }
}

package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    String nameValue = Jsoup.clean(request.getParameter("fname"), Whitelist.none());
    String replyValue = Jsoup.clean(request.getParameter("reply"), Whitelist.none());
    long timestamp = System.currentTimeMillis();
    
    System.out.println("Form from: " + nameValue);
    System.out.println("You submitted: " + replyValue);
    
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Response");
    FullEntity responseEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("Name", nameValue)
            .set("Response", replyValue)
            .set("Timestamp", timestamp)
            .build();
    datastore.put(responseEntity);
    response.sendRedirect("/");
  }
}

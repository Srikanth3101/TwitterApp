/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 *
 * @author srikanth
 */
public class NonEnglishJSONConverter {
    private static Connection con;
    public static ResultSet RetrieveData() throws Exception {
      Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.10:1521:XE","system","java");
          
      //Creating the Statement
      Statement stmt = con.createStatement();
      //Retrieving the record
      ResultSet rs = stmt.executeQuery("Select * from tweets where ROWNUM<=10 order by retweetcount DESC");
      return rs;
   }
   public void getJSON() throws Exception {
      //Creating a JSONObject object
      JSONObject jsonObject = new JSONObject();
      //Creating a json array
      JSONArray array = new JSONArray();
      ResultSet rs = RetrieveData();
      //Inserting ResutlSet data into the json object
      while(rs.next()) {
         JSONObject record = new JSONObject();
         //Inserting key-value pairs into the json object
         record.put("tweet", rs.getString("tweet"));
         record.put("ReTweetCount", rs.getInt("retweetcount"));
         array.add(record);
      }
      jsonObject.put("tweets", array);
      try {
          File file1 =new File("retweets.json");
          file1.createNewFile();
         FileWriter file = new FileWriter(file1);
         file.write(jsonObject.toJSONString());
         file.close();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
}

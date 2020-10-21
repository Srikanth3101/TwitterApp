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
 * @author anbumani
 */
public class JASONconverter {
    private static Connection con;
    public static ResultSet RetrieveData() throws Exception {
      Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.10:1521:XE","system","java");
          
      //Creating the Statement
      Statement stmt = con.createStatement();
      //Retrieving the record
      ResultSet rs = stmt.executeQuery("Select * from NonEnglishTweets");
      return rs;
   }
   public void jason() throws Exception {
      JSONObject jsonObject = new JSONObject();
      JSONArray array = new JSONArray();
      ResultSet rs = RetrieveData();
      while(rs.next()) {
         JSONObject record = new JSONObject();
         record.put("tweet", rs.getString("tweet"));
         record.put("ReTweetCount", rs.getInt("retweetcount"));
         record.put("CreatedTime",rs.getString("createdtime"));
         array.add(record);
      }
      jsonObject.put("tweets_data", array);
      try {
          File file1 =new File("nonenglishtweets.json");
          file1.createNewFile();
         FileWriter file = new FileWriter(file1);
         file.write(jsonObject.toJSONString());
         file.close();
      } catch (IOException e) {
      }
   }
}

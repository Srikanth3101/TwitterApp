/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.List;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.*;
import java.util.Calendar;
import org.apache.tika.language.LanguageIdentifier;
/**
 *
 * @author srikanth
 */
public class tweetsForFiveDays {
    private static Connection con;
    public void find(twitter4j.Twitter twitter) throws TwitterException, ClassNotFoundException, SQLException
    {
         Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.10:1521:XE","system","java");
          
            PreparedStatement ps = con.prepareStatement("insert into tweets values(?,?)");
            PreparedStatement ps1 = con.prepareStatement("insert into NonEnglishTweets values(?,?,?)");
        
        Query query = new Query("corona");
        int i=0;
        QueryResult result;
        Date before=findDate();
        do {
            result = twitter.search(query);
            List<Status> tweets = result.getTweets();
            List<Status> statuses = twitter.getHomeTimeline();
            for(Status tweetss:tweets){
                Date present=tweetss.getCreatedAt();
                if(present.compareTo(before)<0)
                {
                    i=1;
                    break;
                }
                int retweetcount=tweetss.getRetweetCount();
                String tweet=tweetss.getText();
                
                System.out.println(retweetcount+" "+tweet);
                LanguageIdentifier identifier = new LanguageIdentifier(tweet);
                String language = identifier.getLanguage();
                if(language.equals("en"))
                {
                    ps.setString(1,tweet);
                    ps.setInt(2,retweetcount);
                
                    int j = ps.executeUpdate();
                    if(j>0)
                    System.out.println("Updated succussfully");
                }
                else
                {
                    ps1.setString(1,tweet);
                    ps1.setInt(2,retweetcount);
                    ps1.setString(3,present.toString());
                    int j = ps1.executeUpdate();
                    if(j>0)
                    System.out.println("Updated succussfully");
                }
            }
        } while (i==0);
        con.close();
        System.exit(0);
    }
    
    Date findDate()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -5);
        return calendar.getTime();
    }
}
/*
create table NonEnglishTweets
(
    tweet varchar(500),
    retweetcount int,
    createdtime varchar(100)
);
*/

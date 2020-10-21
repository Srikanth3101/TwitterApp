/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterapp;

import java.sql.SQLException;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
/**
 *
 * @author anbumani
 */
public class TwitterApp {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TwitterException, ClassNotFoundException, SQLException, Exception {
        ConfigurationBuilder cb=new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("E4V0cvPKQGj9qBCS1wBXxZ63y")
                .setOAuthConsumerSecret("KiyS339aG4dQR2LM9Nb4JrPPpNLefIa6SAu06w5pa7YMBKc7fe")
                .setOAuthAccessToken("1966958672-t8ndr2otcgAmBrerFnJgFGsGFaxkK3ne60W9A4H")
                .setOAuthAccessTokenSecret("xgqw8pG9nhVtYuCq9rPa89lSeLpGQtwWQVGBBg19O2Su8");
        TwitterFactory tf=new TwitterFactory(cb.build());
        twitter4j.Twitter twitter=tf.getInstance();
        tweetsForFiveDays tr=new tweetsForFiveDays();
        tr.find(twitter);//find trending tweets which has corona in it.
        JASONconverter js=new JASONconverter();
        js.jason();
        
        JASONConverter1 jas=new JASONConverter1();
        jas.jason();
    }
}

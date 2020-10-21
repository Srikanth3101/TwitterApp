# TwitterApp
To find the recent trending tweets that contains word "corona" and find the language of the tweet.
It is a java program using twitter4j and it has dbms(mysql),twitter api and apache tikka(language detection) library in it.
All the source files are present in src.

The name of Main java file is TwitterApp.
The TwitterApp connects with the twitter api and it calls an function in TweetsForFiveDays class by creating an object and also calls function from jasoncoverter class.

The TweetsForFiveDays class contains a method to find all the tweets that has "corona" word in it,and also 
finds the language of the tweet all the english tweets are stored in database table called tweets and all non english tweets are stored in database table called NonEnglishTweets.

the JSONconverter class converts the database table tweets and selects top 10 retweeted tweet into jason file called retweets.jason.

the JSONConverter1 class converts the database table NonEnglishTweets and selects all nonenglishtweets tweet into jason file called nonenglishtweets.jason.

TwitterAppScreensots.odt file contains the Screenshots of Excecution.

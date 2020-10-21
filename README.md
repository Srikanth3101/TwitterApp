# TwitterApp

#### Corono Tweets
The project is about to find the recent trending tweets that contains word "corona" and find the language of the tweet.

#### Java - twitter4j
The codes are written in java language containing the primary library twitter4j.Twitter4J is an unofficial Java library for the Twitter API. With Twitter4J, you can easily integrate your Java application with the Twitter service.

#### Tweets - Storage
The project uses DBMS(oracle) for the storing the receiving tweets.

#### Language Detection - Tikka Library - java

Tika is a toolkit that is used to extract content and metadata from supported document (file). Tika can identify language of any document or piece of text. It is useful while extracting text from document formats which do not include language information in their metadata. Tika uses LanguageProfile and Language-Identifier classes to matching ISO 639 language code.
Tika can detect 18 of the 184 currently registered ISO 639-1 languages.


#### WorkFlow 

The name of Main java file is TwitterApp.
The TwitterApp connects with the twitter api and it calls an function in TweetsForFiveDays class by creating an object and also calls function from jsoncoverter class.

The TweetsForFiveDays class contains a method to find all the tweets that has "corona" word in it,and also 
finds the language of the tweet all the english tweets are stored in database table called tweets and all non english tweets are stored in database table called NonEnglishTweets.

The JSONconverter class converts the database table tweets and selects top 10 retweeted tweet into json file called retweets.json.

The NonEnglishJSONConverter class converts the database table NonEnglishTweets and selects all nonenglishtweets tweet into json file called nonenglishtweets.json.

TwitterAppScreensots.odt file contains the Screenshots of Excecution.

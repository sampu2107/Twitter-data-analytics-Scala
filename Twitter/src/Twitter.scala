import twitter4j._
import java.text.SimpleDateFormat
import java.util.SimpleTimeZone
import java.util.Properties
import twitter4j.conf.ConfigurationBuilder

object Twitter {
	
	def main(args: Array[String]) {
	   val cb = new ConfigurationBuilder()
     cb.setDebugEnabled(true)
		.setOAuthConsumerKey("YHSar9mvzdpEVNe5SYFs5Ii4Z")
		.setOAuthConsumerSecret("MxkCd6Oh2Y7ZIRAtfKxxPecOyiG2DYf9Qrh8Lj5cGUPU40f07y")
		.setOAuthAccessToken("1366744135-qTpURkPwcXU1TpWgmA9zAKLW7IGIahEy0qk6sXs")
		.setOAuthAccessTokenSecret("yDMSychbV7Ipktsk2on2FX5WAdbrlfzs8qN7EjSLrAO9l")
		.setIncludeEntitiesEnabled(true)
    
  val tf = new TwitterFactory(cb.build())
    val twitter = tf.getInstance()
    val query = new Query("Trump");
	   
	   var i=0
	   do {
val result = twitter.search(query)
i=i+1
 println(i+"Tweetes Found :" + result.getTweets)
	   }while (i<=0);
}
}
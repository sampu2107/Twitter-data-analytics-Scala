import twitter4j._
/*import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.json4s.JsonDSL._
import org.json4s.JsonAST._
*/
import java.text.SimpleDateFormat
import java.util.SimpleTimeZone
import java.util.Properties
import java.nio._
import java.nio.file.StandardOpenOption
import java.nio.file.Paths
import twitter4j.conf.ConfigurationBuilder

object TwitterStream {
  
	def main(args: Array[String]) {
	   val cb = new ConfigurationBuilder()
 cb.setDebugEnabled(true)
		.setOAuthConsumerKey("YHSar9mvzdpEVNe5SYFs5Ii4Z")
		.setOAuthConsumerSecret("MxkCd6Oh2Y7ZIRAtfKxxPecOyiG2DYf9Qrh8Lj5cGUPU40f07y")
		.setOAuthAccessToken("1366744135-qTpURkPwcXU1TpWgmA9zAKLW7IGIahEy0qk6sXs")
		.setOAuthAccessTokenSecret("yDMSychbV7Ipktsk2on2FX5WAdbrlfzs8qN7EjSLrAO9l")
		.setIncludeEntitiesEnabled(true)
    
  val tf = new TwitterFactory(cb.build())
    val twitter = tf.getInstance();
	   //twitter.addRateLimitStatusListener(simpleStatusListener);
    val query = new Query("Trump");
     var i=0
	   do {
val result = twitter.search(query)
val list = result.getTweets.toArray()
val tweet = "";
for(tweet <- list ){
  println(tweet.toString());
}
i=i+1

//println(i+"Tweetes Found :" + result.getTweets)

} while (i<=5);

    // (2) use the twitter object to get your friend's timeline
  

	}
}
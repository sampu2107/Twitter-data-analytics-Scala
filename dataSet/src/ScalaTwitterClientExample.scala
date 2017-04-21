import twitter4j.TwitterFactory
import twitter4j.Twitter
import twitter4j.conf.ConfigurationBuilder
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


object ScalaTwitterClientExample {
  
  def main(args : Array[String]) {
    
    // (1) config work to create a twitter object
    val cb = new ConfigurationBuilder()
    cb.setDebugEnabled(true)
      .setOAuthConsumerKey("YHSar9mvzdpEVNe5SYFs5Ii4Z")
		.setOAuthConsumerSecret("MxkCd6Oh2Y7ZIRAtfKxxPecOyiG2DYf9Qrh8Lj5cGUPU40f07y")
		.setOAuthAccessToken("1366744135-qTpURkPwcXU1TpWgmA9zAKLW7IGIahEy0qk6sXs")
		.setOAuthAccessTokenSecret("yDMSychbV7Ipktsk2on2FX5WAdbrlfzs8qN7EjSLrAO9l")
		.setIncludeEntitiesEnabled(true)
     val tf = new TwitterFactory(cb.build())
    val twitter = tf.getInstance()
    val query = new Query("US Elections 2016")
    val result = twitter.search(query)
    System.out.println("Showing results.")
    while (result.hasNext()) {
      val it = result.getTweets.iterator()
        while(it.hasNext()){
          val status = it.next()
          println(status.getText())
        }}
}
}
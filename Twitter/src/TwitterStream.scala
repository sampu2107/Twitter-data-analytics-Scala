import twitter4j._
import java.text.SimpleDateFormat
import java.util.SimpleTimeZone
import java.util.Properties
import twitter4j.conf.ConfigurationBuilder
import org.slf4j.LoggerFactory
import ch.qos.logback.core.util.StatusPrinter
import ch.qos.logback.classic.LoggerContext
import java.io.StringWriter
import au.com.bytecode.opencsv.CSVWriter
import scala.collection.JavaConversions._
import java.io.FileWriter
import java.io.BufferedWriter
import java.io._

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
    val twitter = tf.getInstance()
    val query = new Query("US Elections 2016");
    query.setCount(100);
    var i = 0
    var j = 0
    var textWriter = new PrintWriter(new File("scala.csv"))
    textWriter.write("tweets" + "," + "source");
    textWriter.write("\n");
    System.setProperty("logback.configurationFile", "C:/Users/werms/workspace/Scala/Twitter/resource/logback.xml");

    def logger = LoggerFactory.getLogger(this.getClass)

    // The following line prints startup information from logback if anything should go amiss
    StatusPrinter.print((LoggerFactory.getILoggerFactory).asInstanceOf[LoggerContext])

    println("- About to log!")
    println("Following are the tweets from twitter about US elections 2016!!!")
    try {
      var result = twitter.search(query)
      do {
        var it = result.getTweets.iterator()
        i = i + 1
        do {
          j = j + 1
          println(j + "------------->" + it.next().getText())
          var tweet = it.next().getText.replaceAll(",", "")
          var source = it.next().getSource
          if(tweet != null && source != null){
          textWriter.write(tweet + "," + source);
          textWriter.write("\n");
          }
        } while (result.getTweets.iterator().hasNext());
      } while (result.hasNext());
    } catch {
      case _: Throwable => textWriter.close()
    }
    
var path="cmd /c start C:\\SPL\\batchexec.bat";
var rn=Runtime.getRuntime();
var pr=rn.exec(path);
    
  }
}

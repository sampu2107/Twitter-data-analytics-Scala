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
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ListBuffer
import java.io._

object csvtweets {
   def main(args: Array[String]) {
     val out = new BufferedWriter(new FileWriter("tweets3.txt"));
     val writer = new CSVWriter(out);
     val out1 = new BufferedWriter(new FileWriter("tweets4.csv"));
     val writer1 = new CSVWriter(out1);
     
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
       var i=0
       var j=0
       
       System.setProperty("logback.configurationFile", "C:/Users/werms/workspace/Scala/Twitter/resource/logback.xml");
  
  def logger = LoggerFactory.getLogger(this.getClass)
val tweetsSchema=ArrayBuffer[String]()
var textWriter = new PrintWriter(new File("scala.txt" ))

//val userLangSchema=ArrayBuffer[String]()
 /* var tweetsSchema = ListBuffer[String]()
  var userLangSchema = ListBuffer[String]()
 */ var finalArray = new Array[String](1000)
 var chummaArray = new Array[String](1000)
  var x = List(100)
  // The following line prints startup information from logback if anything should go amiss
  StatusPrinter.print((LoggerFactory.getILoggerFactory).asInstanceOf[LoggerContext])

  println("- About to log!")
  println("Following are the tweets from twitter about US elections 2016!!!")
 var result = twitter.search(query)
       do { 
      var it = result.getTweets.iterator()
      
i=i+1
do {
j=j+1
//println(j+"------------->"+it.next().getText())
//finalArray(j) = it.next().getText()+","+it.next().getSource;
//chummaArray(j) = it.next().getSource
if(j==40){
var listOfRecords= List(finalArray)
writer.writeAll(listOfRecords)
}
//tweetsSchema += it.next().getText()
//print("listttt"+tweetsSchema)
/*z :+ it.next().getText()
x = it.next().getText() := x
*/
//writer1.writeNext(tweetsSchema.toArray)
//var tweets = Array(it.next().getText())
//var listOfRecords= List(tweets)
//logger.info(it.next().getText())
} while (result.getTweets.iterator().hasNext());
} while (result.hasNext());
//print("here"+finalArray)
/*var listOfRecords= List(finalArray)
writer.writeAll(listOfRecords)
*/out.close()
    }
}
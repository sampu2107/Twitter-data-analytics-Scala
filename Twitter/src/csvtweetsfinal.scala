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
  
object csvtweetsfinal {
   def main(args: Array[String]) {
     val out = new BufferedWriter(new FileWriter("tweets.csv"));
     val writer = new CSVWriter(out);
     
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
       
       //System.setProperty("logback.configurationFile", "C:/Users/werms/workspace/Scala/Twitter/resource/logback.xml");

var fruits = ArrayBuffer[String]()
fruits += "Apple"
fruits += "Banana"
fruits += "Orange"

  def logger = LoggerFactory.getLogger(this.getClass)
  println("- About to log!")
  println("Following are the tweets from twitter about US elections 2016!!!")
  var finalArray = new Array[String](5)
 // val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
  finalArray(0) = "hello";
       finalArray(1) = "wordl";
       finalArray(2) = "hello";
       finalArray(3) = "he";
       finalArray(4) = "o";
  var employeeSchema=Array("name","age","dept")
  employeeSchema:+("piyush","23","computerscience")
 
val employee1= Array("piyush","23","computerscience")
 
val employee2= Array("neel","24","computerscience")
 
val employee3= Array("aayush","27","computerscience")

println(employeeSchema.size);
var listOfRecords= List(finalArray)
val pattern = "(<a[^>]*>(.*?)</a>)".r
val pattern(text)="<a href>asasa</a>"
println(text)
/*val s="<a href>hey how are you</a>";
print(s.replaceAll("<a*></?a>", ""));
val startPosition = s.indexOf("<a>") + "<a>".length();
val endPosition = s.indexOf("</a>", startPosition);
val subS = s.substring(startPosition, endPosition);
*///print(subS)
   //    var source = "<a>asas</a>".replaceAll(""<(?!\/?a(?=>|\s.*>))\/?.*?>"", "")
     //  print(source)
       
   var result = twitter.search(query)
 writer.writeAll(listOfRecords)
 out.close()
}}
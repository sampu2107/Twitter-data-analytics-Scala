import twitter4j._
import java.text.SimpleDateFormat
import java.util.SimpleTimeZone
import java.util.Properties
import twitter4j.conf.ConfigurationBuilder
import org.slf4j.LoggerFactory
import ch.qos.logback.core.util.StatusPrinter
import ch.qos.logback.classic.LoggerContext
import java.io.StringWriter
import scala.io.Source
import java.io.File
import java.io._
import java.io.FileInputStream
import opennlp.uima.tokenize.Tokenizer
import opennlp.tools.tokenize.Tokenizer
import opennlp.tools.sentdetect.SentenceDetectorME
import opennlp.tools.sentdetect.SentenceModel
import opennlp.tools.tokenize.TokenizerME
import opennlp.tools.tokenize.TokenizerModel
import scala.collection.mutable.ListBuffer

import scala.collection.JavaConversions._
import java.io.FileWriter
import java.io.BufferedWriter
import java.io._

object TwitterStreams {
  def main(args: Array[String]) {
    
    
		lazy val tokenizer =	new TokenizerME(new TokenizerModel(new File("C:\\Users\\werms\\workspace\\Scala\\Twitter\\da-token.bin" )))
		lazy val sentenceDetector =new SentenceDetectorME(new SentenceModel(new File("C:\\Users\\werms\\workspace\\Scala\\Twitter\\en-sent.bin" )))

		//println("Following is the content read:" )
		val builder = StringBuilder.newBuilder


		val bufferedSource=io.Source.fromFile("C:\\Users\\werms\\workspace\\Scala\\Twitter\\trump_tweets.csv" ); 
		for (line <- bufferedSource.getLines) {
			val cols = line.split(",").map(_.trim)
					// do whatever you want with the columns here



					try {
						//println(s"${cols(0)}|${cols(1)}")
						builder.append(cols(1))
					} catch {
					case ex: ArrayIndexOutOfBoundsException => {
					}
					}

		}
		//println("Builder--------------------"+builder)

		val test = builder.mkString;
		var maps = collection.mutable.Map[String, Int]()
		val tokens1=tokenizer.tokenize(test);
				var word="";
		val sentences = sentenceDetector.sentDetect(test)
		val tokenizedSentences = sentences.map(tokenizer.tokenize(_))
				tokenizedSentences.foreach(tokens => print(""))
				
				var words = new ListBuffer[String]()
				tokens1.foreach(tokens1 => 
				//println("words***"+tokens1.mkString(""))
	     	words+=tokens1.mkString("").toLowerCase()
				)
		   
		
	    
     
//println(words.remove());
	
    
    
    val cb = new ConfigurationBuilder()
    cb.setDebugEnabled(true)
      .setOAuthConsumerKey("YHSar9mvzdpEVNe5SYFs5Ii4Z")
      .setOAuthConsumerSecret("MxkCd6Oh2Y7ZIRAtfKxxPecOyiG2DYf9Qrh8Lj5cGUPU40f07y")
      .setOAuthAccessToken("1366744135-qTpURkPwcXU1TpWgmA9zAKLW7IGIahEy0qk6sXs")
      .setOAuthAccessTokenSecret("yDMSychbV7Ipktsk2on2FX5WAdbrlfzs8qN7EjSLrAO9l")
      .setIncludeEntitiesEnabled(true)

    val tf = new TwitterFactory(cb.build())
    val twitter = tf.getInstance()
    
     println("Enter the topic that you want to Analyze:")
     val inputText=scala.io.StdIn.readLine();
     //println("entered texr"+inputText);
    
    
    
    val query = new Query(inputText);
    query.setCount(100);
    var i = 0
    var j = 0
    var textWriter = new PrintWriter(new File("scala.csv"))
    textWriter.write("tweets" + "," + "source");
    textWriter.write("\n");
   

    def logger = LoggerFactory.getLogger(this.getClass)

    // The following line prints startup information from logback if anything should go amiss
    StatusPrinter.print((LoggerFactory.getILoggerFactory).asInstanceOf[LoggerContext])

  //  println("- About to log!")
    println("Following are the tweets from twitter about "+inputText)
     println(words.groupBy(identity).mapValues(_.size).toSeq)
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
          if(tweet != null && source != null && tweet != "" && source != ""){
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
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
object Demo {
	def main(args: Array[String]) {
		lazy val tokenizer =	new TokenizerME(new TokenizerModel(new File("C:\\ScalaProj\\da-token.bin" )))
		lazy val sentenceDetector =new SentenceDetectorME(new SentenceModel(new File("C:\\ScalaProj\\en-sent.bin" )))

		println("Following is the content read:" )
		val builder = StringBuilder.newBuilder


		val bufferedSource=io.Source.fromFile("C:/trump_tweets.csv" ); 
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
		println("Builder--------------------"+builder)

		val test = builder.mkString;
		var maps = collection.mutable.Map[String, Int]()
		val tokens1=tokenizer.tokenize(test);
		val sentences = sentenceDetector.sentDetect(test)
		val tokenizedSentences = sentences.map(tokenizer.tokenize(_))
				tokenizedSentences.foreach(tokens => println("Sentence***"+tokens.mkString(" ")))
				var fruits = new ListBuffer[String]()
				tokens1.foreach(tokens1 => 
				//println("words***"+tokens1.mkString(""))
	     	fruits+=tokens1.mkString("").toLowerCase()
				)
				println(fruits.groupBy(identity).mapValues(_.size).toSeq)
println(fruits.max)
	}
}

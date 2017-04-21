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



object StatusStreamer{
  def main(args: Array[String]) {
    val twitterStream = new TwitterStreamFactory(Util.config).getInstance
    twitterStream.addListener(Util.simpleStatusListener)
    twitterStream.sample
    Thread.sleep(1000000)
    twitterStream.cleanUp
    twitterStream.shutdown
  }
}
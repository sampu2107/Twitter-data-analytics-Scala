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


class statusListener {
  def simpleStatusListener = new StatusListener() {
  def onStatus(status: Status) { println(status.getText) }
  def onDeletionNotice(statusDeletionNotice: StatusDeletionNotice) {}
  def onTrackLimitationNotice(numberOfLimitedStatuses: Int) {}
  def onException(ex: Exception) { ex.printStackTrace }
  def onScrubGeo(arg0: Long, arg1: Long) {}
  def onStallWarning(warning: StallWarning) {}
}
}
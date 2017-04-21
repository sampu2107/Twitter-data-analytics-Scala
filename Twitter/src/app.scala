import org.slf4j.LoggerFactory
import ch.qos.logback.core.util.StatusPrinter
import ch.qos.logback.classic.LoggerContext

object LogTester extends App{
  
  System.setProperty("logback.configurationFile", "C:/Users/werms/workspace/Scala/Twitter/resource/logback.xml");
  
  def logger = LoggerFactory.getLogger(this.getClass)

  // The following line prints startup information from logback if anything should go amiss
  StatusPrinter.print((LoggerFactory.getILoggerFactory).asInstanceOf[LoggerContext])

  println("- About to log!")
  logger.info("vikas")
}

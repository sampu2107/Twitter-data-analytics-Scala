import twitter4j._


object FollowIdsStreamer {
  def main(args: Array[String]) {
    val twitterStream = new TwitterStreamFactory(Util.config).getInstance
    twitterStream.addListener(Util.simpleStatusListener)
    //twitterStream.filter(new FilterQuery(25073877))
    Thread.sleep(10000)
    twitterStream.cleanUp
    twitterStream.shutdown
  }
}

object SearchStreamer {
  def main(args: Array[String]) {
    val qry = Array [String] ("Trump", "US Elections")
    val twitterStream = new TwitterStreamFactory(Util.config).getInstance
    twitterStream.addListener(Util.simpleStatusListener)
    twitterStream.filter(new FilterQuery().track("@realDonaldTrump"))
    Thread.sleep(10000)
    twitterStream.cleanUp
    twitterStream.shutdown
  }
}

object AustinStreamer {
  def main(args: Array[String]) {
    val twitterStream = new TwitterStreamFactory(Util.config).getInstance
    twitterStream.addListener(Util.simpleStatusListener)
    val austinBox = Array(Array(37.09, 95.7129),Array(37.09, 95.7129))
    //twitterStream.filter(new FilterQuery().locations(austinBox))
    Thread.sleep(10000)
    twitterStream.cleanUp
    twitterStream.shutdown
  }
}

object LocationStreamer {
  def main(args: Array[String]) {
    val a = Array [Double] (37.09, 95.7129)
    val boundingBoxes = a.map(_.toDouble).grouped(2).toArray
    val twitterStream = new TwitterStreamFactory(Util.config).getInstance
    twitterStream.addListener(Util.simpleStatusListener)
    //twitterStream.filter(new FilterQuery().locations(boundingBoxes))
    Thread.sleep(10000)
    twitterStream.cleanUp
    twitterStream.shutdown
  }
}

object Util {

  val config = new twitter4j.conf.ConfigurationBuilder()
  .setOAuthConsumerKey("YHSar9mvzdpEVNe5SYFs5Ii4Z")
		.setOAuthConsumerSecret("MxkCd6Oh2Y7ZIRAtfKxxPecOyiG2DYf9Qrh8Lj5cGUPU40f07y")
		.setOAuthAccessToken("1366744135-qTpURkPwcXU1TpWgmA9zAKLW7IGIahEy0qk6sXs")
		.setOAuthAccessTokenSecret("yDMSychbV7Ipktsk2on2FX5WAdbrlfzs8qN7EjSLrAO9l")
		.setIncludeEntitiesEnabled(true)
    .build

  def simpleStatusListener = new StatusListener() {
    def onStatus(status: Status) { 
      if(status.getLang.matches("en") && !(status.isRetweet())){
      println(status.getText) 
      }
    }
    def onDeletionNotice(statusDeletionNotice: StatusDeletionNotice) {}
    def onTrackLimitationNotice(numberOfLimitedStatuses: Int) {}
    def onException(ex: Exception) { ex.printStackTrace }
    def onScrubGeo(arg0: Long, arg1: Long) {}
    def onStallWarning(warning: StallWarning) {}
  }
}

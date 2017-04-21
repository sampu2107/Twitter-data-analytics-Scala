package com.meetu.elasticsearch
 
import org.elasticsearch.node.NodeBuilder.nodeBuilder
import scala.io.Source
 
object ElasticSearchApplication extends App {
  val node = nodeBuilder().client(true).node()
  val client = node.client()
 
  val jsons = Source.fromFile("src/sample.json").getLines().toList
  for (i <- 1 to jsons.length) {
    indexJson(jsons(i - 1), i.toString)
  }
  
  
 
  def indexJson(json: String, id: String) = {
    client.prepareIndex("esa", "activityStream", id).setSource(json).execute().actionGet()
  }
 
}
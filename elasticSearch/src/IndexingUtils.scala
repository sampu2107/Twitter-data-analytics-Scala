package utils

import org.elasticsearch.client.Client
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest

object IndexingUtils {
  
  def createMapping(client: Client, indexName: String, indexType: String, mappingFile: String) {
	  //Submit mappings to index
		client.admin().indices()
		.preparePutMapping(indexName)
		.setType(indexType)
		.setSource("tweets")
		.execute().actionGet()
	}
	
	def createIndex(client: Client, indexName: String, indexFile: String) {
	  //Create index
		client.admin().indices().prepareCreate(indexName)
			.setSource("tweets").execute()
		.actionGet()
	}
	
}


  while (result.hasNext()) {
      while(it.hasNext()){
          if(it.next().getLang == "en"){ 
         println(it.next().getText)
		 val p = TwitterObject(it.next().getUser,it.next().getText);
         val jsonString = gson.toJson(p);
		 jsonString.addString(",")
         println(jsonString.addString(new StringBuilder(gson.toJson(p))));
      }
    }
	
	
      
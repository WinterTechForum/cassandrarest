package cassandrarest;

import java.util.HashMap;
import java.util.Map;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class CassandraYapper {
    
   private Session session;

   public CassandraYapper(final String host)
   {
      session = Cluster.builder().addContactPoint(host).build().connect();
   }
   
   public Map<String, String> getData()
   {
      Map<String, String> results = new HashMap<>();
      
      ResultSet resultSet = session.execute("SELECT * FROM wtf.data");
      for (Row row : resultSet) 
      {
         results.put(row.getString("field1"), row.getString("field2"));
      }
      return results;
   }
   
   public void putData(String key, String value)
   {
      session.execute("INSERT INTO wtf.data (field1, field2) VALUES ('" + key + "', '" + value + "')");
   }
}

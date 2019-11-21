package org.mike;

import java.nio.file.Path;
import java.util.Arrays;
import org.apache.accumulo.core.client.TableExistsException;
import org.apache.commons.lang3.StringUtils;
import org.apache.accumulo.core.client.Accumulo;
import org.apache.accumulo.core.client.AccumuloClient;


/**
 * Created by miller on 3/30/17.
 */
public class MikeTest {

  public static void main (String[] args) throws Exception {

    String clientPath = "/local/uno/install/accumulo-2.1.0-SNAPSHOT/conf/";
    AccumuloClient client = Accumulo.newClient()
            .from(Path.of(clientPath,"accumulo-client.properties"))
            .build();
    try {
      client.tableOperations().create("newTable");
    } catch (TableExistsException e) {
      System.out.println("newTable exists");
    }
    System.out.println("All tables: " + Arrays.toString(client.tableOperations().list().toArray()));
    client.close();

    String nullStr = null;
    String emptyStr = "";
    String blankStr = " ";
    String str = "a";

    System.out.println("StringUtils.isBlank(nullStr) = " + StringUtils.isBlank(nullStr));
    System.out.println("StringUtils.isBlank(emptyStr) = " + StringUtils.isBlank(emptyStr));
    System.out.println("StringUtils.isBlank(blankStr) = " + StringUtils.isBlank(blankStr));
    System.out.println("StringUtils.isBlank(str) = " + StringUtils.isBlank(str));

  }
}

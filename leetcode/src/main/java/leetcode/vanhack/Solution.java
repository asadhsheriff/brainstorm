package leetcode.vanhack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Result {

  /*
   * Complete the 'getTransactions' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER userId
   *  2. INTEGER locationId
   *  3. INTEGER netStart
   *  4. INTEGER netEnd
   *
   *  https://jsonmock.hackerrank.com/api/transactions/search?userId=
   */

  private static final String FETCH_URL =
      "https://jsonmock.hackerrank.com/api/transactions/search?userId=";

  private static final String QUERY_PARAM_PAGENUM = "page";

  private static final String AND = "&";

  private static final String EQUAL = "=";

  private static final String HTTP_METHOD_GET = "GET";

  public static int getTransactions(int userId, int locationId, int netStart, int netEnd) {
    getNextPageUserTxns(userId, 1);
    return 0;
  }

  private static String getUserTxnInPages(int userId) {

    return "";
  }

  private static void getNextPageUserTxns(int userId, int pageToFetch) {
    try {
      // open the connection
      HttpURLConnection getUserHttpConnection =
          (HttpURLConnection)
              new URL(FETCH_URL + userId + AND + QUERY_PARAM_PAGENUM + EQUAL + pageToFetch)
                  .openConnection();
      getUserHttpConnection.setRequestMethod(HTTP_METHOD_GET);

      getUserHttpConnection.setRequestProperty("Accept", "application/json");

      if (getUserHttpConnection.getResponseCode() == 200) {
        // Building string to convert it to JSON
        BufferedReader reader =
            new BufferedReader(new InputStreamReader((getUserHttpConnection.getInputStream())));
        StringBuilder responseBuilder = new StringBuilder();

        String readLine = "";
        while ((readLine = reader.readLine()) != null) responseBuilder.append(readLine);

        Pattern re =
            Pattern.compile(
                "(?:,|\\{)?([^:]*):(\"[^\"]*\"|\\{[^}]*\\}|[^},]*)",
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
        Pattern dataPattern = Pattern.compile("\\s*\"data\"\\s*:\\s*\"([^,]*)\",");
        Matcher dataMatcher = re.matcher(responseBuilder.toString());

        System.out.println(responseBuilder.toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {

    int userId = 2;
    int locationId = 0;
    int netStart = 0;
    int netEnd = 0;
    //    int result = Result.getTransactions(userId, locationId, netStart, netEnd);
    String a =
        "{\"page\":\"1\",\"per_page\":10,\"total\":76,\"total_pages\":8,\"data\":[{\"id\":2,\"userId\":2,\"userName\":\"Bob Martin\",\"timestamp\":1549260902604,\"txnType\":\"debit\",\"amount\":\"$3,574.95\",\"location\":{\"id\":8,\"address\":\"389, Everest, Barwell Terrace\",\"city\":\"Murillo\",\"zipCode\":66061},\"ip\":\"212.215.115.165\"},{\"id\":4,\"userId\":2,\"userName\":\"Bob Martin\",\"timestamp\":1549272069586,\"txnType\":\"debit\",\"amount\":\"$0.87\",\"location\":{\"id\":8,\"address\":\"389, Everest, Barwell Terrace\",\"city\":\"Murillo\",\"zipCode\":66061},\"ip\":\"119.162.205.226\"},{\"id\":10,\"userId\":2,\"userName\":\"Bob Martin\",\"timestamp\":1552863189963,\"txnType\":\"debit\",\"amount\":\"$3,611.80\",\"location\":{\"id\":1,\"address\":\"948, Entroflex, Franklin Avenue\",\"city\":\"Ilchester\",\"zipCode\":84181},\"ip\":\"212.215.115.165\"},{\"id\":18,\"userId\":2,\"userName\":\"Bob Martin\",\"timestamp\":1550143522252,\"txnType\":\"debit\",\"amount\":\"$2,235.13\",\"location\":{\"id\":1,\"address\":\"948, Entroflex, Franklin Avenue\",\"city\":\"Ilchester\",\"zipCode\":84181},\"ip\":\"111.83.155.103\"},{\"id\":19,\"userId\":2,\"userName\":\"Bob Martin\",\"timestamp\":1552070436910,\"txnType\":\"credit\",\"amount\":\"$2,659.47\",\"location\":{\"id\":6,\"address\":\"206, Portaline, Brooklyn Avenue\",\"city\":\"Brownlee\",\"zipCode\":80358},\"ip\":\"212.215.115.165\"},{\"id\":20,\"userId\":2,\"userName\":\"Bob Martin\",\"timestamp\":1546523118910,\"txnType\":\"debit\",\"amount\":\"$1,543.25\",\"location\":{\"id\":9,\"address\":\"961, Neptide, Elliott Walk\",\"city\":\"Bourg\",\"zipCode\":68602},\"ip\":\"142.216.23.1\"},{\"id\":24,\"userId\":2,\"userName\":\"Bob Martin\",\"timestamp\":1546530515282,\"txnType\":\"debit\",\"amount\":\"$2,201.65\",\"location\":{\"id\":6,\"address\":\"206, Portaline, Brooklyn Avenue\",\"city\":\"Brownlee\",\"zipCode\":80358},\"ip\":\"142.216.23.1\"},{\"id\":33,\"userId\":2,\"userName\":\"Bob Martin\",\"timestamp\":1549507438915,\"txnType\":\"debit\",\"amount\":\"$2,898.16\",\"location\":{\"id\":8,\"address\":\"389, Everest, Barwell Terrace\",\"city\":\"Murillo\",\"zipCode\":66061},\"ip\":\"119.162.205.226\"},{\"id\":42,\"userId\":2,\"userName\":\"Bob Martin\",\"timestamp\":1548791324284,\"txnType\":\"credit\",\"amount\":\"$2,084.06\",\"location\":{\"id\":6,\"address\":\"206, Portaline, Brooklyn Avenue\",\"city\":\"Brownlee\",\"zipCode\":80358},\"ip\":\"142.216.23.1\"},{\"id\":43,\"userId\":2,\"userName\":\"Bob Martin\",\"timestamp\":1550842200606,\"txnType\":\"credit\",\"amount\":\"$3,844.66\",\"location\":{\"id\":1,\"address\":\"948, Entroflex, Franklin Avenue\",\"city\":\"Ilchester\",\"zipCode\":84181},\"ip\":\"212.215.115.165\"}]}";
    Pattern total = Pattern.compile("\"total\"\\s*:\\s*\\d+,");
    Pattern totalPages = Pattern.compile("\"total\"\\s*:\\s*\\d+,");
    Matcher dataMatcher = totalPages.matcher(a);
    //    Pattern dataPattern = Pattern.compile(".*\"data\": .*", Pattern.CASE_INSENSITIVE);
    //    Matcher dataMatcher = dataPattern.matcher(a);
    //    System.out.println("134".matches());
  }
}

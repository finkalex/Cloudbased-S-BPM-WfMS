package at.fhjoanneum.ippr.communicator.plugins.send;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import at.fhjoanneum.ippr.communicator.global.GlobalKey;

public class JsonSendPlugin implements SendPlugin {

  private static final Logger LOG = LoggerFactory.getLogger(JsonSendPlugin.class);

  @Override
  public boolean send(final String body, final Map<String, String> configuration) {
    try {
      final String endpoint = configuration.get(GlobalKey.ENDPOINT);
      final URL obj = new URL(endpoint);
      final HttpURLConnection con = (HttpURLConnection) obj.openConnection();

      con.setRequestMethod("POST");
      con.setRequestProperty("Content-Type", "application/json");
      con.setDoOutput(true);

      LOG.debug("Send [{}] to [{}]", body, endpoint);

      final DataOutputStream wr = new DataOutputStream(con.getOutputStream());
      wr.writeBytes(body);
      wr.flush();
      wr.close();

      final int responseCode = con.getResponseCode();
      if (responseCode == HttpStatus.OK.value()) {
        return true;
      }
      return false;
    } catch (final Exception e) {
      LOG.error(e.getMessage());
      return false;
    }
  }
}

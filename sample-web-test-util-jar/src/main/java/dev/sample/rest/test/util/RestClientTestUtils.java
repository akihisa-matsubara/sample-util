package dev.sample.rest.test.util;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import lombok.experimental.UtilityClass;
import org.apache.cxf.jaxrs.provider.jsrjsonp.JsrJsonpProvider;

/**
 * Rest Client テスト用 ユーティリティー.
 */
@UtilityClass
public class RestClientTestUtils {

  /**
   * テスト用のRest Clientを作成します.
   *
   * @return {@link Client}
   */
  public static Client newClient() {
    Client client = ClientBuilder.newClient();
    client.register(JsrJsonpProvider.class);
    return client;
  }

}

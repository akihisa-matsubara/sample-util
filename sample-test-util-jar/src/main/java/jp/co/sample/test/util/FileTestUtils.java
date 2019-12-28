package jp.co.sample.test.util;

import jp.co.sample.test.exception.TestRuntimeException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.experimental.UtilityClass;

/**
 * テスト用ファイルユーティリティー.
 */
@UtilityClass
public class FileTestUtils {

  /**
   * ファイルを削除します.
   *
   * @param filePath ファイルパス
   * @param fileName ファイル名
   */
  public static void deleteFile(String filePath, String fileName) {
    try {
      Path target = Paths.get(filePath, fileName);
      if (target.toFile().exists()) {
        Files.delete(target);
      }
    } catch (IOException ioe) {
      throw new TestRuntimeException(ioe);
    }
  }

}

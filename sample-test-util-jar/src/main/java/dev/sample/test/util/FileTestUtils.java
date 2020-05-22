package dev.sample.test.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.experimental.UtilityClass;
import dev.sample.test.exception.TestRuntimeException;

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

package dev.sample.test.util;

import lombok.experimental.UtilityClass;
import dev.sample.test.exception.TestRuntimeException;

/**
 * テスト用クラスユーティリティー.
 */
@UtilityClass
public class ClassTestUtils {

  /**
   * 指定したクラス名のクラスを取得します.
   *
   * @param className クラス名
   * @return クラス、指定されたクラス名がnullの場合はnullを返す
   */
  public static Class<?> forName(String className) {
    try {
      return className == null ? null : Class.forName(className);
    } catch (ClassNotFoundException e) {
      throw new TestRuntimeException(e);
    }
  }

}

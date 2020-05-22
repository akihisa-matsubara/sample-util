package dev.sample.test.util;

import lombok.experimental.UtilityClass;

/**
 * テスト用文字列ユーティリティー.
 */
@UtilityClass
public class StringTestUtils {

  /**
   * 文字列配列に分割します（区切り文字はカンマ","）.
   *
   * @param str 文字列
   * @return 分割済みの文字列配列、文字列がnullの場合は空の配列
   */
  public static String[] split(final String str) {
    return split(str, ",");
  }


  /**
   * 文字列配列に分割します.
   *
   * @param str 文字列
   * @param delimiter 区切り文字
   * @return 分割済みの文字列配列、文字列がnullの場合は空の配列
   */
  public static String[] split(final String str, String delimiter) {
    if (str == null) {
      return new String[0];
    }

    return str.split(delimiter, -1);
  }

}

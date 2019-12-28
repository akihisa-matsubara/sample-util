package jp.co.sample.test.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.experimental.UtilityClass;

/**
 * テスト用LocalDateTimeユーティリティー.
 */
@UtilityClass
public class LocalDateTimeTestUtils {

  /**
   * 文字列から{@code LocalDateTime}のインスタンスを取得します.
   * フォーマット: yyyy-MM-dd'T'HH:mm:ss.SSS.
   * (ex. 2014-09-30T06:30:15.123)
   *
   * @param str 文字列
   * @return LocaleDateTIme、指定された文字列がnullの場合はnullを返す
   */
  public static LocalDateTime parse(String str) {
    return str == null ? null : LocalDateTime.parse(str, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
  }

}

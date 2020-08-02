package dev.sample.common.util;

import dev.sample.common.util.DateFormat.DateFormatVo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import lombok.experimental.UtilityClass;

/**
 * 日付ユーティリティー(LocaleDateTIme).
 */
// DateTimeFormatterはスレッドセーフなので定数定義してもよい.ただし、STRICT設定すること.
@UtilityClass
public class LocalDateTimeFormatUtils {

  /**
   * Dateを指定フォーマットにフォーマットします.
   *
   * @param dateTime 日時文字列にフォーマットする時刻値
   * @param format 日付フォーマットVO
   * @return フォーマットされた日時文字列、指定された時刻値がnullの場合は空文字を返す
   */
  public static String format(LocalDateTime dateTime, DateFormatVo format) {
    return dateTime == null ? "" : dateTime.format(DateTimeFormatter.ofPattern(format.getApiCode()));
  }

  /**
   * 指定された文字列を解析して時刻値を生成します.
   *
   * @param text 日時文字列
   * @param format 日付フォーマットVO
   * @return 文字列から解析される時刻値、日時文字列がnullの場合はnullを返す
   * @throws DateTimeParseException 指定された文字列が解析できない場合
   */
  public static LocalDateTime parse(String text, DateFormatVo format) {
    if (text == null) {
      return null;
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format.getApiCode()).withResolverStyle(ResolverStyle.STRICT);
    return LocalDateTime.parse(text, formatter);
  }

}

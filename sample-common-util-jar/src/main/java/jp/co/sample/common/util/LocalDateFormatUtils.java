package jp.co.sample.common.util;

import jp.co.sample.common.code.DateFormat.DateFormatVo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import lombok.experimental.UtilityClass;

/**
 * 日付ユーティリティー(LocalDate).
 */
// DateTimeFormatterはスレッドセーフなので定数定義してもよい.ただし、STRICT設定すること.
@UtilityClass
public class LocalDateFormatUtils {

  /**
   * Dateを指定フォーマットにフォーマットします.
   *
   * @param date 日付文字列にフォーマットする時刻値
   * @param format 日付フォーマットVO
   * @return フォーマットされた日時文字列、指定された時刻値がnullの場合は空文字を返す
   */
  public static String format(LocalDate date, DateFormatVo format) {
    return date == null ? "" : date.format(DateTimeFormatter.ofPattern(format.getApiCode()));
  }

  /**
   * 指定された文字列を解析して時刻値を生成します.
   *
   * @param text 日付文字列
   * @param format 日付フォーマットVO
   * @return 文字列から解析される時刻値、日付文字列がnullの場合はnullを返す
   * @throws DateTimeParseException 指定された文字列が解析できない場合
   */
  public static LocalDate parse(String text, DateFormatVo format) {
    if (text == null) {
      return null;
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format.getApiCode());
    formatter.withResolverStyle(ResolverStyle.STRICT);
    return LocalDate.parse(text, formatter);
  }

}

package dev.sample.common.util;

import dev.sample.common.code.CodeVo;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 日付フォーマット定数.
 * アノテーション属性のようにenumが利用できない定数式にのみ利用する.
 * 原則用意されたVoを利用する.
 *
 * @see DateFormatVo
 */
public final class DateFormat {

  /** yyyy-MM-dd. */
  public static final String YYYYMMDD = "yyyy-MM-dd";

  /** yyyy-MM-dd'T'HH:mm:ss.SSS. */
  public static final String YYYYMMDDTHHMMSSSSS = "yyyy-MM-dd'T'HH:mm:ss.SSS";

  /**
   * デフォルトコンストラクタ.
   */
  private DateFormat() {
    // do nothing
  }

  /**
   * 日付フォーマットVO.
   */
  @AllArgsConstructor
  @Getter
  public enum DateFormatVo implements CodeVo {

    /** yyyy-MM-dd. */
    YYYYMMDD(DateFormat.YYYYMMDD, "uuuu-MM-dd", "YYYYMMDD"),
    /** yyyyMMdd. */
    YYYYMMDD_NO_DELIMITER("yyyyMMdd", "uuuuMMdd", "YYYYMMDD_NO_DELIMITER"),
    /** yyyy-MM-dd'T'HH:mm:ss.SSS. */
    YYYYMMDDTHHMMSSSSS(DateFormat.YYYYMMDDTHHMMSSSSS, "uuuu-MM-dd'T'HH:mm:ss.SSS", "YYYYMMDDTHHMMSSSSS"),
    // /** yyyyMMddHHmmssSSS. */
    // NOTE: DateTimeFormatter won't parse dates with custom format "yyyyMMddHHmmssSSS"
    // https://bugs.openjdk.java.net/browse/JDK-8031085
    // Fix Version: 9, IBM Java 8 is OK.
    // YYYYMMDDHHMMSSSSS_NO_DELIMITER("yyyyMMddHHmmssSSS", "uuuuMMddHHmmssSSS", "YYYYMMDDHHMMSSSSS_NO_DELIMITER"),
    /** HHmmssSSS. */
    HHMMSSSSS_NO_DELIMITER("HHmmssSSS", "HHmmssSSS", "HHMMSSSSS_NO_DELIMITER"),
    ;

    /** コード. */
    private String code;

    /** Date and Time APIコード. */
    private String apiCode;

    /** デコード. */
    private String decode;

  }

}

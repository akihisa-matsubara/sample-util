package dev.sample.common.util;

import static org.assertj.core.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import dev.sample.common.util.DateFormat.DateFormatVo;
import dev.sample.test.util.ClassTestUtils;
import dev.sample.test.util.LocalDateTimeTestUtils;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LocalDateTimeFormatUtilsTest {

  @DisplayName("format(LocalDateTime dateTime, DateFormatVo format)のテスト")
  @Nested
  class Format {
    @DisplayName("正常系")
    @ParameterizedTest
    @CsvSource({
        "文字列変換できていること(yyyy-MM-dd形式),                2014-09-30,              2014-09-30T06:30:15.123, yyyy-MM-dd",
        "文字列変換できていること(yyyyMMdd形式),                  20140930,                2014-09-30T06:30:15.123, yyyyMMdd",
        "文字列変換できていること(yyyy-MM-dd'T'HH:mm:ss.SSS形式), 2014-09-30T06:30:15.123, 2014-09-30T06:30:15.123, yyyy-MM-dd'T'HH:mm:ss.SSS",
        "文字列変換できていること(HHmmssSSS形式),                 063015123,               2014-09-30T06:30:15.123, HHmmssSSS",
        "nullの場合は空文字であること,                            '',                      ,                        yyyy-MM-dd",
    })
    void test(String desc, String expected, String dateTimeStr, String formatStr) {
      // --- setup -----
      LocalDateTime dateTime = LocalDateTimeTestUtils.parse(dateTimeStr);
      DateFormatVo format = CodeUtils.decode(formatStr, DateFormatVo.class);

      // --- execute ---
      String actual = LocalDateTimeFormatUtils.format(dateTime, format);

      // --- verify ----
      assertThat(actual).as(desc).isEqualTo(expected);
    }
  }

  @DisplayName("parse(String text, DateFormatVo format)のテスト")
  @Nested
  class Parse {
    @DisplayName("正常系")
    @ParameterizedTest
    @CsvSource({
        "時刻値変換できていること(yyyy-MM-dd'T'HH:mm:ss.SSS形式), 2014-09-30T06:30:15.123, 2014-09-30T06:30:15.123, yyyy-MM-dd'T'HH:mm:ss.SSS",
        "nullの場合はnullであること,                              ,                        ,                        yyyy-MM-dd'T'HH:mm:ss.SSS",
    })
    void test(String desc, String expectedStr, String dateTimeStr, String formatStr) {
      // --- setup -----
      DateFormatVo format = CodeUtils.decode(formatStr, DateFormatVo.class);

      // --- execute ---
      LocalDateTime actual = LocalDateTimeFormatUtils.parse(dateTimeStr, format);

      // --- verify ----
      LocalDateTime expected = LocalDateTimeTestUtils.parse(expectedStr);
      assertThat(actual).as(desc).isEqualTo(expected);
    }

    @DisplayName("異常系")
    @ParameterizedTest
    @CsvSource({
        "指定された文字列が解析できない場合はDateTimeParseExceptionをthrowすること, java.time.format.DateTimeParseException, 2014-09-30, yyyy-MM-dd",
    })
    void abnormalTest(String desc, String expectedThrownClassName, String dateTimeStr, String formatStr) {
      // --- setup -----
      DateFormatVo format = CodeUtils.decode(formatStr, DateFormatVo.class);

      // --- execute ---
      // --- verify ----
      assertThatThrownBy(() -> {
        LocalDateTimeFormatUtils.parse(dateTimeStr, format);
      }).as(desc).isInstanceOf(ClassTestUtils.forName(expectedThrownClassName));
    }
  }
}

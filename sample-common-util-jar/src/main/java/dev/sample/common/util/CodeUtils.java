package dev.sample.common.util;

import dev.sample.common.code.CodeVo;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

/**
 * コード・ユーティリティ.
 */
@UtilityClass
public class CodeUtils {

  /**
   * コード値をコードVOにデコードします.
   *
   * @param <CD> デコード先となるコードの型
   * @param codeValue コード値
   * @param codeType デコード先となるコードの型
   * @return {@link CodeVo} コードVO.
   */
  public static <CD extends CodeVo> CD decode(String codeValue, Class<CD> codeType) {
    if (StringUtils.isEmpty(codeValue)) {
      return null;
    }

    for (CD code : codeType.getEnumConstants()) {
      if (code.getCode().equals(codeValue)) {
        return code;
      }
    }

    throw new IllegalArgumentException(codeValue + " is not found.");
  }

}

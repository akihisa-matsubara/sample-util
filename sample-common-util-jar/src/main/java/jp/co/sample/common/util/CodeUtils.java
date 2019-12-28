package jp.co.sample.common.util;

import jp.co.sample.common.code.CodeVo;
import java.lang.reflect.InvocationTargetException;
import lombok.experimental.UtilityClass;

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
  @SuppressWarnings("unchecked")
  public static <CD extends CodeVo> CD decode(String codeValue, Class<CD> codeType) {
    CD[] values;
    try {
      values = (CD[]) codeType.getMethod("values").invoke(null);
    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
      throw new IllegalArgumentException(e);
    }

    for (CD code : values) {
      if (code.getCode().equals(codeValue)) {
        return code;
      }
    }

    throw new IllegalArgumentException(codeValue + " is not found.");
  }

}

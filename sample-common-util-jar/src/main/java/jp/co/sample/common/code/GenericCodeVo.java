package jp.co.sample.common.code;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 汎用コードVO.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenericCodeVo implements CodeVo, Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** コード. */
  private String code;

  /** デコード. */
  private String decode;

}

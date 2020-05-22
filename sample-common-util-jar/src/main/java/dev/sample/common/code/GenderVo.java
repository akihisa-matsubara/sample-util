package dev.sample.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 性別VO.
 */
@AllArgsConstructor
@Getter
public enum GenderVo implements CodeVo {

  /** 男性. */
  MALE("1", "男性"),
  /** 女性. */
  FEMALE("2", "女性"),
  ;

  /** コード. */
  private String code;

  /** デコード. */
  private String decode;

}

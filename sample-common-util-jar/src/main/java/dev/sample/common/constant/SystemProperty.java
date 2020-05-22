package dev.sample.common.constant;

/**
 * 環境変数.
 */
public final class SystemProperty {

  /** 言語設定. */
  public static final String LANGUAGE = System.getProperty("user.language");

  /**
   * デフォルトコンストラクター.
   */
  private SystemProperty() {
    // do nothing
  }
}

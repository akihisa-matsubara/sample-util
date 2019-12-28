package jp.co.sample.test.exception;

/**
 * テスト実行例外.
 */
public class TestRuntimeException extends RuntimeException {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * デフォルトコンストラクタ.
   *
   * @param cause 例外
   */
  public TestRuntimeException(Throwable cause) {
    super(cause);
  }

}

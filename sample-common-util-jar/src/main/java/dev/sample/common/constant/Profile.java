package dev.sample.common.constant;

/**
 * Profile定数.
 */
public final class Profile {

  /** production, disaster recovery, staging. */
  public static final String PROD = "prod";

  /** system test. */
  public static final String ST = "st";

  /** integration test. */
  public static final String IT = "it";

  /** continuous integration. */
  public static final String CI = "ci";

  /** unit integration test. */
  public static final String UIT = "uit";

  /** unit test. */
  public static final String UT = "ut";

  /** development. */
  public static final String DEV = "dev";

  /**
   * デフォルトコンストラクタ.
   */
  private Profile() {
    // do nothing
  }

}

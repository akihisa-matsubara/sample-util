package jp.co.sample.test.params.provider;

import org.junit.jupiter.params.provider.ArgumentsSource;

/**
 * Excel形式の{@link ArgumentsSource}.
 */
@ArgumentsSource(ExcelArgumentProvider.class)
@interface ExcelSource {

  /**
   * Excelクラスパスリソース.
   *
   * @return Excelクラスパスリソース
   */
  String resource();

}

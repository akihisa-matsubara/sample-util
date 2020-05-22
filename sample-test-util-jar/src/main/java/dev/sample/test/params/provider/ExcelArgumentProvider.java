package dev.sample.test.params.provider;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

/**
 * {@code @ParameterizedTest}メソッドに渡されるExcelリソースを提供する.
 */
public class ExcelArgumentProvider implements ArgumentsProvider, AnnotationConsumer<ExcelSource> {

  /** Excelクラスパスリソース. */
  private String resource;

  /**
   * {@inheritDoc}
   */
  @Override
  public void accept(ExcelSource annotation) {
    this.resource = annotation.resource();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
    // TODO リソース取得実装
    return null;
  }

}

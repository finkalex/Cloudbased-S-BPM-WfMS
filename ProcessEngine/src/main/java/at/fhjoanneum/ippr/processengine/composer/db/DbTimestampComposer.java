package at.fhjoanneum.ippr.processengine.composer.db;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import at.fhjoanneum.ippr.processengine.config.FormatConfig;

@Component
public class DbTimestampComposer implements DbComposer<LocalDateTime> {

  @Override
  public LocalDateTime compose(final String value) {
    return LocalDateTime.parse(value, FormatConfig.TIMESTAMP_FORMAT);
  }

  @Override
  public boolean canCompose(final String value) {
    try {
      LocalDateTime.parse(value, FormatConfig.TIMESTAMP_FORMAT);
      return true;
    } catch (final Exception e) {
      return false;
    }
  }

}

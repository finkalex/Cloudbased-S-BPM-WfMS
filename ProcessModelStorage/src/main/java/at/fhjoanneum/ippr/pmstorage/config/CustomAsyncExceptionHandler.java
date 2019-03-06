package at.fhjoanneum.ippr.pmstorage.config;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

  private static final Logger LOG = LoggerFactory.getLogger(CustomAsyncExceptionHandler.class);

  @Override
  public void handleUncaughtException(final Throwable throwable, final Method method,
      final Object... params) {
    throwable.printStackTrace();
    if (throwable.getCause() != null) {
      LOG.error("Exception message - " + throwable.getCause().getMessage());
    } else {
      LOG.error("Exception message - " + throwable.getMessage());
    }
    LOG.error("Method name - " + method.getName());
    for (final Object param : params) {
      LOG.error("Parameter value - " + param);
    }
  }

}

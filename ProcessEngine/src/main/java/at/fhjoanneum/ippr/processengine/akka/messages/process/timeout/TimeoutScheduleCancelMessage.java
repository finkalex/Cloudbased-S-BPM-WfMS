package at.fhjoanneum.ippr.processengine.akka.messages.process.timeout;

public class TimeoutScheduleCancelMessage {

  private final Long ssId;

  public TimeoutScheduleCancelMessage(final Long ssId) {
    this.ssId = ssId;
  }

  public Long getSsId() {
    return ssId;
  }
}

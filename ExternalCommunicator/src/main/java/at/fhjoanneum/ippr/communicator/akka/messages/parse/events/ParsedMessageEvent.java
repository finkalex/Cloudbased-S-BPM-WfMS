package at.fhjoanneum.ippr.communicator.akka.messages.parse.events;

import at.fhjoanneum.ippr.communicator.akka.messages.AbstractEvent;

public class ParsedMessageEvent extends AbstractEvent {

  private final Long id;

  public ParsedMessageEvent(final String actorId, final Long id) {
    super(actorId);
    this.id = id;
  }

  public Long getId() {
    return id;
  }
}

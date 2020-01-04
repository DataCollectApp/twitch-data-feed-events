package app.datacollect.twitchdata.feed.events;

public class Event {

  private final EventData eventData;
  private final Metadata metadata;

  public Event(EventData eventData, Metadata metadata) {
    this.eventData = eventData;
    this.metadata = metadata;
  }

  public EventData getEventData() {
    return eventData;
  }

  public Metadata getMetadata() {
    return metadata;
  }
}

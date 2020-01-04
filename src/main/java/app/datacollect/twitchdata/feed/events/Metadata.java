package app.datacollect.twitchdata.feed.events;

import java.util.UUID;

public class Metadata {

  private final UUID eventId;
  private final String author;

  public Metadata(UUID eventId, String author) {
    this.eventId = eventId;
    this.author = author;
  }

  public UUID getEventId() {
    return eventId;
  }

  public String getAuthor() {
    return author;
  }
}

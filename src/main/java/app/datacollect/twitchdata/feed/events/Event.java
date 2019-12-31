package app.datacollect.twitchdata.feed.events;

import org.json.JSONObject;

public abstract class Event {
  public abstract EventType getEventType();

  public abstract ObjectType getObjectType();

  public abstract Version getVersion();

  public abstract JSONObject toJson();
}

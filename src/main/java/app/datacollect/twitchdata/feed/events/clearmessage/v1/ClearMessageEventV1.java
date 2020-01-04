package app.datacollect.twitchdata.feed.events.clearmessage.v1;

import app.datacollect.twitchdata.feed.events.EventData;
import app.datacollect.twitchdata.feed.events.EventType;
import app.datacollect.twitchdata.feed.events.ObjectType;
import app.datacollect.twitchdata.feed.events.Version;
import java.util.UUID;
import org.json.JSONObject;

public class ClearMessageEventV1 extends EventData {

  private final UUID id;
  private final String targetUsername;
  private final String channel;
  private final String message;
  private final String time;

  public ClearMessageEventV1(
      UUID id, String targetUsername, String channel, String message, String time) {
    this.id = id;
    this.targetUsername = targetUsername;
    this.channel = channel;
    this.message = message;
    this.time = time;
  }

  public ClearMessageEventV1(JSONObject jsonObject) {
    this.id = UUID.fromString(jsonObject.getString("id"));
    this.targetUsername = jsonObject.getString("targetUsername");
    this.channel = jsonObject.getString("channel");
    this.message = jsonObject.getString("message");
    this.time = jsonObject.getString("time");
  }

  public UUID getId() {
    return id;
  }

  public String getTargetUsername() {
    return targetUsername;
  }

  public String getChannel() {
    return channel;
  }

  public String getMessage() {
    return message;
  }

  public String getTime() {
    return time;
  }

  @Override
  public EventType getEventType() {
    return EventType.CLEAR_MESSAGE_SNAPSHOT;
  }

  @Override
  public ObjectType getObjectType() {
    return ObjectType.CLEAR_MESSAGE;
  }

  @Override
  public Version getVersion() {
    return Version.V1;
  }

  @Override
  public JSONObject toJson() {
    return new JSONObject()
        .put("id", id.toString())
        .put("targetUsername", targetUsername)
        .put("channel", channel)
        .put("message", message)
        .put("time", time);
  }
}

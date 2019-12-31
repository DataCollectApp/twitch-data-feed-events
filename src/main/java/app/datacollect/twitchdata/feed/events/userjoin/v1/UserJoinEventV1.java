package app.datacollect.twitchdata.feed.events.userjoin.v1;

import app.datacollect.twitchdata.feed.events.Event;
import app.datacollect.twitchdata.feed.events.EventType;
import app.datacollect.twitchdata.feed.events.ObjectType;
import app.datacollect.twitchdata.feed.events.Version;
import java.util.UUID;
import org.json.JSONObject;

public class UserJoinEventV1 extends Event {

  private final UUID id;
  private final String username;
  private final String channel;
  private final String time;

  public UserJoinEventV1(UUID id, String username, String channel, String time) {
    this.id = id;
    this.username = username;
    this.channel = channel;
    this.time = time;
  }

  public UserJoinEventV1(JSONObject jsonObject) {
    this.id = UUID.fromString(jsonObject.getString("id"));
    this.username = jsonObject.getString("username");
    this.channel = jsonObject.getString("channel");
    this.time = jsonObject.getString("time");
  }

  public UUID getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getChannel() {
    return channel;
  }

  public String getTime() {
    return time;
  }

  @Override
  public EventType getEventType() {
    return EventType.USER_JOIN_SNAPSHOT;
  }

  @Override
  public ObjectType getObjectType() {
    return ObjectType.USER_JOIN;
  }

  @Override
  public Version getVersion() {
    return Version.V1;
  }

  @Override
  public JSONObject toJson() {
    return new JSONObject()
        .put("id", id.toString())
        .put("username", username)
        .put("channel", channel)
        .put("time", time);
  }
}

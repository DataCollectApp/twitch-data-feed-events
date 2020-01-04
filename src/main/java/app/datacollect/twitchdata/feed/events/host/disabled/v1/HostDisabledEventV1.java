package app.datacollect.twitchdata.feed.events.host.disabled.v1;

import app.datacollect.twitchdata.feed.events.EventData;
import app.datacollect.twitchdata.feed.events.EventType;
import app.datacollect.twitchdata.feed.events.ObjectType;
import app.datacollect.twitchdata.feed.events.Version;
import java.util.UUID;
import org.json.JSONObject;

public class HostDisabledEventV1 extends EventData {

  private final UUID id;
  private final String channel;
  private final String time;

  public HostDisabledEventV1(UUID id, String channel, String time) {
    this.id = id;
    this.channel = channel;
    this.time = time;
  }

  public HostDisabledEventV1(JSONObject jsonObject) {
    this.id = UUID.fromString(jsonObject.getString("id"));
    this.channel = jsonObject.getString("channel");
    this.time = jsonObject.getString("time");
  }

  public UUID getId() {
    return id;
  }

  public String getChannel() {
    return channel;
  }

  public String getTime() {
    return time;
  }

  @Override
  public EventType getEventType() {
    return EventType.HOST_DISABLED;
  }

  @Override
  public ObjectType getObjectType() {
    return ObjectType.HOST;
  }

  @Override
  public Version getVersion() {
    return Version.V1;
  }

  @Override
  public JSONObject toJson() {
    return new JSONObject().put("id", id.toString()).put("channel", channel).put("time", time);
  }
}

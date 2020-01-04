package app.datacollect.twitchdata.feed.events.host.enabled.v1;

import app.datacollect.twitchdata.feed.events.EventData;
import app.datacollect.twitchdata.feed.events.EventType;
import app.datacollect.twitchdata.feed.events.ObjectType;
import app.datacollect.twitchdata.feed.events.Version;
import java.util.UUID;
import org.json.JSONObject;

public class HostEnabledEventV1 extends EventData {

  private final UUID id;
  private final String channel;
  private final String targetChannel;
  private final String time;

  public HostEnabledEventV1(UUID id, String channel, String targetChannel, String time) {
    this.id = id;
    this.channel = channel;
    this.targetChannel = targetChannel;
    this.time = time;
  }

  public HostEnabledEventV1(JSONObject jsonObject) {
    this.id = UUID.fromString(jsonObject.getString("id"));
    this.channel = jsonObject.getString("channel");
    this.targetChannel = jsonObject.getString("targetChannel");
    this.time = jsonObject.getString("time");
  }

  public UUID getId() {
    return id;
  }

  public String getChannel() {
    return channel;
  }

  public String getTargetChannel() {
    return targetChannel;
  }

  public String getTime() {
    return time;
  }

  @Override
  public EventType getEventType() {
    return EventType.HOST_ENABLED;
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
    return new JSONObject()
        .put("id", id.toString())
        .put("channel", channel)
        .put("targetChannel", targetChannel)
        .put("time", time);
  }
}

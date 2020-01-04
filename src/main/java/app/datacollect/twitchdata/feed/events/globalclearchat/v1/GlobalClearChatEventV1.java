package app.datacollect.twitchdata.feed.events.globalclearchat.v1;

import app.datacollect.twitchdata.feed.events.EventData;
import app.datacollect.twitchdata.feed.events.EventType;
import app.datacollect.twitchdata.feed.events.ObjectType;
import app.datacollect.twitchdata.feed.events.Version;
import java.util.UUID;
import org.json.JSONObject;

public class GlobalClearChatEventV1 extends EventData {

  private final UUID id;
  private final String channel;
  private final long roomId;
  private final String time;

  public GlobalClearChatEventV1(UUID id, String channel, long roomId, String time) {
    this.id = id;
    this.channel = channel;
    this.roomId = roomId;
    this.time = time;
  }

  public GlobalClearChatEventV1(JSONObject jsonObject) {
    this.id = UUID.fromString(jsonObject.getString("id"));
    this.channel = jsonObject.getString("channel");
    this.roomId = jsonObject.getLong("roomId");
    this.time = jsonObject.getString("time");
  }

  public UUID getId() {
    return id;
  }

  public String getChannel() {
    return channel;
  }

  public long getRoomId() {
    return roomId;
  }

  public String getTime() {
    return time;
  }

  @Override
  public EventType getEventType() {
    return EventType.GLOBAL_CLEAR_CHAT_SNAPSHOT;
  }

  @Override
  public ObjectType getObjectType() {
    return ObjectType.GLOBAL_CLEAR_CHAT;
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
        .put("roomId", roomId)
        .put("time", time);
  }
}

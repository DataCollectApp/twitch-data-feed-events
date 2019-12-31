package app.datacollect.twitchdata.feed.events.clearchat.v1;

import app.datacollect.twitchdata.feed.events.Event;
import app.datacollect.twitchdata.feed.events.EventType;
import app.datacollect.twitchdata.feed.events.ObjectType;
import app.datacollect.twitchdata.feed.events.Version;
import java.util.UUID;
import org.json.JSONObject;

public class ClearChatEventV1 extends Event {

  private final UUID id;
  private final String targetUsername;
  private final String targetUserId;
  private final String channel;
  private final long roomId;
  private final long seconds;
  private final String time;

  public ClearChatEventV1(
      UUID id,
      String targetUsername,
      String targetUserId,
      String channel,
      long roomId,
      long seconds,
      String time) {
    this.id = id;
    this.targetUsername = targetUsername;
    this.targetUserId = targetUserId;
    this.channel = channel;
    this.roomId = roomId;
    this.seconds = seconds;
    this.time = time;
  }

  public ClearChatEventV1(JSONObject jsonObject) {
    this.id = UUID.fromString(jsonObject.getString("id"));
    this.targetUsername = jsonObject.getString("targetUsername");
    this.targetUserId = jsonObject.getString("targetUserId");
    this.channel = jsonObject.getString("channel");
    this.roomId = jsonObject.getLong("roomId");
    this.seconds = jsonObject.getLong("seconds");
    this.time = jsonObject.getString("time");
  }

  public UUID getId() {
    return id;
  }

  public String getTargetUsername() {
    return targetUsername;
  }

  public String getTargetUserId() {
    return targetUserId;
  }

  public String getChannel() {
    return channel;
  }

  public long getRoomId() {
    return roomId;
  }

  public long getSeconds() {
    return seconds;
  }

  public String getTime() {
    return time;
  }

  @Override
  public EventType getEventType() {
    return EventType.CLEAR_CHAT_SNAPSHOT;
  }

  @Override
  public ObjectType getObjectType() {
    return ObjectType.CLEAR_CHAT;
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
        .put("targetUserId", targetUserId)
        .put("channel", channel)
        .put("roomId", roomId)
        .put("seconds", seconds)
        .put("time", time);
  }
}

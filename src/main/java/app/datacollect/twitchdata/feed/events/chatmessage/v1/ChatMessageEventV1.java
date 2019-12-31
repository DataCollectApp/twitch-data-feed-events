package app.datacollect.twitchdata.feed.events.chatmessage.v1;

import app.datacollect.twitchdata.feed.events.Event;
import app.datacollect.twitchdata.feed.events.EventType;
import app.datacollect.twitchdata.feed.events.ObjectType;
import app.datacollect.twitchdata.feed.events.Version;
import java.util.UUID;
import org.json.JSONObject;

public class ChatMessageEventV1 extends Event {

  private final UUID id;
  private final String username;
  private final String displayName;
  private final String message;
  private final String channel;
  private final long userId;
  private final long roomId;
  private final boolean mod;
  private final boolean subscriber;
  private final boolean turbo;
  private final String time;

  public ChatMessageEventV1(
      UUID id,
      String username,
      String displayName,
      String message,
      String channel,
      long userId,
      long roomId,
      boolean mod,
      boolean subscriber,
      boolean turbo,
      String time) {
    this.id = id;
    this.username = username;
    this.displayName = displayName;
    this.message = message;
    this.channel = channel;
    this.userId = userId;
    this.roomId = roomId;
    this.mod = mod;
    this.subscriber = subscriber;
    this.turbo = turbo;
    this.time = time;
  }

  public ChatMessageEventV1(JSONObject jsonObject) {
    this.id = UUID.fromString(jsonObject.getString("id"));
    this.username = jsonObject.getString("username");
    this.displayName =
        jsonObject.has("displayName") ? jsonObject.getString("displayName") : username;
    this.message = jsonObject.getString("message");
    this.channel = jsonObject.getString("channel");
    this.userId = jsonObject.getLong("userId");
    this.roomId = jsonObject.getLong("roomId");
    this.mod = jsonObject.has("mod") && jsonObject.getBoolean("mod");
    this.subscriber = jsonObject.has("subscriber") && jsonObject.getBoolean("subscriber");
    this.turbo = jsonObject.has("turbo") && jsonObject.getBoolean("turbo");
    this.time = jsonObject.getString("time");
  }

  public UUID getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getDisplayName() {
    return displayName;
  }

  public String getMessage() {
    return message;
  }

  public String getChannel() {
    return channel;
  }

  public long getUserId() {
    return userId;
  }

  public long getRoomId() {
    return roomId;
  }

  public boolean isMod() {
    return mod;
  }

  public boolean isSubscriber() {
    return subscriber;
  }

  public boolean isTurbo() {
    return turbo;
  }

  public String getTime() {
    return time;
  }

  @Override
  public EventType getEventType() {
    return EventType.CHAT_MESSAGE_SNAPSHOT;
  }

  @Override
  public ObjectType getObjectType() {
    return ObjectType.CHAT_MESSAGE;
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
        .put("displayName", displayName)
        .put("message", message)
        .put("channel", channel)
        .put("userId", userId)
        .put("roomId", roomId)
        .put("mod", mod)
        .put("subscriber", subscriber)
        .put("turbo", turbo)
        .put("time", time);
  }
}

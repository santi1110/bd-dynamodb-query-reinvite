package com.amazon.ata.dynamodbquery.activity;

import com.amazon.ata.dynamodbquery.dao.EventAnnouncementDao;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetEventAnnouncementsBetweenDatesActivity_Factory
    implements Factory<GetEventAnnouncementsBetweenDatesActivity> {
  private final Provider<EventAnnouncementDao> eventAnnouncementDaoProvider;

  public GetEventAnnouncementsBetweenDatesActivity_Factory(
      Provider<EventAnnouncementDao> eventAnnouncementDaoProvider) {
    this.eventAnnouncementDaoProvider = eventAnnouncementDaoProvider;
  }

  @Override
  public GetEventAnnouncementsBetweenDatesActivity get() {
    return new GetEventAnnouncementsBetweenDatesActivity(eventAnnouncementDaoProvider.get());
  }

  public static GetEventAnnouncementsBetweenDatesActivity_Factory create(
      Provider<EventAnnouncementDao> eventAnnouncementDaoProvider) {
    return new GetEventAnnouncementsBetweenDatesActivity_Factory(eventAnnouncementDaoProvider);
  }
}

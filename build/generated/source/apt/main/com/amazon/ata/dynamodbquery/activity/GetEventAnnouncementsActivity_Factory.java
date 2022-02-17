package com.amazon.ata.dynamodbquery.activity;

import com.amazon.ata.dynamodbquery.dao.EventAnnouncementDao;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetEventAnnouncementsActivity_Factory
    implements Factory<GetEventAnnouncementsActivity> {
  private final Provider<EventAnnouncementDao> eventAnnouncementDaoProvider;

  public GetEventAnnouncementsActivity_Factory(
      Provider<EventAnnouncementDao> eventAnnouncementDaoProvider) {
    this.eventAnnouncementDaoProvider = eventAnnouncementDaoProvider;
  }

  @Override
  public GetEventAnnouncementsActivity get() {
    return new GetEventAnnouncementsActivity(eventAnnouncementDaoProvider.get());
  }

  public static GetEventAnnouncementsActivity_Factory create(
      Provider<EventAnnouncementDao> eventAnnouncementDaoProvider) {
    return new GetEventAnnouncementsActivity_Factory(eventAnnouncementDaoProvider);
  }
}

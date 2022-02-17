package com.amazon.ata.dynamodbquery.activity;

import com.amazon.ata.dynamodbquery.dao.EventAnnouncementDao;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CreateEventAnnouncementActivity_Factory
    implements Factory<CreateEventAnnouncementActivity> {
  private final Provider<EventAnnouncementDao> eventAnnouncementDaoProvider;

  public CreateEventAnnouncementActivity_Factory(
      Provider<EventAnnouncementDao> eventAnnouncementDaoProvider) {
    this.eventAnnouncementDaoProvider = eventAnnouncementDaoProvider;
  }

  @Override
  public CreateEventAnnouncementActivity get() {
    return new CreateEventAnnouncementActivity(eventAnnouncementDaoProvider.get());
  }

  public static CreateEventAnnouncementActivity_Factory create(
      Provider<EventAnnouncementDao> eventAnnouncementDaoProvider) {
    return new CreateEventAnnouncementActivity_Factory(eventAnnouncementDaoProvider);
  }
}

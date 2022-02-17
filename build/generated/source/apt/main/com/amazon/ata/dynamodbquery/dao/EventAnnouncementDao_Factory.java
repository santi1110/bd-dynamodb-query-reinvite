package com.amazon.ata.dynamodbquery.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class EventAnnouncementDao_Factory implements Factory<EventAnnouncementDao> {
  private final Provider<DynamoDBMapper> mapperProvider;

  public EventAnnouncementDao_Factory(Provider<DynamoDBMapper> mapperProvider) {
    this.mapperProvider = mapperProvider;
  }

  @Override
  public EventAnnouncementDao get() {
    return new EventAnnouncementDao(mapperProvider.get());
  }

  public static EventAnnouncementDao_Factory create(Provider<DynamoDBMapper> mapperProvider) {
    return new EventAnnouncementDao_Factory(mapperProvider);
  }
}

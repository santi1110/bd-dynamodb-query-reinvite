package com.amazon.ata.dynamodbquery.dependency;

import com.amazon.ata.dynamodbquery.activity.CancelEventActivity;
import com.amazon.ata.dynamodbquery.activity.CreateEventActivity;
import com.amazon.ata.dynamodbquery.activity.CreateEventAnnouncementActivity;
import com.amazon.ata.dynamodbquery.activity.CreateInviteActivity;
import com.amazon.ata.dynamodbquery.activity.CreateMemberActivity;
import com.amazon.ata.dynamodbquery.activity.DeleteMemberActivity;
import com.amazon.ata.dynamodbquery.activity.GetEventActivity;
import com.amazon.ata.dynamodbquery.activity.GetEventAnnouncementsActivity;
import com.amazon.ata.dynamodbquery.activity.GetEventAnnouncementsBetweenDatesActivity;
import com.amazon.ata.dynamodbquery.activity.GetInviteActivity;
import com.amazon.ata.dynamodbquery.activity.GetInvitesForEventActivity;
import com.amazon.ata.dynamodbquery.activity.GetInvitesForMemberActivity;
import com.amazon.ata.dynamodbquery.activity.GetMemberActivity;
import com.amazon.ata.dynamodbquery.dao.EventAnnouncementDao;
import com.amazon.ata.dynamodbquery.dao.EventDao;
import com.amazon.ata.dynamodbquery.dao.InviteDao;
import com.amazon.ata.dynamodbquery.dao.MemberDao;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerServiceComponent implements ServiceComponent {
  private Provider<DynamoDBMapper> provideDynamoDBMapperProvider;

  private DaggerServiceComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static ServiceComponent create() {
    return new Builder().build();
  }

  private MemberDao getMemberDao() {
    return new MemberDao(provideDynamoDBMapperProvider.get());
  }

  private InviteDao getInviteDao() {
    return new InviteDao(provideDynamoDBMapperProvider.get());
  }

  private EventDao getEventDao() {
    return new EventDao(provideDynamoDBMapperProvider.get());
  }

  private EventAnnouncementDao getEventAnnouncementDao() {
    return new EventAnnouncementDao(provideDynamoDBMapperProvider.get());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideDynamoDBMapperProvider =
        DoubleCheck.provider(DaoModule_ProvideDynamoDBMapperFactory.create(builder.daoModule));
  }

  @Override
  public DeleteMemberActivity provideDeleteMemberActivity() {
    return new DeleteMemberActivity(getMemberDao(), getInviteDao());
  }

  @Override
  public CreateMemberActivity provideCreateMemberActivity() {
    return new CreateMemberActivity(getMemberDao());
  }

  @Override
  public GetMemberActivity provideGetMemberActivity() {
    return new GetMemberActivity(getMemberDao());
  }

  @Override
  public GetInviteActivity provideGetInviteActivity() {
    return new GetInviteActivity(getInviteDao());
  }

  @Override
  public GetInvitesForMemberActivity provideGetInvitesForMemberActivity() {
    return new GetInvitesForMemberActivity(getInviteDao(), getEventDao());
  }

  @Override
  public GetInvitesForEventActivity provideGetInvitesForEventActivity() {
    return new GetInvitesForEventActivity(getInviteDao());
  }

  @Override
  public CreateInviteActivity provideCreateInviteActivity() {
    return new CreateInviteActivity(getInviteDao());
  }

  @Override
  public GetEventActivity provideGetEventActivity() {
    return new GetEventActivity(getEventDao());
  }

  @Override
  public CreateEventActivity provideCreateEventActivity() {
    return new CreateEventActivity(getEventDao());
  }

  @Override
  public CancelEventActivity provideCancelEventActivity() {
    return new CancelEventActivity(getEventDao());
  }

  @Override
  public GetEventAnnouncementsActivity provideGetEventAnnouncementsActivity() {
    return new GetEventAnnouncementsActivity(getEventAnnouncementDao());
  }

  @Override
  public GetEventAnnouncementsBetweenDatesActivity
      provideGetEventAnnouncementsBetweenDatesActivity() {
    return new GetEventAnnouncementsBetweenDatesActivity(getEventAnnouncementDao());
  }

  @Override
  public CreateEventAnnouncementActivity provideCreateEventAnnouncementActivity() {
    return new CreateEventAnnouncementActivity(getEventAnnouncementDao());
  }

  public static final class Builder {
    private DaoModule daoModule;

    private Builder() {}

    public ServiceComponent build() {
      if (daoModule == null) {
        this.daoModule = new DaoModule();
      }
      return new DaggerServiceComponent(this);
    }

    public Builder daoModule(DaoModule daoModule) {
      this.daoModule = Preconditions.checkNotNull(daoModule);
      return this;
    }
  }
}

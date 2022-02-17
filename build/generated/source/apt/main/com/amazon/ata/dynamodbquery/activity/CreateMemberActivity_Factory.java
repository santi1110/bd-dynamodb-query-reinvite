package com.amazon.ata.dynamodbquery.activity;

import com.amazon.ata.dynamodbquery.dao.MemberDao;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CreateMemberActivity_Factory implements Factory<CreateMemberActivity> {
  private final Provider<MemberDao> memberDaoProvider;

  public CreateMemberActivity_Factory(Provider<MemberDao> memberDaoProvider) {
    this.memberDaoProvider = memberDaoProvider;
  }

  @Override
  public CreateMemberActivity get() {
    return new CreateMemberActivity(memberDaoProvider.get());
  }

  public static CreateMemberActivity_Factory create(Provider<MemberDao> memberDaoProvider) {
    return new CreateMemberActivity_Factory(memberDaoProvider);
  }
}

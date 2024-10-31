package com.google.api.client.googleapis.extensions.android.accounts;

import android.accounts.AccountManager;
import android.content.Context;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;

@Beta
/* loaded from: classes.dex */
public final class GoogleAccountManager {

    /* renamed from: a, reason: collision with root package name */
    private final AccountManager f2433a;

    public GoogleAccountManager(AccountManager accountManager) {
        this.f2433a = (AccountManager) Preconditions.a(accountManager);
    }

    public GoogleAccountManager(Context context) {
        this(AccountManager.get(context));
    }
}

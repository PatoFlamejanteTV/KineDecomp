package com.google.api.client.googleapis.extensions.android.accounts;

import android.accounts.AccountManager;
import android.content.Context;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;

@Beta
/* loaded from: classes2.dex */
public final class GoogleAccountManager {

    /* renamed from: a */
    private final AccountManager f14663a;

    public GoogleAccountManager(AccountManager accountManager) {
        Preconditions.a(accountManager);
        this.f14663a = accountManager;
    }

    public GoogleAccountManager(Context context) {
        this(AccountManager.get(context));
    }
}

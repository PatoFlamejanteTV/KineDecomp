package com.google.android.gms.wallet;

import android.accounts.Account;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class WalletConstants {

    /* renamed from: a, reason: collision with root package name */
    public static final Account f2297a = new Account("ACCOUNT_NO_WALLET", "com.google");

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface CardNetwork {
    }

    private WalletConstants() {
    }
}

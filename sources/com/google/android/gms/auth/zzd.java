package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import java.io.IOException;

/* loaded from: classes.dex */
public class zzd {

    /* renamed from: a */
    private static final String[] f10613a = {"com.google", "com.google.work", "cn.google"};

    /* renamed from: b */
    @SuppressLint({"InlinedApi"})
    public static final String f10614b = "callerUid";

    /* renamed from: c */
    @SuppressLint({"InlinedApi"})
    public static final String f10615c = "androidPackageName";

    /* renamed from: d */
    private static final ComponentName f10616d = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");

    /* renamed from: e */
    private static final Logger f10617e = new Logger("Auth", "GoogleAuthUtil");

    @Deprecated
    public static String a(Context context, String str, String str2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return a(context, new Account(str, "com.google"), str2);
    }

    public static TokenData b(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        Preconditions.c("Calling this from your main thread can lead to deadlock");
        Preconditions.a(str, (Object) "Scope cannot be empty or null.");
        a(account);
        a(context, 8400000);
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        String str2 = context.getApplicationInfo().packageName;
        bundle2.putString("clientPackageName", str2);
        if (TextUtils.isEmpty(bundle2.getString(f10615c))) {
            bundle2.putString(f10615c, str2);
        }
        bundle2.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        return (TokenData) a(context, f10616d, new a(account, str, bundle2));
    }

    public static String a(Context context, Account account, String str) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return a(context, account, str, new Bundle());
    }

    public static String a(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        a(account);
        return b(context, account, str, bundle).a();
    }

    @Deprecated
    public static void a(Context context, String str) {
        AccountManager.get(context).invalidateAuthToken("com.google", str);
    }

    private static void a(Account account) {
        if (account != null) {
            if (!TextUtils.isEmpty(account.name)) {
                for (String str : f10613a) {
                    if (str.equals(account.type)) {
                        return;
                    }
                }
                throw new IllegalArgumentException("Account type not supported");
            }
            throw new IllegalArgumentException("Account name cannot be empty!");
        }
        throw new IllegalArgumentException("Account cannot be null");
    }

    private static <T> T b(T t) throws IOException {
        if (t != null) {
            return t;
        }
        f10617e.e("GoogleAuthUtil", "Binder call returned null.");
        throw new IOException("Service unavailable.");
    }

    private static void a(Context context, int i) throws GoogleAuthException {
        try {
            GooglePlayServicesUtilLight.ensurePlayServicesAvailable(context.getApplicationContext(), i);
        } catch (GooglePlayServicesNotAvailableException e2) {
            throw new GoogleAuthException(e2.getMessage());
        } catch (GooglePlayServicesRepairableException e3) {
            throw new GooglePlayServicesAvailabilityException(e3.getConnectionStatusCode(), e3.getMessage(), e3.getIntent());
        }
    }

    private static <T> T a(Context context, ComponentName componentName, b<T> bVar) throws IOException, GoogleAuthException {
        BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
        GmsClientSupervisor a2 = GmsClientSupervisor.a(context);
        try {
            if (a2.a(componentName, blockingServiceConnection, "GoogleAuthUtil")) {
                try {
                    return bVar.a(blockingServiceConnection.a());
                } catch (RemoteException | InterruptedException e2) {
                    f10617e.c("GoogleAuthUtil", "Error on service connection.", e2);
                    throw new IOException("Error on service connection.", e2);
                }
            }
            throw new IOException("Could not bind to service.");
        } finally {
            a2.b(componentName, blockingServiceConnection, "GoogleAuthUtil");
        }
    }

    public static /* synthetic */ Object a(Object obj) throws IOException {
        b(obj);
        return obj;
    }
}

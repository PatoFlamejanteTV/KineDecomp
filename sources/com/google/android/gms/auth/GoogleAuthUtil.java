package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzau;
import java.io.IOException;

/* loaded from: classes.dex */
public final class GoogleAuthUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final String f780a;
    public static final String b;
    private static final ComponentName c;
    private static final ComponentName d;

    static {
        f780a = Build.VERSION.SDK_INT >= 11 ? "callerUid" : "callerUid";
        b = Build.VERSION.SDK_INT >= 14 ? "androidPackageName" : "androidPackageName";
        c = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
        d = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
    }

    private GoogleAuthUtil() {
    }

    public static String a(Context context, Account account, String str) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return a(context, account, str, new Bundle());
    }

    public static String a(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return b(context, account, str, bundle).a();
    }

    @Deprecated
    public static String a(Context context, String str, String str2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return a(context, new Account(str, "com.google"), str2);
    }

    private static void a(Context context) throws GoogleAuthException {
        try {
            GooglePlayServicesUtil.b(context);
        } catch (GooglePlayServicesNotAvailableException e) {
            throw new GoogleAuthException(e.getMessage());
        } catch (GooglePlayServicesRepairableException e2) {
            throw new GooglePlayServicesAvailabilityException(e2.getConnectionStatusCode(), e2.getMessage(), e2.getIntent());
        }
    }

    @Deprecated
    public static void a(Context context, String str) {
        AccountManager.get(context).invalidateAuthToken("com.google", str);
    }

    public static TokenData b(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        Context applicationContext = context.getApplicationContext();
        zzx.c("Calling this from your main thread can lead to deadlock");
        a(applicationContext);
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        String str2 = context.getApplicationInfo().packageName;
        bundle2.putString("clientPackageName", str2);
        if (TextUtils.isEmpty(bundle2.getString(b))) {
            bundle2.putString(b, str2);
        }
        bundle2.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        com.google.android.gms.common.zza zzaVar = new com.google.android.gms.common.zza();
        zzl a2 = zzl.a(applicationContext);
        try {
            if (!a2.a(c, zzaVar, "GoogleAuthUtil")) {
                throw new IOException("Could not bind to service with the given context.");
            }
            try {
                Bundle zza = zzau.zza.zza(zzaVar.a()).zza(account, str, bundle2);
                if (zza == null) {
                    Log.w("GoogleAuthUtil", "Binder call returned null.");
                    throw new GoogleAuthException("ServiceUnavailable");
                }
                TokenData a3 = TokenData.a(zza, "tokenDetails");
                if (a3 != null) {
                    return a3;
                }
                String string = zza.getString("Error");
                Intent intent = (Intent) zza.getParcelable("userRecoveryIntent");
                com.google.android.gms.auth.firstparty.shared.zzd zzbE = com.google.android.gms.auth.firstparty.shared.zzd.zzbE(string);
                if (com.google.android.gms.auth.firstparty.shared.zzd.zza(zzbE)) {
                    throw new UserRecoverableAuthException(string, intent);
                }
                if (com.google.android.gms.auth.firstparty.shared.zzd.zzc(zzbE)) {
                    throw new IOException(string);
                }
                throw new GoogleAuthException(string);
            } catch (RemoteException e) {
                Log.i("GoogleAuthUtil", "GMS remote exception ", e);
                throw new IOException("remote exception");
            } catch (InterruptedException e2) {
                throw new GoogleAuthException("Interrupted");
            }
        } finally {
            a2.b(c, zzaVar, "GoogleAuthUtil");
        }
    }
}

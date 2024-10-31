package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.FirebaseApp;
import com.umeng.commonsdk.proguard.ap;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzan {

    /* renamed from: a, reason: collision with root package name */
    private final Context f17408a;

    /* renamed from: b, reason: collision with root package name */
    private String f17409b;

    /* renamed from: c, reason: collision with root package name */
    private String f17410c;

    /* renamed from: d, reason: collision with root package name */
    private int f17411d;

    /* renamed from: e, reason: collision with root package name */
    private int f17412e = 0;

    public zzan(Context context) {
        this.f17408a = context;
    }

    private final synchronized void e() {
        PackageInfo a2 = a(this.f17408a.getPackageName());
        if (a2 != null) {
            this.f17409b = Integer.toString(a2.versionCode);
            this.f17410c = a2.versionName;
        }
    }

    public final synchronized int a() {
        if (this.f17412e != 0) {
            return this.f17412e;
        }
        PackageManager packageManager = this.f17408a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!PlatformVersion.k()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f17412e = 1;
                return this.f17412e;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
            this.f17412e = 2;
            return this.f17412e;
        }
        Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
        if (PlatformVersion.k()) {
            this.f17412e = 2;
        } else {
            this.f17412e = 1;
        }
        return this.f17412e;
    }

    public final synchronized String b() {
        if (this.f17409b == null) {
            e();
        }
        return this.f17409b;
    }

    public final synchronized String c() {
        if (this.f17410c == null) {
            e();
        }
        return this.f17410c;
    }

    public final synchronized int d() {
        PackageInfo a2;
        if (this.f17411d == 0 && (a2 = a("com.google.android.gms")) != null) {
            this.f17411d = a2.versionCode;
        }
        return this.f17411d;
    }

    public static String a(FirebaseApp firebaseApp) {
        String d2 = firebaseApp.e().d();
        if (d2 != null) {
            return d2;
        }
        String b2 = firebaseApp.e().b();
        if (!b2.startsWith("1:")) {
            return b2;
        }
        String[] split = b2.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    public static String a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) ((digest[0] & ap.m) + 112);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    private final PackageInfo a(String str) {
        try {
            return this.f17408a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to find package ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }
}

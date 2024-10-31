package com.bumptech.glide.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: ApplicationVersionSignature.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    private static final ConcurrentMap<String, com.bumptech.glide.load.c> f8485a = new ConcurrentHashMap();

    public static com.bumptech.glide.load.c a(Context context) {
        String packageName = context.getPackageName();
        com.bumptech.glide.load.c cVar = f8485a.get(packageName);
        if (cVar != null) {
            return cVar;
        }
        com.bumptech.glide.load.c c2 = c(context);
        com.bumptech.glide.load.c putIfAbsent = f8485a.putIfAbsent(packageName, c2);
        return putIfAbsent == null ? c2 : putIfAbsent;
    }

    private static PackageInfo b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e2);
            return null;
        }
    }

    private static com.bumptech.glide.load.c c(Context context) {
        return new c(a(b(context)));
    }

    private static String a(PackageInfo packageInfo) {
        if (packageInfo != null) {
            return String.valueOf(packageInfo.versionCode);
        }
        return UUID.randomUUID().toString();
    }
}

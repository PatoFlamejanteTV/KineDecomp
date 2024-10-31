package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;

/* loaded from: classes.dex */
public final class zzp {

    /* renamed from: a */
    private static Object f11179a = new Object();

    /* renamed from: b */
    private static boolean f11180b;

    /* renamed from: c */
    private static String f11181c;

    /* renamed from: d */
    private static int f11182d;

    public static String a(Context context) {
        c(context);
        return f11181c;
    }

    public static int b(Context context) {
        c(context);
        return f11182d;
    }

    private static void c(Context context) {
        Bundle bundle;
        synchronized (f11179a) {
            if (f11180b) {
                return;
            }
            f11180b = true;
            try {
                bundle = Wrappers.a(context).a(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.wtf("MetadataValueReader", "This should never happen.", e2);
            }
            if (bundle == null) {
                return;
            }
            f11181c = bundle.getString("com.google.app.id");
            f11182d = bundle.getInt("com.google.android.gms.version");
        }
    }
}

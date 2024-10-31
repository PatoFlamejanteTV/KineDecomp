package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.flags.zze;

/* loaded from: classes.dex */
public final class zzj {

    /* renamed from: a */
    private static SharedPreferences f11357a;

    public static SharedPreferences a(Context context) throws Exception {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f11357a == null) {
                f11357a = (SharedPreferences) zze.zza(new e(context));
            }
            sharedPreferences = f11357a;
        }
        return sharedPreferences;
    }
}

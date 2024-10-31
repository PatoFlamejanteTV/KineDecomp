package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
/* loaded from: classes.dex */
public class Wrappers {

    /* renamed from: a */
    private static Wrappers f11308a = new Wrappers();

    /* renamed from: b */
    private PackageManagerWrapper f11309b = null;

    @KeepForSdk
    public static PackageManagerWrapper a(Context context) {
        return f11308a.b(context);
    }

    @VisibleForTesting
    private final synchronized PackageManagerWrapper b(Context context) {
        if (this.f11309b == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f11309b = new PackageManagerWrapper(context);
        }
        return this.f11309b;
    }
}

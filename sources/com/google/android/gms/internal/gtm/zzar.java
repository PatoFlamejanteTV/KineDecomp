package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes2.dex */
public final class zzar {
    private final Context zzwu;
    private final Context zzwv;

    public zzar(Context context) {
        Preconditions.a(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.a(applicationContext, "Application context can't be null");
        this.zzwu = applicationContext;
        this.zzwv = applicationContext;
    }

    public final Context getApplicationContext() {
        return this.zzwu;
    }

    public final Context zzdc() {
        return this.zzwv;
    }
}

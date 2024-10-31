package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzft {

    /* renamed from: a */
    final Context f14050a;

    @VisibleForTesting
    public zzft(Context context) {
        Preconditions.a(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.a(applicationContext);
        this.f14050a = applicationContext;
    }
}

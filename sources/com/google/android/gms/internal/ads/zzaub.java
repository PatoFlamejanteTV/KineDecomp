package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

@zzark
/* loaded from: classes2.dex */
public final class zzaub {
    private WeakHashMap<Context, Wc> zzedp = new WeakHashMap<>();

    public final Future<zzatz> zzt(Context context) {
        return zzayf.zza(new Vc(this, context));
    }
}

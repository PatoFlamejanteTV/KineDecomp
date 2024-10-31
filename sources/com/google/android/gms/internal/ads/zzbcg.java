package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

@zzark
/* loaded from: classes2.dex */
public final class zzbcg {
    public static final Executor zzepo = new ExecutorC1122ve();
    public static final Executor zzepp = new ExecutorC1136we();
    private static final zzbcf zzepq = zza(zzepo);
    private static final zzbcf zzepr = zza(zzepp);

    public static zzbcf zza(Executor executor) {
        return new C1150xe(executor, null);
    }
}

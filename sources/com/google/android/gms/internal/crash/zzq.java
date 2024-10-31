package com.google.android.gms.internal.crash;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crash.FirebaseCrash;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public final class zzq {
    private final AnalyticsConnector zzan;

    public zzq(AnalyticsConnector analyticsConnector) {
        this.zzan = analyticsConnector;
    }

    public final void zza(boolean z, long j) {
        Bundle bundle = new Bundle();
        bundle.putInt("fatal", z ? 1 : 0);
        bundle.putLong("timestamp", j);
        this.zzan.logEvent("crash", "_ae", bundle);
    }

    public final void zza(Context context, ExecutorService executorService, FirebaseCrash.zza zzaVar) {
        this.zzan.a("crash", new b(context, executorService, zzaVar));
    }
}

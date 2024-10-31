package com.google.android.gms.internal.crash;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crash.FirebaseCrash;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements AnalyticsConnector.AnalyticsConnectorListener {

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f12942a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f12943b;

    /* renamed from: c, reason: collision with root package name */
    private final FirebaseCrash.zza f12944c;

    public b(Context context, ExecutorService executorService, FirebaseCrash.zza zzaVar) {
        this.f12943b = context.getApplicationContext();
        this.f12942a = executorService;
        this.f12944c = zzaVar;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener
    public final void a(int i, Bundle bundle) {
        if (i != 3 || this.f12944c == null || bundle == null) {
            return;
        }
        this.f12942a.execute(new zzd(this.f12943b, this.f12944c, bundle.getString("name"), bundle.getLong("timestampInMillis"), bundle.getBundle(NativeProtocol.WEB_DIALOG_PARAMS)));
    }
}

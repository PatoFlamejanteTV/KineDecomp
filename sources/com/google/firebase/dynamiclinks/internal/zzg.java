package com.google.firebase.dynamiclinks.internal;

import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;

/* loaded from: classes2.dex */
public final class zzg extends FirebaseDynamicLinks {

    /* renamed from: a, reason: collision with root package name */
    private final GoogleApi<Api.ApiOptions.NoOptions> f17288a;

    /* renamed from: b, reason: collision with root package name */
    private final AnalyticsConnector f17289b;

    public zzg(FirebaseApp firebaseApp, AnalyticsConnector analyticsConnector) {
        this(new zzc(firebaseApp.b()), analyticsConnector);
    }

    @Override // com.google.firebase.dynamiclinks.FirebaseDynamicLinks
    public final Task<PendingDynamicLinkData> a(Intent intent) {
        Task doWrite = this.f17288a.doWrite(new e(this.f17289b, intent.getDataString()));
        zza zzaVar = (zza) SafeParcelableSerializer.a(intent, "com.google.firebase.dynamiclinks.DYNAMIC_LINK_DATA", zza.CREATOR);
        PendingDynamicLinkData pendingDynamicLinkData = zzaVar != null ? new PendingDynamicLinkData(zzaVar) : null;
        return pendingDynamicLinkData != null ? Tasks.a(pendingDynamicLinkData) : doWrite;
    }

    @VisibleForTesting
    private zzg(GoogleApi<Api.ApiOptions.NoOptions> googleApi, AnalyticsConnector analyticsConnector) {
        this.f17288a = googleApi;
        this.f17289b = analyticsConnector;
        if (analyticsConnector == null) {
            Log.w("FDL", "FDL logging failed. Add a dependency for Firebase Analytics to your app to enable logging of Dynamic Link events.");
        }
    }
}

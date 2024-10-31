package com.google.firebase.dynamiclinks.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;

/* loaded from: classes2.dex */
final class d extends c {

    /* renamed from: a, reason: collision with root package name */
    private final TaskCompletionSource<PendingDynamicLinkData> f17275a;

    /* renamed from: b, reason: collision with root package name */
    private final AnalyticsConnector f17276b;

    public d(AnalyticsConnector analyticsConnector, TaskCompletionSource<PendingDynamicLinkData> taskCompletionSource) {
        this.f17276b = analyticsConnector;
        this.f17275a = taskCompletionSource;
    }

    @Override // com.google.firebase.dynamiclinks.internal.zzm
    public final void a(Status status, zza zzaVar) {
        Bundle bundle;
        TaskUtil.a(status, zzaVar == null ? null : new PendingDynamicLinkData(zzaVar), this.f17275a);
        if (zzaVar == null || (bundle = zzaVar.P().getBundle("scionData")) == null || bundle.keySet() == null || this.f17276b == null) {
            return;
        }
        for (String str : bundle.keySet()) {
            this.f17276b.logEvent("fdl", str, bundle.getBundle(str));
        }
    }
}

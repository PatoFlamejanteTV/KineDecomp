package com.google.firebase.dynamiclinks.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;

/* loaded from: classes2.dex */
final class e extends TaskApiCall<zze, PendingDynamicLinkData> {

    /* renamed from: c, reason: collision with root package name */
    private final String f17277c;

    /* renamed from: d, reason: collision with root package name */
    private final AnalyticsConnector f17278d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AnalyticsConnector analyticsConnector, String str) {
        this.f17277c = str;
        this.f17278d = analyticsConnector;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void a(zze zzeVar, TaskCompletionSource<PendingDynamicLinkData> taskCompletionSource) throws RemoteException {
        zze zzeVar2 = zzeVar;
        try {
            ((zzo) zzeVar2.getService()).a(new d(this.f17278d, taskCompletionSource), this.f17277c);
        } catch (RemoteException unused) {
        }
    }
}

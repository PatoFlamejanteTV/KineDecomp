package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.b;

/* loaded from: classes.dex */
public final class zzbb implements NodeApi {

    /* renamed from: a, reason: collision with root package name */
    private static final b.a<NodeApi.NodeListener> f2388a = new c();
    private static final b.a<NodeApi.zza> b = new d();

    /* loaded from: classes.dex */
    public static class zza implements NodeApi.GetConnectedNodesResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f2389a;

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.f2389a;
        }
    }

    /* loaded from: classes.dex */
    public static class zzb implements NodeApi.GetLocalNodeResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f2390a;

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.f2390a;
        }
    }
}

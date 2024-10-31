package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class zaav implements zabd {

    /* renamed from: a, reason: collision with root package name */
    private final zabe f10880a;

    public zaav(zabe zabeVar) {
        this.f10880a = zabeVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void a() {
        Iterator<Api.Client> it = this.f10880a.f10894f.values().iterator();
        while (it.hasNext()) {
            it.next().disconnect();
        }
        this.f10880a.n.q = Collections.emptySet();
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void a(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T b(T t) {
        this.f10880a.n.i.add(t);
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void connect() {
        this.f10880a.e();
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final boolean disconnect() {
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void onConnectionSuspended(int i) {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T a(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}

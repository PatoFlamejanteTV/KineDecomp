package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
final class E implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ConnectionResult f10734a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ GoogleApiManager.b f10735b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(GoogleApiManager.b bVar, ConnectionResult connectionResult) {
        this.f10735b = bVar;
        this.f10734a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zai zaiVar;
        Api.Client client;
        zai zaiVar2;
        Api.Client client2;
        if (!this.f10734a.R()) {
            Map map = GoogleApiManager.this.m;
            zaiVar = this.f10735b.f10750b;
            ((GoogleApiManager.zaa) map.get(zaiVar)).onConnectionFailed(this.f10734a);
            return;
        }
        GoogleApiManager.b.a(this.f10735b, true);
        client = this.f10735b.f10749a;
        if (client.requiresSignIn()) {
            this.f10735b.a();
            return;
        }
        try {
            client2 = this.f10735b.f10749a;
            client2.getRemoteService(null, Collections.emptySet());
        } catch (SecurityException e2) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e2);
            Map map2 = GoogleApiManager.this.m;
            zaiVar2 = this.f10735b.f10750b;
            ((GoogleApiManager.zaa) map2.get(zaiVar2)).onConnectionFailed(new ConnectionResult(10));
        }
    }
}

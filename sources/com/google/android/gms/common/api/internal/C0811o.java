package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.zad;
import java.util.concurrent.locks.Lock;

/* renamed from: com.google.android.gms.common.api.internal.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0811o implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zaak f10848a;

    private C0811o(zaak zaakVar) {
        this.f10848a = zaakVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        ClientSettings clientSettings;
        zad zadVar;
        Lock lock;
        Lock lock2;
        zad zadVar2;
        zad zadVar3;
        clientSettings = this.f10848a.r;
        if (!clientSettings.k()) {
            zadVar = this.f10848a.k;
            zadVar.a(new BinderC0809m(this.f10848a));
            return;
        }
        lock = this.f10848a.f10873b;
        lock.lock();
        try {
            zadVar2 = this.f10848a.k;
            if (zadVar2 == null) {
                return;
            }
            zadVar3 = this.f10848a.k;
            zadVar3.a(new BinderC0809m(this.f10848a));
        } finally {
            lock2 = this.f10848a.f10873b;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Lock lock;
        Lock lock2;
        boolean a2;
        lock = this.f10848a.f10873b;
        lock.lock();
        try {
            a2 = this.f10848a.a(connectionResult);
            if (a2) {
                this.f10848a.e();
                this.f10848a.c();
            } else {
                this.f10848a.b(connectionResult);
            }
        } finally {
            lock2 = this.f10848a.f10873b;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C0811o(zaak zaakVar, RunnableC0803g runnableC0803g) {
        this(zaakVar);
    }
}

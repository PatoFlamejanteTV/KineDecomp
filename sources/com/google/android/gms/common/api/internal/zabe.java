package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public final class zabe implements zabs, zar {

    /* renamed from: a, reason: collision with root package name */
    private final Lock f10889a;

    /* renamed from: b, reason: collision with root package name */
    private final Condition f10890b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f10891c;

    /* renamed from: d, reason: collision with root package name */
    private final GoogleApiAvailabilityLight f10892d;

    /* renamed from: e, reason: collision with root package name */
    private final HandlerC0819x f10893e;

    /* renamed from: f, reason: collision with root package name */
    final Map<Api.AnyClientKey<?>, Api.Client> f10894f;

    /* renamed from: h, reason: collision with root package name */
    private final ClientSettings f10896h;
    private final Map<Api<?>, Boolean> i;
    private final Api.AbstractClientBuilder<? extends zad, SignInOptions> j;
    private volatile zabd k;
    int m;
    final zaaw n;
    final zabt o;

    /* renamed from: g, reason: collision with root package name */
    final Map<Api.AnyClientKey<?>, ConnectionResult> f10895g = new HashMap();
    private ConnectionResult l = null;

    public zabe(Context context, zaaw zaawVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, ArrayList<zaq> arrayList, zabt zabtVar) {
        this.f10891c = context;
        this.f10889a = lock;
        this.f10892d = googleApiAvailabilityLight;
        this.f10894f = map;
        this.f10896h = clientSettings;
        this.i = map2;
        this.j = abstractClientBuilder;
        this.n = zaawVar;
        this.o = zabtVar;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            zaq zaqVar = arrayList.get(i);
            i++;
            zaqVar.a(this);
        }
        this.f10893e = new HandlerC0819x(this, looper);
        this.f10890b = lock.newCondition();
        this.k = new zaav(this);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T a(T t) {
        t.f();
        return (T) this.k.a(t);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean a(SignInConnectionListener signInConnectionListener) {
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T b(T t) {
        t.f();
        return (T) this.k.b(t);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void b() {
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final ConnectionResult c() {
        connect();
        while (d()) {
            try {
                this.f10890b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.f10647a;
        }
        ConnectionResult connectionResult = this.l;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void connect() {
        this.k.connect();
    }

    public final boolean d() {
        return this.k instanceof zaak;
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void disconnect() {
        if (this.k.disconnect()) {
            this.f10895g.clear();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append((CharSequence) str).append("mState=").println(this.k);
        for (Api<?> api : this.i.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) api.b()).println(":");
            this.f10894f.get(api.a()).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        this.f10889a.lock();
        try {
            this.k = new zaak(this, this.f10896h, this.i, this.f10892d, this.j, this.f10889a, this.f10891c);
            this.k.a();
            this.f10890b.signalAll();
        } finally {
            this.f10889a.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f() {
        this.f10889a.lock();
        try {
            this.n.l();
            this.k = new zaah(this);
            this.k.a();
            this.f10890b.signalAll();
        } finally {
            this.f10889a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean isConnected() {
        return this.k instanceof zaah;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.f10889a.lock();
        try {
            this.k.onConnected(bundle);
        } finally {
            this.f10889a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        this.f10889a.lock();
        try {
            this.k.onConnectionSuspended(i);
        } finally {
            this.f10889a.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(ConnectionResult connectionResult) {
        this.f10889a.lock();
        try {
            this.l = connectionResult;
            this.k = new zaav(this);
            this.k.a();
            this.f10890b.signalAll();
        } finally {
            this.f10889a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void a() {
        if (isConnected()) {
            ((zaah) this.k).b();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zar
    public final void a(ConnectionResult connectionResult, Api<?> api, boolean z) {
        this.f10889a.lock();
        try {
            this.k.a(connectionResult, api, z);
        } finally {
            this.f10889a.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(AbstractC0818w abstractC0818w) {
        this.f10893e.sendMessage(this.f10893e.obtainMessage(1, abstractC0818w));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(RuntimeException runtimeException) {
        this.f10893e.sendMessage(this.f10893e.obtainMessage(2, runtimeException));
    }
}

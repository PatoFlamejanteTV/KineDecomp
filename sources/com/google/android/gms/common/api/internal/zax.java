package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public final class zax implements zabs {

    /* renamed from: c, reason: collision with root package name */
    private final Map<Api<?>, Boolean> f10962c;

    /* renamed from: d, reason: collision with root package name */
    private final GoogleApiManager f10963d;

    /* renamed from: e, reason: collision with root package name */
    private final zaaw f10964e;

    /* renamed from: f, reason: collision with root package name */
    private final Lock f10965f;

    /* renamed from: g, reason: collision with root package name */
    private final Looper f10966g;

    /* renamed from: h, reason: collision with root package name */
    private final GoogleApiAvailabilityLight f10967h;
    private final Condition i;
    private final ClientSettings j;
    private final boolean k;
    private final boolean l;
    private boolean n;
    private Map<zai<?>, ConnectionResult> o;
    private Map<zai<?>, ConnectionResult> p;
    private C0797a q;
    private ConnectionResult r;

    /* renamed from: a, reason: collision with root package name */
    private final Map<Api.AnyClientKey<?>, zaw<?>> f10960a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Api.AnyClientKey<?>, zaw<?>> f10961b = new HashMap();
    private final Queue<BaseImplementation.ApiMethodImpl<?, ?>> m = new LinkedList();

    public zax(Context context, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, ArrayList<zaq> arrayList, zaaw zaawVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        this.f10965f = lock;
        this.f10966g = looper;
        this.i = lock.newCondition();
        this.f10967h = googleApiAvailabilityLight;
        this.f10964e = zaawVar;
        this.f10962c = map2;
        this.j = clientSettings;
        this.k = z;
        HashMap hashMap = new HashMap();
        for (Api<?> api : map2.keySet()) {
            hashMap.put(api.a(), api);
        }
        HashMap hashMap2 = new HashMap();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            zaq zaqVar = arrayList.get(i);
            i++;
            zaq zaqVar2 = zaqVar;
            hashMap2.put(zaqVar2.f10953a, zaqVar2);
        }
        boolean z5 = false;
        boolean z6 = true;
        boolean z7 = false;
        for (Map.Entry<Api.AnyClientKey<?>, Api.Client> entry : map.entrySet()) {
            Api api2 = (Api) hashMap.get(entry.getKey());
            Api.Client value = entry.getValue();
            if (value.requiresGooglePlayServices()) {
                if (this.f10962c.get(api2).booleanValue()) {
                    z4 = z6;
                    z3 = z7;
                } else {
                    z4 = z6;
                    z3 = true;
                }
                z2 = true;
            } else {
                z2 = z5;
                z3 = z7;
                z4 = false;
            }
            zaw<?> zawVar = new zaw<>(context, api2, looper, value, (zaq) hashMap2.get(api2), clientSettings, abstractClientBuilder);
            this.f10960a.put(entry.getKey(), zawVar);
            if (value.requiresSignIn()) {
                this.f10961b.put(entry.getKey(), zawVar);
            }
            z7 = z3;
            z6 = z4;
            z5 = z2;
        }
        this.l = (!z5 || z6 || z7) ? false : true;
        this.f10963d = GoogleApiManager.c();
    }

    private final <T extends BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>> boolean c(T t) {
        Api.AnyClientKey<?> h2 = t.h();
        ConnectionResult a2 = a(h2);
        if (a2 == null || a2.a() != 4) {
            return false;
        }
        t.c(new Status(4, null, this.f10963d.a(this.f10960a.get(h2).zak(), System.identityHashCode(this.f10964e))));
        return true;
    }

    private final boolean e() {
        this.f10965f.lock();
        try {
            if (this.n && this.k) {
                Iterator<Api.AnyClientKey<?>> it = this.f10961b.keySet().iterator();
                while (it.hasNext()) {
                    ConnectionResult a2 = a(it.next());
                    if (a2 == null || !a2.R()) {
                        return false;
                    }
                }
                this.f10965f.unlock();
                return true;
            }
            return false;
        } finally {
            this.f10965f.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        ClientSettings clientSettings = this.j;
        if (clientSettings == null) {
            this.f10964e.q = Collections.emptySet();
            return;
        }
        HashSet hashSet = new HashSet(clientSettings.i());
        Map<Api<?>, ClientSettings.OptionalApiSettings> f2 = this.j.f();
        for (Api<?> api : f2.keySet()) {
            ConnectionResult a2 = a(api);
            if (a2 != null && a2.R()) {
                hashSet.addAll(f2.get(api).f11080a);
            }
        }
        this.f10964e.q = hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        while (!this.m.isEmpty()) {
            a((zax) this.m.remove());
        }
        this.f10964e.a((Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConnectionResult h() {
        ConnectionResult connectionResult = null;
        ConnectionResult connectionResult2 = null;
        int i = 0;
        int i2 = 0;
        for (zaw<?> zawVar : this.f10960a.values()) {
            Api<?> api = zawVar.getApi();
            ConnectionResult connectionResult3 = this.o.get(zawVar.zak());
            if (!connectionResult3.R() && (!this.f10962c.get(api).booleanValue() || connectionResult3.Q() || this.f10967h.c(connectionResult3.a()))) {
                if (connectionResult3.a() == 4 && this.k) {
                    int a2 = api.c().a();
                    if (connectionResult2 == null || i2 > a2) {
                        connectionResult2 = connectionResult3;
                        i2 = a2;
                    }
                } else {
                    int a3 = api.c().a();
                    if (connectionResult == null || i > a3) {
                        connectionResult = connectionResult3;
                        i = a3;
                    }
                }
            }
        }
        return (connectionResult == null || connectionResult2 == null || i <= i2) ? connectionResult : connectionResult2;
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T a(T t) {
        Api.AnyClientKey<A> h2 = t.h();
        if (this.k && c((zax) t)) {
            return t;
        }
        this.f10964e.y.a(t);
        return (T) this.f10960a.get(h2).doWrite((zaw<?>) t);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void a() {
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T b(T t) {
        if (this.k && c((zax) t)) {
            return t;
        }
        if (!isConnected()) {
            this.m.add(t);
            return t;
        }
        this.f10964e.y.a(t);
        return (T) this.f10960a.get(t.h()).doRead((zaw<?>) t);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void connect() {
        this.f10965f.lock();
        try {
            if (this.n) {
                return;
            }
            this.n = true;
            this.o = null;
            this.p = null;
            this.q = null;
            this.r = null;
            this.f10963d.g();
            this.f10963d.a(this.f10960a.values()).a(new HandlerExecutor(this.f10966g), new Z(this));
        } finally {
            this.f10965f.unlock();
        }
    }

    public final boolean d() {
        boolean z;
        this.f10965f.lock();
        try {
            if (this.o == null) {
                if (this.n) {
                    z = true;
                    return z;
                }
            }
            z = false;
            return z;
        } finally {
            this.f10965f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void disconnect() {
        this.f10965f.lock();
        try {
            this.n = false;
            this.o = null;
            this.p = null;
            if (this.q != null) {
                this.q.a();
                this.q = null;
            }
            this.r = null;
            while (!this.m.isEmpty()) {
                BaseImplementation.ApiMethodImpl<?, ?> remove = this.m.remove();
                remove.a((N) null);
                remove.a();
            }
            this.i.signalAll();
        } finally {
            this.f10965f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean isConnected() {
        boolean z;
        this.f10965f.lock();
        try {
            if (this.o != null) {
                if (this.r == null) {
                    z = true;
                    return z;
                }
            }
            z = false;
            return z;
        } finally {
            this.f10965f.unlock();
        }
    }

    public final ConnectionResult a(Api<?> api) {
        return a(api.a());
    }

    private final ConnectionResult a(Api.AnyClientKey<?> anyClientKey) {
        this.f10965f.lock();
        try {
            zaw<?> zawVar = this.f10960a.get(anyClientKey);
            if (this.o != null && zawVar != null) {
                return this.o.get(zawVar.zak());
            }
            this.f10965f.unlock();
            return null;
        } finally {
            this.f10965f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void b() {
        this.f10965f.lock();
        try {
            this.f10963d.a();
            if (this.q != null) {
                this.q.a();
                this.q = null;
            }
            if (this.p == null) {
                this.p = new ArrayMap(this.f10961b.size());
            }
            ConnectionResult connectionResult = new ConnectionResult(4);
            Iterator<zaw<?>> it = this.f10961b.values().iterator();
            while (it.hasNext()) {
                this.p.put(it.next().zak(), connectionResult);
            }
            if (this.o != null) {
                this.o.putAll(this.p);
            }
        } finally {
            this.f10965f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final ConnectionResult c() {
        connect();
        while (d()) {
            try {
                this.i.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.f10647a;
        }
        ConnectionResult connectionResult = this.r;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean a(SignInConnectionListener signInConnectionListener) {
        this.f10965f.lock();
        try {
            if (this.n && !e()) {
                this.f10963d.g();
                this.q = new C0797a(this, signInConnectionListener);
                this.f10963d.a(this.f10961b.values()).a(new HandlerExecutor(this.f10966g), this.q);
                this.f10965f.unlock();
                return true;
            }
            this.f10965f.unlock();
            return false;
        } catch (Throwable th) {
            this.f10965f.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(zaw<?> zawVar, ConnectionResult connectionResult) {
        return !connectionResult.R() && !connectionResult.Q() && this.f10962c.get(zawVar.getApi()).booleanValue() && zawVar.a().requiresGooglePlayServices() && this.f10967h.c(connectionResult.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(zax zaxVar, boolean z) {
        zaxVar.n = false;
        return false;
    }
}

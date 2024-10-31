package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public final class U implements zabs {

    /* renamed from: a */
    private final Context f10805a;

    /* renamed from: b */
    private final zaaw f10806b;

    /* renamed from: c */
    private final Looper f10807c;

    /* renamed from: d */
    private final zabe f10808d;

    /* renamed from: e */
    private final zabe f10809e;

    /* renamed from: f */
    private final Map<Api.AnyClientKey<?>, zabe> f10810f;

    /* renamed from: h */
    private final Api.Client f10812h;
    private Bundle i;
    private final Lock m;

    /* renamed from: g */
    private final Set<SignInConnectionListener> f10811g = Collections.newSetFromMap(new WeakHashMap());
    private ConnectionResult j = null;
    private ConnectionResult k = null;
    private boolean l = false;
    private int n = 0;

    private U(Context context, zaaw zaawVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, Map<Api.AnyClientKey<?>, Api.Client> map2, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, Api.Client client, ArrayList<zaq> arrayList, ArrayList<zaq> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        this.f10805a = context;
        this.f10806b = zaawVar;
        this.m = lock;
        this.f10807c = looper;
        this.f10812h = client;
        this.f10808d = new zabe(context, this.f10806b, lock, looper, googleApiAvailabilityLight, map2, null, map4, null, arrayList2, new W(this, null));
        this.f10809e = new zabe(context, this.f10806b, lock, looper, googleApiAvailabilityLight, map, clientSettings, map3, abstractClientBuilder, arrayList, new X(this, null));
        ArrayMap arrayMap = new ArrayMap();
        Iterator<Api.AnyClientKey<?>> it = map2.keySet().iterator();
        while (it.hasNext()) {
            arrayMap.put(it.next(), this.f10808d);
        }
        Iterator<Api.AnyClientKey<?>> it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            arrayMap.put(it2.next(), this.f10809e);
        }
        this.f10810f = Collections.unmodifiableMap(arrayMap);
    }

    public static U a(Context context, zaaw zaawVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, ArrayList<zaq> arrayList) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        Api.Client client = null;
        for (Map.Entry<Api.AnyClientKey<?>, Api.Client> entry : map.entrySet()) {
            Api.Client value = entry.getValue();
            if (value.providesSignIn()) {
                client = value;
            }
            if (value.requiresSignIn()) {
                arrayMap.put(entry.getKey(), value);
            } else {
                arrayMap2.put(entry.getKey(), value);
            }
        }
        Preconditions.b(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api<?> api : map2.keySet()) {
            Api.AnyClientKey<?> a2 = api.a();
            if (arrayMap.containsKey(a2)) {
                arrayMap3.put(api, map2.get(api));
            } else if (arrayMap2.containsKey(a2)) {
                arrayMap4.put(api, map2.get(api));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            zaq zaqVar = arrayList.get(i);
            i++;
            zaq zaqVar2 = zaqVar;
            if (arrayMap3.containsKey(zaqVar2.f10953a)) {
                arrayList2.add(zaqVar2);
            } else if (arrayMap4.containsKey(zaqVar2.f10953a)) {
                arrayList3.add(zaqVar2);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new U(context, zaawVar, lock, looper, googleApiAvailabilityLight, arrayMap, arrayMap2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    private final PendingIntent e() {
        if (this.f10812h == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f10805a, System.identityHashCode(this.f10806b), this.f10812h.getSignInIntent(), 134217728);
    }

    public final void f() {
        ConnectionResult connectionResult;
        if (b(this.j)) {
            if (!b(this.k) && !h()) {
                ConnectionResult connectionResult2 = this.k;
                if (connectionResult2 != null) {
                    if (this.n == 1) {
                        g();
                        return;
                    } else {
                        a(connectionResult2);
                        this.f10808d.disconnect();
                        return;
                    }
                }
                return;
            }
            int i = this.n;
            if (i != 1) {
                if (i != 2) {
                    Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                    this.n = 0;
                    return;
                }
                this.f10806b.a(this.i);
            }
            g();
            this.n = 0;
            return;
        }
        if (this.j != null && b(this.k)) {
            this.f10809e.disconnect();
            a(this.j);
            return;
        }
        ConnectionResult connectionResult3 = this.j;
        if (connectionResult3 == null || (connectionResult = this.k) == null) {
            return;
        }
        if (this.f10809e.m < this.f10808d.m) {
            connectionResult3 = connectionResult;
        }
        a(connectionResult3);
    }

    private final void g() {
        Iterator<SignInConnectionListener> it = this.f10811g.iterator();
        while (it.hasNext()) {
            it.next().onComplete();
        }
        this.f10811g.clear();
    }

    private final boolean h() {
        ConnectionResult connectionResult = this.k;
        return connectionResult != null && connectionResult.a() == 4;
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T b(T t) {
        if (c((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>) t)) {
            if (h()) {
                t.c(new Status(4, null, e()));
                return t;
            }
            return (T) this.f10809e.b((zabe) t);
        }
        return (T) this.f10808d.b((zabe) t);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final ConnectionResult c() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void connect() {
        this.n = 2;
        this.l = false;
        this.k = null;
        this.j = null;
        this.f10808d.connect();
        this.f10809e.connect();
    }

    public final boolean d() {
        this.m.lock();
        try {
            return this.n == 2;
        } finally {
            this.m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void disconnect() {
        this.k = null;
        this.j = null;
        this.n = 0;
        this.f10808d.disconnect();
        this.f10809e.disconnect();
        g();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.f10809e.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.f10808d.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:            if (r2.n == 1) goto L33;     */
    @Override // com.google.android.gms.common.api.internal.zabs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isConnected() {
        /*
            r2 = this;
            java.util.concurrent.locks.Lock r0 = r2.m
            r0.lock()
            com.google.android.gms.common.api.internal.zabe r0 = r2.f10808d     // Catch: java.lang.Throwable -> L28
            boolean r0 = r0.isConnected()     // Catch: java.lang.Throwable -> L28
            r1 = 1
            if (r0 == 0) goto L21
            com.google.android.gms.common.api.internal.zabe r0 = r2.f10809e     // Catch: java.lang.Throwable -> L28
            boolean r0 = r0.isConnected()     // Catch: java.lang.Throwable -> L28
            if (r0 != 0) goto L22
            boolean r0 = r2.h()     // Catch: java.lang.Throwable -> L28
            if (r0 != 0) goto L22
            int r0 = r2.n     // Catch: java.lang.Throwable -> L28
            if (r0 != r1) goto L21
            goto L22
        L21:
            r1 = 0
        L22:
            java.util.concurrent.locks.Lock r0 = r2.m
            r0.unlock()
            return r1
        L28:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r2.m
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.U.isConnected():boolean");
    }

    private final boolean c(BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient> apiMethodImpl) {
        Api.AnyClientKey<? extends Api.AnyClient> h2 = apiMethodImpl.h();
        Preconditions.a(this.f10810f.containsKey(h2), "GoogleApiClient is not configured to use the API required for this call.");
        return this.f10810f.get(h2).equals(this.f10809e);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void b() {
        this.m.lock();
        try {
            boolean d2 = d();
            this.f10809e.disconnect();
            this.k = new ConnectionResult(4);
            if (d2) {
                new zap(this.f10807c).post(new V(this));
            } else {
                g();
            }
        } finally {
            this.m.unlock();
        }
    }

    private static boolean b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.R();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T a(T t) {
        if (c((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>) t)) {
            if (h()) {
                t.c(new Status(4, null, e()));
                return t;
            }
            return (T) this.f10809e.a((zabe) t);
        }
        return (T) this.f10808d.a((zabe) t);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean a(SignInConnectionListener signInConnectionListener) {
        this.m.lock();
        try {
            if ((d() || isConnected()) && !this.f10809e.isConnected()) {
                this.f10811g.add(signInConnectionListener);
                if (this.n == 0) {
                    this.n = 1;
                }
                this.k = null;
                this.f10809e.connect();
                return true;
            }
            this.m.unlock();
            return false;
        } finally {
            this.m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void a() {
        this.f10808d.a();
        this.f10809e.a();
    }

    private final void a(ConnectionResult connectionResult) {
        int i = this.n;
        if (i != 1) {
            if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.n = 0;
            }
            this.f10806b.a(connectionResult);
        }
        g();
        this.n = 0;
    }

    public final void a(int i, boolean z) {
        this.f10806b.a(i, z);
        this.k = null;
        this.j = null;
    }

    public final void a(Bundle bundle) {
        Bundle bundle2 = this.i;
        if (bundle2 == null) {
            this.i = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }
}

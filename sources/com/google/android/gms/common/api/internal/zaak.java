package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public final class zaak implements zabd {

    /* renamed from: a, reason: collision with root package name */
    private final zabe f10872a;

    /* renamed from: b, reason: collision with root package name */
    private final Lock f10873b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f10874c;

    /* renamed from: d, reason: collision with root package name */
    private final GoogleApiAvailabilityLight f10875d;

    /* renamed from: e, reason: collision with root package name */
    private ConnectionResult f10876e;

    /* renamed from: f, reason: collision with root package name */
    private int f10877f;

    /* renamed from: h, reason: collision with root package name */
    private int f10879h;
    private zad k;
    private boolean l;
    private boolean m;
    private boolean n;
    private IAccountAccessor o;
    private boolean p;
    private boolean q;
    private final ClientSettings r;
    private final Map<Api<?>, Boolean> s;
    private final Api.AbstractClientBuilder<? extends zad, SignInOptions> t;

    /* renamed from: g, reason: collision with root package name */
    private int f10878g = 0;
    private final Bundle i = new Bundle();
    private final Set<Api.AnyClientKey> j = new HashSet();
    private ArrayList<Future<?>> u = new ArrayList<>();

    public zaak(zabe zabeVar, ClientSettings clientSettings, Map<Api<?>, Boolean> map, GoogleApiAvailabilityLight googleApiAvailabilityLight, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, Lock lock, Context context) {
        this.f10872a = zabeVar;
        this.r = clientSettings;
        this.s = map;
        this.f10875d = googleApiAvailabilityLight;
        this.t = abstractClientBuilder;
        this.f10873b = lock;
        this.f10874c = context;
    }

    private static String b(int i) {
        return i != 0 ? i != 1 ? "UNKNOWN" : "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b() {
        this.f10879h--;
        int i = this.f10879h;
        if (i > 0) {
            return false;
        }
        if (i < 0) {
            Log.w("GoogleApiClientConnecting", this.f10872a.n.n());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            b(new ConnectionResult(8, null));
            return false;
        }
        ConnectionResult connectionResult = this.f10876e;
        if (connectionResult == null) {
            return true;
        }
        this.f10872a.m = this.f10877f;
        b(connectionResult);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        if (this.f10879h != 0) {
            return;
        }
        if (!this.m || this.n) {
            ArrayList arrayList = new ArrayList();
            this.f10878g = 1;
            this.f10879h = this.f10872a.f10894f.size();
            for (Api.AnyClientKey<?> anyClientKey : this.f10872a.f10894f.keySet()) {
                if (this.f10872a.f10895g.containsKey(anyClientKey)) {
                    if (b()) {
                        d();
                    }
                } else {
                    arrayList.add(this.f10872a.f10894f.get(anyClientKey));
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.u.add(zabh.a().submit(new C0808l(this, arrayList)));
        }
    }

    private final void d() {
        this.f10872a.f();
        zabh.a().execute(new RunnableC0803g(this));
        zad zadVar = this.k;
        if (zadVar != null) {
            if (this.p) {
                zadVar.a(this.o, this.q);
            }
            a(false);
        }
        Iterator<Api.AnyClientKey<?>> it = this.f10872a.f10895g.keySet().iterator();
        while (it.hasNext()) {
            this.f10872a.f10894f.get(it.next()).disconnect();
        }
        this.f10872a.o.a(this.i.isEmpty() ? null : this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        this.m = false;
        this.f10872a.n.q = Collections.emptySet();
        for (Api.AnyClientKey<?> anyClientKey : this.j) {
            if (!this.f10872a.f10895g.containsKey(anyClientKey)) {
                this.f10872a.f10895g.put(anyClientKey, new ConnectionResult(17, null));
            }
        }
    }

    private final void f() {
        ArrayList<Future<?>> arrayList = this.u;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Future<?> future = arrayList.get(i);
            i++;
            future.cancel(true);
        }
        this.u.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<Scope> g() {
        ClientSettings clientSettings = this.r;
        if (clientSettings == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(clientSettings.i());
        Map<Api<?>, ClientSettings.OptionalApiSettings> f2 = this.r.f();
        for (Api<?> api : f2.keySet()) {
            if (!this.f10872a.f10895g.containsKey(api.a())) {
                hashSet.addAll(f2.get(api).f11080a);
            }
        }
        return hashSet;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void a() {
        this.f10872a.f10895g.clear();
        this.m = false;
        RunnableC0803g runnableC0803g = null;
        this.f10876e = null;
        this.f10878g = 0;
        this.l = true;
        this.n = false;
        this.p = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api<?> api : this.s.keySet()) {
            Api.Client client = this.f10872a.f10894f.get(api.a());
            z |= api.c().a() == 1;
            boolean booleanValue = this.s.get(api).booleanValue();
            if (client.requiresSignIn()) {
                this.m = true;
                if (booleanValue) {
                    this.j.add(api.a());
                } else {
                    this.l = false;
                }
            }
            hashMap.put(client, new C0804h(this, api, booleanValue));
        }
        if (z) {
            this.m = false;
        }
        if (this.m) {
            this.r.a(Integer.valueOf(System.identityHashCode(this.f10872a.n)));
            C0811o c0811o = new C0811o(this, runnableC0803g);
            Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder = this.t;
            Context context = this.f10874c;
            Looper g2 = this.f10872a.n.g();
            ClientSettings clientSettings = this.r;
            this.k = abstractClientBuilder.a(context, g2, clientSettings, clientSettings.j(), c0811o, c0811o);
        }
        this.f10879h = this.f10872a.f10894f.size();
        this.u.add(zabh.a().submit(new C0805i(this, hashMap)));
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void connect() {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final boolean disconnect() {
        f();
        a(true);
        this.f10872a.a((ConnectionResult) null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void onConnected(Bundle bundle) {
        if (a(1)) {
            if (bundle != null) {
                this.i.putAll(bundle);
            }
            if (b()) {
                d();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void onConnectionSuspended(int i) {
        b(new ConnectionResult(8, null));
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T b(T t) {
        this.f10872a.n.i.add(t);
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0022, code lost:            if ((r5.Q() || r4.f10875d.a(r5.a()) != null) != false) goto L12;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(com.google.android.gms.common.ConnectionResult r5, com.google.android.gms.common.api.Api<?> r6, boolean r7) {
        /*
            r4 = this;
            com.google.android.gms.common.api.Api$BaseClientBuilder r0 = r6.c()
            int r0 = r0.a()
            r1 = 0
            r2 = 1
            if (r7 == 0) goto L24
            boolean r7 = r5.Q()
            if (r7 == 0) goto L14
        L12:
            r7 = 1
            goto L22
        L14:
            com.google.android.gms.common.GoogleApiAvailabilityLight r7 = r4.f10875d
            int r3 = r5.a()
            android.content.Intent r7 = r7.a(r3)
            if (r7 == 0) goto L21
            goto L12
        L21:
            r7 = 0
        L22:
            if (r7 == 0) goto L2d
        L24:
            com.google.android.gms.common.ConnectionResult r7 = r4.f10876e
            if (r7 == 0) goto L2c
            int r7 = r4.f10877f
            if (r0 >= r7) goto L2d
        L2c:
            r1 = 1
        L2d:
            if (r1 == 0) goto L33
            r4.f10876e = r5
            r4.f10877f = r0
        L33:
            com.google.android.gms.common.api.internal.zabe r7 = r4.f10872a
            java.util.Map<com.google.android.gms.common.api.Api$AnyClientKey<?>, com.google.android.gms.common.ConnectionResult> r7 = r7.f10895g
            com.google.android.gms.common.api.Api$AnyClientKey r6 = r6.a()
            r7.put(r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zaak.b(com.google.android.gms.common.ConnectionResult, com.google.android.gms.common.api.Api, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(ConnectionResult connectionResult) {
        f();
        a(!connectionResult.Q());
        this.f10872a.a(connectionResult);
        this.f10872a.o.a(connectionResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(com.google.android.gms.signin.internal.zaj zajVar) {
        if (a(0)) {
            ConnectionResult a2 = zajVar.a();
            if (a2.R()) {
                ResolveAccountResponse O = zajVar.O();
                ConnectionResult O2 = O.O();
                if (!O2.R()) {
                    String valueOf = String.valueOf(O2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                    sb.append("Sign-in succeeded with resolve account failure: ");
                    sb.append(valueOf);
                    Log.wtf("GoogleApiClientConnecting", sb.toString(), new Exception());
                    b(O2);
                    return;
                }
                this.n = true;
                this.o = O.a();
                this.p = O.P();
                this.q = O.Q();
                c();
                return;
            }
            if (a(a2)) {
                e();
                c();
            } else {
                b(a2);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void a(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (a(1)) {
            b(connectionResult, api, z);
            if (b()) {
                d();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T a(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(ConnectionResult connectionResult) {
        return this.l && !connectionResult.Q();
    }

    private final void a(boolean z) {
        zad zadVar = this.k;
        if (zadVar != null) {
            if (zadVar.isConnected() && z) {
                this.k.b();
            }
            this.k.disconnect();
            if (this.r.k()) {
                this.k = null;
            }
            this.o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(int i) {
        if (this.f10878g == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.f10872a.n.n());
        String valueOf = String.valueOf(this);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
        sb.append("Unexpected callback in ");
        sb.append(valueOf);
        Log.w("GoogleApiClientConnecting", sb.toString());
        int i2 = this.f10879h;
        StringBuilder sb2 = new StringBuilder(33);
        sb2.append("mRemainingConnections=");
        sb2.append(i2);
        Log.w("GoogleApiClientConnecting", sb2.toString());
        String b2 = b(this.f10878g);
        String b3 = b(i);
        StringBuilder sb3 = new StringBuilder(String.valueOf(b2).length() + 70 + String.valueOf(b3).length());
        sb3.append("GoogleApiClient connecting is in step ");
        sb3.append(b2);
        sb3.append(" but received callback for step ");
        sb3.append(b3);
        Log.wtf("GoogleApiClientConnecting", sb3.toString(), new Exception());
        b(new ConnectionResult(8, null));
        return false;
    }
}

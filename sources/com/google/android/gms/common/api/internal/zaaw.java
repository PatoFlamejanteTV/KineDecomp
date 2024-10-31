package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClientEventManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public final class zaaw extends GoogleApiClient implements zabt {

    /* renamed from: b, reason: collision with root package name */
    private final Lock f10881b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f10882c;

    /* renamed from: d, reason: collision with root package name */
    private final GmsClientEventManager f10883d;

    /* renamed from: f, reason: collision with root package name */
    private final int f10885f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f10886g;

    /* renamed from: h, reason: collision with root package name */
    private final Looper f10887h;
    private volatile boolean j;
    private long k;
    private long l;
    private final HandlerC0816u m;
    private final GoogleApiAvailability n;

    @VisibleForTesting
    private zabq o;
    final Map<Api.AnyClientKey<?>, Api.Client> p;
    Set<Scope> q;
    private final ClientSettings r;
    private final Map<Api<?>, Boolean> s;
    private final Api.AbstractClientBuilder<? extends zad, SignInOptions> t;
    private final ListenerHolders u;
    private final ArrayList<zaq> v;
    private Integer w;
    Set<zacm> x;
    final zacp y;
    private final GmsClientEventManager.GmsClientEventState z;

    /* renamed from: e, reason: collision with root package name */
    private zabs f10884e = null;

    @VisibleForTesting
    final Queue<BaseImplementation.ApiMethodImpl<?, ?>> i = new LinkedList();

    public zaaw(Context context, Lock lock, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, Map<Api<?>, Boolean> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.AnyClientKey<?>, Api.Client> map2, int i, int i2, ArrayList<zaq> arrayList, boolean z) {
        this.k = ClientLibraryUtils.a() ? 10000L : 120000L;
        this.l = 5000L;
        this.q = new HashSet();
        this.u = new ListenerHolders();
        this.w = null;
        this.x = null;
        this.z = new C0813q(this);
        this.f10886g = context;
        this.f10881b = lock;
        this.f10882c = false;
        this.f10883d = new GmsClientEventManager(looper, this.z);
        this.f10887h = looper;
        this.m = new HandlerC0816u(this, looper);
        this.n = googleApiAvailability;
        this.f10885f = i;
        if (this.f10885f >= 0) {
            this.w = Integer.valueOf(i2);
        }
        this.s = map;
        this.p = map2;
        this.v = arrayList;
        this.y = new zacp(this.p);
        Iterator<GoogleApiClient.ConnectionCallbacks> it = list.iterator();
        while (it.hasNext()) {
            this.f10883d.a(it.next());
        }
        Iterator<GoogleApiClient.OnConnectionFailedListener> it2 = list2.iterator();
        while (it2.hasNext()) {
            this.f10883d.a(it2.next());
        }
        this.r = clientSettings;
        this.t = abstractClientBuilder;
    }

    private static String c(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "UNKNOWN" : "SIGN_IN_MODE_NONE" : "SIGN_IN_MODE_OPTIONAL" : "SIGN_IN_MODE_REQUIRED";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        this.f10881b.lock();
        try {
            if (this.j) {
                p();
            }
        } finally {
            this.f10881b.unlock();
        }
    }

    private final void p() {
        this.f10883d.b();
        this.f10884e.connect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        this.f10881b.lock();
        try {
            if (l()) {
                p();
            }
        } finally {
            this.f10881b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T a(T t) {
        Preconditions.a(t.h() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.p.containsKey(t.h());
        String b2 = t.g() != null ? t.g().b() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(b2).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(b2);
        sb.append(" required for this call.");
        Preconditions.a(containsKey, sb.toString());
        this.f10881b.lock();
        try {
            if (this.f10884e == null) {
                this.i.add(t);
                return t;
            }
            return (T) this.f10884e.b(t);
        } finally {
            this.f10881b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T b(T t) {
        Preconditions.a(t.h() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.p.containsKey(t.h());
        String b2 = t.g() != null ? t.g().b() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(b2).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(b2);
        sb.append(" required for this call.");
        Preconditions.a(containsKey, sb.toString());
        this.f10881b.lock();
        try {
            if (this.f10884e != null) {
                if (this.j) {
                    this.i.add(t);
                    while (!this.i.isEmpty()) {
                        BaseImplementation.ApiMethodImpl<?, ?> remove = this.i.remove();
                        this.y.a(remove);
                        remove.c(Status.f10706c);
                    }
                    return t;
                }
                return (T) this.f10884e.a((zabs) t);
            }
            throw new IllegalStateException("GoogleApiClient is not connected yet.");
        } finally {
            this.f10881b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void c() {
        this.f10881b.lock();
        try {
            if (this.f10885f >= 0) {
                Preconditions.b(this.w != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.w == null) {
                this.w = Integer.valueOf(a((Iterable<Api.Client>) this.p.values(), false));
            } else if (this.w.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            a(this.w.intValue());
        } finally {
            this.f10881b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void d() {
        this.f10881b.lock();
        try {
            this.y.a();
            if (this.f10884e != null) {
                this.f10884e.disconnect();
            }
            this.u.a();
            for (BaseImplementation.ApiMethodImpl<?, ?> apiMethodImpl : this.i) {
                apiMethodImpl.a((N) null);
                apiMethodImpl.a();
            }
            this.i.clear();
            if (this.f10884e == null) {
                return;
            }
            l();
            this.f10883d.a();
        } finally {
            this.f10881b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Context f() {
        return this.f10886g;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper g() {
        return this.f10887h;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void h() {
        zabs zabsVar = this.f10884e;
        if (zabsVar != null) {
            zabsVar.b();
        }
    }

    public final boolean j() {
        zabs zabsVar = this.f10884e;
        return zabsVar != null && zabsVar.isConnected();
    }

    public final void k() {
        d();
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean l() {
        if (!this.j) {
            return false;
        }
        this.j = false;
        this.m.removeMessages(2);
        this.m.removeMessages(1);
        zabq zabqVar = this.o;
        if (zabqVar != null) {
            zabqVar.a();
            this.o = null;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean m() {
        this.f10881b.lock();
        try {
            if (this.x == null) {
                this.f10881b.unlock();
                return false;
            }
            return !this.x.isEmpty();
        } finally {
            this.f10881b.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String n() {
        StringWriter stringWriter = new StringWriter();
        a("", (FileDescriptor) null, new PrintWriter(stringWriter), (String[]) null);
        return stringWriter.toString();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <C extends Api.Client> C a(Api.AnyClientKey<C> anyClientKey) {
        C c2 = (C) this.p.get(anyClientKey);
        Preconditions.a(c2, "Appropriate Api was not requested.");
        return c2;
    }

    public final void a(int i) {
        this.f10881b.lock();
        boolean z = true;
        if (i != 3 && i != 1 && i != 2) {
            z = false;
        }
        try {
            StringBuilder sb = new StringBuilder(33);
            sb.append("Illegal sign-in mode: ");
            sb.append(i);
            Preconditions.a(z, sb.toString());
            b(i);
            p();
        } finally {
            this.f10881b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final PendingResult<Status> b() {
        Preconditions.b(j(), "GoogleApiClient is not connected yet.");
        Preconditions.b(this.w.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        StatusPendingResult statusPendingResult = new StatusPendingResult(this);
        if (this.p.containsKey(Common.f11166a)) {
            a(this, statusPendingResult, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient a2 = new GoogleApiClient.Builder(this.f10886g).a(Common.f11168c).a(new r(this, atomicReference, statusPendingResult)).a(new C0814s(this, statusPendingResult)).a(this.m).a();
            atomicReference.set(a2);
            a2.c();
        }
        return statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult a() {
        boolean z = true;
        Preconditions.b(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.f10881b.lock();
        try {
            if (this.f10885f >= 0) {
                if (this.w == null) {
                    z = false;
                }
                Preconditions.b(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.w == null) {
                this.w = Integer.valueOf(a((Iterable<Api.Client>) this.p.values(), false));
            } else if (this.w.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            b(this.w.intValue());
            this.f10883d.b();
            return this.f10884e.c();
        } finally {
            this.f10881b.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean z) {
        Common.f11169d.a(googleApiClient).a(new C0815t(this, statusPendingResult, z, googleApiClient));
    }

    private final void b(int i) {
        Integer num = this.w;
        if (num == null) {
            this.w = Integer.valueOf(i);
        } else if (num.intValue() != i) {
            String c2 = c(i);
            String c3 = c(this.w.intValue());
            StringBuilder sb = new StringBuilder(String.valueOf(c2).length() + 51 + String.valueOf(c3).length());
            sb.append("Cannot use sign-in mode: ");
            sb.append(c2);
            sb.append(". Mode was already set to ");
            sb.append(c3);
            throw new IllegalStateException(sb.toString());
        }
        if (this.f10884e != null) {
            return;
        }
        boolean z = false;
        boolean z2 = false;
        for (Api.Client client : this.p.values()) {
            if (client.requiresSignIn()) {
                z = true;
            }
            if (client.providesSignIn()) {
                z2 = true;
            }
        }
        int intValue = this.w.intValue();
        if (intValue == 1) {
            if (!z) {
                throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            }
            if (z2) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
        } else if (intValue == 2 && z) {
            if (this.f10882c) {
                this.f10884e = new zax(this.f10886g, this.f10881b, this.f10887h, this.n, this.p, this.r, this.s, this.t, this.v, this, true);
                return;
            } else {
                this.f10884e = U.a(this.f10886g, this, this.f10881b, this.f10887h, this.n, this.p, this.r, this.s, this.t, this.v);
                return;
            }
        }
        if (this.f10882c && !z2) {
            this.f10884e = new zax(this.f10886g, this.f10881b, this.f10887h, this.n, this.p, this.r, this.s, this.t, this.v, this, false);
        } else {
            this.f10884e = new zabe(this.f10886g, this, this.f10881b, this.f10887h, this.n, this.p, this.r, this.s, this.t, this.v, this);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void a(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f10883d.a(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void a(Bundle bundle) {
        while (!this.i.isEmpty()) {
            b((zaaw) this.i.remove());
        }
        this.f10883d.a(bundle);
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void a(ConnectionResult connectionResult) {
        if (!this.n.b(this.f10886g, connectionResult.a())) {
            l();
        }
        if (this.j) {
            return;
        }
        this.f10883d.a(connectionResult);
        this.f10883d.a();
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void a(int i, boolean z) {
        if (i == 1 && !z && !this.j) {
            this.j = true;
            if (this.o == null && !ClientLibraryUtils.a()) {
                this.o = this.n.a(this.f10886g.getApplicationContext(), new C0817v(this));
            }
            HandlerC0816u handlerC0816u = this.m;
            handlerC0816u.sendMessageDelayed(handlerC0816u.obtainMessage(1), this.k);
            HandlerC0816u handlerC0816u2 = this.m;
            handlerC0816u2.sendMessageDelayed(handlerC0816u2.obtainMessage(2), this.l);
        }
        this.y.b();
        this.f10883d.a(i);
        this.f10883d.a();
        if (i == 2) {
            p();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void b(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f10883d.b(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean a(SignInConnectionListener signInConnectionListener) {
        zabs zabsVar = this.f10884e;
        return zabsVar != null && zabsVar.a(signInConnectionListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void a(zacm zacmVar) {
        this.f10881b.lock();
        try {
            if (this.x == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.x.remove(zacmVar)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!m()) {
                this.f10884e.a();
            }
        } finally {
            this.f10881b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.f10886g);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.j);
        printWriter.append(" mWorkQueue.size()=").print(this.i.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.y.f10925c.size());
        zabs zabsVar = this.f10884e;
        if (zabsVar != null) {
            zabsVar.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public static int a(Iterable<Api.Client> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (Api.Client client : iterable) {
            if (client.requiresSignIn()) {
                z2 = true;
            }
            if (client.providesSignIn()) {
                z3 = true;
            }
        }
        if (z2) {
            return (z3 && z) ? 2 : 1;
        }
        return 3;
    }
}

package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.api.internal.zacm;
import com.google.android.gms.common.api.internal.zaj;
import com.google.android.gms.common.api.internal.zaq;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class GoogleApiClient {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<GoogleApiClient> f10690a = Collections.newSetFromMap(new WeakHashMap());

    /* loaded from: classes.dex */
    public interface ConnectionCallbacks {
        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    /* loaded from: classes.dex */
    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    @KeepForSdk
    public static Set<GoogleApiClient> e() {
        Set<GoogleApiClient> set;
        synchronized (f10690a) {
            set = f10690a;
        }
        return set;
    }

    public abstract ConnectionResult a();

    @KeepForSdk
    public <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T a(T t) {
        throw new UnsupportedOperationException();
    }

    public abstract void a(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract PendingResult<Status> b();

    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T b(T t) {
        throw new UnsupportedOperationException();
    }

    public abstract void b(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void c();

    public abstract void d();

    @KeepForSdk
    public Context f() {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public Looper g() {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public void h() {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private Account f10691a;

        /* renamed from: d, reason: collision with root package name */
        private int f10694d;

        /* renamed from: e, reason: collision with root package name */
        private View f10695e;

        /* renamed from: f, reason: collision with root package name */
        private String f10696f;

        /* renamed from: g, reason: collision with root package name */
        private String f10697g;
        private final Context j;
        private LifecycleActivity l;
        private OnConnectionFailedListener n;
        private Looper o;

        /* renamed from: b, reason: collision with root package name */
        private final Set<Scope> f10692b = new HashSet();

        /* renamed from: c, reason: collision with root package name */
        private final Set<Scope> f10693c = new HashSet();

        /* renamed from: h, reason: collision with root package name */
        private final Map<Api<?>, ClientSettings.OptionalApiSettings> f10698h = new ArrayMap();
        private boolean i = false;
        private final Map<Api<?>, Api.ApiOptions> k = new ArrayMap();
        private int m = -1;
        private GoogleApiAvailability p = GoogleApiAvailability.a();
        private Api.AbstractClientBuilder<? extends zad, SignInOptions> q = zaa.f14143c;
        private final ArrayList<ConnectionCallbacks> r = new ArrayList<>();
        private final ArrayList<OnConnectionFailedListener> s = new ArrayList<>();
        private boolean t = false;

        @KeepForSdk
        public Builder(Context context) {
            this.j = context;
            this.o = context.getMainLooper();
            this.f10696f = context.getPackageName();
            this.f10697g = context.getClass().getName();
        }

        public final Builder a(Handler handler) {
            Preconditions.a(handler, (Object) "Handler must not be null");
            this.o = handler.getLooper();
            return this;
        }

        @VisibleForTesting
        @KeepForSdk
        public final ClientSettings b() {
            SignInOptions signInOptions = SignInOptions.f14122a;
            if (this.k.containsKey(zaa.f14147g)) {
                signInOptions = (SignInOptions) this.k.get(zaa.f14147g);
            }
            return new ClientSettings(this.f10691a, this.f10692b, this.f10698h, this.f10694d, this.f10695e, this.f10696f, this.f10697g, signInOptions, false);
        }

        public final Builder a(ConnectionCallbacks connectionCallbacks) {
            Preconditions.a(connectionCallbacks, "Listener must not be null");
            this.r.add(connectionCallbacks);
            return this;
        }

        public final Builder a(OnConnectionFailedListener onConnectionFailedListener) {
            Preconditions.a(onConnectionFailedListener, "Listener must not be null");
            this.s.add(onConnectionFailedListener);
            return this;
        }

        public final Builder a(Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            Preconditions.a(api, "Api must not be null");
            this.k.put(api, null);
            List<Scope> a2 = api.c().a(null);
            this.f10693c.addAll(a2);
            this.f10692b.addAll(a2);
            return this;
        }

        public final <O extends Api.ApiOptions.HasOptions> Builder a(Api<O> api, O o) {
            Preconditions.a(api, "Api must not be null");
            Preconditions.a(o, "Null options are not permitted for this Api");
            this.k.put(api, o);
            List<Scope> a2 = api.c().a(o);
            this.f10693c.addAll(a2);
            this.f10692b.addAll(a2);
            return this;
        }

        public final Builder a(FragmentActivity fragmentActivity, int i, OnConnectionFailedListener onConnectionFailedListener) {
            LifecycleActivity lifecycleActivity = new LifecycleActivity(fragmentActivity);
            Preconditions.a(i >= 0, "clientId must be non-negative");
            this.m = i;
            this.n = onConnectionFailedListener;
            this.l = lifecycleActivity;
            return this;
        }

        /* JADX WARN: Type inference failed for: r4v18, types: [com.google.android.gms.common.api.Api$Client, java.lang.Object] */
        public final GoogleApiClient a() {
            Preconditions.a(!this.k.isEmpty(), "must call addApi() to add at least one API");
            ClientSettings b2 = b();
            Api<?> api = null;
            Map<Api<?>, ClientSettings.OptionalApiSettings> f2 = b2.f();
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (Api<?> api2 : this.k.keySet()) {
                Api.ApiOptions apiOptions = this.k.get(api2);
                boolean z2 = f2.get(api2) != null;
                arrayMap.put(api2, Boolean.valueOf(z2));
                zaq zaqVar = new zaq(api2, z2);
                arrayList.add(zaqVar);
                Api.AbstractClientBuilder<?, ?> d2 = api2.d();
                ?? a2 = d2.a(this.j, this.o, b2, apiOptions, zaqVar, zaqVar);
                arrayMap2.put(api2.a(), a2);
                if (d2.a() == 1) {
                    z = apiOptions != null;
                }
                if (a2.providesSignIn()) {
                    if (api != null) {
                        String b3 = api2.b();
                        String b4 = api.b();
                        StringBuilder sb = new StringBuilder(String.valueOf(b3).length() + 21 + String.valueOf(b4).length());
                        sb.append(b3);
                        sb.append(" cannot be used with ");
                        sb.append(b4);
                        throw new IllegalStateException(sb.toString());
                    }
                    api = api2;
                }
            }
            if (api != null) {
                if (!z) {
                    Preconditions.b(this.f10691a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.b());
                    Preconditions.b(this.f10692b.equals(this.f10693c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.b());
                } else {
                    String b5 = api.b();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(b5).length() + 82);
                    sb2.append("With using ");
                    sb2.append(b5);
                    sb2.append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                    throw new IllegalStateException(sb2.toString());
                }
            }
            zaaw zaawVar = new zaaw(this.j, new ReentrantLock(), this.o, b2, this.p, this.q, arrayMap, this.r, this.s, arrayMap2, this.m, zaaw.a((Iterable<Api.Client>) arrayMap2.values(), true), arrayList, false);
            synchronized (GoogleApiClient.f10690a) {
                GoogleApiClient.f10690a.add(zaawVar);
            }
            if (this.m >= 0) {
                zaj.b(this.l).a(this.m, zaawVar, this.n);
            }
            return zaawVar;
        }
    }

    @KeepForSdk
    public <C extends Api.Client> C a(Api.AnyClientKey<C> anyClientKey) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public boolean a(SignInConnectionListener signInConnectionListener) {
        throw new UnsupportedOperationException();
    }

    public void a(zacm zacmVar) {
        throw new UnsupportedOperationException();
    }
}

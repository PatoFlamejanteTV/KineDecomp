package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.l;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzli;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzlp;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzqu;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzqx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class GoogleApiClient {

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private Account f975a;
        private final Set<Scope> b;
        private int c;
        private View d;
        private String e;
        private String f;
        private final Map<Api<?>, zzf.zza> g;
        private final Context h;
        private final Map<Api<?>, Api.ApiOptions> i;
        private l j;
        private int k;
        private OnConnectionFailedListener l;
        private Looper m;
        private GoogleApiAvailability n;
        private Api.zza<? extends zzqw, zzqx> o;
        private final ArrayList<ConnectionCallbacks> p;
        private final ArrayList<OnConnectionFailedListener> q;
        private zzqx r;

        public Builder(Context context) {
            this.b = new HashSet();
            this.g = new zzme();
            this.i = new zzme();
            this.k = -1;
            this.n = GoogleApiAvailability.a();
            this.o = zzqu.zzRl;
            this.p = new ArrayList<>();
            this.q = new ArrayList<>();
            this.h = context;
            this.m = context.getMainLooper();
            this.e = context.getPackageName();
            this.f = context.getClass().getName();
        }

        public Builder(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            zzx.a(connectionCallbacks, "Must provide a connected listener");
            this.p.add(connectionCallbacks);
            zzx.a(onConnectionFailedListener, "Must provide a connection failed listener");
            this.q.add(onConnectionFailedListener);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(zzlp zzlpVar, GoogleApiClient googleApiClient) {
            zzlpVar.zza(this.k, googleApiClient, this.l);
        }

        private GoogleApiClient c() {
            zzli zzliVar = new zzli(this.h.getApplicationContext(), this.m, a(), this.n, this.o, this.i, this.p, this.q, this.k);
            zzlp zza = zzlp.zza(this.j);
            if (zza == null) {
                new Handler(this.h.getMainLooper()).post(new a(this, zzliVar));
            } else {
                a(zza, zzliVar);
            }
            return zzliVar;
        }

        public Builder a(Handler handler) {
            zzx.a(handler, "Handler must not be null");
            this.m = handler.getLooper();
            return this;
        }

        public Builder a(Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            zzx.a(api, "Api must not be null");
            this.i.put(api, null);
            this.b.addAll(api.a().zzm(null));
            return this;
        }

        public Builder a(ConnectionCallbacks connectionCallbacks) {
            zzx.a(connectionCallbacks, "Listener must not be null");
            this.p.add(connectionCallbacks);
            return this;
        }

        public Builder a(OnConnectionFailedListener onConnectionFailedListener) {
            zzx.a(onConnectionFailedListener, "Listener must not be null");
            this.q.add(onConnectionFailedListener);
            return this;
        }

        public Builder a(Scope scope) {
            zzx.a(scope, "Scope must not be null");
            this.b.add(scope);
            return this;
        }

        public Builder a(String str) {
            this.f975a = str == null ? null : new Account(str, "com.google");
            return this;
        }

        public zzf a() {
            if (this.i.containsKey(zzqu.API)) {
                zzx.a(this.r == null, "SignIn.API can't be used in conjunction with requestServerAuthCode.");
                this.r = (zzqx) this.i.get(zzqu.API);
            }
            return new zzf(this.f975a, this.b, this.g, this.c, this.d, this.e, this.f, this.r != null ? this.r : zzqx.zzaUZ);
        }

        public GoogleApiClient b() {
            zzx.b(!this.i.isEmpty(), "must call addApi() to add at least one API");
            return this.k >= 0 ? c() : new zzli(this.h, this.m, a(), this.n, this.o, this.i, this.p, this.q, -1);
        }
    }

    /* loaded from: classes.dex */
    public interface ConnectionCallbacks {
        void a(Bundle bundle);

        void a_(int i);
    }

    /* loaded from: classes.dex */
    public interface OnConnectionFailedListener {
        void a(ConnectionResult connectionResult);
    }

    /* loaded from: classes.dex */
    public interface ServerAuthCodeCallbacks {

        /* loaded from: classes.dex */
        public static class CheckResult {

            /* renamed from: a, reason: collision with root package name */
            private boolean f976a;
            private Set<Scope> b;

            public boolean a() {
                return this.f976a;
            }

            public Set<Scope> b() {
                return this.b;
            }
        }

        CheckResult a(String str, Set<Scope> set);

        boolean a(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface zza {
        void a(ConnectionResult connectionResult);

        void b(ConnectionResult connectionResult);
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract ConnectionResult getConnectionResult(Api<?> api);

    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    public int getSessionId() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(Api<?> api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void stopAutoManage(l lVar);

    public abstract void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public <C extends Api.zzb> C zza(Api.zzc<C> zzcVar) {
        throw new UnsupportedOperationException();
    }

    public <A extends Api.zzb, R extends Result, T extends zzlb.zza<R, A>> T zza(T t) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public <A extends Api.zzb, T extends zzlb.zza<? extends Result, A>> T zzb(T t) {
        throw new UnsupportedOperationException();
    }

    public <L> zzlm<L> zzo(L l) {
        throw new UnsupportedOperationException();
    }
}

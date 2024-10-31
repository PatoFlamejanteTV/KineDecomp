package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.signin.zad;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@KeepForSdk
/* loaded from: classes.dex */
public class GoogleApiManager implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public static final Status f10739a = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* renamed from: b, reason: collision with root package name */
    private static final Status f10740b = new Status(4, "The user must be signed in to make this API call.");

    /* renamed from: c, reason: collision with root package name */
    private static final Object f10741c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static GoogleApiManager f10742d;

    /* renamed from: h, reason: collision with root package name */
    private final Context f10746h;
    private final GoogleApiAvailability i;
    private final GoogleApiAvailabilityCache j;
    private final Handler q;

    /* renamed from: e, reason: collision with root package name */
    private long f10743e = 5000;

    /* renamed from: f, reason: collision with root package name */
    private long f10744f = 120000;

    /* renamed from: g, reason: collision with root package name */
    private long f10745g = 10000;
    private final AtomicInteger k = new AtomicInteger(1);
    private final AtomicInteger l = new AtomicInteger(0);
    private final Map<zai<?>, zaa<?>> m = new ConcurrentHashMap(5, 0.75f, 1);
    private zaae n = null;
    private final Set<zai<?>> o = new ArraySet();
    private final Set<zai<?>> p = new ArraySet();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements zach, BaseGmsClient.ConnectionProgressReportCallbacks {

        /* renamed from: a, reason: collision with root package name */
        private final Api.Client f10749a;

        /* renamed from: b, reason: collision with root package name */
        private final zai<?> f10750b;

        /* renamed from: c, reason: collision with root package name */
        private IAccountAccessor f10751c = null;

        /* renamed from: d, reason: collision with root package name */
        private Set<Scope> f10752d = null;

        /* renamed from: e, reason: collision with root package name */
        private boolean f10753e = false;

        public b(Api.Client client, zai<?> zaiVar) {
            this.f10749a = client;
            this.f10750b = zaiVar;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public final void a(ConnectionResult connectionResult) {
            GoogleApiManager.this.q.post(new E(this, connectionResult));
        }

        @Override // com.google.android.gms.common.api.internal.zach
        public final void b(ConnectionResult connectionResult) {
            ((zaa) GoogleApiManager.this.m.get(this.f10750b)).a(connectionResult);
        }

        @Override // com.google.android.gms.common.api.internal.zach
        public final void a(IAccountAccessor iAccountAccessor, Set<Scope> set) {
            if (iAccountAccessor != null && set != null) {
                this.f10751c = iAccountAccessor;
                this.f10752d = set;
                a();
            } else {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                b(new ConnectionResult(4));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a() {
            IAccountAccessor iAccountAccessor;
            if (!this.f10753e || (iAccountAccessor = this.f10751c) == null) {
                return;
            }
            this.f10749a.getRemoteService(iAccountAccessor, this.f10752d);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean a(b bVar, boolean z) {
            bVar.f10753e = true;
            return true;
        }
    }

    @KeepForSdk
    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.f10746h = context;
        this.q = new zap(looper, this);
        this.i = googleApiAvailability;
        this.j = new GoogleApiAvailabilityCache(googleApiAvailability);
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(6));
    }

    public static GoogleApiManager a(Context context) {
        GoogleApiManager googleApiManager;
        synchronized (f10741c) {
            if (f10742d == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                f10742d = new GoogleApiManager(context.getApplicationContext(), handlerThread.getLooper(), GoogleApiAvailability.a());
            }
            googleApiManager = f10742d;
        }
        return googleApiManager;
    }

    @KeepForSdk
    public static void b() {
        synchronized (f10741c) {
            if (f10742d != null) {
                GoogleApiManager googleApiManager = f10742d;
                googleApiManager.l.incrementAndGet();
                googleApiManager.q.sendMessageAtFrontOfQueue(googleApiManager.q.obtainMessage(10));
            }
        }
    }

    public static GoogleApiManager c() {
        GoogleApiManager googleApiManager;
        synchronized (f10741c) {
            Preconditions.a(f10742d, "Must guarantee manager is non-null before using getInstance");
            googleApiManager = f10742d;
        }
        return googleApiManager;
    }

    public final int d() {
        return this.k.getAndIncrement();
    }

    public final void g() {
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(3));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        zaa<?> zaaVar;
        int i = message.what;
        switch (i) {
            case 1:
                this.f10745g = ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.q.removeMessages(12);
                for (zai<?> zaiVar : this.m.keySet()) {
                    Handler handler = this.q;
                    handler.sendMessageDelayed(handler.obtainMessage(12, zaiVar), this.f10745g);
                }
                return true;
            case 2:
                zak zakVar = (zak) message.obj;
                Iterator<zai<?>> it = zakVar.b().iterator();
                while (true) {
                    if (it.hasNext()) {
                        zai<?> next = it.next();
                        zaa<?> zaaVar2 = this.m.get(next);
                        if (zaaVar2 == null) {
                            zakVar.a(next, new ConnectionResult(13), null);
                        } else if (zaaVar2.c()) {
                            zakVar.a(next, ConnectionResult.f10647a, zaaVar2.f().getEndpointPackageName());
                        } else if (zaaVar2.k() != null) {
                            zakVar.a(next, zaaVar2.k(), null);
                        } else {
                            zaaVar2.a(zakVar);
                            zaaVar2.a();
                        }
                    }
                }
                return true;
            case 3:
                for (zaa<?> zaaVar3 : this.m.values()) {
                    zaaVar3.j();
                    zaaVar3.a();
                }
                return true;
            case 4:
            case 8:
            case 13:
                zabv zabvVar = (zabv) message.obj;
                zaa<?> zaaVar4 = this.m.get(zabvVar.f10904c.zak());
                if (zaaVar4 == null) {
                    c(zabvVar.f10904c);
                    zaaVar4 = this.m.get(zabvVar.f10904c.zak());
                }
                if (zaaVar4.d() && this.l.get() != zabvVar.f10903b) {
                    zabvVar.f10902a.a(f10739a);
                    zaaVar4.h();
                } else {
                    zaaVar4.a(zabvVar.f10902a);
                }
                return true;
            case 5:
                int i2 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<zaa<?>> it2 = this.m.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        zaaVar = it2.next();
                        if (zaaVar.b() == i2) {
                        }
                    } else {
                        zaaVar = null;
                    }
                }
                if (zaaVar != null) {
                    String b2 = this.i.b(connectionResult.a());
                    String O = connectionResult.O();
                    StringBuilder sb = new StringBuilder(String.valueOf(b2).length() + 69 + String.valueOf(O).length());
                    sb.append("Error resolution was canceled by the user, original error message: ");
                    sb.append(b2);
                    sb.append(": ");
                    sb.append(O);
                    zaaVar.a(new Status(17, sb.toString()));
                } else {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append("Could not find API instance ");
                    sb2.append(i2);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                }
                return true;
            case 6:
                if (PlatformVersion.a() && (this.f10746h.getApplicationContext() instanceof Application)) {
                    BackgroundDetector.a((Application) this.f10746h.getApplicationContext());
                    BackgroundDetector.a().a(new C0820y(this));
                    if (!BackgroundDetector.a().a(true)) {
                        this.f10745g = 300000L;
                    }
                }
                return true;
            case 7:
                c((GoogleApi<?>) message.obj);
                return true;
            case 9:
                if (this.m.containsKey(message.obj)) {
                    this.m.get(message.obj).e();
                }
                return true;
            case 10:
                Iterator<zai<?>> it3 = this.p.iterator();
                while (it3.hasNext()) {
                    this.m.remove(it3.next()).h();
                }
                this.p.clear();
                return true;
            case 11:
                if (this.m.containsKey(message.obj)) {
                    this.m.get(message.obj).g();
                }
                return true;
            case 12:
                if (this.m.containsKey(message.obj)) {
                    this.m.get(message.obj).l();
                }
                return true;
            case 14:
                C0800d c0800d = (C0800d) message.obj;
                zai<?> b3 = c0800d.b();
                if (!this.m.containsKey(b3)) {
                    c0800d.a().a((TaskCompletionSource<Boolean>) false);
                } else {
                    c0800d.a().a((TaskCompletionSource<Boolean>) Boolean.valueOf(this.m.get(b3).a(false)));
                }
                return true;
            case 15:
                a aVar = (a) message.obj;
                if (this.m.containsKey(aVar.f10747a)) {
                    this.m.get(aVar.f10747a).a(aVar);
                }
                return true;
            case 16:
                a aVar2 = (a) message.obj;
                if (this.m.containsKey(aVar2.f10747a)) {
                    this.m.get(aVar2.f10747a).b(aVar2);
                }
                return true;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final zai<?> f10747a;

        /* renamed from: b, reason: collision with root package name */
        private final Feature f10748b;

        private a(zai<?> zaiVar, Feature feature) {
            this.f10747a = zaiVar;
            this.f10748b = feature;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof a)) {
                a aVar = (a) obj;
                if (Objects.a(this.f10747a, aVar.f10747a) && Objects.a(this.f10748b, aVar.f10748b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.a(this.f10747a, this.f10748b);
        }

        public final String toString() {
            return Objects.a(this).a("key", this.f10747a).a("feature", this.f10748b).toString();
        }

        /* synthetic */ a(zai zaiVar, Feature feature, C0820y c0820y) {
            this(zaiVar, feature);
        }
    }

    /* loaded from: classes.dex */
    public class zaa<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zar {

        /* renamed from: b, reason: collision with root package name */
        private final Api.Client f10756b;

        /* renamed from: c, reason: collision with root package name */
        private final Api.AnyClient f10757c;

        /* renamed from: d, reason: collision with root package name */
        private final zai<O> f10758d;

        /* renamed from: e, reason: collision with root package name */
        private final zaab f10759e;

        /* renamed from: h, reason: collision with root package name */
        private final int f10762h;
        private final zace i;
        private boolean j;

        /* renamed from: a, reason: collision with root package name */
        private final Queue<zab> f10755a = new LinkedList();

        /* renamed from: f, reason: collision with root package name */
        private final Set<zak> f10760f = new HashSet();

        /* renamed from: g, reason: collision with root package name */
        private final Map<ListenerHolder.ListenerKey<?>, zabw> f10761g = new HashMap();
        private final List<a> k = new ArrayList();
        private ConnectionResult l = null;

        public zaa(GoogleApi<O> googleApi) {
            this.f10756b = googleApi.zaa(GoogleApiManager.this.q.getLooper(), this);
            Api.Client client = this.f10756b;
            if (client instanceof SimpleClientAdapter) {
                this.f10757c = ((SimpleClientAdapter) client).c();
            } else {
                this.f10757c = client;
            }
            this.f10758d = googleApi.zak();
            this.f10759e = new zaab();
            this.f10762h = googleApi.getInstanceId();
            if (!this.f10756b.requiresSignIn()) {
                this.i = null;
            } else {
                this.i = googleApi.zaa(GoogleApiManager.this.f10746h, GoogleApiManager.this.q);
            }
        }

        private final boolean b(ConnectionResult connectionResult) {
            synchronized (GoogleApiManager.f10741c) {
                if (GoogleApiManager.this.n == null || !GoogleApiManager.this.o.contains(this.f10758d)) {
                    return false;
                }
                GoogleApiManager.this.n.b(connectionResult, this.f10762h);
                return true;
            }
        }

        private final void c(zab zabVar) {
            zabVar.a(this.f10759e, d());
            try {
                zabVar.a((zaa<?>) this);
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                this.f10756b.disconnect();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void n() {
            j();
            c(ConnectionResult.f10647a);
            q();
            Iterator<zabw> it = this.f10761g.values().iterator();
            while (it.hasNext()) {
                zabw next = it.next();
                if (a(next.f10905a.c()) != null) {
                    it.remove();
                } else {
                    try {
                        next.f10905a.a(this.f10757c, new TaskCompletionSource<>());
                    } catch (DeadObjectException unused) {
                        onConnectionSuspended(1);
                        this.f10756b.disconnect();
                    } catch (RemoteException unused2) {
                        it.remove();
                    }
                }
            }
            p();
            r();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void o() {
            j();
            this.j = true;
            this.f10759e.c();
            GoogleApiManager.this.q.sendMessageDelayed(Message.obtain(GoogleApiManager.this.q, 9, this.f10758d), GoogleApiManager.this.f10743e);
            GoogleApiManager.this.q.sendMessageDelayed(Message.obtain(GoogleApiManager.this.q, 11, this.f10758d), GoogleApiManager.this.f10744f);
            GoogleApiManager.this.j.a();
        }

        private final void p() {
            ArrayList arrayList = new ArrayList(this.f10755a);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                zab zabVar = (zab) obj;
                if (!this.f10756b.isConnected()) {
                    return;
                }
                if (b(zabVar)) {
                    this.f10755a.remove(zabVar);
                }
            }
        }

        private final void q() {
            if (this.j) {
                GoogleApiManager.this.q.removeMessages(11, this.f10758d);
                GoogleApiManager.this.q.removeMessages(9, this.f10758d);
                this.j = false;
            }
        }

        private final void r() {
            GoogleApiManager.this.q.removeMessages(12, this.f10758d);
            GoogleApiManager.this.q.sendMessageDelayed(GoogleApiManager.this.q.obtainMessage(12, this.f10758d), GoogleApiManager.this.f10745g);
        }

        public final void a(ConnectionResult connectionResult) {
            Preconditions.a(GoogleApiManager.this.q);
            this.f10756b.disconnect();
            onConnectionFailed(connectionResult);
        }

        public final boolean d() {
            return this.f10756b.requiresSignIn();
        }

        public final void e() {
            Preconditions.a(GoogleApiManager.this.q);
            if (this.j) {
                a();
            }
        }

        public final Api.Client f() {
            return this.f10756b;
        }

        public final void g() {
            Status status;
            Preconditions.a(GoogleApiManager.this.q);
            if (this.j) {
                q();
                if (GoogleApiManager.this.i.c(GoogleApiManager.this.f10746h) == 18) {
                    status = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
                } else {
                    status = new Status(8, "API failed to connect while resuming due to an unknown error.");
                }
                a(status);
                this.f10756b.disconnect();
            }
        }

        public final void h() {
            Preconditions.a(GoogleApiManager.this.q);
            a(GoogleApiManager.f10739a);
            this.f10759e.b();
            for (ListenerHolder.ListenerKey listenerKey : (ListenerHolder.ListenerKey[]) this.f10761g.keySet().toArray(new ListenerHolder.ListenerKey[this.f10761g.size()])) {
                a(new zah(listenerKey, new TaskCompletionSource()));
            }
            c(new ConnectionResult(4));
            if (this.f10756b.isConnected()) {
                this.f10756b.onUserSignOut(new C(this));
            }
        }

        public final Map<ListenerHolder.ListenerKey<?>, zabw> i() {
            return this.f10761g;
        }

        public final void j() {
            Preconditions.a(GoogleApiManager.this.q);
            this.l = null;
        }

        public final ConnectionResult k() {
            Preconditions.a(GoogleApiManager.this.q);
            return this.l;
        }

        public final boolean l() {
            return a(true);
        }

        final zad m() {
            zace zaceVar = this.i;
            if (zaceVar == null) {
                return null;
            }
            return zaceVar.v();
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public final void onConnected(Bundle bundle) {
            if (Looper.myLooper() == GoogleApiManager.this.q.getLooper()) {
                n();
            } else {
                GoogleApiManager.this.q.post(new RunnableC0821z(this));
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public final void onConnectionFailed(ConnectionResult connectionResult) {
            Preconditions.a(GoogleApiManager.this.q);
            zace zaceVar = this.i;
            if (zaceVar != null) {
                zaceVar.w();
            }
            j();
            GoogleApiManager.this.j.a();
            c(connectionResult);
            if (connectionResult.a() == 4) {
                a(GoogleApiManager.f10740b);
                return;
            }
            if (this.f10755a.isEmpty()) {
                this.l = connectionResult;
                return;
            }
            if (b(connectionResult) || GoogleApiManager.this.b(connectionResult, this.f10762h)) {
                return;
            }
            if (connectionResult.a() == 18) {
                this.j = true;
            }
            if (this.j) {
                GoogleApiManager.this.q.sendMessageDelayed(Message.obtain(GoogleApiManager.this.q, 9, this.f10758d), GoogleApiManager.this.f10743e);
                return;
            }
            String a2 = this.f10758d.a();
            StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 38);
            sb.append("API: ");
            sb.append(a2);
            sb.append(" is not available on this device.");
            a(new Status(17, sb.toString()));
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public final void onConnectionSuspended(int i) {
            if (Looper.myLooper() == GoogleApiManager.this.q.getLooper()) {
                o();
            } else {
                GoogleApiManager.this.q.post(new A(this));
            }
        }

        @Override // com.google.android.gms.common.api.internal.zar
        public final void a(ConnectionResult connectionResult, Api<?> api, boolean z) {
            if (Looper.myLooper() == GoogleApiManager.this.q.getLooper()) {
                onConnectionFailed(connectionResult);
            } else {
                GoogleApiManager.this.q.post(new B(this, connectionResult));
            }
        }

        private final void c(ConnectionResult connectionResult) {
            for (zak zakVar : this.f10760f) {
                String str = null;
                if (Objects.a(connectionResult, ConnectionResult.f10647a)) {
                    str = this.f10756b.getEndpointPackageName();
                }
                zakVar.a(this.f10758d, connectionResult, str);
            }
            this.f10760f.clear();
        }

        private final boolean b(zab zabVar) {
            if (!(zabVar instanceof zac)) {
                c(zabVar);
                return true;
            }
            zac zacVar = (zac) zabVar;
            Feature a2 = a(zacVar.b((zaa<?>) this));
            if (a2 == null) {
                c(zabVar);
                return true;
            }
            if (zacVar.c(this)) {
                a aVar = new a(this.f10758d, a2, null);
                int indexOf = this.k.indexOf(aVar);
                if (indexOf >= 0) {
                    a aVar2 = this.k.get(indexOf);
                    GoogleApiManager.this.q.removeMessages(15, aVar2);
                    GoogleApiManager.this.q.sendMessageDelayed(Message.obtain(GoogleApiManager.this.q, 15, aVar2), GoogleApiManager.this.f10743e);
                    return false;
                }
                this.k.add(aVar);
                GoogleApiManager.this.q.sendMessageDelayed(Message.obtain(GoogleApiManager.this.q, 15, aVar), GoogleApiManager.this.f10743e);
                GoogleApiManager.this.q.sendMessageDelayed(Message.obtain(GoogleApiManager.this.q, 16, aVar), GoogleApiManager.this.f10744f);
                ConnectionResult connectionResult = new ConnectionResult(2, null);
                if (b(connectionResult)) {
                    return false;
                }
                GoogleApiManager.this.b(connectionResult, this.f10762h);
                return false;
            }
            zacVar.a(new UnsupportedApiCallException(a2));
            return false;
        }

        public final void a(zab zabVar) {
            Preconditions.a(GoogleApiManager.this.q);
            if (this.f10756b.isConnected()) {
                if (b(zabVar)) {
                    r();
                    return;
                } else {
                    this.f10755a.add(zabVar);
                    return;
                }
            }
            this.f10755a.add(zabVar);
            ConnectionResult connectionResult = this.l;
            if (connectionResult != null && connectionResult.Q()) {
                onConnectionFailed(this.l);
            } else {
                a();
            }
        }

        final boolean c() {
            return this.f10756b.isConnected();
        }

        public final void a(Status status) {
            Preconditions.a(GoogleApiManager.this.q);
            Iterator<zab> it = this.f10755a.iterator();
            while (it.hasNext()) {
                it.next().a(status);
            }
            this.f10755a.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean a(boolean z) {
            Preconditions.a(GoogleApiManager.this.q);
            if (!this.f10756b.isConnected() || this.f10761g.size() != 0) {
                return false;
            }
            if (!this.f10759e.a()) {
                this.f10756b.disconnect();
                return true;
            }
            if (z) {
                r();
            }
            return false;
        }

        public final void a() {
            Preconditions.a(GoogleApiManager.this.q);
            if (this.f10756b.isConnected() || this.f10756b.isConnecting()) {
                return;
            }
            int a2 = GoogleApiManager.this.j.a(GoogleApiManager.this.f10746h, this.f10756b);
            if (a2 != 0) {
                onConnectionFailed(new ConnectionResult(a2, null));
                return;
            }
            b bVar = new b(this.f10756b, this.f10758d);
            if (this.f10756b.requiresSignIn()) {
                this.i.a(bVar);
            }
            this.f10756b.connect(bVar);
        }

        public final int b() {
            return this.f10762h;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(a aVar) {
            Feature[] b2;
            if (this.k.remove(aVar)) {
                GoogleApiManager.this.q.removeMessages(15, aVar);
                GoogleApiManager.this.q.removeMessages(16, aVar);
                Feature feature = aVar.f10748b;
                ArrayList arrayList = new ArrayList(this.f10755a.size());
                for (zab zabVar : this.f10755a) {
                    if ((zabVar instanceof zac) && (b2 = ((zac) zabVar).b((zaa<?>) this)) != null && ArrayUtils.a(b2, feature)) {
                        arrayList.add(zabVar);
                    }
                }
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    zab zabVar2 = (zab) obj;
                    this.f10755a.remove(zabVar2);
                    zabVar2.a(new UnsupportedApiCallException(feature));
                }
            }
        }

        public final void a(zak zakVar) {
            Preconditions.a(GoogleApiManager.this.q);
            this.f10760f.add(zakVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final Feature a(Feature[] featureArr) {
            if (featureArr != null && featureArr.length != 0) {
                Feature[] availableFeatures = this.f10756b.getAvailableFeatures();
                if (availableFeatures == null) {
                    availableFeatures = new Feature[0];
                }
                ArrayMap arrayMap = new ArrayMap(availableFeatures.length);
                for (Feature feature : availableFeatures) {
                    arrayMap.put(feature.a(), Long.valueOf(feature.O()));
                }
                for (Feature feature2 : featureArr) {
                    if (!arrayMap.containsKey(feature2.a()) || ((Long) arrayMap.get(feature2.a())).longValue() < feature2.O()) {
                        return feature2;
                    }
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(a aVar) {
            if (this.k.contains(aVar) && !this.j) {
                if (!this.f10756b.isConnected()) {
                    a();
                } else {
                    p();
                }
            }
        }
    }

    private final void c(GoogleApi<?> googleApi) {
        zai<?> zak = googleApi.zak();
        zaa<?> zaaVar = this.m.get(zak);
        if (zaaVar == null) {
            zaaVar = new zaa<>(googleApi);
            this.m.put(zak, zaaVar);
        }
        if (zaaVar.d()) {
            this.p.add(zak);
        }
        zaaVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(zaae zaaeVar) {
        synchronized (f10741c) {
            if (this.n == zaaeVar) {
                this.n = null;
                this.o.clear();
            }
        }
    }

    public final void a(GoogleApi<?> googleApi) {
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(7, googleApi));
    }

    public final void a(zaae zaaeVar) {
        synchronized (f10741c) {
            if (this.n != zaaeVar) {
                this.n = zaaeVar;
                this.o.clear();
            }
            this.o.addAll(zaaeVar.h());
        }
    }

    public final Task<Boolean> b(GoogleApi<?> googleApi) {
        C0800d c0800d = new C0800d(googleApi.zak());
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(14, c0800d));
        return c0800d.a().a();
    }

    final boolean b(ConnectionResult connectionResult, int i) {
        return this.i.a(this.f10746h, connectionResult, i);
    }

    public final Task<Map<zai<?>, String>> a(Iterable<? extends GoogleApi<?>> iterable) {
        zak zakVar = new zak(iterable);
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(2, zakVar));
        return zakVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.l.incrementAndGet();
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(10));
    }

    public final <O extends Api.ApiOptions> void a(GoogleApi<O> googleApi, int i, BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient> apiMethodImpl) {
        zae zaeVar = new zae(i, apiMethodImpl);
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(4, new zabv(zaeVar, this.l.get(), googleApi)));
    }

    public final <O extends Api.ApiOptions, ResultT> void a(GoogleApi<O> googleApi, int i, TaskApiCall<Api.AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        zag zagVar = new zag(i, taskApiCall, taskCompletionSource, statusExceptionMapper);
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(4, new zabv(zagVar, this.l.get(), googleApi)));
    }

    public final <O extends Api.ApiOptions> Task<Void> a(GoogleApi<O> googleApi, RegisterListenerMethod<Api.AnyClient, ?> registerListenerMethod, UnregisterListenerMethod<Api.AnyClient, ?> unregisterListenerMethod) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zaf zafVar = new zaf(new zabw(registerListenerMethod, unregisterListenerMethod), taskCompletionSource);
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(8, new zabv(zafVar, this.l.get(), googleApi)));
        return taskCompletionSource.a();
    }

    public final <O extends Api.ApiOptions> Task<Boolean> a(GoogleApi<O> googleApi, ListenerHolder.ListenerKey<?> listenerKey) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zah zahVar = new zah(listenerKey, taskCompletionSource);
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(13, new zabv(zahVar, this.l.get(), googleApi)));
        return taskCompletionSource.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PendingIntent a(zai<?> zaiVar, int i) {
        zad m;
        zaa<?> zaaVar = this.m.get(zaiVar);
        if (zaaVar == null || (m = zaaVar.m()) == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f10746h, i, m.getSignInIntent(), 134217728);
    }

    public final void a(ConnectionResult connectionResult, int i) {
        if (b(connectionResult, i)) {
            return;
        }
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(5, i, 0, connectionResult));
    }
}

package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.internal.zzi;
import com.google.android.gms.cast.internal.zzj;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.internal.zzlb;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zze extends com.google.android.gms.common.internal.zzj<zzi> {

    /* renamed from: a, reason: collision with root package name */
    private static final zzl f851a = new zzl("CastClientImpl");
    private static final Object w = new Object();
    private static final Object x = new Object();
    private ApplicationMetadata b;
    private final CastDevice c;
    private final Cast.Listener d;
    private final Map<String, Cast.MessageReceivedCallback> e;
    private final long f;
    private b g;
    private String h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private double m;
    private int n;
    private int o;
    private final AtomicLong p;
    private String q;
    private String r;
    private Bundle s;
    private final Map<Long, zzlb.zzb<Status>> t;
    private zzlb.zzb<Cast.ApplicationConnectionResult> u;
    private zzlb.zzb<Status> v;

    /* loaded from: classes.dex */
    private static final class a implements Cast.ApplicationConnectionResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f852a;
        private final ApplicationMetadata b;
        private final String c;
        private final String d;
        private final boolean e;

        public a(Status status) {
            this(status, null, null, null, false);
        }

        public a(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.f852a = status;
            this.b = applicationMetadata;
            this.c = str;
            this.d = str2;
            this.e = z;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.f852a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends zzj.zza {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicReference<zze> f853a;
        private final Handler b;

        public b(zze zzeVar) {
            this.f853a = new AtomicReference<>(zzeVar);
            this.b = new Handler(zzeVar.getLooper());
        }

        private void a(zze zzeVar, long j, int i) {
            zzlb.zzb zzbVar;
            synchronized (zzeVar.t) {
                zzbVar = (zzlb.zzb) zzeVar.t.remove(Long.valueOf(j));
            }
            if (zzbVar != null) {
                zzbVar.zzp(new Status(i));
            }
        }

        private boolean a(zze zzeVar, int i) {
            synchronized (zze.x) {
                if (zzeVar.v == null) {
                    return false;
                }
                zzeVar.v.zzp(new Status(i));
                zzeVar.v = null;
                return true;
            }
        }

        public zze a() {
            zze andSet = this.f853a.getAndSet(null);
            if (andSet == null) {
                return null;
            }
            andSet.d();
            return andSet;
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void a(int i) {
            zze a2 = a();
            if (a2 == null) {
                return;
            }
            zze.f851a.b("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
            if (i != 0) {
                a2.zzbE(2);
            }
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            zze zzeVar = this.f853a.get();
            if (zzeVar == null) {
                return;
            }
            zzeVar.b = applicationMetadata;
            zzeVar.q = applicationMetadata.b();
            zzeVar.r = str2;
            synchronized (zze.w) {
                if (zzeVar.u != null) {
                    zzeVar.u.zzp(new a(new Status(0), applicationMetadata, str, str2, z));
                    zzeVar.u = null;
                }
            }
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void a(ApplicationStatus applicationStatus) {
            zze zzeVar = this.f853a.get();
            if (zzeVar == null) {
                return;
            }
            zze.f851a.b("onApplicationStatusChanged", new Object[0]);
            this.b.post(new c(this, zzeVar, applicationStatus));
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void a(DeviceStatus deviceStatus) {
            zze zzeVar = this.f853a.get();
            if (zzeVar == null) {
                return;
            }
            zze.f851a.b("onDeviceStatusChanged", new Object[0]);
            this.b.post(new com.google.android.gms.cast.internal.b(this, zzeVar, deviceStatus));
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void a(String str, double d, boolean z) {
            zze.f851a.b("Deprecated callback: \"onStatusreceived\"", new Object[0]);
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void a(String str, long j) {
            zze zzeVar = this.f853a.get();
            if (zzeVar == null) {
                return;
            }
            a(zzeVar, j, 0);
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void a(String str, long j, int i) {
            zze zzeVar = this.f853a.get();
            if (zzeVar == null) {
                return;
            }
            a(zzeVar, j, i);
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void a(String str, String str2) {
            zze zzeVar = this.f853a.get();
            if (zzeVar == null) {
                return;
            }
            zze.f851a.b("Receive (type=text, ns=%s) %s", str, str2);
            this.b.post(new d(this, zzeVar, str, str2));
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void a(String str, byte[] bArr) {
            if (this.f853a.get() == null) {
                return;
            }
            zze.f851a.b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void b(int i) {
            zze zzeVar = this.f853a.get();
            if (zzeVar == null) {
                return;
            }
            synchronized (zze.w) {
                if (zzeVar.u != null) {
                    zzeVar.u.zzp(new a(new Status(i)));
                    zzeVar.u = null;
                }
            }
        }

        public boolean b() {
            return this.f853a.get() == null;
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void c(int i) {
            zze zzeVar = this.f853a.get();
            if (zzeVar == null) {
                return;
            }
            a(zzeVar, i);
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void d(int i) {
            zze zzeVar = this.f853a.get();
            if (zzeVar == null) {
                return;
            }
            a(zzeVar, i);
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void e(int i) {
            zze zzeVar = this.f853a.get();
            if (zzeVar == null) {
                return;
            }
            zzeVar.q = null;
            zzeVar.r = null;
            a(zzeVar, i);
            if (zzeVar.d != null) {
                this.b.post(new com.google.android.gms.cast.internal.a(this, zzeVar, i));
            }
        }
    }

    public zze(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, CastDevice castDevice, long j, Cast.Listener listener, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 10, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.c = castDevice;
        this.d = listener;
        this.f = j;
        this.e = new HashMap();
        this.p = new AtomicLong(0L);
        this.t = new HashMap();
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ApplicationStatus applicationStatus) {
        boolean z;
        String b2 = applicationStatus.b();
        if (zzf.a(b2, this.h)) {
            z = false;
        } else {
            this.h = b2;
            z = true;
        }
        f851a.b("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.j));
        if (this.d != null && (z || this.j)) {
            this.d.a();
        }
        this.j = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DeviceStatus deviceStatus) {
        boolean z;
        boolean z2;
        boolean z3;
        ApplicationMetadata f = deviceStatus.f();
        if (!zzf.a(f, this.b)) {
            this.b = f;
            this.d.a(this.b);
        }
        double b2 = deviceStatus.b();
        if (b2 == Double.NaN || Math.abs(b2 - this.m) <= 1.0E-7d) {
            z = false;
        } else {
            this.m = b2;
            z = true;
        }
        boolean c = deviceStatus.c();
        if (c != this.i) {
            this.i = c;
            z = true;
        }
        f851a.b("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.k));
        if (this.d != null && (z || this.k)) {
            this.d.b();
        }
        int d = deviceStatus.d();
        if (d != this.n) {
            this.n = d;
            z2 = true;
        } else {
            z2 = false;
        }
        f851a.b("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z2), Boolean.valueOf(this.k));
        if (this.d != null && (z2 || this.k)) {
            this.d.b(this.n);
        }
        int e = deviceStatus.e();
        if (e != this.o) {
            this.o = e;
            z3 = true;
        } else {
            z3 = false;
        }
        f851a.b("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z3), Boolean.valueOf(this.k));
        if (this.d != null && (z3 || this.k)) {
            this.d.c(this.o);
        }
        this.k = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.l = false;
        this.n = -1;
        this.o = -1;
        this.b = null;
        this.h = null;
        this.m = 0.0d;
        this.i = false;
    }

    private void e() {
        f851a.b("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.e) {
            this.e.clear();
        }
    }

    private void f() throws IllegalStateException {
        if (!this.l || this.g == null || this.g.b()) {
            throw new IllegalStateException("Not connected to a device");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzi zzW(IBinder iBinder) {
        return zzi.zza.a(iBinder);
    }

    public void a(String str) throws IllegalArgumentException, RemoteException {
        Cast.MessageReceivedCallback remove;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.e) {
            remove = this.e.remove(str);
        }
        if (remove != null) {
            try {
                zzpc().c(str);
            } catch (IllegalStateException e) {
                f851a.a(e, "Error unregistering namespace (%s): %s", str, e.getMessage());
            }
        }
    }

    public void a(String str, Cast.MessageReceivedCallback messageReceivedCallback) throws IllegalArgumentException, IllegalStateException, RemoteException {
        zzf.a(str);
        a(str);
        if (messageReceivedCallback != null) {
            synchronized (this.e) {
                this.e.put(str, messageReceivedCallback);
            }
            zzpc().b(str);
        }
    }

    public void a(String str, String str2, zzlb.zzb<Status> zzbVar) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        }
        if (str2.length() > 65536) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        }
        zzf.a(str);
        f();
        long incrementAndGet = this.p.incrementAndGet();
        try {
            this.t.put(Long.valueOf(incrementAndGet), zzbVar);
            zzpc().a(str, str2, incrementAndGet);
        } catch (Throwable th) {
            this.t.remove(Long.valueOf(incrementAndGet));
            throw th;
        }
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public void disconnect() {
        f851a.b("disconnect(); ServiceListener=%s, isConnected=%b", this.g, Boolean.valueOf(isConnected()));
        b bVar = this.g;
        this.g = null;
        if (bVar == null || bVar.a() == null) {
            f851a.b("already disposed, so short-circuiting", new Object[0]);
            return;
        }
        e();
        try {
            try {
                zzpc().a();
            } catch (RemoteException | IllegalStateException e) {
                f851a.a(e, "Error while disconnecting the controller interface: %s", e.getMessage());
                super.disconnect();
            }
        } finally {
            super.disconnect();
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    public void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        f851a.b("in onPostInitHandler; statusCode=%d", Integer.valueOf(i));
        if (i == 0 || i == 1001) {
            this.l = true;
            this.j = true;
            this.k = true;
        } else {
            this.l = false;
        }
        if (i == 1001) {
            this.s = new Bundle();
            this.s.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
            i = 0;
        }
        super.zza(i, iBinder, bundle, i2);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzly() {
        Bundle bundle = new Bundle();
        f851a.b("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", this.q, this.r);
        this.c.a(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.f);
        this.g = new b(this);
        bundle.putParcelable("listener", new BinderWrapper(this.g.asBinder()));
        if (this.q != null) {
            bundle.putString("last_application_id", this.q);
            if (this.r != null) {
                bundle.putString("last_session_id", this.r);
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.internal.zzk.zza
    public Bundle zzmS() {
        if (this.s == null) {
            return super.zzmS();
        }
        Bundle bundle = this.s;
        this.s = null;
        return bundle;
    }
}

package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.measurement.AppMeasurementService;
import com.google.android.gms.measurement.internal.zzm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class zzab extends ac {

    /* renamed from: a, reason: collision with root package name */
    private final zza f2052a;
    private zzm b;
    private Boolean c;
    private final n d;
    private final k e;
    private final List<Runnable> f;
    private final n h;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class zza implements ServiceConnection, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private volatile boolean b;
        private volatile zzo c;

        protected zza() {
        }

        public void a() {
            zzab.this.e();
            Context i = zzab.this.i();
            synchronized (this) {
                if (this.b) {
                    zzab.this.l().t().a("Connection attempt already in progress");
                    return;
                }
                if (this.c != null) {
                    zzab.this.l().t().a("Already awaiting connection attempt");
                    return;
                }
                this.c = new zzo(i, Looper.getMainLooper(), com.google.android.gms.common.internal.zzf.a(i), this, this);
                zzab.this.l().t().a("Connecting to remote service");
                this.b = true;
                this.c.zzoZ();
            }
        }

        public void a(Intent intent) {
            zzab.this.e();
            Context i = zzab.this.i();
            com.google.android.gms.common.stats.zzb a2 = com.google.android.gms.common.stats.zzb.a();
            synchronized (this) {
                if (this.b) {
                    zzab.this.l().t().a("Connection attempt already in progress");
                } else {
                    this.b = true;
                    a2.a(i, intent, zzab.this.f2052a, 129);
                }
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void a(Bundle bundle) {
            zzx.b("MeasurementServiceConnection.onConnected");
            synchronized (this) {
                this.b = false;
                try {
                    zzm zzpc = this.c.zzpc();
                    this.c = null;
                    zzab.this.k().a(new i(this, zzpc));
                } catch (DeadObjectException | IllegalStateException e) {
                    this.c = null;
                }
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public void a(ConnectionResult connectionResult) {
            zzx.b("MeasurementServiceConnection.onConnectionFailed");
            synchronized (this) {
                this.c = null;
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void a_(int i) {
            zzx.b("MeasurementServiceConnection.onConnectionSuspended");
            zzab.this.k().a(new j(this));
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzx.b("MeasurementServiceConnection.onServiceConnected");
            synchronized (this) {
                this.b = false;
                if (iBinder == null) {
                    zzab.this.l().b().a("Service connected with null binder");
                    return;
                }
                zzm zzmVar = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                        zzmVar = zzm.zza.a(iBinder);
                        zzab.this.l().t().a("Bound to IMeasurementService interface");
                    } else {
                        zzab.this.l().b().a("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException e) {
                    zzab.this.l().b().a("Service connect failed to get IMeasurementService");
                }
                if (zzmVar == null) {
                    try {
                        com.google.android.gms.common.stats.zzb.a().a(zzab.this.i(), zzab.this.f2052a);
                    } catch (IllegalArgumentException e2) {
                    }
                } else {
                    zzab.this.k().a(new g(this, zzmVar));
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            zzx.b("MeasurementServiceConnection.onServiceDisconnected");
            zzab.this.k().a(new h(this, componentName));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzab(zzv zzvVar) {
        super(zzvVar);
        this.f = new ArrayList();
        this.e = new k(zzvVar.n());
        this.f2052a = new zza();
        this.d = new c(this, zzvVar);
        this.h = new d(this, zzvVar);
    }

    private void A() {
        e();
        l().t().a("Flushing task queue", Integer.valueOf(this.f.size()));
        Iterator<Runnable> it = this.f.iterator();
        while (it.hasNext()) {
            k().a(it.next());
        }
        this.f.clear();
        this.h.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ComponentName componentName) {
        e();
        if (this.b != null) {
            this.b = null;
            l().t().a("Disconnected from device MeasurementService", componentName);
            z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(zzm zzmVar) {
        e();
        zzx.a(zzmVar);
        this.b = zzmVar;
        q();
        A();
    }

    private void a(Runnable runnable) throws IllegalStateException {
        e();
        if (b()) {
            runnable.run();
        } else {
            if (this.f.size() >= n().D()) {
                l().b().a("Discarding data. Max runnable queue size reached");
                return;
            }
            this.f.add(runnable);
            this.h.a(60000L);
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        e();
        this.e.a();
        this.d.a(n().v());
    }

    private void r() {
        e();
        x();
        if (b()) {
            return;
        }
        if (this.c == null) {
            this.c = m().q();
            if (this.c == null) {
                l().t().a("State of service unknown");
                this.c = Boolean.valueOf(t());
                m().a(this.c.booleanValue());
            }
        }
        if (this.c.booleanValue()) {
            l().t().a("Using measurement service");
            this.f2052a.a();
            return;
        }
        if (s()) {
            l().t().a("Using local app measurement service");
            Intent intent = new Intent("com.google.android.gms.measurement.START");
            intent.setComponent(new ComponentName(i(), (Class<?>) AppMeasurementService.class));
            this.f2052a.a(intent);
            return;
        }
        if (!n().A()) {
            l().b().a("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
        } else {
            l().t().a("Using direct local measurement implementation");
            a(new zzw(this.g, true));
        }
    }

    private boolean s() {
        List<ResolveInfo> queryIntentServices = i().getPackageManager().queryIntentServices(new Intent(i(), (Class<?>) AppMeasurementService.class), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        return queryIntentServices != null && queryIntentServices.size() > 0;
    }

    private boolean t() {
        e();
        x();
        if (n().z()) {
            return true;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.measurement.service.MeasurementBrokerService"));
        com.google.android.gms.common.stats.zzb a2 = com.google.android.gms.common.stats.zzb.a();
        l().t().a("Checking service availability");
        if (!a2.a(i(), intent, new f(this), 0)) {
            return false;
        }
        l().t().a("Service available");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        e();
        if (b()) {
            l().t().a("Inactivity, disconnecting from AppMeasurementService");
            p();
        }
    }

    private void z() {
        e();
        r();
    }

    @Override // com.google.android.gms.measurement.internal.ac
    protected void a() {
    }

    public boolean b() {
        e();
        x();
        return this.b != null;
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzn f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzab g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzmn h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ Context i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzag j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzu k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzp l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzs m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzc n() {
        return super.n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        e();
        x();
        a(new e(this));
    }

    public void p() {
        e();
        x();
        try {
            com.google.android.gms.common.stats.zzb.a().a(i(), this.f2052a);
        } catch (IllegalArgumentException e) {
        } catch (IllegalStateException e2) {
        }
        if (this.b != null) {
            this.b = null;
        }
    }
}

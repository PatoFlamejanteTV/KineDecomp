package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.analytics.internal.zzac;
import java.util.Collections;

/* loaded from: classes.dex */
public class zzi extends zzd {

    /* renamed from: a, reason: collision with root package name */
    private final zza f744a;
    private zzac b;
    private final y c;
    private d d;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class zza implements ServiceConnection {
        private volatile zzac b;
        private volatile boolean c;

        protected zza() {
        }

        public zzac a() {
            zzac zzacVar = null;
            zzi.this.m();
            Intent intent = new Intent("com.google.android.gms.analytics.service.START");
            intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
            Context o = zzi.this.o();
            intent.putExtra("app_package_name", o.getPackageName());
            com.google.android.gms.common.stats.zzb a2 = com.google.android.gms.common.stats.zzb.a();
            synchronized (this) {
                this.b = null;
                this.c = true;
                boolean a3 = a2.a(o, intent, zzi.this.f744a, 129);
                zzi.this.a("Bind to service requested", Boolean.valueOf(a3));
                if (a3) {
                    try {
                        wait(zzi.this.q().w());
                    } catch (InterruptedException e) {
                        zzi.this.e("Wait for service connect was interrupted");
                    }
                    this.c = false;
                    zzacVar = this.b;
                    this.b = null;
                    if (zzacVar == null) {
                        zzi.this.f("Successfully bound to service but never got onServiceConnected callback");
                    }
                } else {
                    this.c = false;
                }
            }
            return zzacVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.google.android.gms.common.internal.zzx.b("AnalyticsServiceConnection.onServiceConnected");
            synchronized (this) {
                try {
                    if (iBinder == null) {
                        zzi.this.f("Service connected with null binder");
                        return;
                    }
                    zzac zzacVar = null;
                    try {
                        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                        if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(interfaceDescriptor)) {
                            zzacVar = zzac.zza.a(iBinder);
                            zzi.this.b("Bound to IAnalyticsService interface");
                        } else {
                            zzi.this.e("Got binder with a wrong descriptor", interfaceDescriptor);
                        }
                    } catch (RemoteException e) {
                        zzi.this.f("Service connect failed to get IAnalyticsService");
                    }
                    if (zzacVar == null) {
                        try {
                            com.google.android.gms.common.stats.zzb.a().a(zzi.this.o(), zzi.this.f744a);
                        } catch (IllegalArgumentException e2) {
                        }
                    } else if (this.c) {
                        this.b = zzacVar;
                    } else {
                        zzi.this.e("onServiceConnected received after the timeout limit");
                        zzi.this.r().a(new l(this, zzacVar));
                    }
                } finally {
                    notifyAll();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.google.android.gms.common.internal.zzx.b("AnalyticsServiceConnection.onServiceDisconnected");
            zzi.this.r().a(new m(this, componentName));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzi(zzf zzfVar) {
        super(zzfVar);
        this.d = new d(zzfVar.d());
        this.f744a = new zza();
        this.c = new k(this, zzfVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ComponentName componentName) {
        m();
        if (this.b != null) {
            this.b = null;
            a("Disconnected from device AnalyticsService", componentName);
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(zzac zzacVar) {
        m();
        this.b = zzacVar;
        e();
        t().g();
    }

    private void e() {
        this.d.a();
        this.c.a(q().v());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        m();
        if (b()) {
            b("Inactivity, disconnecting from device AnalyticsService");
            d();
        }
    }

    private void g() {
        t().e();
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void a() {
    }

    public boolean a(zzab zzabVar) {
        com.google.android.gms.common.internal.zzx.a(zzabVar);
        m();
        D();
        zzac zzacVar = this.b;
        if (zzacVar == null) {
            return false;
        }
        try {
            zzacVar.a(zzabVar.b(), zzabVar.d(), zzabVar.f() ? q().o() : q().p(), Collections.emptyList());
            e();
            return true;
        } catch (RemoteException e) {
            b("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    public boolean b() {
        m();
        D();
        return this.b != null;
    }

    public boolean c() {
        m();
        D();
        if (this.b != null) {
            return true;
        }
        zzac a2 = this.f744a.a();
        if (a2 == null) {
            return false;
        }
        this.b = a2;
        e();
        return true;
    }

    public void d() {
        m();
        D();
        try {
            com.google.android.gms.common.stats.zzb.a().a(o(), this.f744a);
        } catch (IllegalArgumentException e) {
        } catch (IllegalStateException e2) {
        }
        if (this.b != null) {
            this.b = null;
            g();
        }
    }
}

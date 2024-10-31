package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzav implements ServiceConnection {
    final /* synthetic */ zzat zzxe;
    private volatile zzce zzxf;
    private volatile boolean zzxg;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzav(zzat zzatVar) {
        this.zzxe = zzatVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzav zzavVar;
        zzce zzcfVar;
        Preconditions.a("AnalyticsServiceConnection.onServiceConnected");
        synchronized (this) {
            try {
                if (iBinder == null) {
                    this.zzxe.zzu("Service connected with null binder");
                    return;
                }
                zzce zzceVar = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(interfaceDescriptor)) {
                        if (iBinder != null) {
                            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                            if (queryLocalInterface instanceof zzce) {
                                zzcfVar = (zzce) queryLocalInterface;
                            } else {
                                zzcfVar = new zzcf(iBinder);
                            }
                            zzceVar = zzcfVar;
                        }
                        this.zzxe.zzq("Bound to IAnalyticsService interface");
                    } else {
                        this.zzxe.zze("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException unused) {
                    this.zzxe.zzu("Service connect failed to get IAnalyticsService");
                }
                if (zzceVar == null) {
                    try {
                        ConnectionTracker a2 = ConnectionTracker.a();
                        Context context = this.zzxe.getContext();
                        zzavVar = this.zzxe.zzxa;
                        a2.a(context, zzavVar);
                    } catch (IllegalArgumentException unused2) {
                    }
                } else if (!this.zzxg) {
                    this.zzxe.zzt("onServiceConnected received after the timeout limit");
                    this.zzxe.zzcq().a(new RunnableC1312j(this, zzceVar));
                } else {
                    this.zzxf = zzceVar;
                }
            } finally {
                notifyAll();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.a("AnalyticsServiceConnection.onServiceDisconnected");
        this.zzxe.zzcq().a(new RunnableC1314k(this, componentName));
    }

    public final zzce zzdq() {
        zzav zzavVar;
        com.google.android.gms.analytics.zzk.d();
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        Context context = this.zzxe.getContext();
        intent.putExtra("app_package_name", context.getPackageName());
        ConnectionTracker a2 = ConnectionTracker.a();
        synchronized (this) {
            this.zzxf = null;
            this.zzxg = true;
            zzavVar = this.zzxe.zzxa;
            boolean a3 = a2.a(context, intent, zzavVar, 129);
            this.zzxe.zza("Bind to service requested", Boolean.valueOf(a3));
            if (!a3) {
                this.zzxg = false;
                return null;
            }
            try {
                wait(zzby.zzaak.get().longValue());
            } catch (InterruptedException unused) {
                this.zzxe.zzt("Wait for service connect was interrupted");
            }
            this.zzxg = false;
            zzce zzceVar = this.zzxf;
            this.zzxf = null;
            if (zzceVar == null) {
                this.zzxe.zzu("Successfully bound to service but never got onServiceConnected callback");
            }
            return zzceVar;
        }
    }
}

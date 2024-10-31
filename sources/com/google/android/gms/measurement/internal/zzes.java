package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzes implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f14024a;

    /* renamed from: b, reason: collision with root package name */
    private volatile zzar f14025b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzeb f14026c;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzes(zzeb zzebVar) {
        this.f14026c = zzebVar;
    }

    public final void a(Intent intent) {
        zzes zzesVar;
        this.f14026c.c();
        Context context = this.f14026c.getContext();
        ConnectionTracker a2 = ConnectionTracker.a();
        synchronized (this) {
            if (this.f14024a) {
                this.f14026c.b().y().a("Connection attempt already in progress");
                return;
            }
            this.f14026c.b().y().a("Using local app measurement service");
            this.f14024a = true;
            zzesVar = this.f14026c.f14018c;
            a2.a(context, intent, zzesVar, 129);
        }
    }

    public final void b() {
        this.f14026c.c();
        Context context = this.f14026c.getContext();
        synchronized (this) {
            if (this.f14024a) {
                this.f14026c.b().y().a("Connection attempt already in progress");
                return;
            }
            if (this.f14025b != null && (this.f14025b.isConnecting() || this.f14025b.isConnected())) {
                this.f14026c.b().y().a("Already awaiting connection attempt");
                return;
            }
            this.f14025b = new zzar(context, Looper.getMainLooper(), this, this);
            this.f14026c.b().y().a("Connecting to remote service");
            this.f14024a = true;
            this.f14025b.checkAvailabilityAndConnect();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Preconditions.a("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.f14026c.zzgs().a(new RunnableC1448wa(this, this.f14025b.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f14025b = null;
                this.f14024a = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Preconditions.a("MeasurementServiceConnection.onConnectionFailed");
        zzas s = this.f14026c.f13672a.s();
        if (s != null) {
            s.t().a("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f14024a = false;
            this.f14025b = null;
        }
        this.f14026c.zzgs().a(new RunnableC1452ya(this));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        Preconditions.a("MeasurementServiceConnection.onConnectionSuspended");
        this.f14026c.b().x().a("Service connection suspended");
        this.f14026c.zzgs().a(new RunnableC1450xa(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzes zzesVar;
        zzaj zzalVar;
        Preconditions.a("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.f14024a = false;
                this.f14026c.b().q().a("Service connected with null binder");
                return;
            }
            zzaj zzajVar = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    if (iBinder != null) {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                        if (queryLocalInterface instanceof zzaj) {
                            zzalVar = (zzaj) queryLocalInterface;
                        } else {
                            zzalVar = new zzal(iBinder);
                        }
                        zzajVar = zzalVar;
                    }
                    this.f14026c.b().y().a("Bound to IMeasurementService interface");
                } else {
                    this.f14026c.b().q().a("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.f14026c.b().q().a("Service connect failed to get IMeasurementService");
            }
            if (zzajVar == null) {
                this.f14024a = false;
                try {
                    ConnectionTracker a2 = ConnectionTracker.a();
                    Context context = this.f14026c.getContext();
                    zzesVar = this.f14026c.f14018c;
                    a2.a(context, zzesVar);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.f14026c.zzgs().a(new RunnableC1444ua(this, zzajVar));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.a("MeasurementServiceConnection.onServiceDisconnected");
        this.f14026c.b().x().a("Service disconnected");
        this.f14026c.zzgs().a(new RunnableC1446va(this, componentName));
    }

    public final void a() {
        if (this.f14025b != null && (this.f14025b.isConnected() || this.f14025b.isConnecting())) {
            this.f14025b.disconnect();
        }
        this.f14025b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(zzes zzesVar, boolean z) {
        zzesVar.f14024a = false;
        return false;
    }
}

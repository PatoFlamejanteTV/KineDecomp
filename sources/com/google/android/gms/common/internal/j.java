package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zze;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class j extends GmsClientSupervisor implements Handler.Callback {

    /* renamed from: d */
    private final Context f11154d;

    /* renamed from: e */
    private final Handler f11155e;

    /* renamed from: c */
    private final HashMap<GmsClientSupervisor.zza, k> f11153c = new HashMap<>();

    /* renamed from: f */
    private final ConnectionTracker f11156f = ConnectionTracker.a();

    /* renamed from: g */
    private final long f11157g = 5000;

    /* renamed from: h */
    private final long f11158h = 300000;

    public j(Context context) {
        this.f11154d = context.getApplicationContext();
        this.f11155e = new zze(context.getMainLooper(), this);
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final boolean a(GmsClientSupervisor.zza zzaVar, ServiceConnection serviceConnection, String str) {
        boolean d2;
        Preconditions.a(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f11153c) {
            k kVar = this.f11153c.get(zzaVar);
            if (kVar == null) {
                kVar = new k(this, zzaVar);
                kVar.a(serviceConnection, str);
                kVar.a(str);
                this.f11153c.put(zzaVar, kVar);
            } else {
                this.f11155e.removeMessages(0, zzaVar);
                if (!kVar.a(serviceConnection)) {
                    kVar.a(serviceConnection, str);
                    int c2 = kVar.c();
                    if (c2 == 1) {
                        serviceConnection.onServiceConnected(kVar.b(), kVar.a());
                    } else if (c2 == 2) {
                        kVar.a(str);
                    }
                } else {
                    String valueOf = String.valueOf(zzaVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            d2 = kVar.d();
        }
        return d2;
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    protected final void b(GmsClientSupervisor.zza zzaVar, ServiceConnection serviceConnection, String str) {
        Preconditions.a(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f11153c) {
            k kVar = this.f11153c.get(zzaVar);
            if (kVar != null) {
                if (kVar.a(serviceConnection)) {
                    kVar.b(serviceConnection, str);
                    if (kVar.e()) {
                        this.f11155e.sendMessageDelayed(this.f11155e.obtainMessage(0, zzaVar), this.f11157g);
                    }
                } else {
                    String valueOf = String.valueOf(zzaVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 76);
                    sb.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            } else {
                String valueOf2 = String.valueOf(zzaVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 50);
                sb2.append("Nonexistent connection status for service config: ");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.f11153c) {
                GmsClientSupervisor.zza zzaVar = (GmsClientSupervisor.zza) message.obj;
                k kVar = this.f11153c.get(zzaVar);
                if (kVar != null && kVar.e()) {
                    if (kVar.d()) {
                        kVar.b("GmsClientSupervisor");
                    }
                    this.f11153c.remove(zzaVar);
                }
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        synchronized (this.f11153c) {
            GmsClientSupervisor.zza zzaVar2 = (GmsClientSupervisor.zza) message.obj;
            k kVar2 = this.f11153c.get(zzaVar2);
            if (kVar2 != null && kVar2.c() == 3) {
                String valueOf = String.valueOf(zzaVar2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                sb.append("Timeout waiting for ServiceConnection callback ");
                sb.append(valueOf);
                Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                ComponentName b2 = kVar2.b();
                if (b2 == null) {
                    b2 = zzaVar2.a();
                }
                if (b2 == null) {
                    b2 = new ComponentName(zzaVar2.b(), "unknown");
                }
                kVar2.onServiceDisconnected(b2);
            }
        }
        return true;
    }
}

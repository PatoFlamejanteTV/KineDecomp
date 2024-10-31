package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.IOException;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public final class Pm implements BaseGmsClient.BaseConnectionCallbacks {

    /* renamed from: a */
    private final /* synthetic */ zzty f11779a;

    /* renamed from: b */
    private final /* synthetic */ zzbcl f11780b;

    /* renamed from: c */
    final /* synthetic */ zzue f11781c;

    public Pm(zzue zzueVar, zzty zztyVar, zzbcl zzbclVar) {
        this.f11781c = zzueVar;
        this.f11779a = zztyVar;
        this.f11780b = zzbclVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Object obj;
        boolean z;
        zztx zztxVar;
        obj = this.f11781c.mLock;
        synchronized (obj) {
            z = this.f11781c.zzcac;
            if (z) {
                return;
            }
            zzue.zza(this.f11781c, true);
            zztxVar = this.f11781c.zzbzr;
            if (zztxVar == null) {
                return;
            }
            this.f11780b.zza(new Runnable(this.f11780b, zzayf.zzc(new Runnable(this, zztxVar, this.f11779a, this.f11780b) { // from class: com.google.android.gms.internal.ads.Qm

                /* renamed from: a, reason: collision with root package name */
                private final Pm f11793a;

                /* renamed from: b, reason: collision with root package name */
                private final zztx f11794b;

                /* renamed from: c, reason: collision with root package name */
                private final zzty f11795c;

                /* renamed from: d, reason: collision with root package name */
                private final zzbcl f11796d;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f11793a = this;
                    this.f11794b = zztxVar;
                    this.f11795c = zztyVar;
                    this.f11796d = zzbclVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Pm pm = this.f11793a;
                    zztx zztxVar2 = this.f11794b;
                    zzty zztyVar2 = this.f11795c;
                    zzbcl zzbclVar2 = this.f11796d;
                    try {
                        zztv zza = zztxVar2.zzoh().zza(zztyVar2);
                        if (!zza.zzoe()) {
                            zzbclVar2.setException(new RuntimeException("No entry contents."));
                            pm.f11781c.disconnect();
                            return;
                        }
                        Sm sm = new Sm(pm, zza.zzof(), 1);
                        int read = sm.read();
                        if (read != -1) {
                            sm.unread(read);
                            zzbclVar2.set(sm);
                            return;
                        }
                        throw new IOException("Unable to read from cache.");
                    } catch (RemoteException | IOException e2) {
                        zzbbd.zzb("Unable to obtain a cache service instance.", e2);
                        zzbclVar2.setException(e2);
                        pm.f11781c.disconnect();
                    }
                }
            })) { // from class: com.google.android.gms.internal.ads.Rm

                /* renamed from: a, reason: collision with root package name */
                private final zzbcl f11816a;

                /* renamed from: b, reason: collision with root package name */
                private final Future f11817b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f11816a = zzbclVar3;
                    this.f11817b = zzc;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbcl zzbclVar4 = this.f11816a;
                    Future future = this.f11817b;
                    if (zzbclVar4.isCancelled()) {
                        future.cancel(true);
                    }
                }
            }, zzbcg.zzepp);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}

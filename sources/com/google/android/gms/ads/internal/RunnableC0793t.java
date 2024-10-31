package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzabs;
import com.google.android.gms.internal.ads.zzabu;
import com.google.android.gms.internal.ads.zzabz;
import com.google.android.gms.internal.ads.zzacf;
import com.google.android.gms.internal.ads.zzbbd;
import java.util.List;

/* renamed from: com.google.android.gms.ads.internal.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class RunnableC0793t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzacf f10155a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ int f10156b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ List f10157c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzbb f10158d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0793t(zzbb zzbbVar, zzacf zzacfVar, int i, List list) {
        this.f10158d = zzbbVar;
        this.f10155a = zzacfVar;
        this.f10156b = i;
        this.f10157c = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzabz b2;
        zzabz b3;
        try {
            if ((this.f10155a instanceof zzabu) && this.f10158d.zzbls.t != null) {
                this.f10158d.zzblq = this.f10156b != this.f10157c.size() - 1;
                b3 = zzbb.b(this.f10155a);
                this.f10158d.zzbls.t.zza(b3);
                this.f10158d.zzb(b3.zzsc());
                return;
            }
            if ((this.f10155a instanceof zzabu) && this.f10158d.zzbls.s != null) {
                this.f10158d.zzblq = this.f10156b != this.f10157c.size() - 1;
                zzabu zzabuVar = (zzabu) this.f10155a;
                this.f10158d.zzbls.s.zza(zzabuVar);
                this.f10158d.zzb(zzabuVar.zzsc());
                return;
            }
            if ((this.f10155a instanceof zzabs) && this.f10158d.zzbls.t != null) {
                this.f10158d.zzblq = this.f10156b != this.f10157c.size() - 1;
                b2 = zzbb.b(this.f10155a);
                this.f10158d.zzbls.t.zza(b2);
                this.f10158d.zzb(b2.zzsc());
                return;
            }
            if ((this.f10155a instanceof zzabs) && this.f10158d.zzbls.r != null) {
                this.f10158d.zzblq = this.f10156b != this.f10157c.size() - 1;
                zzabs zzabsVar = (zzabs) this.f10155a;
                this.f10158d.zzbls.r.zza(zzabsVar);
                this.f10158d.zzb(zzabsVar.zzsc());
                return;
            }
            this.f10158d.zzg(3, this.f10156b != this.f10157c.size() - 1);
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}

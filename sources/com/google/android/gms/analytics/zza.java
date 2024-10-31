package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.measurement.zzf;
import com.google.android.gms.measurement.zzi;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class zza extends zzf<zza> {
    private final com.google.android.gms.analytics.internal.zzf b;
    private boolean c;

    public zza(com.google.android.gms.analytics.internal.zzf zzfVar) {
        super(zzfVar.h(), zzfVar.d());
        this.b = zzfVar;
    }

    @Override // com.google.android.gms.measurement.zzf
    public void a(com.google.android.gms.measurement.zzc zzcVar) {
        zzjo zzjoVar = (zzjo) zzcVar.b(zzjo.class);
        if (TextUtils.isEmpty(zzjoVar.getClientId())) {
            zzjoVar.setClientId(this.b.p().b());
        }
        if (this.c && TextUtils.isEmpty(zzjoVar.zzib())) {
            com.google.android.gms.analytics.internal.zza o = this.b.o();
            zzjoVar.zzaV(o.c());
            zzjoVar.zzG(o.b());
        }
    }

    public void b(String str) {
        zzx.a(str);
        c(str);
        n().add(new zzb(this.b, str));
    }

    public void b(boolean z) {
        this.c = z;
    }

    public void c(String str) {
        Uri a2 = zzb.a(str);
        ListIterator<zzi> listIterator = n().listIterator();
        while (listIterator.hasNext()) {
            if (a2.equals(listIterator.next().a())) {
                listIterator.remove();
            }
        }
    }

    public com.google.android.gms.analytics.internal.zzf k() {
        return this.b;
    }

    @Override // com.google.android.gms.measurement.zzf
    public com.google.android.gms.measurement.zzc l() {
        com.google.android.gms.measurement.zzc a2 = m().a();
        a2.a(this.b.q().c());
        a2.a(this.b.r().b());
        b(a2);
        return a2;
    }
}

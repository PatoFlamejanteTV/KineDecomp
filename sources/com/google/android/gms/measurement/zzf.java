package com.google.android.gms.measurement;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.measurement.zzf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class zzf<T extends zzf> {

    /* renamed from: a, reason: collision with root package name */
    protected final zzc f2078a;
    private final zzg b;
    private final List<zzd> c;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzf(zzg zzgVar, zzmn zzmnVar) {
        zzx.a(zzgVar);
        this.b = zzgVar;
        this.c = new ArrayList();
        zzc zzcVar = new zzc(this, zzmnVar);
        zzcVar.k();
        this.f2078a = zzcVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(zzc zzcVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(zzc zzcVar) {
        Iterator<zzd> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a(this, zzcVar);
        }
    }

    public zzc l() {
        zzc a2 = this.f2078a.a();
        b(a2);
        return a2;
    }

    public zzc m() {
        return this.f2078a;
    }

    public List<zzi> n() {
        return this.f2078a.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzg o() {
        return this.b;
    }
}

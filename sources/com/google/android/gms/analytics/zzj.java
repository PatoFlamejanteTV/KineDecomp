package com.google.android.gms.analytics;

import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class zzj<T extends zzj> {

    /* renamed from: a */
    private final zzk f10371a;

    /* renamed from: b */
    protected final zzg f10372b;

    /* renamed from: c */
    private final List<zzh> f10373c;

    @VisibleForTesting
    public zzj(zzk zzkVar, Clock clock) {
        Preconditions.a(zzkVar);
        this.f10371a = zzkVar;
        this.f10373c = new ArrayList();
        zzg zzgVar = new zzg(this, clock);
        zzgVar.j();
        this.f10372b = zzgVar;
    }

    public final zzk a() {
        return this.f10371a;
    }

    public void a(zzg zzgVar) {
    }

    public final void b(zzg zzgVar) {
        Iterator<zzh> it = this.f10373c.iterator();
        while (it.hasNext()) {
            it.next().a(this, zzgVar);
        }
    }
}

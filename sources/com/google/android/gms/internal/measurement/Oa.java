package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class Oa implements Na {
    @Override // com.google.android.gms.internal.measurement.Na
    public final Object a(Object obj) {
        ((zzvp) obj).zzsw();
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.Na
    public final boolean b(Object obj) {
        return !((zzvp) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.measurement.Na
    public final Map<?, ?> c(Object obj) {
        return (zzvp) obj;
    }

    @Override // com.google.android.gms.internal.measurement.Na
    public final Map<?, ?> d(Object obj) {
        return (zzvp) obj;
    }

    @Override // com.google.android.gms.internal.measurement.Na
    public final Object e(Object obj) {
        return zzvp.zzxg().zzxh();
    }

    @Override // com.google.android.gms.internal.measurement.Na
    public final Ma<?, ?> f(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.Na
    public final int a(int i, Object obj, Object obj2) {
        zzvp zzvpVar = (zzvp) obj;
        if (zzvpVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzvpVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.Na
    public final Object b(Object obj, Object obj2) {
        zzvp zzvpVar = (zzvp) obj;
        zzvp zzvpVar2 = (zzvp) obj2;
        if (!zzvpVar2.isEmpty()) {
            if (!zzvpVar.isMutable()) {
                zzvpVar = zzvpVar.zzxh();
            }
            zzvpVar.zza(zzvpVar2);
        }
        return zzvpVar;
    }
}

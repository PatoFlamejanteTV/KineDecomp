package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class Ga extends Ea {

    /* renamed from: c */
    private static final Class<?> f13366c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* JADX INFO: Access modifiers changed from: private */
    public Ga() {
        super();
    }

    private static <E> List<E> c(Object obj, long j) {
        return (List) xb.f(obj, j);
    }

    @Override // com.google.android.gms.internal.measurement.Ea
    public final <L> List<L> a(Object obj, long j) {
        return a(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.measurement.Ea
    public final void b(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) xb.f(obj, j);
        if (list instanceof zzve) {
            unmodifiableList = ((zzve) list).zzxc();
        } else {
            if (f13366c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof Ya) && (list instanceof zzuu)) {
                zzuu zzuuVar = (zzuu) list;
                if (zzuuVar.zztz()) {
                    zzuuVar.zzsw();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        xb.a(obj, j, unmodifiableList);
    }

    public /* synthetic */ Ga(Fa fa) {
        this();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> a(Object obj, long j, int i) {
        zzvd zzvdVar;
        List<L> arrayList;
        List<L> c2 = c(obj, j);
        if (c2.isEmpty()) {
            if (c2 instanceof zzve) {
                arrayList = new zzvd(i);
            } else if ((c2 instanceof Ya) && (c2 instanceof zzuu)) {
                arrayList = ((zzuu) c2).zzal(i);
            } else {
                arrayList = new ArrayList<>(i);
            }
            xb.a(obj, j, arrayList);
            return arrayList;
        }
        if (f13366c.isAssignableFrom(c2.getClass())) {
            ArrayList arrayList2 = new ArrayList(c2.size() + i);
            arrayList2.addAll(c2);
            xb.a(obj, j, arrayList2);
            zzvdVar = arrayList2;
        } else if (c2 instanceof zzxg) {
            zzvd zzvdVar2 = new zzvd(c2.size() + i);
            zzvdVar2.addAll((zzxg) c2);
            xb.a(obj, j, zzvdVar2);
            zzvdVar = zzvdVar2;
        } else {
            if (!(c2 instanceof Ya) || !(c2 instanceof zzuu)) {
                return c2;
            }
            zzuu zzuuVar = (zzuu) c2;
            if (zzuuVar.zztz()) {
                return c2;
            }
            zzuu zzal = zzuuVar.zzal(c2.size() + i);
            xb.a(obj, j, zzal);
            return zzal;
        }
        return zzvdVar;
    }

    @Override // com.google.android.gms.internal.measurement.Ea
    public final <E> void a(Object obj, Object obj2, long j) {
        List c2 = c(obj2, j);
        List a2 = a(obj, j, c2.size());
        int size = a2.size();
        int size2 = c2.size();
        if (size > 0 && size2 > 0) {
            a2.addAll(c2);
        }
        if (size > 0) {
            c2 = a2;
        }
        xb.a(obj, j, c2);
    }
}

package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class Ea extends Ca {

    /* renamed from: c */
    private static final Class<?> f13142c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* JADX INFO: Access modifiers changed from: private */
    public Ea() {
        super();
    }

    private static <E> List<E> c(Object obj, long j) {
        return (List) ub.f(obj, j);
    }

    @Override // com.google.android.gms.internal.gtm.Ca
    public final <L> List<L> a(Object obj, long j) {
        return a(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.gtm.Ca
    public final void b(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) ub.f(obj, j);
        if (list instanceof zzrt) {
            unmodifiableList = ((zzrt) list).zzqb();
        } else {
            if (f13142c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof Wa) && (list instanceof zzrj)) {
                zzrj zzrjVar = (zzrj) list;
                if (zzrjVar.zzmy()) {
                    zzrjVar.zzmi();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        ub.a(obj, j, unmodifiableList);
    }

    public /* synthetic */ Ea(Da da) {
        this();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> a(Object obj, long j, int i) {
        zzrs zzrsVar;
        List<L> arrayList;
        List<L> c2 = c(obj, j);
        if (c2.isEmpty()) {
            if (c2 instanceof zzrt) {
                arrayList = new zzrs(i);
            } else if ((c2 instanceof Wa) && (c2 instanceof zzrj)) {
                arrayList = ((zzrj) c2).zzaj(i);
            } else {
                arrayList = new ArrayList<>(i);
            }
            ub.a(obj, j, arrayList);
            return arrayList;
        }
        if (f13142c.isAssignableFrom(c2.getClass())) {
            ArrayList arrayList2 = new ArrayList(c2.size() + i);
            arrayList2.addAll(c2);
            ub.a(obj, j, arrayList2);
            zzrsVar = arrayList2;
        } else if (c2 instanceof zztu) {
            zzrs zzrsVar2 = new zzrs(c2.size() + i);
            zzrsVar2.addAll((zztu) c2);
            ub.a(obj, j, zzrsVar2);
            zzrsVar = zzrsVar2;
        } else {
            if (!(c2 instanceof Wa) || !(c2 instanceof zzrj)) {
                return c2;
            }
            zzrj zzrjVar = (zzrj) c2;
            if (zzrjVar.zzmy()) {
                return c2;
            }
            zzrj zzaj = zzrjVar.zzaj(c2.size() + i);
            ub.a(obj, j, zzaj);
            return zzaj;
        }
        return zzrsVar;
    }

    @Override // com.google.android.gms.internal.gtm.Ca
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
        ub.a(obj, j, c2);
    }
}

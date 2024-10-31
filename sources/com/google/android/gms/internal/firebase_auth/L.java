package com.google.android.gms.internal.firebase_auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class L extends J {

    /* renamed from: c */
    private static final Class<?> f12983c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* JADX INFO: Access modifiers changed from: private */
    public L() {
        super();
    }

    private static <E> List<E> c(Object obj, long j) {
        return (List) Ja.f(obj, j);
    }

    @Override // com.google.android.gms.internal.firebase_auth.J
    public final <L> List<L> a(Object obj, long j) {
        return a(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.firebase_auth.J
    public final void b(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) Ja.f(obj, j);
        if (list instanceof zzgl) {
            unmodifiableList = ((zzgl) list).zzid();
        } else {
            if (f12983c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof InterfaceC1247ea) && (list instanceof zzgb)) {
                zzgb zzgbVar = (zzgb) list;
                if (zzgbVar.zzeu()) {
                    zzgbVar.zzev();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        Ja.a(obj, j, unmodifiableList);
    }

    public /* synthetic */ L(K k) {
        this();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> a(Object obj, long j, int i) {
        zzgk zzgkVar;
        List<L> arrayList;
        List<L> c2 = c(obj, j);
        if (c2.isEmpty()) {
            if (c2 instanceof zzgl) {
                arrayList = new zzgk(i);
            } else if ((c2 instanceof InterfaceC1247ea) && (c2 instanceof zzgb)) {
                arrayList = ((zzgb) c2).zzj(i);
            } else {
                arrayList = new ArrayList<>(i);
            }
            Ja.a(obj, j, arrayList);
            return arrayList;
        }
        if (f12983c.isAssignableFrom(c2.getClass())) {
            ArrayList arrayList2 = new ArrayList(c2.size() + i);
            arrayList2.addAll(c2);
            Ja.a(obj, j, arrayList2);
            zzgkVar = arrayList2;
        } else if (c2 instanceof zzit) {
            zzgk zzgkVar2 = new zzgk(c2.size() + i);
            zzgkVar2.addAll((zzit) c2);
            Ja.a(obj, j, zzgkVar2);
            zzgkVar = zzgkVar2;
        } else {
            if (!(c2 instanceof InterfaceC1247ea) || !(c2 instanceof zzgb)) {
                return c2;
            }
            zzgb zzgbVar = (zzgb) c2;
            if (zzgbVar.zzeu()) {
                return c2;
            }
            zzgb zzj = zzgbVar.zzj(c2.size() + i);
            Ja.a(obj, j, zzj);
            return zzj;
        }
        return zzgkVar;
    }

    @Override // com.google.android.gms.internal.firebase_auth.J
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
        Ja.a(obj, j, c2);
    }
}

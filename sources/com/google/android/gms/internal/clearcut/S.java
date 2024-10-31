package com.google.android.gms.internal.clearcut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class S extends O {

    /* renamed from: c */
    private static final Class<?> f12807c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* JADX INFO: Access modifiers changed from: private */
    public S() {
        super();
    }

    public /* synthetic */ S(P p) {
        this();
    }

    private static <E> List<E> b(Object obj, long j) {
        return (List) La.f(obj, j);
    }

    @Override // com.google.android.gms.internal.clearcut.O
    public final void a(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) La.f(obj, j);
        if (list instanceof zzcx) {
            unmodifiableList = ((zzcx) list).zzbu();
        } else if (f12807c.isAssignableFrom(list.getClass())) {
            return;
        } else {
            unmodifiableList = Collections.unmodifiableList(list);
        }
        La.a(obj, j, unmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.clearcut.O
    public final <E> void a(Object obj, Object obj2, long j) {
        zzcw zzcwVar;
        List b2 = b(obj2, j);
        int size = b2.size();
        List b3 = b(obj, j);
        if (b3.isEmpty()) {
            b3 = b3 instanceof zzcx ? new zzcw(size) : new ArrayList(size);
            La.a(obj, j, b3);
        } else {
            if (f12807c.isAssignableFrom(b3.getClass())) {
                ArrayList arrayList = new ArrayList(b3.size() + size);
                arrayList.addAll(b3);
                zzcwVar = arrayList;
            } else if (b3 instanceof zzfa) {
                zzcw zzcwVar2 = new zzcw(b3.size() + size);
                zzcwVar2.addAll((zzfa) b3);
                zzcwVar = zzcwVar2;
            }
            La.a(obj, j, zzcwVar);
            b3 = zzcwVar;
        }
        int size2 = b3.size();
        int size3 = b2.size();
        if (size2 > 0 && size3 > 0) {
            b3.addAll(b2);
        }
        if (size2 > 0) {
            b2 = b3;
        }
        La.a(obj, j, b2);
    }
}

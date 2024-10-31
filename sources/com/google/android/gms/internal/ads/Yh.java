package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class Yh extends Wh {

    /* renamed from: c */
    private static final Class<?> f11981c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* JADX INFO: Access modifiers changed from: private */
    public Yh() {
        super();
    }

    private static <E> List<E> c(Object obj, long j) {
        return (List) Pi.f(obj, j);
    }

    @Override // com.google.android.gms.internal.ads.Wh
    public final <L> List<L> a(Object obj, long j) {
        return a(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.ads.Wh
    public final void b(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) Pi.f(obj, j);
        if (list instanceof zzbru) {
            unmodifiableList = ((zzbru) list).zzanp();
        } else {
            if (f11981c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof InterfaceC1043pi) && (list instanceof zzbrk)) {
                zzbrk zzbrkVar = (zzbrk) list;
                if (zzbrkVar.zzaki()) {
                    zzbrkVar.zzakj();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        Pi.a(obj, j, unmodifiableList);
    }

    public /* synthetic */ Yh(Xh xh) {
        this();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> a(Object obj, long j, int i) {
        zzbrt zzbrtVar;
        List<L> arrayList;
        List<L> c2 = c(obj, j);
        if (c2.isEmpty()) {
            if (c2 instanceof zzbru) {
                arrayList = new zzbrt(i);
            } else if ((c2 instanceof InterfaceC1043pi) && (c2 instanceof zzbrk)) {
                arrayList = ((zzbrk) c2).zzel(i);
            } else {
                arrayList = new ArrayList<>(i);
            }
            Pi.a(obj, j, arrayList);
            return arrayList;
        }
        if (f11981c.isAssignableFrom(c2.getClass())) {
            ArrayList arrayList2 = new ArrayList(c2.size() + i);
            arrayList2.addAll(c2);
            Pi.a(obj, j, arrayList2);
            zzbrtVar = arrayList2;
        } else if (c2 instanceof zzbtx) {
            zzbrt zzbrtVar2 = new zzbrt(c2.size() + i);
            zzbrtVar2.addAll((zzbtx) c2);
            Pi.a(obj, j, zzbrtVar2);
            zzbrtVar = zzbrtVar2;
        } else {
            if (!(c2 instanceof InterfaceC1043pi) || !(c2 instanceof zzbrk)) {
                return c2;
            }
            zzbrk zzbrkVar = (zzbrk) c2;
            if (zzbrkVar.zzaki()) {
                return c2;
            }
            zzbrk zzel = zzbrkVar.zzel(c2.size() + i);
            Pi.a(obj, j, zzel);
            return zzel;
        }
        return zzbrtVar;
    }

    @Override // com.google.android.gms.internal.ads.Wh
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
        Pi.a(obj, j, c2);
    }
}

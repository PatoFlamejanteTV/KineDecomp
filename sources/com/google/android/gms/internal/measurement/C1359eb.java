package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.measurement.eb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1359eb {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f13442a = d();

    /* renamed from: b, reason: collision with root package name */
    private static final tb<?, ?> f13443b = a(false);

    /* renamed from: c, reason: collision with root package name */
    private static final tb<?, ?> f13444c = a(true);

    /* renamed from: d, reason: collision with root package name */
    private static final tb<?, ?> f13445d = new ub();

    public static void a(Class<?> cls) {
        Class<?> cls2;
        if (!zzuo.class.isAssignableFrom(cls) && (cls2 = f13442a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void b(int i, List<Float> list, Fb fb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        fb.n(i, list, z);
    }

    public static void c(int i, List<Long> list, Fb fb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        fb.b(i, list, z);
    }

    public static void d(int i, List<Long> list, Fb fb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        fb.l(i, list, z);
    }

    public static void e(int i, List<Long> list, Fb fb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        fb.d(i, list, z);
    }

    public static void f(int i, List<Long> list, Fb fb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        fb.k(i, list, z);
    }

    public static void g(int i, List<Long> list, Fb fb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        fb.h(i, list, z);
    }

    public static void h(int i, List<Integer> list, Fb fb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        fb.a(i, list, z);
    }

    public static void i(int i, List<Integer> list, Fb fb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        fb.i(i, list, z);
    }

    public static void j(int i, List<Integer> list, Fb fb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        fb.e(i, list, z);
    }

    public static void k(int i, List<Integer> list, Fb fb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        fb.c(i, list, z);
    }

    public static void l(int i, List<Integer> list, Fb fb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        fb.j(i, list, z);
    }

    public static void m(int i, List<Integer> list, Fb fb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        fb.g(i, list, z);
    }

    public static void n(int i, List<Boolean> list, Fb fb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        fb.f(i, list, z);
    }

    public static void b(int i, List<zzte> list, Fb fb) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        fb.a(i, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return a(list) + (size * zztv.zzbd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return b(list) + (size * zztv.zzbd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return c(list) + (size * zztv.zzbd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return d(list) + (size * zztv.zzbd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return e(list) + (size * zztv.zzbd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zztv.zzk(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof Ia) {
            Ia ia = (Ia) list;
            i = 0;
            while (i2 < size) {
                i += zztv.zzaw(ia.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zztv.zzaw(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof Ia) {
            Ia ia = (Ia) list;
            i = 0;
            while (i2 < size) {
                i += zztv.zzax(ia.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zztv.zzax(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void a(int i, List<Double> list, Fb fb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        fb.m(i, list, z);
    }

    public static void b(int i, List<?> list, Fb fb, InterfaceC1353cb interfaceC1353cb) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        fb.a(i, list, interfaceC1353cb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(List<?> list) {
        return list.size();
    }

    public static void a(int i, List<String> list, Fb fb) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        fb.b(i, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof Aa) {
            Aa aa = (Aa) list;
            i = 0;
            while (i2 < size) {
                i += zztv.zzbe(aa.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zztv.zzbe(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof Aa) {
            Aa aa = (Aa) list;
            i = 0;
            while (i2 < size) {
                i += zztv.zzbf(aa.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zztv.zzbf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof Aa) {
            Aa aa = (Aa) list;
            i = 0;
            while (i2 < size) {
                i += zztv.zzbg(aa.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zztv.zzbg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(List<?> list) {
        return list.size() << 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(List<?> list) {
        return list.size() << 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return j(list) + (size * zztv.zzbd(i));
    }

    public static void a(int i, List<?> list, Fb fb, InterfaceC1353cb interfaceC1353cb) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        fb.b(i, list, interfaceC1353cb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zztv.zzg(i, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zztv.zzc(i, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return i(list) + (list.size() * zztv.zzbd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof Aa) {
            Aa aa = (Aa) list;
            i = 0;
            while (i2 < size) {
                i += zztv.zzbj(aa.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zztv.zzbj(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static tb<?, ?> c() {
        return f13445d;
    }

    private static Class<?> d() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> e() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof Ia) {
            Ia ia = (Ia) list;
            i = 0;
            while (i2 < size) {
                i += zztv.zzay(ia.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zztv.zzay(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzte> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbd = size * zztv.zzbd(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzbd += zztv.zzb(list.get(i2));
        }
        return zzbd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list) {
        int zzgc;
        int zzgc2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zzbd = zztv.zzbd(i) * size;
        if (list instanceof zzve) {
            zzve zzveVar = (zzve) list;
            while (i2 < size) {
                Object zzbp = zzveVar.zzbp(i2);
                if (zzbp instanceof zzte) {
                    zzgc2 = zztv.zzb((zzte) zzbp);
                } else {
                    zzgc2 = zztv.zzgc((String) zzbp);
                }
                zzbd += zzgc2;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzte) {
                    zzgc = zztv.zzb((zzte) obj);
                } else {
                    zzgc = zztv.zzgc((String) obj);
                }
                zzbd += zzgc;
                i2++;
            }
        }
        return zzbd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzvv> list, InterfaceC1353cb interfaceC1353cb) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zztv.zzc(i, list.get(i3), interfaceC1353cb);
        }
        return i2;
    }

    public static tb<?, ?> b() {
        return f13444c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, Object obj, InterfaceC1353cb interfaceC1353cb) {
        if (obj instanceof zzvc) {
            return zztv.zza(i, (zzvc) obj);
        }
        return zztv.zzb(i, (zzvv) obj, interfaceC1353cb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list, InterfaceC1353cb interfaceC1353cb) {
        int zzb;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbd = zztv.zzbd(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzvc) {
                zzb = zztv.zza((zzvc) obj);
            } else {
                zzb = zztv.zzb((zzvv) obj, interfaceC1353cb);
            }
            zzbd += zzb;
        }
        return zzbd;
    }

    public static tb<?, ?> a() {
        return f13443b;
    }

    private static tb<?, ?> a(boolean z) {
        try {
            Class<?> e2 = e();
            if (e2 == null) {
                return null;
            }
            return (tb) e2.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void a(Na na, T t, T t2, long j) {
        xb.a(t, j, na.b(xb.f(t, j), xb.f(t2, j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzuh<FT>> void a(AbstractC1387ra<FT> abstractC1387ra, T t, T t2) {
        C1393ua<FT> a2 = abstractC1387ra.a(t2);
        if (a2.b()) {
            return;
        }
        abstractC1387ra.b(t).a(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void a(tb<UT, UB> tbVar, T t, T t2) {
        tbVar.a(t, tbVar.c(tbVar.c(t), tbVar.c(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, List<Integer> list, zzut zzutVar, UB ub, tb<UT, UB> tbVar) {
        UB ub2;
        int intValue;
        if (zzutVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue2 = list.get(i3).intValue();
                if (zzutVar.zzb(intValue2)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue2));
                    }
                    i2++;
                } else {
                    ub2 = (UB) a(i, intValue2, ub2, tbVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            loop1: while (true) {
                ub2 = ub;
                while (it.hasNext()) {
                    intValue = it.next().intValue();
                    if (!zzutVar.zzb(intValue)) {
                        break;
                    }
                }
                ub = (UB) a(i, intValue, ub2, tbVar);
                it.remove();
            }
        }
        return ub2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, int i2, UB ub, tb<UT, UB> tbVar) {
        if (ub == null) {
            ub = tbVar.a();
        }
        tbVar.a((tb<UT, UB>) ub, i, i2);
        return ub;
    }
}

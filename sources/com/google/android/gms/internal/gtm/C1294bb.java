package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.gtm.bb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1294bb {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f13209a = d();

    /* renamed from: b, reason: collision with root package name */
    private static final qb<?, ?> f13210b = a(false);

    /* renamed from: c, reason: collision with root package name */
    private static final qb<?, ?> f13211c = a(true);

    /* renamed from: d, reason: collision with root package name */
    private static final qb<?, ?> f13212d = new rb();

    public static void a(Class<?> cls) {
        Class<?> cls2;
        if (!zzrc.class.isAssignableFrom(cls) && (cls2 = f13209a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void b(int i, List<Float> list, Cb cb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        cb.n(i, list, z);
    }

    public static void c(int i, List<Long> list, Cb cb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        cb.b(i, list, z);
    }

    public static void d(int i, List<Long> list, Cb cb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        cb.l(i, list, z);
    }

    public static void e(int i, List<Long> list, Cb cb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        cb.d(i, list, z);
    }

    public static void f(int i, List<Long> list, Cb cb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        cb.k(i, list, z);
    }

    public static void g(int i, List<Long> list, Cb cb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        cb.h(i, list, z);
    }

    public static void h(int i, List<Integer> list, Cb cb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        cb.a(i, list, z);
    }

    public static void i(int i, List<Integer> list, Cb cb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        cb.i(i, list, z);
    }

    public static void j(int i, List<Integer> list, Cb cb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        cb.e(i, list, z);
    }

    public static void k(int i, List<Integer> list, Cb cb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        cb.c(i, list, z);
    }

    public static void l(int i, List<Integer> list, Cb cb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        cb.j(i, list, z);
    }

    public static void m(int i, List<Integer> list, Cb cb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        cb.g(i, list, z);
    }

    public static void n(int i, List<Boolean> list, Cb cb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        cb.f(i, list, z);
    }

    public static void b(int i, List<zzps> list, Cb cb) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        cb.a(i, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return i(list) + (size * zzqj.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return j(list) + (size * zzqj.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return a(list) + (size * zzqj.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return b(list) + (size * zzqj.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof Ga) {
            Ga ga = (Ga) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzs(ga.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzs(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof Ga) {
            Ga ga = (Ga) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzt(ga.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzt(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof Ga) {
            Ga ga = (Ga) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzu(ga.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzu(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1342ya) {
            C1342ya c1342ya = (C1342ya) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbh(c1342ya.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbh(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void a(int i, List<Double> list, Cb cb, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        cb.m(i, list, z);
    }

    public static void b(int i, List<?> list, Cb cb, _a _aVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        cb.b(i, list, _aVar);
    }

    public static void a(int i, List<String> list, Cb cb) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        cb.b(i, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1342ya) {
            C1342ya c1342ya = (C1342ya) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbe(c1342ya.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbe(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(List<?> list) {
        return list.size() << 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List<?> list) {
        return list.size() << 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(List<?> list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return h(list) + (size * zzqj.zzbb(i));
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

    public static void a(int i, List<?> list, Cb cb, _a _aVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        cb.a(i, list, _aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return c(list) + (size * zzqj.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzqj.zzl(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzqj.zzg(i, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzqj.zzc(i, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return g(list) + (list.size() * zzqj.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1342ya) {
            C1342ya c1342ya = (C1342ya) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbd(c1342ya.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbd(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static qb<?, ?> c() {
        return f13212d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1342ya) {
            C1342ya c1342ya = (C1342ya) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbc(c1342ya.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbc(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzps> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbb = size * zzqj.zzbb(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzbb += zzqj.zzb(list.get(i2));
        }
        return zzbb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list) {
        int zzda;
        int zzda2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zzbb = zzqj.zzbb(i) * size;
        if (list instanceof zzrt) {
            zzrt zzrtVar = (zzrt) list;
            while (i2 < size) {
                Object zzbn = zzrtVar.zzbn(i2);
                if (zzbn instanceof zzps) {
                    zzda2 = zzqj.zzb((zzps) zzbn);
                } else {
                    zzda2 = zzqj.zzda((String) zzbn);
                }
                zzbb += zzda2;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzps) {
                    zzda = zzqj.zzb((zzps) obj);
                } else {
                    zzda = zzqj.zzda((String) obj);
                }
                zzbb += zzda;
                i2++;
            }
        }
        return zzbb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzsk> list, _a _aVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzqj.zzc(i, list.get(i3), _aVar);
        }
        return i2;
    }

    public static qb<?, ?> b() {
        return f13211c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, Object obj, _a _aVar) {
        if (obj instanceof zzrr) {
            return zzqj.zza(i, (zzrr) obj);
        }
        return zzqj.zzb(i, (zzsk) obj, _aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list, _a _aVar) {
        int zzb;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbb = zzqj.zzbb(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzrr) {
                zzb = zzqj.zza((zzrr) obj);
            } else {
                zzb = zzqj.zzb((zzsk) obj, _aVar);
            }
            zzbb += zzb;
        }
        return zzbb;
    }

    public static qb<?, ?> a() {
        return f13210b;
    }

    private static qb<?, ?> a(boolean z) {
        try {
            Class<?> e2 = e();
            if (e2 == null) {
                return null;
            }
            return (qb) e2.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
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
    public static <T> void a(La la, T t, T t2, long j) {
        ub.a(t, j, la.b(ub.f(t, j), ub.f(t2, j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzqv<FT>> void a(AbstractC1325pa<FT> abstractC1325pa, T t, T t2) {
        C1330sa<FT> a2 = abstractC1325pa.a(t2);
        if (a2.f13291b.isEmpty()) {
            return;
        }
        abstractC1325pa.b(t).a(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void a(qb<UT, UB> qbVar, T t, T t2) {
        qbVar.a(t, qbVar.c(qbVar.c(t), qbVar.c(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, List<Integer> list, zzrh zzrhVar, UB ub, qb<UT, UB> qbVar) {
        UB ub2;
        int intValue;
        if (zzrhVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue2 = list.get(i3).intValue();
                if (zzrhVar.zzb(intValue2)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue2));
                    }
                    i2++;
                } else {
                    ub2 = (UB) a(i, intValue2, ub2, qbVar);
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
                    if (!zzrhVar.zzb(intValue)) {
                        break;
                    }
                }
                ub = (UB) a(i, intValue, ub2, qbVar);
                it.remove();
            }
        }
        return ub2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, int i2, UB ub, qb<UT, UB> qbVar) {
        if (ub == null) {
            ub = qbVar.a();
        }
        qbVar.a((qb<UT, UB>) ub, i, i2);
        return ub;
    }
}

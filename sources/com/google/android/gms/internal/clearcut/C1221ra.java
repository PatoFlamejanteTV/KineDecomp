package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.clearcut.ra, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1221ra {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f12882a = d();

    /* renamed from: b, reason: collision with root package name */
    private static final Ga<?, ?> f12883b = a(false);

    /* renamed from: c, reason: collision with root package name */
    private static final Ga<?, ?> f12884c = a(true);

    /* renamed from: d, reason: collision with root package name */
    private static final Ga<?, ?> f12885d = new Ha();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, Object obj, InterfaceC1218pa interfaceC1218pa) {
        return obj instanceof zzcv ? zzbn.zza(i, (zzcv) obj) : zzbn.zzb(i, (zzdo) obj, interfaceC1218pa);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zzr = zzbn.zzr(i) * size;
        if (list instanceof zzcx) {
            zzcx zzcxVar = (zzcx) list;
            while (i2 < size) {
                Object raw = zzcxVar.getRaw(i2);
                zzr += raw instanceof zzbb ? zzbn.zzb((zzbb) raw) : zzbn.zzh((String) raw);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                zzr += obj instanceof zzbb ? zzbn.zzb((zzbb) obj) : zzbn.zzh((String) obj);
                i2++;
            }
        }
        return zzr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list, InterfaceC1218pa interfaceC1218pa) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzr = zzbn.zzr(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            zzr += obj instanceof zzcv ? zzbn.zza((zzcv) obj) : zzbn.zzb((zzdo) obj, interfaceC1218pa);
        }
        return zzr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return a(list) + (list.size() * zzbn.zzr(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof U) {
            U u = (U) list;
            i = 0;
            while (i2 < size) {
                i += zzbn.zze(u.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzbn.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static Ga<?, ?> a() {
        return f12883b;
    }

    private static Ga<?, ?> a(boolean z) {
        try {
            Class<?> e2 = e();
            if (e2 == null) {
                return null;
            }
            return (Ga) e2.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static <UT, UB> UB a(int i, int i2, UB ub, Ga<UT, UB> ga) {
        if (ub == null) {
            ub = ga.a();
        }
        ga.a(ub, i, i2);
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, List<Integer> list, zzck<?> zzckVar, UB ub, Ga<UT, UB> ga) {
        UB ub2;
        int intValue;
        if (zzckVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue2 = list.get(i3).intValue();
                if (zzckVar.zzb(intValue2) != null) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue2));
                    }
                    i2++;
                } else {
                    ub2 = (UB) a(i, intValue2, ub2, ga);
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
                    if (zzckVar.zzb(intValue) == null) {
                        break;
                    }
                }
                ub = (UB) a(i, intValue, ub2, ga);
                it.remove();
            }
        }
        return ub2;
    }

    public static void a(int i, List<String> list, Sa sa) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        sa.b(i, list);
    }

    public static void a(int i, List<?> list, Sa sa, InterfaceC1218pa interfaceC1218pa) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        sa.b(i, list, interfaceC1218pa);
    }

    public static void a(int i, List<Double> list, Sa sa, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        sa.m(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzca<FT>> void a(B<FT> b2, T t, T t2) {
        F<FT> a2 = b2.a(t2);
        if (a2.b()) {
            return;
        }
        b2.b(t).a(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void a(Ga<UT, UB> ga, T t, T t2) {
        ga.a(t, ga.c(ga.c(t), ga.c(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void a(Z z, T t, T t2, long j) {
        La.a(t, j, z.a(La.f(t, j), La.f(t2, j)));
    }

    public static void a(Class<?> cls) {
        Class<?> cls2;
        if (!zzcg.class.isAssignableFrom(cls) && (cls2 = f12882a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean a(int i, int i2, int i3) {
        if (i2 < 40) {
            return true;
        }
        long j = i3;
        return ((((long) i2) - ((long) i)) + 1) + 9 <= ((2 * j) + 3) + ((j + 3) * 3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzbb> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzr = size * zzbn.zzr(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzr += zzbn.zzb(list.get(i2));
        }
        return zzr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzdo> list, InterfaceC1218pa interfaceC1218pa) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzbn.zzc(i, list.get(i3), interfaceC1218pa);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return b(list) + (size * zzbn.zzr(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof U) {
            U u = (U) list;
            i = 0;
            while (i2 < size) {
                i += zzbn.zzf(u.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzbn.zzf(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static Ga<?, ?> b() {
        return f12884c;
    }

    public static void b(int i, List<zzbb> list, Sa sa) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        sa.a(i, list);
    }

    public static void b(int i, List<?> list, Sa sa, InterfaceC1218pa interfaceC1218pa) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        sa.a(i, list, interfaceC1218pa);
    }

    public static void b(int i, List<Float> list, Sa sa, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        sa.n(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return c(list) + (size * zzbn.zzr(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof U) {
            U u = (U) list;
            i = 0;
            while (i2 < size) {
                i += zzbn.zzg(u.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzbn.zzg(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static Ga<?, ?> c() {
        return f12885d;
    }

    public static void c(int i, List<Long> list, Sa sa, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        sa.b(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return d(list) + (size * zzbn.zzr(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof K) {
            K k = (K) list;
            i = 0;
            while (i2 < size) {
                i += zzbn.zzx(k.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzbn.zzx(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    private static Class<?> d() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void d(int i, List<Long> list, Sa sa, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        sa.l(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return e(list) + (size * zzbn.zzr(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof K) {
            K k = (K) list;
            i = 0;
            while (i2 < size) {
                i += zzbn.zzs(k.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzbn.zzs(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    private static Class<?> e() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void e(int i, List<Long> list, Sa sa, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        sa.d(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return f(list) + (size * zzbn.zzr(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof K) {
            K k = (K) list;
            i = 0;
            while (i2 < size) {
                i += zzbn.zzt(k.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzbn.zzt(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void f(int i, List<Long> list, Sa sa, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        sa.k(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return g(list) + (size * zzbn.zzr(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof K) {
            K k = (K) list;
            i = 0;
            while (i2 < size) {
                i += zzbn.zzu(k.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzbn.zzu(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void g(int i, List<Long> list, Sa sa, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        sa.h(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbn.zzj(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(List<?> list) {
        return list.size() << 2;
    }

    public static void h(int i, List<Integer> list, Sa sa, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        sa.a(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbn.zzg(i, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(List<?> list) {
        return list.size() << 3;
    }

    public static void i(int i, List<Integer> list, Sa sa, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        sa.i(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbn.zzc(i, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(List<?> list) {
        return list.size();
    }

    public static void j(int i, List<Integer> list, Sa sa, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        sa.e(i, list, z);
    }

    public static void k(int i, List<Integer> list, Sa sa, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        sa.c(i, list, z);
    }

    public static void l(int i, List<Integer> list, Sa sa, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        sa.j(i, list, z);
    }

    public static void m(int i, List<Integer> list, Sa sa, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        sa.g(i, list, z);
    }

    public static void n(int i, List<Boolean> list, Sa sa, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        sa.f(i, list, z);
    }
}

package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.wi, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1140wi {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f12630a = d();

    /* renamed from: b, reason: collision with root package name */
    private static final Li<?, ?> f12631b = a(false);

    /* renamed from: c, reason: collision with root package name */
    private static final Li<?, ?> f12632c = a(true);

    /* renamed from: d, reason: collision with root package name */
    private static final Li<?, ?> f12633d = new Mi();

    public static void a(Class<?> cls) {
        Class<?> cls2;
        if (!zzbrd.class.isAssignableFrom(cls) && (cls2 = f12630a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void b(int i, List<Float> list, Xi xi, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        xi.n(i, list, z);
    }

    public static void c(int i, List<Long> list, Xi xi, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        xi.b(i, list, z);
    }

    public static void d(int i, List<Long> list, Xi xi, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        xi.l(i, list, z);
    }

    public static void e(int i, List<Long> list, Xi xi, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        xi.d(i, list, z);
    }

    public static void f(int i, List<Long> list, Xi xi, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        xi.k(i, list, z);
    }

    public static void g(int i, List<Long> list, Xi xi, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        xi.h(i, list, z);
    }

    public static void h(int i, List<Integer> list, Xi xi, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        xi.a(i, list, z);
    }

    public static void i(int i, List<Integer> list, Xi xi, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        xi.i(i, list, z);
    }

    public static void j(int i, List<Integer> list, Xi xi, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        xi.e(i, list, z);
    }

    public static void k(int i, List<Integer> list, Xi xi, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        xi.c(i, list, z);
    }

    public static void l(int i, List<Integer> list, Xi xi, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        xi.j(i, list, z);
    }

    public static void m(int i, List<Integer> list, Xi xi, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        xi.g(i, list, z);
    }

    public static void n(int i, List<Boolean> list, Xi xi, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        xi.f(i, list, z);
    }

    public static void b(int i, List<zzbpu> list, Xi xi) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        xi.a(i, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof _h) {
            _h _hVar = (_h) list;
            i = 0;
            while (i2 < size) {
                i += zzbqk.zzbd(_hVar.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzbqk.zzbd(list.get(i2).longValue());
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
        if (list instanceof Sh) {
            Sh sh = (Sh) list;
            i = 0;
            while (i2 < size) {
                i += zzbqk.zzfj(sh.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzbqk.zzfj(list.get(i2).intValue());
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
        if (list instanceof Sh) {
            Sh sh = (Sh) list;
            i = 0;
            while (i2 < size) {
                i += zzbqk.zzfe(sh.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzbqk.zzfe(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof Sh) {
            Sh sh = (Sh) list;
            i = 0;
            while (i2 < size) {
                i += zzbqk.zzff(sh.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzbqk.zzff(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof Sh) {
            Sh sh = (Sh) list;
            i = 0;
            while (i2 < size) {
                i += zzbqk.zzfg(sh.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzbqk.zzfg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(List<?> list) {
        return list.size() << 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(List<?> list) {
        return list.size() << 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(List<?> list) {
        return list.size();
    }

    public static void a(int i, List<Double> list, Xi xi, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        xi.m(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbqk.zzac(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbqk.zzp(i, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbqk.zzk(i, true);
    }

    public static void b(int i, List<?> list, Xi xi, InterfaceC1112ui interfaceC1112ui) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        xi.b(i, list, interfaceC1112ui);
    }

    public static void a(int i, List<String> list, Xi xi) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        xi.b(i, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof _h) {
            _h _hVar = (_h) list;
            i = 0;
            while (i2 < size) {
                i += zzbqk.zzbc(_hVar.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzbqk.zzbc(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void a(int i, List<?> list, Xi xi, InterfaceC1112ui interfaceC1112ui) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        xi.a(i, list, interfaceC1112ui);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return c(list) + (size * zzbqk.zzfd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return d(list) + (size * zzbqk.zzfd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return e(list) + (size * zzbqk.zzfd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return f(list) + (size * zzbqk.zzfd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return g(list) + (size * zzbqk.zzfd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof _h) {
            _h _hVar = (_h) list;
            i = 0;
            while (i2 < size) {
                i += zzbqk.zzbb(_hVar.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzbqk.zzbb(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static Li<?, ?> c() {
        return f12633d;
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
    public static int b(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return b(list) + (size * zzbqk.zzfd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return a(list) + (list.size() * zzbqk.zzfd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzbpu> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzfd = size * zzbqk.zzfd(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzfd += zzbqk.zzao(list.get(i2));
        }
        return zzfd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list) {
        int zzfy;
        int zzfy2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zzfd = zzbqk.zzfd(i) * size;
        if (list instanceof zzbru) {
            zzbru zzbruVar = (zzbru) list;
            while (i2 < size) {
                Object zzfp = zzbruVar.zzfp(i2);
                if (zzfp instanceof zzbpu) {
                    zzfy2 = zzbqk.zzao((zzbpu) zzfp);
                } else {
                    zzfy2 = zzbqk.zzfy((String) zzfp);
                }
                zzfd += zzfy2;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzbpu) {
                    zzfy = zzbqk.zzao((zzbpu) obj);
                } else {
                    zzfy = zzbqk.zzfy((String) obj);
                }
                zzfd += zzfy;
                i2++;
            }
        }
        return zzfd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzbsl> list, InterfaceC1112ui interfaceC1112ui) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzbqk.zzc(i, list.get(i3), interfaceC1112ui);
        }
        return i2;
    }

    public static Li<?, ?> b() {
        return f12632c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, Object obj, InterfaceC1112ui interfaceC1112ui) {
        if (obj instanceof zzbrs) {
            return zzbqk.zza(i, (zzbrs) obj);
        }
        return zzbqk.zzb(i, (zzbsl) obj, interfaceC1112ui);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list, InterfaceC1112ui interfaceC1112ui) {
        int zzb;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzfd = zzbqk.zzfd(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzbrs) {
                zzb = zzbqk.zza((zzbrs) obj);
            } else {
                zzb = zzbqk.zzb((zzbsl) obj, interfaceC1112ui);
            }
            zzfd += zzb;
        }
        return zzfd;
    }

    public static Li<?, ?> a() {
        return f12631b;
    }

    private static Li<?, ?> a(boolean z) {
        try {
            Class<?> e2 = e();
            if (e2 == null) {
                return null;
            }
            return (Li) e2.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
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
    public static <T> void a(InterfaceC0890ei interfaceC0890ei, T t, T t2, long j) {
        Pi.a(t, j, interfaceC0890ei.b(Pi.f(t, j), Pi.f(t2, j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzbqw<FT>> void a(Jh<FT> jh, T t, T t2) {
        Mh<FT> a2 = jh.a(t2);
        if (a2.b()) {
            return;
        }
        jh.b(t).a(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void a(Li<UT, UB> li, T t, T t2) {
        li.a(t, li.c(li.b(t), li.b(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, List<Integer> list, zzbri zzbriVar, UB ub, Li<UT, UB> li) {
        UB ub2;
        int intValue;
        if (zzbriVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue2 = list.get(i3).intValue();
                if (zzbriVar.zzcb(intValue2)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue2));
                    }
                    i2++;
                } else {
                    ub2 = (UB) a(i, intValue2, ub2, li);
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
                    if (!zzbriVar.zzcb(intValue)) {
                        break;
                    }
                }
                ub = (UB) a(i, intValue, ub2, li);
                it.remove();
            }
        }
        return ub2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, int i2, UB ub, Li<UT, UB> li) {
        if (ub == null) {
            ub = li.a();
        }
        li.a((Li<UT, UB>) ub, i, i2);
        return ub;
    }
}

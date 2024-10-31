package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase_auth.oa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1267oa {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f13054a = d();

    /* renamed from: b, reason: collision with root package name */
    private static final Fa<?, ?> f13055b = a(false);

    /* renamed from: c, reason: collision with root package name */
    private static final Fa<?, ?> f13056c = a(true);

    /* renamed from: d, reason: collision with root package name */
    private static final Fa<?, ?> f13057d = new Ga();

    public static void a(Class<?> cls) {
        Class<?> cls2;
        if (!zzft.class.isAssignableFrom(cls) && (cls2 = f13054a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void b(int i, List<Float> list, Ra ra, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ra.n(i, list, z);
    }

    public static void c(int i, List<Long> list, Ra ra, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ra.b(i, list, z);
    }

    public static void d(int i, List<Long> list, Ra ra, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ra.l(i, list, z);
    }

    public static void e(int i, List<Long> list, Ra ra, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ra.d(i, list, z);
    }

    public static void f(int i, List<Long> list, Ra ra, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ra.k(i, list, z);
    }

    public static void g(int i, List<Long> list, Ra ra, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ra.h(i, list, z);
    }

    public static void h(int i, List<Integer> list, Ra ra, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ra.a(i, list, z);
    }

    public static void i(int i, List<Integer> list, Ra ra, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ra.i(i, list, z);
    }

    public static void j(int i, List<Integer> list, Ra ra, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ra.e(i, list, z);
    }

    public static void k(int i, List<Integer> list, Ra ra, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ra.c(i, list, z);
    }

    public static void l(int i, List<Integer> list, Ra ra, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ra.j(i, list, z);
    }

    public static void m(int i, List<Integer> list, Ra ra, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ra.g(i, list, z);
    }

    public static void n(int i, List<Boolean> list, Ra ra, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ra.f(i, list, z);
    }

    public static void b(int i, List<zzeh> list, Ra ra) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ra.a(i, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return f(list) + (size * zzfa.zzag(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof N) {
            N n = (N) list;
            i = 0;
            while (i2 < size) {
                i += zzfa.zze(n.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfa.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof N) {
            N n = (N) list;
            i = 0;
            while (i2 < size) {
                i += zzfa.zzf(n.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfa.zzf(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof N) {
            N n = (N) list;
            i = 0;
            while (i2 < size) {
                i += zzfa.zzg(n.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfa.zzg(list.get(i2).longValue());
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
        if (list instanceof F) {
            F f2 = (F) list;
            i = 0;
            while (i2 < size) {
                i += zzfa.zzam(f2.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfa.zzam(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof F) {
            F f2 = (F) list;
            i = 0;
            while (i2 < size) {
                i += zzfa.zzah(f2.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfa.zzah(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof F) {
            F f2 = (F) list;
            i = 0;
            while (i2 < size) {
                i += zzfa.zzai(f2.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfa.zzai(list.get(i2).intValue());
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
        if (list instanceof F) {
            F f2 = (F) list;
            i = 0;
            while (i2 < size) {
                i += zzfa.zzaj(f2.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfa.zzaj(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void a(int i, List<Double> list, Ra ra, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ra.m(i, list, z);
    }

    public static void b(int i, List<?> list, Ra ra, InterfaceC1263ma interfaceC1263ma) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ra.b(i, list, interfaceC1263ma);
    }

    public static void a(int i, List<String> list, Ra ra) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ra.b(i, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(List<?> list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return e(list) + (size * zzfa.zzag(i));
    }

    public static Fa<?, ?> c() {
        return f13057d;
    }

    public static void a(int i, List<?> list, Ra ra, InterfaceC1263ma interfaceC1263ma) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ra.a(i, list, interfaceC1263ma);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return g(list) + (size * zzfa.zzag(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return h(list) + (size * zzfa.zzag(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return i(list) + (size * zzfa.zzag(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return j(list) + (size * zzfa.zzag(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzfa.zzn(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzfa.zzg(i, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzfa.zzc(i, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return d(list) + (list.size() * zzfa.zzag(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List<?> list) {
        return list.size() << 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzeh> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzag = size * zzfa.zzag(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzag += zzfa.zzb(list.get(i2));
        }
        return zzag;
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
    public static int a(List<?> list) {
        return list.size() << 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list) {
        int zzdb;
        int zzdb2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zzag = zzfa.zzag(i) * size;
        if (list instanceof zzgl) {
            zzgl zzglVar = (zzgl) list;
            while (i2 < size) {
                Object zzat = zzglVar.zzat(i2);
                if (zzat instanceof zzeh) {
                    zzdb2 = zzfa.zzb((zzeh) zzat);
                } else {
                    zzdb2 = zzfa.zzdb((String) zzat);
                }
                zzag += zzdb2;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzeh) {
                    zzdb = zzfa.zzb((zzeh) obj);
                } else {
                    zzdb = zzfa.zzdb((String) obj);
                }
                zzag += zzdb;
                i2++;
            }
        }
        return zzag;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List<zzhc> list, InterfaceC1263ma interfaceC1263ma) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzfa.zzc(i, list.get(i3), interfaceC1263ma);
        }
        return i2;
    }

    public static Fa<?, ?> b() {
        return f13056c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, Object obj, InterfaceC1263ma interfaceC1263ma) {
        if (obj instanceof zzgj) {
            return zzfa.zza(i, (zzgj) obj);
        }
        return zzfa.zzb(i, (zzhc) obj, interfaceC1263ma);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List<?> list, InterfaceC1263ma interfaceC1263ma) {
        int zza;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzag = zzfa.zzag(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzgj) {
                zza = zzfa.zza((zzgj) obj);
            } else {
                zza = zzfa.zza((zzhc) obj, interfaceC1263ma);
            }
            zzag += zza;
        }
        return zzag;
    }

    public static Fa<?, ?> a() {
        return f13055b;
    }

    private static Fa<?, ?> a(boolean z) {
        try {
            Class<?> e2 = e();
            if (e2 == null) {
                return null;
            }
            return (Fa) e2.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
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
    public static <T> void a(T t, T t2, T t3, long j) {
        Ja.a(t2, j, t.a(Ja.f(t2, j), Ja.f(t3, j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzfm<FT>> void a(AbstractC1281w<FT> abstractC1281w, T t, T t2) {
        C1287z<FT> a2 = abstractC1281w.a(t2);
        if (a2.b()) {
            return;
        }
        abstractC1281w.b(t).a(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void a(Fa<UT, UB> fa, T t, T t2) {
        fa.a(t, fa.c(fa.d(t), fa.d(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, List<Integer> list, zzfy zzfyVar, UB ub, Fa<UT, UB> fa) {
        UB ub2;
        int intValue;
        if (zzfyVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue2 = list.get(i3).intValue();
                if (zzfyVar.zzc(intValue2)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue2));
                    }
                    i2++;
                } else {
                    ub2 = (UB) a(i, intValue2, ub2, fa);
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
                    if (!zzfyVar.zzc(intValue)) {
                        break;
                    }
                }
                ub = (UB) a(i, intValue, ub2, fa);
                it.remove();
            }
        }
        return ub2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i, int i2, UB ub, Fa<UT, UB> fa) {
        if (ub == null) {
            ub = fa.a();
        }
        fa.a((Fa<UT, UB>) ub, i, i2);
        return ub;
    }
}

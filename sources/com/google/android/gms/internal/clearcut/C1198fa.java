package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.clearcut.fa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1198fa<T> implements InterfaceC1218pa<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final Unsafe f12829a = La.d();

    /* renamed from: b, reason: collision with root package name */
    private final int[] f12830b;

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f12831c;

    /* renamed from: d, reason: collision with root package name */
    private final int f12832d;

    /* renamed from: e, reason: collision with root package name */
    private final int f12833e;

    /* renamed from: f, reason: collision with root package name */
    private final int f12834f;

    /* renamed from: g, reason: collision with root package name */
    private final zzdo f12835g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f12836h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final int[] l;
    private final int[] m;
    private final int[] n;
    private final InterfaceC1202ha o;
    private final O p;
    private final Ga<?, ?> q;
    private final B<?> r;
    private final Z s;

    private C1198fa(int[] iArr, Object[] objArr, int i, int i2, int i3, zzdo zzdoVar, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4, InterfaceC1202ha interfaceC1202ha, O o, Ga<?, ?> ga, B<?> b2, Z z3) {
        this.f12830b = iArr;
        this.f12831c = objArr;
        this.f12832d = i;
        this.f12833e = i2;
        this.f12834f = i3;
        this.i = zzdoVar instanceof zzcg;
        this.j = z;
        this.f12836h = b2 != null && b2.a(zzdoVar);
        this.k = false;
        this.l = iArr2;
        this.m = iArr3;
        this.n = iArr4;
        this.o = interfaceC1202ha;
        this.p = o;
        this.q = ga;
        this.r = b2;
        this.f12835g = zzdoVar;
        this.s = z3;
    }

    private static int a(int i, byte[] bArr, int i2, int i3, Object obj, C1215o c1215o) throws IOException {
        return C1213n.a(i, bArr, i2, i3, d(obj), c1215o);
    }

    private static <UT, UB> int a(Ga<UT, UB> ga, T t) {
        return ga.b(ga.c(t));
    }

    private static int a(InterfaceC1218pa<?> interfaceC1218pa, int i, byte[] bArr, int i2, int i3, zzcn<?> zzcnVar, C1215o c1215o) throws IOException {
        int a2 = a((InterfaceC1218pa) interfaceC1218pa, bArr, i2, i3, c1215o);
        while (true) {
            zzcnVar.add(c1215o.f12871c);
            if (a2 >= i3) {
                break;
            }
            int a3 = C1213n.a(bArr, a2, c1215o);
            if (i != c1215o.f12869a) {
                break;
            }
            a2 = a((InterfaceC1218pa) interfaceC1218pa, bArr, a3, i3, c1215o);
        }
        return a2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int a(InterfaceC1218pa interfaceC1218pa, byte[] bArr, int i, int i2, int i3, C1215o c1215o) throws IOException {
        C1198fa c1198fa = (C1198fa) interfaceC1218pa;
        Object newInstance = c1198fa.newInstance();
        int a2 = c1198fa.a((C1198fa) newInstance, bArr, i, i2, i3, c1215o);
        c1198fa.c((C1198fa) newInstance);
        c1215o.f12871c = newInstance;
        return a2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int a(InterfaceC1218pa interfaceC1218pa, byte[] bArr, int i, int i2, C1215o c1215o) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = C1213n.a(i4, bArr, i3, c1215o);
            i4 = c1215o.f12869a;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzco.zzbl();
        }
        Object newInstance = interfaceC1218pa.newInstance();
        int i6 = i4 + i5;
        interfaceC1218pa.a(newInstance, bArr, i5, i6, c1215o);
        interfaceC1218pa.c(newInstance);
        c1215o.f12871c = newInstance;
        return i6;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0023. Please report as an issue. */
    private final int a(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, C1215o c1215o) throws IOException {
        Object valueOf;
        Object valueOf2;
        int b2;
        long j2;
        int i9;
        Object valueOf3;
        int i10;
        Unsafe unsafe = f12829a;
        long j3 = this.f12830b[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    valueOf = Double.valueOf(C1213n.c(bArr, i));
                    unsafe.putObject(t, j, valueOf);
                    b2 = i + 8;
                    unsafe.putInt(t, j3, i4);
                    return b2;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    valueOf2 = Float.valueOf(C1213n.d(bArr, i));
                    unsafe.putObject(t, j, valueOf2);
                    b2 = i + 4;
                    unsafe.putInt(t, j3, i4);
                    return b2;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    b2 = C1213n.b(bArr, i, c1215o);
                    j2 = c1215o.f12870b;
                    valueOf3 = Long.valueOf(j2);
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b2;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    b2 = C1213n.a(bArr, i, c1215o);
                    i9 = c1215o.f12869a;
                    valueOf3 = Integer.valueOf(i9);
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b2;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    valueOf = Long.valueOf(C1213n.b(bArr, i));
                    unsafe.putObject(t, j, valueOf);
                    b2 = i + 8;
                    unsafe.putInt(t, j3, i4);
                    return b2;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    valueOf2 = Integer.valueOf(C1213n.a(bArr, i));
                    unsafe.putObject(t, j, valueOf2);
                    b2 = i + 4;
                    unsafe.putInt(t, j3, i4);
                    return b2;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    b2 = C1213n.b(bArr, i, c1215o);
                    valueOf3 = Boolean.valueOf(c1215o.f12870b != 0);
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b2;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    b2 = C1213n.a(bArr, i, c1215o);
                    i10 = c1215o.f12869a;
                    if (i10 == 0) {
                        valueOf3 = "";
                        unsafe.putObject(t, j, valueOf3);
                        unsafe.putInt(t, j3, i4);
                        return b2;
                    }
                    if ((i6 & 536870912) != 0 && !Na.a(bArr, b2, b2 + i10)) {
                        throw zzco.zzbp();
                    }
                    unsafe.putObject(t, j, new String(bArr, b2, i10, zzci.UTF_8));
                    b2 += i10;
                    unsafe.putInt(t, j3, i4);
                    return b2;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    b2 = a(a(i8), bArr, i, i2, c1215o);
                    Object object = unsafe.getInt(t, j3) == i4 ? unsafe.getObject(t, j) : null;
                    valueOf3 = object == null ? c1215o.f12871c : zzci.zza(object, c1215o.f12871c);
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b2;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    b2 = C1213n.a(bArr, i, c1215o);
                    i10 = c1215o.f12869a;
                    if (i10 == 0) {
                        valueOf3 = zzbb.zzfi;
                        unsafe.putObject(t, j, valueOf3);
                        unsafe.putInt(t, j3, i4);
                        return b2;
                    }
                    unsafe.putObject(t, j, zzbb.zzb(bArr, b2, i10));
                    b2 += i10;
                    unsafe.putInt(t, j3, i4);
                    return b2;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int a2 = C1213n.a(bArr, i, c1215o);
                    int i11 = c1215o.f12869a;
                    zzck<?> c2 = c(i8);
                    if (c2 != null && c2.zzb(i11) == null) {
                        d(t).zzb(i3, Long.valueOf(i11));
                        return a2;
                    }
                    unsafe.putObject(t, j, Integer.valueOf(i11));
                    b2 = a2;
                    unsafe.putInt(t, j3, i4);
                    return b2;
                }
                return i;
            case 66:
                if (i5 == 0) {
                    b2 = C1213n.a(bArr, i, c1215o);
                    i9 = zzbk.zzm(c1215o.f12869a);
                    valueOf3 = Integer.valueOf(i9);
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b2;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    b2 = C1213n.b(bArr, i, c1215o);
                    j2 = zzbk.zza(c1215o.f12870b);
                    valueOf3 = Long.valueOf(j2);
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b2;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    b2 = a(a(i8), bArr, i, i2, (i3 & (-8)) | 4, c1215o);
                    Object object2 = unsafe.getInt(t, j3) == i4 ? unsafe.getObject(t, j) : null;
                    valueOf3 = object2 == null ? c1215o.f12871c : zzci.zza(object2, c1215o.f12871c);
                    unsafe.putObject(t, j, valueOf3);
                    unsafe.putInt(t, j3, i4);
                    return b2;
                }
                return i;
            default:
                return i;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0236, code lost:            if (r30.f12870b != 0) goto L125;     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0238, code lost:            r6 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x023b, code lost:            r11.a(r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x023e, code lost:            if (r4 >= r20) goto L247;     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0240, code lost:            r6 = com.google.android.gms.internal.clearcut.C1213n.a(r18, r4, r30);     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0246, code lost:            if (r21 != r30.f12869a) goto L246;     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0248, code lost:            r4 = com.google.android.gms.internal.clearcut.C1213n.b(r18, r6, r30);     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0250, code lost:            if (r30.f12870b == 0) goto L126;     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x023a, code lost:            r6 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x023b, code lost:            r6 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x013a, code lost:            if (r4 == 0) goto L64;     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x013c, code lost:            r11.add(com.google.android.gms.internal.clearcut.zzbb.zzfi);     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x014a, code lost:            if (r1 >= r20) goto L230;     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x014c, code lost:            r4 = com.google.android.gms.internal.clearcut.C1213n.a(r18, r1, r30);     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0152, code lost:            if (r21 != r30.f12869a) goto L229;     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0154, code lost:            r1 = com.google.android.gms.internal.clearcut.C1213n.a(r18, r4, r30);        r4 = r30.f12869a;     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x015a, code lost:            if (r4 != 0) goto L65;     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0142, code lost:            r11.add(com.google.android.gms.internal.clearcut.zzbb.zzb(r18, r1, r4));        r1 = r1 + r4;     */
    /* JADX WARN: Code restructure failed: missing block: B:86:?, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:88:?, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x014a, code lost:            r11.add(com.google.android.gms.internal.clearcut.zzbb.zzb(r18, r1, r4));        r1 = r1 + r4;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x003a. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01d7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:123:0x0250 -> B:117:0x0238). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x015a -> B:60:0x013c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x01ab -> B:74:0x018c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x01e5 -> B:85:0x01be). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int a(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.clearcut.C1215o r30) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 998
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.C1198fa.a(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.clearcut.o):int");
    }

    private final <K, V> int a(T t, byte[] bArr, int i, int i2, int i3, int i4, long j, C1215o c1215o) throws IOException {
        Unsafe unsafe = f12829a;
        Object b2 = b(i3);
        Object object = unsafe.getObject(t, j);
        if (this.s.a(object)) {
            Object zzk = this.s.zzk(b2);
            this.s.a(zzk, object);
            unsafe.putObject(t, j, zzk);
        }
        this.s.zzl(b2);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x02fc, code lost:            if (r0 == r5) goto L129;     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0300, code lost:            r15 = r27;        r14 = r28;        r12 = r29;        r1 = r30;        r13 = r31;        r11 = r32;        r9 = r33;     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x035b, code lost:            r7 = r30;        r6 = r32;        r2 = r0;     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0359, code lost:            if (r0 == r15) goto L129;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:94:0x006c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0371 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int a(T r28, byte[] r29, int r30, int r31, int r32, com.google.android.gms.internal.clearcut.C1215o r33) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1078
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.C1198fa.a(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.clearcut.o):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x016b A[EDGE_INSN: B:50:0x016b->B:71:0x016b BREAK  A[LOOP:0: B:18:0x0066->B:27:0x0167], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> com.google.android.gms.internal.clearcut.C1198fa<T> a(java.lang.Class<T> r23, com.google.android.gms.internal.clearcut.InterfaceC1192ca r24, com.google.android.gms.internal.clearcut.InterfaceC1202ha r25, com.google.android.gms.internal.clearcut.O r26, com.google.android.gms.internal.clearcut.Ga<?, ?> r27, com.google.android.gms.internal.clearcut.B<?> r28, com.google.android.gms.internal.clearcut.Z r29) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.C1198fa.a(java.lang.Class, com.google.android.gms.internal.clearcut.ca, com.google.android.gms.internal.clearcut.ha, com.google.android.gms.internal.clearcut.O, com.google.android.gms.internal.clearcut.Ga, com.google.android.gms.internal.clearcut.B, com.google.android.gms.internal.clearcut.Z):com.google.android.gms.internal.clearcut.fa");
    }

    private final InterfaceC1218pa a(int i) {
        int i2 = (i / 4) << 1;
        InterfaceC1218pa interfaceC1218pa = (InterfaceC1218pa) this.f12831c[i2];
        if (interfaceC1218pa != null) {
            return interfaceC1218pa;
        }
        InterfaceC1218pa<T> a2 = C1208ka.a().a((Class) this.f12831c[i2 + 1]);
        this.f12831c[i2] = a2;
        return a2;
    }

    private final <K, V, UT, UB> UB a(int i, int i2, Map<K, V> map, zzck<?> zzckVar, UB ub, Ga<UT, UB> ga) {
        this.s.zzl(b(i));
        throw null;
    }

    private static <E> List<E> a(Object obj, long j) {
        return (List) La.f(obj, j);
    }

    private static void a(int i, Object obj, Sa sa) throws IOException {
        if (obj instanceof String) {
            sa.a(i, (String) obj);
        } else {
            sa.a(i, (zzbb) obj);
        }
    }

    private static <UT, UB> void a(Ga<UT, UB> ga, T t, Sa sa) throws IOException {
        ga.a((Ga<UT, UB>) ga.c(t), sa);
    }

    private final <K, V> void a(Sa sa, int i, Object obj, int i2) throws IOException {
        if (obj == null) {
            return;
        }
        this.s.zzl(b(i2));
        throw null;
    }

    private final void a(T t, T t2, int i) {
        long d2 = d(i) & 1048575;
        if (a((C1198fa<T>) t2, i)) {
            Object f2 = La.f(t, d2);
            Object f3 = La.f(t2, d2);
            if (f2 != null && f3 != null) {
                La.a(t, d2, zzci.zza(f2, f3));
                b((C1198fa<T>) t, i);
            } else if (f3 != null) {
                La.a(t, d2, f3);
                b((C1198fa<T>) t, i);
            }
        }
    }

    private final boolean a(T t, int i) {
        if (!this.j) {
            int e2 = e(i);
            return (La.a(t, (long) (e2 & 1048575)) & (1 << (e2 >>> 20))) != 0;
        }
        int d2 = d(i);
        long j = d2 & 1048575;
        switch ((d2 & 267386880) >>> 20) {
            case 0:
                return La.e(t, j) != 0.0d;
            case 1:
                return La.d(t, j) != 0.0f;
            case 2:
                return La.b(t, j) != 0;
            case 3:
                return La.b(t, j) != 0;
            case 4:
                return La.a(t, j) != 0;
            case 5:
                return La.b(t, j) != 0;
            case 6:
                return La.a(t, j) != 0;
            case 7:
                return La.c(t, j);
            case 8:
                Object f2 = La.f(t, j);
                if (f2 instanceof String) {
                    return !((String) f2).isEmpty();
                }
                if (f2 instanceof zzbb) {
                    return !zzbb.zzfi.equals(f2);
                }
                throw new IllegalArgumentException();
            case 9:
                return La.f(t, j) != null;
            case 10:
                return !zzbb.zzfi.equals(La.f(t, j));
            case 11:
                return La.a(t, j) != 0;
            case 12:
                return La.a(t, j) != 0;
            case 13:
                return La.a(t, j) != 0;
            case 14:
                return La.b(t, j) != 0;
            case 15:
                return La.a(t, j) != 0;
            case 16:
                return La.b(t, j) != 0;
            case 17:
                return La.f(t, j) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean a(T t, int i, int i2) {
        return La.a(t, (long) (e(i2) & 1048575)) == i;
    }

    private final boolean a(T t, int i, int i2, int i3) {
        return this.j ? a((C1198fa<T>) t, i) : (i2 & i3) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a(Object obj, int i, InterfaceC1218pa interfaceC1218pa) {
        return interfaceC1218pa.zzo(La.f(obj, i & 1048575));
    }

    private static <T> double b(T t, long j) {
        return ((Double) La.f(t, j)).doubleValue();
    }

    private final Object b(int i) {
        return this.f12831c[(i / 4) << 1];
    }

    private final void b(T t, int i) {
        if (this.j) {
            return;
        }
        int e2 = e(i);
        long j = e2 & 1048575;
        La.a((Object) t, j, La.a(t, j) | (1 << (e2 >>> 20)));
    }

    private final void b(T t, int i, int i2) {
        La.a((Object) t, e(i2) & 1048575, i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x0089. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void b(T r19, com.google.android.gms.internal.clearcut.Sa r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.C1198fa.b(java.lang.Object, com.google.android.gms.internal.clearcut.Sa):void");
    }

    private final void b(T t, T t2, int i) {
        int d2 = d(i);
        int i2 = this.f12830b[i];
        long j = d2 & 1048575;
        if (a((C1198fa<T>) t2, i2, i)) {
            Object f2 = La.f(t, j);
            Object f3 = La.f(t2, j);
            if (f2 != null && f3 != null) {
                La.a(t, j, zzci.zza(f2, f3));
                b((C1198fa<T>) t, i2, i);
            } else if (f3 != null) {
                La.a(t, j, f3);
                b((C1198fa<T>) t, i2, i);
            }
        }
    }

    private static <T> float c(T t, long j) {
        return ((Float) La.f(t, j)).floatValue();
    }

    private final zzck<?> c(int i) {
        return (zzck) this.f12831c[((i / 4) << 1) + 1];
    }

    private final boolean c(T t, T t2, int i) {
        return a((C1198fa<T>) t, i) == a((C1198fa<T>) t2, i);
    }

    private final int d(int i) {
        return this.f12830b[i + 1];
    }

    private static <T> int d(T t, long j) {
        return ((Integer) La.f(t, j)).intValue();
    }

    private static zzey d(Object obj) {
        zzcg zzcgVar = (zzcg) obj;
        zzey zzeyVar = zzcgVar.zzjp;
        if (zzeyVar != zzey.zzea()) {
            return zzeyVar;
        }
        zzey zzeb = zzey.zzeb();
        zzcgVar.zzjp = zzeb;
        return zzeb;
    }

    private final int e(int i) {
        return this.f12830b[i + 2];
    }

    private static <T> long e(T t, long j) {
        return ((Long) La.f(t, j)).longValue();
    }

    private final int f(int i) {
        int i2 = this.f12832d;
        if (i >= i2) {
            int i3 = this.f12834f;
            if (i < i3) {
                int i4 = (i - i2) << 2;
                if (this.f12830b[i4] == i) {
                    return i4;
                }
                return -1;
            }
            if (i <= this.f12833e) {
                int i5 = i3 - i2;
                int length = (this.f12830b.length / 4) - 1;
                while (i5 <= length) {
                    int i6 = (length + i5) >>> 1;
                    int i7 = i6 << 2;
                    int i8 = this.f12830b[i7];
                    if (i == i8) {
                        return i7;
                    }
                    if (i < i8) {
                        length = i6 - 1;
                    } else {
                        i5 = i6 + 1;
                    }
                }
            }
        }
        return -1;
    }

    private static <T> boolean f(T t, long j) {
        return ((Boolean) La.f(t, j)).booleanValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00ce, code lost:            if (r3 != null) goto L68;     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00e6, code lost:            r2 = (r2 * 53) + r7;     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00e2, code lost:            r7 = r3.hashCode();     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00e0, code lost:            if (r3 != null) goto L68;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001b. Please report as an issue. */
    @Override // com.google.android.gms.internal.clearcut.InterfaceC1218pa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(T r9) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.C1198fa.a(java.lang.Object):int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0063. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:306:0x0521. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:550:0x0977  */
    @Override // com.google.android.gms.internal.clearcut.InterfaceC1218pa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(T r14, com.google.android.gms.internal.clearcut.Sa r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2738
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.C1198fa.a(java.lang.Object, com.google.android.gms.internal.clearcut.Sa):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0164, code lost:            if (r0 == r15) goto L83;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x01a2, code lost:            r2 = r0;     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01a0, code lost:            if (r0 == r15) goto L83;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:50:0x0048. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v25, types: [int] */
    @Override // com.google.android.gms.internal.clearcut.InterfaceC1218pa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(T r23, byte[] r24, int r25, int r26, com.google.android.gms.internal.clearcut.C1215o r27) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 518
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.C1198fa.a(java.lang.Object, byte[], int, int, com.google.android.gms.internal.clearcut.o):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005c, code lost:            if (com.google.android.gms.internal.clearcut.C1221ra.a(com.google.android.gms.internal.clearcut.La.f(r10, r6), com.google.android.gms.internal.clearcut.La.f(r11, r6)) != false) goto L104;     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0070, code lost:            if (com.google.android.gms.internal.clearcut.La.b(r10, r6) == com.google.android.gms.internal.clearcut.La.b(r11, r6)) goto L104;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0082, code lost:            if (com.google.android.gms.internal.clearcut.La.a(r10, r6) == com.google.android.gms.internal.clearcut.La.a(r11, r6)) goto L104;     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0096, code lost:            if (com.google.android.gms.internal.clearcut.La.b(r10, r6) == com.google.android.gms.internal.clearcut.La.b(r11, r6)) goto L104;     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a8, code lost:            if (com.google.android.gms.internal.clearcut.La.a(r10, r6) == com.google.android.gms.internal.clearcut.La.a(r11, r6)) goto L104;     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ba, code lost:            if (com.google.android.gms.internal.clearcut.La.a(r10, r6) == com.google.android.gms.internal.clearcut.La.a(r11, r6)) goto L104;     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cc, code lost:            if (com.google.android.gms.internal.clearcut.La.a(r10, r6) == com.google.android.gms.internal.clearcut.La.a(r11, r6)) goto L104;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e2, code lost:            if (com.google.android.gms.internal.clearcut.C1221ra.a(com.google.android.gms.internal.clearcut.La.f(r10, r6), com.google.android.gms.internal.clearcut.La.f(r11, r6)) != false) goto L104;     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f8, code lost:            if (com.google.android.gms.internal.clearcut.C1221ra.a(com.google.android.gms.internal.clearcut.La.f(r10, r6), com.google.android.gms.internal.clearcut.La.f(r11, r6)) != false) goto L104;     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x010e, code lost:            if (com.google.android.gms.internal.clearcut.C1221ra.a(com.google.android.gms.internal.clearcut.La.f(r10, r6), com.google.android.gms.internal.clearcut.La.f(r11, r6)) != false) goto L104;     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0120, code lost:            if (com.google.android.gms.internal.clearcut.La.c(r10, r6) == com.google.android.gms.internal.clearcut.La.c(r11, r6)) goto L104;     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0132, code lost:            if (com.google.android.gms.internal.clearcut.La.a(r10, r6) == com.google.android.gms.internal.clearcut.La.a(r11, r6)) goto L104;     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0145, code lost:            if (com.google.android.gms.internal.clearcut.La.b(r10, r6) == com.google.android.gms.internal.clearcut.La.b(r11, r6)) goto L104;     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0156, code lost:            if (com.google.android.gms.internal.clearcut.La.a(r10, r6) == com.google.android.gms.internal.clearcut.La.a(r11, r6)) goto L104;     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0169, code lost:            if (com.google.android.gms.internal.clearcut.La.b(r10, r6) == com.google.android.gms.internal.clearcut.La.b(r11, r6)) goto L104;     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x017c, code lost:            if (com.google.android.gms.internal.clearcut.La.b(r10, r6) == com.google.android.gms.internal.clearcut.La.b(r11, r6)) goto L104;     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x018d, code lost:            if (com.google.android.gms.internal.clearcut.La.a(r10, r6) == com.google.android.gms.internal.clearcut.La.a(r11, r6)) goto L104;     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01a0, code lost:            if (com.google.android.gms.internal.clearcut.La.b(r10, r6) == com.google.android.gms.internal.clearcut.La.b(r11, r6)) goto L104;     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:            if (com.google.android.gms.internal.clearcut.C1221ra.a(com.google.android.gms.internal.clearcut.La.f(r10, r6), com.google.android.gms.internal.clearcut.La.f(r11, r6)) != false) goto L104;     */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a6 A[LOOP:0: B:2:0x0005->B:85:0x01a6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01a5 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.clearcut.InterfaceC1218pa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 610
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.C1198fa.a(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0127, code lost:            if (r19.k != false) goto L142;     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0211, code lost:            r3 = (com.google.android.gms.internal.clearcut.zzbn.zzr(r3) + com.google.android.gms.internal.clearcut.zzbn.zzt(r5)) + r5;     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x020d, code lost:            r2.putInt(r20, r14, r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0139, code lost:            if (r19.k != false) goto L142;     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x014b, code lost:            if (r19.k != false) goto L142;     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x015d, code lost:            if (r19.k != false) goto L142;     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x016f, code lost:            if (r19.k != false) goto L142;     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0181, code lost:            if (r19.k != false) goto L142;     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0193, code lost:            if (r19.k != false) goto L142;     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x01a5, code lost:            if (r19.k != false) goto L142;     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x01b6, code lost:            if (r19.k != false) goto L142;     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x01c7, code lost:            if (r19.k != false) goto L142;     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x01d8, code lost:            if (r19.k != false) goto L142;     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x01e9, code lost:            if (r19.k != false) goto L142;     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x01fa, code lost:            if (r19.k != false) goto L142;     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x020b, code lost:            if (r19.k != false) goto L142;     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0331, code lost:            if ((r5 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L186;     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0417, code lost:            if (a((com.google.android.gms.internal.clearcut.C1198fa<T>) r20, r15, r3) != false) goto L395;     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x06b9, code lost:            r4 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, (com.google.android.gms.internal.clearcut.zzdo) r2.getObject(r20, r9), a(r3));     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x0437, code lost:            if (a((com.google.android.gms.internal.clearcut.C1198fa<T>) r20, r15, r3) != false) goto L406;     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x06e6, code lost:            r4 = com.google.android.gms.internal.clearcut.zzbn.zzh(r15, 0L);     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x043f, code lost:            if (a((com.google.android.gms.internal.clearcut.C1198fa<T>) r20, r15, r3) != false) goto L409;     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x06f1, code lost:            r9 = com.google.android.gms.internal.clearcut.zzbn.zzk(r15, 0);     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x045f, code lost:            if (a((com.google.android.gms.internal.clearcut.C1198fa<T>) r20, r15, r3) != false) goto L421;     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x0716, code lost:            r4 = r2.getObject(r20, r9);     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x071a, code lost:            r4 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, (com.google.android.gms.internal.clearcut.zzbb) r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x0467, code lost:            if (a((com.google.android.gms.internal.clearcut.C1198fa<T>) r20, r15, r3) != false) goto L425;     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x0725, code lost:            r4 = com.google.android.gms.internal.clearcut.C1221ra.a(r15, r2.getObject(r20, r9), a(r3));     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x0477, code lost:            if ((r4 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L422;     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x0740, code lost:            r4 = com.google.android.gms.internal.clearcut.zzbn.zzb(r15, (java.lang.String) r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x047f, code lost:            if (a((com.google.android.gms.internal.clearcut.C1198fa<T>) r20, r15, r3) != false) goto L434;     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x074c, code lost:            r4 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, true);     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x0517, code lost:            if (r19.k != false) goto L375;     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x0601, code lost:            r9 = (com.google.android.gms.internal.clearcut.zzbn.zzr(r15) + com.google.android.gms.internal.clearcut.zzbn.zzt(r4)) + r4;     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x05fd, code lost:            r2.putInt(r20, r11, r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x0529, code lost:            if (r19.k != false) goto L375;     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x053b, code lost:            if (r19.k != false) goto L375;     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x054d, code lost:            if (r19.k != false) goto L375;     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x055f, code lost:            if (r19.k != false) goto L375;     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x0571, code lost:            if (r19.k != false) goto L375;     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x0583, code lost:            if (r19.k != false) goto L375;     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x0595, code lost:            if (r19.k != false) goto L375;     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x05a6, code lost:            if (r19.k != false) goto L375;     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x05b7, code lost:            if (r19.k != false) goto L375;     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x05c8, code lost:            if (r19.k != false) goto L375;     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x05d9, code lost:            if (r19.k != false) goto L375;     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x05ea, code lost:            if (r19.k != false) goto L375;     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x05fb, code lost:            if (r19.k != false) goto L375;     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x06b7, code lost:            if ((r12 & r18) != 0) goto L395;     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x06e4, code lost:            if ((r12 & r18) != 0) goto L406;     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x06ef, code lost:            if ((r12 & r18) != 0) goto L409;     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x0714, code lost:            if ((r12 & r18) != 0) goto L421;     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x0723, code lost:            if ((r12 & r18) != 0) goto L425;     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x073d, code lost:            if ((r4 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L422;     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x074a, code lost:            if ((r12 & r18) != 0) goto L434;     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ab, code lost:            if ((r5 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L186;     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0334, code lost:            r3 = com.google.android.gms.internal.clearcut.zzbn.zzb(r3, (java.lang.String) r5);     */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0042. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:263:0x040e. Please report as an issue. */
    @Override // com.google.android.gms.internal.clearcut.InterfaceC1218pa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b(T r20) {
        /*
            Method dump skipped, instructions count: 2296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.C1198fa.b(java.lang.Object):int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x001a. Please report as an issue. */
    @Override // com.google.android.gms.internal.clearcut.InterfaceC1218pa
    public final void b(T t, T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.f12830b.length; i += 4) {
            int d2 = d(i);
            long j = 1048575 & d2;
            int i2 = this.f12830b[i];
            switch ((d2 & 267386880) >>> 20) {
                case 0:
                    if (a((C1198fa<T>) t2, i)) {
                        La.a(t, j, La.e(t2, j));
                        b((C1198fa<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (a((C1198fa<T>) t2, i)) {
                        La.a((Object) t, j, La.d(t2, j));
                        b((C1198fa<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (!a((C1198fa<T>) t2, i)) {
                        break;
                    }
                    La.a((Object) t, j, La.b(t2, j));
                    b((C1198fa<T>) t, i);
                    break;
                case 3:
                    if (!a((C1198fa<T>) t2, i)) {
                        break;
                    }
                    La.a((Object) t, j, La.b(t2, j));
                    b((C1198fa<T>) t, i);
                    break;
                case 4:
                    if (!a((C1198fa<T>) t2, i)) {
                        break;
                    }
                    La.a((Object) t, j, La.a(t2, j));
                    b((C1198fa<T>) t, i);
                    break;
                case 5:
                    if (!a((C1198fa<T>) t2, i)) {
                        break;
                    }
                    La.a((Object) t, j, La.b(t2, j));
                    b((C1198fa<T>) t, i);
                    break;
                case 6:
                    if (!a((C1198fa<T>) t2, i)) {
                        break;
                    }
                    La.a((Object) t, j, La.a(t2, j));
                    b((C1198fa<T>) t, i);
                    break;
                case 7:
                    if (a((C1198fa<T>) t2, i)) {
                        La.a(t, j, La.c(t2, j));
                        b((C1198fa<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!a((C1198fa<T>) t2, i)) {
                        break;
                    }
                    La.a(t, j, La.f(t2, j));
                    b((C1198fa<T>) t, i);
                    break;
                case 9:
                case 17:
                    a(t, t2, i);
                    break;
                case 10:
                    if (!a((C1198fa<T>) t2, i)) {
                        break;
                    }
                    La.a(t, j, La.f(t2, j));
                    b((C1198fa<T>) t, i);
                    break;
                case 11:
                    if (!a((C1198fa<T>) t2, i)) {
                        break;
                    }
                    La.a((Object) t, j, La.a(t2, j));
                    b((C1198fa<T>) t, i);
                    break;
                case 12:
                    if (!a((C1198fa<T>) t2, i)) {
                        break;
                    }
                    La.a((Object) t, j, La.a(t2, j));
                    b((C1198fa<T>) t, i);
                    break;
                case 13:
                    if (!a((C1198fa<T>) t2, i)) {
                        break;
                    }
                    La.a((Object) t, j, La.a(t2, j));
                    b((C1198fa<T>) t, i);
                    break;
                case 14:
                    if (!a((C1198fa<T>) t2, i)) {
                        break;
                    }
                    La.a((Object) t, j, La.b(t2, j));
                    b((C1198fa<T>) t, i);
                    break;
                case 15:
                    if (!a((C1198fa<T>) t2, i)) {
                        break;
                    }
                    La.a((Object) t, j, La.a(t2, j));
                    b((C1198fa<T>) t, i);
                    break;
                case 16:
                    if (!a((C1198fa<T>) t2, i)) {
                        break;
                    }
                    La.a((Object) t, j, La.b(t2, j));
                    b((C1198fa<T>) t, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.p.a(t, t2, j);
                    break;
                case 50:
                    C1221ra.a(this.s, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!a((C1198fa<T>) t2, i2, i)) {
                        break;
                    }
                    La.a(t, j, La.f(t2, j));
                    b((C1198fa<T>) t, i2, i);
                    break;
                case 60:
                case 68:
                    b(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!a((C1198fa<T>) t2, i2, i)) {
                        break;
                    }
                    La.a(t, j, La.f(t2, j));
                    b((C1198fa<T>) t, i2, i);
                    break;
            }
        }
        if (this.j) {
            return;
        }
        C1221ra.a(this.q, t, t2);
        if (this.f12836h) {
            C1221ra.a(this.r, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC1218pa
    public final void c(T t) {
        int[] iArr = this.m;
        if (iArr != null) {
            for (int i : iArr) {
                long d2 = d(i) & 1048575;
                Object f2 = La.f(t, d2);
                if (f2 != null) {
                    this.s.zzj(f2);
                    La.a(t, d2, f2);
                }
            }
        }
        int[] iArr2 = this.n;
        if (iArr2 != null) {
            for (int i2 : iArr2) {
                this.p.a(t, i2);
            }
        }
        this.q.a(t);
        if (this.f12836h) {
            this.r.c(t);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC1218pa
    public final T newInstance() {
        return (T) this.o.a(this.f12835g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.clearcut.InterfaceC1218pa
    public final boolean zzo(T t) {
        int i;
        int i2;
        boolean z;
        int[] iArr = this.l;
        int i3 = 1;
        if (iArr == null || iArr.length == 0) {
            return true;
        }
        int length = iArr.length;
        int i4 = 0;
        int i5 = -1;
        int i6 = 0;
        while (i4 < length) {
            int i7 = iArr[i4];
            int f2 = f(i7);
            int d2 = d(f2);
            if (this.j) {
                i = i4;
                i2 = 0;
            } else {
                int i8 = this.f12830b[f2 + 2];
                int i9 = i8 & 1048575;
                i2 = i3 << (i8 >>> 20);
                if (i9 != i5) {
                    i = i4;
                    i6 = f12829a.getInt(t, i9);
                    i5 = i9;
                } else {
                    i = i4;
                }
            }
            if (((268435456 & d2) != 0) && !a((C1198fa<T>) t, f2, i6, i2)) {
                return false;
            }
            int i10 = (267386880 & d2) >>> 20;
            if (i10 != 9 && i10 != 17) {
                if (i10 != 27) {
                    if (i10 == 60 || i10 == 68) {
                        if (a((C1198fa<T>) t, i7, f2) && !a(t, d2, a(f2))) {
                            return false;
                        }
                    } else if (i10 != 49) {
                        if (i10 == 50 && !this.s.zzh(La.f(t, d2 & 1048575)).isEmpty()) {
                            this.s.zzl(b(f2));
                            throw null;
                        }
                    }
                }
                List list = (List) La.f(t, d2 & 1048575);
                if (!list.isEmpty()) {
                    InterfaceC1218pa a2 = a(f2);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!a2.zzo(list.get(i11))) {
                            z = false;
                            break;
                        }
                    }
                }
                z = true;
                if (!z) {
                    return false;
                }
            } else if (a((C1198fa<T>) t, f2, i6, i2) && !a(t, d2, a(f2))) {
                return false;
            }
            i4 = i + 1;
            i3 = 1;
        }
        return !this.f12836h || this.r.a(t).d();
    }
}

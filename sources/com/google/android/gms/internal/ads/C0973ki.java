package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.ads.ki, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0973ki<T> implements InterfaceC1112ui<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f12261a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    private static final Unsafe f12262b = Pi.d();

    /* renamed from: c, reason: collision with root package name */
    private final int[] f12263c;

    /* renamed from: d, reason: collision with root package name */
    private final Object[] f12264d;

    /* renamed from: e, reason: collision with root package name */
    private final int f12265e;

    /* renamed from: f, reason: collision with root package name */
    private final int f12266f;

    /* renamed from: g, reason: collision with root package name */
    private final zzbsl f12267g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f12268h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final int[] l;
    private final int m;
    private final int n;
    private final InterfaceC1001mi o;
    private final Wh p;
    private final Li<?, ?> q;
    private final Jh<?> r;
    private final InterfaceC0890ei s;

    private C0973ki(int[] iArr, Object[] objArr, int i, int i2, zzbsl zzbslVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, InterfaceC1001mi interfaceC1001mi, Wh wh, Li<?, ?> li, Jh<?> jh, InterfaceC0890ei interfaceC0890ei) {
        this.f12263c = iArr;
        this.f12264d = objArr;
        this.f12265e = i;
        this.f12266f = i2;
        this.i = zzbslVar instanceof zzbrd;
        this.j = z;
        this.f12268h = jh != null && jh.a(zzbslVar);
        this.k = false;
        this.l = iArr2;
        this.m = i3;
        this.n = i4;
        this.o = interfaceC1001mi;
        this.p = wh;
        this.q = li;
        this.r = jh;
        this.f12267g = zzbslVar;
        this.s = interfaceC0890ei;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> C0973ki<T> a(Class<T> cls, InterfaceC0932hi interfaceC0932hi, InterfaceC1001mi interfaceC1001mi, Wh wh, Li<?, ?> li, Jh<?> jh, InterfaceC0890ei interfaceC0890ei) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        char charAt;
        int i6;
        int charAt2;
        int charAt3;
        int i7;
        int[] iArr;
        int i8;
        char c2;
        char c3;
        int i9;
        char charAt4;
        int i10;
        char charAt5;
        int i11;
        char charAt6;
        int i12;
        char charAt7;
        char charAt8;
        char charAt9;
        char charAt10;
        char charAt11;
        int i13;
        int i14;
        int i15;
        char c4;
        char c5;
        int i16;
        int objectFieldOffset;
        String str;
        Class<?> cls2;
        int i17;
        int i18;
        int i19;
        Field a2;
        int i20;
        char charAt12;
        int i21;
        int i22;
        int i23;
        Field a3;
        Field a4;
        int i24;
        char charAt13;
        int i25;
        char charAt14;
        int i26;
        char charAt15;
        char charAt16;
        char charAt17;
        if (interfaceC0932hi instanceof C1084si) {
            C1084si c1084si = (C1084si) interfaceC0932hi;
            int i27 = 0;
            boolean z = c1084si.c() == zzbrd.zze.zzfqk;
            String d2 = c1084si.d();
            int length = d2.length();
            int charAt18 = d2.charAt(0);
            if (charAt18 >= 55296) {
                int i28 = charAt18 & 8191;
                int i29 = 1;
                int i30 = 13;
                while (true) {
                    i = i29 + 1;
                    charAt17 = d2.charAt(i29);
                    if (charAt17 < 55296) {
                        break;
                    }
                    i28 |= (charAt17 & 8191) << i30;
                    i30 += 13;
                    i29 = i;
                }
                charAt18 = (charAt17 << i30) | i28;
            } else {
                i = 1;
            }
            int i31 = i + 1;
            int charAt19 = d2.charAt(i);
            if (charAt19 >= 55296) {
                int i32 = charAt19 & 8191;
                int i33 = 13;
                while (true) {
                    i2 = i31 + 1;
                    charAt16 = d2.charAt(i31);
                    if (charAt16 < 55296) {
                        break;
                    }
                    i32 |= (charAt16 & 8191) << i33;
                    i33 += 13;
                    i31 = i2;
                }
                charAt19 = i32 | (charAt16 << i33);
            } else {
                i2 = i31;
            }
            if (charAt19 == 0) {
                iArr = f12261a;
                charAt3 = 0;
                c3 = 0;
                i8 = 0;
                charAt = 0;
                charAt2 = 0;
                c2 = 0;
            } else {
                int i34 = i2 + 1;
                char charAt20 = d2.charAt(i2);
                if (charAt20 >= 55296) {
                    int i35 = charAt20 & 8191;
                    int i36 = 13;
                    while (true) {
                        i3 = i34 + 1;
                        charAt11 = d2.charAt(i34);
                        if (charAt11 < 55296) {
                            break;
                        }
                        i35 |= (charAt11 & 8191) << i36;
                        i36 += 13;
                        i34 = i3;
                    }
                    charAt20 = ((charAt11 << i36) | i35) == true ? 1 : 0;
                } else {
                    i3 = i34;
                }
                int i37 = i3 + 1;
                int charAt21 = d2.charAt(i3);
                if (charAt21 >= 55296) {
                    int i38 = charAt21 & 8191;
                    int i39 = 13;
                    while (true) {
                        i4 = i37 + 1;
                        charAt10 = d2.charAt(i37);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i38 |= (charAt10 & 8191) << i39;
                        i39 += 13;
                        i37 = i4;
                    }
                    charAt21 = i38 | (charAt10 << i39);
                } else {
                    i4 = i37;
                }
                int i40 = i4 + 1;
                char charAt22 = d2.charAt(i4);
                if (charAt22 >= 55296) {
                    int i41 = charAt22 & 8191;
                    int i42 = 13;
                    while (true) {
                        i5 = i40 + 1;
                        charAt9 = d2.charAt(i40);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i41 |= (charAt9 & 8191) << i42;
                        i42 += 13;
                        i40 = i5;
                    }
                    charAt22 = ((charAt9 << i42) | i41) == true ? 1 : 0;
                } else {
                    i5 = i40;
                }
                int i43 = i5 + 1;
                charAt = d2.charAt(i5);
                if (charAt >= 55296) {
                    int i44 = charAt & 8191;
                    int i45 = 13;
                    while (true) {
                        i6 = i43 + 1;
                        charAt8 = d2.charAt(i43);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i44 |= (charAt8 & 8191) << i45;
                        i45 += 13;
                        i43 = i6;
                    }
                    charAt = ((charAt8 << i45) | i44) == true ? 1 : 0;
                } else {
                    i6 = i43;
                }
                int i46 = i6 + 1;
                charAt2 = d2.charAt(i6);
                if (charAt2 >= 55296) {
                    int i47 = charAt2 & 8191;
                    int i48 = 13;
                    while (true) {
                        i12 = i46 + 1;
                        charAt7 = d2.charAt(i46);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i47 |= (charAt7 & 8191) << i48;
                        i48 += 13;
                        i46 = i12;
                    }
                    charAt2 = (charAt7 << i48) | i47;
                    i46 = i12;
                }
                int i49 = i46 + 1;
                charAt3 = d2.charAt(i46);
                if (charAt3 >= 55296) {
                    int i50 = charAt3 & 8191;
                    int i51 = 13;
                    while (true) {
                        i11 = i49 + 1;
                        charAt6 = d2.charAt(i49);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i50 |= (charAt6 & 8191) << i51;
                        i51 += 13;
                        i49 = i11;
                    }
                    charAt3 = i50 | (charAt6 << i51);
                    i49 = i11;
                }
                int i52 = i49 + 1;
                int charAt23 = d2.charAt(i49);
                if (charAt23 >= 55296) {
                    int i53 = 13;
                    int i54 = charAt23 & 8191;
                    int i55 = i52;
                    while (true) {
                        i10 = i55 + 1;
                        charAt5 = d2.charAt(i55);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i54 |= (charAt5 & 8191) << i53;
                        i53 += 13;
                        i55 = i10;
                    }
                    charAt23 = i54 | (charAt5 << i53);
                    i7 = i10;
                } else {
                    i7 = i52;
                }
                int i56 = i7 + 1;
                i27 = d2.charAt(i7);
                if (i27 >= 55296) {
                    int i57 = 13;
                    int i58 = i27 & 8191;
                    int i59 = i56;
                    while (true) {
                        i9 = i59 + 1;
                        charAt4 = d2.charAt(i59);
                        if (charAt4 < 55296) {
                            break;
                        }
                        i58 |= (charAt4 & 8191) << i57;
                        i57 += 13;
                        i59 = i9;
                    }
                    i27 = i58 | (charAt4 << i57);
                    i56 = i9;
                }
                iArr = new int[i27 + charAt3 + charAt23];
                i8 = (charAt20 << 1) + charAt21;
                int i60 = i56;
                c2 = charAt20;
                c3 = charAt22;
                i2 = i60;
            }
            Unsafe unsafe = f12262b;
            Object[] e2 = c1084si.e();
            Class<?> cls3 = c1084si.b().getClass();
            int i61 = i8;
            int[] iArr2 = new int[charAt2 * 3];
            Object[] objArr = new Object[charAt2 << 1];
            int i62 = i27 + charAt3;
            int i63 = i27;
            int i64 = i61;
            int i65 = i62;
            int i66 = 0;
            int i67 = 0;
            while (i2 < length) {
                int i68 = i2 + 1;
                int charAt24 = d2.charAt(i2);
                char c6 = 55296;
                if (charAt24 >= 55296) {
                    int i69 = 13;
                    int i70 = charAt24 & 8191;
                    int i71 = i68;
                    while (true) {
                        i26 = i71 + 1;
                        charAt15 = d2.charAt(i71);
                        if (charAt15 < c6) {
                            break;
                        }
                        i70 |= (charAt15 & 8191) << i69;
                        i69 += 13;
                        i71 = i26;
                        c6 = 55296;
                    }
                    charAt24 = i70 | (charAt15 << i69);
                    i13 = i26;
                } else {
                    i13 = i68;
                }
                int i72 = i13 + 1;
                int charAt25 = d2.charAt(i13);
                int i73 = length;
                char c7 = 55296;
                if (charAt25 >= 55296) {
                    int i74 = 13;
                    int i75 = charAt25 & 8191;
                    int i76 = i72;
                    while (true) {
                        i25 = i76 + 1;
                        charAt14 = d2.charAt(i76);
                        if (charAt14 < c7) {
                            break;
                        }
                        i75 |= (charAt14 & 8191) << i74;
                        i74 += 13;
                        i76 = i25;
                        c7 = 55296;
                    }
                    charAt25 = i75 | (charAt14 << i74);
                    i14 = i25;
                } else {
                    i14 = i72;
                }
                int i77 = i27;
                int i78 = charAt25 & 255;
                boolean z2 = z;
                if ((charAt25 & 1024) != 0) {
                    iArr[i66] = i67;
                    i66++;
                }
                if (i78 > zzbqx.MAP.id()) {
                    int i79 = i14 + 1;
                    int charAt26 = d2.charAt(i14);
                    i15 = i66;
                    char c8 = 55296;
                    if (charAt26 >= 55296) {
                        int i80 = charAt26 & 8191;
                        int i81 = 13;
                        while (true) {
                            i24 = i79 + 1;
                            charAt13 = d2.charAt(i79);
                            if (charAt13 < c8) {
                                break;
                            }
                            i80 |= (charAt13 & 8191) << i81;
                            i81 += 13;
                            i79 = i24;
                            c8 = 55296;
                        }
                        charAt26 = i80 | (charAt13 << i81);
                        i79 = i24;
                    }
                    if (i78 != zzbqx.MESSAGE.id() + 51 && i78 != zzbqx.GROUP.id() + 51) {
                        if (i78 == zzbqx.ENUM.id() + 51) {
                            i22 = i79;
                            if ((charAt18 & 1) == 1) {
                                objArr[((i67 / 3) << 1) + 1] = e2[i64];
                                i64++;
                            }
                        } else {
                            i22 = i79;
                        }
                        i23 = 1;
                    } else {
                        i22 = i79;
                        i23 = 1;
                        objArr[((i67 / 3) << 1) + 1] = e2[i64];
                        i64++;
                    }
                    int i82 = charAt26 << i23;
                    Object obj = e2[i82];
                    if (obj instanceof Field) {
                        a3 = (Field) obj;
                    } else {
                        a3 = a(cls3, (String) obj);
                        e2[i82] = a3;
                    }
                    char c9 = c3;
                    int objectFieldOffset2 = (int) unsafe.objectFieldOffset(a3);
                    int i83 = i82 + 1;
                    Object obj2 = e2[i83];
                    if (obj2 instanceof Field) {
                        a4 = (Field) obj2;
                    } else {
                        a4 = a(cls3, (String) obj2);
                        e2[i83] = a4;
                    }
                    str = d2;
                    i19 = (int) unsafe.objectFieldOffset(a4);
                    cls2 = cls3;
                    i17 = i64;
                    objectFieldOffset = objectFieldOffset2;
                    i18 = 0;
                    c5 = c9;
                    char c10 = charAt;
                    i16 = charAt24;
                    i2 = i22;
                    c4 = c10;
                } else {
                    i15 = i66;
                    char c11 = c3;
                    int i84 = i64 + 1;
                    Field a5 = a(cls3, (String) e2[i64]);
                    c4 = charAt;
                    if (i78 != zzbqx.MESSAGE.id() && i78 != zzbqx.GROUP.id()) {
                        if (i78 != zzbqx.MESSAGE_LIST.id() && i78 != zzbqx.GROUP_LIST.id()) {
                            if (i78 == zzbqx.ENUM.id() || i78 == zzbqx.ENUM_LIST.id() || i78 == zzbqx.ENUM_LIST_PACKED.id()) {
                                c5 = c11;
                                if ((charAt18 & 1) == 1) {
                                    i21 = i84 + 1;
                                    objArr[((i67 / 3) << 1) + 1] = e2[i84];
                                }
                            } else if (i78 == zzbqx.MAP.id()) {
                                int i85 = i63 + 1;
                                iArr[i63] = i67;
                                int i86 = (i67 / 3) << 1;
                                int i87 = i84 + 1;
                                objArr[i86] = e2[i84];
                                if ((charAt25 & 2048) != 0) {
                                    i84 = i87 + 1;
                                    objArr[i86 + 1] = e2[i87];
                                    c5 = c11;
                                } else {
                                    c5 = c11;
                                    i84 = i87;
                                }
                                i63 = i85;
                            } else {
                                c5 = c11;
                            }
                        } else {
                            c5 = c11;
                            i21 = i84 + 1;
                            objArr[((i67 / 3) << 1) + 1] = e2[i84];
                        }
                        i16 = charAt24;
                        i84 = i21;
                        objectFieldOffset = (int) unsafe.objectFieldOffset(a5);
                        if ((charAt18 & 1) == 1 || i78 > zzbqx.GROUP.id()) {
                            str = d2;
                            cls2 = cls3;
                            i17 = i84;
                            i2 = i14;
                            i18 = 0;
                            i19 = 0;
                        } else {
                            int i88 = i14 + 1;
                            int charAt27 = d2.charAt(i14);
                            if (charAt27 >= 55296) {
                                int i89 = charAt27 & 8191;
                                int i90 = 13;
                                while (true) {
                                    i20 = i88 + 1;
                                    charAt12 = d2.charAt(i88);
                                    if (charAt12 < 55296) {
                                        break;
                                    }
                                    i89 |= (charAt12 & 8191) << i90;
                                    i90 += 13;
                                    i88 = i20;
                                }
                                charAt27 = i89 | (charAt12 << i90);
                                i88 = i20;
                            }
                            int i91 = (c2 << 1) + (charAt27 / 32);
                            Object obj3 = e2[i91];
                            str = d2;
                            if (obj3 instanceof Field) {
                                a2 = (Field) obj3;
                            } else {
                                a2 = a(cls3, (String) obj3);
                                e2[i91] = a2;
                            }
                            cls2 = cls3;
                            i17 = i84;
                            i19 = (int) unsafe.objectFieldOffset(a2);
                            i18 = charAt27 % 32;
                            i2 = i88;
                        }
                    } else {
                        c5 = c11;
                        objArr[((i67 / 3) << 1) + 1] = a5.getType();
                    }
                    i16 = charAt24;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(a5);
                    if ((charAt18 & 1) == 1) {
                    }
                    str = d2;
                    cls2 = cls3;
                    i17 = i84;
                    i2 = i14;
                    i18 = 0;
                    i19 = 0;
                }
                if (i78 >= 18 && i78 <= 49) {
                    iArr[i65] = objectFieldOffset;
                    i65++;
                }
                int i92 = i67 + 1;
                iArr2[i67] = i16;
                int i93 = i92 + 1;
                iArr2[i92] = (i78 << 20) | ((charAt25 & 256) != 0 ? 268435456 : 0) | ((charAt25 & 512) != 0 ? 536870912 : 0) | objectFieldOffset;
                i67 = i93 + 1;
                iArr2[i93] = (i18 << 20) | i19;
                cls3 = cls2;
                c3 = c5;
                i27 = i77;
                i64 = i17;
                length = i73;
                z = z2;
                i66 = i15;
                charAt = c4;
                d2 = str;
            }
            return new C0973ki<>(iArr2, objArr, c3, charAt, c1084si.b(), z, false, iArr, i27, i62, interfaceC1001mi, wh, li, jh, interfaceC0890ei);
        }
        ((Hi) interfaceC0932hi).c();
        throw null;
    }

    private static zzbtv e(Object obj) {
        zzbrd zzbrdVar = (zzbrd) obj;
        zzbtv zzbtvVar = zzbrdVar.zzfpu;
        if (zzbtvVar != zzbtv.zzaoz()) {
            return zzbtvVar;
        }
        zzbtv zzapa = zzbtv.zzapa();
        zzbrdVar.zzfpu = zzapa;
        return zzapa;
    }

    private static boolean f(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> boolean f(T t, long j) {
        return ((Boolean) Pi.f(t, j)).booleanValue();
    }

    private final int g(int i) {
        if (i < this.f12265e || i > this.f12266f) {
            return -1;
        }
        return b(i, 0);
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1112ui
    public final void b(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.f12263c.length; i += 3) {
                int d2 = d(i);
                long j = 1048575 & d2;
                int i2 = this.f12263c[i];
                switch ((d2 & 267386880) >>> 20) {
                    case 0:
                        if (a((C0973ki<T>) t2, i)) {
                            Pi.a(t, j, Pi.e(t2, j));
                            b((C0973ki<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (a((C0973ki<T>) t2, i)) {
                            Pi.a((Object) t, j, Pi.d(t2, j));
                            b((C0973ki<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (a((C0973ki<T>) t2, i)) {
                            Pi.a((Object) t, j, Pi.b(t2, j));
                            b((C0973ki<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (a((C0973ki<T>) t2, i)) {
                            Pi.a((Object) t, j, Pi.b(t2, j));
                            b((C0973ki<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (a((C0973ki<T>) t2, i)) {
                            Pi.a((Object) t, j, Pi.a(t2, j));
                            b((C0973ki<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (a((C0973ki<T>) t2, i)) {
                            Pi.a((Object) t, j, Pi.b(t2, j));
                            b((C0973ki<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (a((C0973ki<T>) t2, i)) {
                            Pi.a((Object) t, j, Pi.a(t2, j));
                            b((C0973ki<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (a((C0973ki<T>) t2, i)) {
                            Pi.a(t, j, Pi.c(t2, j));
                            b((C0973ki<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (a((C0973ki<T>) t2, i)) {
                            Pi.a(t, j, Pi.f(t2, j));
                            b((C0973ki<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        a(t, t2, i);
                        break;
                    case 10:
                        if (a((C0973ki<T>) t2, i)) {
                            Pi.a(t, j, Pi.f(t2, j));
                            b((C0973ki<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (a((C0973ki<T>) t2, i)) {
                            Pi.a((Object) t, j, Pi.a(t2, j));
                            b((C0973ki<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (a((C0973ki<T>) t2, i)) {
                            Pi.a((Object) t, j, Pi.a(t2, j));
                            b((C0973ki<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (a((C0973ki<T>) t2, i)) {
                            Pi.a((Object) t, j, Pi.a(t2, j));
                            b((C0973ki<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (a((C0973ki<T>) t2, i)) {
                            Pi.a((Object) t, j, Pi.b(t2, j));
                            b((C0973ki<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (a((C0973ki<T>) t2, i)) {
                            Pi.a((Object) t, j, Pi.a(t2, j));
                            b((C0973ki<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (a((C0973ki<T>) t2, i)) {
                            Pi.a((Object) t, j, Pi.b(t2, j));
                            b((C0973ki<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        a(t, t2, i);
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
                        C1140wi.a(this.s, t, t2, j);
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
                        if (a((C0973ki<T>) t2, i2, i)) {
                            Pi.a(t, j, Pi.f(t2, j));
                            b((C0973ki<T>) t, i2, i);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        b(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (a((C0973ki<T>) t2, i2, i)) {
                            Pi.a(t, j, Pi.f(t2, j));
                            b((C0973ki<T>) t, i2, i);
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        b(t, t2, i);
                        break;
                }
            }
            if (this.j) {
                return;
            }
            C1140wi.a(this.q, t, t2);
            if (this.f12268h) {
                C1140wi.a(this.r, t, t2);
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0042. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:299:0x0548. Please report as an issue. */
    @Override // com.google.android.gms.internal.ads.InterfaceC1112ui
    public final int c(T t) {
        int i;
        int i2;
        long j;
        int zzm;
        int zzk;
        int zzad;
        int i3;
        int zzfd;
        int zzff;
        int zzc;
        int i4;
        int zzfd2;
        int zzff2;
        int i5 = 267386880;
        if (this.j) {
            Unsafe unsafe = f12262b;
            int i6 = 0;
            int i7 = 0;
            while (i6 < this.f12263c.length) {
                int d2 = d(i6);
                int i8 = (d2 & i5) >>> 20;
                int i9 = this.f12263c[i6];
                long j2 = d2 & 1048575;
                int i10 = (i8 < zzbqx.DOUBLE_LIST_PACKED.id() || i8 > zzbqx.SINT64_LIST_PACKED.id()) ? 0 : this.f12263c[i6 + 2] & 1048575;
                switch (i8) {
                    case 0:
                        if (a((C0973ki<T>) t, i6)) {
                            zzc = zzbqk.zzc(i9, 0.0d);
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (a((C0973ki<T>) t, i6)) {
                            zzc = zzbqk.zzb(i9, 0.0f);
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (a((C0973ki<T>) t, i6)) {
                            zzc = zzbqk.zzm(i9, Pi.b(t, j2));
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (a((C0973ki<T>) t, i6)) {
                            zzc = zzbqk.zzn(i9, Pi.b(t, j2));
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (a((C0973ki<T>) t, i6)) {
                            zzc = zzbqk.zzz(i9, Pi.a(t, j2));
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (a((C0973ki<T>) t, i6)) {
                            zzc = zzbqk.zzp(i9, 0L);
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (a((C0973ki<T>) t, i6)) {
                            zzc = zzbqk.zzac(i9, 0);
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (a((C0973ki<T>) t, i6)) {
                            zzc = zzbqk.zzk(i9, true);
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (a((C0973ki<T>) t, i6)) {
                            Object f2 = Pi.f(t, j2);
                            if (f2 instanceof zzbpu) {
                                zzc = zzbqk.zzc(i9, (zzbpu) f2);
                            } else {
                                zzc = zzbqk.zzg(i9, (String) f2);
                            }
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (a((C0973ki<T>) t, i6)) {
                            zzc = C1140wi.a(i9, Pi.f(t, j2), a(i6));
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (a((C0973ki<T>) t, i6)) {
                            zzc = zzbqk.zzc(i9, (zzbpu) Pi.f(t, j2));
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (a((C0973ki<T>) t, i6)) {
                            zzc = zzbqk.zzaa(i9, Pi.a(t, j2));
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (a((C0973ki<T>) t, i6)) {
                            zzc = zzbqk.zzae(i9, Pi.a(t, j2));
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (a((C0973ki<T>) t, i6)) {
                            zzc = zzbqk.zzad(i9, 0);
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (a((C0973ki<T>) t, i6)) {
                            zzc = zzbqk.zzq(i9, 0L);
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (a((C0973ki<T>) t, i6)) {
                            zzc = zzbqk.zzab(i9, Pi.a(t, j2));
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (a((C0973ki<T>) t, i6)) {
                            zzc = zzbqk.zzo(i9, Pi.b(t, j2));
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (a((C0973ki<T>) t, i6)) {
                            zzc = zzbqk.zzc(i9, (zzbsl) Pi.f(t, j2), a(i6));
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzc = C1140wi.i(i9, a(t, j2), false);
                        i7 += zzc;
                        break;
                    case 19:
                        zzc = C1140wi.h(i9, a(t, j2), false);
                        i7 += zzc;
                        break;
                    case 20:
                        zzc = C1140wi.a(i9, (List<Long>) a(t, j2), false);
                        i7 += zzc;
                        break;
                    case 21:
                        zzc = C1140wi.b(i9, (List<Long>) a(t, j2), false);
                        i7 += zzc;
                        break;
                    case 22:
                        zzc = C1140wi.e(i9, a(t, j2), false);
                        i7 += zzc;
                        break;
                    case 23:
                        zzc = C1140wi.i(i9, a(t, j2), false);
                        i7 += zzc;
                        break;
                    case 24:
                        zzc = C1140wi.h(i9, a(t, j2), false);
                        i7 += zzc;
                        break;
                    case 25:
                        zzc = C1140wi.j(i9, a(t, j2), false);
                        i7 += zzc;
                        break;
                    case 26:
                        zzc = C1140wi.a(i9, (List<?>) a(t, j2));
                        i7 += zzc;
                        break;
                    case 27:
                        zzc = C1140wi.a(i9, (List<?>) a(t, j2), a(i6));
                        i7 += zzc;
                        break;
                    case 28:
                        zzc = C1140wi.b(i9, a(t, j2));
                        i7 += zzc;
                        break;
                    case 29:
                        zzc = C1140wi.f(i9, a(t, j2), false);
                        i7 += zzc;
                        break;
                    case 30:
                        zzc = C1140wi.d(i9, a(t, j2), false);
                        i7 += zzc;
                        break;
                    case 31:
                        zzc = C1140wi.h(i9, a(t, j2), false);
                        i7 += zzc;
                        break;
                    case 32:
                        zzc = C1140wi.i(i9, a(t, j2), false);
                        i7 += zzc;
                        break;
                    case 33:
                        zzc = C1140wi.g(i9, a(t, j2), false);
                        i7 += zzc;
                        break;
                    case 34:
                        zzc = C1140wi.c(i9, a(t, j2), false);
                        i7 += zzc;
                        break;
                    case 35:
                        i4 = C1140wi.i((List) unsafe.getObject(t, j2));
                        if (i4 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, i4);
                            }
                            zzfd2 = zzbqk.zzfd(i9);
                            zzff2 = zzbqk.zzff(i4);
                            zzc = zzfd2 + zzff2 + i4;
                            i7 += zzc;
                            break;
                        }
                    case 36:
                        i4 = C1140wi.h((List) unsafe.getObject(t, j2));
                        if (i4 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, i4);
                            }
                            zzfd2 = zzbqk.zzfd(i9);
                            zzff2 = zzbqk.zzff(i4);
                            zzc = zzfd2 + zzff2 + i4;
                            i7 += zzc;
                            break;
                        }
                    case 37:
                        i4 = C1140wi.a((List<Long>) unsafe.getObject(t, j2));
                        if (i4 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, i4);
                            }
                            zzfd2 = zzbqk.zzfd(i9);
                            zzff2 = zzbqk.zzff(i4);
                            zzc = zzfd2 + zzff2 + i4;
                            i7 += zzc;
                            break;
                        }
                    case 38:
                        i4 = C1140wi.b((List) unsafe.getObject(t, j2));
                        if (i4 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, i4);
                            }
                            zzfd2 = zzbqk.zzfd(i9);
                            zzff2 = zzbqk.zzff(i4);
                            zzc = zzfd2 + zzff2 + i4;
                            i7 += zzc;
                            break;
                        }
                    case 39:
                        i4 = C1140wi.e((List) unsafe.getObject(t, j2));
                        if (i4 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, i4);
                            }
                            zzfd2 = zzbqk.zzfd(i9);
                            zzff2 = zzbqk.zzff(i4);
                            zzc = zzfd2 + zzff2 + i4;
                            i7 += zzc;
                            break;
                        }
                    case 40:
                        i4 = C1140wi.i((List) unsafe.getObject(t, j2));
                        if (i4 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, i4);
                            }
                            zzfd2 = zzbqk.zzfd(i9);
                            zzff2 = zzbqk.zzff(i4);
                            zzc = zzfd2 + zzff2 + i4;
                            i7 += zzc;
                            break;
                        }
                    case 41:
                        i4 = C1140wi.h((List) unsafe.getObject(t, j2));
                        if (i4 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, i4);
                            }
                            zzfd2 = zzbqk.zzfd(i9);
                            zzff2 = zzbqk.zzff(i4);
                            zzc = zzfd2 + zzff2 + i4;
                            i7 += zzc;
                            break;
                        }
                    case 42:
                        i4 = C1140wi.j((List) unsafe.getObject(t, j2));
                        if (i4 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, i4);
                            }
                            zzfd2 = zzbqk.zzfd(i9);
                            zzff2 = zzbqk.zzff(i4);
                            zzc = zzfd2 + zzff2 + i4;
                            i7 += zzc;
                            break;
                        }
                    case 43:
                        i4 = C1140wi.f((List) unsafe.getObject(t, j2));
                        if (i4 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, i4);
                            }
                            zzfd2 = zzbqk.zzfd(i9);
                            zzff2 = zzbqk.zzff(i4);
                            zzc = zzfd2 + zzff2 + i4;
                            i7 += zzc;
                            break;
                        }
                    case 44:
                        i4 = C1140wi.d((List) unsafe.getObject(t, j2));
                        if (i4 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, i4);
                            }
                            zzfd2 = zzbqk.zzfd(i9);
                            zzff2 = zzbqk.zzff(i4);
                            zzc = zzfd2 + zzff2 + i4;
                            i7 += zzc;
                            break;
                        }
                    case 45:
                        i4 = C1140wi.h((List) unsafe.getObject(t, j2));
                        if (i4 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, i4);
                            }
                            zzfd2 = zzbqk.zzfd(i9);
                            zzff2 = zzbqk.zzff(i4);
                            zzc = zzfd2 + zzff2 + i4;
                            i7 += zzc;
                            break;
                        }
                    case 46:
                        i4 = C1140wi.i((List) unsafe.getObject(t, j2));
                        if (i4 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, i4);
                            }
                            zzfd2 = zzbqk.zzfd(i9);
                            zzff2 = zzbqk.zzff(i4);
                            zzc = zzfd2 + zzff2 + i4;
                            i7 += zzc;
                            break;
                        }
                    case 47:
                        i4 = C1140wi.g((List) unsafe.getObject(t, j2));
                        if (i4 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, i4);
                            }
                            zzfd2 = zzbqk.zzfd(i9);
                            zzff2 = zzbqk.zzff(i4);
                            zzc = zzfd2 + zzff2 + i4;
                            i7 += zzc;
                            break;
                        }
                    case 48:
                        i4 = C1140wi.c((List) unsafe.getObject(t, j2));
                        if (i4 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i10, i4);
                            }
                            zzfd2 = zzbqk.zzfd(i9);
                            zzff2 = zzbqk.zzff(i4);
                            zzc = zzfd2 + zzff2 + i4;
                            i7 += zzc;
                            break;
                        }
                    case 49:
                        zzc = C1140wi.b(i9, (List<zzbsl>) a(t, j2), a(i6));
                        i7 += zzc;
                        break;
                    case 50:
                        zzc = this.s.a(i9, Pi.f(t, j2), b(i6));
                        i7 += zzc;
                        break;
                    case 51:
                        if (a((C0973ki<T>) t, i9, i6)) {
                            zzc = zzbqk.zzc(i9, 0.0d);
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (a((C0973ki<T>) t, i9, i6)) {
                            zzc = zzbqk.zzb(i9, 0.0f);
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (a((C0973ki<T>) t, i9, i6)) {
                            zzc = zzbqk.zzm(i9, e(t, j2));
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (a((C0973ki<T>) t, i9, i6)) {
                            zzc = zzbqk.zzn(i9, e(t, j2));
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (a((C0973ki<T>) t, i9, i6)) {
                            zzc = zzbqk.zzz(i9, d(t, j2));
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (a((C0973ki<T>) t, i9, i6)) {
                            zzc = zzbqk.zzp(i9, 0L);
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (a((C0973ki<T>) t, i9, i6)) {
                            zzc = zzbqk.zzac(i9, 0);
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (a((C0973ki<T>) t, i9, i6)) {
                            zzc = zzbqk.zzk(i9, true);
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (a((C0973ki<T>) t, i9, i6)) {
                            Object f3 = Pi.f(t, j2);
                            if (f3 instanceof zzbpu) {
                                zzc = zzbqk.zzc(i9, (zzbpu) f3);
                            } else {
                                zzc = zzbqk.zzg(i9, (String) f3);
                            }
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (a((C0973ki<T>) t, i9, i6)) {
                            zzc = C1140wi.a(i9, Pi.f(t, j2), a(i6));
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (a((C0973ki<T>) t, i9, i6)) {
                            zzc = zzbqk.zzc(i9, (zzbpu) Pi.f(t, j2));
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (a((C0973ki<T>) t, i9, i6)) {
                            zzc = zzbqk.zzaa(i9, d(t, j2));
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (a((C0973ki<T>) t, i9, i6)) {
                            zzc = zzbqk.zzae(i9, d(t, j2));
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (a((C0973ki<T>) t, i9, i6)) {
                            zzc = zzbqk.zzad(i9, 0);
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (a((C0973ki<T>) t, i9, i6)) {
                            zzc = zzbqk.zzq(i9, 0L);
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (a((C0973ki<T>) t, i9, i6)) {
                            zzc = zzbqk.zzab(i9, d(t, j2));
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (a((C0973ki<T>) t, i9, i6)) {
                            zzc = zzbqk.zzo(i9, e(t, j2));
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (a((C0973ki<T>) t, i9, i6)) {
                            zzc = zzbqk.zzc(i9, (zzbsl) Pi.f(t, j2), a(i6));
                            i7 += zzc;
                            break;
                        } else {
                            break;
                        }
                }
                i6 += 3;
                i5 = 267386880;
            }
            return i7 + a((Li) this.q, (Object) t);
        }
        Unsafe unsafe2 = f12262b;
        int i11 = 0;
        int i12 = -1;
        int i13 = 0;
        for (int i14 = 0; i14 < this.f12263c.length; i14 += 3) {
            int d3 = d(i14);
            int[] iArr = this.f12263c;
            int i15 = iArr[i14];
            int i16 = (d3 & 267386880) >>> 20;
            if (i16 <= 17) {
                i = iArr[i14 + 2];
                int i17 = i & 1048575;
                i2 = 1 << (i >>> 20);
                if (i17 != i12) {
                    i13 = unsafe2.getInt(t, i17);
                } else {
                    i17 = i12;
                }
                i12 = i17;
            } else {
                i = (!this.k || i16 < zzbqx.DOUBLE_LIST_PACKED.id() || i16 > zzbqx.SINT64_LIST_PACKED.id()) ? 0 : this.f12263c[i14 + 2] & 1048575;
                i2 = 0;
            }
            long j3 = d3 & 1048575;
            switch (i16) {
                case 0:
                    j = 0;
                    if ((i13 & i2) != 0) {
                        i11 += zzbqk.zzc(i15, 0.0d);
                        break;
                    }
                    break;
                case 1:
                    j = 0;
                    if ((i13 & i2) != 0) {
                        i11 += zzbqk.zzb(i15, 0.0f);
                        break;
                    }
                case 2:
                    j = 0;
                    if ((i13 & i2) != 0) {
                        zzm = zzbqk.zzm(i15, unsafe2.getLong(t, j3));
                        i11 += zzm;
                    }
                    break;
                case 3:
                    j = 0;
                    if ((i13 & i2) != 0) {
                        zzm = zzbqk.zzn(i15, unsafe2.getLong(t, j3));
                        i11 += zzm;
                    }
                    break;
                case 4:
                    j = 0;
                    if ((i13 & i2) != 0) {
                        zzm = zzbqk.zzz(i15, unsafe2.getInt(t, j3));
                        i11 += zzm;
                    }
                    break;
                case 5:
                    if ((i13 & i2) != 0) {
                        j = 0;
                        zzm = zzbqk.zzp(i15, 0L);
                        i11 += zzm;
                        break;
                    } else {
                        j = 0;
                    }
                case 6:
                    if ((i13 & i2) != 0) {
                        i11 += zzbqk.zzac(i15, 0);
                        j = 0;
                        break;
                    }
                    j = 0;
                case 7:
                    if ((i13 & i2) != 0) {
                        zzk = zzbqk.zzk(i15, true);
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 8:
                    if ((i13 & i2) != 0) {
                        Object object = unsafe2.getObject(t, j3);
                        if (object instanceof zzbpu) {
                            zzk = zzbqk.zzc(i15, (zzbpu) object);
                        } else {
                            zzk = zzbqk.zzg(i15, (String) object);
                        }
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 9:
                    if ((i13 & i2) != 0) {
                        zzk = C1140wi.a(i15, unsafe2.getObject(t, j3), a(i14));
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 10:
                    if ((i13 & i2) != 0) {
                        zzk = zzbqk.zzc(i15, (zzbpu) unsafe2.getObject(t, j3));
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 11:
                    if ((i13 & i2) != 0) {
                        zzk = zzbqk.zzaa(i15, unsafe2.getInt(t, j3));
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 12:
                    if ((i13 & i2) != 0) {
                        zzk = zzbqk.zzae(i15, unsafe2.getInt(t, j3));
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 13:
                    if ((i13 & i2) != 0) {
                        zzad = zzbqk.zzad(i15, 0);
                        i11 += zzad;
                    }
                    j = 0;
                    break;
                case 14:
                    if ((i13 & i2) != 0) {
                        zzk = zzbqk.zzq(i15, 0L);
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 15:
                    if ((i13 & i2) != 0) {
                        zzk = zzbqk.zzab(i15, unsafe2.getInt(t, j3));
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 16:
                    if ((i13 & i2) != 0) {
                        zzk = zzbqk.zzo(i15, unsafe2.getLong(t, j3));
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 17:
                    if ((i13 & i2) != 0) {
                        zzk = zzbqk.zzc(i15, (zzbsl) unsafe2.getObject(t, j3), a(i14));
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 18:
                    zzk = C1140wi.i(i15, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzk;
                    j = 0;
                    break;
                case 19:
                    zzk = C1140wi.h(i15, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzk;
                    j = 0;
                    break;
                case 20:
                    zzk = C1140wi.a(i15, (List<Long>) unsafe2.getObject(t, j3), false);
                    i11 += zzk;
                    j = 0;
                    break;
                case 21:
                    zzk = C1140wi.b(i15, (List<Long>) unsafe2.getObject(t, j3), false);
                    i11 += zzk;
                    j = 0;
                    break;
                case 22:
                    zzk = C1140wi.e(i15, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzk;
                    j = 0;
                    break;
                case 23:
                    zzk = C1140wi.i(i15, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzk;
                    j = 0;
                    break;
                case 24:
                    zzk = C1140wi.h(i15, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzk;
                    j = 0;
                    break;
                case 25:
                    zzk = C1140wi.j(i15, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzk;
                    j = 0;
                    break;
                case 26:
                    zzk = C1140wi.a(i15, (List<?>) unsafe2.getObject(t, j3));
                    i11 += zzk;
                    j = 0;
                    break;
                case 27:
                    zzk = C1140wi.a(i15, (List<?>) unsafe2.getObject(t, j3), a(i14));
                    i11 += zzk;
                    j = 0;
                    break;
                case 28:
                    zzk = C1140wi.b(i15, (List) unsafe2.getObject(t, j3));
                    i11 += zzk;
                    j = 0;
                    break;
                case 29:
                    zzk = C1140wi.f(i15, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzk;
                    j = 0;
                    break;
                case 30:
                    zzk = C1140wi.d(i15, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzk;
                    j = 0;
                    break;
                case 31:
                    zzk = C1140wi.h(i15, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzk;
                    j = 0;
                    break;
                case 32:
                    zzk = C1140wi.i(i15, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzk;
                    j = 0;
                    break;
                case 33:
                    zzk = C1140wi.g(i15, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzk;
                    j = 0;
                    break;
                case 34:
                    zzk = C1140wi.c(i15, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzk;
                    j = 0;
                    break;
                case 35:
                    i3 = C1140wi.i((List) unsafe2.getObject(t, j3));
                    if (i3 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i3);
                        }
                        zzfd = zzbqk.zzfd(i15);
                        zzff = zzbqk.zzff(i3);
                        zzad = zzfd + zzff + i3;
                        i11 += zzad;
                    }
                    j = 0;
                    break;
                case 36:
                    i3 = C1140wi.h((List) unsafe2.getObject(t, j3));
                    if (i3 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i3);
                        }
                        zzfd = zzbqk.zzfd(i15);
                        zzff = zzbqk.zzff(i3);
                        zzad = zzfd + zzff + i3;
                        i11 += zzad;
                    }
                    j = 0;
                    break;
                case 37:
                    i3 = C1140wi.a((List<Long>) unsafe2.getObject(t, j3));
                    if (i3 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i3);
                        }
                        zzfd = zzbqk.zzfd(i15);
                        zzff = zzbqk.zzff(i3);
                        zzad = zzfd + zzff + i3;
                        i11 += zzad;
                    }
                    j = 0;
                    break;
                case 38:
                    i3 = C1140wi.b((List) unsafe2.getObject(t, j3));
                    if (i3 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i3);
                        }
                        zzfd = zzbqk.zzfd(i15);
                        zzff = zzbqk.zzff(i3);
                        zzad = zzfd + zzff + i3;
                        i11 += zzad;
                    }
                    j = 0;
                    break;
                case 39:
                    i3 = C1140wi.e((List) unsafe2.getObject(t, j3));
                    if (i3 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i3);
                        }
                        zzfd = zzbqk.zzfd(i15);
                        zzff = zzbqk.zzff(i3);
                        zzad = zzfd + zzff + i3;
                        i11 += zzad;
                    }
                    j = 0;
                    break;
                case 40:
                    i3 = C1140wi.i((List) unsafe2.getObject(t, j3));
                    if (i3 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i3);
                        }
                        zzfd = zzbqk.zzfd(i15);
                        zzff = zzbqk.zzff(i3);
                        zzad = zzfd + zzff + i3;
                        i11 += zzad;
                    }
                    j = 0;
                    break;
                case 41:
                    i3 = C1140wi.h((List) unsafe2.getObject(t, j3));
                    if (i3 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i3);
                        }
                        zzfd = zzbqk.zzfd(i15);
                        zzff = zzbqk.zzff(i3);
                        zzad = zzfd + zzff + i3;
                        i11 += zzad;
                    }
                    j = 0;
                    break;
                case 42:
                    i3 = C1140wi.j((List) unsafe2.getObject(t, j3));
                    if (i3 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i3);
                        }
                        zzfd = zzbqk.zzfd(i15);
                        zzff = zzbqk.zzff(i3);
                        zzad = zzfd + zzff + i3;
                        i11 += zzad;
                    }
                    j = 0;
                    break;
                case 43:
                    i3 = C1140wi.f((List) unsafe2.getObject(t, j3));
                    if (i3 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i3);
                        }
                        zzfd = zzbqk.zzfd(i15);
                        zzff = zzbqk.zzff(i3);
                        zzad = zzfd + zzff + i3;
                        i11 += zzad;
                    }
                    j = 0;
                    break;
                case 44:
                    i3 = C1140wi.d((List) unsafe2.getObject(t, j3));
                    if (i3 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i3);
                        }
                        zzfd = zzbqk.zzfd(i15);
                        zzff = zzbqk.zzff(i3);
                        zzad = zzfd + zzff + i3;
                        i11 += zzad;
                    }
                    j = 0;
                    break;
                case 45:
                    i3 = C1140wi.h((List) unsafe2.getObject(t, j3));
                    if (i3 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i3);
                        }
                        zzfd = zzbqk.zzfd(i15);
                        zzff = zzbqk.zzff(i3);
                        zzad = zzfd + zzff + i3;
                        i11 += zzad;
                    }
                    j = 0;
                    break;
                case 46:
                    i3 = C1140wi.i((List) unsafe2.getObject(t, j3));
                    if (i3 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i3);
                        }
                        zzfd = zzbqk.zzfd(i15);
                        zzff = zzbqk.zzff(i3);
                        zzad = zzfd + zzff + i3;
                        i11 += zzad;
                    }
                    j = 0;
                    break;
                case 47:
                    i3 = C1140wi.g((List) unsafe2.getObject(t, j3));
                    if (i3 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i3);
                        }
                        zzfd = zzbqk.zzfd(i15);
                        zzff = zzbqk.zzff(i3);
                        zzad = zzfd + zzff + i3;
                        i11 += zzad;
                    }
                    j = 0;
                    break;
                case 48:
                    i3 = C1140wi.c((List) unsafe2.getObject(t, j3));
                    if (i3 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, i3);
                        }
                        zzfd = zzbqk.zzfd(i15);
                        zzff = zzbqk.zzff(i3);
                        zzad = zzfd + zzff + i3;
                        i11 += zzad;
                    }
                    j = 0;
                    break;
                case 49:
                    zzk = C1140wi.b(i15, (List<zzbsl>) unsafe2.getObject(t, j3), a(i14));
                    i11 += zzk;
                    j = 0;
                    break;
                case 50:
                    zzk = this.s.a(i15, unsafe2.getObject(t, j3), b(i14));
                    i11 += zzk;
                    j = 0;
                    break;
                case 51:
                    if (a((C0973ki<T>) t, i15, i14)) {
                        zzk = zzbqk.zzc(i15, 0.0d);
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 52:
                    if (a((C0973ki<T>) t, i15, i14)) {
                        zzad = zzbqk.zzb(i15, 0.0f);
                        i11 += zzad;
                    }
                    j = 0;
                    break;
                case 53:
                    if (a((C0973ki<T>) t, i15, i14)) {
                        zzk = zzbqk.zzm(i15, e(t, j3));
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 54:
                    if (a((C0973ki<T>) t, i15, i14)) {
                        zzk = zzbqk.zzn(i15, e(t, j3));
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 55:
                    if (a((C0973ki<T>) t, i15, i14)) {
                        zzk = zzbqk.zzz(i15, d(t, j3));
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 56:
                    if (a((C0973ki<T>) t, i15, i14)) {
                        zzk = zzbqk.zzp(i15, 0L);
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 57:
                    if (a((C0973ki<T>) t, i15, i14)) {
                        zzad = zzbqk.zzac(i15, 0);
                        i11 += zzad;
                    }
                    j = 0;
                    break;
                case 58:
                    if (a((C0973ki<T>) t, i15, i14)) {
                        zzk = zzbqk.zzk(i15, true);
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 59:
                    if (a((C0973ki<T>) t, i15, i14)) {
                        Object object2 = unsafe2.getObject(t, j3);
                        if (object2 instanceof zzbpu) {
                            zzk = zzbqk.zzc(i15, (zzbpu) object2);
                        } else {
                            zzk = zzbqk.zzg(i15, (String) object2);
                        }
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 60:
                    if (a((C0973ki<T>) t, i15, i14)) {
                        zzk = C1140wi.a(i15, unsafe2.getObject(t, j3), a(i14));
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 61:
                    if (a((C0973ki<T>) t, i15, i14)) {
                        zzk = zzbqk.zzc(i15, (zzbpu) unsafe2.getObject(t, j3));
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 62:
                    if (a((C0973ki<T>) t, i15, i14)) {
                        zzk = zzbqk.zzaa(i15, d(t, j3));
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 63:
                    if (a((C0973ki<T>) t, i15, i14)) {
                        zzk = zzbqk.zzae(i15, d(t, j3));
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 64:
                    if (a((C0973ki<T>) t, i15, i14)) {
                        zzad = zzbqk.zzad(i15, 0);
                        i11 += zzad;
                    }
                    j = 0;
                    break;
                case 65:
                    if (a((C0973ki<T>) t, i15, i14)) {
                        zzk = zzbqk.zzq(i15, 0L);
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 66:
                    if (a((C0973ki<T>) t, i15, i14)) {
                        zzk = zzbqk.zzab(i15, d(t, j3));
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 67:
                    if (a((C0973ki<T>) t, i15, i14)) {
                        zzk = zzbqk.zzo(i15, e(t, j3));
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                case 68:
                    if (a((C0973ki<T>) t, i15, i14)) {
                        zzk = zzbqk.zzc(i15, (zzbsl) unsafe2.getObject(t, j3), a(i14));
                        i11 += zzk;
                    }
                    j = 0;
                    break;
                default:
                    j = 0;
                    break;
            }
        }
        int a2 = i11 + a((Li) this.q, (Object) t);
        return this.f12268h ? a2 + this.r.a(t).h() : a2;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1112ui
    public final void d(T t) {
        int i;
        int i2 = this.m;
        while (true) {
            i = this.n;
            if (i2 >= i) {
                break;
            }
            long d2 = d(this.l[i2]) & 1048575;
            Object f2 = Pi.f(t, d2);
            if (f2 != null) {
                this.s.f(f2);
                Pi.a(t, d2, f2);
            }
            i2++;
        }
        int length = this.l.length;
        while (i < length) {
            this.p.b(t, this.l[i]);
            i++;
        }
        this.q.e(t);
        if (this.f12268h) {
            this.r.c(t);
        }
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1112ui
    public final T newInstance() {
        return (T) this.o.a(this.f12267g);
    }

    private final int e(int i) {
        return this.f12263c[i + 2];
    }

    private static <T> long e(T t, long j) {
        return ((Long) Pi.f(t, j)).longValue();
    }

    private final int d(int i) {
        return this.f12263c[i + 1];
    }

    private static <T> int d(T t, long j) {
        return ((Integer) Pi.f(t, j)).intValue();
    }

    private final void b(T t, T t2, int i) {
        int d2 = d(i);
        int i2 = this.f12263c[i];
        long j = d2 & 1048575;
        if (a((C0973ki<T>) t2, i2, i)) {
            Object f2 = Pi.f(t, j);
            Object f3 = Pi.f(t2, j);
            if (f2 != null && f3 != null) {
                Pi.a(t, j, zzbrf.zzb(f2, f3));
                b((C0973ki<T>) t, i2, i);
            } else if (f3 != null) {
                Pi.a(t, j, f3);
                b((C0973ki<T>) t, i2, i);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:276:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void b(T r18, com.google.android.gms.internal.ads.Xi r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C0973ki.b(java.lang.Object, com.google.android.gms.internal.ads.Xi):void");
    }

    private static Field a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:            if (com.google.android.gms.internal.ads.C1140wi.a(com.google.android.gms.internal.ads.Pi.f(r10, r6), com.google.android.gms.internal.ads.Pi.f(r11, r6)) != false) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:            if (com.google.android.gms.internal.ads.Pi.b(r10, r6) == com.google.android.gms.internal.ads.Pi.b(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:            if (com.google.android.gms.internal.ads.Pi.a(r10, r6) == com.google.android.gms.internal.ads.Pi.a(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a4, code lost:            if (com.google.android.gms.internal.ads.Pi.b(r10, r6) == com.google.android.gms.internal.ads.Pi.b(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b6, code lost:            if (com.google.android.gms.internal.ads.Pi.a(r10, r6) == com.google.android.gms.internal.ads.Pi.a(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c8, code lost:            if (com.google.android.gms.internal.ads.Pi.a(r10, r6) == com.google.android.gms.internal.ads.Pi.a(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00da, code lost:            if (com.google.android.gms.internal.ads.Pi.a(r10, r6) == com.google.android.gms.internal.ads.Pi.a(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f0, code lost:            if (com.google.android.gms.internal.ads.C1140wi.a(com.google.android.gms.internal.ads.Pi.f(r10, r6), com.google.android.gms.internal.ads.Pi.f(r11, r6)) != false) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0106, code lost:            if (com.google.android.gms.internal.ads.C1140wi.a(com.google.android.gms.internal.ads.Pi.f(r10, r6), com.google.android.gms.internal.ads.Pi.f(r11, r6)) != false) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x011c, code lost:            if (com.google.android.gms.internal.ads.C1140wi.a(com.google.android.gms.internal.ads.Pi.f(r10, r6), com.google.android.gms.internal.ads.Pi.f(r11, r6)) != false) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012e, code lost:            if (com.google.android.gms.internal.ads.Pi.c(r10, r6) == com.google.android.gms.internal.ads.Pi.c(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0140, code lost:            if (com.google.android.gms.internal.ads.Pi.a(r10, r6) == com.google.android.gms.internal.ads.Pi.a(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0154, code lost:            if (com.google.android.gms.internal.ads.Pi.b(r10, r6) == com.google.android.gms.internal.ads.Pi.b(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0165, code lost:            if (com.google.android.gms.internal.ads.Pi.a(r10, r6) == com.google.android.gms.internal.ads.Pi.a(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0178, code lost:            if (com.google.android.gms.internal.ads.Pi.b(r10, r6) == com.google.android.gms.internal.ads.Pi.b(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x018b, code lost:            if (com.google.android.gms.internal.ads.Pi.b(r10, r6) == com.google.android.gms.internal.ads.Pi.b(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x019c, code lost:            if (com.google.android.gms.internal.ads.Pi.a(r10, r6) == com.google.android.gms.internal.ads.Pi.a(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01af, code lost:            if (com.google.android.gms.internal.ads.Pi.b(r10, r6) == com.google.android.gms.internal.ads.Pi.b(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:            if (com.google.android.gms.internal.ads.C1140wi.a(com.google.android.gms.internal.ads.Pi.f(r10, r6), com.google.android.gms.internal.ads.Pi.f(r11, r6)) != false) goto L105;     */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01b5 A[LOOP:0: B:2:0x0005->B:86:0x01b5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01b4 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.InterfaceC1112ui
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 624
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C0973ki.a(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001b. Please report as an issue. */
    @Override // com.google.android.gms.internal.ads.InterfaceC1112ui
    public final int a(T t) {
        int i;
        int zzbi;
        int length = this.f12263c.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int d2 = d(i3);
            int i4 = this.f12263c[i3];
            long j = 1048575 & d2;
            int i5 = 37;
            switch ((d2 & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    zzbi = zzbrf.zzbi(Double.doubleToLongBits(Pi.e(t, j)));
                    i2 = i + zzbi;
                    break;
                case 1:
                    i = i2 * 53;
                    zzbi = Float.floatToIntBits(Pi.d(t, j));
                    i2 = i + zzbi;
                    break;
                case 2:
                    i = i2 * 53;
                    zzbi = zzbrf.zzbi(Pi.b(t, j));
                    i2 = i + zzbi;
                    break;
                case 3:
                    i = i2 * 53;
                    zzbi = zzbrf.zzbi(Pi.b(t, j));
                    i2 = i + zzbi;
                    break;
                case 4:
                    i = i2 * 53;
                    zzbi = Pi.a(t, j);
                    i2 = i + zzbi;
                    break;
                case 5:
                    i = i2 * 53;
                    zzbi = zzbrf.zzbi(Pi.b(t, j));
                    i2 = i + zzbi;
                    break;
                case 6:
                    i = i2 * 53;
                    zzbi = Pi.a(t, j);
                    i2 = i + zzbi;
                    break;
                case 7:
                    i = i2 * 53;
                    zzbi = zzbrf.zzbf(Pi.c(t, j));
                    i2 = i + zzbi;
                    break;
                case 8:
                    i = i2 * 53;
                    zzbi = ((String) Pi.f(t, j)).hashCode();
                    i2 = i + zzbi;
                    break;
                case 9:
                    Object f2 = Pi.f(t, j);
                    if (f2 != null) {
                        i5 = f2.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
                    break;
                case 10:
                    i = i2 * 53;
                    zzbi = Pi.f(t, j).hashCode();
                    i2 = i + zzbi;
                    break;
                case 11:
                    i = i2 * 53;
                    zzbi = Pi.a(t, j);
                    i2 = i + zzbi;
                    break;
                case 12:
                    i = i2 * 53;
                    zzbi = Pi.a(t, j);
                    i2 = i + zzbi;
                    break;
                case 13:
                    i = i2 * 53;
                    zzbi = Pi.a(t, j);
                    i2 = i + zzbi;
                    break;
                case 14:
                    i = i2 * 53;
                    zzbi = zzbrf.zzbi(Pi.b(t, j));
                    i2 = i + zzbi;
                    break;
                case 15:
                    i = i2 * 53;
                    zzbi = Pi.a(t, j);
                    i2 = i + zzbi;
                    break;
                case 16:
                    i = i2 * 53;
                    zzbi = zzbrf.zzbi(Pi.b(t, j));
                    i2 = i + zzbi;
                    break;
                case 17:
                    Object f3 = Pi.f(t, j);
                    if (f3 != null) {
                        i5 = f3.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
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
                    i = i2 * 53;
                    zzbi = Pi.f(t, j).hashCode();
                    i2 = i + zzbi;
                    break;
                case 50:
                    i = i2 * 53;
                    zzbi = Pi.f(t, j).hashCode();
                    i2 = i + zzbi;
                    break;
                case 51:
                    if (a((C0973ki<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbi = zzbrf.zzbi(Double.doubleToLongBits(b(t, j)));
                        i2 = i + zzbi;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (a((C0973ki<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbi = Float.floatToIntBits(c(t, j));
                        i2 = i + zzbi;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (a((C0973ki<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbi = zzbrf.zzbi(e(t, j));
                        i2 = i + zzbi;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (a((C0973ki<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbi = zzbrf.zzbi(e(t, j));
                        i2 = i + zzbi;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (a((C0973ki<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbi = d(t, j);
                        i2 = i + zzbi;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (a((C0973ki<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbi = zzbrf.zzbi(e(t, j));
                        i2 = i + zzbi;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (a((C0973ki<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbi = d(t, j);
                        i2 = i + zzbi;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (a((C0973ki<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbi = zzbrf.zzbf(f(t, j));
                        i2 = i + zzbi;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (a((C0973ki<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbi = ((String) Pi.f(t, j)).hashCode();
                        i2 = i + zzbi;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (a((C0973ki<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbi = Pi.f(t, j).hashCode();
                        i2 = i + zzbi;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (a((C0973ki<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbi = Pi.f(t, j).hashCode();
                        i2 = i + zzbi;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (a((C0973ki<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbi = d(t, j);
                        i2 = i + zzbi;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (a((C0973ki<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbi = d(t, j);
                        i2 = i + zzbi;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (a((C0973ki<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbi = d(t, j);
                        i2 = i + zzbi;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (a((C0973ki<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbi = zzbrf.zzbi(e(t, j));
                        i2 = i + zzbi;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (a((C0973ki<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbi = d(t, j);
                        i2 = i + zzbi;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (a((C0973ki<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbi = zzbrf.zzbi(e(t, j));
                        i2 = i + zzbi;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (a((C0973ki<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbi = Pi.f(t, j).hashCode();
                        i2 = i + zzbi;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i2 * 53) + this.q.b(t).hashCode();
        return this.f12268h ? (hashCode * 53) + this.r.a(t).hashCode() : hashCode;
    }

    private final void a(T t, T t2, int i) {
        long d2 = d(i) & 1048575;
        if (a((C0973ki<T>) t2, i)) {
            Object f2 = Pi.f(t, d2);
            Object f3 = Pi.f(t2, d2);
            if (f2 != null && f3 != null) {
                Pi.a(t, d2, zzbrf.zzb(f2, f3));
                b((C0973ki<T>) t, i);
            } else if (f3 != null) {
                Pi.a(t, d2, f3);
                b((C0973ki<T>) t, i);
            }
        }
    }

    private static <UT, UB> int a(Li<UT, UB> li, T t) {
        return li.a((Li<UT, UB>) li.b(t));
    }

    private static <E> List<E> a(Object obj, long j) {
        return (List) Pi.f(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x04ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:538:0x0969  */
    /* JADX WARN: Removed duplicated region for block: B:540:0x096f  */
    @Override // com.google.android.gms.internal.ads.InterfaceC1112ui
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(T r13, com.google.android.gms.internal.ads.Xi r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2710
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C0973ki.a(java.lang.Object, com.google.android.gms.internal.ads.Xi):void");
    }

    private final Object b(int i) {
        return this.f12264d[(i / 3) << 1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.InterfaceC1112ui
    public final boolean b(T t) {
        int i;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= this.m) {
                return !this.f12268h || this.r.a(t).d();
            }
            int i5 = this.l[i2];
            int i6 = this.f12263c[i5];
            int d2 = d(i5);
            if (this.j) {
                i = 0;
            } else {
                int i7 = this.f12263c[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i4 = f12262b.getInt(t, i8);
                    i3 = i8;
                }
            }
            if (((268435456 & d2) != 0) && !a((C0973ki<T>) t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & d2) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (a((C0973ki<T>) t, i6, i5) && !a(t, d2, a(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 == 50 && !this.s.g(Pi.f(t, d2 & 1048575)).isEmpty()) {
                            this.s.e(b(i5));
                            throw null;
                        }
                    }
                }
                List list = (List) Pi.f(t, d2 & 1048575);
                if (!list.isEmpty()) {
                    InterfaceC1112ui a2 = a(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        }
                        if (!a2.b(list.get(i10))) {
                            z = false;
                            break;
                        }
                        i10++;
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (a((C0973ki<T>) t, i5, i4, i) && !a(t, d2, a(i5))) {
                return false;
            }
            i2++;
        }
    }

    private static <T> double b(T t, long j) {
        return ((Double) Pi.f(t, j)).doubleValue();
    }

    private final void b(T t, int i) {
        if (this.j) {
            return;
        }
        int e2 = e(i);
        long j = e2 & 1048575;
        Pi.a((Object) t, j, Pi.a(t, j) | (1 << (e2 >>> 20)));
    }

    private final void b(T t, int i, int i2) {
        Pi.a((Object) t, e(i2) & 1048575, i);
    }

    private final int b(int i, int i2) {
        int length = (this.f12263c.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.f12263c[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private final zzbri c(int i) {
        return (zzbri) this.f12264d[((i / 3) << 1) + 1];
    }

    private static <T> float c(T t, long j) {
        return ((Float) Pi.f(t, j)).floatValue();
    }

    private final boolean c(T t, T t2, int i) {
        return a((C0973ki<T>) t, i) == a((C0973ki<T>) t2, i);
    }

    private final <K, V> void a(Xi xi, int i, Object obj, int i2) throws IOException {
        if (obj == null) {
            return;
        }
        this.s.e(b(i2));
        throw null;
    }

    private static <UT, UB> void a(Li<UT, UB> li, T t, Xi xi) throws IOException {
        li.a((Li<UT, UB>) li.b(t), xi);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0079. Please report as an issue. */
    @Override // com.google.android.gms.internal.ads.InterfaceC1112ui
    public final void a(T t, InterfaceC1098ti interfaceC1098ti, zzbqq zzbqqVar) throws IOException {
        if (zzbqqVar != null) {
            Li li = this.q;
            Jh<?> jh = this.r;
            Object obj = null;
            while (true) {
                try {
                    int m = interfaceC1098ti.m();
                    int g2 = g(m);
                    if (g2 < 0) {
                        if (m == Integer.MAX_VALUE) {
                            for (int i = this.m; i < this.n; i++) {
                                a((Object) t, this.l[i], (int) obj, (Li<UT, int>) li);
                            }
                            if (obj != null) {
                                li.b((Object) t, (T) obj);
                                return;
                            }
                            return;
                        }
                        Object a2 = !this.f12268h ? null : jh.a(zzbqqVar, this.f12267g, m);
                        if (a2 != null) {
                            jh.a(interfaceC1098ti, a2, zzbqqVar, jh.b(t), obj, li);
                            throw null;
                        }
                        li.a(interfaceC1098ti);
                        if (obj == null) {
                            obj = li.c(t);
                        }
                        if (!li.a((Li) obj, interfaceC1098ti)) {
                            for (int i2 = this.m; i2 < this.n; i2++) {
                                a((Object) t, this.l[i2], (int) obj, (Li<UT, int>) li);
                            }
                            if (obj != null) {
                                li.b((Object) t, (T) obj);
                                return;
                            }
                            return;
                        }
                    } else {
                        int d2 = d(g2);
                        switch ((267386880 & d2) >>> 20) {
                            case 0:
                                Pi.a(t, d2 & 1048575, interfaceC1098ti.readDouble());
                                b((C0973ki<T>) t, g2);
                                break;
                            case 1:
                                Pi.a((Object) t, d2 & 1048575, interfaceC1098ti.readFloat());
                                b((C0973ki<T>) t, g2);
                                break;
                            case 2:
                                Pi.a((Object) t, d2 & 1048575, interfaceC1098ti.e());
                                b((C0973ki<T>) t, g2);
                                break;
                            case 3:
                                Pi.a((Object) t, d2 & 1048575, interfaceC1098ti.b());
                                b((C0973ki<T>) t, g2);
                                break;
                            case 4:
                                Pi.a((Object) t, d2 & 1048575, interfaceC1098ti.d());
                                b((C0973ki<T>) t, g2);
                                break;
                            case 5:
                                Pi.a((Object) t, d2 & 1048575, interfaceC1098ti.f());
                                b((C0973ki<T>) t, g2);
                                break;
                            case 6:
                                Pi.a((Object) t, d2 & 1048575, interfaceC1098ti.g());
                                b((C0973ki<T>) t, g2);
                                break;
                            case 7:
                                Pi.a(t, d2 & 1048575, interfaceC1098ti.l());
                                b((C0973ki<T>) t, g2);
                                break;
                            case 8:
                                a(t, d2, interfaceC1098ti);
                                b((C0973ki<T>) t, g2);
                                break;
                            case 9:
                                if (a((C0973ki<T>) t, g2)) {
                                    long j = d2 & 1048575;
                                    Pi.a(t, j, zzbrf.zzb(Pi.f(t, j), interfaceC1098ti.a(a(g2), zzbqqVar)));
                                    break;
                                } else {
                                    Pi.a(t, d2 & 1048575, interfaceC1098ti.a(a(g2), zzbqqVar));
                                    b((C0973ki<T>) t, g2);
                                    break;
                                }
                            case 10:
                                Pi.a(t, d2 & 1048575, interfaceC1098ti.p());
                                b((C0973ki<T>) t, g2);
                                break;
                            case 11:
                                Pi.a((Object) t, d2 & 1048575, interfaceC1098ti.h());
                                b((C0973ki<T>) t, g2);
                                break;
                            case 12:
                                int i3 = interfaceC1098ti.i();
                                zzbri c2 = c(g2);
                                if (c2 != null && !c2.zzcb(i3)) {
                                    obj = C1140wi.a(m, i3, obj, (Li<UT, Object>) li);
                                    break;
                                }
                                Pi.a((Object) t, d2 & 1048575, i3);
                                b((C0973ki<T>) t, g2);
                                break;
                            case 13:
                                Pi.a((Object) t, d2 & 1048575, interfaceC1098ti.j());
                                b((C0973ki<T>) t, g2);
                                break;
                            case 14:
                                Pi.a((Object) t, d2 & 1048575, interfaceC1098ti.k());
                                b((C0973ki<T>) t, g2);
                                break;
                            case 15:
                                Pi.a((Object) t, d2 & 1048575, interfaceC1098ti.c());
                                b((C0973ki<T>) t, g2);
                                break;
                            case 16:
                                Pi.a((Object) t, d2 & 1048575, interfaceC1098ti.a());
                                b((C0973ki<T>) t, g2);
                                break;
                            case 17:
                                if (a((C0973ki<T>) t, g2)) {
                                    long j2 = d2 & 1048575;
                                    Pi.a(t, j2, zzbrf.zzb(Pi.f(t, j2), interfaceC1098ti.b(a(g2), zzbqqVar)));
                                    break;
                                } else {
                                    Pi.a(t, d2 & 1048575, interfaceC1098ti.b(a(g2), zzbqqVar));
                                    b((C0973ki<T>) t, g2);
                                    break;
                                }
                            case 18:
                                interfaceC1098ti.b(this.p.a(t, d2 & 1048575));
                                break;
                            case 19:
                                interfaceC1098ti.d(this.p.a(t, d2 & 1048575));
                                break;
                            case 20:
                                interfaceC1098ti.a(this.p.a(t, d2 & 1048575));
                                break;
                            case 21:
                                interfaceC1098ti.c(this.p.a(t, d2 & 1048575));
                                break;
                            case 22:
                                interfaceC1098ti.h(this.p.a(t, d2 & 1048575));
                                break;
                            case 23:
                                interfaceC1098ti.j(this.p.a(t, d2 & 1048575));
                                break;
                            case 24:
                                interfaceC1098ti.i(this.p.a(t, d2 & 1048575));
                                break;
                            case 25:
                                interfaceC1098ti.q(this.p.a(t, d2 & 1048575));
                                break;
                            case 26:
                                if (f(d2)) {
                                    interfaceC1098ti.p(this.p.a(t, d2 & 1048575));
                                    break;
                                } else {
                                    interfaceC1098ti.e(this.p.a(t, d2 & 1048575));
                                    break;
                                }
                            case 27:
                                interfaceC1098ti.a(this.p.a(t, d2 & 1048575), a(g2), zzbqqVar);
                                break;
                            case 28:
                                interfaceC1098ti.r(this.p.a(t, d2 & 1048575));
                                break;
                            case 29:
                                interfaceC1098ti.s(this.p.a(t, d2 & 1048575));
                                break;
                            case 30:
                                List<Integer> a3 = this.p.a(t, d2 & 1048575);
                                interfaceC1098ti.x(a3);
                                obj = C1140wi.a(m, a3, c(g2), obj, li);
                                break;
                            case 31:
                                interfaceC1098ti.v(this.p.a(t, d2 & 1048575));
                                break;
                            case 32:
                                interfaceC1098ti.w(this.p.a(t, d2 & 1048575));
                                break;
                            case 33:
                                interfaceC1098ti.t(this.p.a(t, d2 & 1048575));
                                break;
                            case 34:
                                interfaceC1098ti.u(this.p.a(t, d2 & 1048575));
                                break;
                            case 35:
                                interfaceC1098ti.b(this.p.a(t, d2 & 1048575));
                                break;
                            case 36:
                                interfaceC1098ti.d(this.p.a(t, d2 & 1048575));
                                break;
                            case 37:
                                interfaceC1098ti.a(this.p.a(t, d2 & 1048575));
                                break;
                            case 38:
                                interfaceC1098ti.c(this.p.a(t, d2 & 1048575));
                                break;
                            case 39:
                                interfaceC1098ti.h(this.p.a(t, d2 & 1048575));
                                break;
                            case 40:
                                interfaceC1098ti.j(this.p.a(t, d2 & 1048575));
                                break;
                            case 41:
                                interfaceC1098ti.i(this.p.a(t, d2 & 1048575));
                                break;
                            case 42:
                                interfaceC1098ti.q(this.p.a(t, d2 & 1048575));
                                break;
                            case 43:
                                interfaceC1098ti.s(this.p.a(t, d2 & 1048575));
                                break;
                            case 44:
                                List<Integer> a4 = this.p.a(t, d2 & 1048575);
                                interfaceC1098ti.x(a4);
                                obj = C1140wi.a(m, a4, c(g2), obj, li);
                                break;
                            case 45:
                                interfaceC1098ti.v(this.p.a(t, d2 & 1048575));
                                break;
                            case 46:
                                interfaceC1098ti.w(this.p.a(t, d2 & 1048575));
                                break;
                            case 47:
                                interfaceC1098ti.t(this.p.a(t, d2 & 1048575));
                                break;
                            case 48:
                                interfaceC1098ti.u(this.p.a(t, d2 & 1048575));
                                break;
                            case 49:
                                interfaceC1098ti.b(this.p.a(t, d2 & 1048575), a(g2), zzbqqVar);
                                break;
                            case 50:
                                Object b2 = b(g2);
                                long d3 = d(g2) & 1048575;
                                Object f2 = Pi.f(t, d3);
                                if (f2 != null) {
                                    if (this.s.b(f2)) {
                                        Object d4 = this.s.d(b2);
                                        this.s.b(d4, f2);
                                        Pi.a(t, d3, d4);
                                        f2 = d4;
                                    }
                                } else {
                                    f2 = this.s.d(b2);
                                    Pi.a(t, d3, f2);
                                }
                                this.s.h(f2);
                                this.s.e(b2);
                                throw null;
                            case 51:
                                Pi.a(t, d2 & 1048575, Double.valueOf(interfaceC1098ti.readDouble()));
                                b((C0973ki<T>) t, m, g2);
                                break;
                            case 52:
                                Pi.a(t, d2 & 1048575, Float.valueOf(interfaceC1098ti.readFloat()));
                                b((C0973ki<T>) t, m, g2);
                                break;
                            case 53:
                                Pi.a(t, d2 & 1048575, Long.valueOf(interfaceC1098ti.e()));
                                b((C0973ki<T>) t, m, g2);
                                break;
                            case 54:
                                Pi.a(t, d2 & 1048575, Long.valueOf(interfaceC1098ti.b()));
                                b((C0973ki<T>) t, m, g2);
                                break;
                            case 55:
                                Pi.a(t, d2 & 1048575, Integer.valueOf(interfaceC1098ti.d()));
                                b((C0973ki<T>) t, m, g2);
                                break;
                            case 56:
                                Pi.a(t, d2 & 1048575, Long.valueOf(interfaceC1098ti.f()));
                                b((C0973ki<T>) t, m, g2);
                                break;
                            case 57:
                                Pi.a(t, d2 & 1048575, Integer.valueOf(interfaceC1098ti.g()));
                                b((C0973ki<T>) t, m, g2);
                                break;
                            case 58:
                                Pi.a(t, d2 & 1048575, Boolean.valueOf(interfaceC1098ti.l()));
                                b((C0973ki<T>) t, m, g2);
                                break;
                            case 59:
                                a(t, d2, interfaceC1098ti);
                                b((C0973ki<T>) t, m, g2);
                                break;
                            case 60:
                                if (a((C0973ki<T>) t, m, g2)) {
                                    long j3 = d2 & 1048575;
                                    Pi.a(t, j3, zzbrf.zzb(Pi.f(t, j3), interfaceC1098ti.a(a(g2), zzbqqVar)));
                                } else {
                                    Pi.a(t, d2 & 1048575, interfaceC1098ti.a(a(g2), zzbqqVar));
                                    b((C0973ki<T>) t, g2);
                                }
                                b((C0973ki<T>) t, m, g2);
                                break;
                            case 61:
                                Pi.a(t, d2 & 1048575, interfaceC1098ti.p());
                                b((C0973ki<T>) t, m, g2);
                                break;
                            case 62:
                                Pi.a(t, d2 & 1048575, Integer.valueOf(interfaceC1098ti.h()));
                                b((C0973ki<T>) t, m, g2);
                                break;
                            case 63:
                                int i4 = interfaceC1098ti.i();
                                zzbri c3 = c(g2);
                                if (c3 != null && !c3.zzcb(i4)) {
                                    obj = C1140wi.a(m, i4, obj, (Li<UT, Object>) li);
                                    break;
                                }
                                Pi.a(t, d2 & 1048575, Integer.valueOf(i4));
                                b((C0973ki<T>) t, m, g2);
                                break;
                            case 64:
                                Pi.a(t, d2 & 1048575, Integer.valueOf(interfaceC1098ti.j()));
                                b((C0973ki<T>) t, m, g2);
                                break;
                            case 65:
                                Pi.a(t, d2 & 1048575, Long.valueOf(interfaceC1098ti.k()));
                                b((C0973ki<T>) t, m, g2);
                                break;
                            case 66:
                                Pi.a(t, d2 & 1048575, Integer.valueOf(interfaceC1098ti.c()));
                                b((C0973ki<T>) t, m, g2);
                                break;
                            case 67:
                                Pi.a(t, d2 & 1048575, Long.valueOf(interfaceC1098ti.a()));
                                b((C0973ki<T>) t, m, g2);
                                break;
                            case 68:
                                Pi.a(t, d2 & 1048575, interfaceC1098ti.b(a(g2), zzbqqVar));
                                b((C0973ki<T>) t, m, g2);
                                break;
                            default:
                                if (obj == null) {
                                    try {
                                        obj = li.a();
                                    } catch (zzbrm unused) {
                                        li.a(interfaceC1098ti);
                                        if (obj == null) {
                                            obj = li.c(t);
                                        }
                                        if (!li.a((Li) obj, interfaceC1098ti)) {
                                            for (int i5 = this.m; i5 < this.n; i5++) {
                                                a((Object) t, this.l[i5], (int) obj, (Li<UT, int>) li);
                                            }
                                            if (obj != null) {
                                                li.b((Object) t, (T) obj);
                                                return;
                                            }
                                            return;
                                        }
                                        break;
                                    }
                                }
                                if (!li.a((Li) obj, interfaceC1098ti)) {
                                    for (int i6 = this.m; i6 < this.n; i6++) {
                                        a((Object) t, this.l[i6], (int) obj, (Li<UT, int>) li);
                                    }
                                    if (obj != null) {
                                        li.b((Object) t, (T) obj);
                                        return;
                                    }
                                    return;
                                }
                                break;
                        }
                    }
                } catch (Throwable th) {
                    for (int i7 = this.m; i7 < this.n; i7++) {
                        a((Object) t, this.l[i7], (int) obj, (Li<UT, int>) li);
                    }
                    if (obj != null) {
                        li.b((Object) t, (T) obj);
                    }
                    throw th;
                }
            }
        } else {
            throw new NullPointerException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int a(InterfaceC1112ui interfaceC1112ui, byte[] bArr, int i, int i2, C1111uh c1111uh) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = C1097th.a(i4, bArr, i3, c1111uh);
            i4 = c1111uh.f12581a;
        }
        int i5 = i3;
        if (i4 >= 0 && i4 <= i2 - i5) {
            Object newInstance = interfaceC1112ui.newInstance();
            int i6 = i4 + i5;
            interfaceC1112ui.a(newInstance, bArr, i5, i6, c1111uh);
            interfaceC1112ui.d(newInstance);
            c1111uh.f12583c = newInstance;
            return i6;
        }
        throw zzbrl.zzanc();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int a(InterfaceC1112ui interfaceC1112ui, byte[] bArr, int i, int i2, int i3, C1111uh c1111uh) throws IOException {
        C0973ki c0973ki = (C0973ki) interfaceC1112ui;
        Object newInstance = c0973ki.newInstance();
        int a2 = c0973ki.a((C0973ki) newInstance, bArr, i, i2, i3, c1111uh);
        c0973ki.d((C0973ki) newInstance);
        c1111uh.f12583c = newInstance;
        return a2;
    }

    private static int a(InterfaceC1112ui<?> interfaceC1112ui, int i, byte[] bArr, int i2, int i3, zzbrk<?> zzbrkVar, C1111uh c1111uh) throws IOException {
        int a2 = a((InterfaceC1112ui) interfaceC1112ui, bArr, i2, i3, c1111uh);
        zzbrkVar.add(c1111uh.f12583c);
        while (a2 < i3) {
            int a3 = C1097th.a(bArr, a2, c1111uh);
            if (i != c1111uh.f12581a) {
                break;
            }
            a2 = a((InterfaceC1112ui) interfaceC1112ui, bArr, a3, i3, c1111uh);
            zzbrkVar.add(c1111uh.f12583c);
        }
        return a2;
    }

    private static int a(int i, byte[] bArr, int i2, int i3, Object obj, C1111uh c1111uh) throws IOException {
        return C1097th.a(i, bArr, i2, i3, e(obj), c1111uh);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x003a. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    private final int a(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, C1111uh c1111uh) throws IOException {
        int a2;
        int i8 = i;
        zzbrk zzbrkVar = (zzbrk) f12262b.getObject(t, j2);
        if (!zzbrkVar.zzaki()) {
            int size = zzbrkVar.size();
            zzbrkVar = zzbrkVar.zzel(size == 0 ? 10 : size << 1);
            f12262b.putObject(t, j2, zzbrkVar);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    Hh hh = (Hh) zzbrkVar;
                    int a3 = C1097th.a(bArr, i8, c1111uh);
                    int i9 = c1111uh.f12581a + a3;
                    while (a3 < i9) {
                        hh.b(C1097th.c(bArr, a3));
                        a3 += 8;
                    }
                    if (a3 == i9) {
                        return a3;
                    }
                    throw zzbrl.zzanc();
                }
                if (i5 == 1) {
                    Hh hh2 = (Hh) zzbrkVar;
                    hh2.b(C1097th.c(bArr, i));
                    while (true) {
                        int i10 = i8 + 8;
                        if (i10 >= i2) {
                            return i10;
                        }
                        i8 = C1097th.a(bArr, i10, c1111uh);
                        if (i3 != c1111uh.f12581a) {
                            return i10;
                        }
                        hh2.b(C1097th.c(bArr, i8));
                    }
                }
                return i8;
            case 19:
            case 36:
                if (i5 == 2) {
                    Ph ph = (Ph) zzbrkVar;
                    int a4 = C1097th.a(bArr, i8, c1111uh);
                    int i11 = c1111uh.f12581a + a4;
                    while (a4 < i11) {
                        ph.a(C1097th.d(bArr, a4));
                        a4 += 4;
                    }
                    if (a4 == i11) {
                        return a4;
                    }
                    throw zzbrl.zzanc();
                }
                if (i5 == 5) {
                    Ph ph2 = (Ph) zzbrkVar;
                    ph2.a(C1097th.d(bArr, i));
                    while (true) {
                        int i12 = i8 + 4;
                        if (i12 >= i2) {
                            return i12;
                        }
                        i8 = C1097th.a(bArr, i12, c1111uh);
                        if (i3 != c1111uh.f12581a) {
                            return i12;
                        }
                        ph2.a(C1097th.d(bArr, i8));
                    }
                }
                return i8;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    _h _hVar = (_h) zzbrkVar;
                    int a5 = C1097th.a(bArr, i8, c1111uh);
                    int i13 = c1111uh.f12581a + a5;
                    while (a5 < i13) {
                        a5 = C1097th.b(bArr, a5, c1111uh);
                        _hVar.a(c1111uh.f12582b);
                    }
                    if (a5 == i13) {
                        return a5;
                    }
                    throw zzbrl.zzanc();
                }
                if (i5 == 0) {
                    _h _hVar2 = (_h) zzbrkVar;
                    int b2 = C1097th.b(bArr, i8, c1111uh);
                    _hVar2.a(c1111uh.f12582b);
                    while (b2 < i2) {
                        int a6 = C1097th.a(bArr, b2, c1111uh);
                        if (i3 != c1111uh.f12581a) {
                            return b2;
                        }
                        b2 = C1097th.b(bArr, a6, c1111uh);
                        _hVar2.a(c1111uh.f12582b);
                    }
                    return b2;
                }
                return i8;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return C1097th.a(bArr, i8, (zzbrk<?>) zzbrkVar, c1111uh);
                }
                if (i5 == 0) {
                    return C1097th.a(i3, bArr, i, i2, (zzbrk<?>) zzbrkVar, c1111uh);
                }
                return i8;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    _h _hVar3 = (_h) zzbrkVar;
                    int a7 = C1097th.a(bArr, i8, c1111uh);
                    int i14 = c1111uh.f12581a + a7;
                    while (a7 < i14) {
                        _hVar3.a(C1097th.b(bArr, a7));
                        a7 += 8;
                    }
                    if (a7 == i14) {
                        return a7;
                    }
                    throw zzbrl.zzanc();
                }
                if (i5 == 1) {
                    _h _hVar4 = (_h) zzbrkVar;
                    _hVar4.a(C1097th.b(bArr, i));
                    while (true) {
                        int i15 = i8 + 8;
                        if (i15 >= i2) {
                            return i15;
                        }
                        i8 = C1097th.a(bArr, i15, c1111uh);
                        if (i3 != c1111uh.f12581a) {
                            return i15;
                        }
                        _hVar4.a(C1097th.b(bArr, i8));
                    }
                }
                return i8;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    Sh sh = (Sh) zzbrkVar;
                    int a8 = C1097th.a(bArr, i8, c1111uh);
                    int i16 = c1111uh.f12581a + a8;
                    while (a8 < i16) {
                        sh.a(C1097th.a(bArr, a8));
                        a8 += 4;
                    }
                    if (a8 == i16) {
                        return a8;
                    }
                    throw zzbrl.zzanc();
                }
                if (i5 == 5) {
                    Sh sh2 = (Sh) zzbrkVar;
                    sh2.a(C1097th.a(bArr, i));
                    while (true) {
                        int i17 = i8 + 4;
                        if (i17 >= i2) {
                            return i17;
                        }
                        i8 = C1097th.a(bArr, i17, c1111uh);
                        if (i3 != c1111uh.f12581a) {
                            return i17;
                        }
                        sh2.a(C1097th.a(bArr, i8));
                    }
                }
                return i8;
            case 25:
            case 42:
                if (i5 == 2) {
                    C1125vh c1125vh = (C1125vh) zzbrkVar;
                    a2 = C1097th.a(bArr, i8, c1111uh);
                    int i18 = c1111uh.f12581a + a2;
                    while (a2 < i18) {
                        a2 = C1097th.b(bArr, a2, c1111uh);
                        c1125vh.a(c1111uh.f12582b != 0);
                    }
                    if (a2 != i18) {
                        throw zzbrl.zzanc();
                    }
                    return a2;
                }
                if (i5 == 0) {
                    C1125vh c1125vh2 = (C1125vh) zzbrkVar;
                    i8 = C1097th.b(bArr, i8, c1111uh);
                    c1125vh2.a(c1111uh.f12582b != 0);
                    while (i8 < i2) {
                        int a9 = C1097th.a(bArr, i8, c1111uh);
                        if (i3 == c1111uh.f12581a) {
                            i8 = C1097th.b(bArr, a9, c1111uh);
                            c1125vh2.a(c1111uh.f12582b != 0);
                        }
                    }
                }
                return i8;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        i8 = C1097th.a(bArr, i8, c1111uh);
                        int i19 = c1111uh.f12581a;
                        if (i19 < 0) {
                            throw zzbrl.zzand();
                        }
                        if (i19 == 0) {
                            zzbrkVar.add("");
                        } else {
                            zzbrkVar.add(new String(bArr, i8, i19, zzbrf.UTF_8));
                            i8 += i19;
                        }
                        while (i8 < i2) {
                            int a10 = C1097th.a(bArr, i8, c1111uh);
                            if (i3 == c1111uh.f12581a) {
                                i8 = C1097th.a(bArr, a10, c1111uh);
                                int i20 = c1111uh.f12581a;
                                if (i20 < 0) {
                                    throw zzbrl.zzand();
                                }
                                if (i20 == 0) {
                                    zzbrkVar.add("");
                                } else {
                                    zzbrkVar.add(new String(bArr, i8, i20, zzbrf.UTF_8));
                                    i8 += i20;
                                }
                            }
                        }
                    } else {
                        i8 = C1097th.a(bArr, i8, c1111uh);
                        int i21 = c1111uh.f12581a;
                        if (i21 < 0) {
                            throw zzbrl.zzand();
                        }
                        if (i21 == 0) {
                            zzbrkVar.add("");
                        } else {
                            int i22 = i8 + i21;
                            if (Ri.a(bArr, i8, i22)) {
                                zzbrkVar.add(new String(bArr, i8, i21, zzbrf.UTF_8));
                                i8 = i22;
                            } else {
                                throw zzbrl.zzank();
                            }
                        }
                        while (i8 < i2) {
                            int a11 = C1097th.a(bArr, i8, c1111uh);
                            if (i3 == c1111uh.f12581a) {
                                i8 = C1097th.a(bArr, a11, c1111uh);
                                int i23 = c1111uh.f12581a;
                                if (i23 < 0) {
                                    throw zzbrl.zzand();
                                }
                                if (i23 == 0) {
                                    zzbrkVar.add("");
                                } else {
                                    int i24 = i8 + i23;
                                    if (Ri.a(bArr, i8, i24)) {
                                        zzbrkVar.add(new String(bArr, i8, i23, zzbrf.UTF_8));
                                        i8 = i24;
                                    } else {
                                        throw zzbrl.zzank();
                                    }
                                }
                            }
                        }
                    }
                }
                return i8;
            case 27:
                if (i5 == 2) {
                    return a((InterfaceC1112ui<?>) a(i6), i3, bArr, i, i2, (zzbrk<?>) zzbrkVar, c1111uh);
                }
                return i8;
            case 28:
                if (i5 == 2) {
                    int a12 = C1097th.a(bArr, i8, c1111uh);
                    int i25 = c1111uh.f12581a;
                    if (i25 >= 0) {
                        if (i25 > bArr.length - a12) {
                            throw zzbrl.zzanc();
                        }
                        if (i25 == 0) {
                            zzbrkVar.add(zzbpu.zzfli);
                        } else {
                            zzbrkVar.add(zzbpu.zzi(bArr, a12, i25));
                            a12 += i25;
                        }
                        while (a12 < i2) {
                            int a13 = C1097th.a(bArr, a12, c1111uh);
                            if (i3 != c1111uh.f12581a) {
                                return a12;
                            }
                            a12 = C1097th.a(bArr, a13, c1111uh);
                            int i26 = c1111uh.f12581a;
                            if (i26 >= 0) {
                                if (i26 > bArr.length - a12) {
                                    throw zzbrl.zzanc();
                                }
                                if (i26 == 0) {
                                    zzbrkVar.add(zzbpu.zzfli);
                                } else {
                                    zzbrkVar.add(zzbpu.zzi(bArr, a12, i26));
                                    a12 += i26;
                                }
                            } else {
                                throw zzbrl.zzand();
                            }
                        }
                        return a12;
                    }
                    throw zzbrl.zzand();
                }
                return i8;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        a2 = C1097th.a(i3, bArr, i, i2, (zzbrk<?>) zzbrkVar, c1111uh);
                    }
                    return i8;
                }
                a2 = C1097th.a(bArr, i8, (zzbrk<?>) zzbrkVar, c1111uh);
                zzbrd zzbrdVar = (zzbrd) t;
                zzbtv zzbtvVar = zzbrdVar.zzfpu;
                if (zzbtvVar == zzbtv.zzaoz()) {
                    zzbtvVar = null;
                }
                zzbtv zzbtvVar2 = (zzbtv) C1140wi.a(i4, zzbrkVar, c(i6), zzbtvVar, this.q);
                if (zzbtvVar2 != null) {
                    zzbrdVar.zzfpu = zzbtvVar2;
                }
                return a2;
            case 33:
            case 47:
                if (i5 == 2) {
                    Sh sh3 = (Sh) zzbrkVar;
                    int a14 = C1097th.a(bArr, i8, c1111uh);
                    int i27 = c1111uh.f12581a + a14;
                    while (a14 < i27) {
                        a14 = C1097th.a(bArr, a14, c1111uh);
                        sh3.a(zzbqf.zzeu(c1111uh.f12581a));
                    }
                    if (a14 == i27) {
                        return a14;
                    }
                    throw zzbrl.zzanc();
                }
                if (i5 == 0) {
                    Sh sh4 = (Sh) zzbrkVar;
                    int a15 = C1097th.a(bArr, i8, c1111uh);
                    sh4.a(zzbqf.zzeu(c1111uh.f12581a));
                    while (a15 < i2) {
                        int a16 = C1097th.a(bArr, a15, c1111uh);
                        if (i3 != c1111uh.f12581a) {
                            return a15;
                        }
                        a15 = C1097th.a(bArr, a16, c1111uh);
                        sh4.a(zzbqf.zzeu(c1111uh.f12581a));
                    }
                    return a15;
                }
                return i8;
            case 34:
            case 48:
                if (i5 == 2) {
                    _h _hVar5 = (_h) zzbrkVar;
                    int a17 = C1097th.a(bArr, i8, c1111uh);
                    int i28 = c1111uh.f12581a + a17;
                    while (a17 < i28) {
                        a17 = C1097th.b(bArr, a17, c1111uh);
                        _hVar5.a(zzbqf.zzax(c1111uh.f12582b));
                    }
                    if (a17 == i28) {
                        return a17;
                    }
                    throw zzbrl.zzanc();
                }
                if (i5 == 0) {
                    _h _hVar6 = (_h) zzbrkVar;
                    int b3 = C1097th.b(bArr, i8, c1111uh);
                    _hVar6.a(zzbqf.zzax(c1111uh.f12582b));
                    while (b3 < i2) {
                        int a18 = C1097th.a(bArr, b3, c1111uh);
                        if (i3 != c1111uh.f12581a) {
                            return b3;
                        }
                        b3 = C1097th.b(bArr, a18, c1111uh);
                        _hVar6.a(zzbqf.zzax(c1111uh.f12582b));
                    }
                    return b3;
                }
                return i8;
            case 49:
                if (i5 == 3) {
                    InterfaceC1112ui a19 = a(i6);
                    int i29 = (i3 & (-8)) | 4;
                    i8 = a(a19, bArr, i, i2, i29, c1111uh);
                    zzbrkVar.add(c1111uh.f12583c);
                    while (i8 < i2) {
                        int a20 = C1097th.a(bArr, i8, c1111uh);
                        if (i3 == c1111uh.f12581a) {
                            i8 = a(a19, bArr, a20, i2, i29, c1111uh);
                            zzbrkVar.add(c1111uh.f12583c);
                        }
                    }
                }
                return i8;
            default:
                return i8;
        }
    }

    private final <K, V> int a(T t, byte[] bArr, int i, int i2, int i3, long j, C1111uh c1111uh) throws IOException {
        Unsafe unsafe = f12262b;
        Object b2 = b(i3);
        Object object = unsafe.getObject(t, j);
        if (this.s.b(object)) {
            Object d2 = this.s.d(b2);
            this.s.b(d2, object);
            unsafe.putObject(t, j, d2);
        }
        this.s.e(b2);
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0023. Please report as an issue. */
    private final int a(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, C1111uh c1111uh) throws IOException {
        int b2;
        Unsafe unsafe = f12262b;
        long j2 = this.f12263c[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(C1097th.c(bArr, i)));
                    b2 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return b2;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(C1097th.d(bArr, i)));
                    b2 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return b2;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    b2 = C1097th.b(bArr, i, c1111uh);
                    unsafe.putObject(t, j, Long.valueOf(c1111uh.f12582b));
                    unsafe.putInt(t, j2, i4);
                    return b2;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    b2 = C1097th.a(bArr, i, c1111uh);
                    unsafe.putObject(t, j, Integer.valueOf(c1111uh.f12581a));
                    unsafe.putInt(t, j2, i4);
                    return b2;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(C1097th.b(bArr, i)));
                    b2 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return b2;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(C1097th.a(bArr, i)));
                    b2 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return b2;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    b2 = C1097th.b(bArr, i, c1111uh);
                    unsafe.putObject(t, j, Boolean.valueOf(c1111uh.f12582b != 0));
                    unsafe.putInt(t, j2, i4);
                    return b2;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int a2 = C1097th.a(bArr, i, c1111uh);
                    int i9 = c1111uh.f12581a;
                    if (i9 == 0) {
                        unsafe.putObject(t, j, "");
                    } else {
                        if ((i6 & 536870912) != 0 && !Ri.a(bArr, a2, a2 + i9)) {
                            throw zzbrl.zzank();
                        }
                        unsafe.putObject(t, j, new String(bArr, a2, i9, zzbrf.UTF_8));
                        a2 += i9;
                    }
                    unsafe.putInt(t, j2, i4);
                    return a2;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int a3 = a(a(i8), bArr, i, i2, c1111uh);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, c1111uh.f12583c);
                    } else {
                        unsafe.putObject(t, j, zzbrf.zzb(object, c1111uh.f12583c));
                    }
                    unsafe.putInt(t, j2, i4);
                    return a3;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    b2 = C1097th.e(bArr, i, c1111uh);
                    unsafe.putObject(t, j, c1111uh.f12583c);
                    unsafe.putInt(t, j2, i4);
                    return b2;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int a4 = C1097th.a(bArr, i, c1111uh);
                    int i10 = c1111uh.f12581a;
                    zzbri c2 = c(i8);
                    if (c2 != null && !c2.zzcb(i10)) {
                        e(t).zzc(i3, Long.valueOf(i10));
                        return a4;
                    }
                    unsafe.putObject(t, j, Integer.valueOf(i10));
                    b2 = a4;
                    unsafe.putInt(t, j2, i4);
                    return b2;
                }
                return i;
            case 66:
                if (i5 == 0) {
                    b2 = C1097th.a(bArr, i, c1111uh);
                    unsafe.putObject(t, j, Integer.valueOf(zzbqf.zzeu(c1111uh.f12581a)));
                    unsafe.putInt(t, j2, i4);
                    return b2;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    b2 = C1097th.b(bArr, i, c1111uh);
                    unsafe.putObject(t, j, Long.valueOf(zzbqf.zzax(c1111uh.f12582b)));
                    unsafe.putInt(t, j2, i4);
                    return b2;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    b2 = a(a(i8), bArr, i, i2, (i3 & (-8)) | 4, c1111uh);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, c1111uh.f12583c);
                    } else {
                        unsafe.putObject(t, j, zzbrf.zzb(object2, c1111uh.f12583c));
                    }
                    unsafe.putInt(t, j2, i4);
                    return b2;
                }
                return i;
            default:
                return i;
        }
    }

    private final InterfaceC1112ui a(int i) {
        int i2 = (i / 3) << 1;
        InterfaceC1112ui interfaceC1112ui = (InterfaceC1112ui) this.f12264d[i2];
        if (interfaceC1112ui != null) {
            return interfaceC1112ui;
        }
        InterfaceC1112ui<T> a2 = C1057qi.a().a((Class) this.f12264d[i2 + 1]);
        this.f12264d[i2] = a2;
        return a2;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:90:0x0087. Please report as an issue. */
    private final int a(T t, byte[] bArr, int i, int i2, int i3, C1111uh c1111uh) throws IOException {
        int i4;
        int i5;
        Unsafe unsafe;
        int i6;
        int i7;
        T t2;
        int i8;
        int i9;
        int g2;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        C1111uh c1111uh2;
        C1111uh c1111uh3;
        int b2;
        int i16;
        int i17;
        C0973ki<T> c0973ki = this;
        T t3 = t;
        byte[] bArr2 = bArr;
        int i18 = i2;
        int i19 = i3;
        C1111uh c1111uh4 = c1111uh;
        Unsafe unsafe2 = f12262b;
        int i20 = i;
        int i21 = -1;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = -1;
        while (true) {
            if (i20 < i18) {
                int i26 = i20 + 1;
                byte b3 = bArr2[i20];
                if (b3 < 0) {
                    i9 = C1097th.a(b3, bArr2, i26, c1111uh4);
                    i8 = c1111uh4.f12581a;
                } else {
                    i8 = b3;
                    i9 = i26;
                }
                int i27 = i8 >>> 3;
                int i28 = i8 & 7;
                if (i27 > i21) {
                    g2 = c0973ki.a(i27, i22 / 3);
                } else {
                    g2 = c0973ki.g(i27);
                }
                int i29 = g2;
                if (i29 == -1) {
                    i10 = i27;
                    i7 = i9;
                    i4 = i24;
                    i5 = i25;
                    unsafe = unsafe2;
                    i6 = i19;
                    i11 = 0;
                    i12 = i8;
                } else {
                    int[] iArr = c0973ki.f12263c;
                    int i30 = iArr[i29 + 1];
                    int i31 = (i30 & 267386880) >>> 20;
                    int i32 = i8;
                    long j = i30 & 1048575;
                    if (i31 <= 17) {
                        int i33 = iArr[i29 + 2];
                        int i34 = 1 << (i33 >>> 20);
                        int i35 = i33 & 1048575;
                        if (i35 != i25) {
                            if (i25 != -1) {
                                unsafe2.putInt(t3, i25, i24);
                            }
                            i24 = unsafe2.getInt(t3, i35);
                            i25 = i35;
                        }
                        switch (i31) {
                            case 0:
                                c1111uh2 = c1111uh;
                                i13 = i29;
                                i10 = i27;
                                i15 = i32;
                                bArr2 = bArr;
                                i14 = i9;
                                if (i28 != 1) {
                                    i4 = i24;
                                    i5 = i25;
                                    i12 = i15;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i7 = i14;
                                    i6 = i3;
                                    break;
                                } else {
                                    Pi.a(t3, j, C1097th.c(bArr2, i14));
                                    i20 = i14 + 8;
                                    i24 |= i34;
                                    i18 = i2;
                                    i23 = i15;
                                    i22 = i13;
                                    c1111uh4 = c1111uh2;
                                    i21 = i10;
                                    i19 = i3;
                                }
                            case 1:
                                c1111uh2 = c1111uh;
                                i13 = i29;
                                i10 = i27;
                                i15 = i32;
                                bArr2 = bArr;
                                i14 = i9;
                                if (i28 != 5) {
                                    i4 = i24;
                                    i5 = i25;
                                    i12 = i15;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i7 = i14;
                                    i6 = i3;
                                    break;
                                } else {
                                    Pi.a((Object) t3, j, C1097th.d(bArr2, i14));
                                    i20 = i14 + 4;
                                    i24 |= i34;
                                    i18 = i2;
                                    i23 = i15;
                                    i22 = i13;
                                    c1111uh4 = c1111uh2;
                                    i21 = i10;
                                    i19 = i3;
                                }
                            case 2:
                            case 3:
                                c1111uh3 = c1111uh;
                                i13 = i29;
                                i10 = i27;
                                i15 = i32;
                                bArr2 = bArr;
                                i14 = i9;
                                if (i28 != 0) {
                                    i4 = i24;
                                    i5 = i25;
                                    i12 = i15;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i7 = i14;
                                    i6 = i3;
                                    break;
                                } else {
                                    b2 = C1097th.b(bArr2, i14, c1111uh3);
                                    unsafe2.putLong(t, j, c1111uh3.f12582b);
                                    i24 |= i34;
                                    i23 = i15;
                                    i22 = i13;
                                    c1111uh4 = c1111uh3;
                                    i20 = b2;
                                    i21 = i10;
                                    i18 = i2;
                                    i19 = i3;
                                }
                            case 4:
                            case 11:
                                c1111uh2 = c1111uh;
                                i13 = i29;
                                i10 = i27;
                                i15 = i32;
                                bArr2 = bArr;
                                i14 = i9;
                                if (i28 != 0) {
                                    i4 = i24;
                                    i5 = i25;
                                    i12 = i15;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i7 = i14;
                                    i6 = i3;
                                    break;
                                } else {
                                    i20 = C1097th.a(bArr2, i14, c1111uh2);
                                    unsafe2.putInt(t3, j, c1111uh2.f12581a);
                                    i24 |= i34;
                                    i18 = i2;
                                    i23 = i15;
                                    i22 = i13;
                                    c1111uh4 = c1111uh2;
                                    i21 = i10;
                                    i19 = i3;
                                }
                            case 5:
                            case 14:
                                c1111uh2 = c1111uh;
                                i13 = i29;
                                i10 = i27;
                                i15 = i32;
                                bArr2 = bArr;
                                if (i28 != 1) {
                                    i14 = i9;
                                    i4 = i24;
                                    i5 = i25;
                                    i12 = i15;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i7 = i14;
                                    i6 = i3;
                                    break;
                                } else {
                                    i14 = i9;
                                    unsafe2.putLong(t, j, C1097th.b(bArr2, i9));
                                    i20 = i14 + 8;
                                    i24 |= i34;
                                    i18 = i2;
                                    i23 = i15;
                                    i22 = i13;
                                    c1111uh4 = c1111uh2;
                                    i21 = i10;
                                    i19 = i3;
                                }
                            case 6:
                            case 13:
                                c1111uh2 = c1111uh;
                                i13 = i29;
                                i10 = i27;
                                i15 = i32;
                                bArr2 = bArr;
                                i18 = i2;
                                if (i28 != 5) {
                                    i14 = i9;
                                    i4 = i24;
                                    i5 = i25;
                                    i12 = i15;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i7 = i14;
                                    i6 = i3;
                                    break;
                                } else {
                                    unsafe2.putInt(t3, j, C1097th.a(bArr2, i9));
                                    i20 = i9 + 4;
                                    i24 |= i34;
                                    i23 = i15;
                                    i22 = i13;
                                    c1111uh4 = c1111uh2;
                                    i21 = i10;
                                    i19 = i3;
                                }
                            case 7:
                                c1111uh2 = c1111uh;
                                i13 = i29;
                                i10 = i27;
                                i15 = i32;
                                bArr2 = bArr;
                                i18 = i2;
                                if (i28 != 0) {
                                    i14 = i9;
                                    i4 = i24;
                                    i5 = i25;
                                    i12 = i15;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i7 = i14;
                                    i6 = i3;
                                    break;
                                } else {
                                    i20 = C1097th.b(bArr2, i9, c1111uh2);
                                    Pi.a(t3, j, c1111uh2.f12582b != 0);
                                    i24 |= i34;
                                    i23 = i15;
                                    i22 = i13;
                                    c1111uh4 = c1111uh2;
                                    i21 = i10;
                                    i19 = i3;
                                }
                            case 8:
                                c1111uh2 = c1111uh;
                                i13 = i29;
                                i10 = i27;
                                i15 = i32;
                                bArr2 = bArr;
                                i18 = i2;
                                if (i28 != 2) {
                                    i14 = i9;
                                    i4 = i24;
                                    i5 = i25;
                                    i12 = i15;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i7 = i14;
                                    i6 = i3;
                                    break;
                                } else {
                                    if ((i30 & 536870912) == 0) {
                                        i20 = C1097th.c(bArr2, i9, c1111uh2);
                                    } else {
                                        i20 = C1097th.d(bArr2, i9, c1111uh2);
                                    }
                                    unsafe2.putObject(t3, j, c1111uh2.f12583c);
                                    i24 |= i34;
                                    i23 = i15;
                                    i22 = i13;
                                    c1111uh4 = c1111uh2;
                                    i21 = i10;
                                    i19 = i3;
                                }
                            case 9:
                                c1111uh2 = c1111uh;
                                i13 = i29;
                                i10 = i27;
                                i15 = i32;
                                bArr2 = bArr;
                                if (i28 != 2) {
                                    i14 = i9;
                                    i4 = i24;
                                    i5 = i25;
                                    i12 = i15;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i7 = i14;
                                    i6 = i3;
                                    break;
                                } else {
                                    i18 = i2;
                                    i20 = a(c0973ki.a(i13), bArr2, i9, i18, c1111uh2);
                                    if ((i24 & i34) == 0) {
                                        unsafe2.putObject(t3, j, c1111uh2.f12583c);
                                    } else {
                                        unsafe2.putObject(t3, j, zzbrf.zzb(unsafe2.getObject(t3, j), c1111uh2.f12583c));
                                    }
                                    i24 |= i34;
                                    i23 = i15;
                                    i22 = i13;
                                    c1111uh4 = c1111uh2;
                                    i21 = i10;
                                    i19 = i3;
                                }
                            case 10:
                                c1111uh2 = c1111uh;
                                i13 = i29;
                                i10 = i27;
                                i15 = i32;
                                bArr2 = bArr;
                                if (i28 != 2) {
                                    i14 = i9;
                                    i4 = i24;
                                    i5 = i25;
                                    i12 = i15;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i7 = i14;
                                    i6 = i3;
                                    break;
                                } else {
                                    i20 = C1097th.e(bArr2, i9, c1111uh2);
                                    unsafe2.putObject(t3, j, c1111uh2.f12583c);
                                    i24 |= i34;
                                    i18 = i2;
                                    i23 = i15;
                                    i22 = i13;
                                    c1111uh4 = c1111uh2;
                                    i21 = i10;
                                    i19 = i3;
                                }
                            case 12:
                                c1111uh2 = c1111uh;
                                i13 = i29;
                                i10 = i27;
                                i15 = i32;
                                bArr2 = bArr;
                                if (i28 != 0) {
                                    i14 = i9;
                                    i4 = i24;
                                    i5 = i25;
                                    i12 = i15;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i7 = i14;
                                    i6 = i3;
                                    break;
                                } else {
                                    i20 = C1097th.a(bArr2, i9, c1111uh2);
                                    int i36 = c1111uh2.f12581a;
                                    zzbri c2 = c0973ki.c(i13);
                                    if (c2 != null && !c2.zzcb(i36)) {
                                        e(t).zzc(i15, Long.valueOf(i36));
                                        i18 = i2;
                                        i23 = i15;
                                        i22 = i13;
                                        c1111uh4 = c1111uh2;
                                        i21 = i10;
                                        i19 = i3;
                                    } else {
                                        unsafe2.putInt(t3, j, i36);
                                        i24 |= i34;
                                        i18 = i2;
                                        i23 = i15;
                                        i22 = i13;
                                        c1111uh4 = c1111uh2;
                                        i21 = i10;
                                        i19 = i3;
                                    }
                                }
                                break;
                            case 15:
                                c1111uh2 = c1111uh;
                                i13 = i29;
                                i10 = i27;
                                i15 = i32;
                                bArr2 = bArr;
                                if (i28 != 0) {
                                    i14 = i9;
                                    i4 = i24;
                                    i5 = i25;
                                    i12 = i15;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i7 = i14;
                                    i6 = i3;
                                    break;
                                } else {
                                    i20 = C1097th.a(bArr2, i9, c1111uh2);
                                    unsafe2.putInt(t3, j, zzbqf.zzeu(c1111uh2.f12581a));
                                    i24 |= i34;
                                    i18 = i2;
                                    i23 = i15;
                                    i22 = i13;
                                    c1111uh4 = c1111uh2;
                                    i21 = i10;
                                    i19 = i3;
                                }
                            case 16:
                                c1111uh3 = c1111uh;
                                i13 = i29;
                                i10 = i27;
                                i15 = i32;
                                if (i28 != 0) {
                                    i14 = i9;
                                    i4 = i24;
                                    i5 = i25;
                                    i12 = i15;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i7 = i14;
                                    i6 = i3;
                                    break;
                                } else {
                                    bArr2 = bArr;
                                    b2 = C1097th.b(bArr2, i9, c1111uh3);
                                    unsafe2.putLong(t, j, zzbqf.zzax(c1111uh3.f12582b));
                                    i24 |= i34;
                                    i23 = i15;
                                    i22 = i13;
                                    c1111uh4 = c1111uh3;
                                    i20 = b2;
                                    i21 = i10;
                                    i18 = i2;
                                    i19 = i3;
                                }
                            case 17:
                                if (i28 != 3) {
                                    i13 = i29;
                                    i10 = i27;
                                    i15 = i32;
                                    i14 = i9;
                                    i4 = i24;
                                    i5 = i25;
                                    i12 = i15;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i7 = i14;
                                    i6 = i3;
                                    break;
                                } else {
                                    i13 = i29;
                                    i10 = i27;
                                    i15 = i32;
                                    i20 = a(c0973ki.a(i29), bArr, i9, i2, (i27 << 3) | 4, c1111uh);
                                    if ((i24 & i34) == 0) {
                                        c1111uh2 = c1111uh;
                                        unsafe2.putObject(t3, j, c1111uh2.f12583c);
                                    } else {
                                        c1111uh2 = c1111uh;
                                        unsafe2.putObject(t3, j, zzbrf.zzb(unsafe2.getObject(t3, j), c1111uh2.f12583c));
                                    }
                                    i24 |= i34;
                                    bArr2 = bArr;
                                    i18 = i2;
                                    i23 = i15;
                                    i22 = i13;
                                    c1111uh4 = c1111uh2;
                                    i21 = i10;
                                    i19 = i3;
                                }
                            default:
                                i13 = i29;
                                i10 = i27;
                                i14 = i9;
                                i15 = i32;
                                i4 = i24;
                                i5 = i25;
                                i12 = i15;
                                i11 = i13;
                                unsafe = unsafe2;
                                i7 = i14;
                                i6 = i3;
                                break;
                        }
                    } else {
                        i10 = i27;
                        bArr2 = bArr;
                        int i37 = i9;
                        if (i31 != 27) {
                            i4 = i24;
                            if (i31 <= 49) {
                                i5 = i25;
                                i16 = i32;
                                i11 = i29;
                                unsafe = unsafe2;
                                i20 = a((C0973ki<T>) t, bArr, i37, i2, i32, i10, i28, i29, i30, i31, j, c1111uh);
                                if (i20 != i37) {
                                    c0973ki = this;
                                    t3 = t;
                                    bArr2 = bArr;
                                    i18 = i2;
                                    i19 = i3;
                                    c1111uh4 = c1111uh;
                                    i24 = i4;
                                    i21 = i10;
                                    i22 = i11;
                                    i25 = i5;
                                    i23 = i16;
                                }
                            } else {
                                i5 = i25;
                                i16 = i32;
                                i11 = i29;
                                unsafe = unsafe2;
                                i17 = i37;
                                if (i31 != 50) {
                                    i20 = a((C0973ki<T>) t, bArr, i17, i2, i16, i10, i28, i30, i31, j, i11, c1111uh);
                                    if (i20 != i17) {
                                        i12 = i16;
                                        c0973ki = this;
                                        t3 = t;
                                        bArr2 = bArr;
                                        i18 = i2;
                                        i19 = i3;
                                        c1111uh4 = c1111uh;
                                        i23 = i12;
                                        i24 = i4;
                                        i21 = i10;
                                        i22 = i11;
                                        i25 = i5;
                                    }
                                } else if (i28 == 2) {
                                    a((C0973ki<T>) t, bArr, i17, i2, i11, j, c1111uh);
                                    throw null;
                                }
                            }
                            i6 = i3;
                            i7 = i20;
                            i12 = i16;
                        } else if (i28 == 2) {
                            zzbrk zzbrkVar = (zzbrk) unsafe2.getObject(t3, j);
                            if (!zzbrkVar.zzaki()) {
                                int size = zzbrkVar.size();
                                zzbrkVar = zzbrkVar.zzel(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t3, j, zzbrkVar);
                            }
                            i20 = a((InterfaceC1112ui<?>) c0973ki.a(i29), i32, bArr, i37, i2, (zzbrk<?>) zzbrkVar, c1111uh);
                            i18 = i2;
                            i19 = i3;
                            i23 = i32;
                            i22 = i29;
                            i24 = i24;
                            i21 = i10;
                            c1111uh4 = c1111uh;
                        } else {
                            i4 = i24;
                            i5 = i25;
                            i16 = i32;
                            i11 = i29;
                            unsafe = unsafe2;
                            i17 = i37;
                        }
                        i6 = i3;
                        i7 = i17;
                        i12 = i16;
                    }
                    unsafe2 = unsafe;
                }
                if (i12 != i6 || i6 == 0) {
                    i20 = a(i12, bArr, i7, i2, t, c1111uh);
                    c0973ki = this;
                    t3 = t;
                    bArr2 = bArr;
                    i18 = i2;
                    c1111uh4 = c1111uh;
                    i19 = i6;
                    i23 = i12;
                    i24 = i4;
                    i21 = i10;
                    i22 = i11;
                    i25 = i5;
                    unsafe2 = unsafe;
                } else {
                    i23 = i12;
                }
            } else {
                i4 = i24;
                i5 = i25;
                unsafe = unsafe2;
                i6 = i19;
                i7 = i20;
            }
        }
        int i38 = i4;
        int i39 = i5;
        if (i39 != -1) {
            long j2 = i39;
            t2 = t;
            unsafe.putInt(t2, j2, i38);
        } else {
            t2 = t;
        }
        zzbtv zzbtvVar = null;
        for (int i40 = this.m; i40 < this.n; i40++) {
            a((Object) t2, this.l[i40], (int) zzbtvVar, (Li<UT, int>) this.q);
            zzbtvVar = zzbtvVar;
        }
        if (zzbtvVar != null) {
            this.q.b((Object) t2, (T) zzbtvVar);
        }
        if (i6 == 0) {
            if (i7 != i2) {
                throw zzbrl.zzanj();
            }
        } else if (i7 > i2 || i23 != i6) {
            throw zzbrl.zzanj();
        }
        return i7;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x022b, code lost:            if (r0 == r15) goto L103;     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01e1, code lost:            if (r0 == r15) goto L103;     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x022d, code lost:            r2 = r0;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0061. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13, types: [int] */
    @Override // com.google.android.gms.internal.ads.InterfaceC1112ui
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.ads.C1111uh r32) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 656
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C0973ki.a(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.uh):void");
    }

    private final <UT, UB> UB a(Object obj, int i, UB ub, Li<UT, UB> li) {
        zzbri c2;
        int i2 = this.f12263c[i];
        Object f2 = Pi.f(obj, d(i) & 1048575);
        if (f2 == null || (c2 = c(i)) == null) {
            return ub;
        }
        a(i, i2, this.s.h(f2), c2, (zzbri) ub, (Li<UT, zzbri>) li);
        throw null;
    }

    private final <K, V, UT, UB> UB a(int i, int i2, Map<K, V> map, zzbri zzbriVar, UB ub, Li<UT, UB> li) {
        this.s.e(b(i));
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a(Object obj, int i, InterfaceC1112ui interfaceC1112ui) {
        return interfaceC1112ui.b(Pi.f(obj, i & 1048575));
    }

    private static void a(int i, Object obj, Xi xi) throws IOException {
        if (obj instanceof String) {
            xi.a(i, (String) obj);
        } else {
            xi.a(i, (zzbpu) obj);
        }
    }

    private final void a(Object obj, int i, InterfaceC1098ti interfaceC1098ti) throws IOException {
        if (f(i)) {
            Pi.a(obj, i & 1048575, interfaceC1098ti.n());
        } else if (this.i) {
            Pi.a(obj, i & 1048575, interfaceC1098ti.readString());
        } else {
            Pi.a(obj, i & 1048575, interfaceC1098ti.p());
        }
    }

    private final boolean a(T t, int i, int i2, int i3) {
        if (this.j) {
            return a((C0973ki<T>) t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean a(T t, int i) {
        if (this.j) {
            int d2 = d(i);
            long j = d2 & 1048575;
            switch ((d2 & 267386880) >>> 20) {
                case 0:
                    return Pi.e(t, j) != 0.0d;
                case 1:
                    return Pi.d(t, j) != 0.0f;
                case 2:
                    return Pi.b(t, j) != 0;
                case 3:
                    return Pi.b(t, j) != 0;
                case 4:
                    return Pi.a(t, j) != 0;
                case 5:
                    return Pi.b(t, j) != 0;
                case 6:
                    return Pi.a(t, j) != 0;
                case 7:
                    return Pi.c(t, j);
                case 8:
                    Object f2 = Pi.f(t, j);
                    if (f2 instanceof String) {
                        return !((String) f2).isEmpty();
                    }
                    if (f2 instanceof zzbpu) {
                        return !zzbpu.zzfli.equals(f2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return Pi.f(t, j) != null;
                case 10:
                    return !zzbpu.zzfli.equals(Pi.f(t, j));
                case 11:
                    return Pi.a(t, j) != 0;
                case 12:
                    return Pi.a(t, j) != 0;
                case 13:
                    return Pi.a(t, j) != 0;
                case 14:
                    return Pi.b(t, j) != 0;
                case 15:
                    return Pi.a(t, j) != 0;
                case 16:
                    return Pi.b(t, j) != 0;
                case 17:
                    return Pi.f(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int e2 = e(i);
        return (Pi.a(t, (long) (e2 & 1048575)) & (1 << (e2 >>> 20))) != 0;
    }

    private final boolean a(T t, int i, int i2) {
        return Pi.a(t, (long) (e(i2) & 1048575)) == i;
    }

    private final int a(int i, int i2) {
        if (i < this.f12265e || i > this.f12266f) {
            return -1;
        }
        return b(i, i2);
    }
}

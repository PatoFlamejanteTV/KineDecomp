package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
final class Ta<T> implements InterfaceC1353cb<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f13388a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    private static final Unsafe f13389b = xb.d();

    /* renamed from: c, reason: collision with root package name */
    private final int[] f13390c;

    /* renamed from: d, reason: collision with root package name */
    private final Object[] f13391d;

    /* renamed from: e, reason: collision with root package name */
    private final int f13392e;

    /* renamed from: f, reason: collision with root package name */
    private final int f13393f;

    /* renamed from: g, reason: collision with root package name */
    private final zzvv f13394g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f13395h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final int[] l;
    private final int m;
    private final int n;
    private final Va o;
    private final Ea p;
    private final tb<?, ?> q;
    private final AbstractC1387ra<?> r;
    private final Na s;

    private Ta(int[] iArr, Object[] objArr, int i, int i2, zzvv zzvvVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, Va va, Ea ea, tb<?, ?> tbVar, AbstractC1387ra<?> abstractC1387ra, Na na) {
        this.f13390c = iArr;
        this.f13391d = objArr;
        this.f13392e = i;
        this.f13393f = i2;
        this.i = zzvvVar instanceof zzuo;
        this.j = z;
        this.f13395h = abstractC1387ra != null && abstractC1387ra.a(zzvvVar);
        this.k = false;
        this.l = iArr2;
        this.m = i3;
        this.n = i4;
        this.o = va;
        this.p = ea;
        this.q = tbVar;
        this.r = abstractC1387ra;
        this.f13394g = zzvvVar;
        this.s = na;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Ta<T> a(Class<T> cls, Qa qa, Va va, Ea ea, tb<?, ?> tbVar, AbstractC1387ra<?> abstractC1387ra, Na na) {
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
        char c4;
        char c5;
        int i15;
        int objectFieldOffset;
        String str;
        Class<?> cls2;
        int i16;
        int i17;
        int i18;
        int i19;
        Field a2;
        int i20;
        char charAt12;
        int i21;
        int i22;
        Field a3;
        Field a4;
        int i23;
        char charAt13;
        int i24;
        char charAt14;
        int i25;
        char charAt15;
        char charAt16;
        char charAt17;
        if (qa instanceof C1347ab) {
            C1347ab c1347ab = (C1347ab) qa;
            int i26 = 0;
            boolean z = c1347ab.c() == zzuo.zze.zzbyt;
            String d2 = c1347ab.d();
            int length = d2.length();
            int charAt18 = d2.charAt(0);
            if (charAt18 >= 55296) {
                int i27 = charAt18 & 8191;
                int i28 = 1;
                int i29 = 13;
                while (true) {
                    i = i28 + 1;
                    charAt17 = d2.charAt(i28);
                    if (charAt17 < 55296) {
                        break;
                    }
                    i27 |= (charAt17 & 8191) << i29;
                    i29 += 13;
                    i28 = i;
                }
                charAt18 = (charAt17 << i29) | i27;
            } else {
                i = 1;
            }
            int i30 = i + 1;
            int charAt19 = d2.charAt(i);
            if (charAt19 >= 55296) {
                int i31 = charAt19 & 8191;
                int i32 = 13;
                while (true) {
                    i2 = i30 + 1;
                    charAt16 = d2.charAt(i30);
                    if (charAt16 < 55296) {
                        break;
                    }
                    i31 |= (charAt16 & 8191) << i32;
                    i32 += 13;
                    i30 = i2;
                }
                charAt19 = i31 | (charAt16 << i32);
            } else {
                i2 = i30;
            }
            if (charAt19 == 0) {
                iArr = f13388a;
                charAt3 = 0;
                c3 = 0;
                i8 = 0;
                charAt = 0;
                charAt2 = 0;
                c2 = 0;
            } else {
                int i33 = i2 + 1;
                char charAt20 = d2.charAt(i2);
                if (charAt20 >= 55296) {
                    int i34 = charAt20 & 8191;
                    int i35 = 13;
                    while (true) {
                        i3 = i33 + 1;
                        charAt11 = d2.charAt(i33);
                        if (charAt11 < 55296) {
                            break;
                        }
                        i34 |= (charAt11 & 8191) << i35;
                        i35 += 13;
                        i33 = i3;
                    }
                    charAt20 = ((charAt11 << i35) | i34) == true ? 1 : 0;
                } else {
                    i3 = i33;
                }
                int i36 = i3 + 1;
                int charAt21 = d2.charAt(i3);
                if (charAt21 >= 55296) {
                    int i37 = charAt21 & 8191;
                    int i38 = 13;
                    while (true) {
                        i4 = i36 + 1;
                        charAt10 = d2.charAt(i36);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i37 |= (charAt10 & 8191) << i38;
                        i38 += 13;
                        i36 = i4;
                    }
                    charAt21 = i37 | (charAt10 << i38);
                } else {
                    i4 = i36;
                }
                int i39 = i4 + 1;
                char charAt22 = d2.charAt(i4);
                if (charAt22 >= 55296) {
                    int i40 = charAt22 & 8191;
                    int i41 = 13;
                    while (true) {
                        i5 = i39 + 1;
                        charAt9 = d2.charAt(i39);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i40 |= (charAt9 & 8191) << i41;
                        i41 += 13;
                        i39 = i5;
                    }
                    charAt22 = ((charAt9 << i41) | i40) == true ? 1 : 0;
                } else {
                    i5 = i39;
                }
                int i42 = i5 + 1;
                charAt = d2.charAt(i5);
                if (charAt >= 55296) {
                    int i43 = charAt & 8191;
                    int i44 = 13;
                    while (true) {
                        i6 = i42 + 1;
                        charAt8 = d2.charAt(i42);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i43 |= (charAt8 & 8191) << i44;
                        i44 += 13;
                        i42 = i6;
                    }
                    charAt = ((charAt8 << i44) | i43) == true ? 1 : 0;
                } else {
                    i6 = i42;
                }
                int i45 = i6 + 1;
                charAt2 = d2.charAt(i6);
                if (charAt2 >= 55296) {
                    int i46 = charAt2 & 8191;
                    int i47 = 13;
                    while (true) {
                        i12 = i45 + 1;
                        charAt7 = d2.charAt(i45);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i46 |= (charAt7 & 8191) << i47;
                        i47 += 13;
                        i45 = i12;
                    }
                    charAt2 = (charAt7 << i47) | i46;
                    i45 = i12;
                }
                int i48 = i45 + 1;
                charAt3 = d2.charAt(i45);
                if (charAt3 >= 55296) {
                    int i49 = charAt3 & 8191;
                    int i50 = 13;
                    while (true) {
                        i11 = i48 + 1;
                        charAt6 = d2.charAt(i48);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i49 |= (charAt6 & 8191) << i50;
                        i50 += 13;
                        i48 = i11;
                    }
                    charAt3 = i49 | (charAt6 << i50);
                    i48 = i11;
                }
                int i51 = i48 + 1;
                int charAt23 = d2.charAt(i48);
                if (charAt23 >= 55296) {
                    int i52 = 13;
                    int i53 = charAt23 & 8191;
                    int i54 = i51;
                    while (true) {
                        i10 = i54 + 1;
                        charAt5 = d2.charAt(i54);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i53 |= (charAt5 & 8191) << i52;
                        i52 += 13;
                        i54 = i10;
                    }
                    charAt23 = i53 | (charAt5 << i52);
                    i7 = i10;
                } else {
                    i7 = i51;
                }
                int i55 = i7 + 1;
                i26 = d2.charAt(i7);
                if (i26 >= 55296) {
                    int i56 = 13;
                    int i57 = i26 & 8191;
                    int i58 = i55;
                    while (true) {
                        i9 = i58 + 1;
                        charAt4 = d2.charAt(i58);
                        if (charAt4 < 55296) {
                            break;
                        }
                        i57 |= (charAt4 & 8191) << i56;
                        i56 += 13;
                        i58 = i9;
                    }
                    i26 = i57 | (charAt4 << i56);
                    i55 = i9;
                }
                iArr = new int[i26 + charAt3 + charAt23];
                i8 = (charAt20 << 1) + charAt21;
                int i59 = i55;
                c2 = charAt20;
                c3 = charAt22;
                i2 = i59;
            }
            Unsafe unsafe = f13389b;
            Object[] e2 = c1347ab.e();
            Class<?> cls3 = c1347ab.a().getClass();
            int i60 = i8;
            int[] iArr2 = new int[charAt2 * 3];
            Object[] objArr = new Object[charAt2 << 1];
            int i61 = i26 + charAt3;
            int i62 = i26;
            int i63 = i61;
            int i64 = 0;
            int i65 = 0;
            while (i2 < length) {
                int i66 = i2 + 1;
                int charAt24 = d2.charAt(i2);
                char c6 = 55296;
                if (charAt24 >= 55296) {
                    int i67 = 13;
                    int i68 = charAt24 & 8191;
                    int i69 = i66;
                    while (true) {
                        i25 = i69 + 1;
                        charAt15 = d2.charAt(i69);
                        if (charAt15 < c6) {
                            break;
                        }
                        i68 |= (charAt15 & 8191) << i67;
                        i67 += 13;
                        i69 = i25;
                        c6 = 55296;
                    }
                    charAt24 = i68 | (charAt15 << i67);
                    i13 = i25;
                } else {
                    i13 = i66;
                }
                int i70 = i13 + 1;
                int charAt25 = d2.charAt(i13);
                int i71 = length;
                char c7 = 55296;
                if (charAt25 >= 55296) {
                    int i72 = 13;
                    int i73 = charAt25 & 8191;
                    int i74 = i70;
                    while (true) {
                        i24 = i74 + 1;
                        charAt14 = d2.charAt(i74);
                        if (charAt14 < c7) {
                            break;
                        }
                        i73 |= (charAt14 & 8191) << i72;
                        i72 += 13;
                        i74 = i24;
                        c7 = 55296;
                    }
                    charAt25 = i73 | (charAt14 << i72);
                    i14 = i24;
                } else {
                    i14 = i70;
                }
                int i75 = i26;
                int i76 = charAt25 & 255;
                boolean z2 = z;
                if ((charAt25 & 1024) != 0) {
                    iArr[i64] = i65;
                    i64++;
                }
                int i77 = i64;
                if (i76 >= 51) {
                    int i78 = i14 + 1;
                    int charAt26 = d2.charAt(i14);
                    char c8 = 55296;
                    if (charAt26 >= 55296) {
                        int i79 = charAt26 & 8191;
                        int i80 = 13;
                        while (true) {
                            i23 = i78 + 1;
                            charAt13 = d2.charAt(i78);
                            if (charAt13 < c8) {
                                break;
                            }
                            i79 |= (charAt13 & 8191) << i80;
                            i80 += 13;
                            i78 = i23;
                            c8 = 55296;
                        }
                        charAt26 = i79 | (charAt13 << i80);
                        i78 = i23;
                    }
                    int i81 = i76 - 51;
                    int i82 = i78;
                    if (i81 == 9 || i81 == 17) {
                        i22 = 1;
                        objArr[((i65 / 3) << 1) + 1] = e2[i60];
                        i60++;
                    } else {
                        if (i81 == 12 && (charAt18 & 1) == 1) {
                            objArr[((i65 / 3) << 1) + 1] = e2[i60];
                            i60++;
                        }
                        i22 = 1;
                    }
                    int i83 = charAt26 << i22;
                    Object obj = e2[i83];
                    if (obj instanceof Field) {
                        a3 = (Field) obj;
                    } else {
                        a3 = a(cls3, (String) obj);
                        e2[i83] = a3;
                    }
                    char c9 = c3;
                    int objectFieldOffset2 = (int) unsafe.objectFieldOffset(a3);
                    int i84 = i83 + 1;
                    Object obj2 = e2[i84];
                    if (obj2 instanceof Field) {
                        a4 = (Field) obj2;
                    } else {
                        a4 = a(cls3, (String) obj2);
                        e2[i84] = a4;
                    }
                    str = d2;
                    i19 = (int) unsafe.objectFieldOffset(a4);
                    cls2 = cls3;
                    i16 = i60;
                    objectFieldOffset = objectFieldOffset2;
                    i18 = 0;
                    c5 = c9;
                    c4 = charAt;
                    i15 = charAt24;
                    i2 = i82;
                } else {
                    char c10 = c3;
                    int i85 = i60 + 1;
                    Field a5 = a(cls3, (String) e2[i60]);
                    c4 = charAt;
                    if (i76 == 9 || i76 == 17) {
                        c5 = c10;
                        objArr[((i65 / 3) << 1) + 1] = a5.getType();
                    } else {
                        if (i76 == 27 || i76 == 49) {
                            c5 = c10;
                            i21 = i85 + 1;
                            objArr[((i65 / 3) << 1) + 1] = e2[i85];
                        } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                            c5 = c10;
                            if ((charAt18 & 1) == 1) {
                                i21 = i85 + 1;
                                objArr[((i65 / 3) << 1) + 1] = e2[i85];
                            }
                        } else if (i76 == 50) {
                            int i86 = i62 + 1;
                            iArr[i62] = i65;
                            int i87 = (i65 / 3) << 1;
                            int i88 = i85 + 1;
                            objArr[i87] = e2[i85];
                            if ((charAt25 & 2048) != 0) {
                                i85 = i88 + 1;
                                objArr[i87 + 1] = e2[i88];
                                c5 = c10;
                                i62 = i86;
                            } else {
                                i62 = i86;
                                i85 = i88;
                                c5 = c10;
                            }
                        } else {
                            c5 = c10;
                        }
                        i15 = charAt24;
                        i85 = i21;
                        objectFieldOffset = (int) unsafe.objectFieldOffset(a5);
                        if ((charAt18 & 1) == 1 || i76 > 17) {
                            str = d2;
                            cls2 = cls3;
                            i16 = i85;
                            i17 = i14;
                            i18 = 0;
                            i19 = 0;
                        } else {
                            i17 = i14 + 1;
                            int charAt27 = d2.charAt(i14);
                            if (charAt27 >= 55296) {
                                int i89 = charAt27 & 8191;
                                int i90 = 13;
                                while (true) {
                                    i20 = i17 + 1;
                                    charAt12 = d2.charAt(i17);
                                    if (charAt12 < 55296) {
                                        break;
                                    }
                                    i89 |= (charAt12 & 8191) << i90;
                                    i90 += 13;
                                    i17 = i20;
                                }
                                charAt27 = i89 | (charAt12 << i90);
                                i17 = i20;
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
                            i16 = i85;
                            i19 = (int) unsafe.objectFieldOffset(a2);
                            i18 = charAt27 % 32;
                        }
                        if (i76 >= 18 && i76 <= 49) {
                            iArr[i63] = objectFieldOffset;
                            i63++;
                        }
                        i2 = i17;
                    }
                    i15 = charAt24;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(a5);
                    if ((charAt18 & 1) == 1) {
                    }
                    str = d2;
                    cls2 = cls3;
                    i16 = i85;
                    i17 = i14;
                    i18 = 0;
                    i19 = 0;
                    if (i76 >= 18) {
                        iArr[i63] = objectFieldOffset;
                        i63++;
                    }
                    i2 = i17;
                }
                int i92 = i65 + 1;
                iArr2[i65] = i15;
                int i93 = i92 + 1;
                iArr2[i92] = (i76 << 20) | ((charAt25 & 256) != 0 ? 268435456 : 0) | ((charAt25 & 512) != 0 ? 536870912 : 0) | objectFieldOffset;
                i65 = i93 + 1;
                iArr2[i93] = (i18 << 20) | i19;
                cls3 = cls2;
                charAt = c4;
                i26 = i75;
                i60 = i16;
                length = i71;
                z = z2;
                c3 = c5;
                i64 = i77;
                d2 = str;
            }
            return new Ta<>(iArr2, objArr, c3, charAt, c1347ab.a(), z, false, iArr, i26, i61, va, ea, tbVar, abstractC1387ra, na);
        }
        ((pb) qa).c();
        throw null;
    }

    private final int e(int i) {
        return this.f13390c[i + 2];
    }

    private static boolean f(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> boolean f(T t, long j) {
        return ((Boolean) xb.f(t, j)).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1353cb
    public final void b(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.f13390c.length; i += 3) {
                int d2 = d(i);
                long j = 1048575 & d2;
                int i2 = this.f13390c[i];
                switch ((d2 & 267386880) >>> 20) {
                    case 0:
                        if (a((Ta<T>) t2, i)) {
                            xb.a(t, j, xb.e(t2, j));
                            b((Ta<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (a((Ta<T>) t2, i)) {
                            xb.a((Object) t, j, xb.d(t2, j));
                            b((Ta<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (a((Ta<T>) t2, i)) {
                            xb.a((Object) t, j, xb.b(t2, j));
                            b((Ta<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (a((Ta<T>) t2, i)) {
                            xb.a((Object) t, j, xb.b(t2, j));
                            b((Ta<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (a((Ta<T>) t2, i)) {
                            xb.a((Object) t, j, xb.a(t2, j));
                            b((Ta<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (a((Ta<T>) t2, i)) {
                            xb.a((Object) t, j, xb.b(t2, j));
                            b((Ta<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (a((Ta<T>) t2, i)) {
                            xb.a((Object) t, j, xb.a(t2, j));
                            b((Ta<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (a((Ta<T>) t2, i)) {
                            xb.a(t, j, xb.c(t2, j));
                            b((Ta<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (a((Ta<T>) t2, i)) {
                            xb.a(t, j, xb.f(t2, j));
                            b((Ta<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        a(t, t2, i);
                        break;
                    case 10:
                        if (a((Ta<T>) t2, i)) {
                            xb.a(t, j, xb.f(t2, j));
                            b((Ta<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (a((Ta<T>) t2, i)) {
                            xb.a((Object) t, j, xb.a(t2, j));
                            b((Ta<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (a((Ta<T>) t2, i)) {
                            xb.a((Object) t, j, xb.a(t2, j));
                            b((Ta<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (a((Ta<T>) t2, i)) {
                            xb.a((Object) t, j, xb.a(t2, j));
                            b((Ta<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (a((Ta<T>) t2, i)) {
                            xb.a((Object) t, j, xb.b(t2, j));
                            b((Ta<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (a((Ta<T>) t2, i)) {
                            xb.a((Object) t, j, xb.a(t2, j));
                            b((Ta<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (a((Ta<T>) t2, i)) {
                            xb.a((Object) t, j, xb.b(t2, j));
                            b((Ta<T>) t, i);
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
                        C1359eb.a(this.s, t, t2, j);
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
                        if (a((Ta<T>) t2, i2, i)) {
                            xb.a(t, j, xb.f(t2, j));
                            b((Ta<T>) t, i2, i);
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
                        if (a((Ta<T>) t2, i2, i)) {
                            xb.a(t, j, xb.f(t2, j));
                            b((Ta<T>) t, i2, i);
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
            C1359eb.a(this.q, t, t2);
            if (this.f13395h) {
                C1359eb.a(this.r, t, t2);
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0042. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:299:0x0548. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.InterfaceC1353cb
    public final int c(T t) {
        int i;
        int i2;
        long j;
        int zzd;
        int zzc;
        int zzl;
        int g2;
        int zzbd;
        int zzbf;
        int zzb;
        int g3;
        int zzbd2;
        int zzbf2;
        int i3 = 267386880;
        if (this.j) {
            Unsafe unsafe = f13389b;
            int i4 = 0;
            int i5 = 0;
            while (i4 < this.f13390c.length) {
                int d2 = d(i4);
                int i6 = (d2 & i3) >>> 20;
                int i7 = this.f13390c[i4];
                long j2 = d2 & 1048575;
                int i8 = (i6 < zzui.DOUBLE_LIST_PACKED.id() || i6 > zzui.SINT64_LIST_PACKED.id()) ? 0 : this.f13390c[i4 + 2] & 1048575;
                switch (i6) {
                    case 0:
                        if (a((Ta<T>) t, i4)) {
                            zzb = zztv.zzb(i7, 0.0d);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (a((Ta<T>) t, i4)) {
                            zzb = zztv.zzb(i7, 0.0f);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (a((Ta<T>) t, i4)) {
                            zzb = zztv.zzd(i7, xb.b(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (a((Ta<T>) t, i4)) {
                            zzb = zztv.zze(i7, xb.b(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (a((Ta<T>) t, i4)) {
                            zzb = zztv.zzh(i7, xb.a(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (a((Ta<T>) t, i4)) {
                            zzb = zztv.zzg(i7, 0L);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (a((Ta<T>) t, i4)) {
                            zzb = zztv.zzk(i7, 0);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (a((Ta<T>) t, i4)) {
                            zzb = zztv.zzc(i7, true);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (a((Ta<T>) t, i4)) {
                            Object f2 = xb.f(t, j2);
                            if (f2 instanceof zzte) {
                                zzb = zztv.zzc(i7, (zzte) f2);
                            } else {
                                zzb = zztv.zzc(i7, (String) f2);
                            }
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (a((Ta<T>) t, i4)) {
                            zzb = C1359eb.a(i7, xb.f(t, j2), a(i4));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (a((Ta<T>) t, i4)) {
                            zzb = zztv.zzc(i7, (zzte) xb.f(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (a((Ta<T>) t, i4)) {
                            zzb = zztv.zzi(i7, xb.a(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (a((Ta<T>) t, i4)) {
                            zzb = zztv.zzm(i7, xb.a(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (a((Ta<T>) t, i4)) {
                            zzb = zztv.zzl(i7, 0);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (a((Ta<T>) t, i4)) {
                            zzb = zztv.zzh(i7, 0L);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (a((Ta<T>) t, i4)) {
                            zzb = zztv.zzj(i7, xb.a(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (a((Ta<T>) t, i4)) {
                            zzb = zztv.zzf(i7, xb.b(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (a((Ta<T>) t, i4)) {
                            zzb = zztv.zzc(i7, (zzvv) xb.f(t, j2), a(i4));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzb = C1359eb.i(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 19:
                        zzb = C1359eb.h(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 20:
                        zzb = C1359eb.a(i7, (List<Long>) a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 21:
                        zzb = C1359eb.b(i7, (List<Long>) a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 22:
                        zzb = C1359eb.e(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 23:
                        zzb = C1359eb.i(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 24:
                        zzb = C1359eb.h(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 25:
                        zzb = C1359eb.j(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 26:
                        zzb = C1359eb.a(i7, (List<?>) a(t, j2));
                        i5 += zzb;
                        break;
                    case 27:
                        zzb = C1359eb.a(i7, (List<?>) a(t, j2), a(i4));
                        i5 += zzb;
                        break;
                    case 28:
                        zzb = C1359eb.b(i7, a(t, j2));
                        i5 += zzb;
                        break;
                    case 29:
                        zzb = C1359eb.f(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 30:
                        zzb = C1359eb.d(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 31:
                        zzb = C1359eb.h(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 32:
                        zzb = C1359eb.i(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 33:
                        zzb = C1359eb.g(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 34:
                        zzb = C1359eb.c(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 35:
                        g3 = C1359eb.g((List) unsafe.getObject(t, j2));
                        if (g3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, g3);
                            }
                            zzbd2 = zztv.zzbd(i7);
                            zzbf2 = zztv.zzbf(g3);
                            zzb = zzbd2 + zzbf2 + g3;
                            i5 += zzb;
                            break;
                        }
                    case 36:
                        g3 = C1359eb.f((List) unsafe.getObject(t, j2));
                        if (g3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, g3);
                            }
                            zzbd2 = zztv.zzbd(i7);
                            zzbf2 = zztv.zzbf(g3);
                            zzb = zzbd2 + zzbf2 + g3;
                            i5 += zzb;
                            break;
                        }
                    case 37:
                        g3 = C1359eb.i((List) unsafe.getObject(t, j2));
                        if (g3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, g3);
                            }
                            zzbd2 = zztv.zzbd(i7);
                            zzbf2 = zztv.zzbf(g3);
                            zzb = zzbd2 + zzbf2 + g3;
                            i5 += zzb;
                            break;
                        }
                    case 38:
                        g3 = C1359eb.j((List) unsafe.getObject(t, j2));
                        if (g3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, g3);
                            }
                            zzbd2 = zztv.zzbd(i7);
                            zzbf2 = zztv.zzbf(g3);
                            zzb = zzbd2 + zzbf2 + g3;
                            i5 += zzb;
                            break;
                        }
                    case 39:
                        g3 = C1359eb.c((List) unsafe.getObject(t, j2));
                        if (g3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, g3);
                            }
                            zzbd2 = zztv.zzbd(i7);
                            zzbf2 = zztv.zzbf(g3);
                            zzb = zzbd2 + zzbf2 + g3;
                            i5 += zzb;
                            break;
                        }
                    case 40:
                        g3 = C1359eb.g((List) unsafe.getObject(t, j2));
                        if (g3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, g3);
                            }
                            zzbd2 = zztv.zzbd(i7);
                            zzbf2 = zztv.zzbf(g3);
                            zzb = zzbd2 + zzbf2 + g3;
                            i5 += zzb;
                            break;
                        }
                    case 41:
                        g3 = C1359eb.f((List) unsafe.getObject(t, j2));
                        if (g3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, g3);
                            }
                            zzbd2 = zztv.zzbd(i7);
                            zzbf2 = zztv.zzbf(g3);
                            zzb = zzbd2 + zzbf2 + g3;
                            i5 += zzb;
                            break;
                        }
                    case 42:
                        g3 = C1359eb.h((List) unsafe.getObject(t, j2));
                        if (g3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, g3);
                            }
                            zzbd2 = zztv.zzbd(i7);
                            zzbf2 = zztv.zzbf(g3);
                            zzb = zzbd2 + zzbf2 + g3;
                            i5 += zzb;
                            break;
                        }
                    case 43:
                        g3 = C1359eb.d((List) unsafe.getObject(t, j2));
                        if (g3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, g3);
                            }
                            zzbd2 = zztv.zzbd(i7);
                            zzbf2 = zztv.zzbf(g3);
                            zzb = zzbd2 + zzbf2 + g3;
                            i5 += zzb;
                            break;
                        }
                    case 44:
                        g3 = C1359eb.b((List) unsafe.getObject(t, j2));
                        if (g3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, g3);
                            }
                            zzbd2 = zztv.zzbd(i7);
                            zzbf2 = zztv.zzbf(g3);
                            zzb = zzbd2 + zzbf2 + g3;
                            i5 += zzb;
                            break;
                        }
                    case 45:
                        g3 = C1359eb.f((List) unsafe.getObject(t, j2));
                        if (g3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, g3);
                            }
                            zzbd2 = zztv.zzbd(i7);
                            zzbf2 = zztv.zzbf(g3);
                            zzb = zzbd2 + zzbf2 + g3;
                            i5 += zzb;
                            break;
                        }
                    case 46:
                        g3 = C1359eb.g((List) unsafe.getObject(t, j2));
                        if (g3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, g3);
                            }
                            zzbd2 = zztv.zzbd(i7);
                            zzbf2 = zztv.zzbf(g3);
                            zzb = zzbd2 + zzbf2 + g3;
                            i5 += zzb;
                            break;
                        }
                    case 47:
                        g3 = C1359eb.e((List) unsafe.getObject(t, j2));
                        if (g3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, g3);
                            }
                            zzbd2 = zztv.zzbd(i7);
                            zzbf2 = zztv.zzbf(g3);
                            zzb = zzbd2 + zzbf2 + g3;
                            i5 += zzb;
                            break;
                        }
                    case 48:
                        g3 = C1359eb.a((List<Long>) unsafe.getObject(t, j2));
                        if (g3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, g3);
                            }
                            zzbd2 = zztv.zzbd(i7);
                            zzbf2 = zztv.zzbf(g3);
                            zzb = zzbd2 + zzbf2 + g3;
                            i5 += zzb;
                            break;
                        }
                    case 49:
                        zzb = C1359eb.b(i7, (List<zzvv>) a(t, j2), a(i4));
                        i5 += zzb;
                        break;
                    case 50:
                        zzb = this.s.a(i7, xb.f(t, j2), b(i4));
                        i5 += zzb;
                        break;
                    case 51:
                        if (a((Ta<T>) t, i7, i4)) {
                            zzb = zztv.zzb(i7, 0.0d);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (a((Ta<T>) t, i7, i4)) {
                            zzb = zztv.zzb(i7, 0.0f);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (a((Ta<T>) t, i7, i4)) {
                            zzb = zztv.zzd(i7, e(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (a((Ta<T>) t, i7, i4)) {
                            zzb = zztv.zze(i7, e(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (a((Ta<T>) t, i7, i4)) {
                            zzb = zztv.zzh(i7, d(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (a((Ta<T>) t, i7, i4)) {
                            zzb = zztv.zzg(i7, 0L);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (a((Ta<T>) t, i7, i4)) {
                            zzb = zztv.zzk(i7, 0);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (a((Ta<T>) t, i7, i4)) {
                            zzb = zztv.zzc(i7, true);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (a((Ta<T>) t, i7, i4)) {
                            Object f3 = xb.f(t, j2);
                            if (f3 instanceof zzte) {
                                zzb = zztv.zzc(i7, (zzte) f3);
                            } else {
                                zzb = zztv.zzc(i7, (String) f3);
                            }
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (a((Ta<T>) t, i7, i4)) {
                            zzb = C1359eb.a(i7, xb.f(t, j2), a(i4));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (a((Ta<T>) t, i7, i4)) {
                            zzb = zztv.zzc(i7, (zzte) xb.f(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (a((Ta<T>) t, i7, i4)) {
                            zzb = zztv.zzi(i7, d(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (a((Ta<T>) t, i7, i4)) {
                            zzb = zztv.zzm(i7, d(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (a((Ta<T>) t, i7, i4)) {
                            zzb = zztv.zzl(i7, 0);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (a((Ta<T>) t, i7, i4)) {
                            zzb = zztv.zzh(i7, 0L);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (a((Ta<T>) t, i7, i4)) {
                            zzb = zztv.zzj(i7, d(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (a((Ta<T>) t, i7, i4)) {
                            zzb = zztv.zzf(i7, e(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (a((Ta<T>) t, i7, i4)) {
                            zzb = zztv.zzc(i7, (zzvv) xb.f(t, j2), a(i4));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                }
                i4 += 3;
                i3 = 267386880;
            }
            return i5 + a((tb) this.q, (Object) t);
        }
        Unsafe unsafe2 = f13389b;
        int i9 = 0;
        int i10 = -1;
        int i11 = 0;
        for (int i12 = 0; i12 < this.f13390c.length; i12 += 3) {
            int d3 = d(i12);
            int[] iArr = this.f13390c;
            int i13 = iArr[i12];
            int i14 = (d3 & 267386880) >>> 20;
            if (i14 <= 17) {
                i = iArr[i12 + 2];
                int i15 = i & 1048575;
                i2 = 1 << (i >>> 20);
                if (i15 != i10) {
                    i11 = unsafe2.getInt(t, i15);
                } else {
                    i15 = i10;
                }
                i10 = i15;
            } else {
                i = (!this.k || i14 < zzui.DOUBLE_LIST_PACKED.id() || i14 > zzui.SINT64_LIST_PACKED.id()) ? 0 : this.f13390c[i12 + 2] & 1048575;
                i2 = 0;
            }
            long j3 = d3 & 1048575;
            switch (i14) {
                case 0:
                    j = 0;
                    if ((i11 & i2) != 0) {
                        i9 += zztv.zzb(i13, 0.0d);
                        break;
                    }
                    break;
                case 1:
                    j = 0;
                    if ((i11 & i2) != 0) {
                        i9 += zztv.zzb(i13, 0.0f);
                        break;
                    }
                case 2:
                    j = 0;
                    if ((i11 & i2) != 0) {
                        zzd = zztv.zzd(i13, unsafe2.getLong(t, j3));
                        i9 += zzd;
                    }
                    break;
                case 3:
                    j = 0;
                    if ((i11 & i2) != 0) {
                        zzd = zztv.zze(i13, unsafe2.getLong(t, j3));
                        i9 += zzd;
                    }
                    break;
                case 4:
                    j = 0;
                    if ((i11 & i2) != 0) {
                        zzd = zztv.zzh(i13, unsafe2.getInt(t, j3));
                        i9 += zzd;
                    }
                    break;
                case 5:
                    if ((i11 & i2) != 0) {
                        j = 0;
                        zzd = zztv.zzg(i13, 0L);
                        i9 += zzd;
                        break;
                    } else {
                        j = 0;
                    }
                case 6:
                    if ((i11 & i2) != 0) {
                        i9 += zztv.zzk(i13, 0);
                        j = 0;
                        break;
                    }
                    j = 0;
                case 7:
                    if ((i11 & i2) != 0) {
                        zzc = zztv.zzc(i13, true);
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 8:
                    if ((i11 & i2) != 0) {
                        Object object = unsafe2.getObject(t, j3);
                        if (object instanceof zzte) {
                            zzc = zztv.zzc(i13, (zzte) object);
                        } else {
                            zzc = zztv.zzc(i13, (String) object);
                        }
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 9:
                    if ((i11 & i2) != 0) {
                        zzc = C1359eb.a(i13, unsafe2.getObject(t, j3), a(i12));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 10:
                    if ((i11 & i2) != 0) {
                        zzc = zztv.zzc(i13, (zzte) unsafe2.getObject(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 11:
                    if ((i11 & i2) != 0) {
                        zzc = zztv.zzi(i13, unsafe2.getInt(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 12:
                    if ((i11 & i2) != 0) {
                        zzc = zztv.zzm(i13, unsafe2.getInt(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 13:
                    if ((i11 & i2) != 0) {
                        zzl = zztv.zzl(i13, 0);
                        i9 += zzl;
                    }
                    j = 0;
                    break;
                case 14:
                    if ((i11 & i2) != 0) {
                        zzc = zztv.zzh(i13, 0L);
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 15:
                    if ((i11 & i2) != 0) {
                        zzc = zztv.zzj(i13, unsafe2.getInt(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 16:
                    if ((i11 & i2) != 0) {
                        zzc = zztv.zzf(i13, unsafe2.getLong(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 17:
                    if ((i11 & i2) != 0) {
                        zzc = zztv.zzc(i13, (zzvv) unsafe2.getObject(t, j3), a(i12));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 18:
                    zzc = C1359eb.i(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 19:
                    zzc = C1359eb.h(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 20:
                    zzc = C1359eb.a(i13, (List<Long>) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 21:
                    zzc = C1359eb.b(i13, (List<Long>) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 22:
                    zzc = C1359eb.e(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 23:
                    zzc = C1359eb.i(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 24:
                    zzc = C1359eb.h(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 25:
                    zzc = C1359eb.j(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 26:
                    zzc = C1359eb.a(i13, (List<?>) unsafe2.getObject(t, j3));
                    i9 += zzc;
                    j = 0;
                    break;
                case 27:
                    zzc = C1359eb.a(i13, (List<?>) unsafe2.getObject(t, j3), a(i12));
                    i9 += zzc;
                    j = 0;
                    break;
                case 28:
                    zzc = C1359eb.b(i13, (List) unsafe2.getObject(t, j3));
                    i9 += zzc;
                    j = 0;
                    break;
                case 29:
                    zzc = C1359eb.f(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 30:
                    zzc = C1359eb.d(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 31:
                    zzc = C1359eb.h(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 32:
                    zzc = C1359eb.i(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 33:
                    zzc = C1359eb.g(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 34:
                    zzc = C1359eb.c(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 35:
                    g2 = C1359eb.g((List) unsafe2.getObject(t, j3));
                    if (g2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, g2);
                        }
                        zzbd = zztv.zzbd(i13);
                        zzbf = zztv.zzbf(g2);
                        zzl = zzbd + zzbf + g2;
                        i9 += zzl;
                    }
                    j = 0;
                    break;
                case 36:
                    g2 = C1359eb.f((List) unsafe2.getObject(t, j3));
                    if (g2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, g2);
                        }
                        zzbd = zztv.zzbd(i13);
                        zzbf = zztv.zzbf(g2);
                        zzl = zzbd + zzbf + g2;
                        i9 += zzl;
                    }
                    j = 0;
                    break;
                case 37:
                    g2 = C1359eb.i((List) unsafe2.getObject(t, j3));
                    if (g2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, g2);
                        }
                        zzbd = zztv.zzbd(i13);
                        zzbf = zztv.zzbf(g2);
                        zzl = zzbd + zzbf + g2;
                        i9 += zzl;
                    }
                    j = 0;
                    break;
                case 38:
                    g2 = C1359eb.j((List) unsafe2.getObject(t, j3));
                    if (g2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, g2);
                        }
                        zzbd = zztv.zzbd(i13);
                        zzbf = zztv.zzbf(g2);
                        zzl = zzbd + zzbf + g2;
                        i9 += zzl;
                    }
                    j = 0;
                    break;
                case 39:
                    g2 = C1359eb.c((List) unsafe2.getObject(t, j3));
                    if (g2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, g2);
                        }
                        zzbd = zztv.zzbd(i13);
                        zzbf = zztv.zzbf(g2);
                        zzl = zzbd + zzbf + g2;
                        i9 += zzl;
                    }
                    j = 0;
                    break;
                case 40:
                    g2 = C1359eb.g((List) unsafe2.getObject(t, j3));
                    if (g2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, g2);
                        }
                        zzbd = zztv.zzbd(i13);
                        zzbf = zztv.zzbf(g2);
                        zzl = zzbd + zzbf + g2;
                        i9 += zzl;
                    }
                    j = 0;
                    break;
                case 41:
                    g2 = C1359eb.f((List) unsafe2.getObject(t, j3));
                    if (g2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, g2);
                        }
                        zzbd = zztv.zzbd(i13);
                        zzbf = zztv.zzbf(g2);
                        zzl = zzbd + zzbf + g2;
                        i9 += zzl;
                    }
                    j = 0;
                    break;
                case 42:
                    g2 = C1359eb.h((List) unsafe2.getObject(t, j3));
                    if (g2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, g2);
                        }
                        zzbd = zztv.zzbd(i13);
                        zzbf = zztv.zzbf(g2);
                        zzl = zzbd + zzbf + g2;
                        i9 += zzl;
                    }
                    j = 0;
                    break;
                case 43:
                    g2 = C1359eb.d((List) unsafe2.getObject(t, j3));
                    if (g2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, g2);
                        }
                        zzbd = zztv.zzbd(i13);
                        zzbf = zztv.zzbf(g2);
                        zzl = zzbd + zzbf + g2;
                        i9 += zzl;
                    }
                    j = 0;
                    break;
                case 44:
                    g2 = C1359eb.b((List) unsafe2.getObject(t, j3));
                    if (g2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, g2);
                        }
                        zzbd = zztv.zzbd(i13);
                        zzbf = zztv.zzbf(g2);
                        zzl = zzbd + zzbf + g2;
                        i9 += zzl;
                    }
                    j = 0;
                    break;
                case 45:
                    g2 = C1359eb.f((List) unsafe2.getObject(t, j3));
                    if (g2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, g2);
                        }
                        zzbd = zztv.zzbd(i13);
                        zzbf = zztv.zzbf(g2);
                        zzl = zzbd + zzbf + g2;
                        i9 += zzl;
                    }
                    j = 0;
                    break;
                case 46:
                    g2 = C1359eb.g((List) unsafe2.getObject(t, j3));
                    if (g2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, g2);
                        }
                        zzbd = zztv.zzbd(i13);
                        zzbf = zztv.zzbf(g2);
                        zzl = zzbd + zzbf + g2;
                        i9 += zzl;
                    }
                    j = 0;
                    break;
                case 47:
                    g2 = C1359eb.e((List) unsafe2.getObject(t, j3));
                    if (g2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, g2);
                        }
                        zzbd = zztv.zzbd(i13);
                        zzbf = zztv.zzbf(g2);
                        zzl = zzbd + zzbf + g2;
                        i9 += zzl;
                    }
                    j = 0;
                    break;
                case 48:
                    g2 = C1359eb.a((List<Long>) unsafe2.getObject(t, j3));
                    if (g2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, g2);
                        }
                        zzbd = zztv.zzbd(i13);
                        zzbf = zztv.zzbf(g2);
                        zzl = zzbd + zzbf + g2;
                        i9 += zzl;
                    }
                    j = 0;
                    break;
                case 49:
                    zzc = C1359eb.b(i13, (List<zzvv>) unsafe2.getObject(t, j3), a(i12));
                    i9 += zzc;
                    j = 0;
                    break;
                case 50:
                    zzc = this.s.a(i13, unsafe2.getObject(t, j3), b(i12));
                    i9 += zzc;
                    j = 0;
                    break;
                case 51:
                    if (a((Ta<T>) t, i13, i12)) {
                        zzc = zztv.zzb(i13, 0.0d);
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 52:
                    if (a((Ta<T>) t, i13, i12)) {
                        zzl = zztv.zzb(i13, 0.0f);
                        i9 += zzl;
                    }
                    j = 0;
                    break;
                case 53:
                    if (a((Ta<T>) t, i13, i12)) {
                        zzc = zztv.zzd(i13, e(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 54:
                    if (a((Ta<T>) t, i13, i12)) {
                        zzc = zztv.zze(i13, e(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 55:
                    if (a((Ta<T>) t, i13, i12)) {
                        zzc = zztv.zzh(i13, d(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 56:
                    if (a((Ta<T>) t, i13, i12)) {
                        zzc = zztv.zzg(i13, 0L);
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 57:
                    if (a((Ta<T>) t, i13, i12)) {
                        zzl = zztv.zzk(i13, 0);
                        i9 += zzl;
                    }
                    j = 0;
                    break;
                case 58:
                    if (a((Ta<T>) t, i13, i12)) {
                        zzc = zztv.zzc(i13, true);
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 59:
                    if (a((Ta<T>) t, i13, i12)) {
                        Object object2 = unsafe2.getObject(t, j3);
                        if (object2 instanceof zzte) {
                            zzc = zztv.zzc(i13, (zzte) object2);
                        } else {
                            zzc = zztv.zzc(i13, (String) object2);
                        }
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 60:
                    if (a((Ta<T>) t, i13, i12)) {
                        zzc = C1359eb.a(i13, unsafe2.getObject(t, j3), a(i12));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 61:
                    if (a((Ta<T>) t, i13, i12)) {
                        zzc = zztv.zzc(i13, (zzte) unsafe2.getObject(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 62:
                    if (a((Ta<T>) t, i13, i12)) {
                        zzc = zztv.zzi(i13, d(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 63:
                    if (a((Ta<T>) t, i13, i12)) {
                        zzc = zztv.zzm(i13, d(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 64:
                    if (a((Ta<T>) t, i13, i12)) {
                        zzl = zztv.zzl(i13, 0);
                        i9 += zzl;
                    }
                    j = 0;
                    break;
                case 65:
                    if (a((Ta<T>) t, i13, i12)) {
                        zzc = zztv.zzh(i13, 0L);
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 66:
                    if (a((Ta<T>) t, i13, i12)) {
                        zzc = zztv.zzj(i13, d(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 67:
                    if (a((Ta<T>) t, i13, i12)) {
                        zzc = zztv.zzf(i13, e(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 68:
                    if (a((Ta<T>) t, i13, i12)) {
                        zzc = zztv.zzc(i13, (zzvv) unsafe2.getObject(t, j3), a(i12));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                default:
                    j = 0;
                    break;
            }
        }
        int a2 = i9 + a((tb) this.q, (Object) t);
        return this.f13395h ? a2 + this.r.a(t).h() : a2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.InterfaceC1353cb
    public final boolean d(T t) {
        int i;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= this.m) {
                return !this.f13395h || this.r.a(t).d();
            }
            int i5 = this.l[i2];
            int i6 = this.f13390c[i5];
            int d2 = d(i5);
            if (this.j) {
                i = 0;
            } else {
                int i7 = this.f13390c[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i4 = f13389b.getInt(t, i8);
                    i3 = i8;
                }
            }
            if (((268435456 & d2) != 0) && !a((Ta<T>) t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & d2) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (a((Ta<T>) t, i6, i5) && !a(t, d2, a(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 == 50 && !this.s.d(xb.f(t, d2 & 1048575)).isEmpty()) {
                            this.s.f(b(i5));
                            throw null;
                        }
                    }
                }
                List list = (List) xb.f(t, d2 & 1048575);
                if (!list.isEmpty()) {
                    InterfaceC1353cb a2 = a(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        }
                        if (!a2.d(list.get(i10))) {
                            z = false;
                            break;
                        }
                        i10++;
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (a((Ta<T>) t, i5, i4, i) && !a(t, d2, a(i5))) {
                return false;
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1353cb
    public final T newInstance() {
        return (T) this.o.a(this.f13394g);
    }

    private static <T> long e(T t, long j) {
        return ((Long) xb.f(t, j)).longValue();
    }

    private final int d(int i) {
        return this.f13390c[i + 1];
    }

    private static <T> int d(T t, long j) {
        return ((Integer) xb.f(t, j)).intValue();
    }

    private final void b(T t, T t2, int i) {
        int d2 = d(i);
        int i2 = this.f13390c[i];
        long j = d2 & 1048575;
        if (a((Ta<T>) t2, i2, i)) {
            Object f2 = xb.f(t, j);
            Object f3 = xb.f(t2, j);
            if (f2 != null && f3 != null) {
                xb.a(t, j, zzuq.zzb(f2, f3));
                b((Ta<T>) t, i2, i);
            } else if (f3 != null) {
                xb.a(t, j, f3);
                b((Ta<T>) t, i2, i);
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
    private final void b(T r18, com.google.android.gms.internal.measurement.Fb r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.Ta.b(java.lang.Object, com.google.android.gms.internal.measurement.Fb):void");
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

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:            if (com.google.android.gms.internal.measurement.C1359eb.a(com.google.android.gms.internal.measurement.xb.f(r10, r6), com.google.android.gms.internal.measurement.xb.f(r11, r6)) != false) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:            if (com.google.android.gms.internal.measurement.xb.b(r10, r6) == com.google.android.gms.internal.measurement.xb.b(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:            if (com.google.android.gms.internal.measurement.xb.a(r10, r6) == com.google.android.gms.internal.measurement.xb.a(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a4, code lost:            if (com.google.android.gms.internal.measurement.xb.b(r10, r6) == com.google.android.gms.internal.measurement.xb.b(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b6, code lost:            if (com.google.android.gms.internal.measurement.xb.a(r10, r6) == com.google.android.gms.internal.measurement.xb.a(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c8, code lost:            if (com.google.android.gms.internal.measurement.xb.a(r10, r6) == com.google.android.gms.internal.measurement.xb.a(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00da, code lost:            if (com.google.android.gms.internal.measurement.xb.a(r10, r6) == com.google.android.gms.internal.measurement.xb.a(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f0, code lost:            if (com.google.android.gms.internal.measurement.C1359eb.a(com.google.android.gms.internal.measurement.xb.f(r10, r6), com.google.android.gms.internal.measurement.xb.f(r11, r6)) != false) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0106, code lost:            if (com.google.android.gms.internal.measurement.C1359eb.a(com.google.android.gms.internal.measurement.xb.f(r10, r6), com.google.android.gms.internal.measurement.xb.f(r11, r6)) != false) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x011c, code lost:            if (com.google.android.gms.internal.measurement.C1359eb.a(com.google.android.gms.internal.measurement.xb.f(r10, r6), com.google.android.gms.internal.measurement.xb.f(r11, r6)) != false) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012e, code lost:            if (com.google.android.gms.internal.measurement.xb.c(r10, r6) == com.google.android.gms.internal.measurement.xb.c(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0140, code lost:            if (com.google.android.gms.internal.measurement.xb.a(r10, r6) == com.google.android.gms.internal.measurement.xb.a(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0154, code lost:            if (com.google.android.gms.internal.measurement.xb.b(r10, r6) == com.google.android.gms.internal.measurement.xb.b(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0165, code lost:            if (com.google.android.gms.internal.measurement.xb.a(r10, r6) == com.google.android.gms.internal.measurement.xb.a(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0178, code lost:            if (com.google.android.gms.internal.measurement.xb.b(r10, r6) == com.google.android.gms.internal.measurement.xb.b(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x018b, code lost:            if (com.google.android.gms.internal.measurement.xb.b(r10, r6) == com.google.android.gms.internal.measurement.xb.b(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a4, code lost:            if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.xb.d(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.xb.d(r11, r6))) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01bf, code lost:            if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.xb.e(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.xb.e(r11, r6))) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:            if (com.google.android.gms.internal.measurement.C1359eb.a(com.google.android.gms.internal.measurement.xb.f(r10, r6), com.google.android.gms.internal.measurement.xb.f(r11, r6)) != false) goto L105;     */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01c5 A[LOOP:0: B:2:0x0005->B:86:0x01c5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c4 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.InterfaceC1353cb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.Ta.a(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001b. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.InterfaceC1353cb
    public final int a(T t) {
        int i;
        int zzbd;
        int length = this.f13390c.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int d2 = d(i3);
            int i4 = this.f13390c[i3];
            long j = 1048575 & d2;
            int i5 = 37;
            switch ((d2 & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    zzbd = zzuq.zzbd(Double.doubleToLongBits(xb.e(t, j)));
                    i2 = i + zzbd;
                    break;
                case 1:
                    i = i2 * 53;
                    zzbd = Float.floatToIntBits(xb.d(t, j));
                    i2 = i + zzbd;
                    break;
                case 2:
                    i = i2 * 53;
                    zzbd = zzuq.zzbd(xb.b(t, j));
                    i2 = i + zzbd;
                    break;
                case 3:
                    i = i2 * 53;
                    zzbd = zzuq.zzbd(xb.b(t, j));
                    i2 = i + zzbd;
                    break;
                case 4:
                    i = i2 * 53;
                    zzbd = xb.a(t, j);
                    i2 = i + zzbd;
                    break;
                case 5:
                    i = i2 * 53;
                    zzbd = zzuq.zzbd(xb.b(t, j));
                    i2 = i + zzbd;
                    break;
                case 6:
                    i = i2 * 53;
                    zzbd = xb.a(t, j);
                    i2 = i + zzbd;
                    break;
                case 7:
                    i = i2 * 53;
                    zzbd = zzuq.zzu(xb.c(t, j));
                    i2 = i + zzbd;
                    break;
                case 8:
                    i = i2 * 53;
                    zzbd = ((String) xb.f(t, j)).hashCode();
                    i2 = i + zzbd;
                    break;
                case 9:
                    Object f2 = xb.f(t, j);
                    if (f2 != null) {
                        i5 = f2.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
                    break;
                case 10:
                    i = i2 * 53;
                    zzbd = xb.f(t, j).hashCode();
                    i2 = i + zzbd;
                    break;
                case 11:
                    i = i2 * 53;
                    zzbd = xb.a(t, j);
                    i2 = i + zzbd;
                    break;
                case 12:
                    i = i2 * 53;
                    zzbd = xb.a(t, j);
                    i2 = i + zzbd;
                    break;
                case 13:
                    i = i2 * 53;
                    zzbd = xb.a(t, j);
                    i2 = i + zzbd;
                    break;
                case 14:
                    i = i2 * 53;
                    zzbd = zzuq.zzbd(xb.b(t, j));
                    i2 = i + zzbd;
                    break;
                case 15:
                    i = i2 * 53;
                    zzbd = xb.a(t, j);
                    i2 = i + zzbd;
                    break;
                case 16:
                    i = i2 * 53;
                    zzbd = zzuq.zzbd(xb.b(t, j));
                    i2 = i + zzbd;
                    break;
                case 17:
                    Object f3 = xb.f(t, j);
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
                    zzbd = xb.f(t, j).hashCode();
                    i2 = i + zzbd;
                    break;
                case 50:
                    i = i2 * 53;
                    zzbd = xb.f(t, j).hashCode();
                    i2 = i + zzbd;
                    break;
                case 51:
                    if (a((Ta<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbd = zzuq.zzbd(Double.doubleToLongBits(b(t, j)));
                        i2 = i + zzbd;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (a((Ta<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbd = Float.floatToIntBits(c(t, j));
                        i2 = i + zzbd;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (a((Ta<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbd = zzuq.zzbd(e(t, j));
                        i2 = i + zzbd;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (a((Ta<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbd = zzuq.zzbd(e(t, j));
                        i2 = i + zzbd;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (a((Ta<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbd = d(t, j);
                        i2 = i + zzbd;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (a((Ta<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbd = zzuq.zzbd(e(t, j));
                        i2 = i + zzbd;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (a((Ta<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbd = d(t, j);
                        i2 = i + zzbd;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (a((Ta<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbd = zzuq.zzu(f(t, j));
                        i2 = i + zzbd;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (a((Ta<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbd = ((String) xb.f(t, j)).hashCode();
                        i2 = i + zzbd;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (a((Ta<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbd = xb.f(t, j).hashCode();
                        i2 = i + zzbd;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (a((Ta<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbd = xb.f(t, j).hashCode();
                        i2 = i + zzbd;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (a((Ta<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbd = d(t, j);
                        i2 = i + zzbd;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (a((Ta<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbd = d(t, j);
                        i2 = i + zzbd;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (a((Ta<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbd = d(t, j);
                        i2 = i + zzbd;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (a((Ta<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbd = zzuq.zzbd(e(t, j));
                        i2 = i + zzbd;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (a((Ta<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbd = d(t, j);
                        i2 = i + zzbd;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (a((Ta<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbd = zzuq.zzbd(e(t, j));
                        i2 = i + zzbd;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (a((Ta<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzbd = xb.f(t, j).hashCode();
                        i2 = i + zzbd;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i2 * 53) + this.q.c(t).hashCode();
        return this.f13395h ? (hashCode * 53) + this.r.a(t).hashCode() : hashCode;
    }

    private final void a(T t, T t2, int i) {
        long d2 = d(i) & 1048575;
        if (a((Ta<T>) t2, i)) {
            Object f2 = xb.f(t, d2);
            Object f3 = xb.f(t2, d2);
            if (f2 != null && f3 != null) {
                xb.a(t, d2, zzuq.zzb(f2, f3));
                b((Ta<T>) t, i);
            } else if (f3 != null) {
                xb.a(t, d2, f3);
                b((Ta<T>) t, i);
            }
        }
    }

    private static <UT, UB> int a(tb<UT, UB> tbVar, T t) {
        return tbVar.b(tbVar.c(t));
    }

    private static <E> List<E> a(Object obj, long j) {
        return (List) xb.f(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x04ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:538:0x0969  */
    /* JADX WARN: Removed duplicated region for block: B:540:0x096f  */
    @Override // com.google.android.gms.internal.measurement.InterfaceC1353cb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(T r13, com.google.android.gms.internal.measurement.Fb r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2710
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.Ta.a(java.lang.Object, com.google.android.gms.internal.measurement.Fb):void");
    }

    private final Object b(int i) {
        return this.f13391d[(i / 3) << 1];
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1353cb
    public final void b(T t) {
        int i;
        int i2 = this.m;
        while (true) {
            i = this.n;
            if (i2 >= i) {
                break;
            }
            long d2 = d(this.l[i2]) & 1048575;
            Object f2 = xb.f(t, d2);
            if (f2 != null) {
                this.s.a(f2);
                xb.a(t, d2, f2);
            }
            i2++;
        }
        int length = this.l.length;
        while (i < length) {
            this.p.b(t, this.l[i]);
            i++;
        }
        this.q.f(t);
        if (this.f13395h) {
            this.r.c(t);
        }
    }

    private static <T> double b(T t, long j) {
        return ((Double) xb.f(t, j)).doubleValue();
    }

    private final void b(T t, int i) {
        if (this.j) {
            return;
        }
        int e2 = e(i);
        long j = e2 & 1048575;
        xb.a((Object) t, j, xb.a(t, j) | (1 << (e2 >>> 20)));
    }

    private final void b(T t, int i, int i2) {
        xb.a((Object) t, e(i2) & 1048575, i);
    }

    private final zzut c(int i) {
        return (zzut) this.f13391d[((i / 3) << 1) + 1];
    }

    private static <T> float c(T t, long j) {
        return ((Float) xb.f(t, j)).floatValue();
    }

    private final boolean c(T t, T t2, int i) {
        return a((Ta<T>) t, i) == a((Ta<T>) t2, i);
    }

    private final <K, V> void a(Fb fb, int i, Object obj, int i2) throws IOException {
        if (obj == null) {
            return;
        }
        this.s.f(b(i2));
        throw null;
    }

    private static <UT, UB> void a(tb<UT, UB> tbVar, T t, Fb fb) throws IOException {
        tbVar.a((tb<UT, UB>) tbVar.c(t), fb);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x009e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:364:0x05c0 A[LOOP:6: B:362:0x05bc->B:364:0x05c0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:367:0x05cc  */
    @Override // com.google.android.gms.internal.measurement.InterfaceC1353cb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(T r13, com.google.android.gms.internal.measurement.InterfaceC1350bb r14, com.google.android.gms.internal.measurement.zzub r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1638
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.Ta.a(java.lang.Object, com.google.android.gms.internal.measurement.bb, com.google.android.gms.internal.measurement.zzub):void");
    }

    private final InterfaceC1353cb a(int i) {
        int i2 = (i / 3) << 1;
        InterfaceC1353cb interfaceC1353cb = (InterfaceC1353cb) this.f13391d[i2];
        if (interfaceC1353cb != null) {
            return interfaceC1353cb;
        }
        InterfaceC1353cb<T> a2 = Za.a().a((Class) this.f13391d[i2 + 1]);
        this.f13391d[i2] = a2;
        return a2;
    }

    private final <UT, UB> UB a(Object obj, int i, UB ub, tb<UT, UB> tbVar) {
        zzut c2;
        int i2 = this.f13390c[i];
        Object f2 = xb.f(obj, d(i) & 1048575);
        if (f2 == null || (c2 = c(i)) == null) {
            return ub;
        }
        a(i, i2, this.s.c(f2), c2, ub, tbVar);
        throw null;
    }

    private final <K, V, UT, UB> UB a(int i, int i2, Map<K, V> map, zzut zzutVar, UB ub, tb<UT, UB> tbVar) {
        this.s.f(b(i));
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a(Object obj, int i, InterfaceC1353cb interfaceC1353cb) {
        return interfaceC1353cb.d(xb.f(obj, i & 1048575));
    }

    private static void a(int i, Object obj, Fb fb) throws IOException {
        if (obj instanceof String) {
            fb.a(i, (String) obj);
        } else {
            fb.a(i, (zzte) obj);
        }
    }

    private final void a(Object obj, int i, InterfaceC1350bb interfaceC1350bb) throws IOException {
        if (f(i)) {
            xb.a(obj, i & 1048575, interfaceC1350bb.b());
        } else if (this.i) {
            xb.a(obj, i & 1048575, interfaceC1350bb.readString());
        } else {
            xb.a(obj, i & 1048575, interfaceC1350bb.zzur());
        }
    }

    private final boolean a(T t, int i, int i2, int i3) {
        if (this.j) {
            return a((Ta<T>) t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean a(T t, int i) {
        if (this.j) {
            int d2 = d(i);
            long j = d2 & 1048575;
            switch ((d2 & 267386880) >>> 20) {
                case 0:
                    return xb.e(t, j) != 0.0d;
                case 1:
                    return xb.d(t, j) != 0.0f;
                case 2:
                    return xb.b(t, j) != 0;
                case 3:
                    return xb.b(t, j) != 0;
                case 4:
                    return xb.a(t, j) != 0;
                case 5:
                    return xb.b(t, j) != 0;
                case 6:
                    return xb.a(t, j) != 0;
                case 7:
                    return xb.c(t, j);
                case 8:
                    Object f2 = xb.f(t, j);
                    if (f2 instanceof String) {
                        return !((String) f2).isEmpty();
                    }
                    if (f2 instanceof zzte) {
                        return !zzte.zzbtq.equals(f2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return xb.f(t, j) != null;
                case 10:
                    return !zzte.zzbtq.equals(xb.f(t, j));
                case 11:
                    return xb.a(t, j) != 0;
                case 12:
                    return xb.a(t, j) != 0;
                case 13:
                    return xb.a(t, j) != 0;
                case 14:
                    return xb.b(t, j) != 0;
                case 15:
                    return xb.a(t, j) != 0;
                case 16:
                    return xb.b(t, j) != 0;
                case 17:
                    return xb.f(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int e2 = e(i);
        return (xb.a(t, (long) (e2 & 1048575)) & (1 << (e2 >>> 20))) != 0;
    }

    private final boolean a(T t, int i, int i2) {
        return xb.a(t, (long) (e(i2) & 1048575)) == i;
    }
}

package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
final class Z<T> implements InterfaceC1263ma<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f13000a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    private static final Unsafe f13001b = Ja.d();

    /* renamed from: c, reason: collision with root package name */
    private final int[] f13002c;

    /* renamed from: d, reason: collision with root package name */
    private final Object[] f13003d;

    /* renamed from: e, reason: collision with root package name */
    private final int f13004e;

    /* renamed from: f, reason: collision with root package name */
    private final int f13005f;

    /* renamed from: g, reason: collision with root package name */
    private final zzhc f13006g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f13007h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final int[] l;
    private final int m;
    private final int n;
    private final InterfaceC1241ba o;
    private final J p;
    private final Fa<?, ?> q;
    private final AbstractC1281w<?> r;
    private final T s;

    private Z(int[] iArr, Object[] objArr, int i, int i2, zzhc zzhcVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, InterfaceC1241ba interfaceC1241ba, J j, Fa<?, ?> fa, AbstractC1281w<?> abstractC1281w, T t) {
        this.f13002c = iArr;
        this.f13003d = objArr;
        this.f13004e = i;
        this.f13005f = i2;
        this.i = zzhcVar instanceof zzft;
        this.j = z;
        this.f13007h = abstractC1281w != null && abstractC1281w.a(zzhcVar);
        this.k = false;
        this.l = iArr2;
        this.m = i3;
        this.n = i4;
        this.o = interfaceC1241ba;
        this.p = j;
        this.q = fa;
        this.r = abstractC1281w;
        this.f13006g = zzhcVar;
        this.s = t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Z<T> a(Class<T> cls, W w, InterfaceC1241ba interfaceC1241ba, J j, Fa<?, ?> fa, AbstractC1281w<?> abstractC1281w, T t) {
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
        if (w instanceof C1253ha) {
            C1253ha c1253ha = (C1253ha) w;
            int i26 = 0;
            boolean z = c1253ha.zzin() == zzft.zze.zzxo;
            String c6 = c1253ha.c();
            int length = c6.length();
            int charAt18 = c6.charAt(0);
            if (charAt18 >= 55296) {
                int i27 = charAt18 & 8191;
                int i28 = 1;
                int i29 = 13;
                while (true) {
                    i = i28 + 1;
                    charAt17 = c6.charAt(i28);
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
            int charAt19 = c6.charAt(i);
            if (charAt19 >= 55296) {
                int i31 = charAt19 & 8191;
                int i32 = 13;
                while (true) {
                    i2 = i30 + 1;
                    charAt16 = c6.charAt(i30);
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
                iArr = f13000a;
                charAt3 = 0;
                c3 = 0;
                i8 = 0;
                charAt = 0;
                charAt2 = 0;
                c2 = 0;
            } else {
                int i33 = i2 + 1;
                char charAt20 = c6.charAt(i2);
                if (charAt20 >= 55296) {
                    int i34 = charAt20 & 8191;
                    int i35 = 13;
                    while (true) {
                        i3 = i33 + 1;
                        charAt11 = c6.charAt(i33);
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
                int charAt21 = c6.charAt(i3);
                if (charAt21 >= 55296) {
                    int i37 = charAt21 & 8191;
                    int i38 = 13;
                    while (true) {
                        i4 = i36 + 1;
                        charAt10 = c6.charAt(i36);
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
                char charAt22 = c6.charAt(i4);
                if (charAt22 >= 55296) {
                    int i40 = charAt22 & 8191;
                    int i41 = 13;
                    while (true) {
                        i5 = i39 + 1;
                        charAt9 = c6.charAt(i39);
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
                charAt = c6.charAt(i5);
                if (charAt >= 55296) {
                    int i43 = charAt & 8191;
                    int i44 = 13;
                    while (true) {
                        i6 = i42 + 1;
                        charAt8 = c6.charAt(i42);
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
                charAt2 = c6.charAt(i6);
                if (charAt2 >= 55296) {
                    int i46 = charAt2 & 8191;
                    int i47 = 13;
                    while (true) {
                        i12 = i45 + 1;
                        charAt7 = c6.charAt(i45);
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
                charAt3 = c6.charAt(i45);
                if (charAt3 >= 55296) {
                    int i49 = charAt3 & 8191;
                    int i50 = 13;
                    while (true) {
                        i11 = i48 + 1;
                        charAt6 = c6.charAt(i48);
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
                int charAt23 = c6.charAt(i48);
                if (charAt23 >= 55296) {
                    int i52 = 13;
                    int i53 = charAt23 & 8191;
                    int i54 = i51;
                    while (true) {
                        i10 = i54 + 1;
                        charAt5 = c6.charAt(i54);
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
                i26 = c6.charAt(i7);
                if (i26 >= 55296) {
                    int i56 = 13;
                    int i57 = i26 & 8191;
                    int i58 = i55;
                    while (true) {
                        i9 = i58 + 1;
                        charAt4 = c6.charAt(i58);
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
            Unsafe unsafe = f13001b;
            Object[] d2 = c1253ha.d();
            Class<?> cls3 = c1253ha.b().getClass();
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
                int charAt24 = c6.charAt(i2);
                char c7 = 55296;
                if (charAt24 >= 55296) {
                    int i67 = 13;
                    int i68 = charAt24 & 8191;
                    int i69 = i66;
                    while (true) {
                        i25 = i69 + 1;
                        charAt15 = c6.charAt(i69);
                        if (charAt15 < c7) {
                            break;
                        }
                        i68 |= (charAt15 & 8191) << i67;
                        i67 += 13;
                        i69 = i25;
                        c7 = 55296;
                    }
                    charAt24 = i68 | (charAt15 << i67);
                    i13 = i25;
                } else {
                    i13 = i66;
                }
                int i70 = i13 + 1;
                int charAt25 = c6.charAt(i13);
                int i71 = length;
                char c8 = 55296;
                if (charAt25 >= 55296) {
                    int i72 = 13;
                    int i73 = charAt25 & 8191;
                    int i74 = i70;
                    while (true) {
                        i24 = i74 + 1;
                        charAt14 = c6.charAt(i74);
                        if (charAt14 < c8) {
                            break;
                        }
                        i73 |= (charAt14 & 8191) << i72;
                        i72 += 13;
                        i74 = i24;
                        c8 = 55296;
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
                    int charAt26 = c6.charAt(i14);
                    char c9 = 55296;
                    if (charAt26 >= 55296) {
                        int i79 = charAt26 & 8191;
                        int i80 = 13;
                        while (true) {
                            i23 = i78 + 1;
                            charAt13 = c6.charAt(i78);
                            if (charAt13 < c9) {
                                break;
                            }
                            i79 |= (charAt13 & 8191) << i80;
                            i80 += 13;
                            i78 = i23;
                            c9 = 55296;
                        }
                        charAt26 = i79 | (charAt13 << i80);
                        i78 = i23;
                    }
                    int i81 = i76 - 51;
                    int i82 = i78;
                    if (i81 == 9 || i81 == 17) {
                        i22 = 1;
                        objArr[((i65 / 3) << 1) + 1] = d2[i60];
                        i60++;
                    } else {
                        if (i81 == 12 && (charAt18 & 1) == 1) {
                            objArr[((i65 / 3) << 1) + 1] = d2[i60];
                            i60++;
                        }
                        i22 = 1;
                    }
                    int i83 = charAt26 << i22;
                    Object obj = d2[i83];
                    if (obj instanceof Field) {
                        a3 = (Field) obj;
                    } else {
                        a3 = a(cls3, (String) obj);
                        d2[i83] = a3;
                    }
                    char c10 = c3;
                    int objectFieldOffset2 = (int) unsafe.objectFieldOffset(a3);
                    int i84 = i83 + 1;
                    Object obj2 = d2[i84];
                    if (obj2 instanceof Field) {
                        a4 = (Field) obj2;
                    } else {
                        a4 = a(cls3, (String) obj2);
                        d2[i84] = a4;
                    }
                    str = c6;
                    i19 = (int) unsafe.objectFieldOffset(a4);
                    cls2 = cls3;
                    i16 = i60;
                    objectFieldOffset = objectFieldOffset2;
                    i18 = 0;
                    c5 = c10;
                    c4 = charAt;
                    i15 = charAt24;
                    i2 = i82;
                } else {
                    char c11 = c3;
                    int i85 = i60 + 1;
                    Field a5 = a(cls3, (String) d2[i60]);
                    c4 = charAt;
                    if (i76 == 9 || i76 == 17) {
                        c5 = c11;
                        objArr[((i65 / 3) << 1) + 1] = a5.getType();
                    } else {
                        if (i76 == 27 || i76 == 49) {
                            c5 = c11;
                            i21 = i85 + 1;
                            objArr[((i65 / 3) << 1) + 1] = d2[i85];
                        } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                            c5 = c11;
                            if ((charAt18 & 1) == 1) {
                                i21 = i85 + 1;
                                objArr[((i65 / 3) << 1) + 1] = d2[i85];
                            }
                        } else if (i76 == 50) {
                            int i86 = i62 + 1;
                            iArr[i62] = i65;
                            int i87 = (i65 / 3) << 1;
                            int i88 = i85 + 1;
                            objArr[i87] = d2[i85];
                            if ((charAt25 & 2048) != 0) {
                                i85 = i88 + 1;
                                objArr[i87 + 1] = d2[i88];
                                c5 = c11;
                                i62 = i86;
                            } else {
                                i62 = i86;
                                i85 = i88;
                                c5 = c11;
                            }
                        } else {
                            c5 = c11;
                        }
                        i15 = charAt24;
                        i85 = i21;
                        objectFieldOffset = (int) unsafe.objectFieldOffset(a5);
                        if ((charAt18 & 1) == 1 || i76 > 17) {
                            str = c6;
                            cls2 = cls3;
                            i16 = i85;
                            i17 = i14;
                            i18 = 0;
                            i19 = 0;
                        } else {
                            i17 = i14 + 1;
                            int charAt27 = c6.charAt(i14);
                            if (charAt27 >= 55296) {
                                int i89 = charAt27 & 8191;
                                int i90 = 13;
                                while (true) {
                                    i20 = i17 + 1;
                                    charAt12 = c6.charAt(i17);
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
                            Object obj3 = d2[i91];
                            str = c6;
                            if (obj3 instanceof Field) {
                                a2 = (Field) obj3;
                            } else {
                                a2 = a(cls3, (String) obj3);
                                d2[i91] = a2;
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
                    str = c6;
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
                c6 = str;
            }
            return new Z<>(iArr2, objArr, c3, charAt, c1253ha.b(), z, false, iArr, i26, i61, interfaceC1241ba, j, fa, abstractC1281w, t);
        }
        ((Aa) w).zzin();
        throw null;
    }

    private final int d(int i) {
        return this.f13002c[i + 1];
    }

    private final int e(int i) {
        return this.f13002c[i + 2];
    }

    private static boolean f(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> boolean f(T t, long j) {
        return ((Boolean) Ja.f(t, j)).booleanValue();
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1263ma
    public final void b(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.f13002c.length; i += 3) {
                int d2 = d(i);
                long j = 1048575 & d2;
                int i2 = this.f13002c[i];
                switch ((d2 & 267386880) >>> 20) {
                    case 0:
                        if (a((Z<T>) t2, i)) {
                            Ja.a(t, j, Ja.e(t2, j));
                            b((Z<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (a((Z<T>) t2, i)) {
                            Ja.a((Object) t, j, Ja.d(t2, j));
                            b((Z<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (a((Z<T>) t2, i)) {
                            Ja.a((Object) t, j, Ja.b(t2, j));
                            b((Z<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (a((Z<T>) t2, i)) {
                            Ja.a((Object) t, j, Ja.b(t2, j));
                            b((Z<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (a((Z<T>) t2, i)) {
                            Ja.a((Object) t, j, Ja.a(t2, j));
                            b((Z<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (a((Z<T>) t2, i)) {
                            Ja.a((Object) t, j, Ja.b(t2, j));
                            b((Z<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (a((Z<T>) t2, i)) {
                            Ja.a((Object) t, j, Ja.a(t2, j));
                            b((Z<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (a((Z<T>) t2, i)) {
                            Ja.a(t, j, Ja.c(t2, j));
                            b((Z<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (a((Z<T>) t2, i)) {
                            Ja.a(t, j, Ja.f(t2, j));
                            b((Z<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        a(t, t2, i);
                        break;
                    case 10:
                        if (a((Z<T>) t2, i)) {
                            Ja.a(t, j, Ja.f(t2, j));
                            b((Z<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (a((Z<T>) t2, i)) {
                            Ja.a((Object) t, j, Ja.a(t2, j));
                            b((Z<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (a((Z<T>) t2, i)) {
                            Ja.a((Object) t, j, Ja.a(t2, j));
                            b((Z<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (a((Z<T>) t2, i)) {
                            Ja.a((Object) t, j, Ja.a(t2, j));
                            b((Z<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (a((Z<T>) t2, i)) {
                            Ja.a((Object) t, j, Ja.b(t2, j));
                            b((Z<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (a((Z<T>) t2, i)) {
                            Ja.a((Object) t, j, Ja.a(t2, j));
                            b((Z<T>) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (a((Z<T>) t2, i)) {
                            Ja.a((Object) t, j, Ja.b(t2, j));
                            b((Z<T>) t, i);
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
                        C1267oa.a(this.s, t, t2, j);
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
                        if (a((Z<T>) t2, i2, i)) {
                            Ja.a(t, j, Ja.f(t2, j));
                            b((Z<T>) t, i2, i);
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
                        if (a((Z<T>) t2, i2, i)) {
                            Ja.a(t, j, Ja.f(t2, j));
                            b((Z<T>) t, i2, i);
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
            C1267oa.a(this.q, t, t2);
            if (this.f13007h) {
                C1267oa.a(this.r, t, t2);
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0042. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:299:0x0548. Please report as an issue. */
    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1263ma
    public final int c(T t) {
        int i;
        int i2;
        long j;
        int zzd;
        int zzc;
        int zzo;
        int b2;
        int zzag;
        int zzai;
        int zzb;
        int b3;
        int zzag2;
        int zzai2;
        int i3 = 267386880;
        if (this.j) {
            Unsafe unsafe = f13001b;
            int i4 = 0;
            int i5 = 0;
            while (i4 < this.f13002c.length) {
                int d2 = d(i4);
                int i6 = (d2 & i3) >>> 20;
                int i7 = this.f13002c[i4];
                long j2 = d2 & 1048575;
                int i8 = (i6 < zzfn.DOUBLE_LIST_PACKED.id() || i6 > zzfn.SINT64_LIST_PACKED.id()) ? 0 : this.f13002c[i4 + 2] & 1048575;
                switch (i6) {
                    case 0:
                        if (a((Z<T>) t, i4)) {
                            zzb = zzfa.zzb(i7, 0.0d);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (a((Z<T>) t, i4)) {
                            zzb = zzfa.zzb(i7, 0.0f);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (a((Z<T>) t, i4)) {
                            zzb = zzfa.zzd(i7, Ja.b(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (a((Z<T>) t, i4)) {
                            zzb = zzfa.zze(i7, Ja.b(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (a((Z<T>) t, i4)) {
                            zzb = zzfa.zzk(i7, Ja.a(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (a((Z<T>) t, i4)) {
                            zzb = zzfa.zzg(i7, 0L);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (a((Z<T>) t, i4)) {
                            zzb = zzfa.zzn(i7, 0);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (a((Z<T>) t, i4)) {
                            zzb = zzfa.zzc(i7, true);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (a((Z<T>) t, i4)) {
                            Object f2 = Ja.f(t, j2);
                            if (f2 instanceof zzeh) {
                                zzb = zzfa.zzc(i7, (zzeh) f2);
                            } else {
                                zzb = zzfa.zzb(i7, (String) f2);
                            }
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (a((Z<T>) t, i4)) {
                            zzb = C1267oa.a(i7, Ja.f(t, j2), a(i4));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (a((Z<T>) t, i4)) {
                            zzb = zzfa.zzc(i7, (zzeh) Ja.f(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (a((Z<T>) t, i4)) {
                            zzb = zzfa.zzl(i7, Ja.a(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (a((Z<T>) t, i4)) {
                            zzb = zzfa.zzp(i7, Ja.a(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (a((Z<T>) t, i4)) {
                            zzb = zzfa.zzo(i7, 0);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (a((Z<T>) t, i4)) {
                            zzb = zzfa.zzh(i7, 0L);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (a((Z<T>) t, i4)) {
                            zzb = zzfa.zzm(i7, Ja.a(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (a((Z<T>) t, i4)) {
                            zzb = zzfa.zzf(i7, Ja.b(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (a((Z<T>) t, i4)) {
                            zzb = zzfa.zzc(i7, (zzhc) Ja.f(t, j2), a(i4));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzb = C1267oa.i(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 19:
                        zzb = C1267oa.h(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 20:
                        zzb = C1267oa.a(i7, (List<Long>) a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 21:
                        zzb = C1267oa.b(i7, (List<Long>) a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 22:
                        zzb = C1267oa.e(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 23:
                        zzb = C1267oa.i(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 24:
                        zzb = C1267oa.h(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 25:
                        zzb = C1267oa.j(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 26:
                        zzb = C1267oa.a(i7, (List<?>) a(t, j2));
                        i5 += zzb;
                        break;
                    case 27:
                        zzb = C1267oa.a(i7, (List<?>) a(t, j2), a(i4));
                        i5 += zzb;
                        break;
                    case 28:
                        zzb = C1267oa.b(i7, a(t, j2));
                        i5 += zzb;
                        break;
                    case 29:
                        zzb = C1267oa.f(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 30:
                        zzb = C1267oa.d(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 31:
                        zzb = C1267oa.h(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 32:
                        zzb = C1267oa.i(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 33:
                        zzb = C1267oa.g(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 34:
                        zzb = C1267oa.c(i7, a(t, j2), false);
                        i5 += zzb;
                        break;
                    case 35:
                        b3 = C1267oa.b((List) unsafe.getObject(t, j2));
                        if (b3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, b3);
                            }
                            zzag2 = zzfa.zzag(i7);
                            zzai2 = zzfa.zzai(b3);
                            zzb = zzag2 + zzai2 + b3;
                            i5 += zzb;
                            break;
                        }
                    case 36:
                        b3 = C1267oa.a((List<?>) unsafe.getObject(t, j2));
                        if (b3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, b3);
                            }
                            zzag2 = zzfa.zzag(i7);
                            zzai2 = zzfa.zzai(b3);
                            zzb = zzag2 + zzai2 + b3;
                            i5 += zzb;
                            break;
                        }
                    case 37:
                        b3 = C1267oa.d((List) unsafe.getObject(t, j2));
                        if (b3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, b3);
                            }
                            zzag2 = zzfa.zzag(i7);
                            zzai2 = zzfa.zzai(b3);
                            zzb = zzag2 + zzai2 + b3;
                            i5 += zzb;
                            break;
                        }
                    case 38:
                        b3 = C1267oa.e((List) unsafe.getObject(t, j2));
                        if (b3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, b3);
                            }
                            zzag2 = zzfa.zzag(i7);
                            zzai2 = zzfa.zzai(b3);
                            zzb = zzag2 + zzai2 + b3;
                            i5 += zzb;
                            break;
                        }
                    case 39:
                        b3 = C1267oa.h((List) unsafe.getObject(t, j2));
                        if (b3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, b3);
                            }
                            zzag2 = zzfa.zzag(i7);
                            zzai2 = zzfa.zzai(b3);
                            zzb = zzag2 + zzai2 + b3;
                            i5 += zzb;
                            break;
                        }
                    case 40:
                        b3 = C1267oa.b((List) unsafe.getObject(t, j2));
                        if (b3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, b3);
                            }
                            zzag2 = zzfa.zzag(i7);
                            zzai2 = zzfa.zzai(b3);
                            zzb = zzag2 + zzai2 + b3;
                            i5 += zzb;
                            break;
                        }
                    case 41:
                        b3 = C1267oa.a((List<?>) unsafe.getObject(t, j2));
                        if (b3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, b3);
                            }
                            zzag2 = zzfa.zzag(i7);
                            zzai2 = zzfa.zzai(b3);
                            zzb = zzag2 + zzai2 + b3;
                            i5 += zzb;
                            break;
                        }
                    case 42:
                        b3 = C1267oa.c((List) unsafe.getObject(t, j2));
                        if (b3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, b3);
                            }
                            zzag2 = zzfa.zzag(i7);
                            zzai2 = zzfa.zzai(b3);
                            zzb = zzag2 + zzai2 + b3;
                            i5 += zzb;
                            break;
                        }
                    case 43:
                        b3 = C1267oa.i((List) unsafe.getObject(t, j2));
                        if (b3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, b3);
                            }
                            zzag2 = zzfa.zzag(i7);
                            zzai2 = zzfa.zzai(b3);
                            zzb = zzag2 + zzai2 + b3;
                            i5 += zzb;
                            break;
                        }
                    case 44:
                        b3 = C1267oa.g((List) unsafe.getObject(t, j2));
                        if (b3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, b3);
                            }
                            zzag2 = zzfa.zzag(i7);
                            zzai2 = zzfa.zzai(b3);
                            zzb = zzag2 + zzai2 + b3;
                            i5 += zzb;
                            break;
                        }
                    case 45:
                        b3 = C1267oa.a((List<?>) unsafe.getObject(t, j2));
                        if (b3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, b3);
                            }
                            zzag2 = zzfa.zzag(i7);
                            zzai2 = zzfa.zzai(b3);
                            zzb = zzag2 + zzai2 + b3;
                            i5 += zzb;
                            break;
                        }
                    case 46:
                        b3 = C1267oa.b((List) unsafe.getObject(t, j2));
                        if (b3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, b3);
                            }
                            zzag2 = zzfa.zzag(i7);
                            zzai2 = zzfa.zzai(b3);
                            zzb = zzag2 + zzai2 + b3;
                            i5 += zzb;
                            break;
                        }
                    case 47:
                        b3 = C1267oa.j((List) unsafe.getObject(t, j2));
                        if (b3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, b3);
                            }
                            zzag2 = zzfa.zzag(i7);
                            zzai2 = zzfa.zzai(b3);
                            zzb = zzag2 + zzai2 + b3;
                            i5 += zzb;
                            break;
                        }
                    case 48:
                        b3 = C1267oa.f((List) unsafe.getObject(t, j2));
                        if (b3 <= 0) {
                            break;
                        } else {
                            if (this.k) {
                                unsafe.putInt(t, i8, b3);
                            }
                            zzag2 = zzfa.zzag(i7);
                            zzai2 = zzfa.zzai(b3);
                            zzb = zzag2 + zzai2 + b3;
                            i5 += zzb;
                            break;
                        }
                    case 49:
                        zzb = C1267oa.b(i7, (List<zzhc>) a(t, j2), a(i4));
                        i5 += zzb;
                        break;
                    case 50:
                        zzb = this.s.a(i7, Ja.f(t, j2), b(i4));
                        i5 += zzb;
                        break;
                    case 51:
                        if (a((Z<T>) t, i7, i4)) {
                            zzb = zzfa.zzb(i7, 0.0d);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (a((Z<T>) t, i7, i4)) {
                            zzb = zzfa.zzb(i7, 0.0f);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (a((Z<T>) t, i7, i4)) {
                            zzb = zzfa.zzd(i7, e(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (a((Z<T>) t, i7, i4)) {
                            zzb = zzfa.zze(i7, e(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (a((Z<T>) t, i7, i4)) {
                            zzb = zzfa.zzk(i7, d(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (a((Z<T>) t, i7, i4)) {
                            zzb = zzfa.zzg(i7, 0L);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (a((Z<T>) t, i7, i4)) {
                            zzb = zzfa.zzn(i7, 0);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (a((Z<T>) t, i7, i4)) {
                            zzb = zzfa.zzc(i7, true);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (a((Z<T>) t, i7, i4)) {
                            Object f3 = Ja.f(t, j2);
                            if (f3 instanceof zzeh) {
                                zzb = zzfa.zzc(i7, (zzeh) f3);
                            } else {
                                zzb = zzfa.zzb(i7, (String) f3);
                            }
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (a((Z<T>) t, i7, i4)) {
                            zzb = C1267oa.a(i7, Ja.f(t, j2), a(i4));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (a((Z<T>) t, i7, i4)) {
                            zzb = zzfa.zzc(i7, (zzeh) Ja.f(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (a((Z<T>) t, i7, i4)) {
                            zzb = zzfa.zzl(i7, d(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (a((Z<T>) t, i7, i4)) {
                            zzb = zzfa.zzp(i7, d(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (a((Z<T>) t, i7, i4)) {
                            zzb = zzfa.zzo(i7, 0);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (a((Z<T>) t, i7, i4)) {
                            zzb = zzfa.zzh(i7, 0L);
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (a((Z<T>) t, i7, i4)) {
                            zzb = zzfa.zzm(i7, d(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (a((Z<T>) t, i7, i4)) {
                            zzb = zzfa.zzf(i7, e(t, j2));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (a((Z<T>) t, i7, i4)) {
                            zzb = zzfa.zzc(i7, (zzhc) Ja.f(t, j2), a(i4));
                            i5 += zzb;
                            break;
                        } else {
                            break;
                        }
                }
                i4 += 3;
                i3 = 267386880;
            }
            return i5 + a((Fa) this.q, (Object) t);
        }
        Unsafe unsafe2 = f13001b;
        int i9 = 0;
        int i10 = -1;
        int i11 = 0;
        for (int i12 = 0; i12 < this.f13002c.length; i12 += 3) {
            int d3 = d(i12);
            int[] iArr = this.f13002c;
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
                i = (!this.k || i14 < zzfn.DOUBLE_LIST_PACKED.id() || i14 > zzfn.SINT64_LIST_PACKED.id()) ? 0 : this.f13002c[i12 + 2] & 1048575;
                i2 = 0;
            }
            long j3 = d3 & 1048575;
            switch (i14) {
                case 0:
                    j = 0;
                    if ((i11 & i2) != 0) {
                        i9 += zzfa.zzb(i13, 0.0d);
                        break;
                    }
                    break;
                case 1:
                    j = 0;
                    if ((i11 & i2) != 0) {
                        i9 += zzfa.zzb(i13, 0.0f);
                        break;
                    }
                case 2:
                    j = 0;
                    if ((i11 & i2) != 0) {
                        zzd = zzfa.zzd(i13, unsafe2.getLong(t, j3));
                        i9 += zzd;
                    }
                    break;
                case 3:
                    j = 0;
                    if ((i11 & i2) != 0) {
                        zzd = zzfa.zze(i13, unsafe2.getLong(t, j3));
                        i9 += zzd;
                    }
                    break;
                case 4:
                    j = 0;
                    if ((i11 & i2) != 0) {
                        zzd = zzfa.zzk(i13, unsafe2.getInt(t, j3));
                        i9 += zzd;
                    }
                    break;
                case 5:
                    if ((i11 & i2) != 0) {
                        j = 0;
                        zzd = zzfa.zzg(i13, 0L);
                        i9 += zzd;
                        break;
                    } else {
                        j = 0;
                    }
                case 6:
                    if ((i11 & i2) != 0) {
                        i9 += zzfa.zzn(i13, 0);
                        j = 0;
                        break;
                    }
                    j = 0;
                case 7:
                    if ((i11 & i2) != 0) {
                        zzc = zzfa.zzc(i13, true);
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 8:
                    if ((i11 & i2) != 0) {
                        Object object = unsafe2.getObject(t, j3);
                        if (object instanceof zzeh) {
                            zzc = zzfa.zzc(i13, (zzeh) object);
                        } else {
                            zzc = zzfa.zzb(i13, (String) object);
                        }
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 9:
                    if ((i11 & i2) != 0) {
                        zzc = C1267oa.a(i13, unsafe2.getObject(t, j3), a(i12));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 10:
                    if ((i11 & i2) != 0) {
                        zzc = zzfa.zzc(i13, (zzeh) unsafe2.getObject(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 11:
                    if ((i11 & i2) != 0) {
                        zzc = zzfa.zzl(i13, unsafe2.getInt(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 12:
                    if ((i11 & i2) != 0) {
                        zzc = zzfa.zzp(i13, unsafe2.getInt(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 13:
                    if ((i11 & i2) != 0) {
                        zzo = zzfa.zzo(i13, 0);
                        i9 += zzo;
                    }
                    j = 0;
                    break;
                case 14:
                    if ((i11 & i2) != 0) {
                        zzc = zzfa.zzh(i13, 0L);
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 15:
                    if ((i11 & i2) != 0) {
                        zzc = zzfa.zzm(i13, unsafe2.getInt(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 16:
                    if ((i11 & i2) != 0) {
                        zzc = zzfa.zzf(i13, unsafe2.getLong(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 17:
                    if ((i11 & i2) != 0) {
                        zzc = zzfa.zzc(i13, (zzhc) unsafe2.getObject(t, j3), a(i12));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 18:
                    zzc = C1267oa.i(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 19:
                    zzc = C1267oa.h(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 20:
                    zzc = C1267oa.a(i13, (List<Long>) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 21:
                    zzc = C1267oa.b(i13, (List<Long>) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 22:
                    zzc = C1267oa.e(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 23:
                    zzc = C1267oa.i(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 24:
                    zzc = C1267oa.h(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 25:
                    zzc = C1267oa.j(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 26:
                    zzc = C1267oa.a(i13, (List<?>) unsafe2.getObject(t, j3));
                    i9 += zzc;
                    j = 0;
                    break;
                case 27:
                    zzc = C1267oa.a(i13, (List<?>) unsafe2.getObject(t, j3), a(i12));
                    i9 += zzc;
                    j = 0;
                    break;
                case 28:
                    zzc = C1267oa.b(i13, (List) unsafe2.getObject(t, j3));
                    i9 += zzc;
                    j = 0;
                    break;
                case 29:
                    zzc = C1267oa.f(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 30:
                    zzc = C1267oa.d(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 31:
                    zzc = C1267oa.h(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 32:
                    zzc = C1267oa.i(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 33:
                    zzc = C1267oa.g(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 34:
                    zzc = C1267oa.c(i13, (List) unsafe2.getObject(t, j3), false);
                    i9 += zzc;
                    j = 0;
                    break;
                case 35:
                    b2 = C1267oa.b((List) unsafe2.getObject(t, j3));
                    if (b2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, b2);
                        }
                        zzag = zzfa.zzag(i13);
                        zzai = zzfa.zzai(b2);
                        zzo = zzag + zzai + b2;
                        i9 += zzo;
                    }
                    j = 0;
                    break;
                case 36:
                    b2 = C1267oa.a((List<?>) unsafe2.getObject(t, j3));
                    if (b2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, b2);
                        }
                        zzag = zzfa.zzag(i13);
                        zzai = zzfa.zzai(b2);
                        zzo = zzag + zzai + b2;
                        i9 += zzo;
                    }
                    j = 0;
                    break;
                case 37:
                    b2 = C1267oa.d((List) unsafe2.getObject(t, j3));
                    if (b2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, b2);
                        }
                        zzag = zzfa.zzag(i13);
                        zzai = zzfa.zzai(b2);
                        zzo = zzag + zzai + b2;
                        i9 += zzo;
                    }
                    j = 0;
                    break;
                case 38:
                    b2 = C1267oa.e((List) unsafe2.getObject(t, j3));
                    if (b2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, b2);
                        }
                        zzag = zzfa.zzag(i13);
                        zzai = zzfa.zzai(b2);
                        zzo = zzag + zzai + b2;
                        i9 += zzo;
                    }
                    j = 0;
                    break;
                case 39:
                    b2 = C1267oa.h((List) unsafe2.getObject(t, j3));
                    if (b2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, b2);
                        }
                        zzag = zzfa.zzag(i13);
                        zzai = zzfa.zzai(b2);
                        zzo = zzag + zzai + b2;
                        i9 += zzo;
                    }
                    j = 0;
                    break;
                case 40:
                    b2 = C1267oa.b((List) unsafe2.getObject(t, j3));
                    if (b2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, b2);
                        }
                        zzag = zzfa.zzag(i13);
                        zzai = zzfa.zzai(b2);
                        zzo = zzag + zzai + b2;
                        i9 += zzo;
                    }
                    j = 0;
                    break;
                case 41:
                    b2 = C1267oa.a((List<?>) unsafe2.getObject(t, j3));
                    if (b2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, b2);
                        }
                        zzag = zzfa.zzag(i13);
                        zzai = zzfa.zzai(b2);
                        zzo = zzag + zzai + b2;
                        i9 += zzo;
                    }
                    j = 0;
                    break;
                case 42:
                    b2 = C1267oa.c((List) unsafe2.getObject(t, j3));
                    if (b2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, b2);
                        }
                        zzag = zzfa.zzag(i13);
                        zzai = zzfa.zzai(b2);
                        zzo = zzag + zzai + b2;
                        i9 += zzo;
                    }
                    j = 0;
                    break;
                case 43:
                    b2 = C1267oa.i((List) unsafe2.getObject(t, j3));
                    if (b2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, b2);
                        }
                        zzag = zzfa.zzag(i13);
                        zzai = zzfa.zzai(b2);
                        zzo = zzag + zzai + b2;
                        i9 += zzo;
                    }
                    j = 0;
                    break;
                case 44:
                    b2 = C1267oa.g((List) unsafe2.getObject(t, j3));
                    if (b2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, b2);
                        }
                        zzag = zzfa.zzag(i13);
                        zzai = zzfa.zzai(b2);
                        zzo = zzag + zzai + b2;
                        i9 += zzo;
                    }
                    j = 0;
                    break;
                case 45:
                    b2 = C1267oa.a((List<?>) unsafe2.getObject(t, j3));
                    if (b2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, b2);
                        }
                        zzag = zzfa.zzag(i13);
                        zzai = zzfa.zzai(b2);
                        zzo = zzag + zzai + b2;
                        i9 += zzo;
                    }
                    j = 0;
                    break;
                case 46:
                    b2 = C1267oa.b((List) unsafe2.getObject(t, j3));
                    if (b2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, b2);
                        }
                        zzag = zzfa.zzag(i13);
                        zzai = zzfa.zzai(b2);
                        zzo = zzag + zzai + b2;
                        i9 += zzo;
                    }
                    j = 0;
                    break;
                case 47:
                    b2 = C1267oa.j((List) unsafe2.getObject(t, j3));
                    if (b2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, b2);
                        }
                        zzag = zzfa.zzag(i13);
                        zzai = zzfa.zzai(b2);
                        zzo = zzag + zzai + b2;
                        i9 += zzo;
                    }
                    j = 0;
                    break;
                case 48:
                    b2 = C1267oa.f((List) unsafe2.getObject(t, j3));
                    if (b2 > 0) {
                        if (this.k) {
                            unsafe2.putInt(t, i, b2);
                        }
                        zzag = zzfa.zzag(i13);
                        zzai = zzfa.zzai(b2);
                        zzo = zzag + zzai + b2;
                        i9 += zzo;
                    }
                    j = 0;
                    break;
                case 49:
                    zzc = C1267oa.b(i13, (List<zzhc>) unsafe2.getObject(t, j3), a(i12));
                    i9 += zzc;
                    j = 0;
                    break;
                case 50:
                    zzc = this.s.a(i13, unsafe2.getObject(t, j3), b(i12));
                    i9 += zzc;
                    j = 0;
                    break;
                case 51:
                    if (a((Z<T>) t, i13, i12)) {
                        zzc = zzfa.zzb(i13, 0.0d);
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 52:
                    if (a((Z<T>) t, i13, i12)) {
                        zzo = zzfa.zzb(i13, 0.0f);
                        i9 += zzo;
                    }
                    j = 0;
                    break;
                case 53:
                    if (a((Z<T>) t, i13, i12)) {
                        zzc = zzfa.zzd(i13, e(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 54:
                    if (a((Z<T>) t, i13, i12)) {
                        zzc = zzfa.zze(i13, e(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 55:
                    if (a((Z<T>) t, i13, i12)) {
                        zzc = zzfa.zzk(i13, d(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 56:
                    if (a((Z<T>) t, i13, i12)) {
                        zzc = zzfa.zzg(i13, 0L);
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 57:
                    if (a((Z<T>) t, i13, i12)) {
                        zzo = zzfa.zzn(i13, 0);
                        i9 += zzo;
                    }
                    j = 0;
                    break;
                case 58:
                    if (a((Z<T>) t, i13, i12)) {
                        zzc = zzfa.zzc(i13, true);
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 59:
                    if (a((Z<T>) t, i13, i12)) {
                        Object object2 = unsafe2.getObject(t, j3);
                        if (object2 instanceof zzeh) {
                            zzc = zzfa.zzc(i13, (zzeh) object2);
                        } else {
                            zzc = zzfa.zzb(i13, (String) object2);
                        }
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 60:
                    if (a((Z<T>) t, i13, i12)) {
                        zzc = C1267oa.a(i13, unsafe2.getObject(t, j3), a(i12));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 61:
                    if (a((Z<T>) t, i13, i12)) {
                        zzc = zzfa.zzc(i13, (zzeh) unsafe2.getObject(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 62:
                    if (a((Z<T>) t, i13, i12)) {
                        zzc = zzfa.zzl(i13, d(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 63:
                    if (a((Z<T>) t, i13, i12)) {
                        zzc = zzfa.zzp(i13, d(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 64:
                    if (a((Z<T>) t, i13, i12)) {
                        zzo = zzfa.zzo(i13, 0);
                        i9 += zzo;
                    }
                    j = 0;
                    break;
                case 65:
                    if (a((Z<T>) t, i13, i12)) {
                        zzc = zzfa.zzh(i13, 0L);
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 66:
                    if (a((Z<T>) t, i13, i12)) {
                        zzc = zzfa.zzm(i13, d(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 67:
                    if (a((Z<T>) t, i13, i12)) {
                        zzc = zzfa.zzf(i13, e(t, j3));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                case 68:
                    if (a((Z<T>) t, i13, i12)) {
                        zzc = zzfa.zzc(i13, (zzhc) unsafe2.getObject(t, j3), a(i12));
                        i9 += zzc;
                    }
                    j = 0;
                    break;
                default:
                    j = 0;
                    break;
            }
        }
        int a2 = i9 + a((Fa) this.q, (Object) t);
        return this.f13007h ? a2 + this.r.a(t).h() : a2;
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1263ma
    public final T newInstance() {
        return (T) this.o.a(this.f13006g);
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1263ma
    public final void zzf(T t) {
        int i;
        int i2 = this.m;
        while (true) {
            i = this.n;
            if (i2 >= i) {
                break;
            }
            long d2 = d(this.l[i2]) & 1048575;
            Object f2 = Ja.f(t, d2);
            if (f2 != null) {
                this.s.b(f2);
                Ja.a(t, d2, f2);
            }
            i2++;
        }
        int length = this.l.length;
        while (i < length) {
            this.p.b(t, this.l[i]);
            i++;
        }
        this.q.a(t);
        if (this.f13007h) {
            this.r.c(t);
        }
    }

    private static <T> int d(T t, long j) {
        return ((Integer) Ja.f(t, j)).intValue();
    }

    private static <T> long e(T t, long j) {
        return ((Long) Ja.f(t, j)).longValue();
    }

    private final void b(T t, T t2, int i) {
        int d2 = d(i);
        int i2 = this.f13002c[i];
        long j = d2 & 1048575;
        if (a((Z<T>) t2, i2, i)) {
            Object f2 = Ja.f(t, j);
            Object f3 = Ja.f(t2, j);
            if (f2 != null && f3 != null) {
                Ja.a(t, j, zzfv.zza(f2, f3));
                b((Z<T>) t, i2, i);
            } else if (f3 != null) {
                Ja.a(t, j, f3);
                b((Z<T>) t, i2, i);
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
    private final void b(T r18, com.google.android.gms.internal.firebase_auth.Ra r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.Z.b(java.lang.Object, com.google.android.gms.internal.firebase_auth.Ra):void");
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

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:            if (com.google.android.gms.internal.firebase_auth.C1267oa.a(com.google.android.gms.internal.firebase_auth.Ja.f(r10, r6), com.google.android.gms.internal.firebase_auth.Ja.f(r11, r6)) != false) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:            if (com.google.android.gms.internal.firebase_auth.Ja.b(r10, r6) == com.google.android.gms.internal.firebase_auth.Ja.b(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:            if (com.google.android.gms.internal.firebase_auth.Ja.a(r10, r6) == com.google.android.gms.internal.firebase_auth.Ja.a(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a4, code lost:            if (com.google.android.gms.internal.firebase_auth.Ja.b(r10, r6) == com.google.android.gms.internal.firebase_auth.Ja.b(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b6, code lost:            if (com.google.android.gms.internal.firebase_auth.Ja.a(r10, r6) == com.google.android.gms.internal.firebase_auth.Ja.a(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c8, code lost:            if (com.google.android.gms.internal.firebase_auth.Ja.a(r10, r6) == com.google.android.gms.internal.firebase_auth.Ja.a(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00da, code lost:            if (com.google.android.gms.internal.firebase_auth.Ja.a(r10, r6) == com.google.android.gms.internal.firebase_auth.Ja.a(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f0, code lost:            if (com.google.android.gms.internal.firebase_auth.C1267oa.a(com.google.android.gms.internal.firebase_auth.Ja.f(r10, r6), com.google.android.gms.internal.firebase_auth.Ja.f(r11, r6)) != false) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0106, code lost:            if (com.google.android.gms.internal.firebase_auth.C1267oa.a(com.google.android.gms.internal.firebase_auth.Ja.f(r10, r6), com.google.android.gms.internal.firebase_auth.Ja.f(r11, r6)) != false) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x011c, code lost:            if (com.google.android.gms.internal.firebase_auth.C1267oa.a(com.google.android.gms.internal.firebase_auth.Ja.f(r10, r6), com.google.android.gms.internal.firebase_auth.Ja.f(r11, r6)) != false) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012e, code lost:            if (com.google.android.gms.internal.firebase_auth.Ja.c(r10, r6) == com.google.android.gms.internal.firebase_auth.Ja.c(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0140, code lost:            if (com.google.android.gms.internal.firebase_auth.Ja.a(r10, r6) == com.google.android.gms.internal.firebase_auth.Ja.a(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0154, code lost:            if (com.google.android.gms.internal.firebase_auth.Ja.b(r10, r6) == com.google.android.gms.internal.firebase_auth.Ja.b(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0165, code lost:            if (com.google.android.gms.internal.firebase_auth.Ja.a(r10, r6) == com.google.android.gms.internal.firebase_auth.Ja.a(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0178, code lost:            if (com.google.android.gms.internal.firebase_auth.Ja.b(r10, r6) == com.google.android.gms.internal.firebase_auth.Ja.b(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x018b, code lost:            if (com.google.android.gms.internal.firebase_auth.Ja.b(r10, r6) == com.google.android.gms.internal.firebase_auth.Ja.b(r11, r6)) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a4, code lost:            if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.firebase_auth.Ja.d(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.firebase_auth.Ja.d(r11, r6))) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01bf, code lost:            if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.firebase_auth.Ja.e(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.firebase_auth.Ja.e(r11, r6))) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:            if (com.google.android.gms.internal.firebase_auth.C1267oa.a(com.google.android.gms.internal.firebase_auth.Ja.f(r10, r6), com.google.android.gms.internal.firebase_auth.Ja.f(r11, r6)) != false) goto L105;     */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01c5 A[LOOP:0: B:2:0x0005->B:86:0x01c5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c4 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1263ma
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.Z.a(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001b. Please report as an issue. */
    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1263ma
    public final int a(T t) {
        int i;
        int zzk;
        int length = this.f13002c.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int d2 = d(i3);
            int i4 = this.f13002c[i3];
            long j = 1048575 & d2;
            int i5 = 37;
            switch ((d2 & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    zzk = zzfv.zzk(Double.doubleToLongBits(Ja.e(t, j)));
                    i2 = i + zzk;
                    break;
                case 1:
                    i = i2 * 53;
                    zzk = Float.floatToIntBits(Ja.d(t, j));
                    i2 = i + zzk;
                    break;
                case 2:
                    i = i2 * 53;
                    zzk = zzfv.zzk(Ja.b(t, j));
                    i2 = i + zzk;
                    break;
                case 3:
                    i = i2 * 53;
                    zzk = zzfv.zzk(Ja.b(t, j));
                    i2 = i + zzk;
                    break;
                case 4:
                    i = i2 * 53;
                    zzk = Ja.a(t, j);
                    i2 = i + zzk;
                    break;
                case 5:
                    i = i2 * 53;
                    zzk = zzfv.zzk(Ja.b(t, j));
                    i2 = i + zzk;
                    break;
                case 6:
                    i = i2 * 53;
                    zzk = Ja.a(t, j);
                    i2 = i + zzk;
                    break;
                case 7:
                    i = i2 * 53;
                    zzk = zzfv.zzu(Ja.c(t, j));
                    i2 = i + zzk;
                    break;
                case 8:
                    i = i2 * 53;
                    zzk = ((String) Ja.f(t, j)).hashCode();
                    i2 = i + zzk;
                    break;
                case 9:
                    Object f2 = Ja.f(t, j);
                    if (f2 != null) {
                        i5 = f2.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
                    break;
                case 10:
                    i = i2 * 53;
                    zzk = Ja.f(t, j).hashCode();
                    i2 = i + zzk;
                    break;
                case 11:
                    i = i2 * 53;
                    zzk = Ja.a(t, j);
                    i2 = i + zzk;
                    break;
                case 12:
                    i = i2 * 53;
                    zzk = Ja.a(t, j);
                    i2 = i + zzk;
                    break;
                case 13:
                    i = i2 * 53;
                    zzk = Ja.a(t, j);
                    i2 = i + zzk;
                    break;
                case 14:
                    i = i2 * 53;
                    zzk = zzfv.zzk(Ja.b(t, j));
                    i2 = i + zzk;
                    break;
                case 15:
                    i = i2 * 53;
                    zzk = Ja.a(t, j);
                    i2 = i + zzk;
                    break;
                case 16:
                    i = i2 * 53;
                    zzk = zzfv.zzk(Ja.b(t, j));
                    i2 = i + zzk;
                    break;
                case 17:
                    Object f3 = Ja.f(t, j);
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
                    zzk = Ja.f(t, j).hashCode();
                    i2 = i + zzk;
                    break;
                case 50:
                    i = i2 * 53;
                    zzk = Ja.f(t, j).hashCode();
                    i2 = i + zzk;
                    break;
                case 51:
                    if (a((Z<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzk = zzfv.zzk(Double.doubleToLongBits(b(t, j)));
                        i2 = i + zzk;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (a((Z<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzk = Float.floatToIntBits(c(t, j));
                        i2 = i + zzk;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (a((Z<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzk = zzfv.zzk(e(t, j));
                        i2 = i + zzk;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (a((Z<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzk = zzfv.zzk(e(t, j));
                        i2 = i + zzk;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (a((Z<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzk = d(t, j);
                        i2 = i + zzk;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (a((Z<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzk = zzfv.zzk(e(t, j));
                        i2 = i + zzk;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (a((Z<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzk = d(t, j);
                        i2 = i + zzk;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (a((Z<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzk = zzfv.zzu(f(t, j));
                        i2 = i + zzk;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (a((Z<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzk = ((String) Ja.f(t, j)).hashCode();
                        i2 = i + zzk;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (a((Z<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzk = Ja.f(t, j).hashCode();
                        i2 = i + zzk;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (a((Z<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzk = Ja.f(t, j).hashCode();
                        i2 = i + zzk;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (a((Z<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzk = d(t, j);
                        i2 = i + zzk;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (a((Z<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzk = d(t, j);
                        i2 = i + zzk;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (a((Z<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzk = d(t, j);
                        i2 = i + zzk;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (a((Z<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzk = zzfv.zzk(e(t, j));
                        i2 = i + zzk;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (a((Z<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzk = d(t, j);
                        i2 = i + zzk;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (a((Z<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzk = zzfv.zzk(e(t, j));
                        i2 = i + zzk;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (a((Z<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzk = Ja.f(t, j).hashCode();
                        i2 = i + zzk;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i2 * 53) + this.q.d(t).hashCode();
        return this.f13007h ? (hashCode * 53) + this.r.a(t).hashCode() : hashCode;
    }

    private final void a(T t, T t2, int i) {
        long d2 = d(i) & 1048575;
        if (a((Z<T>) t2, i)) {
            Object f2 = Ja.f(t, d2);
            Object f3 = Ja.f(t2, d2);
            if (f2 != null && f3 != null) {
                Ja.a(t, d2, zzfv.zza(f2, f3));
                b((Z<T>) t, i);
            } else if (f3 != null) {
                Ja.a(t, d2, f3);
                b((Z<T>) t, i);
            }
        }
    }

    private static <UT, UB> int a(Fa<UT, UB> fa, T t) {
        return fa.c(fa.d(t));
    }

    private static <E> List<E> a(Object obj, long j) {
        return (List) Ja.f(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x04ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:538:0x0969  */
    /* JADX WARN: Removed duplicated region for block: B:540:0x096f  */
    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1263ma
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(T r13, com.google.android.gms.internal.firebase_auth.Ra r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2710
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.Z.a(java.lang.Object, com.google.android.gms.internal.firebase_auth.Ra):void");
    }

    private final Object b(int i) {
        return this.f13003d[(i / 3) << 1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1263ma
    public final boolean b(T t) {
        int i;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= this.m) {
                return !this.f13007h || this.r.a(t).d();
            }
            int i5 = this.l[i2];
            int i6 = this.f13002c[i5];
            int d2 = d(i5);
            if (this.j) {
                i = 0;
            } else {
                int i7 = this.f13002c[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i4 = f13001b.getInt(t, i8);
                    i3 = i8;
                }
            }
            if (((268435456 & d2) != 0) && !a((Z<T>) t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & d2) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (a((Z<T>) t, i6, i5) && !a(t, d2, a(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 == 50 && !this.s.zzk(Ja.f(t, d2 & 1048575)).isEmpty()) {
                            this.s.zzo(b(i5));
                            throw null;
                        }
                    }
                }
                List list = (List) Ja.f(t, d2 & 1048575);
                if (!list.isEmpty()) {
                    InterfaceC1263ma a2 = a(i5);
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
            } else if (a((Z<T>) t, i5, i4, i) && !a(t, d2, a(i5))) {
                return false;
            }
            i2++;
        }
    }

    private static <T> double b(T t, long j) {
        return ((Double) Ja.f(t, j)).doubleValue();
    }

    private final void b(T t, int i) {
        if (this.j) {
            return;
        }
        int e2 = e(i);
        long j = e2 & 1048575;
        Ja.a((Object) t, j, Ja.a(t, j) | (1 << (e2 >>> 20)));
    }

    private final void b(T t, int i, int i2) {
        Ja.a((Object) t, e(i2) & 1048575, i);
    }

    private final zzfy c(int i) {
        return (zzfy) this.f13003d[((i / 3) << 1) + 1];
    }

    private static <T> float c(T t, long j) {
        return ((Float) Ja.f(t, j)).floatValue();
    }

    private final boolean c(T t, T t2, int i) {
        return a((Z<T>) t, i) == a((Z<T>) t2, i);
    }

    private final <K, V> void a(Ra ra, int i, Object obj, int i2) throws IOException {
        if (obj == null) {
            return;
        }
        this.s.zzo(b(i2));
        throw null;
    }

    private static <UT, UB> void a(Fa<UT, UB> fa, T t, Ra ra) throws IOException {
        fa.a((Fa<UT, UB>) fa.d(t), ra);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x009e. Please report as an issue. */
    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1263ma
    public final void a(T t, InterfaceC1255ia interfaceC1255ia, zzfg zzfgVar) throws IOException {
        if (zzfgVar != null) {
            Fa fa = this.q;
            AbstractC1281w<?> abstractC1281w = this.r;
            Object obj = null;
            while (true) {
                try {
                    int c2 = interfaceC1255ia.c();
                    int i = -1;
                    if (c2 >= this.f13004e && c2 <= this.f13005f) {
                        int i2 = 0;
                        int length = (this.f13002c.length / 3) - 1;
                        while (true) {
                            if (i2 <= length) {
                                int i3 = (length + i2) >>> 1;
                                int i4 = i3 * 3;
                                int i5 = this.f13002c[i4];
                                if (c2 == i5) {
                                    i = i4;
                                } else if (c2 < i5) {
                                    length = i3 - 1;
                                } else {
                                    i2 = i3 + 1;
                                }
                            }
                        }
                    }
                    if (i < 0) {
                        if (c2 == Integer.MAX_VALUE) {
                            for (int i6 = this.m; i6 < this.n; i6++) {
                                a((Object) t, this.l[i6], (int) obj, (Fa<UT, int>) fa);
                            }
                            if (obj != null) {
                                fa.b((Object) t, (T) obj);
                                return;
                            }
                            return;
                        }
                        Object a2 = !this.f13007h ? null : abstractC1281w.a(zzfgVar, this.f13006g, c2);
                        if (a2 != null) {
                            abstractC1281w.a(interfaceC1255ia, a2, zzfgVar, abstractC1281w.b(t), obj, fa);
                            throw null;
                        }
                        fa.a(interfaceC1255ia);
                        if (obj == null) {
                            obj = fa.e(t);
                        }
                        if (!fa.a((Fa) obj, interfaceC1255ia)) {
                            for (int i7 = this.m; i7 < this.n; i7++) {
                                a((Object) t, this.l[i7], (int) obj, (Fa<UT, int>) fa);
                            }
                            if (obj != null) {
                                fa.b((Object) t, (T) obj);
                                return;
                            }
                            return;
                        }
                    } else {
                        int d2 = d(i);
                        switch ((267386880 & d2) >>> 20) {
                            case 0:
                                Ja.a(t, d2 & 1048575, interfaceC1255ia.readDouble());
                                b((Z<T>) t, i);
                                break;
                            case 1:
                                Ja.a((Object) t, d2 & 1048575, interfaceC1255ia.readFloat());
                                b((Z<T>) t, i);
                                break;
                            case 2:
                                Ja.a((Object) t, d2 & 1048575, interfaceC1255ia.g());
                                b((Z<T>) t, i);
                                break;
                            case 3:
                                Ja.a((Object) t, d2 & 1048575, interfaceC1255ia.f());
                                b((Z<T>) t, i);
                                break;
                            case 4:
                                Ja.a((Object) t, d2 & 1048575, interfaceC1255ia.j());
                                b((Z<T>) t, i);
                                break;
                            case 5:
                                Ja.a((Object) t, d2 & 1048575, interfaceC1255ia.k());
                                b((Z<T>) t, i);
                                break;
                            case 6:
                                Ja.a((Object) t, d2 & 1048575, interfaceC1255ia.h());
                                b((Z<T>) t, i);
                                break;
                            case 7:
                                Ja.a(t, d2 & 1048575, interfaceC1255ia.i());
                                b((Z<T>) t, i);
                                break;
                            case 8:
                                a(t, d2, interfaceC1255ia);
                                b((Z<T>) t, i);
                                break;
                            case 9:
                                if (a((Z<T>) t, i)) {
                                    long j = d2 & 1048575;
                                    Ja.a(t, j, zzfv.zza(Ja.f(t, j), interfaceC1255ia.a(a(i), zzfgVar)));
                                    break;
                                } else {
                                    Ja.a(t, d2 & 1048575, interfaceC1255ia.a(a(i), zzfgVar));
                                    b((Z<T>) t, i);
                                    break;
                                }
                            case 10:
                                Ja.a(t, d2 & 1048575, interfaceC1255ia.n());
                                b((Z<T>) t, i);
                                break;
                            case 11:
                                Ja.a((Object) t, d2 & 1048575, interfaceC1255ia.p());
                                b((Z<T>) t, i);
                                break;
                            case 12:
                                int l = interfaceC1255ia.l();
                                zzfy c3 = c(i);
                                if (c3 != null && !c3.zzc(l)) {
                                    obj = C1267oa.a(c2, l, obj, (Fa<UT, Object>) fa);
                                    break;
                                }
                                Ja.a((Object) t, d2 & 1048575, l);
                                b((Z<T>) t, i);
                                break;
                            case 13:
                                Ja.a((Object) t, d2 & 1048575, interfaceC1255ia.m());
                                b((Z<T>) t, i);
                                break;
                            case 14:
                                Ja.a((Object) t, d2 & 1048575, interfaceC1255ia.b());
                                b((Z<T>) t, i);
                                break;
                            case 15:
                                Ja.a((Object) t, d2 & 1048575, interfaceC1255ia.d());
                                b((Z<T>) t, i);
                                break;
                            case 16:
                                Ja.a((Object) t, d2 & 1048575, interfaceC1255ia.a());
                                b((Z<T>) t, i);
                                break;
                            case 17:
                                if (a((Z<T>) t, i)) {
                                    long j2 = d2 & 1048575;
                                    Ja.a(t, j2, zzfv.zza(Ja.f(t, j2), interfaceC1255ia.b(a(i), zzfgVar)));
                                    break;
                                } else {
                                    Ja.a(t, d2 & 1048575, interfaceC1255ia.b(a(i), zzfgVar));
                                    b((Z<T>) t, i);
                                    break;
                                }
                            case 18:
                                interfaceC1255ia.r(this.p.a(t, d2 & 1048575));
                                break;
                            case 19:
                                interfaceC1255ia.q(this.p.a(t, d2 & 1048575));
                                break;
                            case 20:
                                interfaceC1255ia.p(this.p.a(t, d2 & 1048575));
                                break;
                            case 21:
                                interfaceC1255ia.zzf(this.p.a(t, d2 & 1048575));
                                break;
                            case 22:
                                interfaceC1255ia.zzh(this.p.a(t, d2 & 1048575));
                                break;
                            case 23:
                                interfaceC1255ia.g(this.p.a(t, d2 & 1048575));
                                break;
                            case 24:
                                interfaceC1255ia.f(this.p.a(t, d2 & 1048575));
                                break;
                            case 25:
                                interfaceC1255ia.m(this.p.a(t, d2 & 1048575));
                                break;
                            case 26:
                                if (f(d2)) {
                                    interfaceC1255ia.l(this.p.a(t, d2 & 1048575));
                                    break;
                                } else {
                                    interfaceC1255ia.e(this.p.a(t, d2 & 1048575));
                                    break;
                                }
                            case 27:
                                interfaceC1255ia.b(this.p.a(t, d2 & 1048575), a(i), zzfgVar);
                                break;
                            case 28:
                                interfaceC1255ia.o(this.p.a(t, d2 & 1048575));
                                break;
                            case 29:
                                interfaceC1255ia.n(this.p.a(t, d2 & 1048575));
                                break;
                            case 30:
                                List<Integer> a3 = this.p.a(t, d2 & 1048575);
                                interfaceC1255ia.k(a3);
                                obj = C1267oa.a(c2, a3, c(i), obj, fa);
                                break;
                            case 31:
                                interfaceC1255ia.b(this.p.a(t, d2 & 1048575));
                                break;
                            case 32:
                                interfaceC1255ia.d(this.p.a(t, d2 & 1048575));
                                break;
                            case 33:
                                interfaceC1255ia.c(this.p.a(t, d2 & 1048575));
                                break;
                            case 34:
                                interfaceC1255ia.a(this.p.a(t, d2 & 1048575));
                                break;
                            case 35:
                                interfaceC1255ia.r(this.p.a(t, d2 & 1048575));
                                break;
                            case 36:
                                interfaceC1255ia.q(this.p.a(t, d2 & 1048575));
                                break;
                            case 37:
                                interfaceC1255ia.p(this.p.a(t, d2 & 1048575));
                                break;
                            case 38:
                                interfaceC1255ia.zzf(this.p.a(t, d2 & 1048575));
                                break;
                            case 39:
                                interfaceC1255ia.zzh(this.p.a(t, d2 & 1048575));
                                break;
                            case 40:
                                interfaceC1255ia.g(this.p.a(t, d2 & 1048575));
                                break;
                            case 41:
                                interfaceC1255ia.f(this.p.a(t, d2 & 1048575));
                                break;
                            case 42:
                                interfaceC1255ia.m(this.p.a(t, d2 & 1048575));
                                break;
                            case 43:
                                interfaceC1255ia.n(this.p.a(t, d2 & 1048575));
                                break;
                            case 44:
                                List<Integer> a4 = this.p.a(t, d2 & 1048575);
                                interfaceC1255ia.k(a4);
                                obj = C1267oa.a(c2, a4, c(i), obj, fa);
                                break;
                            case 45:
                                interfaceC1255ia.b(this.p.a(t, d2 & 1048575));
                                break;
                            case 46:
                                interfaceC1255ia.d(this.p.a(t, d2 & 1048575));
                                break;
                            case 47:
                                interfaceC1255ia.c(this.p.a(t, d2 & 1048575));
                                break;
                            case 48:
                                interfaceC1255ia.a(this.p.a(t, d2 & 1048575));
                                break;
                            case 49:
                                interfaceC1255ia.a(this.p.a(t, d2 & 1048575), a(i), zzfgVar);
                                break;
                            case 50:
                                Object b2 = b(i);
                                long d3 = d(i) & 1048575;
                                Object f2 = Ja.f(t, d3);
                                if (f2 != null) {
                                    if (this.s.zzl(f2)) {
                                        Object a5 = this.s.a(b2);
                                        this.s.a(a5, f2);
                                        Ja.a(t, d3, a5);
                                        f2 = a5;
                                    }
                                } else {
                                    f2 = this.s.a(b2);
                                    Ja.a(t, d3, f2);
                                }
                                this.s.zzj(f2);
                                this.s.zzo(b2);
                                throw null;
                            case 51:
                                Ja.a(t, d2 & 1048575, Double.valueOf(interfaceC1255ia.readDouble()));
                                b((Z<T>) t, c2, i);
                                break;
                            case 52:
                                Ja.a(t, d2 & 1048575, Float.valueOf(interfaceC1255ia.readFloat()));
                                b((Z<T>) t, c2, i);
                                break;
                            case 53:
                                Ja.a(t, d2 & 1048575, Long.valueOf(interfaceC1255ia.g()));
                                b((Z<T>) t, c2, i);
                                break;
                            case 54:
                                Ja.a(t, d2 & 1048575, Long.valueOf(interfaceC1255ia.f()));
                                b((Z<T>) t, c2, i);
                                break;
                            case 55:
                                Ja.a(t, d2 & 1048575, Integer.valueOf(interfaceC1255ia.j()));
                                b((Z<T>) t, c2, i);
                                break;
                            case 56:
                                Ja.a(t, d2 & 1048575, Long.valueOf(interfaceC1255ia.k()));
                                b((Z<T>) t, c2, i);
                                break;
                            case 57:
                                Ja.a(t, d2 & 1048575, Integer.valueOf(interfaceC1255ia.h()));
                                b((Z<T>) t, c2, i);
                                break;
                            case 58:
                                Ja.a(t, d2 & 1048575, Boolean.valueOf(interfaceC1255ia.i()));
                                b((Z<T>) t, c2, i);
                                break;
                            case 59:
                                a(t, d2, interfaceC1255ia);
                                b((Z<T>) t, c2, i);
                                break;
                            case 60:
                                if (a((Z<T>) t, c2, i)) {
                                    long j3 = d2 & 1048575;
                                    Ja.a(t, j3, zzfv.zza(Ja.f(t, j3), interfaceC1255ia.a(a(i), zzfgVar)));
                                } else {
                                    Ja.a(t, d2 & 1048575, interfaceC1255ia.a(a(i), zzfgVar));
                                    b((Z<T>) t, i);
                                }
                                b((Z<T>) t, c2, i);
                                break;
                            case 61:
                                Ja.a(t, d2 & 1048575, interfaceC1255ia.n());
                                b((Z<T>) t, c2, i);
                                break;
                            case 62:
                                Ja.a(t, d2 & 1048575, Integer.valueOf(interfaceC1255ia.p()));
                                b((Z<T>) t, c2, i);
                                break;
                            case 63:
                                int l2 = interfaceC1255ia.l();
                                zzfy c4 = c(i);
                                if (c4 != null && !c4.zzc(l2)) {
                                    obj = C1267oa.a(c2, l2, obj, (Fa<UT, Object>) fa);
                                    break;
                                }
                                Ja.a(t, d2 & 1048575, Integer.valueOf(l2));
                                b((Z<T>) t, c2, i);
                                break;
                            case 64:
                                Ja.a(t, d2 & 1048575, Integer.valueOf(interfaceC1255ia.m()));
                                b((Z<T>) t, c2, i);
                                break;
                            case 65:
                                Ja.a(t, d2 & 1048575, Long.valueOf(interfaceC1255ia.b()));
                                b((Z<T>) t, c2, i);
                                break;
                            case 66:
                                Ja.a(t, d2 & 1048575, Integer.valueOf(interfaceC1255ia.d()));
                                b((Z<T>) t, c2, i);
                                break;
                            case 67:
                                Ja.a(t, d2 & 1048575, Long.valueOf(interfaceC1255ia.a()));
                                b((Z<T>) t, c2, i);
                                break;
                            case 68:
                                Ja.a(t, d2 & 1048575, interfaceC1255ia.b(a(i), zzfgVar));
                                b((Z<T>) t, c2, i);
                                break;
                            default:
                                if (obj == null) {
                                    try {
                                        obj = fa.a();
                                    } catch (zzgd unused) {
                                        fa.a(interfaceC1255ia);
                                        if (obj == null) {
                                            obj = fa.e(t);
                                        }
                                        if (!fa.a((Fa) obj, interfaceC1255ia)) {
                                            for (int i8 = this.m; i8 < this.n; i8++) {
                                                a((Object) t, this.l[i8], (int) obj, (Fa<UT, int>) fa);
                                            }
                                            if (obj != null) {
                                                fa.b((Object) t, (T) obj);
                                                return;
                                            }
                                            return;
                                        }
                                        break;
                                    }
                                }
                                if (!fa.a((Fa) obj, interfaceC1255ia)) {
                                    for (int i9 = this.m; i9 < this.n; i9++) {
                                        a((Object) t, this.l[i9], (int) obj, (Fa<UT, int>) fa);
                                    }
                                    if (obj != null) {
                                        fa.b((Object) t, (T) obj);
                                        return;
                                    }
                                    return;
                                }
                                break;
                        }
                    }
                } catch (Throwable th) {
                    for (int i10 = this.m; i10 < this.n; i10++) {
                        a((Object) t, this.l[i10], (int) obj, (Fa<UT, int>) fa);
                    }
                    if (obj != null) {
                        fa.b((Object) t, (T) obj);
                    }
                    throw th;
                }
            }
        } else {
            throw new NullPointerException();
        }
    }

    private final InterfaceC1263ma a(int i) {
        int i2 = (i / 3) << 1;
        InterfaceC1263ma interfaceC1263ma = (InterfaceC1263ma) this.f13003d[i2];
        if (interfaceC1263ma != null) {
            return interfaceC1263ma;
        }
        InterfaceC1263ma<T> a2 = C1249fa.a().a((Class) this.f13003d[i2 + 1]);
        this.f13003d[i2] = a2;
        return a2;
    }

    private final <UT, UB> UB a(Object obj, int i, UB ub, Fa<UT, UB> fa) {
        zzfy c2;
        int i2 = this.f13002c[i];
        Object f2 = Ja.f(obj, d(i) & 1048575);
        if (f2 == null || (c2 = c(i)) == null) {
            return ub;
        }
        a(i, i2, this.s.zzj(f2), c2, ub, fa);
        throw null;
    }

    private final <K, V, UT, UB> UB a(int i, int i2, Map<K, V> map, zzfy zzfyVar, UB ub, Fa<UT, UB> fa) {
        this.s.zzo(b(i));
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a(Object obj, int i, InterfaceC1263ma interfaceC1263ma) {
        return interfaceC1263ma.b(Ja.f(obj, i & 1048575));
    }

    private static void a(int i, Object obj, Ra ra) throws IOException {
        if (obj instanceof String) {
            ra.a(i, (String) obj);
        } else {
            ra.a(i, (zzeh) obj);
        }
    }

    private final void a(Object obj, int i, InterfaceC1255ia interfaceC1255ia) throws IOException {
        if (f(i)) {
            Ja.a(obj, i & 1048575, interfaceC1255ia.o());
        } else if (this.i) {
            Ja.a(obj, i & 1048575, interfaceC1255ia.readString());
        } else {
            Ja.a(obj, i & 1048575, interfaceC1255ia.n());
        }
    }

    private final boolean a(T t, int i, int i2, int i3) {
        if (this.j) {
            return a((Z<T>) t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean a(T t, int i) {
        if (this.j) {
            int d2 = d(i);
            long j = d2 & 1048575;
            switch ((d2 & 267386880) >>> 20) {
                case 0:
                    return Ja.e(t, j) != 0.0d;
                case 1:
                    return Ja.d(t, j) != 0.0f;
                case 2:
                    return Ja.b(t, j) != 0;
                case 3:
                    return Ja.b(t, j) != 0;
                case 4:
                    return Ja.a(t, j) != 0;
                case 5:
                    return Ja.b(t, j) != 0;
                case 6:
                    return Ja.a(t, j) != 0;
                case 7:
                    return Ja.c(t, j);
                case 8:
                    Object f2 = Ja.f(t, j);
                    if (f2 instanceof String) {
                        return !((String) f2).isEmpty();
                    }
                    if (f2 instanceof zzeh) {
                        return !zzeh.zzso.equals(f2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return Ja.f(t, j) != null;
                case 10:
                    return !zzeh.zzso.equals(Ja.f(t, j));
                case 11:
                    return Ja.a(t, j) != 0;
                case 12:
                    return Ja.a(t, j) != 0;
                case 13:
                    return Ja.a(t, j) != 0;
                case 14:
                    return Ja.b(t, j) != 0;
                case 15:
                    return Ja.a(t, j) != 0;
                case 16:
                    return Ja.b(t, j) != 0;
                case 17:
                    return Ja.f(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int e2 = e(i);
        return (Ja.a(t, (long) (e2 & 1048575)) & (1 << (e2 >>> 20))) != 0;
    }

    private final boolean a(T t, int i, int i2) {
        return Ja.a(t, (long) (e(i2) & 1048575)) == i;
    }
}

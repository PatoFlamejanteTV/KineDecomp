package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;

/* loaded from: classes2.dex */
public class SymbolInfo {

    /* renamed from: a */
    static final SymbolInfo[] f19114a;

    /* renamed from: b */
    private static SymbolInfo[] f19115b;

    /* renamed from: c */
    private final boolean f19116c;

    /* renamed from: d */
    private final int f19117d;

    /* renamed from: e */
    private final int f19118e;

    /* renamed from: f */
    public final int f19119f;

    /* renamed from: g */
    public final int f19120g;

    /* renamed from: h */
    private final int f19121h;
    private final int i;
    private final int j;

    static {
        SymbolInfo[] symbolInfoArr = {new SymbolInfo(false, 3, 5, 8, 8, 1), new SymbolInfo(false, 5, 7, 10, 10, 1), new SymbolInfo(true, 5, 7, 16, 6, 1), new SymbolInfo(false, 8, 10, 12, 12, 1), new SymbolInfo(true, 10, 11, 14, 6, 2), new SymbolInfo(false, 12, 12, 14, 14, 1), new SymbolInfo(true, 16, 14, 24, 10, 1), new SymbolInfo(false, 18, 14, 16, 16, 1), new SymbolInfo(false, 22, 18, 18, 18, 1), new SymbolInfo(true, 22, 18, 16, 10, 2), new SymbolInfo(false, 30, 20, 20, 20, 1), new SymbolInfo(true, 32, 24, 16, 14, 2), new SymbolInfo(false, 36, 24, 22, 22, 1), new SymbolInfo(false, 44, 28, 24, 24, 1), new SymbolInfo(true, 49, 28, 22, 14, 2), new SymbolInfo(false, 62, 36, 14, 14, 4), new SymbolInfo(false, 86, 42, 16, 16, 4), new SymbolInfo(false, 114, 48, 18, 18, 4), new SymbolInfo(false, 144, 56, 20, 20, 4), new SymbolInfo(false, 174, 68, 22, 22, 4), new SymbolInfo(false, 204, 84, 24, 24, 4, 102, 42), new SymbolInfo(false, 280, 112, 14, 14, 16, 140, 56), new SymbolInfo(false, 368, 144, 16, 16, 16, 92, 36), new SymbolInfo(false, 456, 192, 18, 18, 16, 114, 48), new SymbolInfo(false, 576, 224, 20, 20, 16, 144, 56), new SymbolInfo(false, 696, 272, 22, 22, 16, 174, 68), new SymbolInfo(false, 816, 336, 24, 24, 16, 136, 56), new SymbolInfo(false, 1050, 408, 18, 18, 36, 175, 68), new SymbolInfo(false, 1304, 496, 20, 20, 36, 163, 62), new d()};
        f19114a = symbolInfoArr;
        f19115b = symbolInfoArr;
    }

    public SymbolInfo(boolean z, int i, int i2, int i3, int i4, int i5) {
        this(z, i, i2, i3, i4, i5, i, i2);
    }

    public static SymbolInfo a(int i, SymbolShapeHint symbolShapeHint, Dimension dimension, Dimension dimension2, boolean z) {
        for (SymbolInfo symbolInfo : f19115b) {
            if (!(symbolShapeHint == SymbolShapeHint.FORCE_SQUARE && symbolInfo.f19116c) && ((symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || symbolInfo.f19116c) && ((dimension == null || (symbolInfo.g() >= dimension.b() && symbolInfo.f() >= dimension.a())) && ((dimension2 == null || (symbolInfo.g() <= dimension2.b() && symbolInfo.f() <= dimension2.a())) && i <= symbolInfo.f19117d)))) {
                return symbolInfo;
            }
        }
        if (!z) {
            return null;
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: " + i);
    }

    private int h() {
        int i = this.f19121h;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2 && i != 4) {
                if (i == 16) {
                    return 4;
                }
                if (i == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i2;
    }

    private int i() {
        int i = this.f19121h;
        if (i == 1 || i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public final int b() {
        return this.f19118e;
    }

    public int c() {
        return this.f19117d / this.i;
    }

    public final int d() {
        return i() * this.f19120g;
    }

    public final int e() {
        return h() * this.f19119f;
    }

    public final int f() {
        return d() + (i() << 1);
    }

    public final int g() {
        return e() + (h() << 1);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f19116c ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.f19119f);
        sb.append('x');
        sb.append(this.f19120g);
        sb.append(", symbol size ");
        sb.append(g());
        sb.append('x');
        sb.append(f());
        sb.append(", symbol data size ");
        sb.append(e());
        sb.append('x');
        sb.append(d());
        sb.append(", codewords ");
        sb.append(this.f19117d);
        sb.append('+');
        sb.append(this.f19118e);
        return sb.toString();
    }

    public SymbolInfo(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f19116c = z;
        this.f19117d = i;
        this.f19118e = i2;
        this.f19119f = i3;
        this.f19120g = i4;
        this.f19121h = i5;
        this.i = i6;
        this.j = i7;
    }

    public final int b(int i) {
        return this.j;
    }

    public final int a() {
        return this.f19117d;
    }

    public int a(int i) {
        return this.i;
    }
}

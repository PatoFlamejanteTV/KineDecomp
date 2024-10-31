package com.bumptech.glide.b;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.b.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: StandardGifDecoder.java */
/* loaded from: classes.dex */
public class e implements a {

    /* renamed from: a */
    private static final String f8400a = "e";

    /* renamed from: b */
    private int[] f8401b;

    /* renamed from: c */
    private final int[] f8402c;

    /* renamed from: d */
    private final a.InterfaceC0045a f8403d;

    /* renamed from: e */
    private ByteBuffer f8404e;

    /* renamed from: f */
    private byte[] f8405f;

    /* renamed from: g */
    private short[] f8406g;

    /* renamed from: h */
    private byte[] f8407h;
    private byte[] i;
    private byte[] j;
    private int[] k;
    private int l;
    private c m;
    private Bitmap n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private int s;
    private Boolean t;
    private Bitmap.Config u;

    public e(a.InterfaceC0045a interfaceC0045a, c cVar, ByteBuffer byteBuffer, int i) {
        this(interfaceC0045a);
        a(cVar, byteBuffer, i);
    }

    private Bitmap g() {
        Boolean bool = this.t;
        Bitmap a2 = this.f8403d.a(this.s, this.r, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.u);
        a2.setHasAlpha(true);
        return a2;
    }

    private int h() {
        int i = i();
        if (i <= 0) {
            return i;
        }
        ByteBuffer byteBuffer = this.f8404e;
        byteBuffer.get(this.f8405f, 0, Math.min(i, byteBuffer.remaining()));
        return i;
    }

    private int i() {
        return this.f8404e.get() & 255;
    }

    public int a(int i) {
        if (i >= 0) {
            c cVar = this.m;
            if (i < cVar.f8390c) {
                return cVar.f8392e.get(i).i;
            }
        }
        return -1;
    }

    @Override // com.bumptech.glide.b.a
    public void advance() {
        this.l = (this.l + 1) % this.m.f8390c;
    }

    @Override // com.bumptech.glide.b.a
    public int b() {
        return this.m.f8390c;
    }

    @Override // com.bumptech.glide.b.a
    public int c() {
        int i;
        if (this.m.f8390c <= 0 || (i = this.l) < 0) {
            return 0;
        }
        return a(i);
    }

    @Override // com.bumptech.glide.b.a
    public void clear() {
        this.m = null;
        byte[] bArr = this.j;
        if (bArr != null) {
            this.f8403d.a(bArr);
        }
        int[] iArr = this.k;
        if (iArr != null) {
            this.f8403d.a(iArr);
        }
        Bitmap bitmap = this.n;
        if (bitmap != null) {
            this.f8403d.a(bitmap);
        }
        this.n = null;
        this.f8404e = null;
        this.t = null;
        byte[] bArr2 = this.f8405f;
        if (bArr2 != null) {
            this.f8403d.a(bArr2);
        }
    }

    @Override // com.bumptech.glide.b.a
    public void d() {
        this.l = -1;
    }

    @Override // com.bumptech.glide.b.a
    public int e() {
        return this.l;
    }

    @Override // com.bumptech.glide.b.a
    public int f() {
        return this.f8404e.limit() + this.j.length + (this.k.length * 4);
    }

    @Override // com.bumptech.glide.b.a
    public ByteBuffer getData() {
        return this.f8404e;
    }

    private void b(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.k;
        int i = bVar2.f8383d;
        int i2 = bVar2.f8381b;
        int i3 = bVar2.f8382c;
        int i4 = bVar2.f8380a;
        boolean z = this.l == 0;
        int i5 = this.s;
        byte[] bArr = this.j;
        int[] iArr2 = this.f8401b;
        int i6 = 0;
        byte b2 = -1;
        while (i6 < i) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            int i10 = i7 + i5;
            if (i10 < i9) {
                i9 = i10;
            }
            int i11 = bVar2.f8382c * i6;
            for (int i12 = i8; i12 < i9; i12++) {
                byte b3 = bArr[i11];
                int i13 = b3 & 255;
                if (i13 != b2) {
                    int i14 = iArr2[i13];
                    if (i14 != 0) {
                        iArr[i12] = i14;
                    } else {
                        b2 = b3;
                    }
                }
                i11++;
            }
            i6++;
            bVar2 = bVar;
        }
        this.t = Boolean.valueOf(this.t == null && z && b2 != -1);
    }

    public e(a.InterfaceC0045a interfaceC0045a) {
        this.f8402c = new int[256];
        this.u = Bitmap.Config.ARGB_8888;
        this.f8403d = interfaceC0045a;
        this.m = new c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v17, types: [short] */
    /* JADX WARN: Type inference failed for: r4v20 */
    private void c(b bVar) {
        int i;
        int i2;
        int i3;
        short s;
        e eVar = this;
        if (bVar != null) {
            eVar.f8404e.position(bVar.j);
        }
        if (bVar == null) {
            c cVar = eVar.m;
            i = cVar.f8393f;
            i2 = cVar.f8394g;
        } else {
            i = bVar.f8382c;
            i2 = bVar.f8383d;
        }
        int i4 = i * i2;
        byte[] bArr = eVar.j;
        if (bArr == null || bArr.length < i4) {
            eVar.j = eVar.f8403d.a(i4);
        }
        byte[] bArr2 = eVar.j;
        if (eVar.f8406g == null) {
            eVar.f8406g = new short[4096];
        }
        short[] sArr = eVar.f8406g;
        if (eVar.f8407h == null) {
            eVar.f8407h = new byte[4096];
        }
        byte[] bArr3 = eVar.f8407h;
        if (eVar.i == null) {
            eVar.i = new byte[4097];
        }
        byte[] bArr4 = eVar.i;
        int i5 = i();
        int i6 = 1 << i5;
        int i7 = i6 + 1;
        int i8 = i6 + 2;
        int i9 = i5 + 1;
        int i10 = (1 << i9) - 1;
        int i11 = 0;
        for (int i12 = 0; i12 < i6; i12++) {
            sArr[i12] = 0;
            bArr3[i12] = (byte) i12;
        }
        byte[] bArr5 = eVar.f8405f;
        int i13 = i9;
        int i14 = i8;
        int i15 = i10;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = -1;
        int i22 = 0;
        int i23 = 0;
        while (true) {
            if (i11 >= i4) {
                break;
            }
            if (i16 == 0) {
                i16 = h();
                if (i16 <= 0) {
                    eVar.p = 3;
                    break;
                }
                i19 = 0;
            }
            i18 += (bArr5[i19] & 255) << i17;
            i19++;
            i16--;
            int i24 = i17 + 8;
            int i25 = i21;
            int i26 = i22;
            int i27 = i14;
            int i28 = i20;
            int i29 = i11;
            int i30 = i13;
            while (true) {
                if (i24 < i30) {
                    i13 = i30;
                    i22 = i26;
                    i11 = i29;
                    i20 = i28;
                    i17 = i24;
                    i14 = i27;
                    i21 = i25;
                    eVar = this;
                    break;
                }
                int i31 = i18 & i15;
                i18 >>= i30;
                i24 -= i30;
                if (i31 == i6) {
                    i30 = i9;
                    i27 = i8;
                    i15 = i10;
                    i25 = -1;
                } else {
                    if (i31 == i7) {
                        i17 = i24;
                        i13 = i30;
                        i11 = i29;
                        i20 = i28;
                        i14 = i27;
                        i22 = i26;
                        i21 = i25;
                        break;
                    }
                    if (i25 == -1) {
                        bArr2[i28] = bArr3[i31];
                        i28++;
                        i29++;
                        eVar = this;
                        i25 = i31;
                        i26 = i25;
                    } else {
                        int i32 = i27;
                        if (i31 >= i32) {
                            i3 = i24;
                            bArr4[i23] = (byte) i26;
                            i23++;
                            s = i25;
                        } else {
                            i3 = i24;
                            s = i31;
                        }
                        while (s >= i6) {
                            bArr4[i23] = bArr3[s];
                            i23++;
                            s = sArr[s];
                        }
                        int i33 = bArr3[s] & 255;
                        int i34 = i9;
                        byte b2 = (byte) i33;
                        bArr2[i28] = b2;
                        while (true) {
                            i28++;
                            i29++;
                            if (i23 <= 0) {
                                break;
                            }
                            i23--;
                            bArr2[i28] = bArr4[i23];
                        }
                        if (i32 < 4096) {
                            sArr[i32] = (short) i25;
                            bArr3[i32] = b2;
                            i32++;
                            if ((i32 & i15) == 0 && i32 < 4096) {
                                i30++;
                                i15 += i32;
                            }
                        }
                        i25 = i31;
                        i24 = i3;
                        i9 = i34;
                        i26 = i33;
                        i27 = i32;
                        eVar = this;
                    }
                }
            }
        }
        Arrays.fill(bArr2, i20, i4, (byte) 0);
    }

    @Override // com.bumptech.glide.b.a
    public synchronized Bitmap a() {
        if (this.m.f8390c <= 0 || this.l < 0) {
            if (Log.isLoggable(f8400a, 3)) {
                Log.d(f8400a, "Unable to decode frame, frameCount=" + this.m.f8390c + ", framePointer=" + this.l);
            }
            this.p = 1;
        }
        if (this.p != 1 && this.p != 2) {
            this.p = 0;
            if (this.f8405f == null) {
                this.f8405f = this.f8403d.a(255);
            }
            b bVar = this.m.f8392e.get(this.l);
            int i = this.l - 1;
            b bVar2 = i >= 0 ? this.m.f8392e.get(i) : null;
            this.f8401b = bVar.k != null ? bVar.k : this.m.f8388a;
            if (this.f8401b == null) {
                if (Log.isLoggable(f8400a, 3)) {
                    Log.d(f8400a, "No valid color table found for frame #" + this.l);
                }
                this.p = 1;
                return null;
            }
            if (bVar.f8385f) {
                System.arraycopy(this.f8401b, 0, this.f8402c, 0, this.f8401b.length);
                this.f8401b = this.f8402c;
                this.f8401b[bVar.f8387h] = 0;
            }
            return a(bVar, bVar2);
        }
        if (Log.isLoggable(f8400a, 3)) {
            Log.d(f8400a, "Unable to decode frame, status=" + this.p);
        }
        return null;
    }

    public synchronized void a(c cVar, ByteBuffer byteBuffer, int i) {
        if (i > 0) {
            int highestOneBit = Integer.highestOneBit(i);
            this.p = 0;
            this.m = cVar;
            this.l = -1;
            this.f8404e = byteBuffer.asReadOnlyBuffer();
            this.f8404e.position(0);
            this.f8404e.order(ByteOrder.LITTLE_ENDIAN);
            this.o = false;
            Iterator<b> it = cVar.f8392e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().f8386g == 3) {
                    this.o = true;
                    break;
                }
            }
            this.q = highestOneBit;
            this.s = cVar.f8393f / highestOneBit;
            this.r = cVar.f8394g / highestOneBit;
            this.j = this.f8403d.a(cVar.f8393f * cVar.f8394g);
            this.k = this.f8403d.b(this.s * this.r);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
    }

    @Override // com.bumptech.glide.b.a
    public void a(Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
        }
        this.u = config;
    }

    private Bitmap a(b bVar, b bVar2) {
        int i;
        int i2;
        Bitmap bitmap;
        int[] iArr = this.k;
        int i3 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.n;
            if (bitmap2 != null) {
                this.f8403d.a(bitmap2);
            }
            this.n = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.f8386g == 3 && this.n == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i2 = bVar2.f8386g) > 0) {
            if (i2 == 2) {
                if (!bVar.f8385f) {
                    c cVar = this.m;
                    int i4 = cVar.l;
                    if (bVar.k == null || cVar.j != bVar.f8387h) {
                        i3 = i4;
                    }
                } else if (this.l == 0) {
                    this.t = true;
                }
                int i5 = bVar2.f8383d;
                int i6 = this.q;
                int i7 = i5 / i6;
                int i8 = bVar2.f8381b / i6;
                int i9 = bVar2.f8382c / i6;
                int i10 = bVar2.f8380a / i6;
                int i11 = this.s;
                int i12 = (i8 * i11) + i10;
                int i13 = (i7 * i11) + i12;
                while (i12 < i13) {
                    int i14 = i12 + i9;
                    for (int i15 = i12; i15 < i14; i15++) {
                        iArr[i15] = i3;
                    }
                    i12 += this.s;
                }
            } else if (i2 == 3 && (bitmap = this.n) != null) {
                int i16 = this.s;
                bitmap.getPixels(iArr, 0, i16, 0, 0, i16, this.r);
            }
        }
        c(bVar);
        if (!bVar.f8384e && this.q == 1) {
            b(bVar);
        } else {
            a(bVar);
        }
        if (this.o && ((i = bVar.f8386g) == 0 || i == 1)) {
            if (this.n == null) {
                this.n = g();
            }
            Bitmap bitmap3 = this.n;
            int i17 = this.s;
            bitmap3.setPixels(iArr, 0, i17, 0, 0, i17, this.r);
        }
        Bitmap g2 = g();
        int i18 = this.s;
        g2.setPixels(iArr, 0, i18, 0, 0, i18, this.r);
        return g2;
    }

    private void a(b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = this.k;
        int i6 = bVar.f8383d;
        int i7 = this.q;
        int i8 = i6 / i7;
        int i9 = bVar.f8381b / i7;
        int i10 = bVar.f8382c / i7;
        int i11 = bVar.f8380a / i7;
        Boolean bool = true;
        boolean z = this.l == 0;
        int i12 = this.q;
        int i13 = this.s;
        int i14 = this.r;
        byte[] bArr = this.j;
        int[] iArr2 = this.f8401b;
        Boolean bool2 = this.t;
        int i15 = 0;
        int i16 = 0;
        int i17 = 1;
        int i18 = 8;
        while (i15 < i8) {
            Boolean bool3 = bool;
            if (bVar.f8384e) {
                if (i16 >= i8) {
                    i = i8;
                    i5 = i17 + 1;
                    if (i5 == 2) {
                        i16 = 4;
                    } else if (i5 == 3) {
                        i16 = 2;
                        i18 = 4;
                    } else if (i5 == 4) {
                        i16 = 1;
                        i18 = 2;
                    }
                } else {
                    i = i8;
                    i5 = i17;
                }
                i2 = i16 + i18;
                i17 = i5;
            } else {
                i = i8;
                i2 = i16;
                i16 = i15;
            }
            int i19 = i16 + i9;
            boolean z2 = i12 == 1;
            if (i19 < i14) {
                int i20 = i19 * i13;
                int i21 = i20 + i11;
                int i22 = i21 + i10;
                int i23 = i20 + i13;
                if (i23 < i22) {
                    i22 = i23;
                }
                i3 = i9;
                int i24 = i15 * i12 * bVar.f8382c;
                if (z2) {
                    int i25 = i21;
                    while (i25 < i22) {
                        int i26 = i10;
                        int i27 = iArr2[bArr[i24] & 255];
                        if (i27 != 0) {
                            iArr[i25] = i27;
                        } else if (z && bool2 == null) {
                            bool2 = bool3;
                        }
                        i24 += i12;
                        i25++;
                        i10 = i26;
                    }
                } else {
                    i4 = i10;
                    int i28 = ((i22 - i21) * i12) + i24;
                    int i29 = i21;
                    while (i29 < i22) {
                        int i30 = i22;
                        int a2 = a(i24, i28, bVar.f8382c);
                        if (a2 != 0) {
                            iArr[i29] = a2;
                        } else if (z && bool2 == null) {
                            bool2 = bool3;
                        }
                        i24 += i12;
                        i29++;
                        i22 = i30;
                    }
                    i15++;
                    i16 = i2;
                    i10 = i4;
                    bool = bool3;
                    i8 = i;
                    i9 = i3;
                }
            } else {
                i3 = i9;
            }
            i4 = i10;
            i15++;
            i16 = i2;
            i10 = i4;
            bool = bool3;
            i8 = i;
            i9 = i3;
        }
        if (this.t == null) {
            this.t = Boolean.valueOf(bool2 == null ? false : bool2.booleanValue());
        }
    }

    private int a(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.q + i; i9++) {
            byte[] bArr = this.j;
            if (i9 >= bArr.length || i9 >= i2) {
                break;
            }
            int i10 = this.f8401b[bArr[i9] & 255];
            if (i10 != 0) {
                i4 += (i10 >> 24) & 255;
                i5 += (i10 >> 16) & 255;
                i6 += (i10 >> 8) & 255;
                i7 += i10 & 255;
                i8++;
            }
        }
        int i11 = i + i3;
        for (int i12 = i11; i12 < this.q + i11; i12++) {
            byte[] bArr2 = this.j;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.f8401b[bArr2[i12] & 255];
            if (i13 != 0) {
                i4 += (i13 >> 24) & 255;
                i5 += (i13 >> 16) & 255;
                i6 += (i13 >> 8) & 255;
                i7 += i13 & 255;
                i8++;
            }
        }
        if (i8 == 0) {
            return 0;
        }
        return ((i4 / i8) << 24) | ((i5 / i8) << 16) | ((i6 / i8) << 8) | (i7 / i8);
    }
}

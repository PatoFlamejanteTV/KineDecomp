package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.kk */
/* loaded from: classes2.dex */
public final class C0975kk implements zzgi {

    /* renamed from: a */
    private int f12271a;

    /* renamed from: b */
    private int f12272b;

    /* renamed from: c */
    private int[] f12273c;

    /* renamed from: d */
    private boolean f12274d;

    /* renamed from: e */
    private int[] f12275e;

    /* renamed from: f */
    private ByteBuffer f12276f;

    /* renamed from: g */
    private ByteBuffer f12277g;

    /* renamed from: h */
    private boolean f12278h;

    public C0975kk() {
        ByteBuffer byteBuffer = zzgi.zzabh;
        this.f12276f = byteBuffer;
        this.f12277g = byteBuffer;
        this.f12271a = -1;
        this.f12272b = -1;
    }

    public final void a(int[] iArr) {
        this.f12273c = iArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final void flush() {
        this.f12277g = zzgi.zzabh;
        this.f12278h = false;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final boolean isActive() {
        return this.f12274d;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final void reset() {
        flush();
        this.f12276f = zzgi.zzabh;
        this.f12271a = -1;
        this.f12272b = -1;
        this.f12275e = null;
        this.f12274d = false;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final boolean zzb(int i, int i2, int i3) throws zzgj {
        boolean z = !Arrays.equals(this.f12273c, this.f12275e);
        this.f12275e = this.f12273c;
        if (this.f12275e == null) {
            this.f12274d = false;
            return z;
        }
        if (i3 == 2) {
            if (!z && this.f12272b == i && this.f12271a == i2) {
                return false;
            }
            this.f12272b = i;
            this.f12271a = i2;
            this.f12274d = i2 != this.f12275e.length;
            int i4 = 0;
            while (true) {
                int[] iArr = this.f12275e;
                if (i4 >= iArr.length) {
                    return true;
                }
                int i5 = iArr[i4];
                if (i5 < i2) {
                    this.f12274d = (i5 != i4) | this.f12274d;
                    i4++;
                } else {
                    throw new zzgj(i, i2, i3);
                }
            }
        } else {
            throw new zzgj(i, i2, i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final boolean zzcj() {
        return this.f12278h && this.f12277g == zzgi.zzabh;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final int zzco() {
        int[] iArr = this.f12275e;
        return iArr == null ? this.f12271a : iArr.length;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final int zzcp() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final void zzcq() {
        this.f12278h = true;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final ByteBuffer zzcr() {
        ByteBuffer byteBuffer = this.f12277g;
        this.f12277g = zzgi.zzabh;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final void zzi(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = (((limit - position) / (this.f12271a * 2)) * this.f12275e.length) << 1;
        if (this.f12276f.capacity() < length) {
            this.f12276f = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.f12276f.clear();
        }
        while (position < limit) {
            for (int i : this.f12275e) {
                this.f12276f.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.f12271a << 1;
        }
        byteBuffer.position(limit);
        this.f12276f.flip();
        this.f12277g = this.f12276f;
    }
}

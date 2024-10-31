package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* loaded from: classes2.dex */
public final class zzhi implements zzgi {
    private boolean zzaeq;
    private C1031ok zzafx;
    private long zzafz;
    private long zzaga;
    private float zzaag = 1.0f;
    private float zzaah = 1.0f;
    private int zzzt = -1;
    private int zzael = -1;
    private ByteBuffer zzaep = zzgi.zzabh;
    private ShortBuffer zzafy = this.zzaep.asShortBuffer();
    private ByteBuffer zzadm = zzgi.zzabh;

    @Override // com.google.android.gms.internal.ads.zzgi
    public final void flush() {
        this.zzafx = new C1031ok(this.zzael, this.zzzt);
        this.zzafx.a(this.zzaag);
        this.zzafx.b(this.zzaah);
        this.zzadm = zzgi.zzabh;
        this.zzafz = 0L;
        this.zzaga = 0L;
        this.zzaeq = false;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final boolean isActive() {
        return Math.abs(this.zzaag - 1.0f) >= 0.01f || Math.abs(this.zzaah - 1.0f) >= 0.01f;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final void reset() {
        this.zzafx = null;
        this.zzaep = zzgi.zzabh;
        this.zzafy = this.zzaep.asShortBuffer();
        this.zzadm = zzgi.zzabh;
        this.zzzt = -1;
        this.zzael = -1;
        this.zzafz = 0L;
        this.zzaga = 0L;
        this.zzaeq = false;
    }

    public final float zzb(float f2) {
        this.zzaag = zzqe.zza(f2, 0.1f, 8.0f);
        return this.zzaag;
    }

    public final float zzc(float f2) {
        this.zzaah = zzqe.zza(f2, 0.1f, 8.0f);
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final boolean zzcj() {
        if (!this.zzaeq) {
            return false;
        }
        C1031ok c1031ok = this.zzafx;
        return c1031ok == null || c1031ok.b() == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final int zzco() {
        return this.zzzt;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final int zzcp() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final void zzcq() {
        this.zzafx.a();
        this.zzaeq = true;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final ByteBuffer zzcr() {
        ByteBuffer byteBuffer = this.zzadm;
        this.zzadm = zzgi.zzabh;
        return byteBuffer;
    }

    public final long zzdm() {
        return this.zzafz;
    }

    public final long zzdn() {
        return this.zzaga;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final void zzi(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.zzafz += remaining;
            this.zzafx.a(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int b2 = (this.zzafx.b() * this.zzzt) << 1;
        if (b2 > 0) {
            if (this.zzaep.capacity() < b2) {
                this.zzaep = ByteBuffer.allocateDirect(b2).order(ByteOrder.nativeOrder());
                this.zzafy = this.zzaep.asShortBuffer();
            } else {
                this.zzaep.clear();
                this.zzafy.clear();
            }
            this.zzafx.b(this.zzafy);
            this.zzaga += b2;
            this.zzaep.limit(b2);
            this.zzadm = this.zzaep;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final boolean zzb(int i, int i2, int i3) throws zzgj {
        if (i3 == 2) {
            if (this.zzael == i && this.zzzt == i2) {
                return false;
            }
            this.zzael = i;
            this.zzzt = i2;
            return true;
        }
        throw new zzgj(i, i2, i3);
    }
}

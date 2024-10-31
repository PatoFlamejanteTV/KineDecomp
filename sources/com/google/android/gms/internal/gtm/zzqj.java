package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class zzqj extends zzpr {
    private static final Logger logger = Logger.getLogger(zzqj.class.getName());
    private static final boolean zzawt = ub.a();
    C1319ma zzawu;

    /* loaded from: classes2.dex */
    public static final class b extends a {

        /* renamed from: e */
        private final ByteBuffer f13333e;

        /* renamed from: f */
        private int f13334f;

        b(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.f13333e = byteBuffer;
            this.f13334f = byteBuffer.position();
        }

        @Override // com.google.android.gms.internal.gtm.zzqj.a, com.google.android.gms.internal.gtm.zzqj
        public final void flush() {
            this.f13333e.position(this.f13334f + a());
        }
    }

    /* loaded from: classes2.dex */
    public static class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        zzc(java.lang.String r3) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                if (r0 == 0) goto L11
                java.lang.String r3 = r1.concat(r3)
                goto L16
            L11:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
            L16:
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzqj.zzc.<init>(java.lang.String):void");
        }

        zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        zzc(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                if (r0 == 0) goto L11
                java.lang.String r3 = r1.concat(r3)
                goto L16
            L11:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
            L16:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzqj.zzc.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzqj() {
    }

    public static zzqj zza(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            if (ub.b()) {
                return new d(byteBuffer);
            }
            return new c(byteBuffer);
        }
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    public static int zzb(float f2) {
        return 4;
    }

    public static int zzbb(int i) {
        return zzbd(i << 3);
    }

    public static int zzbc(int i) {
        if (i >= 0) {
            return zzbd(i);
        }
        return 10;
    }

    public static int zzbd(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzbe(int i) {
        return zzbd(zzbi(i));
    }

    public static int zzbf(int i) {
        return 4;
    }

    public static int zzbg(int i) {
        return 4;
    }

    public static int zzbh(int i) {
        return zzbc(i);
    }

    private static int zzbi(int i) {
        return (i >> 31) ^ (i << 1);
    }

    @Deprecated
    public static int zzbj(int i) {
        return zzbd(i);
    }

    public static int zzc(double d2) {
        return 8;
    }

    public static int zzc(int i, boolean z) {
        return zzbb(i) + 1;
    }

    public static int zzd(int i, long j) {
        return zzbb(i) + zzt(j);
    }

    public static int zzda(String str) {
        int length;
        try {
            length = wb.a(str);
        } catch (zzud unused) {
            length = str.getBytes(zzre.UTF_8).length;
        }
        return zzbd(length) + length;
    }

    public static int zze(int i, long j) {
        return zzbb(i) + zzt(j);
    }

    public static int zzf(int i, long j) {
        return zzbb(i) + zzt(zzx(j));
    }

    public static zzqj zzg(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int zzh(int i, long j) {
        return zzbb(i) + 8;
    }

    public static int zzj(int i, int i2) {
        return zzbb(i) + zzbd(i2);
    }

    public static int zzj(boolean z) {
        return 1;
    }

    public static int zzk(int i, int i2) {
        return zzbb(i) + zzbd(zzbi(i2));
    }

    public static int zzl(int i, int i2) {
        return zzbb(i) + 4;
    }

    public static int zzm(int i, int i2) {
        return zzbb(i) + 4;
    }

    public static int zzn(int i, int i2) {
        return zzbb(i) + zzbc(i2);
    }

    public static int zzs(long j) {
        return zzt(j);
    }

    public static int zzt(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static int zzu(long j) {
        return zzt(zzx(j));
    }

    public static int zzv(long j) {
        return 8;
    }

    public static int zzw(long j) {
        return 8;
    }

    private static long zzx(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public abstract void flush() throws IOException;

    public abstract void write(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzps zzpsVar) throws IOException;

    public abstract void zza(int i, zzsk zzskVar) throws IOException;

    public abstract void zza(int i, zzsk zzskVar, _a _aVar) throws IOException;

    public abstract void zza(int i, String str) throws IOException;

    public abstract void zza(zzps zzpsVar) throws IOException;

    abstract void zza(zzsk zzskVar, _a _aVar) throws IOException;

    public abstract void zzax(int i) throws IOException;

    public abstract void zzay(int i) throws IOException;

    public final void zzaz(int i) throws IOException {
        zzay(zzbi(i));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzx(j));
    }

    public abstract void zzb(int i, zzps zzpsVar) throws IOException;

    public abstract void zzb(int i, zzsk zzskVar) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(zzsk zzskVar) throws IOException;

    public abstract void zzba(int i) throws IOException;

    public abstract void zzc(byte b2) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public abstract void zzcz(String str) throws IOException;

    public abstract void zzd(int i, int i2) throws IOException;

    public abstract void zze(int i, int i2) throws IOException;

    public abstract void zze(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract void zzh(int i, int i2) throws IOException;

    public final void zzi(boolean z) throws IOException {
        zzc(z ? (byte) 1 : (byte) 0);
    }

    public abstract int zzoi();

    public abstract void zzp(long j) throws IOException;

    public final void zzq(long j) throws IOException {
        zzp(zzx(j));
    }

    public abstract void zzr(long j) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends zzqj {

        /* renamed from: a */
        private final byte[] f13329a;

        /* renamed from: b */
        private final int f13330b;

        /* renamed from: c */
        private final int f13331c;

        /* renamed from: d */
        private int f13332d;

        a(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i + i2;
                if ((i | i2 | (bArr.length - i3)) >= 0) {
                    this.f13329a = bArr;
                    this.f13330b = i;
                    this.f13332d = i;
                    this.f13331c = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            throw new NullPointerException("buffer");
        }

        public final int a() {
            return this.f13332d - this.f13330b;
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public void flush() {
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.f13329a, this.f13332d, i2);
                this.f13332d += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13332d), Integer.valueOf(this.f13331c), Integer.valueOf(i2)), e2);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, long j) throws IOException {
            zzd(i, 0);
            zzp(j);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzax(int i) throws IOException {
            if (i >= 0) {
                zzay(i);
            } else {
                zzp(i);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzay(int i) throws IOException {
            if (!zzqj.zzawt || Z.a() || zzoi() < 5) {
                while ((i & (-128)) != 0) {
                    try {
                        byte[] bArr = this.f13329a;
                        int i2 = this.f13332d;
                        this.f13332d = i2 + 1;
                        bArr[i2] = (byte) ((i & 127) | 128);
                        i >>>= 7;
                    } catch (IndexOutOfBoundsException e2) {
                        throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13332d), Integer.valueOf(this.f13331c), 1), e2);
                    }
                }
                byte[] bArr2 = this.f13329a;
                int i3 = this.f13332d;
                this.f13332d = i3 + 1;
                bArr2[i3] = (byte) i;
                return;
            }
            if ((i & (-128)) == 0) {
                byte[] bArr3 = this.f13329a;
                int i4 = this.f13332d;
                this.f13332d = i4 + 1;
                ub.a(bArr3, i4, (byte) i);
                return;
            }
            byte[] bArr4 = this.f13329a;
            int i5 = this.f13332d;
            this.f13332d = i5 + 1;
            ub.a(bArr4, i5, (byte) (i | 128));
            int i6 = i >>> 7;
            if ((i6 & (-128)) == 0) {
                byte[] bArr5 = this.f13329a;
                int i7 = this.f13332d;
                this.f13332d = i7 + 1;
                ub.a(bArr5, i7, (byte) i6);
                return;
            }
            byte[] bArr6 = this.f13329a;
            int i8 = this.f13332d;
            this.f13332d = i8 + 1;
            ub.a(bArr6, i8, (byte) (i6 | 128));
            int i9 = i6 >>> 7;
            if ((i9 & (-128)) == 0) {
                byte[] bArr7 = this.f13329a;
                int i10 = this.f13332d;
                this.f13332d = i10 + 1;
                ub.a(bArr7, i10, (byte) i9);
                return;
            }
            byte[] bArr8 = this.f13329a;
            int i11 = this.f13332d;
            this.f13332d = i11 + 1;
            ub.a(bArr8, i11, (byte) (i9 | 128));
            int i12 = i9 >>> 7;
            if ((i12 & (-128)) == 0) {
                byte[] bArr9 = this.f13329a;
                int i13 = this.f13332d;
                this.f13332d = i13 + 1;
                ub.a(bArr9, i13, (byte) i12);
                return;
            }
            byte[] bArr10 = this.f13329a;
            int i14 = this.f13332d;
            this.f13332d = i14 + 1;
            ub.a(bArr10, i14, (byte) (i12 | 128));
            byte[] bArr11 = this.f13329a;
            int i15 = this.f13332d;
            this.f13332d = i15 + 1;
            ub.a(bArr11, i15, (byte) (i12 >>> 7));
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, boolean z) throws IOException {
            zzd(i, 0);
            zzc(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzba(int i) throws IOException {
            try {
                byte[] bArr = this.f13329a;
                int i2 = this.f13332d;
                this.f13332d = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.f13329a;
                int i3 = this.f13332d;
                this.f13332d = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.f13329a;
                int i4 = this.f13332d;
                this.f13332d = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.f13329a;
                int i5 = this.f13332d;
                this.f13332d = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13332d), Integer.valueOf(this.f13331c), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzc(int i, long j) throws IOException {
            zzd(i, 1);
            zzr(j);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzcz(String str) throws IOException {
            int i = this.f13332d;
            try {
                int zzbd = zzqj.zzbd(str.length() * 3);
                int zzbd2 = zzqj.zzbd(str.length());
                if (zzbd2 == zzbd) {
                    this.f13332d = i + zzbd2;
                    int a2 = wb.a(str, this.f13329a, this.f13332d, zzoi());
                    this.f13332d = i;
                    zzay((a2 - i) - zzbd2);
                    this.f13332d = a2;
                    return;
                }
                zzay(wb.a(str));
                this.f13332d = wb.a(str, this.f13329a, this.f13332d, zzoi());
            } catch (zzud e2) {
                this.f13332d = i;
                zza(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzd(int i, int i2) throws IOException {
            zzay((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zze(int i, int i2) throws IOException {
            zzd(i, 0);
            zzax(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzf(int i, int i2) throws IOException {
            zzd(i, 0);
            zzay(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzh(int i, int i2) throws IOException {
            zzd(i, 5);
            zzba(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final int zzoi() {
            return this.f13331c - this.f13332d;
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzp(long j) throws IOException {
            if (zzqj.zzawt && zzoi() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.f13329a;
                    int i = this.f13332d;
                    this.f13332d = i + 1;
                    ub.a(bArr, i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.f13329a;
                int i2 = this.f13332d;
                this.f13332d = i2 + 1;
                ub.a(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f13329a;
                    int i3 = this.f13332d;
                    this.f13332d = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13332d), Integer.valueOf(this.f13331c), 1), e2);
                }
            }
            byte[] bArr4 = this.f13329a;
            int i4 = this.f13332d;
            this.f13332d = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzr(long j) throws IOException {
            try {
                byte[] bArr = this.f13329a;
                int i = this.f13332d;
                this.f13332d = i + 1;
                bArr[i] = (byte) j;
                byte[] bArr2 = this.f13329a;
                int i2 = this.f13332d;
                this.f13332d = i2 + 1;
                bArr2[i2] = (byte) (j >> 8);
                byte[] bArr3 = this.f13329a;
                int i3 = this.f13332d;
                this.f13332d = i3 + 1;
                bArr3[i3] = (byte) (j >> 16);
                byte[] bArr4 = this.f13329a;
                int i4 = this.f13332d;
                this.f13332d = i4 + 1;
                bArr4[i4] = (byte) (j >> 24);
                byte[] bArr5 = this.f13329a;
                int i5 = this.f13332d;
                this.f13332d = i5 + 1;
                bArr5[i5] = (byte) (j >> 32);
                byte[] bArr6 = this.f13329a;
                int i6 = this.f13332d;
                this.f13332d = i6 + 1;
                bArr6[i6] = (byte) (j >> 40);
                byte[] bArr7 = this.f13329a;
                int i7 = this.f13332d;
                this.f13332d = i7 + 1;
                bArr7[i7] = (byte) (j >> 48);
                byte[] bArr8 = this.f13329a;
                int i8 = this.f13332d;
                this.f13332d = i8 + 1;
                bArr8[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13332d), Integer.valueOf(this.f13331c), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, String str) throws IOException {
            zzd(i, 2);
            zzcz(str);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, zzsk zzskVar) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zza(3, zzskVar);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzc(byte b2) throws IOException {
            try {
                byte[] bArr = this.f13329a;
                int i = this.f13332d;
                this.f13332d = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13332d), Integer.valueOf(this.f13331c), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzay(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzps zzpsVar) throws IOException {
            zzd(i, 2);
            zza(zzpsVar);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(zzps zzpsVar) throws IOException {
            zzay(zzpsVar.size());
            zzpsVar.zza(this);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, zzps zzpsVar) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zza(3, zzpsVar);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzsk zzskVar) throws IOException {
            zzd(i, 2);
            zzb(zzskVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzsk zzskVar, _a _aVar) throws IOException {
            zzd(i, 2);
            zzpl zzplVar = (zzpl) zzskVar;
            int zzmw = zzplVar.zzmw();
            if (zzmw == -1) {
                zzmw = _aVar.d(zzplVar);
                zzplVar.zzag(zzmw);
            }
            zzay(zzmw);
            _aVar.a((_a) zzskVar, (Cb) this.zzawu);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(zzsk zzskVar) throws IOException {
            zzay(zzskVar.zzpe());
            zzskVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        final void zza(zzsk zzskVar, _a _aVar) throws IOException {
            zzpl zzplVar = (zzpl) zzskVar;
            int zzmw = zzplVar.zzmw();
            if (zzmw == -1) {
                zzmw = _aVar.d(zzplVar);
                zzplVar.zzag(zzmw);
            }
            zzay(zzmw);
            _aVar.a((_a) zzskVar, (Cb) this.zzawu);
        }

        @Override // com.google.android.gms.internal.gtm.zzpr
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }
    }

    /* loaded from: classes2.dex */
    public static final class c extends zzqj {

        /* renamed from: a */
        private final ByteBuffer f13335a;

        /* renamed from: b */
        private final ByteBuffer f13336b;

        /* renamed from: c */
        private final int f13337c;

        c(ByteBuffer byteBuffer) {
            super();
            this.f13335a = byteBuffer;
            this.f13336b = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f13337c = byteBuffer.position();
        }

        private final void a(String str) throws IOException {
            try {
                wb.a(str, this.f13336b);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void flush() {
            this.f13335a.position(this.f13336b.position());
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.f13336b.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            } catch (BufferOverflowException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, long j) throws IOException {
            zzd(i, 0);
            zzp(j);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzax(int i) throws IOException {
            if (i >= 0) {
                zzay(i);
            } else {
                zzp(i);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzay(int i) throws IOException {
            while ((i & (-128)) != 0) {
                try {
                    this.f13336b.put((byte) ((i & 127) | 128));
                    i >>>= 7;
                } catch (BufferOverflowException e2) {
                    throw new zzc(e2);
                }
            }
            this.f13336b.put((byte) i);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, boolean z) throws IOException {
            zzd(i, 0);
            zzc(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzba(int i) throws IOException {
            try {
                this.f13336b.putInt(i);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzc(int i, long j) throws IOException {
            zzd(i, 1);
            zzr(j);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzcz(String str) throws IOException {
            int position = this.f13336b.position();
            try {
                int zzbd = zzqj.zzbd(str.length() * 3);
                int zzbd2 = zzqj.zzbd(str.length());
                if (zzbd2 == zzbd) {
                    int position2 = this.f13336b.position() + zzbd2;
                    this.f13336b.position(position2);
                    a(str);
                    int position3 = this.f13336b.position();
                    this.f13336b.position(position);
                    zzay(position3 - position2);
                    this.f13336b.position(position3);
                    return;
                }
                zzay(wb.a(str));
                a(str);
            } catch (zzud e2) {
                this.f13336b.position(position);
                zza(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzd(int i, int i2) throws IOException {
            zzay((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zze(int i, int i2) throws IOException {
            zzd(i, 0);
            zzax(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzf(int i, int i2) throws IOException {
            zzd(i, 0);
            zzay(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzh(int i, int i2) throws IOException {
            zzd(i, 5);
            zzba(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final int zzoi() {
            return this.f13336b.remaining();
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzp(long j) throws IOException {
            while (((-128) & j) != 0) {
                try {
                    this.f13336b.put((byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                } catch (BufferOverflowException e2) {
                    throw new zzc(e2);
                }
            }
            this.f13336b.put((byte) j);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzr(long j) throws IOException {
            try {
                this.f13336b.putLong(j);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, String str) throws IOException {
            zzd(i, 2);
            zzcz(str);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, zzsk zzskVar) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zza(3, zzskVar);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzc(byte b2) throws IOException {
            try {
                this.f13336b.put(b2);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzay(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzps zzpsVar) throws IOException {
            zzd(i, 2);
            zza(zzpsVar);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzsk zzskVar) throws IOException {
            zzd(i, 2);
            zzb(zzskVar);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, zzps zzpsVar) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zza(3, zzpsVar);
            zzd(1, 4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzsk zzskVar, _a _aVar) throws IOException {
            zzd(i, 2);
            zza(zzskVar, _aVar);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        final void zza(zzsk zzskVar, _a _aVar) throws IOException {
            zzpl zzplVar = (zzpl) zzskVar;
            int zzmw = zzplVar.zzmw();
            if (zzmw == -1) {
                zzmw = _aVar.d(zzplVar);
                zzplVar.zzag(zzmw);
            }
            zzay(zzmw);
            _aVar.a((_a) zzskVar, (Cb) this.zzawu);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(zzsk zzskVar) throws IOException {
            zzay(zzskVar.zzpe());
            zzskVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(zzps zzpsVar) throws IOException {
            zzay(zzpsVar.size());
            zzpsVar.zza(this);
        }

        @Override // com.google.android.gms.internal.gtm.zzpr
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }
    }

    /* loaded from: classes2.dex */
    public static final class d extends zzqj {

        /* renamed from: a */
        private final ByteBuffer f13338a;

        /* renamed from: b */
        private final ByteBuffer f13339b;

        /* renamed from: c */
        private final long f13340c;

        /* renamed from: d */
        private final long f13341d;

        /* renamed from: e */
        private final long f13342e;

        /* renamed from: f */
        private final long f13343f;

        /* renamed from: g */
        private long f13344g;

        d(ByteBuffer byteBuffer) {
            super();
            this.f13338a = byteBuffer;
            this.f13339b = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f13340c = ub.a(byteBuffer);
            this.f13341d = this.f13340c + byteBuffer.position();
            this.f13342e = this.f13340c + byteBuffer.limit();
            this.f13343f = this.f13342e - 10;
            this.f13344g = this.f13341d;
        }

        private final void a(long j) {
            this.f13339b.position((int) (j - this.f13340c));
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void flush() {
            this.f13338a.position((int) (this.f13344g - this.f13340c));
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i) {
                long j = i2;
                long j2 = this.f13342e - j;
                long j3 = this.f13344g;
                if (j2 >= j3) {
                    ub.a(bArr, i, j3, j);
                    this.f13344g += j;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f13344g), Long.valueOf(this.f13342e), Integer.valueOf(i2)));
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, long j) throws IOException {
            zzd(i, 0);
            zzp(j);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzax(int i) throws IOException {
            if (i >= 0) {
                zzay(i);
            } else {
                zzp(i);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzay(int i) throws IOException {
            if (this.f13344g <= this.f13343f) {
                while ((i & (-128)) != 0) {
                    long j = this.f13344g;
                    this.f13344g = j + 1;
                    ub.a(j, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                long j2 = this.f13344g;
                this.f13344g = 1 + j2;
                ub.a(j2, (byte) i);
                return;
            }
            while (true) {
                long j3 = this.f13344g;
                if (j3 >= this.f13342e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j3), Long.valueOf(this.f13342e), 1));
                }
                if ((i & (-128)) == 0) {
                    this.f13344g = 1 + j3;
                    ub.a(j3, (byte) i);
                    return;
                } else {
                    this.f13344g = j3 + 1;
                    ub.a(j3, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, boolean z) throws IOException {
            zzd(i, 0);
            zzc(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzba(int i) throws IOException {
            this.f13339b.putInt((int) (this.f13344g - this.f13340c), i);
            this.f13344g += 4;
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzc(int i, long j) throws IOException {
            zzd(i, 1);
            zzr(j);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzcz(String str) throws IOException {
            long j = this.f13344g;
            try {
                int zzbd = zzqj.zzbd(str.length() * 3);
                int zzbd2 = zzqj.zzbd(str.length());
                if (zzbd2 == zzbd) {
                    int i = ((int) (this.f13344g - this.f13340c)) + zzbd2;
                    this.f13339b.position(i);
                    wb.a(str, this.f13339b);
                    int position = this.f13339b.position() - i;
                    zzay(position);
                    this.f13344g += position;
                    return;
                }
                int a2 = wb.a(str);
                zzay(a2);
                a(this.f13344g);
                wb.a(str, this.f13339b);
                this.f13344g += a2;
            } catch (zzud e2) {
                this.f13344g = j;
                a(this.f13344g);
                zza(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new zzc(e3);
            } catch (IndexOutOfBoundsException e4) {
                throw new zzc(e4);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzd(int i, int i2) throws IOException {
            zzay((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zze(int i, int i2) throws IOException {
            zzd(i, 0);
            zzax(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzf(int i, int i2) throws IOException {
            zzd(i, 0);
            zzay(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzh(int i, int i2) throws IOException {
            zzd(i, 5);
            zzba(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final int zzoi() {
            return (int) (this.f13342e - this.f13344g);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzp(long j) throws IOException {
            if (this.f13344g <= this.f13343f) {
                while ((j & (-128)) != 0) {
                    long j2 = this.f13344g;
                    this.f13344g = j2 + 1;
                    ub.a(j2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                long j3 = this.f13344g;
                this.f13344g = 1 + j3;
                ub.a(j3, (byte) j);
                return;
            }
            while (true) {
                long j4 = this.f13344g;
                if (j4 >= this.f13342e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j4), Long.valueOf(this.f13342e), 1));
                }
                if ((j & (-128)) == 0) {
                    this.f13344g = 1 + j4;
                    ub.a(j4, (byte) j);
                    return;
                } else {
                    this.f13344g = j4 + 1;
                    ub.a(j4, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzr(long j) throws IOException {
            this.f13339b.putLong((int) (this.f13344g - this.f13340c), j);
            this.f13344g += 8;
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, String str) throws IOException {
            zzd(i, 2);
            zzcz(str);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, zzsk zzskVar) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zza(3, zzskVar);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzc(byte b2) throws IOException {
            long j = this.f13344g;
            if (j < this.f13342e) {
                this.f13344g = 1 + j;
                ub.a(j, b2);
                return;
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j), Long.valueOf(this.f13342e), 1));
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzay(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzps zzpsVar) throws IOException {
            zzd(i, 2);
            zza(zzpsVar);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzsk zzskVar) throws IOException {
            zzd(i, 2);
            zzb(zzskVar);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, zzps zzpsVar) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zza(3, zzpsVar);
            zzd(1, 4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzsk zzskVar, _a _aVar) throws IOException {
            zzd(i, 2);
            zza(zzskVar, _aVar);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        final void zza(zzsk zzskVar, _a _aVar) throws IOException {
            zzpl zzplVar = (zzpl) zzskVar;
            int zzmw = zzplVar.zzmw();
            if (zzmw == -1) {
                zzmw = _aVar.d(zzplVar);
                zzplVar.zzag(zzmw);
            }
            zzay(zzmw);
            _aVar.a((_a) zzskVar, (Cb) this.zzawu);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(zzsk zzskVar) throws IOException {
            zzay(zzskVar.zzpe());
            zzskVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(zzps zzpsVar) throws IOException {
            zzay(zzpsVar.size());
            zzpsVar.zza(this);
        }

        @Override // com.google.android.gms.internal.gtm.zzpr
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }
    }

    /* synthetic */ zzqj(C1317la c1317la) {
        this();
    }

    public static int zzc(int i, zzps zzpsVar) {
        int zzbb = zzbb(i);
        int size = zzpsVar.size();
        return zzbb + zzbd(size) + size;
    }

    public static int zzh(byte[] bArr) {
        int length = bArr.length;
        return zzbd(length) + length;
    }

    public static int zzi(int i, int i2) {
        return zzbb(i) + zzbc(i2);
    }

    public final void zzb(double d2) throws IOException {
        zzr(Double.doubleToRawLongBits(d2));
    }

    public static int zzb(int i, float f2) {
        return zzbb(i) + 4;
    }

    public static int zzd(int i, zzsk zzskVar) {
        return (zzbb(1) << 1) + zzj(2, i) + zzc(3, zzskVar);
    }

    public final void zzg(int i, int i2) throws IOException {
        zzf(i, zzbi(i2));
    }

    public static int zzb(int i, double d2) {
        return zzbb(i) + 8;
    }

    public static int zzg(int i, long j) {
        return zzbb(i) + 8;
    }

    public static int zzb(int i, String str) {
        return zzbb(i) + zzda(str);
    }

    public static int zzc(int i, zzsk zzskVar) {
        return zzbb(i) + zzc(zzskVar);
    }

    public static int zzb(int i, zzsk zzskVar, _a _aVar) {
        return zzbb(i) + zzb(zzskVar, _aVar);
    }

    public static int zzc(zzsk zzskVar) {
        int zzpe = zzskVar.zzpe();
        return zzbd(zzpe) + zzpe;
    }

    public static int zzd(int i, zzps zzpsVar) {
        return (zzbb(1) << 1) + zzj(2, i) + zzc(3, zzpsVar);
    }

    public static int zzb(int i, zzrr zzrrVar) {
        return (zzbb(1) << 1) + zzj(2, i) + zza(3, zzrrVar);
    }

    @Deprecated
    public static int zzc(int i, zzsk zzskVar, _a _aVar) {
        int zzbb = zzbb(i) << 1;
        zzpl zzplVar = (zzpl) zzskVar;
        int zzmw = zzplVar.zzmw();
        if (zzmw == -1) {
            zzmw = _aVar.d(zzplVar);
            zzplVar.zzag(zzmw);
        }
        return zzbb + zzmw;
    }

    public final void zza(int i, float f2) throws IOException {
        zzh(i, Float.floatToRawIntBits(f2));
    }

    @Deprecated
    public static int zzd(zzsk zzskVar) {
        return zzskVar.zzpe();
    }

    public final void zza(int i, double d2) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d2));
    }

    public static int zzb(zzps zzpsVar) {
        int size = zzpsVar.size();
        return zzbd(size) + size;
    }

    public final void zza(float f2) throws IOException {
        zzba(Float.floatToRawIntBits(f2));
    }

    public static int zza(int i, zzrr zzrrVar) {
        int zzbb = zzbb(i);
        int zzpe = zzrrVar.zzpe();
        return zzbb + zzbd(zzpe) + zzpe;
    }

    public static int zzb(zzsk zzskVar, _a _aVar) {
        zzpl zzplVar = (zzpl) zzskVar;
        int zzmw = zzplVar.zzmw();
        if (zzmw == -1) {
            zzmw = _aVar.d(zzplVar);
            zzplVar.zzag(zzmw);
        }
        return zzbd(zzmw) + zzmw;
    }

    public static int zza(zzrr zzrrVar) {
        int zzpe = zzrrVar.zzpe();
        return zzbd(zzpe) + zzpe;
    }

    final void zza(String str, zzud zzudVar) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzudVar);
        byte[] bytes = str.getBytes(zzre.UTF_8);
        try {
            zzay(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (zzc e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzc(e3);
        }
    }
}

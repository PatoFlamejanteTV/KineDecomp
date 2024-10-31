package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class zzbqk extends zzbpt {
    private static final Logger logger = Logger.getLogger(zzbqk.class.getName());
    private static final boolean zzfme = Pi.b();
    Gh zzfmf;

    /* loaded from: classes2.dex */
    public static final class b extends a {

        /* renamed from: e */
        private final ByteBuffer f12723e;

        /* renamed from: f */
        private int f12724f;

        b(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.f12723e = byteBuffer;
            this.f12724f = byteBuffer.position();
        }

        @Override // com.google.android.gms.internal.ads.zzbqk.a, com.google.android.gms.internal.ads.zzbqk
        public final void flush() {
            this.f12723e.position(this.f12724f + a());
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbqk.zzc.<init>(java.lang.String):void");
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbqk.zzc.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzbqk() {
    }

    public static int zzaa(int i, int i2) {
        return zzfd(i) + zzff(i2);
    }

    public static int zzab(int i, int i2) {
        return zzfd(i) + zzff(zzfk(i2));
    }

    public static int zzac(int i, int i2) {
        return zzfd(i) + 4;
    }

    public static int zzad(int i, int i2) {
        return zzfd(i) + 4;
    }

    public static int zzae(int i, int i2) {
        return zzfd(i) + zzfe(i2);
    }

    public static int zzao(zzbpu zzbpuVar) {
        int size = zzbpuVar.size();
        return zzff(size) + size;
    }

    public static int zzbb(long j) {
        return zzbc(j);
    }

    public static int zzbc(long j) {
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

    public static int zzbe(long j) {
        return 8;
    }

    public static int zzbe(boolean z) {
        return 1;
    }

    public static int zzbf(long j) {
        return 8;
    }

    private static long zzbg(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzc(double d2) {
        return 8;
    }

    public static int zzc(int i, double d2) {
        return zzfd(i) + 8;
    }

    public static int zzd(int i, zzbsl zzbslVar) {
        return (zzfd(1) << 1) + zzaa(2, i) + zzc(3, zzbslVar);
    }

    public static int zzfd(int i) {
        return zzff(i << 3);
    }

    public static int zzfe(int i) {
        if (i >= 0) {
            return zzff(i);
        }
        return 10;
    }

    public static int zzff(int i) {
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

    public static int zzfg(int i) {
        return zzff(zzfk(i));
    }

    public static int zzfh(int i) {
        return 4;
    }

    public static int zzfi(int i) {
        return 4;
    }

    public static int zzfj(int i) {
        return zzfe(i);
    }

    private static int zzfk(int i) {
        return (i >> 31) ^ (i << 1);
    }

    @Deprecated
    public static int zzfl(int i) {
        return zzff(i);
    }

    public static int zzfy(String str) {
        int length;
        try {
            length = Ri.a(str);
        } catch (zzbug unused) {
            length = str.getBytes(zzbrf.UTF_8).length;
        }
        return zzff(length) + length;
    }

    public static int zzg(float f2) {
        return 4;
    }

    public static int zzg(int i, String str) {
        return zzfd(i) + zzfy(str);
    }

    public static int zzm(int i, long j) {
        return zzfd(i) + zzbc(j);
    }

    public static zzbqk zzn(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            if (Pi.c()) {
                return new d(byteBuffer);
            }
            return new c(byteBuffer);
        }
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    public static int zzo(int i, long j) {
        return zzfd(i) + zzbc(zzbg(j));
    }

    public static int zzp(int i, long j) {
        return zzfd(i) + 8;
    }

    public static int zzq(int i, long j) {
        return zzfd(i) + 8;
    }

    public static zzbqk zzt(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int zzu(byte[] bArr) {
        int length = bArr.length;
        return zzff(length) + length;
    }

    public static int zzz(int i, int i2) {
        return zzfd(i) + zzfe(i2);
    }

    public abstract void flush() throws IOException;

    public abstract void write(byte[] bArr, int i, int i2) throws IOException;

    public final void zza(int i, float f2) throws IOException {
        zzy(i, Float.floatToRawIntBits(f2));
    }

    public abstract void zza(int i, zzbpu zzbpuVar) throws IOException;

    public abstract void zza(int i, zzbsl zzbslVar) throws IOException;

    public abstract void zza(int i, zzbsl zzbslVar, InterfaceC1112ui interfaceC1112ui) throws IOException;

    abstract void zza(zzbsl zzbslVar, InterfaceC1112ui interfaceC1112ui) throws IOException;

    public abstract int zzalu();

    public final void zzalv() {
        if (zzalu() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void zzan(zzbpu zzbpuVar) throws IOException;

    public abstract void zzay(long j) throws IOException;

    public final void zzaz(long j) throws IOException {
        zzay(zzbg(j));
    }

    public final void zzb(int i, double d2) throws IOException {
        zzl(i, Double.doubleToRawLongBits(d2));
    }

    public abstract void zzb(int i, zzbpu zzbpuVar) throws IOException;

    public abstract void zzb(int i, zzbsl zzbslVar) throws IOException;

    public abstract void zzba(long j) throws IOException;

    public final void zzbd(boolean z) throws IOException {
        zzd(z ? (byte) 1 : (byte) 0);
    }

    public abstract void zzd(byte b2) throws IOException;

    public abstract void zze(zzbsl zzbslVar) throws IOException;

    public abstract void zzez(int i) throws IOException;

    public final void zzf(float f2) throws IOException {
        zzfc(Float.floatToRawIntBits(f2));
    }

    public abstract void zzf(int i, String str) throws IOException;

    public abstract void zzfa(int i) throws IOException;

    public final void zzfb(int i) throws IOException {
        zzfa(zzfk(i));
    }

    public abstract void zzfc(int i) throws IOException;

    public abstract void zzfx(String str) throws IOException;

    public abstract void zzj(int i, long j) throws IOException;

    public abstract void zzj(int i, boolean z) throws IOException;

    public final void zzk(int i, long j) throws IOException {
        zzj(i, zzbg(j));
    }

    public abstract void zzl(int i, long j) throws IOException;

    public abstract void zzl(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzu(int i, int i2) throws IOException;

    public abstract void zzv(int i, int i2) throws IOException;

    public abstract void zzw(int i, int i2) throws IOException;

    public final void zzx(int i, int i2) throws IOException {
        zzw(i, zzfk(i2));
    }

    public abstract void zzy(int i, int i2) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends zzbqk {

        /* renamed from: a */
        private final byte[] f12719a;

        /* renamed from: b */
        private final int f12720b;

        /* renamed from: c */
        private final int f12721c;

        /* renamed from: d */
        private int f12722d;

        a(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i + i2;
                if ((i | i2 | (bArr.length - i3)) >= 0) {
                    this.f12719a = bArr;
                    this.f12720b = i;
                    this.f12722d = i;
                    this.f12721c = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            throw new NullPointerException("buffer");
        }

        public final int a() {
            return this.f12722d - this.f12720b;
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public void flush() {
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.f12719a, this.f12722d, i2);
                this.f12722d += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12722d), Integer.valueOf(this.f12721c), Integer.valueOf(i2)), e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zza(int i, zzbpu zzbpuVar) throws IOException {
            zzu(i, 2);
            zzan(zzbpuVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final int zzalu() {
            return this.f12721c - this.f12722d;
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzan(zzbpu zzbpuVar) throws IOException {
            zzfa(zzbpuVar.size());
            zzbpuVar.zza(this);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzay(long j) throws IOException {
            if (zzbqk.zzfme && zzalu() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.f12719a;
                    int i = this.f12722d;
                    this.f12722d = i + 1;
                    Pi.a(bArr, i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.f12719a;
                int i2 = this.f12722d;
                this.f12722d = i2 + 1;
                Pi.a(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f12719a;
                    int i3 = this.f12722d;
                    this.f12722d = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12722d), Integer.valueOf(this.f12721c), 1), e2);
                }
            }
            byte[] bArr4 = this.f12719a;
            int i4 = this.f12722d;
            this.f12722d = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzb(int i, zzbsl zzbslVar) throws IOException {
            zzu(1, 3);
            zzw(2, i);
            zza(3, zzbslVar);
            zzu(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzba(long j) throws IOException {
            try {
                byte[] bArr = this.f12719a;
                int i = this.f12722d;
                this.f12722d = i + 1;
                bArr[i] = (byte) j;
                byte[] bArr2 = this.f12719a;
                int i2 = this.f12722d;
                this.f12722d = i2 + 1;
                bArr2[i2] = (byte) (j >> 8);
                byte[] bArr3 = this.f12719a;
                int i3 = this.f12722d;
                this.f12722d = i3 + 1;
                bArr3[i3] = (byte) (j >> 16);
                byte[] bArr4 = this.f12719a;
                int i4 = this.f12722d;
                this.f12722d = i4 + 1;
                bArr4[i4] = (byte) (j >> 24);
                byte[] bArr5 = this.f12719a;
                int i5 = this.f12722d;
                this.f12722d = i5 + 1;
                bArr5[i5] = (byte) (j >> 32);
                byte[] bArr6 = this.f12719a;
                int i6 = this.f12722d;
                this.f12722d = i6 + 1;
                bArr6[i6] = (byte) (j >> 40);
                byte[] bArr7 = this.f12719a;
                int i7 = this.f12722d;
                this.f12722d = i7 + 1;
                bArr7[i7] = (byte) (j >> 48);
                byte[] bArr8 = this.f12719a;
                int i8 = this.f12722d;
                this.f12722d = i8 + 1;
                bArr8[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12722d), Integer.valueOf(this.f12721c), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzd(byte b2) throws IOException {
            try {
                byte[] bArr = this.f12719a;
                int i = this.f12722d;
                this.f12722d = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12722d), Integer.valueOf(this.f12721c), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zze(zzbsl zzbslVar) throws IOException {
            zzfa(zzbslVar.zzamj());
            zzbslVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzez(int i) throws IOException {
            if (i >= 0) {
                zzfa(i);
            } else {
                zzay(i);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzf(int i, String str) throws IOException {
            zzu(i, 2);
            zzfx(str);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzfa(int i) throws IOException {
            if (zzbqk.zzfme && zzalu() >= 10) {
                while ((i & (-128)) != 0) {
                    byte[] bArr = this.f12719a;
                    int i2 = this.f12722d;
                    this.f12722d = i2 + 1;
                    Pi.a(bArr, i2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.f12719a;
                int i3 = this.f12722d;
                this.f12722d = i3 + 1;
                Pi.a(bArr2, i3, (byte) i);
                return;
            }
            while ((i & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f12719a;
                    int i4 = this.f12722d;
                    this.f12722d = i4 + 1;
                    bArr3[i4] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12722d), Integer.valueOf(this.f12721c), 1), e2);
                }
            }
            byte[] bArr4 = this.f12719a;
            int i5 = this.f12722d;
            this.f12722d = i5 + 1;
            bArr4[i5] = (byte) i;
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzfc(int i) throws IOException {
            try {
                byte[] bArr = this.f12719a;
                int i2 = this.f12722d;
                this.f12722d = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.f12719a;
                int i3 = this.f12722d;
                this.f12722d = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.f12719a;
                int i4 = this.f12722d;
                this.f12722d = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.f12719a;
                int i5 = this.f12722d;
                this.f12722d = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12722d), Integer.valueOf(this.f12721c), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzfx(String str) throws IOException {
            int i = this.f12722d;
            try {
                int zzff = zzbqk.zzff(str.length() * 3);
                int zzff2 = zzbqk.zzff(str.length());
                if (zzff2 == zzff) {
                    this.f12722d = i + zzff2;
                    int a2 = Ri.a(str, this.f12719a, this.f12722d, zzalu());
                    this.f12722d = i;
                    zzfa((a2 - i) - zzff2);
                    this.f12722d = a2;
                    return;
                }
                zzfa(Ri.a(str));
                this.f12722d = Ri.a(str, this.f12719a, this.f12722d, zzalu());
            } catch (zzbug e2) {
                this.f12722d = i;
                zza(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbpt
        public final void zzh(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzj(int i, long j) throws IOException {
            zzu(i, 0);
            zzay(j);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzl(int i, long j) throws IOException {
            zzu(i, 1);
            zzba(j);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzu(int i, int i2) throws IOException {
            zzfa((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzv(int i, int i2) throws IOException {
            zzu(i, 0);
            zzez(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzw(int i, int i2) throws IOException {
            zzu(i, 0);
            zzfa(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzy(int i, int i2) throws IOException {
            zzu(i, 5);
            zzfc(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zza(int i, zzbsl zzbslVar) throws IOException {
            zzu(i, 2);
            zze(zzbslVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzj(int i, boolean z) throws IOException {
            zzu(i, 0);
            zzd(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzl(byte[] bArr, int i, int i2) throws IOException {
            zzfa(i2);
            write(bArr, 0, i2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zza(int i, zzbsl zzbslVar, InterfaceC1112ui interfaceC1112ui) throws IOException {
            zzu(i, 2);
            zzbpl zzbplVar = (zzbpl) zzbslVar;
            int zzakg = zzbplVar.zzakg();
            if (zzakg == -1) {
                zzakg = interfaceC1112ui.c(zzbplVar);
                zzbplVar.zzei(zzakg);
            }
            zzfa(zzakg);
            interfaceC1112ui.a((InterfaceC1112ui) zzbslVar, (Xi) this.zzfmf);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzb(int i, zzbpu zzbpuVar) throws IOException {
            zzu(1, 3);
            zzw(2, i);
            zza(3, zzbpuVar);
            zzu(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        final void zza(zzbsl zzbslVar, InterfaceC1112ui interfaceC1112ui) throws IOException {
            zzbpl zzbplVar = (zzbpl) zzbslVar;
            int zzakg = zzbplVar.zzakg();
            if (zzakg == -1) {
                zzakg = interfaceC1112ui.c(zzbplVar);
                zzbplVar.zzei(zzakg);
            }
            zzfa(zzakg);
            interfaceC1112ui.a((InterfaceC1112ui) zzbslVar, (Xi) this.zzfmf);
        }
    }

    /* loaded from: classes2.dex */
    public static final class c extends zzbqk {

        /* renamed from: a */
        private final ByteBuffer f12725a;

        /* renamed from: b */
        private final ByteBuffer f12726b;

        /* renamed from: c */
        private final int f12727c;

        c(ByteBuffer byteBuffer) {
            super();
            this.f12725a = byteBuffer;
            this.f12726b = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f12727c = byteBuffer.position();
        }

        private final void a(String str) throws IOException {
            try {
                Ri.a(str, this.f12726b);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void flush() {
            this.f12725a.position(this.f12726b.position());
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.f12726b.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            } catch (BufferOverflowException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zza(int i, zzbpu zzbpuVar) throws IOException {
            zzu(i, 2);
            zzan(zzbpuVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final int zzalu() {
            return this.f12726b.remaining();
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzan(zzbpu zzbpuVar) throws IOException {
            zzfa(zzbpuVar.size());
            zzbpuVar.zza(this);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzay(long j) throws IOException {
            while (((-128) & j) != 0) {
                try {
                    this.f12726b.put((byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                } catch (BufferOverflowException e2) {
                    throw new zzc(e2);
                }
            }
            this.f12726b.put((byte) j);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzb(int i, zzbsl zzbslVar) throws IOException {
            zzu(1, 3);
            zzw(2, i);
            zza(3, zzbslVar);
            zzu(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzba(long j) throws IOException {
            try {
                this.f12726b.putLong(j);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzd(byte b2) throws IOException {
            try {
                this.f12726b.put(b2);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zze(zzbsl zzbslVar) throws IOException {
            zzfa(zzbslVar.zzamj());
            zzbslVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzez(int i) throws IOException {
            if (i >= 0) {
                zzfa(i);
            } else {
                zzay(i);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzf(int i, String str) throws IOException {
            zzu(i, 2);
            zzfx(str);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzfa(int i) throws IOException {
            while ((i & (-128)) != 0) {
                try {
                    this.f12726b.put((byte) ((i & 127) | 128));
                    i >>>= 7;
                } catch (BufferOverflowException e2) {
                    throw new zzc(e2);
                }
            }
            this.f12726b.put((byte) i);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzfc(int i) throws IOException {
            try {
                this.f12726b.putInt(i);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzfx(String str) throws IOException {
            int position = this.f12726b.position();
            try {
                int zzff = zzbqk.zzff(str.length() * 3);
                int zzff2 = zzbqk.zzff(str.length());
                if (zzff2 == zzff) {
                    int position2 = this.f12726b.position() + zzff2;
                    this.f12726b.position(position2);
                    a(str);
                    int position3 = this.f12726b.position();
                    this.f12726b.position(position);
                    zzfa(position3 - position2);
                    this.f12726b.position(position3);
                    return;
                }
                zzfa(Ri.a(str));
                a(str);
            } catch (zzbug e2) {
                this.f12726b.position(position);
                zza(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbpt
        public final void zzh(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzj(int i, long j) throws IOException {
            zzu(i, 0);
            zzay(j);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzl(int i, long j) throws IOException {
            zzu(i, 1);
            zzba(j);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzu(int i, int i2) throws IOException {
            zzfa((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzv(int i, int i2) throws IOException {
            zzu(i, 0);
            zzez(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzw(int i, int i2) throws IOException {
            zzu(i, 0);
            zzfa(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzy(int i, int i2) throws IOException {
            zzu(i, 5);
            zzfc(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zza(int i, zzbsl zzbslVar) throws IOException {
            zzu(i, 2);
            zze(zzbslVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzj(int i, boolean z) throws IOException {
            zzu(i, 0);
            zzd(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzl(byte[] bArr, int i, int i2) throws IOException {
            zzfa(i2);
            write(bArr, 0, i2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zza(int i, zzbsl zzbslVar, InterfaceC1112ui interfaceC1112ui) throws IOException {
            zzu(i, 2);
            zza(zzbslVar, interfaceC1112ui);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzb(int i, zzbpu zzbpuVar) throws IOException {
            zzu(1, 3);
            zzw(2, i);
            zza(3, zzbpuVar);
            zzu(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        final void zza(zzbsl zzbslVar, InterfaceC1112ui interfaceC1112ui) throws IOException {
            zzbpl zzbplVar = (zzbpl) zzbslVar;
            int zzakg = zzbplVar.zzakg();
            if (zzakg == -1) {
                zzakg = interfaceC1112ui.c(zzbplVar);
                zzbplVar.zzei(zzakg);
            }
            zzfa(zzakg);
            interfaceC1112ui.a((InterfaceC1112ui) zzbslVar, (Xi) this.zzfmf);
        }
    }

    /* loaded from: classes2.dex */
    public static final class d extends zzbqk {

        /* renamed from: a */
        private final ByteBuffer f12728a;

        /* renamed from: b */
        private final ByteBuffer f12729b;

        /* renamed from: c */
        private final long f12730c;

        /* renamed from: d */
        private final long f12731d;

        /* renamed from: e */
        private final long f12732e;

        /* renamed from: f */
        private final long f12733f;

        /* renamed from: g */
        private long f12734g;

        d(ByteBuffer byteBuffer) {
            super();
            this.f12728a = byteBuffer;
            this.f12729b = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f12730c = Pi.a(byteBuffer);
            this.f12731d = this.f12730c + byteBuffer.position();
            this.f12732e = this.f12730c + byteBuffer.limit();
            this.f12733f = this.f12732e - 10;
            this.f12734g = this.f12731d;
        }

        private final void a(long j) {
            this.f12729b.position((int) (j - this.f12730c));
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void flush() {
            this.f12728a.position((int) (this.f12734g - this.f12730c));
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i) {
                long j = i2;
                long j2 = this.f12732e - j;
                long j3 = this.f12734g;
                if (j2 >= j3) {
                    Pi.a(bArr, i, j3, j);
                    this.f12734g += j;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f12734g), Long.valueOf(this.f12732e), Integer.valueOf(i2)));
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zza(int i, zzbpu zzbpuVar) throws IOException {
            zzu(i, 2);
            zzan(zzbpuVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final int zzalu() {
            return (int) (this.f12732e - this.f12734g);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzan(zzbpu zzbpuVar) throws IOException {
            zzfa(zzbpuVar.size());
            zzbpuVar.zza(this);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzay(long j) throws IOException {
            if (this.f12734g <= this.f12733f) {
                while ((j & (-128)) != 0) {
                    long j2 = this.f12734g;
                    this.f12734g = j2 + 1;
                    Pi.a(j2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                long j3 = this.f12734g;
                this.f12734g = 1 + j3;
                Pi.a(j3, (byte) j);
                return;
            }
            while (true) {
                long j4 = this.f12734g;
                if (j4 >= this.f12732e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j4), Long.valueOf(this.f12732e), 1));
                }
                if ((j & (-128)) == 0) {
                    this.f12734g = 1 + j4;
                    Pi.a(j4, (byte) j);
                    return;
                } else {
                    this.f12734g = j4 + 1;
                    Pi.a(j4, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzb(int i, zzbsl zzbslVar) throws IOException {
            zzu(1, 3);
            zzw(2, i);
            zza(3, zzbslVar);
            zzu(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzba(long j) throws IOException {
            this.f12729b.putLong((int) (this.f12734g - this.f12730c), j);
            this.f12734g += 8;
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzd(byte b2) throws IOException {
            long j = this.f12734g;
            if (j < this.f12732e) {
                this.f12734g = 1 + j;
                Pi.a(j, b2);
                return;
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j), Long.valueOf(this.f12732e), 1));
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zze(zzbsl zzbslVar) throws IOException {
            zzfa(zzbslVar.zzamj());
            zzbslVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzez(int i) throws IOException {
            if (i >= 0) {
                zzfa(i);
            } else {
                zzay(i);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzf(int i, String str) throws IOException {
            zzu(i, 2);
            zzfx(str);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzfa(int i) throws IOException {
            if (this.f12734g <= this.f12733f) {
                while ((i & (-128)) != 0) {
                    long j = this.f12734g;
                    this.f12734g = j + 1;
                    Pi.a(j, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                long j2 = this.f12734g;
                this.f12734g = 1 + j2;
                Pi.a(j2, (byte) i);
                return;
            }
            while (true) {
                long j3 = this.f12734g;
                if (j3 >= this.f12732e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j3), Long.valueOf(this.f12732e), 1));
                }
                if ((i & (-128)) == 0) {
                    this.f12734g = 1 + j3;
                    Pi.a(j3, (byte) i);
                    return;
                } else {
                    this.f12734g = j3 + 1;
                    Pi.a(j3, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzfc(int i) throws IOException {
            this.f12729b.putInt((int) (this.f12734g - this.f12730c), i);
            this.f12734g += 4;
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzfx(String str) throws IOException {
            long j = this.f12734g;
            try {
                int zzff = zzbqk.zzff(str.length() * 3);
                int zzff2 = zzbqk.zzff(str.length());
                if (zzff2 == zzff) {
                    int i = ((int) (this.f12734g - this.f12730c)) + zzff2;
                    this.f12729b.position(i);
                    Ri.a(str, this.f12729b);
                    int position = this.f12729b.position() - i;
                    zzfa(position);
                    this.f12734g += position;
                    return;
                }
                int a2 = Ri.a(str);
                zzfa(a2);
                a(this.f12734g);
                Ri.a(str, this.f12729b);
                this.f12734g += a2;
            } catch (zzbug e2) {
                this.f12734g = j;
                a(this.f12734g);
                zza(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new zzc(e3);
            } catch (IndexOutOfBoundsException e4) {
                throw new zzc(e4);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbpt
        public final void zzh(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzj(int i, long j) throws IOException {
            zzu(i, 0);
            zzay(j);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzl(int i, long j) throws IOException {
            zzu(i, 1);
            zzba(j);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzu(int i, int i2) throws IOException {
            zzfa((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzv(int i, int i2) throws IOException {
            zzu(i, 0);
            zzez(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzw(int i, int i2) throws IOException {
            zzu(i, 0);
            zzfa(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzy(int i, int i2) throws IOException {
            zzu(i, 5);
            zzfc(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zza(int i, zzbsl zzbslVar) throws IOException {
            zzu(i, 2);
            zze(zzbslVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzj(int i, boolean z) throws IOException {
            zzu(i, 0);
            zzd(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzl(byte[] bArr, int i, int i2) throws IOException {
            zzfa(i2);
            write(bArr, 0, i2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zza(int i, zzbsl zzbslVar, InterfaceC1112ui interfaceC1112ui) throws IOException {
            zzu(i, 2);
            zza(zzbslVar, interfaceC1112ui);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        public final void zzb(int i, zzbpu zzbpuVar) throws IOException {
            zzu(1, 3);
            zzw(2, i);
            zza(3, zzbpuVar);
            zzu(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzbqk
        final void zza(zzbsl zzbslVar, InterfaceC1112ui interfaceC1112ui) throws IOException {
            zzbpl zzbplVar = (zzbpl) zzbslVar;
            int zzakg = zzbplVar.zzakg();
            if (zzakg == -1) {
                zzakg = interfaceC1112ui.c(zzbplVar);
                zzbplVar.zzei(zzakg);
            }
            zzfa(zzakg);
            interfaceC1112ui.a((InterfaceC1112ui) zzbslVar, (Xi) this.zzfmf);
        }
    }

    /* synthetic */ zzbqk(Fh fh) {
        this();
    }

    public static int zza(int i, zzbrs zzbrsVar) {
        int zzfd = zzfd(i);
        int zzamj = zzbrsVar.zzamj();
        return zzfd + zzff(zzamj) + zzamj;
    }

    public static int zzbd(long j) {
        return zzbc(zzbg(j));
    }

    public static int zzc(int i, zzbpu zzbpuVar) {
        int zzfd = zzfd(i);
        int size = zzbpuVar.size();
        return zzfd + zzff(size) + size;
    }

    public static int zzf(zzbsl zzbslVar) {
        int zzamj = zzbslVar.zzamj();
        return zzff(zzamj) + zzamj;
    }

    @Deprecated
    public static int zzg(zzbsl zzbslVar) {
        return zzbslVar.zzamj();
    }

    public static int zzk(int i, boolean z) {
        return zzfd(i) + 1;
    }

    public final void zzb(double d2) throws IOException {
        zzba(Double.doubleToRawLongBits(d2));
    }

    public static int zzb(int i, float f2) {
        return zzfd(i) + 4;
    }

    public static int zzb(int i, zzbsl zzbslVar, InterfaceC1112ui interfaceC1112ui) {
        return zzfd(i) + zzb(zzbslVar, interfaceC1112ui);
    }

    public static int zzd(int i, zzbpu zzbpuVar) {
        return (zzfd(1) << 1) + zzaa(2, i) + zzc(3, zzbpuVar);
    }

    public static int zza(zzbrs zzbrsVar) {
        int zzamj = zzbrsVar.zzamj();
        return zzff(zzamj) + zzamj;
    }

    public static int zzb(int i, zzbrs zzbrsVar) {
        return (zzfd(1) << 1) + zzaa(2, i) + zza(3, zzbrsVar);
    }

    public static int zzc(int i, zzbsl zzbslVar) {
        return zzfd(i) + zzf(zzbslVar);
    }

    @Deprecated
    public static int zzc(int i, zzbsl zzbslVar, InterfaceC1112ui interfaceC1112ui) {
        int zzfd = zzfd(i) << 1;
        zzbpl zzbplVar = (zzbpl) zzbslVar;
        int zzakg = zzbplVar.zzakg();
        if (zzakg == -1) {
            zzakg = interfaceC1112ui.c(zzbplVar);
            zzbplVar.zzei(zzakg);
        }
        return zzfd + zzakg;
    }

    final void zza(String str, zzbug zzbugVar) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzbugVar);
        byte[] bytes = str.getBytes(zzbrf.UTF_8);
        try {
            zzfa(bytes.length);
            zzh(bytes, 0, bytes.length);
        } catch (zzc e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzc(e3);
        }
    }

    public static int zzb(zzbsl zzbslVar, InterfaceC1112ui interfaceC1112ui) {
        zzbpl zzbplVar = (zzbpl) zzbslVar;
        int zzakg = zzbplVar.zzakg();
        if (zzakg == -1) {
            zzakg = interfaceC1112ui.c(zzbplVar);
            zzbplVar.zzei(zzakg);
        }
        return zzff(zzakg) + zzakg;
    }

    public static int zzn(int i, long j) {
        return zzfd(i) + zzbc(j);
    }
}

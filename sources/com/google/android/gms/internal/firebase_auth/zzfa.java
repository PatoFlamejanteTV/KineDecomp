package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class zzfa extends zzeg {
    private static final Logger logger = Logger.getLogger(zzfa.class.getName());
    private static final boolean zztp = Ja.b();
    C1275t zztq;

    /* loaded from: classes2.dex */
    public static class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        zzb(java.lang.String r3, java.lang.Throwable r4) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzfa.zzb.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzfa() {
    }

    public static int zzag(int i) {
        return zzai(i << 3);
    }

    public static int zzah(int i) {
        if (i >= 0) {
            return zzai(i);
        }
        return 10;
    }

    public static int zzai(int i) {
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

    public static int zzaj(int i) {
        return zzai(zzan(i));
    }

    public static int zzak(int i) {
        return 4;
    }

    public static int zzal(int i) {
        return 4;
    }

    public static int zzam(int i) {
        return zzah(i);
    }

    private static int zzan(int i) {
        return (i >> 31) ^ (i << 1);
    }

    @Deprecated
    public static int zzao(int i) {
        return zzai(i);
    }

    public static int zzb(double d2) {
        return 8;
    }

    public static int zzb(float f2) {
        return 4;
    }

    public static zzfa zzb(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int zzd(int i, long j) {
        return zzag(i) + zzf(j);
    }

    public static int zzdb(String str) {
        int length;
        try {
            length = La.a(str);
        } catch (zzjc unused) {
            length = str.getBytes(zzfv.UTF_8).length;
        }
        return zzai(length) + length;
    }

    public static int zze(int i, long j) {
        return zzag(i) + zzf(j);
    }

    public static int zzf(int i, long j) {
        return zzag(i) + zzf(zzj(j));
    }

    public static int zzf(long j) {
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

    public static int zzg(int i, long j) {
        return zzag(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzag(i) + 8;
    }

    public static int zzh(long j) {
        return 8;
    }

    public static int zzi(long j) {
        return 8;
    }

    private static long zzj(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzk(int i, int i2) {
        return zzag(i) + zzah(i2);
    }

    public static int zzl(int i, int i2) {
        return zzag(i) + zzai(i2);
    }

    public static int zzm(int i, int i2) {
        return zzag(i) + zzai(zzan(i2));
    }

    public static int zzn(int i, int i2) {
        return zzag(i) + 4;
    }

    public static int zzo(int i, int i2) {
        return zzag(i) + 4;
    }

    public static int zzp(int i, int i2) {
        return zzag(i) + zzah(i2);
    }

    public static int zzt(boolean z) {
        return 1;
    }

    public final void zza(int i, float f2) throws IOException {
        zzj(i, Float.floatToRawIntBits(f2));
    }

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzeh zzehVar) throws IOException;

    public abstract void zza(int i, zzhc zzhcVar) throws IOException;

    public abstract void zza(int i, zzhc zzhcVar, InterfaceC1263ma interfaceC1263ma) throws IOException;

    public abstract void zza(int i, String str) throws IOException;

    public abstract void zza(zzeh zzehVar) throws IOException;

    public abstract void zzac(int i) throws IOException;

    public abstract void zzad(int i) throws IOException;

    public final void zzae(int i) throws IOException {
        zzad(zzan(i));
    }

    public abstract void zzaf(int i) throws IOException;

    public abstract void zzb(int i, zzeh zzehVar) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(long j) throws IOException;

    public abstract void zzc(byte b2) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public final void zzc(long j) throws IOException {
        zzb(zzj(j));
    }

    public abstract void zzc(zzhc zzhcVar) throws IOException;

    public abstract void zzd(long j) throws IOException;

    public abstract void zzd(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzda(String str) throws IOException;

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract void zzg(int i, int i2) throws IOException;

    public abstract int zzgi();

    public final void zzgj() {
        if (zzgi() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void zzh(int i, int i2) throws IOException;

    public final void zzi(int i, int i2) throws IOException {
        zzh(i, zzan(i2));
    }

    public abstract void zzj(int i, int i2) throws IOException;

    public final void zzs(boolean z) throws IOException {
        zzc(z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends zzfa {

        /* renamed from: a */
        private final byte[] f13107a;

        /* renamed from: b */
        private final int f13108b;

        /* renamed from: c */
        private final int f13109c;

        /* renamed from: d */
        private int f13110d;

        a(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i2 + 0;
                if ((i2 | 0 | (bArr.length - i3)) >= 0) {
                    this.f13107a = bArr;
                    this.f13108b = 0;
                    this.f13110d = 0;
                    this.f13109c = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
            }
            throw new NullPointerException("buffer");
        }

        private final void a(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.f13107a, this.f13110d, i2);
                this.f13110d += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13110d), Integer.valueOf(this.f13109c), Integer.valueOf(i2)), e2);
            }
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zza(int i, long j) throws IOException {
            zzf(i, 0);
            zzb(j);
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zzac(int i) throws IOException {
            if (i >= 0) {
                zzad(i);
            } else {
                zzb(i);
            }
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zzad(int i) throws IOException {
            if (zzfa.zztp && zzgi() >= 10) {
                while ((i & (-128)) != 0) {
                    byte[] bArr = this.f13107a;
                    int i2 = this.f13110d;
                    this.f13110d = i2 + 1;
                    Ja.a(bArr, i2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.f13107a;
                int i3 = this.f13110d;
                this.f13110d = i3 + 1;
                Ja.a(bArr2, i3, (byte) i);
                return;
            }
            while ((i & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f13107a;
                    int i4 = this.f13110d;
                    this.f13110d = i4 + 1;
                    bArr3[i4] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13110d), Integer.valueOf(this.f13109c), 1), e2);
                }
            }
            byte[] bArr4 = this.f13107a;
            int i5 = this.f13110d;
            this.f13110d = i5 + 1;
            bArr4[i5] = (byte) i;
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zzaf(int i) throws IOException {
            try {
                byte[] bArr = this.f13107a;
                int i2 = this.f13110d;
                this.f13110d = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.f13107a;
                int i3 = this.f13110d;
                this.f13110d = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.f13107a;
                int i4 = this.f13110d;
                this.f13110d = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.f13107a;
                int i5 = this.f13110d;
                this.f13110d = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13110d), Integer.valueOf(this.f13109c), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zzb(int i, boolean z) throws IOException {
            zzf(i, 0);
            zzc(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zzc(int i, long j) throws IOException {
            zzf(i, 1);
            zzd(j);
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zzd(byte[] bArr, int i, int i2) throws IOException {
            zzad(i2);
            a(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zzda(String str) throws IOException {
            int i = this.f13110d;
            try {
                int zzai = zzfa.zzai(str.length() * 3);
                int zzai2 = zzfa.zzai(str.length());
                if (zzai2 == zzai) {
                    this.f13110d = i + zzai2;
                    int a2 = La.a(str, this.f13107a, this.f13110d, zzgi());
                    this.f13110d = i;
                    zzad((a2 - i) - zzai2);
                    this.f13110d = a2;
                    return;
                }
                zzad(La.a(str));
                this.f13110d = La.a(str, this.f13107a, this.f13110d, zzgi());
            } catch (zzjc e2) {
                this.f13110d = i;
                zza(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzb(e3);
            }
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zzf(int i, int i2) throws IOException {
            zzad((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zzg(int i, int i2) throws IOException {
            zzf(i, 0);
            zzac(i2);
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final int zzgi() {
            return this.f13109c - this.f13110d;
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zzh(int i, int i2) throws IOException {
            zzf(i, 0);
            zzad(i2);
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zzj(int i, int i2) throws IOException {
            zzf(i, 5);
            zzaf(i2);
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zza(int i, String str) throws IOException {
            zzf(i, 2);
            zzda(str);
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zzb(int i, zzeh zzehVar) throws IOException {
            zzf(1, 3);
            zzh(2, i);
            zza(3, zzehVar);
            zzf(1, 4);
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zzc(zzhc zzhcVar) throws IOException {
            zzad(zzhcVar.zzgw());
            zzhcVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zzd(long j) throws IOException {
            try {
                byte[] bArr = this.f13107a;
                int i = this.f13110d;
                this.f13110d = i + 1;
                bArr[i] = (byte) j;
                byte[] bArr2 = this.f13107a;
                int i2 = this.f13110d;
                this.f13110d = i2 + 1;
                bArr2[i2] = (byte) (j >> 8);
                byte[] bArr3 = this.f13107a;
                int i3 = this.f13110d;
                this.f13110d = i3 + 1;
                bArr3[i3] = (byte) (j >> 16);
                byte[] bArr4 = this.f13107a;
                int i4 = this.f13110d;
                this.f13110d = i4 + 1;
                bArr4[i4] = (byte) (j >> 24);
                byte[] bArr5 = this.f13107a;
                int i5 = this.f13110d;
                this.f13110d = i5 + 1;
                bArr5[i5] = (byte) (j >> 32);
                byte[] bArr6 = this.f13107a;
                int i6 = this.f13110d;
                this.f13110d = i6 + 1;
                bArr6[i6] = (byte) (j >> 40);
                byte[] bArr7 = this.f13107a;
                int i7 = this.f13110d;
                this.f13110d = i7 + 1;
                bArr7[i7] = (byte) (j >> 48);
                byte[] bArr8 = this.f13107a;
                int i8 = this.f13110d;
                this.f13110d = i8 + 1;
                bArr8[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13110d), Integer.valueOf(this.f13109c), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zza(int i, zzeh zzehVar) throws IOException {
            zzf(i, 2);
            zza(zzehVar);
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zzc(byte b2) throws IOException {
            try {
                byte[] bArr = this.f13107a;
                int i = this.f13110d;
                this.f13110d = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13110d), Integer.valueOf(this.f13109c), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zza(zzeh zzehVar) throws IOException {
            zzad(zzehVar.size());
            zzehVar.zza(this);
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zzb(long j) throws IOException {
            if (zzfa.zztp && zzgi() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.f13107a;
                    int i = this.f13110d;
                    this.f13110d = i + 1;
                    Ja.a(bArr, i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.f13107a;
                int i2 = this.f13110d;
                this.f13110d = i2 + 1;
                Ja.a(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f13107a;
                    int i3 = this.f13110d;
                    this.f13110d = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13110d), Integer.valueOf(this.f13109c), 1), e2);
                }
            }
            byte[] bArr4 = this.f13107a;
            int i4 = this.f13110d;
            this.f13110d = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zza(int i, zzhc zzhcVar, InterfaceC1263ma interfaceC1263ma) throws IOException {
            zzf(i, 2);
            zzdz zzdzVar = (zzdz) zzhcVar;
            int zzes = zzdzVar.zzes();
            if (zzes == -1) {
                zzes = interfaceC1263ma.c(zzdzVar);
                zzdzVar.zzg(zzes);
            }
            zzad(zzes);
            interfaceC1263ma.a((InterfaceC1263ma) zzhcVar, (Ra) this.zztq);
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzfa
        public final void zza(int i, zzhc zzhcVar) throws IOException {
            zzf(1, 3);
            zzh(2, i);
            zzf(3, 2);
            zzc(zzhcVar);
            zzf(1, 4);
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzeg
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            a(bArr, i, i2);
        }
    }

    /* synthetic */ zzfa(C1273s c1273s) {
        this();
    }

    public static int zzc(int i, boolean z) {
        return zzag(i) + 1;
    }

    public static int zze(long j) {
        return zzf(j);
    }

    public static int zzg(long j) {
        return zzf(zzj(j));
    }

    public final void zza(int i, double d2) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d2));
    }

    public static int zzc(int i, zzeh zzehVar) {
        int zzag = zzag(i);
        int size = zzehVar.size();
        return zzag + zzai(size) + size;
    }

    public static int zzd(int i, zzeh zzehVar) {
        return (zzag(1) << 1) + zzl(2, i) + zzc(3, zzehVar);
    }

    @Deprecated
    public static int zze(zzhc zzhcVar) {
        return zzhcVar.zzgw();
    }

    public final void zza(float f2) throws IOException {
        zzaf(Float.floatToRawIntBits(f2));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzj(j));
    }

    public static int zzb(int i, float f2) {
        return zzag(i) + 4;
    }

    public final void zza(double d2) throws IOException {
        zzd(Double.doubleToRawLongBits(d2));
    }

    public static int zza(int i, zzgj zzgjVar) {
        int zzag = zzag(i);
        int zzgw = zzgjVar.zzgw();
        return zzag + zzai(zzgw) + zzgw;
    }

    public static int zzb(int i, double d2) {
        return zzag(i) + 8;
    }

    public static int zzb(int i, String str) {
        return zzag(i) + zzdb(str);
    }

    public static int zzc(byte[] bArr) {
        int length = bArr.length;
        return zzai(length) + length;
    }

    public static int zzd(zzhc zzhcVar) {
        int zzgw = zzhcVar.zzgw();
        return zzai(zzgw) + zzgw;
    }

    public static int zzb(int i, zzhc zzhcVar, InterfaceC1263ma interfaceC1263ma) {
        return zzag(i) + zza(zzhcVar, interfaceC1263ma);
    }

    public static int zza(zzgj zzgjVar) {
        int zzgw = zzgjVar.zzgw();
        return zzai(zzgw) + zzgw;
    }

    public static int zzb(int i, zzhc zzhcVar) {
        return (zzag(1) << 1) + zzl(2, i) + zzag(3) + zzd(zzhcVar);
    }

    @Deprecated
    public static int zzc(int i, zzhc zzhcVar, InterfaceC1263ma interfaceC1263ma) {
        int zzag = zzag(i) << 1;
        zzdz zzdzVar = (zzdz) zzhcVar;
        int zzes = zzdzVar.zzes();
        if (zzes == -1) {
            zzes = interfaceC1263ma.c(zzdzVar);
            zzdzVar.zzg(zzes);
        }
        return zzag + zzes;
    }

    public static int zza(zzhc zzhcVar, InterfaceC1263ma interfaceC1263ma) {
        zzdz zzdzVar = (zzdz) zzhcVar;
        int zzes = zzdzVar.zzes();
        if (zzes == -1) {
            zzes = interfaceC1263ma.c(zzdzVar);
            zzdzVar.zzg(zzes);
        }
        return zzai(zzes) + zzes;
    }

    public static int zzb(int i, zzgj zzgjVar) {
        return (zzag(1) << 1) + zzl(2, i) + zza(3, zzgjVar);
    }

    public static int zzb(zzeh zzehVar) {
        int size = zzehVar.size();
        return zzai(size) + size;
    }

    final void zza(String str, zzjc zzjcVar) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzjcVar);
        byte[] bytes = str.getBytes(zzfv.UTF_8);
        try {
            zzad(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (zzb e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzb(e3);
        }
    }
}

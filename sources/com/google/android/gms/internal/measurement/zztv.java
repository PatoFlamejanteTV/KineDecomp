package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class zztv extends zztd {
    private static final Logger logger = Logger.getLogger(zztv.class.getName());
    private static final boolean zzbum = xb.b();
    C1382oa zzbun;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends zztv {

        /* renamed from: a */
        private final byte[] f13581a;

        /* renamed from: b */
        private final int f13582b;

        /* renamed from: c */
        private final int f13583c;

        /* renamed from: d */
        private int f13584d;

        a(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i + i2;
                if ((i | i2 | (bArr.length - i3)) >= 0) {
                    this.f13581a = bArr;
                    this.f13582b = i;
                    this.f13584d = i;
                    this.f13583c = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            throw new NullPointerException("buffer");
        }

        public final int a() {
            return this.f13584d - this.f13582b;
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public void flush() {
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.f13581a, this.f13584d, i2);
                this.f13584d += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13584d), Integer.valueOf(this.f13583c), Integer.valueOf(i2)), e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(int i, long j) throws IOException {
            zzc(i, 0);
            zzat(j);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzat(long j) throws IOException {
            if (zztv.zzbum && zzvj() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.f13581a;
                    int i = this.f13584d;
                    this.f13584d = i + 1;
                    xb.a(bArr, i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.f13581a;
                int i2 = this.f13584d;
                this.f13584d = i2 + 1;
                xb.a(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f13581a;
                    int i3 = this.f13584d;
                    this.f13584d = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13584d), Integer.valueOf(this.f13583c), 1), e2);
                }
            }
            byte[] bArr4 = this.f13581a;
            int i4 = this.f13584d;
            this.f13584d = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzav(long j) throws IOException {
            try {
                byte[] bArr = this.f13581a;
                int i = this.f13584d;
                this.f13584d = i + 1;
                bArr[i] = (byte) j;
                byte[] bArr2 = this.f13581a;
                int i2 = this.f13584d;
                this.f13584d = i2 + 1;
                bArr2[i2] = (byte) (j >> 8);
                byte[] bArr3 = this.f13581a;
                int i3 = this.f13584d;
                this.f13584d = i3 + 1;
                bArr3[i3] = (byte) (j >> 16);
                byte[] bArr4 = this.f13581a;
                int i4 = this.f13584d;
                this.f13584d = i4 + 1;
                bArr4[i4] = (byte) (j >> 24);
                byte[] bArr5 = this.f13581a;
                int i5 = this.f13584d;
                this.f13584d = i5 + 1;
                bArr5[i5] = (byte) (j >> 32);
                byte[] bArr6 = this.f13581a;
                int i6 = this.f13584d;
                this.f13584d = i6 + 1;
                bArr6[i6] = (byte) (j >> 40);
                byte[] bArr7 = this.f13581a;
                int i7 = this.f13584d;
                this.f13584d = i7 + 1;
                bArr7[i7] = (byte) (j >> 48);
                byte[] bArr8 = this.f13581a;
                int i8 = this.f13584d;
                this.f13584d = i8 + 1;
                bArr8[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13584d), Integer.valueOf(this.f13583c), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzaz(int i) throws IOException {
            if (i >= 0) {
                zzba(i);
            } else {
                zzat(i);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, boolean z) throws IOException {
            zzc(i, 0);
            zzc(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzba(int i) throws IOException {
            if (zztv.zzbum && zzvj() >= 10) {
                while ((i & (-128)) != 0) {
                    byte[] bArr = this.f13581a;
                    int i2 = this.f13584d;
                    this.f13584d = i2 + 1;
                    xb.a(bArr, i2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.f13581a;
                int i3 = this.f13584d;
                this.f13584d = i3 + 1;
                xb.a(bArr2, i3, (byte) i);
                return;
            }
            while ((i & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f13581a;
                    int i4 = this.f13584d;
                    this.f13584d = i4 + 1;
                    bArr3[i4] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13584d), Integer.valueOf(this.f13583c), 1), e2);
                }
            }
            byte[] bArr4 = this.f13581a;
            int i5 = this.f13584d;
            this.f13584d = i5 + 1;
            bArr4[i5] = (byte) i;
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzbc(int i) throws IOException {
            try {
                byte[] bArr = this.f13581a;
                int i2 = this.f13584d;
                this.f13584d = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.f13581a;
                int i3 = this.f13584d;
                this.f13584d = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.f13581a;
                int i4 = this.f13584d;
                this.f13584d = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.f13581a;
                int i5 = this.f13584d;
                this.f13584d = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13584d), Integer.valueOf(this.f13583c), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzc(int i, int i2) throws IOException {
            zzba((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzd(int i, int i2) throws IOException {
            zzc(i, 0);
            zzaz(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zze(int i, int i2) throws IOException {
            zzc(i, 0);
            zzba(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzg(int i, int i2) throws IOException {
            zzc(i, 5);
            zzbc(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzgb(String str) throws IOException {
            int i = this.f13584d;
            try {
                int zzbf = zztv.zzbf(str.length() * 3);
                int zzbf2 = zztv.zzbf(str.length());
                if (zzbf2 == zzbf) {
                    this.f13584d = i + zzbf2;
                    int a2 = zb.a(str, this.f13581a, this.f13584d, zzvj());
                    this.f13584d = i;
                    zzba((a2 - i) - zzbf2);
                    this.f13584d = a2;
                    return;
                }
                zzba(zb.a(str));
                this.f13584d = zb.a(str, this.f13581a, this.f13584d, zzvj());
            } catch (zzxp e2) {
                this.f13584d = i;
                zza(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final int zzvj() {
            return this.f13583c - this.f13584d;
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzc(int i, long j) throws IOException {
            zzc(i, 1);
            zzav(j);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(int i, zzte zzteVar) throws IOException {
            zzc(i, 2);
            zza(zzteVar);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, String str) throws IOException {
            zzc(i, 2);
            zzgb(str);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzba(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzc(byte b2) throws IOException {
            try {
                byte[] bArr = this.f13581a;
                int i = this.f13584d;
                this.f13584d = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13584d), Integer.valueOf(this.f13583c), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(zzte zzteVar) throws IOException {
            zzba(zzteVar.size());
            zzteVar.zza(this);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, zzvv zzvvVar) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzvvVar);
            zzc(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(int i, zzvv zzvvVar) throws IOException {
            zzc(i, 2);
            zzb(zzvvVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(int i, zzvv zzvvVar, InterfaceC1353cb interfaceC1353cb) throws IOException {
            zzc(i, 2);
            zzsx zzsxVar = (zzsx) zzvvVar;
            int zztx = zzsxVar.zztx();
            if (zztx == -1) {
                zztx = interfaceC1353cb.c(zzsxVar);
                zzsxVar.zzai(zztx);
            }
            zzba(zztx);
            interfaceC1353cb.a((InterfaceC1353cb) zzvvVar, (Fb) this.zzbun);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, zzte zzteVar) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzteVar);
            zzc(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(zzvv zzvvVar) throws IOException {
            zzba(zzvvVar.zzvx());
            zzvvVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        final void zza(zzvv zzvvVar, InterfaceC1353cb interfaceC1353cb) throws IOException {
            zzsx zzsxVar = (zzsx) zzvvVar;
            int zztx = zzsxVar.zztx();
            if (zztx == -1) {
                zztx = interfaceC1353cb.c(zzsxVar);
                zzsxVar.zzai(zztx);
            }
            zzba(zztx);
            interfaceC1353cb.a((InterfaceC1353cb) zzvvVar, (Fb) this.zzbun);
        }

        @Override // com.google.android.gms.internal.measurement.zztd
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends a {

        /* renamed from: e */
        private final ByteBuffer f13585e;

        /* renamed from: f */
        private int f13586f;

        b(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.f13585e = byteBuffer;
            this.f13586f = byteBuffer.position();
        }

        @Override // com.google.android.gms.internal.measurement.zztv.a, com.google.android.gms.internal.measurement.zztv
        public final void flush() {
            this.f13585e.position(this.f13586f + a());
        }
    }

    /* loaded from: classes2.dex */
    public static final class c extends zztv {

        /* renamed from: a */
        private final ByteBuffer f13587a;

        /* renamed from: b */
        private final ByteBuffer f13588b;

        /* renamed from: c */
        private final int f13589c;

        c(ByteBuffer byteBuffer) {
            super();
            this.f13587a = byteBuffer;
            this.f13588b = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f13589c = byteBuffer.position();
        }

        private final void a(String str) throws IOException {
            try {
                zb.a(str, this.f13588b);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void flush() {
            this.f13587a.position(this.f13588b.position());
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.f13588b.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            } catch (BufferOverflowException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(int i, long j) throws IOException {
            zzc(i, 0);
            zzat(j);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzat(long j) throws IOException {
            while (((-128) & j) != 0) {
                try {
                    this.f13588b.put((byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                } catch (BufferOverflowException e2) {
                    throw new zzc(e2);
                }
            }
            this.f13588b.put((byte) j);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzav(long j) throws IOException {
            try {
                this.f13588b.putLong(j);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzaz(int i) throws IOException {
            if (i >= 0) {
                zzba(i);
            } else {
                zzat(i);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, boolean z) throws IOException {
            zzc(i, 0);
            zzc(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzba(int i) throws IOException {
            while ((i & (-128)) != 0) {
                try {
                    this.f13588b.put((byte) ((i & 127) | 128));
                    i >>>= 7;
                } catch (BufferOverflowException e2) {
                    throw new zzc(e2);
                }
            }
            this.f13588b.put((byte) i);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzbc(int i) throws IOException {
            try {
                this.f13588b.putInt(i);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzc(int i, int i2) throws IOException {
            zzba((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzd(int i, int i2) throws IOException {
            zzc(i, 0);
            zzaz(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zze(int i, int i2) throws IOException {
            zzc(i, 0);
            zzba(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzg(int i, int i2) throws IOException {
            zzc(i, 5);
            zzbc(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzgb(String str) throws IOException {
            int position = this.f13588b.position();
            try {
                int zzbf = zztv.zzbf(str.length() * 3);
                int zzbf2 = zztv.zzbf(str.length());
                if (zzbf2 == zzbf) {
                    int position2 = this.f13588b.position() + zzbf2;
                    this.f13588b.position(position2);
                    a(str);
                    int position3 = this.f13588b.position();
                    this.f13588b.position(position);
                    zzba(position3 - position2);
                    this.f13588b.position(position3);
                    return;
                }
                zzba(zb.a(str));
                a(str);
            } catch (zzxp e2) {
                this.f13588b.position(position);
                zza(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final int zzvj() {
            return this.f13588b.remaining();
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzc(int i, long j) throws IOException {
            zzc(i, 1);
            zzav(j);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(int i, zzte zzteVar) throws IOException {
            zzc(i, 2);
            zza(zzteVar);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, String str) throws IOException {
            zzc(i, 2);
            zzgb(str);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzba(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzc(byte b2) throws IOException {
            try {
                this.f13588b.put(b2);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(int i, zzvv zzvvVar) throws IOException {
            zzc(i, 2);
            zzb(zzvvVar);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, zzvv zzvvVar) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzvvVar);
            zzc(1, 4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(int i, zzvv zzvvVar, InterfaceC1353cb interfaceC1353cb) throws IOException {
            zzc(i, 2);
            zza(zzvvVar, interfaceC1353cb);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        final void zza(zzvv zzvvVar, InterfaceC1353cb interfaceC1353cb) throws IOException {
            zzsx zzsxVar = (zzsx) zzvvVar;
            int zztx = zzsxVar.zztx();
            if (zztx == -1) {
                zztx = interfaceC1353cb.c(zzsxVar);
                zzsxVar.zzai(zztx);
            }
            zzba(zztx);
            interfaceC1353cb.a((InterfaceC1353cb) zzvvVar, (Fb) this.zzbun);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, zzte zzteVar) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzteVar);
            zzc(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(zzvv zzvvVar) throws IOException {
            zzba(zzvvVar.zzvx());
            zzvvVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(zzte zzteVar) throws IOException {
            zzba(zzteVar.size());
            zzteVar.zza(this);
        }

        @Override // com.google.android.gms.internal.measurement.zztd
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }
    }

    /* loaded from: classes2.dex */
    public static final class d extends zztv {

        /* renamed from: a */
        private final ByteBuffer f13590a;

        /* renamed from: b */
        private final ByteBuffer f13591b;

        /* renamed from: c */
        private final long f13592c;

        /* renamed from: d */
        private final long f13593d;

        /* renamed from: e */
        private final long f13594e;

        /* renamed from: f */
        private final long f13595f;

        /* renamed from: g */
        private long f13596g;

        d(ByteBuffer byteBuffer) {
            super();
            this.f13590a = byteBuffer;
            this.f13591b = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f13592c = xb.a(byteBuffer);
            this.f13593d = this.f13592c + byteBuffer.position();
            this.f13594e = this.f13592c + byteBuffer.limit();
            this.f13595f = this.f13594e - 10;
            this.f13596g = this.f13593d;
        }

        private final void a(long j) {
            this.f13591b.position((int) (j - this.f13592c));
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void flush() {
            this.f13590a.position((int) (this.f13596g - this.f13592c));
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i) {
                long j = i2;
                long j2 = this.f13594e - j;
                long j3 = this.f13596g;
                if (j2 >= j3) {
                    xb.a(bArr, i, j3, j);
                    this.f13596g += j;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f13596g), Long.valueOf(this.f13594e), Integer.valueOf(i2)));
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(int i, long j) throws IOException {
            zzc(i, 0);
            zzat(j);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzat(long j) throws IOException {
            if (this.f13596g <= this.f13595f) {
                while ((j & (-128)) != 0) {
                    long j2 = this.f13596g;
                    this.f13596g = j2 + 1;
                    xb.a(j2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                long j3 = this.f13596g;
                this.f13596g = 1 + j3;
                xb.a(j3, (byte) j);
                return;
            }
            while (true) {
                long j4 = this.f13596g;
                if (j4 >= this.f13594e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j4), Long.valueOf(this.f13594e), 1));
                }
                if ((j & (-128)) == 0) {
                    this.f13596g = 1 + j4;
                    xb.a(j4, (byte) j);
                    return;
                } else {
                    this.f13596g = j4 + 1;
                    xb.a(j4, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzav(long j) throws IOException {
            this.f13591b.putLong((int) (this.f13596g - this.f13592c), j);
            this.f13596g += 8;
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzaz(int i) throws IOException {
            if (i >= 0) {
                zzba(i);
            } else {
                zzat(i);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, boolean z) throws IOException {
            zzc(i, 0);
            zzc(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzba(int i) throws IOException {
            if (this.f13596g <= this.f13595f) {
                while ((i & (-128)) != 0) {
                    long j = this.f13596g;
                    this.f13596g = j + 1;
                    xb.a(j, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                long j2 = this.f13596g;
                this.f13596g = 1 + j2;
                xb.a(j2, (byte) i);
                return;
            }
            while (true) {
                long j3 = this.f13596g;
                if (j3 >= this.f13594e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j3), Long.valueOf(this.f13594e), 1));
                }
                if ((i & (-128)) == 0) {
                    this.f13596g = 1 + j3;
                    xb.a(j3, (byte) i);
                    return;
                } else {
                    this.f13596g = j3 + 1;
                    xb.a(j3, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzbc(int i) throws IOException {
            this.f13591b.putInt((int) (this.f13596g - this.f13592c), i);
            this.f13596g += 4;
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzc(int i, int i2) throws IOException {
            zzba((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzd(int i, int i2) throws IOException {
            zzc(i, 0);
            zzaz(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zze(int i, int i2) throws IOException {
            zzc(i, 0);
            zzba(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzg(int i, int i2) throws IOException {
            zzc(i, 5);
            zzbc(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzgb(String str) throws IOException {
            long j = this.f13596g;
            try {
                int zzbf = zztv.zzbf(str.length() * 3);
                int zzbf2 = zztv.zzbf(str.length());
                if (zzbf2 == zzbf) {
                    int i = ((int) (this.f13596g - this.f13592c)) + zzbf2;
                    this.f13591b.position(i);
                    zb.a(str, this.f13591b);
                    int position = this.f13591b.position() - i;
                    zzba(position);
                    this.f13596g += position;
                    return;
                }
                int a2 = zb.a(str);
                zzba(a2);
                a(this.f13596g);
                zb.a(str, this.f13591b);
                this.f13596g += a2;
            } catch (zzxp e2) {
                this.f13596g = j;
                a(this.f13596g);
                zza(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new zzc(e3);
            } catch (IndexOutOfBoundsException e4) {
                throw new zzc(e4);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final int zzvj() {
            return (int) (this.f13594e - this.f13596g);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzc(int i, long j) throws IOException {
            zzc(i, 1);
            zzav(j);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(int i, zzte zzteVar) throws IOException {
            zzc(i, 2);
            zza(zzteVar);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, String str) throws IOException {
            zzc(i, 2);
            zzgb(str);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzba(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzc(byte b2) throws IOException {
            long j = this.f13596g;
            if (j < this.f13594e) {
                this.f13596g = 1 + j;
                xb.a(j, b2);
                return;
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j), Long.valueOf(this.f13594e), 1));
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(int i, zzvv zzvvVar) throws IOException {
            zzc(i, 2);
            zzb(zzvvVar);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, zzvv zzvvVar) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzvvVar);
            zzc(1, 4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(int i, zzvv zzvvVar, InterfaceC1353cb interfaceC1353cb) throws IOException {
            zzc(i, 2);
            zza(zzvvVar, interfaceC1353cb);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        final void zza(zzvv zzvvVar, InterfaceC1353cb interfaceC1353cb) throws IOException {
            zzsx zzsxVar = (zzsx) zzvvVar;
            int zztx = zzsxVar.zztx();
            if (zztx == -1) {
                zztx = interfaceC1353cb.c(zzsxVar);
                zzsxVar.zzai(zztx);
            }
            zzba(zztx);
            interfaceC1353cb.a((InterfaceC1353cb) zzvvVar, (Fb) this.zzbun);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(int i, zzte zzteVar) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzteVar);
            zzc(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zzb(zzvv zzvvVar) throws IOException {
            zzba(zzvvVar.zzvx());
            zzvvVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.measurement.zztv
        public final void zza(zzte zzteVar) throws IOException {
            zzba(zzteVar.size());
            zzteVar.zza(this);
        }

        @Override // com.google.android.gms.internal.measurement.zztd
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zztv.zzc.<init>(java.lang.String):void");
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zztv.zzc.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zztv() {
    }

    public static zztv zza(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            if (xb.c()) {
                return new d(byteBuffer);
            }
            return new c(byteBuffer);
        }
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    public static int zzaw(long j) {
        return zzax(j);
    }

    public static int zzax(long j) {
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

    public static int zzay(long j) {
        return zzax(zzbb(j));
    }

    public static int zzaz(long j) {
        return 8;
    }

    public static int zzb(float f2) {
        return 4;
    }

    public static int zzba(long j) {
        return 8;
    }

    private static long zzbb(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzbd(int i) {
        return zzbf(i << 3);
    }

    public static int zzbe(int i) {
        if (i >= 0) {
            return zzbf(i);
        }
        return 10;
    }

    public static int zzbf(int i) {
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

    public static int zzbg(int i) {
        return zzbf(zzbk(i));
    }

    public static int zzbh(int i) {
        return 4;
    }

    public static int zzbi(int i) {
        return 4;
    }

    public static int zzbj(int i) {
        return zzbe(i);
    }

    private static int zzbk(int i) {
        return (i >> 31) ^ (i << 1);
    }

    @Deprecated
    public static int zzbl(int i) {
        return zzbf(i);
    }

    public static int zzc(double d2) {
        return 8;
    }

    public static int zzc(int i, boolean z) {
        return zzbd(i) + 1;
    }

    public static int zzd(int i, long j) {
        return zzbd(i) + zzax(j);
    }

    public static int zze(int i, long j) {
        return zzbd(i) + zzax(j);
    }

    public static int zzg(int i, long j) {
        return zzbd(i) + 8;
    }

    public static int zzgc(String str) {
        int length;
        try {
            length = zb.a(str);
        } catch (zzxp unused) {
            length = str.getBytes(zzuq.UTF_8).length;
        }
        return zzbf(length) + length;
    }

    public static int zzh(int i, int i2) {
        return zzbd(i) + zzbe(i2);
    }

    public static int zzi(int i, int i2) {
        return zzbd(i) + zzbf(i2);
    }

    public static zztv zzj(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int zzk(int i, int i2) {
        return zzbd(i) + 4;
    }

    public static int zzl(int i, int i2) {
        return zzbd(i) + 4;
    }

    public static int zzm(int i, int i2) {
        return zzbd(i) + zzbe(i2);
    }

    public static int zzt(boolean z) {
        return 1;
    }

    public abstract void flush() throws IOException;

    public abstract void write(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzte zzteVar) throws IOException;

    public abstract void zza(int i, zzvv zzvvVar) throws IOException;

    public abstract void zza(int i, zzvv zzvvVar, InterfaceC1353cb interfaceC1353cb) throws IOException;

    public abstract void zza(zzte zzteVar) throws IOException;

    abstract void zza(zzvv zzvvVar, InterfaceC1353cb interfaceC1353cb) throws IOException;

    public abstract void zzat(long j) throws IOException;

    public final void zzau(long j) throws IOException {
        zzat(zzbb(j));
    }

    public abstract void zzav(long j) throws IOException;

    public abstract void zzaz(int i) throws IOException;

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzbb(j));
    }

    public abstract void zzb(int i, zzte zzteVar) throws IOException;

    public abstract void zzb(int i, zzvv zzvvVar) throws IOException;

    public abstract void zzb(int i, String str) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(zzvv zzvvVar) throws IOException;

    public abstract void zzba(int i) throws IOException;

    public final void zzbb(int i) throws IOException {
        zzba(zzbk(i));
    }

    public abstract void zzbc(int i) throws IOException;

    public abstract void zzc(byte b2) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public abstract void zzd(int i, int i2) throws IOException;

    public abstract void zze(int i, int i2) throws IOException;

    public abstract void zze(byte[] bArr, int i, int i2) throws IOException;

    public final void zzf(int i, int i2) throws IOException {
        zze(i, zzbk(i2));
    }

    public abstract void zzg(int i, int i2) throws IOException;

    public abstract void zzgb(String str) throws IOException;

    public final void zzs(boolean z) throws IOException {
        zzc(z ? (byte) 1 : (byte) 0);
    }

    public abstract int zzvj();

    /* synthetic */ zztv(C1380na c1380na) {
        this();
    }

    public static int zzc(int i, String str) {
        return zzbd(i) + zzgc(str);
    }

    public static int zzf(int i, long j) {
        return zzbd(i) + zzax(zzbb(j));
    }

    public static int zzh(int i, long j) {
        return zzbd(i) + 8;
    }

    public static int zzk(byte[] bArr) {
        int length = bArr.length;
        return zzbf(length) + length;
    }

    public final void zzb(double d2) throws IOException {
        zzav(Double.doubleToRawLongBits(d2));
    }

    public static int zzb(int i, float f2) {
        return zzbd(i) + 4;
    }

    public static int zzc(int i, zzte zzteVar) {
        int zzbd = zzbd(i);
        int size = zzteVar.size();
        return zzbd + zzbf(size) + size;
    }

    public static int zzd(int i, zzvv zzvvVar) {
        return (zzbd(1) << 1) + zzi(2, i) + zzc(3, zzvvVar);
    }

    public static int zzj(int i, int i2) {
        return zzbd(i) + zzbf(zzbk(i2));
    }

    public static int zzb(int i, double d2) {
        return zzbd(i) + 8;
    }

    public static int zzb(int i, zzvv zzvvVar, InterfaceC1353cb interfaceC1353cb) {
        return zzbd(i) + zzb(zzvvVar, interfaceC1353cb);
    }

    public static int zzb(int i, zzvc zzvcVar) {
        return (zzbd(1) << 1) + zzi(2, i) + zza(3, zzvcVar);
    }

    public static int zzc(int i, zzvv zzvvVar) {
        return zzbd(i) + zzc(zzvvVar);
    }

    public static int zzd(int i, zzte zzteVar) {
        return (zzbd(1) << 1) + zzi(2, i) + zzc(3, zzteVar);
    }

    public static int zzc(zzvv zzvvVar) {
        int zzvx = zzvvVar.zzvx();
        return zzbf(zzvx) + zzvx;
    }

    public final void zza(int i, float f2) throws IOException {
        zzg(i, Float.floatToRawIntBits(f2));
    }

    public static int zzb(zzte zzteVar) {
        int size = zzteVar.size();
        return zzbf(size) + size;
    }

    @Deprecated
    public static int zzc(int i, zzvv zzvvVar, InterfaceC1353cb interfaceC1353cb) {
        int zzbd = zzbd(i) << 1;
        zzsx zzsxVar = (zzsx) zzvvVar;
        int zztx = zzsxVar.zztx();
        if (zztx == -1) {
            zztx = interfaceC1353cb.c(zzsxVar);
            zzsxVar.zzai(zztx);
        }
        return zzbd + zztx;
    }

    @Deprecated
    public static int zzd(zzvv zzvvVar) {
        return zzvvVar.zzvx();
    }

    public final void zza(int i, double d2) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d2));
    }

    public final void zza(float f2) throws IOException {
        zzbc(Float.floatToRawIntBits(f2));
    }

    public static int zza(int i, zzvc zzvcVar) {
        int zzbd = zzbd(i);
        int zzvx = zzvcVar.zzvx();
        return zzbd + zzbf(zzvx) + zzvx;
    }

    public static int zzb(zzvv zzvvVar, InterfaceC1353cb interfaceC1353cb) {
        zzsx zzsxVar = (zzsx) zzvvVar;
        int zztx = zzsxVar.zztx();
        if (zztx == -1) {
            zztx = interfaceC1353cb.c(zzsxVar);
            zzsxVar.zzai(zztx);
        }
        return zzbf(zztx) + zztx;
    }

    public static int zza(zzvc zzvcVar) {
        int zzvx = zzvcVar.zzvx();
        return zzbf(zzvx) + zzvx;
    }

    final void zza(String str, zzxp zzxpVar) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzxpVar);
        byte[] bytes = str.getBytes(zzuq.UTF_8);
        try {
            zzba(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (zzc e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzc(e3);
        }
    }
}

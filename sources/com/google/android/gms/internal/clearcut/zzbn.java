package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class zzbn extends zzba {
    private static final Logger logger = Logger.getLogger(zzbn.class.getName());
    private static final boolean zzfy = La.b();
    C1234y zzfz;

    /* loaded from: classes2.dex */
    static class a extends zzbn {

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f12915a;

        /* renamed from: b, reason: collision with root package name */
        private final int f12916b;

        /* renamed from: c, reason: collision with root package name */
        private final int f12917c;

        /* renamed from: d, reason: collision with root package name */
        private int f12918d;

        a(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i3 = i + i2;
            if ((i | i2 | (bArr.length - i3)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            this.f12915a = bArr;
            this.f12916b = i;
            this.f12918d = i;
            this.f12917c = i3;
        }

        public final int a() {
            return this.f12918d - this.f12916b;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public void flush() {
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.f12915a, this.f12918d, i2);
                this.f12918d += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12918d), Integer.valueOf(this.f12917c), Integer.valueOf(i2)), e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(byte b2) throws IOException {
            try {
                byte[] bArr = this.f12915a;
                int i = this.f12918d;
                this.f12918d = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12918d), Integer.valueOf(this.f12917c), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, long j) throws IOException {
            zzb(i, 0);
            zzb(j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, zzbb zzbbVar) throws IOException {
            zzb(i, 2);
            zza(zzbbVar);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, zzdo zzdoVar) throws IOException {
            zzb(i, 2);
            zzb(zzdoVar);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        final void zza(int i, zzdo zzdoVar, InterfaceC1218pa interfaceC1218pa) throws IOException {
            zzb(i, 2);
            zzas zzasVar = (zzas) zzdoVar;
            int zzs = zzasVar.zzs();
            if (zzs == -1) {
                zzs = interfaceC1218pa.b(zzasVar);
                zzasVar.zzf(zzs);
            }
            zzo(zzs);
            interfaceC1218pa.a((InterfaceC1218pa) zzdoVar, (Sa) this.zzfz);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, String str) throws IOException {
            zzb(i, 2);
            zzg(str);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(zzbb zzbbVar) throws IOException {
            zzo(zzbbVar.size());
            zzbbVar.zza(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        final void zza(zzdo zzdoVar, InterfaceC1218pa interfaceC1218pa) throws IOException {
            zzas zzasVar = (zzas) zzdoVar;
            int zzs = zzasVar.zzs();
            if (zzs == -1) {
                zzs = interfaceC1218pa.b(zzasVar);
                zzasVar.zzf(zzs);
            }
            zzo(zzs);
            interfaceC1218pa.a((InterfaceC1218pa) zzdoVar, (Sa) this.zzfz);
        }

        @Override // com.google.android.gms.internal.clearcut.zzba
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final int zzag() {
            return this.f12917c - this.f12918d;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, int i2) throws IOException {
            zzo((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, zzbb zzbbVar) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzbbVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, zzdo zzdoVar) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzdoVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, boolean z) throws IOException {
            zzb(i, 0);
            zza(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(long j) throws IOException {
            if (zzbn.zzfy && zzag() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.f12915a;
                    int i = this.f12918d;
                    this.f12918d = i + 1;
                    La.a(bArr, i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.f12915a;
                int i2 = this.f12918d;
                this.f12918d = i2 + 1;
                La.a(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f12915a;
                    int i3 = this.f12918d;
                    this.f12918d = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12918d), Integer.valueOf(this.f12917c), 1), e2);
                }
            }
            byte[] bArr4 = this.f12915a;
            int i4 = this.f12918d;
            this.f12918d = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(zzdo zzdoVar) throws IOException {
            zzo(zzdoVar.zzas());
            zzdoVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzc(int i, int i2) throws IOException {
            zzb(i, 0);
            zzn(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzc(int i, long j) throws IOException {
            zzb(i, 1);
            zzd(j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzd(int i, int i2) throws IOException {
            zzb(i, 0);
            zzo(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzd(long j) throws IOException {
            try {
                byte[] bArr = this.f12915a;
                int i = this.f12918d;
                this.f12918d = i + 1;
                bArr[i] = (byte) j;
                byte[] bArr2 = this.f12915a;
                int i2 = this.f12918d;
                this.f12918d = i2 + 1;
                bArr2[i2] = (byte) (j >> 8);
                byte[] bArr3 = this.f12915a;
                int i3 = this.f12918d;
                this.f12918d = i3 + 1;
                bArr3[i3] = (byte) (j >> 16);
                byte[] bArr4 = this.f12915a;
                int i4 = this.f12918d;
                this.f12918d = i4 + 1;
                bArr4[i4] = (byte) (j >> 24);
                byte[] bArr5 = this.f12915a;
                int i5 = this.f12918d;
                this.f12918d = i5 + 1;
                bArr5[i5] = (byte) (j >> 32);
                byte[] bArr6 = this.f12915a;
                int i6 = this.f12918d;
                this.f12918d = i6 + 1;
                bArr6[i6] = (byte) (j >> 40);
                byte[] bArr7 = this.f12915a;
                int i7 = this.f12918d;
                this.f12918d = i7 + 1;
                bArr7[i7] = (byte) (j >> 48);
                byte[] bArr8 = this.f12915a;
                int i8 = this.f12918d;
                this.f12918d = i8 + 1;
                bArr8[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12918d), Integer.valueOf(this.f12917c), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzd(byte[] bArr, int i, int i2) throws IOException {
            zzo(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzf(int i, int i2) throws IOException {
            zzb(i, 5);
            zzq(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzg(String str) throws IOException {
            int i = this.f12918d;
            try {
                int zzt = zzbn.zzt(str.length() * 3);
                int zzt2 = zzbn.zzt(str.length());
                if (zzt2 != zzt) {
                    zzo(Na.a(str));
                    this.f12918d = Na.a(str, this.f12915a, this.f12918d, zzag());
                    return;
                }
                this.f12918d = i + zzt2;
                int a2 = Na.a(str, this.f12915a, this.f12918d, zzag());
                this.f12918d = i;
                zzo((a2 - i) - zzt2);
                this.f12918d = a2;
            } catch (zzfi e2) {
                this.f12918d = i;
                zza(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzn(int i) throws IOException {
            if (i >= 0) {
                zzo(i);
            } else {
                zzb(i);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzo(int i) throws IOException {
            if (zzbn.zzfy && zzag() >= 10) {
                while ((i & (-128)) != 0) {
                    byte[] bArr = this.f12915a;
                    int i2 = this.f12918d;
                    this.f12918d = i2 + 1;
                    La.a(bArr, i2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.f12915a;
                int i3 = this.f12918d;
                this.f12918d = i3 + 1;
                La.a(bArr2, i3, (byte) i);
                return;
            }
            while ((i & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f12915a;
                    int i4 = this.f12918d;
                    this.f12918d = i4 + 1;
                    bArr3[i4] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12918d), Integer.valueOf(this.f12917c), 1), e2);
                }
            }
            byte[] bArr4 = this.f12915a;
            int i5 = this.f12918d;
            this.f12918d = i5 + 1;
            bArr4[i5] = (byte) i;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzq(int i) throws IOException {
            try {
                byte[] bArr = this.f12915a;
                int i2 = this.f12918d;
                this.f12918d = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.f12915a;
                int i3 = this.f12918d;
                this.f12918d = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.f12915a;
                int i4 = this.f12918d;
                this.f12918d = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.f12915a;
                int i5 = this.f12918d;
                this.f12918d = i5 + 1;
                bArr4[i5] = i >> 24;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12918d), Integer.valueOf(this.f12917c), 1), e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b extends a {

        /* renamed from: e, reason: collision with root package name */
        private final ByteBuffer f12919e;

        /* renamed from: f, reason: collision with root package name */
        private int f12920f;

        b(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.f12919e = byteBuffer;
            this.f12920f = byteBuffer.position();
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn.a, com.google.android.gms.internal.clearcut.zzbn
        public final void flush() {
            this.f12919e.position(this.f12920f + a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends zzbn {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f12921a;

        /* renamed from: b, reason: collision with root package name */
        private final ByteBuffer f12922b;

        /* renamed from: c, reason: collision with root package name */
        private final int f12923c;

        c(ByteBuffer byteBuffer) {
            super();
            this.f12921a = byteBuffer;
            this.f12922b = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f12923c = byteBuffer.position();
        }

        private final void a(String str) throws IOException {
            try {
                Na.a(str, this.f12922b);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void flush() {
            this.f12921a.position(this.f12922b.position());
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.f12922b.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            } catch (BufferOverflowException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(byte b2) throws IOException {
            try {
                this.f12922b.put(b2);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, long j) throws IOException {
            zzb(i, 0);
            zzb(j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, zzbb zzbbVar) throws IOException {
            zzb(i, 2);
            zza(zzbbVar);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, zzdo zzdoVar) throws IOException {
            zzb(i, 2);
            zzb(zzdoVar);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        final void zza(int i, zzdo zzdoVar, InterfaceC1218pa interfaceC1218pa) throws IOException {
            zzb(i, 2);
            zza(zzdoVar, interfaceC1218pa);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, String str) throws IOException {
            zzb(i, 2);
            zzg(str);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(zzbb zzbbVar) throws IOException {
            zzo(zzbbVar.size());
            zzbbVar.zza(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        final void zza(zzdo zzdoVar, InterfaceC1218pa interfaceC1218pa) throws IOException {
            zzas zzasVar = (zzas) zzdoVar;
            int zzs = zzasVar.zzs();
            if (zzs == -1) {
                zzs = interfaceC1218pa.b(zzasVar);
                zzasVar.zzf(zzs);
            }
            zzo(zzs);
            interfaceC1218pa.a((InterfaceC1218pa) zzdoVar, (Sa) this.zzfz);
        }

        @Override // com.google.android.gms.internal.clearcut.zzba
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final int zzag() {
            return this.f12922b.remaining();
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, int i2) throws IOException {
            zzo((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, zzbb zzbbVar) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzbbVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, zzdo zzdoVar) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzdoVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, boolean z) throws IOException {
            zzb(i, 0);
            zza(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(long j) throws IOException {
            while (((-128) & j) != 0) {
                try {
                    this.f12922b.put((byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                } catch (BufferOverflowException e2) {
                    throw new zzc(e2);
                }
            }
            this.f12922b.put((byte) j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(zzdo zzdoVar) throws IOException {
            zzo(zzdoVar.zzas());
            zzdoVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzc(int i, int i2) throws IOException {
            zzb(i, 0);
            zzn(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzc(int i, long j) throws IOException {
            zzb(i, 1);
            zzd(j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzd(int i, int i2) throws IOException {
            zzb(i, 0);
            zzo(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzd(long j) throws IOException {
            try {
                this.f12922b.putLong(j);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzd(byte[] bArr, int i, int i2) throws IOException {
            zzo(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzf(int i, int i2) throws IOException {
            zzb(i, 5);
            zzq(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzg(String str) throws IOException {
            int position = this.f12922b.position();
            try {
                int zzt = zzbn.zzt(str.length() * 3);
                int zzt2 = zzbn.zzt(str.length());
                if (zzt2 != zzt) {
                    zzo(Na.a(str));
                    a(str);
                    return;
                }
                int position2 = this.f12922b.position() + zzt2;
                this.f12922b.position(position2);
                a(str);
                int position3 = this.f12922b.position();
                this.f12922b.position(position);
                zzo(position3 - position2);
                this.f12922b.position(position3);
            } catch (zzfi e2) {
                this.f12922b.position(position);
                zza(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzn(int i) throws IOException {
            if (i >= 0) {
                zzo(i);
            } else {
                zzb(i);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzo(int i) throws IOException {
            while ((i & (-128)) != 0) {
                try {
                    this.f12922b.put((byte) ((i & 127) | 128));
                    i >>>= 7;
                } catch (BufferOverflowException e2) {
                    throw new zzc(e2);
                }
            }
            this.f12922b.put((byte) i);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzq(int i) throws IOException {
            try {
                this.f12922b.putInt(i);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class d extends zzbn {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f12924a;

        /* renamed from: b, reason: collision with root package name */
        private final ByteBuffer f12925b;

        /* renamed from: c, reason: collision with root package name */
        private final long f12926c;

        /* renamed from: d, reason: collision with root package name */
        private final long f12927d;

        /* renamed from: e, reason: collision with root package name */
        private final long f12928e;

        /* renamed from: f, reason: collision with root package name */
        private final long f12929f;

        /* renamed from: g, reason: collision with root package name */
        private long f12930g;

        d(ByteBuffer byteBuffer) {
            super();
            this.f12924a = byteBuffer;
            this.f12925b = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f12926c = La.a(byteBuffer);
            this.f12927d = this.f12926c + byteBuffer.position();
            this.f12928e = this.f12926c + byteBuffer.limit();
            this.f12929f = this.f12928e - 10;
            this.f12930g = this.f12927d;
        }

        private final void a(long j) {
            this.f12925b.position((int) (j - this.f12926c));
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void flush() {
            this.f12924a.position((int) (this.f12930g - this.f12926c));
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i) {
                long j = i2;
                long j2 = this.f12928e - j;
                long j3 = this.f12930g;
                if (j2 >= j3) {
                    La.a(bArr, i, j3, j);
                    this.f12930g += j;
                    return;
                }
            }
            if (bArr != null) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f12930g), Long.valueOf(this.f12928e), Integer.valueOf(i2)));
            }
            throw new NullPointerException("value");
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(byte b2) throws IOException {
            long j = this.f12930g;
            if (j >= this.f12928e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j), Long.valueOf(this.f12928e), 1));
            }
            this.f12930g = 1 + j;
            La.a(j, b2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, long j) throws IOException {
            zzb(i, 0);
            zzb(j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, zzbb zzbbVar) throws IOException {
            zzb(i, 2);
            zza(zzbbVar);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, zzdo zzdoVar) throws IOException {
            zzb(i, 2);
            zzb(zzdoVar);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        final void zza(int i, zzdo zzdoVar, InterfaceC1218pa interfaceC1218pa) throws IOException {
            zzb(i, 2);
            zza(zzdoVar, interfaceC1218pa);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, String str) throws IOException {
            zzb(i, 2);
            zzg(str);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(zzbb zzbbVar) throws IOException {
            zzo(zzbbVar.size());
            zzbbVar.zza(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        final void zza(zzdo zzdoVar, InterfaceC1218pa interfaceC1218pa) throws IOException {
            zzas zzasVar = (zzas) zzdoVar;
            int zzs = zzasVar.zzs();
            if (zzs == -1) {
                zzs = interfaceC1218pa.b(zzasVar);
                zzasVar.zzf(zzs);
            }
            zzo(zzs);
            interfaceC1218pa.a((InterfaceC1218pa) zzdoVar, (Sa) this.zzfz);
        }

        @Override // com.google.android.gms.internal.clearcut.zzba
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final int zzag() {
            return (int) (this.f12928e - this.f12930g);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, int i2) throws IOException {
            zzo((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, zzbb zzbbVar) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzbbVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, zzdo zzdoVar) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzdoVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, boolean z) throws IOException {
            zzb(i, 0);
            zza(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(long j) throws IOException {
            long j2;
            if (this.f12930g <= this.f12929f) {
                while ((j & (-128)) != 0) {
                    long j3 = this.f12930g;
                    this.f12930g = j3 + 1;
                    La.a(j3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                j2 = this.f12930g;
            } else {
                while (true) {
                    j2 = this.f12930g;
                    if (j2 >= this.f12928e) {
                        throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j2), Long.valueOf(this.f12928e), 1));
                    }
                    if ((j & (-128)) == 0) {
                        break;
                    }
                    this.f12930g = j2 + 1;
                    La.a(j2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
            }
            this.f12930g = 1 + j2;
            La.a(j2, (byte) j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(zzdo zzdoVar) throws IOException {
            zzo(zzdoVar.zzas());
            zzdoVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzc(int i, int i2) throws IOException {
            zzb(i, 0);
            zzn(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzc(int i, long j) throws IOException {
            zzb(i, 1);
            zzd(j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzd(int i, int i2) throws IOException {
            zzb(i, 0);
            zzo(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzd(long j) throws IOException {
            this.f12925b.putLong((int) (this.f12930g - this.f12926c), j);
            this.f12930g += 8;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzd(byte[] bArr, int i, int i2) throws IOException {
            zzo(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzf(int i, int i2) throws IOException {
            zzb(i, 5);
            zzq(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzg(String str) throws IOException {
            long j = this.f12930g;
            try {
                int zzt = zzbn.zzt(str.length() * 3);
                int zzt2 = zzbn.zzt(str.length());
                if (zzt2 != zzt) {
                    int a2 = Na.a(str);
                    zzo(a2);
                    a(this.f12930g);
                    Na.a(str, this.f12925b);
                    this.f12930g += a2;
                    return;
                }
                int i = ((int) (this.f12930g - this.f12926c)) + zzt2;
                this.f12925b.position(i);
                Na.a(str, this.f12925b);
                int position = this.f12925b.position() - i;
                zzo(position);
                this.f12930g += position;
            } catch (zzfi e2) {
                this.f12930g = j;
                a(this.f12930g);
                zza(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new zzc(e3);
            } catch (IndexOutOfBoundsException e4) {
                throw new zzc(e4);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzn(int i) throws IOException {
            if (i >= 0) {
                zzo(i);
            } else {
                zzb(i);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzo(int i) throws IOException {
            long j;
            if (this.f12930g <= this.f12929f) {
                while ((i & (-128)) != 0) {
                    long j2 = this.f12930g;
                    this.f12930g = j2 + 1;
                    La.a(j2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                j = this.f12930g;
            } else {
                while (true) {
                    j = this.f12930g;
                    if (j >= this.f12928e) {
                        throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j), Long.valueOf(this.f12928e), 1));
                    }
                    if ((i & (-128)) == 0) {
                        break;
                    }
                    this.f12930g = j + 1;
                    La.a(j, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
            }
            this.f12930g = 1 + j;
            La.a(j, (byte) i);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzq(int i) throws IOException {
            this.f12925b.putInt((int) (this.f12930g - this.f12926c), i);
            this.f12930g += 4;
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzbn.zzc.<init>(java.lang.String):void");
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzbn.zzc.<init>(java.lang.String, java.lang.Throwable):void");
        }

        zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    private zzbn() {
    }

    public static int zza(int i, zzcv zzcvVar) {
        int zzr = zzr(i);
        int zzas = zzcvVar.zzas();
        return zzr + zzt(zzas) + zzas;
    }

    public static int zza(zzcv zzcvVar) {
        int zzas = zzcvVar.zzas();
        return zzt(zzas) + zzas;
    }

    public static zzbn zza(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        }
        return La.c() ? new d(byteBuffer) : new c(byteBuffer);
    }

    public static int zzb(double d2) {
        return 8;
    }

    public static int zzb(float f2) {
        return 4;
    }

    public static int zzb(int i, double d2) {
        return zzr(i) + 8;
    }

    public static int zzb(int i, float f2) {
        return zzr(i) + 4;
    }

    public static int zzb(int i, zzcv zzcvVar) {
        return (zzr(1) << 1) + zzh(2, i) + zza(3, zzcvVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, zzdo zzdoVar, InterfaceC1218pa interfaceC1218pa) {
        return zzr(i) + zzb(zzdoVar, interfaceC1218pa);
    }

    public static int zzb(int i, String str) {
        return zzr(i) + zzh(str);
    }

    public static int zzb(zzbb zzbbVar) {
        int size = zzbbVar.size();
        return zzt(size) + size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(zzdo zzdoVar, InterfaceC1218pa interfaceC1218pa) {
        zzas zzasVar = (zzas) zzdoVar;
        int zzs = zzasVar.zzs();
        if (zzs == -1) {
            zzs = interfaceC1218pa.b(zzasVar);
            zzasVar.zzf(zzs);
        }
        return zzt(zzs) + zzs;
    }

    public static int zzb(boolean z) {
        return 1;
    }

    public static int zzc(int i, zzbb zzbbVar) {
        int zzr = zzr(i);
        int size = zzbbVar.size();
        return zzr + zzt(size) + size;
    }

    public static int zzc(int i, zzdo zzdoVar) {
        return zzr(i) + zzc(zzdoVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zzc(int i, zzdo zzdoVar, InterfaceC1218pa interfaceC1218pa) {
        int zzr = zzr(i) << 1;
        zzas zzasVar = (zzas) zzdoVar;
        int zzs = zzasVar.zzs();
        if (zzs == -1) {
            zzs = interfaceC1218pa.b(zzasVar);
            zzasVar.zzf(zzs);
        }
        return zzr + zzs;
    }

    public static int zzc(int i, boolean z) {
        return zzr(i) + 1;
    }

    public static int zzc(zzdo zzdoVar) {
        int zzas = zzdoVar.zzas();
        return zzt(zzas) + zzas;
    }

    public static zzbn zzc(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int zzd(int i, long j) {
        return zzr(i) + zzf(j);
    }

    public static int zzd(int i, zzbb zzbbVar) {
        return (zzr(1) << 1) + zzh(2, i) + zzc(3, zzbbVar);
    }

    public static int zzd(int i, zzdo zzdoVar) {
        return (zzr(1) << 1) + zzh(2, i) + zzc(3, zzdoVar);
    }

    @Deprecated
    public static int zzd(zzdo zzdoVar) {
        return zzdoVar.zzas();
    }

    public static int zzd(byte[] bArr) {
        int length = bArr.length;
        return zzt(length) + length;
    }

    public static int zze(int i, long j) {
        return zzr(i) + zzf(j);
    }

    public static int zze(long j) {
        return zzf(j);
    }

    public static int zzf(int i, long j) {
        return zzr(i) + zzf(zzj(j));
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

    public static int zzg(int i, int i2) {
        return zzr(i) + zzs(i2);
    }

    public static int zzg(int i, long j) {
        return zzr(i) + 8;
    }

    public static int zzg(long j) {
        return zzf(zzj(j));
    }

    public static int zzh(int i, int i2) {
        return zzr(i) + zzt(i2);
    }

    public static int zzh(int i, long j) {
        return zzr(i) + 8;
    }

    public static int zzh(long j) {
        return 8;
    }

    public static int zzh(String str) {
        int length;
        try {
            length = Na.a(str);
        } catch (zzfi unused) {
            length = str.getBytes(zzci.UTF_8).length;
        }
        return zzt(length) + length;
    }

    public static int zzi(int i, int i2) {
        return zzr(i) + zzt(zzy(i2));
    }

    public static int zzi(long j) {
        return 8;
    }

    public static int zzj(int i, int i2) {
        return zzr(i) + 4;
    }

    private static long zzj(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzk(int i, int i2) {
        return zzr(i) + 4;
    }

    public static int zzl(int i, int i2) {
        return zzr(i) + zzs(i2);
    }

    public static int zzr(int i) {
        return zzt(i << 3);
    }

    public static int zzs(int i) {
        if (i >= 0) {
            return zzt(i);
        }
        return 10;
    }

    public static int zzt(int i) {
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

    public static int zzu(int i) {
        return zzt(zzy(i));
    }

    public static int zzv(int i) {
        return 4;
    }

    public static int zzw(int i) {
        return 4;
    }

    public static int zzx(int i) {
        return zzs(i);
    }

    private static int zzy(int i) {
        return (i >> 31) ^ (i << 1);
    }

    @Deprecated
    public static int zzz(int i) {
        return zzt(i);
    }

    public abstract void flush() throws IOException;

    public abstract void write(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zza(byte b2) throws IOException;

    public final void zza(double d2) throws IOException {
        zzd(Double.doubleToRawLongBits(d2));
    }

    public final void zza(float f2) throws IOException {
        zzq(Float.floatToRawIntBits(f2));
    }

    public final void zza(int i, double d2) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d2));
    }

    public final void zza(int i, float f2) throws IOException {
        zzf(i, Float.floatToRawIntBits(f2));
    }

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzbb zzbbVar) throws IOException;

    public abstract void zza(int i, zzdo zzdoVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(int i, zzdo zzdoVar, InterfaceC1218pa interfaceC1218pa) throws IOException;

    public abstract void zza(int i, String str) throws IOException;

    public abstract void zza(zzbb zzbbVar) throws IOException;

    abstract void zza(zzdo zzdoVar, InterfaceC1218pa interfaceC1218pa) throws IOException;

    final void zza(String str, zzfi zzfiVar) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzfiVar);
        byte[] bytes = str.getBytes(zzci.UTF_8);
        try {
            zzo(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (zzc e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzc(e3);
        }
    }

    public final void zza(boolean z) throws IOException {
        zza(z ? (byte) 1 : (byte) 0);
    }

    public abstract int zzag();

    public abstract void zzb(int i, int i2) throws IOException;

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzj(j));
    }

    public abstract void zzb(int i, zzbb zzbbVar) throws IOException;

    public abstract void zzb(int i, zzdo zzdoVar) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(long j) throws IOException;

    public abstract void zzb(zzdo zzdoVar) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public final void zzc(long j) throws IOException {
        zzb(zzj(j));
    }

    public abstract void zzd(int i, int i2) throws IOException;

    public abstract void zzd(long j) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzd(byte[] bArr, int i, int i2) throws IOException;

    public final void zze(int i, int i2) throws IOException {
        zzd(i, zzy(i2));
    }

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract void zzg(String str) throws IOException;

    public abstract void zzn(int i) throws IOException;

    public abstract void zzo(int i) throws IOException;

    public final void zzp(int i) throws IOException {
        zzo(zzy(i));
    }

    public abstract void zzq(int i) throws IOException;
}

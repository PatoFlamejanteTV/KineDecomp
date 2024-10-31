package com.google.android.gms.internal.config;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* loaded from: classes2.dex */
public final class zzaz {
    private final ByteBuffer zzcg;

    private zzaz(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static zzaz zza(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    public static zzaz zzb(byte[] bArr, int i, int i2) {
        return new zzaz(bArr, 0, i2);
    }

    public static int zzd(int i, int i2) {
        return zzl(1) + zzj(i2);
    }

    public static int zzj(int i) {
        if (i >= 0) {
            return zzn(i);
        }
        return 10;
    }

    private final void zzk(int i) throws IOException {
        byte b2 = (byte) i;
        if (this.zzcg.hasRemaining()) {
            this.zzcg.put(b2);
            return;
        }
        throw new zzba(this.zzcg.position(), this.zzcg.limit());
    }

    public static int zzl(int i) {
        return zzn(i << 3);
    }

    public static int zzn(int i) {
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

    public final void zzad() {
        if (this.zzcg.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(this.zzcg.remaining())));
        }
    }

    public final void zzc(int i, int i2) throws IOException {
        zze(1, 0);
        if (i2 >= 0) {
            zzm(i2);
            return;
        }
        long j = i2;
        while (((-128) & j) != 0) {
            byte b2 = (byte) ((((int) j) & 127) | 128);
            if (this.zzcg.hasRemaining()) {
                this.zzcg.put(b2);
                j >>>= 7;
            } else {
                throw new zzba(this.zzcg.position(), this.zzcg.limit());
            }
        }
        byte b3 = (byte) j;
        if (this.zzcg.hasRemaining()) {
            this.zzcg.put(b3);
            return;
        }
        throw new zzba(this.zzcg.position(), this.zzcg.limit());
    }

    public final void zze(int i, int i2) throws IOException {
        zzm((i << 3) | i2);
    }

    public final void zzm(int i) throws IOException {
        while ((i & (-128)) != 0) {
            zzk((i & 127) | 128);
            i >>>= 7;
        }
        zzk(i);
    }

    private zzaz(ByteBuffer byteBuffer) {
        this.zzcg = byteBuffer;
        this.zzcg.order(ByteOrder.LITTLE_ENDIAN);
    }

    public static int zzb(int i, String str) {
        int zzl = zzl(i);
        int zza = zza(str);
        return zzl + zzn(zza) + zza;
    }

    public final void zza(int i, long j) throws IOException {
        zze(i, 1);
        if (this.zzcg.remaining() >= 8) {
            this.zzcg.putLong(j);
            return;
        }
        throw new zzba(this.zzcg.position(), this.zzcg.limit());
    }

    public static int zzb(int i, zzbh zzbhVar) {
        int zzl = zzl(i);
        int zzai = zzbhVar.zzai();
        return zzl + zzn(zzai) + zzai;
    }

    public final void zza(int i, String str) throws IOException {
        zze(i, 2);
        try {
            int zzn = zzn(str.length());
            if (zzn == zzn(str.length() * 3)) {
                int position = this.zzcg.position();
                if (this.zzcg.remaining() >= zzn) {
                    this.zzcg.position(position + zzn);
                    zza(str, this.zzcg);
                    int position2 = this.zzcg.position();
                    this.zzcg.position(position);
                    zzm((position2 - position) - zzn);
                    this.zzcg.position(position2);
                    return;
                }
                throw new zzba(position + zzn, this.zzcg.limit());
            }
            zzm(zza(str));
            zza(str, this.zzcg);
        } catch (BufferOverflowException e2) {
            zzba zzbaVar = new zzba(this.zzcg.position(), this.zzcg.limit());
            zzbaVar.initCause(e2);
            throw zzbaVar;
        }
    }

    public static int zzb(byte[] bArr) {
        return zzn(bArr.length) + bArr.length;
    }

    public final void zzc(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.zzcg.remaining() >= length) {
            this.zzcg.put(bArr, 0, length);
            return;
        }
        throw new zzba(this.zzcg.position(), this.zzcg.limit());
    }

    public final void zza(int i, zzbh zzbhVar) throws IOException {
        zze(i, 2);
        if (zzbhVar.zzcq < 0) {
            zzbhVar.zzai();
        }
        zzm(zzbhVar.zzcq);
        zzbhVar.zza(this);
    }

    public final void zza(int i, byte[] bArr) throws IOException {
        zze(i, 2);
        zzm(bArr.length);
        zzc(bArr);
    }

    private static int zza(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i2);
                                throw new IllegalArgumentException(sb.toString());
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        long j = i3 + 4294967296L;
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("UTF-8 length does not fit in int: ");
        sb2.append(j);
        throw new IllegalArgumentException(sb2.toString());
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int i2;
        char charAt;
        if (!byteBuffer.isReadOnly()) {
            int i3 = 0;
            if (byteBuffer.hasArray()) {
                try {
                    byte[] array = byteBuffer.array();
                    int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                    int remaining = byteBuffer.remaining();
                    int length = charSequence.length();
                    int i4 = remaining + arrayOffset;
                    while (i3 < length) {
                        int i5 = i3 + arrayOffset;
                        if (i5 >= i4 || (charAt = charSequence.charAt(i3)) >= 128) {
                            break;
                        }
                        array[i5] = (byte) charAt;
                        i3++;
                    }
                    if (i3 == length) {
                        i = arrayOffset + length;
                    } else {
                        i = arrayOffset + i3;
                        while (i3 < length) {
                            char charAt2 = charSequence.charAt(i3);
                            if (charAt2 >= 128 || i >= i4) {
                                if (charAt2 < 2048 && i <= i4 - 2) {
                                    int i6 = i + 1;
                                    array[i] = (byte) ((charAt2 >>> 6) | 960);
                                    i = i6 + 1;
                                    array[i6] = (byte) ((charAt2 & '?') | 128);
                                } else {
                                    if ((charAt2 >= 55296 && 57343 >= charAt2) || i > i4 - 3) {
                                        if (i <= i4 - 4) {
                                            int i7 = i3 + 1;
                                            if (i7 != charSequence.length()) {
                                                char charAt3 = charSequence.charAt(i7);
                                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                                    int i8 = i + 1;
                                                    array[i] = (byte) ((codePoint >>> 18) | 240);
                                                    int i9 = i8 + 1;
                                                    array[i8] = (byte) (((codePoint >>> 12) & 63) | 128);
                                                    int i10 = i9 + 1;
                                                    array[i9] = (byte) (((codePoint >>> 6) & 63) | 128);
                                                    i = i10 + 1;
                                                    array[i10] = (byte) ((codePoint & 63) | 128);
                                                    i3 = i7;
                                                } else {
                                                    i3 = i7;
                                                }
                                            }
                                            StringBuilder sb = new StringBuilder(39);
                                            sb.append("Unpaired surrogate at index ");
                                            sb.append(i3 - 1);
                                            throw new IllegalArgumentException(sb.toString());
                                        }
                                        StringBuilder sb2 = new StringBuilder(37);
                                        sb2.append("Failed writing ");
                                        sb2.append(charAt2);
                                        sb2.append(" at index ");
                                        sb2.append(i);
                                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                                    }
                                    int i11 = i + 1;
                                    array[i] = (byte) ((charAt2 >>> '\f') | 480);
                                    int i12 = i11 + 1;
                                    array[i11] = (byte) (((charAt2 >>> 6) & 63) | 128);
                                    i2 = i12 + 1;
                                    array[i12] = (byte) ((charAt2 & '?') | 128);
                                }
                                i3++;
                            } else {
                                i2 = i + 1;
                                array[i] = (byte) charAt2;
                            }
                            i = i2;
                            i3++;
                        }
                    }
                    byteBuffer.position(i - byteBuffer.arrayOffset());
                    return;
                } catch (ArrayIndexOutOfBoundsException e2) {
                    BufferOverflowException bufferOverflowException = new BufferOverflowException();
                    bufferOverflowException.initCause(e2);
                    throw bufferOverflowException;
                }
            }
            int length2 = charSequence.length();
            while (i3 < length2) {
                char charAt4 = charSequence.charAt(i3);
                if (charAt4 < 128) {
                    byteBuffer.put((byte) charAt4);
                } else if (charAt4 < 2048) {
                    byteBuffer.put((byte) ((charAt4 >>> 6) | 960));
                    byteBuffer.put((byte) ((charAt4 & '?') | 128));
                } else {
                    if (charAt4 >= 55296 && 57343 >= charAt4) {
                        int i13 = i3 + 1;
                        if (i13 != charSequence.length()) {
                            char charAt5 = charSequence.charAt(i13);
                            if (Character.isSurrogatePair(charAt4, charAt5)) {
                                int codePoint2 = Character.toCodePoint(charAt4, charAt5);
                                byteBuffer.put((byte) ((codePoint2 >>> 18) | 240));
                                byteBuffer.put((byte) (((codePoint2 >>> 12) & 63) | 128));
                                byteBuffer.put((byte) (((codePoint2 >>> 6) & 63) | 128));
                                byteBuffer.put((byte) ((codePoint2 & 63) | 128));
                                i3 = i13;
                            } else {
                                i3 = i13;
                            }
                        }
                        StringBuilder sb3 = new StringBuilder(39);
                        sb3.append("Unpaired surrogate at index ");
                        sb3.append(i3 - 1);
                        throw new IllegalArgumentException(sb3.toString());
                    }
                    byteBuffer.put((byte) ((charAt4 >>> '\f') | 480));
                    byteBuffer.put((byte) (((charAt4 >>> 6) & 63) | 128));
                    byteBuffer.put((byte) ((charAt4 & '?') | 128));
                }
                i3++;
            }
            return;
        }
        throw new ReadOnlyBufferException();
    }

    public final void zza(byte b2) throws IOException {
        if (this.zzcg.hasRemaining()) {
            this.zzcg.put(b2);
            return;
        }
        throw new zzba(this.zzcg.position(), this.zzcg.limit());
    }
}

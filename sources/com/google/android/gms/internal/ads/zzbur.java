package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* loaded from: classes2.dex */
public final class zzbur {
    private final ByteBuffer zzaep;
    private zzbqk zzfwi;
    private int zzfwj;

    private zzbur(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static int zzb(int i, zzbuz zzbuzVar) {
        int zzfd = zzfd(i);
        int zzamj = zzbuzVar.zzamj();
        return zzfd + zzfl(zzamj) + zzamj;
    }

    private final void zzbk(long j) throws IOException {
        while (((-128) & j) != 0) {
            zzgd((((int) j) & 127) | 128);
            j >>>= 7;
        }
        zzgd((int) j);
    }

    public static int zzbl(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private static void zzd(CharSequence charSequence, ByteBuffer byteBuffer) {
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

    public static int zzfd(int i) {
        return zzfl(i << 3);
    }

    public static int zzfe(int i) {
        if (i >= 0) {
            return zzfl(i);
        }
        return 10;
    }

    public static int zzfl(int i) {
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

    public static int zzfy(String str) {
        int zza = zza(str);
        return zzfl(zza) + zza;
    }

    public static int zzg(int i, String str) {
        return zzfd(i) + zzfy(str);
    }

    private final void zzgd(int i) throws IOException {
        byte b2 = (byte) i;
        if (this.zzaep.hasRemaining()) {
            this.zzaep.put(b2);
            return;
        }
        throw new zzbus(this.zzaep.position(), this.zzaep.limit());
    }

    public static int zzm(int i, long j) {
        return zzfd(i) + zzbl(j);
    }

    public static int zzn(int i, long j) {
        return zzfd(i) + zzbl(j);
    }

    public static zzbur zzr(byte[] bArr, int i, int i2) {
        return new zzbur(bArr, 0, i2);
    }

    public static zzbur zzx(byte[] bArr) {
        return zzr(bArr, 0, bArr.length);
    }

    public static int zzy(byte[] bArr) {
        return zzfl(bArr.length) + bArr.length;
    }

    public static int zzz(int i, int i2) {
        return zzfd(i) + zzfe(i2);
    }

    public final void zza(int i, zzbuz zzbuzVar) throws IOException {
        zzu(i, 2);
        if (zzbuzVar.zzfwt < 0) {
            zzbuzVar.zzamj();
        }
        zzge(zzbuzVar.zzfwt);
        zzbuzVar.zza(this);
    }

    public final void zzalv() {
        if (this.zzaep.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(this.zzaep.remaining())));
        }
    }

    public final void zze(int i, zzbsl zzbslVar) throws IOException {
        if (this.zzfwi == null) {
            this.zzfwi = zzbqk.zzn(this.zzaep);
            this.zzfwj = this.zzaep.position();
        } else if (this.zzfwj != this.zzaep.position()) {
            this.zzfwi.write(this.zzaep.array(), this.zzfwj, this.zzaep.position() - this.zzfwj);
            this.zzfwj = this.zzaep.position();
        }
        zzbqk zzbqkVar = this.zzfwi;
        zzbqkVar.zza(i, zzbslVar);
        zzbqkVar.flush();
        this.zzfwj = this.zzaep.position();
    }

    public final void zzf(int i, String str) throws IOException {
        zzu(i, 2);
        try {
            int zzfl = zzfl(str.length());
            if (zzfl == zzfl(str.length() * 3)) {
                int position = this.zzaep.position();
                if (this.zzaep.remaining() >= zzfl) {
                    this.zzaep.position(position + zzfl);
                    zzd(str, this.zzaep);
                    int position2 = this.zzaep.position();
                    this.zzaep.position(position);
                    zzge((position2 - position) - zzfl);
                    this.zzaep.position(position2);
                    return;
                }
                throw new zzbus(position + zzfl, this.zzaep.limit());
            }
            zzge(zza(str));
            zzd(str, this.zzaep);
        } catch (BufferOverflowException e2) {
            zzbus zzbusVar = new zzbus(this.zzaep.position(), this.zzaep.limit());
            zzbusVar.initCause(e2);
            throw zzbusVar;
        }
    }

    public final void zzge(int i) throws IOException {
        while ((i & (-128)) != 0) {
            zzgd((i & 127) | 128);
            i >>>= 7;
        }
        zzgd(i);
    }

    public final void zzj(int i, long j) throws IOException {
        zzu(i, 0);
        zzbk(j);
    }

    public final void zzu(int i, int i2) throws IOException {
        zzge((i << 3) | i2);
    }

    public final void zzv(int i, int i2) throws IOException {
        zzu(i, 0);
        if (i2 >= 0) {
            zzge(i2);
        } else {
            zzbk(i2);
        }
    }

    private zzbur(ByteBuffer byteBuffer) {
        this.zzaep = byteBuffer;
        this.zzaep.order(ByteOrder.LITTLE_ENDIAN);
    }

    public final void zzr(int i, long j) throws IOException {
        zzu(i, 0);
        zzbk(j);
    }

    public final void zzz(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.zzaep.remaining() >= length) {
            this.zzaep.put(bArr, 0, length);
            return;
        }
        throw new zzbus(this.zzaep.position(), this.zzaep.limit());
    }

    public final void zzj(int i, boolean z) throws IOException {
        zzu(i, 0);
        byte b2 = z ? (byte) 1 : (byte) 0;
        if (this.zzaep.hasRemaining()) {
            this.zzaep.put(b2);
            return;
        }
        throw new zzbus(this.zzaep.position(), this.zzaep.limit());
    }

    public static int zzb(int i, byte[] bArr) {
        return zzfd(i) + zzy(bArr);
    }

    public final void zza(int i, byte[] bArr) throws IOException {
        zzu(i, 2);
        zzge(bArr.length);
        zzz(bArr);
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
}

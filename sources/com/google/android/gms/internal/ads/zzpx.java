package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzpx {
    public byte[] data;
    private int limit;
    private int position;

    public zzpx() {
    }

    public final int capacity() {
        byte[] bArr = this.data;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int limit() {
        return this.limit;
    }

    public final int readInt() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = (bArr[i] & 255) << 24;
        int i3 = this.position;
        this.position = i3 + 1;
        int i4 = i2 | ((bArr[i3] & 255) << 16);
        int i5 = this.position;
        this.position = i5 + 1;
        int i6 = i4 | ((bArr[i5] & 255) << 8);
        int i7 = this.position;
        this.position = i7 + 1;
        return (bArr[i7] & 255) | i6;
    }

    public final long readLong() {
        byte[] bArr = this.data;
        this.position = this.position + 1;
        this.position = this.position + 1;
        long j = ((bArr[r1] & 255) << 56) | ((bArr[r5] & 255) << 48);
        this.position = this.position + 1;
        long j2 = j | ((bArr[r5] & 255) << 40);
        this.position = this.position + 1;
        long j3 = j2 | ((bArr[r5] & 255) << 32);
        this.position = this.position + 1;
        long j4 = j3 | ((bArr[r5] & 255) << 24);
        this.position = this.position + 1;
        long j5 = j4 | ((bArr[r5] & 255) << 16);
        this.position = this.position + 1;
        long j6 = j5 | ((bArr[r5] & 255) << 8);
        this.position = this.position + 1;
        return j6 | (255 & bArr[r5]);
    }

    public final short readShort() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        int i3 = this.position;
        this.position = i3 + 1;
        return (short) ((bArr[i3] & 255) | i2);
    }

    public final int readUnsignedByte() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        return bArr[i] & 255;
    }

    public final int readUnsignedShort() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        int i3 = this.position;
        this.position = i3 + 1;
        return (bArr[i3] & 255) | i2;
    }

    public final void reset(int i) {
        zzc(capacity() < i ? new byte[i] : this.data, i);
    }

    public final void setPosition(int i) {
        zzpo.checkArgument(i >= 0 && i <= this.limit);
        this.position = i;
    }

    public final void zzbk(int i) {
        zzpo.checkArgument(i >= 0 && i <= this.data.length);
        this.limit = i;
    }

    public final void zzbl(int i) {
        setPosition(this.position + i);
    }

    public final String zzbm(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = (this.position + i) - 1;
        String str = new String(this.data, this.position, (i2 >= this.limit || this.data[i2] != 0) ? i : i - 1);
        this.position += i;
        return str;
    }

    public final void zzc(byte[] bArr, int i) {
        this.data = bArr;
        this.limit = i;
        this.position = 0;
    }

    public final void zze(byte[] bArr, int i, int i2) {
        System.arraycopy(this.data, this.position, bArr, i, i2);
        this.position += i2;
    }

    public final int zzhb() {
        return this.limit - this.position;
    }

    public final int zzhc() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = bArr[i] & 255;
        int i3 = this.position;
        this.position = i3 + 1;
        return ((bArr[i3] & 255) << 8) | i2;
    }

    public final long zzhd() {
        byte[] bArr = this.data;
        this.position = this.position + 1;
        this.position = this.position + 1;
        long j = ((bArr[r1] & 255) << 24) | ((bArr[r5] & 255) << 16);
        this.position = this.position + 1;
        long j2 = j | ((bArr[r5] & 255) << 8);
        this.position = this.position + 1;
        return j2 | (255 & bArr[r5]);
    }

    public final long zzhe() {
        byte[] bArr = this.data;
        this.position = this.position + 1;
        this.position = this.position + 1;
        long j = (bArr[r1] & 255) | ((bArr[r5] & 255) << 8);
        this.position = this.position + 1;
        long j2 = j | ((bArr[r5] & 255) << 16);
        this.position = this.position + 1;
        return j2 | ((255 & bArr[r5]) << 24);
    }

    public final int zzhf() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        int i3 = this.position;
        this.position = i3 + 1;
        int i4 = (bArr[i3] & 255) | i2;
        this.position += 2;
        return i4;
    }

    public final int zzhg() {
        int readInt = readInt();
        if (readInt >= 0) {
            return readInt;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(readInt);
        throw new IllegalStateException(sb.toString());
    }

    public final long zzhh() {
        long readLong = readLong();
        if (readLong >= 0) {
            return readLong;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(readLong);
        throw new IllegalStateException(sb.toString());
    }

    public final String zzhi() {
        if (zzhb() == 0) {
            return null;
        }
        int i = this.position;
        while (i < this.limit && this.data[i] != 0) {
            i++;
        }
        byte[] bArr = this.data;
        int i2 = this.position;
        String str = new String(bArr, i2, i - i2);
        this.position = i;
        int i3 = this.position;
        if (i3 < this.limit) {
            this.position = i3 + 1;
        }
        return str;
    }

    public zzpx(int i) {
        this.data = new byte[i];
        this.limit = i;
    }

    public final void reset() {
        this.position = 0;
        this.limit = 0;
    }

    public zzpx(byte[] bArr) {
        this.data = bArr;
        this.limit = bArr.length;
    }
}

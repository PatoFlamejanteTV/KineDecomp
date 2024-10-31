package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzqn {
    public final int zzakx;
    public final List<byte[]> zzzl;

    private zzqn(List<byte[]> list, int i) {
        this.zzzl = list;
        this.zzakx = i;
    }

    public static zzqn zzi(zzpx zzpxVar) throws zzfx {
        try {
            zzpxVar.zzbl(21);
            int readUnsignedByte = zzpxVar.readUnsignedByte() & 3;
            int readUnsignedByte2 = zzpxVar.readUnsignedByte();
            int position = zzpxVar.getPosition();
            int i = 0;
            int i2 = 0;
            while (i < readUnsignedByte2) {
                zzpxVar.zzbl(1);
                int readUnsignedShort = zzpxVar.readUnsignedShort();
                int i3 = i2;
                for (int i4 = 0; i4 < readUnsignedShort; i4++) {
                    int readUnsignedShort2 = zzpxVar.readUnsignedShort();
                    i3 += readUnsignedShort2 + 4;
                    zzpxVar.zzbl(readUnsignedShort2);
                }
                i++;
                i2 = i3;
            }
            zzpxVar.setPosition(position);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            int i6 = 0;
            while (i5 < readUnsignedByte2) {
                zzpxVar.zzbl(1);
                int readUnsignedShort3 = zzpxVar.readUnsignedShort();
                int i7 = i6;
                for (int i8 = 0; i8 < readUnsignedShort3; i8++) {
                    int readUnsignedShort4 = zzpxVar.readUnsignedShort();
                    System.arraycopy(zzpu.zzbhi, 0, bArr, i7, zzpu.zzbhi.length);
                    int length = i7 + zzpu.zzbhi.length;
                    System.arraycopy(zzpxVar.data, zzpxVar.getPosition(), bArr, length, readUnsignedShort4);
                    i7 = length + readUnsignedShort4;
                    zzpxVar.zzbl(readUnsignedShort4);
                }
                i5++;
                i6 = i7;
            }
            return new zzqn(i2 == 0 ? null : Collections.singletonList(bArr), readUnsignedByte + 1);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new zzfx("Error parsing HEVC config", e2);
        }
    }
}

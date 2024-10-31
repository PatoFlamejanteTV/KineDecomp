package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzqh {
    private final int height;
    private final int width;
    public final int zzakx;
    public final float zzbhq;
    public final List<byte[]> zzzl;

    private zzqh(List<byte[]> list, int i, int i2, int i3, float f2) {
        this.zzzl = list;
        this.zzakx = i;
        this.width = i2;
        this.height = i3;
        this.zzbhq = f2;
    }

    public static zzqh zzg(zzpx zzpxVar) throws zzfx {
        int i;
        int i2;
        float f2;
        try {
            zzpxVar.zzbl(4);
            int readUnsignedByte = (zzpxVar.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte != 3) {
                ArrayList arrayList = new ArrayList();
                int readUnsignedByte2 = zzpxVar.readUnsignedByte() & 31;
                for (int i3 = 0; i3 < readUnsignedByte2; i3++) {
                    arrayList.add(zzh(zzpxVar));
                }
                int readUnsignedByte3 = zzpxVar.readUnsignedByte();
                for (int i4 = 0; i4 < readUnsignedByte3; i4++) {
                    arrayList.add(zzh(zzpxVar));
                }
                if (readUnsignedByte2 > 0) {
                    zzpv zzd = zzpu.zzd((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                    int i5 = zzd.width;
                    int i6 = zzd.height;
                    f2 = zzd.zzbhq;
                    i = i5;
                    i2 = i6;
                } else {
                    i = -1;
                    i2 = -1;
                    f2 = 1.0f;
                }
                return new zzqh(arrayList, readUnsignedByte, i, i2, f2);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new zzfx("Error parsing AVC config", e2);
        }
    }

    private static byte[] zzh(zzpx zzpxVar) {
        int readUnsignedShort = zzpxVar.readUnsignedShort();
        int position = zzpxVar.getPosition();
        zzpxVar.zzbl(readUnsignedShort);
        return zzpp.zzc(zzpxVar.data, position, readUnsignedShort);
    }
}

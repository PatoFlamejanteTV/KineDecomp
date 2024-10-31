package com.google.android.gms.internal.ads;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class zzgg {
    private static final int[] zzaay = {1, 2, 3, 6};
    private static final int[] zzaaz = {48000, 44100, 32000};
    private static final int[] zzaba = {24000, 22050, 16000};
    private static final int[] zzabb = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzabc = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, ModuleDescriptor.MODULE_VERSION, 384, 448, 512, 576, 640};
    private static final int[] zzabd = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static zzfs zza(zzpx zzpxVar, String str, String str2, zzhp zzhpVar) {
        int i = zzaaz[(zzpxVar.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzpxVar.readUnsignedByte();
        int i2 = zzabb[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        return zzfs.zza(str, "audio/ac3", null, -1, -1, i2, i, null, zzhpVar, 0, str2);
    }

    public static zzfs zzb(zzpx zzpxVar, String str, String str2, zzhp zzhpVar) {
        zzpxVar.zzbl(2);
        int i = zzaaz[(zzpxVar.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzpxVar.readUnsignedByte();
        int i2 = zzabb[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        return zzfs.zza(str, "audio/eac3", null, -1, -1, i2, i, null, zzhpVar, 0, str2);
    }

    public static int zzcn() {
        return 1536;
    }

    public static int zzh(ByteBuffer byteBuffer) {
        return (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? zzaay[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4] : 6) * 256;
    }
}

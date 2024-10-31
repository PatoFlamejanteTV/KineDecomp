package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzbvc {
    private static final int zzfwu = 11;
    private static final int zzfwv = 12;
    private static final int zzfww = 16;
    private static final int zzfwx = 26;
    public static final int[] zzfsg = new int[0];
    public static final long[] zzfwy = new long[0];
    private static final float[] zzfwz = new float[0];
    private static final double[] zzfxa = new double[0];
    private static final boolean[] zzfxb = new boolean[0];
    public static final String[] zzfxc = new String[0];
    public static final byte[][] zzfxd = new byte[0];
    public static final byte[] zzfxe = new byte[0];

    public static final int zzb(zzbuq zzbuqVar, int i) throws IOException {
        int position = zzbuqVar.getPosition();
        zzbuqVar.zzep(i);
        int i2 = 1;
        while (zzbuqVar.zzaku() == i) {
            zzbuqVar.zzep(i);
            i2++;
        }
        zzbuqVar.zzan(position, i);
        return i2;
    }
}

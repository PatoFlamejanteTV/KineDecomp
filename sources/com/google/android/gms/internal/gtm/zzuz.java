package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzuz {
    private static final int zzbhm = 11;
    private static final int zzbhn = 12;
    private static final int zzbho = 16;
    private static final int zzbhp = 26;
    public static final int[] zzbcw = new int[0];
    private static final long[] zzbhq = new long[0];
    private static final float[] zzbhr = new float[0];
    private static final double[] zzbhs = new double[0];
    private static final boolean[] zzbht = new boolean[0];
    public static final String[] zzbhu = new String[0];
    private static final byte[][] zzbhv = new byte[0];
    public static final byte[] zzbhw = new byte[0];

    public static final int zzb(zzun zzunVar, int i) throws IOException {
        int position = zzunVar.getPosition();
        zzunVar.zzao(i);
        int i2 = 1;
        while (zzunVar.zzni() == i) {
            zzunVar.zzao(i);
            i2++;
        }
        zzunVar.zzu(position, i);
        return i2;
    }
}

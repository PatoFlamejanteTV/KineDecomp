package com.google.android.gms.internal.config;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzbk {
    private static final int zzcs = 11;
    private static final int zzct = 12;
    private static final int zzcu = 16;
    private static final int zzcv = 26;
    private static final int[] zzcw = new int[0];
    private static final long[] zzcx = new long[0];
    private static final float[] zzcy = new float[0];
    private static final double[] zzcz = new double[0];
    private static final boolean[] zzda = new boolean[0];
    private static final String[] zzdb = new String[0];
    public static final byte[][] zzdc = new byte[0];
    public static final byte[] zzdd = new byte[0];

    public static final int zzb(zzay zzayVar, int i) throws IOException {
        int position = zzayVar.getPosition();
        zzayVar.zzh(i);
        int i2 = 1;
        while (zzayVar.zzy() == i) {
            zzayVar.zzh(i);
            i2++;
        }
        zzayVar.zzb(position, i);
        return i2;
    }
}

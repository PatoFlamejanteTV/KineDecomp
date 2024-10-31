package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzyl {
    private static final int zzcfe = 11;
    private static final int zzcff = 12;
    private static final int zzcfg = 16;
    private static final int zzcfh = 26;
    public static final int[] zzcao = new int[0];
    public static final long[] zzcfi = new long[0];
    private static final float[] zzcfj = new float[0];
    private static final double[] zzcfk = new double[0];
    private static final boolean[] zzcfl = new boolean[0];
    public static final String[] zzcfm = new String[0];
    private static final byte[][] zzcfn = new byte[0];
    public static final byte[] zzcfo = new byte[0];

    public static final int zzb(zzxz zzxzVar, int i) throws IOException {
        int position = zzxzVar.getPosition();
        zzxzVar.zzaq(i);
        int i2 = 1;
        while (zzxzVar.zzuj() == i) {
            zzxzVar.zzaq(i);
            i2++;
        }
        zzxzVar.zzt(position, i);
        return i2;
    }
}

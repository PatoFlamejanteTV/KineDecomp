package com.google.android.gms.internal.firebase_abt;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzm {
    private static final int zzad = 11;
    private static final int zzae = 12;
    private static final int zzaf = 16;
    private static final int zzag = 26;
    private static final int[] zzah = new int[0];
    private static final long[] zzai = new long[0];
    private static final float[] zzaj = new float[0];
    private static final double[] zzak = new double[0];
    private static final boolean[] zzal = new boolean[0];
    private static final String[] zzam = new String[0];
    private static final byte[][] zzan = new byte[0];
    public static final byte[] zzao = new byte[0];

    public static final int zzb(zza zzaVar, int i) throws IOException {
        int position = zzaVar.getPosition();
        zzaVar.zzb(106);
        int i2 = 1;
        while (zzaVar.zzd() == 106) {
            zzaVar.zzb(106);
            i2++;
        }
        zzaVar.zzb(position, 106);
        return i2;
    }
}

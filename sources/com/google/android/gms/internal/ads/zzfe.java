package com.google.android.gms.internal.ads;

import android.support.v4.view.PointerIconCompat;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class zzfe {
    public static final int CHANNEL_OUT_7POINT1_SURROUND;
    public static final UUID zzwm;
    private static final UUID zzwn;
    private static final UUID zzwo;
    public static final UUID zzwp;

    static {
        CHANNEL_OUT_7POINT1_SURROUND = zzqe.SDK_INT < 23 ? PointerIconCompat.TYPE_GRAB : 6396;
        zzwm = new UUID(0L, 0L);
        zzwn = new UUID(1186680826959645954L, -5988876978535335093L);
        zzwo = new UUID(-1301668207276963122L, -6645017420763422227L);
        zzwp = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long zzf(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j / 1000;
    }

    public static long zzg(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j * 1000;
    }
}

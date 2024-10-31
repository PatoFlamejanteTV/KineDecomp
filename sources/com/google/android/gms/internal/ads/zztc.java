package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zztc {
    private final float zzbys;
    private final float zzbyt;
    private final float zzbyu;
    private final float zzbyv;
    private final int zzbyw;

    @VisibleForTesting
    public zztc(float f2, float f3, float f4, float f5, int i) {
        this.zzbys = f2;
        this.zzbyt = f3;
        this.zzbyu = f2 + f4;
        this.zzbyv = f3 + f5;
        this.zzbyw = i;
    }

    public final float zznx() {
        return this.zzbys;
    }

    public final float zzny() {
        return this.zzbyt;
    }

    public final float zznz() {
        return this.zzbyu;
    }

    public final float zzoa() {
        return this.zzbyv;
    }

    public final int zzob() {
        return this.zzbyw;
    }
}

package com.google.android.gms.internal;

import android.os.Build;

/* loaded from: classes.dex */
public class zzrg {
    int zzCq() {
        return Build.VERSION.SDK_INT;
    }

    public zzrf zzEt() {
        return zzCq() < 8 ? new jd() : new je();
    }
}

package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzaas {
    public static void zza(zzaaq zzaaqVar, zzaap zzaapVar) {
        if (zzaapVar.getContext() != null) {
            if (!TextUtils.isEmpty(zzaapVar.zzmr())) {
                zzaaqVar.zza(zzaapVar.getContext(), zzaapVar.zzmr(), zzaapVar.zzra(), zzaapVar.zzrb());
                return;
            }
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
        throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
    }
}

package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.internal.zzms;

/* loaded from: classes.dex */
public abstract class GamesDowngradeableSafeParcel extends DowngradeableSafeParcel {
    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean b(Integer num) {
        if (num == null) {
            return false;
        }
        return zzms.zzcc(num.intValue());
    }
}

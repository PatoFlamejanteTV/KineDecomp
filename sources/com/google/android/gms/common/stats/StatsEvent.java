package com.google.android.gms.common.stats;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface Types {
    }

    public abstract long O();

    public abstract int a();

    public String toString() {
        long O = O();
        int a2 = a();
        long zzu = zzu();
        String zzv = zzv();
        StringBuilder sb = new StringBuilder(String.valueOf(zzv).length() + 53);
        sb.append(O);
        sb.append("\t");
        sb.append(a2);
        sb.append("\t");
        sb.append(zzu);
        sb.append(zzv);
        return sb.toString();
    }

    public abstract long zzu();

    public abstract String zzv();
}

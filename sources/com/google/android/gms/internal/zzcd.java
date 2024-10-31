package com.google.android.gms.internal;

import java.util.Map;

@zzgr
/* loaded from: classes.dex */
public abstract class zzcd {

    @zzgr
    public static final zzcd zzvK = new ag();

    @zzgr
    public static final zzcd zzvL = new ah();

    @zzgr
    public static final zzcd zzvM = new ai();

    public final void zza(Map<String, String> map, String str, String str2) {
        map.put(str, zzd(map.get(str), str2));
    }

    public abstract String zzd(String str, String str2);
}

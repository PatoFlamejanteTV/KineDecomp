package com.google.android.gms.internal;

import com.google.android.gms.common.api.Scope;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzna {
    public static String[] zza(Scope[] scopeArr) {
        com.google.android.gms.common.internal.zzx.a(scopeArr, "scopes can't be null.");
        String[] strArr = new String[scopeArr.length];
        for (int i = 0; i < scopeArr.length; i++) {
            strArr[i] = scopeArr[i].a();
        }
        return strArr;
    }

    public static String[] zzc(Set<Scope> set) {
        com.google.android.gms.common.internal.zzx.a(set, "scopes can't be null.");
        return zza((Scope[]) set.toArray(new Scope[set.size()]));
    }
}

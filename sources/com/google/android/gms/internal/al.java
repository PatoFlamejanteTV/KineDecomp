package com.google.android.gms.internal;

import java.util.Map;

/* loaded from: classes.dex */
final class al implements zzdk {
    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        if (zzby.zzvs.get().booleanValue()) {
            zzizVar.zzE(!Boolean.parseBoolean(map.get("disabled")));
        }
    }
}

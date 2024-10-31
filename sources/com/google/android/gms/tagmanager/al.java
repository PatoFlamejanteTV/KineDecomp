package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.Map;

/* loaded from: classes.dex */
abstract class al extends i {
    @Override // com.google.android.gms.tagmanager.i
    public zzag.zza a(Map<String, zzag.zza> map) {
        b(map);
        return zzdf.b();
    }

    @Override // com.google.android.gms.tagmanager.i
    public boolean a() {
        return false;
    }

    public abstract void b(Map<String, zzag.zza> map);
}

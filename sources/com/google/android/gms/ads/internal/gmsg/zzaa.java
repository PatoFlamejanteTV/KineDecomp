package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.internal.ads.zzark;
import java.util.Map;

@zzark
/* loaded from: classes.dex */
public final class zzaa implements zzu<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f10058a;

    public zzaa(Context context) {
        this.f10058a = context;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final void zza(Object obj, Map<String, String> map) {
        if (zzbv.E().zzv(this.f10058a)) {
            zzbv.E().zza(this.f10058a, map.get("eventName"), map.get("eventId"));
        }
    }
}

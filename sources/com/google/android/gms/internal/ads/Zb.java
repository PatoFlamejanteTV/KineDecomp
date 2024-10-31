package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Zb implements com.google.android.gms.ads.internal.gmsg.zzu<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzabw f12002a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzapw f12003b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Zb(zzapw zzapwVar, zzabw zzabwVar) {
        this.f12003b = zzapwVar;
        this.f12002a = zzabwVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final void zza(Object obj, Map<String, String> map) {
        this.f12003b.zzc(this.f12002a, map.get("asset"));
    }
}

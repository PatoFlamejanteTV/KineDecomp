package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.tc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1092tc implements zzbbn<zzbgg> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f12546a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ JSONObject f12547b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1092tc(zzaqt zzaqtVar, String str, JSONObject jSONObject) {
        this.f12546a = str;
        this.f12547b = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzbbn
    public final void zzb(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzbbn
    public final /* synthetic */ void zzl(zzbgg zzbggVar) {
        zzbggVar.zza(this.f12546a, this.f12547b);
    }
}

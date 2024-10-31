package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.w, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1131w implements com.google.android.gms.ads.internal.gmsg.zzu<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaqp f12618a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ C1075s f12619b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1131w(C1075s c1075s, zzaqp zzaqpVar) {
        this.f12619b = c1075s;
        this.f12618a = zzaqpVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final void zza(Object obj, Map<String, String> map) {
        WeakReference weakReference;
        weakReference = this.f12619b.f12506a;
        zzbgg zzbggVar = (zzbgg) weakReference.get();
        if (zzbggVar == null) {
            this.f12618a.zzb("/hideOverlay", this);
        } else {
            zzbggVar.getView().setVisibility(8);
        }
    }
}

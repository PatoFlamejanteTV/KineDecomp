package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.ads.s */
/* loaded from: classes2.dex */
final class C1075s {

    /* renamed from: a */
    private final WeakReference<zzbgg> f12506a;

    /* renamed from: b */
    private String f12507b;

    public C1075s(zzbgg zzbggVar) {
        this.f12506a = new WeakReference<>(zzbggVar);
    }

    public final void a(zzaqp zzaqpVar) {
        zzaqpVar.zza("/loadHtml", new C1089t(this, zzaqpVar));
        zzaqpVar.zza("/showOverlay", new C1117v(this, zzaqpVar));
        zzaqpVar.zza("/hideOverlay", new C1131w(this, zzaqpVar));
        zzbgg zzbggVar = this.f12506a.get();
        if (zzbggVar != null) {
            zzbggVar.zza("/sendMessageToSdk", new C1145x(this, zzaqpVar));
        }
    }
}

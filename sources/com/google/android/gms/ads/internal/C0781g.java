package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzaxf;
import com.google.android.gms.internal.ads.zzaxv;
import com.google.android.gms.internal.ads.zzayh;

/* JADX INFO: Access modifiers changed from: package-private */
@zzark
/* renamed from: com.google.android.gms.ads.internal.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0781g extends zzaxv {

    /* renamed from: a, reason: collision with root package name */
    private final int f10032a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzal f10033b;

    public C0781g(zzal zzalVar, int i) {
        this.f10033b = zzalVar;
        this.f10032a = i;
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void zzki() {
        boolean z;
        float f2;
        boolean z2;
        boolean z3 = this.f10033b.zzbls.M;
        zzbv.e();
        boolean zzay = zzayh.zzay(this.f10033b.zzbls.f10251c);
        z = this.f10033b.f10199d;
        f2 = this.f10033b.f10200e;
        int i = this.f10033b.zzbls.M ? this.f10032a : -1;
        z2 = this.f10033b.f10201f;
        zzaxf zzaxfVar = this.f10033b.zzbls.j;
        zzaq zzaqVar = new zzaq(z3, zzay, z, f2, i, z2, zzaxfVar.zzbph, zzaxfVar.zzbpi);
        int requestedOrientation = this.f10033b.zzbls.j.zzdrv.getRequestedOrientation();
        if (requestedOrientation == -1) {
            requestedOrientation = this.f10033b.zzbls.j.orientation;
        }
        int i2 = requestedOrientation;
        zzal zzalVar = this.f10033b;
        zzbw zzbwVar = zzalVar.zzbls;
        zzaxf zzaxfVar2 = zzbwVar.j;
        zzayh.zzelc.post(new RunnableC0782h(this, new AdOverlayInfoParcel(zzalVar, zzalVar, zzalVar, zzaxfVar2.zzdrv, i2, zzbwVar.f10253e, zzaxfVar2.zzdyi, zzaqVar)));
    }
}

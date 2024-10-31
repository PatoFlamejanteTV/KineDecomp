package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.gmsg.zzu;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzals;
import com.google.android.gms.internal.ads.zzalv;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbgg;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.ads.internal.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0787m implements zzu<zzbgg> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzals f10092a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzab f10093b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzalv f10094c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0787m(zzals zzalsVar, zzab zzabVar, zzalv zzalvVar) {
        this.f10092a = zzalsVar;
        this.f10093b = zzabVar;
        this.f10094c = zzalvVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbggVar, Map map) {
        zzbgg zzbggVar2 = zzbggVar;
        View view = zzbggVar2.getView();
        if (view != null) {
            try {
                if (this.f10092a != null) {
                    if (!this.f10092a.getOverrideClickHandling()) {
                        this.f10092a.zzk(ObjectWrapper.a(view));
                        this.f10093b.f10172a.onAdClicked();
                        return;
                    } else {
                        zzas.b(zzbggVar2);
                        return;
                    }
                }
                if (this.f10094c != null) {
                    if (!this.f10094c.getOverrideClickHandling()) {
                        this.f10094c.zzk(ObjectWrapper.a(view));
                        this.f10093b.f10172a.onAdClicked();
                    } else {
                        zzas.b(zzbggVar2);
                    }
                }
            } catch (RemoteException e2) {
                zzbbd.zzc("Unable to call handleClick on mapper", e2);
            }
        }
    }
}

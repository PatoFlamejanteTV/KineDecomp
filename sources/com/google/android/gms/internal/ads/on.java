package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class on extends un<zzxl> {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Context f12407b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzwf f12408c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ String f12409d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzalg f12410e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzwj f12411f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public on(zzwj zzwjVar, Context context, zzwf zzwfVar, String str, zzalg zzalgVar) {
        this.f12411f = zzwjVar;
        this.f12407b = context;
        this.f12408c = zzwfVar;
        this.f12409d = str;
        this.f12410e = zzalgVar;
    }

    @Override // com.google.android.gms.internal.ads.un
    public final /* synthetic */ zzxl a() {
        zzwj.zza(this.f12407b, "interstitial");
        return new zzzl();
    }

    @Override // com.google.android.gms.internal.ads.un
    public final /* synthetic */ zzxl b() throws RemoteException {
        zzvz zzvzVar;
        zzvzVar = this.f12411f.zzckr;
        return zzvzVar.zza(this.f12407b, this.f12408c, this.f12409d, this.f12410e, 2);
    }

    @Override // com.google.android.gms.internal.ads.un
    public final /* synthetic */ zzxl a(zzxw zzxwVar) throws RemoteException {
        return zzxwVar.createInterstitialAdManager(ObjectWrapper.a(this.f12407b), this.f12408c, this.f12409d, this.f12410e, 14300000);
    }
}

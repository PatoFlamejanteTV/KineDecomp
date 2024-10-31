package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
final class qn extends un<zzyc> {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Context f12472b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzwj f12473c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public qn(zzwj zzwjVar, Context context) {
        this.f12473c = zzwjVar;
        this.f12472b = context;
    }

    @Override // com.google.android.gms.internal.ads.un
    protected final /* synthetic */ zzyc a() {
        zzwj.zza(this.f12472b, "mobile_ads_settings");
        return new zzzn();
    }

    @Override // com.google.android.gms.internal.ads.un
    public final /* synthetic */ zzyc b() throws RemoteException {
        zzzg zzzgVar;
        zzzgVar = this.f12473c.zzckt;
        return zzzgVar.zzi(this.f12472b);
    }

    @Override // com.google.android.gms.internal.ads.un
    public final /* synthetic */ zzyc a(zzxw zzxwVar) throws RemoteException {
        return zzxwVar.getMobileAdsSettingsManagerWithClientJarVersion(ObjectWrapper.a(this.f12472b), 14300000);
    }
}

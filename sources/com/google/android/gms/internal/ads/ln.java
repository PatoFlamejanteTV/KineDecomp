package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ln extends un<zzxl> {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Context f12313b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzwf f12314c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ String f12315d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzalg f12316e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzwj f12317f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ln(zzwj zzwjVar, Context context, zzwf zzwfVar, String str, zzalg zzalgVar) {
        this.f12317f = zzwjVar;
        this.f12313b = context;
        this.f12314c = zzwfVar;
        this.f12315d = str;
        this.f12316e = zzalgVar;
    }

    @Override // com.google.android.gms.internal.ads.un
    public final /* synthetic */ zzxl a() {
        zzwj.zza(this.f12313b, "banner");
        return new zzzl();
    }

    @Override // com.google.android.gms.internal.ads.un
    public final /* synthetic */ zzxl b() throws RemoteException {
        zzvz zzvzVar;
        zzvzVar = this.f12317f.zzckr;
        return zzvzVar.zza(this.f12313b, this.f12314c, this.f12315d, this.f12316e, 1);
    }

    @Override // com.google.android.gms.internal.ads.un
    public final /* synthetic */ zzxl a(zzxw zzxwVar) throws RemoteException {
        return zzxwVar.createBannerAdManager(ObjectWrapper.a(this.f12313b), this.f12314c, this.f12315d, this.f12316e, 14300000);
    }
}

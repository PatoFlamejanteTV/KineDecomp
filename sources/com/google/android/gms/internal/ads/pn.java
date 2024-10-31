package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class pn extends un<zzxg> {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Context f12439b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f12440c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzalg f12441d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzwj f12442e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public pn(zzwj zzwjVar, Context context, String str, zzalg zzalgVar) {
        this.f12442e = zzwjVar;
        this.f12439b = context;
        this.f12440c = str;
        this.f12441d = zzalgVar;
    }

    @Override // com.google.android.gms.internal.ads.un
    protected final /* synthetic */ zzxg a() {
        zzwj.zza(this.f12439b, "native_ad");
        return new zzzh();
    }

    @Override // com.google.android.gms.internal.ads.un
    public final /* synthetic */ zzxg b() throws RemoteException {
        zzvy zzvyVar;
        zzvyVar = this.f12442e.zzcks;
        return zzvyVar.zza(this.f12439b, this.f12440c, this.f12441d);
    }

    @Override // com.google.android.gms.internal.ads.un
    public final /* synthetic */ zzxg a(zzxw zzxwVar) throws RemoteException {
        return zzxwVar.createAdLoaderBuilder(ObjectWrapper.a(this.f12439b), this.f12440c, this.f12441d, 14300000);
    }
}

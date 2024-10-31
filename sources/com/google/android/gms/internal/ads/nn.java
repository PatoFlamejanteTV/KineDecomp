package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class nn extends un<zzxl> {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Context f12370b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzwf f12371c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ String f12372d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzwj f12373e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public nn(zzwj zzwjVar, Context context, zzwf zzwfVar, String str) {
        this.f12373e = zzwjVar;
        this.f12370b = context;
        this.f12371c = zzwfVar;
        this.f12372d = str;
    }

    @Override // com.google.android.gms.internal.ads.un
    public final /* synthetic */ zzxl a() {
        zzwj.zza(this.f12370b, "search");
        return new zzzl();
    }

    @Override // com.google.android.gms.internal.ads.un
    public final /* synthetic */ zzxl b() throws RemoteException {
        zzvz zzvzVar;
        zzvzVar = this.f12373e.zzckr;
        return zzvzVar.zza(this.f12370b, this.f12371c, this.f12372d, null, 3);
    }

    @Override // com.google.android.gms.internal.ads.un
    public final /* synthetic */ zzxl a(zzxw zzxwVar) throws RemoteException {
        return zzxwVar.createSearchAdManager(ObjectWrapper.a(this.f12370b), this.f12371c, this.f12372d, 14300000);
    }
}

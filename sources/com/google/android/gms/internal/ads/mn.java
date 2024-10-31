package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class mn extends un<zzaop> {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Activity f12339b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzwj f12340c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public mn(zzwj zzwjVar, Activity activity) {
        this.f12340c = zzwjVar;
        this.f12339b = activity;
    }

    @Override // com.google.android.gms.internal.ads.un
    protected final /* synthetic */ zzaop a() {
        zzwj.zza(this.f12339b, "ad_overlay");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.un
    public final /* synthetic */ zzaop b() throws RemoteException {
        zzaoo zzaooVar;
        zzaooVar = this.f12340c.zzckx;
        return zzaooVar.zze(this.f12339b);
    }

    @Override // com.google.android.gms.internal.ads.un
    public final /* synthetic */ zzaop a(zzxw zzxwVar) throws RemoteException {
        return zzxwVar.createAdOverlay(ObjectWrapper.a(this.f12339b));
    }
}

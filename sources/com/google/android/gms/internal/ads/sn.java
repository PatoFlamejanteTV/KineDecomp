package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;

/* loaded from: classes2.dex */
final class sn extends un<zzadk> {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ View f12537b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ HashMap f12538c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ HashMap f12539d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzwj f12540e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public sn(zzwj zzwjVar, View view, HashMap hashMap, HashMap hashMap2) {
        this.f12540e = zzwjVar;
        this.f12537b = view;
        this.f12538c = hashMap;
        this.f12539d = hashMap2;
    }

    @Override // com.google.android.gms.internal.ads.un
    protected final /* synthetic */ zzadk a() {
        zzwj.zza(this.f12537b.getContext(), "native_ad_view_holder_delegate");
        return new zzzp();
    }

    @Override // com.google.android.gms.internal.ads.un
    public final /* synthetic */ zzadk b() throws RemoteException {
        zzafb zzafbVar;
        zzafbVar = this.f12540e.zzcky;
        return zzafbVar.zzb(this.f12537b, this.f12538c, this.f12539d);
    }

    @Override // com.google.android.gms.internal.ads.un
    public final /* synthetic */ zzadk a(zzxw zzxwVar) throws RemoteException {
        return zzxwVar.createNativeAdViewHolderDelegate(ObjectWrapper.a(this.f12537b), ObjectWrapper.a(this.f12538c), ObjectWrapper.a(this.f12539d));
    }
}

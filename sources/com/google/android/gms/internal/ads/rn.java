package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class rn extends un<zzadf> {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ FrameLayout f12502b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ FrameLayout f12503c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ Context f12504d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzwj f12505e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public rn(zzwj zzwjVar, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.f12505e = zzwjVar;
        this.f12502b = frameLayout;
        this.f12503c = frameLayout2;
        this.f12504d = context;
    }

    @Override // com.google.android.gms.internal.ads.un
    protected final /* synthetic */ zzadf a() {
        zzwj.zza(this.f12504d, "native_ad_view_delegate");
        return new zzzo();
    }

    @Override // com.google.android.gms.internal.ads.un
    public final /* synthetic */ zzadf b() throws RemoteException {
        zzafa zzafaVar;
        zzafaVar = this.f12505e.zzcku;
        return zzafaVar.zzb(this.f12504d, this.f12502b, this.f12503c);
    }

    @Override // com.google.android.gms.internal.ads.un
    public final /* synthetic */ zzadf a(zzxw zzxwVar) throws RemoteException {
        return zzxwVar.createNativeAdViewDelegate(ObjectWrapper.a(this.f12502b), ObjectWrapper.a(this.f12503c));
    }
}

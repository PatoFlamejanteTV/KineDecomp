package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
final class tn extends un<zzauw> {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Context f12568b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzalg f12569c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzwj f12570d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public tn(zzwj zzwjVar, Context context, zzalg zzalgVar) {
        this.f12570d = zzwjVar;
        this.f12568b = context;
        this.f12569c = zzalgVar;
    }

    @Override // com.google.android.gms.internal.ads.un
    protected final /* synthetic */ zzauw a() {
        zzwj.zza(this.f12568b, "rewarded_video");
        return new zzzq();
    }

    @Override // com.google.android.gms.internal.ads.un
    public final /* synthetic */ zzauw b() throws RemoteException {
        zzavf zzavfVar;
        zzavfVar = this.f12570d.zzckv;
        return zzavfVar.zza(this.f12568b, this.f12569c);
    }

    @Override // com.google.android.gms.internal.ads.un
    public final /* synthetic */ zzauw a(zzxw zzxwVar) throws RemoteException {
        return zzxwVar.createRewardedVideoAd(ObjectWrapper.a(this.f12568b), this.f12569c, 14300000);
    }
}

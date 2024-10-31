package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.ads.ad, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC0826ad implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzalj f12054a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzwb f12055b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzavs f12056c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzavk f12057d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0826ad(zzavk zzavkVar, zzalj zzaljVar, zzwb zzwbVar, zzavs zzavsVar) {
        this.f12057d = zzavkVar;
        this.f12054a = zzaljVar;
        this.f12055b = zzwbVar;
        this.f12056c = zzavsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        String str;
        try {
            zzalj zzaljVar = this.f12054a;
            context = this.f12057d.mContext;
            IObjectWrapper a2 = ObjectWrapper.a(context);
            zzwb zzwbVar = this.f12055b;
            zzavs zzavsVar = this.f12056c;
            str = this.f12057d.zzeer;
            zzaljVar.zza(a2, zzwbVar, (String) null, zzavsVar, str);
        } catch (RemoteException e2) {
            String valueOf = String.valueOf(this.f12057d.zzdml);
            zzbbd.zzc(valueOf.length() != 0 ? "Fail to initialize adapter ".concat(valueOf) : new String("Fail to initialize adapter "), e2);
            zzavk zzavkVar = this.f12057d;
            zzavkVar.zza(zzavkVar.zzdml, 0);
        }
    }
}

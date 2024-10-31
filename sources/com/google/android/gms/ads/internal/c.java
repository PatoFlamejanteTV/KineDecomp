package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzct;
import com.google.android.gms.internal.ads.zzcu;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class C implements Callable<zzcu> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbp f9987a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(zzbp zzbpVar) {
        this.f9987a = zzbpVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzcu call() throws Exception {
        zzbbi zzbbiVar;
        Context context;
        zzbbiVar = this.f9987a.f10233a;
        String str = zzbbiVar.zzdp;
        context = this.f9987a.f10236d;
        return new zzcu(zzct.zza(str, context, false));
    }
}

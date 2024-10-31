package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.request.zzc;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzby;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements zzc.a {

    /* renamed from: a */
    final /* synthetic */ Context f628a;

    public c(Context context) {
        this.f628a = context;
    }

    @Override // com.google.android.gms.ads.internal.request.zzc.a
    public boolean a(AdRequestInfoParcel adRequestInfoParcel) {
        return adRequestInfoParcel.k.e || (GooglePlayServicesUtil.g(this.f628a) && !zzby.zzuL.get().booleanValue());
    }
}

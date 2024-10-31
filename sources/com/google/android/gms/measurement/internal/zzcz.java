package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzcz {

    /* renamed from: a */
    final Context f13995a;

    /* renamed from: b */
    String f13996b;

    /* renamed from: c */
    String f13997c;

    /* renamed from: d */
    String f13998d;

    /* renamed from: e */
    boolean f13999e;

    /* renamed from: f */
    Boolean f14000f;

    /* renamed from: g */
    zzan f14001g;

    @VisibleForTesting
    public zzcz(Context context, zzan zzanVar) {
        this.f13999e = true;
        Preconditions.a(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.a(applicationContext);
        this.f13995a = applicationContext;
        if (zzanVar != null) {
            this.f14001g = zzanVar;
            this.f13996b = zzanVar.f13925f;
            this.f13997c = zzanVar.f13924e;
            this.f13998d = zzanVar.f13923d;
            this.f13999e = zzanVar.f13922c;
            Bundle bundle = zzanVar.f13926g;
            if (bundle != null) {
                this.f14000f = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}

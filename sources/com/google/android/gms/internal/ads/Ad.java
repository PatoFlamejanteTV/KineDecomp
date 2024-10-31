package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import java.util.List;

/* loaded from: classes2.dex */
public final class Ad implements zzabl {

    /* renamed from: a */
    private final /* synthetic */ List f11372a;

    /* renamed from: b */
    private final /* synthetic */ zzabk f11373b;

    /* renamed from: c */
    private final /* synthetic */ Context f11374c;

    public Ad(zzayh zzayhVar, List list, zzabk zzabkVar, Context context) {
        this.f11372a = list;
        this.f11373b = zzabkVar;
        this.f11374c = context;
    }

    @Override // com.google.android.gms.internal.ads.zzabl
    public final void zzrm() {
        for (String str : this.f11372a) {
            String valueOf = String.valueOf(str);
            zzbbd.zzen(valueOf.length() != 0 ? "Pinging url: ".concat(valueOf) : new String("Pinging url: "));
            this.f11373b.mayLaunchUrl(Uri.parse(str), null, null);
        }
        this.f11373b.zzc((Activity) this.f11374c);
    }

    @Override // com.google.android.gms.internal.ads.zzabl
    public final void zzrn() {
    }
}

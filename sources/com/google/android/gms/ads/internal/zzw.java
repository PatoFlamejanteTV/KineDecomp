package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzaso;
import com.google.android.gms.internal.ads.zzawr;
import com.google.android.gms.internal.ads.zzayh;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzw {

    /* renamed from: a */
    private final Context f10268a;

    /* renamed from: b */
    private boolean f10269b;

    /* renamed from: c */
    private zzawr f10270c;

    /* renamed from: d */
    private zzaso f10271d;

    public zzw(Context context, zzawr zzawrVar, zzaso zzasoVar) {
        this.f10268a = context;
        this.f10270c = zzawrVar;
        this.f10271d = zzasoVar;
        if (this.f10271d == null) {
            this.f10271d = new zzaso();
        }
    }

    private final boolean c() {
        zzawr zzawrVar = this.f10270c;
        return (zzawrVar != null && zzawrVar.zzxp().zzegm) || this.f10271d.zzdzg;
    }

    public final void a() {
        this.f10269b = true;
    }

    public final boolean b() {
        return !c() || this.f10269b;
    }

    public final void a(String str) {
        List<String> list;
        if (c()) {
            if (str == null) {
                str = "";
            }
            zzawr zzawrVar = this.f10270c;
            if (zzawrVar != null) {
                zzawrVar.zza(str, null, 3);
                return;
            }
            zzaso zzasoVar = this.f10271d;
            if (!zzasoVar.zzdzg || (list = zzasoVar.zzdzh) == null) {
                return;
            }
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    String replace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                    zzbv.e();
                    zzayh.zzc(this.f10268a, "", replace);
                }
            }
        }
    }
}

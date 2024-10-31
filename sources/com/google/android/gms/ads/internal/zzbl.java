package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzwb;
import java.lang.ref.WeakReference;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbl {

    /* renamed from: a */
    private final zzbn f10226a;

    /* renamed from: b */
    private final Runnable f10227b;

    /* renamed from: c */
    private zzwb f10228c;

    /* renamed from: d */
    private boolean f10229d;

    /* renamed from: e */
    private boolean f10230e;

    /* renamed from: f */
    private long f10231f;

    public zzbl(zza zzaVar) {
        this(zzaVar, new zzbn(zzayh.zzelc));
    }

    public final void a(zzwb zzwbVar) {
        this.f10228c = zzwbVar;
    }

    public final void b() {
        this.f10230e = true;
        if (this.f10229d) {
            this.f10226a.a(this.f10227b);
        }
    }

    public final void c() {
        this.f10230e = false;
        if (this.f10229d) {
            this.f10229d = false;
            a(this.f10228c, this.f10231f);
        }
    }

    public final void d() {
        Bundle bundle;
        this.f10230e = false;
        this.f10229d = false;
        zzwb zzwbVar = this.f10228c;
        if (zzwbVar != null && (bundle = zzwbVar.extras) != null) {
            bundle.remove("_ad");
        }
        a(this.f10228c, 0L);
    }

    public final boolean e() {
        return this.f10229d;
    }

    @VisibleForTesting
    private zzbl(zza zzaVar, zzbn zzbnVar) {
        this.f10229d = false;
        this.f10230e = false;
        this.f10231f = 0L;
        this.f10226a = zzbnVar;
        this.f10227b = new z(this, new WeakReference(zzaVar));
    }

    public final void a() {
        this.f10229d = false;
        this.f10226a.a(this.f10227b);
    }

    public final void a(zzwb zzwbVar, long j) {
        if (this.f10229d) {
            zzbbd.zzeo("An ad refresh is already scheduled.");
            return;
        }
        this.f10228c = zzwbVar;
        this.f10229d = true;
        this.f10231f = j;
        if (this.f10230e) {
            return;
        }
        StringBuilder sb = new StringBuilder(65);
        sb.append("Scheduling ad refresh ");
        sb.append(j);
        sb.append(" milliseconds from now.");
        zzbbd.zzen(sb.toString());
        this.f10226a.a(this.f10227b, j);
    }

    public final void b(zzwb zzwbVar) {
        a(zzwbVar, 60000L);
    }

    public static /* synthetic */ boolean a(zzbl zzblVar, boolean z) {
        zzblVar.f10229d = false;
        return false;
    }
}

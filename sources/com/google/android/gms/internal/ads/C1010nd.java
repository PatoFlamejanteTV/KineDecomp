package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.util.Clock;

@zzark
/* renamed from: com.google.android.gms.internal.ads.nd */
/* loaded from: classes2.dex */
public final class C1010nd {

    /* renamed from: a */
    private long f12346a = -1;

    /* renamed from: b */
    private long f12347b = -1;

    /* renamed from: c */
    private final /* synthetic */ zzaxh f12348c;

    public C1010nd(zzaxh zzaxhVar) {
        this.f12348c = zzaxhVar;
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.f12346a);
        bundle.putLong("tclose", this.f12347b);
        return bundle;
    }

    public final long b() {
        return this.f12347b;
    }

    public final void c() {
        Clock clock;
        clock = this.f12348c.zzehz;
        this.f12347b = clock.c();
    }

    public final void d() {
        Clock clock;
        clock = this.f12348c.zzehz;
        this.f12346a = clock.c();
    }
}

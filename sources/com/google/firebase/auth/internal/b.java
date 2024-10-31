package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

/* loaded from: classes2.dex */
public final class b implements BackgroundDetector.BackgroundStateChangeListener {

    /* renamed from: a */
    private final /* synthetic */ zzae f16497a;

    public b(zzae zzaeVar) {
        this.f16497a = zzaeVar;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void a(boolean z) {
        boolean b2;
        zzs zzsVar;
        if (z) {
            this.f16497a.f16513d = true;
            this.f16497a.a();
            return;
        }
        this.f16497a.f16513d = false;
        b2 = this.f16497a.b();
        if (b2) {
            zzsVar = this.f16497a.f16512c;
            zzsVar.b();
        }
    }
}

package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
final class f extends zzaj {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ e f12749a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f12749a = eVar;
    }

    @Override // com.google.android.gms.internal.auth.zzaj, com.google.android.gms.internal.auth.zzal
    public final void zzb(String str) {
        if (str != null) {
            this.f12749a.a((e) new zzax(str));
        } else {
            this.f12749a.a((e) b.d(new Status(3006)));
        }
    }
}

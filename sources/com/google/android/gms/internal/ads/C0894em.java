package com.google.android.gms.internal.ads;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.em */
/* loaded from: classes2.dex */
public final class C0894em extends ContentObserver {

    /* renamed from: a */
    private final /* synthetic */ zzrg f12151a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0894em(zzrg zzrgVar, Handler handler) {
        super(handler);
        this.f12151a = zzrgVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        super.onChange(z);
        this.f12151a.zzmw();
    }
}

package com.google.android.gms.internal.clearcut;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: com.google.android.gms.internal.clearcut.a */
/* loaded from: classes2.dex */
public final class C1187a extends ContentObserver {

    /* renamed from: a */
    private final /* synthetic */ zzab f12821a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1187a(zzab zzabVar, Handler handler) {
        super(null);
        this.f12821a = zzabVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.f12821a.zzh();
        this.f12821a.zzj();
    }
}

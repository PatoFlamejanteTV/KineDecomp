package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.google.android.gms.internal.ads.y, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1159y implements zzacb {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ View f12674a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzacr f12675b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1159y(zzacr zzacrVar, View view) {
        this.f12675b = zzacrVar;
        this.f12674a = view;
    }

    @Override // com.google.android.gms.internal.ads.zzacb
    public final void zzc(MotionEvent motionEvent) {
        this.f12675b.onTouch(null, motionEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzacb
    public final void zzsh() {
        this.f12675b.onClick(this.f12674a);
    }
}

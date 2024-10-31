package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes2.dex */
final class Tf implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzawr f11846a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzbhu f11847b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tf(zzbhu zzbhuVar, zzawr zzawrVar) {
        this.f11847b = zzbhuVar;
        this.f11846a = zzawrVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f11847b.zza(view, this.f11846a, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}

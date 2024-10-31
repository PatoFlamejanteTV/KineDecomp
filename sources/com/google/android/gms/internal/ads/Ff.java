package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes2.dex */
final class Ff implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzawr f11529a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzbgh f11530b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ff(zzbgh zzbghVar, zzawr zzawrVar) {
        this.f11530b = zzbghVar;
        this.f11529a = zzawrVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f11530b.zza(view, this.f11529a, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}

package com.google.android.gms.internal.ads;

import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.jc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class ViewTreeObserverOnGlobalLayoutListenerC0953jc implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ WeakReference f12217a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzaqf f12218b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserverOnGlobalLayoutListenerC0953jc(zzaqf zzaqfVar, WeakReference weakReference) {
        this.f12218b = zzaqfVar;
        this.f12217a = weakReference;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f12218b.zza((WeakReference<zzbgg>) this.f12217a, false);
    }
}

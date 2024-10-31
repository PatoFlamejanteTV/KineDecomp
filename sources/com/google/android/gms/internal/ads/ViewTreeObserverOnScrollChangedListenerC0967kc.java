package com.google.android.gms.internal.ads;

import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.kc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class ViewTreeObserverOnScrollChangedListenerC0967kc implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ WeakReference f12253a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzaqf f12254b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserverOnScrollChangedListenerC0967kc(zzaqf zzaqfVar, WeakReference weakReference) {
        this.f12254b = zzaqfVar;
        this.f12253a = weakReference;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        this.f12254b.zza((WeakReference<zzbgg>) this.f12253a, true);
    }
}

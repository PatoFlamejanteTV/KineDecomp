package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

@zzark
/* renamed from: com.google.android.gms.internal.ads.ze */
/* loaded from: classes2.dex */
final class ViewTreeObserverOnGlobalLayoutListenerC1178ze extends Be implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b */
    private final WeakReference<ViewTreeObserver.OnGlobalLayoutListener> f12701b;

    public ViewTreeObserverOnGlobalLayoutListenerC1178ze(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.f12701b = new WeakReference<>(onGlobalLayoutListener);
    }

    @Override // com.google.android.gms.internal.ads.Be
    protected final void a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    @Override // com.google.android.gms.internal.ads.Be
    protected final void b(ViewTreeObserver viewTreeObserver) {
        com.google.android.gms.ads.internal.zzbv.g().zza(viewTreeObserver, this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f12701b.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            b();
        }
    }
}

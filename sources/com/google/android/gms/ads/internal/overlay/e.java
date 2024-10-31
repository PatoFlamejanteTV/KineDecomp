package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Drawable f10111a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ d f10112b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, Drawable drawable) {
        this.f10112b = dVar;
        this.f10111a = drawable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10112b.f10110a.f10127b.getWindow().setBackgroundDrawable(this.f10111a);
    }
}

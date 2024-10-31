package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;
import com.google.android.gms.ads.internal.overlay.zzd;

/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Drawable f598a;
    final /* synthetic */ zzd.b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(zzd.b bVar, Drawable drawable) {
        this.b = bVar;
        this.f598a = drawable;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzd.this.n.getWindow().setBackgroundDrawable(this.f598a);
    }
}

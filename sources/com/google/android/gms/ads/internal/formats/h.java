package com.google.android.gms.ads.internal.formats;

import android.widget.FrameLayout;
import com.google.android.gms.internal.zziz;

/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzh f571a;
    final /* synthetic */ zzj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(zzj zzjVar, zzh zzhVar) {
        this.b = zzjVar;
        this.f571a = zzhVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        zziz c = this.f571a.c();
        if (c != null) {
            frameLayout = this.b.f;
            frameLayout.addView(c.getView());
        }
    }
}

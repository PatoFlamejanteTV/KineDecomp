package com.flurry.sdk;

import android.widget.Toast;

/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f484a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, int i) {
        this.b = hVar;
        this.f484a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(ad.a().b(), "SD HTTP Response Code: " + this.f484a, 0).show();
    }
}

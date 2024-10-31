package com.google.android.gms.gcm;

import android.content.Intent;

/* loaded from: classes.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f1412a;
    final /* synthetic */ GcmListenerService b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GcmListenerService gcmListenerService, Intent intent) {
        this.b = gcmListenerService;
        this.f1412a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.f1412a);
    }
}

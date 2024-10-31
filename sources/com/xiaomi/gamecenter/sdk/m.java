package com.xiaomi.gamecenter.sdk;

import android.app.AlertDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AlertDialog.Builder f4900a;
    final /* synthetic */ MiCommplatform b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(MiCommplatform miCommplatform, AlertDialog.Builder builder) {
        this.b = miCommplatform;
        this.f4900a = builder;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4900a.show();
    }
}

package com.xiaomi.gamecenter.sdk;

import android.app.AlertDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AlertDialog.Builder f26611a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f26612b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(MiCommplatform miCommplatform, AlertDialog.Builder builder) {
        this.f26612b = miCommplatform;
        this.f26611a = builder;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f26611a.show();
    }
}

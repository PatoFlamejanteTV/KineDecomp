package com.xiaomi.gamecenter.sdk;

import com.xiaomi.gamecenter.sdk.entry.MiAppInfo;

/* loaded from: classes3.dex */
class y extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ x f26645a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.f26645a = xVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        MiAppInfo miAppInfo;
        MiCommplatform miCommplatform = this.f26645a.f26644a;
        miAppInfo = miCommplatform.appInfo;
        miCommplatform.openApp(miAppInfo);
    }
}

package com.xiaomi.gamecenter.sdk;

import com.xiaomi.gamecenter.sdk.entry.MiAppInfo;

/* loaded from: classes.dex */
class y extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ x f4914a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.f4914a = xVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        MiAppInfo miAppInfo;
        MiCommplatform miCommplatform = this.f4914a.f4913a;
        miAppInfo = this.f4914a.f4913a.appInfo;
        miCommplatform.openApp(miAppInfo);
    }
}

package com.xiaomi.gamecenter.sdk;

import com.xiaomi.gamecenter.sdk.entry.MiAccountInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements OnLoginProcessListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ag f4886a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar) {
        this.f4886a = agVar;
    }

    @Override // com.xiaomi.gamecenter.sdk.OnLoginProcessListener
    public void finishLoginProcess(int i, MiAccountInfo miAccountInfo) {
        Object obj;
        Object obj2;
        if (i == 0 && miAccountInfo != null) {
            this.f4886a.c = String.valueOf(miAccountInfo.getUid());
        }
        obj = this.f4886a.f4883a;
        synchronized (obj) {
            obj2 = this.f4886a.f4883a;
            obj2.notifyAll();
        }
    }
}

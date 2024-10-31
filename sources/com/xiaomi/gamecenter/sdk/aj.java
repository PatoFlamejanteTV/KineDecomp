package com.xiaomi.gamecenter.sdk;

import com.xiaomi.gamecenter.sdk.entry.MiAccountInfo;

/* loaded from: classes3.dex */
public class aj implements OnLoginProcessListener {

    /* renamed from: a */
    final /* synthetic */ ag f26580a;

    public aj(ag agVar) {
        this.f26580a = agVar;
    }

    @Override // com.xiaomi.gamecenter.sdk.OnLoginProcessListener
    public void finishLoginProcess(int i, MiAccountInfo miAccountInfo) {
        Object obj;
        Object obj2;
        if (i == 0 && miAccountInfo != null) {
            this.f26580a.f26571c = String.valueOf(miAccountInfo.getUid());
        }
        obj = this.f26580a.f26570a;
        synchronized (obj) {
            obj2 = this.f26580a.f26570a;
            obj2.notifyAll();
        }
    }
}

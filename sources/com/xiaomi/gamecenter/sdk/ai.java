package com.xiaomi.gamecenter.sdk;

/* loaded from: classes3.dex */
class ai implements OnPayProcessListener {

    /* renamed from: a */
    final /* synthetic */ ah f26579a;

    public ai(ah ahVar) {
        this.f26579a = ahVar;
    }

    @Override // com.xiaomi.gamecenter.sdk.OnPayProcessListener
    public void finishPayProcess(int i) {
        Object obj;
        Object obj2;
        if (i == 0) {
            this.f26579a.f26578c.f26573e = 0;
        } else {
            this.f26579a.f26578c.f26573e = i;
        }
        obj = this.f26579a.f26578c.f26570a;
        synchronized (obj) {
            obj2 = this.f26579a.f26578c.f26570a;
            obj2.notifyAll();
        }
    }
}

package com.xiaomi.gamecenter.sdk;

/* loaded from: classes.dex */
class ai implements OnPayProcessListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ah f4885a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.f4885a = ahVar;
    }

    @Override // com.xiaomi.gamecenter.sdk.OnPayProcessListener
    public void finishPayProcess(int i) {
        Object obj;
        Object obj2;
        if (i == 0) {
            this.f4885a.c.e = 0;
        } else {
            this.f4885a.c.e = i;
        }
        obj = this.f4885a.c.f4883a;
        synchronized (obj) {
            obj2 = this.f4885a.c.f4883a;
            obj2.notifyAll();
        }
    }
}

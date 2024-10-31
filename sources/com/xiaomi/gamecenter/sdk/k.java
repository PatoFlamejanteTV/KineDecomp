package com.xiaomi.gamecenter.sdk;

import android.content.DialogInterface;

/* loaded from: classes.dex */
class k implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f4898a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.f4898a = hVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Object obj;
        Object obj2;
        Object obj3;
        this.f4898a.c.service_isntall_ask = 1;
        obj = this.f4898a.c._check_service_lock_;
        if (obj != null) {
            obj2 = this.f4898a.c._check_service_lock_;
            synchronized (obj2) {
                obj3 = this.f4898a.c._check_service_lock_;
                obj3.notifyAll();
            }
        }
    }
}

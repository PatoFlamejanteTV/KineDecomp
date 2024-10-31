package com.xiaomi.gamecenter.sdk;

import android.content.DialogInterface;

/* loaded from: classes.dex */
class i implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f4896a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f4896a = hVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Object obj;
        Object obj2;
        this.f4896a.c.service_isntall_ask = 2;
        obj = this.f4896a.c._check_service_lock_;
        synchronized (obj) {
            obj2 = this.f4896a.c._check_service_lock_;
            obj2.notifyAll();
        }
    }
}

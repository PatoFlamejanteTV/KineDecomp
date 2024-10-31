package com.xiaomi.gamecenter.sdk;

import android.content.DialogInterface;

/* loaded from: classes3.dex */
class i implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f26607a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f26607a = hVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Object obj;
        Object obj2;
        this.f26607a.f26606c.service_isntall_ask = 2;
        obj = this.f26607a.f26606c._check_service_lock_;
        synchronized (obj) {
            obj2 = this.f26607a.f26606c._check_service_lock_;
            obj2.notifyAll();
        }
    }
}

package com.xiaomi.gamecenter.sdk;

import android.content.DialogInterface;

/* loaded from: classes3.dex */
class j implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f26608a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.f26608a = hVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Object obj;
        Object obj2;
        Object obj3;
        this.f26608a.f26606c.service_isntall_ask = 2;
        obj = this.f26608a.f26606c._check_service_lock_;
        if (obj != null) {
            obj2 = this.f26608a.f26606c._check_service_lock_;
            synchronized (obj2) {
                obj3 = this.f26608a.f26606c._check_service_lock_;
                obj3.notifyAll();
            }
        }
    }
}

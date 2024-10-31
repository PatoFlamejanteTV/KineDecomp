package com.xiaomi.licensinglibrary;

import android.content.DialogInterface;

/* loaded from: classes.dex */
class f implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f4921a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.f4921a = cVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4921a.f4918a.reportLog("buy_license_begin");
        this.f4921a.f4918a.mValidatorHandler.removeMessages(4);
        this.f4921a.f4918a.mValidatorHandler.sendEmptyMessage(4);
    }
}

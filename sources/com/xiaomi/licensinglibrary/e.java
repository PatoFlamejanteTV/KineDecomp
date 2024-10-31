package com.xiaomi.licensinglibrary;

import android.content.DialogInterface;

/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f4920a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.f4920a = cVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4920a.f4918a.mCallback.dontAllow(LicenseErrCode.LICENSE_STATUS_NOT_LICENSED);
        this.f4920a.f4918a.reportLog("buy_license_confirm_canceled");
    }
}

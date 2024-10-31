package com.xiaomi.licensinglibrary;

import android.content.DialogInterface;

/* loaded from: classes.dex */
class d implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f4919a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f4919a = cVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f4919a.f4918a.mCallback.dontAllow(LicenseErrCode.LICENSE_STATUS_NOT_LICENSED);
        this.f4919a.f4918a.reportLog("buy_license_confirm_canceled");
    }
}

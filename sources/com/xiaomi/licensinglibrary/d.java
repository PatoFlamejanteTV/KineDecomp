package com.xiaomi.licensinglibrary;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ c f26652a;

    public d(c cVar) {
        this.f26652a = cVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        LicenseCheckerCallback licenseCheckerCallback;
        licenseCheckerCallback = this.f26652a.f26649a.mCallback;
        licenseCheckerCallback.dontAllow(1000);
        this.f26652a.f26649a.reportLog("buy_license_confirm_canceled");
    }
}

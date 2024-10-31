package com.xiaomi.licensinglibrary;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ c f26653a;

    public e(c cVar) {
        this.f26653a = cVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        LicenseCheckerCallback licenseCheckerCallback;
        licenseCheckerCallback = this.f26653a.f26649a.mCallback;
        licenseCheckerCallback.dontAllow(1000);
        this.f26653a.f26649a.reportLog("buy_license_confirm_canceled");
    }
}

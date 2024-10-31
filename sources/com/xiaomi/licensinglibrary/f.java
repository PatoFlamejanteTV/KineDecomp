package com.xiaomi.licensinglibrary;

import android.content.DialogInterface;

/* loaded from: classes3.dex */
class f implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f26654a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.f26654a = cVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f26654a.f26649a.reportLog("buy_license_begin");
        LicenseChecker.access$200(this.f26654a.f26649a).removeMessages(4);
        LicenseChecker.access$200(this.f26654a.f26649a).sendEmptyMessage(4);
    }
}

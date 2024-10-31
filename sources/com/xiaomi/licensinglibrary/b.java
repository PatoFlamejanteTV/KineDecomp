package com.xiaomi.licensinglibrary;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.licensinglibrary.ILicenseService;

/* loaded from: classes3.dex */
class b implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LicenseChecker f26648a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LicenseChecker licenseChecker) {
        this.f26648a = licenseChecker;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        LicenseChecker.access$102(this.f26648a, ILicenseService.Stub.asInterface(iBinder));
        Message obtainMessage = LicenseChecker.access$200(this.f26648a).obtainMessage(1);
        LicenseChecker.access$200(this.f26648a).removeMessages(1);
        LicenseChecker.access$200(this.f26648a).sendMessage(obtainMessage);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        LicenseChecker.access$102(this.f26648a, null);
        LicenseChecker.access$302(this.f26648a, false);
    }
}

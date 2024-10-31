package com.xiaomi.licensinglibrary;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.licensinglibrary.ILicenseService;

/* loaded from: classes.dex */
class b implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LicenseChecker f4917a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LicenseChecker licenseChecker) {
        this.f4917a = licenseChecker;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f4917a.mService = ILicenseService.Stub.asInterface(iBinder);
        Message obtainMessage = this.f4917a.mValidatorHandler.obtainMessage(1);
        this.f4917a.mValidatorHandler.removeMessages(1);
        this.f4917a.mValidatorHandler.sendMessage(obtainMessage);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f4917a.mService = null;
        this.f4917a.mChecking = false;
    }
}

package com.xiaomi.licensinglibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.gamecenter.sdk.MiCommplatform;
import com.xiaomi.gamecenter.sdk.ag;
import com.xiaomi.gamecenter.sdk.ak;
import com.xiaomi.gamecenter.sdk.al;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class g extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LicenseChecker f26655a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(LicenseChecker licenseChecker, Looper looper) {
        super(looper);
        this.f26655a = licenseChecker;
    }

    private void a() {
        ak akVar;
        Activity activity;
        ILicenseService iLicenseService;
        Activity activity2;
        ServiceConnection serviceConnection;
        ak akVar2;
        g gVar;
        g gVar2;
        LicenseCheckerCallback licenseCheckerCallback;
        akVar = this.f26655a.mValidator;
        if (akVar == null) {
            return;
        }
        MiCommplatform miCommplatform = MiCommplatform.getInstance();
        activity = this.f26655a.mActivity;
        if (!miCommplatform.newSDKInstalled(activity)) {
            Log.e("MiGameSDK", "New version SDK installed failed.");
        }
        iLicenseService = this.f26655a.mService;
        if (iLicenseService != null) {
            removeMessages(1);
            sendEmptyMessage(1);
            return;
        }
        try {
            Intent intent = new Intent("com.xiaomi.licensinglibrary.authfileinfo");
            intent.setPackage("com.xiaomi.gamecenter.sdk.service");
            activity2 = this.f26655a.mActivity;
            Context applicationContext = activity2.getApplicationContext();
            serviceConnection = this.f26655a.mValidatorServiceConn;
            if (applicationContext.bindService(intent, serviceConnection, 1)) {
                return;
            }
            Log.e("MiGameSDK", "Could not bind to service.");
            LicenseChecker licenseChecker = this.f26655a;
            akVar2 = this.f26655a.mValidator;
            licenseChecker.handleServiceConnectionError(akVar2);
            gVar = this.f26655a.mValidatorHandler;
            Message obtainMessage = gVar.obtainMessage(5, 1002, 0);
            gVar2 = this.f26655a.mValidatorHandler;
            gVar2.sendMessage(obtainMessage);
            licenseCheckerCallback = this.f26655a.mCallback;
            licenseCheckerCallback.applicationError(1002);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(String str, String str2) {
        Activity activity;
        Activity activity2;
        ILicenseService iLicenseService;
        Activity activity3;
        try {
            String str3 = "firstRunOnthisDevice_" + str;
            activity = this.f26655a.mActivity;
            if (al.a(activity, str3)) {
                return;
            }
            ag a2 = ag.a();
            activity2 = this.f26655a.mActivity;
            iLicenseService = this.f26655a.mService;
            if (a2.a(activity2, str2, iLicenseService).getInt("errcode") == 5004) {
                this.f26655a.reportLog("server_verify_success_newDevice_bind");
            }
            activity3 = this.f26655a.mActivity;
            al.a(activity3, str3, true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(boolean z, int i) {
        ak akVar;
        ak akVar2;
        LicenseCheckerCallback licenseCheckerCallback;
        ak akVar3;
        LicenseCheckerCallback licenseCheckerCallback2;
        ILicenseService iLicenseService;
        ak akVar4;
        Activity activity;
        Activity activity2;
        Activity activity3;
        String str;
        ILicenseService iLicenseService2;
        g gVar;
        g gVar2;
        Activity activity4;
        LicenseCheckerCallback licenseCheckerCallback3;
        Activity activity5;
        ak akVar5;
        Activity activity6;
        LicenseCheckerCallback licenseCheckerCallback4;
        Activity activity7;
        ILicenseService iLicenseService3;
        ILicenseService iLicenseService4;
        LicenseCheckerCallback licenseCheckerCallback5;
        LicenseCheckerCallback licenseCheckerCallback6;
        akVar = this.f26655a.mValidator;
        if (akVar != null) {
            try {
                iLicenseService = this.f26655a.mService;
                Bundle a2 = iLicenseService.a();
                akVar4 = this.f26655a.mValidator;
                if (akVar4.a(a2)) {
                    licenseCheckerCallback6 = this.f26655a.mCallback;
                    licenseCheckerCallback6.allow(0);
                    this.f26655a.reportLog("local_verify_success");
                    return;
                }
                String string = a2.getString("mid");
                String str2 = null;
                if (TextUtils.isEmpty(string)) {
                    ag a3 = ag.a();
                    activity7 = this.f26655a.mActivity;
                    iLicenseService3 = this.f26655a.mService;
                    str2 = a3.b(activity7, iLicenseService3);
                    if (TextUtils.isEmpty(str2)) {
                        this.f26655a.reportLog("server_verify_noxiaomiaccount");
                        licenseCheckerCallback5 = this.f26655a.mCallback;
                        licenseCheckerCallback5.applicationError(LicenseErrCode.ERROR_NO_XIAOMI_ACCOUNT);
                        return;
                    } else {
                        iLicenseService4 = this.f26655a.mService;
                        a2 = iLicenseService4.a();
                        string = a2.getString("mid");
                    }
                }
                a(string, str2);
                activity = this.f26655a.mActivity;
                String packageName = activity.getPackageName();
                activity2 = this.f26655a.mActivity;
                PackageManager packageManager = activity2.getPackageManager();
                activity3 = this.f26655a.mActivity;
                int i2 = packageManager.getPackageInfo(activity3.getPackageName(), 0).versionCode;
                Bundle bundle = new Bundle();
                bundle.putString("pkgName", packageName);
                str = this.f26655a.mAppId;
                bundle.putString("appId", str);
                bundle.putInt("versionCode", i2);
                bundle.putInt("validatorsdkvc", 150);
                iLicenseService2 = this.f26655a.mService;
                Bundle a4 = iLicenseService2.a(bundle);
                int i3 = a4.getInt("errcode");
                if (i3 == 200) {
                    akVar5 = this.f26655a.mValidator;
                    if (akVar5.a(a4, a2)) {
                        this.f26655a.reportLog("server_verify_success");
                        activity6 = this.f26655a.mActivity;
                        activity6.runOnUiThread(new i(this));
                        licenseCheckerCallback4 = this.f26655a.mCallback;
                        licenseCheckerCallback4.allow(0);
                        return;
                    }
                    this.f26655a.reportLog("server_verify_failed");
                } else if (i3 == 4002) {
                    gVar = this.f26655a.mValidatorHandler;
                    Message obtainMessage = gVar.obtainMessage(5, LicenseErrCode.ERROR_NETWORK_ERROR, 0);
                    gVar2 = this.f26655a.mValidatorHandler;
                    gVar2.sendMessage(obtainMessage);
                    this.f26655a.reportLog("server_verify_networkerror");
                    activity4 = this.f26655a.mActivity;
                    activity4.runOnUiThread(new j(this));
                    licenseCheckerCallback3 = this.f26655a.mCallback;
                    licenseCheckerCallback3.applicationError(LicenseErrCode.ERROR_NETWORK_ERROR);
                    return;
                }
                if (!z || i >= 30) {
                    activity5 = this.f26655a.mActivity;
                    activity5.runOnUiThread(new k(this));
                    return;
                }
                Log.e("MiGameSDK", "handle_Msg_RunChecks count:" + i);
                removeMessages(1);
                Message obtainMessage2 = obtainMessage(1);
                obtainMessage2.obj = true;
                obtainMessage2.arg1 = i + 1;
                sendMessageDelayed(obtainMessage2, 2000L);
            } catch (RemoteException e2) {
                this.f26655a.reportLog("license_verify_remoteException");
                Log.w("MiGameSDK", "RemoteException in checkLicense call.", e2);
                LicenseChecker licenseChecker = this.f26655a;
                akVar3 = licenseChecker.mValidator;
                licenseChecker.handleServiceConnectionError(akVar3);
                licenseCheckerCallback2 = this.f26655a.mCallback;
                licenseCheckerCallback2.applicationError(LicenseErrCode.ERROR_CHACK_LICENSE_EXCEPTION);
            } catch (Exception e3) {
                this.f26655a.reportLog("license_verify_Exception");
                LicenseChecker licenseChecker2 = this.f26655a;
                akVar2 = licenseChecker2.mValidator;
                licenseChecker2.handleServiceConnectionError(akVar2);
                licenseCheckerCallback = this.f26655a.mCallback;
                licenseCheckerCallback.applicationError(LicenseErrCode.ERROR_CHACK_LICENSE_EXCEPTION);
                e3.printStackTrace();
            }
        }
    }

    private void b() {
        Activity activity;
        ILicenseService iLicenseService;
        Activity activity2;
        g gVar;
        g gVar2;
        LicenseCheckerCallback licenseCheckerCallback;
        try {
            ag a2 = ag.a();
            activity = this.f26655a.mActivity;
            iLicenseService = this.f26655a.mService;
            int a3 = a2.a(activity, iLicenseService);
            Log.e("MiGameSDK", "handle_Msg_BUY_GAME ret:" + a3);
            this.f26655a.reportLog("buy_license_ret_" + a3);
            if (a3 != 0 && a3 != 5004) {
                gVar = this.f26655a.mValidatorHandler;
                Message obtainMessage = gVar.obtainMessage(5, a3, 0);
                gVar2 = this.f26655a.mValidatorHandler;
                gVar2.sendMessage(obtainMessage);
                licenseCheckerCallback = this.f26655a.mCallback;
                licenseCheckerCallback.dontAllow(1000);
            }
            removeMessages(1);
            Message obtainMessage2 = obtainMessage(1);
            obtainMessage2.obj = true;
            obtainMessage2.arg1 = 0;
            sendMessage(obtainMessage2);
            activity2 = this.f26655a.mActivity;
            activity2.runOnUiThread(new l(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Activity activity;
        int i = message.what;
        if (i == 1) {
            boolean z = false;
            int i2 = message.arg1;
            Object obj = message.obj;
            if (obj != null && (obj instanceof Boolean)) {
                z = ((Boolean) obj).booleanValue();
            }
            a(z, i2);
            return;
        }
        if (i == 3) {
            a();
            return;
        }
        if (i == 4) {
            b();
        } else {
            if (i != 5) {
                return;
            }
            int i3 = message.arg1;
            activity = this.f26655a.mActivity;
            activity.runOnUiThread(new h(this, i3));
        }
    }
}

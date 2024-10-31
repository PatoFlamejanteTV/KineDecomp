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
/* loaded from: classes.dex */
public class g extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LicenseChecker f4922a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(LicenseChecker licenseChecker, Looper looper) {
        super(looper);
        this.f4922a = licenseChecker;
    }

    private void a() {
        ak akVar;
        Activity activity;
        ILicenseService iLicenseService;
        Activity activity2;
        ServiceConnection serviceConnection;
        ak akVar2;
        akVar = this.f4922a.mValidator;
        if (akVar == null) {
            return;
        }
        MiCommplatform miCommplatform = MiCommplatform.getInstance();
        activity = this.f4922a.mActivity;
        if (!miCommplatform.newSDKInstalled(activity)) {
            Log.e("MiGameSDK", "New version SDK installed failed.");
        }
        iLicenseService = this.f4922a.mService;
        if (iLicenseService != null) {
            removeMessages(1);
            sendEmptyMessage(1);
            return;
        }
        try {
            Intent intent = new Intent("com.xiaomi.licensinglibrary.authfileinfo");
            intent.setPackage("com.xiaomi.gamecenter.sdk.service");
            activity2 = this.f4922a.mActivity;
            Context applicationContext = activity2.getApplicationContext();
            serviceConnection = this.f4922a.mValidatorServiceConn;
            if (applicationContext.bindService(intent, serviceConnection, 1)) {
                return;
            }
            Log.e("MiGameSDK", "Could not bind to service.");
            LicenseChecker licenseChecker = this.f4922a;
            akVar2 = this.f4922a.mValidator;
            licenseChecker.handleServiceConnectionError(akVar2);
            this.f4922a.mValidatorHandler.sendMessage(this.f4922a.mValidatorHandler.obtainMessage(5, LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE, 0));
            this.f4922a.mCallback.applicationError(LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(String str, String str2) {
        Activity activity;
        Activity activity2;
        ILicenseService iLicenseService;
        Activity activity3;
        try {
            String str3 = "firstRunOnthisDevice_" + str;
            activity = this.f4922a.mActivity;
            if (al.a(activity, str3)) {
                return;
            }
            ag a2 = ag.a();
            activity2 = this.f4922a.mActivity;
            iLicenseService = this.f4922a.mService;
            if (a2.a(activity2, str2, iLicenseService).getInt("errcode") == 5004) {
                this.f4922a.reportLog("server_verify_success_newDevice_bind");
            }
            activity3 = this.f4922a.mActivity;
            al.a(activity3, str3, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(boolean z, int i) {
        ak akVar;
        ak akVar2;
        ak akVar3;
        ILicenseService iLicenseService;
        ak akVar4;
        Activity activity;
        Activity activity2;
        Activity activity3;
        String str;
        ILicenseService iLicenseService2;
        Activity activity4;
        Activity activity5;
        ak akVar5;
        Activity activity6;
        Activity activity7;
        ILicenseService iLicenseService3;
        ILicenseService iLicenseService4;
        akVar = this.f4922a.mValidator;
        if (akVar != null) {
            try {
                iLicenseService = this.f4922a.mService;
                Bundle a2 = iLicenseService.a();
                akVar4 = this.f4922a.mValidator;
                if (akVar4.a(a2)) {
                    this.f4922a.mCallback.allow(0);
                    this.f4922a.reportLog("local_verify_success");
                    return;
                }
                String string = a2.getString("mid");
                String str2 = null;
                if (TextUtils.isEmpty(string)) {
                    ag a3 = ag.a();
                    activity7 = this.f4922a.mActivity;
                    iLicenseService3 = this.f4922a.mService;
                    str2 = a3.b(activity7, iLicenseService3);
                    if (TextUtils.isEmpty(str2)) {
                        this.f4922a.reportLog("server_verify_noxiaomiaccount");
                        this.f4922a.mCallback.applicationError(LicenseErrCode.ERROR_NO_XIAOMI_ACCOUNT);
                        return;
                    } else {
                        iLicenseService4 = this.f4922a.mService;
                        a2 = iLicenseService4.a();
                        string = a2.getString("mid");
                    }
                }
                a(string, str2);
                activity = this.f4922a.mActivity;
                String packageName = activity.getPackageName();
                activity2 = this.f4922a.mActivity;
                PackageManager packageManager = activity2.getPackageManager();
                activity3 = this.f4922a.mActivity;
                int i2 = packageManager.getPackageInfo(activity3.getPackageName(), 0).versionCode;
                Bundle bundle = new Bundle();
                bundle.putString("pkgName", packageName);
                str = this.f4922a.mAppId;
                bundle.putString("appId", str);
                bundle.putInt("versionCode", i2);
                bundle.putInt("validatorsdkvc", 150);
                iLicenseService2 = this.f4922a.mService;
                Bundle a4 = iLicenseService2.a(bundle);
                int i3 = a4.getInt("errcode");
                if (i3 == 200) {
                    akVar5 = this.f4922a.mValidator;
                    if (akVar5.a(a4, a2)) {
                        this.f4922a.reportLog("server_verify_success");
                        activity6 = this.f4922a.mActivity;
                        activity6.runOnUiThread(new i(this));
                        this.f4922a.mCallback.allow(0);
                        return;
                    }
                    this.f4922a.reportLog("server_verify_failed");
                } else if (i3 == 4002) {
                    this.f4922a.mValidatorHandler.sendMessage(this.f4922a.mValidatorHandler.obtainMessage(5, LicenseErrCode.ERROR_NETWORK_ERROR, 0));
                    this.f4922a.reportLog("server_verify_networkerror");
                    activity4 = this.f4922a.mActivity;
                    activity4.runOnUiThread(new j(this));
                    this.f4922a.mCallback.applicationError(LicenseErrCode.ERROR_NETWORK_ERROR);
                    return;
                }
                if (!z || i >= 30) {
                    activity5 = this.f4922a.mActivity;
                    activity5.runOnUiThread(new k(this));
                    return;
                }
                Log.e("MiGameSDK", "handle_Msg_RunChecks count:" + i);
                removeMessages(1);
                Message obtainMessage = obtainMessage(1);
                obtainMessage.obj = true;
                obtainMessage.arg1 = i + 1;
                sendMessageDelayed(obtainMessage, 2000L);
            } catch (RemoteException e) {
                this.f4922a.reportLog("license_verify_remoteException");
                Log.w("MiGameSDK", "RemoteException in checkLicense call.", e);
                LicenseChecker licenseChecker = this.f4922a;
                akVar3 = this.f4922a.mValidator;
                licenseChecker.handleServiceConnectionError(akVar3);
                this.f4922a.mCallback.applicationError(LicenseErrCode.ERROR_CHACK_LICENSE_EXCEPTION);
            } catch (Exception e2) {
                this.f4922a.reportLog("license_verify_Exception");
                LicenseChecker licenseChecker2 = this.f4922a;
                akVar2 = this.f4922a.mValidator;
                licenseChecker2.handleServiceConnectionError(akVar2);
                this.f4922a.mCallback.applicationError(LicenseErrCode.ERROR_CHACK_LICENSE_EXCEPTION);
                e2.printStackTrace();
            }
        }
    }

    private void b() {
        Activity activity;
        ILicenseService iLicenseService;
        Activity activity2;
        try {
            ag a2 = ag.a();
            activity = this.f4922a.mActivity;
            iLicenseService = this.f4922a.mService;
            int a3 = a2.a(activity, iLicenseService);
            Log.e("MiGameSDK", "handle_Msg_BUY_GAME ret:" + a3);
            this.f4922a.reportLog("buy_license_ret_" + a3);
            if (a3 == 0 || a3 == 5004) {
                removeMessages(1);
                Message obtainMessage = obtainMessage(1);
                obtainMessage.obj = true;
                obtainMessage.arg1 = 0;
                sendMessage(obtainMessage);
                activity2 = this.f4922a.mActivity;
                activity2.runOnUiThread(new l(this));
            } else {
                this.f4922a.mValidatorHandler.sendMessage(this.f4922a.mValidatorHandler.obtainMessage(5, a3, 0));
                this.f4922a.mCallback.dontAllow(LicenseErrCode.LICENSE_STATUS_NOT_LICENSED);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Activity activity;
        switch (message.what) {
            case 1:
                int i = message.arg1;
                Object obj = message.obj;
                a((obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue(), i);
                return;
            case 2:
            default:
                return;
            case 3:
                a();
                return;
            case 4:
                b();
                return;
            case 5:
                int i2 = message.arg1;
                activity = this.f4922a.mActivity;
                activity.runOnUiThread(new h(this, i2));
                return;
        }
    }
}

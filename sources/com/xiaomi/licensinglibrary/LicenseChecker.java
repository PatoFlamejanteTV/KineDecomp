package com.xiaomi.licensinglibrary;

import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.gamecenter.sdk.MiCommplatform;
import com.xiaomi.gamecenter.sdk.ak;
import com.xiaomi.gamecenter.sdk.entry.MiAppInfo;
import com.xiaomi.gamecenter.sdk.entry.ScreenOrientation;

/* loaded from: classes.dex */
public class LicenseChecker {
    private static final String LICENSE_CHECKER_LOG_TYPE = "licensechecker";
    private static final int MSG_ID_BUY_GAME = 4;
    private static final int MSG_ID_ESTABLISH_CONNECTION = 3;
    private static final int MSG_ID_SHOWTOAST = 5;
    private static final int MSG_ID_VALIDATOR_CHECK = 1;
    private static final String SERVICE_NAME = "com.xiaomi.licensinglibrary.authfileinfo";
    private static final String SERVICE_PKG_NAME = "com.xiaomi.gamecenter.sdk.service";
    private static final String TAG = "MiGameSDK";
    private static final int sCHECK_BUY_RET_COUNT = 30;
    private final Activity mActivity;
    private String mAppId;
    private LicenseCheckerCallback mCallback;
    private ILicenseService mService;
    private ak mValidator;
    private g mValidatorHandler;
    private c purchaseWindow;
    private volatile boolean mChecking = false;
    private ServiceConnection mValidatorServiceConn = new b(this);

    public LicenseChecker(Activity activity, String str, String str2, String str3, LicenseCheckerCallback licenseCheckerCallback) {
        b bVar = null;
        this.mCallback = null;
        this.purchaseWindow = null;
        this.mValidator = null;
        this.mAppId = null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3) || licenseCheckerCallback == null || activity == null || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The Argument is illegal.");
        }
        MiAppInfo miAppInfo = new MiAppInfo();
        miAppInfo.setAppId(str);
        miAppInfo.setAppKey(str2);
        miAppInfo.setOrientation(ScreenOrientation.vertical);
        MiCommplatform.Init(activity, miAppInfo);
        this.mActivity = activity;
        HandlerThread handlerThread = new HandlerThread("xiaomi_validator_background_thread");
        handlerThread.start();
        this.mValidatorHandler = new g(this, handlerThread.getLooper());
        this.mValidator = new ak(this.mActivity, str3);
        this.mCallback = licenseCheckerCallback;
        this.mAppId = str;
        this.purchaseWindow = new c(this, bVar);
    }

    private void cleanupService() {
        this.mChecking = false;
        if (this.mService != null) {
            try {
                this.mActivity.unbindService(this.mValidatorServiceConn);
            } catch (IllegalArgumentException e) {
                Log.e(TAG, "Unable to unbind from licensing service (already unbound)");
            }
            this.mService = null;
        }
        if (this.purchaseWindow != null) {
            this.purchaseWindow.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void handleServiceConnectionError(ak akVar) {
        cleanupService();
    }

    public synchronized void checkAccess() {
        if (!this.mChecking) {
            this.mValidatorHandler.removeMessages(3);
            this.mValidatorHandler.sendEmptyMessage(3);
        }
    }

    public void gotoGameCenterGamePage() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("migamecenter://details?pkgname=" + this.mActivity.getPackageName()));
            intent.addFlags(268435456);
            this.mActivity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void onDestroy() {
        cleanupService();
        this.mValidatorHandler.getLooper().quit();
    }

    public void reportLog(String str) {
        try {
            if (this.mService == null || !this.mService.asBinder().isBinderAlive()) {
                return;
            }
            this.mService.a(LICENSE_CHECKER_LOG_TYPE, str, this.mAppId, 150);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

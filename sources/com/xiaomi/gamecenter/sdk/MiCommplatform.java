package com.xiaomi.gamecenter.sdk;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.xiaomi.gamecenter.sdk.IServiceCallback;
import com.xiaomi.gamecenter.sdk.entry.CardBuyInfo;
import com.xiaomi.gamecenter.sdk.entry.MiAccountInfo;
import com.xiaomi.gamecenter.sdk.entry.MiAppEntry;
import com.xiaomi.gamecenter.sdk.entry.MiAppInfo;
import com.xiaomi.gamecenter.sdk.entry.MiBuyInfo;
import com.xiaomi.gamecenter.sdk.entry.MiBuyInfoOffline;
import com.xiaomi.gamecenter.sdk.entry.MiBuyInfoOnline;
import com.xiaomi.gamecenter.sdk.entry.ScreenOrientation;
import com.xiaomi.gamecenter.sdk.gam.MiResponseHandler;
import com.xiaomi.gamecenter.sdk.gam.MiResponseListener;
import com.xiaomi.gamecenter.sdk.gam.MiliaoInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class MiCommplatform {
    private static final long DEFAULT_TIMEOUT_MILLIS = 30000;
    public static final int GAM_ACCEPTALLMESSAGE = 8;
    public static final int GAM_ACCEPTMESSAGE = 7;
    public static final int GAM_DELETEME = 15;
    public static final int GAM_LOADGAMEFRIENDS = 3;
    public static final int GAM_LOADGAMEINFO = 1;
    public static final int GAM_LOADGAMEME = 2;
    public static final int GAM_LOADGAMEMESSAGE = 5;
    public static final int GAM_LOADLEADERBOARD = 12;
    public static final int GAM_LOADLOTTERYPRIZE = 16;
    public static final int GAM_MESSAGEBLOCK = 13;
    public static final int GAM_SENDGAMEMESSAGE = 6;
    public static final int GAM_SENDINVITEMESSAGE = 14;
    public static final int GAM_SENDINVITEMESSAGENEW = 21;
    public static final int GAM_SHAREFORLARGEIMG = 20;
    public static final int GAM_SHARETOMILIAO = 17;
    public static final int GAM_SHARETOMITALKNEW = 22;
    public static final int GAM_SYNCRESULT = 18;
    public static final int GAM_SYNCRESULTS = 19;
    public static final int GAM_UPDATEME = 4;
    public static final int GAM_UPDATERESULT = 10;
    public static final int GAM_UPDATERESULTS = 11;
    public static final int GAM_USEHEART = 9;
    private static final String PERMISSION_GETACCOUNTS = "android.permission.GET_ACCOUNTS";
    private static final String SERVICE_FILE_NAME = "MiGameCenterSDKService.apk";
    private static final String SERVICE_NAME = "com.xiaomi.gamecenter.sdk.service";
    private static final String SERVICE_PKG_NAME = "com.xiaomi.gamecenter.sdk.service";
    private static volatile MiCommplatform sInstance;
    private Object _check_service_lock_;
    private Activity activity;
    private MiAppInfo appInfo;
    private Context ctx;
    private IGameCenterSDK loginSdk;
    private IGameCenterSDK sdk;
    private int service_isntall_ask;
    private long systemTime;
    private Object _Lock_ = new Object();
    private boolean mTouch = false;
    private volatile int connect_flag = Integer.MIN_VALUE;
    private String useHeartToken = null;
    private MiliaoInfo miliaoInfo = null;
    private ServiceConnection connection = new c(this);
    private Handler toastHandler = new r(this, Looper.getMainLooper());
    private ServiceConnection openAppConnection = new x(this);
    private ServiceConnection checkLoginConnection = new z(this);
    private IServiceCallback serviceCallback = new IServiceCallback.Stub() { // from class: com.xiaomi.gamecenter.sdk.MiCommplatform.5
        @Override // com.xiaomi.gamecenter.sdk.IServiceCallback
        public void startActivity(String str, String str2, Bundle bundle) {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            bundle.setClassLoader(MiAppEntry.class.getClassLoader());
            intent.putExtras(bundle);
            intent.setClassName(str, str2);
            MiCommplatform.this.activity.startActivity(intent);
        }
    };

    private MiCommplatform(Context context, MiAppInfo miAppInfo) {
        this.ctx = context;
        this.appInfo = miAppInfo;
        this.appInfo.setSocialGame(false);
        openAppForInit();
    }

    public static void Init(Context context, MiAppInfo miAppInfo) {
        if (sInstance != null) {
            sInstance.appInfo = miAppInfo;
        } else {
            if (miAppInfo == null) {
                throw new NullPointerException("MiAppInfo is Null");
            }
            sInstance = new MiCommplatform(context, miAppInfo);
        }
    }

    private boolean checkPermission(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private boolean checkServiceVersion(Context context) {
        PackageManager packageManager;
        File file;
        try {
            packageManager = context.getPackageManager();
            InputStream open = this.ctx.getAssets().open(SERVICE_FILE_NAME);
            file = new File(this.ctx.getCacheDir(), SERVICE_FILE_NAME);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.close();
            open.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return packageManager.getPackageInfo("com.xiaomi.gamecenter.sdk.service", 64).versionCode < packageManager.getPackageArchiveInfo(file.toString(), 1).versionCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int check_and_connect(Context context, boolean z) {
        if (context instanceof Activity) {
            this.activity = (Activity) context;
        }
        if (isSdkServiceExist(context)) {
            if (checkServiceVersion(context) && (!install_service_apk(context, true) || checkServiceVersion(context))) {
                return -1;
            }
        } else if (!install_service_apk(context, false)) {
            return -1;
        }
        if (this.appInfo == null) {
            Log.e("MiCommplatform", "使用SDK前请先调用MiCommplatform.Init()且MiappInfo参数不可为null");
            return -1;
        }
        synchronized (this._Lock_) {
            this.connect_flag = Integer.MIN_VALUE;
            Intent intent = new Intent("com.xiaomi.gamecenter.sdk.service");
            intent.setPackage("com.xiaomi.gamecenter.sdk.service");
            context.getApplicationContext().bindService(intent, this.connection, 1);
            try {
                this._Lock_.wait();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        if (this.sdk == null) {
            return -1;
        }
        Log.i(">>>", "sdk.ConnService");
        return this.connect_flag;
    }

    private int check_and_connect_for_account(Context context) {
        if (context instanceof Activity) {
            this.activity = (Activity) context;
        }
        if (isSdkServiceExist(context)) {
            if (checkServiceVersion(context) && (!install_service_apk(context, true) || checkServiceVersion(context))) {
                return -1;
            }
        } else if (!install_service_apk(context, false)) {
            return -1;
        }
        if (this.appInfo == null) {
            Log.e("MiCommplatform", "使用SDK前请先调用MiCommplatform.Init()且MiappInfo参数不可为null");
            return -1;
        }
        synchronized (this._Lock_) {
            this.connect_flag = Integer.MIN_VALUE;
            Intent intent = new Intent("com.xiaomi.gamecenter.sdk.service");
            intent.setPackage("com.xiaomi.gamecenter.sdk.service");
            context.getApplicationContext().bindService(intent, this.checkLoginConnection, 1);
            try {
                this._Lock_.wait();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        if (this.loginSdk == null) {
            return -1;
        }
        Log.i(">>>", "sdk.ConnService");
        return this.connect_flag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean check_user_changed(Activity activity, int i) {
        if (i != -51) {
            return false;
        }
        this.appInfo.setAccount(null);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("提示");
        builder.setMessage("系统账户异常，请退出后重新登录！");
        builder.setCancelable(false);
        builder.setPositiveButton("确定", new l(this));
        activity.runOnUiThread(new m(this, builder));
        return true;
    }

    private void chmod(String str, String str2) {
        try {
            Runtime.getRuntime().exec("chmod " + str + " " + str2);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disconnect(Context context) {
        try {
            if (this.sdk == null) {
                return;
            }
            context.getApplicationContext().unbindService(this.connection);
            this.sdk.unregistCallBack(this.serviceCallback, getVersion());
            Intent intent = new Intent("com.xiaomi.gamecenter.sdk.service");
            intent.setPackage("com.xiaomi.gamecenter.sdk.service");
            boolean stopService = context.getApplicationContext().stopService(intent);
            this.sdk = null;
            Log.i(">>>>", "disconnect:" + stopService);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean export_install_service_apk() {
        try {
            InputStream open = this.ctx.getAssets().open(SERVICE_FILE_NAME);
            File file = new File(this.ctx.getFilesDir(), SERVICE_FILE_NAME);
            FileOutputStream openFileOutput = this.ctx.openFileOutput(SERVICE_FILE_NAME, 1);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read == -1) {
                    openFileOutput.flush();
                    openFileOutput.close();
                    open.close();
                    chmod("777", file.getAbsolutePath());
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addFlags(268435456);
                    intent.setDataAndType(Uri.parse("file://" + file.getAbsolutePath()), "application/vnd.android.package-archive");
                    this.ctx.startActivity(intent);
                    return true;
                }
                openFileOutput.write(bArr, 0, read);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static MiCommplatform getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        throw new IllegalStateException("使用SDK前请先调用MiCommplatform.Init()且MiappInfo参数不可为null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getVersion() {
        return "44033";
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x003d -> B:17:0x0040). Please report as a decompilation issue!!! */
    private boolean install_service_apk(Context context, boolean z) {
        this.service_isntall_ask = 0;
        this._check_service_lock_ = new Object();
        new h(this, Looper.getMainLooper(), z, context).sendEmptyMessage(0);
        synchronized (this._check_service_lock_) {
            try {
                this._check_service_lock_.wait();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        if (this.service_isntall_ask != 1) {
            this._check_service_lock_ = null;
            return false;
        }
        if (!export_install_service_apk()) {
            return false;
        }
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
        while (!isTopActivity((Activity) context)) {
            Thread.sleep(100L);
        }
        return isSdkServiceExist(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTopActivity(Activity activity) {
        String packageName = activity.getPackageName();
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) activity.getSystemService("activity")).getRunningTasks(1);
        return runningTasks.size() > 0 && packageName.equals(runningTasks.get(0).topActivity.getPackageName());
    }

    private void miCardPay(Activity activity, CardBuyInfo cardBuyInfo, OnCardPayProcessListener onCardPayProcessListener) {
        if (this.mTouch) {
            onCardPayProcessListener.finishCardPayProcess(-18006);
        } else {
            this.mTouch = true;
            new g(this, activity, onCardPayProcessListener, cardBuyInfo).start();
        }
    }

    private void miLogout(OnLoginProcessListener onLoginProcessListener) {
        if (this.mTouch) {
            onLoginProcessListener.finishLoginProcess(-18006, null);
        } else {
            this.mTouch = true;
            new ab(this, onLoginProcessListener).start();
        }
    }

    private void miWindow(OnPayProcessListener onPayProcessListener) {
        if (this.mTouch) {
            onPayProcessListener.finishPayProcess(-18006);
        } else {
            this.mTouch = true;
            new ac(this, onPayProcessListener).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openApp(MiAppInfo miAppInfo) {
        try {
            try {
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
            if (this.sdk == null) {
                return;
            }
            this.sdk.openAppReportForInit(miAppInfo, this.ctx.getPackageName());
        } finally {
            this.ctx.getApplicationContext().unbindService(this.openAppConnection);
        }
    }

    private void openAppForInit() {
        if (isSdkServiceExist(this.ctx)) {
            try {
                if (this.ctx.getPackageManager().getPackageInfo("com.xiaomi.gamecenter.sdk.service", 64).versionCode < 43070) {
                    return;
                }
                Intent intent = new Intent("com.xiaomi.gamecenter.sdk.service");
                intent.setPackage("com.xiaomi.gamecenter.sdk.service");
                this.ctx.getApplicationContext().bindService(intent, this.openAppConnection, 1);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLogToSDKSerivce(String str) {
        try {
            if (this.sdk == null) {
                return;
            }
            this.sdk.sendLogToService(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendToastMsg() {
        Handler handler = this.toastHandler;
        if (handler != null) {
            handler.sendEmptyMessage(0);
        }
    }

    public void acceptAllMessage(Activity activity, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else {
            this.mTouch = true;
            new ae(this, activity, 8, miResponseHandler, new Object[0]);
        }
    }

    public void acceptMessage(Activity activity, String str, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else {
            this.mTouch = true;
            new ae(this, activity, 7, miResponseHandler, str);
        }
    }

    public boolean canOpenEntrancePage() {
        if (!isSdkServiceExist(this.ctx)) {
            return false;
        }
        try {
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        return this.ctx.getPackageManager().getPackageInfo("com.xiaomi.gamecenter.sdk.service", 64).versionCode >= 8;
    }

    public void checkJoinedUnion(String str, MiResponseListener miResponseListener) {
        if (this.mTouch) {
            miResponseListener.sendResultCode(-18006, null);
        } else {
            this.mTouch = true;
            new p(this, miResponseListener, str).start();
        }
    }

    public void checkMiTalkStatus(MiResponseListener miResponseListener) {
        if (this.mTouch) {
            miResponseListener.sendResultCode(-18006, "");
        } else {
            this.mTouch = true;
            new n(this, miResponseListener).start();
        }
    }

    public void checkVipIsScubscribed(String str, MiResponseListener miResponseListener) {
        if (this.mTouch) {
            miResponseListener.sendResultCode(-18006, null);
        } else {
            this.mTouch = true;
            new s(this, miResponseListener, str).start();
        }
    }

    public void deleteMe(Activity activity, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else {
            this.mTouch = true;
            new ae(this, activity, 15, miResponseHandler, new Object[0]);
        }
    }

    public String generateCpOrderId() {
        return getMD5(UUID.randomUUID().toString().getBytes());
    }

    String getMD5(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            byte[] digest = messageDigest.digest();
            for (int i = 0; i < digest.length; i++) {
                int i2 = digest[i];
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 25) {
                    stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString().substring(5, 30);
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public MiAccountInfo getMiAccountInfo() {
        MiAppInfo miAppInfo = this.appInfo;
        if (miAppInfo != null) {
            return miAppInfo.getAccount();
        }
        return null;
    }

    public void getUnionList(Activity activity, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else {
            this.mTouch = true;
            new u(this, activity, miResponseHandler).start();
        }
    }

    public void getVipList(Activity activity, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else {
            this.mTouch = true;
            new v(this, activity, miResponseHandler).start();
        }
    }

    public boolean isMiAccountLogin() {
        Context context = this.ctx;
        if (context == null) {
            throw new NullPointerException("Context is Null, please init SDK");
        }
        if (!checkPermission(context, PERMISSION_GETACCOUNTS)) {
            throw new SecurityException("XiaomiSDK lacks any of android.permission.GET_ACCOUNTS");
        }
        Account[] accountsByType = AccountManager.get(this.ctx).getAccountsByType("com.xiaomi");
        return accountsByType != null && accountsByType.length > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSdkServiceExist(Context context) {
        try {
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
            for (int i = 0; i < installedPackages.size(); i++) {
                if (installedPackages.get(i).packageName.equalsIgnoreCase("com.xiaomi.gamecenter.sdk.service")) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void joinUnion(String str, String str2, MiResponseListener miResponseListener) {
        if (this.mTouch) {
            miResponseListener.sendResultCode(-18006, null);
        } else {
            this.mTouch = true;
            new o(this, miResponseListener, str, str2).start();
        }
    }

    public void loadGameFriends(Activity activity, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else {
            this.mTouch = true;
            new ae(this, activity, 3, miResponseHandler, new Object[0]);
        }
    }

    public void loadGameInfo(Activity activity, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else {
            this.mTouch = true;
            new ae(this, activity, 1, miResponseHandler, new Object[0]);
        }
    }

    public void loadGameMe(Activity activity, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else {
            this.mTouch = true;
            new ae(this, activity, 2, miResponseHandler, new Object[0]);
        }
    }

    public void loadGameMessage(Activity activity, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else {
            this.mTouch = true;
            new ae(this, activity, 5, miResponseHandler, new Object[0]);
        }
    }

    public void loadLeaderBoard(Activity activity, String str, int i, int i2, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else {
            this.mTouch = true;
            new ae(this, activity, 12, miResponseHandler, str, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public void messageBlock(Activity activity, boolean z, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else {
            this.mTouch = true;
            new ae(this, activity, 13, miResponseHandler, Boolean.valueOf(z));
        }
    }

    public void miAppExit(Activity activity, OnExitListner onExitListner) {
        new Thread(new w(this, activity, onExitListner)).start();
    }

    public void miLogin(Activity activity, OnLoginProcessListener onLoginProcessListener) {
        if (this.mTouch) {
            onLoginProcessListener.finishLoginProcess(-18006, null);
        } else {
            this.mTouch = true;
            new aa(this, activity, onLoginProcessListener).start();
        }
    }

    public int miUniPay(Activity activity, MiBuyInfo miBuyInfo, OnPayProcessListener onPayProcessListener) {
        if (this.mTouch) {
            onPayProcessListener.finishPayProcess(-18006);
            return -1;
        }
        this.mTouch = true;
        new f(this, miBuyInfo, onPayProcessListener, activity).start();
        return 0;
    }

    public int miUniPayOffline(Activity activity, MiBuyInfoOffline miBuyInfoOffline, OnPayProcessListener onPayProcessListener) {
        if (this.mTouch) {
            onPayProcessListener.finishPayProcess(-18006);
            return -1;
        }
        this.mTouch = true;
        new ad(this, miBuyInfoOffline, onPayProcessListener, activity).start();
        return 0;
    }

    public int miUniPayOnline(Activity activity, MiBuyInfoOnline miBuyInfoOnline, Bundle bundle, OnPayProcessListener onPayProcessListener) {
        if (this.mTouch) {
            onPayProcessListener.finishPayProcess(-18006);
            return -1;
        }
        this.mTouch = true;
        new e(this, miBuyInfoOnline, onPayProcessListener, activity, bundle).start();
        return 0;
    }

    public boolean newSDKInstalled(Activity activity) {
        boolean z = check_and_connect(activity, true) == 0;
        disconnect(this.ctx);
        return z;
    }

    public void openMiTalkUpdateSite() {
        if (this.mTouch) {
            return;
        }
        this.mTouch = true;
        new t(this).start();
    }

    public void sendGameMessage(Activity activity, String str, boolean z, String str2, String str3, int i, byte[] bArr, List list, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else {
            this.mTouch = true;
            new ae(this, activity, 6, miResponseHandler, str, Boolean.valueOf(z), str2, str3, Integer.valueOf(i), bArr, list);
        }
    }

    public void sendInviteMessage(Activity activity, String str, String str2, String str3, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else if (this.miliaoInfo == null) {
            Toast.makeText(activity, "请先调用loadGameInfo接口", 1).show();
            miResponseHandler.sendResultMsg(-107, null);
        } else {
            this.mTouch = true;
            new ae(this, activity, 21, miResponseHandler, str, str2, str3);
        }
    }

    public void sendInviteMessage(Activity activity, String str, boolean z, String str2, List list, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else if (this.miliaoInfo == null) {
            Toast.makeText(activity, "请先调用loadGameInfo接口", 1).show();
            miResponseHandler.sendResultMsg(-107, null);
        } else {
            this.mTouch = true;
            new ae(this, activity, 14, miResponseHandler, str, Boolean.valueOf(z), str2, list);
        }
    }

    public void shareToMiTalk(Activity activity, String str, String str2, String str3, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(activity, "参数错误,title不能为空", 1).show();
            miResponseHandler.sendResultMsg(-107, null);
        } else if (this.miliaoInfo != null) {
            new ae(this, activity, 17, miResponseHandler, str, str2, str3);
        } else {
            Toast.makeText(activity, "请先调用loadGameInfo接口", 1).show();
            miResponseHandler.sendResultMsg(-107, null);
        }
    }

    public void shareToMiTalkForImgAndUrl(Activity activity, String str, String str2, String str3, String str4, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else if (this.miliaoInfo == null) {
            Toast.makeText(activity, "请先调用loadGameInfo接口", 1).show();
            miResponseHandler.sendResultMsg(-107, null);
        } else {
            this.mTouch = true;
            new ae(this, activity, 22, miResponseHandler, str, str2, str3, str4);
        }
    }

    public void shareToMiTalkForLargeImg(Activity activity, String str, String str2, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else if (this.miliaoInfo == null) {
            Toast.makeText(activity, "请先调用loadGameInfo接口", 1).show();
            miResponseHandler.sendResultMsg(-107, null);
        } else {
            this.mTouch = true;
            new ae(this, activity, 20, miResponseHandler, str, str2);
        }
    }

    public void subscribeVip(String str, MiResponseListener miResponseListener) {
        if (this.mTouch) {
            miResponseListener.sendResultCode(-18006, null);
        } else {
            this.mTouch = true;
            new q(this, miResponseListener, str).start();
        }
    }

    public void syncResult(Activity activity, String str, int i, int i2, byte[] bArr, byte[] bArr2, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else {
            this.mTouch = true;
            new ae(this, activity, 18, miResponseHandler, str, Integer.valueOf(i), Integer.valueOf(i2), bArr, bArr2);
        }
    }

    public void syncResults(Activity activity, HashMap hashMap, int i, byte[] bArr, byte[] bArr2, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else {
            this.mTouch = true;
            new ae(this, activity, 19, miResponseHandler, hashMap, Integer.valueOf(i), bArr, bArr2);
        }
    }

    public void updateMe(Activity activity, int i, int i2, byte[] bArr, byte[] bArr2, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else {
            this.mTouch = true;
            new ae(this, activity, 4, miResponseHandler, Integer.valueOf(i), Integer.valueOf(i2), bArr, bArr2);
        }
    }

    public void updateResult(Activity activity, String str, int i, int i2, byte[] bArr, byte[] bArr2, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else {
            this.mTouch = true;
            new ae(this, activity, 10, miResponseHandler, str, Integer.valueOf(i), Integer.valueOf(i2), bArr, bArr2, -1, null);
        }
    }

    public void updateResults(Activity activity, HashMap hashMap, int i, byte[] bArr, byte[] bArr2, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else {
            this.mTouch = true;
            new ae(this, activity, 11, miResponseHandler, hashMap, Integer.valueOf(i), bArr, bArr2, -1, null);
        }
    }

    public void update_screen_orientation(ScreenOrientation screenOrientation) {
        this.appInfo.setOrientation(screenOrientation);
    }

    public void useHeart(Activity activity, int i, MiResponseHandler miResponseHandler) {
        if (this.mTouch) {
            miResponseHandler.sendResultMsg(-18006, null);
        } else {
            this.mTouch = true;
            new ae(this, activity, 9, miResponseHandler, Integer.valueOf(i), false);
        }
    }
}

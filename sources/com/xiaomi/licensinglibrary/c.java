package com.xiaomi.licensinglibrary;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LicenseChecker f4918a;
    private AlertDialog b;
    private ProgressDialog c;

    private c(LicenseChecker licenseChecker) {
        this.f4918a = licenseChecker;
        this.b = null;
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(LicenseChecker licenseChecker, b bVar) {
        this(licenseChecker);
    }

    public void a() {
        try {
            if (this.c != null) {
                if (this.c.isShowing()) {
                    this.c.dismiss();
                }
                this.c = null;
            }
            if (this.b != null) {
                if (this.b.isShowing()) {
                    this.b.dismiss();
                }
                this.b = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(int i) {
        Activity activity;
        a();
        String str = "";
        switch (i) {
            case -18003:
                str = "购买失败";
                break;
            case LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE /* 1002 */:
                str = "未安装小米游戏中心福利助手!";
                break;
            case LicenseErrCode.ERROR_NETWORK_ERROR /* 4002 */:
                str = "无法使用网络，请检查你的网络连接状态";
                break;
            case LicenseErrCode.ERROR_BUY_LICENSE_CREATECPCORDERERROR /* 5003 */:
                str = "创建订单失败";
                break;
            case LicenseErrCode.ERROR_BUY_LICENSE_HASBUYERERROR /* 5004 */:
                str = "你已经购买过该游戏";
                break;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        activity = this.f4918a.mActivity;
        Toast.makeText(activity, str, 1).show();
    }

    public void a(Context context) {
        a();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("购买该游戏后，你才能使用该游戏");
        builder.setCancelable(true);
        builder.setOnCancelListener(new d(this));
        builder.setNegativeButton(R.string.cancel, new e(this));
        builder.setPositiveButton("购买", new f(this));
        this.b = builder.create();
        try {
            this.b.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(Context context, String str) {
        a();
        this.c = ProgressDialog.show(context, null, str);
        this.c.setCancelable(true);
        try {
            this.c.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

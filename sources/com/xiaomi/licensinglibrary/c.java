package com.xiaomi.licensinglibrary;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a */
    final /* synthetic */ LicenseChecker f26649a;

    /* renamed from: b */
    private AlertDialog f26650b;

    /* renamed from: c */
    private ProgressDialog f26651c;

    private c(LicenseChecker licenseChecker) {
        this.f26649a = licenseChecker;
        this.f26650b = null;
        this.f26651c = null;
    }

    public /* synthetic */ c(LicenseChecker licenseChecker, b bVar) {
        this(licenseChecker);
    }

    public void a() {
        try {
            if (this.f26651c != null) {
                if (this.f26651c.isShowing()) {
                    this.f26651c.dismiss();
                }
                this.f26651c = null;
            }
            if (this.f26650b != null) {
                if (this.f26650b.isShowing()) {
                    this.f26650b.dismiss();
                }
                this.f26650b = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(int i) {
        Activity activity;
        a();
        String str = i != -18003 ? i != 1002 ? i != 4002 ? i != 5003 ? i != 5004 ? "" : "你已经购买过该游戏" : "创建订单失败" : "无法使用网络，请检查你的网络连接状态" : "未安装小米游戏中心福利助手!" : "购买失败";
        if (TextUtils.isEmpty(str)) {
            return;
        }
        activity = this.f26649a.mActivity;
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
        this.f26650b = builder.create();
        try {
            this.f26650b.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(Context context, String str) {
        a();
        this.f26651c = ProgressDialog.show(context, null, str);
        this.f26651c.setCancelable(true);
        try {
            this.f26651c.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

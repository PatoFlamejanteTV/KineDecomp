package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class h extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f26604a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f26605b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f26606c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(MiCommplatform miCommplatform, Looper looper, boolean z, Context context) {
        super(looper);
        this.f26606c = miCommplatform;
        this.f26604a = z;
        this.f26605b = context;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        new AlertDialog.Builder((Activity) this.f26605b).setTitle("提示").setCancelable(true).setMessage(this.f26604a ? "当前有新版本的'小米游戏中心福利助手'，是否安装?" : "您尚未安装'小米游戏中心福利助手'，安装后才可用小米账户登录，并保证账户安全。仅需安装一次，是否立即安装？").setPositiveButton("安装", new k(this)).setNegativeButton("取消", new j(this)).setOnCancelListener(new i(this)).show();
    }
}

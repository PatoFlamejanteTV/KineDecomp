package com.xiaomi.gamecenter.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f4905a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(MiCommplatform miCommplatform, Looper looper) {
        super(looper);
        this.f4905a = miCommplatform;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        Context context;
        context = this.f4905a.ctx;
        Toast.makeText(context, "网络错误，请检查网络", 0).show();
    }
}

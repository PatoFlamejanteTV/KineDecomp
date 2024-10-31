package com.xiaomi.gamecenter.sdk.gam;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public abstract class MiResponseListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onResponseStatus(int i, String str);

    public void sendResultCode(int i, String str) {
        new Handler(Looper.getMainLooper()).post(new c(this, i, str));
    }
}

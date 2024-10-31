package com.nexstreaming.app.general.iab;

import android.app.PendingIntent;

/* loaded from: classes2.dex */
public class BuyResult {
    public static final int BUY_RESULT_GOOGLE = 2;
    public static final int BUY_RESULT_WECHAT = 3;
    public static final int BUY_RESULT_XIAOMI = 1;
    private PendingIntent pendingIntent = null;
    private int errorCode = -1;
    private int buyResult = 2;
    private int requestCode = -1;

    public void a(int i) {
        this.buyResult = i;
    }

    public String toString() {
        return "BuyResult{pendingIntent=" + this.pendingIntent + ", errorCode=" + this.errorCode + ", buyResult=" + this.buyResult + ", requestCode=" + this.requestCode + '}';
    }
}

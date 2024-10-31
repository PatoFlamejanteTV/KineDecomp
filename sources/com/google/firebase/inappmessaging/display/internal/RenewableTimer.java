package com.google.firebase.inappmessaging.display.internal;

import android.os.CountDownTimer;
import javax.inject.Inject;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class RenewableTimer {

    /* renamed from: a */
    private CountDownTimer f17558a;

    /* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface Callback {
        void onFinish();
    }

    @Inject
    public RenewableTimer() {
    }

    public void a(Callback callback, long j, long j2) {
        this.f17558a = new e(this, j, j2, callback).start();
    }

    public void a() {
        CountDownTimer countDownTimer = this.f17558a;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f17558a = null;
        }
    }
}

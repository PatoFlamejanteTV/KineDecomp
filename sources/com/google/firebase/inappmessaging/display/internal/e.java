package com.google.firebase.inappmessaging.display.internal;

import android.os.CountDownTimer;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class e extends CountDownTimer {

    /* renamed from: a */
    final /* synthetic */ RenewableTimer.Callback f17604a;

    /* renamed from: b */
    final /* synthetic */ RenewableTimer f17605b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(RenewableTimer renewableTimer, long j, long j2, RenewableTimer.Callback callback) {
        super(j, j2);
        this.f17605b = renewableTimer;
        this.f17604a = callback;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f17604a.onFinish();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }
}

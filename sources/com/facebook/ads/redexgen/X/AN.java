package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;

/* loaded from: assets/audience_network.dex */
public class AN extends Handler {
    public final /* synthetic */ AO A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AN(AO ao, Looper looper) {
        super(looper);
        this.A00 = ao;
    }

    @Override // android.os.Handler
    @SuppressLint({"CatchGeneralException"})
    public final void handleMessage(Message message) {
        AY ay;
        try {
            switch (AM.values()[message.what]) {
                case A02:
                    MotionEvent motionEvent = (MotionEvent) message.obj;
                    if (motionEvent == null) {
                        return;
                    }
                    ay = this.A00.A02;
                    ay.A00(motionEvent);
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            AK.A03(th);
        }
        AK.A03(th);
    }
}

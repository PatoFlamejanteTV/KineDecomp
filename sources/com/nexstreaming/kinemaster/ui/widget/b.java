package com.nexstreaming.kinemaster.ui.widget;

import android.os.Handler;
import android.os.Message;
import android.widget.Scroller;
import com.nexstreaming.kinemaster.ui.widget.C;

/* compiled from: WheelScroller.java */
/* loaded from: classes2.dex */
public class B extends Handler {

    /* renamed from: a */
    final /* synthetic */ C f23719a;

    public B(C c2) {
        this.f23719a = c2;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Scroller scroller;
        Scroller scroller2;
        int i;
        Scroller scroller3;
        Scroller scroller4;
        Handler handler;
        Scroller scroller5;
        Scroller scroller6;
        C.a aVar;
        scroller = this.f23719a.f23723d;
        scroller.computeScrollOffset();
        scroller2 = this.f23719a.f23723d;
        int currY = scroller2.getCurrY();
        i = this.f23719a.f23724e;
        int i2 = i - currY;
        this.f23719a.f23724e = currY;
        if (i2 != 0) {
            aVar = this.f23719a.f23720a;
            aVar.a(i2);
        }
        scroller3 = this.f23719a.f23723d;
        if (Math.abs(currY - scroller3.getFinalY()) < 1) {
            scroller5 = this.f23719a.f23723d;
            scroller5.getFinalY();
            scroller6 = this.f23719a.f23723d;
            scroller6.forceFinished(true);
        }
        scroller4 = this.f23719a.f23723d;
        if (!scroller4.isFinished()) {
            handler = this.f23719a.k;
            handler.sendEmptyMessage(message.what);
        } else if (message.what == 0) {
            this.f23719a.d();
        } else {
            this.f23719a.a();
        }
    }
}

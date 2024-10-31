package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* compiled from: LongPressDetector.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.timeline.j */
/* loaded from: classes2.dex */
public class HandlerC2029j extends Handler {

    /* renamed from: a */
    private final Context f22675a;

    /* renamed from: b */
    private final a f22676b;

    /* renamed from: c */
    private final int f22677c = ViewConfiguration.getLongPressTimeout();

    /* renamed from: d */
    private final int f22678d = ViewConfiguration.getTapTimeout();

    /* renamed from: e */
    private final int f22679e;

    /* renamed from: f */
    private MotionEvent f22680f;

    /* renamed from: g */
    private boolean f22681g;

    /* compiled from: LongPressDetector.java */
    /* renamed from: com.nexstreaming.kinemaster.ui.projectedit.timeline.j$a */
    /* loaded from: classes2.dex */
    public interface a {
        void onLongPress(MotionEvent motionEvent);
    }

    public HandlerC2029j(Context context, a aVar) {
        this.f22675a = context;
        this.f22676b = aVar;
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f22679e = scaledTouchSlop * scaledTouchSlop;
    }

    private void b() {
        removeMessages(1);
    }

    private void c() {
        sendEmptyMessageAtTime(1, this.f22680f.getDownTime() + this.f22678d + this.f22677c);
    }

    public void a(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    MotionEvent motionEvent2 = this.f22680f;
                    if (motionEvent2 == null) {
                        return;
                    }
                    int x2 = (int) (x - motionEvent2.getX());
                    int y2 = (int) (y - this.f22680f.getY());
                    if ((x2 * x2) + (y2 * y2) > this.f22679e) {
                        this.f22681g = false;
                        b();
                        return;
                    }
                    return;
                }
                if (actionMasked != 3) {
                    return;
                }
            }
            MotionEvent motionEvent3 = this.f22680f;
            if (motionEvent3 != null && motionEvent3.getDownTime() + this.f22678d + this.f22677c > motionEvent.getEventTime()) {
                this.f22681g = false;
                b();
                return;
            }
            return;
        }
        this.f22680f = MotionEvent.obtain(motionEvent);
        this.f22681g = false;
        c();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 1) {
            return;
        }
        this.f22681g = true;
        MotionEvent motionEvent = this.f22680f;
        if (motionEvent != null) {
            a aVar = this.f22676b;
            if (aVar != null) {
                aVar.onLongPress(motionEvent);
            }
            this.f22680f.recycle();
            this.f22680f = null;
        }
    }

    public void a() {
        b();
        MotionEvent motionEvent = this.f22680f;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.f22680f = null;
        }
    }
}

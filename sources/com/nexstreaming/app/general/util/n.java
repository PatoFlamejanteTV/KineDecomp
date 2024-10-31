package com.nexstreaming.app.general.util;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* compiled from: NexGestureDetector.java */
/* loaded from: classes.dex */
public class n {
    private static final int f = ViewConfiguration.getLongPressTimeout();
    private static final int g = ViewConfiguration.getTapTimeout();
    private static final int h = ViewConfiguration.getDoubleTapTimeout();

    /* renamed from: a, reason: collision with root package name */
    private int f3232a;
    private int b;
    private int c;
    private int d;
    private int e;
    private final Handler i;
    private final c j;
    private b k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private MotionEvent p;
    private MotionEvent q;
    private boolean r;
    private float s;
    private float t;
    private float u;
    private float v;
    private boolean w;
    private VelocityTracker x;

    /* compiled from: NexGestureDetector.java */
    /* loaded from: classes.dex */
    public interface b {
        boolean a(MotionEvent motionEvent);

        boolean b(MotionEvent motionEvent);

        boolean c(MotionEvent motionEvent);
    }

    /* compiled from: NexGestureDetector.java */
    /* loaded from: classes.dex */
    public interface c {
        boolean a(MotionEvent motionEvent);

        boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

        void b(MotionEvent motionEvent);

        boolean b(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

        boolean c(MotionEvent motionEvent);

        void d(MotionEvent motionEvent);
    }

    /* compiled from: NexGestureDetector.java */
    /* loaded from: classes.dex */
    private class a extends Handler {
        a() {
        }

        a(Handler handler) {
            super(handler.getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    n.this.j.b(n.this.p);
                    return;
                case 2:
                    n.this.c();
                    return;
                case 3:
                    if (n.this.k != null && !n.this.l) {
                        n.this.k.a(n.this.p);
                        return;
                    }
                    return;
                default:
                    throw new RuntimeException("Unknown message " + message);
            }
        }
    }

    public n(Context context, c cVar) {
        this(context, cVar, null);
    }

    public n(Context context, c cVar, Handler handler) {
        if (handler != null) {
            this.i = new a(handler);
        } else {
            this.i = new a();
        }
        this.j = cVar;
        if (cVar instanceof b) {
            a((b) cVar);
        }
        a(context);
    }

    private void a(Context context) {
        int scaledTouchSlop;
        int scaledDoubleTapSlop;
        int i;
        if (this.j == null) {
            throw new NullPointerException("OnGestureListener must not be null");
        }
        this.w = true;
        if (context == null) {
            scaledTouchSlop = ViewConfiguration.getTouchSlop();
            scaledDoubleTapSlop = ViewConfiguration.getDoubleTapTimeout();
            this.d = ViewConfiguration.getMinimumFlingVelocity();
            this.e = ViewConfiguration.getMaximumFlingVelocity();
            i = scaledTouchSlop;
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.d = viewConfiguration.getScaledMinimumFlingVelocity();
            this.e = viewConfiguration.getScaledMaximumFlingVelocity();
            i = scaledTouchSlop;
        }
        this.f3232a = i * i;
        this.b = scaledTouchSlop * scaledTouchSlop;
        this.c = scaledDoubleTapSlop * scaledDoubleTapSlop;
    }

    public void a(int i) {
        this.f3232a = i * i;
    }

    public void a(b bVar) {
        this.k = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.app.general.util.n.a(android.view.MotionEvent):boolean");
    }

    private void a() {
        this.i.removeMessages(1);
        this.i.removeMessages(2);
        this.i.removeMessages(3);
        this.x.recycle();
        this.x = null;
        this.r = false;
        this.l = false;
        this.n = false;
        this.o = false;
        if (this.m) {
            this.m = false;
        }
    }

    private void b() {
        this.i.removeMessages(1);
        this.i.removeMessages(2);
        this.i.removeMessages(3);
        this.r = false;
        this.n = false;
        this.o = false;
        if (this.m) {
            this.m = false;
        }
    }

    private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (!this.o || motionEvent3.getEventTime() - motionEvent2.getEventTime() > h) {
            return false;
        }
        int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
        int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
        return (x * x) + (y * y) < this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.i.removeMessages(3);
        this.m = true;
        this.j.d(this.p);
    }
}

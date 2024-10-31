package com.nexstreaming.app.general.util;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* compiled from: NexGestureDetector.java */
/* loaded from: classes2.dex */
public class v {

    /* renamed from: a */
    private static final int f19886a = ViewConfiguration.getLongPressTimeout();

    /* renamed from: b */
    private static final int f19887b = ViewConfiguration.getTapTimeout();

    /* renamed from: c */
    private static final int f19888c = ViewConfiguration.getDoubleTapTimeout();

    /* renamed from: d */
    private int f19889d;

    /* renamed from: e */
    private int f19890e;

    /* renamed from: f */
    private int f19891f;

    /* renamed from: g */
    private int f19892g;

    /* renamed from: h */
    private int f19893h;
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
    /* loaded from: classes2.dex */
    public interface b {
        boolean onDoubleTap(MotionEvent motionEvent);

        boolean onDoubleTapEvent(MotionEvent motionEvent);

        boolean onSingleTapConfirmed(MotionEvent motionEvent);
    }

    /* compiled from: NexGestureDetector.java */
    /* loaded from: classes2.dex */
    public interface c {
        boolean onDown(MotionEvent motionEvent);

        boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);

        void onLongPress(MotionEvent motionEvent);

        boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);

        void onShowPress(MotionEvent motionEvent);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    /* compiled from: NexGestureDetector.java */
    /* loaded from: classes2.dex */
    public static class d implements c, b {
        @Override // com.nexstreaming.app.general.util.v.b
        public boolean onDoubleTap(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.nexstreaming.app.general.util.v.b
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.nexstreaming.app.general.util.v.c
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.nexstreaming.app.general.util.v.c
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // com.nexstreaming.app.general.util.v.c
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // com.nexstreaming.app.general.util.v.b
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.nexstreaming.app.general.util.v.c
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    public v(Context context, c cVar) {
        this(context, cVar, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NexGestureDetector.java */
    /* loaded from: classes2.dex */
    public class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                v.this.j.onShowPress(v.this.p);
                return;
            }
            if (i == 2) {
                v.this.c();
                return;
            }
            if (i == 3) {
                if (v.this.k == null || v.this.l) {
                    return;
                }
                v.this.k.onSingleTapConfirmed(v.this.p);
                return;
            }
            throw new RuntimeException("Unknown message " + message);
        }

        a(Handler handler) {
            super(handler.getLooper());
        }
    }

    public v(Context context, c cVar, Handler handler) {
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
        int i;
        int i2;
        if (this.j != null) {
            this.w = true;
            if (context == null) {
                i = ViewConfiguration.getTouchSlop();
                i2 = ViewConfiguration.getDoubleTapTimeout();
                this.f19892g = ViewConfiguration.getMinimumFlingVelocity();
                this.f19893h = ViewConfiguration.getMaximumFlingVelocity();
            } else {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.f19892g = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f19893h = viewConfiguration.getScaledMaximumFlingVelocity();
                i = scaledTouchSlop;
                i2 = scaledDoubleTapSlop;
            }
            int i3 = i * i;
            this.f19889d = i3;
            this.f19890e = i3;
            this.f19891f = i2 * i2;
            return;
        }
        throw new NullPointerException("OnGestureListener must not be null");
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

    public void c() {
        this.i.removeMessages(3);
        this.m = true;
        this.j.onLongPress(this.p);
    }

    public void a(int i) {
        this.f19889d = i * i;
    }

    public void a(b bVar) {
        this.k = bVar;
    }

    public void a(boolean z) {
        this.w = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 506
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.app.general.util.v.a(android.view.MotionEvent):boolean");
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

    private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (!this.o || motionEvent3.getEventTime() - motionEvent2.getEventTime() > f19888c) {
            return false;
        }
        int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
        int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
        return (x * x) + (y * y) < this.f19891f;
    }
}

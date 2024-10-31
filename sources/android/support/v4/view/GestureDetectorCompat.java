package android.support.v4.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public final class GestureDetectorCompat {

    /* renamed from: a */
    private final GestureDetectorCompatImpl f1787a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent motionEvent);

        void setIsLongpressEnabled(boolean z);

        void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {

        /* renamed from: a */
        private static final int f1788a = ViewConfiguration.getLongPressTimeout();

        /* renamed from: b */
        private static final int f1789b = ViewConfiguration.getTapTimeout();

        /* renamed from: c */
        private static final int f1790c = ViewConfiguration.getDoubleTapTimeout();

        /* renamed from: d */
        private int f1791d;

        /* renamed from: e */
        private int f1792e;

        /* renamed from: f */
        private int f1793f;

        /* renamed from: g */
        private int f1794g;

        /* renamed from: h */
        private final Handler f1795h;
        final GestureDetector.OnGestureListener i;
        GestureDetector.OnDoubleTapListener j;
        boolean k;
        boolean l;
        private boolean m;
        private boolean n;
        private boolean o;
        MotionEvent p;
        private MotionEvent q;
        private boolean r;
        private float s;
        private float t;
        private float u;
        private float v;
        private boolean w;
        private VelocityTracker x;

        GestureDetectorCompatImplBase(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.f1795h = new GestureHandler(handler);
            } else {
                this.f1795h = new GestureHandler();
            }
            this.i = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            a(context);
        }

        private void a(Context context) {
            if (context != null) {
                if (this.i != null) {
                    this.w = true;
                    ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                    int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                    int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                    this.f1793f = viewConfiguration.getScaledMinimumFlingVelocity();
                    this.f1794g = viewConfiguration.getScaledMaximumFlingVelocity();
                    this.f1791d = scaledTouchSlop * scaledTouchSlop;
                    this.f1792e = scaledDoubleTapSlop * scaledDoubleTapSlop;
                    return;
                }
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
            throw new IllegalArgumentException("Context must not be null");
        }

        private void b() {
            this.f1795h.removeMessages(1);
            this.f1795h.removeMessages(2);
            this.f1795h.removeMessages(3);
            this.x.recycle();
            this.x = null;
            this.r = false;
            this.k = false;
            this.n = false;
            this.o = false;
            this.l = false;
            if (this.m) {
                this.m = false;
            }
        }

        private void c() {
            this.f1795h.removeMessages(1);
            this.f1795h.removeMessages(2);
            this.f1795h.removeMessages(3);
            this.r = false;
            this.n = false;
            this.o = false;
            this.l = false;
            if (this.m) {
                this.m = false;
            }
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            return this.w;
        }

        /* JADX WARN: Removed duplicated region for block: B:114:0x0208  */
        /* JADX WARN: Removed duplicated region for block: B:117:0x021f  */
        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouchEvent(android.view.MotionEvent r13) {
            /*
                Method dump skipped, instructions count: 591
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImplBase.onTouchEvent(android.view.MotionEvent):boolean");
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean z) {
            this.w = z;
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.j = onDoubleTapListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class GestureHandler extends Handler {
            GestureHandler() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    GestureDetectorCompatImplBase gestureDetectorCompatImplBase = GestureDetectorCompatImplBase.this;
                    gestureDetectorCompatImplBase.i.onShowPress(gestureDetectorCompatImplBase.p);
                    return;
                }
                if (i == 2) {
                    GestureDetectorCompatImplBase.this.a();
                    return;
                }
                if (i == 3) {
                    GestureDetectorCompatImplBase gestureDetectorCompatImplBase2 = GestureDetectorCompatImplBase.this;
                    GestureDetector.OnDoubleTapListener onDoubleTapListener = gestureDetectorCompatImplBase2.j;
                    if (onDoubleTapListener != null) {
                        if (!gestureDetectorCompatImplBase2.k) {
                            onDoubleTapListener.onSingleTapConfirmed(gestureDetectorCompatImplBase2.p);
                            return;
                        } else {
                            gestureDetectorCompatImplBase2.l = true;
                            return;
                        }
                    }
                    return;
                }
                throw new RuntimeException("Unknown message " + message);
            }

            GestureHandler(Handler handler) {
                super(handler.getLooper());
            }
        }

        private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.o || motionEvent3.getEventTime() - motionEvent2.getEventTime() > f1790c) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x * x) + (y * y) < this.f1792e;
        }

        void a() {
            this.f1795h.removeMessages(3);
            this.l = false;
            this.m = true;
            this.i.onLongPress(this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {

        /* renamed from: a */
        private final GestureDetector f1797a;

        GestureDetectorCompatImplJellybeanMr2(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f1797a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            return this.f1797a.isLongpressEnabled();
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.f1797a.onTouchEvent(motionEvent);
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean z) {
            this.f1797a.setIsLongpressEnabled(z);
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f1797a.setOnDoubleTapListener(onDoubleTapListener);
        }
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean isLongpressEnabled() {
        return this.f1787a.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f1787a.onTouchEvent(motionEvent);
    }

    public void setIsLongpressEnabled(boolean z) {
        this.f1787a.setIsLongpressEnabled(z);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f1787a.setOnDoubleTapListener(onDoubleTapListener);
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.f1787a = new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener, handler);
        } else {
            this.f1787a = new GestureDetectorCompatImplBase(context, onGestureListener, handler);
        }
    }
}

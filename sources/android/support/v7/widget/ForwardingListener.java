package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v7.view.menu.ShowableListMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* loaded from: classes.dex */
public abstract class ForwardingListener implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a */
    private final float f2783a;

    /* renamed from: b */
    private final int f2784b;

    /* renamed from: c */
    private final int f2785c;

    /* renamed from: d */
    final View f2786d;

    /* renamed from: e */
    private Runnable f2787e;

    /* renamed from: f */
    private Runnable f2788f;

    /* renamed from: g */
    private boolean f2789g;

    /* renamed from: h */
    private int f2790h;
    private final int[] i = new int[2];

    /* loaded from: classes.dex */
    public class DisallowIntercept implements Runnable {
        DisallowIntercept() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = ForwardingListener.this.f2786d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* loaded from: classes.dex */
    public class TriggerLongPress implements Runnable {
        TriggerLongPress() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ForwardingListener.this.a();
        }
    }

    public ForwardingListener(View view) {
        this.f2786d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f2783a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f2784b = ViewConfiguration.getTapTimeout();
        this.f2785c = (this.f2784b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:            if (r1 != 3) goto L57;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f2786d
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L41
            r3 = 1
            if (r1 == r3) goto L3d
            r4 = 2
            if (r1 == r4) goto L1a
            r6 = 3
            if (r1 == r6) goto L3d
            goto L6d
        L1a:
            int r1 = r5.f2790h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f2783a
            boolean r6 = a(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.b()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.b()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.f2790h = r6
            java.lang.Runnable r6 = r5.f2787e
            if (r6 != 0) goto L52
            android.support.v7.widget.ForwardingListener$DisallowIntercept r6 = new android.support.v7.widget.ForwardingListener$DisallowIntercept
            r6.<init>()
            r5.f2787e = r6
        L52:
            java.lang.Runnable r6 = r5.f2787e
            int r1 = r5.f2784b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f2788f
            if (r6 != 0) goto L65
            android.support.v7.widget.ForwardingListener$TriggerLongPress r6 = new android.support.v7.widget.ForwardingListener$TriggerLongPress
            r6.<init>()
            r5.f2788f = r6
        L65:
            java.lang.Runnable r6 = r5.f2788f
            int r1 = r5.f2785c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ForwardingListener.b(android.view.MotionEvent):boolean");
    }

    void a() {
        b();
        View view = this.f2786d;
        if (view.isEnabled() && !view.isLongClickable() && onForwardingStarted()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f2789g = true;
        }
    }

    public abstract ShowableListMenu getPopup();

    protected boolean onForwardingStarted() {
        ShowableListMenu popup = getPopup();
        if (popup == null || popup.isShowing()) {
            return true;
        }
        popup.show();
        return true;
    }

    protected boolean onForwardingStopped() {
        ShowableListMenu popup = getPopup();
        if (popup == null || !popup.isShowing()) {
            return true;
        }
        popup.dismiss();
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f2789g;
        if (z2) {
            z = a(motionEvent) || !onForwardingStopped();
        } else {
            z = b(motionEvent) && onForwardingStarted();
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f2786d.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f2789g = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f2789g = false;
        this.f2790h = -1;
        Runnable runnable = this.f2787e;
        if (runnable != null) {
            this.f2786d.removeCallbacks(runnable);
        }
    }

    private boolean a(MotionEvent motionEvent) {
        DropDownListView dropDownListView;
        View view = this.f2786d;
        ShowableListMenu popup = getPopup();
        if (popup == null || !popup.isShowing() || (dropDownListView = (DropDownListView) popup.getListView()) == null || !dropDownListView.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        a(view, obtainNoHistory);
        b(dropDownListView, obtainNoHistory);
        boolean onForwardedEvent = dropDownListView.onForwardedEvent(obtainNoHistory, this.f2790h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return onForwardedEvent && (actionMasked != 1 && actionMasked != 3);
    }

    private void b() {
        Runnable runnable = this.f2788f;
        if (runnable != null) {
            this.f2786d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f2787e;
        if (runnable2 != null) {
            this.f2786d.removeCallbacks(runnable2);
        }
    }

    private static boolean a(View view, float f2, float f3, float f4) {
        float f5 = -f4;
        return f2 >= f5 && f3 >= f5 && f2 < ((float) (view.getRight() - view.getLeft())) + f4 && f3 < ((float) (view.getBottom() - view.getTop())) + f4;
    }

    private boolean b(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.i);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.i);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }
}

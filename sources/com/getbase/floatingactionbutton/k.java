package com.getbase.floatingactionbutton;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;

/* compiled from: TouchDelegateGroup.java */
/* loaded from: classes.dex */
public class k extends TouchDelegate {

    /* renamed from: a */
    private static final Rect f9861a = new Rect();

    /* renamed from: b */
    private final ArrayList<TouchDelegate> f9862b;

    /* renamed from: c */
    private TouchDelegate f9863c;

    /* renamed from: d */
    private boolean f9864d;

    public k(View view) {
        super(f9861a, view);
        this.f9862b = new ArrayList<>();
    }

    public void a(TouchDelegate touchDelegate) {
        this.f9862b.add(touchDelegate);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:            if (r0 != 3) goto L55;     */
    @Override // android.view.TouchDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            boolean r0 = r6.f9864d
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getAction()
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L20
            if (r0 == r3) goto L1a
            r4 = 2
            if (r0 == r4) goto L17
            r4 = 3
            if (r0 == r4) goto L1a
            goto L3d
        L17:
            android.view.TouchDelegate r2 = r6.f9863c
            goto L3d
        L1a:
            android.view.TouchDelegate r0 = r6.f9863c
            r6.f9863c = r2
            r2 = r0
            goto L3d
        L20:
            r0 = 0
        L21:
            java.util.ArrayList<android.view.TouchDelegate> r4 = r6.f9862b
            int r4 = r4.size()
            if (r0 >= r4) goto L3d
            java.util.ArrayList<android.view.TouchDelegate> r4 = r6.f9862b
            java.lang.Object r4 = r4.get(r0)
            android.view.TouchDelegate r4 = (android.view.TouchDelegate) r4
            boolean r5 = r4.onTouchEvent(r7)
            if (r5 == 0) goto L3a
            r6.f9863c = r4
            return r3
        L3a:
            int r0 = r0 + 1
            goto L21
        L3d:
            if (r2 == 0) goto L46
            boolean r7 = r2.onTouchEvent(r7)
            if (r7 == 0) goto L46
            r1 = 1
        L46:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getbase.floatingactionbutton.k.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void a() {
        this.f9862b.clear();
        this.f9863c = null;
    }

    public void a(boolean z) {
        this.f9864d = z;
    }
}

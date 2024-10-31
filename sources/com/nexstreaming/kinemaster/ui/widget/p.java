package com.nexstreaming.kinemaster.ui.widget;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;

/* compiled from: PopoutMenu.java */
/* loaded from: classes2.dex */
public abstract class p {

    /* renamed from: a */
    private View f23877a;

    /* renamed from: b */
    PopupWindow f23878b;

    /* renamed from: c */
    Context f23879c;

    /* renamed from: d */
    private PopupWindow.OnDismissListener f23880d;

    /* renamed from: e */
    private PopupWindow.OnDismissListener f23881e = new o(this);

    public p(Context context) {
        this.f23879c = context;
    }

    protected abstract View a(Context context);

    public void a(View view, int i) {
        a(view, i, 0, 0);
    }

    public void b() {
        PopupWindow.OnDismissListener onDismissListener = this.f23880d;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
            this.f23880d = null;
        }
        this.f23877a = null;
        this.f23878b = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.view.View r9, int r10, int r11, int r12) {
        /*
            r8 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 17
            if (r0 < r1) goto Le
            int r0 = r9.getLayoutDirection()
            int r10 = android.view.Gravity.getAbsoluteGravity(r10, r0)
        Le:
            r0 = r10 & 7
            r10 = r10 & 112(0x70, float:1.57E-43)
            android.view.View r1 = r8.f23877a
            if (r1 != 0) goto L1e
            android.content.Context r1 = r8.f23879c
            android.view.View r1 = r8.a(r1)
            r8.f23877a = r1
        L1e:
            android.widget.PopupWindow r1 = r8.f23878b
            if (r1 != 0) goto L2b
            android.widget.PopupWindow r1 = new android.widget.PopupWindow
            android.view.View r2 = r8.f23877a
            r1.<init>(r2)
            r8.f23878b = r1
        L2b:
            android.view.View r1 = r8.f23877a
            r2 = 0
            r1.measure(r2, r2)
            r1 = 2
            int[] r3 = new int[r1]
            r9.getLocationInWindow(r3)
            android.view.View r4 = r8.f23877a
            int r4 = r4.getMeasuredWidth()
            android.view.View r5 = r8.f23877a
            int r5 = r5.getMeasuredHeight()
            r6 = 5
            r7 = 1
            if (r0 != r6) goto L4f
            r0 = r3[r2]
            int r6 = r9.getWidth()
        L4d:
            int r0 = r0 + r6
            goto L66
        L4f:
            if (r0 != r7) goto L59
            r0 = r3[r2]
            int r6 = r9.getWidth()
            int r6 = r6 / r1
            goto L4d
        L59:
            r6 = 3
            if (r0 != r6) goto L64
            r0 = r3[r2]
            int r0 = r0 - r4
            int r6 = r9.getPaddingLeft()
            goto L4d
        L64:
            r0 = r3[r2]
        L66:
            r6 = 48
            if (r10 != r6) goto L73
            r10 = r3[r7]
            int r10 = r10 - r5
            int r1 = r9.getPaddingTop()
            int r10 = r10 + r1
            goto L95
        L73:
            r6 = 16
            if (r10 != r6) goto L82
            r10 = r3[r7]
            int r3 = r9.getHeight()
            int r3 = r5 - r3
            int r3 = r3 / r1
            int r10 = r10 - r3
            goto L95
        L82:
            r1 = 80
            if (r10 != r1) goto L93
            r10 = r3[r7]
            int r1 = r9.getHeight()
            int r10 = r10 + r1
            int r1 = r9.getPaddingBottom()
            int r10 = r10 - r1
            goto L95
        L93:
            r10 = r3[r7]
        L95:
            android.widget.PopupWindow r1 = r8.f23878b
            android.graphics.drawable.ColorDrawable r3 = new android.graphics.drawable.ColorDrawable
            r3.<init>()
            r1.setBackgroundDrawable(r3)
            android.widget.PopupWindow r1 = r8.f23878b
            r1.setWidth(r4)
            android.widget.PopupWindow r1 = r8.f23878b
            r1.setHeight(r5)
            android.widget.PopupWindow r1 = r8.f23878b
            r1.setFocusable(r7)
            android.widget.PopupWindow r1 = r8.f23878b
            r1.setTouchable(r7)
            android.widget.PopupWindow r1 = r8.f23878b
            int r0 = r0 + r11
            int r10 = r10 + r12
            r1.showAtLocation(r9, r2, r0, r10)
            android.widget.PopupWindow r9 = r8.f23878b
            android.widget.PopupWindow$OnDismissListener r10 = r8.f23881e
            r9.setOnDismissListener(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.widget.p.a(android.view.View, int, int, int):void");
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.f23880d = onDismissListener;
    }

    public void a() {
        PopupWindow popupWindow = this.f23878b;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }
}

package com.nexstreaming.kinemaster.ui.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;

/* compiled from: PopoutMenu.java */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    private View f4395a;
    PopupWindow b;
    Context c;
    private PopupWindow.OnDismissListener d;
    private PopupWindow.OnDismissListener e = new k(this);

    protected abstract View a(Context context);

    public j(Context context) {
        this.c = context;
    }

    public void a(View view, int i) {
        a(view, i, 0, 0);
    }

    public void a(View view, int i, int i2, int i3) {
        int i4;
        int i5;
        if (Build.VERSION.SDK_INT >= 17) {
            i = Gravity.getAbsoluteGravity(i, view.getLayoutDirection());
        }
        int i6 = i & 7;
        int i7 = i & 112;
        if (this.f4395a == null) {
            this.f4395a = a(this.c);
        }
        if (this.b == null) {
            this.b = new PopupWindow(this.f4395a);
        }
        this.f4395a.measure(0, 0);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int measuredWidth = this.f4395a.getMeasuredWidth();
        int measuredHeight = this.f4395a.getMeasuredHeight();
        if (i6 == 5) {
            i4 = (iArr[0] + view.getWidth()) - view.getPaddingRight();
        } else if (i6 == 1) {
            i4 = iArr[0] + (view.getWidth() / 2);
        } else if (i6 == 3) {
            i4 = (iArr[0] - measuredWidth) + view.getPaddingLeft();
        } else {
            i4 = iArr[0];
        }
        if (i7 == 48) {
            i5 = (iArr[1] - measuredHeight) + view.getPaddingTop();
        } else if (i7 == 16) {
            i5 = iArr[1] - ((measuredHeight - view.getHeight()) / 2);
        } else if (i7 == 80) {
            i5 = (iArr[1] + view.getHeight()) - view.getPaddingBottom();
        } else {
            i5 = iArr[1];
        }
        this.b.setBackgroundDrawable(new ColorDrawable());
        this.b.setWidth(measuredWidth);
        this.b.setHeight(measuredHeight);
        this.b.setFocusable(true);
        this.b.setTouchable(true);
        this.b.showAtLocation(view, 0, i4 + i2, i5 + i3);
        this.b.setOnDismissListener(this.e);
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.d = onDismissListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.d != null) {
            this.d.onDismiss();
            this.d = null;
        }
        this.f4395a = null;
        this.b = null;
    }

    public void a() {
        if (this.b != null) {
            this.b.dismiss();
        }
    }
}

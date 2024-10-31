package android.support.design.widget;

import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.view.View;
import android.view.ViewParent;

/* compiled from: SwipeDismissBehavior.java */
/* loaded from: classes.dex */
class C extends ViewDragHelper.Callback {

    /* renamed from: a */
    private int f338a;

    /* renamed from: b */
    private int f339b = -1;

    /* renamed from: c */
    final /* synthetic */ SwipeDismissBehavior f340c;

    public C(SwipeDismissBehavior swipeDismissBehavior) {
        this.f340c = swipeDismissBehavior;
    }

    private boolean a(View view, float f2) {
        if (f2 == 0.0f) {
            return Math.abs(view.getLeft() - this.f338a) >= Math.round(((float) view.getWidth()) * this.f340c.f444g);
        }
        boolean z = ViewCompat.getLayoutDirection(view) == 1;
        int i = this.f340c.f443f;
        if (i == 2) {
            return true;
        }
        if (i == 0) {
            if (z) {
                if (f2 >= 0.0f) {
                    return false;
                }
            } else if (f2 <= 0.0f) {
                return false;
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        if (z) {
            if (f2 <= 0.0f) {
                return false;
            }
        } else if (f2 >= 0.0f) {
            return false;
        }
        return true;
    }

    @Override // android.support.v4.widget.ViewDragHelper.Callback
    public int clampViewPositionHorizontal(View view, int i, int i2) {
        int width;
        int width2;
        int width3;
        boolean z = ViewCompat.getLayoutDirection(view) == 1;
        int i3 = this.f340c.f443f;
        if (i3 == 0) {
            if (z) {
                width = this.f338a - view.getWidth();
                width2 = this.f338a;
            } else {
                width = this.f338a;
                width3 = view.getWidth();
                width2 = width3 + width;
            }
        } else if (i3 != 1) {
            width = this.f338a - view.getWidth();
            width2 = view.getWidth() + this.f338a;
        } else if (z) {
            width = this.f338a;
            width3 = view.getWidth();
            width2 = width3 + width;
        } else {
            width = this.f338a - view.getWidth();
            width2 = this.f338a;
        }
        return SwipeDismissBehavior.a(width, i, width2);
    }

    @Override // android.support.v4.widget.ViewDragHelper.Callback
    public int clampViewPositionVertical(View view, int i, int i2) {
        return view.getTop();
    }

    @Override // android.support.v4.widget.ViewDragHelper.Callback
    public int getViewHorizontalDragRange(View view) {
        return view.getWidth();
    }

    @Override // android.support.v4.widget.ViewDragHelper.Callback
    public void onViewCaptured(View view, int i) {
        this.f339b = i;
        this.f338a = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.support.v4.widget.ViewDragHelper.Callback
    public void onViewDragStateChanged(int i) {
        SwipeDismissBehavior.a aVar = this.f340c.f439b;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    @Override // android.support.v4.widget.ViewDragHelper.Callback
    public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        float width = this.f338a + (view.getWidth() * this.f340c.f445h);
        float width2 = this.f338a + (view.getWidth() * this.f340c.i);
        float f2 = i;
        if (f2 <= width) {
            view.setAlpha(1.0f);
        } else if (f2 >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(SwipeDismissBehavior.a(0.0f, 1.0f - SwipeDismissBehavior.b(width, width2, f2), 1.0f));
        }
    }

    @Override // android.support.v4.widget.ViewDragHelper.Callback
    public void onViewReleased(View view, float f2, float f3) {
        int i;
        boolean z;
        SwipeDismissBehavior.a aVar;
        this.f339b = -1;
        int width = view.getWidth();
        if (a(view, f2)) {
            int left = view.getLeft();
            int i2 = this.f338a;
            i = left < i2 ? i2 - width : i2 + width;
            z = true;
        } else {
            i = this.f338a;
            z = false;
        }
        if (this.f340c.f438a.settleCapturedViewAt(i, view.getTop())) {
            ViewCompat.postOnAnimation(view, new SwipeDismissBehavior.b(view, z));
        } else {
            if (!z || (aVar = this.f340c.f439b) == null) {
                return;
            }
            aVar.a(view);
        }
    }

    @Override // android.support.v4.widget.ViewDragHelper.Callback
    public boolean tryCaptureView(View view, int i) {
        return this.f339b == -1 && this.f340c.a(view);
    }
}

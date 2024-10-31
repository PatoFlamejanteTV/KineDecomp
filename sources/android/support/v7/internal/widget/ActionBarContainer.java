package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.b.a;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    Drawable f145a;
    Drawable b;
    Drawable c;
    boolean d;
    boolean e;
    private boolean f;
    private View g;
    private View h;
    private View i;
    private int j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundDrawable(android.support.v7.internal.a.a() ? new d(this) : new c(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.i.ActionBar);
        this.f145a = obtainStyledAttributes.getDrawable(a.i.ActionBar_background);
        this.b = obtainStyledAttributes.getDrawable(a.i.ActionBar_backgroundStacked);
        this.j = obtainStyledAttributes.getDimensionPixelSize(a.i.ActionBar_height, -1);
        if (getId() == a.e.split_action_bar) {
            this.d = true;
            this.c = obtainStyledAttributes.getDrawable(a.i.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        setWillNotDraw(this.d ? this.c == null : this.f145a == null && this.b == null);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.h = findViewById(a.e.action_bar);
        this.i = findViewById(a.e.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.f145a != null) {
            this.f145a.setCallback(null);
            unscheduleDrawable(this.f145a);
        }
        this.f145a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.h != null) {
                this.f145a.setBounds(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
            }
        }
        if (this.d) {
            if (this.c != null) {
                z = false;
            }
        } else if (this.f145a != null || this.b != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.b != null) {
            this.b.setCallback(null);
            unscheduleDrawable(this.b);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.e && this.b != null) {
                this.b.setBounds(this.g.getLeft(), this.g.getTop(), this.g.getRight(), this.g.getBottom());
            }
        }
        if (this.d) {
            if (this.c != null) {
                z = false;
            }
        } else if (this.f145a != null || this.b != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.c != null) {
            this.c.setCallback(null);
            unscheduleDrawable(this.c);
        }
        this.c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.d && this.c != null) {
                this.c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.d) {
            if (this.c != null) {
                z = false;
            }
        } else if (this.f145a != null || this.b != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f145a != null) {
            this.f145a.setVisible(z, false);
        }
        if (this.b != null) {
            this.b.setVisible(z, false);
        }
        if (this.c != null) {
            this.c.setVisible(z, false);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f145a && !this.d) || (drawable == this.b && this.e) || ((drawable == this.c && this.d) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f145a != null && this.f145a.isStateful()) {
            this.f145a.setState(getDrawableState());
        }
        if (this.b != null && this.b.isStateful()) {
            this.b.setState(getDrawableState());
        }
        if (this.c != null && this.c.isStateful()) {
            this.c.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f145a != null) {
                this.f145a.jumpToCurrentState();
            }
            if (this.b != null) {
                this.b.jumpToCurrentState();
            }
            if (this.c != null) {
                this.c.jumpToCurrentState();
            }
        }
    }

    public void setTransitioning(boolean z) {
        this.f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setTabContainer(s sVar) {
        if (this.g != null) {
            removeView(this.g);
        }
        this.g = sVar;
        if (sVar != null) {
            addView(sVar);
            ViewGroup.LayoutParams layoutParams = sVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            sVar.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.g;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    private boolean a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + view.getMeasuredHeight() + layoutParams.topMargin;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        if (this.h == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.j >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(this.j, View.MeasureSpec.getSize(i2)), NexEditorDeviceProfile.UNKNOWN);
        }
        super.onMeasure(i, i2);
        if (this.h != null) {
            int mode = View.MeasureSpec.getMode(i2);
            if (this.g != null && this.g.getVisibility() != 8 && mode != 1073741824) {
                if (!a(this.h)) {
                    i3 = b(this.h);
                } else if (!a(this.i)) {
                    i3 = b(this.i);
                } else {
                    i3 = 0;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i3 + b(this.g), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3 = true;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.g;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (this.d) {
            if (this.c != null) {
                this.c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z3 = false;
            }
        } else {
            if (this.f145a != null) {
                if (this.h.getVisibility() == 0) {
                    this.f145a.setBounds(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
                } else if (this.i != null && this.i.getVisibility() == 0) {
                    this.f145a.setBounds(this.i.getLeft(), this.i.getTop(), this.i.getRight(), this.i.getBottom());
                } else {
                    this.f145a.setBounds(0, 0, 0, 0);
                }
                z2 = true;
            } else {
                z2 = false;
            }
            this.e = z4;
            if (!z4 || this.b == null) {
                z3 = z2;
            } else {
                this.b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z3) {
            invalidate();
        }
    }
}

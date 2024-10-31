package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a */
    private boolean f2534a;

    /* renamed from: b */
    private View f2535b;

    /* renamed from: c */
    private View f2536c;

    /* renamed from: d */
    private View f2537d;

    /* renamed from: e */
    Drawable f2538e;

    /* renamed from: f */
    Drawable f2539f;

    /* renamed from: g */
    Drawable f2540g;

    /* renamed from: h */
    boolean f2541h;
    boolean i;
    private int j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2538e;
        if (drawable != null && drawable.isStateful()) {
            this.f2538e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f2539f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f2539f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f2540g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f2540g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f2535b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2538e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2539f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f2540g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f2536c = findViewById(R.id.action_bar);
        this.f2537d = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f2534a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Drawable drawable;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f2535b;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (this.f2541h) {
            Drawable drawable2 = this.f2540g;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f2538e != null) {
                if (this.f2536c.getVisibility() == 0) {
                    this.f2538e.setBounds(this.f2536c.getLeft(), this.f2536c.getTop(), this.f2536c.getRight(), this.f2536c.getBottom());
                } else {
                    View view2 = this.f2537d;
                    if (view2 != null && view2.getVisibility() == 0) {
                        this.f2538e.setBounds(this.f2537d.getLeft(), this.f2537d.getTop(), this.f2537d.getRight(), this.f2537d.getBottom());
                    } else {
                        this.f2538e.setBounds(0, 0, 0, 0);
                    }
                }
                z3 = true;
            }
            this.i = z4;
            if (!z4 || (drawable = this.f2539f) == null) {
                z2 = z3;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int a2;
        int i3;
        if (this.f2536c == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i3 = this.j) >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i3, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f2536c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        View view = this.f2535b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (!b(this.f2536c)) {
            a2 = a(this.f2536c);
        } else {
            a2 = !b(this.f2537d) ? a(this.f2537d) : 0;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(a2 + a(this.f2535b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f2538e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f2538e);
        }
        this.f2538e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f2536c;
            if (view != null) {
                this.f2538e.setBounds(view.getLeft(), this.f2536c.getTop(), this.f2536c.getRight(), this.f2536c.getBottom());
            }
        }
        boolean z = true;
        if (!this.f2541h ? this.f2538e != null || this.f2539f != null : this.f2540g != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f2540g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f2540g);
        }
        this.f2540g = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2541h && (drawable2 = this.f2540g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f2541h ? !(this.f2538e != null || this.f2539f != null) : this.f2540g == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f2539f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f2539f);
        }
        this.f2539f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.i && (drawable2 = this.f2539f) != null) {
                drawable2.setBounds(this.f2535b.getLeft(), this.f2535b.getTop(), this.f2535b.getRight(), this.f2535b.getBottom());
            }
        }
        boolean z = true;
        if (!this.f2541h ? this.f2538e != null || this.f2539f != null : this.f2540g != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f2535b;
        if (view != null) {
            removeView(view);
        }
        this.f2535b = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f2534a = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.f2538e;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f2539f;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f2540g;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f2538e && !this.f2541h) || (drawable == this.f2539f && this.i) || ((drawable == this.f2540g && this.f2541h) || super.verifyDrawable(drawable));
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewCompat.setBackground(this, Build.VERSION.SDK_INT >= 21 ? new ActionBarBackgroundDrawableV21(this) : new ActionBarBackgroundDrawable(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.f2538e = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.f2539f = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        if (getId() == R.id.split_action_bar) {
            this.f2541h = true;
            this.f2540g = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = false;
        if (!this.f2541h ? !(this.f2538e != null || this.f2539f != null) : this.f2540g == null) {
            z = true;
        }
        setWillNotDraw(z);
    }
}

package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.b.a;
import android.support.v7.widget.ActionMenuView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* loaded from: classes.dex */
public class ActionBarContextView extends a implements android.support.v4.g.ad {
    private CharSequence j;
    private CharSequence k;
    private View l;
    private View m;
    private LinearLayout n;
    private TextView o;
    private TextView p;
    private int q;
    private int r;
    private Drawable s;
    private boolean t;
    private int u;
    private android.support.v7.internal.view.c v;
    private boolean w;
    private int x;

    @Override // android.support.v7.internal.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // android.support.v7.internal.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    @Override // android.support.v7.internal.widget.a
    public /* bridge */ /* synthetic */ void setSplitView(ViewGroup viewGroup) {
        super.setSplitView(viewGroup);
    }

    @Override // android.support.v7.internal.widget.a
    public /* bridge */ /* synthetic */ void setSplitWhenNarrow(boolean z) {
        super.setSplitWhenNarrow(z);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0016a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ac a2 = ac.a(context, attributeSet, a.i.ActionMode, i, 0);
        setBackgroundDrawable(a2.a(a.i.ActionMode_background));
        this.q = a2.f(a.i.ActionMode_titleTextStyle, 0);
        this.r = a2.f(a.i.ActionMode_subtitleTextStyle, 0);
        this.h = a2.e(a.i.ActionMode_height, 0);
        this.s = a2.a(a.i.ActionMode_backgroundSplit);
        this.u = a2.f(a.i.ActionMode_closeItemLayout, a.g.abc_action_mode_close_item_material);
        a2.b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            this.d.d();
            this.d.f();
        }
    }

    @Override // android.support.v7.internal.widget.a
    public void setSplitToolbar(boolean z) {
        if (this.f != z) {
            if (this.d != null) {
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
                if (!z) {
                    this.c = (ActionMenuView) this.d.a(this);
                    this.c.setBackgroundDrawable(null);
                    ViewGroup viewGroup = (ViewGroup) this.c.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.c);
                    }
                    addView(this.c, layoutParams);
                } else {
                    this.d.a(getContext().getResources().getDisplayMetrics().widthPixels, true);
                    this.d.a(Integer.MAX_VALUE);
                    layoutParams.width = -1;
                    layoutParams.height = this.h;
                    this.c = (ActionMenuView) this.d.a(this);
                    this.c.setBackgroundDrawable(this.s);
                    ViewGroup viewGroup2 = (ViewGroup) this.c.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(this.c);
                    }
                    this.e.addView(this.c, layoutParams);
                }
            }
            super.setSplitToolbar(z);
        }
    }

    @Override // android.support.v7.internal.widget.a
    public void setContentHeight(int i) {
        this.h = i;
    }

    public void setCustomView(View view) {
        if (this.m != null) {
            removeView(this.m);
        }
        this.m = view;
        if (this.n != null) {
            removeView(this.n);
            this.n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.j = charSequence;
        b();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.k = charSequence;
        b();
    }

    public CharSequence getTitle() {
        return this.j;
    }

    public CharSequence getSubtitle() {
        return this.k;
    }

    private void b() {
        if (this.n == null) {
            LayoutInflater.from(getContext()).inflate(a.g.abc_action_bar_title_item, this);
            this.n = (LinearLayout) getChildAt(getChildCount() - 1);
            this.o = (TextView) this.n.findViewById(a.e.action_bar_title);
            this.p = (TextView) this.n.findViewById(a.e.action_bar_subtitle);
            if (this.q != 0) {
                this.o.setTextAppearance(getContext(), this.q);
            }
            if (this.r != 0) {
                this.p.setTextAppearance(getContext(), this.r);
            }
        }
        this.o.setText(this.j);
        this.p.setText(this.k);
        boolean z = !TextUtils.isEmpty(this.j);
        boolean z2 = TextUtils.isEmpty(this.k) ? false : true;
        this.p.setVisibility(z2 ? 0 : 8);
        this.n.setVisibility((z || z2) ? 0 : 8);
        if (this.n.getParent() == null) {
            addView(this.n);
        }
    }

    private void c() {
        android.support.v7.internal.view.c cVar = this.v;
        if (cVar != null) {
            this.v = null;
            cVar.b();
        }
    }

    public void a() {
        c();
        removeAllViews();
        if (this.e != null) {
            this.e.removeView(this.c);
        }
        this.m = null;
        this.c = null;
        this.w = false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.h > 0 ? this.h : View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i4 = size2 - paddingTop;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, NexEditorDeviceProfile.UNKNOWN);
        if (this.l != null) {
            int a2 = a(this.l, paddingLeft, makeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
            paddingLeft = a2 - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
        }
        if (this.c != null && this.c.getParent() == this) {
            paddingLeft = a(this.c, paddingLeft, makeMeasureSpec, 0);
        }
        if (this.n != null && this.m == null) {
            if (this.t) {
                this.n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                int measuredWidth = this.n.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.n.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = a(this.n, paddingLeft, makeMeasureSpec, 0);
            }
        }
        if (this.m != null) {
            ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
            int i5 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (layoutParams.width >= 0) {
                paddingLeft = Math.min(layoutParams.width, paddingLeft);
            }
            this.m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i5), View.MeasureSpec.makeMeasureSpec(layoutParams.height >= 0 ? Math.min(layoutParams.height, i4) : i4, layoutParams.height == -2 ? Integer.MIN_VALUE : 1073741824));
        }
        if (this.h <= 0) {
            int childCount = getChildCount();
            int i6 = 0;
            while (i3 < childCount) {
                int measuredHeight = getChildAt(i3).getMeasuredHeight() + paddingTop;
                if (measuredHeight <= i6) {
                    measuredHeight = i6;
                }
                i3++;
                i6 = measuredHeight;
            }
            setMeasuredDimension(size, i6);
            return;
        }
        setMeasuredDimension(size, size2);
    }

    private android.support.v7.internal.view.c d() {
        int childCount;
        android.support.v4.g.p.a(this.l, (-this.l.getWidth()) - ((ViewGroup.MarginLayoutParams) this.l.getLayoutParams()).leftMargin);
        android.support.v4.g.y a2 = android.support.v4.g.p.f(this.l).a(0.0f);
        a2.a(200L);
        a2.a(this);
        a2.a(new DecelerateInterpolator());
        android.support.v7.internal.view.c cVar = new android.support.v7.internal.view.c();
        cVar.a(a2);
        if (this.c != null && (childCount = this.c.getChildCount()) > 0) {
            int i = childCount - 1;
            int i2 = 0;
            while (i >= 0) {
                View childAt = this.c.getChildAt(i);
                android.support.v4.g.p.c(childAt, 0.0f);
                android.support.v4.g.y c = android.support.v4.g.p.f(childAt).c(1.0f);
                c.a(300L);
                cVar.a(c);
                i--;
                i2++;
            }
        }
        return cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean a2 = af.a(this);
        int paddingRight = a2 ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.l != null && this.l.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
            int i5 = a2 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = a2 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int a3 = a(paddingRight, i5, a2);
            paddingRight = a(a(this.l, a3, paddingTop, paddingTop2, a2) + a3, i6, a2);
            if (this.w) {
                this.x = 1;
                this.v = d();
                this.v.a();
                this.w = false;
            }
        }
        int i7 = paddingRight;
        if (this.n != null && this.m == null && this.n.getVisibility() != 8) {
            i7 += a(this.n, i7, paddingTop, paddingTop2, a2);
        }
        if (this.m != null) {
            int a4 = a(this.m, i7, paddingTop, paddingTop2, a2) + i7;
        }
        int paddingLeft = a2 ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.c != null) {
            int a5 = a(this.c, paddingLeft, paddingTop, paddingTop2, !a2) + paddingLeft;
        }
    }

    @Override // android.support.v4.g.ad
    public void a(View view) {
    }

    @Override // android.support.v4.g.ad
    public void b(View view) {
        if (this.x == 2) {
            a();
        }
        this.x = 0;
    }

    @Override // android.support.v4.g.ad
    public void c(View view) {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 14) {
            if (accessibilityEvent.getEventType() == 32) {
                accessibilityEvent.setSource(this);
                accessibilityEvent.setClassName(getClass().getName());
                accessibilityEvent.setPackageName(getContext().getPackageName());
                accessibilityEvent.setContentDescription(this.j);
                return;
            }
            super.onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    public void setTitleOptional(boolean z) {
        if (z != this.t) {
            requestLayout();
        }
        this.t = z;
    }
}

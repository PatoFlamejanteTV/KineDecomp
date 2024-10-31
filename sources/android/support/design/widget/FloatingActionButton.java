package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.C0194u;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewGroupUtils;
import android.support.v7.widget.AppCompatImageHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

@CoordinatorLayout.c(Behavior.class)
/* loaded from: classes.dex */
public class FloatingActionButton extends U {

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f405b;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f406c;

    /* renamed from: d, reason: collision with root package name */
    private int f407d;

    /* renamed from: e, reason: collision with root package name */
    private int f408e;

    /* renamed from: f, reason: collision with root package name */
    private int f409f;

    /* renamed from: g, reason: collision with root package name */
    int f410g;

    /* renamed from: h, reason: collision with root package name */
    private int f411h;
    boolean i;
    final Rect j;
    private final Rect k;
    private AppCompatImageHelper l;
    private C0194u m;

    /* loaded from: classes.dex */
    public static class Behavior extends CoordinatorLayout.b<FloatingActionButton> {

        /* renamed from: a, reason: collision with root package name */
        private Rect f412a;

        /* renamed from: b, reason: collision with root package name */
        private a f413b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f414c;

        public Behavior() {
            this.f414c = true;
        }

        private boolean b(View view, FloatingActionButton floatingActionButton) {
            if (!a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.e) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.a(this.f413b, false);
                return true;
            }
            floatingActionButton.b(this.f413b, false);
            return true;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.b.d.i.FloatingActionButton_Behavior_Layout);
            this.f414c = obtainStyledAttributes.getBoolean(b.b.d.i.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public void a(CoordinatorLayout.e eVar) {
            if (eVar.f359h == 0) {
                eVar.f359h = 80;
            }
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!a(view)) {
                return false;
            }
            b(view, floatingActionButton);
            return false;
        }

        private static boolean a(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.e) {
                return ((CoordinatorLayout.e) layoutParams).d() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean a(View view, FloatingActionButton floatingActionButton) {
            return this.f414c && ((CoordinatorLayout.e) floatingActionButton.getLayoutParams()).c() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!a(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f412a == null) {
                this.f412a = new Rect();
            }
            Rect rect = this.f412a;
            ViewGroupUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.a(this.f413b, false);
                return true;
            }
            floatingActionButton.b(this.f413b, false);
            return true;
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List<View> b2 = coordinatorLayout.b(floatingActionButton);
            int size = b2.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = b2.get(i2);
                if (view instanceof AppBarLayout) {
                    if (a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (a(view) && b(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.b(floatingActionButton, i);
            a(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.j;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        private void a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i;
            Rect rect = floatingActionButton.j;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.e eVar = (CoordinatorLayout.e) floatingActionButton.getLayoutParams();
            int i2 = 0;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) eVar).rightMargin) {
                i = rect.right;
            } else {
                i = floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) eVar).leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) {
                i2 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) eVar).topMargin) {
                i2 = -rect.top;
            }
            if (i2 != 0) {
                ViewCompat.offsetTopAndBottom(floatingActionButton, i2);
            }
            if (i != 0) {
                ViewCompat.offsetLeftAndRight(floatingActionButton, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract void a(FloatingActionButton floatingActionButton);

        public abstract void b(FloatingActionButton floatingActionButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements z {
        b() {
        }

        @Override // android.support.design.widget.z
        public boolean a() {
            return FloatingActionButton.this.i;
        }

        @Override // android.support.design.widget.z
        public float b() {
            return FloatingActionButton.this.getSizeDimension() / 2.0f;
        }

        @Override // android.support.design.widget.z
        public void setBackgroundDrawable(Drawable drawable) {
            FloatingActionButton.super.setBackgroundDrawable(drawable);
        }

        @Override // android.support.design.widget.z
        public void setShadowPadding(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.j.set(i, i2, i3, i4);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            int i5 = floatingActionButton.f410g;
            floatingActionButton.setPadding(i + i5, i2 + i5, i3 + i5, i4 + i5);
        }
    }

    private C0194u getImpl() {
        if (this.m == null) {
            this.m = a();
        }
        return this.m;
    }

    void b(a aVar, boolean z) {
        getImpl().b(a(aVar), z);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().a(getDrawableState());
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f405b;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f406c;
    }

    public float getCompatElevation() {
        return getImpl().b();
    }

    public Drawable getContentBackground() {
        return getImpl().a();
    }

    public int getCustomSize() {
        return this.f409f;
    }

    public int getRippleColor() {
        return this.f407d;
    }

    public int getSize() {
        return this.f408e;
    }

    int getSizeDimension() {
        return a(this.f408e);
    }

    public boolean getUseCompatPadding() {
        return this.i;
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().e();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().f();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().h();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.f410g = (sizeDimension - this.f411h) / 2;
        getImpl().k();
        int min = Math.min(a(sizeDimension, i), a(sizeDimension, i2));
        Rect rect = this.j;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && a(this.k) && !this.k.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f405b != colorStateList) {
            this.f405b = colorStateList;
            getImpl().a(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f406c != mode) {
            this.f406c = mode;
            getImpl().a(mode);
        }
    }

    public void setCompatElevation(float f2) {
        getImpl().a(f2);
    }

    public void setCustomSize(int i) {
        if (i >= 0) {
            this.f409f = i;
            return;
        }
        throw new IllegalArgumentException("Custom size should be non-negative.");
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.l.setImageResource(i);
    }

    public void setRippleColor(int i) {
        if (this.f407d != i) {
            this.f407d = i;
            getImpl().a(i);
        }
    }

    public void setSize(int i) {
        if (i != this.f408e) {
            this.f408e = i;
            requestLayout();
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.i != z) {
            this.i = z;
            getImpl().g();
        }
    }

    @Override // android.support.design.widget.U, android.widget.ImageView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    void a(a aVar, boolean z) {
        getImpl().a(a(aVar), z);
    }

    private C0194u.c a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new C0191q(this, aVar);
    }

    private int a(int i) {
        Resources resources = getResources();
        int i2 = this.f409f;
        if (i2 != 0) {
            return i2;
        }
        if (i != -1) {
            if (i != 1) {
                return resources.getDimensionPixelSize(b.b.d.b.design_fab_size_normal);
            }
            return resources.getDimensionPixelSize(b.b.d.b.design_fab_size_mini);
        }
        if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return a(1);
        }
        return a(0);
    }

    public boolean a(Rect rect) {
        if (!ViewCompat.isLaidOut(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        int i = rect.left;
        Rect rect2 = this.j;
        rect.left = i + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
        return true;
    }

    private static int a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            return (mode == 0 || mode != 1073741824) ? i : size;
        }
        return Math.min(i, size);
    }

    private C0194u a() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new v(this, new b());
        }
        return new C0194u(this, new b());
    }
}

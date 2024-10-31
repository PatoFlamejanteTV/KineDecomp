package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v7.b.a;
import android.support.v7.widget.ActionMenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* compiled from: AbsActionBarView.java */
/* loaded from: classes.dex */
abstract class a extends ViewGroup {
    private static final Interpolator j = new DecelerateInterpolator();

    /* renamed from: a, reason: collision with root package name */
    protected final C0019a f159a;
    protected final Context b;
    protected ActionMenuView c;
    protected android.support.v7.widget.a d;
    protected ViewGroup e;
    protected boolean f;
    protected boolean g;
    protected int h;
    protected android.support.v4.g.y i;

    a(Context context) {
        this(context, null);
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f159a = new C0019a();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(a.C0016a.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.b = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.b = context;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, a.i.ActionBar, a.C0016a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(a.i.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.d != null) {
            this.d.a(configuration);
        }
    }

    public void setSplitToolbar(boolean z) {
        this.f = z;
    }

    public void setSplitWhenNarrow(boolean z) {
        this.g = z;
    }

    public void setContentHeight(int i) {
        this.h = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.h;
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.e = viewGroup;
    }

    public int getAnimatedVisibility() {
        return this.i != null ? this.f159a.f160a : getVisibility();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, NexEditorDeviceProfile.UNKNOWN), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    /* compiled from: AbsActionBarView.java */
    /* renamed from: android.support.v7.internal.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    protected class C0019a implements android.support.v4.g.ad {

        /* renamed from: a, reason: collision with root package name */
        int f160a;
        private boolean c = false;

        protected C0019a() {
        }

        @Override // android.support.v4.g.ad
        public void a(View view) {
            a.this.setVisibility(0);
            this.c = false;
        }

        @Override // android.support.v4.g.ad
        public void b(View view) {
            if (!this.c) {
                a.this.i = null;
                a.this.setVisibility(this.f160a);
                if (a.this.e != null && a.this.c != null) {
                    a.this.c.setVisibility(this.f160a);
                }
            }
        }

        @Override // android.support.v4.g.ad
        public void c(View view) {
            this.c = true;
        }
    }
}

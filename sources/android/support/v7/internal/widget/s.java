package android.support.v7.internal.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.a.a;
import android.support.v7.b.a;
import android.support.v7.internal.widget.j;
import android.support.v7.widget.e;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/* compiled from: ScrollingTabContainerView.java */
/* loaded from: classes.dex */
public class s extends HorizontalScrollView implements j.b {
    private static final Interpolator j = new DecelerateInterpolator();

    /* renamed from: a, reason: collision with root package name */
    Runnable f186a;
    int b;
    int c;
    private b d;
    private android.support.v7.widget.e e;
    private SpinnerCompat f;
    private boolean g;
    private int h;
    private int i;

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.e.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.b = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.b = View.MeasureSpec.getSize(i) / 2;
            }
            this.b = Math.min(this.b, this.c);
        } else {
            this.b = -1;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
        if (!z && this.g) {
            this.e.measure(0, makeMeasureSpec);
            if (this.e.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                b();
            } else {
                c();
            }
        } else {
            c();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z && measuredWidth != measuredWidth2) {
            setTabSelected(this.i);
        }
    }

    private boolean a() {
        return this.f != null && this.f.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.g = z;
    }

    private void b() {
        t tVar = null;
        if (!a()) {
            if (this.f == null) {
                this.f = d();
            }
            removeView(this.e);
            addView(this.f, new ViewGroup.LayoutParams(-2, -1));
            if (this.f.getAdapter() == null) {
                this.f.setAdapter(new a(this, tVar));
            }
            if (this.f186a != null) {
                removeCallbacks(this.f186a);
                this.f186a = null;
            }
            this.f.setSelection(this.i);
        }
    }

    private boolean c() {
        if (a()) {
            removeView(this.f);
            addView(this.e, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.f.getSelectedItemPosition());
        }
        return false;
    }

    public void setTabSelected(int i) {
        this.i = i;
        int childCount = this.e.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.e.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                a(i);
            }
            i2++;
        }
        if (this.f != null && i >= 0) {
            this.f.setSelection(i);
        }
    }

    public void setContentHeight(int i) {
        this.h = i;
        requestLayout();
    }

    private SpinnerCompat d() {
        SpinnerCompat spinnerCompat = new SpinnerCompat(getContext(), null, a.C0016a.actionDropDownStyle);
        spinnerCompat.setLayoutParams(new e.a(-2, -1));
        spinnerCompat.a((j.b) this);
        return spinnerCompat;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        android.support.v7.internal.view.a a2 = android.support.v7.internal.view.a.a(getContext());
        setContentHeight(a2.e());
        this.c = a2.f();
    }

    public void a(int i) {
        View childAt = this.e.getChildAt(i);
        if (this.f186a != null) {
            removeCallbacks(this.f186a);
        }
        this.f186a = new t(this, childAt);
        post(this.f186a);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f186a != null) {
            post(this.f186a);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f186a != null) {
            removeCallbacks(this.f186a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c a(a.b bVar, boolean z) {
        t tVar = null;
        c cVar = new c(getContext(), bVar, z);
        if (z) {
            cVar.setBackgroundDrawable(null);
            cVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.h));
        } else {
            cVar.setFocusable(true);
            if (this.d == null) {
                this.d = new b(this, tVar);
            }
            cVar.setOnClickListener(this.d);
        }
        return cVar;
    }

    @Override // android.support.v7.internal.widget.j.b
    public void a(j<?> jVar, View view, int i, long j2) {
        ((c) view).b().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class c extends android.support.v7.widget.e implements View.OnLongClickListener {
        private final int[] b;
        private a.b c;
        private TextView d;
        private ImageView e;
        private View f;

        public c(Context context, a.b bVar, boolean z) {
            super(context, null, a.C0016a.actionBarTabStyle);
            this.b = new int[]{R.attr.background};
            this.c = bVar;
            ac a2 = ac.a(context, null, this.b, a.C0016a.actionBarTabStyle, 0);
            if (a2.d(0)) {
                setBackgroundDrawable(a2.a(0));
            }
            a2.b();
            if (z) {
                setGravity(8388627);
            }
            a();
        }

        public void a(a.b bVar) {
            this.c = bVar;
            a();
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        @Override // android.support.v7.widget.e, android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(a.b.class.getName());
        }

        @Override // android.support.v7.widget.e, android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (Build.VERSION.SDK_INT >= 14) {
                accessibilityNodeInfo.setClassName(a.b.class.getName());
            }
        }

        @Override // android.support.v7.widget.e, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (s.this.b > 0 && getMeasuredWidth() > s.this.b) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(s.this.b, 1073741824), i2);
            }
        }

        public void a() {
            a.b bVar = this.c;
            View c = bVar.c();
            if (c != null) {
                ViewParent parent = c.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(c);
                    }
                    addView(c);
                }
                this.f = c;
                if (this.d != null) {
                    this.d.setVisibility(8);
                }
                if (this.e != null) {
                    this.e.setVisibility(8);
                    this.e.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (this.f != null) {
                removeView(this.f);
                this.f = null;
            }
            Drawable a2 = bVar.a();
            CharSequence b = bVar.b();
            if (a2 != null) {
                if (this.e == null) {
                    ImageView imageView = new ImageView(getContext());
                    e.a aVar = new e.a(-2, -2);
                    aVar.h = 16;
                    imageView.setLayoutParams(aVar);
                    addView(imageView, 0);
                    this.e = imageView;
                }
                this.e.setImageDrawable(a2);
                this.e.setVisibility(0);
            } else if (this.e != null) {
                this.e.setVisibility(8);
                this.e.setImageDrawable(null);
            }
            boolean z = !TextUtils.isEmpty(b);
            if (z) {
                if (this.d == null) {
                    android.support.v7.widget.d dVar = new android.support.v7.widget.d(getContext(), null, a.C0016a.actionBarTabTextStyle);
                    dVar.setEllipsize(TextUtils.TruncateAt.END);
                    e.a aVar2 = new e.a(-2, -2);
                    aVar2.h = 16;
                    dVar.setLayoutParams(aVar2);
                    addView(dVar);
                    this.d = dVar;
                }
                this.d.setText(b);
                this.d.setVisibility(0);
            } else if (this.d != null) {
                this.d.setVisibility(8);
                this.d.setText((CharSequence) null);
            }
            if (this.e != null) {
                this.e.setContentDescription(bVar.e());
            }
            if (!z && !TextUtils.isEmpty(bVar.e())) {
                setOnLongClickListener(this);
            } else {
                setOnLongClickListener(null);
                setLongClickable(false);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.c.e(), 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }

        public a.b b() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(s sVar, t tVar) {
            this();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return s.this.e.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((c) s.this.e.getChildAt(i)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return s.this.a((a.b) getItem(i), true);
            }
            ((c) view).a((a.b) getItem(i));
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private b() {
        }

        /* synthetic */ b(s sVar, t tVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((c) view).b().d();
            int childCount = s.this.e.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = s.this.e.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }
}

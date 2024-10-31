package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

/* loaded from: classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    private static final Interpolator f2998a = new DecelerateInterpolator();

    /* renamed from: b, reason: collision with root package name */
    Runnable f2999b;

    /* renamed from: c, reason: collision with root package name */
    private TabClickListener f3000c;

    /* renamed from: d, reason: collision with root package name */
    LinearLayoutCompat f3001d;

    /* renamed from: e, reason: collision with root package name */
    private Spinner f3002e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3003f;

    /* renamed from: g, reason: collision with root package name */
    int f3004g;

    /* renamed from: h, reason: collision with root package name */
    int f3005h;
    private int i;
    private int j;
    protected ViewPropertyAnimator k;
    protected final VisibilityAnimListener l;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class TabAdapter extends BaseAdapter {
        TabAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ScrollingTabContainerView.this.f3001d.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((TabView) ScrollingTabContainerView.this.f3001d.getChildAt(i)).getTab();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.a((ActionBar.Tab) getItem(i), true);
            }
            ((TabView) view).bindTab((ActionBar.Tab) getItem(i));
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class TabClickListener implements View.OnClickListener {
        TabClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((TabView) view).getTab().select();
            int childCount = ScrollingTabContainerView.this.f3001d.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ScrollingTabContainerView.this.f3001d.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class TabView extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        private final int[] f3010a;

        /* renamed from: b, reason: collision with root package name */
        private ActionBar.Tab f3011b;

        /* renamed from: c, reason: collision with root package name */
        private TextView f3012c;

        /* renamed from: d, reason: collision with root package name */
        private ImageView f3013d;

        /* renamed from: e, reason: collision with root package name */
        private View f3014e;

        public TabView(Context context, ActionBar.Tab tab, boolean z) {
            super(context, null, R.attr.actionBarTabStyle);
            this.f3010a = new int[]{android.R.attr.background};
            this.f3011b = tab;
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, null, this.f3010a, R.attr.actionBarTabStyle, 0);
            if (obtainStyledAttributes.hasValue(0)) {
                setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            }
            obtainStyledAttributes.recycle();
            if (z) {
                setGravity(8388627);
            }
            update();
        }

        public void bindTab(ActionBar.Tab tab) {
            this.f3011b = tab;
            update();
        }

        public ActionBar.Tab getTab() {
            return this.f3011b;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (ScrollingTabContainerView.this.f3004g > 0) {
                int measuredWidth = getMeasuredWidth();
                int i3 = ScrollingTabContainerView.this.f3004g;
                if (measuredWidth > i3) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        public void update() {
            ActionBar.Tab tab = this.f3011b;
            View customView = tab.getCustomView();
            if (customView != null) {
                ViewParent parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(customView);
                    }
                    addView(customView);
                }
                this.f3014e = customView;
                TextView textView = this.f3012c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f3013d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f3013d.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f3014e;
            if (view != null) {
                removeView(view);
                this.f3014e = null;
            }
            Drawable icon = tab.getIcon();
            CharSequence text = tab.getText();
            if (icon != null) {
                if (this.f3013d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f3013d = appCompatImageView;
                }
                this.f3013d.setImageDrawable(icon);
                this.f3013d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f3013d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f3013d.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(text);
            if (z) {
                if (this.f3012c == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f3012c = appCompatTextView;
                }
                this.f3012c.setText(text);
                this.f3012c.setVisibility(0);
            } else {
                TextView textView2 = this.f3012c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f3012c.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f3013d;
            if (imageView3 != null) {
                imageView3.setContentDescription(tab.getContentDescription());
            }
            TooltipCompat.setTooltipText(this, z ? null : tab.getContentDescription());
        }
    }

    /* loaded from: classes.dex */
    protected class VisibilityAnimListener extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f3016a = false;

        /* renamed from: b, reason: collision with root package name */
        private int f3017b;

        protected VisibilityAnimListener() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3016a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f3016a) {
                return;
            }
            ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
            scrollingTabContainerView.k = null;
            scrollingTabContainerView.setVisibility(this.f3017b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f3016a = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimator viewPropertyAnimator, int i) {
            this.f3017b = i;
            ScrollingTabContainerView.this.k = viewPropertyAnimator;
            return this;
        }
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        this.l = new VisibilityAnimListener();
        setHorizontalScrollBarEnabled(false);
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.f3005h = actionBarPolicy.getStackedTabMaxWidth();
        this.f3001d = b();
        addView(this.f3001d, new ViewGroup.LayoutParams(-2, -1));
    }

    private Spinner a() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private LinearLayoutCompat b() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    private boolean c() {
        Spinner spinner = this.f3002e;
        return spinner != null && spinner.getParent() == this;
    }

    private void d() {
        if (c()) {
            return;
        }
        if (this.f3002e == null) {
            this.f3002e = a();
        }
        removeView(this.f3001d);
        addView(this.f3002e, new ViewGroup.LayoutParams(-2, -1));
        if (this.f3002e.getAdapter() == null) {
            this.f3002e.setAdapter((SpinnerAdapter) new TabAdapter());
        }
        Runnable runnable = this.f2999b;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f2999b = null;
        }
        this.f3002e.setSelection(this.j);
    }

    private boolean e() {
        if (!c()) {
            return false;
        }
        removeView(this.f3002e);
        addView(this.f3001d, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f3002e.getSelectedItemPosition());
        return false;
    }

    public void addTab(ActionBar.Tab tab, boolean z) {
        TabView a2 = a(tab, false);
        this.f3001d.addView(a2, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.f3002e;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            a2.setSelected(true);
        }
        if (this.f3003f) {
            requestLayout();
        }
    }

    public void animateToTab(int i) {
        final View childAt = this.f3001d.getChildAt(i);
        Runnable runnable = this.f2999b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.f2999b = new Runnable() { // from class: android.support.v7.widget.ScrollingTabContainerView.1
            @Override // java.lang.Runnable
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
                ScrollingTabContainerView.this.f2999b = null;
            }
        };
        post(this.f2999b);
    }

    public void animateToVisibility(int i) {
        ViewPropertyAnimator viewPropertyAnimator = this.k;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            ViewPropertyAnimator alpha = animate().alpha(1.0f);
            alpha.setDuration(200L);
            alpha.setInterpolator(f2998a);
            alpha.setListener(this.l.withFinalVisibility(alpha, i));
            alpha.start();
            return;
        }
        ViewPropertyAnimator alpha2 = animate().alpha(0.0f);
        alpha2.setDuration(200L);
        alpha2.setInterpolator(f2998a);
        alpha2.setListener(this.l.withFinalVisibility(alpha2, i));
        alpha2.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f2999b;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(getContext());
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.f3005h = actionBarPolicy.getStackedTabMaxWidth();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f2999b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((TabView) view).getTab().select();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f3001d.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.f3004g = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.f3004g = View.MeasureSpec.getSize(i) / 2;
            }
            this.f3004g = Math.min(this.f3004g, this.f3005h);
        } else {
            this.f3004g = -1;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.i, 1073741824);
        if (!z && this.f3003f) {
            this.f3001d.measure(0, makeMeasureSpec);
            if (this.f3001d.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                d();
            } else {
                e();
            }
        } else {
            e();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.j);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void removeAllTabs() {
        this.f3001d.removeAllViews();
        Spinner spinner = this.f3002e;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f3003f) {
            requestLayout();
        }
    }

    public void removeTabAt(int i) {
        this.f3001d.removeViewAt(i);
        Spinner spinner = this.f3002e;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f3003f) {
            requestLayout();
        }
    }

    public void setAllowCollapse(boolean z) {
        this.f3003f = z;
    }

    public void setContentHeight(int i) {
        this.i = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.j = i;
        int childCount = this.f3001d.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f3001d.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                animateToTab(i);
            }
            i2++;
        }
        Spinner spinner = this.f3002e;
        if (spinner == null || i < 0) {
            return;
        }
        spinner.setSelection(i);
    }

    public void updateTab(int i) {
        ((TabView) this.f3001d.getChildAt(i)).update();
        Spinner spinner = this.f3002e;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f3003f) {
            requestLayout();
        }
    }

    TabView a(ActionBar.Tab tab, boolean z) {
        TabView tabView = new TabView(getContext(), tab, z);
        if (z) {
            tabView.setBackgroundDrawable(null);
            tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.i));
        } else {
            tabView.setFocusable(true);
            if (this.f3000c == null) {
                this.f3000c = new TabClickListener();
            }
            tabView.setOnClickListener(this.f3000c);
        }
        return tabView;
    }

    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        TabView a2 = a(tab, false);
        this.f3001d.addView(a2, i, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.f3002e;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            a2.setSelected(true);
        }
        if (this.f3003f) {
            requestLayout();
        }
    }
}

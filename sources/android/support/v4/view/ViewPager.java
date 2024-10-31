package android.support.v4.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;

    /* renamed from: a */
    static final int[] f1840a = {R.attr.layout_gravity};

    /* renamed from: b */
    private static final Comparator<ItemInfo> f1841b = new Comparator<ItemInfo>() { // from class: android.support.v4.view.ViewPager.1
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.f1852b - itemInfo2.f1852b;
        }
    };

    /* renamed from: c */
    private static final Interpolator f1842c = new Interpolator() { // from class: android.support.v4.view.ViewPager.2
        AnonymousClass2() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };

    /* renamed from: d */
    private static final ViewPositionComparator f1843d = new ViewPositionComparator();
    private boolean A;
    private int B;
    private boolean C;
    private boolean D;
    private int E;
    private int F;
    private int G;
    private float H;
    private float I;
    private float J;
    private float K;
    private int L;
    private VelocityTracker M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private boolean R;
    private long S;
    private EdgeEffect T;
    private EdgeEffect U;
    private boolean V;
    private boolean W;
    private boolean aa;
    private int ba;
    private List<OnPageChangeListener> ca;
    private OnPageChangeListener da;

    /* renamed from: e */
    private int f1844e;
    private OnPageChangeListener ea;

    /* renamed from: f */
    private final ArrayList<ItemInfo> f1845f;
    private List<OnAdapterChangeListener> fa;

    /* renamed from: g */
    private final ItemInfo f1846g;
    private PageTransformer ga;

    /* renamed from: h */
    private final Rect f1847h;
    private int ha;
    PagerAdapter i;
    private int ia;
    int j;
    private ArrayList<View> ja;
    private int k;
    private final Runnable ka;
    private Parcelable l;
    private int la;
    private ClassLoader m;
    private Scroller n;
    private boolean o;
    private PagerObserver p;
    private int q;
    private Drawable r;
    private int s;
    private int t;
    private float u;
    private float v;
    private int w;
    private int x;
    private boolean y;
    private boolean z;

    /* renamed from: android.support.v4.view.ViewPager$1 */
    /* loaded from: classes.dex */
    static class AnonymousClass1 implements Comparator<ItemInfo> {
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.f1852b - itemInfo2.f1852b;
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$2 */
    /* loaded from: classes.dex */
    static class AnonymousClass2 implements Interpolator {
        AnonymousClass2() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v4.view.ViewPager$3 */
    /* loaded from: classes.dex */
    public class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.e();
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$4 */
    /* loaded from: classes.dex */
    public class AnonymousClass4 implements OnApplyWindowInsetsListener {

        /* renamed from: a */
        private final Rect f1849a = new Rect();

        AnonymousClass4() {
        }

        @Override // android.support.v4.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
            if (onApplyWindowInsets.isConsumed()) {
                return onApplyWindowInsets;
            }
            Rect rect = this.f1849a;
            rect.left = onApplyWindowInsets.getSystemWindowInsetLeft();
            rect.top = onApplyWindowInsets.getSystemWindowInsetTop();
            rect.right = onApplyWindowInsets.getSystemWindowInsetRight();
            rect.bottom = onApplyWindowInsets.getSystemWindowInsetBottom();
            int childCount = ViewPager.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                WindowInsetsCompat dispatchApplyWindowInsets = ViewCompat.dispatchApplyWindowInsets(ViewPager.this.getChildAt(i), onApplyWindowInsets);
                rect.left = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetLeft(), rect.left);
                rect.top = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetTop(), rect.top);
                rect.right = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetRight(), rect.right);
                rect.bottom = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetBottom(), rect.bottom);
            }
            return onApplyWindowInsets.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface DecorView {
    }

    /* loaded from: classes.dex */
    public static class ItemInfo {

        /* renamed from: a */
        Object f1851a;

        /* renamed from: b */
        int f1852b;

        /* renamed from: c */
        boolean f1853c;

        /* renamed from: d */
        float f1854d;

        /* renamed from: e */
        float f1855e;

        ItemInfo() {
        }
    }

    /* loaded from: classes.dex */
    public class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        MyAccessibilityDelegate() {
        }

        private boolean b() {
            PagerAdapter pagerAdapter = ViewPager.this.i;
            return pagerAdapter != null && pagerAdapter.getCount() > 1;
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            PagerAdapter pagerAdapter;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(b());
            if (accessibilityEvent.getEventType() != 4096 || (pagerAdapter = ViewPager.this.i) == null) {
                return;
            }
            accessibilityEvent.setItemCount(pagerAdapter.getCount());
            accessibilityEvent.setFromIndex(ViewPager.this.j);
            accessibilityEvent.setToIndex(ViewPager.this.j);
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(b());
            if (ViewPager.this.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.j - 1);
                return true;
            }
            if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            }
            ViewPager viewPager2 = ViewPager.this;
            viewPager2.setCurrentItem(viewPager2.j + 1);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface OnAdapterChangeListener {
        void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* loaded from: classes.dex */
    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f2, int i2);

        void onPageSelected(int i);
    }

    /* loaded from: classes.dex */
    public interface PageTransformer {
        void transformPage(View view, float f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PagerObserver extends DataSetObserver {
        PagerObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.a();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.a();
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.v4.view.ViewPager.SavedState.1
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };

        /* renamed from: b */
        int f1862b;

        /* renamed from: c */
        Parcelable f1863c;

        /* renamed from: d */
        ClassLoader f1864d;

        /* renamed from: android.support.v4.view.ViewPager$SavedState$1 */
        /* loaded from: classes.dex */
        static class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f1862b + "}";
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1862b);
            parcel.writeParcelable(this.f1863c, i);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? SavedState.class.getClassLoader() : classLoader;
            this.f1862b = parcel.readInt();
            this.f1863c = parcel.readParcelable(classLoader);
            this.f1864d = classLoader;
        }
    }

    /* loaded from: classes.dex */
    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
        }
    }

    /* loaded from: classes.dex */
    public static class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z = layoutParams.isDecor;
            if (z != layoutParams2.isDecor) {
                return z ? 1 : -1;
            }
            return layoutParams.f1858c - layoutParams2.f1858c;
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.f1845f = new ArrayList<>();
        this.f1846g = new ItemInfo();
        this.f1847h = new Rect();
        this.k = -1;
        this.l = null;
        this.m = null;
        this.u = -3.4028235E38f;
        this.v = Float.MAX_VALUE;
        this.B = 1;
        this.L = -1;
        this.V = true;
        this.W = false;
        this.ka = new Runnable() { // from class: android.support.v4.view.ViewPager.3
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.e();
            }
        };
        this.la = 0;
        b();
    }

    private static boolean c(View view) {
        return view.getClass().getAnnotation(DecorView.class) != null;
    }

    private void d(int i) {
        OnPageChangeListener onPageChangeListener = this.da;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
        List<OnPageChangeListener> list = this.ca;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener2 = this.ca.get(i2);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageScrollStateChanged(i);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.ea;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageScrollStateChanged(i);
        }
    }

    private void f() {
        this.C = false;
        this.D = false;
        VelocityTracker velocityTracker = this.M;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.M = null;
        }
    }

    private ItemInfo g() {
        int i;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.q / clientWidth : 0.0f;
        ItemInfo itemInfo = null;
        int i2 = 0;
        boolean z = true;
        int i3 = -1;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (i2 < this.f1845f.size()) {
            ItemInfo itemInfo2 = this.f1845f.get(i2);
            if (!z && itemInfo2.f1852b != (i = i3 + 1)) {
                itemInfo2 = this.f1846g;
                itemInfo2.f1855e = f3 + f4 + f2;
                itemInfo2.f1852b = i;
                itemInfo2.f1854d = this.i.getPageWidth(itemInfo2.f1852b);
                i2--;
            }
            f3 = itemInfo2.f1855e;
            float f5 = itemInfo2.f1854d + f3 + f2;
            if (!z && scrollX < f3) {
                return itemInfo;
            }
            if (scrollX < f5 || i2 == this.f1845f.size() - 1) {
                return itemInfo2;
            }
            i3 = itemInfo2.f1852b;
            f4 = itemInfo2.f1854d;
            i2++;
            itemInfo = itemInfo2;
            z = false;
        }
        return itemInfo;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void h() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).isDecor) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    private boolean i() {
        this.L = -1;
        f();
        this.T.onRelease();
        this.U.onRelease();
        return this.T.isFinished() || this.U.isFinished();
    }

    private void j() {
        if (this.ia != 0) {
            ArrayList<View> arrayList = this.ja;
            if (arrayList == null) {
                this.ja = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ja.add(getChildAt(i));
            }
            Collections.sort(this.ja, f1843d);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.z != z) {
            this.z = z;
        }
    }

    void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        ItemInfo b2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.f1852b == this.j) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    public void addOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        if (this.fa == null) {
            this.fa = new ArrayList();
        }
        this.fa.add(onAdapterChangeListener);
    }

    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.ca == null) {
            this.ca = new ArrayList();
        }
        this.ca.add(onPageChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        ItemInfo b2;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.f1852b == this.j) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        layoutParams2.isDecor |= c(view);
        if (this.y) {
            if (layoutParams2 != null && layoutParams2.isDecor) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams2.f1857b = true;
            addViewInLayout(view, i, layoutParams);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public boolean arrowScroll(int i) {
        boolean requestFocus;
        boolean z;
        View findFocus = findFocus();
        boolean z2 = false;
        View view = null;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    }
                    if (parent == this) {
                        z = true;
                        break;
                    }
                    parent = parent.getParent();
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus != null && findNextFocus != view) {
            if (i == 17) {
                int i2 = a(this.f1847h, findNextFocus).left;
                int i3 = a(this.f1847h, view).left;
                if (view != null && i2 >= i3) {
                    requestFocus = c();
                } else {
                    requestFocus = findNextFocus.requestFocus();
                }
            } else if (i == 66) {
                int i4 = a(this.f1847h, findNextFocus).left;
                int i5 = a(this.f1847h, view).left;
                if (view != null && i4 <= i5) {
                    requestFocus = d();
                } else {
                    requestFocus = findNextFocus.requestFocus();
                }
            }
            z2 = requestFocus;
        } else if (i == 17 || i == 1) {
            z2 = c();
        } else if (i == 66 || i == 2) {
            z2 = d();
        }
        if (z2) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return z2;
    }

    void b() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.n = new Scroller(context, f1842c);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.G = viewConfiguration.getScaledPagingTouchSlop();
        this.N = (int) (400.0f * f2);
        this.O = viewConfiguration.getScaledMaximumFlingVelocity();
        this.T = new EdgeEffect(context);
        this.U = new EdgeEffect(context);
        this.P = (int) (25.0f * f2);
        this.Q = (int) (2.0f * f2);
        this.E = (int) (f2 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: android.support.v4.view.ViewPager.4

            /* renamed from: a */
            private final Rect f1849a = new Rect();

            AnonymousClass4() {
            }

            @Override // android.support.v4.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
                if (onApplyWindowInsets.isConsumed()) {
                    return onApplyWindowInsets;
                }
                Rect rect = this.f1849a;
                rect.left = onApplyWindowInsets.getSystemWindowInsetLeft();
                rect.top = onApplyWindowInsets.getSystemWindowInsetTop();
                rect.right = onApplyWindowInsets.getSystemWindowInsetRight();
                rect.bottom = onApplyWindowInsets.getSystemWindowInsetBottom();
                int childCount = ViewPager.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    WindowInsetsCompat dispatchApplyWindowInsets = ViewCompat.dispatchApplyWindowInsets(ViewPager.this.getChildAt(i), onApplyWindowInsets);
                    rect.left = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetLeft(), rect.left);
                    rect.top = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetTop(), rect.top);
                    rect.right = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetRight(), rect.right);
                    rect.bottom = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetBottom(), rect.bottom);
                }
                return onApplyWindowInsets.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    public boolean beginFakeDrag() {
        if (this.C) {
            return false;
        }
        this.R = true;
        setScrollState(1);
        this.H = 0.0f;
        this.J = 0.0f;
        VelocityTracker velocityTracker = this.M;
        if (velocityTracker == null) {
            this.M = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.M.addMovement(obtain);
        obtain.recycle();
        this.S = uptimeMillis;
        return true;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.i == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i < 0 ? scrollX > ((int) (((float) clientWidth) * this.u)) : i > 0 && scrollX < ((int) (((float) clientWidth) * this.v));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void clearOnPageChangeListeners() {
        List<OnPageChangeListener> list = this.ca;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        this.o = true;
        if (!this.n.isFinished() && this.n.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.n.getCurrX();
            int currY = this.n.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!e(currX)) {
                    this.n.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        a(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo b2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.f1852b == this.j && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode != 0 && (overScrollMode != 1 || (pagerAdapter = this.i) == null || pagerAdapter.getCount() <= 1)) {
            this.T.finish();
            this.U.finish();
        } else {
            if (!this.T.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.u * width);
                this.T.setSize(height, width);
                z = false | this.T.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.U.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.v + 1.0f)) * width2);
                this.U.setSize(height2, width2);
                z |= this.U.draw(canvas);
                canvas.restoreToCount(save2);
            }
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.r;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    void e() {
        b(this.j);
    }

    public void endFakeDrag() {
        if (this.R) {
            if (this.i != null) {
                VelocityTracker velocityTracker = this.M;
                velocityTracker.computeCurrentVelocity(1000, this.O);
                int xVelocity = (int) velocityTracker.getXVelocity(this.L);
                this.A = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                ItemInfo g2 = g();
                a(a(g2.f1852b, ((scrollX / clientWidth) - g2.f1855e) / g2.f1854d, xVelocity, (int) (this.H - this.J)), true, true, xVelocity);
            }
            f();
            this.R = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                if (keyEvent.hasModifiers(2)) {
                    return c();
                }
                return arrowScroll(17);
            }
            if (keyCode == 22) {
                if (keyEvent.hasModifiers(2)) {
                    return d();
                }
                return arrowScroll(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return arrowScroll(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return arrowScroll(1);
                }
            }
        }
        return false;
    }

    public void fakeDragBy(float f2) {
        if (this.R) {
            if (this.i == null) {
                return;
            }
            this.H += f2;
            float scrollX = getScrollX() - f2;
            float clientWidth = getClientWidth();
            float f3 = this.u * clientWidth;
            float f4 = this.v * clientWidth;
            ItemInfo itemInfo = this.f1845f.get(0);
            ItemInfo itemInfo2 = this.f1845f.get(r4.size() - 1);
            if (itemInfo.f1852b != 0) {
                f3 = itemInfo.f1855e * clientWidth;
            }
            if (itemInfo2.f1852b != this.i.getCount() - 1) {
                f4 = itemInfo2.f1855e * clientWidth;
            }
            if (scrollX < f3) {
                scrollX = f3;
            } else if (scrollX > f4) {
                scrollX = f4;
            }
            int i = (int) scrollX;
            this.H += scrollX - i;
            scrollTo(i, getScrollY());
            e(i);
            MotionEvent obtain = MotionEvent.obtain(this.S, SystemClock.uptimeMillis(), 2, this.H, 0.0f, 0);
            this.M.addMovement(obtain);
            obtain.recycle();
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.i;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ia == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) this.ja.get(i2).getLayoutParams()).f1859d;
    }

    public int getCurrentItem() {
        return this.j;
    }

    public int getOffscreenPageLimit() {
        return this.B;
    }

    public int getPageMargin() {
        return this.q;
    }

    public boolean isFakeDragging() {
        return this.R;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.V = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.ka);
        Scroller scroller = this.n;
        if (scroller != null && !scroller.isFinished()) {
            this.n.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.q <= 0 || this.r == null || this.f1845f.size() <= 0 || this.i == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f4 = this.q / width;
        int i = 0;
        ItemInfo itemInfo = this.f1845f.get(0);
        float f5 = itemInfo.f1855e;
        int size = this.f1845f.size();
        int i2 = itemInfo.f1852b;
        int i3 = this.f1845f.get(size - 1).f1852b;
        while (i2 < i3) {
            while (i2 > itemInfo.f1852b && i < size) {
                i++;
                itemInfo = this.f1845f.get(i);
            }
            if (i2 == itemInfo.f1852b) {
                float f6 = itemInfo.f1855e;
                float f7 = itemInfo.f1854d;
                f2 = (f6 + f7) * width;
                f5 = f6 + f7 + f4;
            } else {
                float pageWidth = this.i.getPageWidth(i2);
                f2 = (f5 + pageWidth) * width;
                f5 += pageWidth + f4;
            }
            if (this.q + f2 > scrollX) {
                f3 = f4;
                this.r.setBounds(Math.round(f2), this.s, Math.round(this.q + f2), this.t);
                this.r.draw(canvas);
            } else {
                f3 = f4;
            }
            if (f2 > scrollX + r2) {
                return;
            }
            i2++;
            f4 = f3;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.C) {
                    return true;
                }
                if (this.D) {
                    return false;
                }
            }
            if (action == 0) {
                float x = motionEvent.getX();
                this.J = x;
                this.H = x;
                float y = motionEvent.getY();
                this.K = y;
                this.I = y;
                this.L = motionEvent.getPointerId(0);
                this.D = false;
                this.o = true;
                this.n.computeScrollOffset();
                if (this.la == 2 && Math.abs(this.n.getFinalX() - this.n.getCurrX()) > this.Q) {
                    this.n.abortAnimation();
                    this.A = false;
                    e();
                    this.C = true;
                    c(true);
                    setScrollState(1);
                } else {
                    a(false);
                    this.C = false;
                }
            } else if (action == 2) {
                int i = this.L;
                if (i != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float f2 = x2 - this.H;
                    float abs = Math.abs(f2);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float abs2 = Math.abs(y2 - this.K);
                    if (f2 != 0.0f && !a(this.H, f2) && a(this, false, (int) f2, (int) x2, (int) y2)) {
                        this.H = x2;
                        this.I = y2;
                        this.D = true;
                        return false;
                    }
                    if (abs > this.G && abs * 0.5f > abs2) {
                        this.C = true;
                        c(true);
                        setScrollState(1);
                        this.H = f2 > 0.0f ? this.J + this.G : this.J - this.G;
                        this.I = y2;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > this.G) {
                        this.D = true;
                    }
                    if (this.C && b(x2)) {
                        ViewCompat.postInvalidateOnAnimation(this);
                    }
                }
            } else if (action == 6) {
                a(motionEvent);
            }
            if (this.M == null) {
                this.M = VelocityTracker.obtain();
            }
            this.M.addMovement(motionEvent);
            return this.C;
        }
        i();
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        ItemInfo b2;
        int max;
        int max2;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = paddingBottom;
        int i8 = 0;
        int i9 = paddingTop;
        int i10 = paddingLeft;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i12 = layoutParams.gravity;
                    int i13 = i12 & 7;
                    int i14 = i12 & 112;
                    if (i13 == 1) {
                        max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, i10);
                    } else if (i13 == 3) {
                        max = i10;
                        i10 = childAt.getMeasuredWidth() + i10;
                    } else if (i13 != 5) {
                        max = i10;
                    } else {
                        max = (i5 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i14 == 16) {
                        max2 = Math.max((i6 - childAt.getMeasuredHeight()) / 2, i9);
                    } else if (i14 == 48) {
                        max2 = i9;
                        i9 = childAt.getMeasuredHeight() + i9;
                    } else if (i14 != 80) {
                        max2 = i9;
                    } else {
                        max2 = (i6 - i7) - childAt.getMeasuredHeight();
                        i7 += childAt.getMeasuredHeight();
                    }
                    int i15 = max + scrollX;
                    childAt.layout(i15, max2, childAt.getMeasuredWidth() + i15, max2 + childAt.getMeasuredHeight());
                    i8++;
                }
            }
        }
        int i16 = (i5 - i10) - paddingRight;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt2 = getChildAt(i17);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.isDecor && (b2 = b(childAt2)) != null) {
                    float f2 = i16;
                    int i18 = ((int) (b2.f1855e * f2)) + i10;
                    if (layoutParams2.f1857b) {
                        layoutParams2.f1857b = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f2 * layoutParams2.f1856a), 1073741824), View.MeasureSpec.makeMeasureSpec((i6 - i9) - i7, 1073741824));
                    }
                    childAt2.layout(i18, i9, childAt2.getMeasuredWidth() + i18, childAt2.getMeasuredHeight() + i9);
                }
            }
        }
        this.s = i9;
        this.t = i6 - i7;
        this.ba = i8;
        if (this.V) {
            z2 = false;
            a(this.j, false, 0, false);
        } else {
            z2 = false;
        }
        this.V = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        ItemInfo b2;
        int childCount = getChildCount();
        int i4 = -1;
        if ((i & 2) != 0) {
            i4 = childCount;
            i2 = 0;
            i3 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
        }
        while (i2 != i4) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.f1852b == this.j && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        PagerAdapter pagerAdapter = this.i;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(savedState.f1863c, savedState.f1864d);
            a(savedState.f1862b, false, true);
        } else {
            this.k = savedState.f1862b;
            this.l = savedState.f1863c;
            this.m = savedState.f1864d;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1862b = this.j;
        PagerAdapter pagerAdapter = this.i;
        if (pagerAdapter != null) {
            savedState.f1863c = pagerAdapter.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.q;
            a(i, i3, i5, i5);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        if (this.R) {
            return true;
        }
        boolean z = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.i) == null || pagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.M == null) {
            this.M = VelocityTracker.obtain();
        }
        this.M.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.n.abortAnimation();
            this.A = false;
            e();
            float x = motionEvent.getX();
            this.J = x;
            this.H = x;
            float y = motionEvent.getY();
            this.K = y;
            this.I = y;
            this.L = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.C) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.L);
                    if (findPointerIndex == -1) {
                        z = i();
                    } else {
                        float x2 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x2 - this.H);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y2 - this.I);
                        if (abs > this.G && abs > abs2) {
                            this.C = true;
                            c(true);
                            float f2 = this.J;
                            this.H = x2 - f2 > 0.0f ? f2 + this.G : f2 - this.G;
                            this.I = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.C) {
                    z = false | b(motionEvent.getX(motionEvent.findPointerIndex(this.L)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.H = motionEvent.getX(actionIndex);
                    this.L = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    a(motionEvent);
                    this.H = motionEvent.getX(motionEvent.findPointerIndex(this.L));
                }
            } else if (this.C) {
                a(this.j, true, 0, false);
                z = i();
            }
        } else if (this.C) {
            VelocityTracker velocityTracker = this.M;
            velocityTracker.computeCurrentVelocity(1000, this.O);
            int xVelocity = (int) velocityTracker.getXVelocity(this.L);
            this.A = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            ItemInfo g2 = g();
            float f3 = clientWidth;
            a(a(g2.f1852b, ((scrollX / f3) - g2.f1855e) / (g2.f1854d + (this.q / f3)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.L)) - this.J)), true, true, xVelocity);
            z = i();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    public void removeOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        List<OnAdapterChangeListener> list = this.fa;
        if (list != null) {
            list.remove(onAdapterChangeListener);
        }
    }

    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        List<OnPageChangeListener> list = this.ca;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.y) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        PagerAdapter pagerAdapter2 = this.i;
        if (pagerAdapter2 != null) {
            pagerAdapter2.a(null);
            this.i.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.f1845f.size(); i++) {
                ItemInfo itemInfo = this.f1845f.get(i);
                this.i.destroyItem((ViewGroup) this, itemInfo.f1852b, itemInfo.f1851a);
            }
            this.i.finishUpdate((ViewGroup) this);
            this.f1845f.clear();
            h();
            this.j = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.i;
        this.i = pagerAdapter;
        this.f1844e = 0;
        if (this.i != null) {
            if (this.p == null) {
                this.p = new PagerObserver();
            }
            this.i.a(this.p);
            this.A = false;
            boolean z = this.V;
            this.V = true;
            this.f1844e = this.i.getCount();
            if (this.k >= 0) {
                this.i.restoreState(this.l, this.m);
                a(this.k, false, true);
                this.k = -1;
                this.l = null;
                this.m = null;
            } else if (!z) {
                e();
            } else {
                requestLayout();
            }
        }
        List<OnAdapterChangeListener> list = this.fa;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.fa.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.fa.get(i2).onAdapterChanged(this, pagerAdapter3, pagerAdapter);
        }
    }

    public void setCurrentItem(int i) {
        this.A = false;
        a(i, !this.V, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.B) {
            this.B = i;
            e();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.da = onPageChangeListener;
    }

    public void setPageMargin(int i) {
        int i2 = this.q;
        this.q = i;
        int width = getWidth();
        a(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.r = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer) {
        setPageTransformer(z, pageTransformer, 2);
    }

    void setScrollState(int i) {
        if (this.la == i) {
            return;
        }
        this.la = i;
        if (this.ga != null) {
            b(i != 0);
        }
        d(i);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.r;
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a */
        float f1856a;

        /* renamed from: b */
        boolean f1857b;

        /* renamed from: c */
        int f1858c;

        /* renamed from: d */
        int f1859d;
        public int gravity;
        public boolean isDecor;

        public LayoutParams() {
            super(-1, -1);
            this.f1856a = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1856a = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f1840a);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    private boolean e(int i) {
        if (this.f1845f.size() == 0) {
            if (this.V) {
                return false;
            }
            this.aa = false;
            a(0, 0.0f, 0);
            if (this.aa) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ItemInfo g2 = g();
        int clientWidth = getClientWidth();
        int i2 = this.q;
        int i3 = clientWidth + i2;
        float f2 = clientWidth;
        int i4 = g2.f1852b;
        float f3 = ((i / f2) - g2.f1855e) / (g2.f1854d + (i2 / f2));
        this.aa = false;
        a(i4, f3, (int) (i3 * f3));
        if (this.aa) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    void a(int i, boolean z, boolean z2, int i2) {
        PagerAdapter pagerAdapter = this.i;
        if (pagerAdapter != null && pagerAdapter.getCount() > 0) {
            if (!z2 && this.j == i && this.f1845f.size() != 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            if (i < 0) {
                i = 0;
            } else if (i >= this.i.getCount()) {
                i = this.i.getCount() - 1;
            }
            int i3 = this.B;
            int i4 = this.j;
            if (i > i4 + i3 || i < i4 - i3) {
                for (int i5 = 0; i5 < this.f1845f.size(); i5++) {
                    this.f1845f.get(i5).f1853c = true;
                }
            }
            boolean z3 = this.j != i;
            if (this.V) {
                this.j = i;
                if (z3) {
                    c(i);
                }
                requestLayout();
                return;
            }
            b(i);
            a(i, z, i2, z3);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer, int i) {
        boolean z2 = pageTransformer != null;
        boolean z3 = z2 != (this.ga != null);
        this.ga = pageTransformer;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.ia = z ? 2 : 1;
            this.ha = i;
        } else {
            this.ia = 0;
        }
        if (z3) {
            e();
        }
    }

    private void c(int i) {
        OnPageChangeListener onPageChangeListener = this.da;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i);
        }
        List<OnPageChangeListener> list = this.ca;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener2 = this.ca.get(i2);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageSelected(i);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.ea;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageSelected(i);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        this.A = false;
        a(i, z, false);
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), i));
    }

    boolean d() {
        PagerAdapter pagerAdapter = this.i;
        if (pagerAdapter == null || this.j >= pagerAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.j + 1, true);
        return true;
    }

    private void c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    boolean c() {
        int i = this.j;
        if (i <= 0) {
            return false;
        }
        setCurrentItem(i - 1, true);
        return true;
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1845f = new ArrayList<>();
        this.f1846g = new ItemInfo();
        this.f1847h = new Rect();
        this.k = -1;
        this.l = null;
        this.m = null;
        this.u = -3.4028235E38f;
        this.v = Float.MAX_VALUE;
        this.B = 1;
        this.L = -1;
        this.V = true;
        this.W = false;
        this.ka = new Runnable() { // from class: android.support.v4.view.ViewPager.3
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.e();
            }
        };
        this.la = 0;
        b();
    }

    private void a(int i, boolean z, int i2, boolean z2) {
        ItemInfo a2 = a(i);
        int clientWidth = a2 != null ? (int) (getClientWidth() * Math.max(this.u, Math.min(a2.f1855e, this.v))) : 0;
        if (z) {
            a(clientWidth, 0, i2);
            if (z2) {
                c(i);
                return;
            }
            return;
        }
        if (z2) {
            c(i);
        }
        a(false);
        scrollTo(clientWidth, 0);
        e(clientWidth);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:            if (r9 == r10) goto L213;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:            r8 = null;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void b(int r18) {
        /*
            Method dump skipped, instructions count: 619
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.b(int):void");
    }

    public OnPageChangeListener a(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.ea;
        this.ea = onPageChangeListener;
        return onPageChangeListener2;
    }

    float a(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    void a(int i, int i2, int i3) {
        int scrollX;
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.n;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.o ? this.n.getCurrX() : this.n.getStartX();
            this.n.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i4 = scrollX;
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            a(false);
            e();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float f2 = clientWidth;
        float f3 = i7;
        float a2 = f3 + (a(Math.min(1.0f, (Math.abs(i5) * 1.0f) / f2)) * f3);
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(a2 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i5) / ((f2 * this.i.getPageWidth(this.j)) + this.q)) + 1.0f) * 100.0f);
        }
        int min = Math.min(abs, 600);
        this.o = false;
        this.n.startScroll(i4, scrollY, i5, i6, min);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    ItemInfo a(int i, int i2) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.f1852b = i;
        itemInfo.f1851a = this.i.instantiateItem((ViewGroup) this, i);
        itemInfo.f1854d = this.i.getPageWidth(i);
        if (i2 >= 0 && i2 < this.f1845f.size()) {
            this.f1845f.add(i2, itemInfo);
        } else {
            this.f1845f.add(itemInfo);
        }
        return itemInfo;
    }

    void a() {
        int count = this.i.getCount();
        this.f1844e = count;
        boolean z = this.f1845f.size() < (this.B * 2) + 1 && this.f1845f.size() < count;
        int i = this.j;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.f1845f.size()) {
            ItemInfo itemInfo = this.f1845f.get(i2);
            int itemPosition = this.i.getItemPosition(itemInfo.f1851a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f1845f.remove(i2);
                    i2--;
                    if (!z2) {
                        this.i.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.i.destroyItem((ViewGroup) this, itemInfo.f1852b, itemInfo.f1851a);
                    int i3 = this.j;
                    if (i3 == itemInfo.f1852b) {
                        i = Math.max(0, Math.min(i3, count - 1));
                    }
                } else {
                    int i4 = itemInfo.f1852b;
                    if (i4 != itemPosition) {
                        if (i4 == this.j) {
                            i = itemPosition;
                        }
                        itemInfo.f1852b = itemPosition;
                    }
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.i.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f1845f, f1841b);
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.f1856a = 0.0f;
                }
            }
            a(i, false, true);
            requestLayout();
        }
    }

    private void a(ItemInfo itemInfo, int i, ItemInfo itemInfo2) {
        int i2;
        int i3;
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        int count = this.i.getCount();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.q / clientWidth : 0.0f;
        if (itemInfo2 != null) {
            int i4 = itemInfo2.f1852b;
            int i5 = itemInfo.f1852b;
            if (i4 < i5) {
                float f3 = itemInfo2.f1855e + itemInfo2.f1854d + f2;
                int i6 = i4 + 1;
                int i7 = 0;
                while (i6 <= itemInfo.f1852b && i7 < this.f1845f.size()) {
                    ItemInfo itemInfo5 = this.f1845f.get(i7);
                    while (true) {
                        itemInfo4 = itemInfo5;
                        if (i6 <= itemInfo4.f1852b || i7 >= this.f1845f.size() - 1) {
                            break;
                        }
                        i7++;
                        itemInfo5 = this.f1845f.get(i7);
                    }
                    while (i6 < itemInfo4.f1852b) {
                        f3 += this.i.getPageWidth(i6) + f2;
                        i6++;
                    }
                    itemInfo4.f1855e = f3;
                    f3 += itemInfo4.f1854d + f2;
                    i6++;
                }
            } else if (i4 > i5) {
                int size = this.f1845f.size() - 1;
                float f4 = itemInfo2.f1855e;
                while (true) {
                    i4--;
                    if (i4 < itemInfo.f1852b || size < 0) {
                        break;
                    }
                    ItemInfo itemInfo6 = this.f1845f.get(size);
                    while (true) {
                        itemInfo3 = itemInfo6;
                        if (i4 >= itemInfo3.f1852b || size <= 0) {
                            break;
                        }
                        size--;
                        itemInfo6 = this.f1845f.get(size);
                    }
                    while (i4 > itemInfo3.f1852b) {
                        f4 -= this.i.getPageWidth(i4) + f2;
                        i4--;
                    }
                    f4 -= itemInfo3.f1854d + f2;
                    itemInfo3.f1855e = f4;
                }
            }
        }
        int size2 = this.f1845f.size();
        float f5 = itemInfo.f1855e;
        int i8 = itemInfo.f1852b;
        int i9 = i8 - 1;
        this.u = i8 == 0 ? f5 : -3.4028235E38f;
        int i10 = count - 1;
        this.v = itemInfo.f1852b == i10 ? (itemInfo.f1855e + itemInfo.f1854d) - 1.0f : Float.MAX_VALUE;
        int i11 = i - 1;
        while (i11 >= 0) {
            ItemInfo itemInfo7 = this.f1845f.get(i11);
            while (true) {
                i3 = itemInfo7.f1852b;
                if (i9 <= i3) {
                    break;
                }
                f5 -= this.i.getPageWidth(i9) + f2;
                i9--;
            }
            f5 -= itemInfo7.f1854d + f2;
            itemInfo7.f1855e = f5;
            if (i3 == 0) {
                this.u = f5;
            }
            i11--;
            i9--;
        }
        float f6 = itemInfo.f1855e + itemInfo.f1854d + f2;
        int i12 = itemInfo.f1852b + 1;
        int i13 = i + 1;
        while (i13 < size2) {
            ItemInfo itemInfo8 = this.f1845f.get(i13);
            while (true) {
                i2 = itemInfo8.f1852b;
                if (i12 >= i2) {
                    break;
                }
                f6 += this.i.getPageWidth(i12) + f2;
                i12++;
            }
            if (i2 == i10) {
                this.v = (itemInfo8.f1854d + f6) - 1.0f;
            }
            itemInfo8.f1855e = f6;
            f6 += itemInfo8.f1854d + f2;
            i13++;
            i12++;
        }
        this.W = false;
    }

    ItemInfo b(View view) {
        for (int i = 0; i < this.f1845f.size(); i++) {
            ItemInfo itemInfo = this.f1845f.get(i);
            if (this.i.isViewFromObject(view, itemInfo.f1851a)) {
                return itemInfo;
            }
        }
        return null;
    }

    private void b(int i, float f2, int i2) {
        OnPageChangeListener onPageChangeListener = this.da;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f2, i2);
        }
        List<OnPageChangeListener> list = this.ca;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                OnPageChangeListener onPageChangeListener2 = this.ca.get(i3);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageScrolled(i, f2, i2);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.ea;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageScrolled(i, f2, i2);
        }
    }

    private void b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.ha : 0, null);
        }
    }

    private boolean b(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.H - f2;
        this.H = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.u * clientWidth;
        float f5 = this.v * clientWidth;
        boolean z3 = false;
        ItemInfo itemInfo = this.f1845f.get(0);
        ArrayList<ItemInfo> arrayList = this.f1845f;
        ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
        if (itemInfo.f1852b != 0) {
            f4 = itemInfo.f1855e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (itemInfo2.f1852b != this.i.getCount() - 1) {
            f5 = itemInfo2.f1855e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.T.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z2) {
                this.U.onPull(Math.abs(scrollX - f5) / clientWidth);
                z3 = true;
            }
            scrollX = f5;
        }
        int i = (int) scrollX;
        this.H += scrollX - i;
        scrollTo(i, getScrollY());
        e(i);
        return z3;
    }

    ItemInfo a(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return b(view);
            }
        }
    }

    ItemInfo a(int i) {
        for (int i2 = 0; i2 < this.f1845f.size(); i2++) {
            ItemInfo itemInfo = this.f1845f.get(i2);
            if (itemInfo.f1852b == i) {
                return itemInfo;
            }
        }
        return null;
    }

    private void a(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.f1845f.isEmpty()) {
            if (!this.n.isFinished()) {
                this.n.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
                return;
            }
        }
        ItemInfo a2 = a(this.j);
        int min = (int) ((a2 != null ? Math.min(a2.f1855e, this.v) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (min != getScrollX()) {
            a(false);
            scrollTo(min, getScrollY());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void a(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.ba
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6d
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r4
            r4 = r3
            r3 = 0
        L1d:
            if (r3 >= r6) goto L6d
            android.view.View r8 = r12.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            android.support.v4.view.ViewPager$LayoutParams r9 = (android.support.v4.view.ViewPager.LayoutParams) r9
            boolean r10 = r9.isDecor
            if (r10 != 0) goto L2e
            goto L6a
        L2e:
            int r9 = r9.gravity
            r9 = r9 & 7
            if (r9 == r2) goto L4f
            r10 = 3
            if (r9 == r10) goto L49
            r10 = 5
            if (r9 == r10) goto L3c
            r9 = r4
            goto L5e
        L3c:
            int r9 = r5 - r7
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r7 = r7 + r10
            goto L5b
        L49:
            int r9 = r8.getWidth()
            int r9 = r9 + r4
            goto L5e
        L4f:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r4)
        L5b:
            r11 = r9
            r9 = r4
            r4 = r11
        L5e:
            int r4 = r4 + r0
            int r10 = r8.getLeft()
            int r4 = r4 - r10
            if (r4 == 0) goto L69
            r8.offsetLeftAndRight(r4)
        L69:
            r4 = r9
        L6a:
            int r3 = r3 + 1
            goto L1d
        L6d:
            r12.b(r13, r14, r15)
            android.support.v4.view.ViewPager$PageTransformer r13 = r12.ga
            if (r13 == 0) goto La1
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L7c:
            if (r1 >= r14) goto La1
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            android.support.v4.view.ViewPager$LayoutParams r0 = (android.support.v4.view.ViewPager.LayoutParams) r0
            boolean r0 = r0.isDecor
            if (r0 == 0) goto L8d
            goto L9e
        L8d:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            android.support.v4.view.ViewPager$PageTransformer r3 = r12.ga
            r3.transformPage(r15, r0)
        L9e:
            int r1 = r1 + 1
            goto L7c
        La1:
            r12.aa = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.a(int, float, int):void");
    }

    private void a(boolean z) {
        boolean z2 = this.la == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.n.isFinished()) {
                this.n.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.n.getCurrX();
                int currY = this.n.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        e(currX);
                    }
                }
            }
        }
        this.A = false;
        boolean z3 = z2;
        for (int i = 0; i < this.f1845f.size(); i++) {
            ItemInfo itemInfo = this.f1845f.get(i);
            if (itemInfo.f1853c) {
                itemInfo.f1853c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                ViewCompat.postOnAnimation(this, this.ka);
            } else {
                this.ka.run();
            }
        }
    }

    private boolean a(float f2, float f3) {
        return (f2 < ((float) this.F) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.F)) && f3 < 0.0f);
    }

    private int a(int i, float f2, int i2, int i3) {
        if (Math.abs(i3) <= this.P || Math.abs(i2) <= this.N) {
            i += (int) (f2 + (i >= this.j ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f1845f.size() <= 0) {
            return i;
        }
        return Math.max(this.f1845f.get(0).f1852b, Math.min(i, this.f1845f.get(r4.size() - 1).f1852b));
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.L) {
            int i = actionIndex == 0 ? 1 : 0;
            this.H = motionEvent.getX(i);
            this.L = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.M;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    protected boolean a(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && a(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    private Rect a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }
}

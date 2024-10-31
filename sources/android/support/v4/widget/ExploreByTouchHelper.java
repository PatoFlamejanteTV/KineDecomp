package android.support.v4.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewParentCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.FocusStrategy;
import android.support.v7.widget.ActivityChooserView;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    private static final Rect f1991d = new Rect(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: e, reason: collision with root package name */
    private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> f1992e = new FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat>() { // from class: android.support.v4.widget.ExploreByTouchHelper.1
        @Override // android.support.v4.widget.FocusStrategy.BoundsAdapter
        public void obtainBounds(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
            accessibilityNodeInfoCompat.getBoundsInParent(rect);
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> f1993f = new FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>() { // from class: android.support.v4.widget.ExploreByTouchHelper.2
        @Override // android.support.v4.widget.FocusStrategy.CollectionAdapter
        public AccessibilityNodeInfoCompat get(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int i) {
            return sparseArrayCompat.valueAt(i);
        }

        @Override // android.support.v4.widget.FocusStrategy.CollectionAdapter
        public int size(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
            return sparseArrayCompat.size();
        }
    };
    private final AccessibilityManager k;
    private final View l;
    private MyNodeProvider m;

    /* renamed from: g, reason: collision with root package name */
    private final Rect f1994g = new Rect();

    /* renamed from: h, reason: collision with root package name */
    private final Rect f1995h = new Rect();
    private final Rect i = new Rect();
    private final int[] j = new int[2];
    private int n = Integer.MIN_VALUE;
    private int o = Integer.MIN_VALUE;
    private int p = Integer.MIN_VALUE;

    /* loaded from: classes.dex */
    private class MyNodeProvider extends AccessibilityNodeProviderCompat {
        MyNodeProvider() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
            return AccessibilityNodeInfoCompat.obtain(ExploreByTouchHelper.this.a(i));
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int i) {
            int i2 = i == 2 ? ExploreByTouchHelper.this.n : ExploreByTouchHelper.this.o;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return createAccessibilityNodeInfo(i2);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int i, int i2, Bundle bundle) {
            return ExploreByTouchHelper.this.b(i, i2, bundle);
        }
    }

    public ExploreByTouchHelper(View view) {
        if (view != null) {
            this.l = view;
            this.k = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (ViewCompat.getImportantForAccessibility(view) == 0) {
                ViewCompat.setImportantForAccessibility(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private AccessibilityEvent c(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        this.l.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> d() {
        ArrayList arrayList = new ArrayList();
        a(arrayList);
        SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = new SparseArrayCompat<>();
        for (int i = 0; i < arrayList.size(); i++) {
            sparseArrayCompat.put(i, d(i));
        }
        return sparseArrayCompat;
    }

    private static int e(int i) {
        if (i == 19) {
            return 33;
        }
        if (i != 21) {
            return i != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean f(int i) {
        int i2;
        if (!this.k.isEnabled() || !this.k.isTouchExplorationEnabled() || (i2 = this.n) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            b(i2);
        }
        this.n = i;
        this.l.invalidate();
        sendEventForVirtualView(i, 32768);
        return true;
    }

    private void g(int i) {
        int i2 = this.p;
        if (i2 == i) {
            return;
        }
        this.p = i;
        sendEventForVirtualView(i, 128);
        sendEventForVirtualView(i2, 256);
    }

    protected abstract int a(float f2, float f3);

    protected abstract void a(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    protected void a(int i, AccessibilityEvent accessibilityEvent) {
    }

    protected void a(int i, boolean z) {
    }

    protected void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    protected void a(AccessibilityEvent accessibilityEvent) {
    }

    protected abstract void a(List<Integer> list);

    protected abstract boolean a(int i, int i2, Bundle bundle);

    public final boolean clearKeyboardFocusForVirtualView(int i) {
        if (this.o != i) {
            return false;
        }
        this.o = Integer.MIN_VALUE;
        a(i, false);
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!this.k.isEnabled() || !this.k.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7 && action != 9) {
            if (action != 10 || this.n == Integer.MIN_VALUE) {
                return false;
            }
            g(Integer.MIN_VALUE);
            return true;
        }
        int a2 = a(motionEvent.getX(), motionEvent.getY());
        g(a2);
        return a2 != Integer.MIN_VALUE;
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int e2 = e(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z = false;
                        while (i < repeatCount && b(e2, (Rect) null)) {
                            i++;
                            z = true;
                        }
                        return z;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            b();
            return true;
        }
        if (keyEvent.hasNoModifiers()) {
            return b(2, (Rect) null);
        }
        if (keyEvent.hasModifiers(1)) {
            return b(1, (Rect) null);
        }
        return false;
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.n;
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.m == null) {
            this.m = new MyNodeProvider();
        }
        return this.m;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.o;
    }

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i) {
        invalidateVirtualView(i, 0);
    }

    public final void onFocusChanged(boolean z, int i, Rect rect) {
        int i2 = this.o;
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        if (z) {
            b(i, rect);
        }
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        a(accessibilityEvent);
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        a(accessibilityNodeInfoCompat);
    }

    public final boolean requestKeyboardFocusForVirtualView(int i) {
        int i2;
        if ((!this.l.isFocused() && !this.l.requestFocus()) || (i2 = this.o) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        this.o = i;
        a(i, true);
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final boolean sendEventForVirtualView(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.k.isEnabled() || (parent = this.l.getParent()) == null) {
            return false;
        }
        return ViewParentCompat.requestSendAccessibilityEvent(parent, this.l, a(i, i2));
    }

    private void a(int i, Rect rect) {
        a(i).getBoundsInParent(rect);
    }

    private boolean b(int i, Rect rect) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        SparseArrayCompat<AccessibilityNodeInfoCompat> d2 = d();
        int i2 = this.o;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = i2 == Integer.MIN_VALUE ? null : d2.get(i2);
        if (i == 1 || i == 2) {
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInRelativeDirection(d2, f1993f, f1992e, accessibilityNodeInfoCompat2, i, ViewCompat.getLayoutDirection(this.l) == 1, false);
        } else {
            if (i != 17 && i != 33 && i != 66 && i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i3 = this.o;
            if (i3 != Integer.MIN_VALUE) {
                a(i3, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                a(this.l, i, rect2);
            }
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInAbsoluteDirection(d2, f1993f, f1992e, accessibilityNodeInfoCompat2, rect2, i);
        }
        return requestKeyboardFocusForVirtualView(accessibilityNodeInfoCompat != null ? d2.keyAt(d2.indexOfValue(accessibilityNodeInfoCompat)) : Integer.MIN_VALUE);
    }

    public final void invalidateVirtualView(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.k.isEnabled() || (parent = this.l.getParent()) == null) {
            return;
        }
        AccessibilityEvent a2 = a(i, 2048);
        AccessibilityEventCompat.setContentChangeTypes(a2, i2);
        ViewParentCompat.requestSendAccessibilityEvent(parent, this.l, a2);
    }

    private AccessibilityNodeInfoCompat c() {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(this.l);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.l, obtain);
        ArrayList arrayList = new ArrayList();
        a(arrayList);
        if (obtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            obtain.addChild(this.l, ((Integer) arrayList.get(i)).intValue());
        }
        return obtain;
    }

    private static Rect a(View view, int i, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i == 17) {
            rect.set(width, 0, width, height);
        } else if (i == 33) {
            rect.set(0, height, width, height);
        } else if (i == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    private AccessibilityNodeInfoCompat d(int i) {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        obtain.setClassName("android.view.View");
        obtain.setBoundsInParent(f1991d);
        obtain.setBoundsInScreen(f1991d);
        obtain.setParent(this.l);
        a(i, obtain);
        if (obtain.getText() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        obtain.getBoundsInParent(this.f1995h);
        if (!this.f1995h.equals(f1991d)) {
            int actions = obtain.getActions();
            if ((actions & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            if ((actions & 128) == 0) {
                obtain.setPackageName(this.l.getContext().getPackageName());
                obtain.setSource(this.l, i);
                if (this.n == i) {
                    obtain.setAccessibilityFocused(true);
                    obtain.addAction(128);
                } else {
                    obtain.setAccessibilityFocused(false);
                    obtain.addAction(64);
                }
                boolean z = this.o == i;
                if (z) {
                    obtain.addAction(2);
                } else if (obtain.isFocusable()) {
                    obtain.addAction(1);
                }
                obtain.setFocused(z);
                this.l.getLocationOnScreen(this.j);
                obtain.getBoundsInScreen(this.f1994g);
                if (this.f1994g.equals(f1991d)) {
                    obtain.getBoundsInParent(this.f1994g);
                    if (obtain.mParentVirtualDescendantId != -1) {
                        AccessibilityNodeInfoCompat obtain2 = AccessibilityNodeInfoCompat.obtain();
                        for (int i2 = obtain.mParentVirtualDescendantId; i2 != -1; i2 = obtain2.mParentVirtualDescendantId) {
                            obtain2.setParent(this.l, -1);
                            obtain2.setBoundsInParent(f1991d);
                            a(i2, obtain2);
                            obtain2.getBoundsInParent(this.f1995h);
                            Rect rect = this.f1994g;
                            Rect rect2 = this.f1995h;
                            rect.offset(rect2.left, rect2.top);
                        }
                        obtain2.recycle();
                    }
                    this.f1994g.offset(this.j[0] - this.l.getScrollX(), this.j[1] - this.l.getScrollY());
                }
                if (this.l.getLocalVisibleRect(this.i)) {
                    this.i.offset(this.j[0] - this.l.getScrollX(), this.j[1] - this.l.getScrollY());
                    if (this.f1994g.intersect(this.i)) {
                        obtain.setBoundsInScreen(this.f1994g);
                        if (a(this.f1994g)) {
                            obtain.setVisibleToUser(true);
                        }
                    }
                }
                return obtain;
            }
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }

    private AccessibilityEvent a(int i, int i2) {
        if (i != -1) {
            return b(i, i2);
        }
        return c(i2);
    }

    private boolean c(int i, int i2, Bundle bundle) {
        if (i2 == 1) {
            return requestKeyboardFocusForVirtualView(i);
        }
        if (i2 == 2) {
            return clearKeyboardFocusForVirtualView(i);
        }
        if (i2 == 64) {
            return f(i);
        }
        if (i2 != 128) {
            return a(i, i2, bundle);
        }
        return b(i);
    }

    AccessibilityNodeInfoCompat a(int i) {
        if (i == -1) {
            return c();
        }
        return d(i);
    }

    private boolean a(int i, Bundle bundle) {
        return ViewCompat.performAccessibilityAction(this.l, i, bundle);
    }

    private boolean a(Rect rect) {
        if (rect == null || rect.isEmpty() || this.l.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.l.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private boolean b() {
        int i = this.o;
        return i != Integer.MIN_VALUE && a(i, 16, (Bundle) null);
    }

    private AccessibilityEvent b(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        AccessibilityNodeInfoCompat a2 = a(i);
        obtain.getText().add(a2.getText());
        obtain.setContentDescription(a2.getContentDescription());
        obtain.setScrollable(a2.isScrollable());
        obtain.setPassword(a2.isPassword());
        obtain.setEnabled(a2.isEnabled());
        obtain.setChecked(a2.isChecked());
        a(i, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(a2.getClassName());
        AccessibilityRecordCompat.setSource(obtain, this.l, i);
        obtain.setPackageName(this.l.getContext().getPackageName());
        return obtain;
    }

    boolean b(int i, int i2, Bundle bundle) {
        if (i != -1) {
            return c(i, i2, bundle);
        }
        return a(i2, bundle);
    }

    private boolean b(int i) {
        if (this.n != i) {
            return false;
        }
        this.n = Integer.MIN_VALUE;
        this.l.invalidate();
        sendEventForVirtualView(i, 65536);
        return true;
    }
}

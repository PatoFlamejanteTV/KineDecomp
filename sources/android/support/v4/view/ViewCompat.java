package android.support.v4.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.util.Log;
import android.view.Display;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class ViewCompat {
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;

    @Deprecated
    public static final int LAYER_TYPE_HARDWARE = 2;

    @Deprecated
    public static final int LAYER_TYPE_NONE = 0;

    @Deprecated
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;

    @Deprecated
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;

    @Deprecated
    public static final int MEASURED_SIZE_MASK = 16777215;

    @Deprecated
    public static final int MEASURED_STATE_MASK = -16777216;

    @Deprecated
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;

    @Deprecated
    public static final int OVER_SCROLL_ALWAYS = 0;

    @Deprecated
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;

    @Deprecated
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH = 0;

    /* renamed from: a */
    static final ViewCompatBaseImpl f1827a;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    private @interface AccessibilityLiveRegion {
    }

    @Retention(RetentionPolicy.SOURCE)
    @TargetApi(26)
    /* loaded from: classes.dex */
    private @interface AutofillImportance {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FocusDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FocusRealDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FocusRelativeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    private @interface ImportantForAccessibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    private @interface LayerType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    private @interface LayoutDirectionMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface NestedScrollType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    private @interface OverScroll {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    private @interface ResolvedLayoutDirectionMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ScrollAxis {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ScrollIndicators {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ViewCompatApi15Impl extends ViewCompatBaseImpl {
        ViewCompatApi15Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean hasOnClickListeners(View view) {
            return view.hasOnClickListeners();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ViewCompatApi16Impl extends ViewCompatApi15Impl {
        ViewCompatApi16Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
            AccessibilityNodeProvider accessibilityNodeProvider = view.getAccessibilityNodeProvider();
            if (accessibilityNodeProvider != null) {
                return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
            }
            return null;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean getFitsSystemWindows(View view) {
            return view.getFitsSystemWindows();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getImportantForAccessibility(View view) {
            return view.getImportantForAccessibility();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getMinimumHeight(View view) {
            return view.getMinimumHeight();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getMinimumWidth(View view) {
            return view.getMinimumWidth();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public ViewParent getParentForAccessibility(View view) {
            return view.getParentForAccessibility();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean hasOverlappingRendering(View view) {
            return view.hasOverlappingRendering();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean hasTransientState(View view) {
            return view.hasTransientState();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return view.performAccessibilityAction(i, bundle);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void postInvalidateOnAnimation(View view) {
            view.postInvalidateOnAnimation();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void postOnAnimation(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void postOnAnimationDelayed(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void requestApplyInsets(View view) {
            view.requestFitSystemWindows();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setBackground(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setHasTransientState(View view, boolean z) {
            view.setHasTransientState(z);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setImportantForAccessibility(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            view.setImportantForAccessibility(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void postInvalidateOnAnimation(View view, int i, int i2, int i3, int i4) {
            view.postInvalidateOnAnimation(i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ViewCompatApi17Impl extends ViewCompatApi16Impl {
        ViewCompatApi17Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int generateViewId() {
            return View.generateViewId();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public Display getDisplay(View view) {
            return view.getDisplay();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getLabelFor(View view) {
            return view.getLabelFor();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getLayoutDirection(View view) {
            return view.getLayoutDirection();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getPaddingEnd(View view) {
            return view.getPaddingEnd();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getPaddingStart(View view) {
            return view.getPaddingStart();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getWindowSystemUiVisibility(View view) {
            return view.getWindowSystemUiVisibility();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean isPaddingRelative(View view) {
            return view.isPaddingRelative();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setLabelFor(View view, int i) {
            view.setLabelFor(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setLayerPaint(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setLayoutDirection(View view, int i) {
            view.setLayoutDirection(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setPaddingRelative(View view, int i, int i2, int i3, int i4) {
            view.setPaddingRelative(i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ViewCompatApi18Impl extends ViewCompatApi17Impl {
        ViewCompatApi18Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public Rect getClipBounds(View view) {
            return view.getClipBounds();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean isInLayout(View view) {
            return view.isInLayout();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setClipBounds(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ViewCompatApi19Impl extends ViewCompatApi18Impl {
        ViewCompatApi19Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getAccessibilityLiveRegion(View view) {
            return view.getAccessibilityLiveRegion();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean isAttachedToWindow(View view) {
            return view.isAttachedToWindow();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean isLaidOut(View view) {
            return view.isLaidOut();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean isLayoutDirectionResolved(View view) {
            return view.isLayoutDirectionResolved();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setAccessibilityLiveRegion(View view, int i) {
            view.setAccessibilityLiveRegion(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatApi16Impl, android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setImportantForAccessibility(View view, int i) {
            view.setImportantForAccessibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ViewCompatApi21Impl extends ViewCompatApi19Impl {
        private static ThreadLocal<Rect> n;

        /* renamed from: android.support.v4.view.ViewCompat$ViewCompatApi21Impl$1 */
        /* loaded from: classes.dex */
        class AnonymousClass1 implements View.OnApplyWindowInsetsListener {

            /* renamed from: a */
            final /* synthetic */ OnApplyWindowInsetsListener f1828a;

            AnonymousClass1(OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
                onApplyWindowInsetsListener = onApplyWindowInsetsListener;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                return (WindowInsets) WindowInsetsCompat.a(onApplyWindowInsetsListener.onApplyWindowInsets(view, WindowInsetsCompat.a(windowInsets)));
            }
        }

        ViewCompatApi21Impl() {
        }

        private static Rect c() {
            if (n == null) {
                n = new ThreadLocal<>();
            }
            Rect rect = n.get();
            if (rect == null) {
                rect = new Rect();
                n.set(rect);
            }
            rect.setEmpty();
            return rect;
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            WindowInsets windowInsets = (WindowInsets) WindowInsetsCompat.a(windowInsetsCompat);
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
            if (dispatchApplyWindowInsets != windowInsets) {
                windowInsets = new WindowInsets(dispatchApplyWindowInsets);
            }
            return WindowInsetsCompat.a(windowInsets);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean dispatchNestedFling(View view, float f2, float f3, boolean z) {
            return view.dispatchNestedFling(f2, f3, z);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean dispatchNestedPreFling(View view, float f2, float f3) {
            return view.dispatchNestedPreFling(f2, f3);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr) {
            return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public ColorStateList getBackgroundTintList(View view) {
            return view.getBackgroundTintList();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public PorterDuff.Mode getBackgroundTintMode(View view) {
            return view.getBackgroundTintMode();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public float getElevation(View view) {
            return view.getElevation();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public String getTransitionName(View view) {
            return view.getTransitionName();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public float getTranslationZ(View view) {
            return view.getTranslationZ();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public float getZ(View view) {
            return view.getZ();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean hasNestedScrollingParent(View view) {
            return view.hasNestedScrollingParent();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean isImportantForAccessibility(View view) {
            return view.isImportantForAccessibility();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean isNestedScrollingEnabled(View view) {
            return view.isNestedScrollingEnabled();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void offsetLeftAndRight(View view, int i) {
            boolean z;
            Rect c2 = c();
            Object parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                c2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !c2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                z = false;
            }
            super.offsetLeftAndRight(view, i);
            if (z && c2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(c2);
            }
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void offsetTopAndBottom(View view, int i) {
            boolean z;
            Rect c2 = c();
            Object parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                c2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !c2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                z = false;
            }
            super.offsetTopAndBottom(view, i);
            if (z && c2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(c2);
            }
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            WindowInsets windowInsets = (WindowInsets) WindowInsetsCompat.a(windowInsetsCompat);
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            if (onApplyWindowInsets != windowInsets) {
                windowInsets = new WindowInsets(onApplyWindowInsets);
            }
            return WindowInsetsCompat.a(windowInsets);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatApi16Impl, android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void requestApplyInsets(View view) {
            view.requestApplyInsets();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setBackgroundTintList(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setElevation(View view, float f2) {
            view.setElevation(f2);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setNestedScrollingEnabled(View view, boolean z) {
            view.setNestedScrollingEnabled(z);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: android.support.v4.view.ViewCompat.ViewCompatApi21Impl.1

                    /* renamed from: a */
                    final /* synthetic */ OnApplyWindowInsetsListener f1828a;

                    AnonymousClass1(OnApplyWindowInsetsListener onApplyWindowInsetsListener2) {
                        onApplyWindowInsetsListener = onApplyWindowInsetsListener2;
                    }

                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        return (WindowInsets) WindowInsetsCompat.a(onApplyWindowInsetsListener.onApplyWindowInsets(view2, WindowInsetsCompat.a(windowInsets)));
                    }
                });
            }
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setTransitionName(View view, String str) {
            view.setTransitionName(str);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setTranslationZ(View view, float f2) {
            view.setTranslationZ(f2);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setZ(View view, float f2) {
            view.setZ(f2);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean startNestedScroll(View view, int i) {
            return view.startNestedScroll(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void stopNestedScroll(View view) {
            view.stopNestedScroll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ViewCompatApi23Impl extends ViewCompatApi21Impl {
        ViewCompatApi23Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getScrollIndicators(View view) {
            return view.getScrollIndicators();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatApi21Impl, android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void offsetLeftAndRight(View view, int i) {
            view.offsetLeftAndRight(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatApi21Impl, android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void offsetTopAndBottom(View view, int i) {
            view.offsetTopAndBottom(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setScrollIndicators(View view, int i) {
            view.setScrollIndicators(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setScrollIndicators(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ViewCompatApi24Impl extends ViewCompatApi23Impl {
        ViewCompatApi24Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void cancelDragAndDrop(View view) {
            view.cancelDragAndDrop();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void dispatchFinishTemporaryDetach(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void dispatchStartTemporaryDetach(View view) {
            view.dispatchStartTemporaryDetach();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setPointerIcon(View view, PointerIconCompat pointerIconCompat) {
            view.setPointerIcon((PointerIcon) (pointerIconCompat != null ? pointerIconCompat.getPointerIcon() : null));
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean startDragAndDrop(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void updateDragShadow(View view, View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    /* loaded from: classes.dex */
    static class ViewCompatApi26Impl extends ViewCompatApi24Impl {
        ViewCompatApi26Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void addKeyboardNavigationClusters(View view, Collection<View> collection, int i) {
            view.addKeyboardNavigationClusters(collection, i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getImportantForAutofill(View view) {
            return view.getImportantForAutofill();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public int getNextClusterForwardId(View view) {
            return view.getNextClusterForwardId();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean hasExplicitFocusable(View view) {
            return view.hasExplicitFocusable();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean isFocusedByDefault(View view) {
            return view.isFocusedByDefault();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean isImportantForAutofill(View view) {
            return view.isImportantForAutofill();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean isKeyboardNavigationCluster(View view) {
            return view.isKeyboardNavigationCluster();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public View keyboardNavigationClusterSearch(View view, View view2, int i) {
            return view.keyboardNavigationClusterSearch(view2, i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public boolean restoreDefaultFocus(View view) {
            return view.restoreDefaultFocus();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setAutofillHints(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setFocusedByDefault(View view, boolean z) {
            view.setFocusedByDefault(z);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setImportantForAutofill(View view, int i) {
            view.setImportantForAutofill(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setKeyboardNavigationCluster(View view, boolean z) {
            view.setKeyboardNavigationCluster(z);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setNextClusterForwardId(View view, int i) {
            view.setNextClusterForwardId(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        public void setTooltipText(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ViewCompatBaseImpl {

        /* renamed from: a */
        private static Field f1830a;

        /* renamed from: b */
        private static boolean f1831b;

        /* renamed from: c */
        private static Field f1832c;

        /* renamed from: d */
        private static boolean f1833d;

        /* renamed from: e */
        private static WeakHashMap<View, String> f1834e;

        /* renamed from: g */
        private static Method f1836g;

        /* renamed from: h */
        static Field f1837h;
        private Method j;
        private Method k;
        private boolean l;
        WeakHashMap<View, ViewPropertyAnimatorCompat> m = null;

        /* renamed from: f */
        private static final AtomicInteger f1835f = new AtomicInteger(1);
        static boolean i = false;

        ViewCompatBaseImpl() {
        }

        private void b() {
            try {
                this.j = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
                this.k = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
            } catch (NoSuchMethodException e2) {
                Log.e("ViewCompat", "Couldn't find method", e2);
            }
            this.l = true;
        }

        long a() {
            return ValueAnimator.getFrameDelay();
        }

        public void addKeyboardNavigationClusters(View view, Collection<View> collection, int i2) {
        }

        public ViewPropertyAnimatorCompat animate(View view) {
            if (this.m == null) {
                this.m = new WeakHashMap<>();
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.m.get(view);
            if (viewPropertyAnimatorCompat != null) {
                return viewPropertyAnimatorCompat;
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
            this.m.put(view, viewPropertyAnimatorCompat2);
            return viewPropertyAnimatorCompat2;
        }

        public void cancelDragAndDrop(View view) {
        }

        public WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void dispatchFinishTemporaryDetach(View view) {
            if (!this.l) {
                b();
            }
            Method method = this.k;
            if (method != null) {
                try {
                    method.invoke(view, new Object[0]);
                    return;
                } catch (Exception e2) {
                    Log.d("ViewCompat", "Error calling dispatchFinishTemporaryDetach", e2);
                    return;
                }
            }
            view.onFinishTemporaryDetach();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean dispatchNestedFling(View view, float f2, float f3, boolean z) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).dispatchNestedFling(f2, f3, z);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean dispatchNestedPreFling(View view, float f2, float f3) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).dispatchNestedPreFling(f2, f3);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean dispatchNestedPreScroll(View view, int i2, int i3, int[] iArr, int[] iArr2) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).dispatchNestedPreScroll(i2, i3, iArr, iArr2);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean dispatchNestedScroll(View view, int i2, int i3, int i4, int i5, int[] iArr) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).dispatchNestedScroll(i2, i3, i4, i5, iArr);
            }
            return false;
        }

        public void dispatchStartTemporaryDetach(View view) {
            if (!this.l) {
                b();
            }
            Method method = this.j;
            if (method != null) {
                try {
                    method.invoke(view, new Object[0]);
                    return;
                } catch (Exception e2) {
                    Log.d("ViewCompat", "Error calling dispatchStartTemporaryDetach", e2);
                    return;
                }
            }
            view.onStartTemporaryDetach();
        }

        public int generateViewId() {
            int i2;
            int i3;
            do {
                i2 = f1835f.get();
                i3 = i2 + 1;
                if (i3 > 16777215) {
                    i3 = 1;
                }
            } while (!f1835f.compareAndSet(i2, i3));
            return i2;
        }

        public int getAccessibilityLiveRegion(View view) {
            return 0;
        }

        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ColorStateList getBackgroundTintList(View view) {
            if (view instanceof TintableBackgroundView) {
                return ((TintableBackgroundView) view).getSupportBackgroundTintList();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PorterDuff.Mode getBackgroundTintMode(View view) {
            if (view instanceof TintableBackgroundView) {
                return ((TintableBackgroundView) view).getSupportBackgroundTintMode();
            }
            return null;
        }

        public Rect getClipBounds(View view) {
            return null;
        }

        public Display getDisplay(View view) {
            if (isAttachedToWindow(view)) {
                return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
            }
            return null;
        }

        public float getElevation(View view) {
            return 0.0f;
        }

        public boolean getFitsSystemWindows(View view) {
            return false;
        }

        public int getImportantForAccessibility(View view) {
            return 0;
        }

        @TargetApi(26)
        public int getImportantForAutofill(View view) {
            return 0;
        }

        public int getLabelFor(View view) {
            return 0;
        }

        public int getLayoutDirection(View view) {
            return 0;
        }

        public int getMinimumHeight(View view) {
            if (!f1833d) {
                try {
                    f1832c = View.class.getDeclaredField("mMinHeight");
                    f1832c.setAccessible(true);
                } catch (NoSuchFieldException unused) {
                }
                f1833d = true;
            }
            Field field = f1832c;
            if (field == null) {
                return 0;
            }
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }

        public int getMinimumWidth(View view) {
            if (!f1831b) {
                try {
                    f1830a = View.class.getDeclaredField("mMinWidth");
                    f1830a.setAccessible(true);
                } catch (NoSuchFieldException unused) {
                }
                f1831b = true;
            }
            Field field = f1830a;
            if (field == null) {
                return 0;
            }
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }

        public int getNextClusterForwardId(View view) {
            return -1;
        }

        public int getPaddingEnd(View view) {
            return view.getPaddingRight();
        }

        public int getPaddingStart(View view) {
            return view.getPaddingLeft();
        }

        public ViewParent getParentForAccessibility(View view) {
            return view.getParent();
        }

        public int getScrollIndicators(View view) {
            return 0;
        }

        public String getTransitionName(View view) {
            WeakHashMap<View, String> weakHashMap = f1834e;
            if (weakHashMap == null) {
                return null;
            }
            return weakHashMap.get(view);
        }

        public float getTranslationZ(View view) {
            return 0.0f;
        }

        public int getWindowSystemUiVisibility(View view) {
            return 0;
        }

        public float getZ(View view) {
            return getTranslationZ(view) + getElevation(view);
        }

        public boolean hasAccessibilityDelegate(View view) {
            if (i) {
                return false;
            }
            if (f1837h == null) {
                try {
                    f1837h = View.class.getDeclaredField("mAccessibilityDelegate");
                    f1837h.setAccessible(true);
                } catch (Throwable unused) {
                    i = true;
                    return false;
                }
            }
            try {
                return f1837h.get(view) != null;
            } catch (Throwable unused2) {
                i = true;
                return false;
            }
        }

        public boolean hasExplicitFocusable(View view) {
            return view.hasFocusable();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean hasNestedScrollingParent(View view) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).hasNestedScrollingParent();
            }
            return false;
        }

        public boolean hasOnClickListeners(View view) {
            return false;
        }

        public boolean hasOverlappingRendering(View view) {
            return true;
        }

        public boolean hasTransientState(View view) {
            return false;
        }

        public boolean isAttachedToWindow(View view) {
            return view.getWindowToken() != null;
        }

        public boolean isFocusedByDefault(View view) {
            return false;
        }

        public boolean isImportantForAccessibility(View view) {
            return true;
        }

        public boolean isImportantForAutofill(View view) {
            return true;
        }

        public boolean isInLayout(View view) {
            return false;
        }

        public boolean isKeyboardNavigationCluster(View view) {
            return false;
        }

        public boolean isLaidOut(View view) {
            return view.getWidth() > 0 && view.getHeight() > 0;
        }

        public boolean isLayoutDirectionResolved(View view) {
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean isNestedScrollingEnabled(View view) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).isNestedScrollingEnabled();
            }
            return false;
        }

        public boolean isPaddingRelative(View view) {
            return false;
        }

        public View keyboardNavigationClusterSearch(View view, View view2, int i2) {
            return null;
        }

        public void offsetLeftAndRight(View view, int i2) {
            view.offsetLeftAndRight(i2);
            if (view.getVisibility() == 0) {
                a(view);
                Object parent = view.getParent();
                if (parent instanceof View) {
                    a((View) parent);
                }
            }
        }

        public void offsetTopAndBottom(View view, int i2) {
            view.offsetTopAndBottom(i2);
            if (view.getVisibility() == 0) {
                a(view);
                Object parent = view.getParent();
                if (parent instanceof View) {
                    a((View) parent);
                }
            }
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.unwrap());
        }

        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            return false;
        }

        public void postInvalidateOnAnimation(View view) {
            view.postInvalidate();
        }

        public void postOnAnimation(View view, Runnable runnable) {
            view.postDelayed(runnable, a());
        }

        public void postOnAnimationDelayed(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, a() + j);
        }

        public void requestApplyInsets(View view) {
        }

        public boolean restoreDefaultFocus(View view) {
            return view.requestFocus();
        }

        public void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
            view.setAccessibilityDelegate(accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.a());
        }

        public void setAccessibilityLiveRegion(View view, int i2) {
        }

        public void setAutofillHints(View view, String... strArr) {
        }

        public void setBackground(View view, Drawable drawable) {
            view.setBackgroundDrawable(drawable);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setBackgroundTintList(View view, ColorStateList colorStateList) {
            if (view instanceof TintableBackgroundView) {
                ((TintableBackgroundView) view).setSupportBackgroundTintList(colorStateList);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
            if (view instanceof TintableBackgroundView) {
                ((TintableBackgroundView) view).setSupportBackgroundTintMode(mode);
            }
        }

        public void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z) {
            if (f1836g == null) {
                try {
                    f1836g = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
                } catch (NoSuchMethodException e2) {
                    Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", e2);
                }
                f1836g.setAccessible(true);
            }
            try {
                f1836g.invoke(viewGroup, Boolean.valueOf(z));
            } catch (IllegalAccessException e3) {
                Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e3);
            } catch (IllegalArgumentException e4) {
                Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e4);
            } catch (InvocationTargetException e5) {
                Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e5);
            }
        }

        public void setClipBounds(View view, Rect rect) {
        }

        public void setElevation(View view, float f2) {
        }

        public void setFocusedByDefault(View view, boolean z) {
        }

        public void setHasTransientState(View view, boolean z) {
        }

        public void setImportantForAccessibility(View view, int i2) {
        }

        public void setImportantForAutofill(View view, int i2) {
        }

        public void setKeyboardNavigationCluster(View view, boolean z) {
        }

        public void setLabelFor(View view, int i2) {
        }

        public void setLayerPaint(View view, Paint paint) {
            view.setLayerType(view.getLayerType(), paint);
            view.invalidate();
        }

        public void setLayoutDirection(View view, int i2) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setNestedScrollingEnabled(View view, boolean z) {
            if (view instanceof NestedScrollingChild) {
                ((NestedScrollingChild) view).setNestedScrollingEnabled(z);
            }
        }

        public void setNextClusterForwardId(View view, int i2) {
        }

        public void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        }

        public void setPaddingRelative(View view, int i2, int i3, int i4, int i5) {
            view.setPadding(i2, i3, i4, i5);
        }

        public void setPointerIcon(View view, PointerIconCompat pointerIconCompat) {
        }

        public void setScrollIndicators(View view, int i2) {
        }

        public void setScrollIndicators(View view, int i2, int i3) {
        }

        public void setTooltipText(View view, CharSequence charSequence) {
        }

        public void setTransitionName(View view, String str) {
            if (f1834e == null) {
                f1834e = new WeakHashMap<>();
            }
            f1834e.put(view, str);
        }

        public void setTranslationZ(View view, float f2) {
        }

        public void setZ(View view, float f2) {
        }

        public boolean startDragAndDrop(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i2) {
            return view.startDrag(clipData, dragShadowBuilder, obj, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean startNestedScroll(View view, int i2) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).startNestedScroll(i2);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void stopNestedScroll(View view) {
            if (view instanceof NestedScrollingChild) {
                ((NestedScrollingChild) view).stopNestedScroll();
            }
        }

        public void updateDragShadow(View view, View.DragShadowBuilder dragShadowBuilder) {
        }

        private static void a(View view) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
        }

        public void postInvalidateOnAnimation(View view, int i2, int i3, int i4, int i5) {
            view.postInvalidate(i2, i3, i4, i5);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            f1827a = new ViewCompatApi26Impl();
            return;
        }
        if (i >= 24) {
            f1827a = new ViewCompatApi24Impl();
            return;
        }
        if (i >= 23) {
            f1827a = new ViewCompatApi23Impl();
            return;
        }
        if (i >= 21) {
            f1827a = new ViewCompatApi21Impl();
            return;
        }
        if (i >= 19) {
            f1827a = new ViewCompatApi19Impl();
            return;
        }
        if (i >= 18) {
            f1827a = new ViewCompatApi18Impl();
            return;
        }
        if (i >= 17) {
            f1827a = new ViewCompatApi17Impl();
            return;
        }
        if (i >= 16) {
            f1827a = new ViewCompatApi16Impl();
        } else if (i >= 15) {
            f1827a = new ViewCompatApi15Impl();
        } else {
            f1827a = new ViewCompatBaseImpl();
        }
    }

    protected ViewCompat() {
    }

    public static void addKeyboardNavigationClusters(View view, Collection<View> collection, int i) {
        f1827a.addKeyboardNavigationClusters(view, collection, i);
    }

    public static ViewPropertyAnimatorCompat animate(View view) {
        return f1827a.animate(view);
    }

    @Deprecated
    public static boolean canScrollHorizontally(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    @Deprecated
    public static boolean canScrollVertically(View view, int i) {
        return view.canScrollVertically(i);
    }

    public static void cancelDragAndDrop(View view) {
        f1827a.cancelDragAndDrop(view);
    }

    @Deprecated
    public static int combineMeasuredStates(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return f1827a.dispatchApplyWindowInsets(view, windowInsetsCompat);
    }

    public static void dispatchFinishTemporaryDetach(View view) {
        f1827a.dispatchFinishTemporaryDetach(view);
    }

    public static boolean dispatchNestedFling(View view, float f2, float f3, boolean z) {
        return f1827a.dispatchNestedFling(view, f2, f3, z);
    }

    public static boolean dispatchNestedPreFling(View view, float f2, float f3) {
        return f1827a.dispatchNestedPreFling(view, f2, f3);
    }

    public static boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2) {
        return f1827a.dispatchNestedPreScroll(view, i, i2, iArr, iArr2);
    }

    public static boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr) {
        return f1827a.dispatchNestedScroll(view, i, i2, i3, i4, iArr);
    }

    public static void dispatchStartTemporaryDetach(View view) {
        f1827a.dispatchStartTemporaryDetach(view);
    }

    public static int generateViewId() {
        return f1827a.generateViewId();
    }

    public static int getAccessibilityLiveRegion(View view) {
        return f1827a.getAccessibilityLiveRegion(view);
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        return f1827a.getAccessibilityNodeProvider(view);
    }

    @Deprecated
    public static float getAlpha(View view) {
        return view.getAlpha();
    }

    public static ColorStateList getBackgroundTintList(View view) {
        return f1827a.getBackgroundTintList(view);
    }

    public static PorterDuff.Mode getBackgroundTintMode(View view) {
        return f1827a.getBackgroundTintMode(view);
    }

    public static Rect getClipBounds(View view) {
        return f1827a.getClipBounds(view);
    }

    public static Display getDisplay(View view) {
        return f1827a.getDisplay(view);
    }

    public static float getElevation(View view) {
        return f1827a.getElevation(view);
    }

    public static boolean getFitsSystemWindows(View view) {
        return f1827a.getFitsSystemWindows(view);
    }

    public static int getImportantForAccessibility(View view) {
        return f1827a.getImportantForAccessibility(view);
    }

    public static int getImportantForAutofill(View view) {
        return f1827a.getImportantForAutofill(view);
    }

    public static int getLabelFor(View view) {
        return f1827a.getLabelFor(view);
    }

    @Deprecated
    public static int getLayerType(View view) {
        return view.getLayerType();
    }

    public static int getLayoutDirection(View view) {
        return f1827a.getLayoutDirection(view);
    }

    @Deprecated
    public static Matrix getMatrix(View view) {
        return view.getMatrix();
    }

    @Deprecated
    public static int getMeasuredHeightAndState(View view) {
        return view.getMeasuredHeightAndState();
    }

    @Deprecated
    public static int getMeasuredState(View view) {
        return view.getMeasuredState();
    }

    @Deprecated
    public static int getMeasuredWidthAndState(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static int getMinimumHeight(View view) {
        return f1827a.getMinimumHeight(view);
    }

    public static int getMinimumWidth(View view) {
        return f1827a.getMinimumWidth(view);
    }

    public static int getNextClusterForwardId(View view) {
        return f1827a.getNextClusterForwardId(view);
    }

    @Deprecated
    public static int getOverScrollMode(View view) {
        return view.getOverScrollMode();
    }

    public static int getPaddingEnd(View view) {
        return f1827a.getPaddingEnd(view);
    }

    public static int getPaddingStart(View view) {
        return f1827a.getPaddingStart(view);
    }

    public static ViewParent getParentForAccessibility(View view) {
        return f1827a.getParentForAccessibility(view);
    }

    @Deprecated
    public static float getPivotX(View view) {
        return view.getPivotX();
    }

    @Deprecated
    public static float getPivotY(View view) {
        return view.getPivotY();
    }

    @Deprecated
    public static float getRotation(View view) {
        return view.getRotation();
    }

    @Deprecated
    public static float getRotationX(View view) {
        return view.getRotationX();
    }

    @Deprecated
    public static float getRotationY(View view) {
        return view.getRotationY();
    }

    @Deprecated
    public static float getScaleX(View view) {
        return view.getScaleX();
    }

    @Deprecated
    public static float getScaleY(View view) {
        return view.getScaleY();
    }

    public static int getScrollIndicators(View view) {
        return f1827a.getScrollIndicators(view);
    }

    public static String getTransitionName(View view) {
        return f1827a.getTransitionName(view);
    }

    @Deprecated
    public static float getTranslationX(View view) {
        return view.getTranslationX();
    }

    @Deprecated
    public static float getTranslationY(View view) {
        return view.getTranslationY();
    }

    public static float getTranslationZ(View view) {
        return f1827a.getTranslationZ(view);
    }

    public static int getWindowSystemUiVisibility(View view) {
        return f1827a.getWindowSystemUiVisibility(view);
    }

    @Deprecated
    public static float getX(View view) {
        return view.getX();
    }

    @Deprecated
    public static float getY(View view) {
        return view.getY();
    }

    public static float getZ(View view) {
        return f1827a.getZ(view);
    }

    public static boolean hasAccessibilityDelegate(View view) {
        return f1827a.hasAccessibilityDelegate(view);
    }

    public static boolean hasExplicitFocusable(View view) {
        return f1827a.hasExplicitFocusable(view);
    }

    public static boolean hasNestedScrollingParent(View view) {
        return f1827a.hasNestedScrollingParent(view);
    }

    public static boolean hasOnClickListeners(View view) {
        return f1827a.hasOnClickListeners(view);
    }

    public static boolean hasOverlappingRendering(View view) {
        return f1827a.hasOverlappingRendering(view);
    }

    public static boolean hasTransientState(View view) {
        return f1827a.hasTransientState(view);
    }

    public static boolean isAttachedToWindow(View view) {
        return f1827a.isAttachedToWindow(view);
    }

    public static boolean isFocusedByDefault(View view) {
        return f1827a.isFocusedByDefault(view);
    }

    public static boolean isImportantForAccessibility(View view) {
        return f1827a.isImportantForAccessibility(view);
    }

    public static boolean isImportantForAutofill(View view) {
        return f1827a.isImportantForAutofill(view);
    }

    public static boolean isInLayout(View view) {
        return f1827a.isInLayout(view);
    }

    public static boolean isKeyboardNavigationCluster(View view) {
        return f1827a.isKeyboardNavigationCluster(view);
    }

    public static boolean isLaidOut(View view) {
        return f1827a.isLaidOut(view);
    }

    public static boolean isLayoutDirectionResolved(View view) {
        return f1827a.isLayoutDirectionResolved(view);
    }

    public static boolean isNestedScrollingEnabled(View view) {
        return f1827a.isNestedScrollingEnabled(view);
    }

    @Deprecated
    public static boolean isOpaque(View view) {
        return view.isOpaque();
    }

    public static boolean isPaddingRelative(View view) {
        return f1827a.isPaddingRelative(view);
    }

    @Deprecated
    public static void jumpDrawablesToCurrentState(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static View keyboardNavigationClusterSearch(View view, View view2, int i) {
        return f1827a.keyboardNavigationClusterSearch(view, view2, i);
    }

    public static void offsetLeftAndRight(View view, int i) {
        f1827a.offsetLeftAndRight(view, i);
    }

    public static void offsetTopAndBottom(View view, int i) {
        f1827a.offsetTopAndBottom(view, i);
    }

    public static WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return f1827a.onApplyWindowInsets(view, windowInsetsCompat);
    }

    @Deprecated
    public static void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        f1827a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
    }

    @Deprecated
    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    public static boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return f1827a.performAccessibilityAction(view, i, bundle);
    }

    public static void postInvalidateOnAnimation(View view) {
        f1827a.postInvalidateOnAnimation(view);
    }

    public static void postOnAnimation(View view, Runnable runnable) {
        f1827a.postOnAnimation(view, runnable);
    }

    public static void postOnAnimationDelayed(View view, Runnable runnable, long j) {
        f1827a.postOnAnimationDelayed(view, runnable, j);
    }

    public static void requestApplyInsets(View view) {
        f1827a.requestApplyInsets(view);
    }

    public static <T extends View> T requireViewById(View view, int i) {
        T t = (T) view.findViewById(i);
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    @Deprecated
    public static int resolveSizeAndState(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    public static boolean restoreDefaultFocus(View view) {
        return f1827a.restoreDefaultFocus(view);
    }

    public static void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        f1827a.setAccessibilityDelegate(view, accessibilityDelegateCompat);
    }

    public static void setAccessibilityLiveRegion(View view, int i) {
        f1827a.setAccessibilityLiveRegion(view, i);
    }

    @Deprecated
    public static void setActivated(View view, boolean z) {
        view.setActivated(z);
    }

    @Deprecated
    public static void setAlpha(View view, float f2) {
        view.setAlpha(f2);
    }

    public static void setAutofillHints(View view, String... strArr) {
        f1827a.setAutofillHints(view, strArr);
    }

    public static void setBackground(View view, Drawable drawable) {
        f1827a.setBackground(view, drawable);
    }

    public static void setBackgroundTintList(View view, ColorStateList colorStateList) {
        f1827a.setBackgroundTintList(view, colorStateList);
    }

    public static void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
        f1827a.setBackgroundTintMode(view, mode);
    }

    @Deprecated
    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z) {
        f1827a.setChildrenDrawingOrderEnabled(viewGroup, z);
    }

    public static void setClipBounds(View view, Rect rect) {
        f1827a.setClipBounds(view, rect);
    }

    public static void setElevation(View view, float f2) {
        f1827a.setElevation(view, f2);
    }

    @Deprecated
    public static void setFitsSystemWindows(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void setFocusedByDefault(View view, boolean z) {
        f1827a.setFocusedByDefault(view, z);
    }

    public static void setHasTransientState(View view, boolean z) {
        f1827a.setHasTransientState(view, z);
    }

    public static void setImportantForAccessibility(View view, int i) {
        f1827a.setImportantForAccessibility(view, i);
    }

    public static void setImportantForAutofill(View view, int i) {
        f1827a.setImportantForAutofill(view, i);
    }

    public static void setKeyboardNavigationCluster(View view, boolean z) {
        f1827a.setKeyboardNavigationCluster(view, z);
    }

    public static void setLabelFor(View view, int i) {
        f1827a.setLabelFor(view, i);
    }

    public static void setLayerPaint(View view, Paint paint) {
        f1827a.setLayerPaint(view, paint);
    }

    @Deprecated
    public static void setLayerType(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static void setLayoutDirection(View view, int i) {
        f1827a.setLayoutDirection(view, i);
    }

    public static void setNestedScrollingEnabled(View view, boolean z) {
        f1827a.setNestedScrollingEnabled(view, z);
    }

    public static void setNextClusterForwardId(View view, int i) {
        f1827a.setNextClusterForwardId(view, i);
    }

    public static void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        f1827a.setOnApplyWindowInsetsListener(view, onApplyWindowInsetsListener);
    }

    @Deprecated
    public static void setOverScrollMode(View view, int i) {
        view.setOverScrollMode(i);
    }

    public static void setPaddingRelative(View view, int i, int i2, int i3, int i4) {
        f1827a.setPaddingRelative(view, i, i2, i3, i4);
    }

    @Deprecated
    public static void setPivotX(View view, float f2) {
        view.setPivotX(f2);
    }

    @Deprecated
    public static void setPivotY(View view, float f2) {
        view.setPivotY(f2);
    }

    public static void setPointerIcon(View view, PointerIconCompat pointerIconCompat) {
        f1827a.setPointerIcon(view, pointerIconCompat);
    }

    @Deprecated
    public static void setRotation(View view, float f2) {
        view.setRotation(f2);
    }

    @Deprecated
    public static void setRotationX(View view, float f2) {
        view.setRotationX(f2);
    }

    @Deprecated
    public static void setRotationY(View view, float f2) {
        view.setRotationY(f2);
    }

    @Deprecated
    public static void setSaveFromParentEnabled(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    @Deprecated
    public static void setScaleX(View view, float f2) {
        view.setScaleX(f2);
    }

    @Deprecated
    public static void setScaleY(View view, float f2) {
        view.setScaleY(f2);
    }

    public static void setScrollIndicators(View view, int i) {
        f1827a.setScrollIndicators(view, i);
    }

    public static void setTooltipText(View view, CharSequence charSequence) {
        f1827a.setTooltipText(view, charSequence);
    }

    public static void setTransitionName(View view, String str) {
        f1827a.setTransitionName(view, str);
    }

    @Deprecated
    public static void setTranslationX(View view, float f2) {
        view.setTranslationX(f2);
    }

    @Deprecated
    public static void setTranslationY(View view, float f2) {
        view.setTranslationY(f2);
    }

    public static void setTranslationZ(View view, float f2) {
        f1827a.setTranslationZ(view, f2);
    }

    @Deprecated
    public static void setX(View view, float f2) {
        view.setX(f2);
    }

    @Deprecated
    public static void setY(View view, float f2) {
        view.setY(f2);
    }

    public static void setZ(View view, float f2) {
        f1827a.setZ(view, f2);
    }

    public static boolean startDragAndDrop(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
        return f1827a.startDragAndDrop(view, clipData, dragShadowBuilder, obj, i);
    }

    public static boolean startNestedScroll(View view, int i) {
        return f1827a.startNestedScroll(view, i);
    }

    public static void stopNestedScroll(View view) {
        f1827a.stopNestedScroll(view);
    }

    public static void updateDragShadow(View view, View.DragShadowBuilder dragShadowBuilder) {
        f1827a.updateDragShadow(view, dragShadowBuilder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2, int i3) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
        }
        if (i3 == 0) {
            return f1827a.dispatchNestedPreScroll(view, i, i2, iArr, iArr2);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr, int i5) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
        }
        if (i5 == 0) {
            return f1827a.dispatchNestedScroll(view, i, i2, i3, i4, iArr);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean hasNestedScrollingParent(View view, int i) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).hasNestedScrollingParent(i);
            return false;
        }
        if (i == 0) {
            return f1827a.hasNestedScrollingParent(view);
        }
        return false;
    }

    public static void postInvalidateOnAnimation(View view, int i, int i2, int i3, int i4) {
        f1827a.postInvalidateOnAnimation(view, i, i2, i3, i4);
    }

    public static void setScrollIndicators(View view, int i, int i2) {
        f1827a.setScrollIndicators(view, i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean startNestedScroll(View view, int i, int i2) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).startNestedScroll(i, i2);
        }
        if (i2 == 0) {
            return f1827a.startNestedScroll(view, i);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void stopNestedScroll(View view, int i) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).stopNestedScroll(i);
        } else if (i == 0) {
            f1827a.stopNestedScroll(view);
        }
    }
}

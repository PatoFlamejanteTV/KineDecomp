package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {

    /* renamed from: d, reason: collision with root package name */
    final RecyclerView f2970d;

    /* renamed from: e, reason: collision with root package name */
    final AccessibilityDelegateCompat f2971e = new ItemDelegate(this);

    /* loaded from: classes.dex */
    public static class ItemDelegate extends AccessibilityDelegateCompat {

        /* renamed from: d, reason: collision with root package name */
        final RecyclerViewAccessibilityDelegate f2972d;

        public ItemDelegate(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
            this.f2972d = recyclerViewAccessibilityDelegate;
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (this.f2972d.b() || this.f2972d.f2970d.getLayoutManager() == null) {
                return;
            }
            this.f2972d.f2970d.getLayoutManager().a(view, accessibilityNodeInfoCompat);
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (this.f2972d.b() || this.f2972d.f2970d.getLayoutManager() == null) {
                return false;
            }
            return this.f2972d.f2970d.getLayoutManager().a(view, i, bundle);
        }
    }

    public RecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        this.f2970d = recyclerView;
    }

    boolean b() {
        return this.f2970d.hasPendingAdapterUpdates();
    }

    public AccessibilityDelegateCompat getItemDelegate() {
        return this.f2971e;
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if (!(view instanceof RecyclerView) || b()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(RecyclerView.class.getName());
        if (b() || this.f2970d.getLayoutManager() == null) {
            return;
        }
        this.f2970d.getLayoutManager().a(accessibilityNodeInfoCompat);
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (b() || this.f2970d.getLayoutManager() == null) {
            return false;
        }
        return this.f2970d.getLayoutManager().a(i, bundle);
    }
}

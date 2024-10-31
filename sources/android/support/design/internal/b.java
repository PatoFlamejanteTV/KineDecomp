package android.support.design.internal;

import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;

/* compiled from: NavigationMenuItemView.java */
/* loaded from: classes.dex */
class b extends AccessibilityDelegateCompat {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ NavigationMenuItemView f305d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NavigationMenuItemView navigationMenuItemView) {
        this.f305d = navigationMenuItemView;
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setCheckable(this.f305d.y);
    }
}

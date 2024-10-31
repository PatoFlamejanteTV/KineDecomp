package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

@RequiresApi(16)
/* renamed from: com.facebook.ads.redexgen.X.61, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass61 {
    public static Object A00(final InterfaceC01475s interfaceC01475s) {
        return new AccessibilityNodeProvider() { // from class: com.facebook.ads.redexgen.X.60
            @Override // android.view.accessibility.AccessibilityNodeProvider
            public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (AccessibilityNodeInfo) InterfaceC01475s.this.A3k(i);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
                return InterfaceC01475s.this.A47(str, i);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public final boolean performAction(int i, int i2, Bundle bundle) {
                return InterfaceC01475s.this.A7k(i, i2, bundle);
            }
        };
    }
}

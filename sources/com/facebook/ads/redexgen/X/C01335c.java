package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: com.facebook.ads.redexgen.X.5c, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C01335c {
    public static final C5Z A00;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            A00 = new C01315a() { // from class: com.facebook.ads.redexgen.X.5b
                @Override // com.facebook.ads.redexgen.X.C5Z
                public final int A00(AccessibilityEvent accessibilityEvent) {
                    return accessibilityEvent.getContentChangeTypes();
                }

                @Override // com.facebook.ads.redexgen.X.C5Z
                public final void A01(AccessibilityEvent accessibilityEvent, int i) {
                    accessibilityEvent.setContentChangeTypes(i);
                }
            };
        } else if (Build.VERSION.SDK_INT >= 16) {
            A00 = new C01315a();
        } else {
            A00 = new C5Z();
        }
    }

    public static int A00(AccessibilityEvent accessibilityEvent) {
        return A00.A00(accessibilityEvent);
    }

    public static void A01(AccessibilityEvent accessibilityEvent, int i) {
        A00.A01(accessibilityEvent, i);
    }
}

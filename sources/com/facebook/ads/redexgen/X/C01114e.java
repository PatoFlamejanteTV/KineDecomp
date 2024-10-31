package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: com.facebook.ads.redexgen.X.4e, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C01114e {
    public static final View.AccessibilityDelegate A01;
    public static final C01084b A02;
    public final View.AccessibilityDelegate A00 = A02.A00(this);

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            A02 = new C01084b() { // from class: com.facebook.ads.redexgen.X.4c
                @Override // com.facebook.ads.redexgen.X.C01084b
                public final View.AccessibilityDelegate A00(final C01114e c01114e) {
                    return new View.AccessibilityDelegate() { // from class: com.facebook.ads.redexgen.X.4a
                        @Override // android.view.View.AccessibilityDelegate
                        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                            return c01114e.A05(view, accessibilityEvent);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:            return r2;     */
                        @Override // android.view.View.AccessibilityDelegate
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final android.view.accessibility.AccessibilityNodeProvider getAccessibilityNodeProvider(android.view.View r4) {
                            /*
                                r3 = this;
                                r2 = 0
                                r0 = 0
                                com.facebook.ads.redexgen.X.4e r0 = r2
                                com.facebook.ads.redexgen.X.5z r1 = r0.A01(r4)
                                if (r1 == 0) goto L1c
                                r0 = 2
                            Lb:
                                switch(r0) {
                                    case 2: goto Lf;
                                    case 3: goto L1e;
                                    case 4: goto L19;
                                    default: goto Le;
                                }
                            Le:
                                goto Lb
                            Lf:
                                com.facebook.ads.redexgen.X.5z r1 = (com.facebook.ads.redexgen.X.C01545z) r1
                                java.lang.Object r2 = r1.A02()
                                android.view.accessibility.AccessibilityNodeProvider r2 = (android.view.accessibility.AccessibilityNodeProvider) r2
                                r0 = 3
                                goto Lb
                            L19:
                                r2 = 0
                                r0 = 3
                                goto Lb
                            L1c:
                                r0 = 4
                                goto Lb
                            L1e:
                                android.view.accessibility.AccessibilityNodeProvider r2 = (android.view.accessibility.AccessibilityNodeProvider) r2
                                return r2
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01074a.getAccessibilityNodeProvider(android.view.View):android.view.accessibility.AccessibilityNodeProvider");
                        }

                        @Override // android.view.View.AccessibilityDelegate
                        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                            c01114e.A07(view, accessibilityEvent);
                        }

                        @Override // android.view.View.AccessibilityDelegate
                        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                            c01114e.A08(view, C5q.A01(accessibilityNodeInfo));
                        }

                        @Override // android.view.View.AccessibilityDelegate
                        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                            c01114e.A03(view, accessibilityEvent);
                        }

                        @Override // android.view.View.AccessibilityDelegate
                        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                            return c01114e.A06(viewGroup, view, accessibilityEvent);
                        }

                        @Override // android.view.View.AccessibilityDelegate
                        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                            return c01114e.A09(view, i, bundle);
                        }

                        @Override // android.view.View.AccessibilityDelegate
                        public final void sendAccessibilityEvent(View view, int i) {
                            c01114e.A02(view, i);
                        }

                        @Override // android.view.View.AccessibilityDelegate
                        public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                            c01114e.A04(view, accessibilityEvent);
                        }
                    };
                }

                /* JADX WARN: Code restructure failed: missing block: B:15:0x001d, code lost:            return r2;     */
                @Override // com.facebook.ads.redexgen.X.C01084b
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final com.facebook.ads.redexgen.X.C01545z A01(android.view.View.AccessibilityDelegate r4, android.view.View r5) {
                    /*
                        r3 = this;
                        r2 = 0
                        r0 = 0
                        android.view.accessibility.AccessibilityNodeProvider r1 = r4.getAccessibilityNodeProvider(r5)
                        if (r1 == 0) goto L19
                        r0 = 2
                    L9:
                        switch(r0) {
                            case 2: goto Ld;
                            case 3: goto L1b;
                            case 4: goto L16;
                            default: goto Lc;
                        }
                    Lc:
                        goto L9
                    Ld:
                        android.view.accessibility.AccessibilityNodeProvider r1 = (android.view.accessibility.AccessibilityNodeProvider) r1
                        com.facebook.ads.redexgen.X.5z r2 = new com.facebook.ads.redexgen.X.5z
                        r2.<init>(r1)
                        r0 = 3
                        goto L9
                    L16:
                        r2 = 0
                        r0 = 3
                        goto L9
                    L19:
                        r0 = 4
                        goto L9
                    L1b:
                        com.facebook.ads.redexgen.X.5z r2 = (com.facebook.ads.redexgen.X.C01545z) r2
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01094c.A01(android.view.View$AccessibilityDelegate, android.view.View):com.facebook.ads.redexgen.X.5z");
                }

                @Override // com.facebook.ads.redexgen.X.C01084b
                public final boolean A02(View.AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
                    return accessibilityDelegate.performAccessibilityAction(view, i, bundle);
                }
            };
        } else {
            A02 = new C01084b();
        }
        A01 = new View.AccessibilityDelegate();
    }

    public final View.AccessibilityDelegate A00() {
        return this.A00;
    }

    public final C01545z A01(View view) {
        return A02.A01(A01, view);
    }

    public final void A02(View view, int i) {
        A01.sendAccessibilityEvent(view, i);
    }

    public final void A03(View view, AccessibilityEvent accessibilityEvent) {
        A01.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public final void A04(View view, AccessibilityEvent accessibilityEvent) {
        A01.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public final boolean A05(View view, AccessibilityEvent accessibilityEvent) {
        return A01.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public final boolean A06(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return A01.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public void A07(View view, AccessibilityEvent accessibilityEvent) {
        A01.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void A08(View view, C5q c5q) {
        A01.onInitializeAccessibilityNodeInfo(view, c5q.A0M());
    }

    public boolean A09(View view, int i, Bundle bundle) {
        return A02.A02(A01, view, i, bundle);
    }
}

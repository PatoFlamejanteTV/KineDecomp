package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

/* renamed from: com.facebook.ads.redexgen.X.6W, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C6W extends C6V {
    public static TimeInterpolator A0B;
    public ArrayList<C7Z> A0A = new ArrayList<>();
    public ArrayList<C7Z> A07 = new ArrayList<>();
    public ArrayList<C6T> A09 = new ArrayList<>();
    public ArrayList<C6S> A08 = new ArrayList<>();
    public ArrayList<ArrayList<C7Z>> A01 = new ArrayList<>();
    public ArrayList<ArrayList<C6T>> A05 = new ArrayList<>();
    public ArrayList<ArrayList<C6S>> A03 = new ArrayList<>();
    public ArrayList<C7Z> A00 = new ArrayList<>();
    public ArrayList<C7Z> A04 = new ArrayList<>();
    public ArrayList<C7Z> A06 = new ArrayList<>();
    public ArrayList<C7Z> A02 = new ArrayList<>();

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A01(com.facebook.ads.redexgen.X.C6S r3) {
        /*
            r2 = this;
            r1 = r2
            com.facebook.ads.redexgen.X.7Z r0 = r3.A05
            if (r0 == 0) goto L2a
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L15;
                case 4: goto L1f;
                case 5: goto L2c;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.6W r1 = (com.facebook.ads.redexgen.X.C6W) r1
            com.facebook.ads.redexgen.X.6S r3 = (com.facebook.ads.redexgen.X.C6S) r3
            com.facebook.ads.redexgen.X.7Z r0 = r3.A05
            r1.A06(r3, r0)
            r0 = 3
            goto L6
        L15:
            com.facebook.ads.redexgen.X.6S r3 = (com.facebook.ads.redexgen.X.C6S) r3
            com.facebook.ads.redexgen.X.7Z r0 = r3.A04
            if (r0 == 0) goto L1d
            r0 = 4
            goto L6
        L1d:
            r0 = 5
            goto L6
        L1f:
            com.facebook.ads.redexgen.X.6W r1 = (com.facebook.ads.redexgen.X.C6W) r1
            com.facebook.ads.redexgen.X.6S r3 = (com.facebook.ads.redexgen.X.C6S) r3
            com.facebook.ads.redexgen.X.7Z r0 = r3.A04
            r1.A06(r3, r0)
            r0 = 5
            goto L6
        L2a:
            r0 = 3
            goto L6
        L2c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6W.A01(com.facebook.ads.redexgen.X.6S):void");
    }

    private void A02(final C7Z c7z) {
        final View view = c7z.A0H;
        final ViewPropertyAnimator animate = view.animate();
        this.A06.add(c7z);
        animate.setDuration(A05()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.facebook.ads.redexgen.X.6N
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                view.setAlpha(1.0f);
                C6W.this.A0P(c7z);
                C6W.this.A06.remove(c7z);
                C6W.this.A0X();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                C6W.this.A0Q(c7z);
            }
        }).start();
    }

    private void A03(C7Z c7z) {
        if (A0B == null) {
            A0B = new ValueAnimator().getInterpolator();
        }
        c7z.A0H.animate().setInterpolator(A0B);
        A0I(c7z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A04(java.util.List<com.facebook.ads.redexgen.X.C7Z> r3) {
        /*
            r2 = this;
            r0 = 0
            int r0 = r3.size()
            int r1 = r0 + (-1)
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L12;
                case 4: goto L27;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            if (r1 < 0) goto L10
            r0 = 3
            goto L8
        L10:
            r0 = 4
            goto L8
        L12:
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r0 = r3.get(r1)
            com.facebook.ads.redexgen.X.7Z r0 = (com.facebook.ads.redexgen.X.C7Z) r0
            android.view.View r0 = r0.A0H
            android.view.ViewPropertyAnimator r0 = r0.animate()
            r0.cancel()
            int r1 = r1 + (-1)
            r0 = 2
            goto L8
        L27:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6W.A04(java.util.List):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x004c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A05(java.util.List<com.facebook.ads.redexgen.X.C6S> r5, com.facebook.ads.redexgen.X.C7Z r6) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r0 = 0
            int r0 = r5.size()
            int r1 = r0 + (-1)
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L45;
                case 3: goto L2f;
                case 4: goto L25;
                case 5: goto Le;
                case 6: goto L1c;
                case 7: goto L18;
                case 8: goto L4c;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.6S r2 = (com.facebook.ads.redexgen.X.C6S) r2
            com.facebook.ads.redexgen.X.7Z r0 = r2.A04
            if (r0 != 0) goto L16
            r0 = 6
            goto La
        L16:
            r0 = 7
            goto La
        L18:
            int r1 = r1 + (-1)
            r0 = 2
            goto La
        L1c:
            java.util.List r5 = (java.util.List) r5
            com.facebook.ads.redexgen.X.6S r2 = (com.facebook.ads.redexgen.X.C6S) r2
            r5.remove(r2)
            r0 = 7
            goto La
        L25:
            com.facebook.ads.redexgen.X.6S r2 = (com.facebook.ads.redexgen.X.C6S) r2
            com.facebook.ads.redexgen.X.7Z r0 = r2.A05
            if (r0 != 0) goto L2d
            r0 = 5
            goto La
        L2d:
            r0 = 7
            goto La
        L2f:
            com.facebook.ads.redexgen.X.6W r3 = (com.facebook.ads.redexgen.X.C6W) r3
            java.util.List r5 = (java.util.List) r5
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            java.lang.Object r2 = r5.get(r1)
            com.facebook.ads.redexgen.X.6S r2 = (com.facebook.ads.redexgen.X.C6S) r2
            boolean r0 = r3.A06(r2, r6)
            if (r0 == 0) goto L43
            r0 = 4
            goto La
        L43:
            r0 = 7
            goto La
        L45:
            if (r1 < 0) goto L49
            r0 = 3
            goto La
        L49:
            r0 = 8
            goto La
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6W.A05(java.util.List, com.facebook.ads.redexgen.X.7Z):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x004d, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A06(com.facebook.ads.redexgen.X.C6S r6, com.facebook.ads.redexgen.X.C7Z r7) {
        /*
            r5 = this;
            r4 = r5
            r1 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r3 = 0
            com.facebook.ads.redexgen.X.7Z r0 = r6.A04
            if (r0 != r7) goto L4b
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L44;
                case 3: goto L28;
                case 4: goto L4d;
                case 5: goto L11;
                case 6: goto L20;
                case 7: goto L1d;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.6S r6 = (com.facebook.ads.redexgen.X.C6S) r6
            com.facebook.ads.redexgen.X.7Z r7 = (com.facebook.ads.redexgen.X.C7Z) r7
            com.facebook.ads.redexgen.X.7Z r0 = r6.A05
            if (r0 != r7) goto L1b
            r0 = 6
            goto Ld
        L1b:
            r0 = 7
            goto Ld
        L1d:
            r1 = 0
            r0 = 4
            goto Ld
        L20:
            com.facebook.ads.redexgen.X.6S r6 = (com.facebook.ads.redexgen.X.C6S) r6
            r0 = 0
            r6.A05 = r0
            r3 = 1
            r0 = 3
            goto Ld
        L28:
            com.facebook.ads.redexgen.X.6W r4 = (com.facebook.ads.redexgen.X.C6W) r4
            com.facebook.ads.redexgen.X.7Z r7 = (com.facebook.ads.redexgen.X.C7Z) r7
            r2 = 0
            android.view.View r1 = r7.A0H
            r0 = 1065353216(0x3f800000, float:1.0)
            r1.setAlpha(r0)
            android.view.View r0 = r7.A0H
            r0.setTranslationX(r2)
            android.view.View r0 = r7.A0H
            r0.setTranslationY(r2)
            r4.A0R(r7, r3)
            r1 = 1
            r0 = 4
            goto Ld
        L44:
            com.facebook.ads.redexgen.X.6S r6 = (com.facebook.ads.redexgen.X.C6S) r6
            r0 = 0
            r6.A04 = r0
            r0 = 3
            goto Ld
        L4b:
            r0 = 5
            goto Ld
        L4d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6W.A06(com.facebook.ads.redexgen.X.6S, com.facebook.ads.redexgen.X.7Z):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:190:0x027f, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C6U
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0G() {
        /*
            Method dump skipped, instructions count: 720
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6W.A0G():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:234:0x0230, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C6U
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0H() {
        /*
            Method dump skipped, instructions count: 650
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6W.A0H():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:162:0x01c8, code lost:            r5 = r5;        r13 = r13;        r5.A06.remove(r13);        r5.A00.remove(r13);        r5.A02.remove(r13);        r5.A04.remove(r13);        r5.A0X();     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x01e3, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C6U
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0I(com.facebook.ads.redexgen.X.C7Z r13) {
        /*
            Method dump skipped, instructions count: 546
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6W.A0I(com.facebook.ads.redexgen.X.7Z):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x00bc, code lost:            return r2;     */
    @Override // com.facebook.ads.redexgen.X.C6U
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0J() {
        /*
            r3 = this;
            r1 = r3
            r2 = 0
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r1.A07
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lb8
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L4b;
                case 3: goto L2d;
                case 4: goto L3c;
                case 5: goto L1e;
                case 6: goto Lf;
                case 7: goto L5a;
                case 8: goto L8a;
                case 9: goto L6a;
                case 10: goto L7a;
                case 11: goto L9c;
                case 12: goto Lb3;
                case 13: goto Lbc;
                case 14: goto Lae;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.6W r1 = (com.facebook.ads.redexgen.X.C6W) r1
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r1.A06
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L1b
            r0 = 7
            goto Lb
        L1b:
            r0 = 12
            goto Lb
        L1e:
            com.facebook.ads.redexgen.X.6W r1 = (com.facebook.ads.redexgen.X.C6W) r1
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r1.A04
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L2a
            r0 = 6
            goto Lb
        L2a:
            r0 = 12
            goto Lb
        L2d:
            com.facebook.ads.redexgen.X.6W r1 = (com.facebook.ads.redexgen.X.C6W) r1
            java.util.ArrayList<com.facebook.ads.redexgen.X.6T> r0 = r1.A09
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L39
            r0 = 4
            goto Lb
        L39:
            r0 = 12
            goto Lb
        L3c:
            com.facebook.ads.redexgen.X.6W r1 = (com.facebook.ads.redexgen.X.C6W) r1
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r1.A0A
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L48
            r0 = 5
            goto Lb
        L48:
            r0 = 12
            goto Lb
        L4b:
            com.facebook.ads.redexgen.X.6W r1 = (com.facebook.ads.redexgen.X.C6W) r1
            java.util.ArrayList<com.facebook.ads.redexgen.X.6S> r0 = r1.A08
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L57
            r0 = 3
            goto Lb
        L57:
            r0 = 12
            goto Lb
        L5a:
            com.facebook.ads.redexgen.X.6W r1 = (com.facebook.ads.redexgen.X.C6W) r1
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r1.A00
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L67
            r0 = 8
            goto Lb
        L67:
            r0 = 12
            goto Lb
        L6a:
            com.facebook.ads.redexgen.X.6W r1 = (com.facebook.ads.redexgen.X.C6W) r1
            java.util.ArrayList<java.util.ArrayList<com.facebook.ads.redexgen.X.6T>> r0 = r1.A05
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L77
            r0 = 10
            goto Lb
        L77:
            r0 = 12
            goto Lb
        L7a:
            com.facebook.ads.redexgen.X.6W r1 = (com.facebook.ads.redexgen.X.C6W) r1
            java.util.ArrayList<java.util.ArrayList<com.facebook.ads.redexgen.X.7Z>> r0 = r1.A01
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L87
            r0 = 11
            goto Lb
        L87:
            r0 = 12
            goto Lb
        L8a:
            com.facebook.ads.redexgen.X.6W r1 = (com.facebook.ads.redexgen.X.C6W) r1
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r1.A02
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L98
            r0 = 9
            goto Lb
        L98:
            r0 = 12
            goto Lb
        L9c:
            com.facebook.ads.redexgen.X.6W r1 = (com.facebook.ads.redexgen.X.C6W) r1
            java.util.ArrayList<java.util.ArrayList<com.facebook.ads.redexgen.X.6S>> r0 = r1.A03
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Laa
            r0 = 12
            goto Lb
        Laa:
            r0 = 14
            goto Lb
        Lae:
            r2 = 0
            r0 = 13
            goto Lb
        Lb3:
            r2 = 1
            r0 = 13
            goto Lb
        Lb8:
            r0 = 12
            goto Lb
        Lbc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6W.A0J():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0025, code lost:            return r1;     */
    @Override // com.facebook.ads.redexgen.X.C6U
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0K(@android.support.annotation.NonNull com.facebook.ads.redexgen.X.C7Z r4, @android.support.annotation.NonNull java.util.List<java.lang.Object> r5) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r5.isEmpty()
            if (r0 == 0) goto L23
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1d;
                case 4: goto L25;
                case 5: goto L20;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.6W r2 = (com.facebook.ads.redexgen.X.C6W) r2
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            java.util.List r5 = (java.util.List) r5
            boolean r0 = super.A0K(r4, r5)
            if (r0 == 0) goto L1b
            r0 = 3
            goto L9
        L1b:
            r0 = 5
            goto L9
        L1d:
            r1 = 1
            r0 = 4
            goto L9
        L20:
            r1 = 0
            r0 = 4
            goto L9
        L23:
            r0 = 3
            goto L9
        L25:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6W.A0K(com.facebook.ads.redexgen.X.7Z, java.util.List):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.C6V
    public final boolean A0T(C7Z c7z) {
        A03(c7z);
        c7z.A0H.setAlpha(0.0f);
        this.A07.add(c7z);
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.C6V
    public final boolean A0U(C7Z c7z) {
        A03(c7z);
        this.A0A.add(c7z);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0071, code lost:            return r5;     */
    @Override // com.facebook.ads.redexgen.X.C6V
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0V(com.facebook.ads.redexgen.X.C7Z r12, int r13, int r14, int r15, int r16) {
        /*
            r11 = this;
            r6 = r12
            r7 = r13
            r8 = r14
            r4 = r11
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r5 = 0
            r0 = 0
            android.view.View r3 = r6.A0H
            android.view.View r0 = r6.A0H
            float r0 = r0.getTranslationX()
            int r0 = (int) r0
            int r7 = r7 + r0
            android.view.View r0 = r6.A0H
            float r0 = r0.getTranslationY()
            int r0 = (int) r0
            int r8 = r8 + r0
            r4.A03(r6)
            r9 = r15
            int r2 = r9 - r7
            r10 = r16
            int r1 = r10 - r8
            if (r2 != 0) goto L6f
            r0 = 2
        L29:
            switch(r0) {
                case 2: goto L57;
                case 3: goto L4d;
                case 4: goto L71;
                case 5: goto L47;
                case 6: goto L2d;
                case 7: goto L5d;
                case 8: goto L65;
                case 9: goto L36;
                default: goto L2c;
            }
        L2c:
            goto L29
        L2d:
            android.view.View r3 = (android.view.View) r3
            int r0 = -r2
            float r0 = (float) r0
            r3.setTranslationX(r0)
            r0 = 7
            goto L29
        L36:
            com.facebook.ads.redexgen.X.6W r4 = (com.facebook.ads.redexgen.X.C6W) r4
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            java.util.ArrayList<com.facebook.ads.redexgen.X.6T> r0 = r4.A09
            com.facebook.ads.redexgen.X.6T r5 = new com.facebook.ads.redexgen.X.6T
            r5.<init>(r6, r7, r8, r9, r10)
            r0.add(r5)
            r5 = 1
            r0 = 4
            goto L29
        L47:
            if (r2 == 0) goto L4b
            r0 = 6
            goto L29
        L4b:
            r0 = 7
            goto L29
        L4d:
            com.facebook.ads.redexgen.X.6W r4 = (com.facebook.ads.redexgen.X.C6W) r4
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            r4.A0N(r6)
            r5 = 0
            r0 = 4
            goto L29
        L57:
            if (r1 != 0) goto L5b
            r0 = 3
            goto L29
        L5b:
            r0 = 5
            goto L29
        L5d:
            if (r1 == 0) goto L62
            r0 = 8
            goto L29
        L62:
            r0 = 9
            goto L29
        L65:
            android.view.View r3 = (android.view.View) r3
            int r0 = -r1
            float r0 = (float) r0
            r3.setTranslationY(r0)
            r0 = 9
            goto L29
        L6f:
            r0 = 5
            goto L29
        L71:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6W.A0V(com.facebook.ads.redexgen.X.7Z, int, int, int, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0098, code lost:            return r6;     */
    @Override // com.facebook.ads.redexgen.X.C6V
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0W(com.facebook.ads.redexgen.X.C7Z r20, com.facebook.ads.redexgen.X.C7Z r21, int r22, int r23, int r24, int r25) {
        /*
            r19 = this;
            r8 = r21
            r7 = r20
            r13 = r19
            r3 = 0
            r6 = 0
            r2 = 0
            if (r7 != r8) goto L95
            r0 = 2
        Lc:
            r9 = r22
            r10 = r23
            r11 = r24
            r12 = r25
            switch(r0) {
                case 2: goto L18;
                case 3: goto L98;
                case 4: goto L2a;
                case 5: goto L77;
                case 6: goto L64;
                default: goto L17;
            }
        L17:
            goto Lc
        L18:
            com.facebook.ads.redexgen.X.6W r13 = (com.facebook.ads.redexgen.X.C6W) r13
            com.facebook.ads.redexgen.X.7Z r7 = (com.facebook.ads.redexgen.X.C7Z) r7
            r14 = r7
            r15 = r9
            r16 = r10
            r17 = r11
            r18 = r12
            boolean r6 = r13.A0V(r14, r15, r16, r17, r18)
            r0 = 3
            goto Lc
        L2a:
            com.facebook.ads.redexgen.X.6W r13 = (com.facebook.ads.redexgen.X.C6W) r13
            com.facebook.ads.redexgen.X.7Z r7 = (com.facebook.ads.redexgen.X.C7Z) r7
            com.facebook.ads.redexgen.X.7Z r8 = (com.facebook.ads.redexgen.X.C7Z) r8
            android.view.View r0 = r7.A0H
            float r5 = r0.getTranslationX()
            android.view.View r0 = r7.A0H
            float r4 = r0.getTranslationY()
            android.view.View r0 = r7.A0H
            float r1 = r0.getAlpha()
            r13.A03(r7)
            int r0 = r11 - r9
            float r0 = (float) r0
            float r0 = r0 - r5
            int r2 = (int) r0
            int r0 = r12 - r10
            float r0 = (float) r0
            float r0 = r0 - r4
            int r3 = (int) r0
            android.view.View r0 = r7.A0H
            r0.setTranslationX(r5)
            android.view.View r0 = r7.A0H
            r0.setTranslationY(r4)
            android.view.View r0 = r7.A0H
            r0.setAlpha(r1)
            if (r8 == 0) goto L62
            r0 = 5
            goto Lc
        L62:
            r0 = 6
            goto Lc
        L64:
            com.facebook.ads.redexgen.X.6W r13 = (com.facebook.ads.redexgen.X.C6W) r13
            com.facebook.ads.redexgen.X.7Z r7 = (com.facebook.ads.redexgen.X.C7Z) r7
            com.facebook.ads.redexgen.X.7Z r8 = (com.facebook.ads.redexgen.X.C7Z) r8
            java.util.ArrayList<com.facebook.ads.redexgen.X.6S> r0 = r13.A08
            com.facebook.ads.redexgen.X.6S r6 = new com.facebook.ads.redexgen.X.6S
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r0.add(r6)
            r6 = 1
            r0 = 3
            goto Lc
        L77:
            com.facebook.ads.redexgen.X.6W r13 = (com.facebook.ads.redexgen.X.C6W) r13
            com.facebook.ads.redexgen.X.7Z r8 = (com.facebook.ads.redexgen.X.C7Z) r8
            r13.A03(r8)
            android.view.View r1 = r8.A0H
            int r0 = -r2
            float r0 = (float) r0
            r1.setTranslationX(r0)
            android.view.View r1 = r8.A0H
            int r0 = -r3
            float r0 = (float) r0
            r1.setTranslationY(r0)
            android.view.View r1 = r8.A0H
            r0 = 0
            r1.setAlpha(r0)
            r0 = 6
            goto Lc
        L95:
            r0 = 4
            goto Lc
        L98:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6W.A0W(com.facebook.ads.redexgen.X.7Z, com.facebook.ads.redexgen.X.7Z, int, int, int, int):boolean");
    }

    public final void A0X() {
        if (!A0J()) {
            A08();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b5, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0Y(final com.facebook.ads.redexgen.X.C6S r12) {
        /*
            r11 = this;
            r7 = r11
            r0 = 0
            r6 = 0
            r0 = 0
            r5 = 0
            r4 = 0
            r0 = 0
            r10 = 0
            r3 = 0
            com.facebook.ads.redexgen.X.7Z r2 = r12.A05
            if (r2 != 0) goto Lb1
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L6d;
                case 3: goto L12;
                case 4: goto L67;
                case 5: goto L61;
                case 6: goto L1d;
                case 7: goto L59;
                case 8: goto L71;
                case 9: goto Lb5;
                case 10: goto La6;
                case 11: goto Laa;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            com.facebook.ads.redexgen.X.6S r12 = (com.facebook.ads.redexgen.X.C6S) r12
            com.facebook.ads.redexgen.X.7Z r5 = r12.A04
            if (r5 == 0) goto L1a
            r0 = 4
            goto Le
        L1a:
            r0 = 10
            goto Le
        L1d:
            com.facebook.ads.redexgen.X.6W r7 = (com.facebook.ads.redexgen.X.C6W) r7
            com.facebook.ads.redexgen.X.6S r12 = (com.facebook.ads.redexgen.X.C6S) r12
            r3 = 0
            android.view.ViewPropertyAnimator r8 = r4.animate()
            long r0 = r7.A03()
            android.view.ViewPropertyAnimator r8 = r8.setDuration(r0)
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r1 = r7.A02
            com.facebook.ads.redexgen.X.7Z r0 = r12.A05
            r1.add(r0)
            int r1 = r12.A02
            int r0 = r12.A00
            int r1 = r1 - r0
            float r0 = (float) r1
            r8.translationX(r0)
            int r1 = r12.A03
            int r0 = r12.A01
            int r1 = r1 - r0
            float r0 = (float) r1
            r8.translationY(r0)
            android.view.ViewPropertyAnimator r1 = r8.alpha(r3)
            com.facebook.ads.redexgen.X.6Q r0 = new com.facebook.ads.redexgen.X.6Q
            r0.<init>()
            android.view.ViewPropertyAnimator r0 = r1.setListener(r0)
            r0.start()
            r0 = 7
            goto Le
        L59:
            if (r6 == 0) goto L5e
            r0 = 8
            goto Le
        L5e:
            r0 = 9
            goto Le
        L61:
            if (r4 == 0) goto L65
            r0 = 6
            goto Le
        L65:
            r0 = 7
            goto Le
        L67:
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            android.view.View r6 = r5.A0H
            r0 = 5
            goto Le
        L6d:
            r10 = 0
            r4 = r10
            r0 = 3
            goto Le
        L71:
            com.facebook.ads.redexgen.X.6W r7 = (com.facebook.ads.redexgen.X.C6W) r7
            com.facebook.ads.redexgen.X.6S r12 = (com.facebook.ads.redexgen.X.C6S) r12
            android.view.ViewPropertyAnimator r9 = r6.animate()
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r1 = r7.A02
            com.facebook.ads.redexgen.X.7Z r0 = r12.A04
            r1.add(r0)
            android.view.ViewPropertyAnimator r0 = r9.translationX(r3)
            android.view.ViewPropertyAnimator r8 = r0.translationY(r3)
            long r0 = r7.A03()
            android.view.ViewPropertyAnimator r1 = r8.setDuration(r0)
            r0 = 1065353216(0x3f800000, float:1.0)
            android.view.ViewPropertyAnimator r1 = r1.alpha(r0)
            com.facebook.ads.redexgen.X.6R r0 = new com.facebook.ads.redexgen.X.6R
            r0.<init>()
            android.view.ViewPropertyAnimator r0 = r1.setListener(r0)
            r0.start()
            r0 = 9
            goto Le
        La6:
            r6 = r10
            r0 = 5
            goto Le
        Laa:
            com.facebook.ads.redexgen.X.7Z r2 = (com.facebook.ads.redexgen.X.C7Z) r2
            android.view.View r4 = r2.A0H
            r0 = 3
            goto Le
        Lb1:
            r0 = 11
            goto Le
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6W.A0Y(com.facebook.ads.redexgen.X.6S):void");
    }

    public final void A0Z(final C7Z c7z) {
        final View view = c7z.A0H;
        final ViewPropertyAnimator animate = view.animate();
        this.A00.add(c7z);
        animate.alpha(1.0f).setDuration(A02()).setListener(new AnimatorListenerAdapter() { // from class: com.facebook.ads.redexgen.X.6O
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                C6W.this.A0L(c7z);
                C6W.this.A00.remove(c7z);
                C6W.this.A0X();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                C6W.this.A0M(c7z);
            }
        }).start();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0032, code lost:            r2 = r8;        r3 = r9;        r5 = r5;        r7 = r5.animate();        r2.A04.add(r3);        r0 = r7.setDuration(r2.A04());        r0.setListener(new com.facebook.ads.redexgen.X.C6P(r2, r3, r4, r5, r6, r7)).start();     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0a(com.facebook.ads.redexgen.X.C7Z r9, int r10, int r11, int r12, int r13) {
        /*
            r8 = this;
            r3 = r9
            r4 = r12
            r6 = r13
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r1 = 0
            android.view.View r5 = r3.A0H
            int r4 = r4 - r10
            int r6 = r6 - r11
            if (r4 == 0) goto L30
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L13;
                case 3: goto L1f;
                case 4: goto L25;
                case 5: goto L32;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            android.view.View r5 = (android.view.View) r5
            r1 = 0
            android.view.ViewPropertyAnimator r0 = r5.animate()
            r0.translationX(r1)
            r0 = 3
            goto Lf
        L1f:
            if (r6 == 0) goto L23
            r0 = 4
            goto Lf
        L23:
            r0 = 5
            goto Lf
        L25:
            android.view.View r5 = (android.view.View) r5
            android.view.ViewPropertyAnimator r0 = r5.animate()
            r0.translationY(r1)
            r0 = 5
            goto Lf
        L30:
            r0 = 3
            goto Lf
        L32:
            r2 = r8
            com.facebook.ads.redexgen.X.6W r2 = (com.facebook.ads.redexgen.X.C6W) r2
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            android.view.View r5 = (android.view.View) r5
            android.view.ViewPropertyAnimator r7 = r5.animate()
            java.util.ArrayList<com.facebook.ads.redexgen.X.7Z> r0 = r2.A04
            r0.add(r3)
            long r0 = r2.A04()
            android.view.ViewPropertyAnimator r0 = r7.setDuration(r0)
            com.facebook.ads.redexgen.X.6P r1 = new com.facebook.ads.redexgen.X.6P
            r1.<init>()
            android.view.ViewPropertyAnimator r0 = r0.setListener(r1)
            r0.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6W.A0a(com.facebook.ads.redexgen.X.7Z, int, int, int, int):void");
    }
}

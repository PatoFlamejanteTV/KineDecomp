package com.facebook.ads.redexgen.X;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.6U, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C6U {
    public C7B A04 = null;
    public ArrayList<RecyclerView.ItemAnimator.ItemAnimatorFinishedListener> A05 = new ArrayList<>();
    public long A00 = 120;
    public long A03 = 120;
    public long A02 = 250;
    public long A01 = 250;

    public abstract boolean A0C(@NonNull C7Z c7z, @Nullable C7C c7c, @NonNull C7C c7c2);

    public abstract boolean A0D(@NonNull C7Z c7z, @NonNull C7C c7c, @Nullable C7C c7c2);

    public abstract boolean A0E(@NonNull C7Z c7z, @NonNull C7C c7c, @NonNull C7C c7c2);

    public abstract boolean A0F(@NonNull C7Z c7z, @NonNull C7Z c7z2, @NonNull C7C c7c, @NonNull C7C c7c2);

    public abstract void A0G();

    public abstract void A0H();

    public abstract void A0I(C7Z c7z);

    public abstract boolean A0J();

    /* JADX WARN: Code restructure failed: missing block: B:51:0x004d, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A00(com.facebook.ads.redexgen.X.C7Z r6) {
        /*
            r5 = 0
            r0 = 0
            r4 = 0
            r3 = 0
            r0 = 0
            r2 = -1
            int r0 = com.facebook.ads.redexgen.X.C7Z.A00(r6)
            r1 = r0 & 14
            boolean r0 = r6.A0b()
            if (r0 == 0) goto L4b
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L3b;
                case 3: goto L4d;
                case 4: goto L32;
                case 5: goto L21;
                case 6: goto L17;
                case 7: goto L3e;
                case 8: goto L46;
                case 9: goto L1e;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            if (r5 == r2) goto L1b
            r0 = 7
            goto L13
        L1b:
            r0 = 9
            goto L13
        L1e:
            r3 = r1
            r0 = 3
            goto L13
        L21:
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            int r4 = r6.A0J()
            int r5 = r6.A0G()
            if (r4 == r2) goto L2f
            r0 = 6
            goto L13
        L2f:
            r0 = 9
            goto L13
        L32:
            r0 = r1 & 4
            if (r0 != 0) goto L38
            r0 = 5
            goto L13
        L38:
            r0 = 9
            goto L13
        L3b:
            r3 = 4
            r0 = 3
            goto L13
        L3e:
            if (r4 == r5) goto L43
            r0 = 8
            goto L13
        L43:
            r0 = 9
            goto L13
        L46:
            r1 = r1 | 2048(0x800, float:2.87E-42)
            r0 = 9
            goto L13
        L4b:
            r0 = 4
            goto L13
        L4d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6U.A00(com.facebook.ads.redexgen.X.7Z):int");
    }

    private final C7C A01() {
        return new C7C();
    }

    public final long A02() {
        return this.A00;
    }

    public final long A03() {
        return this.A01;
    }

    public final long A04() {
        return this.A02;
    }

    public final long A05() {
        return this.A03;
    }

    @NonNull
    public final C7C A06(@NonNull C7W c7w, @NonNull C7Z c7z) {
        return A01().A01(c7z);
    }

    @NonNull
    public final C7C A07(@NonNull C7W c7w, @NonNull C7Z c7z, int i, @NonNull List<Object> list) {
        return A01().A01(c7z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0020, code lost:            r3.A05.clear();     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0027, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A08() {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r0 = 0
            java.util.ArrayList<com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$ItemAnimator$ItemAnimatorFinishedListener> r0 = r3.A05
            int r2 = r0.size()
            r1 = 0
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L15;
                case 4: goto L20;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            if (r1 >= r2) goto L13
            r0 = 3
            goto Lb
        L13:
            r0 = 4
            goto Lb
        L15:
            com.facebook.ads.redexgen.X.6U r3 = (com.facebook.ads.redexgen.X.C6U) r3
            java.util.ArrayList<com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$ItemAnimator$ItemAnimatorFinishedListener> r0 = r3.A05
            r0.get(r1)
            int r1 = r1 + 1
            r0 = 2
            goto Lb
        L20:
            com.facebook.ads.redexgen.X.6U r3 = (com.facebook.ads.redexgen.X.C6U) r3
            java.util.ArrayList<com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$ItemAnimator$ItemAnimatorFinishedListener> r0 = r3.A05
            r0.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6U.A08():void");
    }

    public final void A09(C7B c7b) {
        this.A04 = c7b;
    }

    public final void A0A(C7Z c7z) {
        if (this.A04 != null) {
            this.A04.A6A(c7z);
        }
    }

    public boolean A0B(@NonNull C7Z c7z) {
        return true;
    }

    public boolean A0K(@NonNull C7Z c7z, @NonNull List<Object> list) {
        return A0B(c7z);
    }
}

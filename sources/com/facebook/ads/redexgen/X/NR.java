package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* loaded from: assets/audience_network.dex */
public final class NR extends AsyncTask<String, Void, Bitmap[]> implements InterfaceC02138i {
    public static byte[] A0A;
    public int A00;
    public int A01;
    public C2B A02;
    public boolean A03;
    public final int A04;
    public final int A05;

    @Nullable
    public final WeakReference<NO> A06;
    public final WeakReference<C0362Ec> A07;

    @Nullable
    public final WeakReference<ImageView> A08;

    @Nullable
    public final WeakReference<ViewGroup> A09;

    static {
        A01();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.NR.A0A
            int r0 = r2 + r3
            byte[] r2 = java.util.Arrays.copyOfRange(r1, r2, r0)
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L19;
                case 4: goto L27;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            if (r1 >= r0) goto L17
            r0 = 3
            goto Lc
        L17:
            r0 = 4
            goto Lc
        L19:
            byte[] r2 = (byte[]) r2
            r0 = r2[r1]
            int r0 = r0 - r4
            int r0 = r0 + (-84)
            byte r0 = (byte) r0
            r2[r1] = r0
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L27:
            byte[] r2 = (byte[]) r2
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NR.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A0A = new byte[]{54, 52, 61, 52, 65, 56, 50};
    }

    public NR(ViewGroup viewGroup, int i, int i2, C0362Ec c0362Ec) {
        this.A03 = false;
        this.A00 = -1;
        this.A01 = -1;
        this.A07 = new WeakReference<>(c0362Ec);
        this.A06 = null;
        this.A08 = null;
        this.A09 = new WeakReference<>(viewGroup);
        this.A04 = i;
        this.A05 = i2;
    }

    public NR(ViewGroup viewGroup, C0362Ec c0362Ec) {
        this(viewGroup, 12, 16, c0362Ec);
    }

    public NR(ImageView imageView, C0362Ec c0362Ec) {
        this.A03 = false;
        this.A00 = -1;
        this.A01 = -1;
        this.A07 = new WeakReference<>(c0362Ec);
        this.A06 = null;
        this.A08 = new WeakReference<>(imageView);
        this.A09 = null;
        this.A04 = 0;
        this.A05 = 1;
    }

    public NR(NO no, C0362Ec c0362Ec) {
        this.A03 = false;
        this.A00 = -1;
        this.A01 = -1;
        this.A07 = new WeakReference<>(c0362Ec);
        this.A06 = new WeakReference<>(no);
        this.A08 = null;
        this.A09 = null;
        this.A04 = 12;
        this.A05 = 16;
    }

    private final void A02(Bitmap[] bitmapArr) {
        NO no;
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            if (this.A08 != null) {
                ImageView imageView = this.A08.get();
                if (bitmapArr[1] != null && !this.A03 && this.A04 != 0 && imageView != null) {
                    imageView.setImageBitmap(bitmapArr[1]);
                    return;
                } else if (imageView != null) {
                    imageView.setImageBitmap(bitmapArr[0]);
                }
            }
            if (this.A06 != null && (no = this.A06.get()) != null) {
                no.setImage(bitmapArr[0], bitmapArr[1]);
            }
            if (this.A09 != null && this.A09.get() != null && bitmapArr[1] != null) {
                KE.A0T(this.A09.get(), new BitmapDrawable(this.A07.get().getResources(), bitmapArr[1]));
            }
            if (this.A02 == null) {
                return;
            }
            this.A02.A6h(bitmapArr[0] != null);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    private final Bitmap[] A03(String... strArr) {
        if (C0466Ig.A02(this)) {
            return null;
        }
        try {
            String str = strArr[0];
            Bitmap bitmap = null;
            Bitmap bitmap2 = null;
            C0362Ec c0362Ec = this.A07.get();
            if (c0362Ec == null) {
                return new Bitmap[]{null, null};
            }
            try {
                bitmap = new EV(c0362Ec).A0I(str, this.A00, this.A01);
                if (bitmap != null && !this.A03) {
                    bitmap2 = KL.A01(c0362Ec, bitmap, this.A04, this.A05);
                }
            } catch (Throwable th) {
                C0511Kb.A06(c0362Ec, A00(0, 7, 123), C0512Kc.A17, new C0514Ke(th));
            }
            return new Bitmap[]{bitmap, bitmap2};
        } catch (Throwable e) {
            C0466Ig.A00(e, this);
            return null;
        }
    }

    public final NR A04() {
        this.A00 = -1;
        this.A01 = -1;
        return this;
    }

    public final NR A05(int i, int i2) {
        this.A00 = i;
        this.A01 = i2;
        return this;
    }

    public final NR A06(C2B c2b) {
        this.A02 = c2b;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0035, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A07(java.lang.String r5) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r0 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L33
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L18;
                case 4: goto L35;
                case 5: goto L22;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.NR r3 = (com.facebook.ads.redexgen.X.NR) r3
            com.facebook.ads.redexgen.X.2B r0 = r3.A02
            if (r0 == 0) goto L16
            r0 = 3
            goto La
        L16:
            r0 = 4
            goto La
        L18:
            com.facebook.ads.redexgen.X.NR r3 = (com.facebook.ads.redexgen.X.NR) r3
            r1 = 0
            com.facebook.ads.redexgen.X.2B r0 = r3.A02
            r0.A6h(r1)
            r0 = 4
            goto La
        L22:
            com.facebook.ads.redexgen.X.NR r3 = (com.facebook.ads.redexgen.X.NR) r3
            java.lang.String r5 = (java.lang.String) r5
            r2 = 0
            java.util.concurrent.Executor r1 = com.facebook.ads.redexgen.X.KJ.A05
            r0 = 1
            java.lang.String[] r0 = new java.lang.String[r0]
            r0[r2] = r5
            r3.executeOnExecutor(r1, r0)
            r0 = 4
            goto La
        L33:
            r0 = 5
            goto La
        L35:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NR.A07(java.lang.String):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC02138i
    @Nullable
    public final C0362Ec A4E() {
        return this.A07.get();
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Bitmap[] doInBackground(String[] strArr) {
        Bitmap[] bitmapArr = null;
        if (C0466Ig.A02(this)) {
            return null;
        }
        try {
            bitmapArr = A03(strArr);
            return bitmapArr;
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
            return bitmapArr;
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Bitmap[] bitmapArr) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(bitmapArr);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}

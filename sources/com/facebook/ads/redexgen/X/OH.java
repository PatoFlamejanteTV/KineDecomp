package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public abstract class OH extends AbstractC0604Nr {
    public RelativeLayout A00;
    public MB A01;
    public OO A02;
    public PG A03;
    public PL A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public final Paint A08;
    public final Path A09;
    public final RectF A0A;
    public final C0362Ec A0B;
    public final AbstractC02238s A0C;
    public final AbstractC02198o A0D;
    public final AbstractC02178m A0E;
    public final AbstractC02158k A0F;
    public final AbstractC02258u A0G;
    public final String A0H;
    public static final int A0J = (int) (1.0f * KE.A01);
    public static final int A0K = (int) (4.0f * KE.A01);
    public static final int A0I = (int) (6.0f * KE.A01);

    public abstract void A0g(C0362Ec c0362Ec);

    public OH(C0610Nx c0610Nx, C2T c2t, boolean z, String str, PG pg) {
        super(c0610Nx, c2t, z);
        this.A09 = new Path();
        this.A0A = new RectF();
        this.A0G = new OJ(this);
        this.A0C = new OK(this);
        this.A0E = new OL(this);
        this.A0D = new OM(this);
        this.A0F = new ON(this);
        this.A03 = pg;
        this.A0H = str;
        this.A0B = c0610Nx.A05();
        setGravity(17);
        setPadding(A0J, 0, A0J, A0J);
        KE.A0P(this, 0);
        setUpView(this.A0B);
        this.A08 = new Paint();
        this.A08.setColor(-16777216);
        this.A08.setStyle(Paint.Style.FILL);
        this.A08.setAlpha(16);
        this.A08.setAntiAlias(true);
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0041, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A02() {
        /*
            r2 = this;
            r1 = r2
            com.facebook.ads.redexgen.X.OO r0 = r1.A02
            if (r0 != 0) goto L3f
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L41;
                case 3: goto L2a;
                case 4: goto L20;
                case 5: goto L14;
                case 6: goto La;
                case 7: goto L36;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.OH r1 = (com.facebook.ads.redexgen.X.OH) r1
            boolean r0 = r1.A06
            if (r0 == 0) goto L12
            r0 = 7
            goto L6
        L12:
            r0 = 2
            goto L6
        L14:
            com.facebook.ads.redexgen.X.OH r1 = (com.facebook.ads.redexgen.X.OH) r1
            boolean r0 = r1.A0j()
            if (r0 != 0) goto L1e
            r0 = 6
            goto L6
        L1e:
            r0 = 2
            goto L6
        L20:
            com.facebook.ads.redexgen.X.OH r1 = (com.facebook.ads.redexgen.X.OH) r1
            boolean r0 = r1.A07
            if (r0 != 0) goto L28
            r0 = 5
            goto L6
        L28:
            r0 = 7
            goto L6
        L2a:
            com.facebook.ads.redexgen.X.OH r1 = (com.facebook.ads.redexgen.X.OH) r1
            boolean r0 = r1.A0j()
            if (r0 == 0) goto L34
            r0 = 4
            goto L6
        L34:
            r0 = 5
            goto L6
        L36:
            com.facebook.ads.redexgen.X.OH r1 = (com.facebook.ads.redexgen.X.OH) r1
            com.facebook.ads.redexgen.X.OO r0 = r1.A02
            r0.A6C()
            r0 = 2
            goto L6
        L3f:
            r0 = 3
            goto L6
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OH.A02():void");
    }

    private void A03(View view) {
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        KE.A0N(view);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public boolean A07() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final boolean A0b() {
        return false;
    }

    public final void A0d() {
        if (A0j()) {
            this.A04.A01();
        }
    }

    public final void A0e() {
        if (A0j()) {
            A0f();
            this.A04.A05(QH.A03);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0f() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            com.facebook.ads.redexgen.X.PG r0 = r2.A03
            com.facebook.ads.redexgen.X.OS r0 = r0.A0Y()
            float r1 = r0.getVolume()
            boolean r0 = r2.A0j()
            if (r0 == 0) goto L30
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L17;
                case 3: goto L27;
                case 4: goto L32;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            com.facebook.ads.redexgen.X.OH r2 = (com.facebook.ads.redexgen.X.OH) r2
            com.facebook.ads.redexgen.X.PL r0 = r2.A04
            float r0 = r0.getVolume()
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 == 0) goto L25
            r0 = 3
            goto L13
        L25:
            r0 = 4
            goto L13
        L27:
            com.facebook.ads.redexgen.X.OH r2 = (com.facebook.ads.redexgen.X.OH) r2
            com.facebook.ads.redexgen.X.PL r0 = r2.A04
            r0.setVolume(r1)
            r0 = 4
            goto L13
        L30:
            r0 = 4
            goto L13
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OH.A0f():void");
    }

    public final void A0h(Map<String, String> map) {
        this.A04.A02();
        if (A0j()) {
            this.A04.A04(getAdEventManager(), this.A0H, map);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0023, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0i() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A0j()
            if (r0 == 0) goto L21
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1e;
                case 4: goto L23;
                case 5: goto L1b;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.OH r2 = (com.facebook.ads.redexgen.X.OH) r2
            com.facebook.ads.redexgen.X.PL r0 = r2.A04
            boolean r0 = r0.A06()
            if (r0 == 0) goto L19
            r0 = 3
            goto L9
        L19:
            r0 = 5
            goto L9
        L1b:
            r1 = 0
            r0 = 4
            goto L9
        L1e:
            r1 = 1
            r0 = 4
            goto L9
        L21:
            r0 = 5
            goto L9
        L23:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OH.A0i():boolean");
    }

    public final boolean A0j() {
        return this.A05;
    }

    public final RelativeLayout getMediaContainer() {
        return this.A00;
    }

    public final PL getVideoView() {
        return this.A04;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        this.A09.reset();
        this.A0A.set(0.0f, 0.0f, getWidth(), getHeight());
        this.A09.addRoundRect(this.A0A, A0I, A0I, Path.Direction.CW);
        canvas.drawPath(this.A09, this.A08);
        this.A0A.set(A0J, 0.0f, getWidth() - A0J, getHeight() - A0J);
        this.A09.addRoundRect(this.A0A, A0K, A0K, Path.Direction.CW);
        canvas.clipPath(this.A09);
        super.onDraw(canvas);
    }

    public void setAdTitleAndDescription(String str, String str2) {
        getTitleDescContainer().A00(str, str2, null, true, false);
    }

    public void setCTAInfo(C2U c2u, Map<String, String> map) {
        getCtaButton().setCta(c2u, this.A0H, map);
    }

    public void setImageUrl(String str) {
        this.A01.setVisibility(0);
        this.A04.setVisibility(8);
        new NR(this.A01, this.A0B).A04().A06(new OP(this, null)).A07(str);
    }

    public void setIsVideo(boolean z) {
        this.A05 = z;
    }

    public void setOnAssetsLoadedListener(OO oo) {
        this.A02 = oo;
    }

    public void setUpImageView(C0362Ec c0362Ec) {
        this.A01 = new MB(c0362Ec);
        A03(this.A01);
    }

    public void setUpMediaContainer(C0362Ec c0362Ec) {
        this.A00 = new RelativeLayout(c0362Ec);
        A03(this.A00);
    }

    public void setUpVideoView(C0362Ec c0362Ec) {
        this.A04 = new PL(c0362Ec, new C0432Gv(this.A0H, getAdEventManager()));
        A03(this.A04);
    }

    private void setUpView(C0362Ec c0362Ec) {
        setUpImageView(c0362Ec);
        setUpVideoView(c0362Ec);
        setUpMediaContainer(c0362Ec);
        this.A00.addView(this.A01);
        this.A00.addView(this.A04);
        A0g(c0362Ec);
    }

    public void setVideoPlaceholderUrl(String str) {
        this.A04.setPlaceholderUrl(str);
    }

    public void setVideoUrl(String str) {
        this.A01.setVisibility(8);
        this.A04.setVisibility(0);
        this.A04.setVideoURI(str);
        this.A04.A03(this.A0G);
        this.A04.A03(this.A0C);
        this.A04.A03(this.A0E);
        this.A04.A03(this.A0D);
        this.A04.A03(this.A0F);
    }
}

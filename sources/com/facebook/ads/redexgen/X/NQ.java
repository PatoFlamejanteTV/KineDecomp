package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* loaded from: assets/audience_network.dex */
public final class NQ extends Drawable {
    public static byte[] A0G;
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public String A04;
    public String A05;

    @Nullable
    public String A06;

    @Nullable
    public WeakReference<FP> A07;
    public boolean A08;
    public final Paint A09 = new Paint();
    public final Paint A0A = new Paint();
    public final Path A0C = new Path();
    public final TextPaint A0E = new TextPaint();
    public final Paint A0B = new Paint();
    public final Handler A0D = new Handler();
    public final Runnable A0F = new NP(this);

    static {
        A04();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.NQ.A0G
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
            r0 = r0 ^ r4
            r0 = r0 ^ 79
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NQ.A02(int, int, int):java.lang.String");
    }

    public static void A04() {
        A0G = new byte[]{87, 26, 124, 71, 66, 71, 70, 94, 71, 109, 49, 14, 2, 16, 93, 71, 70, 14, 67, 116, 123, 48, 121, 117, 25, 58, 52, 49, 48, 49, 117, 89, 20, 43, 39, 53, 35, 32, 43, 46, 43, 54, 59, 98, 1, 42, 39, 33, 41, 39, 48, 98, 44, 45, 54, 98, 49, 39, 54, 23, 12, 21, 12, 19, 0, 79, 70, 0, 36, 6, 21, 3, 71, 22, 69, 4, 2, 10, 113, 86, 81, 76, 81, 89, 84, 81, 66, 81, 86, 95, 22, 22, 22};
    }

    public NQ() {
        this.A09.setColor(Color.argb(127, 36, 36, 36));
        this.A09.setStyle(Paint.Style.FILL_AND_STROKE);
        this.A0A.setAntiAlias(true);
        this.A0A.setColor(Color.argb(191, 0, 255, 0));
        this.A0A.setStrokeWidth(20.0f);
        this.A0A.setStyle(Paint.Style.STROKE);
        this.A0E.setAntiAlias(true);
        this.A0E.setColor(-1);
        this.A0E.setStyle(Paint.Style.FILL_AND_STROKE);
        this.A0E.setTextSize(30.0f);
        this.A0B.setColor(Color.argb(212, 0, 0, 0));
        this.A0B.setStyle(Paint.Style.FILL_AND_STROKE);
        A07();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01f7, code lost:            r8 = r8;        r0 = (int) (0.5f + r6);        r8.A02 = r0;        r8.invalidateSelf();     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0202, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A03() {
        /*
            Method dump skipped, instructions count: 562
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NQ.A03():void");
    }

    public final void A07() {
        this.A00 = 0;
        this.A01 = -1;
        this.A05 = A02(78, 15, 119);
        this.A02 = 100;
        this.A06 = null;
        this.A03 = -1L;
        this.A07 = null;
        A0D(false);
    }

    public final void A08(int i, int i2) {
        this.A00 = i;
        this.A01 = i2;
        A03();
    }

    public final void A09(long j) {
        this.A03 = j;
        A03();
    }

    public final void A0A(FP fp) {
        this.A07 = new WeakReference<>(fp);
        A03();
    }

    public final void A0B(String str) {
        this.A04 = str;
        A03();
    }

    public final void A0C(String str) {
        this.A06 = str;
        A03();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:            r2.invalidateSelf();     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0D(boolean r4) {
        /*
            r3 = this;
            r2 = r3
            r2.A08 = r4
            boolean r0 = r2.A08
            if (r0 == 0) goto L22
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L24;
                case 4: goto L17;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.NQ r2 = (com.facebook.ads.redexgen.X.NQ) r2
            android.os.Handler r1 = r2.A0D
            java.lang.Runnable r0 = r2.A0F
            r1.post(r0)
            r0 = 3
            goto L8
        L17:
            com.facebook.ads.redexgen.X.NQ r2 = (com.facebook.ads.redexgen.X.NQ) r2
            android.os.Handler r1 = r2.A0D
            java.lang.Runnable r0 = r2.A0F
            r1.removeCallbacks(r0)
            r0 = 3
            goto L8
        L22:
            r0 = 4
            goto L8
        L24:
            com.facebook.ads.redexgen.X.NQ r2 = (com.facebook.ads.redexgen.X.NQ) r2
            r2.invalidateSelf()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NQ.A0D(boolean):void");
    }

    public final boolean A0E() {
        return this.A08;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (!this.A08) {
            return;
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        canvas.drawRect(0.0f, 0.0f, width, height, this.A09);
        String str = this.A05;
        TextPaint textPaint = this.A0E;
        int canvasHeight = this.A02;
        StaticLayout staticLayout = new StaticLayout(str, textPaint, canvasHeight, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        float f = width / 2.0f;
        float f2 = height / 2.0f;
        float width2 = staticLayout.getWidth() / 2.0f;
        float height2 = staticLayout.getHeight() / 2.0f;
        float textMiddleY = f - width2;
        float canvasMiddleX = 40.0f + f + width2;
        canvas.drawRect(textMiddleY - 40.0f, (f2 - height2) - 40.0f, canvasMiddleX, 40.0f + f2 + height2, this.A0B);
        canvas.save();
        canvas.translate(f - width2, f2 - height2);
        staticLayout.draw(canvas);
        canvas.restore();
        this.A0C.reset();
        this.A0C.moveTo(0.0f, 0.0f);
        this.A0C.lineTo(width, 0.0f);
        this.A0C.lineTo(width, height);
        this.A0C.lineTo(0.0f, height);
        this.A0C.lineTo(0.0f, 0.0f);
        canvas.drawPath(this.A0C, this.A0A);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(@IntRange(from = 0, to = 255) int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}

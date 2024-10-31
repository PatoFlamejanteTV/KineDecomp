package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* loaded from: assets/audience_network.dex */
public final class KL {
    @TargetApi(18)
    public static Bitmap A00(C0362Ec c0362Ec, Bitmap bitmap, int i) throws RSRuntimeException {
        RenderScript rs = null;
        Allocation allocation = null;
        Allocation allocation2 = null;
        ScriptIntrinsicBlur scriptIntrinsicBlur = null;
        try {
            rs = RenderScript.create(c0362Ec);
            rs.setMessageHandler(new RenderScript.RSMessageHandler());
            allocation = Allocation.createFromBitmap(rs, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            allocation2 = Allocation.createTyped(rs, allocation.getType());
            scriptIntrinsicBlur = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
            scriptIntrinsicBlur.setInput(allocation);
            scriptIntrinsicBlur.setRadius(i);
            scriptIntrinsicBlur.forEach(allocation2);
            allocation2.copyTo(bitmap);
            return bitmap;
        } finally {
            if (rs != null) {
                rs.destroy();
            }
            if (allocation != null) {
                allocation.destroy();
            }
            if (allocation2 != null) {
                allocation2.destroy();
            }
            if (scriptIntrinsicBlur != null) {
                scriptIntrinsicBlur.destroy();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0092, code lost:            return r6;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap A01(com.facebook.ads.redexgen.X.C0362Ec r9, android.graphics.Bitmap r10, int r11, int r12) {
        /*
            r5 = 0
            r6 = 0
            r0 = 0
            r0 = 0
            int r4 = r10.getWidth()
            int r4 = r4 / r12
            int r3 = r10.getHeight()
            int r3 = r3 / r12
            if (r4 == 0) goto L8e
            r0 = 2
        L11:
            switch(r0) {
                case 2: goto L55;
                case 3: goto L4b;
                case 4: goto L48;
                case 5: goto L90;
                case 6: goto L15;
                case 7: goto L5b;
                case 8: goto L14;
                case 9: goto L77;
                default: goto L14;
            }
        L14:
            goto L11
        L15:
            android.graphics.Bitmap r10 = (android.graphics.Bitmap) r10
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r4, r3, r0)
            android.graphics.Canvas r8 = new android.graphics.Canvas
            r8.<init>(r5)
            r2 = 1065353216(0x3f800000, float:1.0)
            float r0 = (float) r12
            float r2 = r2 / r0
            r1 = 1065353216(0x3f800000, float:1.0)
            float r0 = (float) r12
            float r1 = r1 / r0
            r8.scale(r2, r1)
            android.graphics.Paint r7 = new android.graphics.Paint
            r7.<init>()
            r0 = 3
            r7.setFlags(r0)
            android.graphics.PorterDuffColorFilter r2 = new android.graphics.PorterDuffColorFilter
            r1 = 0
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.SRC_ATOP
            r2.<init>(r1, r0)
            r7.setColorFilter(r2)
            r1 = 0
            r0 = 0
            r8.drawBitmap(r10, r1, r0, r7)
            r0 = 7
            goto L11
        L48:
            r6 = 0
            r0 = 5
            goto L11
        L4b:
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 18
            if (r1 >= r0) goto L53
            r0 = 4
            goto L11
        L53:
            r0 = 6
            goto L11
        L55:
            if (r3 == 0) goto L59
            r0 = 3
            goto L11
        L59:
            r0 = 4
            goto L11
        L5b:
            com.facebook.ads.redexgen.X.Ec r9 = (com.facebook.ads.redexgen.X.C0362Ec) r9     // Catch: android.renderscript.RSRuntimeException -> L6b
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5     // Catch: android.renderscript.RSRuntimeException -> L6b
            android.graphics.Bitmap r6 = A00(r9, r5, r11)     // Catch: android.renderscript.RSRuntimeException -> L6b
            r0 = 1
            if (r12 == r0) goto L69
            r0 = 9
            goto L11
        L69:
            r0 = 5
            goto L11
        L6b:
            com.facebook.ads.redexgen.X.KP r1 = new com.facebook.ads.redexgen.X.KP
            r1.<init>()
            float r0 = (float) r11
            android.graphics.Bitmap r6 = r1.A02(r5, r0)
            r0 = 5
            goto L11
        L77:
            android.graphics.Bitmap r10 = (android.graphics.Bitmap) r10
            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
            int r2 = r10.getWidth()
            int r1 = r10.getHeight()
            r0 = 1
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createScaledBitmap(r6, r2, r1, r0)
            r6.recycle()
            r6 = r0
            r0 = 5
            goto L11
        L8e:
            r0 = 4
            goto L11
        L90:
            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KL.A01(com.facebook.ads.redexgen.X.Ec, android.graphics.Bitmap, int, int):android.graphics.Bitmap");
    }
}

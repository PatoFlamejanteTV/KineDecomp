package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;

/* loaded from: assets/audience_network.dex */
public final class KN {
    public static Bitmap A00(KM km) {
        byte[] decode = Base64.decode(km.A00(KE.A01), 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static Drawable A01(C0362Ec c0362Ec, KM km) {
        return new BitmapDrawable(c0362Ec.getResources(), A00(km));
    }
}

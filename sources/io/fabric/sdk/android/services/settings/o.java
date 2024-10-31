package io.fabric.sdk.android.services.settings;

import android.content.Context;
import android.graphics.BitmapFactory;
import io.fabric.sdk.android.services.common.CommonUtils;

/* compiled from: IconRequest.java */
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a */
    public final String f27032a;

    /* renamed from: b */
    public final int f27033b;

    /* renamed from: c */
    public final int f27034c;

    /* renamed from: d */
    public final int f27035d;

    public o(String str, int i, int i2, int i3) {
        this.f27032a = str;
        this.f27033b = i;
        this.f27034c = i2;
        this.f27035d = i3;
    }

    public static o a(Context context, String str) {
        if (str != null) {
            try {
                int d2 = CommonUtils.d(context);
                io.fabric.sdk.android.f.f().d("Fabric", "App icon resource ID is " + d2);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(context.getResources(), d2, options);
                return new o(str, d2, options.outWidth, options.outHeight);
            } catch (Exception e2) {
                io.fabric.sdk.android.f.f().c("Fabric", "Failed to load icon", e2);
            }
        }
        return null;
    }
}

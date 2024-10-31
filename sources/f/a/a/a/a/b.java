package f.a.a.a.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* compiled from: Utils.java */
/* loaded from: classes3.dex */
public final class b {
    public static Drawable a(Context context, int i) {
        Drawable drawable;
        if (Build.VERSION.SDK_INT >= 21) {
            drawable = context.getDrawable(i);
        } else {
            drawable = context.getResources().getDrawable(i);
        }
        if (drawable != null) {
            return drawable;
        }
        throw new IllegalArgumentException("maskId is invalid");
    }
}

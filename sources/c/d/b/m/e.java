package c.d.b.m;

import android.content.Context;
import android.os.Build;
import kotlin.text.Regex;

/* compiled from: GlobalUtil.kt */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f3850a = new e();

    private e() {
    }

    public final boolean a() {
        return kotlin.jvm.internal.h.a((Object) "chinaAppStores", (Object) "googlePlay");
    }

    public final boolean a(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        if (Build.VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        String str = Build.DEVICE;
        if (str != null) {
            kotlin.jvm.internal.h.a((Object) str, "Build.DEVICE");
            if (new Regex(".+_cheets|cheets_.+").matches(str)) {
                return true;
            }
        }
        return false;
    }
}

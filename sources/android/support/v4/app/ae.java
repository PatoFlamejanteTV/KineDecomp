package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;

/* compiled from: NavUtils.java */
/* loaded from: classes.dex */
public class ae {

    /* renamed from: a, reason: collision with root package name */
    private static final a f35a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NavUtils.java */
    /* loaded from: classes.dex */
    public interface a {
        String a(Context context, ActivityInfo activityInfo);
    }

    /* compiled from: NavUtils.java */
    /* loaded from: classes.dex */
    static class b implements a {
        b() {
        }

        @Override // android.support.v4.app.ae.a
        public String a(Context context, ActivityInfo activityInfo) {
            String string;
            if (activityInfo.metaData != null && (string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY")) != null) {
                if (string.charAt(0) == '.') {
                    return context.getPackageName() + string;
                }
                return string;
            }
            return null;
        }
    }

    /* compiled from: NavUtils.java */
    /* loaded from: classes.dex */
    static class c extends b {
        c() {
        }

        @Override // android.support.v4.app.ae.b, android.support.v4.app.ae.a
        public String a(Context context, ActivityInfo activityInfo) {
            String a2 = af.a(activityInfo);
            if (a2 == null) {
                return super.a(context, activityInfo);
            }
            return a2;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f35a = new c();
        } else {
            f35a = new b();
        }
    }

    public static Intent a(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String b2 = b(context, componentName);
        if (b2 == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b2);
        return b(context, componentName2) == null ? android.support.v4.a.c.a(componentName2) : new Intent().setComponent(componentName2);
    }

    public static String b(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        return f35a.a(context, context.getPackageManager().getActivityInfo(componentName, 128));
    }
}

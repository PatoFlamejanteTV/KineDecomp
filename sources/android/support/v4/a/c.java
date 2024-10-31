package android.support.v4.a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;

/* compiled from: IntentCompat.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final a f19a;

    /* compiled from: IntentCompat.java */
    /* loaded from: classes.dex */
    interface a {
        Intent a(ComponentName componentName);

        Intent b(ComponentName componentName);
    }

    /* compiled from: IntentCompat.java */
    /* loaded from: classes.dex */
    static class b implements a {
        b() {
        }

        @Override // android.support.v4.a.c.a
        public Intent a(ComponentName componentName) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setComponent(componentName);
            intent.addCategory("android.intent.category.LAUNCHER");
            return intent;
        }

        @Override // android.support.v4.a.c.a
        public Intent b(ComponentName componentName) {
            Intent a2 = a(componentName);
            a2.addFlags(268468224);
            return a2;
        }
    }

    /* compiled from: IntentCompat.java */
    /* renamed from: android.support.v4.a.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0002c extends b {
        C0002c() {
        }

        @Override // android.support.v4.a.c.b, android.support.v4.a.c.a
        public Intent a(ComponentName componentName) {
            return android.support.v4.a.d.a(componentName);
        }

        @Override // android.support.v4.a.c.b, android.support.v4.a.c.a
        public Intent b(ComponentName componentName) {
            return android.support.v4.a.d.b(componentName);
        }
    }

    /* compiled from: IntentCompat.java */
    /* loaded from: classes.dex */
    static class d extends C0002c {
        d() {
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 15) {
            f19a = new d();
        } else if (i >= 11) {
            f19a = new C0002c();
        } else {
            f19a = new b();
        }
    }

    public static Intent a(ComponentName componentName) {
        return f19a.a(componentName);
    }

    public static Intent b(ComponentName componentName) {
        return f19a.b(componentName);
    }
}

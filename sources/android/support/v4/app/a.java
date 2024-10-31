package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.app.b;
import android.view.View;
import java.util.List;
import java.util.Map;

/* compiled from: ActivityCompat.java */
/* loaded from: classes.dex */
public class a extends android.support.v4.a.a {
    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            b.a(activity);
        } else {
            activity.finish();
        }
    }

    public static void a(Activity activity, ay ayVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            b.a(activity, a(ayVar));
        }
    }

    public static void b(Activity activity, ay ayVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            b.b(activity, a(ayVar));
        }
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            b.b(activity);
        }
    }

    public static void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            b.c(activity);
        }
    }

    private static b.a a(ay ayVar) {
        if (ayVar == null) {
            return null;
        }
        return new C0003a(ayVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ActivityCompat.java */
    /* renamed from: android.support.v4.app.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0003a extends b.a {

        /* renamed from: a, reason: collision with root package name */
        private ay f30a;

        public C0003a(ay ayVar) {
            this.f30a = ayVar;
        }

        @Override // android.support.v4.app.b.a
        public void a(List<String> list, List<View> list2, List<View> list3) {
            this.f30a.a(list, list2, list3);
        }

        @Override // android.support.v4.app.b.a
        public void b(List<String> list, List<View> list2, List<View> list3) {
            this.f30a.b(list, list2, list3);
        }

        @Override // android.support.v4.app.b.a
        public void a(List<View> list) {
            this.f30a.a(list);
        }

        @Override // android.support.v4.app.b.a
        public void a(List<String> list, Map<String, View> map) {
            this.f30a.a(list, map);
        }

        @Override // android.support.v4.app.b.a
        public Parcelable a(View view, Matrix matrix, RectF rectF) {
            return this.f30a.a(view, matrix, rectF);
        }

        @Override // android.support.v4.app.b.a
        public View a(Context context, Parcelable parcelable) {
            return this.f30a.a(context, parcelable);
        }
    }
}

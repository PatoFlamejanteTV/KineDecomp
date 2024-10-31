package android.support.v4.g;

import android.content.Context;
import android.support.v4.g.e;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Field;

/* compiled from: LayoutInflaterCompatHC.java */
/* loaded from: classes.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    private static Field f93a;
    private static boolean b;

    /* compiled from: LayoutInflaterCompatHC.java */
    /* loaded from: classes.dex */
    static class a extends e.a implements LayoutInflater.Factory2 {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a(h hVar) {
            super(hVar);
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.f92a.a(view, str, context, attributeSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LayoutInflater layoutInflater, h hVar) {
        a aVar = hVar != null ? new a(hVar) : null;
        layoutInflater.setFactory2(aVar);
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof LayoutInflater.Factory2) {
            a(layoutInflater, (LayoutInflater.Factory2) factory);
        } else {
            a(layoutInflater, aVar);
        }
    }

    static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!b) {
            try {
                f93a = LayoutInflater.class.getDeclaredField("mFactory2");
                f93a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            b = true;
        }
        if (f93a != null) {
            try {
                f93a.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}

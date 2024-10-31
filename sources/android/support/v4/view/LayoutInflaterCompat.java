package android.support.v4.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class LayoutInflaterCompat {

    /* renamed from: a */
    private static Field f1798a;

    /* renamed from: b */
    private static boolean f1799b;

    /* renamed from: c */
    static final LayoutInflaterCompatBaseImpl f1800c;

    /* loaded from: classes.dex */
    public static class Factory2Wrapper implements LayoutInflater.Factory2 {

        /* renamed from: a */
        final LayoutInflaterFactory f1801a;

        Factory2Wrapper(LayoutInflaterFactory layoutInflaterFactory) {
            this.f1801a = layoutInflaterFactory;
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f1801a.onCreateView(null, str, context, attributeSet);
        }

        public String toString() {
            return Factory2Wrapper.class.getName() + "{" + this.f1801a + "}";
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.f1801a.onCreateView(view, str, context, attributeSet);
        }
    }

    /* loaded from: classes.dex */
    static class LayoutInflaterCompatApi21Impl extends LayoutInflaterCompatBaseImpl {
        LayoutInflaterCompatApi21Impl() {
        }

        @Override // android.support.v4.view.LayoutInflaterCompat.LayoutInflaterCompatBaseImpl
        public void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
            layoutInflater.setFactory2(layoutInflaterFactory != null ? new Factory2Wrapper(layoutInflaterFactory) : null);
        }

        @Override // android.support.v4.view.LayoutInflaterCompat.LayoutInflaterCompatBaseImpl
        public void setFactory2(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LayoutInflaterCompatBaseImpl {
        LayoutInflaterCompatBaseImpl() {
        }

        public LayoutInflaterFactory getFactory(LayoutInflater layoutInflater) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof Factory2Wrapper) {
                return ((Factory2Wrapper) factory).f1801a;
            }
            return null;
        }

        public void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
            setFactory2(layoutInflater, layoutInflaterFactory != null ? new Factory2Wrapper(layoutInflaterFactory) : null);
        }

        public void setFactory2(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                LayoutInflaterCompat.a(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                LayoutInflaterCompat.a(layoutInflater, factory2);
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f1800c = new LayoutInflaterCompatApi21Impl();
        } else {
            f1800c = new LayoutInflaterCompatBaseImpl();
        }
    }

    private LayoutInflaterCompat() {
    }

    static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f1799b) {
            try {
                f1798a = LayoutInflater.class.getDeclaredField("mFactory2");
                f1798a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e2);
            }
            f1799b = true;
        }
        Field field = f1798a;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e3) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e3);
            }
        }
    }

    @Deprecated
    public static LayoutInflaterFactory getFactory(LayoutInflater layoutInflater) {
        return f1800c.getFactory(layoutInflater);
    }

    @Deprecated
    public static void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        f1800c.setFactory(layoutInflater, layoutInflaterFactory);
    }

    public static void setFactory2(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        f1800c.setFactory2(layoutInflater, factory2);
    }
}

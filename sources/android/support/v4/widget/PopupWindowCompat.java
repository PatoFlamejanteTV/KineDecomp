package android.support.v4.widget;

import android.os.Build;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class PopupWindowCompat {

    /* renamed from: a */
    static final PopupWindowCompatBaseImpl f2010a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class PopupWindowCompatApi19Impl extends PopupWindowCompatBaseImpl {
        PopupWindowCompatApi19Impl() {
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl
        public void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class PopupWindowCompatApi21Impl extends PopupWindowCompatApi19Impl {

        /* renamed from: e */
        private static Field f2011e;

        static {
            try {
                f2011e = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f2011e.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e2);
            }
        }

        PopupWindowCompatApi21Impl() {
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl
        public boolean getOverlapAnchor(PopupWindow popupWindow) {
            Field field = f2011e;
            if (field == null) {
                return false;
            }
            try {
                return ((Boolean) field.get(popupWindow)).booleanValue();
            } catch (IllegalAccessException e2) {
                Log.i("PopupWindowCompatApi21", "Could not get overlap anchor field in PopupWindow", e2);
                return false;
            }
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl
        public void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
            Field field = f2011e;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e2) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    static class PopupWindowCompatApi23Impl extends PopupWindowCompatApi21Impl {
        PopupWindowCompatApi23Impl() {
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowCompatApi21Impl, android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl
        public boolean getOverlapAnchor(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl
        public int getWindowLayoutType(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowCompatApi21Impl, android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl
        public void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl
        public void setWindowLayoutType(PopupWindow popupWindow, int i) {
            popupWindow.setWindowLayoutType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class PopupWindowCompatBaseImpl {

        /* renamed from: a */
        private static Method f2012a;

        /* renamed from: b */
        private static boolean f2013b;

        /* renamed from: c */
        private static Method f2014c;

        /* renamed from: d */
        private static boolean f2015d;

        PopupWindowCompatBaseImpl() {
        }

        public boolean getOverlapAnchor(PopupWindow popupWindow) {
            return false;
        }

        public int getWindowLayoutType(PopupWindow popupWindow) {
            if (!f2015d) {
                try {
                    f2014c = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);
                    f2014c.setAccessible(true);
                } catch (Exception unused) {
                }
                f2015d = true;
            }
            Method method = f2014c;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(popupWindow, new Object[0])).intValue();
                } catch (Exception unused2) {
                }
            }
            return 0;
        }

        public void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
        }

        public void setWindowLayoutType(PopupWindow popupWindow, int i) {
            if (!f2013b) {
                try {
                    f2012a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                    f2012a.setAccessible(true);
                } catch (Exception unused) {
                }
                f2013b = true;
            }
            Method method = f2012a;
            if (method != null) {
                try {
                    method.invoke(popupWindow, Integer.valueOf(i));
                } catch (Exception unused2) {
                }
            }
        }

        public void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            if ((GravityCompat.getAbsoluteGravity(i3, ViewCompat.getLayoutDirection(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            f2010a = new PopupWindowCompatApi23Impl();
            return;
        }
        if (i >= 21) {
            f2010a = new PopupWindowCompatApi21Impl();
        } else if (i >= 19) {
            f2010a = new PopupWindowCompatApi19Impl();
        } else {
            f2010a = new PopupWindowCompatBaseImpl();
        }
    }

    private PopupWindowCompat() {
    }

    public static boolean getOverlapAnchor(PopupWindow popupWindow) {
        return f2010a.getOverlapAnchor(popupWindow);
    }

    public static int getWindowLayoutType(PopupWindow popupWindow) {
        return f2010a.getWindowLayoutType(popupWindow);
    }

    public static void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
        f2010a.setOverlapAnchor(popupWindow, z);
    }

    public static void setWindowLayoutType(PopupWindow popupWindow, int i) {
        f2010a.setWindowLayoutType(popupWindow, i);
    }

    public static void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f2010a.showAsDropDown(popupWindow, view, i, i2, i3);
    }
}

package com.mixpanel.android.viewcrawler;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: Caller.java */
/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f3081a;
    private final Object[] b;
    private final Class<?> c;
    private final Class<?> d;
    private final Method e;

    public a(Class<?> cls, String str, Object[] objArr, Class<?> cls2) throws NoSuchMethodException {
        this.f3081a = str;
        this.b = objArr;
        this.c = cls2;
        this.e = b(cls);
        if (this.e == null) {
            throw new NoSuchMethodException("Method " + cls.getName() + "." + this.f3081a + " doesn't exit");
        }
        this.d = this.e.getDeclaringClass();
    }

    public String toString() {
        return "[Caller " + this.f3081a + "(" + this.b + ")]";
    }

    public Object[] a() {
        return this.b;
    }

    public Object a(View view) {
        return a(view, this.b);
    }

    public Object a(View view, Object[] objArr) {
        if (this.d.isAssignableFrom(view.getClass())) {
            try {
                return this.e.invoke(view, objArr);
            } catch (IllegalAccessException e) {
                Log.e("MixpanelABTest.Caller", "Method " + this.e.getName() + " appears not to be public", e);
            } catch (IllegalArgumentException e2) {
                Log.e("MixpanelABTest.Caller", "Method " + this.e.getName() + " called with arguments of the wrong type", e2);
            } catch (InvocationTargetException e3) {
                Log.e("MixpanelABTest.Caller", "Method " + this.e.getName() + " threw an exception", e3);
            }
        }
        return null;
    }

    public boolean a(Object[] objArr) {
        Class<?>[] parameterTypes = this.e.getParameterTypes();
        if (objArr.length != parameterTypes.length) {
            return false;
        }
        for (int i = 0; i < objArr.length; i++) {
            Class<?> a2 = a(parameterTypes[i]);
            if (objArr[i] == null) {
                if (a2 == Byte.TYPE || a2 == Short.TYPE || a2 == Integer.TYPE || a2 == Long.TYPE || a2 == Float.TYPE || a2 == Double.TYPE || a2 == Boolean.TYPE || a2 == Character.TYPE) {
                    return false;
                }
            } else if (!a2.isAssignableFrom(a(objArr[i].getClass()))) {
                return false;
            }
        }
        return true;
    }

    private static Class<?> a(Class<?> cls) {
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        if (cls == Character.class) {
            return Character.TYPE;
        }
        return cls;
    }

    private Method b(Class<?> cls) {
        Class[] clsArr = new Class[this.b.length];
        for (int i = 0; i < this.b.length; i++) {
            clsArr[i] = this.b[i].getClass();
        }
        for (Method method : cls.getMethods()) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (name.equals(this.f3081a) && parameterTypes.length == this.b.length && a(this.c).isAssignableFrom(a(method.getReturnType()))) {
                boolean z = true;
                for (int i2 = 0; i2 < parameterTypes.length && z; i2++) {
                    z = a(parameterTypes[i2]).isAssignableFrom(a((Class<?>) clsArr[i2]));
                }
                if (z) {
                    return method;
                }
            }
        }
        return null;
    }
}

package defpackage;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public /* synthetic */ class a {
    public static /* synthetic */ void a(Throwable th, Object obj) {
        try {
            if (obj instanceof AutoCloseable) {
                ((AutoCloseable) obj).close();
                return;
            }
            try {
                obj.getClass().getMethod("close", new Class[0]).invoke(obj, new Object[0]);
            } catch (ExceptionInInitializerError e2) {
                e = e2;
                throw new AssertionError("Fail to call close() on " + obj.getClass(), e);
            } catch (IllegalAccessException e3) {
                e = e3;
                throw new AssertionError("Fail to call close() on " + obj.getClass(), e);
            } catch (IllegalArgumentException e4) {
                e = e4;
                throw new AssertionError("Fail to call close() on " + obj.getClass(), e);
            } catch (NoSuchMethodException e5) {
                e = e5;
                throw new AssertionError(obj.getClass() + " does not have a close() method.", e);
            } catch (SecurityException e6) {
                e = e6;
                throw new AssertionError(obj.getClass() + " does not have a close() method.", e);
            } catch (InvocationTargetException e7) {
                throw e7.getCause();
            }
        } finally {
        }
    }
}

package org.apache.commons.cli;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/* compiled from: TypeHandler.java */
/* loaded from: classes3.dex */
public class g {
    public static Object a(String str, Object obj) throws ParseException {
        return a(str, (Class) obj);
    }

    public static Date b(String str) throws ParseException {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static File c(String str) throws ParseException {
        return new File(str);
    }

    public static File[] d(String str) throws ParseException {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static Number e(String str) throws ParseException {
        try {
            if (str.indexOf(46) != -1) {
                return Double.valueOf(str);
            }
            return Long.valueOf(str);
        } catch (NumberFormatException e2) {
            throw new ParseException(e2.getMessage());
        }
    }

    public static Object f(String str) throws ParseException {
        try {
            try {
                return Class.forName(str).newInstance();
            } catch (Exception e2) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(e2.getClass().getName());
                stringBuffer.append("; Unable to create an instance of: ");
                stringBuffer.append(str);
                throw new ParseException(stringBuffer.toString());
            }
        } catch (ClassNotFoundException unused) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Unable to find the class: ");
            stringBuffer2.append(str);
            throw new ParseException(stringBuffer2.toString());
        }
    }

    public static URL g(String str) throws ParseException {
        try {
            return new URL(str);
        } catch (MalformedURLException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unable to parse the URL: ");
            stringBuffer.append(str);
            throw new ParseException(stringBuffer.toString());
        }
    }

    public static Object a(String str, Class cls) throws ParseException {
        if (f.f29292a == cls) {
            return str;
        }
        if (f.f29293b == cls) {
            return f(str);
        }
        if (f.f29294c == cls) {
            return e(str);
        }
        if (f.f29295d != cls) {
            if (f.f29296e == cls) {
                return a(str);
            }
            if (f.f29298g == cls) {
                return c(str);
            }
            if (f.f29297f == cls) {
                return c(str);
            }
            if (f.f29299h != cls) {
                if (f.i == cls) {
                    return g(str);
                }
                return null;
            }
            d(str);
            throw null;
        }
        b(str);
        throw null;
    }

    public static Class a(String str) throws ParseException {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unable to find the class: ");
            stringBuffer.append(str);
            throw new ParseException(stringBuffer.toString());
        }
    }
}

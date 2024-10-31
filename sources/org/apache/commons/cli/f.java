package org.apache.commons.cli;

/* compiled from: PatternOptionBuilder.java */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a */
    public static final Class f29292a;

    /* renamed from: b */
    public static final Class f29293b;

    /* renamed from: c */
    public static final Class f29294c;

    /* renamed from: d */
    public static final Class f29295d;

    /* renamed from: e */
    public static final Class f29296e;

    /* renamed from: f */
    public static final Class f29297f;

    /* renamed from: g */
    public static final Class f29298g;

    /* renamed from: h */
    public static final Class f29299h;
    public static final Class i;
    static /* synthetic */ Class j;
    static /* synthetic */ Class k;
    static /* synthetic */ Class l;
    static /* synthetic */ Class m;
    static /* synthetic */ Class n;
    static /* synthetic */ Class o;
    static /* synthetic */ Class p;
    static /* synthetic */ Class q;
    static /* synthetic */ Class r;

    static {
        Class cls = j;
        if (cls == null) {
            cls = a("java.lang.String");
            j = cls;
        }
        f29292a = cls;
        Class cls2 = k;
        if (cls2 == null) {
            cls2 = a("java.lang.Object");
            k = cls2;
        }
        f29293b = cls2;
        Class cls3 = l;
        if (cls3 == null) {
            cls3 = a("java.lang.Number");
            l = cls3;
        }
        f29294c = cls3;
        Class cls4 = m;
        if (cls4 == null) {
            cls4 = a("java.util.Date");
            m = cls4;
        }
        f29295d = cls4;
        Class cls5 = n;
        if (cls5 == null) {
            cls5 = a("java.lang.Class");
            n = cls5;
        }
        f29296e = cls5;
        Class cls6 = o;
        if (cls6 == null) {
            cls6 = a("java.io.FileInputStream");
            o = cls6;
        }
        f29297f = cls6;
        Class cls7 = p;
        if (cls7 == null) {
            cls7 = a("java.io.File");
            p = cls7;
        }
        f29298g = cls7;
        Class cls8 = q;
        if (cls8 == null) {
            cls8 = a("[Ljava.io.File;");
            q = cls8;
        }
        f29299h = cls8;
        Class cls9 = r;
        if (cls9 == null) {
            cls9 = a("java.net.URL");
            r = cls9;
        }
        i = cls9;
    }

    static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }
}

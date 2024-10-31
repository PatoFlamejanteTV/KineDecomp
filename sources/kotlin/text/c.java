package kotlin.text;

import java.nio.charset.Charset;

/* compiled from: Charsets.kt */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a */
    public static final Charset f28548a;

    /* renamed from: b */
    public static final Charset f28549b;

    /* renamed from: c */
    public static final Charset f28550c;

    /* renamed from: d */
    public static final Charset f28551d;

    /* renamed from: e */
    public static final Charset f28552e;

    /* renamed from: f */
    public static final Charset f28553f;

    /* renamed from: g */
    public static final c f28554g = new c();

    static {
        Charset forName = Charset.forName("UTF-8");
        kotlin.jvm.internal.h.a((Object) forName, "Charset.forName(\"UTF-8\")");
        f28548a = forName;
        Charset forName2 = Charset.forName("UTF-16");
        kotlin.jvm.internal.h.a((Object) forName2, "Charset.forName(\"UTF-16\")");
        f28549b = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        kotlin.jvm.internal.h.a((Object) forName3, "Charset.forName(\"UTF-16BE\")");
        f28550c = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        kotlin.jvm.internal.h.a((Object) forName4, "Charset.forName(\"UTF-16LE\")");
        f28551d = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        kotlin.jvm.internal.h.a((Object) forName5, "Charset.forName(\"US-ASCII\")");
        f28552e = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        kotlin.jvm.internal.h.a((Object) forName6, "Charset.forName(\"ISO-8859-1\")");
        f28553f = forName6;
    }

    private c() {
    }
}

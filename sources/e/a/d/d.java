package e.a.d;

import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

/* compiled from: Measure.java */
@Immutable
/* loaded from: classes3.dex */
public abstract class d {

    /* compiled from: Measure.java */
    @Immutable
    /* loaded from: classes3.dex */
    public static abstract class a extends d {
        public a() {
            super();
        }

        public static a a(String str, String str2, String str3) {
            Preconditions.a(e.a.c.b.a(str) && str.length() <= 255, "Name should be a ASCII string with a length no greater than 255 characters.");
            return new e.a.d.a(str, str2, str3);
        }

        public abstract String a();

        public abstract String b();

        public abstract String c();
    }

    /* compiled from: Measure.java */
    @Immutable
    /* loaded from: classes3.dex */
    public static abstract class b extends d {
        public b() {
            super();
        }

        public static b a(String str, String str2, String str3) {
            Preconditions.a(e.a.c.b.a(str) && str.length() <= 255, "Name should be a ASCII string with a length no greater than 255 characters.");
            return new e.a.d.b(str, str2, str3);
        }

        public abstract String a();

        public abstract String b();

        public abstract String c();
    }

    /* synthetic */ d(c cVar) {
        this();
    }

    private d() {
    }
}

package e.a.e;

import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

/* compiled from: TagValue.java */
@Immutable
/* loaded from: classes3.dex */
public abstract class i {
    public static i a(String str) {
        Preconditions.a(b(str));
        return new b(str);
    }

    private static boolean b(String str) {
        return str.length() <= 255 && e.a.c.b.a(str);
    }

    public abstract String a();
}

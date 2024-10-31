package e.a.e;

import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

/* compiled from: TagKey.java */
@Immutable
/* loaded from: classes3.dex */
public abstract class h {
    public static h a(String str) {
        Preconditions.a(b(str));
        return new a(str);
    }

    private static boolean b(String str) {
        return !str.isEmpty() && str.length() <= 255 && e.a.c.b.a(str);
    }

    public abstract String a();
}

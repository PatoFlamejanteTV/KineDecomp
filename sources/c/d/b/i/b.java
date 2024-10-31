package c.d.b.i;

import c.d.b.i.a.c;
import c.d.b.i.a.d;
import c.d.b.i.a.e;
import java.util.Arrays;
import java.util.List;

/* compiled from: TemplateManager.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    private static final a[] f3816a = {c.d.b.i.a.b.c(), c.c(), d.c(), e.c()};

    public static a a(String str) {
        for (a aVar : f3816a) {
            if (aVar.getId().equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public static List<a> a() {
        return Arrays.asList(f3816a);
    }
}

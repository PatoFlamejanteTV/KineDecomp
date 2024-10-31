package g.a.c;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.h;
import kotlin.reflect.c;

/* compiled from: KClassExt.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a */
    private static final Map<c<?>, String> f26775a = new ConcurrentHashMap();

    public static final String a(c<?> cVar) {
        h.b(cVar, "$this$getFullName");
        String str = f26775a.get(cVar);
        return str != null ? str : b(cVar);
    }

    private static final String b(c<?> cVar) {
        String name = kotlin.jvm.a.a(cVar).getName();
        Map<c<?>, String> map = f26775a;
        h.a((Object) name, "name");
        map.put(cVar, name);
        return name;
    }
}

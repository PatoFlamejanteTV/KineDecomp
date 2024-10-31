package android.arch.lifecycle;

import java.util.HashMap;
import java.util.Iterator;

/* compiled from: ViewModelStore.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a */
    private final HashMap<String, p> f57a = new HashMap<>();

    public final void a(String str, p pVar) {
        p pVar2 = this.f57a.get(str);
        if (pVar2 != null) {
            pVar2.a();
        }
        this.f57a.put(str, pVar);
    }

    public final p a(String str) {
        return this.f57a.get(str);
    }

    public final void a() {
        Iterator<p> it = this.f57a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f57a.clear();
    }
}

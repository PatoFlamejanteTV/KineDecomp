package android.support.constraint.solver.widgets;

import java.util.HashSet;
import java.util.Iterator;

/* compiled from: ResolutionNode.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a */
    HashSet<p> f288a = new HashSet<>(2);

    /* renamed from: b */
    int f289b = 0;

    public void a(p pVar) {
        this.f288a.add(pVar);
    }

    public void b() {
        this.f289b = 0;
        Iterator<p> it = this.f288a.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public boolean c() {
        return this.f289b == 1;
    }

    public void d() {
        this.f289b = 0;
        this.f288a.clear();
    }

    public void e() {
    }

    public void a() {
        this.f289b = 1;
        Iterator<p> it = this.f288a.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }
}

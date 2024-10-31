package c.d.b.d.b.b.a.d;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.Effect;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: KXNTransitionItem.java */
/* loaded from: classes.dex */
public class f extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d {

    /* renamed from: g */
    com.nexstreaming.kinemaster.integration.kmxml.adapter.items.d f3748g;

    public f(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
        this.f3760d.put("iid", c.d.b.d.e.a.a(this.f3748g.c()));
        this.f3760d.put("duration", c.d.b.d.e.a.a(this.f3748g.a()));
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        ArrayList<Effect.a> d2 = this.f3748g.d();
        if (d2 == null || d2.size() <= 0) {
            return;
        }
        Iterator<Effect.a> it = d2.iterator();
        while (it.hasNext()) {
            Effect.a next = it.next();
            new c.d.b.d.d.b.a(this.f3759c, "param", "name", next.f20551a, next.f20552b);
        }
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "transition";
    }

    public void a(Object obj) {
        this.f3748g = (com.nexstreaming.kinemaster.integration.kmxml.adapter.items.d) obj;
    }
}

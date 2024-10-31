package c.d.b.d.b.b.a.a;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.Effect;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: KXNProjectFilter.java */
/* loaded from: classes.dex */
public class d extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d {

    /* renamed from: g */
    com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.c f3732g;

    public d(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
        com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.c cVar = this.f3732g;
        if (cVar != null) {
            this.f3760d.put("width", cVar.a());
        }
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        ArrayList<Effect.a> b2;
        com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.c cVar = this.f3732g;
        if (cVar == null || (b2 = cVar.b()) == null || b2.size() <= 0) {
            return;
        }
        Iterator<Effect.a> it = b2.iterator();
        while (it.hasNext()) {
            Effect.a next = it.next();
            this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "param", "name", next.f20551a, String.valueOf(next.f20552b)));
        }
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "project-filter";
    }

    public void a(Object obj) {
        this.f3732g = (com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.c) obj;
    }
}

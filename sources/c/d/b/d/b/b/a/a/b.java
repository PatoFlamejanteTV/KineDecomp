package c.d.b.d.b.b.a.a;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.Effect;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: KXNFilterEffect.java */
/* loaded from: classes.dex */
public class b extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d {

    /* renamed from: g */
    private com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.c f3730g;

    public b(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
        this.f3760d.put("iid", c.d.b.d.e.a.a(this.f3730g.a()));
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        ArrayList<Effect.a> b2 = this.f3730g.b();
        if (b2 == null || b2.size() <= 0) {
            return;
        }
        Iterator<Effect.a> it = b2.iterator();
        while (it.hasNext()) {
            Effect.a next = it.next();
            this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "param", "name", next.f20551a, next.f20552b));
        }
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "filter";
    }

    public void a(Object obj) {
        this.f3730g = (com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.c) obj;
    }
}

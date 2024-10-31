package c.d.b.d.b.b.a.b;

import org.xmlpull.v1.XmlSerializer;

/* compiled from: KXNTextLayer.java */
/* loaded from: classes.dex */
public class c extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d {

    /* renamed from: g, reason: collision with root package name */
    com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.e f3737g;

    public c(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
        this.f3760d.put("start", c.d.b.d.e.a.a(this.f3737g.k()));
        this.f3760d.put("end", c.d.b.d.e.a.a(this.f3737g.e()));
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        new c.d.b.d.d.b.a(this.f3759c, "string", "name", "content", this.f3737g.m());
        d dVar = new d(this.f3759c);
        dVar.a(this.f3737g.n());
        this.f3762f.add(dVar);
        new c.d.b.d.b.b.c.a(this.f3759c, this.f3762f, this.f3737g.b()).a();
        new c.d.b.d.d.b.a(this.f3759c, "blend", "alpha", String.valueOf(this.f3737g.c()), null);
        c.d.b.d.b.b.a.b.a.a aVar = new c.d.b.d.b.b.a.b.a.a(this.f3759c);
        aVar.a(this.f3737g.h());
        this.f3762f.add(aVar);
        if (this.f3737g.l()) {
            c.d.b.d.b.b.a.a.c cVar = new c.d.b.d.b.b.a.a.c(this.f3759c);
            cVar.a(this.f3737g.f());
            this.f3762f.add(cVar);
        }
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "textlayer";
    }

    public void a(Object obj) {
        this.f3737g = (com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.e) obj;
    }
}

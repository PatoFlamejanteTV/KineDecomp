package c.d.b.d.b.b.a.d;

import org.xmlpull.v1.XmlSerializer;

/* compiled from: KXNSolidItem.java */
/* loaded from: classes.dex */
public class e extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d {

    /* renamed from: g, reason: collision with root package name */
    com.nexstreaming.kinemaster.integration.kmxml.adapter.items.c f3747g;

    public e(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
        this.f3760d.put("color", this.f3747g.f());
        this.f3760d.put("duration", c.d.b.d.e.a.a(this.f3747g.a()));
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        if (this.f3747g.c() != null) {
            c.d.b.d.b.b.a.c.a aVar = new c.d.b.d.b.b.a.c.a(this.f3759c);
            aVar.a(this.f3747g.c());
            this.f3762f.add(aVar);
        }
        if (this.f3747g.e() != null) {
            c.d.b.d.b.b.a.c.c cVar = new c.d.b.d.b.b.a.c.c(this.f3759c);
            cVar.a(this.f3747g.e());
            this.f3762f.add(cVar);
        }
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "solid";
    }

    public void a(Object obj) {
        this.f3747g = (com.nexstreaming.kinemaster.integration.kmxml.adapter.items.c) obj;
    }
}

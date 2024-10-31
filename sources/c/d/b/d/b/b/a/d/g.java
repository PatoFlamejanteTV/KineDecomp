package c.d.b.d.b.b.a.d;

import org.xmlpull.v1.XmlSerializer;

/* compiled from: KXNVideoItem.java */
/* loaded from: classes.dex */
public class g extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d {

    /* renamed from: g, reason: collision with root package name */
    private com.nexstreaming.kinemaster.integration.kmxml.adapter.items.e f3749g;

    public g(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
        this.f3760d.put("src", this.f3749g.f().a());
        this.f3760d.put("duration", c.d.b.d.e.a.a(this.f3749g.a()));
        this.f3760d.put("offset", c.d.b.d.e.a.a(this.f3749g.g()));
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        new c.d.b.d.b.b.c.a(this.f3759c, this.f3762f, this.f3749g.b()).a();
        if (this.f3749g.d() != null) {
            c.d.b.d.b.b.a.c.b bVar = new c.d.b.d.b.b.a.c.b(this.f3759c);
            bVar.a(this.f3749g.d());
            this.f3762f.add(bVar);
        }
        if (this.f3749g.c() != null) {
            c.d.b.d.b.b.a.c.a aVar = new c.d.b.d.b.b.a.c.a(this.f3759c);
            aVar.a(this.f3749g.c());
            this.f3762f.add(aVar);
        }
        if (this.f3749g.e() != null) {
            c.d.b.d.b.b.a.c.c cVar = new c.d.b.d.b.b.a.c.c(this.f3759c);
            cVar.a(this.f3749g.e());
            this.f3762f.add(cVar);
        }
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "video";
    }

    public void a(Object obj) {
        this.f3749g = (com.nexstreaming.kinemaster.integration.kmxml.adapter.items.e) obj;
    }
}

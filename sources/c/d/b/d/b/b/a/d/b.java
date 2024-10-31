package c.d.b.d.b.b.a.d;

import com.facebook.share.internal.MessengerShareContentUtility;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: KXNImageItem.java */
/* loaded from: classes.dex */
public class b extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d {

    /* renamed from: g, reason: collision with root package name */
    com.nexstreaming.kinemaster.integration.kmxml.adapter.items.b f3744g;

    public b(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
        this.f3760d.put("src", this.f3744g.f().a());
        this.f3760d.put("duration", c.d.b.d.e.a.a(this.f3744g.a()));
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        if (this.f3744g.d() != null) {
            c.d.b.d.b.b.a.c.b bVar = new c.d.b.d.b.b.a.c.b(this.f3759c);
            bVar.a(this.f3744g.d());
            this.f3762f.add(bVar);
        }
        if (this.f3744g.c() != null) {
            c.d.b.d.b.b.a.c.a aVar = new c.d.b.d.b.b.a.c.a(this.f3759c);
            aVar.a(this.f3744g.c());
            this.f3762f.add(aVar);
        }
        if (this.f3744g.e() != null) {
            c.d.b.d.b.b.a.c.c cVar = new c.d.b.d.b.b.a.c.c(this.f3759c);
            cVar.a(this.f3744g.e());
            this.f3762f.add(cVar);
        }
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return MessengerShareContentUtility.MEDIA_IMAGE;
    }

    public void a(Object obj) {
        this.f3744g = (com.nexstreaming.kinemaster.integration.kmxml.adapter.items.b) obj;
    }
}

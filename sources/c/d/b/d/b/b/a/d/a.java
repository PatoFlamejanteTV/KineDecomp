package c.d.b.d.b.b.a.d;

import org.xmlpull.v1.XmlSerializer;

/* compiled from: KXNAudioItem.java */
/* loaded from: classes.dex */
public class a extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d {

    /* renamed from: g, reason: collision with root package name */
    com.nexstreaming.kinemaster.integration.kmxml.adapter.items.a f3743g;

    public a(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
        this.f3760d.put("src", String.valueOf(this.f3743g.d().a()));
        this.f3760d.put("start", c.d.b.d.e.a.a(this.f3743g.f()));
        this.f3760d.put("end", c.d.b.d.e.a.a(this.f3743g.c()));
        this.f3760d.put("offset", c.d.b.d.e.a.a(this.f3743g.e()));
        this.f3760d.put("duration", c.d.b.d.e.a.a(this.f3743g.a()));
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        new c.d.b.d.b.b.c.a(this.f3759c, this.f3762f, this.f3743g.b()).a();
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "audio";
    }

    public void a(Object obj) {
        this.f3743g = (com.nexstreaming.kinemaster.integration.kmxml.adapter.items.a) obj;
    }
}

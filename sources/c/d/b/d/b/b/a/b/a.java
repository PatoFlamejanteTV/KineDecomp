package c.d.b.d.b.b.a.b;

import org.xmlpull.v1.XmlSerializer;

/* compiled from: KXNImageLayer.java */
/* loaded from: classes.dex */
public class a extends b implements c.d.b.d.d.b.d {

    /* renamed from: h, reason: collision with root package name */
    private com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.b f3734h;

    public a(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.b.b.a.b.b, c.d.b.d.d.b.b
    public void a() {
        this.f3760d.put("src", this.f3734h.i().a());
        super.a();
    }

    @Override // c.d.b.d.b.b.a.b.b, c.d.b.d.d.b.b
    public void b() {
        super.b();
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "imagelayer";
    }

    @Override // c.d.b.d.b.b.a.b.b
    public void a(Object obj) {
        this.f3734h = (com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.b) obj;
        super.a(this.f3734h);
    }
}

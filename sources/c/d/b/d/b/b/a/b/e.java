package c.d.b.d.b.b.a.b;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.f;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: KXNVideoLayer.java */
/* loaded from: classes.dex */
public class e extends b implements c.d.b.d.d.b.d {

    /* renamed from: h, reason: collision with root package name */
    private f f3739h;

    public e(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.b.b.a.b.b, c.d.b.d.d.b.b
    public void a() {
        this.f3760d.put("src", this.f3739h.i().a());
        this.f3760d.put("duration", c.d.b.d.e.a.a(this.f3739h.a()));
        this.f3760d.put("offset", c.d.b.d.e.a.a(this.f3739h.j()));
    }

    @Override // c.d.b.d.b.b.a.b.b, c.d.b.d.d.b.b
    public void b() {
        super.b();
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "videolayer";
    }

    @Override // c.d.b.d.b.b.a.b.b
    public void a(Object obj) {
        this.f3739h = (f) obj;
        super.a(this.f3739h);
    }
}

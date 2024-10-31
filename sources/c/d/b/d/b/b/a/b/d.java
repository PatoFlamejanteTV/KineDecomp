package c.d.b.d.b.b.a.b;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.e;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: KXNTextStyle.java */
/* loaded from: classes.dex */
public class d extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d {

    /* renamed from: g */
    e.a f3738g;

    public d(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
        this.f3760d.put("font", this.f3738g.f20602a);
        this.f3760d.put("color", this.f3738g.f20603b);
        this.f3760d.put("size", String.valueOf(this.f3738g.f20604c));
        this.f3760d.put("background", this.f3738g.f20605d.getName());
        this.f3760d.put("background-color", this.f3738g.f20606e);
        this.f3760d.put("shadow", this.f3738g.f20608g ? "on" : "off");
        this.f3760d.put("shadow-color", this.f3738g.f20607f);
        this.f3760d.put("glow", this.f3738g.i ? "on" : "off");
        this.f3760d.put("glow-color", this.f3738g.f20609h);
        this.f3760d.put("outline", this.f3738g.k ? "on" : "off");
        this.f3760d.put("outline-color", this.f3738g.j);
        this.f3760d.put("align", this.f3738g.l.getName());
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "textstyle";
    }

    public void a(Object obj) {
        this.f3738g = (e.a) obj;
    }
}

package c.d.b.d.b.b.a.c;

import c.d.b.d.d.b.d;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: KXLColorAdjustment.java */
/* loaded from: classes.dex */
public class b extends c.d.b.d.d.b.b implements d {

    /* renamed from: g */
    c.d.b.d.b.a.c.a f3741g;

    public b(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
        this.f3760d.put("brightness", String.valueOf(this.f3741g.f3723a));
        this.f3760d.put("contrast", String.valueOf(this.f3741g.f3724b));
        this.f3760d.put("saturation", String.valueOf(this.f3741g.f3725c));
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "coloradj";
    }

    public void a(Object obj) {
        this.f3741g = (c.d.b.d.b.a.c.a) obj;
    }
}

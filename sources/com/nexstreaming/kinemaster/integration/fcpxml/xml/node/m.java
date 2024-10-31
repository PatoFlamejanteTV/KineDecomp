package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import java.util.Locale;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNLink.java */
/* loaded from: classes.dex */
class m extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g */
    c.d.b.d.a.a.e.a f20523g;

    public m(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        this.f20523g = (c.d.b.d.a.a.e.a) obj;
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "linkclipref", String.format(Locale.US, "clipitem-%d", Integer.valueOf(this.f20523g.f3688a))));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "mediatype", this.f20523g.f3692e.getMediaType()));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "trackindex", this.f20523g.f3690c));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "clipindex", this.f20523g.f3689b));
        int i = this.f20523g.f3691d;
        if (i != -1) {
            this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "groupindex", i));
        }
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "link";
    }
}

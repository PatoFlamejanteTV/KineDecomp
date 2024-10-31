package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import c.d.b.d.a.a.b.a;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNGroup.java */
/* loaded from: classes.dex */
class j extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g */
    a.C0014a f20518g;

    public j(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        this.f20518g = (a.C0014a) obj;
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "index", this.f20518g.f3657a));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "numchannels", this.f20518g.f3659c));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "downmix", this.f20518g.f3660d));
        c cVar = new c(this.f3759c);
        cVar.a(Long.valueOf(this.f20518g.f3658b));
        this.f3762f.add(cVar);
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "group";
    }
}

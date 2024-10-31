package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNTimeCode.java */
/* loaded from: classes.dex */
class x extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d {

    /* renamed from: g */
    private c.d.b.d.a.a.d.a f20538g;

    public x(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        this.f20538g = (c.d.b.d.a.a.d.a) obj;
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        s sVar = new s(this.f3759c);
        sVar.a(this.f20538g.f3676a);
        this.f3762f.add(sVar);
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "string", this.f20538g.f3677b));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "frame", this.f20538g.f3678c));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "displayformat", this.f20538g.f3679d));
        this.f3762f.add(new t(this.f3759c));
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "timecode";
    }
}

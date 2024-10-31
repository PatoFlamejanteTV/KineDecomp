package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import c.d.b.d.a.a.d.a;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNRate.java */
/* loaded from: classes.dex */
class s extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d {

    /* renamed from: g */
    private a.C0015a f20532g;

    public s(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        this.f20532g = (a.C0015a) obj;
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "timebase", this.f20532g.f3681a));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "ntsc", this.f20532g.f3682b));
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "rate";
    }
}

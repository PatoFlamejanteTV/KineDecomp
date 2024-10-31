package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNLoggingInfo.java */
/* loaded from: classes.dex */
class n extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {
    public n(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "description", ""));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "scene", ""));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "shottake", ""));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "lognote", ""));
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "logginginfo";
    }
}

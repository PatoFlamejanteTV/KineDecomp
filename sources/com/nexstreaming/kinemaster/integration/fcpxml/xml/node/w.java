package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNSourceTrack.java */
/* loaded from: classes.dex */
class w extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g */
    com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a f20536g;

    /* renamed from: h */
    OperationMode f20537h;

    public w(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        this.f20536g = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) obj;
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "mediatype", this.f20536g.u.getMediaType()));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "trackindex", (this.f20536g.j - this.f20536g.v.get(0).f3690c) + 1));
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "sourcetrack";
    }

    public void a(OperationMode operationMode) {
        this.f20537h = operationMode;
    }
}

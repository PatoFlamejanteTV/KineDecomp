package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNAudioChannel.java */
/* renamed from: com.nexstreaming.kinemaster.integration.fcpxml.xml.node.b */
/* loaded from: classes.dex */
class C1782b extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g */
    com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a f20504g;

    public C1782b(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        this.f20504g = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) obj;
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "sourcechannel", 1L));
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "audiochannel";
    }
}

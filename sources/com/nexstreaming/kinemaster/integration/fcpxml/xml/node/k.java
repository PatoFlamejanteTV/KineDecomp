package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNKeyFrame.java */
/* loaded from: classes.dex */
class k extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g */
    OperationMode f20519g;

    /* renamed from: h */
    c.C0103c f20520h;

    public k(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        this.f20520h = (c.C0103c) obj;
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "when", this.f20520h.f20468a));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "value", this.f20520h.f20469b));
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "keyframe";
    }

    public void a(OperationMode operationMode) {
        this.f20519g = operationMode;
    }
}

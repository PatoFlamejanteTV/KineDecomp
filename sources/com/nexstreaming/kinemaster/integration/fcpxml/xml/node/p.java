package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import c.d.b.d.a.a.b.a;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNOutputs.java */
/* loaded from: classes.dex */
class p extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g */
    OperationMode f20526g;

    /* renamed from: h */
    c.d.b.d.a.a.c.a f20527h;

    public p(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        this.f20527h = (c.d.b.d.a.a.c.a) obj;
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        for (a.C0014a c0014a : this.f20527h.a().f3648d) {
            j jVar = new j(this.f3759c);
            jVar.a(c0014a);
            this.f3762f.add(jVar);
        }
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "outputs";
    }

    public void a(OperationMode operationMode) {
        this.f20526g = operationMode;
    }
}

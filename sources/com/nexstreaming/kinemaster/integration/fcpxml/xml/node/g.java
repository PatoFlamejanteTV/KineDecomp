package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.Effect;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNFilter.java */
/* loaded from: classes.dex */
class g extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g */
    OperationMode f20512g;

    /* renamed from: h */
    Effect f20513h;

    public g(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        this.f20513h = (Effect) obj;
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        e eVar = new e(this.f3759c);
        eVar.a(this.f20513h);
        eVar.a(this.f20512g);
        this.f3762f.add(eVar);
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "filter";
    }

    public void a(OperationMode operationMode) {
        this.f20512g = operationMode;
    }
}

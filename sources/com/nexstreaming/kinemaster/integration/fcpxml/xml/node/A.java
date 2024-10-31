package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import c.d.b.d.a.a.d.a;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNTransitionItem.java */
/* loaded from: classes.dex */
class A extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g, reason: collision with root package name */
    com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.d f20499g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        this.f20499g = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.d) obj;
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "start", this.f20499g.f20476c));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "end", this.f20499g.f20477d));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "alignment", this.f20499g.t.getAlignment()));
        s sVar = new s(this.f3759c);
        com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.d dVar = this.f20499g;
        sVar.a(new a.C0015a(dVar.r, dVar.s));
        this.f3762f.add(sVar);
        e eVar = new e(this.f3759c);
        eVar.a(this.f20499g.u);
        this.f3762f.add(eVar);
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "transitionitem";
    }
}

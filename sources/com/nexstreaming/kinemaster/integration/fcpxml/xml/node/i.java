package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import java.util.Locale;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNGeneratorItem.java */
/* loaded from: classes.dex */
class i extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g, reason: collision with root package name */
    OperationMode f20516g;

    /* renamed from: h, reason: collision with root package name */
    com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.c f20517h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
        this.f3760d.put("id", String.format(Locale.US, "clipitem-%d", Integer.valueOf(this.f20517h.s)));
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "enabled", true));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "duration", this.f20517h.f20475b));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "start", this.f20517h.f20476c));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "end", this.f20517h.f20477d));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "in", this.f20517h.f20478e));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "out", this.f20517h.f20479f));
        e eVar = new e(this.f3759c);
        eVar.a(this.f20517h.x.get(0));
        eVar.a(this.f20516g);
        this.f3762f.add(eVar);
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "generatoritem";
    }

    public void a(Object obj) {
        this.f20517h = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.c) obj;
    }

    public void a(OperationMode operationMode) {
        this.f20516g = operationMode;
    }
}

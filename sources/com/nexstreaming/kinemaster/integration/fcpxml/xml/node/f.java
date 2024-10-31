package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import c.d.b.d.a.a.d.a;
import java.io.File;
import java.util.Locale;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNFile.java */
/* loaded from: classes.dex */
class f extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g, reason: collision with root package name */
    OperationMode f20510g;

    /* renamed from: h, reason: collision with root package name */
    com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a f20511h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
        this.f3760d.put("id", String.format(Locale.US, "file-%d", Integer.valueOf(this.f20511h.r)));
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b bVar = this.f20511h.q;
        if (bVar.C) {
            return;
        }
        bVar.C = true;
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "name", bVar.t));
        c.d.b.d.e.a.a(new File(bVar.s));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "pathurl", bVar.t));
        a.b bVar2 = new a.b();
        bVar2.a(new a.C0015a(bVar.z, bVar.B));
        bVar2.c("00:00:00:00");
        bVar2.a(0L);
        bVar2.a(bVar.A.name());
        bVar2.b("");
        c.d.b.d.a.a.d.a a2 = bVar2.a();
        s sVar = new s(this.f3759c);
        sVar.a(a2.f3676a);
        this.f3762f.add(sVar);
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "duration", this.f20511h.f20475b));
        x xVar = new x(this.f3759c);
        xVar.a(a2);
        this.f3762f.add(xVar);
        o oVar = new o(this.f3759c);
        oVar.a(OperationMode.FILE);
        oVar.a(this.f20511h);
        this.f3762f.add(oVar);
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "file";
    }

    public void a(Object obj) {
        this.f20511h = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) obj;
    }

    public void a(OperationMode operationMode) {
        this.f20510g = operationMode;
    }
}

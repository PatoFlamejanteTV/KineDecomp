package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import c.d.b.d.a.a.d.a;
import com.nexstreaming.kinemaster.integration.fcpxml.xml.tagname.TempName$LabelName;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNSequence.java */
/* loaded from: classes.dex */
public class v extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g, reason: collision with root package name */
    c.d.b.d.a.a.c.a f20535g;

    public v(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
        this.f3760d.put("id", "sequence-1");
    }

    public void a(OperationMode operationMode) {
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "uuid", c.d.b.d.e.a.a()));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "duration", this.f20535g.d()));
        a.b bVar = new a.b();
        bVar.a(new a.C0015a(this.f20535g.g().b(), this.f20535g.g().e()));
        bVar.c("00:00:00:00");
        bVar.a(0L);
        bVar.a("NDF");
        bVar.b("");
        c.d.b.d.a.a.d.a a2 = bVar.a();
        s sVar = new s(this.f3759c);
        sVar.a(a2.f3676a);
        this.f3762f.add(sVar);
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "name", this.f20535g.e()));
        o oVar = new o(this.f3759c);
        oVar.a(this.f20535g);
        this.f3762f.add(oVar);
        x xVar = new x(this.f3759c);
        xVar.a(a2);
        this.f3762f.add(xVar);
        l lVar = new l(this.f3759c);
        lVar.a(TempName$LabelName.spring.getName());
        this.f3762f.add(lVar);
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "sequence";
    }

    public void a(Object obj) {
        this.f20535g = (c.d.b.d.a.a.c.a) obj;
    }
}

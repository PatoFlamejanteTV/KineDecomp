package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNFormat.java */
/* loaded from: classes.dex */
class h extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g, reason: collision with root package name */
    OperationMode f20514g;

    /* renamed from: h, reason: collision with root package name */
    c.d.b.d.a.a.c.a f20515h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        this.f20515h = (c.d.b.d.a.a.c.a) obj;
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        u uVar = new u(this.f3759c);
        uVar.a(this.f20514g);
        uVar.a(this.f20515h);
        this.f3762f.add(uVar);
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "format";
    }

    @Override // c.d.b.d.d.b.b
    public void d() throws IOException {
        super.d();
    }

    public void a(OperationMode operationMode) {
        this.f20514g = operationMode;
    }
}

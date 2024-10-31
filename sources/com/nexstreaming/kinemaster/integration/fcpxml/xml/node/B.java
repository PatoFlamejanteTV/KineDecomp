package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNVideo.java */
/* loaded from: classes.dex */
class B extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g, reason: collision with root package name */
    OperationMode f20500g;

    /* renamed from: h, reason: collision with root package name */
    com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a f20501h;
    c.d.b.d.a.a.c.a i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        if (obj instanceof c.d.b.d.a.a.c.a) {
            this.i = (c.d.b.d.a.a.c.a) obj;
        } else if (obj instanceof com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) {
            this.f20501h = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) obj;
        }
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        if (this.f20500g == OperationMode.FILE) {
            if (this.f20501h != null) {
                u uVar = new u(this.f3759c);
                uVar.a(this.f20501h);
                uVar.a(OperationMode.VIDEO);
                this.f3762f.add(uVar);
                return;
            }
            return;
        }
        if (this.i != null) {
            h hVar = new h(this.f3759c);
            hVar.a(this.i);
            hVar.a(OperationMode.VIDEO);
            this.f3762f.add(hVar);
            for (c.d.b.d.a.a.e.b bVar : this.i.f()) {
                if (bVar.e()) {
                    z zVar = new z(this.f3759c);
                    zVar.a(bVar);
                    zVar.a(OperationMode.VIDEO);
                    this.f3762f.add(zVar);
                }
            }
        }
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "video";
    }

    public void a(OperationMode operationMode) {
        this.f20500g = operationMode;
    }
}

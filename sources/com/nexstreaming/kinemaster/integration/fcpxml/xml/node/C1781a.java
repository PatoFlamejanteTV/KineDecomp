package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNAudio.java */
/* renamed from: com.nexstreaming.kinemaster.integration.fcpxml.xml.node.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C1781a extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g, reason: collision with root package name */
    OperationMode f20502g;

    /* renamed from: h, reason: collision with root package name */
    com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a f20503h;
    c.d.b.d.a.a.c.a i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1781a(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        if (obj instanceof c.d.b.d.a.a.c.a) {
            this.i = (c.d.b.d.a.a.c.a) obj;
        } else if (obj instanceof com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) {
            this.f20503h = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) obj;
        }
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        if (this.f20502g == OperationMode.FILE) {
            if (this.f20503h != null) {
                u uVar = new u(this.f3759c);
                uVar.a(this.f20503h);
                uVar.a(OperationMode.AUDIO);
                this.f3762f.add(uVar);
                com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b bVar = this.f20503h.q;
                this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "channelcount", bVar.y.f20484c));
                if (bVar.v) {
                    C1782b c1782b = new C1782b(this.f3759c);
                    c1782b.a(this.f20503h);
                    this.f3762f.add(c1782b);
                    return;
                }
                return;
            }
            return;
        }
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "numOutputChannels", this.i.a().b()));
        h hVar = new h(this.f3759c);
        hVar.a(this.i);
        hVar.a(OperationMode.AUDIO);
        this.f3762f.add(hVar);
        p pVar = new p(this.f3759c);
        pVar.a(this.i);
        pVar.a(OperationMode.AUDIO);
        this.f3762f.add(pVar);
        for (c.d.b.d.a.a.e.b bVar2 : this.i.f()) {
            if (bVar2.c()) {
                z zVar = new z(this.f3759c);
                zVar.a(bVar2);
                zVar.a(OperationMode.AUDIO);
                this.f3762f.add(zVar);
            }
        }
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "audio";
    }

    public void a(OperationMode operationMode) {
        this.f20502g = operationMode;
    }
}

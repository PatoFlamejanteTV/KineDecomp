package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.SourceItem;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNMedia.java */
/* loaded from: classes.dex */
class o extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g, reason: collision with root package name */
    OperationMode f20524g;

    /* renamed from: h, reason: collision with root package name */
    com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a f20525h;
    c.d.b.d.a.a.c.a i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        if (obj instanceof c.d.b.d.a.a.c.a) {
            this.i = (c.d.b.d.a.a.c.a) obj;
        } else if (obj instanceof com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) {
            this.f20525h = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) obj;
        }
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        if (this.f20524g == OperationMode.FILE) {
            com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a aVar = this.f20525h;
            if (aVar != null) {
                com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b bVar = aVar.q;
                SourceItem.MediaType mediaType = aVar.u;
                if (mediaType == SourceItem.MediaType.VIDEO || mediaType == SourceItem.MediaType.IMAGE || mediaType == SourceItem.MediaType.BGIMAGE) {
                    B b2 = new B(this.f3759c);
                    b2.a(this.f20525h);
                    b2.a(OperationMode.FILE);
                    this.f3762f.add(b2);
                }
                if (bVar.w) {
                    C1781a c1781a = new C1781a(this.f3759c);
                    c1781a.a(this.f20525h);
                    c1781a.a(OperationMode.FILE);
                    this.f3762f.add(c1781a);
                    return;
                }
                return;
            }
            return;
        }
        c.d.b.d.a.a.c.a aVar2 = this.i;
        if (aVar2 != null) {
            List<c.d.b.d.a.a.e.b> f2 = aVar2.f();
            Iterator<c.d.b.d.a.a.e.b> it = f2.iterator();
            com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a aVar3 = null;
            com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a aVar4 = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Iterator<SourceItem> it2 = it.next().a().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    SourceItem next = it2.next();
                    if (next instanceof com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) {
                        aVar4 = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) next;
                        break;
                    }
                }
                if (aVar4 != null) {
                    B b3 = new B(this.f3759c);
                    b3.a(this.i);
                    this.f3762f.add(b3);
                    break;
                }
            }
            Iterator<c.d.b.d.a.a.e.b> it3 = f2.iterator();
            while (it3.hasNext()) {
                Iterator<SourceItem> it4 = it3.next().a().iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    SourceItem next2 = it4.next();
                    if (next2 instanceof com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) {
                        com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a aVar5 = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) next2;
                        if (aVar5.q.w) {
                            aVar3 = aVar5;
                            break;
                        }
                    }
                }
                if (aVar3 != null) {
                    C1781a c1781a2 = new C1781a(this.f3759c);
                    c1781a2.a(this.i);
                    this.f3762f.add(c1781a2);
                    return;
                }
            }
        }
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "media";
    }

    public void a(OperationMode operationMode) {
        this.f20524g = operationMode;
    }
}

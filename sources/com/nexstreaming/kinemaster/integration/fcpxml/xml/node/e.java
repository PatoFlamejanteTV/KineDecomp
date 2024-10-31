package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.Effect;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNEffect.java */
/* loaded from: classes.dex */
class e extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g */
    OperationMode f20508g;

    /* renamed from: h */
    Effect f20509h;

    public e(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        this.f20509h = (Effect) obj;
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "name", this.f20509h.f20447a));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "effectid", this.f20509h.f20448b.getEffectId()));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "effectcategory", this.f20509h.f20449c));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "effecttype", this.f20509h.f20450d.name()));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "mediatype", this.f20509h.f20451e.getMediaType()));
        Effect effect = this.f20509h;
        if (effect instanceof com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.d) {
            com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.d dVar = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.d) effect;
            this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "wipecode", dVar.f20470f));
            this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "wipeaccuracy", dVar.f20471g));
            this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "startratio", dVar.f20472h));
            this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "endratio", dVar.i));
            this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "reverse", dVar.j));
            return;
        }
        if (effect instanceof com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c) {
            List<c.b> list = ((com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c) effect).f20460f;
            if (list != null) {
                for (c.b bVar : list) {
                    q qVar = new q(this.f3759c);
                    qVar.a(bVar);
                    qVar.a(this.f20508g);
                    this.f3762f.add(qVar);
                }
                return;
            }
            return;
        }
        if (effect instanceof com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.a) {
            com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.a aVar = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.a) effect;
            if (aVar.f20452f != null) {
                q qVar2 = new q(this.f3759c);
                qVar2.a(aVar.f20452f);
                qVar2.a(this.f20508g);
                this.f3762f.add(qVar2);
            }
        }
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "effect";
    }

    public void a(OperationMode operationMode) {
        this.f20508g = operationMode;
    }
}

package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import c.d.b.d.a.a.d.a;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.Effect;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.SourceItem;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b;
import com.nexstreaming.kinemaster.integration.fcpxml.xml.tagname.TempName$LabelName;
import java.util.List;
import java.util.Locale;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNClipItem.java */
/* loaded from: classes.dex */
class d extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g, reason: collision with root package name */
    OperationMode f20506g;

    /* renamed from: h, reason: collision with root package name */
    com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a f20507h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    private void e() {
        w wVar = new w(this.f3759c);
        wVar.a(this.f20507h);
        wVar.a(this.f20506g);
        this.f3762f.add(wVar);
    }

    private void f() {
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "alphatype", SourceItem.AlphaType.none.name()));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "pixelaspectratio", SourceItem.PixelAspectRatio.square.name()));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "anamorphic", false));
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
        this.f3760d.put("id", String.format(Locale.US, "clipitem-%d", Integer.valueOf(this.f20507h.s)));
        com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a aVar = this.f20507h;
        com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b bVar = aVar.q;
        if (this.f20506g == OperationMode.AUDIO && aVar.m && bVar.y.f20484c == 2) {
            this.f3760d.put("premiereChannelType", "mono");
        }
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        List<c.d.b.d.a.a.e.a> list;
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "masterclipid", String.format(Locale.US, "masterclip-%d", Integer.valueOf(this.f20507h.r))));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "name", this.f20507h.f20474a));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "enabled", true));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "duration", this.f20507h.f20475b));
        b.c cVar = this.f20507h.q.x;
        a.C0015a c0015a = new a.C0015a(cVar.f20497e, cVar.f20498f);
        s sVar = new s(this.f3759c);
        sVar.a(c0015a);
        this.f3762f.add(sVar);
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "start", this.f20507h.f20476c));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "end", this.f20507h.f20477d));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "in", this.f20507h.f20478e));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "out", this.f20507h.f20479f));
        OperationMode operationMode = this.f20506g;
        if (operationMode == OperationMode.VIDEO) {
            f();
        } else if (operationMode == OperationMode.AUDIO) {
            e();
        }
        f fVar = new f(this.f3759c);
        fVar.a(this.f20507h);
        fVar.a(this.f20506g);
        this.f3762f.add(fVar);
        OperationMode operationMode2 = this.f20506g;
        if (operationMode2 == OperationMode.VIDEO) {
            if (this.f20507h.c()) {
                for (Effect effect : this.f20507h.x) {
                    g gVar = new g(this.f3759c);
                    gVar.a(effect);
                    gVar.a(this.f20506g);
                    this.f3762f.add(gVar);
                }
            }
        } else if (operationMode2 == OperationMode.AUDIO && this.f20507h.b()) {
            for (Effect effect2 : this.f20507h.z) {
                g gVar2 = new g(this.f3759c);
                gVar2.a(effect2);
                gVar2.a(this.f20506g);
                this.f3762f.add(gVar2);
            }
        }
        com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a aVar = this.f20507h;
        if (!aVar.m && (list = aVar.v) != null && list.size() > 0) {
            for (c.d.b.d.a.a.e.a aVar2 : this.f20507h.v) {
                m mVar = new m(this.f3759c);
                mVar.a(aVar2);
                this.f3762f.add(mVar);
            }
        }
        this.f3762f.add(new n(this.f3759c));
        l lVar = new l(this.f3759c);
        lVar.a(TempName$LabelName.winter.getName());
        this.f3762f.add(lVar);
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "clipitem";
    }

    public void a(Object obj) {
        this.f20507h = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) obj;
    }

    public void a(OperationMode operationMode) {
        this.f20506g = operationMode;
    }
}

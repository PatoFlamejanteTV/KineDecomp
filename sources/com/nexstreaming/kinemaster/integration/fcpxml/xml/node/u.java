package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import c.d.b.d.a.a.d.a;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.SourceItem;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b;
import com.nextreaming.nexeditorui.NexTimeline;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNSampleCharacteristics.java */
/* loaded from: classes.dex */
class u extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g, reason: collision with root package name */
    OperationMode f20533g;

    /* renamed from: h, reason: collision with root package name */
    com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a f20534h;
    c.d.b.d.a.a.c.a i;
    boolean j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
        this.f20534h = null;
        this.i = null;
        this.j = false;
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        if (obj instanceof c.d.b.d.a.a.c.a) {
            this.i = (c.d.b.d.a.a.c.a) obj;
        } else if (obj instanceof com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) {
            this.f20534h = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) obj;
        }
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a aVar = this.f20534h;
        if (aVar != null) {
            this.j = false;
            com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b bVar = aVar.q;
            OperationMode operationMode = this.f20533g;
            if (operationMode == OperationMode.VIDEO) {
                b.c cVar = bVar.x;
                a.C0015a c0015a = new a.C0015a(cVar.f20497e, cVar.f20498f);
                s sVar = new s(this.f3759c);
                sVar.a(c0015a);
                this.f3762f.add(sVar);
                this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "width", bVar.x.f20493a));
                this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "height", bVar.x.f20494b));
                this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "anamorphic", false));
                this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "pixelaspectratio", SourceItem.PixelAspectRatio.square.name()));
                this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "fielddominance", NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE));
                if (this.j) {
                    this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "colordepth", bVar.x.f20496d));
                    return;
                }
                return;
            }
            if (operationMode == OperationMode.AUDIO) {
                this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "depth", bVar.y.f20482a));
                this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "samplerate", bVar.y.f20483b));
                return;
            }
            return;
        }
        c.d.b.d.a.a.c.a aVar2 = this.i;
        if (aVar2 != null) {
            this.j = true;
            OperationMode operationMode2 = this.f20533g;
            if (operationMode2 == OperationMode.VIDEO) {
                c.d.b.d.a.a.b.b g2 = aVar2.g();
                a.C0015a c0015a2 = new a.C0015a(g2.b(), g2.e());
                s sVar2 = new s(this.f3759c);
                sVar2.a(c0015a2);
                this.f3762f.add(sVar2);
                this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "width", g2.d()));
                this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "height", g2.c()));
                this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "anamorphic", false));
                this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "pixelaspectratio", SourceItem.PixelAspectRatio.square.name()));
                this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "fielddominance", NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE));
                if (this.j) {
                    this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "colordepth", g2.a()));
                    return;
                }
                return;
            }
            if (operationMode2 == OperationMode.AUDIO) {
                c.d.b.d.a.a.b.a a2 = aVar2.a();
                this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "depth", a2.a()));
                this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "samplerate", a2.c()));
            }
        }
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "samplecharacteristics";
    }

    public void a(OperationMode operationMode) {
        this.f20533g = operationMode;
    }
}

package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.SourceItem;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNTrack.java */
/* loaded from: classes.dex */
public class z extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g, reason: collision with root package name */
    OperationMode f20540g;

    /* renamed from: h, reason: collision with root package name */
    c.d.b.d.a.a.e.b f20541h;

    public z(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
        this.f20541h.a();
        boolean d2 = this.f20541h.d();
        if (this.f20540g != OperationMode.AUDIO || d2) {
            return;
        }
        int i = 0;
        c.d.b.d.a.a.e.b bVar = this.f20541h;
        com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a a2 = bVar.a(bVar);
        com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b bVar2 = a2.q;
        if (a2.m || bVar2.y.f20484c != 2) {
            return;
        }
        Iterator<c.d.b.d.a.a.e.a> it = a2.v.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.d.b.d.a.a.e.a next = it.next();
            if (next.f3692e == SourceItem.MediaType.AUDIO) {
                i = next.f3690c;
                break;
            }
        }
        int i2 = a2.j - i;
        this.f3760d.put("MZ.TrackTargeted", String.valueOf(1));
        this.f3760d.put("currentExplodedTrackIndex", String.valueOf(i2));
        this.f3760d.put("totalExplodedTrackCount", String.valueOf(0L));
        this.f3760d.put("premiereTrackType", bVar2.y.f20484c == 2 ? "Stereo" : "MONO");
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        OperationMode operationMode = this.f20540g;
        if (operationMode == OperationMode.VIDEO) {
            for (SourceItem sourceItem : this.f20541h.a()) {
                SourceItem.ItemType itemType = sourceItem.i;
                if (itemType == SourceItem.ItemType.VISUAL) {
                    com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a aVar = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) sourceItem;
                    SourceItem.MediaType mediaType = aVar.u;
                    if (mediaType != SourceItem.MediaType.VIDEO && mediaType != SourceItem.MediaType.IMAGE && mediaType != SourceItem.MediaType.BGIMAGE) {
                        if (mediaType == SourceItem.MediaType.SOLID) {
                            i iVar = new i(this.f3759c);
                            iVar.a((com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.c) aVar);
                            iVar.a(this.f20540g);
                            this.f3762f.add(iVar);
                        }
                    } else {
                        d dVar = new d(this.f3759c);
                        dVar.a(aVar);
                        dVar.a(this.f20540g);
                        this.f3762f.add(dVar);
                    }
                } else if (itemType == SourceItem.ItemType.TRANSITION) {
                    A a2 = new A(this.f3759c);
                    a2.a((com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.d) sourceItem);
                    this.f3762f.add(a2);
                }
            }
        } else if (operationMode == OperationMode.AUDIO) {
            for (SourceItem sourceItem2 : this.f20541h.a()) {
                SourceItem.ItemType itemType2 = sourceItem2.i;
                if (itemType2 == SourceItem.ItemType.VISUAL || itemType2 == SourceItem.ItemType.SOUNDTRACK) {
                    com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a aVar2 = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) sourceItem2;
                    if (aVar2.u == SourceItem.MediaType.AUDIO) {
                        d dVar2 = new d(this.f3759c);
                        dVar2.a(aVar2);
                        dVar2.a(this.f20540g);
                        this.f3762f.add(dVar2);
                    }
                }
            }
        }
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "enabled", this.f20541h.f()));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "locked", this.f20541h.g()));
        if (this.f20540g == OperationMode.AUDIO) {
            int i = 0;
            for (SourceItem sourceItem3 : this.f20541h.a()) {
                SourceItem.ItemType itemType3 = sourceItem3.i;
                if (itemType3 == SourceItem.ItemType.VISUAL || itemType3 == SourceItem.ItemType.SOUNDTRACK) {
                    com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a aVar3 = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) sourceItem3;
                    if (aVar3.u == SourceItem.MediaType.AUDIO) {
                        int i2 = y.f20539a[aVar3.o.ordinal()];
                        if (i2 == 1) {
                            i = 1;
                        } else if (i2 == 2) {
                            i = 2;
                        }
                    }
                }
                if (i != 0) {
                    break;
                }
            }
            if (i != 0) {
                this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "outputchannelindex", i));
            }
        }
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "track";
    }

    public void a(Object obj) {
        this.f20541h = (c.d.b.d.a.a.e.b) obj;
    }

    public void a(OperationMode operationMode) {
        this.f20540g = operationMode;
    }
}

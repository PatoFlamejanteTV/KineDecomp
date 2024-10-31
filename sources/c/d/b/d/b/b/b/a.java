package c.d.b.d.b.b.b;

import c.d.b.d.b.b.a.b.e;
import c.d.b.d.b.b.a.d.c;
import c.d.b.d.d.b.b;
import c.d.b.d.d.b.d;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.LayerItem;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.f;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: KXNProject.java */
/* loaded from: classes.dex */
public class a extends b implements d {

    /* renamed from: g, reason: collision with root package name */
    private c.d.b.d.b.a.b.a f3750g;

    public a(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
        this.f3760d.put("width", String.valueOf(this.f3750g.i()));
        this.f3760d.put("height", String.valueOf(this.f3750g.c()));
        this.f3760d.put("fps", String.valueOf(this.f3750g.b()));
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        ArrayList<c.d.b.d.b.a.a.a> e2 = this.f3750g.e();
        if (e2 != null && e2.size() > 0) {
            Iterator<c.d.b.d.b.a.a.a> it = e2.iterator();
            while (it.hasNext()) {
                c.d.b.d.b.a.a.a next = it.next();
                c cVar = new c(this.f3759c);
                cVar.a(next);
                this.f3762f.add(cVar);
            }
        }
        if (this.f3750g.f() != null) {
            c.d.b.d.b.b.a.a.d dVar = new c.d.b.d.b.b.a.a.d(this.f3759c);
            dVar.a(this.f3750g.f());
            this.f3762f.add(dVar);
        }
        c.d.b.d.b.b.a.d.d dVar2 = new c.d.b.d.b.b.a.d.d(this.f3759c);
        dVar2.a(this.f3750g.h());
        this.f3762f.add(dVar2);
        ArrayList<LayerItem> d2 = this.f3750g.d();
        if (d2 != null && d2.size() > 0) {
            Iterator<LayerItem> it2 = d2.iterator();
            while (it2.hasNext()) {
                LayerItem next2 = it2.next();
                if (next2 instanceof f) {
                    e eVar = new e(this.f3759c);
                    eVar.a(next2);
                    this.f3762f.add(eVar);
                } else if (next2 instanceof com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.e) {
                    c.d.b.d.b.b.a.b.c cVar2 = new c.d.b.d.b.b.a.b.c(this.f3759c);
                    cVar2.a(next2);
                    this.f3762f.add(cVar2);
                } else if (next2 instanceof com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.b) {
                    c.d.b.d.b.b.a.b.a aVar = new c.d.b.d.b.b.a.b.a(this.f3759c);
                    aVar.a(next2);
                    this.f3762f.add(aVar);
                }
            }
        }
        ArrayList<com.nexstreaming.kinemaster.integration.kmxml.adapter.items.a> a2 = this.f3750g.a();
        if (a2 == null || a2.size() <= 0) {
            return;
        }
        Iterator<com.nexstreaming.kinemaster.integration.kmxml.adapter.items.a> it3 = a2.iterator();
        while (it3.hasNext()) {
            com.nexstreaming.kinemaster.integration.kmxml.adapter.items.a next3 = it3.next();
            c.d.b.d.b.b.a.d.a aVar2 = new c.d.b.d.b.b.a.d.a(this.f3759c);
            aVar2.a(next3);
            this.f3762f.add(aVar2);
        }
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "kmproject";
    }

    public void a(Object obj) {
        this.f3750g = (c.d.b.d.b.a.b.a) obj;
    }
}

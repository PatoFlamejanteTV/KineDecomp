package c.d.b.d.b.b.a.d;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.items.SourceItem;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: KXNSequence.java */
/* loaded from: classes.dex */
public class d extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d {

    /* renamed from: g, reason: collision with root package name */
    c.d.b.d.b.a.d.a f3746g;

    public d(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        this.f3746g = (c.d.b.d.b.a.d.a) obj;
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        Iterator<SourceItem> it = this.f3746g.b().iterator();
        while (it.hasNext()) {
            SourceItem next = it.next();
            if (next instanceof com.nexstreaming.kinemaster.integration.kmxml.adapter.items.e) {
                g gVar = new g(this.f3759c);
                gVar.a(next);
                this.f3762f.add(gVar);
            } else if (next instanceof com.nexstreaming.kinemaster.integration.kmxml.adapter.items.b) {
                b bVar = new b(this.f3759c);
                bVar.a(next);
                this.f3762f.add(bVar);
            } else if (next instanceof com.nexstreaming.kinemaster.integration.kmxml.adapter.items.d) {
                f fVar = new f(this.f3759c);
                fVar.a(next);
                this.f3762f.add(fVar);
            } else if (next instanceof com.nexstreaming.kinemaster.integration.kmxml.adapter.items.c) {
                e eVar = new e(this.f3759c);
                eVar.a(next);
                this.f3762f.add(eVar);
            }
        }
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "sequence";
    }
}

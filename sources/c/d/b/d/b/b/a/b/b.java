package c.d.b.d.b.b.a.b;

import android.graphics.RectF;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.LayerItem;
import java.util.LinkedHashMap;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: KXNLayer.java */
/* loaded from: classes.dex */
public abstract class b extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d {

    /* renamed from: g, reason: collision with root package name */
    private LayerItem f3736g;

    public b(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
        this.f3760d.put("start", c.d.b.d.e.a.a(this.f3736g.k()));
        this.f3760d.put("end", c.d.b.d.e.a.a(this.f3736g.e()));
        this.f3760d.put("duration", c.d.b.d.e.a.a(this.f3736g.a()));
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        c.d.b.d.b.b.a.b.a.a aVar = new c.d.b.d.b.b.a.b.a.a(this.f3759c);
        aVar.a(this.f3736g.h());
        this.f3762f.add(aVar);
        new c.d.b.d.b.b.c.a(this.f3759c, this.f3762f, this.f3736g.b()).a();
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "blend", "alpha", String.valueOf(this.f3736g.c()), null));
        if (this.f3736g.l()) {
            c.d.b.d.b.b.a.a.c cVar = new c.d.b.d.b.b.a.a.c(this.f3759c);
            cVar.a(this.f3736g.f());
            this.f3762f.add(cVar);
        }
        if (this.f3736g.d() != null) {
            c.d.b.d.b.b.a.c.b bVar = new c.d.b.d.b.b.a.c.b(this.f3759c);
            bVar.a(this.f3736g.d());
            this.f3762f.add(bVar);
        }
        LayerItem.c g2 = this.f3736g.g();
        if (g2 != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String str = g2.f20594a;
            if (str != null) {
                linkedHashMap.put("iid", c.d.b.d.e.a.a(str));
            }
            if (g2.b()) {
                RectF a2 = g2.a();
                linkedHashMap.put("left", String.valueOf(a2.left));
                linkedHashMap.put("top", String.valueOf(a2.top));
                linkedHashMap.put("right", String.valueOf(a2.right));
                linkedHashMap.put("bottom", String.valueOf(a2.bottom));
            }
            if (linkedHashMap.size() > 0) {
                this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "layercrop", linkedHashMap, null));
            }
        }
    }

    public void a(Object obj) {
        this.f3736g = (LayerItem) obj;
    }
}

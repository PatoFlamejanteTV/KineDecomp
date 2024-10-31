package c.d.b.d.b.b.a.b.a;

import c.d.b.d.d.b.b;
import c.d.b.d.d.b.d;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.LayerItem;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: KXNPosition.java */
/* loaded from: classes.dex */
public class a extends b implements d {

    /* renamed from: g */
    private LayerItem.d f3735g;

    public a(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
        this.f3760d.put(FragmentC2201x.f23219a, String.valueOf(this.f3735g.f20597a));
        this.f3760d.put("y", String.valueOf(this.f3735g.f20598b));
        this.f3760d.put("scale", String.valueOf(this.f3735g.f20599c));
        this.f3760d.put("angle", String.valueOf(this.f3735g.f20600d));
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "position";
    }

    public void a(Object obj) {
        this.f3735g = (LayerItem.d) obj;
    }
}

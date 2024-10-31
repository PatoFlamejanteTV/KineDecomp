package c.d.b.d.b.b.a.a;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.LayerItem;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: KXNKeyFrameAnimation.java */
/* loaded from: classes.dex */
public class c extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d {

    /* renamed from: g */
    private LayerItem.b f3731g;

    public c(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        this.f3731g = (LayerItem.b) obj;
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        Iterator<LayerItem.a> it = this.f3731g.a().iterator();
        while (it.hasNext()) {
            LayerItem.a next = it.next();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("time", c.d.b.d.e.a.a(next.f20591a));
            linkedHashMap.put(FragmentC2201x.f23219a, String.valueOf(next.f20592b.f20597a));
            linkedHashMap.put("y", String.valueOf(next.f20592b.f20598b));
            linkedHashMap.put("scale", String.valueOf(next.f20592b.f20599c));
            linkedHashMap.put("angle", String.valueOf(next.f20592b.f20600d));
            this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "keyframe", linkedHashMap, null));
        }
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "keyframeanimation";
    }
}

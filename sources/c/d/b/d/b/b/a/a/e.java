package c.d.b.d.b.b.a.a;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: KXNVolumeEnvEffect.java */
/* loaded from: classes.dex */
public class e extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d {

    /* renamed from: g */
    private g f3733g;

    public e(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        this.f3733g = (g) obj;
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        ArrayList<g.a> a2 = this.f3733g.a();
        if (a2 == null || a2.size() <= 0) {
            return;
        }
        Iterator<g.a> it = a2.iterator();
        while (it.hasNext()) {
            g.a next = it.next();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("time", c.d.b.d.e.a.a(next.f20567a));
            linkedHashMap.put("gain", String.valueOf(next.f20568b));
            this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "volkf", linkedHashMap, null));
        }
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "volumeenv";
    }
}

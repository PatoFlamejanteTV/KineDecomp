package c.d.b.d.b.b.c;

import c.d.b.d.d.b.b;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.AnimationEffect;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.CropEffect;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.Effect;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.FlipEffect;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.c;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.d;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.e;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: SubEffectGenerator.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    ArrayList<Effect> f3751a;

    /* renamed from: b, reason: collision with root package name */
    List<b> f3752b;

    /* renamed from: c, reason: collision with root package name */
    XmlSerializer f3753c;

    public a(XmlSerializer xmlSerializer, List<b> list, ArrayList<Effect> arrayList) {
        this.f3751a = arrayList;
        this.f3752b = list;
        this.f3753c = xmlSerializer;
    }

    public a a() {
        ArrayList<Effect> arrayList;
        if (this.f3753c != null && this.f3752b != null && (arrayList = this.f3751a) != null) {
            Iterator<Effect> it = arrayList.iterator();
            while (it.hasNext()) {
                Effect next = it.next();
                if (next instanceof com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.a) {
                    com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.a aVar = (com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.a) next;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("gain", String.valueOf(aVar.a()));
                    linkedHashMap.put("leftpan", String.valueOf(aVar.b()));
                    linkedHashMap.put("rightpan", String.valueOf(aVar.c()));
                    linkedHashMap.put("mute", String.valueOf(aVar.d()));
                    this.f3752b.add(new c.d.b.d.d.b.a(this.f3753c, "audiomix", linkedHashMap, null));
                } else if (next instanceof CropEffect) {
                    CropEffect cropEffect = (CropEffect) next;
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put("auto", cropEffect.d().getName());
                    if (cropEffect.a() != null) {
                        linkedHashMap2.put("left", String.valueOf(cropEffect.a().left));
                        linkedHashMap2.put("top", String.valueOf(cropEffect.a().top));
                        linkedHashMap2.put("right", String.valueOf(cropEffect.a().right));
                        linkedHashMap2.put("bottom", String.valueOf(cropEffect.a().bottom));
                    }
                    if (cropEffect.b() != 1.0f) {
                        linkedHashMap2.put("scale", String.valueOf(cropEffect.b()));
                    }
                    if (cropEffect.c() != 0.0f) {
                        linkedHashMap2.put("time", c.d.b.d.e.a.a(cropEffect.c()));
                    }
                    this.f3752b.add(new c.d.b.d.d.b.a(this.f3753c, "crop", linkedHashMap2, null));
                } else if (next instanceof c) {
                    c.d.b.d.b.b.a.a.b bVar = new c.d.b.d.b.b.a.a.b(this.f3753c);
                    bVar.a((c) next);
                    this.f3752b.add(bVar);
                } else if (next instanceof d) {
                    this.f3752b.add(new c.d.b.d.d.b.a(this.f3753c, "angle", "angle", String.valueOf(((d) next).a()), null));
                } else if (next instanceof AnimationEffect) {
                    c.d.b.d.b.b.a.a.a aVar2 = new c.d.b.d.b.b.a.a.a(this.f3753c);
                    aVar2.a((AnimationEffect) next);
                    this.f3752b.add(aVar2);
                } else if (next instanceof e) {
                    this.f3752b.add(new c.d.b.d.d.b.a(this.f3753c, "playspeed", "rate", String.valueOf(((e) next).a()), null));
                } else if (next instanceof FlipEffect) {
                    this.f3752b.add(new c.d.b.d.d.b.a(this.f3753c, "flip", "direction", ((FlipEffect) next).a().getName(), null));
                } else if (next instanceof g) {
                    c.d.b.d.b.b.a.a.e eVar = new c.d.b.d.b.b.a.a.e(this.f3753c);
                    eVar.a((g) next);
                    this.f3752b.add(eVar);
                }
            }
        }
        return this;
    }
}

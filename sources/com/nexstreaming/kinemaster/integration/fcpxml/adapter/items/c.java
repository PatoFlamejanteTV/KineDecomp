package com.nexstreaming.kinemaster.integration.fcpxml.adapter.items;

import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.Effect;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.EffectId;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.a;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.SourceItem;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a;
import java.util.List;

/* compiled from: SolidClipItem.java */
/* loaded from: classes.dex */
public class c extends a implements Cloneable {
    a.C0102a A;

    public c(a.C0104a c0104a, a.C0102a c0102a) {
        super(c0104a);
        this.A = c0102a;
        a(this.A);
    }

    private void a(a.C0102a c0102a) {
        com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.a aVar = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.a) a.a(EffectId.COLOR_MATTE, this.x);
        if (aVar == null) {
            List<String> nameTable = EffectId.getNameTable(EffectId.COLOR_MATTE.getEffectId());
            com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.a aVar2 = new com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.a(EffectId.COLOR_MATTE, nameTable.get(0), nameTable.get(1), Effect.EffectType.generator, SourceItem.MediaType.VIDEO);
            this.x.add(aVar2);
            aVar = aVar2;
        }
        Effect.EffectParameterId effectParameterId = Effect.EffectParameterId.fillcolor;
        aVar.a(new a.b(effectParameterId, effectParameterId.getParameterName(), c0102a));
        this.w = true;
    }

    @Override // com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (this.A != null) {
            sb.append("\nSolid Color Value ------------------------------------");
            sb.append("\n    Alpha : " + this.A.f20453a);
            sb.append("\n    Red   : " + this.A.f20454b);
            sb.append("\n    Green : " + this.A.f20455c);
            sb.append("\n    Blue  : " + this.A.f20456d);
        }
        return sb.toString();
    }

    @Override // com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a, com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.SourceItem
    public c clone() {
        return (c) super.clone();
    }

    public static boolean a(String str) {
        return str.startsWith("@solid:");
    }
}

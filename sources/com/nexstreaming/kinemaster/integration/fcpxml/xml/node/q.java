package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.a;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c;
import java.util.HashMap;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNParameter.java */
/* loaded from: classes.dex */
class q extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g, reason: collision with root package name */
    OperationMode f20528g;

    /* renamed from: h, reason: collision with root package name */
    com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.b f20529h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        this.f20529h = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.b) obj;
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        a.b bVar;
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "parameterid", this.f20529h.f20458a.name()));
        this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "name", this.f20529h.f20458a.getParameterName()));
        com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.b bVar2 = this.f20529h;
        if (bVar2 instanceof c.b) {
            c.b bVar3 = (c.b) bVar2;
            if (bVar3.f20467g != null) {
                r rVar = new r(this.f3759c);
                HashMap hashMap = new HashMap();
                hashMap.put("horiz", Double.valueOf(bVar3.f20467g.f20461a));
                hashMap.put("vert", Double.valueOf(bVar3.f20467g.f20462b));
                rVar.a(hashMap);
                rVar.a(this.f20528g);
                this.f3762f.add(rVar);
                return;
            }
            this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "valuemin", bVar3.f20463c));
            this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "valuemax", bVar3.f20464d));
            this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "value", bVar3.f20465e));
            c.C0103c[] c0103cArr = bVar3.f20466f;
            if (c0103cArr == null || c0103cArr.length <= 0) {
                return;
            }
            for (c.C0103c c0103c : c0103cArr) {
                k kVar = new k(this.f3759c);
                kVar.a(c0103c);
                kVar.a(this.f20528g);
                this.f3762f.add(kVar);
            }
            return;
        }
        if (!(bVar2 instanceof a.b) || (bVar = (a.b) bVar2) == null) {
            return;
        }
        r rVar2 = new r(this.f3759c);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("alpha", Double.valueOf(bVar.f20457c.f20453a));
        hashMap2.put("red", Double.valueOf(bVar.f20457c.f20454b));
        hashMap2.put("green", Double.valueOf(bVar.f20457c.f20455c));
        hashMap2.put("blue", Double.valueOf(bVar.f20457c.f20456d));
        rVar2.a(hashMap2);
        rVar2.a(this.f20528g);
        this.f3762f.add(rVar2);
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD;
    }

    public void a(OperationMode operationMode) {
        this.f20528g = operationMode;
    }
}

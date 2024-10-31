package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import java.util.Map;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNParameterValue.java */
/* loaded from: classes.dex */
class r extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g */
    OperationMode f20530g;

    /* renamed from: h */
    Map<String, Double> f20531h;

    public r(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        this.f20531h = (Map) obj;
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        Map<String, Double> map = this.f20531h;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (String str : this.f20531h.keySet()) {
            this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, str, this.f20531h.get(str).doubleValue()));
        }
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "value";
    }

    public void a(OperationMode operationMode) {
        this.f20530g = operationMode;
    }
}

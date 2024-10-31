package com.nexstreaming.kinemaster.integration.fcpxml.xml.node;

import org.xmlpull.v1.XmlSerializer;

/* compiled from: FXNLables.java */
/* loaded from: classes.dex */
class l extends c.d.b.d.d.b.b implements c.d.b.d.d.b.d, c.d.b.d.d.b.c {

    /* renamed from: g */
    String f20521g;

    /* renamed from: h */
    String f20522h;

    public l(XmlSerializer xmlSerializer) {
        super(xmlSerializer);
    }

    @Override // c.d.b.d.d.b.b
    public void a() {
    }

    public void a(Object obj) {
        this.f20522h = (String) obj;
    }

    @Override // c.d.b.d.d.b.b
    public void b() {
        String str = this.f20521g;
        if (str != null) {
            this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "label", str));
            return;
        }
        String str2 = this.f20522h;
        if (str2 != null) {
            this.f3762f.add(new c.d.b.d.d.b.a(this.f3759c, "label2", str2));
        }
    }

    @Override // c.d.b.d.d.b.b
    public String c() {
        return "labels";
    }
}

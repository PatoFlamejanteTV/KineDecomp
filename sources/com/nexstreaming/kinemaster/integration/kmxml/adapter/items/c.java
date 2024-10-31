package com.nexstreaming.kinemaster.integration.kmxml.adapter.items;

import com.nexstreaming.app.general.util.C1703g;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.items.SourceItem;

/* compiled from: SolidItem.java */
/* loaded from: classes.dex */
public class c extends f {

    /* renamed from: g */
    String f20578g;

    public c(float f2, int i) {
        super(SourceItem.ItemType.SOLID, f2);
        this.f20578g = C1703g.a(i);
    }

    public String f() {
        return this.f20578g;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nSolidItem ............................. ");
        sb.append("\n\t duration : " + this.f20570b);
        sb.append("\n\t textColor    : " + this.f20578g);
        return sb.toString();
    }
}

package com.nexstreaming.kinemaster.integration.kmxml.adapter.items;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.Effect;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.FlipEffect;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.items.SourceItem;

/* compiled from: ImageItem.java */
/* loaded from: classes.dex */
public class b extends f {

    /* renamed from: g */
    c.d.b.d.b.a.a.a f20576g;

    /* renamed from: h */
    FlipEffect f20577h;

    public b(c.d.b.d.b.a.a.a aVar, float f2) {
        super(SourceItem.ItemType.IMAGE, f2);
        this.f20576g = aVar;
    }

    public void a(FlipEffect flipEffect) {
        this.f20577h = flipEffect;
        a((Effect) flipEffect);
    }

    public c.d.b.d.b.a.a.a f() {
        return this.f20576g;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nImageItem ............................. ");
        sb.append("\n\t duration : " + this.f20570b);
        sb.append("\n\t media    : " + this.f20576g.toString());
        return sb.toString();
    }
}

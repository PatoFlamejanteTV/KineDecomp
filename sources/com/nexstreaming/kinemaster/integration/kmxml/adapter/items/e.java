package com.nexstreaming.kinemaster.integration.kmxml.adapter.items;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.Effect;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.FlipEffect;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.items.SourceItem;

/* compiled from: VideoItem.java */
/* loaded from: classes.dex */
public class e extends f {

    /* renamed from: g */
    float f20581g;

    /* renamed from: h */
    c.d.b.d.b.a.a.a f20582h;
    FlipEffect i;

    public e(c.d.b.d.b.a.a.a aVar, float f2, float f3) {
        super(SourceItem.ItemType.VIDEO, f2);
        this.f20581g = f3;
        this.f20582h = aVar;
    }

    public void a(FlipEffect flipEffect) {
        this.i = flipEffect;
        a((Effect) flipEffect);
    }

    public c.d.b.d.b.a.a.a f() {
        return this.f20582h;
    }

    public float g() {
        return this.f20581g;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nVideoItem ............................. ");
        sb.append("\n\t offset   : " + this.f20581g);
        sb.append("\n\t duration : " + this.f20570b);
        sb.append("\n\t media    : " + this.f20582h);
        return sb.toString();
    }
}

package com.nexstreaming.kinemaster.integration.kmxml.adapter.items;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.items.SourceItem;

/* compiled from: VisualItem.java */
/* loaded from: classes.dex */
public abstract class f extends SourceItem {

    /* renamed from: d */
    c.d.b.d.b.a.c.a f20583d;

    /* renamed from: e */
    com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.b f20584e;

    /* renamed from: f */
    com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.f f20585f;

    public f(SourceItem.ItemType itemType, float f2) {
        super(itemType, f2);
    }

    public void a(c.d.b.d.b.a.c.a aVar) {
        this.f20583d = aVar;
    }

    public com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.b c() {
        return this.f20584e;
    }

    public c.d.b.d.b.a.c.a d() {
        return this.f20583d;
    }

    public com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.f e() {
        return this.f20585f;
    }

    public void a(com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.b bVar) {
        this.f20584e = bVar;
    }

    public void a(com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.f fVar) {
        this.f20585f = fVar;
    }
}

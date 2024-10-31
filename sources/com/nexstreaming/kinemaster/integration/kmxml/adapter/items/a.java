package com.nexstreaming.kinemaster.integration.kmxml.adapter.items;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.items.SourceItem;

/* compiled from: AudioItem.java */
/* loaded from: classes.dex */
public class a extends SourceItem {

    /* renamed from: d */
    float f20572d;

    /* renamed from: e */
    float f20573e;

    /* renamed from: f */
    float f20574f;

    /* renamed from: g */
    c.d.b.d.b.a.a.a f20575g;

    public a(c.d.b.d.b.a.a.a aVar, float f2, float f3, float f4, float f5) {
        super(SourceItem.ItemType.AUDIO, f2);
        this.f20572d = f3;
        this.f20573e = f4;
        this.f20574f = f5;
        this.f20575g = aVar;
    }

    public float c() {
        return this.f20573e;
    }

    public c.d.b.d.b.a.a.a d() {
        return this.f20575g;
    }

    public float e() {
        return this.f20574f;
    }

    public float f() {
        return this.f20572d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nAudioItem ............................. ");
        sb.append("\n\t start    : " + this.f20572d);
        sb.append("\n\t offset   : " + this.f20574f);
        sb.append("\n\t duration : " + this.f20570b);
        sb.append("\n\t media    : " + this.f20575g);
        return sb.toString();
    }
}

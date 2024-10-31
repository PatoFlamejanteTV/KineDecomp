package com.nexstreaming.kinemaster.integration.kmxml.adapter.layer;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.LayerItem;

/* compiled from: ImageLayerItem.java */
/* loaded from: classes.dex */
public class b extends LayerItem {
    public b(c.d.b.d.b.a.a.a aVar, float f2, float f3, float f4) {
        super(LayerItem.LayerType.IMAGELAYER, f2, f3, f4);
        this.l = aVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n\nImageLayerItem ............................. ");
        sb.append("\n\t mStart    : " + this.f20586d);
        sb.append("\n\t mEnd      : " + this.f20587e);
        sb.append("\n\t mDuration : " + (this.f20587e - this.f20586d));
        sb.append("\n\t media    : " + this.l);
        return sb.toString();
    }

    public b(c.d.b.d.b.a.a.a aVar, float f2, float f3, float f4, LayerItem.d dVar, float f5) {
        this(aVar, f2, f3, f4);
        a(dVar);
        a(f5);
    }
}

package com.nexstreaming.kinemaster.integration.kmxml.adapter.layer;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.LayerItem;

/* compiled from: VideoLayerItem.java */
/* loaded from: classes.dex */
public class f extends LayerItem {
    public f(c.d.b.d.b.a.a.a aVar, float f2, float f3, float f4) {
        super(LayerItem.LayerType.VIDEOLAYER, f2, f3, f4);
        this.l = aVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n\nVideoLayerItem ............................. ");
        sb.append("\n\t mStart    : " + this.f20586d);
        sb.append("\n\t mOffset   : " + this.f20589g);
        sb.append("\n\t mDuration : " + (this.f20587e - this.f20586d));
        sb.append("\n\t media    : " + this.l);
        return sb.toString();
    }

    public f(c.d.b.d.b.a.a.a aVar, float f2, float f3, float f4, float f5, LayerItem.d dVar, float f6) {
        this(aVar, f2, f3, f4);
        this.f20589g = f5;
        this.f20590h = dVar;
        this.k = f6;
    }
}

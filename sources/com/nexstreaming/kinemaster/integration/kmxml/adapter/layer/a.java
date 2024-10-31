package com.nexstreaming.kinemaster.integration.kmxml.adapter.layer;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.Effect;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.LayerItem;
import java.util.ArrayList;

/* compiled from: EffectLayerItem.java */
/* loaded from: classes.dex */
public class a extends LayerItem {
    private String p;
    private ArrayList<Effect.a> q;

    public a(String str, float f2, float f3, float f4) {
        super(LayerItem.LayerType.EFFECTLAYER, f2, f3, f4);
        this.p = this.p;
        this.q = new ArrayList<>();
    }

    public void a(ArrayList<Effect.a> arrayList) {
        this.q = arrayList;
    }

    public a(String str, float f2, float f3, float f4, LayerItem.d dVar, float f5) {
        this(str, f2, f3, f4);
        a(dVar);
        a(f5);
    }
}

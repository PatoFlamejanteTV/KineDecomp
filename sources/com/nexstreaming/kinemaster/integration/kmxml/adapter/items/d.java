package com.nexstreaming.kinemaster.integration.kmxml.adapter.items;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.Effect;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.items.SourceItem;
import java.util.ArrayList;

/* compiled from: TransitionItem.java */
/* loaded from: classes.dex */
public class d extends SourceItem {

    /* renamed from: d */
    String f20579d;

    /* renamed from: e */
    ArrayList<Effect.a> f20580e;

    public d(float f2, String str) {
        super(SourceItem.ItemType.TRANSITION, f2);
        this.f20579d = str;
        this.f20580e = new ArrayList<>();
    }

    public void a(Effect.a aVar) {
        this.f20580e.add(aVar);
    }

    public String c() {
        return this.f20579d;
    }

    public ArrayList<Effect.a> d() {
        return this.f20580e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nTransitionItem ............................. ");
        sb.append("\n\t duration : " + this.f20570b);
        sb.append("\n\t iid      : " + this.f20579d);
        return sb.toString();
    }
}

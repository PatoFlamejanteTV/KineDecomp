package com.nexstreaming.kinemaster.integration.kmxml.adapter.effect;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.Effect;
import java.util.ArrayList;

/* compiled from: FilterEffect.java */
/* loaded from: classes.dex */
public class c extends Effect {

    /* renamed from: b */
    String f20560b;

    /* renamed from: c */
    ArrayList<Effect.a> f20561c;

    public c(String str) {
        super(Effect.EffectType.FILTER);
        this.f20560b = str;
        this.f20561c = new ArrayList<>();
    }

    public String a() {
        return this.f20560b;
    }

    public ArrayList<Effect.a> b() {
        return this.f20561c;
    }

    public void a(Effect.a aVar) {
        this.f20561c.add(aVar);
    }
}

package com.nexstreaming.kinemaster.integration.kmxml.adapter.effect;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.Effect;
import java.util.ArrayList;

/* compiled from: ClipGraphics.java */
/* loaded from: classes.dex */
public class b extends Effect {

    /* renamed from: b */
    String f20558b;

    /* renamed from: c */
    ArrayList<Effect.a> f20559c;

    public b(String str) {
        super(Effect.EffectType.CLIPGRAPHICS);
        this.f20558b = str;
        this.f20559c = new ArrayList<>();
    }

    public String a() {
        return this.f20558b;
    }

    public ArrayList<Effect.a> b() {
        return this.f20559c;
    }

    public void a(Effect.a aVar) {
        this.f20559c.add(aVar);
    }
}

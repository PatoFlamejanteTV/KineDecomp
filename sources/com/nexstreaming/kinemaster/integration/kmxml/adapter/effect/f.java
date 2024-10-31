package com.nexstreaming.kinemaster.integration.kmxml.adapter.effect;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.Effect;
import java.util.ArrayList;

/* compiled from: Vignette.java */
/* loaded from: classes.dex */
public class f extends Effect {

    /* renamed from: b */
    String f20564b;

    /* renamed from: c */
    ArrayList<Effect.a> f20565c;

    public f(String str) {
        super(Effect.EffectType.VIGNETTE);
        this.f20564b = str;
        this.f20565c = new ArrayList<>();
    }

    public String a() {
        return this.f20564b;
    }

    public ArrayList<Effect.a> b() {
        return this.f20565c;
    }
}

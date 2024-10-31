package com.nexstreaming.kinemaster.integration.kmxml.adapter.effect;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.Effect;

/* compiled from: AudioMixEffect.java */
/* loaded from: classes.dex */
public class a extends Effect {

    /* renamed from: b */
    private float f20554b;

    /* renamed from: c */
    private float f20555c;

    /* renamed from: d */
    private float f20556d;

    /* renamed from: e */
    private boolean f20557e;

    public a(float f2, float f3, float f4, boolean z) {
        super(Effect.EffectType.AUDIOMIX);
        this.f20554b = f2;
        this.f20555c = f3;
        this.f20556d = f4;
        this.f20557e = z;
    }

    public float a() {
        return this.f20554b;
    }

    public float b() {
        return this.f20555c;
    }

    public float c() {
        return this.f20556d;
    }

    public boolean d() {
        return this.f20557e;
    }
}

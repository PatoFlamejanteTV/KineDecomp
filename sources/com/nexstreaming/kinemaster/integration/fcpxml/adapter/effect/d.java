package com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect;

import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.Effect;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.SourceItem;

/* compiled from: TransitionEffect.java */
/* loaded from: classes.dex */
public class d extends Effect {

    /* renamed from: f */
    public int f20470f;

    /* renamed from: g */
    public int f20471g;

    /* renamed from: h */
    public float f20472h;
    public float i;
    public boolean j;

    public d(EffectId effectId, String str, String str2, Effect.EffectType effectType, SourceItem.MediaType mediaType) {
        super(effectId, str, str2, effectType, mediaType);
    }

    public void a(int i, int i2, float f2, float f3, boolean z) {
        this.f20470f = i;
        this.f20471g = i2;
        this.f20472h = f2;
        this.i = f3;
        this.j = z;
    }

    public float f() {
        return this.i;
    }

    public float g() {
        return this.f20472h;
    }

    public int h() {
        return this.f20471g;
    }

    public int i() {
        return this.f20470f;
    }

    public boolean j() {
        return this.j;
    }
}

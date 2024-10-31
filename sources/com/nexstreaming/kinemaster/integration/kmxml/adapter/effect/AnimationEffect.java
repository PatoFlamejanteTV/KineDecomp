package com.nexstreaming.kinemaster.integration.kmxml.adapter.effect;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.Effect;

/* loaded from: classes.dex */
public class AnimationEffect extends Effect {

    /* renamed from: b */
    AnimationType f20542b;

    /* renamed from: c */
    String f20543c;

    /* renamed from: d */
    float f20544d;

    /* renamed from: e */
    float f20545e;

    /* loaded from: classes.dex */
    public enum AnimationType {
        IN("in"),
        OUT("out"),
        OVERALL("overall");

        private String type;

        AnimationType(String str) {
            this.type = str;
        }

        public String getName() {
            return this.type;
        }
    }

    public AnimationEffect(AnimationType animationType, String str) {
        super(Effect.EffectType.ANIMATION);
        this.f20544d = 0.0f;
        this.f20545e = 1.0f;
        this.f20542b = animationType;
        this.f20543c = str;
    }

    public AnimationType a() {
        return this.f20542b;
    }

    public float b() {
        return this.f20544d;
    }

    public String c() {
        return this.f20543c;
    }

    public float d() {
        return this.f20545e;
    }
}

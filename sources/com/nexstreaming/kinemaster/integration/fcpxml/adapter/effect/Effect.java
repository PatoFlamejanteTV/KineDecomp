package com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect;

import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.SourceItem;

/* loaded from: classes.dex */
public abstract class Effect {

    /* renamed from: a */
    public String f20447a;

    /* renamed from: b */
    public EffectId f20448b;

    /* renamed from: c */
    public String f20449c;

    /* renamed from: d */
    public EffectType f20450d;

    /* renamed from: e */
    public SourceItem.MediaType f20451e;

    /* loaded from: classes.dex */
    public enum EffectParameterId {
        scale("Scale"),
        rotation("Rotation"),
        center("Center"),
        centerOffset("Anchor Point"),
        speed("speed"),
        level("Level"),
        pan("Pan"),
        fillcolor("fillcolor");

        private String type;

        EffectParameterId(String str) {
            this.type = str;
        }

        public String getParameterName() {
            return this.type;
        }
    }

    /* loaded from: classes.dex */
    public enum EffectType {
        filter,
        transition,
        motion,
        generator,
        audiolevels,
        audiopan
    }

    public Effect(EffectId effectId, String str, String str2, EffectType effectType, SourceItem.MediaType mediaType) {
        this.f20447a = str;
        this.f20448b = effectId;
        this.f20449c = str2;
        this.f20450d = effectType;
        this.f20451e = mediaType;
    }

    public EffectType a() {
        return this.f20450d;
    }

    public String b() {
        return this.f20449c;
    }

    public EffectId c() {
        return this.f20448b;
    }

    public String d() {
        return this.f20447a;
    }

    public SourceItem.MediaType e() {
        return this.f20451e;
    }
}

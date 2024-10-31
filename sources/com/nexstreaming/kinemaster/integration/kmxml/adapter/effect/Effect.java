package com.nexstreaming.kinemaster.integration.kmxml.adapter.effect;

/* loaded from: classes.dex */
public abstract class Effect {

    /* renamed from: a */
    public EffectType f20550a;

    /* loaded from: classes.dex */
    public enum EffectType {
        AUDIOMIX("audiomix"),
        CROP("crop"),
        FILTER("filter"),
        ROTATE("angle"),
        ANIMATION("animation"),
        SPEED("speed"),
        CLIPGRAPHICS("clipgraphics"),
        VIGNETTE("vignette"),
        FLIP("flip"),
        VOLUMEENV("volumeenv");

        private String type;

        EffectType(String str) {
            this.type = str;
        }

        public String getName() {
            return this.type;
        }
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public String f20551a;

        /* renamed from: b */
        public String f20552b;

        public a(String str, String str2) {
            this.f20551a = str;
            this.f20552b = str2;
        }
    }

    public Effect(EffectType effectType) {
        this.f20550a = effectType;
    }
}

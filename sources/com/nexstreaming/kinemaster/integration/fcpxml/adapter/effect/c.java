package com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect;

import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.Effect;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.SourceItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FilterEffect.java */
/* loaded from: classes.dex */
public class c extends Effect {

    /* renamed from: f */
    public List<b> f20460f;

    /* compiled from: FilterEffect.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public double f20461a;

        /* renamed from: b */
        public double f20462b;

        public a(double d2, double d3) {
            this.f20461a = d2;
            this.f20462b = d3;
        }
    }

    /* compiled from: FilterEffect.java */
    /* renamed from: com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c$c */
    /* loaded from: classes.dex */
    public static class C0103c {

        /* renamed from: a */
        public int f20468a;

        /* renamed from: b */
        public double f20469b;

        public C0103c(int i, double d2) {
            this.f20468a = i;
            this.f20469b = d2;
        }
    }

    public c(EffectId effectId, String str, String str2, Effect.EffectType effectType, SourceItem.MediaType mediaType) {
        super(effectId, str, str2, effectType, mediaType);
        this.f20460f = new ArrayList();
        f();
    }

    public C0103c[] a(int i, double d2, int i2, double d3) {
        return new C0103c[]{new C0103c(i, d2), new C0103c(i2, d3)};
    }

    public void f() {
    }

    /* compiled from: FilterEffect.java */
    /* loaded from: classes.dex */
    public static class b extends com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.b {

        /* renamed from: c */
        public double f20463c;

        /* renamed from: d */
        public double f20464d;

        /* renamed from: e */
        public double f20465e;

        /* renamed from: f */
        public C0103c[] f20466f;

        /* renamed from: g */
        public a f20467g;

        public b(Effect.EffectParameterId effectParameterId, String str, double d2, double d3, double d4, C0103c[] c0103cArr) {
            this.f20458a = effectParameterId;
            this.f20459b = str;
            this.f20463c = d2;
            this.f20464d = d3;
            this.f20465e = d4;
            this.f20466f = c0103cArr;
        }

        public b(Effect.EffectParameterId effectParameterId, String str, a aVar) {
            this.f20458a = effectParameterId;
            this.f20459b = str;
            this.f20467g = aVar;
        }
    }
}

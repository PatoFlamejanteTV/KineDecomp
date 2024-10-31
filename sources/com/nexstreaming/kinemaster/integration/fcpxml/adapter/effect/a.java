package com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect;

import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.Effect;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.SourceItem;

/* compiled from: ColorMatteEffect.java */
/* loaded from: classes.dex */
public class a extends Effect {

    /* renamed from: f */
    public b f20452f;

    /* compiled from: ColorMatteEffect.java */
    /* renamed from: com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.a$a */
    /* loaded from: classes.dex */
    public static class C0102a {

        /* renamed from: a */
        public long f20453a;

        /* renamed from: b */
        public long f20454b;

        /* renamed from: c */
        public long f20455c;

        /* renamed from: d */
        public long f20456d;

        public C0102a(long j, long j2, long j3, long j4) {
            this.f20453a = j;
            this.f20454b = j2;
            this.f20455c = j3;
            this.f20456d = j4;
        }

        public static C0102a a(String str) {
            if (!str.startsWith("@solid:")) {
                return null;
            }
            long parseLong = Long.parseLong(str.substring(str.indexOf(":") + 1, str.lastIndexOf(".")), 16);
            return new C0102a((parseLong >> 24) & 255, (parseLong >> 16) & 255, (parseLong >> 8) & 255, parseLong & 255);
        }
    }

    /* compiled from: ColorMatteEffect.java */
    /* loaded from: classes.dex */
    public static class b extends com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.b {

        /* renamed from: c */
        public C0102a f20457c;

        public b(Effect.EffectParameterId effectParameterId, String str, C0102a c0102a) {
            this.f20458a = effectParameterId;
            this.f20459b = str;
            this.f20457c = c0102a;
        }
    }

    public a(EffectId effectId, String str, String str2, Effect.EffectType effectType, SourceItem.MediaType mediaType) {
        super(effectId, str, str2, effectType, mediaType);
    }

    public void a(b bVar) {
        this.f20452f = bVar;
    }
}

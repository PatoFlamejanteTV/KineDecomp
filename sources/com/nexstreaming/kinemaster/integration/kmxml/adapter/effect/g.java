package com.nexstreaming.kinemaster.integration.kmxml.adapter.effect;

import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.Effect;
import java.util.ArrayList;

/* compiled from: VolumeEnvEffect.java */
/* loaded from: classes.dex */
public class g extends Effect {

    /* renamed from: b */
    ArrayList<a> f20566b;

    /* compiled from: VolumeEnvEffect.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public float f20567a;

        /* renamed from: b */
        public float f20568b;

        public a(float f2, float f3) {
            this.f20567a = f2;
            this.f20568b = f3;
        }
    }

    public g() {
        super(Effect.EffectType.VOLUMEENV);
        this.f20566b = new ArrayList<>();
    }

    public ArrayList<a> a() {
        return this.f20566b;
    }

    public void a(a aVar) {
        this.f20566b.add(aVar);
    }
}

package com.nexstreaming.kinemaster.integration.fcpxml.adapter.items;

import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.Effect;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.EffectId;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.SourceItem;
import java.util.List;

/* compiled from: TransitionItem.java */
/* loaded from: classes.dex */
public class d extends SourceItem {
    public long r;
    public boolean s;
    public SourceItem.Alignment t;
    public com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.d u;

    /* compiled from: TransitionItem.java */
    /* loaded from: classes.dex */
    public static class a extends SourceItem {
        private long A;
        private boolean B;
        private SourceItem.Alignment r;
        private EffectId s;
        private Effect.EffectType t = Effect.EffectType.transition;
        private SourceItem.MediaType u = SourceItem.MediaType.VIDEO;
        private int v;
        private int w;
        private float x;
        private float y;
        private boolean z;

        public d build() {
            return new d(this);
        }

        public a a(SourceItem.ItemType itemType) {
            this.i = itemType;
            return this;
        }

        public a b(float f2) {
            this.x = f2;
            return this;
        }

        public a c(int i) {
            this.w = i;
            return this;
        }

        public a d(int i) {
            this.v = i;
            return this;
        }

        public a a(int i) {
            this.f20475b = i;
            return this;
        }

        public a b(int i) {
            this.j = i;
            return this;
        }

        public a a(SourceItem.Alignment alignment) {
            this.r = alignment;
            return this;
        }

        public a a(EffectId effectId) {
            this.s = effectId;
            return this;
        }

        public a a(Effect.EffectType effectType) {
            this.t = effectType;
            return this;
        }

        public a a(SourceItem.MediaType mediaType) {
            this.u = mediaType;
            return this;
        }

        public a a(float f2) {
            this.y = f2;
            return this;
        }

        public a a(boolean z) {
            this.z = z;
            return this;
        }

        public a a(long j) {
            this.A = j;
            this.B = this.A != 30;
            return this;
        }
    }

    public d(a aVar) {
        this.i = aVar.i;
        this.t = aVar.r;
        List<String> nameTable = EffectId.getNameTable(aVar.s.getEffectId());
        this.u = new com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.d(aVar.s, nameTable.get(0), nameTable.get(1), aVar.t, aVar.u);
        this.u.a(aVar.v, aVar.w, aVar.x, aVar.y, aVar.z);
        this.f20475b = aVar.f20475b;
        this.f20476c = aVar.f20476c;
        this.f20477d = aVar.f20477d;
        this.f20478e = aVar.f20478e;
        this.f20479f = aVar.f20479f;
        this.r = aVar.A;
        this.s = aVar.B;
        this.j = aVar.j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n================== Transition Info ========================= ");
        sb.append("\n start      : " + this.f20476c);
        sb.append("\n end        : " + this.f20477d);
        sb.append("\n alignment  : " + this.t);
        sb.append("\n effect --------------------------------------------------- ");
        sb.append("\n    name        : " + this.u.d());
        sb.append("\n    id          : " + this.u.c());
        sb.append("\n    category    : " + this.u.b());
        sb.append("\n    type        : " + this.u.a());
        sb.append("\n    media       : " + this.u.e());
        sb.append("\n    wipecode    : " + this.u.i());
        sb.append("\n    wipeaccuracy : " + this.u.h());
        sb.append("\n    startratio  : " + this.u.g());
        sb.append("\n    endratio    : " + this.u.f());
        sb.append("\n    reverse     : " + this.u.j());
        return sb.toString();
    }
}

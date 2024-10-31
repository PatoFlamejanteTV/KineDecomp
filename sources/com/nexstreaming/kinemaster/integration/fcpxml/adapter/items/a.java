package com.nexstreaming.kinemaster.integration.fcpxml.adapter.items;

import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.Effect;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.EffectId;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.SourceItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ClipItem.java */
/* loaded from: classes.dex */
public class a extends SourceItem implements Cloneable {
    public int r;
    public int s;
    public int t;
    public SourceItem.MediaType u;
    public List<c.d.b.d.a.a.e.a> v;
    protected boolean w;
    public List<Effect> x;
    protected boolean y;
    public List<Effect> z;

    /* compiled from: ClipItem.java */
    /* renamed from: com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a$a */
    /* loaded from: classes.dex */
    public static class C0104a extends SourceItem {
        private int r;
        private SourceItem.MediaType s;
        private List<c.d.b.d.a.a.e.a> t;
        public int u;

        public C0104a() {
            this.k = 100;
            this.l = false;
        }

        public a build() {
            return new a(this);
        }

        public C0104a d(int i) {
            this.f20481h = i;
            return this;
        }

        public C0104a e(int i) {
            this.r = i;
            return this;
        }

        public C0104a f(int i) {
            this.f20478e = i;
            return this;
        }

        public C0104a g(int i) {
            this.f20479f = i;
            return this;
        }

        public C0104a h(int i) {
            this.p = i;
            return this;
        }

        public C0104a i(int i) {
            this.f20476c = i;
            return this;
        }

        public C0104a j(int i) {
            this.f20480g = i;
            return this;
        }

        public C0104a k(int i) {
            this.j = i;
            return this;
        }

        public C0104a l(int i) {
            this.k = i;
            return this;
        }

        public C0104a a(String str) {
            this.f20474a = str;
            return this;
        }

        public C0104a b(int i) {
            this.f20475b = i;
            return this;
        }

        public C0104a c(int i) {
            this.f20477d = i;
            return this;
        }

        public C0104a a(SourceItem.ItemType itemType) {
            this.i = itemType;
            return this;
        }

        public C0104a b(boolean z) {
            this.l = z;
            return this;
        }

        public C0104a a(SourceItem.MediaType mediaType) {
            this.s = mediaType;
            return this;
        }

        public C0104a a(List<c.d.b.d.a.a.e.a> list) {
            this.t = list;
            return this;
        }

        public C0104a a(int i) {
            this.u = i;
            return this;
        }

        public C0104a a(double d2) {
            this.n = a.a(d2);
            return this;
        }

        public C0104a a(boolean z) {
            this.m = z;
            return this;
        }

        public C0104a a(SourceItem.OutputChannel outputChannel) {
            this.o = outputChannel;
            return this;
        }

        public C0104a a(b bVar) {
            this.q = bVar;
            return this;
        }
    }

    public a() {
    }

    public static double a(double d2) {
        return d2 / 100.0d;
    }

    public static double b(double d2) {
        return d2 >= 100.0d ? ((d2 - 100.0d) / 100.0d) + 1.0d : d2 / 100.0d;
    }

    public a a(int i, int i2, String str, double d2, SourceItem.OutputChannel outputChannel, List<c.d.b.d.a.a.e.a> list) {
        a a2 = a(i, i2, str, d2, outputChannel);
        if (a2 != null) {
            a2.a(list);
        }
        return a2;
    }

    public boolean b() {
        return this.y;
    }

    public boolean c() {
        return this.w;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nClip Info // ");
        sb.append("\nClip ID    : " + this.s);
        sb.append("\ntrack ID   : " + this.j);
        sb.append("\nFile ID    : " + this.t);
        sb.append("\nMaster ID  : " + this.r);
        sb.append("\nMedia Type : " + this.u.getMediaType());
        sb.append("\nTime(frame) value ------------------------------------");
        sb.append("\n    start    : " + this.f20476c);
        sb.append("\n    end      : " + this.f20477d);
        sb.append("\n    in       : " + this.f20478e);
        sb.append("\n    out      : " + this.f20479f);
        sb.append("\n    mute     : " + this.l);
        sb.append("\n    volume   : " + this.k);
        sb.append("\n    hasPan   : " + this.m);
        sb.append("\n    PanValue : " + this.n);
        List<c.d.b.d.a.a.e.a> list = this.v;
        if (list != null) {
            Iterator<c.d.b.d.a.a.e.a> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
        }
        return sb.toString();
    }

    public a(C0104a c0104a) {
        this.x = new ArrayList();
        this.z = new ArrayList();
        this.i = c0104a.i;
        this.f20475b = c0104a.f20475b;
        this.f20474a = c0104a.f20474a;
        this.f20476c = c0104a.f20476c;
        this.f20477d = c0104a.f20477d;
        this.f20478e = c0104a.f20478e;
        this.f20479f = c0104a.f20479f;
        this.f20480g = c0104a.f20480g;
        this.f20481h = c0104a.f20481h;
        this.t = c0104a.r;
        this.r = c0104a.r;
        this.u = c0104a.s;
        this.v = c0104a.t;
        this.s = c0104a.u;
        this.j = c0104a.j;
        this.k = c0104a.k;
        this.l = c0104a.l;
        a(this.k, this.l, this.z);
        this.n = c0104a.n;
        this.m = c0104a.m;
        if (this.m) {
            a(this.n, this.z);
        }
        this.p = c0104a.p;
        int i = this.p;
        if (i != 0 && i != 100) {
            a();
            a(this.p, this.x, this.z);
        }
        this.o = c0104a.o;
        this.q = c0104a.q;
    }

    @Override // com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.SourceItem
    public a clone() {
        a aVar = new a();
        aVar.w = this.w;
        aVar.x = new ArrayList();
        aVar.y = this.y;
        aVar.z = new ArrayList();
        aVar.r = this.r;
        aVar.s = this.s;
        aVar.t = this.t;
        aVar.u = this.u;
        aVar.f20474a = this.f20474a;
        aVar.f20475b = this.f20475b;
        aVar.f20476c = this.f20476c;
        aVar.f20477d = this.f20477d;
        aVar.f20478e = this.f20478e;
        aVar.f20479f = this.f20479f;
        aVar.f20480g = this.f20480g;
        aVar.f20481h = this.f20481h;
        aVar.i = this.i;
        aVar.j = this.j;
        aVar.k = this.k;
        aVar.l = this.l;
        a(aVar.k, aVar.l, aVar.z);
        aVar.o = this.o;
        aVar.p = this.p;
        int i = aVar.p;
        if (i != 0 && i != 100) {
            aVar.a(i, aVar.x, aVar.z);
        }
        aVar.q = this.q;
        return aVar;
    }

    public a a(int i, int i2, String str, double d2, SourceItem.OutputChannel outputChannel) {
        a clone = clone();
        clone.j = i;
        clone.s = i2;
        clone.f20474a = str;
        if (clone.m) {
            clone.n = d2;
            clone.a(clone.n, clone.z);
        }
        clone.o = outputChannel;
        return clone;
    }

    private void a(int i, boolean z, List<Effect> list) {
        if (z) {
            i = 0;
            if (this.i == SourceItem.ItemType.VISUAL && this.u == SourceItem.MediaType.AUDIO) {
                a(0, list);
            } else {
                SourceItem.ItemType itemType = this.i;
                SourceItem.ItemType itemType2 = SourceItem.ItemType.SOUNDTRACK;
            }
        }
        if (z || i == 100 || this.u != SourceItem.MediaType.AUDIO) {
            return;
        }
        a(i, list);
    }

    public void a(List<c.d.b.d.a.a.e.a> list) {
        this.v = list;
    }

    public static Effect a(EffectId effectId, List<Effect> list) {
        for (Effect effect : list) {
            if (effect.f20448b == effectId) {
                return effect;
            }
        }
        return null;
    }

    public void a(double d2, double d3, c.a aVar, c.a aVar2) {
        com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c cVar;
        com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c cVar2 = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c) a(EffectId.BASIC, this.x);
        if (cVar2 == null) {
            List<String> nameTable = EffectId.getNameTable(EffectId.BASIC.getEffectId());
            cVar = new com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c(EffectId.BASIC, nameTable.get(0), nameTable.get(1), Effect.EffectType.motion, SourceItem.MediaType.VIDEO);
            this.x.add(cVar);
        } else {
            cVar = cVar2;
        }
        if (d2 != -1.0d) {
            cVar.f20460f.add(new c.b(Effect.EffectParameterId.scale, "Scale", 0.0d, 1000.0d, d2, null));
        }
        if (d3 != -1.0d) {
            cVar.f20460f.add(new c.b(Effect.EffectParameterId.rotation, "Rotation", -8640.0d, 8640.0d, d3, null));
        }
        if (aVar != null) {
            cVar.f20460f.add(new c.b(Effect.EffectParameterId.center, "Center", aVar));
        }
        if (aVar2 != null) {
            cVar.f20460f.add(new c.b(Effect.EffectParameterId.centerOffset, "Anchor Point", aVar2));
        }
        this.w = true;
    }

    public void a(int i, int i2, double d2) {
        com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c cVar = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c) a(EffectId.BASIC, this.x);
        if (cVar == null) {
            List<String> nameTable = EffectId.getNameTable(EffectId.BASIC.getEffectId());
            com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c cVar2 = new com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c(EffectId.BASIC, nameTable.get(0), nameTable.get(1), Effect.EffectType.motion, SourceItem.MediaType.VIDEO);
            this.x.add(cVar2);
            cVar = cVar2;
        }
        double parseDouble = Double.parseDouble(String.format("%.2f", Double.valueOf(d2 * 100.0d)));
        double parseDouble2 = Double.parseDouble(String.format("%.2f", Double.valueOf(1.3d * d2 * 100.0d)));
        cVar.f20460f.add(new c.b(Effect.EffectParameterId.scale, "Scale", 0.0d, 1000.0d, parseDouble2, cVar.a(i, parseDouble, i2, parseDouble2)));
        this.w = true;
    }

    public void a(int i, List<Effect> list) {
        com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c cVar = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c) a(EffectId.AUDIOLEVELS, list);
        if (cVar == null) {
            List<String> nameTable = EffectId.getNameTable(EffectId.AUDIOLEVELS.getEffectId());
            com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c cVar2 = new com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c(EffectId.AUDIOLEVELS, nameTable.get(0), nameTable.get(1), Effect.EffectType.audiolevels, SourceItem.MediaType.AUDIO);
            list.add(cVar2);
            cVar = cVar2;
        }
        double b2 = b(i);
        Effect.EffectParameterId effectParameterId = Effect.EffectParameterId.level;
        cVar.f20460f.add(new c.b(effectParameterId, effectParameterId.getParameterName(), 0.0d, 4.0d, b2, null));
        this.y = true;
    }

    public void a(double d2, List<Effect> list) {
        com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c cVar = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c) a(EffectId.AUDIOPAN, list);
        if (cVar == null) {
            List<String> nameTable = EffectId.getNameTable(EffectId.AUDIOPAN.getEffectId());
            com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c cVar2 = new com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c(EffectId.AUDIOPAN, nameTable.get(0), nameTable.get(1), Effect.EffectType.audiopan, SourceItem.MediaType.AUDIO);
            list.add(cVar2);
            cVar = cVar2;
        }
        Effect.EffectParameterId effectParameterId = Effect.EffectParameterId.pan;
        cVar.f20460f.add(new c.b(effectParameterId, effectParameterId.getParameterName(), -1.0d, 1.0d, d2, null));
        this.y = true;
    }

    public void a() {
        int i = this.p;
        if (i == 0 || i == 100) {
            return;
        }
        this.f20477d = (this.f20477d * 100) / i;
    }

    public void a(int i, List<Effect> list, List<Effect> list2) {
        SourceItem.MediaType mediaType = this.u;
        if (mediaType == SourceItem.MediaType.VIDEO) {
            com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c cVar = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c) a(EffectId.TIMEREMAP, list);
            if (cVar == null) {
                List<String> nameTable = EffectId.getNameTable(EffectId.TIMEREMAP.getEffectId());
                com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c cVar2 = new com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c(EffectId.TIMEREMAP, nameTable.get(0), nameTable.get(1), Effect.EffectType.motion, SourceItem.MediaType.VIDEO);
                list.add(cVar2);
                cVar = cVar2;
            }
            Effect.EffectParameterId effectParameterId = Effect.EffectParameterId.speed;
            cVar.f20460f.add(new c.b(effectParameterId, effectParameterId.getParameterName(), -100000.0d, 100000.0d, i, null));
            this.w = true;
            return;
        }
        if (mediaType == SourceItem.MediaType.AUDIO) {
            com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c cVar3 = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c) a(EffectId.TIMEREMAP, list2);
            if (cVar3 == null) {
                List<String> nameTable2 = EffectId.getNameTable(EffectId.TIMEREMAP.getEffectId());
                com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c cVar4 = new com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c(EffectId.TIMEREMAP, nameTable2.get(0), nameTable2.get(1), Effect.EffectType.motion, SourceItem.MediaType.AUDIO);
                list2.add(cVar4);
                cVar3 = cVar4;
            }
            Effect.EffectParameterId effectParameterId2 = Effect.EffectParameterId.speed;
            cVar3.f20460f.add(new c.b(effectParameterId2, effectParameterId2.getParameterName(), -100000.0d, 100000.0d, i, null));
            this.y = true;
        }
    }
}

package com.nexstreaming.kinemaster.integration.kmxml.adapter.layer;

import android.graphics.Rect;
import android.graphics.RectF;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.Effect;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.FlipEffect;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.items.SourceItem;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class LayerItem extends SourceItem {

    /* renamed from: d */
    float f20586d;

    /* renamed from: e */
    float f20587e;

    /* renamed from: f */
    float f20588f;

    /* renamed from: g */
    float f20589g;

    /* renamed from: h */
    d f20590h;
    LayerType i;
    b j;
    float k;
    c.d.b.d.b.a.a.a l;
    c.d.b.d.b.a.c.a m;
    FlipEffect n;
    c o;

    /* loaded from: classes.dex */
    public enum Align {
        CENTER("center"),
        LEFT("left"),
        RIGHT("right");

        private String mode;

        Align(String str) {
            this.mode = str;
        }

        public String getName() {
            return this.mode;
        }
    }

    /* loaded from: classes.dex */
    public enum FillType {
        OFF("off"),
        FILL("fill"),
        EXTEND("extend");

        private String type;

        FillType(String str) {
            this.type = str;
        }

        public String getName() {
            return this.type;
        }
    }

    /* loaded from: classes.dex */
    public enum LayerType {
        VIDEOLAYER("videolayer"),
        IMAGELAYER("imagelayer"),
        TEXTLAYER("textlayer"),
        DRAWINGLAYER("drawinglayer"),
        EFFECTLAYER("effectlayer"),
        OVERLAYLAYER("overlay"),
        SOLIDLAYER("solidlayer");

        private String type;

        LayerType(String str) {
            this.type = str;
        }

        public String getName() {
            return this.type;
        }
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public float f20591a;

        /* renamed from: b */
        public d f20592b;

        public a(float f2, d dVar) {
            this.f20591a = f2;
            this.f20592b = dVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public ArrayList<a> f20593a = new ArrayList<>();

        public void a(a aVar) {
            this.f20593a.add(aVar);
        }

        public ArrayList<a> a() {
            return this.f20593a;
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a */
        public String f20594a;

        /* renamed from: b */
        public Rect f20595b;

        /* renamed from: c */
        public RectF f20596c;

        public c(String str, Rect rect, RectF rectF) {
            this.f20594a = str;
            this.f20595b = rect;
            this.f20596c = rectF;
        }

        public RectF a() {
            return new RectF((this.f20596c.left * 2.0f) / this.f20595b.width(), (this.f20596c.top * 2.0f) / this.f20595b.height(), (this.f20596c.right * 2.0f) / this.f20595b.width(), (this.f20596c.bottom * 2.0f) / this.f20595b.height());
        }

        public boolean b() {
            Rect rect = this.f20595b;
            return (rect == null || this.f20596c == null || !new RectF(rect).equals(this.f20596c)) ? false : true;
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a */
        public int f20597a;

        /* renamed from: b */
        public int f20598b;

        /* renamed from: c */
        public float f20599c;

        /* renamed from: d */
        public float f20600d;

        public d(int i, int i2, float f2, float f3) {
            this.f20597a = i;
            this.f20598b = i2;
            this.f20599c = f2;
            this.f20600d = f3;
        }
    }

    public LayerItem(LayerType layerType, float f2, float f3, float f4) {
        super(SourceItem.ItemType.LAYER, f4);
        this.i = layerType;
        this.f20586d = f2;
        this.f20587e = f3;
        this.f20588f = f4;
        this.j = new b();
    }

    public void a(float f2) {
        this.k = f2;
    }

    public float c() {
        return this.k;
    }

    public c.d.b.d.b.a.c.a d() {
        return this.m;
    }

    public float e() {
        return this.f20587e;
    }

    public b f() {
        return this.j;
    }

    public c g() {
        return this.o;
    }

    public d h() {
        return this.f20590h;
    }

    public c.d.b.d.b.a.a.a i() {
        return this.l;
    }

    public float j() {
        return this.f20589g;
    }

    public float k() {
        return this.f20586d;
    }

    public boolean l() {
        return this.j.f20593a.size() > 0;
    }

    public void a(d dVar) {
        this.f20590h = dVar;
    }

    public void a(a aVar) {
        this.j.a(aVar);
    }

    public void a(c.d.b.d.b.a.c.a aVar) {
        this.m = aVar;
    }

    public void a(FlipEffect flipEffect) {
        this.n = flipEffect;
        a((Effect) flipEffect);
    }

    public void a(c cVar) {
        this.o = cVar;
    }
}

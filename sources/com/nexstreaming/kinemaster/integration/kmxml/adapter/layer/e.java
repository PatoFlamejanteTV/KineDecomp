package com.nexstreaming.kinemaster.integration.kmxml.adapter.layer;

import android.text.Layout;
import com.nexstreaming.app.general.util.C1703g;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.LayerItem;

/* compiled from: TextLayerItem.java */
/* loaded from: classes.dex */
public class e extends LayerItem {
    private a p;
    private String q;

    /* compiled from: TextLayerItem.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public String f20602a;

        /* renamed from: b */
        public String f20603b;

        /* renamed from: c */
        public float f20604c;

        /* renamed from: d */
        public LayerItem.FillType f20605d;

        /* renamed from: e */
        public String f20606e;

        /* renamed from: f */
        public String f20607f;

        /* renamed from: g */
        public boolean f20608g;

        /* renamed from: h */
        public String f20609h;
        public boolean i;
        public String j;
        public boolean k;
        public LayerItem.Align l;

        /* compiled from: TextLayerItem.java */
        /* renamed from: com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.e$a$a */
        /* loaded from: classes.dex */
        public static class C0106a {

            /* renamed from: a */
            private String f20610a;

            /* renamed from: c */
            private float f20612c;

            /* renamed from: b */
            private String f20611b = "#FFFFFFFF";

            /* renamed from: d */
            private LayerItem.FillType f20613d = LayerItem.FillType.OFF;

            /* renamed from: e */
            private String f20614e = "#88000000";

            /* renamed from: f */
            private String f20615f = "#FF000000";

            /* renamed from: g */
            private boolean f20616g = false;

            /* renamed from: h */
            private String f20617h = "#AAFFFFAA";
            private boolean i = false;
            private String j = "#FFCCCCCC";
            private boolean k = false;
            private LayerItem.Align l = LayerItem.Align.CENTER;

            public C0106a a(String str, int i, float f2) {
                this.f20610a = str;
                this.f20611b = C1703g.a(i);
                this.f20612c = f2;
                return this;
            }

            public C0106a b(int i, boolean z) {
                this.j = C1703g.a(i);
                this.k = z;
                return this;
            }

            public C0106a c(int i, boolean z) {
                this.f20615f = C1703g.a(i);
                this.f20616g = z;
                return this;
            }

            public C0106a a(int i, boolean z, boolean z2) {
                this.f20614e = C1703g.a(i);
                if (!z) {
                    this.f20613d = LayerItem.FillType.OFF;
                } else if (z2) {
                    this.f20613d = LayerItem.FillType.EXTEND;
                } else {
                    this.f20613d = LayerItem.FillType.FILL;
                }
                return this;
            }

            public C0106a a(int i, boolean z) {
                this.f20617h = C1703g.a(i);
                this.i = z;
                return this;
            }

            public C0106a a(Layout.Alignment alignment) {
                int i = d.f20601a[alignment.ordinal()];
                if (i == 1) {
                    this.l = LayerItem.Align.RIGHT;
                } else if (i != 2) {
                    this.l = LayerItem.Align.CENTER;
                } else {
                    this.l = LayerItem.Align.LEFT;
                }
                return this;
            }

            public a a() {
                return new a(this);
            }
        }

        public a(C0106a c0106a) {
            this.f20602a = c0106a.f20610a;
            this.f20603b = c0106a.f20611b;
            this.f20604c = c0106a.f20612c;
            this.f20606e = c0106a.f20614e;
            this.f20605d = c0106a.f20613d;
            this.f20607f = c0106a.f20615f;
            this.f20608g = c0106a.f20616g;
            this.f20609h = c0106a.f20617h;
            this.i = c0106a.i;
            this.j = c0106a.j;
            this.k = c0106a.k;
            this.l = c0106a.l;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\nTextStyle ............................. ");
            sb.append("\n\t fontID   : " + this.f20602a);
            return sb.toString();
        }
    }

    public e(float f2, float f3, float f4) {
        super(LayerItem.LayerType.TEXTLAYER, f2, f3, f4);
    }

    public String m() {
        return this.q;
    }

    public a n() {
        return this.p;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n\nTextLayerItem ............................. ");
        sb.append("\n\t mStart    : " + this.f20586d);
        sb.append("\n\t mEnd      : " + this.f20587e);
        sb.append("\n\t mDuration : " + (this.f20587e - this.f20586d));
        sb.append("\n\t content  : " + this.q);
        sb.append(this.p);
        return sb.toString();
    }

    public e(float f2, float f3, float f4, String str, a aVar, LayerItem.d dVar, float f5) {
        this(f2, f3, f4);
        this.p = aVar;
        this.q = str;
        a(dVar);
        a(f5);
    }
}

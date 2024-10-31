package com.google.firebase.inappmessaging.display.internal;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class InAppMessageLayoutConfig {

    /* renamed from: a */
    private Float f17546a;

    /* renamed from: b */
    private Float f17547b;

    /* renamed from: c */
    private Float f17548c;

    /* renamed from: d */
    private Float f17549d;

    /* renamed from: e */
    private Integer f17550e;

    /* renamed from: f */
    private Integer f17551f;

    /* renamed from: g */
    private Integer f17552g;

    /* renamed from: h */
    private Integer f17553h;
    private Integer i;
    private Integer j;
    private Boolean k;
    private Boolean l;
    private Boolean m;

    /* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a */
        private final InAppMessageLayoutConfig f17554a = new InAppMessageLayoutConfig();

        public Builder a(Float f2) {
            this.f17554a.f17548c = f2;
            return this;
        }

        public Builder b(Float f2) {
            this.f17554a.f17549d = f2;
            return this;
        }

        public Builder c(Float f2) {
            this.f17554a.f17546a = f2;
            return this;
        }

        public Builder d(Float f2) {
            this.f17554a.f17547b = f2;
            return this;
        }

        public Builder e(Integer num) {
            this.f17554a.j = num;
            return this;
        }

        public Builder f(Integer num) {
            this.f17554a.i = num;
            return this;
        }

        public Builder a(Integer num) {
            this.f17554a.f17550e = num;
            return this;
        }

        public Builder b(Integer num) {
            this.f17554a.f17551f = num;
            return this;
        }

        public Builder c(Integer num) {
            this.f17554a.f17553h = num;
            return this;
        }

        public Builder d(Integer num) {
            this.f17554a.f17552g = num;
            return this;
        }

        public Builder a(Boolean bool) {
            this.f17554a.l = bool;
            return this;
        }

        public Builder b(Boolean bool) {
            this.f17554a.m = bool;
            return this;
        }

        public Builder c(Boolean bool) {
            this.f17554a.k = bool;
            return this;
        }

        public InAppMessageLayoutConfig a() {
            return this.f17554a;
        }
    }

    public Integer g() {
        return this.f17550e;
    }

    public Integer h() {
        return this.f17551f;
    }

    public Float i() {
        return this.f17546a;
    }

    public Float j() {
        return this.f17547b;
    }

    public Integer k() {
        return this.f17553h;
    }

    public Integer l() {
        return this.f17552g;
    }

    public Integer m() {
        return this.j;
    }

    public Integer n() {
        return this.i;
    }

    public int e() {
        return (int) (i().floatValue() * g().intValue());
    }

    public int f() {
        return (int) (j().floatValue() * h().intValue());
    }

    public static Builder d() {
        return new Builder();
    }

    public Boolean a() {
        return this.l;
    }

    public Boolean b() {
        return this.m;
    }

    public Boolean c() {
        return this.k;
    }
}

package com.google.firebase.inappmessaging.model;

import com.google.firebase.inappmessaging.model.RateLimit;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
final class k extends RateLimit {

    /* renamed from: a */
    private final String f18042a;

    /* renamed from: b */
    private final long f18043b;

    /* renamed from: c */
    private final long f18044c;

    /* synthetic */ k(String str, long j, long j2, j jVar) {
        this(str, j, j2);
    }

    @Override // com.google.firebase.inappmessaging.model.RateLimit
    public long b() {
        return this.f18043b;
    }

    @Override // com.google.firebase.inappmessaging.model.RateLimit
    public String c() {
        return this.f18042a;
    }

    @Override // com.google.firebase.inappmessaging.model.RateLimit
    public long d() {
        return this.f18044c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RateLimit)) {
            return false;
        }
        RateLimit rateLimit = (RateLimit) obj;
        return this.f18042a.equals(rateLimit.c()) && this.f18043b == rateLimit.b() && this.f18044c == rateLimit.d();
    }

    public int hashCode() {
        int hashCode = (this.f18042a.hashCode() ^ 1000003) * 1000003;
        long j = this.f18043b;
        long j2 = this.f18044c;
        return ((hashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "RateLimit{limiterKey=" + this.f18042a + ", limit=" + this.f18043b + ", timeToLiveMillis=" + this.f18044c + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class a extends RateLimit.Builder {

        /* renamed from: a */
        private String f18045a;

        /* renamed from: b */
        private Long f18046b;

        /* renamed from: c */
        private Long f18047c;

        @Override // com.google.firebase.inappmessaging.model.RateLimit.Builder
        public RateLimit.Builder a(String str) {
            if (str != null) {
                this.f18045a = str;
                return this;
            }
            throw new NullPointerException("Null limiterKey");
        }

        @Override // com.google.firebase.inappmessaging.model.RateLimit.Builder
        public RateLimit.Builder b(long j) {
            this.f18047c = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.model.RateLimit.Builder
        public RateLimit.Builder a(long j) {
            this.f18046b = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.model.RateLimit.Builder
        public RateLimit a() {
            String str = "";
            if (this.f18045a == null) {
                str = " limiterKey";
            }
            if (this.f18046b == null) {
                str = str + " limit";
            }
            if (this.f18047c == null) {
                str = str + " timeToLiveMillis";
            }
            if (str.isEmpty()) {
                return new k(this.f18045a, this.f18046b.longValue(), this.f18047c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    private k(String str, long j, long j2) {
        this.f18042a = str;
        this.f18043b = j;
        this.f18044c = j2;
    }
}

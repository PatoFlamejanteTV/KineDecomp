package com.nexstreaming.app.general.iab.b;

/* compiled from: ConnectionResponse.kt */
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a */
    private final int f19442a;

    /* compiled from: ConnectionResponse.kt */
    /* renamed from: com.nexstreaming.app.general.iab.b.a$a */
    /* loaded from: classes2.dex */
    public static final class C0096a extends a {

        /* renamed from: b */
        private final int f19443b;

        public C0096a(int i) {
            super(i, null);
            this.f19443b = i;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof C0096a) {
                    if (this.f19443b == ((C0096a) obj).f19443b) {
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f19443b;
        }

        public String toString() {
            return "ConnectionFailure(billingResponse=" + this.f19443b + ")";
        }
    }

    /* compiled from: ConnectionResponse.kt */
    /* loaded from: classes2.dex */
    public static final class b extends a {

        /* renamed from: b */
        private final int f19444b;

        public b(int i) {
            super(i, null);
            this.f19444b = i;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof b) {
                    if (this.f19444b == ((b) obj).f19444b) {
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f19444b;
        }

        public String toString() {
            return "ConnectionSuccess(billingResponse=" + this.f19444b + ")";
        }
    }

    private a(int i) {
        this.f19442a = i;
    }

    public final int a() {
        return this.f19442a;
    }

    public /* synthetic */ a(int i, kotlin.jvm.internal.f fVar) {
        this(i);
    }
}

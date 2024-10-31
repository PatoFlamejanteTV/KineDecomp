package com.nexstreaming.app.general.iab.b;

/* compiled from: PurchaseResponse.kt */
/* loaded from: classes2.dex */
public abstract class f {

    /* renamed from: a */
    private final int f19464a;

    /* compiled from: PurchaseResponse.kt */
    /* loaded from: classes2.dex */
    public static final class a extends f {

        /* renamed from: b */
        private final int f19465b;

        public a(int i) {
            super(i, null);
            this.f19465b = i;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    if (this.f19465b == ((a) obj).f19465b) {
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f19465b;
        }

        public String toString() {
            return "PurchaseFailure(billingResponse=" + this.f19465b + ")";
        }
    }

    /* compiled from: PurchaseResponse.kt */
    /* loaded from: classes2.dex */
    public static final class b extends f {

        /* renamed from: b */
        private final int f19466b;

        public b(int i) {
            super(i, null);
            this.f19466b = i;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof b) {
                    if (this.f19466b == ((b) obj).f19466b) {
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f19466b;
        }

        public String toString() {
            return "PurchaseSuccess(billingResponse=" + this.f19466b + ")";
        }
    }

    private f(int i) {
        this.f19464a = i;
    }

    public final int a() {
        return this.f19464a;
    }

    public /* synthetic */ f(int i, kotlin.jvm.internal.f fVar) {
        this(i);
    }
}

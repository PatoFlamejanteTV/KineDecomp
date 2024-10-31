package com.nexstreaming.app.general.iab.b;

import kotlin.jvm.internal.h;

/* compiled from: ConsumptionResponse.kt */
/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a */
    private final int f19445a;

    /* renamed from: b */
    private final String f19446b;

    /* compiled from: ConsumptionResponse.kt */
    /* loaded from: classes2.dex */
    public static final class a extends b {

        /* renamed from: c */
        private final int f19447c;

        public a(int i) {
            super(i, null, null);
            this.f19447c = i;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    if (this.f19447c == ((a) obj).f19447c) {
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f19447c;
        }

        public String toString() {
            return "ConsumptionFailure(billingResponse=" + this.f19447c + ")";
        }
    }

    /* compiled from: ConsumptionResponse.kt */
    /* renamed from: com.nexstreaming.app.general.iab.b.b$b */
    /* loaded from: classes2.dex */
    public static final class C0097b extends b {

        /* renamed from: c */
        private final int f19448c;

        /* renamed from: d */
        private final String f19449d;

        public C0097b(int i, String str) {
            super(i, str, null);
            this.f19448c = i;
            this.f19449d = str;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof C0097b) {
                    C0097b c0097b = (C0097b) obj;
                    if (!(this.f19448c == c0097b.f19448c) || !h.a((Object) this.f19449d, (Object) c0097b.f19449d)) {
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.f19448c * 31;
            String str = this.f19449d;
            return i + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "ConsumptionSuccess(billingResponse=" + this.f19448c + ", outputToken=" + this.f19449d + ")";
        }
    }

    private b(int i, String str) {
        this.f19445a = i;
        this.f19446b = str;
    }

    public final int a() {
        return this.f19445a;
    }

    public /* synthetic */ b(int i, String str, kotlin.jvm.internal.f fVar) {
        this(i, str);
    }
}

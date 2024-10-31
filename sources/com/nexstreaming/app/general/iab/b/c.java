package com.nexstreaming.app.general.iab.b;

import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.h;

/* compiled from: ItemsForPurchaseResponse.kt */
/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a */
    private final int f19450a;

    /* renamed from: b */
    private final LinkedHashMap<IABConstant.SKUType, List<Purchase>> f19451b;

    /* compiled from: ItemsForPurchaseResponse.kt */
    /* loaded from: classes2.dex */
    public static final class a extends c {

        /* renamed from: c */
        private final int f19452c;

        public a(int i) {
            super(i, null, 2, null);
            this.f19452c = i;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    if (this.f19452c == ((a) obj).f19452c) {
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f19452c;
        }

        public String toString() {
            return "ItemsForPurchaseFailure(billingResponse=" + this.f19452c + ")";
        }
    }

    /* compiled from: ItemsForPurchaseResponse.kt */
    /* loaded from: classes2.dex */
    public static final class b extends c {

        /* renamed from: c */
        private final int f19453c;

        /* renamed from: d */
        private final LinkedHashMap<IABConstant.SKUType, List<Purchase>> f19454d;

        public b(int i, LinkedHashMap<IABConstant.SKUType, List<Purchase>> linkedHashMap) {
            super(i, linkedHashMap, null);
            this.f19453c = i;
            this.f19454d = linkedHashMap;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (!(this.f19453c == bVar.f19453c) || !h.a(this.f19454d, bVar.f19454d)) {
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.f19453c * 31;
            LinkedHashMap<IABConstant.SKUType, List<Purchase>> linkedHashMap = this.f19454d;
            return i + (linkedHashMap != null ? linkedHashMap.hashCode() : 0);
        }

        public String toString() {
            return "ItemsForPurchaseSuccess(billingResponse=" + this.f19453c + ", items=" + this.f19454d + ")";
        }
    }

    private c(int i, LinkedHashMap<IABConstant.SKUType, List<Purchase>> linkedHashMap) {
        this.f19450a = i;
        this.f19451b = linkedHashMap;
    }

    public final int a() {
        return this.f19450a;
    }

    public final LinkedHashMap<IABConstant.SKUType, List<Purchase>> b() {
        return this.f19451b;
    }

    public /* synthetic */ c(int i, LinkedHashMap linkedHashMap, kotlin.jvm.internal.f fVar) {
        this(i, linkedHashMap);
    }

    /* synthetic */ c(int i, LinkedHashMap linkedHashMap, int i2, kotlin.jvm.internal.f fVar) {
        this(i, (i2 & 2) != 0 ? null : linkedHashMap);
    }
}

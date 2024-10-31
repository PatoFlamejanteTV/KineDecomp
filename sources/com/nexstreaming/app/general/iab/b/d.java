package com.nexstreaming.app.general.iab.b;

import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.h;

/* compiled from: ItemsForSkuResponse.kt */
/* loaded from: classes2.dex */
public abstract class d {

    /* renamed from: a */
    private final int f19455a;

    /* renamed from: b */
    private final LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> f19456b;

    /* compiled from: ItemsForSkuResponse.kt */
    /* loaded from: classes2.dex */
    public static final class a extends d {

        /* renamed from: c */
        private final int f19457c;

        public a(int i) {
            super(i, null, 2, null);
            this.f19457c = i;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    if (this.f19457c == ((a) obj).f19457c) {
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f19457c;
        }

        public String toString() {
            return "ItemsForSkuFailure(billingResponse=" + this.f19457c + ")";
        }
    }

    /* compiled from: ItemsForSkuResponse.kt */
    /* loaded from: classes2.dex */
    public static final class b extends d {

        /* renamed from: c */
        private final int f19458c;

        /* renamed from: d */
        private final LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> f19459d;

        public b(int i, LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> linkedHashMap) {
            super(i, linkedHashMap, null);
            this.f19458c = i;
            this.f19459d = linkedHashMap;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (!(this.f19458c == bVar.f19458c) || !h.a(this.f19459d, bVar.f19459d)) {
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.f19458c * 31;
            LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> linkedHashMap = this.f19459d;
            return i + (linkedHashMap != null ? linkedHashMap.hashCode() : 0);
        }

        public String toString() {
            return "ItemsForSkuSuccess(billingResponse=" + this.f19458c + ", items=" + this.f19459d + ")";
        }
    }

    private d(int i, LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> linkedHashMap) {
        this.f19455a = i;
        this.f19456b = linkedHashMap;
    }

    public final int a() {
        return this.f19455a;
    }

    public final LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> b() {
        return this.f19456b;
    }

    public /* synthetic */ d(int i, LinkedHashMap linkedHashMap, kotlin.jvm.internal.f fVar) {
        this(i, linkedHashMap);
    }

    /* synthetic */ d(int i, LinkedHashMap linkedHashMap, int i2, kotlin.jvm.internal.f fVar) {
        this(i, (i2 & 2) != 0 ? null : linkedHashMap);
    }
}

package com.nexstreaming.app.general.iab.b;

import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import java.util.List;
import kotlin.jvm.internal.h;

/* compiled from: ItemsForStoreResponse.kt */
/* loaded from: classes2.dex */
public abstract class e {

    /* renamed from: a */
    private final int f19460a;

    /* renamed from: b */
    private final List<InterfaceC1821j> f19461b;

    /* compiled from: ItemsForStoreResponse.kt */
    /* loaded from: classes2.dex */
    public static final class a extends e {

        /* renamed from: c */
        private final int f19462c;

        /* renamed from: d */
        private final List<InterfaceC1821j> f19463d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(int i, List<? extends InterfaceC1821j> list) {
            super(i, list, null);
            this.f19462c = i;
            this.f19463d = list;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (!(this.f19462c == aVar.f19462c) || !h.a(this.f19463d, aVar.f19463d)) {
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.f19462c * 31;
            List<InterfaceC1821j> list = this.f19463d;
            return i + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "ItemsForStoreSuccess(billingResponse=" + this.f19462c + ", items=" + this.f19463d + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private e(int i, List<? extends InterfaceC1821j> list) {
        this.f19460a = i;
        this.f19461b = list;
    }

    public final List<InterfaceC1821j> a() {
        return this.f19461b;
    }

    public final int b() {
        return this.f19460a;
    }

    public /* synthetic */ e(int i, List list, kotlin.jvm.internal.f fVar) {
        this(i, list);
    }
}

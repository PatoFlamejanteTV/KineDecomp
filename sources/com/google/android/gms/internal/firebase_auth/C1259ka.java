package com.google.android.gms.internal.firebase_auth;

import java.util.ArrayDeque;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase_auth.ka */
/* loaded from: classes2.dex */
public final class C1259ka {

    /* renamed from: a */
    private final ArrayDeque<zzeh> f13041a;

    private C1259ka() {
        this.f13041a = new ArrayDeque<>();
    }

    public final zzeh a(zzeh zzehVar, zzeh zzehVar2) {
        a(zzehVar);
        a(zzehVar2);
        zzeh pop = this.f13041a.pop();
        while (!this.f13041a.isEmpty()) {
            pop = new zzhs(this.f13041a.pop(), pop, null);
        }
        return pop;
    }

    public /* synthetic */ C1259ka(C1257ja c1257ja) {
        this();
    }

    private final void a(zzeh zzehVar) {
        int[] iArr;
        int[] iArr2;
        C1257ja c1257ja;
        int[] iArr3;
        zzeh zzehVar2;
        while (!zzehVar.zzfd()) {
            if (zzehVar instanceof zzhs) {
                zzhs zzhsVar = (zzhs) zzehVar;
                zzehVar2 = zzhsVar.zzaak;
                a(zzehVar2);
                zzehVar = zzhsVar.zzaal;
            } else {
                String valueOf = String.valueOf(zzehVar.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        int a2 = a(zzehVar.size());
        iArr = zzhs.f13113a;
        int i = iArr[a2 + 1];
        if (!this.f13041a.isEmpty() && this.f13041a.peek().size() < i) {
            iArr2 = zzhs.f13113a;
            int i2 = iArr2[a2];
            zzeh pop = this.f13041a.pop();
            while (true) {
                c1257ja = null;
                if (this.f13041a.isEmpty() || this.f13041a.peek().size() >= i2) {
                    break;
                } else {
                    pop = new zzhs(this.f13041a.pop(), pop, c1257ja);
                }
            }
            zzhs zzhsVar2 = new zzhs(pop, zzehVar, c1257ja);
            while (!this.f13041a.isEmpty()) {
                int a3 = a(zzhsVar2.size());
                iArr3 = zzhs.f13113a;
                if (this.f13041a.peek().size() >= iArr3[a3 + 1]) {
                    break;
                } else {
                    zzhsVar2 = new zzhs(this.f13041a.pop(), zzhsVar2, c1257ja);
                }
            }
            this.f13041a.push(zzhsVar2);
            return;
        }
        this.f13041a.push(zzehVar);
    }

    private static int a(int i) {
        int[] iArr;
        iArr = zzhs.f13113a;
        int binarySearch = Arrays.binarySearch(iArr, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    public static /* synthetic */ zzeh a(C1259ka c1259ka, zzeh zzehVar, zzeh zzehVar2) {
        return c1259ka.a(zzehVar, zzehVar2);
    }
}

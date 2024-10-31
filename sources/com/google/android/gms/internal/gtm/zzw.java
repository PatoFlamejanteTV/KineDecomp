package com.google.android.gms.internal.gtm;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzw extends com.google.android.gms.analytics.zzi<zzw> {
    private ProductAction zzrx;
    private final List<Product> zzsa = new ArrayList();
    private final List<Promotion> zzrz = new ArrayList();
    private final Map<String, List<Product>> zzry = new HashMap();

    public final String toString() {
        HashMap hashMap = new HashMap();
        if (!this.zzsa.isEmpty()) {
            hashMap.put("products", this.zzsa);
        }
        if (!this.zzrz.isEmpty()) {
            hashMap.put("promotions", this.zzrz);
        }
        if (!this.zzry.isEmpty()) {
            hashMap.put("impressions", this.zzry);
        }
        hashMap.put("productAction", this.zzrx);
        return com.google.android.gms.analytics.zzi.zza((Object) hashMap);
    }

    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzw zzwVar) {
        zzw zzwVar2 = zzwVar;
        zzwVar2.zzsa.addAll(this.zzsa);
        zzwVar2.zzrz.addAll(this.zzrz);
        for (Map.Entry<String, List<Product>> entry : this.zzry.entrySet()) {
            String key = entry.getKey();
            for (Product product : entry.getValue()) {
                if (product != null) {
                    String str = key == null ? "" : key;
                    if (!zzwVar2.zzry.containsKey(str)) {
                        zzwVar2.zzry.put(str, new ArrayList());
                    }
                    zzwVar2.zzry.get(str).add(product);
                }
            }
        }
        ProductAction productAction = this.zzrx;
        if (productAction != null) {
            zzwVar2.zzrx = productAction;
        }
    }

    public final ProductAction zzbn() {
        return this.zzrx;
    }

    public final List<Product> zzbo() {
        return Collections.unmodifiableList(this.zzsa);
    }

    public final Map<String, List<Product>> zzbp() {
        return this.zzry;
    }

    public final List<Promotion> zzbq() {
        return Collections.unmodifiableList(this.zzrz);
    }
}

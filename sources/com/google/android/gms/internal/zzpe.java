package com.google.android.gms.internal;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzpe extends com.google.android.gms.measurement.zze<zzpe> {
    private ProductAction zzLI;
    private final List<Product> zzLL = new ArrayList();
    private final List<Promotion> zzLK = new ArrayList();
    private final Map<String, List<Product>> zzLJ = new HashMap();

    public String toString() {
        HashMap hashMap = new HashMap();
        if (!this.zzLL.isEmpty()) {
            hashMap.put("products", this.zzLL);
        }
        if (!this.zzLK.isEmpty()) {
            hashMap.put("promotions", this.zzLK);
        }
        if (!this.zzLJ.isEmpty()) {
            hashMap.put("impressions", this.zzLJ);
        }
        hashMap.put("productAction", this.zzLI);
        return zzB(hashMap);
    }

    public void zza(Product product, String str) {
        if (product == null) {
            return;
        }
        if (str == null) {
            str = "";
        }
        if (!this.zzLJ.containsKey(str)) {
            this.zzLJ.put(str, new ArrayList());
        }
        this.zzLJ.get(str).add(product);
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzpe zzpeVar) {
        zzpeVar.zzLL.addAll(this.zzLL);
        zzpeVar.zzLK.addAll(this.zzLK);
        for (Map.Entry<String, List<Product>> entry : this.zzLJ.entrySet()) {
            String key = entry.getKey();
            Iterator<Product> it = entry.getValue().iterator();
            while (it.hasNext()) {
                zzpeVar.zza(it.next(), key);
            }
        }
        if (this.zzLI != null) {
            zzpeVar.zzLI = this.zzLI;
        }
    }

    public ProductAction zzyF() {
        return this.zzLI;
    }

    public List<Product> zzyG() {
        return Collections.unmodifiableList(this.zzLL);
    }

    public Map<String, List<Product>> zzyH() {
        return this.zzLJ;
    }

    public List<Promotion> zzyI() {
        return Collections.unmodifiableList(this.zzLK);
    }
}

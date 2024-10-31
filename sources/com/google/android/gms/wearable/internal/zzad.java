package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class zzad implements DataItem {

    /* renamed from: a, reason: collision with root package name */
    private Uri f2382a;
    private byte[] b;
    private Map<String, DataItemAsset> c;

    public zzad(DataItem dataItem) {
        this.f2382a = dataItem.b();
        this.b = dataItem.c();
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, DataItemAsset> entry : dataItem.d().entrySet()) {
            if (entry.getKey() != null) {
                hashMap.put(entry.getKey(), entry.getValue().a());
            }
        }
        this.c = Collections.unmodifiableMap(hashMap);
    }

    public String a(boolean z) {
        StringBuilder sb = new StringBuilder("DataItemEntity{ ");
        sb.append("uri=" + this.f2382a);
        sb.append(", dataSz=" + (this.b == null ? "null" : Integer.valueOf(this.b.length)));
        sb.append(", numAssets=" + this.c.size());
        if (z && !this.c.isEmpty()) {
            sb.append(", assets=[");
            String str = "";
            Iterator<Map.Entry<String, DataItemAsset>> it = this.c.entrySet().iterator();
            while (true) {
                String str2 = str;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, DataItemAsset> next = it.next();
                sb.append(str2 + next.getKey() + ": " + next.getValue().b());
                str = ", ";
            }
            sb.append("]");
        }
        sb.append(" }");
        return sb.toString();
    }

    @Override // com.google.android.gms.wearable.DataItem
    public Uri b() {
        return this.f2382a;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public byte[] c() {
        return this.b;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public Map<String, DataItemAsset> d() {
        return this.c;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public DataItem a() {
        return this;
    }

    public String toString() {
        return a(Log.isLoggable("DataItem", 3));
    }
}

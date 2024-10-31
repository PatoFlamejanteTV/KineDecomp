package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzaf extends com.google.android.gms.common.data.zzc implements DataItem {
    private final int c;

    public zzaf(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.c = i2;
    }

    public String a(boolean z) {
        byte[] c = c();
        Map<String, DataItemAsset> d = d();
        StringBuilder sb = new StringBuilder("DataItemInternal{ ");
        sb.append("uri=" + b());
        sb.append(", dataSz=" + (c == null ? "null" : Integer.valueOf(c.length)));
        sb.append(", numAssets=" + d.size());
        if (z && !d.isEmpty()) {
            sb.append(", assets=[");
            String str = "";
            Iterator<Map.Entry<String, DataItemAsset>> it = d.entrySet().iterator();
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
        return Uri.parse(e("path"));
    }

    @Override // com.google.android.gms.wearable.DataItem
    public byte[] c() {
        return g(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    @Override // com.google.android.gms.wearable.DataItem
    public Map<String, DataItemAsset> d() {
        HashMap hashMap = new HashMap(this.c);
        for (int i = 0; i < this.c; i++) {
            zzac zzacVar = new zzac(this.a_, this.b_ + i);
            if (zzacVar.c() != null) {
                hashMap.put(zzacVar.c(), zzacVar);
            }
        }
        return hashMap;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public DataItem a() {
        return new zzad(this);
    }

    public String toString() {
        return a(Log.isLoggable("DataItem", 3));
    }
}

package com.adobe.creativesdk.foundation.internal.cache;

import java.util.Comparator;
import java.util.Map;

/* compiled from: AdobeCommonCacheInstance.java */
/* loaded from: classes.dex */
public class i implements Comparator<Map.Entry<String, Long>> {

    /* renamed from: a */
    final /* synthetic */ o f4965a;

    public i(o oVar) {
        this.f4965a = oVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
        return entry2.getValue().compareTo(entry.getValue());
    }
}

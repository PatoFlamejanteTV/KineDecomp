package com.adobe.creativesdk.foundation.internal.cache;

import java.util.Comparator;
import java.util.Map;

/* compiled from: AdobeCommonCacheInstance.java */
/* loaded from: classes.dex */
public class h implements Comparator<Map.Entry<String, Long>> {

    /* renamed from: a */
    final /* synthetic */ o f4964a;

    public h(o oVar) {
        this.f4964a = oVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
        return entry.getValue().compareTo(entry2.getValue());
    }
}

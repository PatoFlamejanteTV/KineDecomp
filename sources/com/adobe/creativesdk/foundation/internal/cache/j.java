package com.adobe.creativesdk.foundation.internal.cache;

import java.util.Comparator;
import java.util.Date;

/* compiled from: AdobeCommonCacheInstance.java */
/* loaded from: classes.dex */
public class j implements Comparator<Date> {

    /* renamed from: a */
    final /* synthetic */ o f4966a;

    public j(o oVar) {
        this.f4966a = oVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Date date, Date date2) {
        return (int) (date.getTime() - date2.getTime());
    }
}

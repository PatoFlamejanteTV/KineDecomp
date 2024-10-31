package com.adobe.creativesdk.foundation.internal.utils.photoview.c;

import android.annotation.TargetApi;
import android.content.Context;

/* compiled from: IcsScroller.java */
@TargetApi(14)
/* loaded from: classes.dex */
public class b extends a {
    public b(Context context) {
        super(context);
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.c.a, com.adobe.creativesdk.foundation.internal.utils.photoview.c.d
    public boolean a() {
        return this.f6892a.computeScrollOffset();
    }
}

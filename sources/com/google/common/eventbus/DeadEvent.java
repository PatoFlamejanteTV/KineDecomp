package com.google.common.eventbus;

import android.support.v4.app.NotificationCompat;
import com.facebook.share.internal.ShareConstants;
import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;

@Beta
/* loaded from: classes2.dex */
public class DeadEvent {

    /* renamed from: a */
    private final Object f15897a;

    /* renamed from: b */
    private final Object f15898b;

    public String toString() {
        return MoreObjects.a(this).a(ShareConstants.FEED_SOURCE_PARAM, this.f15897a).a(NotificationCompat.CATEGORY_EVENT, this.f15898b).toString();
    }
}

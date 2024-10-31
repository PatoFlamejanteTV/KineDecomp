package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* compiled from: EventBlackList.java */
/* loaded from: classes3.dex */
public class a extends EventList {

    /* renamed from: a */
    private d f25791a;

    /* renamed from: b */
    private Object f25792b;

    public a(String str, String str2) {
        super(str, str2);
        this.f25792b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    protected void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f25792b) {
            this.f25791a = null;
            this.f25791a = new d(false, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean a2;
        if (TextUtils.isEmpty(this.mEventList)) {
            return false;
        }
        synchronized (this.f25792b) {
            if (this.f25791a == null) {
                this.f25791a = new d(false, this.mEventList);
            }
            a2 = this.f25791a.a(str);
        }
        return a2;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z) {
        AnalyticsConfig.CLEAR_EKV_BL = z;
    }
}

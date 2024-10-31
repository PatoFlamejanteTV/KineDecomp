package com.nexstreaming.kinemaster.ad.providers.tencent;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import com.nexstreaming.kinemaster.ad.g;
import com.umeng.analytics.pro.b;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* compiled from: TencentAdProvider.kt */
/* loaded from: classes.dex */
public class TencentAdProvider implements g {
    private final Context context;
    public static final Companion Companion = new Companion(null);
    private static final String APPID = APPID;
    private static final String APPID = APPID;
    private static final String PG_UNIT_ID = PG_UNIT_ID;
    private static final String PG_UNIT_ID = PG_UNIT_ID;
    private static final String SF_UNIT_ID = SF_UNIT_ID;
    private static final String SF_UNIT_ID = SF_UNIT_ID;
    private static final String ES_UNIT_ID = ES_UNIT_ID;
    private static final String ES_UNIT_ID = ES_UNIT_ID;
    private static final String PE_UNIT_ID = PE_UNIT_ID;
    private static final String PE_UNIT_ID = PE_UNIT_ID;
    private static final String SP_UNIT_ID = SP_UNIT_ID;
    private static final String SP_UNIT_ID = SP_UNIT_ID;

    /* compiled from: TencentAdProvider.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final String getAPPID() {
            return TencentAdProvider.APPID;
        }

        public final String getES_UNIT_ID() {
            return TencentAdProvider.ES_UNIT_ID;
        }

        public final String getPE_UNIT_ID() {
            return TencentAdProvider.PE_UNIT_ID;
        }

        public final String getPG_UNIT_ID() {
            return TencentAdProvider.PG_UNIT_ID;
        }

        public final String getSF_UNIT_ID() {
            return TencentAdProvider.SF_UNIT_ID;
        }

        public final String getSP_UNIT_ID() {
            return TencentAdProvider.SP_UNIT_ID;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public TencentAdProvider(Context context) {
        h.b(context, b.Q);
        this.context = context;
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public void addListener(g.a aVar) {
        h.b(aVar, "listener");
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public void clearAd() {
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public String getId() {
        String simpleName = TencentAdProvider.class.getSimpleName();
        h.a((Object) simpleName, "TencentAdProvider::class.java.simpleName");
        return simpleName;
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public String getUnitId() {
        return APPID;
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public boolean isOpened() {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public boolean isReady() {
        return false;
    }

    public void onLoadAd() {
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public void removeListener(g.a aVar) {
        h.b(aVar, "listener");
    }

    public void requestCustomAd() {
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public void requestCustomInstallAd() {
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public void requestTriggerAd() {
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public void showAd(AppCompatActivity appCompatActivity) {
        h.b(appCompatActivity, "callerActivity");
    }

    public void showAd(AppCompatActivity appCompatActivity, int i, int i2) {
        h.b(appCompatActivity, "callerActivity");
    }

    @Override // com.nexstreaming.kinemaster.ad.g
    public void showDialogAd(AppCompatActivity appCompatActivity, int i, int i2) {
        h.b(appCompatActivity, "callerActivity");
    }
}

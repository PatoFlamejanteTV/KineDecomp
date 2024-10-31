package com.adobe.creativesdk.foundation.internal.analytics;

import com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIMSEnvironment;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.internal.utils.w;
import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.y;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AdobeAnalyticsETSJob extends Job {
    public static final int PRIORITY = 1;
    private String eventJSON;
    int retryCount;
    int sendStatus;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AdobeAnalyticsETSJob(java.lang.String r3) {
        /*
            r2 = this;
            com.birbit.android.jobqueue.w r0 = new com.birbit.android.jobqueue.w
            r1 = 1
            r0.<init>(r1)
            r0.h()
            r2.<init>(r0)
            r0 = 0
            r2.eventJSON = r0
            r0 = 0
            r2.sendStatus = r0
            r2.retryCount = r0
            r2.eventJSON = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.analytics.AdobeAnalyticsETSJob.<init>(java.lang.String):void");
    }

    @Override // com.birbit.android.jobqueue.Job
    public void onAdded() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.birbit.android.jobqueue.Job
    public void onCancel(int i, Throwable th) {
    }

    @Override // com.birbit.android.jobqueue.Job
    public void onRun() throws Throwable {
        this.retryCount++;
        com.adobe.creativesdk.foundation.internal.net.l a2 = n.a().a(this.eventJSON);
        if (a2 != null) {
            this.sendStatus = a2.g();
            if (this.sendStatus == 400) {
                try {
                    com.adobe.creativesdk.foundation.adobeinternal.analytics.a aVar = new com.adobe.creativesdk.foundation.adobeinternal.analytics.a("app.project_error");
                    aVar.a(AdobeAnalyticsEventParams.Core.AdobeEventPropertyErrorDescription, this.eventJSON);
                    JSONObject jSONObject = new JSONObject(this.eventJSON);
                    jSONObject.put("project", "csdkandroid-service");
                    jSONObject.put("time", w.c());
                    jSONObject.put("ingesttype", "dunamis");
                    if (AdobeAuthIdentityManagementService.K().w() == AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentProductionUS) {
                        jSONObject.put("environment", "prod");
                    } else {
                        jSONObject.put("environment", "stage");
                    }
                    jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_DATA, new JSONObject(aVar.f4730c));
                    n.a().a(this.eventJSON);
                } catch (Exception e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, AdobeAnalyticsETSJob.class.getSimpleName(), e2.getMessage());
                }
            }
        }
    }

    @Override // com.birbit.android.jobqueue.Job
    protected y shouldReRunOnThrowable(Throwable th, int i, int i2) {
        int i3 = this.sendStatus;
        if ((i3 == 404 || i3 == 500) && this.retryCount < 3) {
            return new y(true);
        }
        return new y(false);
    }
}

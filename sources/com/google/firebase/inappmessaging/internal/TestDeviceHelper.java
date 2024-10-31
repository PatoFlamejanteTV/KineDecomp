package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import java.util.Iterator;
import javax.inject.Inject;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class TestDeviceHelper {

    /* renamed from: a */
    private final SharedPreferencesUtils f17836a;

    /* renamed from: d */
    private int f17839d = 0;

    /* renamed from: c */
    private boolean f17838c = c();

    /* renamed from: b */
    private boolean f17837b = d();

    @Inject
    public TestDeviceHelper(SharedPreferencesUtils sharedPreferencesUtils) {
        this.f17836a = sharedPreferencesUtils;
    }

    private boolean c() {
        return this.f17836a.a("fresh_install", true);
    }

    private boolean d() {
        return this.f17836a.a("test_device", false);
    }

    private void e() {
        if (this.f17838c) {
            this.f17839d++;
            if (this.f17839d >= 5) {
                a(false);
            }
        }
    }

    public boolean a() {
        return this.f17838c;
    }

    public boolean b() {
        return this.f17837b;
    }

    private void b(boolean z) {
        this.f17837b = z;
        this.f17836a.d("test_device", z);
    }

    public void a(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        if (this.f17837b) {
            return;
        }
        e();
        Iterator<CampaignProto.ThickContent> it = fetchEligibleCampaignsResponse.p().iterator();
        while (it.hasNext()) {
            if (it.next().o()) {
                b(true);
                Logging.c("Setting this device as a test device");
                return;
            }
        }
    }

    private void a(boolean z) {
        this.f17838c = z;
        this.f17836a.d("fresh_install", z);
    }
}

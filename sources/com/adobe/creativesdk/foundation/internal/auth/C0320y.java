package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.Calendar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAuthIdentityManagementService.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0320y implements Z {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeAuthIdentityManagementService.TokenType f4930a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeAuthIdentityManagementService f4931b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0320y(AdobeAuthIdentityManagementService adobeAuthIdentityManagementService, AdobeAuthIdentityManagementService.TokenType tokenType) {
        this.f4931b = adobeAuthIdentityManagementService;
        this.f4930a = tokenType;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        try {
            String a2 = new com.adobe.creativesdk.foundation.internal.utils.k(lVar.d()).a("expires_at");
            if (a2 == null) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", this.f4930a + " Expiry time is null");
                return;
            }
            long parseLong = Long.parseLong(a2);
            Calendar calendar = Calendar.getInstance();
            calendar.add(13, (int) (parseLong / 1000));
            calendar.add(14, (int) (parseLong % 1000));
            this.f4931b.a(this.f4930a, calendar.getTime());
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AuthIMS", this.f4930a + " Error parsing expiration date", e2);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.Z
    public void b() {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", this.f4930a + " Invalid client secret.");
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.Z
    public void c() {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", this.f4930a + " Invalid client id.");
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", this.f4930a + " Network error while getting token expiration time.");
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.Z
    public void a() {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AuthIMS", this.f4930a + " Invalid device id.");
    }
}

package com.adobe.creativesdk.foundation.internal.storage.a.b;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageAsyncResponseHandler.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.a.b.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0331a implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f5370a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f5371b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Handler f5372c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0332b f5373d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0331a(C0332b c0332b, long j, String str, Handler handler) {
        this.f5373d = c0332b;
        this.f5370a = j;
        this.f5371b = str;
        this.f5372c = handler;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        int g2 = lVar.g();
        if (g2 != 200) {
            if (g2 != 202) {
                return;
            }
            try {
                Thread.sleep(this.f5370a);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            this.f5373d.a(this.f5371b, this.f5370a, this.f5372c);
            return;
        }
        String d2 = lVar.d();
        Matcher matcher = Pattern.compile("^([0-9]+)").matcher(d2.substring(d2.indexOf(" ") + 1));
        if (matcher.find()) {
            int i = 0;
            try {
                i = Integer.parseInt(matcher.group(0));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            if (i != 200 && i != 201) {
                this.f5373d.f5378b.b(lVar);
                return;
            } else {
                this.f5373d.f5378b.a(lVar);
                return;
            }
        }
        this.f5373d.f5378b.b(lVar);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f5373d.f5378b.a(adobeNetworkException);
    }
}

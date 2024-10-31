package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import java.text.ParseException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXSyncGroupMonitor.java */
/* loaded from: classes.dex */
public class Va implements com.adobe.creativesdk.foundation.internal.storage.a.b.ta {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4256a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ya f4257b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Va(Ya ya, String str) {
        this.f4257b = ya;
        this.f4256a = str;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ta
    public void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar) {
        boolean a2;
        this.f4257b.j.lock();
        if (!Za.a(this.f4257b.i, this.f4256a)) {
            this.f4257b.j.unlock();
            return;
        }
        Ya ya = this.f4257b;
        ya.f4285g = null;
        if (eVar == null) {
            ya.d();
            return;
        }
        if (eVar.m()) {
            try {
                a2 = this.f4257b.a(eVar, this.f4256a);
                if (a2) {
                    this.f4257b.d();
                    return;
                }
                return;
            } catch (AdobeDCXException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXSyncGroupMonitor.requestSyncGroupAssetsWithUpdateId", e2.getMessage(), e2);
                return;
            } catch (InterruptedException e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXSyncGroupMonitor.requestSyncGroupAssetsWithUpdateId", e3.getMessage(), e3);
                return;
            } catch (ParseException e4) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXSyncGroupMonitor.requestSyncGroupAssetsWithUpdateId", e4.getMessage(), e4);
                return;
            }
        }
        this.f4257b.a(this.f4256a, true, false);
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        this.f4257b.j.lock();
        if (!Za.a(this.f4257b.i, this.f4256a)) {
            this.f4257b.j.unlock();
            return;
        }
        Ya ya = this.f4257b;
        ya.f4285g = null;
        ya.d();
    }
}

package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryComposite.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.gb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0559gb implements c.a.a.a.c<AdobeNetworkException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f7261a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0622wb f7262b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f7263c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7264d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Handler f7265e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f7266f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ C0614ub f7267g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0559gb(C0614ub c0614ub, boolean z, C0622wb c0622wb, c.a.a.a.b bVar, c.a.a.a.c cVar, Handler handler, String str) {
        this.f7267g = c0614ub;
        this.f7261a = z;
        this.f7262b = c0622wb;
        this.f7263c = bVar;
        this.f7264d = cVar;
        this.f7265e = handler;
        this.f7266f = str;
    }

    @Override // c.a.a.a.c
    public void a(AdobeNetworkException adobeNetworkException) {
        Exception f2;
        Hb hb;
        com.adobe.creativesdk.foundation.internal.net.l lVar = (com.adobe.creativesdk.foundation.internal.net.l) adobeNetworkException.getData().get(AdobeNetworkException.getKeyForResponse());
        if (com.adobe.creativesdk.foundation.internal.storage.a.a.b.a(lVar)) {
            int g2 = lVar.g();
            if (g2 == 400 || g2 == 403) {
                if (this.f7261a) {
                    Iterator<Hb> it = this.f7267g.d(this.f7262b).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            hb = null;
                            break;
                        }
                        hb = it.next();
                        if (hb.j().equals("rendition") && hb.o()) {
                            break;
                        }
                    }
                    if (hb != null && this.f7267g.a(hb, this.f7263c, this.f7264d, this.f7265e)) {
                        return;
                    }
                }
                f2 = lVar.f();
            } else {
                f2 = null;
            }
            JSONObject b2 = this.f7267g.b(this.f7262b.c());
            StringBuilder sb = new StringBuilder();
            sb.append("ERROR");
            sb.append(f2 != null ? f2.toString() : "");
            try {
                b2.put(this.f7266f, sb.toString());
                this.f7267g.w();
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0614ub.class.getSimpleName(), null, e2);
            }
        }
        if (this.f7264d != null) {
            this.f7267g.a((c.a.a.a.c<AdobeLibraryException>) this.f7264d, this.f7265e, new AdobeLibraryException(AdobeLibraryErrorCode.AdobeLibraryErrorDownloadingRepresentationAsset));
        }
    }
}

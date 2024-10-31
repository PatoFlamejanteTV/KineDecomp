package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudServiceType;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryException;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.Gb;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: AdobeLibraryPublicCollection.java */
/* loaded from: classes.dex */
public class M extends D {
    boolean q = false;

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.library.D
    public boolean a(String str, AdobeCloud adobeCloud, AdobeCloudServiceType adobeCloudServiceType, String str2, String str3) throws AdobeLibraryException {
        return super.a(str, adobeCloud, adobeCloudServiceType, str2, str3);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.library.D
    public boolean c(boolean z) {
        synchronized (this) {
            if (this.m == null) {
                return false;
            }
            if (!this.q) {
                this.q = true;
                ArrayList<C0614ub> d2 = d();
                int size = d2.size();
                ((G) Gb.f()).b(this);
                if (size > 0) {
                    Iterator<C0614ub> it = d2.iterator();
                    while (it.hasNext()) {
                        C0614ub next = it.next();
                        this.m.a(next, new K(this, next), new L(this), (Handler) null);
                    }
                } else {
                    this.m.b(true);
                }
            }
            return true;
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.library.D
    public boolean g() {
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.library.D
    public boolean h() {
        return this.q;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.library.D
    void j() {
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.library.D
    void l() {
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.library.D
    public boolean n() {
        return c(false);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.library.D
    public void p() {
        synchronized (this) {
            this.q = false;
            ((G) this.f4513c).a(this);
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.library.D
    public boolean a(String str) {
        String url = ((com.adobe.creativesdk.foundation.adobeinternal.cloud.g) this.m.o()).c("libraries").d().toString();
        if (!url.endsWith("/")) {
            url = url + "/";
        }
        return str.startsWith(url);
    }

    public void h(String str) {
        ha haVar = this.m;
        if (haVar != null) {
            haVar.i(str);
        }
    }
}

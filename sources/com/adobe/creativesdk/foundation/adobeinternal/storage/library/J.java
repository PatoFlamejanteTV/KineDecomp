package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ka;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.La;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryException;
import com.adobe.creativesdk.foundation.storage.Hb;

/* compiled from: AdobeLibraryMutableRepresentation.java */
/* loaded from: classes.dex */
public class J extends Hb {

    /* renamed from: c, reason: collision with root package name */
    Ka f4523c;

    public J() {
    }

    @Override // com.adobe.creativesdk.foundation.storage.Hb
    public boolean a(Object obj, String str, String str2) throws AdobeLibraryException {
        if (str2 != null) {
            if (!str2.equals("library")) {
                if (r() != null) {
                    if (r() instanceof Na) {
                        ((Na) r()).a(obj, String.format("%s#%s", str2, str));
                    } else if (r() instanceof La) {
                        ((La) r()).a(obj, String.format("%s#%s", str2, str));
                    }
                } else {
                    this.f4523c.a(obj, String.format("%s#%s", str2, str));
                }
                return true;
            }
            throw ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorRepresentationReservedKey, null, null, null);
        }
        throw ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorNamespaceNotFoundForKey, null, null, null);
    }

    public void b(int i) {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(i >= 0, "The height must be greater than or equal to 0.");
        if (r() != null) {
            com.adobe.creativesdk.foundation.internal.storage.model.util.e.b("application/vnd.adobe.library.link+dcx".equals(h()), "Cannot set height on an element that is not file based.");
            if (r() instanceof Na) {
                ((Na) r()).a(Integer.valueOf(i), "library#height");
                return;
            } else {
                if (r() instanceof La) {
                    ((La) r()).a(Integer.valueOf(i), "library#height");
                    return;
                }
                return;
            }
        }
        this.f4523c.a(i);
    }

    public void c(int i) {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(i >= 0, "The width must be greater than or equal to 0.");
        if (r() != null) {
            com.adobe.creativesdk.foundation.internal.storage.model.util.e.b("application/vnd.adobe.library.link+dcx".equals(h()), "Cannot set width on an element that is not file based.");
            if (r() instanceof Na) {
                ((Na) r()).a(Integer.valueOf(i), "library#width");
                return;
            } else {
                if (r() instanceof La) {
                    ((La) r()).a(Integer.valueOf(i), "library#width");
                    return;
                }
                return;
            }
        }
        this.f4523c.b(i);
    }

    @Override // com.adobe.creativesdk.foundation.storage.Hb
    public String h() {
        throw null;
    }

    public Ka q() {
        return this.f4523c;
    }

    public Object r() {
        throw null;
    }

    public J(C0225c c0225c) {
        super(c0225c);
    }

    @Override // com.adobe.creativesdk.foundation.storage.Hb
    public void a(int i) {
        if (r() != null) {
            if (r() instanceof Na) {
                ((Na) r()).a(Integer.valueOf(i), "library#representationOrder");
                return;
            } else {
                if (r() instanceof La) {
                    ((La) r()).a(Integer.valueOf(i), "library#representationOrder");
                    return;
                }
                return;
            }
        }
        this.f4523c.a(Integer.valueOf(i), "library#representationOrder");
    }

    public void a(Ka ka) {
        this.f4523c = ka;
    }
}

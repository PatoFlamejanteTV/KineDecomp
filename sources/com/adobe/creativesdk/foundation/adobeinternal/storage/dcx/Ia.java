package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import android.content.Context;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.xmp.XMPException;
import com.facebook.internal.NativeProtocol;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: AdobeDCXMetadata.java */
/* loaded from: classes.dex */
public class Ia {

    /* renamed from: d, reason: collision with root package name */
    static String f4181d;

    /* renamed from: g, reason: collision with root package name */
    private com.adobe.xmp.f f4184g;

    /* renamed from: h, reason: collision with root package name */
    long f4185h;
    long i;
    String j;
    protected SimpleDateFormat k;
    private String l;

    /* renamed from: a, reason: collision with root package name */
    private static String f4178a = "META-INF/metadata.xml";

    /* renamed from: b, reason: collision with root package name */
    private static String f4179b = f4178a;

    /* renamed from: c, reason: collision with root package name */
    private static String f4180c = "/" + f4178a;

    /* renamed from: e, reason: collision with root package name */
    static String f4182e = null;

    /* renamed from: f, reason: collision with root package name */
    static String f4183f = null;

    public Ia() {
        this.f4184g = com.adobe.xmp.h.a();
        this.f4185h = 0L;
        this.i = 0L;
        this.l = null;
        b("http://creativecommons.org/ns#", "cc");
        try {
            f4181d = com.adobe.xmp.i.a("History", -1);
        } catch (XMPException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMetadata.Constructor", e2.getMessage());
        }
    }

    public static C0225c a(C0233g c0233g) {
        return a((InterfaceC0223b) c0233g);
    }

    String b(String str) {
        String format;
        try {
            Date parse = Fa.k().parse(str);
            synchronized (e()) {
                format = e().format(parse);
            }
            return format;
        } catch (ParseException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMetadata.convertToTZLocalDate", e2.getMessage());
            return null;
        }
    }

    String c(String str) {
        String format;
        if (str != null) {
            return b(str);
        }
        Date date = new Date();
        synchronized (e()) {
            format = e().format(date);
        }
        return format;
    }

    void d(String str) throws XMPException {
        String str2;
        try {
            str2 = Za.b(str).toString();
        } catch (IOException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "dcxMetaData init failed", e2.getMessage());
            str2 = null;
        }
        e(str2);
    }

    SimpleDateFormat e() {
        if (this.k == null) {
            this.k = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
        }
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.adobe.xmp.f f() {
        return this.f4184g;
    }

    public boolean g() {
        return this.f4185h != this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.adobe.xmp.f h() {
        this.f4184g = (com.adobe.xmp.f) this.f4184g.clone();
        this.f4185h++;
        return this.f4184g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        this.l = "*composite*metadata*";
    }

    String j() {
        String c2 = Za.c(org.apache.commons.io.b.a(), com.adobe.creativesdk.foundation.internal.storage.model.util.i.a());
        try {
            if (Za.b(c2, com.adobe.xmp.h.a(this.f4184g, (com.adobe.xmp.b.f) null)).booleanValue()) {
                return c2;
            }
            return null;
        } catch (XMPException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMetadata.serializeToTempFile", e2.getMessage());
            return null;
        } catch (IOException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMetadata.serializeToTempFile", e3.getMessage());
            return null;
        }
    }

    public static C0225c a(InterfaceC0223b interfaceC0223b) {
        if (interfaceC0223b != null) {
            return interfaceC0223b.a().c(f4180c);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, String str2) {
        h();
        String a2 = Za.a(str2 == null ? com.adobe.creativesdk.foundation.internal.storage.model.util.i.a() : str2);
        try {
            String value = this.f4184g.b("http://ns.adobe.com/xap/1.0/mm/", "DocumentID").getValue();
            String value2 = this.f4184g.b("http://ns.adobe.com/xap/1.0/mm/", "OriginalDocumentID").getValue();
            String str3 = value2.isEmpty() ? value : value2;
            String value3 = this.f4184g.b("http://ns.adobe.com/xap/1.0/mm/", "InstanceID").getValue();
            String value4 = this.f4184g.b("http://ns.adobe.com/xap/1.0/", "ModifyDate").getValue();
            this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", "DerivedFrom", "http://ns.adobe.com/xap/1.0/sType/ResourceRef#", "documentID", value);
            this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", "DerivedFrom", "http://ns.adobe.com/xap/1.0/sType/ResourceRef#", "originalDocumentID", str3);
            this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", "DerivedFrom", "http://ns.adobe.com/xap/1.0/sType/ResourceRef#", "instanceID", value3);
            this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", "DerivedFrom", "http://ns.adobe.com/xap/1.0/sType/ResourceRef#", "lastModifyDate", value4);
            this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", "DocumentID");
            this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", "DocumentID", a2);
            this.f4184g.a("http://ns.adobe.com/xap/1.0/", "CreatorTool");
            this.f4184g.a("http://ns.adobe.com/xap/1.0/", "CreatorTool", Za.a(b()));
            a(str);
        } catch (XMPException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMetadata.Constructor", e2.getMessage());
        }
    }

    public static String d() {
        return f4183f;
    }

    private void e(String str) throws XMPException {
        if (str != null) {
            this.f4184g = com.adobe.xmp.h.a((str + "\n").getBytes(org.apache.commons.io.a.f29306f));
            if (this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", f4181d, "http://ns.adobe.com/xap/1.0/sType/ResourceEvent#", NativeProtocol.WEB_DIALOG_ACTION).getValue() == "saved" && this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", f4181d, "http://ns.adobe.com/xap/1.0/sType/ResourceEvent#", "softwareAgent").getValue().equals(Za.a(b()))) {
                this.j = this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", f4181d, "http://ns.adobe.com/xap/1.0/sType/ResourceEvent#", "instanceID").getValue();
                return;
            }
            return;
        }
        throw new XMPException("null data in initFromData", -1);
    }

    public C0225c b(InterfaceC0223b interfaceC0223b) throws AdobeDCXException {
        Ka i;
        String str = this.l;
        if (str == "*composite*metadata*") {
            C0225c b2 = b(interfaceC0223b.a().h(), interfaceC0223b, f4179b);
            if (b2 == null) {
                return null;
            }
            this.i = this.f4185h;
            return b2;
        }
        if (str == null || (i = interfaceC0223b.a().d(this.l).i()) == null) {
            return null;
        }
        this.i = this.f4185h;
        return a(i, interfaceC0223b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ma c() {
        return new Ma(this.f4184g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ia(C0233g c0233g, C0225c c0225c) throws AdobeDCXException, XMPException {
        this((InterfaceC0223b) c0233g, c0225c);
    }

    Ia(InterfaceC0223b interfaceC0223b, C0225c c0225c) throws AdobeDCXException, XMPException {
        this();
        a(a(interfaceC0223b, c0225c), c0225c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ia(Fa fa) {
        this();
        h();
        String a2 = Za.a(c((String) fa.b("created")));
        String a3 = Za.a(c((String) fa.b("modified")));
        String a4 = Za.a(fa.h());
        String a5 = Za.a(fa.v()) != null ? Za.a(fa.v()) : "";
        String a6 = d() != null ? Za.a(d()) : Za.a(b());
        try {
            this.f4184g.a("http://ns.adobe.com/xap/1.0/", "CreatorTool", Za.a(b()));
            this.f4184g.a("http://ns.adobe.com/xap/1.0/", "CreateDate", a2);
            this.f4184g.a("http://ns.adobe.com/xap/1.0/", "ModifyDate", a3);
            this.f4184g.a("http://ns.adobe.com/xap/1.0/", "MetadataDate", a3);
            if (a5.length() > 0) {
                this.f4184g.a("http://purl.org/dc/elements/1.1/", "format", a5);
            }
            this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", "DocumentID", a4);
            this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", "OriginalDocumentID", a4);
            this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", "InstanceID", a4);
            this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", "History", new com.adobe.xmp.b.e(1024), (String) null, new com.adobe.xmp.b.e(256));
            this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", f4181d, "http://ns.adobe.com/xap/1.0/sType/ResourceEvent#", NativeProtocol.WEB_DIALOG_ACTION, "created");
            this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", f4181d, "http://ns.adobe.com/xap/1.0/sType/ResourceEvent#", "instanceID", a4);
            this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", f4181d, "http://ns.adobe.com/xap/1.0/sType/ResourceEvent#", "when", a3);
            this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", f4181d, "http://ns.adobe.com/xap/1.0/sType/ResourceEvent#", "softwareAgent", a6);
            this.l = "*composite*metadata*";
        } catch (XMPException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMetadata.Constructor", e2.getMessage());
        }
    }

    public static String b() {
        Context a2 = c.a.a.a.c.a.a.b().a();
        if (a2 != null) {
            f4182e = a2.getString(a2.getApplicationInfo().labelRes);
        }
        return f4182e;
    }

    public static void b(String str, String str2) {
        try {
            com.adobe.xmp.h.b().a(Za.a(str), Za.a(str2));
        } catch (XMPException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMetadata.registerNamespace", e2.getMessage());
        }
    }

    C0225c b(Na na, InterfaceC0223b interfaceC0223b, String str) throws AdobeDCXException {
        for (C0225c c0225c : interfaceC0223b.a().b(na)) {
            if (c0225c.k().equals(str)) {
                return a(c0225c, interfaceC0223b);
            }
        }
        return a(na, interfaceC0223b, str);
    }

    private static String a(InterfaceC0223b interfaceC0223b, C0225c c0225c) throws AdobeDCXException {
        return interfaceC0223b.a().c(c0225c);
    }

    private void a(String str, C0225c c0225c) throws XMPException {
        d(str);
        this.l = c0225c.a().equals(f4180c) ? "*composite*metadata*" : c0225c.b();
    }

    public C0225c a(C0235h c0235h) throws AdobeDCXException {
        return b(c0235h);
    }

    String a(String str, Date date, boolean z) {
        String a2;
        h();
        String a3 = Za.a(str);
        String a4 = Za.a(com.adobe.creativesdk.foundation.internal.storage.model.util.i.a());
        String a5 = Za.a(b());
        if (d() != null) {
            a5 = Za.a(d());
        }
        synchronized (e()) {
            a2 = Za.a(e().format(date));
        }
        try {
            this.f4184g.a("http://ns.adobe.com/xap/1.0/", "ModifyDate");
            this.f4184g.a("http://ns.adobe.com/xap/1.0/", "MetadataDate");
            this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", "InstanceID");
            this.f4184g.a("http://ns.adobe.com/xap/1.0/", "ModifyDate", a2);
            this.f4184g.a("http://ns.adobe.com/xap/1.0/", "MetadataDate", a2);
            this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", "InstanceID", a4);
            this.f4184g.b("http://ns.adobe.com/xap/1.0/mm/", "DocumentID");
            if (!z) {
                this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", "History", new com.adobe.xmp.b.e(1024), (String) null, new com.adobe.xmp.b.e(256));
            }
            this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", f4181d, "http://ns.adobe.com/xap/1.0/sType/ResourceEvent#", NativeProtocol.WEB_DIALOG_ACTION, a3);
            this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", f4181d, "http://ns.adobe.com/xap/1.0/sType/ResourceEvent#", "instanceID", a4);
            this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", f4181d, "http://ns.adobe.com/xap/1.0/sType/ResourceEvent#", "when", a2);
            this.f4184g.a("http://ns.adobe.com/xap/1.0/mm/", f4181d, "http://ns.adobe.com/xap/1.0/sType/ResourceEvent#", "softwareAgent", a5);
        } catch (XMPException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMetadata.appendHistoryEvent", e2.getMessage());
        }
        return a4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ia(com.adobe.xmp.f fVar) {
        this.f4184g = fVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        a(str, new Date(), false);
    }

    public com.adobe.xmp.c.b a(Ja ja) {
        try {
            return this.f4184g.b(Za.a(ja.c()), Za.a(ja.b()));
        } catch (XMPException e2) {
            try {
                a(e2);
                throw null;
            } catch (AdobeDCXMetadataException e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Ia.class.getSimpleName(), null, e3);
                return null;
            }
        }
    }

    static void a(XMPException xMPException) throws AdobeDCXMetadataException {
        AdobeDCXMetadataErrorCode adobeDCXMetadataErrorCode;
        int errorCode = xMPException.getErrorCode();
        if (errorCode == 4) {
            adobeDCXMetadataErrorCode = AdobeDCXMetadataErrorCode.BADPARAM;
        } else if (errorCode == 5) {
            adobeDCXMetadataErrorCode = AdobeDCXMetadataErrorCode.BADVALUE;
        } else if (errorCode == 9) {
            adobeDCXMetadataErrorCode = AdobeDCXMetadataErrorCode.INTERNALFAILURE;
        } else if (errorCode != 107) {
            switch (errorCode) {
                case 101:
                    adobeDCXMetadataErrorCode = AdobeDCXMetadataErrorCode.BADSCHEMA;
                    break;
                case 102:
                    adobeDCXMetadataErrorCode = AdobeDCXMetadataErrorCode.BADXPATH;
                    break;
                case 103:
                    adobeDCXMetadataErrorCode = AdobeDCXMetadataErrorCode.BADOPTIONS;
                    break;
                case 104:
                    adobeDCXMetadataErrorCode = AdobeDCXMetadataErrorCode.BADINDEX;
                    break;
                default:
                    switch (errorCode) {
                        case 201:
                            adobeDCXMetadataErrorCode = AdobeDCXMetadataErrorCode.BADXML;
                            break;
                        case 202:
                            adobeDCXMetadataErrorCode = AdobeDCXMetadataErrorCode.BADRDF;
                            break;
                        case 203:
                            adobeDCXMetadataErrorCode = AdobeDCXMetadataErrorCode.BADXMP;
                            break;
                        case 204:
                            adobeDCXMetadataErrorCode = AdobeDCXMetadataErrorCode.BADSTREAM;
                            break;
                        default:
                            adobeDCXMetadataErrorCode = AdobeDCXMetadataErrorCode.UNKNOWN;
                            break;
                    }
            }
        } else {
            adobeDCXMetadataErrorCode = AdobeDCXMetadataErrorCode.BADSERIALIZE;
        }
        throw new AdobeDCXMetadataException(adobeDCXMetadataErrorCode, xMPException.getMessage());
    }

    public C0225c a(C0225c c0225c, InterfaceC0223b interfaceC0223b) {
        C0225c c0225c2;
        String j = j();
        if (j == null) {
            return null;
        }
        try {
            c0225c2 = interfaceC0223b.a().a(c0225c, j, false);
        } catch (AdobeDCXException unused) {
            c0225c2 = null;
        }
        if (c0225c2 == null) {
            org.apache.commons.io.b.c(new File(j));
            return null;
        }
        this.i = this.f4185h;
        this.l = c0225c2.b();
        return c0225c2;
    }

    public C0225c a(Na na, InterfaceC0223b interfaceC0223b, String str) throws AdobeDCXException {
        String j = j();
        if (j == null) {
            return null;
        }
        C0225c a2 = interfaceC0223b.a().a("xmp-metadata", (String) null, "application/rdf+xml", "metadata", str, na, j, false, (String) null);
        if (a2 == null) {
            org.apache.commons.io.b.c(new File(j));
            return null;
        }
        this.i = this.f4185h;
        this.l = a2.b();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        String str;
        boolean z;
        if (this.f4184g.d("http://ns.adobe.com/xap/1.0/sType/ResourceEvent#", "instanceID")) {
            try {
                str = this.f4184g.c("http://ns.adobe.com/xap/1.0/sType/ResourceEvent#", "instanceID");
            } catch (XMPException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeDCXMetadata#appendSavedEvent", e2.getMessage());
                str = null;
            }
            String str2 = this.j;
            if (str == str2 || (str != null && str.equals(str2))) {
                z = true;
                this.j = a("saved", new Date(), z);
            }
        }
        z = false;
        this.j = a("saved", new Date(), z);
    }
}

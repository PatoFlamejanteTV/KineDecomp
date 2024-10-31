package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.adobeinternal.storage.library.C0272a;
import com.adobe.creativesdk.foundation.adobeinternal.storage.library.C0273b;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AdobeAssetLibrary.java */
@Deprecated
/* renamed from: com.adobe.creativesdk.foundation.storage.oa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0590oa extends Ya {
    private HashMap<String, Aa> A;
    private HashMap<String, Ca> B;
    private HashMap<String, C0598qa> C;
    private HashMap<String, C0594pa> D;
    private HashMap<String, C0601ra> E;
    private HashMap<String, C0609ta> F;
    private String s;
    private HashMap<String, C0621wa> t;
    private HashMap<String, C0625xa> u;
    private HashMap<String, C0629ya> v;
    private HashMap<String, C0613ua> w;
    private HashMap<String, C0272a> x;
    private HashMap<String, C0273b> y;
    private HashMap<String, C0633za> z;

    protected C0590oa() {
        k();
    }

    private static boolean g(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha) {
        for (com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha2 : ha.d().c(ha)) {
            if (ha2.k().equals("application/vnd.adobe.library.link+dcx") && ((JSONObject) ha2.a("adobestock#trackingdata")) != null) {
                return true;
            }
        }
        return false;
    }

    private void k() {
        this.w = new HashMap<>();
        this.x = new HashMap<>();
        this.t = new HashMap<>();
        this.u = new HashMap<>();
        this.y = new HashMap<>();
        this.v = new HashMap<>();
        this.z = new HashMap<>();
        this.A = new HashMap<>();
        this.B = new HashMap<>();
        this.C = new HashMap<>();
        this.D = new HashMap<>();
        this.E = new HashMap<>();
        this.F = new HashMap<>();
    }

    @Override // com.adobe.creativesdk.foundation.storage.Ya
    @Deprecated
    public void a(vd vdVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        new WeakReference(this);
        super.a(new C0586na(this, vdVar), cVar);
    }

    com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha b(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha) {
        for (com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha2 : h().c(ha)) {
            if (ha2.k() != null && ha2.k().equals("application/vnd.adobe.color+json")) {
                return ha2;
            }
        }
        return null;
    }

    com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha c(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha) {
        for (com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha2 : h().c(ha)) {
            if (ha2.a("library#rel") != null && ha2.a("library#rel").equals("rendition")) {
                return ha2;
            }
        }
        return null;
    }

    com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha d(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha) {
        for (com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha2 : h().c(ha)) {
            if (ha2.k() != null && ha2.k().equals("application/vnd.adobe.colortheme+json")) {
                return ha2;
            }
        }
        return null;
    }

    protected C0225c e(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha) {
        for (C0225c c0225c : h().d(ha)) {
            if (c0225c.l() != null && c0225c.l().equals("primary")) {
                return c0225c;
            }
        }
        return null;
    }

    @Override // com.adobe.creativesdk.foundation.storage.Ya, com.adobe.creativesdk.foundation.storage.C0578la, com.adobe.creativesdk.foundation.storage.C0533a
    public boolean equals(Object obj) {
        if (obj instanceof C0590oa) {
            return super.equals(obj);
        }
        return false;
    }

    protected C0225c f(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha) {
        for (C0225c c0225c : h().d(ha)) {
            if (c0225c.l() != null && c0225c.l().equals("rendition") && c0225c.n() != null && (c0225c.n().equals("image/png") || c0225c.n().equals("image/jpg") || c0225c.n().equals("image/jpeg"))) {
                return c0225c;
            }
        }
        return null;
    }

    @Override // com.adobe.creativesdk.foundation.storage.Ya, com.adobe.creativesdk.foundation.storage.C0578la, com.adobe.creativesdk.foundation.storage.C0533a
    public int hashCode() {
        return super.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha;
        HashMap<String, C0609ta> hashMap;
        HashMap<String, C0601ra> hashMap2;
        HashMap<String, C0594pa> hashMap3;
        HashMap<String, C0598qa> hashMap4;
        HashMap<String, Aa> hashMap5;
        HashMap<String, C0633za> hashMap6;
        HashMap<String, C0629ya> hashMap7;
        HashMap<String, Ca> hashMap8;
        HashMap<String, C0273b> hashMap9;
        HashMap<String, C0621wa> hashMap10;
        HashMap<String, C0272a> hashMap11;
        HashMap<String, C0613ua> hashMap12;
        HashMap<String, C0629ya> hashMap13;
        HashMap<String, C0625xa> hashMap14;
        HashMap<String, C0625xa> hashMap15;
        HashMap<String, C0273b> hashMap16;
        HashMap<String, C0633za> hashMap17;
        HashMap<String, Aa> hashMap18;
        String str;
        AdobeAssetFile adobeAssetFile;
        int i;
        int i2;
        String str2;
        AdobeAssetFile adobeAssetFile2;
        int i3;
        int i4;
        String str3;
        AdobeAssetFile adobeAssetFile3;
        int i5;
        int i6;
        String str4;
        AdobeAssetFile adobeAssetFile4;
        int i7;
        int i8;
        String str5;
        AdobeAssetFile adobeAssetFile5;
        int i9;
        int i10;
        String str6;
        AdobeAssetFile adobeAssetFile6;
        int i11;
        int i12;
        String str7;
        AdobeAssetFile adobeAssetFile7;
        int i13;
        int i14;
        String str8;
        AdobeAssetFile adobeAssetFile8;
        int i15;
        int i16;
        String str9;
        int i17;
        int i18;
        String str10;
        AdobeAssetFile adobeAssetFile9;
        int i19;
        int i20;
        C0629ya c0629ya;
        HashMap<String, Ca> hashMap19;
        String str11;
        String str12;
        String str13;
        Object obj;
        Number number;
        String str14;
        String str15;
        Object obj2;
        Number number2;
        String str16;
        String str17;
        AdobeAssetFile adobeAssetFile10;
        int i21;
        int i22;
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha2;
        AdobeAssetFile adobeAssetFile11;
        AdobeAssetFile adobeAssetFile12;
        String str18;
        int i23;
        C0590oa c0590oa = (C0590oa) new WeakReference(this).get();
        if (c0590oa == null || c0590oa.h() == null) {
            return;
        }
        Map<String, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha> a2 = c0590oa.h().a();
        c0590oa.s = c0590oa.h().h();
        HashMap<String, C0613ua> hashMap20 = new HashMap<>();
        HashMap<String, C0272a> hashMap21 = new HashMap<>();
        HashMap<String, C0621wa> hashMap22 = new HashMap<>();
        HashMap<String, C0625xa> hashMap23 = new HashMap<>();
        HashMap<String, C0273b> hashMap24 = new HashMap<>();
        HashMap<String, C0629ya> hashMap25 = new HashMap<>();
        HashMap<String, C0633za> hashMap26 = new HashMap<>();
        HashMap<String, Aa> hashMap27 = new HashMap<>();
        HashMap<String, Ca> hashMap28 = new HashMap<>();
        HashMap<String, C0598qa> hashMap29 = new HashMap<>();
        HashMap<String, C0594pa> hashMap30 = new HashMap<>();
        HashMap<String, C0601ra> hashMap31 = new HashMap<>();
        HashMap<String, C0609ta> hashMap32 = new HashMap<>();
        for (com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha3 : a2.values()) {
            int i24 = 0;
            String str19 = null;
            if (ha3.k() != null) {
                HashMap<String, C0609ta> hashMap33 = hashMap32;
                HashMap<String, C0601ra> hashMap34 = hashMap31;
                if (ha3.k().equals("application/vnd.adobe.element.brush+dcx")) {
                    C0225c e2 = c0590oa.e(ha3);
                    com.adobe.creativesdk.foundation.internal.storage.model.resources.f a3 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(URI.create(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(c0590oa.href.getRawPath(), e2 != null ? e2.b() : null)));
                    a3.f6612d = ha3.k();
                    HashMap<String, C0594pa> hashMap35 = hashMap30;
                    AdobeAssetFile adobeAssetFile13 = new AdobeAssetFile(a3, c0590oa.g());
                    adobeAssetFile13.setCloud(getCloud());
                    C0225c f2 = c0590oa.f(ha3);
                    if (f2 != null) {
                        String j = f2.j();
                        ha2 = ha3;
                        adobeAssetFile11 = adobeAssetFile13;
                        com.adobe.creativesdk.foundation.internal.storage.model.resources.f a4 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(URI.create(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(c0590oa.href.getRawPath(), f2.b())));
                        a4.f6612d = "image/png";
                        adobeAssetFile12 = new AdobeAssetFile(a4, c0590oa.g());
                        adobeAssetFile12.setCloud(getCloud());
                        i24 = f2.e();
                        i23 = f2.p();
                        str18 = j;
                    } else {
                        ha2 = ha3;
                        adobeAssetFile11 = adobeAssetFile13;
                        adobeAssetFile12 = null;
                        str18 = null;
                        i23 = 0;
                    }
                    hashMap = hashMap33;
                    hashMap2 = hashMap34;
                    hashMap7 = hashMap25;
                    hashMap3 = hashMap35;
                    hashMap4 = hashMap29;
                    hashMap5 = hashMap27;
                    hashMap6 = hashMap26;
                    hashMap20.put(ha2.g(), new C0613ua(ha2, str18, adobeAssetFile11, adobeAssetFile12, i24, i23, c0590oa));
                    hashMap8 = hashMap28;
                    hashMap16 = hashMap24;
                    hashMap10 = hashMap22;
                    hashMap11 = hashMap21;
                    hashMap12 = hashMap20;
                    hashMap13 = hashMap7;
                    hashMap32 = hashMap;
                    hashMap17 = hashMap6;
                    hashMap15 = hashMap23;
                    hashMap18 = hashMap5;
                    hashMap27 = hashMap18;
                    hashMap25 = hashMap13;
                    hashMap23 = hashMap15;
                    hashMap21 = hashMap11;
                    hashMap31 = hashMap2;
                    hashMap30 = hashMap3;
                    hashMap29 = hashMap4;
                    hashMap20 = hashMap12;
                    hashMap28 = hashMap8;
                    hashMap22 = hashMap10;
                    HashMap<String, C0633za> hashMap36 = hashMap17;
                    hashMap24 = hashMap16;
                    hashMap26 = hashMap36;
                } else {
                    ha = ha3;
                    hashMap3 = hashMap30;
                    hashMap4 = hashMap29;
                    hashMap5 = hashMap27;
                    hashMap6 = hashMap26;
                    hashMap = hashMap33;
                    hashMap2 = hashMap34;
                }
            } else {
                ha = ha3;
                hashMap = hashMap32;
                hashMap2 = hashMap31;
                hashMap3 = hashMap30;
                hashMap4 = hashMap29;
                hashMap5 = hashMap27;
                hashMap6 = hashMap26;
            }
            hashMap7 = hashMap25;
            HashMap<String, Ca> hashMap37 = hashMap28;
            if (ha.k() != null && ha.k().equals("application/vnd.adobe.element.characterstyle+dcx")) {
                com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha4 = ha;
                JSONObject jSONObject = (JSONObject) c0590oa.a(ha4).a("characterstyle#data");
                C0225c f3 = c0590oa.f(ha4);
                if (f3 != null) {
                    String j2 = f3.j();
                    com.adobe.creativesdk.foundation.internal.storage.model.resources.f a5 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(URI.create(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(c0590oa.href.getRawPath(), f3.b())));
                    a5.f6612d = "image/png";
                    AdobeAssetFile adobeAssetFile14 = new AdobeAssetFile(a5, c0590oa.g());
                    adobeAssetFile14.setCloud(getCloud());
                    int e3 = f3.e();
                    adobeAssetFile10 = adobeAssetFile14;
                    i22 = f3.p();
                    i21 = e3;
                    str17 = j2;
                } else {
                    str17 = null;
                    adobeAssetFile10 = null;
                    i21 = 0;
                    i22 = 0;
                }
                hashMap21.put(ha4.g(), new C0272a(ha4, str17, jSONObject, adobeAssetFile10, i21, i22, c0590oa));
                hashMap8 = hashMap37;
                hashMap16 = hashMap24;
                hashMap10 = hashMap22;
                hashMap11 = hashMap21;
                hashMap12 = hashMap20;
                hashMap13 = hashMap7;
                hashMap32 = hashMap;
                hashMap17 = hashMap6;
                hashMap15 = hashMap23;
                hashMap18 = hashMap5;
                hashMap27 = hashMap18;
                hashMap25 = hashMap13;
                hashMap23 = hashMap15;
                hashMap21 = hashMap11;
                hashMap31 = hashMap2;
                hashMap30 = hashMap3;
                hashMap29 = hashMap4;
                hashMap20 = hashMap12;
                hashMap28 = hashMap8;
                hashMap22 = hashMap10;
                HashMap<String, C0633za> hashMap362 = hashMap17;
                hashMap24 = hashMap16;
                hashMap26 = hashMap362;
            } else {
                if (ha.k() != null && ha.k().equals("application/vnd.adobe.element.color+dcx")) {
                    com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha5 = ha;
                    com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha b2 = c0590oa.b(ha5);
                    if (b2 != null) {
                        JSONObject jSONObject2 = (JSONObject) b2.a("color#data");
                        str12 = jSONObject2.optString("type");
                        str13 = jSONObject2.optString("mode");
                        obj = jSONObject2.opt("value");
                        number = (Number) jSONObject2.opt("alpha");
                        str11 = jSONObject2.optString("profileName");
                        hashMap19 = hashMap37;
                    } else {
                        hashMap19 = hashMap37;
                        str11 = null;
                        str12 = null;
                        str13 = null;
                        obj = null;
                        number = null;
                    }
                    com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha c2 = c0590oa.c(ha5);
                    if (c2 != null) {
                        String f4 = c2.f();
                        JSONObject jSONObject3 = (JSONObject) c2.a("color#data");
                        String optString = jSONObject3.optString("type");
                        String optString2 = jSONObject3.optString("mode");
                        Object opt = jSONObject3.opt("value");
                        Number number3 = (Number) jSONObject3.opt("alpha");
                        str16 = jSONObject3.optString("profileName");
                        number2 = number3;
                        obj2 = opt;
                        str15 = optString;
                        str14 = f4;
                        str19 = optString2;
                    } else {
                        str14 = null;
                        str15 = null;
                        obj2 = null;
                        number2 = null;
                        str16 = null;
                    }
                    hashMap8 = hashMap19;
                    hashMap9 = hashMap24;
                    hashMap14 = hashMap23;
                    hashMap10 = hashMap22;
                    hashMap11 = hashMap21;
                    hashMap12 = hashMap20;
                    C0621wa c0621wa = new C0621wa(ha5, str14, str12, str13, obj, number, str11, str15, str19, obj2, number2, str16, c0590oa);
                    c0621wa.a();
                    hashMap10.put(ha5.g(), c0621wa);
                    hashMap13 = hashMap7;
                } else {
                    hashMap8 = hashMap37;
                    hashMap9 = hashMap24;
                    hashMap10 = hashMap22;
                    hashMap11 = hashMap21;
                    hashMap12 = hashMap20;
                    hashMap13 = hashMap7;
                    com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha6 = ha;
                    hashMap14 = hashMap23;
                    if (ha6.k() != null && ha6.k().equals("application/vnd.adobe.element.colortheme+dcx")) {
                        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha d2 = c0590oa.d(ha6);
                        if (d2 != null) {
                            JSONObject jSONObject4 = (JSONObject) d2.a("colortheme#data");
                            hashMap15 = hashMap14;
                            hashMap15.put(ha6.g(), new C0625xa(ha6, (JSONArray) jSONObject4.opt("tags"), jSONObject4.optString("rule"), jSONObject4.optString("mood"), (JSONArray) jSONObject4.opt("swatches"), c0590oa));
                        }
                    } else {
                        hashMap15 = hashMap14;
                        if (ha6.k() != null && ha6.k().equals("application/vnd.adobe.element.image+dcx")) {
                            C0225c e4 = c0590oa.e(ha6);
                            String str20 = "";
                            if (e4 != null) {
                                str20 = e4.b();
                                int e5 = e4.e();
                                int p = e4.p();
                                str9 = e4.n();
                                i18 = p;
                                i17 = e5;
                            } else {
                                str9 = "";
                                i17 = 0;
                                i18 = 0;
                            }
                            com.adobe.creativesdk.foundation.internal.storage.model.resources.f a6 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(URI.create(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(c0590oa.href.getRawPath(), str20)));
                            a6.f6612d = ha6.k();
                            AdobeAssetFile adobeAssetFile15 = new AdobeAssetFile(a6, c0590oa.g());
                            adobeAssetFile15.setCloud(getCloud());
                            C0225c f5 = c0590oa.f(ha6);
                            if (f5 != null) {
                                str10 = f5.j();
                                com.adobe.creativesdk.foundation.internal.storage.model.resources.f a7 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(URI.create(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(c0590oa.href.getRawPath(), f5.b())));
                                a7.f6612d = "image/png";
                                AdobeAssetFile adobeAssetFile16 = new AdobeAssetFile(a7, c0590oa.g());
                                adobeAssetFile16.setCloud(getCloud());
                                int e6 = f5.e();
                                i20 = f5.p();
                                i19 = e6;
                                adobeAssetFile9 = adobeAssetFile16;
                            } else {
                                str10 = null;
                                adobeAssetFile9 = null;
                                i19 = 0;
                                i20 = 0;
                            }
                            if (g(ha6)) {
                                c0629ya = new Ba(ha6, str10, adobeAssetFile9, i19, i20, adobeAssetFile9, i19, i20, str9, c0590oa);
                            } else {
                                c0629ya = new C0629ya(ha6, str10, adobeAssetFile15, i17, i18, adobeAssetFile9, i19, i20, str9, c0590oa);
                            }
                            hashMap13.put(ha6.g(), c0629ya);
                        } else {
                            if (ha6.k() != null && ha6.k().equals("application/vnd.adobe.element.layerstyle+dcx")) {
                                C0225c e7 = c0590oa.e(ha6);
                                com.adobe.creativesdk.foundation.internal.storage.model.resources.f a8 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(URI.create(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(c0590oa.href.getRawPath(), e7 != null ? e7.b() : null)));
                                a8.f6612d = ha6.k();
                                AdobeAssetFile adobeAssetFile17 = new AdobeAssetFile(a8, c0590oa.g());
                                adobeAssetFile17.setCloud(getCloud());
                                C0225c f6 = c0590oa.f(ha6);
                                if (f6 != null) {
                                    str8 = f6.j();
                                    com.adobe.creativesdk.foundation.internal.storage.model.resources.f a9 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(URI.create(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(c0590oa.href.getRawPath(), f6.b())));
                                    a9.f6612d = "image/png";
                                    AdobeAssetFile adobeAssetFile18 = new AdobeAssetFile(a9, c0590oa.g());
                                    adobeAssetFile18.setCloud(getCloud());
                                    int e8 = f6.e();
                                    i16 = f6.p();
                                    i15 = e8;
                                    adobeAssetFile8 = adobeAssetFile18;
                                } else {
                                    str8 = null;
                                    adobeAssetFile8 = null;
                                    i15 = 0;
                                    i16 = 0;
                                }
                                hashMap16 = hashMap9;
                                hashMap16.put(ha6.g(), new C0273b(ha6, str8, adobeAssetFile17, adobeAssetFile8, i15, i16, c0590oa));
                                hashMap32 = hashMap;
                                hashMap18 = hashMap5;
                                hashMap17 = hashMap6;
                            } else {
                                hashMap16 = hashMap9;
                                if (ha6.k() != null && ha6.k().equals("application/vnd.adobe.element.look+dcx")) {
                                    C0225c f7 = c0590oa.f(ha6);
                                    if (f7 != null) {
                                        str7 = f7.j();
                                        com.adobe.creativesdk.foundation.internal.storage.model.resources.f a10 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(URI.create(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(c0590oa.href.getRawPath(), f7.b())));
                                        a10.f6612d = "image/png";
                                        AdobeAssetFile adobeAssetFile19 = new AdobeAssetFile(a10, c0590oa.g());
                                        adobeAssetFile19.setCloud(getCloud());
                                        int e9 = f7.e();
                                        i14 = f7.p();
                                        i13 = e9;
                                        adobeAssetFile7 = adobeAssetFile19;
                                    } else {
                                        str7 = null;
                                        adobeAssetFile7 = null;
                                        i13 = 0;
                                        i14 = 0;
                                    }
                                    hashMap17 = hashMap6;
                                    hashMap17.put(ha6.g(), new C0633za(ha6, str7, adobeAssetFile7, i13, i14, c0590oa));
                                    hashMap32 = hashMap;
                                    hashMap18 = hashMap5;
                                } else {
                                    hashMap17 = hashMap6;
                                    if (ha6.k() != null && ha6.k().equals("application/vnd.adobe.element.pattern+dcx")) {
                                        C0225c f8 = c0590oa.f(ha6);
                                        if (f8 != null) {
                                            str6 = f8.j();
                                            com.adobe.creativesdk.foundation.internal.storage.model.resources.f a11 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(URI.create(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(c0590oa.href.getRawPath(), f8.b())));
                                            a11.f6612d = "image/png";
                                            AdobeAssetFile adobeAssetFile20 = new AdobeAssetFile(a11, c0590oa.g());
                                            adobeAssetFile20.setCloud(getCloud());
                                            int e10 = f8.e();
                                            i12 = f8.p();
                                            i11 = e10;
                                            adobeAssetFile6 = adobeAssetFile20;
                                        } else {
                                            str6 = null;
                                            adobeAssetFile6 = null;
                                            i11 = 0;
                                            i12 = 0;
                                        }
                                        hashMap18 = hashMap5;
                                        hashMap18.put(ha6.g(), new Aa(ha6, str6, adobeAssetFile6, i11, i12, c0590oa));
                                    } else {
                                        hashMap18 = hashMap5;
                                        if (ha6.k() != null && ha6.k().equals("application/vnd.adobe.element.template+dcx")) {
                                            C0225c f9 = c0590oa.f(ha6);
                                            if (f9 != null) {
                                                str5 = f9.j();
                                                com.adobe.creativesdk.foundation.internal.storage.model.resources.f a12 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(URI.create(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(c0590oa.href.getRawPath(), f9.b())));
                                                a12.f6612d = "image/png";
                                                AdobeAssetFile adobeAssetFile21 = new AdobeAssetFile(a12, c0590oa.g());
                                                adobeAssetFile21.setCloud(getCloud());
                                                int e11 = f9.e();
                                                i10 = f9.p();
                                                i9 = e11;
                                                adobeAssetFile5 = adobeAssetFile21;
                                            } else {
                                                str5 = null;
                                                adobeAssetFile5 = null;
                                                i9 = 0;
                                                i10 = 0;
                                            }
                                            hashMap8.put(ha6.g(), new Ca(ha6, str5, adobeAssetFile5, i9, i10, c0590oa));
                                        } else if (ha6.k() != null && ha6.k().equals("application/vnd.adobe.element.material+dcx")) {
                                            C0225c f10 = c0590oa.f(ha6);
                                            if (f10 != null) {
                                                str4 = f10.j();
                                                com.adobe.creativesdk.foundation.internal.storage.model.resources.f a13 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(URI.create(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(c0590oa.href.getRawPath(), f10.b())));
                                                a13.f6612d = "image/png";
                                                AdobeAssetFile adobeAssetFile22 = new AdobeAssetFile(a13, c0590oa.g());
                                                adobeAssetFile22.setCloud(getCloud());
                                                int e12 = f10.e();
                                                i8 = f10.p();
                                                i7 = e12;
                                                adobeAssetFile4 = adobeAssetFile22;
                                            } else {
                                                str4 = null;
                                                adobeAssetFile4 = null;
                                                i7 = 0;
                                                i8 = 0;
                                            }
                                            hashMap8 = hashMap8;
                                            hashMap4.put(ha6.g(), new C0598qa(ha6, str4, adobeAssetFile4, i7, i8, c0590oa));
                                        } else {
                                            hashMap8 = hashMap8;
                                            HashMap<String, C0598qa> hashMap38 = hashMap4;
                                            if (ha6.k() != null && ha6.k().equals("application/vnd.adobe.element.light+dcx")) {
                                                C0225c f11 = c0590oa.f(ha6);
                                                if (f11 != null) {
                                                    str3 = f11.j();
                                                    com.adobe.creativesdk.foundation.internal.storage.model.resources.f a14 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(URI.create(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(c0590oa.href.getRawPath(), f11.b())));
                                                    a14.f6612d = "image/png";
                                                    AdobeAssetFile adobeAssetFile23 = new AdobeAssetFile(a14, c0590oa.g());
                                                    adobeAssetFile23.setCloud(getCloud());
                                                    int e13 = f11.e();
                                                    i6 = f11.p();
                                                    i5 = e13;
                                                    adobeAssetFile3 = adobeAssetFile23;
                                                } else {
                                                    str3 = null;
                                                    adobeAssetFile3 = null;
                                                    i5 = 0;
                                                    i6 = 0;
                                                }
                                                hashMap4 = hashMap38;
                                                hashMap3.put(ha6.g(), new C0594pa(ha6, str3, adobeAssetFile3, i5, i6, c0590oa));
                                            } else {
                                                hashMap4 = hashMap38;
                                                HashMap<String, C0594pa> hashMap39 = hashMap3;
                                                if (ha6.k() != null && ha6.k().equals("application/vnd.adobe.element.3d+dcx")) {
                                                    C0225c f12 = c0590oa.f(ha6);
                                                    if (f12 != null) {
                                                        str2 = f12.j();
                                                        com.adobe.creativesdk.foundation.internal.storage.model.resources.f a15 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(URI.create(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(c0590oa.href.getRawPath(), f12.b())));
                                                        a15.f6612d = "image/png";
                                                        AdobeAssetFile adobeAssetFile24 = new AdobeAssetFile(a15, c0590oa.g());
                                                        adobeAssetFile24.setCloud(getCloud());
                                                        int e14 = f12.e();
                                                        i4 = f12.p();
                                                        i3 = e14;
                                                        adobeAssetFile2 = adobeAssetFile24;
                                                    } else {
                                                        str2 = null;
                                                        adobeAssetFile2 = null;
                                                        i3 = 0;
                                                        i4 = 0;
                                                    }
                                                    hashMap3 = hashMap39;
                                                    hashMap2.put(ha6.g(), new C0601ra(ha6, str2, adobeAssetFile2, i3, i4, c0590oa));
                                                } else {
                                                    hashMap3 = hashMap39;
                                                    HashMap<String, C0601ra> hashMap40 = hashMap2;
                                                    if (ha6.k() == null || !ha6.k().equals("application/vnd.adobe.element.animation+dcx")) {
                                                        hashMap2 = hashMap40;
                                                    } else {
                                                        C0225c f13 = c0590oa.f(ha6);
                                                        if (f13 != null) {
                                                            str = f13.j();
                                                            com.adobe.creativesdk.foundation.internal.storage.model.resources.f a16 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(URI.create(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(c0590oa.href.getRawPath(), f13.b())));
                                                            a16.f6612d = "image/png";
                                                            AdobeAssetFile adobeAssetFile25 = new AdobeAssetFile(a16, c0590oa.g());
                                                            adobeAssetFile25.setCloud(getCloud());
                                                            int e15 = f13.e();
                                                            i2 = f13.p();
                                                            i = e15;
                                                            adobeAssetFile = adobeAssetFile25;
                                                        } else {
                                                            str = null;
                                                            adobeAssetFile = null;
                                                            i = 0;
                                                            i2 = 0;
                                                        }
                                                        hashMap2 = hashMap40;
                                                        hashMap32 = hashMap;
                                                        hashMap32.put(ha6.g(), new C0609ta(ha6, str, adobeAssetFile, i, i2, c0590oa));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    hashMap32 = hashMap;
                                }
                            }
                            hashMap27 = hashMap18;
                            hashMap25 = hashMap13;
                            hashMap23 = hashMap15;
                            hashMap21 = hashMap11;
                            hashMap31 = hashMap2;
                            hashMap30 = hashMap3;
                            hashMap29 = hashMap4;
                            hashMap20 = hashMap12;
                            hashMap28 = hashMap8;
                            hashMap22 = hashMap10;
                            HashMap<String, C0633za> hashMap3622 = hashMap17;
                            hashMap24 = hashMap16;
                            hashMap26 = hashMap3622;
                        }
                    }
                    hashMap32 = hashMap;
                    hashMap18 = hashMap5;
                    hashMap17 = hashMap6;
                    hashMap16 = hashMap9;
                    hashMap27 = hashMap18;
                    hashMap25 = hashMap13;
                    hashMap23 = hashMap15;
                    hashMap21 = hashMap11;
                    hashMap31 = hashMap2;
                    hashMap30 = hashMap3;
                    hashMap29 = hashMap4;
                    hashMap20 = hashMap12;
                    hashMap28 = hashMap8;
                    hashMap22 = hashMap10;
                    HashMap<String, C0633za> hashMap36222 = hashMap17;
                    hashMap24 = hashMap16;
                    hashMap26 = hashMap36222;
                }
                hashMap15 = hashMap14;
                hashMap32 = hashMap;
                hashMap18 = hashMap5;
                hashMap17 = hashMap6;
                hashMap16 = hashMap9;
                hashMap27 = hashMap18;
                hashMap25 = hashMap13;
                hashMap23 = hashMap15;
                hashMap21 = hashMap11;
                hashMap31 = hashMap2;
                hashMap30 = hashMap3;
                hashMap29 = hashMap4;
                hashMap20 = hashMap12;
                hashMap28 = hashMap8;
                hashMap22 = hashMap10;
                HashMap<String, C0633za> hashMap362222 = hashMap17;
                hashMap24 = hashMap16;
                hashMap26 = hashMap362222;
            }
        }
        HashMap<String, C0601ra> hashMap41 = hashMap31;
        HashMap<String, C0594pa> hashMap42 = hashMap30;
        HashMap<String, C0598qa> hashMap43 = hashMap29;
        HashMap<String, Ca> hashMap44 = hashMap28;
        HashMap<String, C0621wa> hashMap45 = hashMap22;
        HashMap<String, C0272a> hashMap46 = hashMap21;
        HashMap<String, C0613ua> hashMap47 = hashMap20;
        HashMap<String, C0629ya> hashMap48 = hashMap25;
        HashMap<String, C0625xa> hashMap49 = hashMap23;
        HashMap<String, Aa> hashMap50 = hashMap27;
        HashMap<String, C0273b> hashMap51 = hashMap24;
        HashMap<String, C0633za> hashMap52 = hashMap26;
        if (hashMap47.size() > 0) {
            c0590oa.w = hashMap47;
        }
        if (hashMap46.size() > 0) {
            c0590oa.x = hashMap46;
        }
        if (hashMap45.size() > 0) {
            c0590oa.t = hashMap45;
        }
        if (hashMap49.size() > 0) {
            c0590oa.u = hashMap49;
        }
        if (hashMap51.size() > 0) {
            c0590oa.y = hashMap51;
        }
        if (hashMap48.size() > 0) {
            c0590oa.v = hashMap48;
        }
        if (hashMap52.size() > 0) {
            c0590oa.z = hashMap52;
        }
        if (hashMap50.size() > 0) {
            c0590oa.A = hashMap50;
        }
        if (hashMap44.size() > 0) {
            c0590oa.B = hashMap44;
        }
        if (hashMap43.size() > 0) {
            c0590oa.C = hashMap43;
        }
        if (hashMap42.size() > 0) {
            c0590oa.D = hashMap42;
        }
        if (hashMap41.size() > 0) {
            c0590oa.E = hashMap41;
        }
        if (hashMap32.size() > 0) {
            c0590oa.F = hashMap32;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C0590oa(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar2) {
        super(eVar, eVar2);
        k();
    }

    com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha) {
        for (com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha2 : h().c(ha)) {
            if (ha2.k() != null && ha2.k().equals("application/vnd.adobe.characterstyle+json")) {
                return ha2;
            }
        }
        return null;
    }
}

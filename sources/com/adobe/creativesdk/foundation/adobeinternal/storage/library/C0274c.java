package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ta;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.adobe.creativesdk.foundation.storage.C0578la;
import com.adobe.creativesdk.foundation.storage.qd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: AdobeAssetProductFolder.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.library.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0274c implements ta {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0276e f4592a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ qd f4593b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0276e f4594c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0274c(C0276e c0276e, C0276e c0276e2, qd qdVar) {
        this.f4594c = c0276e;
        this.f4592a = c0276e2;
        this.f4593b = qdVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ta
    public void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar) {
        char c2;
        com.adobe.creativesdk.foundation.internal.storage.model.resources.e g2;
        com.adobe.creativesdk.foundation.internal.storage.model.resources.e g3;
        com.adobe.creativesdk.foundation.internal.storage.model.resources.e g4;
        com.adobe.creativesdk.foundation.internal.storage.model.resources.e g5;
        com.adobe.creativesdk.foundation.internal.storage.model.resources.e g6;
        com.adobe.creativesdk.foundation.internal.storage.model.resources.e g7;
        com.adobe.creativesdk.foundation.internal.storage.model.resources.e g8;
        com.adobe.creativesdk.foundation.internal.storage.model.resources.e g9;
        if (eVar != null) {
            ((C0578la) this.f4594c).f7328a = eVar;
            ((C0578la) this.f4594c).f7329b = true;
            Pattern compile = Pattern.compile("assets/([-_\\w]+)/", 2);
            ArrayList<com.adobe.creativesdk.foundation.internal.storage.model.resources.b> d2 = eVar.d();
            ArrayList<C0533a> arrayList = new ArrayList<>();
            if (d2 != null) {
                Iterator<com.adobe.creativesdk.foundation.internal.storage.model.resources.b> it = d2.iterator();
                while (it.hasNext()) {
                    com.adobe.creativesdk.foundation.internal.storage.model.resources.b next = it.next();
                    if (next instanceof com.adobe.creativesdk.foundation.internal.storage.model.resources.e) {
                        com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar2 = (com.adobe.creativesdk.foundation.internal.storage.model.resources.e) next;
                        Matcher matcher = compile.matcher(eVar2.f6610b.getPath());
                        String str = "";
                        while (matcher.find()) {
                            str = matcher.group(1);
                        }
                        String lowerCase = str.toLowerCase();
                        switch (lowerCase.hashCode()) {
                            case -2094251973:
                                if (lowerCase.equals("adobe-libraries")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case -1906481573:
                                if (lowerCase.equals("adobesketch")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case -1469336143:
                                if (lowerCase.equals("adobe-psfix-cls")) {
                                    c2 = '\t';
                                    break;
                                }
                                break;
                            case -1191443663:
                                if (lowerCase.equals("adobecompandroid")) {
                                    c2 = 11;
                                    break;
                                }
                                break;
                            case -918586149:
                                if (lowerCase.equals("adobecls")) {
                                    c2 = '\f';
                                    break;
                                }
                                break;
                            case -620262827:
                                if (lowerCase.equals("adobeclsprojects")) {
                                    c2 = '\r';
                                    break;
                                }
                                break;
                            case -383257347:
                                if (lowerCase.equals("adobesketch-android")) {
                                    c2 = 4;
                                    break;
                                }
                                break;
                            case -245459650:
                                if (lowerCase.equals("adobeclsdemo")) {
                                    c2 = 14;
                                    break;
                                }
                                break;
                            case 89883625:
                                if (lowerCase.equals("adobefixandroid")) {
                                    c2 = '\b';
                                    break;
                                }
                                break;
                            case 246419292:
                                if (lowerCase.equals("adobedrawandroid")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 385254881:
                                if (lowerCase.equals("adobe-layup")) {
                                    c2 = '\n';
                                    break;
                                }
                                break;
                            case 389466580:
                                if (lowerCase.equals("adobe-psfix")) {
                                    c2 = 7;
                                    break;
                                }
                                break;
                            case 389473307:
                                if (lowerCase.equals("adobe-psmix")) {
                                    c2 = 5;
                                    break;
                                }
                                break;
                            case 1588635571:
                                if (lowerCase.equals("adobedraw")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case 1931753377:
                                if (lowerCase.equals("adobeclsmix")) {
                                    c2 = 6;
                                    break;
                                }
                                break;
                        }
                        c2 = 65535;
                        switch (c2) {
                            case 0:
                            case 1:
                                g3 = this.f4594c.g();
                                com.adobe.creativesdk.foundation.internal.storage.asset.b bVar = new com.adobe.creativesdk.foundation.internal.storage.asset.b(eVar2, g3);
                                bVar.setCloud(this.f4592a.getCloud());
                                arrayList.add(bVar);
                                break;
                            case 2:
                                g4 = this.f4594c.g();
                                com.adobe.creativesdk.foundation.internal.storage.asset.d dVar = new com.adobe.creativesdk.foundation.internal.storage.asset.d(eVar2, g4);
                                dVar.setCloud(this.f4592a.getCloud());
                                arrayList.add(dVar);
                                break;
                            case 3:
                            case 4:
                                g5 = this.f4594c.g();
                                com.adobe.creativesdk.foundation.internal.storage.asset.i iVar = new com.adobe.creativesdk.foundation.internal.storage.asset.i(eVar2, g5);
                                iVar.setCloud(this.f4592a.getCloud());
                                arrayList.add(iVar);
                                break;
                            case 5:
                            case 6:
                                g6 = this.f4594c.g();
                                com.adobe.creativesdk.foundation.internal.storage.asset.f fVar = new com.adobe.creativesdk.foundation.internal.storage.asset.f(eVar2, g6);
                                fVar.setCloud(this.f4592a.getCloud());
                                arrayList.add(fVar);
                                break;
                            case 7:
                            case '\b':
                            case '\t':
                                g7 = this.f4594c.g();
                                com.adobe.creativesdk.foundation.internal.storage.asset.e eVar3 = new com.adobe.creativesdk.foundation.internal.storage.asset.e(eVar2, g7);
                                eVar3.setCloud(this.f4592a.getCloud());
                                arrayList.add(eVar3);
                                break;
                            case '\n':
                            case 11:
                                g8 = this.f4594c.g();
                                com.adobe.creativesdk.foundation.internal.storage.asset.a aVar = new com.adobe.creativesdk.foundation.internal.storage.asset.a(eVar2, g8);
                                aVar.setCloud(this.f4592a.getCloud());
                                arrayList.add(aVar);
                                break;
                            case '\f':
                            case '\r':
                            case 14:
                                g9 = this.f4594c.g();
                                com.adobe.creativesdk.foundation.internal.storage.asset.h hVar = new com.adobe.creativesdk.foundation.internal.storage.asset.h(eVar2, g9);
                                hVar.setCloud(this.f4592a.getCloud());
                                arrayList.add(hVar);
                                break;
                            default:
                                g2 = this.f4594c.g();
                                com.adobe.creativesdk.foundation.internal.storage.asset.g gVar = new com.adobe.creativesdk.foundation.internal.storage.asset.g(eVar2, g2);
                                gVar.setCloud(this.f4592a.getCloud());
                                arrayList.add(gVar);
                                break;
                        }
                    }
                }
            }
            this.f4593b.a(arrayList, eVar.h());
        }
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        if (adobeAssetException != null) {
            this.f4593b.a(adobeAssetException);
        }
    }
}

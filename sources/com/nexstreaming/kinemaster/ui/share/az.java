package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.kinemaster.intent.a;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.ui.share.ShareIntentActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareIntentActivity.java */
/* loaded from: classes.dex */
public class az implements ShareIntentActivity.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.e f4310a;
    final /* synthetic */ ShareIntentActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ShareIntentActivity shareIntentActivity, com.nexstreaming.kinemaster.ui.a.e eVar) {
        this.b = shareIntentActivity;
        this.f4310a = eVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.share.ShareIntentActivity.c
    public void a(File file, MediaStoreItem mediaStoreItem) {
        int i;
        ArrayList arrayList;
        int i2;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        boolean a2;
        int i3;
        ShareIntentActivity.b(this.b);
        com.nexstreaming.kinemaster.ui.a.e eVar = this.f4310a;
        int a3 = this.f4310a.a();
        i = this.b.c;
        eVar.h(a3 - i);
        if (mediaStoreItem != null) {
            arrayList = this.b.e;
            arrayList.add(mediaStoreItem);
            i2 = this.b.c;
            if (i2 <= 0) {
                com.nexstreaming.kinemaster.intent.a aVar = new com.nexstreaming.kinemaster.intent.a();
                arrayList2 = this.b.e;
                if (arrayList2 != null) {
                    arrayList3 = this.b.e;
                    if (arrayList3.size() > 0) {
                        arrayList4 = this.b.e;
                        Iterator it = arrayList4.iterator();
                        while (it.hasNext()) {
                            MediaStoreItem mediaStoreItem2 = (MediaStoreItem) it.next();
                            a2 = this.b.a(mediaStoreItem2);
                            if (a2) {
                                switch (mediaStoreItem2.b()) {
                                    case IMAGE:
                                        a.C0069a a4 = aVar.b().a(mediaStoreItem2.h());
                                        i3 = this.b.d;
                                        a4.a(i3).a();
                                        break;
                                    case VIDEO:
                                    case FILE:
                                        aVar.a().a(mediaStoreItem2.h()).a(mediaStoreItem2.m()).a();
                                        break;
                                }
                            } else {
                                return;
                            }
                        }
                        this.b.d(aVar.c());
                    }
                }
            }
            if (this.f4310a.isShowing()) {
                try {
                    this.f4310a.dismiss();
                    return;
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        if (file != null) {
            this.b.a(file.getAbsolutePath());
        }
    }
}

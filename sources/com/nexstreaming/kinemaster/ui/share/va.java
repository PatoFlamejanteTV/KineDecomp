package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.kinemaster.intent.a;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.ui.share.Da;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareIntentCheckFragment.java */
/* loaded from: classes2.dex */
public class va implements Da.d {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Da f23393a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public va(Da da) {
        this.f23393a = da;
    }

    @Override // com.nexstreaming.kinemaster.ui.share.Da.d
    public void a(File file, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        Da.b bVar;
        Da.b bVar2;
        ArrayList arrayList;
        int i;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        boolean f2;
        int i2;
        Da.b(this.f23393a);
        if (cVar == null) {
            if (file != null) {
                bVar = this.f23393a.f23258e;
                if (bVar != null) {
                    bVar2 = this.f23393a.f23258e;
                    bVar2.a(file, MediaInfo.a(file), null);
                    return;
                }
                return;
            }
            return;
        }
        arrayList = this.f23393a.f23257d;
        arrayList.add(cVar);
        i = this.f23393a.f23255b;
        if (i <= 0) {
            com.nexstreaming.kinemaster.intent.a aVar = new com.nexstreaming.kinemaster.intent.a();
            arrayList2 = this.f23393a.f23257d;
            if (arrayList2 != null) {
                arrayList3 = this.f23393a.f23257d;
                if (arrayList3.size() > 0) {
                    arrayList4 = this.f23393a.f23257d;
                    Iterator it = arrayList4.iterator();
                    while (it.hasNext()) {
                        com.nexstreaming.kinemaster.mediastore.item.c cVar2 = (com.nexstreaming.kinemaster.mediastore.item.c) it.next();
                        f2 = this.f23393a.f(cVar2);
                        if (!f2) {
                            return;
                        }
                        int i3 = Ca.f23252a[cVar2.getType().ordinal()];
                        if (i3 == 1) {
                            a.C0107a b2 = aVar.b();
                            b2.a(cVar2.getPath());
                            i2 = this.f23393a.f23256c;
                            ((a.C0107a) b2.a(i2)).a();
                        } else if (i3 == 2 || i3 == 3) {
                            a.b c2 = aVar.c();
                            c2.a(cVar2.getPath());
                            ((a.b) c2.a(cVar2.getDuration())).a();
                        }
                    }
                    this.f23393a.d(aVar.a());
                }
            }
        }
    }
}

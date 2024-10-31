package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nexstreaming.kinemaster.ui.audiobrowser.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: ThemeMusicLister.java */
/* loaded from: classes.dex */
public class k extends f {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.f
    public List<n> b(Context context, long j) {
        int i;
        long parseLong;
        EffectLibrary a2 = EffectLibrary.a(context);
        HashMap hashMap = new HashMap();
        ArrayList<a> arrayList = new ArrayList();
        for (Theme theme : a2.c()) {
            String n = theme.n();
            if (n != null) {
                if (hashMap.containsKey(n)) {
                    a aVar = (a) hashMap.get(n);
                    aVar.c.add(theme.a(context));
                    Collections.sort(aVar.c);
                    StringBuilder sb = new StringBuilder();
                    for (String str : aVar.c) {
                        if (sb.length() > 0) {
                            sb.append(", ");
                        }
                        sb.append(str);
                    }
                    aVar.b = sb.toString();
                } else {
                    a aVar2 = new a(null);
                    aVar2.f3665a = theme.i();
                    aVar2.b = theme.a(context);
                    aVar2.c.add(aVar2.b);
                    arrayList.add(aVar2);
                    hashMap.put(n, aVar2);
                }
            }
        }
        Collections.sort(arrayList, new l(this));
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (a aVar3 : arrayList) {
            File h = a2.h(aVar3.f3665a);
            if (h != null) {
                String absolutePath = h.getAbsolutePath();
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(absolutePath);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                if (extractMetadata != null) {
                    try {
                        parseLong = Long.parseLong(extractMetadata);
                    } catch (NumberFormatException e) {
                        i = -1;
                    }
                    if (parseLong < 2147483647L) {
                        i = (int) parseLong;
                        arrayList2.add(new n(aVar3.b, i, "@theme:" + aVar3.f3665a, absolutePath));
                    }
                }
                i = -1;
                arrayList2.add(new n(aVar3.b, i, "@theme:" + aVar3.f3665a, absolutePath));
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ThemeMusicLister.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f3665a;
        String b;
        List<String> c;

        private a() {
            this.c = new ArrayList();
        }

        /* synthetic */ a(l lVar) {
            this();
        }
    }
}

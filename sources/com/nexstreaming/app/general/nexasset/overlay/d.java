package com.nexstreaming.app.general.nexasset.overlay;

import com.nexstreaming.app.general.nexasset.assetpackage.h;
import com.nexstreaming.app.general.nexasset.assetpackage.r;
import com.nexstreaming.app.general.nexasset.overlay.a.e;
import com.nexstreaming.app.general.nexasset.overlay.a.g;
import com.nexstreaming.app.general.nexasset.overlay.a.i;
import com.nexstreaming.app.general.nexasset.overlay.a.k;
import com.nexstreaming.app.general.util.D;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: OverlayAssetFactory.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, WeakReference<b>> f19639a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static int f19640b = 0;

    public static b a(String str) throws IOException, XmlPullParserException {
        b bVar;
        WeakReference<b> weakReference = f19639a.get(str);
        if (weakReference != null && (bVar = weakReference.get()) != null) {
            return bVar;
        }
        b bVar2 = null;
        r a2 = h.e().a(str);
        if (a2 != null) {
            int i = c.f19638a[a2.getType().ordinal()];
            if (i == 1) {
                String filePath = a2.getFilePath();
                String substring = filePath.substring(filePath.lastIndexOf(46) + 1);
                if (!substring.equalsIgnoreCase("png") && !substring.equalsIgnoreCase("jpeg") && !substring.equalsIgnoreCase("jpg") && !substring.equalsIgnoreCase("webp")) {
                    if (substring.equalsIgnoreCase("svg")) {
                        bVar2 = new k(a2);
                    } else if (substring.equalsIgnoreCase("xml")) {
                        bVar2 = new com.nexstreaming.app.general.nexasset.overlay.a.c(a2);
                    } else {
                        throw new IOException("Asset load error: " + str + " (unknown overlay type for '" + filePath + "')");
                    }
                } else {
                    bVar2 = new e(a2);
                }
            } else {
                if (i == 2) {
                    return new g(a2);
                }
                if (i == 3) {
                    bVar2 = new i(a2);
                }
            }
            if (bVar2 != null) {
                f19639a.put(str, new WeakReference<>(bVar2));
                int i2 = f19640b;
                f19640b = i2 + 1;
                if (i2 > 32) {
                    D.a(f19639a);
                    f19640b = 0;
                }
            }
            return bVar2;
        }
        throw new IOException("Asset not found: " + str);
    }
}

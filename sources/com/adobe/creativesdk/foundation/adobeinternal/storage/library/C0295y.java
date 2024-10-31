package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.internal.storage.a.b.va;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryBookmarkManager.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.library.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0295y implements va {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f4667a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ja f4668b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ B f4669c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0295y(B b2, byte[] bArr, ja jaVar) {
        this.f4669c = b2;
        this.f4667a = bArr;
        this.f4668b = jaVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.va
    public void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "BOOKMARK", " downloadBookmarksFile onComplete");
        synchronized (this) {
            this.f4669c.i = fVar;
            if (fVar != null && fVar.d() != null && fVar.d().length > 2 && !Arrays.equals(this.f4667a, fVar.d())) {
                try {
                    JSONObject a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(new String(fVar.d(), "UTF-8"));
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "BOOKMARK", a2.toString());
                    this.f4669c.j = true;
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "BOOKMARK", " downloadBookmarksFile onComplete123");
                    this.f4668b.a(this.f4669c.a(a2));
                } catch (UnsupportedEncodingException e2) {
                    this.f4668b.a((ja) e2);
                }
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "BOOKMARK", " downloadBookmarksFile onComplete12345");
                this.f4668b.a((ArrayList<C0291u>) null);
            }
        }
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "BOOKMARK", " downloadBookmarksFile onError");
        this.f4668b.a((ja) adobeAssetException);
    }
}

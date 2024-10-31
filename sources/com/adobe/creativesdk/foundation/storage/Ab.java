package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.Gb;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryManager.java */
/* loaded from: classes.dex */
public class Ab implements Gb.a<Object> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.adobeinternal.storage.library.D f6924a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f6925b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Gb f6926c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ab(Gb gb, com.adobe.creativesdk.foundation.adobeinternal.storage.library.D d2, String str) {
        this.f6926c = gb;
        this.f6924a = d2;
        this.f6925b = str;
    }

    @Override // com.adobe.creativesdk.foundation.storage.Gb.a
    public boolean b(Object obj) {
        if (((Integer) obj).intValue() != 0) {
            return true;
        }
        try {
            this.f6924a.g(this.f6925b);
            return false;
        } catch (AdobeDCXException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
            return true;
        }
    }
}

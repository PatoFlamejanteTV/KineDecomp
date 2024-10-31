package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Sc;
import com.adobe.creativesdk.foundation.internal.storage.controllers.b.a;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryException;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DesignLibraryItemsListView.java */
/* loaded from: classes.dex */
public class Vc implements com.adobe.creativesdk.foundation.storage.sd<String, AdobeLibraryException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a.e f5874a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0622wb f5875b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0582ma f5876c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0622wb f5877d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Sc.c f5878e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Vc(Sc.c cVar, a.e eVar, C0622wb c0622wb, C0582ma c0582ma, C0622wb c0622wb2) {
        this.f5878e = cVar;
        this.f5874a = eVar;
        this.f5875b = c0622wb;
        this.f5876c = c0582ma;
        this.f5877d = c0622wb2;
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // c.a.a.a.c
    public void a(AdobeLibraryException adobeLibraryException) {
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(String str) {
        if (str != null && !str.isEmpty()) {
            if (new File(str).exists()) {
                Sc.this.H.a(this.f5875b.c(), str, this.f5876c, new Tc(this), new Uc(this));
                return;
            } else {
                this.f5874a.a((BitmapDrawable) null);
                return;
            }
        }
        this.f5874a.a((Bitmap) null);
    }
}

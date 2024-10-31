package com.adobe.creativesdk.foundation.internal.storage.controllers.b;

import android.os.Bundle;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Jc;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import java.util.List;

/* compiled from: LibraryItemsOneUpViewController.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private C0614ub f5952a;

    /* renamed from: b, reason: collision with root package name */
    private int f5953b;

    /* renamed from: c, reason: collision with root package name */
    private List<C0622wb> f5954c;

    private c() {
    }

    public static c a(Bundle bundle) {
        c cVar = new c();
        C0614ub i = Jc.i(bundle.getString("library_id"));
        cVar.b(bundle.getInt("startindex"));
        cVar.a(i);
        return cVar;
    }

    private void d() {
        this.f5954c.addAll(new c.a.a.a.a.b.a.b.a.d.a().a(this.f5952a));
        this.f5954c.addAll(new c.a.a.a.a.b.a.b.a.e.a().a(this.f5952a));
        this.f5954c.addAll(new c.a.a.a.a.b.a.b.a.f.a().a(this.f5952a));
    }

    public C0614ub b() {
        return this.f5952a;
    }

    public int c() {
        return this.f5953b;
    }

    private void b(int i) {
        this.f5953b = i;
    }

    public void b(Bundle bundle) {
        bundle.putInt("startindex", this.f5953b);
        bundle.putString("library_id", this.f5952a.k());
    }

    private void a(C0614ub c0614ub, List<C0622wb> list) {
        this.f5952a = c0614ub;
        this.f5954c = list;
    }

    private void a(C0614ub c0614ub) {
        this.f5952a = c0614ub;
        d();
    }

    public static c a(C0614ub c0614ub, List<C0622wb> list, int i) {
        c cVar = new c();
        cVar.a(c0614ub, list);
        cVar.b(i);
        return cVar;
    }

    public int a() {
        List<C0622wb> list = this.f5954c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public C0622wb a(int i) {
        List<C0622wb> list = this.f5954c;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.f5954c.get(i);
    }
}

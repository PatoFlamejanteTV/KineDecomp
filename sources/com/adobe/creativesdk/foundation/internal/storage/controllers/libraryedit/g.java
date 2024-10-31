package com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit;

import android.os.Handler;
import android.support.v4.util.Pair;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryException;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import com.adobe.creativesdk.foundation.storage.Hb;
import com.adobe.creativesdk.foundation.storage.vd;
import com.facebook.share.internal.ShareConstants;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: AdobeDesignLibraryEditSession.java */
/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a */
    Hb f6211a;

    /* renamed from: b */
    final /* synthetic */ C0614ub f6212b;

    /* renamed from: c */
    final /* synthetic */ C0622wb f6213c;

    /* renamed from: d */
    final /* synthetic */ List f6214d;

    /* renamed from: e */
    final /* synthetic */ Handler f6215e;

    /* renamed from: f */
    final /* synthetic */ vd f6216f;

    /* renamed from: g */
    final /* synthetic */ l f6217g;

    public g(l lVar, Hb hb, C0614ub c0614ub, C0622wb c0622wb, List list, Handler handler, vd vdVar) {
        this.f6217g = lVar;
        this.f6212b = c0614ub;
        this.f6213c = c0622wb;
        this.f6214d = list;
        this.f6215e = handler;
        this.f6216f = vdVar;
        this.f6211a = hb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        Pair a2;
        boolean z;
        int i;
        c cVar = new c(this.f6217g);
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        if (!this.f6211a.o() && this.f6211a.b() != null) {
            this.f6212b.a(this.f6211a, new d(this, reentrantLock, newCondition, cVar), new e(this, reentrantLock, newCondition, cVar), (Handler) null);
        } else {
            reentrantLock.lock();
            try {
                if (!this.f6211a.o()) {
                    a2 = this.f6217g.a(this.f6211a);
                    this.f6213c.a(this.f6211a.h(), this.f6211a.j()).a(a2.second, ShareConstants.WEB_DIALOG_PARAM_DATA, (String) a2.first);
                } else {
                    this.f6213c.a(this.f6211a.m(), null, this.f6211a.c().toString(), true, this.f6211a.j(), null, null, true);
                }
                l.c(this.f6217g);
            } catch (AdobeLibraryException e2) {
                e2.printStackTrace();
            }
            newCondition.signal();
            cVar.f6200a = true;
            reentrantLock.unlock();
        }
        reentrantLock.lock();
        while (!cVar.f6200a) {
            try {
                newCondition.await();
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
        synchronized (this.f6217g) {
            z = this.f6217g.f6232g;
            if (!z) {
                i = this.f6217g.f6231f;
                if (i == this.f6214d.size()) {
                    this.f6217g.f6232g = true;
                    this.f6215e.post(new f(this));
                }
            }
        }
    }
}

package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.ContainerHolder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zzo implements ContainerHolder {

    /* renamed from: a, reason: collision with root package name */
    private final Looper f2241a = null;
    private Container b;
    private Container c;
    private Status d;
    private a e;
    private zza f;
    private boolean g;
    private TagManager h;

    /* loaded from: classes.dex */
    private class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ zzo f2242a;
        private final ContainerHolder.ContainerAvailableListener b;

        protected void a(String str) {
            this.b.a(this.f2242a, str);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    a((String) message.obj);
                    return;
                default:
                    zzbg.a("Don't know how to handle this message.");
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface zza {
        void a();

        void a(String str);

        String b();
    }

    public zzo(Status status) {
        this.d = status;
    }

    public synchronized void a() {
        if (this.g) {
            zzbg.a("Refreshing a released ContainerHolder.");
        } else {
            this.f.a();
        }
    }

    public synchronized void a(String str) {
        if (!this.g) {
            this.b.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        if (!this.g) {
            return this.b.a();
        }
        zzbg.a("getContainerId called on a released ContainerHolder.");
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        if (this.g) {
            zzbg.a("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.f.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        if (!this.g) {
            return this.f.b();
        }
        zzbg.a("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.d;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public synchronized void release() {
        if (this.g) {
            zzbg.a("Releasing a released ContainerHolder.");
        } else {
            this.g = true;
            this.h.a(this);
            this.b.b();
            this.b = null;
            this.c = null;
            this.f = null;
            this.e = null;
        }
    }
}

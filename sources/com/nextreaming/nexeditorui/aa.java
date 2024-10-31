package com.nextreaming.nexeditorui;

import android.os.Handler;
import android.os.Message;
import android.view.Display;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: NexInterfaceOrientationMonitor.java */
/* loaded from: classes.dex */
public class Aa {

    /* renamed from: a */
    private final Display f23973a;

    /* renamed from: b */
    private int f23974b = -1;

    /* renamed from: c */
    private List<a> f23975c = new ArrayList();

    /* renamed from: d */
    private boolean f23976d = false;

    /* renamed from: e */
    private final Handler f23977e = new b(this);

    /* compiled from: NexInterfaceOrientationMonitor.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NexInterfaceOrientationMonitor.java */
    /* loaded from: classes.dex */
    public static class b extends Handler {

        /* renamed from: a */
        private final WeakReference<Aa> f23978a;

        public b(Aa aa) {
            this.f23978a = new WeakReference<>(aa);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                removeMessages(1);
                Aa aa = this.f23978a.get();
                if (aa != null && aa.f23976d) {
                    sendEmptyMessageDelayed(1, 250L);
                    int rotation = aa.f23973a.getRotation();
                    if (aa.f23974b != -1) {
                        if (aa.f23974b != rotation) {
                            Iterator it = aa.f23975c.iterator();
                            while (it.hasNext()) {
                                ((a) it.next()).a(aa.f23974b, rotation);
                            }
                            aa.a(aa.f23974b, rotation);
                            aa.f23974b = rotation;
                        }
                    } else {
                        aa.f23974b = rotation;
                    }
                }
            }
            super.handleMessage(message);
        }
    }

    public Aa(Display display) {
        this.f23973a = display;
    }

    protected void a(int i, int i2) {
    }

    public void b() {
        if (this.f23976d) {
            this.f23976d = false;
            this.f23977e.removeMessages(1);
        }
    }

    public void a(a aVar) {
        if (this.f23975c.contains(aVar)) {
            return;
        }
        this.f23975c.add(aVar);
    }

    public void a() {
        if (this.f23976d) {
            return;
        }
        this.f23976d = true;
        this.f23977e.removeMessages(1);
        this.f23977e.sendEmptyMessage(1);
    }
}

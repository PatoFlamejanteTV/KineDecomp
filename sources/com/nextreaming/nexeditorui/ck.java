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
public class ck {

    /* renamed from: a, reason: collision with root package name */
    private final Display f4574a;
    private int b = -1;
    private List<a> c = new ArrayList();
    private boolean d = false;
    private final Handler e = new b(this);

    /* compiled from: NexInterfaceOrientationMonitor.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(int i, int i2);
    }

    /* compiled from: NexInterfaceOrientationMonitor.java */
    /* loaded from: classes.dex */
    private static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<ck> f4575a;

        public b(ck ckVar) {
            this.f4575a = new WeakReference<>(ckVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    ck ckVar = this.f4575a.get();
                    if (ckVar != null && ckVar.d) {
                        sendEmptyMessageDelayed(1, 250L);
                        int rotation = ckVar.f4574a.getRotation();
                        if (ckVar.b == -1) {
                            ckVar.b = rotation;
                            break;
                        } else if (ckVar.b != rotation) {
                            Iterator it = ckVar.c.iterator();
                            while (it.hasNext()) {
                                ((a) it.next()).a(ckVar.b, rotation);
                            }
                            ckVar.a(ckVar.b, rotation);
                            ckVar.b = rotation;
                            break;
                        }
                    }
                    break;
            }
            super.handleMessage(message);
        }
    }

    public ck(Display display) {
        this.f4574a = display;
    }

    public void a(a aVar) {
        if (!this.c.contains(aVar)) {
            this.c.add(aVar);
        }
    }

    protected void a(int i, int i2) {
    }

    public void a() {
        if (!this.d) {
            this.d = true;
            this.e.removeMessages(1);
            this.e.sendEmptyMessage(1);
        }
    }

    public void b() {
        if (this.d) {
            this.d = false;
            this.e.removeMessages(1);
        }
    }
}

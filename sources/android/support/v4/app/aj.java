package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.al;
import android.support.v4.app.am;
import android.support.v4.app.an;
import android.support.v4.app.aq;
import android.support.v4.app.ar;
import android.support.v4.app.as;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: NotificationCompat.java */
/* loaded from: classes.dex */
public class aj {

    /* renamed from: a, reason: collision with root package name */
    private static final g f36a;

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class b extends p {

        /* renamed from: a, reason: collision with root package name */
        Bitmap f38a;
        Bitmap b;
        boolean c;
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class c extends p {

        /* renamed from: a, reason: collision with root package name */
        CharSequence f39a;
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class f extends p {

        /* renamed from: a, reason: collision with root package name */
        ArrayList<CharSequence> f41a = new ArrayList<>();
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    interface g {
        Notification a(d dVar, e eVar);
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static abstract class p {
        CharSequence d;
        CharSequence e;
        boolean f = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class e {
        protected e() {
        }

        public Notification a(d dVar, ai aiVar) {
            return aiVar.b();
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    static class j implements g {
        j() {
        }

        @Override // android.support.v4.app.aj.g
        public Notification a(d dVar, e eVar) {
            Notification notification = dVar.B;
            notification.setLatestEventInfo(dVar.f40a, dVar.b, dVar.c, dVar.d);
            if (dVar.j > 0) {
                notification.flags |= 128;
            }
            return notification;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    static class k extends j {
        k() {
        }

        @Override // android.support.v4.app.aj.j, android.support.v4.app.aj.g
        public Notification a(d dVar, e eVar) {
            Notification notification = dVar.B;
            notification.setLatestEventInfo(dVar.f40a, dVar.b, dVar.c, dVar.d);
            Notification a2 = ao.a(notification, dVar.f40a, dVar.b, dVar.c, dVar.d, dVar.e);
            if (dVar.j > 0) {
                a2.flags |= 128;
            }
            return a2;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    static class l extends j {
        l() {
        }

        @Override // android.support.v4.app.aj.j, android.support.v4.app.aj.g
        public Notification a(d dVar, e eVar) {
            return ap.a(dVar.f40a, dVar.B, dVar.b, dVar.c, dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g);
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    static class m extends j {
        m() {
        }

        @Override // android.support.v4.app.aj.j, android.support.v4.app.aj.g
        public Notification a(d dVar, e eVar) {
            return eVar.a(dVar, new aq.a(dVar.f40a, dVar.B, dVar.b, dVar.c, dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.o, dVar.p, dVar.q));
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    static class n extends j {
        n() {
        }

        @Override // android.support.v4.app.aj.j, android.support.v4.app.aj.g
        public Notification a(d dVar, e eVar) {
            ar.a aVar = new ar.a(dVar.f40a, dVar.B, dVar.b, dVar.c, dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.o, dVar.p, dVar.q, dVar.l, dVar.j, dVar.n, dVar.v, dVar.x, dVar.r, dVar.s, dVar.t);
            aj.b(aVar, dVar.u);
            aj.b(aVar, dVar.m);
            return eVar.a(dVar, aVar);
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    static class o extends n {
        o() {
        }

        @Override // android.support.v4.app.aj.n, android.support.v4.app.aj.j, android.support.v4.app.aj.g
        public Notification a(d dVar, e eVar) {
            as.a aVar = new as.a(dVar.f40a, dVar.B, dVar.b, dVar.c, dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.o, dVar.p, dVar.q, dVar.k, dVar.l, dVar.j, dVar.n, dVar.v, dVar.C, dVar.x, dVar.r, dVar.s, dVar.t);
            aj.b(aVar, dVar.u);
            aj.b(aVar, dVar.m);
            return eVar.a(dVar, aVar);
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    static class h extends o {
        h() {
        }

        @Override // android.support.v4.app.aj.o, android.support.v4.app.aj.n, android.support.v4.app.aj.j, android.support.v4.app.aj.g
        public Notification a(d dVar, e eVar) {
            al.a aVar = new al.a(dVar.f40a, dVar.B, dVar.b, dVar.c, dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.o, dVar.p, dVar.q, dVar.k, dVar.l, dVar.j, dVar.n, dVar.v, dVar.C, dVar.x, dVar.r, dVar.s, dVar.t);
            aj.b(aVar, dVar.u);
            aj.b(aVar, dVar.m);
            return eVar.a(dVar, aVar);
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    static class i extends h {
        i() {
        }

        @Override // android.support.v4.app.aj.h, android.support.v4.app.aj.o, android.support.v4.app.aj.n, android.support.v4.app.aj.j, android.support.v4.app.aj.g
        public Notification a(d dVar, e eVar) {
            am.a aVar = new am.a(dVar.f40a, dVar.B, dVar.b, dVar.c, dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.o, dVar.p, dVar.q, dVar.k, dVar.l, dVar.j, dVar.n, dVar.v, dVar.w, dVar.C, dVar.x, dVar.y, dVar.z, dVar.A, dVar.r, dVar.s, dVar.t);
            aj.b(aVar, dVar.u);
            aj.b(aVar, dVar.m);
            return eVar.a(dVar, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ah ahVar, ArrayList<a> arrayList) {
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            ahVar.a(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ai aiVar, p pVar) {
        if (pVar != null) {
            if (pVar instanceof c) {
                c cVar = (c) pVar;
                ar.a(aiVar, cVar.d, cVar.f, cVar.e, cVar.f39a);
            } else if (pVar instanceof f) {
                f fVar = (f) pVar;
                ar.a(aiVar, fVar.d, fVar.f, fVar.e, fVar.f41a);
            } else if (pVar instanceof b) {
                b bVar = (b) pVar;
                ar.a(aiVar, bVar.d, bVar.f, bVar.e, bVar.f38a, bVar.b, bVar.c);
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f36a = new i();
            return;
        }
        if (Build.VERSION.SDK_INT >= 20) {
            f36a = new h();
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            f36a = new o();
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            f36a = new n();
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            f36a = new m();
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            f36a = new l();
        } else if (Build.VERSION.SDK_INT >= 9) {
            f36a = new k();
        } else {
            f36a = new j();
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class d {
        Notification A;
        public ArrayList<String> C;

        /* renamed from: a, reason: collision with root package name */
        public Context f40a;
        public CharSequence b;
        public CharSequence c;
        PendingIntent d;
        PendingIntent e;
        RemoteViews f;
        public Bitmap g;
        public CharSequence h;
        public int i;
        int j;
        public boolean l;
        public p m;
        public CharSequence n;
        int o;
        int p;
        boolean q;
        String r;
        boolean s;
        String t;
        String w;
        Bundle x;
        boolean k = true;
        public ArrayList<a> u = new ArrayList<>();
        boolean v = false;
        int y = 0;
        int z = 0;
        public Notification B = new Notification();

        public d(Context context) {
            this.f40a = context;
            this.B.when = System.currentTimeMillis();
            this.B.audioStreamType = -1;
            this.j = 0;
            this.C = new ArrayList<>();
        }

        public d a(long j) {
            this.B.when = j;
            return this;
        }

        public d a(int i) {
            this.B.icon = i;
            return this;
        }

        public d a(CharSequence charSequence) {
            this.b = c(charSequence);
            return this;
        }

        public d b(CharSequence charSequence) {
            this.c = c(charSequence);
            return this;
        }

        public d a(PendingIntent pendingIntent) {
            this.d = pendingIntent;
            return this;
        }

        public d a(Uri uri) {
            this.B.sound = uri;
            this.B.audioStreamType = -1;
            return this;
        }

        public d a(boolean z) {
            a(16, z);
            return this;
        }

        public d b(int i) {
            this.B.defaults = i;
            if ((i & 4) != 0) {
                this.B.flags |= 1;
            }
            return this;
        }

        private void a(int i, boolean z) {
            if (z) {
                this.B.flags |= i;
            } else {
                this.B.flags &= i ^ (-1);
            }
        }

        public Notification a() {
            return aj.f36a.a(this, b());
        }

        protected e b() {
            return new e();
        }

        protected static CharSequence c(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class a extends an.a {
        public static final an.a.InterfaceC0004a d = new ak();

        /* renamed from: a, reason: collision with root package name */
        public int f37a;
        public CharSequence b;
        public PendingIntent c;
        private final Bundle e;
        private final at[] f;

        @Override // android.support.v4.app.an.a
        public int a() {
            return this.f37a;
        }

        @Override // android.support.v4.app.an.a
        public CharSequence b() {
            return this.b;
        }

        @Override // android.support.v4.app.an.a
        public PendingIntent c() {
            return this.c;
        }

        @Override // android.support.v4.app.an.a
        public Bundle d() {
            return this.e;
        }

        @Override // android.support.v4.app.an.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public at[] f() {
            return this.f;
        }
    }
}

package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.a.e;
import android.support.v4.app.ac;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* compiled from: LoaderManager.java */
/* loaded from: classes.dex */
public class ad extends ac {

    /* renamed from: a */
    static boolean f33a = false;
    final android.support.v4.f.j<a> b = new android.support.v4.f.j<>();
    final android.support.v4.f.j<a> c = new android.support.v4.f.j<>();
    final String d;
    l e;
    boolean f;
    boolean g;

    /* compiled from: LoaderManager.java */
    /* loaded from: classes.dex */
    public final class a implements e.a<Object> {

        /* renamed from: a */
        final int f34a;
        final Bundle b;
        ac.a<Object> c;
        android.support.v4.a.e<Object> d;
        boolean e;
        boolean f;
        Object g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        a n;
        final /* synthetic */ ad o;

        void a() {
            if (this.i && this.j) {
                this.h = true;
                return;
            }
            if (!this.h) {
                this.h = true;
                if (ad.f33a) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.d == null && this.c != null) {
                    this.d = this.c.a(this.f34a, this.b);
                }
                if (this.d != null) {
                    if (this.d.getClass().isMemberClass() && !Modifier.isStatic(this.d.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.d);
                    }
                    if (!this.m) {
                        this.d.a(this.f34a, this);
                        this.m = true;
                    }
                    this.d.a();
                }
            }
        }

        void b() {
            if (ad.f33a) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.i = true;
            this.j = this.h;
            this.h = false;
            this.c = null;
        }

        void c() {
            if (this.i) {
                if (ad.f33a) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.i = false;
                if (this.h != this.j && !this.h) {
                    e();
                }
            }
            if (this.h && this.e && !this.k) {
                a(this.d, this.g);
            }
        }

        void d() {
            if (this.h && this.k) {
                this.k = false;
                if (this.e) {
                    a(this.d, this.g);
                }
            }
        }

        void e() {
            if (ad.f33a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.h = false;
            if (!this.i && this.d != null && this.m) {
                this.m = false;
                this.d.a((e.a<Object>) this);
                this.d.c();
            }
        }

        void f() {
            String str;
            if (ad.f33a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.l = true;
            boolean z = this.f;
            this.f = false;
            if (this.c != null && this.d != null && this.e && z) {
                if (ad.f33a) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.o.e != null) {
                    String str2 = this.o.e.mFragments.u;
                    this.o.e.mFragments.u = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.c.a(this.d);
                } finally {
                    if (this.o.e != null) {
                        this.o.e.mFragments.u = str;
                    }
                }
            }
            this.c = null;
            this.g = null;
            this.e = false;
            if (this.d != null) {
                if (this.m) {
                    this.m = false;
                    this.d.a((e.a<Object>) this);
                }
                this.d.e();
            }
            if (this.n != null) {
                this.n.f();
            }
        }

        void a(android.support.v4.a.e<Object> eVar, Object obj) {
            String str;
            if (this.c != null) {
                if (this.o.e == null) {
                    str = null;
                } else {
                    String str2 = this.o.e.mFragments.u;
                    this.o.e.mFragments.u = "onLoadFinished";
                    str = str2;
                }
                try {
                    if (ad.f33a) {
                        Log.v("LoaderManager", "  onLoadFinished in " + eVar + ": " + eVar.a((android.support.v4.a.e<Object>) obj));
                    }
                    this.c.a((android.support.v4.a.e<android.support.v4.a.e<Object>>) eVar, (android.support.v4.a.e<Object>) obj);
                    this.f = true;
                } finally {
                    if (this.o.e != null) {
                        this.o.e.mFragments.u = str;
                    }
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f34a);
            sb.append(" : ");
            android.support.v4.f.d.a(this.d, sb);
            sb.append("}}");
            return sb.toString();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f34a);
            printWriter.print(" mArgs=");
            printWriter.println(this.b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.d);
            if (this.d != null) {
                this.d.a(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.e || this.f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.m);
            if (this.n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.n);
                printWriter.println(":");
                this.n.a(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    public ad(String str, l lVar, boolean z) {
        this.d = str;
        this.e = lVar;
        this.f = z;
    }

    public void a(l lVar) {
        this.e = lVar;
    }

    public void b() {
        if (f33a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
        } else {
            this.f = true;
            for (int b = this.b.b() - 1; b >= 0; b--) {
                this.b.b(b).a();
            }
        }
    }

    public void c() {
        if (f33a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (!this.f) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
        } else {
            for (int b = this.b.b() - 1; b >= 0; b--) {
                this.b.b(b).e();
            }
            this.f = false;
        }
    }

    public void d() {
        if (f33a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (!this.f) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
        } else {
            this.g = true;
            this.f = false;
            for (int b = this.b.b() - 1; b >= 0; b--) {
                this.b.b(b).b();
            }
        }
    }

    public void e() {
        if (this.g) {
            if (f33a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.g = false;
            for (int b = this.b.b() - 1; b >= 0; b--) {
                this.b.b(b).c();
            }
        }
    }

    public void f() {
        for (int b = this.b.b() - 1; b >= 0; b--) {
            this.b.b(b).k = true;
        }
    }

    public void g() {
        for (int b = this.b.b() - 1; b >= 0; b--) {
            this.b.b(b).d();
        }
    }

    public void h() {
        if (!this.g) {
            if (f33a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int b = this.b.b() - 1; b >= 0; b--) {
                this.b.b(b).f();
            }
            this.b.c();
        }
        if (f33a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int b2 = this.c.b() - 1; b2 >= 0; b2--) {
            this.c.b(b2).f();
        }
        this.c.c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        android.support.v4.f.d.a(this.e, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.b.b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.b.b(); i++) {
                a b = this.b.b(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.b.a(i));
                printWriter.print(": ");
                printWriter.println(b.toString());
                b.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.c.b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.c.b(); i2++) {
                a b2 = this.c.b(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.c.a(i2));
                printWriter.print(": ");
                printWriter.println(b2.toString());
                b2.a(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // android.support.v4.app.ac
    public boolean a() {
        int b = this.b.b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            a b2 = this.b.b(i);
            z |= b2.h && !b2.f;
        }
        return z;
    }
}

package android.support.v4.app;

import android.arch.lifecycle.e;
import android.arch.lifecycle.l;
import android.arch.lifecycle.m;
import android.arch.lifecycle.p;
import android.arch.lifecycle.q;
import android.arch.lifecycle.r;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* loaded from: classes.dex */
public class LoaderManagerImpl extends LoaderManager {

    /* renamed from: a */
    static boolean f905a = false;

    /* renamed from: b */
    private final e f906b;

    /* renamed from: c */
    private final LoaderViewModel f907c;

    /* renamed from: d */
    private boolean f908d;

    /* loaded from: classes.dex */
    public static class LoaderObserver<D> implements m<D> {

        /* renamed from: a */
        private final Loader<D> f909a;

        /* renamed from: b */
        private final LoaderManager.LoaderCallbacks<D> f910b;

        /* renamed from: c */
        private boolean f911c = false;

        LoaderObserver(Loader<D> loader, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            this.f909a = loader;
            this.f910b = loaderCallbacks;
        }

        boolean a() {
            return this.f911c;
        }

        void b() {
            if (this.f911c) {
                if (LoaderManagerImpl.f905a) {
                    Log.v("LoaderManager", "  Resetting: " + this.f909a);
                }
                this.f910b.onLoaderReset(this.f909a);
            }
        }

        public void dump(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f911c);
        }

        @Override // android.arch.lifecycle.m
        public void onChanged(D d2) {
            if (LoaderManagerImpl.f905a) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f909a + ": " + this.f909a.dataToString(d2));
            }
            this.f910b.onLoadFinished(this.f909a, d2);
            this.f911c = true;
        }

        public String toString() {
            return this.f910b.toString();
        }
    }

    /* loaded from: classes.dex */
    public static class LoaderViewModel extends p {

        /* renamed from: a */
        private static final q.a f912a = new q.a() { // from class: android.support.v4.app.LoaderManagerImpl.LoaderViewModel.1
            AnonymousClass1() {
            }

            @Override // android.arch.lifecycle.q.a
            public <T extends p> T create(Class<T> cls) {
                return new LoaderViewModel();
            }
        };

        /* renamed from: b */
        private SparseArrayCompat<LoaderInfo> f913b = new SparseArrayCompat<>();

        /* renamed from: android.support.v4.app.LoaderManagerImpl$LoaderViewModel$1 */
        /* loaded from: classes.dex */
        static class AnonymousClass1 implements q.a {
            AnonymousClass1() {
            }

            @Override // android.arch.lifecycle.q.a
            public <T extends p> T create(Class<T> cls) {
                return new LoaderViewModel();
            }
        }

        LoaderViewModel() {
        }

        static LoaderViewModel a(r rVar) {
            return (LoaderViewModel) new q(rVar, f912a).a(LoaderViewModel.class);
        }

        void b(int i) {
            this.f913b.remove(i);
        }

        void c() {
            int size = this.f913b.size();
            for (int i = 0; i < size; i++) {
                this.f913b.valueAt(i).f();
            }
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f913b.size() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.f913b.size(); i++) {
                    LoaderInfo valueAt = this.f913b.valueAt(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f913b.keyAt(i));
                    printWriter.print(": ");
                    printWriter.println(valueAt.toString());
                    valueAt.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void a(int i, LoaderInfo loaderInfo) {
            this.f913b.put(i, loaderInfo);
        }

        boolean b() {
            int size = this.f913b.size();
            for (int i = 0; i < size; i++) {
                if (this.f913b.valueAt(i).e()) {
                    return true;
                }
            }
            return false;
        }

        <D> LoaderInfo<D> a(int i) {
            return this.f913b.get(i);
        }

        @Override // android.arch.lifecycle.p
        public void a() {
            super.a();
            int size = this.f913b.size();
            for (int i = 0; i < size; i++) {
                this.f913b.valueAt(i).a(true);
            }
            this.f913b.clear();
        }
    }

    public LoaderManagerImpl(e eVar, r rVar) {
        this.f906b = eVar;
        this.f907c = LoaderViewModel.a(rVar);
    }

    private <D> Loader<D> a(int i, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks, Loader<D> loader) {
        try {
            this.f908d = true;
            Loader<D> onCreateLoader = loaderCallbacks.onCreateLoader(i, bundle);
            if (onCreateLoader.getClass().isMemberClass() && !Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
            }
            LoaderInfo loaderInfo = new LoaderInfo(i, bundle, onCreateLoader, loader);
            if (f905a) {
                Log.v("LoaderManager", "  Created new loader " + loaderInfo);
            }
            this.f907c.a(i, loaderInfo);
            this.f908d = false;
            return loaderInfo.a(this.f906b, loaderCallbacks);
        } catch (Throwable th) {
            this.f908d = false;
            throw th;
        }
    }

    @Override // android.support.v4.app.LoaderManager
    public void destroyLoader(int i) {
        if (!this.f908d) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                if (f905a) {
                    Log.v("LoaderManager", "destroyLoader in " + this + " of " + i);
                }
                LoaderInfo a2 = this.f907c.a(i);
                if (a2 != null) {
                    a2.a(true);
                    this.f907c.b(i);
                    return;
                }
                return;
            }
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // android.support.v4.app.LoaderManager
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f907c.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // android.support.v4.app.LoaderManager
    public <D> Loader<D> getLoader(int i) {
        if (!this.f908d) {
            LoaderInfo<D> a2 = this.f907c.a(i);
            if (a2 != null) {
                return a2.d();
            }
            return null;
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // android.support.v4.app.LoaderManager
    public boolean hasRunningLoaders() {
        return this.f907c.b();
    }

    @Override // android.support.v4.app.LoaderManager
    public <D> Loader<D> initLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (!this.f908d) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                LoaderInfo<D> a2 = this.f907c.a(i);
                if (f905a) {
                    Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
                }
                if (a2 == null) {
                    return a(i, bundle, loaderCallbacks, null);
                }
                if (f905a) {
                    Log.v("LoaderManager", "  Re-using existing loader " + a2);
                }
                return a2.a(this.f906b, loaderCallbacks);
            }
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // android.support.v4.app.LoaderManager
    public <D> Loader<D> restartLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (!this.f908d) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                if (f905a) {
                    Log.v("LoaderManager", "restartLoader in " + this + ": args=" + bundle);
                }
                LoaderInfo<D> a2 = this.f907c.a(i);
                return a(i, bundle, loaderCallbacks, a2 != null ? a2.a(false) : null);
            }
            throw new IllegalStateException("restartLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(this.f906b, sb);
        sb.append("}}");
        return sb.toString();
    }

    /* loaded from: classes.dex */
    public static class LoaderInfo<D> extends l<D> implements Loader.OnLoadCompleteListener<D> {
        private final int k;
        private final Bundle l;
        private final Loader<D> m;
        private e n;
        private LoaderObserver<D> o;
        private Loader<D> p;

        LoaderInfo(int i, Bundle bundle, Loader<D> loader, Loader<D> loader2) {
            this.k = i;
            this.l = bundle;
            this.m = loader;
            this.p = loader2;
            this.m.registerListener(i, this);
        }

        Loader<D> a(e eVar, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            LoaderObserver<D> loaderObserver = new LoaderObserver<>(this.m, loaderCallbacks);
            observe(eVar, loaderObserver);
            LoaderObserver<D> loaderObserver2 = this.o;
            if (loaderObserver2 != null) {
                removeObserver(loaderObserver2);
            }
            this.n = eVar;
            this.o = loaderObserver;
            return this.m;
        }

        @Override // android.arch.lifecycle.LiveData
        protected void b() {
            if (LoaderManagerImpl.f905a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.m.startLoading();
        }

        @Override // android.arch.lifecycle.LiveData
        protected void c() {
            if (LoaderManagerImpl.f905a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.m.stopLoading();
        }

        Loader<D> d() {
            return this.m;
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.k);
            printWriter.print(" mArgs=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.m);
            this.m.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.o != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.o);
                this.o.dump(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(d().dataToString(getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(hasActiveObservers());
        }

        boolean e() {
            LoaderObserver<D> loaderObserver;
            return (!hasActiveObservers() || (loaderObserver = this.o) == null || loaderObserver.a()) ? false : true;
        }

        void f() {
            e eVar = this.n;
            LoaderObserver<D> loaderObserver = this.o;
            if (eVar == null || loaderObserver == null) {
                return;
            }
            super.removeObserver(loaderObserver);
            observe(eVar, loaderObserver);
        }

        @Override // android.support.v4.content.Loader.OnLoadCompleteListener
        public void onLoadComplete(Loader<D> loader, D d2) {
            if (LoaderManagerImpl.f905a) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(d2);
                return;
            }
            if (LoaderManagerImpl.f905a) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            postValue(d2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.arch.lifecycle.LiveData
        public void removeObserver(m<D> mVar) {
            super.removeObserver(mVar);
            this.n = null;
            this.o = null;
        }

        @Override // android.arch.lifecycle.l, android.arch.lifecycle.LiveData
        public void setValue(D d2) {
            super.setValue(d2);
            Loader<D> loader = this.p;
            if (loader != null) {
                loader.reset();
                this.p = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.k);
            sb.append(" : ");
            DebugUtils.buildShortClassTag(this.m, sb);
            sb.append("}}");
            return sb.toString();
        }

        Loader<D> a(boolean z) {
            if (LoaderManagerImpl.f905a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.m.cancelLoad();
            this.m.abandon();
            LoaderObserver<D> loaderObserver = this.o;
            if (loaderObserver != null) {
                removeObserver(loaderObserver);
                if (z) {
                    loaderObserver.b();
                }
            }
            this.m.unregisterListener(this);
            if ((loaderObserver != null && !loaderObserver.a()) || z) {
                this.m.reset();
                return this.p;
            }
            return this.m;
        }
    }

    public void a() {
        this.f907c.c();
    }
}

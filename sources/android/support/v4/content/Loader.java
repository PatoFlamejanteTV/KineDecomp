package android.support.v4.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.support.v4.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class Loader<D> {

    /* renamed from: a */
    int f1061a;

    /* renamed from: b */
    OnLoadCompleteListener<D> f1062b;

    /* renamed from: c */
    OnLoadCanceledListener<D> f1063c;

    /* renamed from: d */
    Context f1064d;

    /* renamed from: e */
    boolean f1065e = false;

    /* renamed from: f */
    boolean f1066f = false;

    /* renamed from: g */
    boolean f1067g = true;

    /* renamed from: h */
    boolean f1068h = false;
    boolean i = false;

    /* loaded from: classes.dex */
    public final class ForceLoadContentObserver extends ContentObserver {
        public ForceLoadContentObserver() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Loader.this.onContentChanged();
        }
    }

    /* loaded from: classes.dex */
    public interface OnLoadCanceledListener<D> {
        void onLoadCanceled(Loader<D> loader);
    }

    /* loaded from: classes.dex */
    public interface OnLoadCompleteListener<D> {
        void onLoadComplete(Loader<D> loader, D d2);
    }

    public Loader(Context context) {
        this.f1064d = context.getApplicationContext();
    }

    protected void a() {
    }

    public void abandon() {
        this.f1066f = true;
        a();
    }

    protected boolean b() {
        return false;
    }

    public void c() {
    }

    public boolean cancelLoad() {
        return b();
    }

    public void commitContentChanged() {
        this.i = false;
    }

    public void d() {
    }

    public String dataToString(D d2) {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(d2, sb);
        sb.append("}");
        return sb.toString();
    }

    public void deliverCancellation() {
        OnLoadCanceledListener<D> onLoadCanceledListener = this.f1063c;
        if (onLoadCanceledListener != null) {
            onLoadCanceledListener.onLoadCanceled(this);
        }
    }

    public void deliverResult(D d2) {
        OnLoadCompleteListener<D> onLoadCompleteListener = this.f1062b;
        if (onLoadCompleteListener != null) {
            onLoadCompleteListener.onLoadComplete(this, d2);
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f1061a);
        printWriter.print(" mListener=");
        printWriter.println(this.f1062b);
        if (this.f1065e || this.f1068h || this.i) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f1065e);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f1068h);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.i);
        }
        if (this.f1066f || this.f1067g) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f1066f);
            printWriter.print(" mReset=");
            printWriter.println(this.f1067g);
        }
    }

    protected void e() {
    }

    protected void f() {
    }

    public void forceLoad() {
        c();
    }

    public Context getContext() {
        return this.f1064d;
    }

    public int getId() {
        return this.f1061a;
    }

    public boolean isAbandoned() {
        return this.f1066f;
    }

    public boolean isReset() {
        return this.f1067g;
    }

    public boolean isStarted() {
        return this.f1065e;
    }

    public void onContentChanged() {
        if (this.f1065e) {
            forceLoad();
        } else {
            this.f1068h = true;
        }
    }

    public void registerListener(int i, OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.f1062b == null) {
            this.f1062b = onLoadCompleteListener;
            this.f1061a = i;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public void registerOnLoadCanceledListener(OnLoadCanceledListener<D> onLoadCanceledListener) {
        if (this.f1063c == null) {
            this.f1063c = onLoadCanceledListener;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public void reset() {
        d();
        this.f1067g = true;
        this.f1065e = false;
        this.f1066f = false;
        this.f1068h = false;
        this.i = false;
    }

    public void rollbackContentChanged() {
        if (this.i) {
            onContentChanged();
        }
    }

    public final void startLoading() {
        this.f1065e = true;
        this.f1067g = false;
        this.f1066f = false;
        e();
    }

    public void stopLoading() {
        this.f1065e = false;
        f();
    }

    public boolean takeContentChanged() {
        boolean z = this.f1068h;
        this.f1068h = false;
        this.i |= z;
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, sb);
        sb.append(" id=");
        sb.append(this.f1061a);
        sb.append("}");
        return sb.toString();
    }

    public void unregisterListener(OnLoadCompleteListener<D> onLoadCompleteListener) {
        OnLoadCompleteListener<D> onLoadCompleteListener2 = this.f1062b;
        if (onLoadCompleteListener2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (onLoadCompleteListener2 == onLoadCompleteListener) {
            this.f1062b = null;
            return;
        }
        throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }

    public void unregisterOnLoadCanceledListener(OnLoadCanceledListener<D> onLoadCanceledListener) {
        OnLoadCanceledListener<D> onLoadCanceledListener2 = this.f1063c;
        if (onLoadCanceledListener2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (onLoadCanceledListener2 == onLoadCanceledListener) {
            this.f1063c = null;
            return;
        }
        throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
}

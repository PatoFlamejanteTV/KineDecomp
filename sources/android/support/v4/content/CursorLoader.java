package android.support.v4.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.Loader;
import android.support.v4.os.CancellationSignal;
import android.support.v4.os.OperationCanceledException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* loaded from: classes.dex */
public class CursorLoader extends AsyncTaskLoader<Cursor> {
    final Loader<Cursor>.ForceLoadContentObserver p;
    Uri q;
    String[] r;
    String s;
    String[] t;
    String u;
    Cursor v;
    CancellationSignal w;

    public CursorLoader(Context context) {
        super(context);
        this.p = new Loader.ForceLoadContentObserver();
    }

    @Override // android.support.v4.content.AsyncTaskLoader
    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        synchronized (this) {
            if (this.w != null) {
                this.w.cancel();
            }
        }
    }

    @Override // android.support.v4.content.Loader
    public void d() {
        super.d();
        f();
        Cursor cursor = this.v;
        if (cursor != null && !cursor.isClosed()) {
            this.v.close();
        }
        this.v = null;
    }

    @Override // android.support.v4.content.AsyncTaskLoader, android.support.v4.content.Loader
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.q);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.r));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.s);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.t));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.u);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.v);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.f1068h);
    }

    @Override // android.support.v4.content.Loader
    protected void e() {
        Cursor cursor = this.v;
        if (cursor != null) {
            deliverResult(cursor);
        }
        if (takeContentChanged() || this.v == null) {
            forceLoad();
        }
    }

    @Override // android.support.v4.content.Loader
    protected void f() {
        cancelLoad();
    }

    public String[] getProjection() {
        return this.r;
    }

    public String getSelection() {
        return this.s;
    }

    public String[] getSelectionArgs() {
        return this.t;
    }

    public String getSortOrder() {
        return this.u;
    }

    public Uri getUri() {
        return this.q;
    }

    public void setProjection(String[] strArr) {
        this.r = strArr;
    }

    public void setSelection(String str) {
        this.s = str;
    }

    public void setSelectionArgs(String[] strArr) {
        this.t = strArr;
    }

    public void setSortOrder(String str) {
        this.u = str;
    }

    public void setUri(Uri uri) {
        this.q = uri;
    }

    @Override // android.support.v4.content.Loader
    public void deliverResult(Cursor cursor) {
        if (isReset()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        Cursor cursor2 = this.v;
        this.v = cursor;
        if (isStarted()) {
            super.deliverResult((CursorLoader) cursor);
        }
        if (cursor2 == null || cursor2 == cursor || cursor2.isClosed()) {
            return;
        }
        cursor2.close();
    }

    @Override // android.support.v4.content.AsyncTaskLoader
    public Cursor loadInBackground() {
        synchronized (this) {
            if (!isLoadInBackgroundCanceled()) {
                this.w = new CancellationSignal();
            } else {
                throw new OperationCanceledException();
            }
        }
        try {
            Cursor query = ContentResolverCompat.query(getContext().getContentResolver(), this.q, this.r, this.s, this.t, this.u, this.w);
            if (query != null) {
                try {
                    query.getCount();
                    query.registerContentObserver(this.p);
                } catch (RuntimeException e2) {
                    query.close();
                    throw e2;
                }
            }
            synchronized (this) {
                this.w = null;
            }
            return query;
        } catch (Throwable th) {
            synchronized (this) {
                this.w = null;
                throw th;
            }
        }
    }

    @Override // android.support.v4.content.AsyncTaskLoader
    public void onCanceled(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    public CursorLoader(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context);
        this.p = new Loader.ForceLoadContentObserver();
        this.q = uri;
        this.r = strArr;
        this.s = str;
        this.t = strArr2;
        this.u = str2;
    }
}

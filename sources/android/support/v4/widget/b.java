package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v4.widget.c;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

/* compiled from: CursorAdapter.java */
/* loaded from: classes.dex */
public abstract class b extends BaseAdapter implements c.a, Filterable {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f109a;
    protected boolean b;
    protected Cursor c;
    protected Context d;
    protected int e;
    protected a f;
    protected DataSetObserver g;
    protected c h;
    protected FilterQueryProvider i;

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract void a(View view, Context context, Cursor cursor);

    public b(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? 1 : 2);
    }

    void a(Context context, Cursor cursor, int i) {
        if ((i & 1) == 1) {
            i |= 2;
            this.b = true;
        } else {
            this.b = false;
        }
        boolean z = cursor != null;
        this.c = cursor;
        this.f109a = z;
        this.d = context;
        this.e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f = new a();
            this.g = new C0014b();
        } else {
            this.f = null;
            this.g = null;
        }
        if (z) {
            if (this.f != null) {
                cursor.registerContentObserver(this.f);
            }
            if (this.g != null) {
                cursor.registerDataSetObserver(this.g);
            }
        }
    }

    @Override // android.support.v4.widget.c.a
    public Cursor a() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (!this.f109a || this.c == null) {
            return 0;
        }
        return this.c.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (!this.f109a || this.c == null) {
            return null;
        }
        this.c.moveToPosition(i);
        return this.c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.f109a && this.c != null && this.c.moveToPosition(i)) {
            return this.c.getLong(this.e);
        }
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f109a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.c.moveToPosition(i)) {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
        if (view == null) {
            view = a(this.d, this.c, viewGroup);
        }
        a(view, this.d, this.c);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f109a) {
            return null;
        }
        this.c.moveToPosition(i);
        if (view == null) {
            view = b(this.d, this.c, viewGroup);
        }
        a(view, this.d, this.c);
        return view;
    }

    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return a(context, cursor, viewGroup);
    }

    @Override // android.support.v4.widget.c.a
    public void a(Cursor cursor) {
        Cursor b = b(cursor);
        if (b != null) {
            b.close();
        }
    }

    public Cursor b(Cursor cursor) {
        if (cursor == this.c) {
            return null;
        }
        Cursor cursor2 = this.c;
        if (cursor2 != null) {
            if (this.f != null) {
                cursor2.unregisterContentObserver(this.f);
            }
            if (this.g != null) {
                cursor2.unregisterDataSetObserver(this.g);
            }
        }
        this.c = cursor;
        if (cursor != null) {
            if (this.f != null) {
                cursor.registerContentObserver(this.f);
            }
            if (this.g != null) {
                cursor.registerDataSetObserver(this.g);
            }
            this.e = cursor.getColumnIndexOrThrow("_id");
            this.f109a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.e = -1;
        this.f109a = false;
        notifyDataSetInvalidated();
        return cursor2;
    }

    @Override // android.support.v4.widget.c.a
    public CharSequence c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    @Override // android.support.v4.widget.c.a
    public Cursor a(CharSequence charSequence) {
        return this.i != null ? this.i.runQuery(charSequence) : this.c;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.h == null) {
            this.h = new c(this);
        }
        return this.h;
    }

    protected void b() {
        if (this.b && this.c != null && !this.c.isClosed()) {
            this.f109a = this.c.requery();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CursorAdapter.java */
    /* loaded from: classes.dex */
    public class a extends ContentObserver {
        public a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            b.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CursorAdapter.java */
    /* renamed from: android.support.v4.widget.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0014b extends DataSetObserver {
        private C0014b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            b.this.f109a = true;
            b.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            b.this.f109a = false;
            b.this.notifyDataSetInvalidated();
        }
    }
}

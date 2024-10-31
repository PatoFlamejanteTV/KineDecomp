package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v4.widget.CursorFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

/* loaded from: classes.dex */
public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {

    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;

    /* renamed from: a */
    protected boolean f1950a;

    /* renamed from: b */
    protected boolean f1951b;

    /* renamed from: c */
    protected Cursor f1952c;

    /* renamed from: d */
    protected Context f1953d;

    /* renamed from: e */
    protected int f1954e;

    /* renamed from: f */
    protected ChangeObserver f1955f;

    /* renamed from: g */
    protected DataSetObserver f1956g;

    /* renamed from: h */
    protected CursorFilter f1957h;
    protected FilterQueryProvider i;

    /* loaded from: classes.dex */
    public class ChangeObserver extends ContentObserver {
        ChangeObserver() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            CursorAdapter.this.a();
        }
    }

    /* loaded from: classes.dex */
    public class MyDataSetObserver extends DataSetObserver {
        MyDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.f1950a = true;
            cursorAdapter.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.f1950a = false;
            cursorAdapter.notifyDataSetInvalidated();
        }
    }

    @Deprecated
    public CursorAdapter(Context context, Cursor cursor) {
        a(context, cursor, 1);
    }

    void a(Context context, Cursor cursor, int i) {
        if ((i & 1) == 1) {
            i |= 2;
            this.f1951b = true;
        } else {
            this.f1951b = false;
        }
        boolean z = cursor != null;
        this.f1952c = cursor;
        this.f1950a = z;
        this.f1953d = context;
        this.f1954e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f1955f = new ChangeObserver();
            this.f1956g = new MyDataSetObserver();
        } else {
            this.f1955f = null;
            this.f1956g = null;
        }
        if (z) {
            ChangeObserver changeObserver = this.f1955f;
            if (changeObserver != null) {
                cursor.registerContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.f1956g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract void bindView(View view, Context context, Cursor cursor);

    @Override // android.support.v4.widget.CursorFilter.CursorFilterClient
    public void changeCursor(Cursor cursor) {
        Cursor swapCursor = swapCursor(cursor);
        if (swapCursor != null) {
            swapCursor.close();
        }
    }

    @Override // android.support.v4.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f1950a || (cursor = this.f1952c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.support.v4.widget.CursorFilter.CursorFilterClient
    public Cursor getCursor() {
        return this.f1952c;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1950a) {
            return null;
        }
        this.f1952c.moveToPosition(i);
        if (view == null) {
            view = newDropDownView(this.f1953d, this.f1952c, viewGroup);
        }
        bindView(view, this.f1953d, this.f1952c);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f1957h == null) {
            this.f1957h = new CursorFilter(this);
        }
        return this.f1957h;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return this.i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.f1950a || (cursor = this.f1952c) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.f1952c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (this.f1950a && (cursor = this.f1952c) != null && cursor.moveToPosition(i)) {
            return this.f1952c.getLong(this.f1954e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f1950a) {
            if (this.f1952c.moveToPosition(i)) {
                if (view == null) {
                    view = newView(this.f1953d, this.f1952c, viewGroup);
                }
                bindView(view, this.f1953d, this.f1952c);
                return view;
            }
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return newView(context, cursor, viewGroup);
    }

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.support.v4.widget.CursorFilter.CursorFilterClient
    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.i;
        if (filterQueryProvider != null) {
            return filterQueryProvider.runQuery(charSequence);
        }
        return this.f1952c;
    }

    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        this.i = filterQueryProvider;
    }

    public Cursor swapCursor(Cursor cursor) {
        Cursor cursor2 = this.f1952c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            ChangeObserver changeObserver = this.f1955f;
            if (changeObserver != null) {
                cursor2.unregisterContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.f1956g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1952c = cursor;
        if (cursor != null) {
            ChangeObserver changeObserver2 = this.f1955f;
            if (changeObserver2 != null) {
                cursor.registerContentObserver(changeObserver2);
            }
            DataSetObserver dataSetObserver2 = this.f1956g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f1954e = cursor.getColumnIndexOrThrow("_id");
            this.f1950a = true;
            notifyDataSetChanged();
        } else {
            this.f1954e = -1;
            this.f1950a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    public CursorAdapter(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? 1 : 2);
    }

    public CursorAdapter(Context context, Cursor cursor, int i) {
        a(context, cursor, i);
    }

    protected void a() {
        Cursor cursor;
        if (!this.f1951b || (cursor = this.f1952c) == null || cursor.isClosed()) {
            return;
        }
        this.f1950a = this.f1952c.requery();
    }
}

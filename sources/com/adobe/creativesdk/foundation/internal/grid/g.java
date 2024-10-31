package com.adobe.creativesdk.foundation.internal.grid;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.adobe.creativesdk.foundation.internal.grid.e;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: HeaderViewListAdapter.java */
/* loaded from: classes.dex */
public class g implements WrapperListAdapter, Filterable {

    /* renamed from: a */
    static final ArrayList<e.b> f5055a = new ArrayList<>();

    /* renamed from: b */
    private final ListAdapter f5056b;

    /* renamed from: c */
    ArrayList<e.b> f5057c;

    /* renamed from: d */
    ArrayList<e.b> f5058d;

    /* renamed from: e */
    boolean f5059e;

    /* renamed from: f */
    private final boolean f5060f;

    public g(ArrayList<e.b> arrayList, ArrayList<e.b> arrayList2, ListAdapter listAdapter) {
        this.f5056b = listAdapter;
        this.f5060f = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.f5057c = f5055a;
        } else {
            this.f5057c = arrayList;
        }
        if (arrayList2 == null) {
            this.f5058d = f5055a;
        } else {
            this.f5058d = arrayList2;
        }
        this.f5059e = a(this.f5057c) && a(this.f5058d);
    }

    public int a() {
        return this.f5058d.size();
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f5056b;
        if (listAdapter != null) {
            return this.f5059e && listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    public int b() {
        return this.f5057c.size();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int a2;
        int b2;
        if (this.f5056b != null) {
            a2 = a() + b();
            b2 = this.f5056b.getCount();
        } else {
            a2 = a();
            b2 = b();
        }
        return a2 + b2;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f5060f) {
            return ((Filterable) this.f5056b).getFilter();
        }
        return null;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int b2 = b();
        if (i < b2) {
            return this.f5057c.get(i).f5029b;
        }
        int i2 = i - b2;
        int i3 = 0;
        ListAdapter listAdapter = this.f5056b;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            return this.f5056b.getItem(i2);
        }
        return this.f5058d.get(i2 - i3).f5029b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2;
        int b2 = b();
        ListAdapter listAdapter = this.f5056b;
        if (listAdapter == null || i < b2 || (i2 = i - b2) >= listAdapter.getCount()) {
            return -1L;
        }
        return this.f5056b.getItemId(i2);
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        int b2 = b();
        ListAdapter listAdapter = this.f5056b;
        if (listAdapter == null || i < b2 || (i2 = i - b2) >= listAdapter.getCount()) {
            return -2;
        }
        return this.f5056b.getItemViewType(i2);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int b2 = b();
        if (i < b2) {
            return this.f5057c.get(i).f5028a;
        }
        int i2 = i - b2;
        int i3 = 0;
        ListAdapter listAdapter = this.f5056b;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            return this.f5056b.getView(i2, view, viewGroup);
        }
        return this.f5058d.get(i2 - i3).f5028a;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        ListAdapter listAdapter = this.f5056b;
        if (listAdapter != null) {
            return listAdapter.getViewTypeCount();
        }
        return 1;
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        return this.f5056b;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        ListAdapter listAdapter = this.f5056b;
        if (listAdapter != null) {
            return listAdapter.hasStableIds();
        }
        return false;
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        ListAdapter listAdapter = this.f5056b;
        return listAdapter == null || listAdapter.isEmpty();
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i) {
        int b2 = b();
        if (i < b2) {
            return this.f5057c.get(i).f5030c;
        }
        int i2 = i - b2;
        int i3 = 0;
        ListAdapter listAdapter = this.f5056b;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            return this.f5056b.isEnabled(i2);
        }
        return this.f5058d.get(i2 - i3).f5030c;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f5056b;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f5056b;
        if (listAdapter != null) {
            listAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }

    private boolean a(ArrayList<e.b> arrayList) {
        if (arrayList == null) {
            return true;
        }
        Iterator<e.b> it = arrayList.iterator();
        while (it.hasNext()) {
            if (!it.next().f5030c) {
                return false;
            }
        }
        return true;
    }
}

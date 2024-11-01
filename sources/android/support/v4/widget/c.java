package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;

/* compiled from: CursorFilter.java */
/* loaded from: classes.dex */
class c extends Filter {

    /* renamed from: a, reason: collision with root package name */
    a f112a;

    /* compiled from: CursorFilter.java */
    /* loaded from: classes.dex */
    interface a {
        Cursor a();

        Cursor a(CharSequence charSequence);

        void a(Cursor cursor);

        CharSequence c(Cursor cursor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f112a = aVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f112a.c((Cursor) obj);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor a2 = this.f112a.a(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (a2 != null) {
            filterResults.count = a2.getCount();
            filterResults.values = a2;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor a2 = this.f112a.a();
        if (filterResults.values != null && filterResults.values != a2) {
            this.f112a.a((Cursor) filterResults.values);
        }
    }
}

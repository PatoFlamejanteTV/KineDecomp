package com.google.android.gms.drive.widget;

import android.database.CursorIndexOutOfBoundsException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.drive.internal.zzz;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class DataBufferAdapter<T> extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private final int f1200a;
    private int b;
    private final int c;
    private final List<DataBuffer<T>> d;
    private final LayoutInflater e;
    private boolean f;

    private View a(int i, View view, ViewGroup viewGroup, int i2) {
        View inflate = view == null ? this.e.inflate(i2, viewGroup, false) : view;
        try {
            TextView textView = this.c == 0 ? (TextView) inflate : (TextView) inflate.findViewById(this.c);
            T item = getItem(i);
            if (item instanceof CharSequence) {
                textView.setText((CharSequence) item);
            } else {
                textView.setText(item.toString());
            }
            return inflate;
        } catch (ClassCastException e) {
            zzz.a("DataBufferAdapter", e, "You must supply a resource ID for a TextView");
            throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", e);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        Iterator<DataBuffer<T>> it = this.d.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = it.next().a() + i2;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return a(i, view, viewGroup, this.b);
    }

    @Override // android.widget.Adapter
    public T getItem(int i) throws CursorIndexOutOfBoundsException {
        int i2 = i;
        for (DataBuffer<T> dataBuffer : this.d) {
            int a2 = dataBuffer.a();
            if (a2 > i2) {
                try {
                    return dataBuffer.a(i2);
                } catch (CursorIndexOutOfBoundsException e) {
                    throw new CursorIndexOutOfBoundsException(i, getCount());
                }
            }
            i2 -= a2;
        }
        throw new CursorIndexOutOfBoundsException(i, getCount());
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(i, view, viewGroup, this.f1200a);
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.f = true;
    }
}

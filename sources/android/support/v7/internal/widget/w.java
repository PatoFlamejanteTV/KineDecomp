package android.support.v7.internal.widget;

import android.support.v7.internal.widget.SpinnerCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpinnerCompat.java */
/* loaded from: classes.dex */
public class w implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SpinnerCompat f193a;
    final /* synthetic */ SpinnerCompat.c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(SpinnerCompat.c cVar, SpinnerCompat spinnerCompat) {
        this.b = cVar;
        this.f193a = spinnerCompat;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter;
        SpinnerCompat.this.setSelection(i);
        if (SpinnerCompat.this.s != null) {
            SpinnerCompat spinnerCompat = SpinnerCompat.this;
            listAdapter = this.b.d;
            spinnerCompat.a(view, i, listAdapter.getItemId(i));
        }
        this.b.a();
    }
}

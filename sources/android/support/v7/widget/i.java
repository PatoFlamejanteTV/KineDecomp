package android.support.v7.widget;

import android.support.v7.widget.f;
import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ListPopupWindow.java */
/* loaded from: classes.dex */
public class i implements AdapterView.OnItemSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f226a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.f226a = fVar;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        f.a aVar;
        if (i == -1 || (aVar = this.f226a.f) == null) {
            return;
        }
        aVar.f = false;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}

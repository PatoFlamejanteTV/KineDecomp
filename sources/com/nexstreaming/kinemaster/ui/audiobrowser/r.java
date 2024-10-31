package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.view.View;
import android.widget.ListView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.audiobrowser.q;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SongAdapter.java */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ q f3684a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.f3684a = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q.a aVar;
        q.a aVar2;
        List list;
        q.a aVar3;
        List list2;
        aVar = this.f3684a.e;
        if (aVar != null) {
            int positionForView = ((ListView) view.getParent().getParent().getParent()).getPositionForView(view);
            switch (view.getId()) {
                case R.id.AddAudio /* 2131821202 */:
                    aVar2 = this.f3684a.e;
                    q qVar = this.f3684a;
                    list = this.f3684a.f3683a;
                    aVar2.b(qVar, (n) list.get(positionForView), positionForView);
                    return;
                case R.id.Play /* 2131821203 */:
                    aVar3 = this.f3684a.e;
                    q qVar2 = this.f3684a;
                    list2 = this.f3684a.f3683a;
                    aVar3.a(qVar2, (n) list2.get(positionForView), positionForView);
                    return;
                default:
                    return;
            }
        }
    }
}

package com.nexstreaming.kinemaster.util.update;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetUpdateActivity.java */
/* loaded from: classes2.dex */
public class e implements ResultTask.OnResultAvailableListener<List<com.nexstreaming.app.general.nexasset.assetpackage.b>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AssetUpdateActivity f23956a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AssetUpdateActivity assetUpdateActivity) {
        this.f23956a = assetUpdateActivity;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<List<com.nexstreaming.app.general.nexasset.assetpackage.b>> resultTask, Task.Event event, List<com.nexstreaming.app.general.nexasset.assetpackage.b> list) {
        List list2;
        List list3;
        ResultTask P;
        list2 = this.f23956a.J;
        list2.clear();
        if (list.size() > 0) {
            list3 = this.f23956a.J;
            list3.addAll(list);
            this.f23956a.N();
            P = this.f23956a.P();
            P.onResultAvailable(new d(this)).onFailure((Task.OnFailListener) new c(this));
            return;
        }
        this.f23956a.finish();
    }
}

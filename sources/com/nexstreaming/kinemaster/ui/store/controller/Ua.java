package com.nexstreaming.kinemaster.ui.store.controller;

import android.widget.ProgressBar;
import com.nexstreaming.app.general.nexasset.assetpackage.AssetCategoryAlias;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.network.InterfaceC1822k;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GridPageFragment.java */
/* loaded from: classes2.dex */
public class Ua implements ResultTask.OnResultAvailableListener<InterfaceC1822k> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ _a f23502a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ua(_a _aVar) {
        this.f23502a = _aVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<InterfaceC1822k> resultTask, Task.Event event, InterfaceC1822k interfaceC1822k) {
        ab abVar;
        int i;
        int i2;
        List<com.nexstreaming.kinemaster.network.m> a2;
        ab abVar2;
        int i3;
        int i4;
        ProgressBar progressBar;
        if (interfaceC1822k == null) {
            progressBar = this.f23502a.i;
            progressBar.setVisibility(4);
            return;
        }
        this.f23502a.j = interfaceC1822k;
        List<com.nexstreaming.kinemaster.network.m> subCategories = interfaceC1822k.getSubCategories();
        if (interfaceC1822k.getCategoryAliasName().equals(AssetCategoryAlias.Font.name())) {
            a2 = this.f23502a.a((List<com.nexstreaming.kinemaster.network.m>) subCategories);
            this.f23502a.f23522d = new ab();
            abVar2 = this.f23502a.f23522d;
            abVar2.a(a2);
            int size = subCategories.size();
            i3 = this.f23502a.f23521c;
            if (size > i3) {
                _a _aVar = this.f23502a;
                i4 = _aVar.f23521c;
                _aVar.a((List<com.nexstreaming.kinemaster.network.m>) a2, subCategories.get(i4));
            }
        } else if (subCategories != null && subCategories.size() > 0) {
            this.f23502a.f23522d = new ab();
            abVar = this.f23502a.f23522d;
            abVar.a(subCategories);
            int size2 = subCategories.size();
            i = this.f23502a.f23521c;
            if (size2 > i) {
                _a _aVar2 = this.f23502a;
                i2 = _aVar2.f23521c;
                _aVar2.a((List<com.nexstreaming.kinemaster.network.m>) subCategories, subCategories.get(i2));
            }
        }
        this.f23502a.B();
        this.f23502a.C();
    }
}

package c.d.a.a.d.a;

import android.content.Context;
import c.d.a.a.d.a.d;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.network.C1819h;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nexstreaming.kinemaster.network.InterfaceC1822k;
import com.nexstreaming.kinemaster.network.m;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetInstallHelper.java */
/* loaded from: classes2.dex */
public class b implements ResultTask.OnResultAvailableListener<List<InterfaceC1822k>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InterfaceC1821j f3546a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ d.c f3547b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Task f3548c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ d f3549d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(d dVar, InterfaceC1821j interfaceC1821j, d.c cVar, Task task) {
        this.f3549d = dVar;
        this.f3546a = interfaceC1821j;
        this.f3547b = cVar;
        this.f3548c = task;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<List<InterfaceC1822k>> resultTask, Task.Event event, List<InterfaceC1822k> list) {
        String str;
        Context context;
        Iterator<InterfaceC1822k> it = list.iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                break;
            }
            InterfaceC1822k next = it.next();
            if (next.getCategoryIdx() == this.f3546a.r()) {
                Iterator<m> it2 = next.getSubCategories().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    m next2 = it2.next();
                    if (this.f3546a.n() == next2.getSubcategoryIdx()) {
                        str = next2.getSubcategoryAliasName();
                        break;
                    }
                }
            }
        }
        context = this.f3549d.f3555e;
        C1819h.a(context).a().a(this.f3546a.p(), new a(this, str));
    }
}

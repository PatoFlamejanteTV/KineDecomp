package com.nextreaming.nexeditorui.fontbrowser;

import android.content.Context;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.fonts.Font;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontBrowserActivity.java */
/* loaded from: classes2.dex */
public class d implements ResultTask.OnResultAvailableListener<List<com.nexstreaming.kinemaster.fonts.c>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FontBrowserActivity f24265a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FontBrowserActivity fontBrowserActivity) {
        this.f24265a = fontBrowserActivity;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<List<com.nexstreaming.kinemaster.fonts.c>> resultTask, Task.Event event, List<com.nexstreaming.kinemaster.fonts.c> list) {
        List list2;
        List list3;
        List list4;
        Context context;
        List list5;
        ListView listView;
        ListView listView2;
        List list6;
        String str;
        Font c2;
        ListView listView3;
        ListView listView4;
        int d2;
        List list7;
        ListView listView5;
        ListView listView6;
        list2 = this.f24265a.f24256f;
        list2.clear();
        list3 = this.f24265a.f24256f;
        list3.addAll(com.nexstreaming.kinemaster.fonts.d.b().a());
        list4 = this.f24265a.f24256f;
        list4.addAll(list);
        context = this.f24265a.f24252b;
        list5 = this.f24265a.f24256f;
        FontBrowserActivity.b(context, (List<com.nexstreaming.kinemaster.fonts.c>) list5);
        listView = this.f24265a.f24253c;
        listView.clearChoices();
        listView2 = this.f24265a.f24253c;
        FontBrowserActivity fontBrowserActivity = this.f24265a;
        list6 = fontBrowserActivity.f24256f;
        listView2.setAdapter((ListAdapter) new j(fontBrowserActivity, list6));
        FontBrowserActivity fontBrowserActivity2 = this.f24265a;
        str = fontBrowserActivity2.i;
        c2 = fontBrowserActivity2.c(str);
        if (c2 == null) {
            listView3 = this.f24265a.f24253c;
            listView4 = this.f24265a.f24253c;
            listView3.performItemClick(listView4, 0, 0L);
        } else {
            d2 = this.f24265a.d(c2.e());
            if (d2 >= 0) {
                list7 = this.f24265a.f24256f;
                if (d2 < list7.size()) {
                    listView5 = this.f24265a.f24253c;
                    listView6 = this.f24265a.f24253c;
                    listView5.performItemClick(listView6, d2, d2);
                }
            }
        }
        this.f24265a.v();
    }
}

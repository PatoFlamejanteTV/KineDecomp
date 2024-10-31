package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class kc implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f4027a;
    final /* synthetic */ MSID b;
    final /* synthetic */ int[] c;
    final /* synthetic */ List d;
    final /* synthetic */ ArrayList e;
    final /* synthetic */ String f;
    final /* synthetic */ String g;
    final /* synthetic */ Theme h;
    final /* synthetic */ ProjectEditActivity i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kc(ProjectEditActivity projectEditActivity, Map map, MSID msid, int[] iArr, List list, ArrayList arrayList, String str, String str2, Theme theme) {
        this.i = projectEditActivity;
        this.f4027a = map;
        this.b = msid;
        this.c = iArr;
        this.d = list;
        this.e = arrayList;
        this.f = str;
        this.g = str2;
        this.h = theme;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        this.f4027a.put(this.b, bitmap);
        int[] iArr = this.c;
        int i = iArr[0] - 1;
        iArr[0] = i;
        if (i < 1) {
            this.i.a(this.d, this.e, this.f, this.g, this.h, this.f4027a);
        }
    }
}

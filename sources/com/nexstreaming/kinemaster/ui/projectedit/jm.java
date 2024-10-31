package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class jm implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int[] f4010a;
    final /* synthetic */ List b;
    final /* synthetic */ ArrayList c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ Theme f;
    final /* synthetic */ Map g;
    final /* synthetic */ ProjectEditActivity h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jm(ProjectEditActivity projectEditActivity, int[] iArr, List list, ArrayList arrayList, String str, String str2, Theme theme, Map map) {
        this.h = projectEditActivity;
        this.f4010a = iArr;
        this.b = list;
        this.c = arrayList;
        this.d = str;
        this.e = str2;
        this.f = theme;
        this.g = map;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        int[] iArr = this.f4010a;
        int i = iArr[0] - 1;
        iArr[0] = i;
        if (i < 1) {
            this.h.a(this.b, this.c, this.d, this.e, this.f, this.g);
        }
    }
}

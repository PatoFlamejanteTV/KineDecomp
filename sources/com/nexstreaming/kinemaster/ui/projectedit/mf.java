package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import c.e.a.a.f;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
public class Mf implements f.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f21957a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f21958b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int[] f21959c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f21960d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ArrayList f21961e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f21962f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ String f21963g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ c.d.b.i.a f21964h;
    final /* synthetic */ Task i;
    final /* synthetic */ ProjectEditActivity j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Mf(ProjectEditActivity projectEditActivity, Map map, MediaStoreItemId mediaStoreItemId, int[] iArr, List list, ArrayList arrayList, String str, String str2, c.d.b.i.a aVar, Task task) {
        this.j = projectEditActivity;
        this.f21957a = map;
        this.f21958b = mediaStoreItemId;
        this.f21959c = iArr;
        this.f21960d = list;
        this.f21961e = arrayList;
        this.f21962f = str;
        this.f21963g = str2;
        this.f21964h = aVar;
        this.i = task;
    }

    @Override // c.e.a.a.f.e
    public void a(Bitmap bitmap) {
        this.f21957a.put(this.f21958b, bitmap);
        int[] iArr = this.f21959c;
        int i = iArr[0] - 1;
        iArr[0] = i;
        if (i < 1) {
            this.j.a((List<MediaStoreItemId>) this.f21960d, (ArrayList<String>) this.f21961e, this.f21962f, this.f21963g, this.f21964h, (Map<MediaStoreItemId, Bitmap>) this.f21957a);
            this.i.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
        }
    }

    @Override // c.e.a.a.f.e
    public void a() {
        int[] iArr = this.f21959c;
        int i = iArr[0] - 1;
        iArr[0] = i;
        if (i < 1) {
            this.j.a((List<MediaStoreItemId>) this.f21960d, (ArrayList<String>) this.f21961e, this.f21962f, this.f21963g, this.f21964h, (Map<MediaStoreItemId, Bitmap>) this.f21957a);
            this.i.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
        }
    }
}

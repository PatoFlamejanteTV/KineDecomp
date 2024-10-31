package com.nexstreaming.kinemaster.project;

import android.os.AsyncTask;
import android.os.Environment;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.io.File;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectInfo.java */
/* loaded from: classes.dex */
public class i extends AsyncTask<Void, Void, List<k>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity.SortingMode f21198a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ResultTask f21199b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ProjectGalleryActivity.SortingMode sortingMode, ResultTask resultTask) {
        this.f21198a = sortingMode;
        this.f21199b = resultTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<k> doInBackground(Void... voidArr) {
        Environment.getExternalStorageDirectory().getAbsolutePath();
        File o = EditorGlobal.o();
        o.getAbsolutePath();
        o.mkdirs();
        File[] listFiles = o.listFiles(new h(this));
        if (listFiles == null) {
            listFiles = new File[0];
        }
        final Collator collator = Collator.getInstance();
        ArrayList arrayList = new ArrayList(listFiles.length);
        for (File file : listFiles) {
            arrayList.add(new k(file, null));
        }
        final ProjectGalleryActivity.SortingMode sortingMode = this.f21198a;
        Collections.sort(arrayList, new Comparator() { // from class: com.nexstreaming.kinemaster.project.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return i.a(ProjectGalleryActivity.SortingMode.this, collator, (k) obj, (k) obj2);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int a(ProjectGalleryActivity.SortingMode sortingMode, Collator collator, k kVar, k kVar2) {
        String i;
        String i2;
        int i3 = j.f21200a[sortingMode.ordinal()];
        if (i3 == 1) {
            return (kVar2.d() == null ? new Date(Long.MIN_VALUE) : kVar2.d()).compareTo(kVar.d() == null ? new Date(Long.MIN_VALUE) : kVar.d());
        }
        if (i3 == 2) {
            return kVar2.c().compareTo(kVar.c());
        }
        if (i3 != 3) {
            return 0;
        }
        i = k.i(kVar.f());
        i2 = k.i(kVar2.f());
        return collator.compare(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<k> list) {
        this.f21199b.sendResult(list);
    }
}

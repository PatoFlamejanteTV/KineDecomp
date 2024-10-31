package com.nexstreaming.kinemaster.project;

import android.os.AsyncTask;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.io.File;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectInfo.java */
/* loaded from: classes.dex */
public final class h extends AsyncTask<Void, Void, List<f>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity.SortingMode f3624a;
    final /* synthetic */ ResultTask b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ProjectGalleryActivity.SortingMode sortingMode, ResultTask resultTask) {
        this.f3624a = sortingMode;
        this.b = resultTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<f> doInBackground(Void... voidArr) {
        File j = EditorGlobal.j();
        j.mkdirs();
        File[] listFiles = j.listFiles(new i(this));
        if (listFiles == null) {
            listFiles = new File[0];
        }
        Collator collator = Collator.getInstance();
        ArrayList arrayList = new ArrayList(listFiles.length);
        for (File file : listFiles) {
            arrayList.add(new f(file, null));
        }
        Collections.sort(arrayList, new j(this, collator));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<f> list) {
        this.b.sendResult(list);
    }
}

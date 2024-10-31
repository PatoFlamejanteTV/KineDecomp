package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import android.widget.BaseAdapter;
import java.io.File;
import java.util.List;

/* compiled from: ExportFileListActivity.java */
/* loaded from: classes.dex */
class w implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f4224a;
    final /* synthetic */ int b;
    final /* synthetic */ u c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, File file, int i) {
        this.c = uVar;
        this.f4224a = file;
        this.b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        List list;
        BaseAdapter baseAdapter;
        this.f4224a.delete();
        list = this.c.f4222a.c;
        list.remove(this.b);
        baseAdapter = this.c.f4222a.f;
        baseAdapter.notifyDataSetChanged();
        dialogInterface.dismiss();
    }
}

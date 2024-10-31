package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.View;
import android.widget.BaseAdapter;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.a;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportFileListActivity.java */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExportFileListActivity f4222a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ExportFileListActivity exportFileListActivity) {
        this.f4222a = exportFileListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseAdapter baseAdapter;
        if (view.getTag() != null) {
            int intValue = ((Integer) view.getTag()).intValue();
            baseAdapter = this.f4222a.f;
            File file = (File) baseAdapter.getItem(intValue);
            if (file != null) {
                switch (view.getId()) {
                    case R.id.filePlayButton /* 2131820958 */:
                    case R.id.fileShareButton /* 2131820959 */:
                    default:
                        return;
                    case R.id.fileDeleteButton /* 2131820960 */:
                        new a.C0074a(this.f4222a).f(R.string.exproted_file_delete_popup_title).a(R.string.exproted_file_delete_popup_msg).a(R.string.button_delete, new w(this, file, intValue)).b(R.string.button_cancel, new v(this)).a().show();
                        return;
                }
            }
        }
    }
}

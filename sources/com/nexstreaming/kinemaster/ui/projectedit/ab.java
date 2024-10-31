package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Intent;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import java.io.File;

/* compiled from: FullScreenInputActivity.java */
/* loaded from: classes.dex */
class ab implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FullScreenInputActivity f3755a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FullScreenInputActivity fullScreenInputActivity) {
        this.f3755a = fullScreenInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        String str;
        File file;
        String str2;
        boolean z2;
        String str3;
        String str4;
        String obj = this.f3755a.f3732a.getText().toString();
        z = this.f3755a.g;
        if (z) {
            str = obj.trim();
            if (str.length() < 1) {
                this.f3755a.a(R.string.project_rename_fail_blank);
                return;
            }
            z2 = this.f3755a.i;
            if (z2) {
                str3 = this.f3755a.h;
                if (str3 != null) {
                    str4 = this.f3755a.h;
                    if (str.equals(str4.trim())) {
                        this.f3755a.b.hideSoftInputFromWindow(this.f3755a.f3732a.getWindowToken(), 0, null);
                        this.f3755a.setResult(0);
                        this.f3755a.finish();
                        return;
                    }
                }
            }
            if (com.nexstreaming.kinemaster.project.f.c(str).getAbsolutePath().getBytes().length > 200) {
                this.f3755a.a(R.string.project_rename_fail_too_long);
                return;
            }
            file = com.nexstreaming.kinemaster.project.f.c(str);
            if (com.nexstreaming.kinemaster.project.f.b(str) || file.exists()) {
                this.f3755a.a(R.string.project_rename_fail_name_conflict);
                return;
            }
        } else {
            str = obj;
            file = null;
        }
        this.f3755a.b.hideSoftInputFromWindow(this.f3755a.f3732a.getWindowToken(), 0, null);
        Intent intent = new Intent();
        str2 = this.f3755a.e;
        intent.putExtra("fontId", str2);
        if (file != null) {
            intent.putExtra("path", file);
        }
        intent.putExtra("text", str);
        this.f3755a.setResult(1, intent);
        this.f3755a.finish();
    }
}

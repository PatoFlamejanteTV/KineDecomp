package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Intent;
import android.view.KeyEvent;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import java.io.File;

/* compiled from: FullScreenInputActivity.java */
/* loaded from: classes.dex */
class ad implements TextView.OnEditorActionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FullScreenInputActivity f3757a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FullScreenInputActivity fullScreenInputActivity) {
        this.f3757a = fullScreenInputActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        boolean z;
        String str;
        boolean z2;
        String str2;
        String str3;
        File file = null;
        if (keyEvent == null && i == 1) {
            this.f3757a.b.hideSoftInputFromWindow(this.f3757a.f3732a.getWindowToken(), 0, null);
            Intent intent = new Intent();
            intent.putExtra("text", this.f3757a.f3732a.getText().toString());
            this.f3757a.setResult(1, intent);
            this.f3757a.finish();
        } else if (i == 6) {
            String obj = this.f3757a.f3732a.getText().toString();
            z = this.f3757a.g;
            if (z) {
                obj = obj.trim();
                if (obj.length() < 1) {
                    this.f3757a.a(R.string.project_rename_fail_blank);
                    return true;
                }
                z2 = this.f3757a.i;
                if (z2) {
                    str2 = this.f3757a.h;
                    if (str2 != null) {
                        str3 = this.f3757a.h;
                        if (obj.equals(str3.trim())) {
                            this.f3757a.b.hideSoftInputFromWindow(this.f3757a.f3732a.getWindowToken(), 0, null);
                            this.f3757a.setResult(0);
                            this.f3757a.finish();
                            return true;
                        }
                    }
                }
                if (com.nexstreaming.kinemaster.project.f.c(obj).getAbsolutePath().getBytes().length > 200) {
                    this.f3757a.a(R.string.project_rename_fail_too_long);
                    return true;
                }
                file = com.nexstreaming.kinemaster.project.f.c(obj);
                if (com.nexstreaming.kinemaster.project.f.b(obj) || file.exists()) {
                    this.f3757a.a(R.string.project_rename_fail_name_conflict);
                    return true;
                }
            }
            Intent intent2 = new Intent();
            str = this.f3757a.e;
            intent2.putExtra("fontId", str);
            if (file != null) {
                intent2.putExtra("path", file);
            }
            intent2.putExtra("text", obj);
            this.f3757a.setResult(1, intent2);
            this.f3757a.finish();
        }
        return false;
    }
}

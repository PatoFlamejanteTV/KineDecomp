package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Intent;
import android.view.KeyEvent;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import java.io.File;

/* compiled from: FullScreenInputActivity.java */
/* loaded from: classes2.dex */
class Ia implements TextView.OnEditorActionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FullScreenInputActivity f21898a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ia(FullScreenInputActivity fullScreenInputActivity) {
        this.f21898a = fullScreenInputActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        boolean z;
        File file;
        String str;
        boolean z2;
        String str2;
        String str3;
        if (keyEvent == null && i == 1) {
            FullScreenInputActivity fullScreenInputActivity = this.f21898a;
            fullScreenInputActivity.f21854b.hideSoftInputFromWindow(fullScreenInputActivity.f21853a.getWindowToken(), 0, null);
            Intent intent = new Intent();
            intent.putExtra("text", this.f21898a.f21853a.getText().toString());
            this.f21898a.setResult(1, intent);
            this.f21898a.finish();
        } else if (i == 6) {
            String obj = this.f21898a.f21853a.getText().toString();
            z = this.f21898a.f21859g;
            if (z) {
                obj = obj.trim();
                if (obj.length() >= 1) {
                    z2 = this.f21898a.i;
                    if (z2) {
                        str2 = this.f21898a.f21860h;
                        if (str2 != null) {
                            str3 = this.f21898a.f21860h;
                            if (obj.equals(str3.trim())) {
                                FullScreenInputActivity fullScreenInputActivity2 = this.f21898a;
                                fullScreenInputActivity2.f21854b.hideSoftInputFromWindow(fullScreenInputActivity2.f21853a.getWindowToken(), 0, null);
                                this.f21898a.setResult(0);
                                this.f21898a.finish();
                                return true;
                            }
                        }
                    }
                    if (com.nexstreaming.kinemaster.project.k.g(obj).getAbsolutePath().getBytes().length > 200) {
                        this.f21898a.b(R.string.project_rename_fail_too_long);
                        return true;
                    }
                    file = com.nexstreaming.kinemaster.project.k.g(obj);
                    if (com.nexstreaming.kinemaster.project.k.f(obj) || file.exists()) {
                        this.f21898a.b(R.string.project_rename_fail_name_conflict);
                        return true;
                    }
                } else {
                    this.f21898a.b(R.string.project_rename_fail_blank);
                    return true;
                }
            } else {
                file = null;
            }
            FullScreenInputActivity fullScreenInputActivity3 = this.f21898a;
            fullScreenInputActivity3.f21854b.hideSoftInputFromWindow(fullScreenInputActivity3.f21853a.getWindowToken(), 0, null);
            Intent intent2 = new Intent();
            str = this.f21898a.f21857e;
            intent2.putExtra("fontId", str);
            if (file != null) {
                intent2.putExtra("path", file);
            }
            intent2.putExtra("text", obj);
            this.f21898a.setResult(1, intent2);
            this.f21898a.finish();
        }
        return false;
    }
}

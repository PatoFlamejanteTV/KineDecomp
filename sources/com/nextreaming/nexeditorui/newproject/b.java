package com.nextreaming.nexeditorui.newproject;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.newproject.NewProjectActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: NewProjectActivity.java */
/* loaded from: classes.dex */
class b implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NewProjectActivity f4661a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewProjectActivity newProjectActivity) {
        this.f4661a = newProjectActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NewProjectActivity.Step step;
        String str;
        String str2;
        ArrayList arrayList;
        Theme theme;
        Theme theme2;
        Theme theme3;
        String i;
        ArrayList arrayList2;
        Activity D;
        ArrayList arrayList3;
        ArrayList arrayList4;
        Theme theme4;
        File file;
        NewProjectActivity.Step step2;
        int id = view.getId();
        Log.i("NewProjectActivity", "Click view : " + id);
        switch (id) {
            case R.id.linear_step_media /* 2131820866 */:
            case R.id.linear_step_theme /* 2131820871 */:
            case R.id.linear_step_text /* 2131820874 */:
            case R.id.linear_step_music /* 2131820877 */:
                NewProjectActivity.Step findStepById = NewProjectActivity.Step.findStepById(id);
                step2 = this.f4661a.l;
                if (step2 != findStepById) {
                    this.f4661a.a(findStepById);
                    return;
                }
                return;
            case R.id.linear_step_next /* 2131820880 */:
                NewProjectActivity.Step[] values = NewProjectActivity.Step.values();
                step = this.f4661a.l;
                int ordinal = step.ordinal();
                int length = ordinal + 1 > values.length ? values.length : ordinal + 1;
                if (length > values.length - 2) {
                    str = this.f4661a.i;
                    String str3 = str != null ? this.f4661a.i : null;
                    str2 = this.f4661a.D;
                    String str4 = str2 != null ? this.f4661a.D : null;
                    arrayList = this.f4661a.g;
                    Iterator it = arrayList.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        String str5 = (String) it.next();
                        if (str5 != null && str5.trim().length() > 0) {
                            i2++;
                        }
                        i2 = i2;
                    }
                    KMUsage kMUsage = KMUsage.GetStarted_Finish;
                    String[] strArr = new String[10];
                    strArr[0] = "music";
                    strArr[1] = (str3 == null || str3.trim().length() <= 0) ? "no-music" : "music";
                    strArr[2] = "titles";
                    strArr[3] = "" + i2;
                    strArr[4] = "theme";
                    theme = this.f4661a.f;
                    strArr[5] = theme == null ? "no-theme" : "theme";
                    strArr[6] = "themeId";
                    theme2 = this.f4661a.f;
                    if (theme2 == null) {
                        i = "none";
                    } else {
                        theme3 = this.f4661a.f;
                        i = theme3.i();
                    }
                    strArr[7] = i;
                    strArr[8] = "items";
                    StringBuilder append = new StringBuilder().append("");
                    arrayList2 = this.f4661a.e;
                    strArr[9] = append.append(arrayList2.size()).toString();
                    kMUsage.logEvent(strArr);
                    D = this.f4661a.D();
                    arrayList3 = this.f4661a.e;
                    arrayList4 = this.f4661a.g;
                    theme4 = this.f4661a.f;
                    file = this.f4661a.j;
                    this.f4661a.startActivity(ProjectEditActivity.a(D, arrayList3, (ArrayList<String>) arrayList4, str3, str4, theme4, file));
                    this.f4661a.finish();
                    return;
                }
                this.f4661a.a(values[length]);
                return;
            default:
                return;
        }
    }
}

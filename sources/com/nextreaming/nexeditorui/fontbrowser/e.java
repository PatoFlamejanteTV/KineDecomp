package com.nextreaming.nexeditorui.fontbrowser;

import android.content.Context;
import android.os.AsyncTask;
import com.nexstreaming.app.general.nexasset.assetpackage.ItemCategory;
import com.nexstreaming.app.general.nexasset.assetpackage.r;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.util.J;
import com.nexstreaming.kinemaster.fonts.Font;
import com.nextreaming.nexeditorui.fontbrowser.FontBrowserActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontBrowserActivity.java */
/* loaded from: classes2.dex */
public class e extends AsyncTask<Void, Void, List<com.nexstreaming.kinemaster.fonts.c>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FontBrowserActivity f24266a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FontBrowserActivity fontBrowserActivity) {
        this.f24266a = fontBrowserActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<com.nexstreaming.kinemaster.fonts.c> doInBackground(Void... voidArr) {
        Context context;
        Context context2;
        String b2;
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (r rVar : com.nexstreaming.app.general.nexasset.assetpackage.h.e().d(ItemCategory.font)) {
            String valueOf = String.valueOf((int) rVar.getAssetPackage().getAssetSubCategory().getSubCategoryId());
            FontBrowserActivity.a aVar = (FontBrowserActivity.a) hashMap.get(valueOf);
            if (aVar == null) {
                aVar = new FontBrowserActivity.a(valueOf, rVar.getAssetPackage().getAssetSubCategory().getSubCategoryName());
                hashMap.put(valueOf, aVar);
            }
            String sampleText = rVar.getSampleText();
            if (sampleText == null || sampleText.trim().length() < 1) {
                context = this.f24266a.f24252b;
                sampleText = J.a(context, rVar.getLabel());
            }
            String id = rVar.getId();
            context2 = this.f24266a.f24252b;
            b2 = FontBrowserActivity.b(context2, rVar);
            aVar.a(new Font(id, valueOf, new File(b2), sampleText, rVar.getAssetPackage()));
        }
        arrayList.addAll(hashMap.values());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<com.nexstreaming.kinemaster.fonts.c> list) {
        ResultTask resultTask;
        ResultTask resultTask2;
        resultTask = this.f24266a.l;
        if (resultTask != null) {
            resultTask2 = this.f24266a.l;
            resultTask2.sendResult(list);
            this.f24266a.l = null;
        }
    }
}

package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzmj;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class AppContentUtils {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface a {
        void a(ArrayList<DataHolder> arrayList, int i);
    }

    public static ArrayList<AppContentAction> a(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        ArrayList<AppContentAction> arrayList2 = new ArrayList<>();
        a(dataHolder, 1, str, "action_id", i, new com.google.android.gms.games.appcontent.a(arrayList2), arrayList);
        return arrayList2;
    }

    private static void a(DataHolder dataHolder, int i, String str, String str2, int i2, a aVar, ArrayList<DataHolder> arrayList) {
        DataHolder dataHolder2 = arrayList.get(i);
        String c = dataHolder.c(str, i2, dataHolder.a(i2));
        if (TextUtils.isEmpty(c)) {
            return;
        }
        int g = dataHolder2.g();
        String[] split = c.split(",");
        for (int i3 = 0; i3 < g; i3++) {
            String c2 = dataHolder2.c(str2, i3, dataHolder2.a(i3));
            if (!TextUtils.isEmpty(c2) && zzmj.zzb(split, c2)) {
                aVar.a(arrayList, i3);
            }
        }
    }

    public static ArrayList<AppContentAnnotation> b(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        ArrayList<AppContentAnnotation> arrayList2 = new ArrayList<>();
        a(dataHolder, 2, str, "annotation_id", i, new b(arrayList2), arrayList);
        return arrayList2;
    }

    public static ArrayList<AppContentCondition> c(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        ArrayList<AppContentCondition> arrayList2 = new ArrayList<>();
        a(dataHolder, 4, str, "condition_id", i, new c(arrayList2), arrayList);
        return arrayList2;
    }

    public static Bundle d(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        Bundle bundle = new Bundle();
        a(dataHolder, 3, str, "tuple_id", i, new d(arrayList.get(3), bundle), arrayList);
        return bundle;
    }
}

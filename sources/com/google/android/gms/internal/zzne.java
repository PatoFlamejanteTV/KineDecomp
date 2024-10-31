package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.CustomProperty;
import com.google.android.gms.drive.metadata.internal.zze;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class zzne extends com.google.android.gms.drive.metadata.internal.zzj<AppVisibleCustomProperties> {
    public static final zze.zza zzanA = new gm();

    public zzne(int i) {
        super("customProperties", Arrays.asList("hasCustomProperties", "sqlId"), Arrays.asList("customPropertiesExtra", "customPropertiesExtraHolder"), i);
    }

    private static void zzc(DataHolder dataHolder) {
        synchronized (dataHolder) {
            DataHolder dataHolder2 = (DataHolder) dataHolder.f().getParcelable("customPropertiesExtraHolder");
            if (dataHolder2 == null) {
                return;
            }
            try {
                android.support.v4.f.f<AppVisibleCustomProperties.zza> zzf = zzf(dataHolder2);
                SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
                for (int i = 0; i < dataHolder.g(); i++) {
                    AppVisibleCustomProperties.zza a2 = zzf.a(dataHolder.a("sqlId", i, dataHolder.a(i)));
                    if (a2 != null) {
                        sparseArray.append(i, a2.a());
                    }
                }
                dataHolder.f().putSparseParcelableArray("customPropertiesExtra", sparseArray);
            } finally {
                dataHolder2.i();
                dataHolder.f().remove("customPropertiesExtraHolder");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzd(DataHolder dataHolder) {
        Bundle f = dataHolder.f();
        if (f == null) {
            return;
        }
        synchronized (dataHolder) {
            DataHolder dataHolder2 = (DataHolder) f.getParcelable("customPropertiesExtraHolder");
            if (dataHolder2 != null) {
                dataHolder2.i();
                f.remove("customPropertiesExtraHolder");
            }
        }
    }

    private static android.support.v4.f.f<AppVisibleCustomProperties.zza> zzf(DataHolder dataHolder) {
        Bundle f = dataHolder.f();
        String string = f.getString("entryIdColumn");
        String string2 = f.getString("keyColumn");
        String string3 = f.getString("visibilityColumn");
        String string4 = f.getString("valueColumn");
        android.support.v4.f.f<AppVisibleCustomProperties.zza> fVar = new android.support.v4.f.f<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= dataHolder.g()) {
                return fVar;
            }
            int a2 = dataHolder.a(i2);
            long a3 = dataHolder.a(string, i2, a2);
            String c = dataHolder.c(string2, i2, a2);
            int b = dataHolder.b(string3, i2, a2);
            CustomProperty customProperty = new CustomProperty(new CustomPropertyKey(c, b), dataHolder.c(string4, i2, a2));
            AppVisibleCustomProperties.zza a4 = fVar.a(a3);
            if (a4 == null) {
                a4 = new AppVisibleCustomProperties.zza();
                fVar.b(a3, a4);
            }
            a4.a(customProperty);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: zzl, reason: merged with bridge method [inline-methods] */
    public AppVisibleCustomProperties zzc(DataHolder dataHolder, int i, int i2) {
        Bundle f = dataHolder.f();
        SparseArray sparseParcelableArray = f.getSparseParcelableArray("customPropertiesExtra");
        if (sparseParcelableArray == null) {
            if (f.getParcelable("customPropertiesExtraHolder") != null) {
                zzc(dataHolder);
                sparseParcelableArray = f.getSparseParcelableArray("customPropertiesExtra");
            }
            if (sparseParcelableArray == null) {
                return AppVisibleCustomProperties.f1144a;
            }
        }
        return (AppVisibleCustomProperties) sparseParcelableArray.get(i, AppVisibleCustomProperties.f1144a);
    }
}

package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.zze;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes2.dex */
public class zzl extends zzi<DriveId> implements SearchableCollectionMetadataField<DriveId> {

    /* renamed from: a, reason: collision with root package name */
    public static final zze.zza f1151a = new a();

    public zzl(int i) {
        super("parents", Collections.emptySet(), Arrays.asList("parentsExtra", "dbInstanceId", "parentsExtraHolder"), i);
    }

    private void b(DataHolder dataHolder) {
        synchronized (dataHolder) {
            DataHolder dataHolder2 = (DataHolder) dataHolder.f().getParcelable("parentsExtraHolder");
            if (dataHolder2 == null) {
                return;
            }
            try {
                int g = dataHolder.g();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(g);
                HashMap hashMap = new HashMap(g);
                for (int i = 0; i < g; i++) {
                    int a2 = dataHolder.a(i);
                    ParentDriveIdSet parentDriveIdSet = new ParentDriveIdSet();
                    arrayList.add(parentDriveIdSet);
                    hashMap.put(Long.valueOf(dataHolder.a("sqlId", i, a2)), parentDriveIdSet);
                }
                Bundle f = dataHolder2.f();
                String string = f.getString("childSqlIdColumn");
                String string2 = f.getString("parentSqlIdColumn");
                String string3 = f.getString("parentResIdColumn");
                int g2 = dataHolder2.g();
                for (int i2 = 0; i2 < g2; i2++) {
                    int a3 = dataHolder2.a(i2);
                    ((ParentDriveIdSet) hashMap.get(Long.valueOf(dataHolder2.a(string, i2, a3)))).a(new PartialDriveId(dataHolder2.c(string3, i2, a3), dataHolder2.a(string2, i2, a3), 1));
                }
                dataHolder.f().putParcelableArrayList("parentsExtra", arrayList);
            } finally {
                dataHolder2.i();
                dataHolder.f().remove("parentsExtraHolder");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(DataHolder dataHolder) {
        Bundle f = dataHolder.f();
        if (f == null) {
            return;
        }
        synchronized (dataHolder) {
            DataHolder dataHolder2 = (DataHolder) f.getParcelable("parentsExtraHolder");
            if (dataHolder2 != null) {
                dataHolder2.i();
                f.remove("parentsExtraHolder");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zzb, com.google.android.gms.drive.metadata.zza
    /* renamed from: zzd */
    public Collection<DriveId> zzc(DataHolder dataHolder, int i, int i2) {
        Bundle f = dataHolder.f();
        ArrayList parcelableArrayList = f.getParcelableArrayList("parentsExtra");
        if (parcelableArrayList == null) {
            if (f.getParcelable("parentsExtraHolder") != null) {
                b(dataHolder);
                parcelableArrayList = f.getParcelableArrayList("parentsExtra");
            }
            if (parcelableArrayList == null) {
                return null;
            }
        }
        return ((ParentDriveIdSet) parcelableArrayList.get(i)).a(f.getLong("dbInstanceId"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.internal.zzi, com.google.android.gms.drive.metadata.zza
    /* renamed from: zzp */
    public Collection<DriveId> zzk(Bundle bundle) {
        Collection zzk = super.zzk(bundle);
        if (zzk == null) {
            return null;
        }
        return new HashSet(zzk);
    }
}

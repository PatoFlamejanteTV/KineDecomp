package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class zzng extends com.google.android.gms.drive.metadata.internal.zzj<DriveId> {
    public static final zzng zzanH = new zzng();

    private zzng() {
        super("driveId", Arrays.asList("sqlId", "resourceId", "mimeType"), Arrays.asList("dbInstanceId"), 4100000);
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected boolean zzb(DataHolder dataHolder, int i, int i2) {
        Iterator<String> it = zzrG().iterator();
        while (it.hasNext()) {
            if (!dataHolder.a(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: zzm */
    public DriveId zzc(DataHolder dataHolder, int i, int i2) {
        long j = dataHolder.f().getLong("dbInstanceId");
        int i3 = "application/vnd.google-apps.folder".equals(dataHolder.c(zznd.zzang.getName(), i, i2)) ? 1 : 0;
        String c = dataHolder.c("resourceId", i, i2);
        Long valueOf = Long.valueOf(dataHolder.a("sqlId", i, i2));
        if ("generated-android-null".equals(c)) {
            c = null;
        }
        return new DriveId(c, valueOf.longValue(), j, i3);
    }
}

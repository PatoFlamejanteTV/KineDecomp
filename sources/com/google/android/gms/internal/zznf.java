package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import java.util.Date;

/* loaded from: classes2.dex */
public class zznf {
    public static final zza zzanB = new zza("created", 4100000);
    public static final zzb zzanC = new zzb("lastOpenedTime", 4300000);
    public static final zzd zzanD = new zzd("modified", 4100000);
    public static final zzc zzanE = new zzc("modifiedByMe", 4100000);
    public static final zzf zzanF = new zzf("sharedWithMe", 4100000);
    public static final zze zzanG = new zze("recency", 8000000);

    /* loaded from: classes2.dex */
    public static class zza extends com.google.android.gms.drive.metadata.internal.zzd implements SortableMetadataField<Date> {
        public zza(String str, int i) {
            super(str, i);
        }
    }

    /* loaded from: classes2.dex */
    public static class zzb extends com.google.android.gms.drive.metadata.internal.zzd implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public zzb(String str, int i) {
            super(str, i);
        }
    }

    /* loaded from: classes2.dex */
    public static class zzc extends com.google.android.gms.drive.metadata.internal.zzd implements SortableMetadataField<Date> {
        public zzc(String str, int i) {
            super(str, i);
        }
    }

    /* loaded from: classes2.dex */
    public static class zzd extends com.google.android.gms.drive.metadata.internal.zzd implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public zzd(String str, int i) {
            super(str, i);
        }
    }

    /* loaded from: classes2.dex */
    public static class zze extends com.google.android.gms.drive.metadata.internal.zzd implements SortableMetadataField<Date> {
        public zze(String str, int i) {
            super(str, i);
        }
    }

    /* loaded from: classes2.dex */
    public static class zzf extends com.google.android.gms.drive.metadata.internal.zzd implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public zzf(String str, int i) {
            super(str, i);
        }
    }
}

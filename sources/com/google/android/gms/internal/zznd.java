package com.google.android.gms.internal;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes2.dex */
public class zznd {
    public static final MetadataField<DriveId> zzamJ = zzng.zzanH;
    public static final MetadataField<String> zzamK = new com.google.android.gms.drive.metadata.internal.zzo("alternateLink", 4300000);
    public static final zza zzamL = new zza(5000000);
    public static final MetadataField<String> zzamM = new com.google.android.gms.drive.metadata.internal.zzo("description", 4300000);
    public static final MetadataField<String> zzamN = new com.google.android.gms.drive.metadata.internal.zzo("embedLink", 4300000);
    public static final MetadataField<String> zzamO = new com.google.android.gms.drive.metadata.internal.zzo("fileExtension", 4300000);
    public static final MetadataField<Long> zzamP = new com.google.android.gms.drive.metadata.internal.zzg("fileSize", 4300000);
    public static final MetadataField<String> zzamQ = new com.google.android.gms.drive.metadata.internal.zzo("folderColorRgb", 7500000);
    public static final MetadataField<Boolean> zzamR = new com.google.android.gms.drive.metadata.internal.zzb("hasThumbnail", 4300000);
    public static final MetadataField<String> zzamS = new com.google.android.gms.drive.metadata.internal.zzo("indexableText", 4300000);
    public static final MetadataField<Boolean> zzamT = new com.google.android.gms.drive.metadata.internal.zzb("isAppData", 4300000);
    public static final MetadataField<Boolean> zzamU = new com.google.android.gms.drive.metadata.internal.zzb("isCopyable", 4300000);
    public static final MetadataField<Boolean> zzamV = new com.google.android.gms.drive.metadata.internal.zzb("isEditable", 4100000);
    public static final MetadataField<Boolean> zzamW = new gk("isExplicitlyTrashed", Collections.singleton("trashed"), Collections.emptySet(), 7000000);
    public static final MetadataField<Boolean> zzamX = new com.google.android.gms.drive.metadata.internal.zzb("isLocalContentUpToDate", 7800000);
    public static final zzb zzamY = new zzb("isPinned", 4100000);
    public static final MetadataField<Boolean> zzamZ = new com.google.android.gms.drive.metadata.internal.zzb("isOpenable", 7200000);
    public static final MetadataField<Boolean> zzana = new com.google.android.gms.drive.metadata.internal.zzb("isRestricted", 4300000);
    public static final MetadataField<Boolean> zzanb = new com.google.android.gms.drive.metadata.internal.zzb("isShared", 4300000);
    public static final MetadataField<Boolean> zzanc = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosFolder", 7000000);
    public static final MetadataField<Boolean> zzand = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosRootFolder", 7000000);
    public static final MetadataField<Boolean> zzane = new com.google.android.gms.drive.metadata.internal.zzb("isTrashable", 4400000);
    public static final MetadataField<Boolean> zzanf = new com.google.android.gms.drive.metadata.internal.zzb("isViewed", 4300000);
    public static final zzc zzang = new zzc(4100000);
    public static final MetadataField<String> zzanh = new com.google.android.gms.drive.metadata.internal.zzo("originalFilename", 4300000);
    public static final com.google.android.gms.drive.metadata.zzb<String> zzani = new com.google.android.gms.drive.metadata.internal.zzn("ownerNames", 4300000);
    public static final com.google.android.gms.drive.metadata.internal.zzp zzanj = new com.google.android.gms.drive.metadata.internal.zzp("lastModifyingUser", 6000000);
    public static final com.google.android.gms.drive.metadata.internal.zzp zzank = new com.google.android.gms.drive.metadata.internal.zzp("sharingUser", 6000000);
    public static final com.google.android.gms.drive.metadata.internal.zzl zzanl = new com.google.android.gms.drive.metadata.internal.zzl(4100000);
    public static final zzd zzanm = new zzd("quotaBytesUsed", 4300000);
    public static final zzf zzann = new zzf("starred", 4100000);
    public static final MetadataField<BitmapTeleporter> zzano = new gl("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000);
    public static final zzg zzanp = new zzg(ShareConstants.WEB_DIALOG_PARAM_TITLE, 4100000);
    public static final zzh zzanq = new zzh("trashed", 4100000);
    public static final MetadataField<String> zzanr = new com.google.android.gms.drive.metadata.internal.zzo("webContentLink", 4300000);
    public static final MetadataField<String> zzans = new com.google.android.gms.drive.metadata.internal.zzo("webViewLink", 4300000);
    public static final MetadataField<String> zzant = new com.google.android.gms.drive.metadata.internal.zzo("uniqueIdentifier", 5000000);
    public static final com.google.android.gms.drive.metadata.internal.zzb zzanu = new com.google.android.gms.drive.metadata.internal.zzb("writersCanShare", 6000000);
    public static final MetadataField<String> zzanv = new com.google.android.gms.drive.metadata.internal.zzo("role", 6000000);
    public static final MetadataField<String> zzanw = new com.google.android.gms.drive.metadata.internal.zzo("md5Checksum", 7000000);
    public static final zze zzanx = new zze(7000000);
    public static final MetadataField<String> zzany = new com.google.android.gms.drive.metadata.internal.zzo("recencyReason", 8000000);
    public static final MetadataField<Boolean> zzanz = new com.google.android.gms.drive.metadata.internal.zzb("subscribed", 8000000);

    /* loaded from: classes2.dex */
    public static class zza extends zzne implements SearchableMetadataField<AppVisibleCustomProperties> {
        public zza(int i) {
            super(i);
        }
    }

    /* loaded from: classes2.dex */
    public static class zzb extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
        public zzb(String str, int i) {
            super(str, i);
        }
    }

    /* loaded from: classes2.dex */
    public static class zzc extends com.google.android.gms.drive.metadata.internal.zzo implements SearchableMetadataField<String> {
        public zzc(int i) {
            super("mimeType", i);
        }
    }

    /* loaded from: classes2.dex */
    public static class zzd extends com.google.android.gms.drive.metadata.internal.zzg implements SortableMetadataField<Long> {
        public zzd(String str, int i) {
            super(str, i);
        }
    }

    /* loaded from: classes2.dex */
    public static class zze extends com.google.android.gms.drive.metadata.internal.zzi<DriveSpace> {
        public zze(int i) {
            super("spaces", Arrays.asList("inDriveSpace", "isAppData", "inGooglePhotosSpace"), Collections.emptySet(), i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.drive.metadata.zzb, com.google.android.gms.drive.metadata.zza
        /* renamed from: zzd */
        public Collection<DriveSpace> zzc(DataHolder dataHolder, int i, int i2) {
            ArrayList arrayList = new ArrayList();
            if (dataHolder.d("inDriveSpace", i, i2)) {
                arrayList.add(DriveSpace.f1057a);
            }
            if (dataHolder.d("isAppData", i, i2)) {
                arrayList.add(DriveSpace.b);
            }
            if (dataHolder.d("inGooglePhotosSpace", i, i2)) {
                arrayList.add(DriveSpace.c);
            }
            return arrayList;
        }
    }

    /* loaded from: classes2.dex */
    public static class zzf extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
        public zzf(String str, int i) {
            super(str, i);
        }
    }

    /* loaded from: classes2.dex */
    public static class zzg extends com.google.android.gms.drive.metadata.internal.zzo implements SearchableMetadataField<String>, SortableMetadataField<String> {
        public zzg(String str, int i) {
            super(str, i);
        }
    }

    /* loaded from: classes2.dex */
    public static class zzh extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
        public zzh(String str, int i) {
            super(str, i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.drive.metadata.internal.zzb, com.google.android.gms.drive.metadata.zza
        /* renamed from: zze */
        public Boolean zzc(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.b(getName(), i, i2) != 0);
        }
    }
}

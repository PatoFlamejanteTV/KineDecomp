package com.nextreaming.nexeditorui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.nexstreaming.kinemaster.wire.KMProto;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import okio.ByteString;

/* loaded from: classes.dex */
public class NexProjectHeader implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private transient Bitmap f24115a;
    public String bgmThemeId;
    public Date creationTime;
    public byte[] jpegThumbnail;
    public Date lastEditTime;
    public boolean needUpdateLargeThumbnail;
    public UUID projectUUID;
    public int projectVersion;
    public KMProto.Platform savedOnPlatform;
    public int savedWithKMVersion;
    public String savedWithKMVersionName;
    public String themeId;
    public int totalPlayTime;

    public NexProjectHeader() {
    }

    public static NexProjectHeader fromProtoBuf(KMProto.KMProjectHeader kMProjectHeader) {
        Long l;
        NexProjectHeader nexProjectHeader = new NexProjectHeader();
        nexProjectHeader.themeId = kMProjectHeader.theme_id;
        nexProjectHeader.bgmThemeId = kMProjectHeader.bgm_theme_id;
        ByteString byteString = kMProjectHeader.jpeg_thumbnail;
        if (byteString != null) {
            nexProjectHeader.jpegThumbnail = byteString.toByteArray();
        }
        Long l2 = kMProjectHeader.creation_time;
        if (l2 != null) {
            nexProjectHeader.creationTime = new Date(l2.longValue());
        }
        Long l3 = kMProjectHeader.last_edit_time;
        if (l3 != null) {
            nexProjectHeader.lastEditTime = new Date(l3.longValue());
        }
        Integer num = kMProjectHeader.saved_with_km_version;
        if (num != null) {
            nexProjectHeader.savedWithKMVersion = num.intValue();
        } else {
            nexProjectHeader.savedWithKMVersion = 0;
        }
        Integer num2 = kMProjectHeader.project_version;
        if (num2 != null) {
            nexProjectHeader.projectVersion = num2.intValue();
        } else {
            nexProjectHeader.projectVersion = 0;
        }
        nexProjectHeader.savedWithKMVersionName = kMProjectHeader.saved_with_km_ver_name;
        nexProjectHeader.savedOnPlatform = kMProjectHeader.saved_on_platform;
        Boolean bool = kMProjectHeader.need_update_large_thumbnail;
        nexProjectHeader.needUpdateLargeThumbnail = bool == null ? false : bool.booleanValue();
        if (kMProjectHeader.project_uuid_lsb != null && (l = kMProjectHeader.project_uuid_msb) != null) {
            nexProjectHeader.projectUUID = new UUID(l.longValue(), kMProjectHeader.project_uuid_lsb.longValue());
        }
        Integer num3 = kMProjectHeader.total_play_time;
        nexProjectHeader.totalPlayTime = num3 != null ? num3.intValue() : 0;
        return nexProjectHeader;
    }

    public KMProto.KMProjectHeader asProtoBuf() {
        KMProto.KMProjectHeader.Builder builder = new KMProto.KMProjectHeader.Builder();
        builder.theme_id = this.themeId;
        builder.bgm_theme_id = this.bgmThemeId;
        byte[] bArr = this.jpegThumbnail;
        if (bArr != null) {
            builder.jpeg_thumbnail = ByteString.of(bArr);
        }
        Date date = this.lastEditTime;
        builder.last_edit_time = date == null ? null : Long.valueOf(date.getTime());
        Date date2 = this.creationTime;
        builder.creation_time = date2 != null ? Long.valueOf(date2.getTime()) : null;
        builder.saved_on_platform = this.savedOnPlatform;
        builder.saved_with_km_version = Integer.valueOf(this.savedWithKMVersion);
        builder.saved_with_km_ver_name = this.savedWithKMVersionName;
        builder.project_version = Integer.valueOf(this.projectVersion);
        UUID uuid = this.projectUUID;
        if (uuid != null) {
            builder.project_uuid_lsb(Long.valueOf(uuid.getLeastSignificantBits())).project_uuid_msb(Long.valueOf(this.projectUUID.getMostSignificantBits()));
        }
        builder.total_play_time = Integer.valueOf(this.totalPlayTime);
        return builder.build();
    }

    public Bitmap getBitmap() {
        byte[] bArr;
        if (this.f24115a == null && (bArr = this.jpegThumbnail) != null) {
            this.f24115a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return this.f24115a;
    }

    public NexProjectHeader(NexProjectHeader nexProjectHeader) {
        this.creationTime = nexProjectHeader.creationTime;
        this.lastEditTime = nexProjectHeader.lastEditTime;
        this.jpegThumbnail = nexProjectHeader.jpegThumbnail;
        this.needUpdateLargeThumbnail = nexProjectHeader.needUpdateLargeThumbnail;
        this.projectUUID = nexProjectHeader.projectUUID;
        this.themeId = nexProjectHeader.themeId;
        this.bgmThemeId = nexProjectHeader.bgmThemeId;
        this.totalPlayTime = nexProjectHeader.totalPlayTime;
        this.f24115a = nexProjectHeader.f24115a;
        this.savedOnPlatform = nexProjectHeader.savedOnPlatform;
        this.savedWithKMVersion = nexProjectHeader.savedWithKMVersion;
        this.savedWithKMVersionName = nexProjectHeader.savedWithKMVersionName;
        this.projectVersion = nexProjectHeader.projectVersion;
    }
}

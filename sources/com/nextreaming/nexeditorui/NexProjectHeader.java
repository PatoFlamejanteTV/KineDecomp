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

    /* renamed from: a, reason: collision with root package name */
    private transient Bitmap f4489a;
    public String bgmThemeId;
    public Date creationTime;
    public byte[] jpegThumbnail;
    public Date lastEditTime;
    public boolean needUpdateLargeThumbnail;
    public UUID projectUUID;
    public String themeId;
    public int totalPlayTime;

    public NexProjectHeader() {
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
        this.f4489a = nexProjectHeader.f4489a;
    }

    public Bitmap getBitmap() {
        if (this.f4489a == null && this.jpegThumbnail != null) {
            this.f4489a = BitmapFactory.decodeByteArray(this.jpegThumbnail, 0, this.jpegThumbnail.length);
        }
        return this.f4489a;
    }

    public KMProto.KMProjectHeader asProtoBuf() {
        KMProto.KMProjectHeader.Builder builder = new KMProto.KMProjectHeader.Builder();
        builder.theme_id = this.themeId;
        builder.bgm_theme_id = this.bgmThemeId;
        if (this.jpegThumbnail != null) {
            builder.jpeg_thumbnail = ByteString.of(this.jpegThumbnail);
        }
        builder.last_edit_time = this.lastEditTime == null ? null : Long.valueOf(this.lastEditTime.getTime());
        builder.creation_time = this.creationTime != null ? Long.valueOf(this.creationTime.getTime()) : null;
        if (this.projectUUID != null) {
            builder.project_uuid_lsb(Long.valueOf(this.projectUUID.getLeastSignificantBits())).project_uuid_msb(Long.valueOf(this.projectUUID.getMostSignificantBits()));
        }
        builder.total_play_time = Integer.valueOf(this.totalPlayTime);
        return builder.build();
    }

    public static NexProjectHeader fromProtoBuf(KMProto.KMProjectHeader kMProjectHeader) {
        NexProjectHeader nexProjectHeader = new NexProjectHeader();
        nexProjectHeader.themeId = kMProjectHeader.theme_id;
        nexProjectHeader.bgmThemeId = kMProjectHeader.bgm_theme_id;
        if (kMProjectHeader.jpeg_thumbnail != null) {
            nexProjectHeader.jpegThumbnail = kMProjectHeader.jpeg_thumbnail.toByteArray();
        }
        if (kMProjectHeader.creation_time != null) {
            nexProjectHeader.creationTime = new Date(kMProjectHeader.creation_time.longValue());
        }
        if (kMProjectHeader.last_edit_time != null) {
            nexProjectHeader.lastEditTime = new Date(kMProjectHeader.last_edit_time.longValue());
        }
        nexProjectHeader.needUpdateLargeThumbnail = kMProjectHeader.need_update_large_thumbnail == null ? false : kMProjectHeader.need_update_large_thumbnail.booleanValue();
        if (kMProjectHeader.project_uuid_lsb != null && kMProjectHeader.project_uuid_msb != null) {
            nexProjectHeader.projectUUID = new UUID(kMProjectHeader.project_uuid_msb.longValue(), kMProjectHeader.project_uuid_lsb.longValue());
        }
        nexProjectHeader.totalPlayTime = kMProjectHeader.total_play_time != null ? kMProjectHeader.total_play_time.intValue() : 0;
        return nexProjectHeader;
    }
}

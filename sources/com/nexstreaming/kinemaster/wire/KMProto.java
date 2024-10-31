package com.nexstreaming.kinemaster.wire;

import com.squareup.wire.Message;
import com.squareup.wire.m;
import com.squareup.wire.n;
import java.util.Collections;
import java.util.List;
import okio.ByteString;

/* loaded from: classes2.dex */
public final class KMProto extends Message {
    private static final long serialVersionUID = 0;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.a<KMProto> {
        public Builder() {
        }

        public Builder(KMProto kMProto) {
            super(kMProto);
        }

        @Override // com.squareup.wire.Message.a
        public KMProto build() {
            return new KMProto(this);
        }
    }

    /* loaded from: classes.dex */
    public static final class KMProject extends Message {
        public static final Integer DEFAULT_ASPECT_RATIO_HEIGHT;
        public static final Integer DEFAULT_ASPECT_RATIO_WIDTH;
        public static final Boolean DEFAULT_IS_PROJECT_AUDIO_FADE_IN_ON;
        public static final Boolean DEFAULT_IS_PROJECT_AUDIO_FADE_OUT_ON;
        public static final Boolean DEFAULT_IS_PROJECT_VIDEO_FADE_IN_ON;
        public static final Boolean DEFAULT_IS_PROJECT_VIDEO_FADE_OUT_ON;
        public static final Float DEFAULT_PROJECT_AUDIO_FADE_IN_TIME;
        public static final Float DEFAULT_PROJECT_AUDIO_FADE_OUT_TIME;
        public static final Boolean DEFAULT_PROJECT_AUTO_MASTER;
        public static final Integer DEFAULT_PROJECT_CAPABILITY_MODE;
        public static final String DEFAULT_PROJECT_DEFAULT_IMG_CROP_MODE = "";
        public static final Integer DEFAULT_PROJECT_DEFAULT_IMG_CROP_MODE_IOS;
        public static final Integer DEFAULT_PROJECT_DEFAULT_IMG_DURATION;
        public static final Integer DEFAULT_PROJECT_DEFAULT_LAYER_DURATION;
        public static final Integer DEFAULT_PROJECT_FRAME_RATE;
        public static final Integer DEFAULT_PROJECT_MASTER_VOLUME;
        public static final Integer DEFAULT_PROJECT_RESOLUTION_SETTING;
        public static final Float DEFAULT_PROJECT_VIDEO_FADE_IN_TIME;
        public static final Float DEFAULT_PROJECT_VIDEO_FADE_OUT_TIME;
        private static final long serialVersionUID = 0;

        @n(tag = 134, type = Message.Datatype.INT32)
        public final Integer aspect_ratio_height;

        @n(tag = 133, type = Message.Datatype.INT32)
        public final Integer aspect_ratio_width;

        @n(label = Message.Label.PACKED, tag = 103, type = Message.Datatype.UINT32)
        public final List<Integer> bookmarks;

        @n(tag = 114, type = Message.Datatype.BOOL)
        public final Boolean is_project_audio_fade_in_on;

        @n(tag = 115, type = Message.Datatype.BOOL)
        public final Boolean is_project_audio_fade_out_on;

        @n(tag = 122, type = Message.Datatype.BOOL)
        public final Boolean is_project_video_fade_in_on;

        @n(tag = 123, type = Message.Datatype.BOOL)
        public final Boolean is_project_video_fade_out_on;

        @n(label = Message.Label.REPEATED, messageType = TimelineItem.class, tag = 1)
        public final List<TimelineItem> primary_items;

        @n(tag = 112, type = Message.Datatype.FLOAT)
        public final Float project_audio_fade_in_time;

        @n(tag = 113, type = Message.Datatype.FLOAT)
        public final Float project_audio_fade_out_time;

        @n(tag = 127, type = Message.Datatype.BOOL)
        public final Boolean project_auto_master;

        @n(tag = 132, type = Message.Datatype.INT32)
        public final Integer project_capability_mode;

        @n(tag = 126, type = Message.Datatype.STRING)
        public final String project_default_img_crop_mode;

        @n(tag = 131, type = Message.Datatype.INT32)
        public final Integer project_default_img_crop_mode_ios;

        @n(tag = 124, type = Message.Datatype.INT32)
        public final Integer project_default_img_duration;

        @n(tag = 125, type = Message.Datatype.INT32)
        public final Integer project_default_layer_duration;

        @n(tag = 130, type = Message.Datatype.INT32)
        public final Integer project_frame_rate;

        @n(tag = 128, type = Message.Datatype.INT32)
        public final Integer project_master_volume;

        @n(tag = 111, type = Message.Datatype.ENUM)
        public final AspectRatio project_ratio;

        @n(tag = 129, type = Message.Datatype.INT32)
        public final Integer project_resolution_setting;

        @n(tag = 120, type = Message.Datatype.FLOAT)
        public final Float project_video_fade_in_time;

        @n(tag = 121, type = Message.Datatype.FLOAT)
        public final Float project_video_fade_out_time;

        @n(tag = 109, type = Message.Datatype.INT32)
        public final Integer recent_scroll_time;

        @n(label = Message.Label.REPEATED, messageType = TimelineItem.class, tag = 2)
        public final List<TimelineItem> secondary_items;

        @n(tag = 100, type = Message.Datatype.INT32)
        public final Integer timeline_format_version;

        @n(label = Message.Label.REPEATED, messageType = Track.class, tag = 3)
        public final List<Track> tracks;
        public static final Integer DEFAULT_TIMELINE_FORMAT_VERSION = 0;
        public static final List<TimelineItem> DEFAULT_PRIMARY_ITEMS = Collections.emptyList();
        public static final List<TimelineItem> DEFAULT_SECONDARY_ITEMS = Collections.emptyList();
        public static final List<Track> DEFAULT_TRACKS = Collections.emptyList();
        public static final List<Integer> DEFAULT_BOOKMARKS = Collections.emptyList();
        public static final Integer DEFAULT_RECENT_SCROLL_TIME = 0;
        public static final AspectRatio DEFAULT_PROJECT_RATIO = AspectRatio.ASPECT_R_16_9;

        /* loaded from: classes2.dex */
        public enum AspectRatio implements m {
            ASPECT_R_16_9(1),
            ASPECT_SQUARE(2),
            ASPECT_R_9_16(3);

            private final int value;

            AspectRatio(int i) {
                this.value = i;
            }

            @Override // com.squareup.wire.m
            public int getValue() {
                return this.value;
            }
        }

        /* loaded from: classes.dex */
        public static final class AssetLayer extends Message {
            public static final String DEFAULT_ASSET_ITEM_ID = "";
            public static final String DEFAULT_ASSET_ITEM_NAME_FOR_IOS = "";
            public static final String DEFAULT_ASSET_NAME_FOR_IOS = "";
            private static final long serialVersionUID = 0;

            @n(tag = 101, type = Message.Datatype.STRING)
            public final String asset_item_id;

            @n(tag = 104, type = Message.Datatype.STRING)
            public final String asset_item_name_for_ios;

            @n(tag = 103, type = Message.Datatype.ENUM)
            public final AssetLayerType asset_layer_type;

            @n(tag = 105, type = Message.Datatype.STRING)
            public final String asset_name_for_ios;

            @n(tag = 102)
            public final StringHashMap effect_options;

            @n(tag = 100)
            public final LayerCommon layer_common;

            @n(tag = 106, type = Message.Datatype.BOOL)
            public final Boolean sync_xy_scale;
            public static final AssetLayerType DEFAULT_ASSET_LAYER_TYPE = AssetLayerType.EFFECT_LAYER;
            public static final Boolean DEFAULT_SYNC_XY_SCALE = false;

            /* loaded from: classes2.dex */
            public enum AssetLayerType implements m {
                EFFECT_LAYER(1),
                OVERLAY_LAYER(2);

                private final int value;

                AssetLayerType(int i) {
                    this.value = i;
                }

                @Override // com.squareup.wire.m
                public int getValue() {
                    return this.value;
                }
            }

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<AssetLayer> {
                public String asset_item_id;
                public String asset_item_name_for_ios;
                public AssetLayerType asset_layer_type;
                public String asset_name_for_ios;
                public StringHashMap effect_options;
                public LayerCommon layer_common;
                public Boolean sync_xy_scale;

                public Builder() {
                }

                public Builder asset_item_id(String str) {
                    this.asset_item_id = str;
                    return this;
                }

                public Builder asset_item_name_for_ios(String str) {
                    this.asset_item_name_for_ios = str;
                    return this;
                }

                public Builder asset_layer_type(AssetLayerType assetLayerType) {
                    this.asset_layer_type = assetLayerType;
                    return this;
                }

                public Builder asset_name_for_ios(String str) {
                    this.asset_name_for_ios = str;
                    return this;
                }

                public Builder effect_options(StringHashMap stringHashMap) {
                    this.effect_options = stringHashMap;
                    return this;
                }

                public Builder layer_common(LayerCommon layerCommon) {
                    this.layer_common = layerCommon;
                    return this;
                }

                public Builder sync_xy_scale(Boolean bool) {
                    this.sync_xy_scale = bool;
                    return this;
                }

                public Builder(AssetLayer assetLayer) {
                    super(assetLayer);
                    if (assetLayer == null) {
                        return;
                    }
                    this.layer_common = assetLayer.layer_common;
                    this.asset_item_id = assetLayer.asset_item_id;
                    this.effect_options = assetLayer.effect_options;
                    this.asset_layer_type = assetLayer.asset_layer_type;
                    this.asset_item_name_for_ios = assetLayer.asset_item_name_for_ios;
                    this.asset_name_for_ios = assetLayer.asset_name_for_ios;
                    this.sync_xy_scale = assetLayer.sync_xy_scale;
                }

                @Override // com.squareup.wire.Message.a
                public AssetLayer build() {
                    return new AssetLayer(this);
                }
            }

            /* synthetic */ AssetLayer(Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof AssetLayer)) {
                    return false;
                }
                AssetLayer assetLayer = (AssetLayer) obj;
                return equals(this.layer_common, assetLayer.layer_common) && equals(this.asset_item_id, assetLayer.asset_item_id) && equals(this.effect_options, assetLayer.effect_options) && equals(this.asset_layer_type, assetLayer.asset_layer_type) && equals(this.asset_item_name_for_ios, assetLayer.asset_item_name_for_ios) && equals(this.asset_name_for_ios, assetLayer.asset_name_for_ios) && equals(this.sync_xy_scale, assetLayer.sync_xy_scale);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i != 0) {
                    return i;
                }
                LayerCommon layerCommon = this.layer_common;
                int hashCode = (layerCommon != null ? layerCommon.hashCode() : 0) * 37;
                String str = this.asset_item_id;
                int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
                StringHashMap stringHashMap = this.effect_options;
                int hashCode3 = (hashCode2 + (stringHashMap != null ? stringHashMap.hashCode() : 0)) * 37;
                AssetLayerType assetLayerType = this.asset_layer_type;
                int hashCode4 = (hashCode3 + (assetLayerType != null ? assetLayerType.hashCode() : 0)) * 37;
                String str2 = this.asset_item_name_for_ios;
                int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
                String str3 = this.asset_name_for_ios;
                int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
                Boolean bool = this.sync_xy_scale;
                int hashCode7 = hashCode6 + (bool != null ? bool.hashCode() : 0);
                this.hashCode = hashCode7;
                return hashCode7;
            }

            public AssetLayer(LayerCommon layerCommon, String str, StringHashMap stringHashMap, AssetLayerType assetLayerType, String str2, String str3, Boolean bool) {
                this.layer_common = layerCommon;
                this.asset_item_id = str;
                this.effect_options = stringHashMap;
                this.asset_layer_type = assetLayerType;
                this.asset_item_name_for_ios = str2;
                this.asset_name_for_ios = str3;
                this.sync_xy_scale = bool;
            }

            private AssetLayer(Builder builder) {
                this(builder.layer_common, builder.asset_item_id, builder.effect_options, builder.asset_layer_type, builder.asset_item_name_for_ios, builder.asset_name_for_ios, builder.sync_xy_scale);
                setBuilder(builder);
            }
        }

        /* loaded from: classes.dex */
        public static final class AudioClip extends Message {
            public static final String DEFAULT_AUDIO_ASSET_ID_IOS = "";
            public static final String DEFAULT_CLIP_NAME = "";
            public static final String DEFAULT_ENHANCEDAUDIOFILTER = "";
            public static final String DEFAULT_EQUALIZER = "";
            public static final String DEFAULT_MEDIA_PATH = "";
            public static final String DEFAULT_MEDIA_TITLE = "";
            public static final String DEFAULT_ORIGINAL_MEDIA_PATH = "";
            private static final long serialVersionUID = 0;

            @n(tag = 135, type = Message.Datatype.STRING)
            public final String audio_asset_id_ios;

            @n(tag = 134, type = Message.Datatype.STRING)
            public final String clip_name;

            @n(tag = 111, type = Message.Datatype.INT32)
            public final Integer clip_volume;

            @n(tag = 125, type = Message.Datatype.FLOAT)
            public final Float clip_width;

            @n(tag = 132, type = Message.Datatype.INT32)
            public final Integer compressor;

            @n(tag = 106, type = Message.Datatype.INT32)
            public final Integer duration;

            @n(tag = 105, type = Message.Datatype.INT32)
            public final Integer engine_clip_id;

            @n(tag = 136, type = Message.Datatype.STRING)
            public final String enhancedAudioFilter;

            @n(tag = 137, type = Message.Datatype.STRING)
            public final String equalizer;

            @n(tag = 128, type = Message.Datatype.BOOL)
            public final Boolean extend_to_end;

            @n(tag = 100, type = Message.Datatype.INT32)
            public final Integer extra_relative_start_time;

            @n(tag = 122, type = Message.Datatype.BOOL)
            public final Boolean is_bg_music;

            @n(tag = 119, type = Message.Datatype.BOOL)
            public final Boolean is_extract_audio;

            @n(tag = 118, type = Message.Datatype.BOOL)
            public final Boolean is_pending_voice_recording;

            @n(tag = 117, type = Message.Datatype.BOOL)
            public final Boolean is_voice_recording;

            @n(tag = 116, type = Message.Datatype.BOOL)
            public final Boolean loop;

            @n(tag = 112, type = Message.Datatype.STRING)
            public final String media_path;

            @n(tag = 114, type = Message.Datatype.STRING)
            public final String media_title;

            @n(tag = 115, type = Message.Datatype.BOOL)
            public final Boolean mute_audio;

            @n(tag = 113, type = Message.Datatype.STRING)
            public final String original_media_path;

            @n(tag = 130, type = Message.Datatype.INT32)
            public final Integer pan_left;

            @n(tag = 131, type = Message.Datatype.INT32)
            public final Integer pan_right;

            @n(tag = 126, type = Message.Datatype.BOOL)
            public final Boolean pinned;

            @n(tag = 133, type = Message.Datatype.INT32)
            public final Integer pitch_factor;

            @n(tag = 102, type = Message.Datatype.INT32)
            public final Integer relative_end_time;

            @n(tag = 101, type = Message.Datatype.INT32)
            public final Integer relative_start_time;

            @n(tag = 127, type = Message.Datatype.INT32)
            public final Integer saved_loop_duration;

            @n(tag = 103, type = Message.Datatype.INT32)
            public final Integer saved_relative_end_time;

            @n(tag = 104, type = Message.Datatype.INT32)
            public final Integer saved_relative_start_time;

            @n(tag = 110, type = Message.Datatype.INT32)
            public final Integer saved_trim_time_end;

            @n(tag = 109, type = Message.Datatype.INT32)
            public final Integer saved_trim_time_start;

            @n(tag = 108, type = Message.Datatype.INT32)
            public final Integer trim_time_end;

            @n(tag = 107, type = Message.Datatype.INT32)
            public final Integer trim_time_start;

            @n(tag = 120, type = Message.Datatype.UINT64)
            public final Long video_clip_item_uuid_lsb;

            @n(tag = 121, type = Message.Datatype.UINT64)
            public final Long video_clip_item_uuid_msb;

            @n(tag = 129, type = Message.Datatype.INT32)
            public final Integer voice_changer;

            @n(label = Message.Label.PACKED, tag = 124, type = Message.Datatype.INT32)
            public final List<Integer> volume_envelope_level;

            @n(label = Message.Label.PACKED, tag = 123, type = Message.Datatype.INT32)
            public final List<Integer> volume_envelope_time;
            public static final Integer DEFAULT_EXTRA_RELATIVE_START_TIME = 0;
            public static final Integer DEFAULT_RELATIVE_START_TIME = 0;
            public static final Integer DEFAULT_RELATIVE_END_TIME = 0;
            public static final Integer DEFAULT_SAVED_RELATIVE_END_TIME = 0;
            public static final Integer DEFAULT_SAVED_RELATIVE_START_TIME = 0;
            public static final Integer DEFAULT_ENGINE_CLIP_ID = 0;
            public static final Integer DEFAULT_DURATION = 0;
            public static final Integer DEFAULT_TRIM_TIME_START = 0;
            public static final Integer DEFAULT_TRIM_TIME_END = 0;
            public static final Integer DEFAULT_SAVED_TRIM_TIME_START = 0;
            public static final Integer DEFAULT_SAVED_TRIM_TIME_END = 0;
            public static final Integer DEFAULT_CLIP_VOLUME = 0;
            public static final Boolean DEFAULT_MUTE_AUDIO = false;
            public static final Boolean DEFAULT_LOOP = false;
            public static final Boolean DEFAULT_IS_VOICE_RECORDING = false;
            public static final Boolean DEFAULT_IS_PENDING_VOICE_RECORDING = false;
            public static final Boolean DEFAULT_IS_EXTRACT_AUDIO = false;
            public static final Long DEFAULT_VIDEO_CLIP_ITEM_UUID_LSB = 0L;
            public static final Long DEFAULT_VIDEO_CLIP_ITEM_UUID_MSB = 0L;
            public static final Boolean DEFAULT_IS_BG_MUSIC = false;
            public static final List<Integer> DEFAULT_VOLUME_ENVELOPE_TIME = Collections.emptyList();
            public static final List<Integer> DEFAULT_VOLUME_ENVELOPE_LEVEL = Collections.emptyList();
            public static final Float DEFAULT_CLIP_WIDTH = Float.valueOf(0.0f);
            public static final Boolean DEFAULT_PINNED = false;
            public static final Integer DEFAULT_SAVED_LOOP_DURATION = 0;
            public static final Boolean DEFAULT_EXTEND_TO_END = false;
            public static final Integer DEFAULT_VOICE_CHANGER = 0;
            public static final Integer DEFAULT_PAN_LEFT = 0;
            public static final Integer DEFAULT_PAN_RIGHT = 0;
            public static final Integer DEFAULT_COMPRESSOR = 0;
            public static final Integer DEFAULT_PITCH_FACTOR = 0;

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<AudioClip> {
                public String audio_asset_id_ios;
                public String clip_name;
                public Integer clip_volume;
                public Float clip_width;
                public Integer compressor;
                public Integer duration;
                public Integer engine_clip_id;
                public String enhancedAudioFilter;
                public String equalizer;
                public Boolean extend_to_end;
                public Integer extra_relative_start_time;
                public Boolean is_bg_music;
                public Boolean is_extract_audio;
                public Boolean is_pending_voice_recording;
                public Boolean is_voice_recording;
                public Boolean loop;
                public String media_path;
                public String media_title;
                public Boolean mute_audio;
                public String original_media_path;
                public Integer pan_left;
                public Integer pan_right;
                public Boolean pinned;
                public Integer pitch_factor;
                public Integer relative_end_time;
                public Integer relative_start_time;
                public Integer saved_loop_duration;
                public Integer saved_relative_end_time;
                public Integer saved_relative_start_time;
                public Integer saved_trim_time_end;
                public Integer saved_trim_time_start;
                public Integer trim_time_end;
                public Integer trim_time_start;
                public Long video_clip_item_uuid_lsb;
                public Long video_clip_item_uuid_msb;
                public Integer voice_changer;
                public List<Integer> volume_envelope_level;
                public List<Integer> volume_envelope_time;

                public Builder() {
                }

                public Builder audio_asset_id_ios(String str) {
                    this.audio_asset_id_ios = str;
                    return this;
                }

                public Builder clip_name(String str) {
                    this.clip_name = str;
                    return this;
                }

                public Builder clip_volume(Integer num) {
                    this.clip_volume = num;
                    return this;
                }

                public Builder clip_width(Float f2) {
                    this.clip_width = f2;
                    return this;
                }

                public Builder compressor(Integer num) {
                    this.compressor = num;
                    return this;
                }

                public Builder duration(Integer num) {
                    this.duration = num;
                    return this;
                }

                public Builder engine_clip_id(Integer num) {
                    this.engine_clip_id = num;
                    return this;
                }

                public Builder enhancedAudioFilter(String str) {
                    this.enhancedAudioFilter = str;
                    return this;
                }

                public Builder equalizer(String str) {
                    this.equalizer = str;
                    return this;
                }

                public Builder extend_to_end(Boolean bool) {
                    this.extend_to_end = bool;
                    return this;
                }

                public Builder extra_relative_start_time(Integer num) {
                    this.extra_relative_start_time = num;
                    return this;
                }

                public Builder is_bg_music(Boolean bool) {
                    this.is_bg_music = bool;
                    return this;
                }

                public Builder is_extract_audio(Boolean bool) {
                    this.is_extract_audio = bool;
                    return this;
                }

                public Builder is_pending_voice_recording(Boolean bool) {
                    this.is_pending_voice_recording = bool;
                    return this;
                }

                public Builder is_voice_recording(Boolean bool) {
                    this.is_voice_recording = bool;
                    return this;
                }

                public Builder loop(Boolean bool) {
                    this.loop = bool;
                    return this;
                }

                public Builder media_path(String str) {
                    this.media_path = str;
                    return this;
                }

                public Builder media_title(String str) {
                    this.media_title = str;
                    return this;
                }

                public Builder mute_audio(Boolean bool) {
                    this.mute_audio = bool;
                    return this;
                }

                public Builder original_media_path(String str) {
                    this.original_media_path = str;
                    return this;
                }

                public Builder pan_left(Integer num) {
                    this.pan_left = num;
                    return this;
                }

                public Builder pan_right(Integer num) {
                    this.pan_right = num;
                    return this;
                }

                public Builder pinned(Boolean bool) {
                    this.pinned = bool;
                    return this;
                }

                public Builder pitch_factor(Integer num) {
                    this.pitch_factor = num;
                    return this;
                }

                public Builder relative_end_time(Integer num) {
                    this.relative_end_time = num;
                    return this;
                }

                public Builder relative_start_time(Integer num) {
                    this.relative_start_time = num;
                    return this;
                }

                public Builder saved_loop_duration(Integer num) {
                    this.saved_loop_duration = num;
                    return this;
                }

                public Builder saved_relative_end_time(Integer num) {
                    this.saved_relative_end_time = num;
                    return this;
                }

                public Builder saved_relative_start_time(Integer num) {
                    this.saved_relative_start_time = num;
                    return this;
                }

                public Builder saved_trim_time_end(Integer num) {
                    this.saved_trim_time_end = num;
                    return this;
                }

                public Builder saved_trim_time_start(Integer num) {
                    this.saved_trim_time_start = num;
                    return this;
                }

                public Builder trim_time_end(Integer num) {
                    this.trim_time_end = num;
                    return this;
                }

                public Builder trim_time_start(Integer num) {
                    this.trim_time_start = num;
                    return this;
                }

                public Builder video_clip_item_uuid_lsb(Long l) {
                    this.video_clip_item_uuid_lsb = l;
                    return this;
                }

                public Builder video_clip_item_uuid_msb(Long l) {
                    this.video_clip_item_uuid_msb = l;
                    return this;
                }

                public Builder voice_changer(Integer num) {
                    this.voice_changer = num;
                    return this;
                }

                public Builder volume_envelope_level(List<Integer> list) {
                    Message.a.checkForNulls(list);
                    this.volume_envelope_level = list;
                    return this;
                }

                public Builder volume_envelope_time(List<Integer> list) {
                    Message.a.checkForNulls(list);
                    this.volume_envelope_time = list;
                    return this;
                }

                public Builder(AudioClip audioClip) {
                    super(audioClip);
                    if (audioClip == null) {
                        return;
                    }
                    this.extra_relative_start_time = audioClip.extra_relative_start_time;
                    this.relative_start_time = audioClip.relative_start_time;
                    this.relative_end_time = audioClip.relative_end_time;
                    this.saved_relative_end_time = audioClip.saved_relative_end_time;
                    this.saved_relative_start_time = audioClip.saved_relative_start_time;
                    this.engine_clip_id = audioClip.engine_clip_id;
                    this.duration = audioClip.duration;
                    this.trim_time_start = audioClip.trim_time_start;
                    this.trim_time_end = audioClip.trim_time_end;
                    this.saved_trim_time_start = audioClip.saved_trim_time_start;
                    this.saved_trim_time_end = audioClip.saved_trim_time_end;
                    this.clip_volume = audioClip.clip_volume;
                    this.media_path = audioClip.media_path;
                    this.original_media_path = audioClip.original_media_path;
                    this.media_title = audioClip.media_title;
                    this.mute_audio = audioClip.mute_audio;
                    this.loop = audioClip.loop;
                    this.is_voice_recording = audioClip.is_voice_recording;
                    this.is_pending_voice_recording = audioClip.is_pending_voice_recording;
                    this.is_extract_audio = audioClip.is_extract_audio;
                    this.video_clip_item_uuid_lsb = audioClip.video_clip_item_uuid_lsb;
                    this.video_clip_item_uuid_msb = audioClip.video_clip_item_uuid_msb;
                    this.is_bg_music = audioClip.is_bg_music;
                    this.volume_envelope_time = Message.copyOf(audioClip.volume_envelope_time);
                    this.volume_envelope_level = Message.copyOf(audioClip.volume_envelope_level);
                    this.clip_width = audioClip.clip_width;
                    this.pinned = audioClip.pinned;
                    this.saved_loop_duration = audioClip.saved_loop_duration;
                    this.extend_to_end = audioClip.extend_to_end;
                    this.voice_changer = audioClip.voice_changer;
                    this.pan_left = audioClip.pan_left;
                    this.pan_right = audioClip.pan_right;
                    this.compressor = audioClip.compressor;
                    this.pitch_factor = audioClip.pitch_factor;
                    this.clip_name = audioClip.clip_name;
                    this.audio_asset_id_ios = audioClip.audio_asset_id_ios;
                    this.enhancedAudioFilter = audioClip.enhancedAudioFilter;
                    this.equalizer = audioClip.equalizer;
                }

                @Override // com.squareup.wire.Message.a
                public AudioClip build() {
                    return new AudioClip(this);
                }
            }

            /* synthetic */ AudioClip(Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof AudioClip)) {
                    return false;
                }
                AudioClip audioClip = (AudioClip) obj;
                return equals(this.extra_relative_start_time, audioClip.extra_relative_start_time) && equals(this.relative_start_time, audioClip.relative_start_time) && equals(this.relative_end_time, audioClip.relative_end_time) && equals(this.saved_relative_end_time, audioClip.saved_relative_end_time) && equals(this.saved_relative_start_time, audioClip.saved_relative_start_time) && equals(this.engine_clip_id, audioClip.engine_clip_id) && equals(this.duration, audioClip.duration) && equals(this.trim_time_start, audioClip.trim_time_start) && equals(this.trim_time_end, audioClip.trim_time_end) && equals(this.saved_trim_time_start, audioClip.saved_trim_time_start) && equals(this.saved_trim_time_end, audioClip.saved_trim_time_end) && equals(this.clip_volume, audioClip.clip_volume) && equals(this.media_path, audioClip.media_path) && equals(this.original_media_path, audioClip.original_media_path) && equals(this.media_title, audioClip.media_title) && equals(this.mute_audio, audioClip.mute_audio) && equals(this.loop, audioClip.loop) && equals(this.is_voice_recording, audioClip.is_voice_recording) && equals(this.is_pending_voice_recording, audioClip.is_pending_voice_recording) && equals(this.is_extract_audio, audioClip.is_extract_audio) && equals(this.video_clip_item_uuid_lsb, audioClip.video_clip_item_uuid_lsb) && equals(this.video_clip_item_uuid_msb, audioClip.video_clip_item_uuid_msb) && equals(this.is_bg_music, audioClip.is_bg_music) && equals((List<?>) this.volume_envelope_time, (List<?>) audioClip.volume_envelope_time) && equals((List<?>) this.volume_envelope_level, (List<?>) audioClip.volume_envelope_level) && equals(this.clip_width, audioClip.clip_width) && equals(this.pinned, audioClip.pinned) && equals(this.saved_loop_duration, audioClip.saved_loop_duration) && equals(this.extend_to_end, audioClip.extend_to_end) && equals(this.voice_changer, audioClip.voice_changer) && equals(this.pan_left, audioClip.pan_left) && equals(this.pan_right, audioClip.pan_right) && equals(this.compressor, audioClip.compressor) && equals(this.pitch_factor, audioClip.pitch_factor) && equals(this.clip_name, audioClip.clip_name) && equals(this.audio_asset_id_ios, audioClip.audio_asset_id_ios) && equals(this.enhancedAudioFilter, audioClip.enhancedAudioFilter) && equals(this.equalizer, audioClip.equalizer);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i != 0) {
                    return i;
                }
                Integer num = this.extra_relative_start_time;
                int hashCode = (num != null ? num.hashCode() : 0) * 37;
                Integer num2 = this.relative_start_time;
                int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
                Integer num3 = this.relative_end_time;
                int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
                Integer num4 = this.saved_relative_end_time;
                int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
                Integer num5 = this.saved_relative_start_time;
                int hashCode5 = (hashCode4 + (num5 != null ? num5.hashCode() : 0)) * 37;
                Integer num6 = this.engine_clip_id;
                int hashCode6 = (hashCode5 + (num6 != null ? num6.hashCode() : 0)) * 37;
                Integer num7 = this.duration;
                int hashCode7 = (hashCode6 + (num7 != null ? num7.hashCode() : 0)) * 37;
                Integer num8 = this.trim_time_start;
                int hashCode8 = (hashCode7 + (num8 != null ? num8.hashCode() : 0)) * 37;
                Integer num9 = this.trim_time_end;
                int hashCode9 = (hashCode8 + (num9 != null ? num9.hashCode() : 0)) * 37;
                Integer num10 = this.saved_trim_time_start;
                int hashCode10 = (hashCode9 + (num10 != null ? num10.hashCode() : 0)) * 37;
                Integer num11 = this.saved_trim_time_end;
                int hashCode11 = (hashCode10 + (num11 != null ? num11.hashCode() : 0)) * 37;
                Integer num12 = this.clip_volume;
                int hashCode12 = (hashCode11 + (num12 != null ? num12.hashCode() : 0)) * 37;
                String str = this.media_path;
                int hashCode13 = (hashCode12 + (str != null ? str.hashCode() : 0)) * 37;
                String str2 = this.original_media_path;
                int hashCode14 = (hashCode13 + (str2 != null ? str2.hashCode() : 0)) * 37;
                String str3 = this.media_title;
                int hashCode15 = (hashCode14 + (str3 != null ? str3.hashCode() : 0)) * 37;
                Boolean bool = this.mute_audio;
                int hashCode16 = (hashCode15 + (bool != null ? bool.hashCode() : 0)) * 37;
                Boolean bool2 = this.loop;
                int hashCode17 = (hashCode16 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
                Boolean bool3 = this.is_voice_recording;
                int hashCode18 = (hashCode17 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
                Boolean bool4 = this.is_pending_voice_recording;
                int hashCode19 = (hashCode18 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
                Boolean bool5 = this.is_extract_audio;
                int hashCode20 = (hashCode19 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
                Long l = this.video_clip_item_uuid_lsb;
                int hashCode21 = (hashCode20 + (l != null ? l.hashCode() : 0)) * 37;
                Long l2 = this.video_clip_item_uuid_msb;
                int hashCode22 = (hashCode21 + (l2 != null ? l2.hashCode() : 0)) * 37;
                Boolean bool6 = this.is_bg_music;
                int hashCode23 = (hashCode22 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
                List<Integer> list = this.volume_envelope_time;
                int hashCode24 = (hashCode23 + (list != null ? list.hashCode() : 1)) * 37;
                List<Integer> list2 = this.volume_envelope_level;
                int hashCode25 = (hashCode24 + (list2 != null ? list2.hashCode() : 1)) * 37;
                Float f2 = this.clip_width;
                int hashCode26 = (hashCode25 + (f2 != null ? f2.hashCode() : 0)) * 37;
                Boolean bool7 = this.pinned;
                int hashCode27 = (hashCode26 + (bool7 != null ? bool7.hashCode() : 0)) * 37;
                Integer num13 = this.saved_loop_duration;
                int hashCode28 = (hashCode27 + (num13 != null ? num13.hashCode() : 0)) * 37;
                Boolean bool8 = this.extend_to_end;
                int hashCode29 = (hashCode28 + (bool8 != null ? bool8.hashCode() : 0)) * 37;
                Integer num14 = this.voice_changer;
                int hashCode30 = (hashCode29 + (num14 != null ? num14.hashCode() : 0)) * 37;
                Integer num15 = this.pan_left;
                int hashCode31 = (hashCode30 + (num15 != null ? num15.hashCode() : 0)) * 37;
                Integer num16 = this.pan_right;
                int hashCode32 = (hashCode31 + (num16 != null ? num16.hashCode() : 0)) * 37;
                Integer num17 = this.compressor;
                int hashCode33 = (hashCode32 + (num17 != null ? num17.hashCode() : 0)) * 37;
                Integer num18 = this.pitch_factor;
                int hashCode34 = (hashCode33 + (num18 != null ? num18.hashCode() : 0)) * 37;
                String str4 = this.clip_name;
                int hashCode35 = (hashCode34 + (str4 != null ? str4.hashCode() : 0)) * 37;
                String str5 = this.audio_asset_id_ios;
                int hashCode36 = (hashCode35 + (str5 != null ? str5.hashCode() : 0)) * 37;
                String str6 = this.enhancedAudioFilter;
                int hashCode37 = (hashCode36 + (str6 != null ? str6.hashCode() : 0)) * 37;
                String str7 = this.equalizer;
                int hashCode38 = hashCode37 + (str7 != null ? str7.hashCode() : 0);
                this.hashCode = hashCode38;
                return hashCode38;
            }

            public AudioClip(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, String str, String str2, String str3, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Long l, Long l2, Boolean bool6, List<Integer> list, List<Integer> list2, Float f2, Boolean bool7, Integer num13, Boolean bool8, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18, String str4, String str5, String str6, String str7) {
                this.extra_relative_start_time = num;
                this.relative_start_time = num2;
                this.relative_end_time = num3;
                this.saved_relative_end_time = num4;
                this.saved_relative_start_time = num5;
                this.engine_clip_id = num6;
                this.duration = num7;
                this.trim_time_start = num8;
                this.trim_time_end = num9;
                this.saved_trim_time_start = num10;
                this.saved_trim_time_end = num11;
                this.clip_volume = num12;
                this.media_path = str;
                this.original_media_path = str2;
                this.media_title = str3;
                this.mute_audio = bool;
                this.loop = bool2;
                this.is_voice_recording = bool3;
                this.is_pending_voice_recording = bool4;
                this.is_extract_audio = bool5;
                this.video_clip_item_uuid_lsb = l;
                this.video_clip_item_uuid_msb = l2;
                this.is_bg_music = bool6;
                this.volume_envelope_time = Message.immutableCopyOf(list);
                this.volume_envelope_level = Message.immutableCopyOf(list2);
                this.clip_width = f2;
                this.pinned = bool7;
                this.saved_loop_duration = num13;
                this.extend_to_end = bool8;
                this.voice_changer = num14;
                this.pan_left = num15;
                this.pan_right = num16;
                this.compressor = num17;
                this.pitch_factor = num18;
                this.clip_name = str4;
                this.audio_asset_id_ios = str5;
                this.enhancedAudioFilter = str6;
                this.equalizer = str7;
            }

            private AudioClip(Builder builder) {
                this(builder.extra_relative_start_time, builder.relative_start_time, builder.relative_end_time, builder.saved_relative_end_time, builder.saved_relative_start_time, builder.engine_clip_id, builder.duration, builder.trim_time_start, builder.trim_time_end, builder.saved_trim_time_start, builder.saved_trim_time_end, builder.clip_volume, builder.media_path, builder.original_media_path, builder.media_title, builder.mute_audio, builder.loop, builder.is_voice_recording, builder.is_pending_voice_recording, builder.is_extract_audio, builder.video_clip_item_uuid_lsb, builder.video_clip_item_uuid_msb, builder.is_bg_music, builder.volume_envelope_time, builder.volume_envelope_level, builder.clip_width, builder.pinned, builder.saved_loop_duration, builder.extend_to_end, builder.voice_changer, builder.pan_left, builder.pan_right, builder.compressor, builder.pitch_factor, builder.clip_name, builder.audio_asset_id_ios, builder.enhancedAudioFilter, builder.equalizer);
                setBuilder(builder);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends Message.a<KMProject> {
            public Integer aspect_ratio_height;
            public Integer aspect_ratio_width;
            public List<Integer> bookmarks;
            public Boolean is_project_audio_fade_in_on;
            public Boolean is_project_audio_fade_out_on;
            public Boolean is_project_video_fade_in_on;
            public Boolean is_project_video_fade_out_on;
            public List<TimelineItem> primary_items;
            public Float project_audio_fade_in_time;
            public Float project_audio_fade_out_time;
            public Boolean project_auto_master;
            public Integer project_capability_mode;
            public String project_default_img_crop_mode;
            public Integer project_default_img_crop_mode_ios;
            public Integer project_default_img_duration;
            public Integer project_default_layer_duration;
            public Integer project_frame_rate;
            public Integer project_master_volume;
            public AspectRatio project_ratio;
            public Integer project_resolution_setting;
            public Float project_video_fade_in_time;
            public Float project_video_fade_out_time;
            public Integer recent_scroll_time;
            public List<TimelineItem> secondary_items;
            public Integer timeline_format_version;
            public List<Track> tracks;

            public Builder() {
            }

            public Builder aspect_ratio_height(Integer num) {
                this.aspect_ratio_height = num;
                return this;
            }

            public Builder aspect_ratio_width(Integer num) {
                this.aspect_ratio_width = num;
                return this;
            }

            public Builder bookmarks(List<Integer> list) {
                Message.a.checkForNulls(list);
                this.bookmarks = list;
                return this;
            }

            public Builder is_project_audio_fade_in_on(Boolean bool) {
                this.is_project_audio_fade_in_on = bool;
                return this;
            }

            public Builder is_project_audio_fade_out_on(Boolean bool) {
                this.is_project_audio_fade_out_on = bool;
                return this;
            }

            public Builder is_project_video_fade_in_on(Boolean bool) {
                this.is_project_video_fade_in_on = bool;
                return this;
            }

            public Builder is_project_video_fade_out_on(Boolean bool) {
                this.is_project_video_fade_out_on = bool;
                return this;
            }

            public Builder primary_items(List<TimelineItem> list) {
                Message.a.checkForNulls(list);
                this.primary_items = list;
                return this;
            }

            public Builder project_audio_fade_in_time(Float f2) {
                this.project_audio_fade_in_time = f2;
                return this;
            }

            public Builder project_audio_fade_out_time(Float f2) {
                this.project_audio_fade_out_time = f2;
                return this;
            }

            public Builder project_auto_master(Boolean bool) {
                this.project_auto_master = bool;
                return this;
            }

            public Builder project_capability_mode(Integer num) {
                this.project_capability_mode = num;
                return this;
            }

            public Builder project_default_img_crop_mode(String str) {
                this.project_default_img_crop_mode = str;
                return this;
            }

            public Builder project_default_img_crop_mode_ios(Integer num) {
                this.project_default_img_crop_mode_ios = num;
                return this;
            }

            public Builder project_default_img_duration(Integer num) {
                this.project_default_img_duration = num;
                return this;
            }

            public Builder project_default_layer_duration(Integer num) {
                this.project_default_layer_duration = num;
                return this;
            }

            public Builder project_frame_rate(Integer num) {
                this.project_frame_rate = num;
                return this;
            }

            public Builder project_master_volume(Integer num) {
                this.project_master_volume = num;
                return this;
            }

            public Builder project_ratio(AspectRatio aspectRatio) {
                this.project_ratio = aspectRatio;
                return this;
            }

            public Builder project_resolution_setting(Integer num) {
                this.project_resolution_setting = num;
                return this;
            }

            public Builder project_video_fade_in_time(Float f2) {
                this.project_video_fade_in_time = f2;
                return this;
            }

            public Builder project_video_fade_out_time(Float f2) {
                this.project_video_fade_out_time = f2;
                return this;
            }

            public Builder recent_scroll_time(Integer num) {
                this.recent_scroll_time = num;
                return this;
            }

            public Builder secondary_items(List<TimelineItem> list) {
                Message.a.checkForNulls(list);
                this.secondary_items = list;
                return this;
            }

            public Builder timeline_format_version(Integer num) {
                this.timeline_format_version = num;
                return this;
            }

            public Builder tracks(List<Track> list) {
                Message.a.checkForNulls(list);
                this.tracks = list;
                return this;
            }

            public Builder(KMProject kMProject) {
                super(kMProject);
                if (kMProject == null) {
                    return;
                }
                this.timeline_format_version = kMProject.timeline_format_version;
                this.primary_items = Message.copyOf(kMProject.primary_items);
                this.secondary_items = Message.copyOf(kMProject.secondary_items);
                this.tracks = Message.copyOf(kMProject.tracks);
                this.bookmarks = Message.copyOf(kMProject.bookmarks);
                this.recent_scroll_time = kMProject.recent_scroll_time;
                this.project_ratio = kMProject.project_ratio;
                this.project_audio_fade_in_time = kMProject.project_audio_fade_in_time;
                this.project_audio_fade_out_time = kMProject.project_audio_fade_out_time;
                this.is_project_audio_fade_in_on = kMProject.is_project_audio_fade_in_on;
                this.is_project_audio_fade_out_on = kMProject.is_project_audio_fade_out_on;
                this.project_video_fade_in_time = kMProject.project_video_fade_in_time;
                this.project_video_fade_out_time = kMProject.project_video_fade_out_time;
                this.is_project_video_fade_in_on = kMProject.is_project_video_fade_in_on;
                this.is_project_video_fade_out_on = kMProject.is_project_video_fade_out_on;
                this.project_default_img_duration = kMProject.project_default_img_duration;
                this.project_default_layer_duration = kMProject.project_default_layer_duration;
                this.project_default_img_crop_mode = kMProject.project_default_img_crop_mode;
                this.project_auto_master = kMProject.project_auto_master;
                this.project_master_volume = kMProject.project_master_volume;
                this.project_resolution_setting = kMProject.project_resolution_setting;
                this.project_frame_rate = kMProject.project_frame_rate;
                this.project_default_img_crop_mode_ios = kMProject.project_default_img_crop_mode_ios;
                this.project_capability_mode = kMProject.project_capability_mode;
                this.aspect_ratio_width = kMProject.aspect_ratio_width;
                this.aspect_ratio_height = kMProject.aspect_ratio_height;
            }

            @Override // com.squareup.wire.Message.a
            public KMProject build() {
                return new KMProject(this);
            }
        }

        /* loaded from: classes2.dex */
        public enum CapDecorationStyle implements m {
            NONE(1),
            ROUND(2),
            SOLID_ARROW(3),
            HOLLOW_ARROW(4);

            private final int value;

            CapDecorationStyle(int i) {
                this.value = i;
            }

            @Override // com.squareup.wire.m
            public int getValue() {
                return this.value;
            }
        }

        /* loaded from: classes2.dex */
        public enum ClipState implements m {
            BUSY(1),
            TEMPORARY_FAILURE(2),
            PERMANENT_FAILURE(3),
            READY_TO_PLAY(4);

            private final int value;

            ClipState(int i) {
                this.value = i;
            }

            @Override // com.squareup.wire.m
            public int getValue() {
                return this.value;
            }
        }

        /* loaded from: classes2.dex */
        public enum ClipType implements m {
            VISUAL_CLIP(1),
            TRANSITION(2),
            AUDIO_CLIP(3),
            LAYER_TEXT(4),
            LAYER_STICKER(5),
            LAYER_HANDWRITING(6),
            LAYER_IMAGE(7),
            LAYER_VIDEO(8),
            LAYER_EFFECT(9),
            LAYER_ASSET(10),
            LAYER_GROUP(11);

            private final int value;

            ClipType(int i) {
                this.value = i;
            }

            @Override // com.squareup.wire.m
            public int getValue() {
                return this.value;
            }
        }

        /* loaded from: classes.dex */
        public static final class ColorEffect extends Message {
            public static final Float DEFAULT_BRIGHTNESS;
            public static final Float DEFAULT_CONTRAST;
            public static final String DEFAULT_PRESET_NAME = "";
            public static final Float DEFAULT_SATURATION;
            public static final Integer DEFAULT_TINT_COLOR;
            private static final long serialVersionUID = 0;

            @n(tag = 1, type = Message.Datatype.FLOAT)
            public final Float brightness;

            @n(tag = 2, type = Message.Datatype.FLOAT)
            public final Float contrast;

            @n(tag = 5, type = Message.Datatype.STRING)
            public final String preset_name;

            @n(tag = 3, type = Message.Datatype.FLOAT)
            public final Float saturation;

            @n(tag = 4, type = Message.Datatype.FIXED32)
            public final Integer tint_color;

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<ColorEffect> {
                public Float brightness;
                public Float contrast;
                public String preset_name;
                public Float saturation;
                public Integer tint_color;

                public Builder() {
                }

                public Builder brightness(Float f2) {
                    this.brightness = f2;
                    return this;
                }

                public Builder contrast(Float f2) {
                    this.contrast = f2;
                    return this;
                }

                public Builder preset_name(String str) {
                    this.preset_name = str;
                    return this;
                }

                public Builder saturation(Float f2) {
                    this.saturation = f2;
                    return this;
                }

                public Builder tint_color(Integer num) {
                    this.tint_color = num;
                    return this;
                }

                public Builder(ColorEffect colorEffect) {
                    super(colorEffect);
                    if (colorEffect == null) {
                        return;
                    }
                    this.brightness = colorEffect.brightness;
                    this.contrast = colorEffect.contrast;
                    this.saturation = colorEffect.saturation;
                    this.tint_color = colorEffect.tint_color;
                    this.preset_name = colorEffect.preset_name;
                }

                @Override // com.squareup.wire.Message.a
                public ColorEffect build() {
                    return new ColorEffect(this);
                }
            }

            static {
                Float valueOf = Float.valueOf(0.0f);
                DEFAULT_BRIGHTNESS = valueOf;
                DEFAULT_CONTRAST = valueOf;
                DEFAULT_SATURATION = valueOf;
                DEFAULT_TINT_COLOR = 0;
            }

            /* synthetic */ ColorEffect(Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof ColorEffect)) {
                    return false;
                }
                ColorEffect colorEffect = (ColorEffect) obj;
                return equals(this.brightness, colorEffect.brightness) && equals(this.contrast, colorEffect.contrast) && equals(this.saturation, colorEffect.saturation) && equals(this.tint_color, colorEffect.tint_color) && equals(this.preset_name, colorEffect.preset_name);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i != 0) {
                    return i;
                }
                Float f2 = this.brightness;
                int hashCode = (f2 != null ? f2.hashCode() : 0) * 37;
                Float f3 = this.contrast;
                int hashCode2 = (hashCode + (f3 != null ? f3.hashCode() : 0)) * 37;
                Float f4 = this.saturation;
                int hashCode3 = (hashCode2 + (f4 != null ? f4.hashCode() : 0)) * 37;
                Integer num = this.tint_color;
                int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
                String str = this.preset_name;
                int hashCode5 = hashCode4 + (str != null ? str.hashCode() : 0);
                this.hashCode = hashCode5;
                return hashCode5;
            }

            public ColorEffect(Float f2, Float f3, Float f4, Integer num, String str) {
                this.brightness = f2;
                this.contrast = f3;
                this.saturation = f4;
                this.tint_color = num;
                this.preset_name = str;
            }

            private ColorEffect(Builder builder) {
                this(builder.brightness, builder.contrast, builder.saturation, builder.tint_color, builder.preset_name);
                setBuilder(builder);
            }
        }

        /* loaded from: classes.dex */
        public static final class DrawingAction extends Message {
            public static final CapDecorationStyle DEFAULT_END_CAP;
            public static final Float DEFAULT_HARDNESS;
            public static final Boolean DEFAULT_IS_ERASER;
            public static final PathStyle DEFAULT_PATH_STYLE;
            public static final CapDecorationStyle DEFAULT_START_CAP;
            public static final Boolean DEFAULT_STRAIGHT_LINE;
            public static final Float DEFAULT_STROKE_WIDTH;
            private static final long serialVersionUID = 0;

            @n(tag = 3, type = Message.Datatype.INT32)
            public final Integer color;

            @n(tag = 1, type = Message.Datatype.ENUM)
            public final DrawingActionType drawing_action_type;

            @n(tag = 10, type = Message.Datatype.ENUM)
            public final CapDecorationStyle end_cap;

            @n(tag = 5, type = Message.Datatype.FLOAT)
            public final Float hardness;

            @n(tag = 6, type = Message.Datatype.BOOL)
            public final Boolean is_eraser;

            @n(tag = 8, type = Message.Datatype.ENUM)
            public final PathStyle path_style;

            @n(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.FLOAT)
            public final List<Float> points;

            @n(tag = 9, type = Message.Datatype.ENUM)
            public final CapDecorationStyle start_cap;

            @n(tag = 7, type = Message.Datatype.BOOL)
            public final Boolean straight_line;

            @n(tag = 4, type = Message.Datatype.FLOAT)
            public final Float stroke_width;
            public static final DrawingActionType DEFAULT_DRAWING_ACTION_TYPE = DrawingActionType.STROKE;
            public static final List<Float> DEFAULT_POINTS = Collections.emptyList();
            public static final Integer DEFAULT_COLOR = 0;

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<DrawingAction> {
                public Integer color;
                public DrawingActionType drawing_action_type;
                public CapDecorationStyle end_cap;
                public Float hardness;
                public Boolean is_eraser;
                public PathStyle path_style;
                public List<Float> points;
                public CapDecorationStyle start_cap;
                public Boolean straight_line;
                public Float stroke_width;

                public Builder() {
                }

                public Builder color(Integer num) {
                    this.color = num;
                    return this;
                }

                public Builder drawing_action_type(DrawingActionType drawingActionType) {
                    this.drawing_action_type = drawingActionType;
                    return this;
                }

                public Builder end_cap(CapDecorationStyle capDecorationStyle) {
                    this.end_cap = capDecorationStyle;
                    return this;
                }

                public Builder hardness(Float f2) {
                    this.hardness = f2;
                    return this;
                }

                public Builder is_eraser(Boolean bool) {
                    this.is_eraser = bool;
                    return this;
                }

                public Builder path_style(PathStyle pathStyle) {
                    this.path_style = pathStyle;
                    return this;
                }

                public Builder points(List<Float> list) {
                    Message.a.checkForNulls(list);
                    this.points = list;
                    return this;
                }

                public Builder start_cap(CapDecorationStyle capDecorationStyle) {
                    this.start_cap = capDecorationStyle;
                    return this;
                }

                public Builder straight_line(Boolean bool) {
                    this.straight_line = bool;
                    return this;
                }

                public Builder stroke_width(Float f2) {
                    this.stroke_width = f2;
                    return this;
                }

                public Builder(DrawingAction drawingAction) {
                    super(drawingAction);
                    if (drawingAction == null) {
                        return;
                    }
                    this.drawing_action_type = drawingAction.drawing_action_type;
                    this.points = Message.copyOf(drawingAction.points);
                    this.color = drawingAction.color;
                    this.stroke_width = drawingAction.stroke_width;
                    this.hardness = drawingAction.hardness;
                    this.is_eraser = drawingAction.is_eraser;
                    this.straight_line = drawingAction.straight_line;
                    this.path_style = drawingAction.path_style;
                    this.start_cap = drawingAction.start_cap;
                    this.end_cap = drawingAction.end_cap;
                }

                @Override // com.squareup.wire.Message.a
                public DrawingAction build() {
                    return new DrawingAction(this);
                }
            }

            static {
                Float valueOf = Float.valueOf(0.0f);
                DEFAULT_STROKE_WIDTH = valueOf;
                DEFAULT_HARDNESS = valueOf;
                DEFAULT_IS_ERASER = false;
                DEFAULT_STRAIGHT_LINE = false;
                DEFAULT_PATH_STYLE = PathStyle.SMOOTH;
                CapDecorationStyle capDecorationStyle = CapDecorationStyle.NONE;
                DEFAULT_START_CAP = capDecorationStyle;
                DEFAULT_END_CAP = capDecorationStyle;
            }

            /* synthetic */ DrawingAction(Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof DrawingAction)) {
                    return false;
                }
                DrawingAction drawingAction = (DrawingAction) obj;
                return equals(this.drawing_action_type, drawingAction.drawing_action_type) && equals((List<?>) this.points, (List<?>) drawingAction.points) && equals(this.color, drawingAction.color) && equals(this.stroke_width, drawingAction.stroke_width) && equals(this.hardness, drawingAction.hardness) && equals(this.is_eraser, drawingAction.is_eraser) && equals(this.straight_line, drawingAction.straight_line) && equals(this.path_style, drawingAction.path_style) && equals(this.start_cap, drawingAction.start_cap) && equals(this.end_cap, drawingAction.end_cap);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i != 0) {
                    return i;
                }
                DrawingActionType drawingActionType = this.drawing_action_type;
                int hashCode = (drawingActionType != null ? drawingActionType.hashCode() : 0) * 37;
                List<Float> list = this.points;
                int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
                Integer num = this.color;
                int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
                Float f2 = this.stroke_width;
                int hashCode4 = (hashCode3 + (f2 != null ? f2.hashCode() : 0)) * 37;
                Float f3 = this.hardness;
                int hashCode5 = (hashCode4 + (f3 != null ? f3.hashCode() : 0)) * 37;
                Boolean bool = this.is_eraser;
                int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
                Boolean bool2 = this.straight_line;
                int hashCode7 = (hashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
                PathStyle pathStyle = this.path_style;
                int hashCode8 = (hashCode7 + (pathStyle != null ? pathStyle.hashCode() : 0)) * 37;
                CapDecorationStyle capDecorationStyle = this.start_cap;
                int hashCode9 = (hashCode8 + (capDecorationStyle != null ? capDecorationStyle.hashCode() : 0)) * 37;
                CapDecorationStyle capDecorationStyle2 = this.end_cap;
                int hashCode10 = hashCode9 + (capDecorationStyle2 != null ? capDecorationStyle2.hashCode() : 0);
                this.hashCode = hashCode10;
                return hashCode10;
            }

            public DrawingAction(DrawingActionType drawingActionType, List<Float> list, Integer num, Float f2, Float f3, Boolean bool, Boolean bool2, PathStyle pathStyle, CapDecorationStyle capDecorationStyle, CapDecorationStyle capDecorationStyle2) {
                this.drawing_action_type = drawingActionType;
                this.points = Message.immutableCopyOf(list);
                this.color = num;
                this.stroke_width = f2;
                this.hardness = f3;
                this.is_eraser = bool;
                this.straight_line = bool2;
                this.path_style = pathStyle;
                this.start_cap = capDecorationStyle;
                this.end_cap = capDecorationStyle2;
            }

            private DrawingAction(Builder builder) {
                this(builder.drawing_action_type, builder.points, builder.color, builder.stroke_width, builder.hardness, builder.is_eraser, builder.straight_line, builder.path_style, builder.start_cap, builder.end_cap);
                setBuilder(builder);
            }
        }

        /* loaded from: classes2.dex */
        public enum DrawingActionType implements m {
            STROKE(1),
            ERASE_ALL(2);

            private final int value;

            DrawingActionType(int i) {
                this.value = i;
            }

            @Override // com.squareup.wire.m
            public int getValue() {
                return this.value;
            }
        }

        /* loaded from: classes.dex */
        public static final class EffectLayer extends Message {
            public static final String DEFAULT_EFFECT_ID = "";
            public static final Float DEFAULT_EFFECT_STRENGTH;
            public static final Float DEFAULT_EFFECT_VARIATION;
            private static final long serialVersionUID = 0;

            @n(tag = 101, type = Message.Datatype.STRING)
            public final String effect_id;

            @n(tag = 102, type = Message.Datatype.FLOAT)
            public final Float effect_strength;

            @n(tag = 103, type = Message.Datatype.FLOAT)
            public final Float effect_variation;

            @n(tag = 100)
            public final LayerCommon layer_common;

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<EffectLayer> {
                public String effect_id;
                public Float effect_strength;
                public Float effect_variation;
                public LayerCommon layer_common;

                public Builder() {
                }

                public Builder effect_id(String str) {
                    this.effect_id = str;
                    return this;
                }

                public Builder effect_strength(Float f2) {
                    this.effect_strength = f2;
                    return this;
                }

                public Builder effect_variation(Float f2) {
                    this.effect_variation = f2;
                    return this;
                }

                public Builder layer_common(LayerCommon layerCommon) {
                    this.layer_common = layerCommon;
                    return this;
                }

                public Builder(EffectLayer effectLayer) {
                    super(effectLayer);
                    if (effectLayer == null) {
                        return;
                    }
                    this.layer_common = effectLayer.layer_common;
                    this.effect_id = effectLayer.effect_id;
                    this.effect_strength = effectLayer.effect_strength;
                    this.effect_variation = effectLayer.effect_variation;
                }

                @Override // com.squareup.wire.Message.a
                public EffectLayer build() {
                    return new EffectLayer(this);
                }
            }

            static {
                Float valueOf = Float.valueOf(0.0f);
                DEFAULT_EFFECT_STRENGTH = valueOf;
                DEFAULT_EFFECT_VARIATION = valueOf;
            }

            /* synthetic */ EffectLayer(Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof EffectLayer)) {
                    return false;
                }
                EffectLayer effectLayer = (EffectLayer) obj;
                return equals(this.layer_common, effectLayer.layer_common) && equals(this.effect_id, effectLayer.effect_id) && equals(this.effect_strength, effectLayer.effect_strength) && equals(this.effect_variation, effectLayer.effect_variation);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i != 0) {
                    return i;
                }
                LayerCommon layerCommon = this.layer_common;
                int hashCode = (layerCommon != null ? layerCommon.hashCode() : 0) * 37;
                String str = this.effect_id;
                int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
                Float f2 = this.effect_strength;
                int hashCode3 = (hashCode2 + (f2 != null ? f2.hashCode() : 0)) * 37;
                Float f3 = this.effect_variation;
                int hashCode4 = hashCode3 + (f3 != null ? f3.hashCode() : 0);
                this.hashCode = hashCode4;
                return hashCode4;
            }

            public EffectLayer(LayerCommon layerCommon, String str, Float f2, Float f3) {
                this.layer_common = layerCommon;
                this.effect_id = str;
                this.effect_strength = f2;
                this.effect_variation = f3;
            }

            private EffectLayer(Builder builder) {
                this(builder.layer_common, builder.effect_id, builder.effect_strength, builder.effect_variation);
                setBuilder(builder);
            }
        }

        /* loaded from: classes.dex */
        public static final class GroupLayer extends Message {
            public static final List<TimelineItem> DEFAULT_CHILD_ITEMS = Collections.emptyList();
            private static final long serialVersionUID = 0;

            @n(label = Message.Label.REPEATED, messageType = TimelineItem.class, tag = 101)
            public final List<TimelineItem> child_items;

            @n(tag = 100)
            public final LayerCommon layer_common;

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<GroupLayer> {
                public List<TimelineItem> child_items;
                public LayerCommon layer_common;

                public Builder() {
                }

                public Builder child_items(List<TimelineItem> list) {
                    Message.a.checkForNulls(list);
                    this.child_items = list;
                    return this;
                }

                public Builder layer_common(LayerCommon layerCommon) {
                    this.layer_common = layerCommon;
                    return this;
                }

                public Builder(GroupLayer groupLayer) {
                    super(groupLayer);
                    if (groupLayer == null) {
                        return;
                    }
                    this.layer_common = groupLayer.layer_common;
                    this.child_items = Message.copyOf(groupLayer.child_items);
                }

                @Override // com.squareup.wire.Message.a
                public GroupLayer build() {
                    return new GroupLayer(this);
                }
            }

            /* synthetic */ GroupLayer(Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof GroupLayer)) {
                    return false;
                }
                GroupLayer groupLayer = (GroupLayer) obj;
                return equals(this.layer_common, groupLayer.layer_common) && equals((List<?>) this.child_items, (List<?>) groupLayer.child_items);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i != 0) {
                    return i;
                }
                LayerCommon layerCommon = this.layer_common;
                int hashCode = (layerCommon != null ? layerCommon.hashCode() : 0) * 37;
                List<TimelineItem> list = this.child_items;
                int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
                this.hashCode = hashCode2;
                return hashCode2;
            }

            public GroupLayer(LayerCommon layerCommon, List<TimelineItem> list) {
                this.layer_common = layerCommon;
                this.child_items = Message.immutableCopyOf(list);
            }

            private GroupLayer(Builder builder) {
                this(builder.layer_common, builder.child_items);
                setBuilder(builder);
            }
        }

        /* loaded from: classes.dex */
        public static final class HandwritingLayer extends Message {
            private static final long serialVersionUID = 0;

            @n(label = Message.Label.REPEATED, messageType = DrawingAction.class, tag = 1)
            public final List<DrawingAction> drawing_actions;

            @n(label = Message.Label.REPEATED, messageType = WritingPoint.class, tag = 103)
            public final List<WritingPoint> handwriting_frame_ios;

            @n(tag = 100)
            public final LayerCommon layer_common;

            @n(tag = 101, type = Message.Datatype.INT32)
            public final Integer pivot_x;

            @n(tag = 102, type = Message.Datatype.INT32)
            public final Integer pivot_y;
            public static final Integer DEFAULT_PIVOT_X = 0;
            public static final Integer DEFAULT_PIVOT_Y = 0;
            public static final List<WritingPoint> DEFAULT_HANDWRITING_FRAME_IOS = Collections.emptyList();
            public static final List<DrawingAction> DEFAULT_DRAWING_ACTIONS = Collections.emptyList();

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<HandwritingLayer> {
                public List<DrawingAction> drawing_actions;
                public List<WritingPoint> handwriting_frame_ios;
                public LayerCommon layer_common;
                public Integer pivot_x;
                public Integer pivot_y;

                public Builder() {
                }

                public Builder drawing_actions(List<DrawingAction> list) {
                    Message.a.checkForNulls(list);
                    this.drawing_actions = list;
                    return this;
                }

                public Builder handwriting_frame_ios(List<WritingPoint> list) {
                    Message.a.checkForNulls(list);
                    this.handwriting_frame_ios = list;
                    return this;
                }

                public Builder layer_common(LayerCommon layerCommon) {
                    this.layer_common = layerCommon;
                    return this;
                }

                public Builder pivot_x(Integer num) {
                    this.pivot_x = num;
                    return this;
                }

                public Builder pivot_y(Integer num) {
                    this.pivot_y = num;
                    return this;
                }

                public Builder(HandwritingLayer handwritingLayer) {
                    super(handwritingLayer);
                    if (handwritingLayer == null) {
                        return;
                    }
                    this.layer_common = handwritingLayer.layer_common;
                    this.pivot_x = handwritingLayer.pivot_x;
                    this.pivot_y = handwritingLayer.pivot_y;
                    this.handwriting_frame_ios = Message.copyOf(handwritingLayer.handwriting_frame_ios);
                    this.drawing_actions = Message.copyOf(handwritingLayer.drawing_actions);
                }

                @Override // com.squareup.wire.Message.a
                public HandwritingLayer build() {
                    return new HandwritingLayer(this);
                }
            }

            /* synthetic */ HandwritingLayer(Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof HandwritingLayer)) {
                    return false;
                }
                HandwritingLayer handwritingLayer = (HandwritingLayer) obj;
                return equals(this.layer_common, handwritingLayer.layer_common) && equals(this.pivot_x, handwritingLayer.pivot_x) && equals(this.pivot_y, handwritingLayer.pivot_y) && equals((List<?>) this.handwriting_frame_ios, (List<?>) handwritingLayer.handwriting_frame_ios) && equals((List<?>) this.drawing_actions, (List<?>) handwritingLayer.drawing_actions);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i != 0) {
                    return i;
                }
                LayerCommon layerCommon = this.layer_common;
                int hashCode = (layerCommon != null ? layerCommon.hashCode() : 0) * 37;
                Integer num = this.pivot_x;
                int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
                Integer num2 = this.pivot_y;
                int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
                List<WritingPoint> list = this.handwriting_frame_ios;
                int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
                List<DrawingAction> list2 = this.drawing_actions;
                int hashCode5 = hashCode4 + (list2 != null ? list2.hashCode() : 1);
                this.hashCode = hashCode5;
                return hashCode5;
            }

            public HandwritingLayer(LayerCommon layerCommon, Integer num, Integer num2, List<WritingPoint> list, List<DrawingAction> list2) {
                this.layer_common = layerCommon;
                this.pivot_x = num;
                this.pivot_y = num2;
                this.handwriting_frame_ios = Message.immutableCopyOf(list);
                this.drawing_actions = Message.immutableCopyOf(list2);
            }

            private HandwritingLayer(Builder builder) {
                this(builder.layer_common, builder.pivot_x, builder.pivot_y, builder.handwriting_frame_ios, builder.drawing_actions);
                setBuilder(builder);
            }
        }

        /* loaded from: classes.dex */
        public static final class ImageLayer extends Message {
            public static final String DEFAULT_IMAGE_MSID = "";
            public static final String DEFAULT_IMAGE_PATH = "";
            private static final long serialVersionUID = 0;

            @n(tag = 103, type = Message.Datatype.INT32)
            public final Integer brightness;

            @n(tag = 106)
            public final ColorEffect color_effect;

            @n(tag = 104, type = Message.Datatype.INT32)
            public final Integer contrast;

            @n(label = Message.Label.REPEATED, messageType = DrawingAction.class, tag = 107)
            public final List<DrawingAction> drawing_actions;

            @n(tag = 102, type = Message.Datatype.STRING)
            public final String image_msid;

            @n(tag = 101, type = Message.Datatype.STRING)
            public final String image_path;

            @n(tag = 100)
            public final LayerCommon layer_common;

            @n(tag = 105, type = Message.Datatype.INT32)
            public final Integer saturation;
            public static final Integer DEFAULT_BRIGHTNESS = 0;
            public static final Integer DEFAULT_CONTRAST = 0;
            public static final Integer DEFAULT_SATURATION = 0;
            public static final List<DrawingAction> DEFAULT_DRAWING_ACTIONS = Collections.emptyList();

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<ImageLayer> {
                public Integer brightness;
                public ColorEffect color_effect;
                public Integer contrast;
                public List<DrawingAction> drawing_actions;
                public String image_msid;
                public String image_path;
                public LayerCommon layer_common;
                public Integer saturation;

                public Builder() {
                }

                public Builder brightness(Integer num) {
                    this.brightness = num;
                    return this;
                }

                public Builder color_effect(ColorEffect colorEffect) {
                    this.color_effect = colorEffect;
                    return this;
                }

                public Builder contrast(Integer num) {
                    this.contrast = num;
                    return this;
                }

                public Builder drawing_actions(List<DrawingAction> list) {
                    Message.a.checkForNulls(list);
                    this.drawing_actions = list;
                    return this;
                }

                public Builder image_msid(String str) {
                    this.image_msid = str;
                    return this;
                }

                public Builder image_path(String str) {
                    this.image_path = str;
                    return this;
                }

                public Builder layer_common(LayerCommon layerCommon) {
                    this.layer_common = layerCommon;
                    return this;
                }

                public Builder saturation(Integer num) {
                    this.saturation = num;
                    return this;
                }

                public Builder(ImageLayer imageLayer) {
                    super(imageLayer);
                    if (imageLayer == null) {
                        return;
                    }
                    this.layer_common = imageLayer.layer_common;
                    this.image_path = imageLayer.image_path;
                    this.image_msid = imageLayer.image_msid;
                    this.brightness = imageLayer.brightness;
                    this.contrast = imageLayer.contrast;
                    this.saturation = imageLayer.saturation;
                    this.color_effect = imageLayer.color_effect;
                    this.drawing_actions = Message.copyOf(imageLayer.drawing_actions);
                }

                @Override // com.squareup.wire.Message.a
                public ImageLayer build() {
                    return new ImageLayer(this);
                }
            }

            /* synthetic */ ImageLayer(Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof ImageLayer)) {
                    return false;
                }
                ImageLayer imageLayer = (ImageLayer) obj;
                return equals(this.layer_common, imageLayer.layer_common) && equals(this.image_path, imageLayer.image_path) && equals(this.image_msid, imageLayer.image_msid) && equals(this.brightness, imageLayer.brightness) && equals(this.contrast, imageLayer.contrast) && equals(this.saturation, imageLayer.saturation) && equals(this.color_effect, imageLayer.color_effect) && equals((List<?>) this.drawing_actions, (List<?>) imageLayer.drawing_actions);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i != 0) {
                    return i;
                }
                LayerCommon layerCommon = this.layer_common;
                int hashCode = (layerCommon != null ? layerCommon.hashCode() : 0) * 37;
                String str = this.image_path;
                int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
                String str2 = this.image_msid;
                int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
                Integer num = this.brightness;
                int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
                Integer num2 = this.contrast;
                int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
                Integer num3 = this.saturation;
                int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
                ColorEffect colorEffect = this.color_effect;
                int hashCode7 = (hashCode6 + (colorEffect != null ? colorEffect.hashCode() : 0)) * 37;
                List<DrawingAction> list = this.drawing_actions;
                int hashCode8 = hashCode7 + (list != null ? list.hashCode() : 1);
                this.hashCode = hashCode8;
                return hashCode8;
            }

            public ImageLayer(LayerCommon layerCommon, String str, String str2, Integer num, Integer num2, Integer num3, ColorEffect colorEffect, List<DrawingAction> list) {
                this.layer_common = layerCommon;
                this.image_path = str;
                this.image_msid = str2;
                this.brightness = num;
                this.contrast = num2;
                this.saturation = num3;
                this.color_effect = colorEffect;
                this.drawing_actions = Message.immutableCopyOf(list);
            }

            private ImageLayer(Builder builder) {
                this(builder.layer_common, builder.image_path, builder.image_msid, builder.brightness, builder.contrast, builder.saturation, builder.color_effect, builder.drawing_actions);
                setBuilder(builder);
            }
        }

        /* loaded from: classes.dex */
        public static final class KeyFrame extends Message {
            public static final Float DEFAULT_ALPHA;
            public static final Float DEFAULT_ANGLE;
            public static final Float DEFAULT_SCALE;
            public static final Float DEFAULT_SCALEX;
            public static final Float DEFAULT_SCALEY;
            public static final Float DEFAULT_TIME;
            public static final Float DEFAULT_X;
            public static final Float DEFAULT_Y;
            private static final long serialVersionUID = 0;

            @n(tag = 106, type = Message.Datatype.FLOAT)
            public final Float alpha;

            @n(tag = 105, type = Message.Datatype.FLOAT)
            public final Float angle;

            @n(tag = 102, type = Message.Datatype.FLOAT)
            public final Float scale;

            @n(tag = 107, type = Message.Datatype.FLOAT)
            public final Float scalex;

            @n(tag = 108, type = Message.Datatype.FLOAT)
            public final Float scaley;

            @n(tag = 101, type = Message.Datatype.FLOAT)
            public final Float time;

            @n(tag = 103, type = Message.Datatype.FLOAT)
            public final Float x;

            @n(tag = 104, type = Message.Datatype.FLOAT)
            public final Float y;

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<KeyFrame> {
                public Float alpha;
                public Float angle;
                public Float scale;
                public Float scalex;
                public Float scaley;
                public Float time;
                public Float x;
                public Float y;

                public Builder() {
                }

                public Builder alpha(Float f2) {
                    this.alpha = f2;
                    return this;
                }

                public Builder angle(Float f2) {
                    this.angle = f2;
                    return this;
                }

                public Builder scale(Float f2) {
                    this.scale = f2;
                    return this;
                }

                public Builder scalex(Float f2) {
                    this.scalex = f2;
                    return this;
                }

                public Builder scaley(Float f2) {
                    this.scaley = f2;
                    return this;
                }

                public Builder time(Float f2) {
                    this.time = f2;
                    return this;
                }

                public Builder x(Float f2) {
                    this.x = f2;
                    return this;
                }

                public Builder y(Float f2) {
                    this.y = f2;
                    return this;
                }

                public Builder(KeyFrame keyFrame) {
                    super(keyFrame);
                    if (keyFrame == null) {
                        return;
                    }
                    this.time = keyFrame.time;
                    this.scale = keyFrame.scale;
                    this.x = keyFrame.x;
                    this.y = keyFrame.y;
                    this.angle = keyFrame.angle;
                    this.alpha = keyFrame.alpha;
                    this.scalex = keyFrame.scalex;
                    this.scaley = keyFrame.scaley;
                }

                @Override // com.squareup.wire.Message.a
                public KeyFrame build() {
                    return new KeyFrame(this);
                }
            }

            static {
                Float valueOf = Float.valueOf(0.0f);
                DEFAULT_TIME = valueOf;
                DEFAULT_SCALE = valueOf;
                DEFAULT_X = valueOf;
                DEFAULT_Y = valueOf;
                DEFAULT_ANGLE = valueOf;
                DEFAULT_ALPHA = valueOf;
                DEFAULT_SCALEX = valueOf;
                DEFAULT_SCALEY = valueOf;
            }

            /* synthetic */ KeyFrame(Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof KeyFrame)) {
                    return false;
                }
                KeyFrame keyFrame = (KeyFrame) obj;
                return equals(this.time, keyFrame.time) && equals(this.scale, keyFrame.scale) && equals(this.x, keyFrame.x) && equals(this.y, keyFrame.y) && equals(this.angle, keyFrame.angle) && equals(this.alpha, keyFrame.alpha) && equals(this.scalex, keyFrame.scalex) && equals(this.scaley, keyFrame.scaley);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i != 0) {
                    return i;
                }
                Float f2 = this.time;
                int hashCode = (f2 != null ? f2.hashCode() : 0) * 37;
                Float f3 = this.scale;
                int hashCode2 = (hashCode + (f3 != null ? f3.hashCode() : 0)) * 37;
                Float f4 = this.x;
                int hashCode3 = (hashCode2 + (f4 != null ? f4.hashCode() : 0)) * 37;
                Float f5 = this.y;
                int hashCode4 = (hashCode3 + (f5 != null ? f5.hashCode() : 0)) * 37;
                Float f6 = this.angle;
                int hashCode5 = (hashCode4 + (f6 != null ? f6.hashCode() : 0)) * 37;
                Float f7 = this.alpha;
                int hashCode6 = (hashCode5 + (f7 != null ? f7.hashCode() : 0)) * 37;
                Float f8 = this.scalex;
                int hashCode7 = (hashCode6 + (f8 != null ? f8.hashCode() : 0)) * 37;
                Float f9 = this.scaley;
                int hashCode8 = hashCode7 + (f9 != null ? f9.hashCode() : 0);
                this.hashCode = hashCode8;
                return hashCode8;
            }

            public KeyFrame(Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, Float f9) {
                this.time = f2;
                this.scale = f3;
                this.x = f4;
                this.y = f5;
                this.angle = f6;
                this.alpha = f7;
                this.scalex = f8;
                this.scaley = f9;
            }

            private KeyFrame(Builder builder) {
                this(builder.time, builder.scale, builder.x, builder.y, builder.angle, builder.alpha, builder.scalex, builder.scaley);
                setBuilder(builder);
            }
        }

        /* loaded from: classes2.dex */
        public enum LayerBlendModeType implements m {
            LAYER_BLEND_NONE(0),
            LAYER_BLEND_ADD(1),
            LAYER_BLEND_AVERAGE(2),
            LAYER_BLEND_COLOR_BURN(3),
            LAYER_BLEND_COLOR_DODGE(4),
            LAYER_BLEND_DARKEN(5),
            LAYER_BLEND_DIFFERENCE(6),
            LAYER_BLEND_EXCLUSION(7),
            LAYER_BLEND_GLOW(8),
            LAYER_BLEND_HARD_LIGHT(9),
            LAYER_BLEND_HARD_MIX(10),
            LAYER_BLEND_LIGHTEN(11),
            LAYER_BLEND_LINEAR_BURN(12),
            LAYER_BLEND_LINEAR_DODGE(13),
            LAYER_BLEND_LINEAR_LIGHT(14),
            LAYER_BLEND_MULTIPLY(15),
            LAYER_BLEND_NEGATION(16),
            LAYER_BLEND_NORMAL(17),
            LAYER_BLEND_OVERLAY(18),
            LAYER_BLEND_PHOENIX(19),
            LAYER_BLEND_PIN_LIGHT(20),
            LAYER_BLEND_REFLECT(21),
            LAYER_BLEND_SCREEN(22),
            LAYER_BLEND_SOFT_LIGHT(23),
            LAYER_BLEND_SUBTRACT(24),
            LAYER_BLEND_VIVID_LIGHT(25);

            private final int value;

            LayerBlendModeType(int i) {
                this.value = i;
            }

            @Override // com.squareup.wire.m
            public int getValue() {
                return this.value;
            }
        }

        /* loaded from: classes.dex */
        public static final class LayerCommon extends Message {
            public static final LayerBlendModeType DEFAULT_BLEND_MODE;
            public static final Float DEFAULT_CROP_BOUNDS_BOTTOM;
            public static final Float DEFAULT_CROP_BOUNDS_LEFT;
            public static final Float DEFAULT_CROP_BOUNDS_RIGHT;
            public static final Integer DEFAULT_CROP_BOUNDS_SHAPE;
            public static final Float DEFAULT_CROP_BOUNDS_TOP;
            public static final Float DEFAULT_CROP_MASK_FEATHER;
            public static final Boolean DEFAULT_FLIP_H;
            public static final Boolean DEFAULT_FLIP_V;
            public static final List<KeyFrame> DEFAULT_KEYFRAMES;
            public static final Boolean DEFAULT_LAYERMASK_ENABLED;
            public static final Integer DEFAULT_LAYERMASK_INDEX;
            public static final Integer DEFAULT_LAYERMASK_TYPE;
            public static final String DEFAULT_LAYER_NAME = "";
            public static final Float DEFAULT_LAYER_OVERALL_EXPRESSION_SPEED;
            public static final Integer DEFAULT_NATURAL_ORIENTATION;
            public static final Integer DEFAULT_OVERALL_ALPHA;
            public static final SplitScreenType DEFAULT_SPLIT_SCREEN_TYPE;
            public static final Integer DEFAULT_SPLIT_SIZE_BOTTOM;
            public static final Integer DEFAULT_SPLIT_SIZE_LEFT;
            public static final Integer DEFAULT_SPLIT_SIZE_RIGHT;
            public static final Integer DEFAULT_SPLIT_SIZE_TOP;
            public static final Boolean DEFAULT_USE_CROP_MASK;
            private static final long serialVersionUID = 0;

            @n(tag = 136, type = Message.Datatype.ENUM)
            public final LayerBlendModeType blend_mode;

            @n(tag = 131, type = Message.Datatype.FLOAT)
            public final Float crop_bounds_bottom;

            @n(tag = 128, type = Message.Datatype.FLOAT)
            public final Float crop_bounds_left;

            @n(tag = 130, type = Message.Datatype.FLOAT)
            public final Float crop_bounds_right;

            @n(tag = 132, type = Message.Datatype.INT32)
            public final Integer crop_bounds_shape;

            @n(tag = 129, type = Message.Datatype.FLOAT)
            public final Float crop_bounds_top;

            @n(tag = 133, type = Message.Datatype.FLOAT)
            public final Float crop_mask_feather;

            @n(tag = 101, type = Message.Datatype.INT32)
            public final Integer end_time;

            @n(tag = 104, type = Message.Datatype.INT32)
            public final Integer end_trim;

            @n(tag = 122, type = Message.Datatype.BOOL)
            public final Boolean flip_h;

            @n(tag = 123, type = Message.Datatype.BOOL)
            public final Boolean flip_v;

            @n(label = Message.Label.REPEATED, messageType = KeyFrame.class, tag = 108)
            public final List<KeyFrame> keyframes;

            @n(tag = 106, type = Message.Datatype.INT32)
            public final Integer layer_expression;

            @n(tag = 107, type = Message.Datatype.INT32)
            public final Integer layer_expression_duration;

            @n(tag = 109, type = Message.Datatype.INT32)
            public final Integer layer_in_expression;

            @n(tag = 110, type = Message.Datatype.INT32)
            public final Integer layer_in_expression_duration;

            @n(tag = 127, type = Message.Datatype.STRING)
            public final String layer_name;

            @n(tag = 111, type = Message.Datatype.INT32)
            public final Integer layer_out_expression;

            @n(tag = 112, type = Message.Datatype.INT32)
            public final Integer layer_out_expression_duration;

            @n(tag = 113, type = Message.Datatype.INT32)
            public final Integer layer_overall_expression;

            @n(tag = 114, type = Message.Datatype.FLOAT)
            public final Float layer_overall_expression_speed;

            @n(tag = 124, type = Message.Datatype.BOOL)
            public final Boolean layermask_enabled;

            @n(tag = 126, type = Message.Datatype.INT32)
            public final Integer layermask_index;

            @n(tag = 125, type = Message.Datatype.INT32)
            public final Integer layermask_type;

            @n(tag = 134, type = Message.Datatype.INT32)
            public final Integer natural_orientation;

            @n(tag = 121, type = Message.Datatype.INT32)
            public final Integer overall_alpha;

            @n(tag = 102, type = Message.Datatype.BOOL)
            public final Boolean pinned;

            @n(tag = 115)
            public final KeyFrame split_keyframe;

            @n(tag = 116, type = Message.Datatype.ENUM)
            public final SplitScreenType split_screen_type;

            @n(tag = 120, type = Message.Datatype.INT32)
            public final Integer split_size_bottom;

            @n(tag = 117, type = Message.Datatype.INT32)
            public final Integer split_size_left;

            @n(tag = 118, type = Message.Datatype.INT32)
            public final Integer split_size_right;

            @n(tag = 119, type = Message.Datatype.INT32)
            public final Integer split_size_top;

            @n(tag = 100, type = Message.Datatype.INT32)
            public final Integer start_time;

            @n(tag = 103, type = Message.Datatype.INT32)
            public final Integer start_trim;

            @n(tag = 135, type = Message.Datatype.BOOL)
            public final Boolean use_crop_mask;

            @n(tag = 105, type = Message.Datatype.INT64)
            public final Long z_order;
            public static final Integer DEFAULT_START_TIME = 0;
            public static final Integer DEFAULT_END_TIME = 0;
            public static final Boolean DEFAULT_PINNED = false;
            public static final Integer DEFAULT_START_TRIM = 0;
            public static final Integer DEFAULT_END_TRIM = 0;
            public static final Long DEFAULT_Z_ORDER = 0L;
            public static final Integer DEFAULT_LAYER_EXPRESSION = 0;
            public static final Integer DEFAULT_LAYER_EXPRESSION_DURATION = 0;
            public static final Integer DEFAULT_LAYER_IN_EXPRESSION = 0;
            public static final Integer DEFAULT_LAYER_IN_EXPRESSION_DURATION = 0;
            public static final Integer DEFAULT_LAYER_OUT_EXPRESSION = 0;
            public static final Integer DEFAULT_LAYER_OUT_EXPRESSION_DURATION = 0;
            public static final Integer DEFAULT_LAYER_OVERALL_EXPRESSION = 0;

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<LayerCommon> {
                public LayerBlendModeType blend_mode;
                public Float crop_bounds_bottom;
                public Float crop_bounds_left;
                public Float crop_bounds_right;
                public Integer crop_bounds_shape;
                public Float crop_bounds_top;
                public Float crop_mask_feather;
                public Integer end_time;
                public Integer end_trim;
                public Boolean flip_h;
                public Boolean flip_v;
                public List<KeyFrame> keyframes;
                public Integer layer_expression;
                public Integer layer_expression_duration;
                public Integer layer_in_expression;
                public Integer layer_in_expression_duration;
                public String layer_name;
                public Integer layer_out_expression;
                public Integer layer_out_expression_duration;
                public Integer layer_overall_expression;
                public Float layer_overall_expression_speed;
                public Boolean layermask_enabled;
                public Integer layermask_index;
                public Integer layermask_type;
                public Integer natural_orientation;
                public Integer overall_alpha;
                public Boolean pinned;
                public KeyFrame split_keyframe;
                public SplitScreenType split_screen_type;
                public Integer split_size_bottom;
                public Integer split_size_left;
                public Integer split_size_right;
                public Integer split_size_top;
                public Integer start_time;
                public Integer start_trim;
                public Boolean use_crop_mask;
                public Long z_order;

                public Builder() {
                }

                public Builder blend_mode(LayerBlendModeType layerBlendModeType) {
                    this.blend_mode = layerBlendModeType;
                    return this;
                }

                public Builder crop_bounds_bottom(Float f2) {
                    this.crop_bounds_bottom = f2;
                    return this;
                }

                public Builder crop_bounds_left(Float f2) {
                    this.crop_bounds_left = f2;
                    return this;
                }

                public Builder crop_bounds_right(Float f2) {
                    this.crop_bounds_right = f2;
                    return this;
                }

                public Builder crop_bounds_shape(Integer num) {
                    this.crop_bounds_shape = num;
                    return this;
                }

                public Builder crop_bounds_top(Float f2) {
                    this.crop_bounds_top = f2;
                    return this;
                }

                public Builder crop_mask_feather(Float f2) {
                    this.crop_mask_feather = f2;
                    return this;
                }

                public Builder end_time(Integer num) {
                    this.end_time = num;
                    return this;
                }

                public Builder end_trim(Integer num) {
                    this.end_trim = num;
                    return this;
                }

                public Builder flip_h(Boolean bool) {
                    this.flip_h = bool;
                    return this;
                }

                public Builder flip_v(Boolean bool) {
                    this.flip_v = bool;
                    return this;
                }

                public Builder keyframes(List<KeyFrame> list) {
                    Message.a.checkForNulls(list);
                    this.keyframes = list;
                    return this;
                }

                public Builder layer_expression(Integer num) {
                    this.layer_expression = num;
                    return this;
                }

                public Builder layer_expression_duration(Integer num) {
                    this.layer_expression_duration = num;
                    return this;
                }

                public Builder layer_in_expression(Integer num) {
                    this.layer_in_expression = num;
                    return this;
                }

                public Builder layer_in_expression_duration(Integer num) {
                    this.layer_in_expression_duration = num;
                    return this;
                }

                public Builder layer_name(String str) {
                    this.layer_name = str;
                    return this;
                }

                public Builder layer_out_expression(Integer num) {
                    this.layer_out_expression = num;
                    return this;
                }

                public Builder layer_out_expression_duration(Integer num) {
                    this.layer_out_expression_duration = num;
                    return this;
                }

                public Builder layer_overall_expression(Integer num) {
                    this.layer_overall_expression = num;
                    return this;
                }

                public Builder layer_overall_expression_speed(Float f2) {
                    this.layer_overall_expression_speed = f2;
                    return this;
                }

                public Builder layermask_enabled(Boolean bool) {
                    this.layermask_enabled = bool;
                    return this;
                }

                public Builder layermask_index(Integer num) {
                    this.layermask_index = num;
                    return this;
                }

                public Builder layermask_type(Integer num) {
                    this.layermask_type = num;
                    return this;
                }

                public Builder natural_orientation(Integer num) {
                    this.natural_orientation = num;
                    return this;
                }

                public Builder overall_alpha(Integer num) {
                    this.overall_alpha = num;
                    return this;
                }

                public Builder pinned(Boolean bool) {
                    this.pinned = bool;
                    return this;
                }

                public Builder split_keyframe(KeyFrame keyFrame) {
                    this.split_keyframe = keyFrame;
                    return this;
                }

                public Builder split_screen_type(SplitScreenType splitScreenType) {
                    this.split_screen_type = splitScreenType;
                    return this;
                }

                public Builder split_size_bottom(Integer num) {
                    this.split_size_bottom = num;
                    return this;
                }

                public Builder split_size_left(Integer num) {
                    this.split_size_left = num;
                    return this;
                }

                public Builder split_size_right(Integer num) {
                    this.split_size_right = num;
                    return this;
                }

                public Builder split_size_top(Integer num) {
                    this.split_size_top = num;
                    return this;
                }

                public Builder start_time(Integer num) {
                    this.start_time = num;
                    return this;
                }

                public Builder start_trim(Integer num) {
                    this.start_trim = num;
                    return this;
                }

                public Builder use_crop_mask(Boolean bool) {
                    this.use_crop_mask = bool;
                    return this;
                }

                public Builder z_order(Long l) {
                    this.z_order = l;
                    return this;
                }

                public Builder(LayerCommon layerCommon) {
                    super(layerCommon);
                    if (layerCommon == null) {
                        return;
                    }
                    this.start_time = layerCommon.start_time;
                    this.end_time = layerCommon.end_time;
                    this.pinned = layerCommon.pinned;
                    this.start_trim = layerCommon.start_trim;
                    this.end_trim = layerCommon.end_trim;
                    this.z_order = layerCommon.z_order;
                    this.layer_expression = layerCommon.layer_expression;
                    this.layer_expression_duration = layerCommon.layer_expression_duration;
                    this.layer_in_expression = layerCommon.layer_in_expression;
                    this.layer_in_expression_duration = layerCommon.layer_in_expression_duration;
                    this.layer_out_expression = layerCommon.layer_out_expression;
                    this.layer_out_expression_duration = layerCommon.layer_out_expression_duration;
                    this.layer_overall_expression = layerCommon.layer_overall_expression;
                    this.layer_overall_expression_speed = layerCommon.layer_overall_expression_speed;
                    this.split_screen_type = layerCommon.split_screen_type;
                    this.split_size_left = layerCommon.split_size_left;
                    this.split_size_right = layerCommon.split_size_right;
                    this.split_size_top = layerCommon.split_size_top;
                    this.split_size_bottom = layerCommon.split_size_bottom;
                    this.flip_h = layerCommon.flip_h;
                    this.flip_v = layerCommon.flip_v;
                    this.split_keyframe = layerCommon.split_keyframe;
                    this.keyframes = Message.copyOf(layerCommon.keyframes);
                    this.overall_alpha = layerCommon.overall_alpha;
                    this.layermask_enabled = layerCommon.layermask_enabled;
                    this.layermask_type = layerCommon.layermask_type;
                    this.layermask_index = layerCommon.layermask_index;
                    this.layer_name = layerCommon.layer_name;
                    this.crop_bounds_left = layerCommon.crop_bounds_left;
                    this.crop_bounds_top = layerCommon.crop_bounds_top;
                    this.crop_bounds_right = layerCommon.crop_bounds_right;
                    this.crop_bounds_bottom = layerCommon.crop_bounds_bottom;
                    this.crop_bounds_shape = layerCommon.crop_bounds_shape;
                    this.crop_mask_feather = layerCommon.crop_mask_feather;
                    this.natural_orientation = layerCommon.natural_orientation;
                    this.use_crop_mask = layerCommon.use_crop_mask;
                    this.blend_mode = layerCommon.blend_mode;
                }

                @Override // com.squareup.wire.Message.a
                public LayerCommon build() {
                    return new LayerCommon(this);
                }
            }

            static {
                Float valueOf = Float.valueOf(0.0f);
                DEFAULT_LAYER_OVERALL_EXPRESSION_SPEED = valueOf;
                DEFAULT_SPLIT_SCREEN_TYPE = SplitScreenType.OFF;
                DEFAULT_SPLIT_SIZE_LEFT = 0;
                DEFAULT_SPLIT_SIZE_RIGHT = 0;
                DEFAULT_SPLIT_SIZE_TOP = 0;
                DEFAULT_SPLIT_SIZE_BOTTOM = 0;
                DEFAULT_FLIP_H = false;
                DEFAULT_FLIP_V = false;
                DEFAULT_KEYFRAMES = Collections.emptyList();
                DEFAULT_OVERALL_ALPHA = 0;
                DEFAULT_LAYERMASK_ENABLED = false;
                DEFAULT_LAYERMASK_TYPE = 0;
                DEFAULT_LAYERMASK_INDEX = 0;
                DEFAULT_CROP_BOUNDS_LEFT = valueOf;
                DEFAULT_CROP_BOUNDS_TOP = valueOf;
                DEFAULT_CROP_BOUNDS_RIGHT = valueOf;
                DEFAULT_CROP_BOUNDS_BOTTOM = valueOf;
                DEFAULT_CROP_BOUNDS_SHAPE = 0;
                DEFAULT_CROP_MASK_FEATHER = valueOf;
                DEFAULT_NATURAL_ORIENTATION = 0;
                DEFAULT_USE_CROP_MASK = false;
                DEFAULT_BLEND_MODE = LayerBlendModeType.LAYER_BLEND_NORMAL;
            }

            /* synthetic */ LayerCommon(Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof LayerCommon)) {
                    return false;
                }
                LayerCommon layerCommon = (LayerCommon) obj;
                return equals(this.start_time, layerCommon.start_time) && equals(this.end_time, layerCommon.end_time) && equals(this.pinned, layerCommon.pinned) && equals(this.start_trim, layerCommon.start_trim) && equals(this.end_trim, layerCommon.end_trim) && equals(this.z_order, layerCommon.z_order) && equals(this.layer_expression, layerCommon.layer_expression) && equals(this.layer_expression_duration, layerCommon.layer_expression_duration) && equals(this.layer_in_expression, layerCommon.layer_in_expression) && equals(this.layer_in_expression_duration, layerCommon.layer_in_expression_duration) && equals(this.layer_out_expression, layerCommon.layer_out_expression) && equals(this.layer_out_expression_duration, layerCommon.layer_out_expression_duration) && equals(this.layer_overall_expression, layerCommon.layer_overall_expression) && equals(this.layer_overall_expression_speed, layerCommon.layer_overall_expression_speed) && equals(this.split_screen_type, layerCommon.split_screen_type) && equals(this.split_size_left, layerCommon.split_size_left) && equals(this.split_size_right, layerCommon.split_size_right) && equals(this.split_size_top, layerCommon.split_size_top) && equals(this.split_size_bottom, layerCommon.split_size_bottom) && equals(this.flip_h, layerCommon.flip_h) && equals(this.flip_v, layerCommon.flip_v) && equals(this.split_keyframe, layerCommon.split_keyframe) && equals((List<?>) this.keyframes, (List<?>) layerCommon.keyframes) && equals(this.overall_alpha, layerCommon.overall_alpha) && equals(this.layermask_enabled, layerCommon.layermask_enabled) && equals(this.layermask_type, layerCommon.layermask_type) && equals(this.layermask_index, layerCommon.layermask_index) && equals(this.layer_name, layerCommon.layer_name) && equals(this.crop_bounds_left, layerCommon.crop_bounds_left) && equals(this.crop_bounds_top, layerCommon.crop_bounds_top) && equals(this.crop_bounds_right, layerCommon.crop_bounds_right) && equals(this.crop_bounds_bottom, layerCommon.crop_bounds_bottom) && equals(this.crop_bounds_shape, layerCommon.crop_bounds_shape) && equals(this.crop_mask_feather, layerCommon.crop_mask_feather) && equals(this.natural_orientation, layerCommon.natural_orientation) && equals(this.use_crop_mask, layerCommon.use_crop_mask) && equals(this.blend_mode, layerCommon.blend_mode);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i != 0) {
                    return i;
                }
                Integer num = this.start_time;
                int hashCode = (num != null ? num.hashCode() : 0) * 37;
                Integer num2 = this.end_time;
                int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
                Boolean bool = this.pinned;
                int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
                Integer num3 = this.start_trim;
                int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
                Integer num4 = this.end_trim;
                int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
                Long l = this.z_order;
                int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
                Integer num5 = this.layer_expression;
                int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
                Integer num6 = this.layer_expression_duration;
                int hashCode8 = (hashCode7 + (num6 != null ? num6.hashCode() : 0)) * 37;
                Integer num7 = this.layer_in_expression;
                int hashCode9 = (hashCode8 + (num7 != null ? num7.hashCode() : 0)) * 37;
                Integer num8 = this.layer_in_expression_duration;
                int hashCode10 = (hashCode9 + (num8 != null ? num8.hashCode() : 0)) * 37;
                Integer num9 = this.layer_out_expression;
                int hashCode11 = (hashCode10 + (num9 != null ? num9.hashCode() : 0)) * 37;
                Integer num10 = this.layer_out_expression_duration;
                int hashCode12 = (hashCode11 + (num10 != null ? num10.hashCode() : 0)) * 37;
                Integer num11 = this.layer_overall_expression;
                int hashCode13 = (hashCode12 + (num11 != null ? num11.hashCode() : 0)) * 37;
                Float f2 = this.layer_overall_expression_speed;
                int hashCode14 = (hashCode13 + (f2 != null ? f2.hashCode() : 0)) * 37;
                SplitScreenType splitScreenType = this.split_screen_type;
                int hashCode15 = (hashCode14 + (splitScreenType != null ? splitScreenType.hashCode() : 0)) * 37;
                Integer num12 = this.split_size_left;
                int hashCode16 = (hashCode15 + (num12 != null ? num12.hashCode() : 0)) * 37;
                Integer num13 = this.split_size_right;
                int hashCode17 = (hashCode16 + (num13 != null ? num13.hashCode() : 0)) * 37;
                Integer num14 = this.split_size_top;
                int hashCode18 = (hashCode17 + (num14 != null ? num14.hashCode() : 0)) * 37;
                Integer num15 = this.split_size_bottom;
                int hashCode19 = (hashCode18 + (num15 != null ? num15.hashCode() : 0)) * 37;
                Boolean bool2 = this.flip_h;
                int hashCode20 = (hashCode19 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
                Boolean bool3 = this.flip_v;
                int hashCode21 = (hashCode20 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
                KeyFrame keyFrame = this.split_keyframe;
                int hashCode22 = (hashCode21 + (keyFrame != null ? keyFrame.hashCode() : 0)) * 37;
                List<KeyFrame> list = this.keyframes;
                int hashCode23 = (hashCode22 + (list != null ? list.hashCode() : 1)) * 37;
                Integer num16 = this.overall_alpha;
                int hashCode24 = (hashCode23 + (num16 != null ? num16.hashCode() : 0)) * 37;
                Boolean bool4 = this.layermask_enabled;
                int hashCode25 = (hashCode24 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
                Integer num17 = this.layermask_type;
                int hashCode26 = (hashCode25 + (num17 != null ? num17.hashCode() : 0)) * 37;
                Integer num18 = this.layermask_index;
                int hashCode27 = (hashCode26 + (num18 != null ? num18.hashCode() : 0)) * 37;
                String str = this.layer_name;
                int hashCode28 = (hashCode27 + (str != null ? str.hashCode() : 0)) * 37;
                Float f3 = this.crop_bounds_left;
                int hashCode29 = (hashCode28 + (f3 != null ? f3.hashCode() : 0)) * 37;
                Float f4 = this.crop_bounds_top;
                int hashCode30 = (hashCode29 + (f4 != null ? f4.hashCode() : 0)) * 37;
                Float f5 = this.crop_bounds_right;
                int hashCode31 = (hashCode30 + (f5 != null ? f5.hashCode() : 0)) * 37;
                Float f6 = this.crop_bounds_bottom;
                int hashCode32 = (hashCode31 + (f6 != null ? f6.hashCode() : 0)) * 37;
                Integer num19 = this.crop_bounds_shape;
                int hashCode33 = (hashCode32 + (num19 != null ? num19.hashCode() : 0)) * 37;
                Float f7 = this.crop_mask_feather;
                int hashCode34 = (hashCode33 + (f7 != null ? f7.hashCode() : 0)) * 37;
                Integer num20 = this.natural_orientation;
                int hashCode35 = (hashCode34 + (num20 != null ? num20.hashCode() : 0)) * 37;
                Boolean bool5 = this.use_crop_mask;
                int hashCode36 = (hashCode35 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
                LayerBlendModeType layerBlendModeType = this.blend_mode;
                int hashCode37 = hashCode36 + (layerBlendModeType != null ? layerBlendModeType.hashCode() : 0);
                this.hashCode = hashCode37;
                return hashCode37;
            }

            public LayerCommon(Integer num, Integer num2, Boolean bool, Integer num3, Integer num4, Long l, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Float f2, SplitScreenType splitScreenType, Integer num12, Integer num13, Integer num14, Integer num15, Boolean bool2, Boolean bool3, KeyFrame keyFrame, List<KeyFrame> list, Integer num16, Boolean bool4, Integer num17, Integer num18, String str, Float f3, Float f4, Float f5, Float f6, Integer num19, Float f7, Integer num20, Boolean bool5, LayerBlendModeType layerBlendModeType) {
                this.start_time = num;
                this.end_time = num2;
                this.pinned = bool;
                this.start_trim = num3;
                this.end_trim = num4;
                this.z_order = l;
                this.layer_expression = num5;
                this.layer_expression_duration = num6;
                this.layer_in_expression = num7;
                this.layer_in_expression_duration = num8;
                this.layer_out_expression = num9;
                this.layer_out_expression_duration = num10;
                this.layer_overall_expression = num11;
                this.layer_overall_expression_speed = f2;
                this.split_screen_type = splitScreenType;
                this.split_size_left = num12;
                this.split_size_right = num13;
                this.split_size_top = num14;
                this.split_size_bottom = num15;
                this.flip_h = bool2;
                this.flip_v = bool3;
                this.split_keyframe = keyFrame;
                this.keyframes = Message.immutableCopyOf(list);
                this.overall_alpha = num16;
                this.layermask_enabled = bool4;
                this.layermask_type = num17;
                this.layermask_index = num18;
                this.layer_name = str;
                this.crop_bounds_left = f3;
                this.crop_bounds_top = f4;
                this.crop_bounds_right = f5;
                this.crop_bounds_bottom = f6;
                this.crop_bounds_shape = num19;
                this.crop_mask_feather = f7;
                this.natural_orientation = num20;
                this.use_crop_mask = bool5;
                this.blend_mode = layerBlendModeType;
            }

            private LayerCommon(Builder builder) {
                this(builder.start_time, builder.end_time, builder.pinned, builder.start_trim, builder.end_trim, builder.z_order, builder.layer_expression, builder.layer_expression_duration, builder.layer_in_expression, builder.layer_in_expression_duration, builder.layer_out_expression, builder.layer_out_expression_duration, builder.layer_overall_expression, builder.layer_overall_expression_speed, builder.split_screen_type, builder.split_size_left, builder.split_size_right, builder.split_size_top, builder.split_size_bottom, builder.flip_h, builder.flip_v, builder.split_keyframe, builder.keyframes, builder.overall_alpha, builder.layermask_enabled, builder.layermask_type, builder.layermask_index, builder.layer_name, builder.crop_bounds_left, builder.crop_bounds_top, builder.crop_bounds_right, builder.crop_bounds_bottom, builder.crop_bounds_shape, builder.crop_mask_feather, builder.natural_orientation, builder.use_crop_mask, builder.blend_mode);
                setBuilder(builder);
            }
        }

        /* loaded from: classes.dex */
        public static final class Matrix extends Message {
            public static final List<Float> DEFAULT_ELEMENT = Collections.emptyList();
            private static final long serialVersionUID = 0;

            @n(label = Message.Label.PACKED, tag = 1, type = Message.Datatype.FLOAT)
            public final List<Float> element;

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<Matrix> {
                public List<Float> element;

                public Builder() {
                }

                public Builder element(List<Float> list) {
                    Message.a.checkForNulls(list);
                    this.element = list;
                    return this;
                }

                public Builder(Matrix matrix) {
                    super(matrix);
                    if (matrix == null) {
                        return;
                    }
                    this.element = Message.copyOf(matrix.element);
                }

                @Override // com.squareup.wire.Message.a
                public Matrix build() {
                    return new Matrix(this);
                }
            }

            /* synthetic */ Matrix(Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof Matrix) {
                    return equals((List<?>) this.element, (List<?>) ((Matrix) obj).element);
                }
                return false;
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i == 0) {
                    List<Float> list = this.element;
                    i = list != null ? list.hashCode() : 1;
                    this.hashCode = i;
                }
                return i;
            }

            public Matrix(List<Float> list) {
                this.element = Message.immutableCopyOf(list);
            }

            private Matrix(Builder builder) {
                this(builder.element);
                setBuilder(builder);
            }
        }

        /* loaded from: classes2.dex */
        public enum PathStyle implements m {
            SMOOTH(1),
            SHARP(2),
            RECT(3),
            ROUND_RECT(4),
            ELLIPSE(5),
            XSHAPE(6),
            FILL_RECT(7),
            FILL_ROUND_RECT(8),
            FILL_ELLIPSE(9);

            private final int value;

            PathStyle(int i) {
                this.value = i;
            }

            @Override // com.squareup.wire.m
            public int getValue() {
                return this.value;
            }
        }

        /* loaded from: classes2.dex */
        public enum SplitScreenType implements m {
            OFF(0),
            FULL(1),
            BOTTOM(2),
            TOP(3),
            LEFT(4),
            RIGHT(5);

            private final int value;

            SplitScreenType(int i) {
                this.value = i;
            }

            @Override // com.squareup.wire.m
            public int getValue() {
                return this.value;
            }
        }

        /* loaded from: classes.dex */
        public static final class StickerLayer extends Message {
            private static final long serialVersionUID = 0;

            @n(tag = 102, type = Message.Datatype.INT32)
            public final Integer colorize_color;

            @n(tag = 101, type = Message.Datatype.BOOL)
            public final Boolean colorize_enabled;

            @n(tag = 100)
            public final LayerCommon layer_common;

            @n(tag = 103, type = Message.Datatype.INT32)
            public final Integer sticker_id;
            public static final Boolean DEFAULT_COLORIZE_ENABLED = false;
            public static final Integer DEFAULT_COLORIZE_COLOR = 0;
            public static final Integer DEFAULT_STICKER_ID = 0;

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<StickerLayer> {
                public Integer colorize_color;
                public Boolean colorize_enabled;
                public LayerCommon layer_common;
                public Integer sticker_id;

                public Builder() {
                }

                public Builder colorize_color(Integer num) {
                    this.colorize_color = num;
                    return this;
                }

                public Builder colorize_enabled(Boolean bool) {
                    this.colorize_enabled = bool;
                    return this;
                }

                public Builder layer_common(LayerCommon layerCommon) {
                    this.layer_common = layerCommon;
                    return this;
                }

                public Builder sticker_id(Integer num) {
                    this.sticker_id = num;
                    return this;
                }

                public Builder(StickerLayer stickerLayer) {
                    super(stickerLayer);
                    if (stickerLayer == null) {
                        return;
                    }
                    this.layer_common = stickerLayer.layer_common;
                    this.colorize_enabled = stickerLayer.colorize_enabled;
                    this.colorize_color = stickerLayer.colorize_color;
                    this.sticker_id = stickerLayer.sticker_id;
                }

                @Override // com.squareup.wire.Message.a
                public StickerLayer build() {
                    return new StickerLayer(this);
                }
            }

            /* synthetic */ StickerLayer(Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof StickerLayer)) {
                    return false;
                }
                StickerLayer stickerLayer = (StickerLayer) obj;
                return equals(this.layer_common, stickerLayer.layer_common) && equals(this.colorize_enabled, stickerLayer.colorize_enabled) && equals(this.colorize_color, stickerLayer.colorize_color) && equals(this.sticker_id, stickerLayer.sticker_id);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i != 0) {
                    return i;
                }
                LayerCommon layerCommon = this.layer_common;
                int hashCode = (layerCommon != null ? layerCommon.hashCode() : 0) * 37;
                Boolean bool = this.colorize_enabled;
                int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
                Integer num = this.colorize_color;
                int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
                Integer num2 = this.sticker_id;
                int hashCode4 = hashCode3 + (num2 != null ? num2.hashCode() : 0);
                this.hashCode = hashCode4;
                return hashCode4;
            }

            public StickerLayer(LayerCommon layerCommon, Boolean bool, Integer num, Integer num2) {
                this.layer_common = layerCommon;
                this.colorize_enabled = bool;
                this.colorize_color = num;
                this.sticker_id = num2;
            }

            private StickerLayer(Builder builder) {
                this(builder.layer_common, builder.colorize_enabled, builder.colorize_color, builder.sticker_id);
                setBuilder(builder);
            }
        }

        /* loaded from: classes.dex */
        public static final class StringHashMap extends Message {
            public static final List<StringHashMapEntry> DEFAULT_ENTRIES = Collections.emptyList();
            private static final long serialVersionUID = 0;

            @n(label = Message.Label.REPEATED, messageType = StringHashMapEntry.class, tag = 1)
            public final List<StringHashMapEntry> entries;

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<StringHashMap> {
                public List<StringHashMapEntry> entries;

                public Builder() {
                }

                public Builder entries(List<StringHashMapEntry> list) {
                    Message.a.checkForNulls(list);
                    this.entries = list;
                    return this;
                }

                public Builder(StringHashMap stringHashMap) {
                    super(stringHashMap);
                    if (stringHashMap == null) {
                        return;
                    }
                    this.entries = Message.copyOf(stringHashMap.entries);
                }

                @Override // com.squareup.wire.Message.a
                public StringHashMap build() {
                    return new StringHashMap(this);
                }
            }

            /* synthetic */ StringHashMap(Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof StringHashMap) {
                    return equals((List<?>) this.entries, (List<?>) ((StringHashMap) obj).entries);
                }
                return false;
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i == 0) {
                    List<StringHashMapEntry> list = this.entries;
                    i = list != null ? list.hashCode() : 1;
                    this.hashCode = i;
                }
                return i;
            }

            public StringHashMap(List<StringHashMapEntry> list) {
                this.entries = Message.immutableCopyOf(list);
            }

            private StringHashMap(Builder builder) {
                this(builder.entries);
                setBuilder(builder);
            }
        }

        /* loaded from: classes.dex */
        public static final class StringHashMapEntry extends Message {
            public static final String DEFAULT_KEY = "";
            public static final String DEFAULT_VALUE = "";
            private static final long serialVersionUID = 0;

            @n(tag = 1, type = Message.Datatype.STRING)
            public final String key;

            @n(tag = 2, type = Message.Datatype.STRING)
            public final String value;

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<StringHashMapEntry> {
                public String key;
                public String value;

                public Builder() {
                }

                public Builder key(String str) {
                    this.key = str;
                    return this;
                }

                public Builder value(String str) {
                    this.value = str;
                    return this;
                }

                public Builder(StringHashMapEntry stringHashMapEntry) {
                    super(stringHashMapEntry);
                    if (stringHashMapEntry == null) {
                        return;
                    }
                    this.key = stringHashMapEntry.key;
                    this.value = stringHashMapEntry.value;
                }

                @Override // com.squareup.wire.Message.a
                public StringHashMapEntry build() {
                    return new StringHashMapEntry(this);
                }
            }

            /* synthetic */ StringHashMapEntry(Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof StringHashMapEntry)) {
                    return false;
                }
                StringHashMapEntry stringHashMapEntry = (StringHashMapEntry) obj;
                return equals(this.key, stringHashMapEntry.key) && equals(this.value, stringHashMapEntry.value);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i != 0) {
                    return i;
                }
                String str = this.key;
                int hashCode = (str != null ? str.hashCode() : 0) * 37;
                String str2 = this.value;
                int hashCode2 = hashCode + (str2 != null ? str2.hashCode() : 0);
                this.hashCode = hashCode2;
                return hashCode2;
            }

            public StringHashMapEntry(String str, String str2) {
                this.key = str;
                this.value = str2;
            }

            private StringHashMapEntry(Builder builder) {
                this(builder.key, builder.value);
                setBuilder(builder);
            }
        }

        /* loaded from: classes.dex */
        public static final class TextLayer extends Message {
            public static final Integer DEFAULT_BACKGROUND_COLOR;
            public static final Boolean DEFAULT_ENABLE_BACKGROUND;
            public static final Boolean DEFAULT_ENABLE_GLOW;
            public static final Boolean DEFAULT_ENABLE_GRADIENT;
            public static final Boolean DEFAULT_ENABLE_OUTLINE;
            public static final Boolean DEFAULT_ENABLE_SHADOW;
            public static final Boolean DEFAULT_EXTEND_BACKGROUND;
            public static final String DEFAULT_FONT_ID = "";
            public static final Integer DEFAULT_GLOW_COLOR;
            public static final Float DEFAULT_GLOW_RADIUS;
            public static final Integer DEFAULT_GLOW_TYPE;
            public static final List<Integer> DEFAULT_GRADIENT_COLORS;
            public static final String DEFAULT_LAYER_TEXT = "";
            public static final Integer DEFAULT_OUTLINE_COLOR;
            public static final Float DEFAULT_OUTLINE_WIDTH;
            public static final Integer DEFAULT_SHADOW_COLOR;
            public static final Float DEFAULT_SHADOW_DX;
            public static final Float DEFAULT_SHADOW_DY;
            public static final Float DEFAULT_SHADOW_RADIUS;
            public static final Integer DEFAULT_TEXT_ALIGN;
            public static final Integer DEFAULT_TEXT_COLOR;
            public static final Float DEFAULT_TEXT_SIZE;
            private static final long serialVersionUID = 0;

            @n(tag = 120, type = Message.Datatype.INT32)
            public final Integer background_color;

            @n(tag = 119, type = Message.Datatype.BOOL)
            public final Boolean enable_background;

            @n(tag = 110, type = Message.Datatype.BOOL)
            public final Boolean enable_glow;

            @n(tag = 117, type = Message.Datatype.BOOL)
            public final Boolean enable_gradient;

            @n(tag = 114, type = Message.Datatype.BOOL)
            public final Boolean enable_outline;

            @n(tag = 105, type = Message.Datatype.BOOL)
            public final Boolean enable_shadow;

            @n(tag = 121, type = Message.Datatype.BOOL)
            public final Boolean extend_background;

            @n(tag = 103, type = Message.Datatype.STRING)
            public final String font_id;

            @n(tag = 111, type = Message.Datatype.INT32)
            public final Integer glow_color;

            @n(tag = 112, type = Message.Datatype.FLOAT)
            public final Float glow_radius;

            @n(tag = 113, type = Message.Datatype.INT32)
            public final Integer glow_type;

            @n(label = Message.Label.REPEATED, tag = 118, type = Message.Datatype.INT32)
            public final List<Integer> gradient_colors;

            @n(tag = 100)
            public final LayerCommon layer_common;

            @n(tag = 101, type = Message.Datatype.STRING)
            public final String layer_text;

            @n(tag = 115, type = Message.Datatype.INT32)
            public final Integer outline_color;

            @n(tag = 116, type = Message.Datatype.FLOAT)
            public final Float outline_width;

            @n(tag = 106, type = Message.Datatype.INT32)
            public final Integer shadow_color;

            @n(tag = 108, type = Message.Datatype.FLOAT)
            public final Float shadow_dx;

            @n(tag = 109, type = Message.Datatype.FLOAT)
            public final Float shadow_dy;

            @n(tag = 107, type = Message.Datatype.FLOAT)
            public final Float shadow_radius;

            @n(tag = 122, type = Message.Datatype.INT32)
            public final Integer text_align;

            @n(tag = 104, type = Message.Datatype.INT32)
            public final Integer text_color;

            @n(tag = 102, type = Message.Datatype.FLOAT)
            public final Float text_size;

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<TextLayer> {
                public Integer background_color;
                public Boolean enable_background;
                public Boolean enable_glow;
                public Boolean enable_gradient;
                public Boolean enable_outline;
                public Boolean enable_shadow;
                public Boolean extend_background;
                public String font_id;
                public Integer glow_color;
                public Float glow_radius;
                public Integer glow_type;
                public List<Integer> gradient_colors;
                public LayerCommon layer_common;
                public String layer_text;
                public Integer outline_color;
                public Float outline_width;
                public Integer shadow_color;
                public Float shadow_dx;
                public Float shadow_dy;
                public Float shadow_radius;
                public Integer text_align;
                public Integer text_color;
                public Float text_size;

                public Builder() {
                }

                public Builder background_color(Integer num) {
                    this.background_color = num;
                    return this;
                }

                public Builder enable_background(Boolean bool) {
                    this.enable_background = bool;
                    return this;
                }

                public Builder enable_glow(Boolean bool) {
                    this.enable_glow = bool;
                    return this;
                }

                public Builder enable_gradient(Boolean bool) {
                    this.enable_gradient = bool;
                    return this;
                }

                public Builder enable_outline(Boolean bool) {
                    this.enable_outline = bool;
                    return this;
                }

                public Builder enable_shadow(Boolean bool) {
                    this.enable_shadow = bool;
                    return this;
                }

                public Builder extend_background(Boolean bool) {
                    this.extend_background = bool;
                    return this;
                }

                public Builder font_id(String str) {
                    this.font_id = str;
                    return this;
                }

                public Builder glow_color(Integer num) {
                    this.glow_color = num;
                    return this;
                }

                public Builder glow_radius(Float f2) {
                    this.glow_radius = f2;
                    return this;
                }

                public Builder glow_type(Integer num) {
                    this.glow_type = num;
                    return this;
                }

                public Builder gradient_colors(List<Integer> list) {
                    Message.a.checkForNulls(list);
                    this.gradient_colors = list;
                    return this;
                }

                public Builder layer_common(LayerCommon layerCommon) {
                    this.layer_common = layerCommon;
                    return this;
                }

                public Builder layer_text(String str) {
                    this.layer_text = str;
                    return this;
                }

                public Builder outline_color(Integer num) {
                    this.outline_color = num;
                    return this;
                }

                public Builder outline_width(Float f2) {
                    this.outline_width = f2;
                    return this;
                }

                public Builder shadow_color(Integer num) {
                    this.shadow_color = num;
                    return this;
                }

                public Builder shadow_dx(Float f2) {
                    this.shadow_dx = f2;
                    return this;
                }

                public Builder shadow_dy(Float f2) {
                    this.shadow_dy = f2;
                    return this;
                }

                public Builder shadow_radius(Float f2) {
                    this.shadow_radius = f2;
                    return this;
                }

                public Builder text_align(Integer num) {
                    this.text_align = num;
                    return this;
                }

                public Builder text_color(Integer num) {
                    this.text_color = num;
                    return this;
                }

                public Builder text_size(Float f2) {
                    this.text_size = f2;
                    return this;
                }

                public Builder(TextLayer textLayer) {
                    super(textLayer);
                    if (textLayer == null) {
                        return;
                    }
                    this.layer_common = textLayer.layer_common;
                    this.layer_text = textLayer.layer_text;
                    this.text_size = textLayer.text_size;
                    this.font_id = textLayer.font_id;
                    this.text_color = textLayer.text_color;
                    this.enable_shadow = textLayer.enable_shadow;
                    this.shadow_color = textLayer.shadow_color;
                    this.shadow_radius = textLayer.shadow_radius;
                    this.shadow_dx = textLayer.shadow_dx;
                    this.shadow_dy = textLayer.shadow_dy;
                    this.enable_glow = textLayer.enable_glow;
                    this.glow_color = textLayer.glow_color;
                    this.glow_radius = textLayer.glow_radius;
                    this.glow_type = textLayer.glow_type;
                    this.enable_outline = textLayer.enable_outline;
                    this.outline_color = textLayer.outline_color;
                    this.outline_width = textLayer.outline_width;
                    this.enable_gradient = textLayer.enable_gradient;
                    this.gradient_colors = Message.copyOf(textLayer.gradient_colors);
                    this.enable_background = textLayer.enable_background;
                    this.background_color = textLayer.background_color;
                    this.extend_background = textLayer.extend_background;
                    this.text_align = textLayer.text_align;
                }

                @Override // com.squareup.wire.Message.a
                public TextLayer build() {
                    return new TextLayer(this);
                }
            }

            static {
                Float valueOf = Float.valueOf(0.0f);
                DEFAULT_TEXT_SIZE = valueOf;
                DEFAULT_TEXT_COLOR = 0;
                DEFAULT_ENABLE_SHADOW = false;
                DEFAULT_SHADOW_COLOR = 0;
                DEFAULT_SHADOW_RADIUS = valueOf;
                DEFAULT_SHADOW_DX = valueOf;
                DEFAULT_SHADOW_DY = valueOf;
                DEFAULT_ENABLE_GLOW = false;
                DEFAULT_GLOW_COLOR = 0;
                DEFAULT_GLOW_RADIUS = valueOf;
                DEFAULT_GLOW_TYPE = 0;
                DEFAULT_ENABLE_OUTLINE = false;
                DEFAULT_OUTLINE_COLOR = 0;
                DEFAULT_OUTLINE_WIDTH = valueOf;
                DEFAULT_ENABLE_GRADIENT = false;
                DEFAULT_GRADIENT_COLORS = Collections.emptyList();
                DEFAULT_ENABLE_BACKGROUND = false;
                DEFAULT_BACKGROUND_COLOR = 0;
                DEFAULT_EXTEND_BACKGROUND = false;
                DEFAULT_TEXT_ALIGN = 0;
            }

            /* synthetic */ TextLayer(Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof TextLayer)) {
                    return false;
                }
                TextLayer textLayer = (TextLayer) obj;
                return equals(this.layer_common, textLayer.layer_common) && equals(this.layer_text, textLayer.layer_text) && equals(this.text_size, textLayer.text_size) && equals(this.font_id, textLayer.font_id) && equals(this.text_color, textLayer.text_color) && equals(this.enable_shadow, textLayer.enable_shadow) && equals(this.shadow_color, textLayer.shadow_color) && equals(this.shadow_radius, textLayer.shadow_radius) && equals(this.shadow_dx, textLayer.shadow_dx) && equals(this.shadow_dy, textLayer.shadow_dy) && equals(this.enable_glow, textLayer.enable_glow) && equals(this.glow_color, textLayer.glow_color) && equals(this.glow_radius, textLayer.glow_radius) && equals(this.glow_type, textLayer.glow_type) && equals(this.enable_outline, textLayer.enable_outline) && equals(this.outline_color, textLayer.outline_color) && equals(this.outline_width, textLayer.outline_width) && equals(this.enable_gradient, textLayer.enable_gradient) && equals((List<?>) this.gradient_colors, (List<?>) textLayer.gradient_colors) && equals(this.enable_background, textLayer.enable_background) && equals(this.background_color, textLayer.background_color) && equals(this.extend_background, textLayer.extend_background) && equals(this.text_align, textLayer.text_align);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i != 0) {
                    return i;
                }
                LayerCommon layerCommon = this.layer_common;
                int hashCode = (layerCommon != null ? layerCommon.hashCode() : 0) * 37;
                String str = this.layer_text;
                int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
                Float f2 = this.text_size;
                int hashCode3 = (hashCode2 + (f2 != null ? f2.hashCode() : 0)) * 37;
                String str2 = this.font_id;
                int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
                Integer num = this.text_color;
                int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
                Boolean bool = this.enable_shadow;
                int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
                Integer num2 = this.shadow_color;
                int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
                Float f3 = this.shadow_radius;
                int hashCode8 = (hashCode7 + (f3 != null ? f3.hashCode() : 0)) * 37;
                Float f4 = this.shadow_dx;
                int hashCode9 = (hashCode8 + (f4 != null ? f4.hashCode() : 0)) * 37;
                Float f5 = this.shadow_dy;
                int hashCode10 = (hashCode9 + (f5 != null ? f5.hashCode() : 0)) * 37;
                Boolean bool2 = this.enable_glow;
                int hashCode11 = (hashCode10 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
                Integer num3 = this.glow_color;
                int hashCode12 = (hashCode11 + (num3 != null ? num3.hashCode() : 0)) * 37;
                Float f6 = this.glow_radius;
                int hashCode13 = (hashCode12 + (f6 != null ? f6.hashCode() : 0)) * 37;
                Integer num4 = this.glow_type;
                int hashCode14 = (hashCode13 + (num4 != null ? num4.hashCode() : 0)) * 37;
                Boolean bool3 = this.enable_outline;
                int hashCode15 = (hashCode14 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
                Integer num5 = this.outline_color;
                int hashCode16 = (hashCode15 + (num5 != null ? num5.hashCode() : 0)) * 37;
                Float f7 = this.outline_width;
                int hashCode17 = (hashCode16 + (f7 != null ? f7.hashCode() : 0)) * 37;
                Boolean bool4 = this.enable_gradient;
                int hashCode18 = (hashCode17 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
                List<Integer> list = this.gradient_colors;
                int hashCode19 = (hashCode18 + (list != null ? list.hashCode() : 1)) * 37;
                Boolean bool5 = this.enable_background;
                int hashCode20 = (hashCode19 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
                Integer num6 = this.background_color;
                int hashCode21 = (hashCode20 + (num6 != null ? num6.hashCode() : 0)) * 37;
                Boolean bool6 = this.extend_background;
                int hashCode22 = (hashCode21 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
                Integer num7 = this.text_align;
                int hashCode23 = hashCode22 + (num7 != null ? num7.hashCode() : 0);
                this.hashCode = hashCode23;
                return hashCode23;
            }

            public TextLayer(LayerCommon layerCommon, String str, Float f2, String str2, Integer num, Boolean bool, Integer num2, Float f3, Float f4, Float f5, Boolean bool2, Integer num3, Float f6, Integer num4, Boolean bool3, Integer num5, Float f7, Boolean bool4, List<Integer> list, Boolean bool5, Integer num6, Boolean bool6, Integer num7) {
                this.layer_common = layerCommon;
                this.layer_text = str;
                this.text_size = f2;
                this.font_id = str2;
                this.text_color = num;
                this.enable_shadow = bool;
                this.shadow_color = num2;
                this.shadow_radius = f3;
                this.shadow_dx = f4;
                this.shadow_dy = f5;
                this.enable_glow = bool2;
                this.glow_color = num3;
                this.glow_radius = f6;
                this.glow_type = num4;
                this.enable_outline = bool3;
                this.outline_color = num5;
                this.outline_width = f7;
                this.enable_gradient = bool4;
                this.gradient_colors = Message.immutableCopyOf(list);
                this.enable_background = bool5;
                this.background_color = num6;
                this.extend_background = bool6;
                this.text_align = num7;
            }

            private TextLayer(Builder builder) {
                this(builder.layer_common, builder.layer_text, builder.text_size, builder.font_id, builder.text_color, builder.enable_shadow, builder.shadow_color, builder.shadow_radius, builder.shadow_dx, builder.shadow_dy, builder.enable_glow, builder.glow_color, builder.glow_radius, builder.glow_type, builder.enable_outline, builder.outline_color, builder.outline_width, builder.enable_gradient, builder.gradient_colors, builder.enable_background, builder.background_color, builder.extend_background, builder.text_align);
                setBuilder(builder);
            }
        }

        /* loaded from: classes2.dex */
        public enum ThemeEffectType implements m {
            THEME_EFFECT_TYPE_OPENING(1),
            THEME_EFFECT_TYPE_MIDDLE(2),
            THEME_EFFECT_TYPE_ENDING(3),
            THEME_EFFECT_TYPE_ACCENT(4),
            THEME_EFFECT_TYPE_TRANSITION(5),
            THEME_EFFECT_TYPE_CLIP(6);

            private final int value;

            ThemeEffectType(int i) {
                this.value = i;
            }

            @Override // com.squareup.wire.m
            public int getValue() {
                return this.value;
            }
        }

        /* loaded from: classes.dex */
        public static final class TimelineItem extends Message {
            private static final long serialVersionUID = 0;

            @n(tag = 13)
            public final AssetLayer asset_layer;

            @n(tag = 6)
            public final AudioClip audio_clip;

            @n(tag = 3, type = Message.Datatype.ENUM)
            public final ClipType clip_type;

            @n(tag = 12)
            public final EffectLayer effect_layer;

            @n(tag = 15)
            public final GroupLayer group_layer;

            @n(tag = 10)
            public final HandwritingLayer handwriting_layer;

            @n(tag = 9)
            public final ImageLayer image_layer;

            @n(tag = 8)
            public final StickerLayer sticker_layer;

            @n(tag = 7)
            public final TextLayer text_layer;

            @n(tag = 14, type = Message.Datatype.INT32)
            public final Integer track_id;

            @n(tag = 5)
            public final Transition transition;

            @n(tag = 1, type = Message.Datatype.UINT64)
            public final Long unique_id_lsb;

            @n(tag = 2, type = Message.Datatype.UINT64)
            public final Long unique_id_msb;

            @n(tag = 11)
            public final VideoLayer video_layer;

            @n(tag = 4)
            public final VisualClip visual_clip;
            public static final Long DEFAULT_UNIQUE_ID_LSB = 0L;
            public static final Long DEFAULT_UNIQUE_ID_MSB = 0L;
            public static final ClipType DEFAULT_CLIP_TYPE = ClipType.VISUAL_CLIP;
            public static final Integer DEFAULT_TRACK_ID = 0;

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<TimelineItem> {
                public AssetLayer asset_layer;
                public AudioClip audio_clip;
                public ClipType clip_type;
                public EffectLayer effect_layer;
                public GroupLayer group_layer;
                public HandwritingLayer handwriting_layer;
                public ImageLayer image_layer;
                public StickerLayer sticker_layer;
                public TextLayer text_layer;
                public Integer track_id;
                public Transition transition;
                public Long unique_id_lsb;
                public Long unique_id_msb;
                public VideoLayer video_layer;
                public VisualClip visual_clip;

                public Builder() {
                }

                public Builder asset_layer(AssetLayer assetLayer) {
                    this.asset_layer = assetLayer;
                    return this;
                }

                public Builder audio_clip(AudioClip audioClip) {
                    this.audio_clip = audioClip;
                    return this;
                }

                public Builder clip_type(ClipType clipType) {
                    this.clip_type = clipType;
                    return this;
                }

                public Builder effect_layer(EffectLayer effectLayer) {
                    this.effect_layer = effectLayer;
                    return this;
                }

                public Builder group_layer(GroupLayer groupLayer) {
                    this.group_layer = groupLayer;
                    return this;
                }

                public Builder handwriting_layer(HandwritingLayer handwritingLayer) {
                    this.handwriting_layer = handwritingLayer;
                    return this;
                }

                public Builder image_layer(ImageLayer imageLayer) {
                    this.image_layer = imageLayer;
                    return this;
                }

                public Builder sticker_layer(StickerLayer stickerLayer) {
                    this.sticker_layer = stickerLayer;
                    return this;
                }

                public Builder text_layer(TextLayer textLayer) {
                    this.text_layer = textLayer;
                    return this;
                }

                public Builder track_id(Integer num) {
                    this.track_id = num;
                    return this;
                }

                public Builder transition(Transition transition) {
                    this.transition = transition;
                    return this;
                }

                public Builder unique_id_lsb(Long l) {
                    this.unique_id_lsb = l;
                    return this;
                }

                public Builder unique_id_msb(Long l) {
                    this.unique_id_msb = l;
                    return this;
                }

                public Builder video_layer(VideoLayer videoLayer) {
                    this.video_layer = videoLayer;
                    return this;
                }

                public Builder visual_clip(VisualClip visualClip) {
                    this.visual_clip = visualClip;
                    return this;
                }

                public Builder(TimelineItem timelineItem) {
                    super(timelineItem);
                    if (timelineItem == null) {
                        return;
                    }
                    this.unique_id_lsb = timelineItem.unique_id_lsb;
                    this.unique_id_msb = timelineItem.unique_id_msb;
                    this.clip_type = timelineItem.clip_type;
                    this.track_id = timelineItem.track_id;
                    this.visual_clip = timelineItem.visual_clip;
                    this.transition = timelineItem.transition;
                    this.audio_clip = timelineItem.audio_clip;
                    this.text_layer = timelineItem.text_layer;
                    this.sticker_layer = timelineItem.sticker_layer;
                    this.image_layer = timelineItem.image_layer;
                    this.handwriting_layer = timelineItem.handwriting_layer;
                    this.video_layer = timelineItem.video_layer;
                    this.effect_layer = timelineItem.effect_layer;
                    this.asset_layer = timelineItem.asset_layer;
                    this.group_layer = timelineItem.group_layer;
                }

                @Override // com.squareup.wire.Message.a
                public TimelineItem build() {
                    return new TimelineItem(this);
                }
            }

            /* synthetic */ TimelineItem(Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof TimelineItem)) {
                    return false;
                }
                TimelineItem timelineItem = (TimelineItem) obj;
                return equals(this.unique_id_lsb, timelineItem.unique_id_lsb) && equals(this.unique_id_msb, timelineItem.unique_id_msb) && equals(this.clip_type, timelineItem.clip_type) && equals(this.track_id, timelineItem.track_id) && equals(this.visual_clip, timelineItem.visual_clip) && equals(this.transition, timelineItem.transition) && equals(this.audio_clip, timelineItem.audio_clip) && equals(this.text_layer, timelineItem.text_layer) && equals(this.sticker_layer, timelineItem.sticker_layer) && equals(this.image_layer, timelineItem.image_layer) && equals(this.handwriting_layer, timelineItem.handwriting_layer) && equals(this.video_layer, timelineItem.video_layer) && equals(this.effect_layer, timelineItem.effect_layer) && equals(this.asset_layer, timelineItem.asset_layer) && equals(this.group_layer, timelineItem.group_layer);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i != 0) {
                    return i;
                }
                Long l = this.unique_id_lsb;
                int hashCode = (l != null ? l.hashCode() : 0) * 37;
                Long l2 = this.unique_id_msb;
                int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
                ClipType clipType = this.clip_type;
                int hashCode3 = (hashCode2 + (clipType != null ? clipType.hashCode() : 0)) * 37;
                Integer num = this.track_id;
                int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
                VisualClip visualClip = this.visual_clip;
                int hashCode5 = (hashCode4 + (visualClip != null ? visualClip.hashCode() : 0)) * 37;
                Transition transition = this.transition;
                int hashCode6 = (hashCode5 + (transition != null ? transition.hashCode() : 0)) * 37;
                AudioClip audioClip = this.audio_clip;
                int hashCode7 = (hashCode6 + (audioClip != null ? audioClip.hashCode() : 0)) * 37;
                TextLayer textLayer = this.text_layer;
                int hashCode8 = (hashCode7 + (textLayer != null ? textLayer.hashCode() : 0)) * 37;
                StickerLayer stickerLayer = this.sticker_layer;
                int hashCode9 = (hashCode8 + (stickerLayer != null ? stickerLayer.hashCode() : 0)) * 37;
                ImageLayer imageLayer = this.image_layer;
                int hashCode10 = (hashCode9 + (imageLayer != null ? imageLayer.hashCode() : 0)) * 37;
                HandwritingLayer handwritingLayer = this.handwriting_layer;
                int hashCode11 = (hashCode10 + (handwritingLayer != null ? handwritingLayer.hashCode() : 0)) * 37;
                VideoLayer videoLayer = this.video_layer;
                int hashCode12 = (hashCode11 + (videoLayer != null ? videoLayer.hashCode() : 0)) * 37;
                EffectLayer effectLayer = this.effect_layer;
                int hashCode13 = (hashCode12 + (effectLayer != null ? effectLayer.hashCode() : 0)) * 37;
                AssetLayer assetLayer = this.asset_layer;
                int hashCode14 = (hashCode13 + (assetLayer != null ? assetLayer.hashCode() : 0)) * 37;
                GroupLayer groupLayer = this.group_layer;
                int hashCode15 = hashCode14 + (groupLayer != null ? groupLayer.hashCode() : 0);
                this.hashCode = hashCode15;
                return hashCode15;
            }

            public TimelineItem(Long l, Long l2, ClipType clipType, Integer num, VisualClip visualClip, Transition transition, AudioClip audioClip, TextLayer textLayer, StickerLayer stickerLayer, ImageLayer imageLayer, HandwritingLayer handwritingLayer, VideoLayer videoLayer, EffectLayer effectLayer, AssetLayer assetLayer, GroupLayer groupLayer) {
                this.unique_id_lsb = l;
                this.unique_id_msb = l2;
                this.clip_type = clipType;
                this.track_id = num;
                this.visual_clip = visualClip;
                this.transition = transition;
                this.audio_clip = audioClip;
                this.text_layer = textLayer;
                this.sticker_layer = stickerLayer;
                this.image_layer = imageLayer;
                this.handwriting_layer = handwritingLayer;
                this.video_layer = videoLayer;
                this.effect_layer = effectLayer;
                this.asset_layer = assetLayer;
                this.group_layer = groupLayer;
            }

            private TimelineItem(Builder builder) {
                this(builder.unique_id_lsb, builder.unique_id_msb, builder.clip_type, builder.track_id, builder.visual_clip, builder.transition, builder.audio_clip, builder.text_layer, builder.sticker_layer, builder.image_layer, builder.handwriting_layer, builder.video_layer, builder.effect_layer, builder.asset_layer, builder.group_layer);
                setBuilder(builder);
            }
        }

        /* loaded from: classes2.dex */
        public enum TitleStyle implements m {
            TITLE_STYLE_NONE(0),
            TITLE_STYLE_HEADLINE(1),
            TITLE_STYLE_OPENING(2),
            TITLE_STYLE_PLAYING(3),
            TITLE_STYLE_ENDING(4);

            private final int value;

            TitleStyle(int i) {
                this.value = i;
            }

            @Override // com.squareup.wire.m
            public int getValue() {
                return this.value;
            }
        }

        /* loaded from: classes.dex */
        public static final class Track extends Message {
            public static final String DEFAULT_TEXT_FONT_ID = "";
            private static final long serialVersionUID = 0;

            @n(tag = 102, type = Message.Datatype.INT32)
            public final Integer clip_volume;

            @n(tag = 103, type = Message.Datatype.INT32)
            public final Integer compressor;

            @n(tag = 101, type = Message.Datatype.BOOL)
            public final Boolean mute_audio;

            @n(tag = 107, type = Message.Datatype.INT32)
            public final Integer overall_alpha;

            @n(tag = 110, type = Message.Datatype.BOOL)
            public final Boolean override_text_style;

            @n(tag = 104, type = Message.Datatype.INT32)
            public final Integer pan_left;

            @n(tag = 105, type = Message.Datatype.INT32)
            public final Integer pan_right;

            @n(tag = 106, type = Message.Datatype.INT32)
            public final Integer pitch_factor;

            @n(tag = 112, type = Message.Datatype.INT32)
            public final Integer text_color;

            @n(tag = 111, type = Message.Datatype.STRING)
            public final String text_font_id;

            @n(tag = 115, type = Message.Datatype.BOOL)
            public final Boolean text_glow;

            @n(tag = 116, type = Message.Datatype.INT32)
            public final Integer text_glow_color;

            @n(tag = 117, type = Message.Datatype.BOOL)
            public final Boolean text_outline;

            @n(tag = 118, type = Message.Datatype.INT32)
            public final Integer text_outline_color;

            @n(tag = 113, type = Message.Datatype.BOOL)
            public final Boolean text_shadow;

            @n(tag = 114, type = Message.Datatype.INT32)
            public final Integer text_shadow_color;

            @n(tag = 1, type = Message.Datatype.INT32)
            public final Integer track_id;

            @n(tag = 100, type = Message.Datatype.BOOL)
            public final Boolean visible;
            public static final Integer DEFAULT_TRACK_ID = 0;
            public static final Boolean DEFAULT_VISIBLE = false;
            public static final Boolean DEFAULT_MUTE_AUDIO = false;
            public static final Integer DEFAULT_CLIP_VOLUME = 0;
            public static final Integer DEFAULT_COMPRESSOR = 0;
            public static final Integer DEFAULT_PAN_LEFT = 0;
            public static final Integer DEFAULT_PAN_RIGHT = 0;
            public static final Integer DEFAULT_PITCH_FACTOR = 0;
            public static final Integer DEFAULT_OVERALL_ALPHA = 0;
            public static final Boolean DEFAULT_OVERRIDE_TEXT_STYLE = false;
            public static final Integer DEFAULT_TEXT_COLOR = 0;
            public static final Boolean DEFAULT_TEXT_SHADOW = false;
            public static final Integer DEFAULT_TEXT_SHADOW_COLOR = 0;
            public static final Boolean DEFAULT_TEXT_GLOW = false;
            public static final Integer DEFAULT_TEXT_GLOW_COLOR = 0;
            public static final Boolean DEFAULT_TEXT_OUTLINE = false;
            public static final Integer DEFAULT_TEXT_OUTLINE_COLOR = 0;

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<Track> {
                public Integer clip_volume;
                public Integer compressor;
                public Boolean mute_audio;
                public Integer overall_alpha;
                public Boolean override_text_style;
                public Integer pan_left;
                public Integer pan_right;
                public Integer pitch_factor;
                public Integer text_color;
                public String text_font_id;
                public Boolean text_glow;
                public Integer text_glow_color;
                public Boolean text_outline;
                public Integer text_outline_color;
                public Boolean text_shadow;
                public Integer text_shadow_color;
                public Integer track_id;
                public Boolean visible;

                public Builder() {
                }

                public Builder clip_volume(Integer num) {
                    this.clip_volume = num;
                    return this;
                }

                public Builder compressor(Integer num) {
                    this.compressor = num;
                    return this;
                }

                public Builder mute_audio(Boolean bool) {
                    this.mute_audio = bool;
                    return this;
                }

                public Builder overall_alpha(Integer num) {
                    this.overall_alpha = num;
                    return this;
                }

                public Builder override_text_style(Boolean bool) {
                    this.override_text_style = bool;
                    return this;
                }

                public Builder pan_left(Integer num) {
                    this.pan_left = num;
                    return this;
                }

                public Builder pan_right(Integer num) {
                    this.pan_right = num;
                    return this;
                }

                public Builder pitch_factor(Integer num) {
                    this.pitch_factor = num;
                    return this;
                }

                public Builder text_color(Integer num) {
                    this.text_color = num;
                    return this;
                }

                public Builder text_font_id(String str) {
                    this.text_font_id = str;
                    return this;
                }

                public Builder text_glow(Boolean bool) {
                    this.text_glow = bool;
                    return this;
                }

                public Builder text_glow_color(Integer num) {
                    this.text_glow_color = num;
                    return this;
                }

                public Builder text_outline(Boolean bool) {
                    this.text_outline = bool;
                    return this;
                }

                public Builder text_outline_color(Integer num) {
                    this.text_outline_color = num;
                    return this;
                }

                public Builder text_shadow(Boolean bool) {
                    this.text_shadow = bool;
                    return this;
                }

                public Builder text_shadow_color(Integer num) {
                    this.text_shadow_color = num;
                    return this;
                }

                public Builder track_id(Integer num) {
                    this.track_id = num;
                    return this;
                }

                public Builder visible(Boolean bool) {
                    this.visible = bool;
                    return this;
                }

                public Builder(Track track) {
                    super(track);
                    if (track == null) {
                        return;
                    }
                    this.track_id = track.track_id;
                    this.visible = track.visible;
                    this.mute_audio = track.mute_audio;
                    this.clip_volume = track.clip_volume;
                    this.compressor = track.compressor;
                    this.pan_left = track.pan_left;
                    this.pan_right = track.pan_right;
                    this.pitch_factor = track.pitch_factor;
                    this.overall_alpha = track.overall_alpha;
                    this.override_text_style = track.override_text_style;
                    this.text_font_id = track.text_font_id;
                    this.text_color = track.text_color;
                    this.text_shadow = track.text_shadow;
                    this.text_shadow_color = track.text_shadow_color;
                    this.text_glow = track.text_glow;
                    this.text_glow_color = track.text_glow_color;
                    this.text_outline = track.text_outline;
                    this.text_outline_color = track.text_outline_color;
                }

                @Override // com.squareup.wire.Message.a
                public Track build() {
                    return new Track(this);
                }
            }

            /* synthetic */ Track(Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Track)) {
                    return false;
                }
                Track track = (Track) obj;
                return equals(this.track_id, track.track_id) && equals(this.visible, track.visible) && equals(this.mute_audio, track.mute_audio) && equals(this.clip_volume, track.clip_volume) && equals(this.compressor, track.compressor) && equals(this.pan_left, track.pan_left) && equals(this.pan_right, track.pan_right) && equals(this.pitch_factor, track.pitch_factor) && equals(this.overall_alpha, track.overall_alpha) && equals(this.override_text_style, track.override_text_style) && equals(this.text_font_id, track.text_font_id) && equals(this.text_color, track.text_color) && equals(this.text_shadow, track.text_shadow) && equals(this.text_shadow_color, track.text_shadow_color) && equals(this.text_glow, track.text_glow) && equals(this.text_glow_color, track.text_glow_color) && equals(this.text_outline, track.text_outline) && equals(this.text_outline_color, track.text_outline_color);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i != 0) {
                    return i;
                }
                Integer num = this.track_id;
                int hashCode = (num != null ? num.hashCode() : 0) * 37;
                Boolean bool = this.visible;
                int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
                Boolean bool2 = this.mute_audio;
                int hashCode3 = (hashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
                Integer num2 = this.clip_volume;
                int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
                Integer num3 = this.compressor;
                int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
                Integer num4 = this.pan_left;
                int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
                Integer num5 = this.pan_right;
                int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
                Integer num6 = this.pitch_factor;
                int hashCode8 = (hashCode7 + (num6 != null ? num6.hashCode() : 0)) * 37;
                Integer num7 = this.overall_alpha;
                int hashCode9 = (hashCode8 + (num7 != null ? num7.hashCode() : 0)) * 37;
                Boolean bool3 = this.override_text_style;
                int hashCode10 = (hashCode9 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
                String str = this.text_font_id;
                int hashCode11 = (hashCode10 + (str != null ? str.hashCode() : 0)) * 37;
                Integer num8 = this.text_color;
                int hashCode12 = (hashCode11 + (num8 != null ? num8.hashCode() : 0)) * 37;
                Boolean bool4 = this.text_shadow;
                int hashCode13 = (hashCode12 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
                Integer num9 = this.text_shadow_color;
                int hashCode14 = (hashCode13 + (num9 != null ? num9.hashCode() : 0)) * 37;
                Boolean bool5 = this.text_glow;
                int hashCode15 = (hashCode14 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
                Integer num10 = this.text_glow_color;
                int hashCode16 = (hashCode15 + (num10 != null ? num10.hashCode() : 0)) * 37;
                Boolean bool6 = this.text_outline;
                int hashCode17 = (hashCode16 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
                Integer num11 = this.text_outline_color;
                int hashCode18 = hashCode17 + (num11 != null ? num11.hashCode() : 0);
                this.hashCode = hashCode18;
                return hashCode18;
            }

            public Track(Integer num, Boolean bool, Boolean bool2, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Boolean bool3, String str, Integer num8, Boolean bool4, Integer num9, Boolean bool5, Integer num10, Boolean bool6, Integer num11) {
                this.track_id = num;
                this.visible = bool;
                this.mute_audio = bool2;
                this.clip_volume = num2;
                this.compressor = num3;
                this.pan_left = num4;
                this.pan_right = num5;
                this.pitch_factor = num6;
                this.overall_alpha = num7;
                this.override_text_style = bool3;
                this.text_font_id = str;
                this.text_color = num8;
                this.text_shadow = bool4;
                this.text_shadow_color = num9;
                this.text_glow = bool5;
                this.text_glow_color = num10;
                this.text_outline = bool6;
                this.text_outline_color = num11;
            }

            private Track(Builder builder) {
                this(builder.track_id, builder.visible, builder.mute_audio, builder.clip_volume, builder.compressor, builder.pan_left, builder.pan_right, builder.pitch_factor, builder.overall_alpha, builder.override_text_style, builder.text_font_id, builder.text_color, builder.text_shadow, builder.text_shadow_color, builder.text_glow, builder.text_glow_color, builder.text_outline, builder.text_outline_color);
                setBuilder(builder);
            }
        }

        /* loaded from: classes.dex */
        public static final class Transition extends Message {
            public static final String DEFAULT_CAPTUREFILENAME = "";
            public static final String DEFAULT_TRANSITION_EFFECT_ID = "";
            private static final long serialVersionUID = 0;

            @n(tag = 112, type = Message.Datatype.BOOL)
            public final Boolean allow_overlap;

            @n(tag = 102, type = Message.Datatype.ENUM)
            public final ThemeEffectType auto_theme_effect;

            @n(tag = 100, type = Message.Datatype.STRING)
            public final String captureFilename;

            @n(tag = 107, type = Message.Datatype.BOOL)
            public final Boolean disabled;

            @n(tag = 111, type = Message.Datatype.INT32)
            public final Integer duration_limit;

            @n(tag = 110)
            public final StringHashMap effect_options;

            @n(tag = 109, type = Message.Datatype.INT32)
            public final Integer maximum_duration;

            @n(tag = 108, type = Message.Datatype.INT32)
            public final Integer minimum_duration;

            @n(tag = 103, type = Message.Datatype.INT32)
            public final Integer transition_duration;

            @n(tag = 101, type = Message.Datatype.STRING)
            public final String transition_effect_id;

            @n(tag = 104, type = Message.Datatype.INT32)
            public final Integer transition_engine_duration;

            @n(tag = 106, type = Message.Datatype.INT32)
            public final Integer transition_offset_percent;

            @n(tag = 105, type = Message.Datatype.INT32)
            public final Integer transition_overlap_percent;
            public static final ThemeEffectType DEFAULT_AUTO_THEME_EFFECT = ThemeEffectType.THEME_EFFECT_TYPE_OPENING;
            public static final Integer DEFAULT_TRANSITION_DURATION = 0;
            public static final Integer DEFAULT_TRANSITION_ENGINE_DURATION = 0;
            public static final Integer DEFAULT_TRANSITION_OVERLAP_PERCENT = 0;
            public static final Integer DEFAULT_TRANSITION_OFFSET_PERCENT = 0;
            public static final Boolean DEFAULT_DISABLED = false;
            public static final Integer DEFAULT_MINIMUM_DURATION = 0;
            public static final Integer DEFAULT_MAXIMUM_DURATION = 0;
            public static final Integer DEFAULT_DURATION_LIMIT = 0;
            public static final Boolean DEFAULT_ALLOW_OVERLAP = false;

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<Transition> {
                public Boolean allow_overlap;
                public ThemeEffectType auto_theme_effect;
                public String captureFilename;
                public Boolean disabled;
                public Integer duration_limit;
                public StringHashMap effect_options;
                public Integer maximum_duration;
                public Integer minimum_duration;
                public Integer transition_duration;
                public String transition_effect_id;
                public Integer transition_engine_duration;
                public Integer transition_offset_percent;
                public Integer transition_overlap_percent;

                public Builder() {
                }

                public Builder allow_overlap(Boolean bool) {
                    this.allow_overlap = bool;
                    return this;
                }

                public Builder auto_theme_effect(ThemeEffectType themeEffectType) {
                    this.auto_theme_effect = themeEffectType;
                    return this;
                }

                public Builder captureFilename(String str) {
                    this.captureFilename = str;
                    return this;
                }

                public Builder disabled(Boolean bool) {
                    this.disabled = bool;
                    return this;
                }

                public Builder duration_limit(Integer num) {
                    this.duration_limit = num;
                    return this;
                }

                public Builder effect_options(StringHashMap stringHashMap) {
                    this.effect_options = stringHashMap;
                    return this;
                }

                public Builder maximum_duration(Integer num) {
                    this.maximum_duration = num;
                    return this;
                }

                public Builder minimum_duration(Integer num) {
                    this.minimum_duration = num;
                    return this;
                }

                public Builder transition_duration(Integer num) {
                    this.transition_duration = num;
                    return this;
                }

                public Builder transition_effect_id(String str) {
                    this.transition_effect_id = str;
                    return this;
                }

                public Builder transition_engine_duration(Integer num) {
                    this.transition_engine_duration = num;
                    return this;
                }

                public Builder transition_offset_percent(Integer num) {
                    this.transition_offset_percent = num;
                    return this;
                }

                public Builder transition_overlap_percent(Integer num) {
                    this.transition_overlap_percent = num;
                    return this;
                }

                public Builder(Transition transition) {
                    super(transition);
                    if (transition == null) {
                        return;
                    }
                    this.captureFilename = transition.captureFilename;
                    this.transition_effect_id = transition.transition_effect_id;
                    this.auto_theme_effect = transition.auto_theme_effect;
                    this.transition_duration = transition.transition_duration;
                    this.transition_engine_duration = transition.transition_engine_duration;
                    this.transition_overlap_percent = transition.transition_overlap_percent;
                    this.transition_offset_percent = transition.transition_offset_percent;
                    this.disabled = transition.disabled;
                    this.minimum_duration = transition.minimum_duration;
                    this.maximum_duration = transition.maximum_duration;
                    this.effect_options = transition.effect_options;
                    this.duration_limit = transition.duration_limit;
                    this.allow_overlap = transition.allow_overlap;
                }

                @Override // com.squareup.wire.Message.a
                public Transition build() {
                    return new Transition(this);
                }
            }

            /* synthetic */ Transition(Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Transition)) {
                    return false;
                }
                Transition transition = (Transition) obj;
                return equals(this.captureFilename, transition.captureFilename) && equals(this.transition_effect_id, transition.transition_effect_id) && equals(this.auto_theme_effect, transition.auto_theme_effect) && equals(this.transition_duration, transition.transition_duration) && equals(this.transition_engine_duration, transition.transition_engine_duration) && equals(this.transition_overlap_percent, transition.transition_overlap_percent) && equals(this.transition_offset_percent, transition.transition_offset_percent) && equals(this.disabled, transition.disabled) && equals(this.minimum_duration, transition.minimum_duration) && equals(this.maximum_duration, transition.maximum_duration) && equals(this.effect_options, transition.effect_options) && equals(this.duration_limit, transition.duration_limit) && equals(this.allow_overlap, transition.allow_overlap);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i != 0) {
                    return i;
                }
                String str = this.captureFilename;
                int hashCode = (str != null ? str.hashCode() : 0) * 37;
                String str2 = this.transition_effect_id;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
                ThemeEffectType themeEffectType = this.auto_theme_effect;
                int hashCode3 = (hashCode2 + (themeEffectType != null ? themeEffectType.hashCode() : 0)) * 37;
                Integer num = this.transition_duration;
                int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
                Integer num2 = this.transition_engine_duration;
                int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
                Integer num3 = this.transition_overlap_percent;
                int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
                Integer num4 = this.transition_offset_percent;
                int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
                Boolean bool = this.disabled;
                int hashCode8 = (hashCode7 + (bool != null ? bool.hashCode() : 0)) * 37;
                Integer num5 = this.minimum_duration;
                int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
                Integer num6 = this.maximum_duration;
                int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
                StringHashMap stringHashMap = this.effect_options;
                int hashCode11 = (hashCode10 + (stringHashMap != null ? stringHashMap.hashCode() : 0)) * 37;
                Integer num7 = this.duration_limit;
                int hashCode12 = (hashCode11 + (num7 != null ? num7.hashCode() : 0)) * 37;
                Boolean bool2 = this.allow_overlap;
                int hashCode13 = hashCode12 + (bool2 != null ? bool2.hashCode() : 0);
                this.hashCode = hashCode13;
                return hashCode13;
            }

            public Transition(String str, String str2, ThemeEffectType themeEffectType, Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, Integer num5, Integer num6, StringHashMap stringHashMap, Integer num7, Boolean bool2) {
                this.captureFilename = str;
                this.transition_effect_id = str2;
                this.auto_theme_effect = themeEffectType;
                this.transition_duration = num;
                this.transition_engine_duration = num2;
                this.transition_overlap_percent = num3;
                this.transition_offset_percent = num4;
                this.disabled = bool;
                this.minimum_duration = num5;
                this.maximum_duration = num6;
                this.effect_options = stringHashMap;
                this.duration_limit = num7;
                this.allow_overlap = bool2;
            }

            private Transition(Builder builder) {
                this(builder.captureFilename, builder.transition_effect_id, builder.auto_theme_effect, builder.transition_duration, builder.transition_engine_duration, builder.transition_overlap_percent, builder.transition_offset_percent, builder.disabled, builder.minimum_duration, builder.maximum_duration, builder.effect_options, builder.duration_limit, builder.allow_overlap);
                setBuilder(builder);
            }
        }

        /* loaded from: classes.dex */
        public static final class VideoLayer extends Message {
            public static final Float DEFAULT_CHROMA_KEY_BLEND_X0;
            public static final Float DEFAULT_CHROMA_KEY_BLEND_X1;
            public static final Float DEFAULT_CHROMA_KEY_BLEND_Y0;
            public static final Float DEFAULT_CHROMA_KEY_BLEND_Y1;
            public static final Float DEFAULT_CHROMA_KEY_CLIP_BG;
            public static final Float DEFAULT_CHROMA_KEY_CLIP_FG;
            public static final Integer DEFAULT_COMPRESSOR;
            public static final String DEFAULT_ENHANCEDAUDIOFILTER = "";
            public static final String DEFAULT_EQUALIZER = "";
            public static final String DEFAULT_IOS_MEDIA_ASSET_ID = "";
            public static final Integer DEFAULT_PAN_LEFT;
            public static final Integer DEFAULT_PAN_RIGHT;
            public static final Integer DEFAULT_PITCH_FACTOR;
            public static final String DEFAULT_VIDEO_MSID = "";
            public static final String DEFAULT_VIDEO_PATH = "";
            public static final Integer DEFAULT_VOICE_CHANGER;
            private static final long serialVersionUID = 0;

            @n(tag = 103, type = Message.Datatype.INT32)
            public final Integer brightness;

            @n(tag = 122, type = Message.Datatype.FLOAT)
            public final Float chroma_key_blend_x0;

            @n(tag = 124, type = Message.Datatype.FLOAT)
            public final Float chroma_key_blend_x1;

            @n(tag = 123, type = Message.Datatype.FLOAT)
            public final Float chroma_key_blend_y0;

            @n(tag = 125, type = Message.Datatype.FLOAT)
            public final Float chroma_key_blend_y1;

            @n(tag = 121, type = Message.Datatype.FLOAT)
            public final Float chroma_key_clip_bg;

            @n(tag = 120, type = Message.Datatype.FLOAT)
            public final Float chroma_key_clip_fg;

            @n(tag = 118, type = Message.Datatype.INT32)
            public final Integer chroma_key_color;

            @n(label = Message.Label.PACKED, tag = 1, type = Message.Datatype.FLOAT)
            public final List<Float> chroma_key_divisions;

            @n(tag = 119, type = Message.Datatype.BOOL)
            public final Boolean chroma_key_enabled;

            @n(label = Message.Label.PACKED, tag = 2, type = Message.Datatype.FLOAT)
            public final List<Float> chroma_key_strengths;

            @n(tag = 114, type = Message.Datatype.INT32)
            public final Integer clip_volume;

            @n(tag = 106)
            public final ColorEffect color_effect;

            @n(tag = 129, type = Message.Datatype.INT32)
            public final Integer compressor;

            @n(tag = 104, type = Message.Datatype.INT32)
            public final Integer contrast;

            @n(tag = 107, type = Message.Datatype.INT32)
            public final Integer engine_clip_id;

            @n(tag = 132, type = Message.Datatype.STRING)
            public final String enhancedAudioFilter;

            @n(tag = 133, type = Message.Datatype.STRING)
            public final String equalizer;

            @n(tag = 111, type = Message.Datatype.BOOL)
            public final Boolean has_audio;

            @n(tag = 112, type = Message.Datatype.BOOL)
            public final Boolean has_video;

            @n(tag = 131, type = Message.Datatype.STRING)
            public final String ios_media_asset_id;

            @n(tag = 100)
            public final LayerCommon layer_common;

            @n(tag = 113, type = Message.Datatype.BOOL)
            public final Boolean mute_audio;

            @n(tag = 108, type = Message.Datatype.INT32)
            public final Integer original_clip_duration;

            @n(tag = 110, type = Message.Datatype.INT32)
            public final Integer original_video_height;

            @n(tag = 109, type = Message.Datatype.INT32)
            public final Integer original_video_width;

            @n(tag = 127, type = Message.Datatype.INT32)
            public final Integer pan_left;

            @n(tag = 128, type = Message.Datatype.INT32)
            public final Integer pan_right;

            @n(tag = 130, type = Message.Datatype.INT32)
            public final Integer pitch_factor;

            @n(tag = 115, type = Message.Datatype.INT32)
            public final Integer playback_speed;

            @n(tag = 105, type = Message.Datatype.INT32)
            public final Integer saturation;

            @n(tag = 102, type = Message.Datatype.STRING)
            public final String video_msid;

            @n(tag = 101, type = Message.Datatype.STRING)
            public final String video_path;

            @n(tag = 126, type = Message.Datatype.INT32)
            public final Integer voice_changer;

            @n(label = Message.Label.PACKED, tag = 117, type = Message.Datatype.INT32)
            public final List<Integer> volume_envelope_level;

            @n(label = Message.Label.PACKED, tag = 116, type = Message.Datatype.INT32)
            public final List<Integer> volume_envelope_time;
            public static final Integer DEFAULT_BRIGHTNESS = 0;
            public static final Integer DEFAULT_CONTRAST = 0;
            public static final Integer DEFAULT_SATURATION = 0;
            public static final Integer DEFAULT_ENGINE_CLIP_ID = 0;
            public static final Integer DEFAULT_ORIGINAL_CLIP_DURATION = 0;
            public static final Integer DEFAULT_ORIGINAL_VIDEO_WIDTH = 0;
            public static final Integer DEFAULT_ORIGINAL_VIDEO_HEIGHT = 0;
            public static final Boolean DEFAULT_HAS_AUDIO = false;
            public static final Boolean DEFAULT_HAS_VIDEO = false;
            public static final Boolean DEFAULT_MUTE_AUDIO = false;
            public static final Integer DEFAULT_CLIP_VOLUME = 0;
            public static final Integer DEFAULT_PLAYBACK_SPEED = 0;
            public static final List<Integer> DEFAULT_VOLUME_ENVELOPE_TIME = Collections.emptyList();
            public static final List<Integer> DEFAULT_VOLUME_ENVELOPE_LEVEL = Collections.emptyList();
            public static final List<Float> DEFAULT_CHROMA_KEY_DIVISIONS = Collections.emptyList();
            public static final List<Float> DEFAULT_CHROMA_KEY_STRENGTHS = Collections.emptyList();
            public static final Integer DEFAULT_CHROMA_KEY_COLOR = 0;
            public static final Boolean DEFAULT_CHROMA_KEY_ENABLED = false;

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<VideoLayer> {
                public Integer brightness;
                public Float chroma_key_blend_x0;
                public Float chroma_key_blend_x1;
                public Float chroma_key_blend_y0;
                public Float chroma_key_blend_y1;
                public Float chroma_key_clip_bg;
                public Float chroma_key_clip_fg;
                public Integer chroma_key_color;
                public List<Float> chroma_key_divisions;
                public Boolean chroma_key_enabled;
                public List<Float> chroma_key_strengths;
                public Integer clip_volume;
                public ColorEffect color_effect;
                public Integer compressor;
                public Integer contrast;
                public Integer engine_clip_id;
                public String enhancedAudioFilter;
                public String equalizer;
                public Boolean has_audio;
                public Boolean has_video;
                public String ios_media_asset_id;
                public LayerCommon layer_common;
                public Boolean mute_audio;
                public Integer original_clip_duration;
                public Integer original_video_height;
                public Integer original_video_width;
                public Integer pan_left;
                public Integer pan_right;
                public Integer pitch_factor;
                public Integer playback_speed;
                public Integer saturation;
                public String video_msid;
                public String video_path;
                public Integer voice_changer;
                public List<Integer> volume_envelope_level;
                public List<Integer> volume_envelope_time;

                public Builder() {
                }

                public Builder brightness(Integer num) {
                    this.brightness = num;
                    return this;
                }

                public Builder chroma_key_blend_x0(Float f2) {
                    this.chroma_key_blend_x0 = f2;
                    return this;
                }

                public Builder chroma_key_blend_x1(Float f2) {
                    this.chroma_key_blend_x1 = f2;
                    return this;
                }

                public Builder chroma_key_blend_y0(Float f2) {
                    this.chroma_key_blend_y0 = f2;
                    return this;
                }

                public Builder chroma_key_blend_y1(Float f2) {
                    this.chroma_key_blend_y1 = f2;
                    return this;
                }

                public Builder chroma_key_clip_bg(Float f2) {
                    this.chroma_key_clip_bg = f2;
                    return this;
                }

                public Builder chroma_key_clip_fg(Float f2) {
                    this.chroma_key_clip_fg = f2;
                    return this;
                }

                public Builder chroma_key_color(Integer num) {
                    this.chroma_key_color = num;
                    return this;
                }

                public Builder chroma_key_divisions(List<Float> list) {
                    Message.a.checkForNulls(list);
                    this.chroma_key_divisions = list;
                    return this;
                }

                public Builder chroma_key_enabled(Boolean bool) {
                    this.chroma_key_enabled = bool;
                    return this;
                }

                public Builder chroma_key_strengths(List<Float> list) {
                    Message.a.checkForNulls(list);
                    this.chroma_key_strengths = list;
                    return this;
                }

                public Builder clip_volume(Integer num) {
                    this.clip_volume = num;
                    return this;
                }

                public Builder color_effect(ColorEffect colorEffect) {
                    this.color_effect = colorEffect;
                    return this;
                }

                public Builder compressor(Integer num) {
                    this.compressor = num;
                    return this;
                }

                public Builder contrast(Integer num) {
                    this.contrast = num;
                    return this;
                }

                public Builder engine_clip_id(Integer num) {
                    this.engine_clip_id = num;
                    return this;
                }

                public Builder enhancedAudioFilter(String str) {
                    this.enhancedAudioFilter = str;
                    return this;
                }

                public Builder equalizer(String str) {
                    this.equalizer = str;
                    return this;
                }

                public Builder has_audio(Boolean bool) {
                    this.has_audio = bool;
                    return this;
                }

                public Builder has_video(Boolean bool) {
                    this.has_video = bool;
                    return this;
                }

                public Builder ios_media_asset_id(String str) {
                    this.ios_media_asset_id = str;
                    return this;
                }

                public Builder layer_common(LayerCommon layerCommon) {
                    this.layer_common = layerCommon;
                    return this;
                }

                public Builder mute_audio(Boolean bool) {
                    this.mute_audio = bool;
                    return this;
                }

                public Builder original_clip_duration(Integer num) {
                    this.original_clip_duration = num;
                    return this;
                }

                public Builder original_video_height(Integer num) {
                    this.original_video_height = num;
                    return this;
                }

                public Builder original_video_width(Integer num) {
                    this.original_video_width = num;
                    return this;
                }

                public Builder pan_left(Integer num) {
                    this.pan_left = num;
                    return this;
                }

                public Builder pan_right(Integer num) {
                    this.pan_right = num;
                    return this;
                }

                public Builder pitch_factor(Integer num) {
                    this.pitch_factor = num;
                    return this;
                }

                public Builder playback_speed(Integer num) {
                    this.playback_speed = num;
                    return this;
                }

                public Builder saturation(Integer num) {
                    this.saturation = num;
                    return this;
                }

                public Builder video_msid(String str) {
                    this.video_msid = str;
                    return this;
                }

                public Builder video_path(String str) {
                    this.video_path = str;
                    return this;
                }

                public Builder voice_changer(Integer num) {
                    this.voice_changer = num;
                    return this;
                }

                public Builder volume_envelope_level(List<Integer> list) {
                    Message.a.checkForNulls(list);
                    this.volume_envelope_level = list;
                    return this;
                }

                public Builder volume_envelope_time(List<Integer> list) {
                    Message.a.checkForNulls(list);
                    this.volume_envelope_time = list;
                    return this;
                }

                public Builder(VideoLayer videoLayer) {
                    super(videoLayer);
                    if (videoLayer == null) {
                        return;
                    }
                    this.layer_common = videoLayer.layer_common;
                    this.video_path = videoLayer.video_path;
                    this.video_msid = videoLayer.video_msid;
                    this.brightness = videoLayer.brightness;
                    this.contrast = videoLayer.contrast;
                    this.saturation = videoLayer.saturation;
                    this.color_effect = videoLayer.color_effect;
                    this.engine_clip_id = videoLayer.engine_clip_id;
                    this.original_clip_duration = videoLayer.original_clip_duration;
                    this.original_video_width = videoLayer.original_video_width;
                    this.original_video_height = videoLayer.original_video_height;
                    this.has_audio = videoLayer.has_audio;
                    this.has_video = videoLayer.has_video;
                    this.mute_audio = videoLayer.mute_audio;
                    this.clip_volume = videoLayer.clip_volume;
                    this.playback_speed = videoLayer.playback_speed;
                    this.volume_envelope_time = Message.copyOf(videoLayer.volume_envelope_time);
                    this.volume_envelope_level = Message.copyOf(videoLayer.volume_envelope_level);
                    this.chroma_key_divisions = Message.copyOf(videoLayer.chroma_key_divisions);
                    this.chroma_key_strengths = Message.copyOf(videoLayer.chroma_key_strengths);
                    this.chroma_key_color = videoLayer.chroma_key_color;
                    this.chroma_key_enabled = videoLayer.chroma_key_enabled;
                    this.chroma_key_clip_fg = videoLayer.chroma_key_clip_fg;
                    this.chroma_key_clip_bg = videoLayer.chroma_key_clip_bg;
                    this.chroma_key_blend_x0 = videoLayer.chroma_key_blend_x0;
                    this.chroma_key_blend_y0 = videoLayer.chroma_key_blend_y0;
                    this.chroma_key_blend_x1 = videoLayer.chroma_key_blend_x1;
                    this.chroma_key_blend_y1 = videoLayer.chroma_key_blend_y1;
                    this.voice_changer = videoLayer.voice_changer;
                    this.pan_left = videoLayer.pan_left;
                    this.pan_right = videoLayer.pan_right;
                    this.compressor = videoLayer.compressor;
                    this.pitch_factor = videoLayer.pitch_factor;
                    this.ios_media_asset_id = videoLayer.ios_media_asset_id;
                    this.enhancedAudioFilter = videoLayer.enhancedAudioFilter;
                    this.equalizer = videoLayer.equalizer;
                }

                @Override // com.squareup.wire.Message.a
                public VideoLayer build() {
                    return new VideoLayer(this);
                }
            }

            static {
                Float valueOf = Float.valueOf(0.0f);
                DEFAULT_CHROMA_KEY_CLIP_FG = valueOf;
                DEFAULT_CHROMA_KEY_CLIP_BG = valueOf;
                DEFAULT_CHROMA_KEY_BLEND_X0 = valueOf;
                DEFAULT_CHROMA_KEY_BLEND_Y0 = valueOf;
                DEFAULT_CHROMA_KEY_BLEND_X1 = valueOf;
                DEFAULT_CHROMA_KEY_BLEND_Y1 = valueOf;
                DEFAULT_VOICE_CHANGER = 0;
                DEFAULT_PAN_LEFT = 0;
                DEFAULT_PAN_RIGHT = 0;
                DEFAULT_COMPRESSOR = 0;
                DEFAULT_PITCH_FACTOR = 0;
            }

            /* synthetic */ VideoLayer(Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof VideoLayer)) {
                    return false;
                }
                VideoLayer videoLayer = (VideoLayer) obj;
                return equals(this.layer_common, videoLayer.layer_common) && equals(this.video_path, videoLayer.video_path) && equals(this.video_msid, videoLayer.video_msid) && equals(this.brightness, videoLayer.brightness) && equals(this.contrast, videoLayer.contrast) && equals(this.saturation, videoLayer.saturation) && equals(this.color_effect, videoLayer.color_effect) && equals(this.engine_clip_id, videoLayer.engine_clip_id) && equals(this.original_clip_duration, videoLayer.original_clip_duration) && equals(this.original_video_width, videoLayer.original_video_width) && equals(this.original_video_height, videoLayer.original_video_height) && equals(this.has_audio, videoLayer.has_audio) && equals(this.has_video, videoLayer.has_video) && equals(this.mute_audio, videoLayer.mute_audio) && equals(this.clip_volume, videoLayer.clip_volume) && equals(this.playback_speed, videoLayer.playback_speed) && equals((List<?>) this.volume_envelope_time, (List<?>) videoLayer.volume_envelope_time) && equals((List<?>) this.volume_envelope_level, (List<?>) videoLayer.volume_envelope_level) && equals((List<?>) this.chroma_key_divisions, (List<?>) videoLayer.chroma_key_divisions) && equals((List<?>) this.chroma_key_strengths, (List<?>) videoLayer.chroma_key_strengths) && equals(this.chroma_key_color, videoLayer.chroma_key_color) && equals(this.chroma_key_enabled, videoLayer.chroma_key_enabled) && equals(this.chroma_key_clip_fg, videoLayer.chroma_key_clip_fg) && equals(this.chroma_key_clip_bg, videoLayer.chroma_key_clip_bg) && equals(this.chroma_key_blend_x0, videoLayer.chroma_key_blend_x0) && equals(this.chroma_key_blend_y0, videoLayer.chroma_key_blend_y0) && equals(this.chroma_key_blend_x1, videoLayer.chroma_key_blend_x1) && equals(this.chroma_key_blend_y1, videoLayer.chroma_key_blend_y1) && equals(this.voice_changer, videoLayer.voice_changer) && equals(this.pan_left, videoLayer.pan_left) && equals(this.pan_right, videoLayer.pan_right) && equals(this.compressor, videoLayer.compressor) && equals(this.pitch_factor, videoLayer.pitch_factor) && equals(this.ios_media_asset_id, videoLayer.ios_media_asset_id) && equals(this.enhancedAudioFilter, videoLayer.enhancedAudioFilter) && equals(this.equalizer, videoLayer.equalizer);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i != 0) {
                    return i;
                }
                LayerCommon layerCommon = this.layer_common;
                int hashCode = (layerCommon != null ? layerCommon.hashCode() : 0) * 37;
                String str = this.video_path;
                int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
                String str2 = this.video_msid;
                int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
                Integer num = this.brightness;
                int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
                Integer num2 = this.contrast;
                int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
                Integer num3 = this.saturation;
                int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
                ColorEffect colorEffect = this.color_effect;
                int hashCode7 = (hashCode6 + (colorEffect != null ? colorEffect.hashCode() : 0)) * 37;
                Integer num4 = this.engine_clip_id;
                int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
                Integer num5 = this.original_clip_duration;
                int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
                Integer num6 = this.original_video_width;
                int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
                Integer num7 = this.original_video_height;
                int hashCode11 = (hashCode10 + (num7 != null ? num7.hashCode() : 0)) * 37;
                Boolean bool = this.has_audio;
                int hashCode12 = (hashCode11 + (bool != null ? bool.hashCode() : 0)) * 37;
                Boolean bool2 = this.has_video;
                int hashCode13 = (hashCode12 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
                Boolean bool3 = this.mute_audio;
                int hashCode14 = (hashCode13 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
                Integer num8 = this.clip_volume;
                int hashCode15 = (hashCode14 + (num8 != null ? num8.hashCode() : 0)) * 37;
                Integer num9 = this.playback_speed;
                int hashCode16 = (hashCode15 + (num9 != null ? num9.hashCode() : 0)) * 37;
                List<Integer> list = this.volume_envelope_time;
                int hashCode17 = (hashCode16 + (list != null ? list.hashCode() : 1)) * 37;
                List<Integer> list2 = this.volume_envelope_level;
                int hashCode18 = (hashCode17 + (list2 != null ? list2.hashCode() : 1)) * 37;
                List<Float> list3 = this.chroma_key_divisions;
                int hashCode19 = (hashCode18 + (list3 != null ? list3.hashCode() : 1)) * 37;
                List<Float> list4 = this.chroma_key_strengths;
                int hashCode20 = (hashCode19 + (list4 != null ? list4.hashCode() : 1)) * 37;
                Integer num10 = this.chroma_key_color;
                int hashCode21 = (hashCode20 + (num10 != null ? num10.hashCode() : 0)) * 37;
                Boolean bool4 = this.chroma_key_enabled;
                int hashCode22 = (hashCode21 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
                Float f2 = this.chroma_key_clip_fg;
                int hashCode23 = (hashCode22 + (f2 != null ? f2.hashCode() : 0)) * 37;
                Float f3 = this.chroma_key_clip_bg;
                int hashCode24 = (hashCode23 + (f3 != null ? f3.hashCode() : 0)) * 37;
                Float f4 = this.chroma_key_blend_x0;
                int hashCode25 = (hashCode24 + (f4 != null ? f4.hashCode() : 0)) * 37;
                Float f5 = this.chroma_key_blend_y0;
                int hashCode26 = (hashCode25 + (f5 != null ? f5.hashCode() : 0)) * 37;
                Float f6 = this.chroma_key_blend_x1;
                int hashCode27 = (hashCode26 + (f6 != null ? f6.hashCode() : 0)) * 37;
                Float f7 = this.chroma_key_blend_y1;
                int hashCode28 = (hashCode27 + (f7 != null ? f7.hashCode() : 0)) * 37;
                Integer num11 = this.voice_changer;
                int hashCode29 = (hashCode28 + (num11 != null ? num11.hashCode() : 0)) * 37;
                Integer num12 = this.pan_left;
                int hashCode30 = (hashCode29 + (num12 != null ? num12.hashCode() : 0)) * 37;
                Integer num13 = this.pan_right;
                int hashCode31 = (hashCode30 + (num13 != null ? num13.hashCode() : 0)) * 37;
                Integer num14 = this.compressor;
                int hashCode32 = (hashCode31 + (num14 != null ? num14.hashCode() : 0)) * 37;
                Integer num15 = this.pitch_factor;
                int hashCode33 = (hashCode32 + (num15 != null ? num15.hashCode() : 0)) * 37;
                String str3 = this.ios_media_asset_id;
                int hashCode34 = (hashCode33 + (str3 != null ? str3.hashCode() : 0)) * 37;
                String str4 = this.enhancedAudioFilter;
                int hashCode35 = (hashCode34 + (str4 != null ? str4.hashCode() : 0)) * 37;
                String str5 = this.equalizer;
                int hashCode36 = hashCode35 + (str5 != null ? str5.hashCode() : 0);
                this.hashCode = hashCode36;
                return hashCode36;
            }

            public VideoLayer(LayerCommon layerCommon, String str, String str2, Integer num, Integer num2, Integer num3, ColorEffect colorEffect, Integer num4, Integer num5, Integer num6, Integer num7, Boolean bool, Boolean bool2, Boolean bool3, Integer num8, Integer num9, List<Integer> list, List<Integer> list2, List<Float> list3, List<Float> list4, Integer num10, Boolean bool4, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, String str3, String str4, String str5) {
                this.layer_common = layerCommon;
                this.video_path = str;
                this.video_msid = str2;
                this.brightness = num;
                this.contrast = num2;
                this.saturation = num3;
                this.color_effect = colorEffect;
                this.engine_clip_id = num4;
                this.original_clip_duration = num5;
                this.original_video_width = num6;
                this.original_video_height = num7;
                this.has_audio = bool;
                this.has_video = bool2;
                this.mute_audio = bool3;
                this.clip_volume = num8;
                this.playback_speed = num9;
                this.volume_envelope_time = Message.immutableCopyOf(list);
                this.volume_envelope_level = Message.immutableCopyOf(list2);
                this.chroma_key_divisions = Message.immutableCopyOf(list3);
                this.chroma_key_strengths = Message.immutableCopyOf(list4);
                this.chroma_key_color = num10;
                this.chroma_key_enabled = bool4;
                this.chroma_key_clip_fg = f2;
                this.chroma_key_clip_bg = f3;
                this.chroma_key_blend_x0 = f4;
                this.chroma_key_blend_y0 = f5;
                this.chroma_key_blend_x1 = f6;
                this.chroma_key_blend_y1 = f7;
                this.voice_changer = num11;
                this.pan_left = num12;
                this.pan_right = num13;
                this.compressor = num14;
                this.pitch_factor = num15;
                this.ios_media_asset_id = str3;
                this.enhancedAudioFilter = str4;
                this.equalizer = str5;
            }

            private VideoLayer(Builder builder) {
                this(builder.layer_common, builder.video_path, builder.video_msid, builder.brightness, builder.contrast, builder.saturation, builder.color_effect, builder.engine_clip_id, builder.original_clip_duration, builder.original_video_width, builder.original_video_height, builder.has_audio, builder.has_video, builder.mute_audio, builder.clip_volume, builder.playback_speed, builder.volume_envelope_time, builder.volume_envelope_level, builder.chroma_key_divisions, builder.chroma_key_strengths, builder.chroma_key_color, builder.chroma_key_enabled, builder.chroma_key_clip_fg, builder.chroma_key_clip_bg, builder.chroma_key_blend_x0, builder.chroma_key_blend_y0, builder.chroma_key_blend_x1, builder.chroma_key_blend_y1, builder.voice_changer, builder.pan_left, builder.pan_right, builder.compressor, builder.pitch_factor, builder.ios_media_asset_id, builder.enhancedAudioFilter, builder.equalizer);
                setBuilder(builder);
            }
        }

        /* loaded from: classes.dex */
        public static final class VisualClip extends Message {
            public static final Boolean DEFAULT_ABSTRACT_CROP;
            public static final Integer DEFAULT_AUDIO_DURATION;
            public static final ThemeEffectType DEFAULT_AUTO_THEME_EFFECT;
            public static final Integer DEFAULT_BRIGHTNESS;
            public static final String DEFAULT_CAPTURE_FILENAME = "";
            public static final String DEFAULT_CLIP_NAME = "";
            public static final ClipState DEFAULT_CLIP_STATE;
            public static final Integer DEFAULT_CLIP_VOLUME;
            public static final Float DEFAULT_CLIP_WIDTH;
            public static final Integer DEFAULT_COMPRESSOR;
            public static final Integer DEFAULT_CONTRAST;
            public static final Boolean DEFAULT_CROP_LINK;
            public static final Integer DEFAULT_DIFF_AV_DURATION;
            public static final Integer DEFAULT_DURATION;
            public static final Integer DEFAULT_EFFECT_END_TIME;
            public static final Integer DEFAULT_EFFECT_START_TIME;
            public static final Integer DEFAULT_END_OVERLAP;
            public static final Integer DEFAULT_END_POSITION_BOTTOM;
            public static final Integer DEFAULT_END_POSITION_LEFT;
            public static final Integer DEFAULT_END_POSITION_RIGHT;
            public static final Integer DEFAULT_END_POSITION_TOP;
            public static final Integer DEFAULT_ENGINE_CLIP_ID;
            public static final String DEFAULT_ENHANCEDAUDIOFILTER = "";
            public static final String DEFAULT_EQUALIZER = "";
            public static final Float DEFAULT_FACE_BOUNDS_BOTTOM;
            public static final Float DEFAULT_FACE_BOUNDS_LEFT;
            public static final Float DEFAULT_FACE_BOUNDS_RIGHT;
            public static final Boolean DEFAULT_FACE_BOUNDS_SET;
            public static final Float DEFAULT_FACE_BOUNDS_TOP;
            public static final Boolean DEFAULT_FLIPH;
            public static final Boolean DEFAULT_FLIPV;
            public static final Boolean DEFAULT_HAS_AUDIO;
            public static final Boolean DEFAULT_HAS_VIDEO;
            public static final Integer DEFAULT_HEIGHT;
            public static final String DEFAULT_IOS_MEDIA_ASSET_ID = "";
            public static final Boolean DEFAULT_IS_IMAGE;
            public static final Boolean DEFAULT_IS_REVERSE;
            public static final Boolean DEFAULT_KEEPPITCH;
            public static final String DEFAULT_MEDIA_MSID = "";
            public static final String DEFAULT_MEDIA_PATH = "";
            public static final Integer DEFAULT_MUSIC_VOLUME;
            public static final Boolean DEFAULT_MUTE_AUDIO;
            public static final Boolean DEFAULT_MUTE_MUSIC;
            public static final Integer DEFAULT_ORIGINAL_HEIGHT;
            public static final Integer DEFAULT_ORIGINAL_WIDTH;
            public static final Integer DEFAULT_PAN_LEFT;
            public static final Integer DEFAULT_PAN_RIGHT;
            public static final Integer DEFAULT_PITCH_FACTOR;
            public static final Integer DEFAULT_PLAYBACK_SPEED;
            public static final Integer DEFAULT_PRE_TRIMMED_DURATION;
            public static final Integer DEFAULT_ROTATED_END_POSITION_BOTTOM;
            public static final Integer DEFAULT_ROTATED_END_POSITION_LEFT;
            public static final Integer DEFAULT_ROTATED_END_POSITION_RIGHT;
            public static final Integer DEFAULT_ROTATED_END_POSITION_TOP;
            public static final Integer DEFAULT_ROTATED_START_POSITION_BOTTOM;
            public static final Integer DEFAULT_ROTATED_START_POSITION_LEFT;
            public static final Integer DEFAULT_ROTATED_START_POSITION_RIGHT;
            public static final Integer DEFAULT_ROTATED_START_POSITION_TOP;
            public static final Integer DEFAULT_ROTATION;
            public static final Integer DEFAULT_SATURATION;
            public static final Integer DEFAULT_START_OVERLAP;
            public static final Integer DEFAULT_START_POSITION_BOTTOM;
            public static final Integer DEFAULT_START_POSITION_LEFT;
            public static final Integer DEFAULT_START_POSITION_RIGHT;
            public static final Integer DEFAULT_START_POSITION_TOP;
            public static final String DEFAULT_THUMB_PATH = "";
            public static final Integer DEFAULT_TINTCOLOR;
            public static final String DEFAULT_TITLE_EFFECT_ID = "";
            public static final Integer DEFAULT_TITLE_END_TIME;
            public static final Integer DEFAULT_TITLE_START_TIME;
            public static final TitleStyle DEFAULT_TITLE_STYLE;
            public static final Boolean DEFAULT_TRANSCODE_APPROVED;
            public static final Long DEFAULT_TRANSITION_ITEM_UUID_LSB;
            public static final Long DEFAULT_TRANSITION_ITEM_UUID_MSB;
            public static final Integer DEFAULT_TRIMMED_DURATION;
            public static final Integer DEFAULT_TRIM_TIME_END;
            public static final Integer DEFAULT_TRIM_TIME_START;
            public static final Boolean DEFAULT_USEIFRAMEONLY;
            public static final Integer DEFAULT_VIDEO_DURATION;
            public static final Boolean DEFAULT_VIGNETTE;
            public static final Integer DEFAULT_VOICE_CHANGER;
            public static final List<Integer> DEFAULT_VOLUME_ENVELOPE_LEVEL;
            public static final List<Integer> DEFAULT_VOLUME_ENVELOPE_TIME;
            public static final Integer DEFAULT_WIDTH;
            private static final long serialVersionUID = 0;

            @n(tag = 107, type = Message.Datatype.BOOL)
            public final Boolean abstract_crop;

            @n(tag = 136, type = Message.Datatype.INT32)
            public final Integer audio_duration;

            @n(tag = 164, type = Message.Datatype.ENUM)
            public final ThemeEffectType auto_theme_effect;

            @n(tag = 156, type = Message.Datatype.INT32)
            public final Integer brightness;

            @n(tag = 105, type = Message.Datatype.STRING)
            public final String capture_filename;

            @n(tag = 184, type = Message.Datatype.STRING)
            public final String clip_name;

            @n(tag = 173, type = Message.Datatype.ENUM)
            public final ClipState clip_state;

            @n(tag = 144, type = Message.Datatype.INT32)
            public final Integer clip_volume;

            @n(tag = 167, type = Message.Datatype.FLOAT)
            public final Float clip_width;

            @n(tag = 169)
            public final ColorEffect color_effect;

            @n(tag = 182, type = Message.Datatype.INT32)
            public final Integer compressor;

            @n(tag = 157, type = Message.Datatype.INT32)
            public final Integer contrast;

            @n(tag = 175, type = Message.Datatype.BOOL)
            public final Boolean crop_link;

            @n(tag = 127, type = Message.Datatype.INT32)
            public final Integer diff_av_duration;

            @n(tag = 135, type = Message.Datatype.INT32)
            public final Integer duration;

            @n(tag = 161, type = Message.Datatype.INT32)
            public final Integer effect_end_time;

            @n(tag = 170)
            public final StringHashMap effect_options;

            @n(tag = 160, type = Message.Datatype.INT32)
            public final Integer effect_start_time;

            @n(tag = 163)
            public final Matrix end_matrix;

            @n(tag = 139, type = Message.Datatype.INT32)
            public final Integer end_overlap;

            @n(tag = 113, type = Message.Datatype.INT32)
            public final Integer end_position_bottom;

            @n(tag = 112, type = Message.Datatype.INT32)
            public final Integer end_position_left;

            @n(tag = 114, type = Message.Datatype.INT32)
            public final Integer end_position_right;

            @n(tag = 115, type = Message.Datatype.INT32)
            public final Integer end_position_top;

            @n(tag = 106, type = Message.Datatype.INT32)
            public final Integer engine_clip_id;

            @n(tag = 188, type = Message.Datatype.STRING)
            public final String enhancedAudioFilter;

            @n(tag = 189, type = Message.Datatype.STRING)
            public final String equalizer;

            @n(tag = 103, type = Message.Datatype.FLOAT)
            public final Float face_bounds_bottom;

            @n(tag = 100, type = Message.Datatype.FLOAT)
            public final Float face_bounds_left;

            @n(tag = 102, type = Message.Datatype.FLOAT)
            public final Float face_bounds_right;

            @n(tag = 104, type = Message.Datatype.BOOL)
            public final Boolean face_bounds_set;

            @n(tag = 101, type = Message.Datatype.FLOAT)
            public final Float face_bounds_top;

            @n(tag = 125, type = Message.Datatype.BOOL)
            public final Boolean fliph;

            @n(tag = 126, type = Message.Datatype.BOOL)
            public final Boolean flipv;

            @n(tag = 150, type = Message.Datatype.BOOL)
            public final Boolean has_audio;

            @n(tag = 151, type = Message.Datatype.BOOL)
            public final Boolean has_video;

            @n(tag = 141, type = Message.Datatype.INT32)
            public final Integer height;

            @n(tag = 185, type = Message.Datatype.STRING)
            public final String ios_media_asset_id;

            @n(tag = 147, type = Message.Datatype.BOOL)
            public final Boolean is_image;

            @n(tag = 177, type = Message.Datatype.BOOL)
            public final Boolean is_reverse;

            @n(tag = 186, type = Message.Datatype.BOOL)
            public final Boolean keepPitch;

            @n(tag = 174, type = Message.Datatype.STRING)
            public final String media_msid;

            @n(tag = 153, type = Message.Datatype.STRING)
            public final String media_path;

            @n(tag = 145, type = Message.Datatype.INT32)
            public final Integer music_volume;

            @n(tag = 148, type = Message.Datatype.BOOL)
            public final Boolean mute_audio;

            @n(tag = 149, type = Message.Datatype.BOOL)
            public final Boolean mute_music;

            @n(tag = 143, type = Message.Datatype.INT32)
            public final Integer original_height;

            @n(tag = 142, type = Message.Datatype.INT32)
            public final Integer original_width;

            @n(tag = 180, type = Message.Datatype.INT32)
            public final Integer pan_left;

            @n(tag = 181, type = Message.Datatype.INT32)
            public final Integer pan_right;

            @n(tag = 183, type = Message.Datatype.INT32)
            public final Integer pitch_factor;

            @n(tag = 168, type = Message.Datatype.INT32)
            public final Integer playback_speed;

            @n(tag = 131, type = Message.Datatype.INT32)
            public final Integer pre_trimmed_duration;

            @n(tag = 121, type = Message.Datatype.INT32)
            public final Integer rotated_end_position_bottom;

            @n(tag = 120, type = Message.Datatype.INT32)
            public final Integer rotated_end_position_left;

            @n(tag = 122, type = Message.Datatype.INT32)
            public final Integer rotated_end_position_right;

            @n(tag = 123, type = Message.Datatype.INT32)
            public final Integer rotated_end_position_top;

            @n(tag = 117, type = Message.Datatype.INT32)
            public final Integer rotated_start_position_bottom;

            @n(tag = 116, type = Message.Datatype.INT32)
            public final Integer rotated_start_position_left;

            @n(tag = 118, type = Message.Datatype.INT32)
            public final Integer rotated_start_position_right;

            @n(tag = 119, type = Message.Datatype.INT32)
            public final Integer rotated_start_position_top;

            @n(tag = 124, type = Message.Datatype.INT32)
            public final Integer rotation;

            @n(tag = 158, type = Message.Datatype.INT32)
            public final Integer saturation;

            @n(tag = 162)
            public final Matrix start_matrix;

            @n(tag = 138, type = Message.Datatype.INT32)
            public final Integer start_overlap;

            @n(tag = 109, type = Message.Datatype.INT32)
            public final Integer start_position_bottom;

            @n(tag = 108, type = Message.Datatype.INT32)
            public final Integer start_position_left;

            @n(tag = 110, type = Message.Datatype.INT32)
            public final Integer start_position_right;

            @n(tag = 111, type = Message.Datatype.INT32)
            public final Integer start_position_top;

            @n(tag = 152, type = Message.Datatype.STRING)
            public final String thumb_path;

            @n(tag = 159, type = Message.Datatype.INT32)
            public final Integer tintcolor;

            @n(tag = 132, type = Message.Datatype.STRING)
            public final String title_effect_id;

            @n(tag = 134, type = Message.Datatype.INT32)
            public final Integer title_end_time;

            @n(tag = 133, type = Message.Datatype.INT32)
            public final Integer title_start_time;

            @n(tag = 146, type = Message.Datatype.ENUM)
            public final TitleStyle title_style;

            @n(tag = 172, type = Message.Datatype.BOOL)
            public final Boolean transcode_approved;

            @n(tag = 154, type = Message.Datatype.UINT64)
            public final Long transition_item_uuid_lsb;

            @n(tag = 155, type = Message.Datatype.UINT64)
            public final Long transition_item_uuid_msb;

            @n(tag = 129, type = Message.Datatype.INT32)
            public final Integer trim_time_end;

            @n(tag = 128, type = Message.Datatype.INT32)
            public final Integer trim_time_start;

            @n(tag = 130, type = Message.Datatype.INT32)
            public final Integer trimmed_duration;

            @n(tag = 171)
            public final TimelineItem unattached_transition;

            @n(tag = 187, type = Message.Datatype.BOOL)
            public final Boolean useIFrameOnly;

            @n(tag = 137, type = Message.Datatype.INT32)
            public final Integer video_duration;

            @n(tag = 179, type = Message.Datatype.BOOL)
            public final Boolean vignette;

            @n(tag = 178, type = Message.Datatype.INT32)
            public final Integer voice_changer;

            @n(label = Message.Label.PACKED, tag = 166, type = Message.Datatype.INT32)
            public final List<Integer> volume_envelope_level;

            @n(label = Message.Label.PACKED, tag = 165, type = Message.Datatype.INT32)
            public final List<Integer> volume_envelope_time;

            @n(tag = 140, type = Message.Datatype.INT32)
            public final Integer width;

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<VisualClip> {
                public Boolean abstract_crop;
                public Integer audio_duration;
                public ThemeEffectType auto_theme_effect;
                public Integer brightness;
                public String capture_filename;
                public String clip_name;
                public ClipState clip_state;
                public Integer clip_volume;
                public Float clip_width;
                public ColorEffect color_effect;
                public Integer compressor;
                public Integer contrast;
                public Boolean crop_link;
                public Integer diff_av_duration;
                public Integer duration;
                public Integer effect_end_time;
                public StringHashMap effect_options;
                public Integer effect_start_time;
                public Matrix end_matrix;
                public Integer end_overlap;
                public Integer end_position_bottom;
                public Integer end_position_left;
                public Integer end_position_right;
                public Integer end_position_top;
                public Integer engine_clip_id;
                public String enhancedAudioFilter;
                public String equalizer;
                public Float face_bounds_bottom;
                public Float face_bounds_left;
                public Float face_bounds_right;
                public Boolean face_bounds_set;
                public Float face_bounds_top;
                public Boolean fliph;
                public Boolean flipv;
                public Boolean has_audio;
                public Boolean has_video;
                public Integer height;
                public String ios_media_asset_id;
                public Boolean is_image;
                public Boolean is_reverse;
                public Boolean keepPitch;
                public String media_msid;
                public String media_path;
                public Integer music_volume;
                public Boolean mute_audio;
                public Boolean mute_music;
                public Integer original_height;
                public Integer original_width;
                public Integer pan_left;
                public Integer pan_right;
                public Integer pitch_factor;
                public Integer playback_speed;
                public Integer pre_trimmed_duration;
                public Integer rotated_end_position_bottom;
                public Integer rotated_end_position_left;
                public Integer rotated_end_position_right;
                public Integer rotated_end_position_top;
                public Integer rotated_start_position_bottom;
                public Integer rotated_start_position_left;
                public Integer rotated_start_position_right;
                public Integer rotated_start_position_top;
                public Integer rotation;
                public Integer saturation;
                public Matrix start_matrix;
                public Integer start_overlap;
                public Integer start_position_bottom;
                public Integer start_position_left;
                public Integer start_position_right;
                public Integer start_position_top;
                public String thumb_path;
                public Integer tintcolor;
                public String title_effect_id;
                public Integer title_end_time;
                public Integer title_start_time;
                public TitleStyle title_style;
                public Boolean transcode_approved;
                public Long transition_item_uuid_lsb;
                public Long transition_item_uuid_msb;
                public Integer trim_time_end;
                public Integer trim_time_start;
                public Integer trimmed_duration;
                public TimelineItem unattached_transition;
                public Boolean useIFrameOnly;
                public Integer video_duration;
                public Boolean vignette;
                public Integer voice_changer;
                public List<Integer> volume_envelope_level;
                public List<Integer> volume_envelope_time;
                public Integer width;

                public Builder() {
                }

                public Builder abstract_crop(Boolean bool) {
                    this.abstract_crop = bool;
                    return this;
                }

                public Builder audio_duration(Integer num) {
                    this.audio_duration = num;
                    return this;
                }

                public Builder auto_theme_effect(ThemeEffectType themeEffectType) {
                    this.auto_theme_effect = themeEffectType;
                    return this;
                }

                public Builder brightness(Integer num) {
                    this.brightness = num;
                    return this;
                }

                public Builder capture_filename(String str) {
                    this.capture_filename = str;
                    return this;
                }

                public Builder clip_name(String str) {
                    this.clip_name = str;
                    return this;
                }

                public Builder clip_state(ClipState clipState) {
                    this.clip_state = clipState;
                    return this;
                }

                public Builder clip_volume(Integer num) {
                    this.clip_volume = num;
                    return this;
                }

                public Builder clip_width(Float f2) {
                    this.clip_width = f2;
                    return this;
                }

                public Builder color_effect(ColorEffect colorEffect) {
                    this.color_effect = colorEffect;
                    return this;
                }

                public Builder compressor(Integer num) {
                    this.compressor = num;
                    return this;
                }

                public Builder contrast(Integer num) {
                    this.contrast = num;
                    return this;
                }

                public Builder crop_link(Boolean bool) {
                    this.crop_link = bool;
                    return this;
                }

                public Builder diff_av_duration(Integer num) {
                    this.diff_av_duration = num;
                    return this;
                }

                public Builder duration(Integer num) {
                    this.duration = num;
                    return this;
                }

                public Builder effect_end_time(Integer num) {
                    this.effect_end_time = num;
                    return this;
                }

                public Builder effect_options(StringHashMap stringHashMap) {
                    this.effect_options = stringHashMap;
                    return this;
                }

                public Builder effect_start_time(Integer num) {
                    this.effect_start_time = num;
                    return this;
                }

                public Builder end_matrix(Matrix matrix) {
                    this.end_matrix = matrix;
                    return this;
                }

                public Builder end_overlap(Integer num) {
                    this.end_overlap = num;
                    return this;
                }

                public Builder end_position_bottom(Integer num) {
                    this.end_position_bottom = num;
                    return this;
                }

                public Builder end_position_left(Integer num) {
                    this.end_position_left = num;
                    return this;
                }

                public Builder end_position_right(Integer num) {
                    this.end_position_right = num;
                    return this;
                }

                public Builder end_position_top(Integer num) {
                    this.end_position_top = num;
                    return this;
                }

                public Builder engine_clip_id(Integer num) {
                    this.engine_clip_id = num;
                    return this;
                }

                public Builder enhancedAudioFilter(String str) {
                    this.enhancedAudioFilter = str;
                    return this;
                }

                public Builder equalizer(String str) {
                    this.equalizer = str;
                    return this;
                }

                public Builder face_bounds_bottom(Float f2) {
                    this.face_bounds_bottom = f2;
                    return this;
                }

                public Builder face_bounds_left(Float f2) {
                    this.face_bounds_left = f2;
                    return this;
                }

                public Builder face_bounds_right(Float f2) {
                    this.face_bounds_right = f2;
                    return this;
                }

                public Builder face_bounds_set(Boolean bool) {
                    this.face_bounds_set = bool;
                    return this;
                }

                public Builder face_bounds_top(Float f2) {
                    this.face_bounds_top = f2;
                    return this;
                }

                public Builder fliph(Boolean bool) {
                    this.fliph = bool;
                    return this;
                }

                public Builder flipv(Boolean bool) {
                    this.flipv = bool;
                    return this;
                }

                public Builder has_audio(Boolean bool) {
                    this.has_audio = bool;
                    return this;
                }

                public Builder has_video(Boolean bool) {
                    this.has_video = bool;
                    return this;
                }

                public Builder height(Integer num) {
                    this.height = num;
                    return this;
                }

                public Builder ios_media_asset_id(String str) {
                    this.ios_media_asset_id = str;
                    return this;
                }

                public Builder is_image(Boolean bool) {
                    this.is_image = bool;
                    return this;
                }

                public Builder is_reverse(Boolean bool) {
                    this.is_reverse = bool;
                    return this;
                }

                public Builder keepPitch(Boolean bool) {
                    this.keepPitch = bool;
                    return this;
                }

                public Builder media_msid(String str) {
                    this.media_msid = str;
                    return this;
                }

                public Builder media_path(String str) {
                    this.media_path = str;
                    return this;
                }

                public Builder music_volume(Integer num) {
                    this.music_volume = num;
                    return this;
                }

                public Builder mute_audio(Boolean bool) {
                    this.mute_audio = bool;
                    return this;
                }

                public Builder mute_music(Boolean bool) {
                    this.mute_music = bool;
                    return this;
                }

                public Builder original_height(Integer num) {
                    this.original_height = num;
                    return this;
                }

                public Builder original_width(Integer num) {
                    this.original_width = num;
                    return this;
                }

                public Builder pan_left(Integer num) {
                    this.pan_left = num;
                    return this;
                }

                public Builder pan_right(Integer num) {
                    this.pan_right = num;
                    return this;
                }

                public Builder pitch_factor(Integer num) {
                    this.pitch_factor = num;
                    return this;
                }

                public Builder playback_speed(Integer num) {
                    this.playback_speed = num;
                    return this;
                }

                public Builder pre_trimmed_duration(Integer num) {
                    this.pre_trimmed_duration = num;
                    return this;
                }

                public Builder rotated_end_position_bottom(Integer num) {
                    this.rotated_end_position_bottom = num;
                    return this;
                }

                public Builder rotated_end_position_left(Integer num) {
                    this.rotated_end_position_left = num;
                    return this;
                }

                public Builder rotated_end_position_right(Integer num) {
                    this.rotated_end_position_right = num;
                    return this;
                }

                public Builder rotated_end_position_top(Integer num) {
                    this.rotated_end_position_top = num;
                    return this;
                }

                public Builder rotated_start_position_bottom(Integer num) {
                    this.rotated_start_position_bottom = num;
                    return this;
                }

                public Builder rotated_start_position_left(Integer num) {
                    this.rotated_start_position_left = num;
                    return this;
                }

                public Builder rotated_start_position_right(Integer num) {
                    this.rotated_start_position_right = num;
                    return this;
                }

                public Builder rotated_start_position_top(Integer num) {
                    this.rotated_start_position_top = num;
                    return this;
                }

                public Builder rotation(Integer num) {
                    this.rotation = num;
                    return this;
                }

                public Builder saturation(Integer num) {
                    this.saturation = num;
                    return this;
                }

                public Builder start_matrix(Matrix matrix) {
                    this.start_matrix = matrix;
                    return this;
                }

                public Builder start_overlap(Integer num) {
                    this.start_overlap = num;
                    return this;
                }

                public Builder start_position_bottom(Integer num) {
                    this.start_position_bottom = num;
                    return this;
                }

                public Builder start_position_left(Integer num) {
                    this.start_position_left = num;
                    return this;
                }

                public Builder start_position_right(Integer num) {
                    this.start_position_right = num;
                    return this;
                }

                public Builder start_position_top(Integer num) {
                    this.start_position_top = num;
                    return this;
                }

                public Builder thumb_path(String str) {
                    this.thumb_path = str;
                    return this;
                }

                public Builder tintcolor(Integer num) {
                    this.tintcolor = num;
                    return this;
                }

                public Builder title_effect_id(String str) {
                    this.title_effect_id = str;
                    return this;
                }

                public Builder title_end_time(Integer num) {
                    this.title_end_time = num;
                    return this;
                }

                public Builder title_start_time(Integer num) {
                    this.title_start_time = num;
                    return this;
                }

                public Builder title_style(TitleStyle titleStyle) {
                    this.title_style = titleStyle;
                    return this;
                }

                public Builder transcode_approved(Boolean bool) {
                    this.transcode_approved = bool;
                    return this;
                }

                public Builder transition_item_uuid_lsb(Long l) {
                    this.transition_item_uuid_lsb = l;
                    return this;
                }

                public Builder transition_item_uuid_msb(Long l) {
                    this.transition_item_uuid_msb = l;
                    return this;
                }

                public Builder trim_time_end(Integer num) {
                    this.trim_time_end = num;
                    return this;
                }

                public Builder trim_time_start(Integer num) {
                    this.trim_time_start = num;
                    return this;
                }

                public Builder trimmed_duration(Integer num) {
                    this.trimmed_duration = num;
                    return this;
                }

                public Builder unattached_transition(TimelineItem timelineItem) {
                    this.unattached_transition = timelineItem;
                    return this;
                }

                public Builder useIFrameOnly(Boolean bool) {
                    this.useIFrameOnly = bool;
                    return this;
                }

                public Builder video_duration(Integer num) {
                    this.video_duration = num;
                    return this;
                }

                public Builder vignette(Boolean bool) {
                    this.vignette = bool;
                    return this;
                }

                public Builder voice_changer(Integer num) {
                    this.voice_changer = num;
                    return this;
                }

                public Builder volume_envelope_level(List<Integer> list) {
                    Message.a.checkForNulls(list);
                    this.volume_envelope_level = list;
                    return this;
                }

                public Builder volume_envelope_time(List<Integer> list) {
                    Message.a.checkForNulls(list);
                    this.volume_envelope_time = list;
                    return this;
                }

                public Builder width(Integer num) {
                    this.width = num;
                    return this;
                }

                public Builder(VisualClip visualClip) {
                    super(visualClip);
                    if (visualClip == null) {
                        return;
                    }
                    this.media_path = visualClip.media_path;
                    this.face_bounds_left = visualClip.face_bounds_left;
                    this.face_bounds_top = visualClip.face_bounds_top;
                    this.face_bounds_right = visualClip.face_bounds_right;
                    this.face_bounds_bottom = visualClip.face_bounds_bottom;
                    this.face_bounds_set = visualClip.face_bounds_set;
                    this.capture_filename = visualClip.capture_filename;
                    this.engine_clip_id = visualClip.engine_clip_id;
                    this.abstract_crop = visualClip.abstract_crop;
                    this.start_position_left = visualClip.start_position_left;
                    this.start_position_bottom = visualClip.start_position_bottom;
                    this.start_position_right = visualClip.start_position_right;
                    this.start_position_top = visualClip.start_position_top;
                    this.end_position_left = visualClip.end_position_left;
                    this.end_position_bottom = visualClip.end_position_bottom;
                    this.end_position_right = visualClip.end_position_right;
                    this.end_position_top = visualClip.end_position_top;
                    this.rotated_start_position_left = visualClip.rotated_start_position_left;
                    this.rotated_start_position_bottom = visualClip.rotated_start_position_bottom;
                    this.rotated_start_position_right = visualClip.rotated_start_position_right;
                    this.rotated_start_position_top = visualClip.rotated_start_position_top;
                    this.rotated_end_position_left = visualClip.rotated_end_position_left;
                    this.rotated_end_position_bottom = visualClip.rotated_end_position_bottom;
                    this.rotated_end_position_right = visualClip.rotated_end_position_right;
                    this.rotated_end_position_top = visualClip.rotated_end_position_top;
                    this.rotation = visualClip.rotation;
                    this.fliph = visualClip.fliph;
                    this.flipv = visualClip.flipv;
                    this.diff_av_duration = visualClip.diff_av_duration;
                    this.trim_time_start = visualClip.trim_time_start;
                    this.trim_time_end = visualClip.trim_time_end;
                    this.trimmed_duration = visualClip.trimmed_duration;
                    this.pre_trimmed_duration = visualClip.pre_trimmed_duration;
                    this.title_effect_id = visualClip.title_effect_id;
                    this.title_start_time = visualClip.title_start_time;
                    this.title_end_time = visualClip.title_end_time;
                    this.duration = visualClip.duration;
                    this.audio_duration = visualClip.audio_duration;
                    this.video_duration = visualClip.video_duration;
                    this.start_overlap = visualClip.start_overlap;
                    this.end_overlap = visualClip.end_overlap;
                    this.width = visualClip.width;
                    this.height = visualClip.height;
                    this.original_width = visualClip.original_width;
                    this.original_height = visualClip.original_height;
                    this.clip_volume = visualClip.clip_volume;
                    this.music_volume = visualClip.music_volume;
                    this.title_style = visualClip.title_style;
                    this.is_image = visualClip.is_image;
                    this.mute_audio = visualClip.mute_audio;
                    this.mute_music = visualClip.mute_music;
                    this.has_audio = visualClip.has_audio;
                    this.has_video = visualClip.has_video;
                    this.thumb_path = visualClip.thumb_path;
                    this.transition_item_uuid_lsb = visualClip.transition_item_uuid_lsb;
                    this.transition_item_uuid_msb = visualClip.transition_item_uuid_msb;
                    this.unattached_transition = visualClip.unattached_transition;
                    this.brightness = visualClip.brightness;
                    this.contrast = visualClip.contrast;
                    this.saturation = visualClip.saturation;
                    this.tintcolor = visualClip.tintcolor;
                    this.effect_start_time = visualClip.effect_start_time;
                    this.effect_end_time = visualClip.effect_end_time;
                    this.start_matrix = visualClip.start_matrix;
                    this.end_matrix = visualClip.end_matrix;
                    this.auto_theme_effect = visualClip.auto_theme_effect;
                    this.volume_envelope_time = Message.copyOf(visualClip.volume_envelope_time);
                    this.volume_envelope_level = Message.copyOf(visualClip.volume_envelope_level);
                    this.clip_width = visualClip.clip_width;
                    this.playback_speed = visualClip.playback_speed;
                    this.color_effect = visualClip.color_effect;
                    this.effect_options = visualClip.effect_options;
                    this.media_msid = visualClip.media_msid;
                    this.transcode_approved = visualClip.transcode_approved;
                    this.clip_state = visualClip.clip_state;
                    this.crop_link = visualClip.crop_link;
                    this.is_reverse = visualClip.is_reverse;
                    this.voice_changer = visualClip.voice_changer;
                    this.vignette = visualClip.vignette;
                    this.pan_left = visualClip.pan_left;
                    this.pan_right = visualClip.pan_right;
                    this.compressor = visualClip.compressor;
                    this.pitch_factor = visualClip.pitch_factor;
                    this.clip_name = visualClip.clip_name;
                    this.ios_media_asset_id = visualClip.ios_media_asset_id;
                    this.keepPitch = visualClip.keepPitch;
                    this.useIFrameOnly = visualClip.useIFrameOnly;
                    this.enhancedAudioFilter = visualClip.enhancedAudioFilter;
                    this.equalizer = visualClip.equalizer;
                }

                @Override // com.squareup.wire.Message.a
                public VisualClip build() {
                    return new VisualClip(this);
                }
            }

            static {
                Float valueOf = Float.valueOf(0.0f);
                DEFAULT_FACE_BOUNDS_LEFT = valueOf;
                DEFAULT_FACE_BOUNDS_TOP = valueOf;
                DEFAULT_FACE_BOUNDS_RIGHT = valueOf;
                DEFAULT_FACE_BOUNDS_BOTTOM = valueOf;
                DEFAULT_FACE_BOUNDS_SET = false;
                DEFAULT_ENGINE_CLIP_ID = 0;
                DEFAULT_ABSTRACT_CROP = false;
                DEFAULT_START_POSITION_LEFT = 0;
                DEFAULT_START_POSITION_BOTTOM = 0;
                DEFAULT_START_POSITION_RIGHT = 0;
                DEFAULT_START_POSITION_TOP = 0;
                DEFAULT_END_POSITION_LEFT = 0;
                DEFAULT_END_POSITION_BOTTOM = 0;
                DEFAULT_END_POSITION_RIGHT = 0;
                DEFAULT_END_POSITION_TOP = 0;
                DEFAULT_ROTATED_START_POSITION_LEFT = 0;
                DEFAULT_ROTATED_START_POSITION_BOTTOM = 0;
                DEFAULT_ROTATED_START_POSITION_RIGHT = 0;
                DEFAULT_ROTATED_START_POSITION_TOP = 0;
                DEFAULT_ROTATED_END_POSITION_LEFT = 0;
                DEFAULT_ROTATED_END_POSITION_BOTTOM = 0;
                DEFAULT_ROTATED_END_POSITION_RIGHT = 0;
                DEFAULT_ROTATED_END_POSITION_TOP = 0;
                DEFAULT_ROTATION = 0;
                DEFAULT_FLIPH = false;
                DEFAULT_FLIPV = false;
                DEFAULT_DIFF_AV_DURATION = 0;
                DEFAULT_TRIM_TIME_START = 0;
                DEFAULT_TRIM_TIME_END = 0;
                DEFAULT_TRIMMED_DURATION = 0;
                DEFAULT_PRE_TRIMMED_DURATION = 0;
                DEFAULT_TITLE_START_TIME = 0;
                DEFAULT_TITLE_END_TIME = 0;
                DEFAULT_DURATION = 0;
                DEFAULT_AUDIO_DURATION = 0;
                DEFAULT_VIDEO_DURATION = 0;
                DEFAULT_START_OVERLAP = 0;
                DEFAULT_END_OVERLAP = 0;
                DEFAULT_WIDTH = 0;
                DEFAULT_HEIGHT = 0;
                DEFAULT_ORIGINAL_WIDTH = 0;
                DEFAULT_ORIGINAL_HEIGHT = 0;
                DEFAULT_CLIP_VOLUME = 0;
                DEFAULT_MUSIC_VOLUME = 0;
                DEFAULT_TITLE_STYLE = TitleStyle.TITLE_STYLE_NONE;
                DEFAULT_IS_IMAGE = false;
                DEFAULT_MUTE_AUDIO = false;
                DEFAULT_MUTE_MUSIC = false;
                DEFAULT_HAS_AUDIO = false;
                DEFAULT_HAS_VIDEO = false;
                DEFAULT_TRANSITION_ITEM_UUID_LSB = 0L;
                DEFAULT_TRANSITION_ITEM_UUID_MSB = 0L;
                DEFAULT_BRIGHTNESS = 0;
                DEFAULT_CONTRAST = 0;
                DEFAULT_SATURATION = 0;
                DEFAULT_TINTCOLOR = 0;
                DEFAULT_EFFECT_START_TIME = 0;
                DEFAULT_EFFECT_END_TIME = 0;
                DEFAULT_AUTO_THEME_EFFECT = ThemeEffectType.THEME_EFFECT_TYPE_OPENING;
                DEFAULT_VOLUME_ENVELOPE_TIME = Collections.emptyList();
                DEFAULT_VOLUME_ENVELOPE_LEVEL = Collections.emptyList();
                DEFAULT_CLIP_WIDTH = valueOf;
                DEFAULT_PLAYBACK_SPEED = 0;
                DEFAULT_TRANSCODE_APPROVED = false;
                DEFAULT_CLIP_STATE = ClipState.BUSY;
                DEFAULT_CROP_LINK = false;
                DEFAULT_IS_REVERSE = false;
                DEFAULT_VOICE_CHANGER = 0;
                DEFAULT_VIGNETTE = false;
                DEFAULT_PAN_LEFT = 0;
                DEFAULT_PAN_RIGHT = 0;
                DEFAULT_COMPRESSOR = 0;
                DEFAULT_PITCH_FACTOR = 0;
                DEFAULT_KEEPPITCH = false;
                DEFAULT_USEIFRAMEONLY = false;
            }

            /* synthetic */ VisualClip(Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof VisualClip)) {
                    return false;
                }
                VisualClip visualClip = (VisualClip) obj;
                return equals(this.media_path, visualClip.media_path) && equals(this.face_bounds_left, visualClip.face_bounds_left) && equals(this.face_bounds_top, visualClip.face_bounds_top) && equals(this.face_bounds_right, visualClip.face_bounds_right) && equals(this.face_bounds_bottom, visualClip.face_bounds_bottom) && equals(this.face_bounds_set, visualClip.face_bounds_set) && equals(this.capture_filename, visualClip.capture_filename) && equals(this.engine_clip_id, visualClip.engine_clip_id) && equals(this.abstract_crop, visualClip.abstract_crop) && equals(this.start_position_left, visualClip.start_position_left) && equals(this.start_position_bottom, visualClip.start_position_bottom) && equals(this.start_position_right, visualClip.start_position_right) && equals(this.start_position_top, visualClip.start_position_top) && equals(this.end_position_left, visualClip.end_position_left) && equals(this.end_position_bottom, visualClip.end_position_bottom) && equals(this.end_position_right, visualClip.end_position_right) && equals(this.end_position_top, visualClip.end_position_top) && equals(this.rotated_start_position_left, visualClip.rotated_start_position_left) && equals(this.rotated_start_position_bottom, visualClip.rotated_start_position_bottom) && equals(this.rotated_start_position_right, visualClip.rotated_start_position_right) && equals(this.rotated_start_position_top, visualClip.rotated_start_position_top) && equals(this.rotated_end_position_left, visualClip.rotated_end_position_left) && equals(this.rotated_end_position_bottom, visualClip.rotated_end_position_bottom) && equals(this.rotated_end_position_right, visualClip.rotated_end_position_right) && equals(this.rotated_end_position_top, visualClip.rotated_end_position_top) && equals(this.rotation, visualClip.rotation) && equals(this.fliph, visualClip.fliph) && equals(this.flipv, visualClip.flipv) && equals(this.diff_av_duration, visualClip.diff_av_duration) && equals(this.trim_time_start, visualClip.trim_time_start) && equals(this.trim_time_end, visualClip.trim_time_end) && equals(this.trimmed_duration, visualClip.trimmed_duration) && equals(this.pre_trimmed_duration, visualClip.pre_trimmed_duration) && equals(this.title_effect_id, visualClip.title_effect_id) && equals(this.title_start_time, visualClip.title_start_time) && equals(this.title_end_time, visualClip.title_end_time) && equals(this.duration, visualClip.duration) && equals(this.audio_duration, visualClip.audio_duration) && equals(this.video_duration, visualClip.video_duration) && equals(this.start_overlap, visualClip.start_overlap) && equals(this.end_overlap, visualClip.end_overlap) && equals(this.width, visualClip.width) && equals(this.height, visualClip.height) && equals(this.original_width, visualClip.original_width) && equals(this.original_height, visualClip.original_height) && equals(this.clip_volume, visualClip.clip_volume) && equals(this.music_volume, visualClip.music_volume) && equals(this.title_style, visualClip.title_style) && equals(this.is_image, visualClip.is_image) && equals(this.mute_audio, visualClip.mute_audio) && equals(this.mute_music, visualClip.mute_music) && equals(this.has_audio, visualClip.has_audio) && equals(this.has_video, visualClip.has_video) && equals(this.thumb_path, visualClip.thumb_path) && equals(this.transition_item_uuid_lsb, visualClip.transition_item_uuid_lsb) && equals(this.transition_item_uuid_msb, visualClip.transition_item_uuid_msb) && equals(this.unattached_transition, visualClip.unattached_transition) && equals(this.brightness, visualClip.brightness) && equals(this.contrast, visualClip.contrast) && equals(this.saturation, visualClip.saturation) && equals(this.tintcolor, visualClip.tintcolor) && equals(this.effect_start_time, visualClip.effect_start_time) && equals(this.effect_end_time, visualClip.effect_end_time) && equals(this.start_matrix, visualClip.start_matrix) && equals(this.end_matrix, visualClip.end_matrix) && equals(this.auto_theme_effect, visualClip.auto_theme_effect) && equals((List<?>) this.volume_envelope_time, (List<?>) visualClip.volume_envelope_time) && equals((List<?>) this.volume_envelope_level, (List<?>) visualClip.volume_envelope_level) && equals(this.clip_width, visualClip.clip_width) && equals(this.playback_speed, visualClip.playback_speed) && equals(this.color_effect, visualClip.color_effect) && equals(this.effect_options, visualClip.effect_options) && equals(this.media_msid, visualClip.media_msid) && equals(this.transcode_approved, visualClip.transcode_approved) && equals(this.clip_state, visualClip.clip_state) && equals(this.crop_link, visualClip.crop_link) && equals(this.is_reverse, visualClip.is_reverse) && equals(this.voice_changer, visualClip.voice_changer) && equals(this.vignette, visualClip.vignette) && equals(this.pan_left, visualClip.pan_left) && equals(this.pan_right, visualClip.pan_right) && equals(this.compressor, visualClip.compressor) && equals(this.pitch_factor, visualClip.pitch_factor) && equals(this.clip_name, visualClip.clip_name) && equals(this.ios_media_asset_id, visualClip.ios_media_asset_id) && equals(this.keepPitch, visualClip.keepPitch) && equals(this.useIFrameOnly, visualClip.useIFrameOnly) && equals(this.enhancedAudioFilter, visualClip.enhancedAudioFilter) && equals(this.equalizer, visualClip.equalizer);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i != 0) {
                    return i;
                }
                String str = this.media_path;
                int hashCode = (str != null ? str.hashCode() : 0) * 37;
                Float f2 = this.face_bounds_left;
                int hashCode2 = (hashCode + (f2 != null ? f2.hashCode() : 0)) * 37;
                Float f3 = this.face_bounds_top;
                int hashCode3 = (hashCode2 + (f3 != null ? f3.hashCode() : 0)) * 37;
                Float f4 = this.face_bounds_right;
                int hashCode4 = (hashCode3 + (f4 != null ? f4.hashCode() : 0)) * 37;
                Float f5 = this.face_bounds_bottom;
                int hashCode5 = (hashCode4 + (f5 != null ? f5.hashCode() : 0)) * 37;
                Boolean bool = this.face_bounds_set;
                int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
                String str2 = this.capture_filename;
                int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
                Integer num = this.engine_clip_id;
                int hashCode8 = (hashCode7 + (num != null ? num.hashCode() : 0)) * 37;
                Boolean bool2 = this.abstract_crop;
                int hashCode9 = (hashCode8 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
                Integer num2 = this.start_position_left;
                int hashCode10 = (hashCode9 + (num2 != null ? num2.hashCode() : 0)) * 37;
                Integer num3 = this.start_position_bottom;
                int hashCode11 = (hashCode10 + (num3 != null ? num3.hashCode() : 0)) * 37;
                Integer num4 = this.start_position_right;
                int hashCode12 = (hashCode11 + (num4 != null ? num4.hashCode() : 0)) * 37;
                Integer num5 = this.start_position_top;
                int hashCode13 = (hashCode12 + (num5 != null ? num5.hashCode() : 0)) * 37;
                Integer num6 = this.end_position_left;
                int hashCode14 = (hashCode13 + (num6 != null ? num6.hashCode() : 0)) * 37;
                Integer num7 = this.end_position_bottom;
                int hashCode15 = (hashCode14 + (num7 != null ? num7.hashCode() : 0)) * 37;
                Integer num8 = this.end_position_right;
                int hashCode16 = (hashCode15 + (num8 != null ? num8.hashCode() : 0)) * 37;
                Integer num9 = this.end_position_top;
                int hashCode17 = (hashCode16 + (num9 != null ? num9.hashCode() : 0)) * 37;
                Integer num10 = this.rotated_start_position_left;
                int hashCode18 = (hashCode17 + (num10 != null ? num10.hashCode() : 0)) * 37;
                Integer num11 = this.rotated_start_position_bottom;
                int hashCode19 = (hashCode18 + (num11 != null ? num11.hashCode() : 0)) * 37;
                Integer num12 = this.rotated_start_position_right;
                int hashCode20 = (hashCode19 + (num12 != null ? num12.hashCode() : 0)) * 37;
                Integer num13 = this.rotated_start_position_top;
                int hashCode21 = (hashCode20 + (num13 != null ? num13.hashCode() : 0)) * 37;
                Integer num14 = this.rotated_end_position_left;
                int hashCode22 = (hashCode21 + (num14 != null ? num14.hashCode() : 0)) * 37;
                Integer num15 = this.rotated_end_position_bottom;
                int hashCode23 = (hashCode22 + (num15 != null ? num15.hashCode() : 0)) * 37;
                Integer num16 = this.rotated_end_position_right;
                int hashCode24 = (hashCode23 + (num16 != null ? num16.hashCode() : 0)) * 37;
                Integer num17 = this.rotated_end_position_top;
                int hashCode25 = (hashCode24 + (num17 != null ? num17.hashCode() : 0)) * 37;
                Integer num18 = this.rotation;
                int hashCode26 = (hashCode25 + (num18 != null ? num18.hashCode() : 0)) * 37;
                Boolean bool3 = this.fliph;
                int hashCode27 = (hashCode26 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
                Boolean bool4 = this.flipv;
                int hashCode28 = (hashCode27 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
                Integer num19 = this.diff_av_duration;
                int hashCode29 = (hashCode28 + (num19 != null ? num19.hashCode() : 0)) * 37;
                Integer num20 = this.trim_time_start;
                int hashCode30 = (hashCode29 + (num20 != null ? num20.hashCode() : 0)) * 37;
                Integer num21 = this.trim_time_end;
                int hashCode31 = (hashCode30 + (num21 != null ? num21.hashCode() : 0)) * 37;
                Integer num22 = this.trimmed_duration;
                int hashCode32 = (hashCode31 + (num22 != null ? num22.hashCode() : 0)) * 37;
                Integer num23 = this.pre_trimmed_duration;
                int hashCode33 = (hashCode32 + (num23 != null ? num23.hashCode() : 0)) * 37;
                String str3 = this.title_effect_id;
                int hashCode34 = (hashCode33 + (str3 != null ? str3.hashCode() : 0)) * 37;
                Integer num24 = this.title_start_time;
                int hashCode35 = (hashCode34 + (num24 != null ? num24.hashCode() : 0)) * 37;
                Integer num25 = this.title_end_time;
                int hashCode36 = (hashCode35 + (num25 != null ? num25.hashCode() : 0)) * 37;
                Integer num26 = this.duration;
                int hashCode37 = (hashCode36 + (num26 != null ? num26.hashCode() : 0)) * 37;
                Integer num27 = this.audio_duration;
                int hashCode38 = (hashCode37 + (num27 != null ? num27.hashCode() : 0)) * 37;
                Integer num28 = this.video_duration;
                int hashCode39 = (hashCode38 + (num28 != null ? num28.hashCode() : 0)) * 37;
                Integer num29 = this.start_overlap;
                int hashCode40 = (hashCode39 + (num29 != null ? num29.hashCode() : 0)) * 37;
                Integer num30 = this.end_overlap;
                int hashCode41 = (hashCode40 + (num30 != null ? num30.hashCode() : 0)) * 37;
                Integer num31 = this.width;
                int hashCode42 = (hashCode41 + (num31 != null ? num31.hashCode() : 0)) * 37;
                Integer num32 = this.height;
                int hashCode43 = (hashCode42 + (num32 != null ? num32.hashCode() : 0)) * 37;
                Integer num33 = this.original_width;
                int hashCode44 = (hashCode43 + (num33 != null ? num33.hashCode() : 0)) * 37;
                Integer num34 = this.original_height;
                int hashCode45 = (hashCode44 + (num34 != null ? num34.hashCode() : 0)) * 37;
                Integer num35 = this.clip_volume;
                int hashCode46 = (hashCode45 + (num35 != null ? num35.hashCode() : 0)) * 37;
                Integer num36 = this.music_volume;
                int hashCode47 = (hashCode46 + (num36 != null ? num36.hashCode() : 0)) * 37;
                TitleStyle titleStyle = this.title_style;
                int hashCode48 = (hashCode47 + (titleStyle != null ? titleStyle.hashCode() : 0)) * 37;
                Boolean bool5 = this.is_image;
                int hashCode49 = (hashCode48 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
                Boolean bool6 = this.mute_audio;
                int hashCode50 = (hashCode49 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
                Boolean bool7 = this.mute_music;
                int hashCode51 = (hashCode50 + (bool7 != null ? bool7.hashCode() : 0)) * 37;
                Boolean bool8 = this.has_audio;
                int hashCode52 = (hashCode51 + (bool8 != null ? bool8.hashCode() : 0)) * 37;
                Boolean bool9 = this.has_video;
                int hashCode53 = (hashCode52 + (bool9 != null ? bool9.hashCode() : 0)) * 37;
                String str4 = this.thumb_path;
                int hashCode54 = (hashCode53 + (str4 != null ? str4.hashCode() : 0)) * 37;
                Long l = this.transition_item_uuid_lsb;
                int hashCode55 = (hashCode54 + (l != null ? l.hashCode() : 0)) * 37;
                Long l2 = this.transition_item_uuid_msb;
                int hashCode56 = (hashCode55 + (l2 != null ? l2.hashCode() : 0)) * 37;
                TimelineItem timelineItem = this.unattached_transition;
                int hashCode57 = (hashCode56 + (timelineItem != null ? timelineItem.hashCode() : 0)) * 37;
                Integer num37 = this.brightness;
                int hashCode58 = (hashCode57 + (num37 != null ? num37.hashCode() : 0)) * 37;
                Integer num38 = this.contrast;
                int hashCode59 = (hashCode58 + (num38 != null ? num38.hashCode() : 0)) * 37;
                Integer num39 = this.saturation;
                int hashCode60 = (hashCode59 + (num39 != null ? num39.hashCode() : 0)) * 37;
                Integer num40 = this.tintcolor;
                int hashCode61 = (hashCode60 + (num40 != null ? num40.hashCode() : 0)) * 37;
                Integer num41 = this.effect_start_time;
                int hashCode62 = (hashCode61 + (num41 != null ? num41.hashCode() : 0)) * 37;
                Integer num42 = this.effect_end_time;
                int hashCode63 = (hashCode62 + (num42 != null ? num42.hashCode() : 0)) * 37;
                Matrix matrix = this.start_matrix;
                int hashCode64 = (hashCode63 + (matrix != null ? matrix.hashCode() : 0)) * 37;
                Matrix matrix2 = this.end_matrix;
                int hashCode65 = (hashCode64 + (matrix2 != null ? matrix2.hashCode() : 0)) * 37;
                ThemeEffectType themeEffectType = this.auto_theme_effect;
                int hashCode66 = (hashCode65 + (themeEffectType != null ? themeEffectType.hashCode() : 0)) * 37;
                List<Integer> list = this.volume_envelope_time;
                int hashCode67 = (hashCode66 + (list != null ? list.hashCode() : 1)) * 37;
                List<Integer> list2 = this.volume_envelope_level;
                int hashCode68 = (hashCode67 + (list2 != null ? list2.hashCode() : 1)) * 37;
                Float f6 = this.clip_width;
                int hashCode69 = (hashCode68 + (f6 != null ? f6.hashCode() : 0)) * 37;
                Integer num43 = this.playback_speed;
                int hashCode70 = (hashCode69 + (num43 != null ? num43.hashCode() : 0)) * 37;
                ColorEffect colorEffect = this.color_effect;
                int hashCode71 = (hashCode70 + (colorEffect != null ? colorEffect.hashCode() : 0)) * 37;
                StringHashMap stringHashMap = this.effect_options;
                int hashCode72 = (hashCode71 + (stringHashMap != null ? stringHashMap.hashCode() : 0)) * 37;
                String str5 = this.media_msid;
                int hashCode73 = (hashCode72 + (str5 != null ? str5.hashCode() : 0)) * 37;
                Boolean bool10 = this.transcode_approved;
                int hashCode74 = (hashCode73 + (bool10 != null ? bool10.hashCode() : 0)) * 37;
                ClipState clipState = this.clip_state;
                int hashCode75 = (hashCode74 + (clipState != null ? clipState.hashCode() : 0)) * 37;
                Boolean bool11 = this.crop_link;
                int hashCode76 = (hashCode75 + (bool11 != null ? bool11.hashCode() : 0)) * 37;
                Boolean bool12 = this.is_reverse;
                int hashCode77 = (hashCode76 + (bool12 != null ? bool12.hashCode() : 0)) * 37;
                Integer num44 = this.voice_changer;
                int hashCode78 = (hashCode77 + (num44 != null ? num44.hashCode() : 0)) * 37;
                Boolean bool13 = this.vignette;
                int hashCode79 = (hashCode78 + (bool13 != null ? bool13.hashCode() : 0)) * 37;
                Integer num45 = this.pan_left;
                int hashCode80 = (hashCode79 + (num45 != null ? num45.hashCode() : 0)) * 37;
                Integer num46 = this.pan_right;
                int hashCode81 = (hashCode80 + (num46 != null ? num46.hashCode() : 0)) * 37;
                Integer num47 = this.compressor;
                int hashCode82 = (hashCode81 + (num47 != null ? num47.hashCode() : 0)) * 37;
                Integer num48 = this.pitch_factor;
                int hashCode83 = (hashCode82 + (num48 != null ? num48.hashCode() : 0)) * 37;
                String str6 = this.clip_name;
                int hashCode84 = (hashCode83 + (str6 != null ? str6.hashCode() : 0)) * 37;
                String str7 = this.ios_media_asset_id;
                int hashCode85 = (hashCode84 + (str7 != null ? str7.hashCode() : 0)) * 37;
                Boolean bool14 = this.keepPitch;
                int hashCode86 = (hashCode85 + (bool14 != null ? bool14.hashCode() : 0)) * 37;
                Boolean bool15 = this.useIFrameOnly;
                int hashCode87 = (hashCode86 + (bool15 != null ? bool15.hashCode() : 0)) * 37;
                String str8 = this.enhancedAudioFilter;
                int hashCode88 = (hashCode87 + (str8 != null ? str8.hashCode() : 0)) * 37;
                String str9 = this.equalizer;
                int hashCode89 = hashCode88 + (str9 != null ? str9.hashCode() : 0);
                this.hashCode = hashCode89;
                return hashCode89;
            }

            public VisualClip(String str, Float f2, Float f3, Float f4, Float f5, Boolean bool, String str2, Integer num, Boolean bool2, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18, Boolean bool3, Boolean bool4, Integer num19, Integer num20, Integer num21, Integer num22, Integer num23, String str3, Integer num24, Integer num25, Integer num26, Integer num27, Integer num28, Integer num29, Integer num30, Integer num31, Integer num32, Integer num33, Integer num34, Integer num35, Integer num36, TitleStyle titleStyle, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, String str4, Long l, Long l2, TimelineItem timelineItem, Integer num37, Integer num38, Integer num39, Integer num40, Integer num41, Integer num42, Matrix matrix, Matrix matrix2, ThemeEffectType themeEffectType, List<Integer> list, List<Integer> list2, Float f6, Integer num43, ColorEffect colorEffect, StringHashMap stringHashMap, String str5, Boolean bool10, ClipState clipState, Boolean bool11, Boolean bool12, Integer num44, Boolean bool13, Integer num45, Integer num46, Integer num47, Integer num48, String str6, String str7, Boolean bool14, Boolean bool15, String str8, String str9) {
                this.media_path = str;
                this.face_bounds_left = f2;
                this.face_bounds_top = f3;
                this.face_bounds_right = f4;
                this.face_bounds_bottom = f5;
                this.face_bounds_set = bool;
                this.capture_filename = str2;
                this.engine_clip_id = num;
                this.abstract_crop = bool2;
                this.start_position_left = num2;
                this.start_position_bottom = num3;
                this.start_position_right = num4;
                this.start_position_top = num5;
                this.end_position_left = num6;
                this.end_position_bottom = num7;
                this.end_position_right = num8;
                this.end_position_top = num9;
                this.rotated_start_position_left = num10;
                this.rotated_start_position_bottom = num11;
                this.rotated_start_position_right = num12;
                this.rotated_start_position_top = num13;
                this.rotated_end_position_left = num14;
                this.rotated_end_position_bottom = num15;
                this.rotated_end_position_right = num16;
                this.rotated_end_position_top = num17;
                this.rotation = num18;
                this.fliph = bool3;
                this.flipv = bool4;
                this.diff_av_duration = num19;
                this.trim_time_start = num20;
                this.trim_time_end = num21;
                this.trimmed_duration = num22;
                this.pre_trimmed_duration = num23;
                this.title_effect_id = str3;
                this.title_start_time = num24;
                this.title_end_time = num25;
                this.duration = num26;
                this.audio_duration = num27;
                this.video_duration = num28;
                this.start_overlap = num29;
                this.end_overlap = num30;
                this.width = num31;
                this.height = num32;
                this.original_width = num33;
                this.original_height = num34;
                this.clip_volume = num35;
                this.music_volume = num36;
                this.title_style = titleStyle;
                this.is_image = bool5;
                this.mute_audio = bool6;
                this.mute_music = bool7;
                this.has_audio = bool8;
                this.has_video = bool9;
                this.thumb_path = str4;
                this.transition_item_uuid_lsb = l;
                this.transition_item_uuid_msb = l2;
                this.unattached_transition = timelineItem;
                this.brightness = num37;
                this.contrast = num38;
                this.saturation = num39;
                this.tintcolor = num40;
                this.effect_start_time = num41;
                this.effect_end_time = num42;
                this.start_matrix = matrix;
                this.end_matrix = matrix2;
                this.auto_theme_effect = themeEffectType;
                this.volume_envelope_time = Message.immutableCopyOf(list);
                this.volume_envelope_level = Message.immutableCopyOf(list2);
                this.clip_width = f6;
                this.playback_speed = num43;
                this.color_effect = colorEffect;
                this.effect_options = stringHashMap;
                this.media_msid = str5;
                this.transcode_approved = bool10;
                this.clip_state = clipState;
                this.crop_link = bool11;
                this.is_reverse = bool12;
                this.voice_changer = num44;
                this.vignette = bool13;
                this.pan_left = num45;
                this.pan_right = num46;
                this.compressor = num47;
                this.pitch_factor = num48;
                this.clip_name = str6;
                this.ios_media_asset_id = str7;
                this.keepPitch = bool14;
                this.useIFrameOnly = bool15;
                this.enhancedAudioFilter = str8;
                this.equalizer = str9;
            }

            private VisualClip(Builder builder) {
                this(builder.media_path, builder.face_bounds_left, builder.face_bounds_top, builder.face_bounds_right, builder.face_bounds_bottom, builder.face_bounds_set, builder.capture_filename, builder.engine_clip_id, builder.abstract_crop, builder.start_position_left, builder.start_position_bottom, builder.start_position_right, builder.start_position_top, builder.end_position_left, builder.end_position_bottom, builder.end_position_right, builder.end_position_top, builder.rotated_start_position_left, builder.rotated_start_position_bottom, builder.rotated_start_position_right, builder.rotated_start_position_top, builder.rotated_end_position_left, builder.rotated_end_position_bottom, builder.rotated_end_position_right, builder.rotated_end_position_top, builder.rotation, builder.fliph, builder.flipv, builder.diff_av_duration, builder.trim_time_start, builder.trim_time_end, builder.trimmed_duration, builder.pre_trimmed_duration, builder.title_effect_id, builder.title_start_time, builder.title_end_time, builder.duration, builder.audio_duration, builder.video_duration, builder.start_overlap, builder.end_overlap, builder.width, builder.height, builder.original_width, builder.original_height, builder.clip_volume, builder.music_volume, builder.title_style, builder.is_image, builder.mute_audio, builder.mute_music, builder.has_audio, builder.has_video, builder.thumb_path, builder.transition_item_uuid_lsb, builder.transition_item_uuid_msb, builder.unattached_transition, builder.brightness, builder.contrast, builder.saturation, builder.tintcolor, builder.effect_start_time, builder.effect_end_time, builder.start_matrix, builder.end_matrix, builder.auto_theme_effect, builder.volume_envelope_time, builder.volume_envelope_level, builder.clip_width, builder.playback_speed, builder.color_effect, builder.effect_options, builder.media_msid, builder.transcode_approved, builder.clip_state, builder.crop_link, builder.is_reverse, builder.voice_changer, builder.vignette, builder.pan_left, builder.pan_right, builder.compressor, builder.pitch_factor, builder.clip_name, builder.ios_media_asset_id, builder.keepPitch, builder.useIFrameOnly, builder.enhancedAudioFilter, builder.equalizer);
                setBuilder(builder);
            }
        }

        /* loaded from: classes.dex */
        public static final class WritingPoint extends Message {
            public static final Float DEFAULT_POINTX;
            public static final Float DEFAULT_POINTY;
            private static final long serialVersionUID = 0;

            @n(tag = 1, type = Message.Datatype.FLOAT)
            public final Float pointx;

            @n(tag = 2, type = Message.Datatype.FLOAT)
            public final Float pointy;

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<WritingPoint> {
                public Float pointx;
                public Float pointy;

                public Builder() {
                }

                public Builder pointx(Float f2) {
                    this.pointx = f2;
                    return this;
                }

                public Builder pointy(Float f2) {
                    this.pointy = f2;
                    return this;
                }

                public Builder(WritingPoint writingPoint) {
                    super(writingPoint);
                    if (writingPoint == null) {
                        return;
                    }
                    this.pointx = writingPoint.pointx;
                    this.pointy = writingPoint.pointy;
                }

                @Override // com.squareup.wire.Message.a
                public WritingPoint build() {
                    return new WritingPoint(this);
                }
            }

            static {
                Float valueOf = Float.valueOf(0.0f);
                DEFAULT_POINTX = valueOf;
                DEFAULT_POINTY = valueOf;
            }

            /* synthetic */ WritingPoint(Builder builder, AnonymousClass1 anonymousClass1) {
                this(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof WritingPoint)) {
                    return false;
                }
                WritingPoint writingPoint = (WritingPoint) obj;
                return equals(this.pointx, writingPoint.pointx) && equals(this.pointy, writingPoint.pointy);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i != 0) {
                    return i;
                }
                Float f2 = this.pointx;
                int hashCode = (f2 != null ? f2.hashCode() : 0) * 37;
                Float f3 = this.pointy;
                int hashCode2 = hashCode + (f3 != null ? f3.hashCode() : 0);
                this.hashCode = hashCode2;
                return hashCode2;
            }

            public WritingPoint(Float f2, Float f3) {
                this.pointx = f2;
                this.pointy = f3;
            }

            private WritingPoint(Builder builder) {
                this(builder.pointx, builder.pointy);
                setBuilder(builder);
            }
        }

        static {
            Float valueOf = Float.valueOf(0.0f);
            DEFAULT_PROJECT_AUDIO_FADE_IN_TIME = valueOf;
            DEFAULT_PROJECT_AUDIO_FADE_OUT_TIME = valueOf;
            DEFAULT_IS_PROJECT_AUDIO_FADE_IN_ON = false;
            DEFAULT_IS_PROJECT_AUDIO_FADE_OUT_ON = false;
            DEFAULT_PROJECT_VIDEO_FADE_IN_TIME = valueOf;
            DEFAULT_PROJECT_VIDEO_FADE_OUT_TIME = valueOf;
            DEFAULT_IS_PROJECT_VIDEO_FADE_IN_ON = false;
            DEFAULT_IS_PROJECT_VIDEO_FADE_OUT_ON = false;
            DEFAULT_PROJECT_DEFAULT_IMG_DURATION = 0;
            DEFAULT_PROJECT_DEFAULT_LAYER_DURATION = 0;
            DEFAULT_PROJECT_AUTO_MASTER = false;
            DEFAULT_PROJECT_MASTER_VOLUME = 0;
            DEFAULT_PROJECT_RESOLUTION_SETTING = 0;
            DEFAULT_PROJECT_FRAME_RATE = 0;
            DEFAULT_PROJECT_DEFAULT_IMG_CROP_MODE_IOS = 0;
            DEFAULT_PROJECT_CAPABILITY_MODE = 0;
            DEFAULT_ASPECT_RATIO_WIDTH = 0;
            DEFAULT_ASPECT_RATIO_HEIGHT = 0;
        }

        /* synthetic */ KMProject(Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof KMProject)) {
                return false;
            }
            KMProject kMProject = (KMProject) obj;
            return equals(this.timeline_format_version, kMProject.timeline_format_version) && equals((List<?>) this.primary_items, (List<?>) kMProject.primary_items) && equals((List<?>) this.secondary_items, (List<?>) kMProject.secondary_items) && equals((List<?>) this.tracks, (List<?>) kMProject.tracks) && equals((List<?>) this.bookmarks, (List<?>) kMProject.bookmarks) && equals(this.recent_scroll_time, kMProject.recent_scroll_time) && equals(this.project_ratio, kMProject.project_ratio) && equals(this.project_audio_fade_in_time, kMProject.project_audio_fade_in_time) && equals(this.project_audio_fade_out_time, kMProject.project_audio_fade_out_time) && equals(this.is_project_audio_fade_in_on, kMProject.is_project_audio_fade_in_on) && equals(this.is_project_audio_fade_out_on, kMProject.is_project_audio_fade_out_on) && equals(this.project_video_fade_in_time, kMProject.project_video_fade_in_time) && equals(this.project_video_fade_out_time, kMProject.project_video_fade_out_time) && equals(this.is_project_video_fade_in_on, kMProject.is_project_video_fade_in_on) && equals(this.is_project_video_fade_out_on, kMProject.is_project_video_fade_out_on) && equals(this.project_default_img_duration, kMProject.project_default_img_duration) && equals(this.project_default_layer_duration, kMProject.project_default_layer_duration) && equals(this.project_default_img_crop_mode, kMProject.project_default_img_crop_mode) && equals(this.project_auto_master, kMProject.project_auto_master) && equals(this.project_master_volume, kMProject.project_master_volume) && equals(this.project_resolution_setting, kMProject.project_resolution_setting) && equals(this.project_frame_rate, kMProject.project_frame_rate) && equals(this.project_default_img_crop_mode_ios, kMProject.project_default_img_crop_mode_ios) && equals(this.project_capability_mode, kMProject.project_capability_mode) && equals(this.aspect_ratio_width, kMProject.aspect_ratio_width) && equals(this.aspect_ratio_height, kMProject.aspect_ratio_height);
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i != 0) {
                return i;
            }
            Integer num = this.timeline_format_version;
            int hashCode = (num != null ? num.hashCode() : 0) * 37;
            List<TimelineItem> list = this.primary_items;
            int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
            List<TimelineItem> list2 = this.secondary_items;
            int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 1)) * 37;
            List<Track> list3 = this.tracks;
            int hashCode4 = (hashCode3 + (list3 != null ? list3.hashCode() : 1)) * 37;
            List<Integer> list4 = this.bookmarks;
            int hashCode5 = (hashCode4 + (list4 != null ? list4.hashCode() : 1)) * 37;
            Integer num2 = this.recent_scroll_time;
            int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
            AspectRatio aspectRatio = this.project_ratio;
            int hashCode7 = (hashCode6 + (aspectRatio != null ? aspectRatio.hashCode() : 0)) * 37;
            Float f2 = this.project_audio_fade_in_time;
            int hashCode8 = (hashCode7 + (f2 != null ? f2.hashCode() : 0)) * 37;
            Float f3 = this.project_audio_fade_out_time;
            int hashCode9 = (hashCode8 + (f3 != null ? f3.hashCode() : 0)) * 37;
            Boolean bool = this.is_project_audio_fade_in_on;
            int hashCode10 = (hashCode9 + (bool != null ? bool.hashCode() : 0)) * 37;
            Boolean bool2 = this.is_project_audio_fade_out_on;
            int hashCode11 = (hashCode10 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
            Float f4 = this.project_video_fade_in_time;
            int hashCode12 = (hashCode11 + (f4 != null ? f4.hashCode() : 0)) * 37;
            Float f5 = this.project_video_fade_out_time;
            int hashCode13 = (hashCode12 + (f5 != null ? f5.hashCode() : 0)) * 37;
            Boolean bool3 = this.is_project_video_fade_in_on;
            int hashCode14 = (hashCode13 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
            Boolean bool4 = this.is_project_video_fade_out_on;
            int hashCode15 = (hashCode14 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
            Integer num3 = this.project_default_img_duration;
            int hashCode16 = (hashCode15 + (num3 != null ? num3.hashCode() : 0)) * 37;
            Integer num4 = this.project_default_layer_duration;
            int hashCode17 = (hashCode16 + (num4 != null ? num4.hashCode() : 0)) * 37;
            String str = this.project_default_img_crop_mode;
            int hashCode18 = (hashCode17 + (str != null ? str.hashCode() : 0)) * 37;
            Boolean bool5 = this.project_auto_master;
            int hashCode19 = (hashCode18 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
            Integer num5 = this.project_master_volume;
            int hashCode20 = (hashCode19 + (num5 != null ? num5.hashCode() : 0)) * 37;
            Integer num6 = this.project_resolution_setting;
            int hashCode21 = (hashCode20 + (num6 != null ? num6.hashCode() : 0)) * 37;
            Integer num7 = this.project_frame_rate;
            int hashCode22 = (hashCode21 + (num7 != null ? num7.hashCode() : 0)) * 37;
            Integer num8 = this.project_default_img_crop_mode_ios;
            int hashCode23 = (hashCode22 + (num8 != null ? num8.hashCode() : 0)) * 37;
            Integer num9 = this.project_capability_mode;
            int hashCode24 = (hashCode23 + (num9 != null ? num9.hashCode() : 0)) * 37;
            Integer num10 = this.aspect_ratio_width;
            int hashCode25 = (hashCode24 + (num10 != null ? num10.hashCode() : 0)) * 37;
            Integer num11 = this.aspect_ratio_height;
            int hashCode26 = hashCode25 + (num11 != null ? num11.hashCode() : 0);
            this.hashCode = hashCode26;
            return hashCode26;
        }

        public KMProject(Integer num, List<TimelineItem> list, List<TimelineItem> list2, List<Track> list3, List<Integer> list4, Integer num2, AspectRatio aspectRatio, Float f2, Float f3, Boolean bool, Boolean bool2, Float f4, Float f5, Boolean bool3, Boolean bool4, Integer num3, Integer num4, String str, Boolean bool5, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11) {
            this.timeline_format_version = num;
            this.primary_items = Message.immutableCopyOf(list);
            this.secondary_items = Message.immutableCopyOf(list2);
            this.tracks = Message.immutableCopyOf(list3);
            this.bookmarks = Message.immutableCopyOf(list4);
            this.recent_scroll_time = num2;
            this.project_ratio = aspectRatio;
            this.project_audio_fade_in_time = f2;
            this.project_audio_fade_out_time = f3;
            this.is_project_audio_fade_in_on = bool;
            this.is_project_audio_fade_out_on = bool2;
            this.project_video_fade_in_time = f4;
            this.project_video_fade_out_time = f5;
            this.is_project_video_fade_in_on = bool3;
            this.is_project_video_fade_out_on = bool4;
            this.project_default_img_duration = num3;
            this.project_default_layer_duration = num4;
            this.project_default_img_crop_mode = str;
            this.project_auto_master = bool5;
            this.project_master_volume = num5;
            this.project_resolution_setting = num6;
            this.project_frame_rate = num7;
            this.project_default_img_crop_mode_ios = num8;
            this.project_capability_mode = num9;
            this.aspect_ratio_width = num10;
            this.aspect_ratio_height = num11;
        }

        private KMProject(Builder builder) {
            this(builder.timeline_format_version, builder.primary_items, builder.secondary_items, builder.tracks, builder.bookmarks, builder.recent_scroll_time, builder.project_ratio, builder.project_audio_fade_in_time, builder.project_audio_fade_out_time, builder.is_project_audio_fade_in_on, builder.is_project_audio_fade_out_on, builder.project_video_fade_in_time, builder.project_video_fade_out_time, builder.is_project_video_fade_in_on, builder.is_project_video_fade_out_on, builder.project_default_img_duration, builder.project_default_layer_duration, builder.project_default_img_crop_mode, builder.project_auto_master, builder.project_master_volume, builder.project_resolution_setting, builder.project_frame_rate, builder.project_default_img_crop_mode_ios, builder.project_capability_mode, builder.aspect_ratio_width, builder.aspect_ratio_height);
            setBuilder(builder);
        }
    }

    /* loaded from: classes.dex */
    public static final class KMProjectHeader extends Message {
        public static final String DEFAULT_BGM_THEME_ID = "";
        public static final String DEFAULT_SAVED_WITH_KM_VER_NAME = "";
        public static final String DEFAULT_THEME_ID = "";
        private static final long serialVersionUID = 0;

        @n(tag = 102, type = Message.Datatype.STRING)
        public final String bgm_theme_id;

        @n(tag = 3, type = Message.Datatype.UINT64)
        public final Long creation_time;

        @n(tag = 5, type = Message.Datatype.BYTES)
        public final ByteString jpeg_thumbnail;

        @n(tag = 4, type = Message.Datatype.UINT64)
        public final Long last_edit_time;

        @n(tag = 100, type = Message.Datatype.BOOL)
        public final Boolean need_update_large_thumbnail;

        @n(tag = 6, type = Message.Datatype.UINT64)
        public final Long project_uuid_lsb;

        @n(tag = 7, type = Message.Datatype.UINT64)
        public final Long project_uuid_msb;

        @n(tag = 1, type = Message.Datatype.UINT32)
        public final Integer project_version;

        @n(tag = 104, type = Message.Datatype.ENUM)
        public final Platform saved_on_platform;

        @n(tag = 103, type = Message.Datatype.STRING)
        public final String saved_with_km_ver_name;

        @n(tag = 2, type = Message.Datatype.UINT32)
        public final Integer saved_with_km_version;

        @n(tag = 101, type = Message.Datatype.STRING)
        public final String theme_id;

        @n(tag = 8, type = Message.Datatype.UINT32)
        public final Integer total_play_time;

        @n(tag = 105, type = Message.Datatype.BOOL)
        public final Boolean using_icloud_for_ios_only;
        public static final Integer DEFAULT_PROJECT_VERSION = 0;
        public static final Integer DEFAULT_SAVED_WITH_KM_VERSION = 0;
        public static final Long DEFAULT_CREATION_TIME = 0L;
        public static final Long DEFAULT_LAST_EDIT_TIME = 0L;
        public static final ByteString DEFAULT_JPEG_THUMBNAIL = ByteString.EMPTY;
        public static final Boolean DEFAULT_NEED_UPDATE_LARGE_THUMBNAIL = false;
        public static final Long DEFAULT_PROJECT_UUID_LSB = 0L;
        public static final Long DEFAULT_PROJECT_UUID_MSB = 0L;
        public static final Integer DEFAULT_TOTAL_PLAY_TIME = 0;
        public static final Platform DEFAULT_SAVED_ON_PLATFORM = Platform.IOS;
        public static final Boolean DEFAULT_USING_ICLOUD_FOR_IOS_ONLY = false;

        /* loaded from: classes2.dex */
        public static final class Builder extends Message.a<KMProjectHeader> {
            public String bgm_theme_id;
            public Long creation_time;
            public ByteString jpeg_thumbnail;
            public Long last_edit_time;
            public Boolean need_update_large_thumbnail;
            public Long project_uuid_lsb;
            public Long project_uuid_msb;
            public Integer project_version;
            public Platform saved_on_platform;
            public String saved_with_km_ver_name;
            public Integer saved_with_km_version;
            public String theme_id;
            public Integer total_play_time;
            public Boolean using_icloud_for_ios_only;

            public Builder() {
            }

            public Builder bgm_theme_id(String str) {
                this.bgm_theme_id = str;
                return this;
            }

            public Builder creation_time(Long l) {
                this.creation_time = l;
                return this;
            }

            public Builder jpeg_thumbnail(ByteString byteString) {
                this.jpeg_thumbnail = byteString;
                return this;
            }

            public Builder last_edit_time(Long l) {
                this.last_edit_time = l;
                return this;
            }

            public Builder need_update_large_thumbnail(Boolean bool) {
                this.need_update_large_thumbnail = bool;
                return this;
            }

            public Builder project_uuid_lsb(Long l) {
                this.project_uuid_lsb = l;
                return this;
            }

            public Builder project_uuid_msb(Long l) {
                this.project_uuid_msb = l;
                return this;
            }

            public Builder project_version(Integer num) {
                this.project_version = num;
                return this;
            }

            public Builder saved_on_platform(Platform platform) {
                this.saved_on_platform = platform;
                return this;
            }

            public Builder saved_with_km_ver_name(String str) {
                this.saved_with_km_ver_name = str;
                return this;
            }

            public Builder saved_with_km_version(Integer num) {
                this.saved_with_km_version = num;
                return this;
            }

            public Builder theme_id(String str) {
                this.theme_id = str;
                return this;
            }

            public Builder total_play_time(Integer num) {
                this.total_play_time = num;
                return this;
            }

            public Builder using_icloud_for_ios_only(Boolean bool) {
                this.using_icloud_for_ios_only = bool;
                return this;
            }

            public Builder(KMProjectHeader kMProjectHeader) {
                super(kMProjectHeader);
                if (kMProjectHeader == null) {
                    return;
                }
                this.project_version = kMProjectHeader.project_version;
                this.saved_with_km_version = kMProjectHeader.saved_with_km_version;
                this.creation_time = kMProjectHeader.creation_time;
                this.last_edit_time = kMProjectHeader.last_edit_time;
                this.jpeg_thumbnail = kMProjectHeader.jpeg_thumbnail;
                this.need_update_large_thumbnail = kMProjectHeader.need_update_large_thumbnail;
                this.project_uuid_lsb = kMProjectHeader.project_uuid_lsb;
                this.project_uuid_msb = kMProjectHeader.project_uuid_msb;
                this.theme_id = kMProjectHeader.theme_id;
                this.bgm_theme_id = kMProjectHeader.bgm_theme_id;
                this.total_play_time = kMProjectHeader.total_play_time;
                this.saved_with_km_ver_name = kMProjectHeader.saved_with_km_ver_name;
                this.saved_on_platform = kMProjectHeader.saved_on_platform;
                this.using_icloud_for_ios_only = kMProjectHeader.using_icloud_for_ios_only;
            }

            @Override // com.squareup.wire.Message.a
            public KMProjectHeader build() {
                return new KMProjectHeader(this);
            }
        }

        /* synthetic */ KMProjectHeader(Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof KMProjectHeader)) {
                return false;
            }
            KMProjectHeader kMProjectHeader = (KMProjectHeader) obj;
            return equals(this.project_version, kMProjectHeader.project_version) && equals(this.saved_with_km_version, kMProjectHeader.saved_with_km_version) && equals(this.creation_time, kMProjectHeader.creation_time) && equals(this.last_edit_time, kMProjectHeader.last_edit_time) && equals(this.jpeg_thumbnail, kMProjectHeader.jpeg_thumbnail) && equals(this.need_update_large_thumbnail, kMProjectHeader.need_update_large_thumbnail) && equals(this.project_uuid_lsb, kMProjectHeader.project_uuid_lsb) && equals(this.project_uuid_msb, kMProjectHeader.project_uuid_msb) && equals(this.theme_id, kMProjectHeader.theme_id) && equals(this.bgm_theme_id, kMProjectHeader.bgm_theme_id) && equals(this.total_play_time, kMProjectHeader.total_play_time) && equals(this.saved_with_km_ver_name, kMProjectHeader.saved_with_km_ver_name) && equals(this.saved_on_platform, kMProjectHeader.saved_on_platform) && equals(this.using_icloud_for_ios_only, kMProjectHeader.using_icloud_for_ios_only);
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i != 0) {
                return i;
            }
            Integer num = this.project_version;
            int hashCode = (num != null ? num.hashCode() : 0) * 37;
            Integer num2 = this.saved_with_km_version;
            int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
            Long l = this.creation_time;
            int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
            Long l2 = this.last_edit_time;
            int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
            ByteString byteString = this.jpeg_thumbnail;
            int hashCode5 = (hashCode4 + (byteString != null ? byteString.hashCode() : 0)) * 37;
            Boolean bool = this.need_update_large_thumbnail;
            int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
            Long l3 = this.project_uuid_lsb;
            int hashCode7 = (hashCode6 + (l3 != null ? l3.hashCode() : 0)) * 37;
            Long l4 = this.project_uuid_msb;
            int hashCode8 = (hashCode7 + (l4 != null ? l4.hashCode() : 0)) * 37;
            String str = this.theme_id;
            int hashCode9 = (hashCode8 + (str != null ? str.hashCode() : 0)) * 37;
            String str2 = this.bgm_theme_id;
            int hashCode10 = (hashCode9 + (str2 != null ? str2.hashCode() : 0)) * 37;
            Integer num3 = this.total_play_time;
            int hashCode11 = (hashCode10 + (num3 != null ? num3.hashCode() : 0)) * 37;
            String str3 = this.saved_with_km_ver_name;
            int hashCode12 = (hashCode11 + (str3 != null ? str3.hashCode() : 0)) * 37;
            Platform platform = this.saved_on_platform;
            int hashCode13 = (hashCode12 + (platform != null ? platform.hashCode() : 0)) * 37;
            Boolean bool2 = this.using_icloud_for_ios_only;
            int hashCode14 = hashCode13 + (bool2 != null ? bool2.hashCode() : 0);
            this.hashCode = hashCode14;
            return hashCode14;
        }

        public KMProjectHeader(Integer num, Integer num2, Long l, Long l2, ByteString byteString, Boolean bool, Long l3, Long l4, String str, String str2, Integer num3, String str3, Platform platform, Boolean bool2) {
            this.project_version = num;
            this.saved_with_km_version = num2;
            this.creation_time = l;
            this.last_edit_time = l2;
            this.jpeg_thumbnail = byteString;
            this.need_update_large_thumbnail = bool;
            this.project_uuid_lsb = l3;
            this.project_uuid_msb = l4;
            this.theme_id = str;
            this.bgm_theme_id = str2;
            this.total_play_time = num3;
            this.saved_with_km_ver_name = str3;
            this.saved_on_platform = platform;
            this.using_icloud_for_ios_only = bool2;
        }

        private KMProjectHeader(Builder builder) {
            this(builder.project_version, builder.saved_with_km_version, builder.creation_time, builder.last_edit_time, builder.jpeg_thumbnail, builder.need_update_large_thumbnail, builder.project_uuid_lsb, builder.project_uuid_msb, builder.theme_id, builder.bgm_theme_id, builder.total_play_time, builder.saved_with_km_ver_name, builder.saved_on_platform, builder.using_icloud_for_ios_only);
            setBuilder(builder);
        }
    }

    /* loaded from: classes2.dex */
    public enum Platform implements m {
        IOS(1),
        ANDROID(2);

        private final int value;

        Platform(int i) {
            this.value = i;
        }

        @Override // com.squareup.wire.m
        public int getValue() {
            return this.value;
        }
    }

    /* synthetic */ KMProto(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public boolean equals(Object obj) {
        return obj instanceof KMProto;
    }

    public int hashCode() {
        return 0;
    }

    public KMProto() {
    }

    private KMProto(Builder builder) {
        setBuilder(builder);
    }
}

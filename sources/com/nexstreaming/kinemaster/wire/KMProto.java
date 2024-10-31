package com.nexstreaming.kinemaster.wire;

import com.squareup.wire.Message;
import com.squareup.wire.m;
import com.squareup.wire.n;
import java.util.Collections;
import java.util.List;
import okio.ByteString;

/* loaded from: classes.dex */
public final class KMProto extends Message {
    private static final long serialVersionUID = 0;

    public KMProto() {
    }

    private KMProto(Builder builder) {
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        return obj instanceof KMProto;
    }

    public int hashCode() {
        return 0;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.a<KMProto> {
        public Builder() {
        }

        public Builder(KMProto kMProto) {
            super(kMProto);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.a
        public KMProto build() {
            return new KMProto(this);
        }
    }

    /* loaded from: classes.dex */
    public static final class KMProject extends Message {
        private static final long serialVersionUID = 0;

        @n(a = 103, b = Message.Datatype.UINT32, c = Message.Label.PACKED)
        public final List<Integer> bookmarks;

        @n(a = 114, b = Message.Datatype.BOOL)
        public final Boolean is_project_audio_fade_in_on;

        @n(a = 115, b = Message.Datatype.BOOL)
        public final Boolean is_project_audio_fade_out_on;

        @n(a = 122, b = Message.Datatype.BOOL)
        public final Boolean is_project_video_fade_in_on;

        @n(a = 123, b = Message.Datatype.BOOL)
        public final Boolean is_project_video_fade_out_on;

        @n(a = 1, c = Message.Label.REPEATED, d = TimelineItem.class)
        public final List<TimelineItem> primary_items;

        @n(a = 112, b = Message.Datatype.FLOAT)
        public final Float project_audio_fade_in_time;

        @n(a = 113, b = Message.Datatype.FLOAT)
        public final Float project_audio_fade_out_time;

        @n(a = 111, b = Message.Datatype.ENUM)
        public final AspectRatio project_ratio;

        @n(a = 120, b = Message.Datatype.FLOAT)
        public final Float project_video_fade_in_time;

        @n(a = 121, b = Message.Datatype.FLOAT)
        public final Float project_video_fade_out_time;

        @n(a = 109, b = Message.Datatype.INT32)
        public final Integer recent_scroll_time;

        @n(a = 2, c = Message.Label.REPEATED, d = TimelineItem.class)
        public final List<TimelineItem> secondary_items;

        @n(a = 100, b = Message.Datatype.INT32)
        public final Integer timeline_format_version;
        public static final Integer DEFAULT_TIMELINE_FORMAT_VERSION = 0;
        public static final List<TimelineItem> DEFAULT_PRIMARY_ITEMS = Collections.emptyList();
        public static final List<TimelineItem> DEFAULT_SECONDARY_ITEMS = Collections.emptyList();
        public static final List<Integer> DEFAULT_BOOKMARKS = Collections.emptyList();
        public static final Integer DEFAULT_RECENT_SCROLL_TIME = 0;
        public static final AspectRatio DEFAULT_PROJECT_RATIO = AspectRatio.ASPECT_R_16_9;
        public static final Float DEFAULT_PROJECT_AUDIO_FADE_IN_TIME = Float.valueOf(0.0f);
        public static final Float DEFAULT_PROJECT_AUDIO_FADE_OUT_TIME = Float.valueOf(0.0f);
        public static final Boolean DEFAULT_IS_PROJECT_AUDIO_FADE_IN_ON = false;
        public static final Boolean DEFAULT_IS_PROJECT_AUDIO_FADE_OUT_ON = false;
        public static final Float DEFAULT_PROJECT_VIDEO_FADE_IN_TIME = Float.valueOf(0.0f);
        public static final Float DEFAULT_PROJECT_VIDEO_FADE_OUT_TIME = Float.valueOf(0.0f);
        public static final Boolean DEFAULT_IS_PROJECT_VIDEO_FADE_IN_ON = false;
        public static final Boolean DEFAULT_IS_PROJECT_VIDEO_FADE_OUT_ON = false;

        public KMProject(Integer num, List<TimelineItem> list, List<TimelineItem> list2, List<Integer> list3, Integer num2, AspectRatio aspectRatio, Float f, Float f2, Boolean bool, Boolean bool2, Float f3, Float f4, Boolean bool3, Boolean bool4) {
            this.timeline_format_version = num;
            this.primary_items = immutableCopyOf(list);
            this.secondary_items = immutableCopyOf(list2);
            this.bookmarks = immutableCopyOf(list3);
            this.recent_scroll_time = num2;
            this.project_ratio = aspectRatio;
            this.project_audio_fade_in_time = f;
            this.project_audio_fade_out_time = f2;
            this.is_project_audio_fade_in_on = bool;
            this.is_project_audio_fade_out_on = bool2;
            this.project_video_fade_in_time = f3;
            this.project_video_fade_out_time = f4;
            this.is_project_video_fade_in_on = bool3;
            this.is_project_video_fade_out_on = bool4;
        }

        private KMProject(Builder builder) {
            this(builder.timeline_format_version, builder.primary_items, builder.secondary_items, builder.bookmarks, builder.recent_scroll_time, builder.project_ratio, builder.project_audio_fade_in_time, builder.project_audio_fade_out_time, builder.is_project_audio_fade_in_on, builder.is_project_audio_fade_out_on, builder.project_video_fade_in_time, builder.project_video_fade_out_time, builder.is_project_video_fade_in_on, builder.is_project_video_fade_out_on);
            setBuilder(builder);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof KMProject)) {
                return false;
            }
            KMProject kMProject = (KMProject) obj;
            return equals(this.timeline_format_version, kMProject.timeline_format_version) && equals((List<?>) this.primary_items, (List<?>) kMProject.primary_items) && equals((List<?>) this.secondary_items, (List<?>) kMProject.secondary_items) && equals((List<?>) this.bookmarks, (List<?>) kMProject.bookmarks) && equals(this.recent_scroll_time, kMProject.recent_scroll_time) && equals(this.project_ratio, kMProject.project_ratio) && equals(this.project_audio_fade_in_time, kMProject.project_audio_fade_in_time) && equals(this.project_audio_fade_out_time, kMProject.project_audio_fade_out_time) && equals(this.is_project_audio_fade_in_on, kMProject.is_project_audio_fade_in_on) && equals(this.is_project_audio_fade_out_on, kMProject.is_project_audio_fade_out_on) && equals(this.project_video_fade_in_time, kMProject.project_video_fade_in_time) && equals(this.project_video_fade_out_time, kMProject.project_video_fade_out_time) && equals(this.is_project_video_fade_in_on, kMProject.is_project_video_fade_in_on) && equals(this.is_project_video_fade_out_on, kMProject.is_project_video_fade_out_on);
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i == 0) {
                int hashCode = (((this.is_project_video_fade_in_on != null ? this.is_project_video_fade_in_on.hashCode() : 0) + (((this.project_video_fade_out_time != null ? this.project_video_fade_out_time.hashCode() : 0) + (((this.project_video_fade_in_time != null ? this.project_video_fade_in_time.hashCode() : 0) + (((this.is_project_audio_fade_out_on != null ? this.is_project_audio_fade_out_on.hashCode() : 0) + (((this.is_project_audio_fade_in_on != null ? this.is_project_audio_fade_in_on.hashCode() : 0) + (((this.project_audio_fade_out_time != null ? this.project_audio_fade_out_time.hashCode() : 0) + (((this.project_audio_fade_in_time != null ? this.project_audio_fade_in_time.hashCode() : 0) + (((this.project_ratio != null ? this.project_ratio.hashCode() : 0) + (((this.recent_scroll_time != null ? this.recent_scroll_time.hashCode() : 0) + (((((this.secondary_items != null ? this.secondary_items.hashCode() : 1) + (((this.primary_items != null ? this.primary_items.hashCode() : 1) + ((this.timeline_format_version != null ? this.timeline_format_version.hashCode() : 0) * 37)) * 37)) * 37) + (this.bookmarks != null ? this.bookmarks.hashCode() : 1)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37) + (this.is_project_video_fade_out_on != null ? this.is_project_video_fade_out_on.hashCode() : 0);
                this.hashCode = hashCode;
                return hashCode;
            }
            return i;
        }

        /* loaded from: classes.dex */
        public static final class Builder extends Message.a<KMProject> {
            public List<Integer> bookmarks;
            public Boolean is_project_audio_fade_in_on;
            public Boolean is_project_audio_fade_out_on;
            public Boolean is_project_video_fade_in_on;
            public Boolean is_project_video_fade_out_on;
            public List<TimelineItem> primary_items;
            public Float project_audio_fade_in_time;
            public Float project_audio_fade_out_time;
            public AspectRatio project_ratio;
            public Float project_video_fade_in_time;
            public Float project_video_fade_out_time;
            public Integer recent_scroll_time;
            public List<TimelineItem> secondary_items;
            public Integer timeline_format_version;

            public Builder() {
            }

            public Builder(KMProject kMProject) {
                super(kMProject);
                if (kMProject != null) {
                    this.timeline_format_version = kMProject.timeline_format_version;
                    this.primary_items = KMProject.copyOf(kMProject.primary_items);
                    this.secondary_items = KMProject.copyOf(kMProject.secondary_items);
                    this.bookmarks = KMProject.copyOf(kMProject.bookmarks);
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
                }
            }

            public Builder timeline_format_version(Integer num) {
                this.timeline_format_version = num;
                return this;
            }

            public Builder primary_items(List<TimelineItem> list) {
                this.primary_items = checkForNulls(list);
                return this;
            }

            public Builder secondary_items(List<TimelineItem> list) {
                this.secondary_items = checkForNulls(list);
                return this;
            }

            public Builder bookmarks(List<Integer> list) {
                this.bookmarks = checkForNulls(list);
                return this;
            }

            public Builder recent_scroll_time(Integer num) {
                this.recent_scroll_time = num;
                return this;
            }

            public Builder project_ratio(AspectRatio aspectRatio) {
                this.project_ratio = aspectRatio;
                return this;
            }

            public Builder project_audio_fade_in_time(Float f) {
                this.project_audio_fade_in_time = f;
                return this;
            }

            public Builder project_audio_fade_out_time(Float f) {
                this.project_audio_fade_out_time = f;
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

            public Builder project_video_fade_in_time(Float f) {
                this.project_video_fade_in_time = f;
                return this;
            }

            public Builder project_video_fade_out_time(Float f) {
                this.project_video_fade_out_time = f;
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

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.Message.a
            public KMProject build() {
                return new KMProject(this);
            }
        }

        /* loaded from: classes.dex */
        public enum AspectRatio implements m {
            ASPECT_R_16_9(1),
            ASPECT_SQUARE(2);

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
        public enum ClipType implements m {
            VISUAL_CLIP(1),
            TRANSITION(2),
            AUDIO_CLIP(3),
            LAYER_TEXT(4),
            LAYER_STICKER(5),
            LAYER_HANDWRITING(6),
            LAYER_IMAGE(7),
            LAYER_VIDEO(8),
            LAYER_EFFECT(9);

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

        /* loaded from: classes.dex */
        public static final class TimelineItem extends Message {
            private static final long serialVersionUID = 0;

            @n(a = 6)
            public final AudioClip audio_clip;

            @n(a = 3, b = Message.Datatype.ENUM)
            public final ClipType clip_type;

            @n(a = 12)
            public final EffectLayer effect_layer;

            @n(a = 10)
            public final HandwritingLayer handwriting_layer;

            @n(a = 9)
            public final ImageLayer image_layer;

            @n(a = 8)
            public final StickerLayer sticker_layer;

            @n(a = 7)
            public final TextLayer text_layer;

            @n(a = 5)
            public final Transition transition;

            @n(a = 1, b = Message.Datatype.UINT64)
            public final Long unique_id_lsb;

            @n(a = 2, b = Message.Datatype.UINT64)
            public final Long unique_id_msb;

            @n(a = 11)
            public final VideoLayer video_layer;

            @n(a = 4)
            public final VisualClip visual_clip;
            public static final Long DEFAULT_UNIQUE_ID_LSB = 0L;
            public static final Long DEFAULT_UNIQUE_ID_MSB = 0L;
            public static final ClipType DEFAULT_CLIP_TYPE = ClipType.VISUAL_CLIP;

            public TimelineItem(Long l, Long l2, ClipType clipType, VisualClip visualClip, Transition transition, AudioClip audioClip, TextLayer textLayer, StickerLayer stickerLayer, ImageLayer imageLayer, HandwritingLayer handwritingLayer, VideoLayer videoLayer, EffectLayer effectLayer) {
                this.unique_id_lsb = l;
                this.unique_id_msb = l2;
                this.clip_type = clipType;
                this.visual_clip = visualClip;
                this.transition = transition;
                this.audio_clip = audioClip;
                this.text_layer = textLayer;
                this.sticker_layer = stickerLayer;
                this.image_layer = imageLayer;
                this.handwriting_layer = handwritingLayer;
                this.video_layer = videoLayer;
                this.effect_layer = effectLayer;
            }

            private TimelineItem(Builder builder) {
                this(builder.unique_id_lsb, builder.unique_id_msb, builder.clip_type, builder.visual_clip, builder.transition, builder.audio_clip, builder.text_layer, builder.sticker_layer, builder.image_layer, builder.handwriting_layer, builder.video_layer, builder.effect_layer);
                setBuilder(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof TimelineItem)) {
                    return false;
                }
                TimelineItem timelineItem = (TimelineItem) obj;
                return equals(this.unique_id_lsb, timelineItem.unique_id_lsb) && equals(this.unique_id_msb, timelineItem.unique_id_msb) && equals(this.clip_type, timelineItem.clip_type) && equals(this.visual_clip, timelineItem.visual_clip) && equals(this.transition, timelineItem.transition) && equals(this.audio_clip, timelineItem.audio_clip) && equals(this.text_layer, timelineItem.text_layer) && equals(this.sticker_layer, timelineItem.sticker_layer) && equals(this.image_layer, timelineItem.image_layer) && equals(this.handwriting_layer, timelineItem.handwriting_layer) && equals(this.video_layer, timelineItem.video_layer) && equals(this.effect_layer, timelineItem.effect_layer);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i == 0) {
                    int hashCode = (((this.video_layer != null ? this.video_layer.hashCode() : 0) + (((this.handwriting_layer != null ? this.handwriting_layer.hashCode() : 0) + (((this.image_layer != null ? this.image_layer.hashCode() : 0) + (((this.sticker_layer != null ? this.sticker_layer.hashCode() : 0) + (((this.text_layer != null ? this.text_layer.hashCode() : 0) + (((this.audio_clip != null ? this.audio_clip.hashCode() : 0) + (((this.transition != null ? this.transition.hashCode() : 0) + (((this.visual_clip != null ? this.visual_clip.hashCode() : 0) + (((this.clip_type != null ? this.clip_type.hashCode() : 0) + (((this.unique_id_msb != null ? this.unique_id_msb.hashCode() : 0) + ((this.unique_id_lsb != null ? this.unique_id_lsb.hashCode() : 0) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37) + (this.effect_layer != null ? this.effect_layer.hashCode() : 0);
                    this.hashCode = hashCode;
                    return hashCode;
                }
                return i;
            }

            /* loaded from: classes.dex */
            public static final class Builder extends Message.a<TimelineItem> {
                public AudioClip audio_clip;
                public ClipType clip_type;
                public EffectLayer effect_layer;
                public HandwritingLayer handwriting_layer;
                public ImageLayer image_layer;
                public StickerLayer sticker_layer;
                public TextLayer text_layer;
                public Transition transition;
                public Long unique_id_lsb;
                public Long unique_id_msb;
                public VideoLayer video_layer;
                public VisualClip visual_clip;

                public Builder() {
                }

                public Builder(TimelineItem timelineItem) {
                    super(timelineItem);
                    if (timelineItem != null) {
                        this.unique_id_lsb = timelineItem.unique_id_lsb;
                        this.unique_id_msb = timelineItem.unique_id_msb;
                        this.clip_type = timelineItem.clip_type;
                        this.visual_clip = timelineItem.visual_clip;
                        this.transition = timelineItem.transition;
                        this.audio_clip = timelineItem.audio_clip;
                        this.text_layer = timelineItem.text_layer;
                        this.sticker_layer = timelineItem.sticker_layer;
                        this.image_layer = timelineItem.image_layer;
                        this.handwriting_layer = timelineItem.handwriting_layer;
                        this.video_layer = timelineItem.video_layer;
                        this.effect_layer = timelineItem.effect_layer;
                    }
                }

                public Builder unique_id_lsb(Long l) {
                    this.unique_id_lsb = l;
                    return this;
                }

                public Builder unique_id_msb(Long l) {
                    this.unique_id_msb = l;
                    return this;
                }

                public Builder clip_type(ClipType clipType) {
                    this.clip_type = clipType;
                    return this;
                }

                public Builder visual_clip(VisualClip visualClip) {
                    this.visual_clip = visualClip;
                    return this;
                }

                public Builder transition(Transition transition) {
                    this.transition = transition;
                    return this;
                }

                public Builder audio_clip(AudioClip audioClip) {
                    this.audio_clip = audioClip;
                    return this;
                }

                public Builder text_layer(TextLayer textLayer) {
                    this.text_layer = textLayer;
                    return this;
                }

                public Builder sticker_layer(StickerLayer stickerLayer) {
                    this.sticker_layer = stickerLayer;
                    return this;
                }

                public Builder image_layer(ImageLayer imageLayer) {
                    this.image_layer = imageLayer;
                    return this;
                }

                public Builder handwriting_layer(HandwritingLayer handwritingLayer) {
                    this.handwriting_layer = handwritingLayer;
                    return this;
                }

                public Builder video_layer(VideoLayer videoLayer) {
                    this.video_layer = videoLayer;
                    return this;
                }

                public Builder effect_layer(EffectLayer effectLayer) {
                    this.effect_layer = effectLayer;
                    return this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.Message.a
                public TimelineItem build() {
                    return new TimelineItem(this);
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class VisualClip extends Message {
            public static final String DEFAULT_CAPTURE_FILENAME = "";
            public static final String DEFAULT_MEDIA_MSID = "";
            public static final String DEFAULT_MEDIA_PATH = "";
            public static final String DEFAULT_THUMB_PATH = "";
            public static final String DEFAULT_TITLE_EFFECT_ID = "";
            private static final long serialVersionUID = 0;

            @n(a = 107, b = Message.Datatype.BOOL)
            public final Boolean abstract_crop;

            @n(a = 136, b = Message.Datatype.INT32)
            public final Integer audio_duration;

            @n(a = 164, b = Message.Datatype.ENUM)
            public final ThemeEffectType auto_theme_effect;

            @n(a = 156, b = Message.Datatype.INT32)
            public final Integer brightness;

            @n(a = 105, b = Message.Datatype.STRING)
            public final String capture_filename;

            @n(a = 173, b = Message.Datatype.ENUM)
            public final ClipState clip_state;

            @n(a = 144, b = Message.Datatype.INT32)
            public final Integer clip_volume;

            @n(a = 167, b = Message.Datatype.FLOAT)
            public final Float clip_width;

            @n(a = 169)
            public final ColorEffect color_effect;

            @n(a = 182, b = Message.Datatype.INT32)
            public final Integer compressor;

            @n(a = 157, b = Message.Datatype.INT32)
            public final Integer contrast;

            @n(a = 175, b = Message.Datatype.BOOL)
            public final Boolean crop_link;

            @n(a = 127, b = Message.Datatype.INT32)
            public final Integer diff_av_duration;

            @n(a = 135, b = Message.Datatype.INT32)
            public final Integer duration;

            @n(a = 161, b = Message.Datatype.INT32)
            public final Integer effect_end_time;

            @n(a = 170)
            public final StringHashMap effect_options;

            @n(a = 160, b = Message.Datatype.INT32)
            public final Integer effect_start_time;

            @n(a = 163)
            public final Matrix end_matrix;

            @n(a = 139, b = Message.Datatype.INT32)
            public final Integer end_overlap;

            @n(a = 113, b = Message.Datatype.INT32)
            public final Integer end_position_bottom;

            @n(a = 112, b = Message.Datatype.INT32)
            public final Integer end_position_left;

            @n(a = 114, b = Message.Datatype.INT32)
            public final Integer end_position_right;

            @n(a = 115, b = Message.Datatype.INT32)
            public final Integer end_position_top;

            @n(a = 106, b = Message.Datatype.INT32)
            public final Integer engine_clip_id;

            @n(a = 103, b = Message.Datatype.FLOAT)
            public final Float face_bounds_bottom;

            @n(a = 100, b = Message.Datatype.FLOAT)
            public final Float face_bounds_left;

            @n(a = 102, b = Message.Datatype.FLOAT)
            public final Float face_bounds_right;

            @n(a = 104, b = Message.Datatype.BOOL)
            public final Boolean face_bounds_set;

            @n(a = 101, b = Message.Datatype.FLOAT)
            public final Float face_bounds_top;

            @n(a = 125, b = Message.Datatype.BOOL)
            public final Boolean fliph;

            @n(a = 126, b = Message.Datatype.BOOL)
            public final Boolean flipv;

            @n(a = 150, b = Message.Datatype.BOOL)
            public final Boolean has_audio;

            @n(a = 151, b = Message.Datatype.BOOL)
            public final Boolean has_video;

            @n(a = 141, b = Message.Datatype.INT32)
            public final Integer height;

            @n(a = 147, b = Message.Datatype.BOOL)
            public final Boolean is_image;

            @n(a = 177, b = Message.Datatype.BOOL)
            public final Boolean is_reverse;

            @n(a = 174, b = Message.Datatype.STRING)
            public final String media_msid;

            @n(a = 153, b = Message.Datatype.STRING)
            public final String media_path;

            @n(a = 145, b = Message.Datatype.INT32)
            public final Integer music_volume;

            @n(a = 148, b = Message.Datatype.BOOL)
            public final Boolean mute_audio;

            @n(a = 149, b = Message.Datatype.BOOL)
            public final Boolean mute_music;

            @n(a = 143, b = Message.Datatype.INT32)
            public final Integer original_height;

            @n(a = 142, b = Message.Datatype.INT32)
            public final Integer original_width;

            @n(a = 180, b = Message.Datatype.INT32)
            public final Integer pan_left;

            @n(a = 181, b = Message.Datatype.INT32)
            public final Integer pan_right;

            @n(a = 183, b = Message.Datatype.INT32)
            public final Integer pitch_factor;

            @n(a = 168, b = Message.Datatype.INT32)
            public final Integer playback_speed;

            @n(a = 131, b = Message.Datatype.INT32)
            public final Integer pre_trimmed_duration;

            @n(a = 121, b = Message.Datatype.INT32)
            public final Integer rotated_end_position_bottom;

            @n(a = 120, b = Message.Datatype.INT32)
            public final Integer rotated_end_position_left;

            @n(a = 122, b = Message.Datatype.INT32)
            public final Integer rotated_end_position_right;

            @n(a = 123, b = Message.Datatype.INT32)
            public final Integer rotated_end_position_top;

            @n(a = 117, b = Message.Datatype.INT32)
            public final Integer rotated_start_position_bottom;

            @n(a = 116, b = Message.Datatype.INT32)
            public final Integer rotated_start_position_left;

            @n(a = 118, b = Message.Datatype.INT32)
            public final Integer rotated_start_position_right;

            @n(a = 119, b = Message.Datatype.INT32)
            public final Integer rotated_start_position_top;

            @n(a = 124, b = Message.Datatype.INT32)
            public final Integer rotation;

            @n(a = 158, b = Message.Datatype.INT32)
            public final Integer saturation;

            @n(a = 162)
            public final Matrix start_matrix;

            @n(a = 138, b = Message.Datatype.INT32)
            public final Integer start_overlap;

            @n(a = 109, b = Message.Datatype.INT32)
            public final Integer start_position_bottom;

            @n(a = 108, b = Message.Datatype.INT32)
            public final Integer start_position_left;

            @n(a = 110, b = Message.Datatype.INT32)
            public final Integer start_position_right;

            @n(a = 111, b = Message.Datatype.INT32)
            public final Integer start_position_top;

            @n(a = 152, b = Message.Datatype.STRING)
            public final String thumb_path;

            @n(a = 159, b = Message.Datatype.INT32)
            public final Integer tintcolor;

            @n(a = 132, b = Message.Datatype.STRING)
            public final String title_effect_id;

            @n(a = 134, b = Message.Datatype.INT32)
            public final Integer title_end_time;

            @n(a = 133, b = Message.Datatype.INT32)
            public final Integer title_start_time;

            @n(a = 146, b = Message.Datatype.ENUM)
            public final TitleStyle title_style;

            @n(a = 172, b = Message.Datatype.BOOL)
            public final Boolean transcode_approved;

            @n(a = 154, b = Message.Datatype.UINT64)
            public final Long transition_item_uuid_lsb;

            @n(a = 155, b = Message.Datatype.UINT64)
            public final Long transition_item_uuid_msb;

            @n(a = 129, b = Message.Datatype.INT32)
            public final Integer trim_time_end;

            @n(a = 128, b = Message.Datatype.INT32)
            public final Integer trim_time_start;

            @n(a = 130, b = Message.Datatype.INT32)
            public final Integer trimmed_duration;

            @n(a = 171)
            public final TimelineItem unattached_transition;

            @n(a = 137, b = Message.Datatype.INT32)
            public final Integer video_duration;

            @n(a = 179, b = Message.Datatype.BOOL)
            public final Boolean vignette;

            @n(a = 178, b = Message.Datatype.INT32)
            public final Integer voice_changer;

            @n(a = 166, b = Message.Datatype.INT32, c = Message.Label.PACKED)
            public final List<Integer> volume_envelope_level;

            @n(a = 165, b = Message.Datatype.INT32, c = Message.Label.PACKED)
            public final List<Integer> volume_envelope_time;

            @n(a = 140, b = Message.Datatype.INT32)
            public final Integer width;
            public static final Float DEFAULT_FACE_BOUNDS_LEFT = Float.valueOf(0.0f);
            public static final Float DEFAULT_FACE_BOUNDS_TOP = Float.valueOf(0.0f);
            public static final Float DEFAULT_FACE_BOUNDS_RIGHT = Float.valueOf(0.0f);
            public static final Float DEFAULT_FACE_BOUNDS_BOTTOM = Float.valueOf(0.0f);
            public static final Boolean DEFAULT_FACE_BOUNDS_SET = false;
            public static final Integer DEFAULT_ENGINE_CLIP_ID = 0;
            public static final Boolean DEFAULT_ABSTRACT_CROP = false;
            public static final Integer DEFAULT_START_POSITION_LEFT = 0;
            public static final Integer DEFAULT_START_POSITION_BOTTOM = 0;
            public static final Integer DEFAULT_START_POSITION_RIGHT = 0;
            public static final Integer DEFAULT_START_POSITION_TOP = 0;
            public static final Integer DEFAULT_END_POSITION_LEFT = 0;
            public static final Integer DEFAULT_END_POSITION_BOTTOM = 0;
            public static final Integer DEFAULT_END_POSITION_RIGHT = 0;
            public static final Integer DEFAULT_END_POSITION_TOP = 0;
            public static final Integer DEFAULT_ROTATED_START_POSITION_LEFT = 0;
            public static final Integer DEFAULT_ROTATED_START_POSITION_BOTTOM = 0;
            public static final Integer DEFAULT_ROTATED_START_POSITION_RIGHT = 0;
            public static final Integer DEFAULT_ROTATED_START_POSITION_TOP = 0;
            public static final Integer DEFAULT_ROTATED_END_POSITION_LEFT = 0;
            public static final Integer DEFAULT_ROTATED_END_POSITION_BOTTOM = 0;
            public static final Integer DEFAULT_ROTATED_END_POSITION_RIGHT = 0;
            public static final Integer DEFAULT_ROTATED_END_POSITION_TOP = 0;
            public static final Integer DEFAULT_ROTATION = 0;
            public static final Boolean DEFAULT_FLIPH = false;
            public static final Boolean DEFAULT_FLIPV = false;
            public static final Integer DEFAULT_DIFF_AV_DURATION = 0;
            public static final Integer DEFAULT_TRIM_TIME_START = 0;
            public static final Integer DEFAULT_TRIM_TIME_END = 0;
            public static final Integer DEFAULT_TRIMMED_DURATION = 0;
            public static final Integer DEFAULT_PRE_TRIMMED_DURATION = 0;
            public static final Integer DEFAULT_TITLE_START_TIME = 0;
            public static final Integer DEFAULT_TITLE_END_TIME = 0;
            public static final Integer DEFAULT_DURATION = 0;
            public static final Integer DEFAULT_AUDIO_DURATION = 0;
            public static final Integer DEFAULT_VIDEO_DURATION = 0;
            public static final Integer DEFAULT_START_OVERLAP = 0;
            public static final Integer DEFAULT_END_OVERLAP = 0;
            public static final Integer DEFAULT_WIDTH = 0;
            public static final Integer DEFAULT_HEIGHT = 0;
            public static final Integer DEFAULT_ORIGINAL_WIDTH = 0;
            public static final Integer DEFAULT_ORIGINAL_HEIGHT = 0;
            public static final Integer DEFAULT_CLIP_VOLUME = 0;
            public static final Integer DEFAULT_MUSIC_VOLUME = 0;
            public static final TitleStyle DEFAULT_TITLE_STYLE = TitleStyle.TITLE_STYLE_NONE;
            public static final Boolean DEFAULT_IS_IMAGE = false;
            public static final Boolean DEFAULT_MUTE_AUDIO = false;
            public static final Boolean DEFAULT_MUTE_MUSIC = false;
            public static final Boolean DEFAULT_HAS_AUDIO = false;
            public static final Boolean DEFAULT_HAS_VIDEO = false;
            public static final Long DEFAULT_TRANSITION_ITEM_UUID_LSB = 0L;
            public static final Long DEFAULT_TRANSITION_ITEM_UUID_MSB = 0L;
            public static final Integer DEFAULT_BRIGHTNESS = 0;
            public static final Integer DEFAULT_CONTRAST = 0;
            public static final Integer DEFAULT_SATURATION = 0;
            public static final Integer DEFAULT_TINTCOLOR = 0;
            public static final Integer DEFAULT_EFFECT_START_TIME = 0;
            public static final Integer DEFAULT_EFFECT_END_TIME = 0;
            public static final ThemeEffectType DEFAULT_AUTO_THEME_EFFECT = ThemeEffectType.THEME_EFFECT_TYPE_OPENING;
            public static final List<Integer> DEFAULT_VOLUME_ENVELOPE_TIME = Collections.emptyList();
            public static final List<Integer> DEFAULT_VOLUME_ENVELOPE_LEVEL = Collections.emptyList();
            public static final Float DEFAULT_CLIP_WIDTH = Float.valueOf(0.0f);
            public static final Integer DEFAULT_PLAYBACK_SPEED = 0;
            public static final Boolean DEFAULT_TRANSCODE_APPROVED = false;
            public static final ClipState DEFAULT_CLIP_STATE = ClipState.BUSY;
            public static final Boolean DEFAULT_CROP_LINK = false;
            public static final Boolean DEFAULT_IS_REVERSE = false;
            public static final Integer DEFAULT_VOICE_CHANGER = 0;
            public static final Boolean DEFAULT_VIGNETTE = false;
            public static final Integer DEFAULT_PAN_LEFT = 0;
            public static final Integer DEFAULT_PAN_RIGHT = 0;
            public static final Integer DEFAULT_COMPRESSOR = 0;
            public static final Integer DEFAULT_PITCH_FACTOR = 0;

            public VisualClip(String str, Float f, Float f2, Float f3, Float f4, Boolean bool, String str2, Integer num, Boolean bool2, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18, Boolean bool3, Boolean bool4, Integer num19, Integer num20, Integer num21, Integer num22, Integer num23, String str3, Integer num24, Integer num25, Integer num26, Integer num27, Integer num28, Integer num29, Integer num30, Integer num31, Integer num32, Integer num33, Integer num34, Integer num35, Integer num36, TitleStyle titleStyle, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, String str4, Long l, Long l2, TimelineItem timelineItem, Integer num37, Integer num38, Integer num39, Integer num40, Integer num41, Integer num42, Matrix matrix, Matrix matrix2, ThemeEffectType themeEffectType, List<Integer> list, List<Integer> list2, Float f5, Integer num43, ColorEffect colorEffect, StringHashMap stringHashMap, String str5, Boolean bool10, ClipState clipState, Boolean bool11, Boolean bool12, Integer num44, Boolean bool13, Integer num45, Integer num46, Integer num47, Integer num48) {
                this.media_path = str;
                this.face_bounds_left = f;
                this.face_bounds_top = f2;
                this.face_bounds_right = f3;
                this.face_bounds_bottom = f4;
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
                this.volume_envelope_time = immutableCopyOf(list);
                this.volume_envelope_level = immutableCopyOf(list2);
                this.clip_width = f5;
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
            }

            private VisualClip(Builder builder) {
                this(builder.media_path, builder.face_bounds_left, builder.face_bounds_top, builder.face_bounds_right, builder.face_bounds_bottom, builder.face_bounds_set, builder.capture_filename, builder.engine_clip_id, builder.abstract_crop, builder.start_position_left, builder.start_position_bottom, builder.start_position_right, builder.start_position_top, builder.end_position_left, builder.end_position_bottom, builder.end_position_right, builder.end_position_top, builder.rotated_start_position_left, builder.rotated_start_position_bottom, builder.rotated_start_position_right, builder.rotated_start_position_top, builder.rotated_end_position_left, builder.rotated_end_position_bottom, builder.rotated_end_position_right, builder.rotated_end_position_top, builder.rotation, builder.fliph, builder.flipv, builder.diff_av_duration, builder.trim_time_start, builder.trim_time_end, builder.trimmed_duration, builder.pre_trimmed_duration, builder.title_effect_id, builder.title_start_time, builder.title_end_time, builder.duration, builder.audio_duration, builder.video_duration, builder.start_overlap, builder.end_overlap, builder.width, builder.height, builder.original_width, builder.original_height, builder.clip_volume, builder.music_volume, builder.title_style, builder.is_image, builder.mute_audio, builder.mute_music, builder.has_audio, builder.has_video, builder.thumb_path, builder.transition_item_uuid_lsb, builder.transition_item_uuid_msb, builder.unattached_transition, builder.brightness, builder.contrast, builder.saturation, builder.tintcolor, builder.effect_start_time, builder.effect_end_time, builder.start_matrix, builder.end_matrix, builder.auto_theme_effect, builder.volume_envelope_time, builder.volume_envelope_level, builder.clip_width, builder.playback_speed, builder.color_effect, builder.effect_options, builder.media_msid, builder.transcode_approved, builder.clip_state, builder.crop_link, builder.is_reverse, builder.voice_changer, builder.vignette, builder.pan_left, builder.pan_right, builder.compressor, builder.pitch_factor);
                setBuilder(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof VisualClip)) {
                    return false;
                }
                VisualClip visualClip = (VisualClip) obj;
                return equals(this.media_path, visualClip.media_path) && equals(this.face_bounds_left, visualClip.face_bounds_left) && equals(this.face_bounds_top, visualClip.face_bounds_top) && equals(this.face_bounds_right, visualClip.face_bounds_right) && equals(this.face_bounds_bottom, visualClip.face_bounds_bottom) && equals(this.face_bounds_set, visualClip.face_bounds_set) && equals(this.capture_filename, visualClip.capture_filename) && equals(this.engine_clip_id, visualClip.engine_clip_id) && equals(this.abstract_crop, visualClip.abstract_crop) && equals(this.start_position_left, visualClip.start_position_left) && equals(this.start_position_bottom, visualClip.start_position_bottom) && equals(this.start_position_right, visualClip.start_position_right) && equals(this.start_position_top, visualClip.start_position_top) && equals(this.end_position_left, visualClip.end_position_left) && equals(this.end_position_bottom, visualClip.end_position_bottom) && equals(this.end_position_right, visualClip.end_position_right) && equals(this.end_position_top, visualClip.end_position_top) && equals(this.rotated_start_position_left, visualClip.rotated_start_position_left) && equals(this.rotated_start_position_bottom, visualClip.rotated_start_position_bottom) && equals(this.rotated_start_position_right, visualClip.rotated_start_position_right) && equals(this.rotated_start_position_top, visualClip.rotated_start_position_top) && equals(this.rotated_end_position_left, visualClip.rotated_end_position_left) && equals(this.rotated_end_position_bottom, visualClip.rotated_end_position_bottom) && equals(this.rotated_end_position_right, visualClip.rotated_end_position_right) && equals(this.rotated_end_position_top, visualClip.rotated_end_position_top) && equals(this.rotation, visualClip.rotation) && equals(this.fliph, visualClip.fliph) && equals(this.flipv, visualClip.flipv) && equals(this.diff_av_duration, visualClip.diff_av_duration) && equals(this.trim_time_start, visualClip.trim_time_start) && equals(this.trim_time_end, visualClip.trim_time_end) && equals(this.trimmed_duration, visualClip.trimmed_duration) && equals(this.pre_trimmed_duration, visualClip.pre_trimmed_duration) && equals(this.title_effect_id, visualClip.title_effect_id) && equals(this.title_start_time, visualClip.title_start_time) && equals(this.title_end_time, visualClip.title_end_time) && equals(this.duration, visualClip.duration) && equals(this.audio_duration, visualClip.audio_duration) && equals(this.video_duration, visualClip.video_duration) && equals(this.start_overlap, visualClip.start_overlap) && equals(this.end_overlap, visualClip.end_overlap) && equals(this.width, visualClip.width) && equals(this.height, visualClip.height) && equals(this.original_width, visualClip.original_width) && equals(this.original_height, visualClip.original_height) && equals(this.clip_volume, visualClip.clip_volume) && equals(this.music_volume, visualClip.music_volume) && equals(this.title_style, visualClip.title_style) && equals(this.is_image, visualClip.is_image) && equals(this.mute_audio, visualClip.mute_audio) && equals(this.mute_music, visualClip.mute_music) && equals(this.has_audio, visualClip.has_audio) && equals(this.has_video, visualClip.has_video) && equals(this.thumb_path, visualClip.thumb_path) && equals(this.transition_item_uuid_lsb, visualClip.transition_item_uuid_lsb) && equals(this.transition_item_uuid_msb, visualClip.transition_item_uuid_msb) && equals(this.unattached_transition, visualClip.unattached_transition) && equals(this.brightness, visualClip.brightness) && equals(this.contrast, visualClip.contrast) && equals(this.saturation, visualClip.saturation) && equals(this.tintcolor, visualClip.tintcolor) && equals(this.effect_start_time, visualClip.effect_start_time) && equals(this.effect_end_time, visualClip.effect_end_time) && equals(this.start_matrix, visualClip.start_matrix) && equals(this.end_matrix, visualClip.end_matrix) && equals(this.auto_theme_effect, visualClip.auto_theme_effect) && equals((List<?>) this.volume_envelope_time, (List<?>) visualClip.volume_envelope_time) && equals((List<?>) this.volume_envelope_level, (List<?>) visualClip.volume_envelope_level) && equals(this.clip_width, visualClip.clip_width) && equals(this.playback_speed, visualClip.playback_speed) && equals(this.color_effect, visualClip.color_effect) && equals(this.effect_options, visualClip.effect_options) && equals(this.media_msid, visualClip.media_msid) && equals(this.transcode_approved, visualClip.transcode_approved) && equals(this.clip_state, visualClip.clip_state) && equals(this.crop_link, visualClip.crop_link) && equals(this.is_reverse, visualClip.is_reverse) && equals(this.voice_changer, visualClip.voice_changer) && equals(this.vignette, visualClip.vignette) && equals(this.pan_left, visualClip.pan_left) && equals(this.pan_right, visualClip.pan_right) && equals(this.compressor, visualClip.compressor) && equals(this.pitch_factor, visualClip.pitch_factor);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i == 0) {
                    int hashCode = (((this.compressor != null ? this.compressor.hashCode() : 0) + (((this.pan_right != null ? this.pan_right.hashCode() : 0) + (((this.pan_left != null ? this.pan_left.hashCode() : 0) + (((this.vignette != null ? this.vignette.hashCode() : 0) + (((this.voice_changer != null ? this.voice_changer.hashCode() : 0) + (((this.is_reverse != null ? this.is_reverse.hashCode() : 0) + (((this.crop_link != null ? this.crop_link.hashCode() : 0) + (((this.clip_state != null ? this.clip_state.hashCode() : 0) + (((this.transcode_approved != null ? this.transcode_approved.hashCode() : 0) + (((this.media_msid != null ? this.media_msid.hashCode() : 0) + (((this.effect_options != null ? this.effect_options.hashCode() : 0) + (((this.color_effect != null ? this.color_effect.hashCode() : 0) + (((this.playback_speed != null ? this.playback_speed.hashCode() : 0) + (((this.clip_width != null ? this.clip_width.hashCode() : 0) + (((((this.volume_envelope_time != null ? this.volume_envelope_time.hashCode() : 1) + (((this.auto_theme_effect != null ? this.auto_theme_effect.hashCode() : 0) + (((this.end_matrix != null ? this.end_matrix.hashCode() : 0) + (((this.start_matrix != null ? this.start_matrix.hashCode() : 0) + (((this.effect_end_time != null ? this.effect_end_time.hashCode() : 0) + (((this.effect_start_time != null ? this.effect_start_time.hashCode() : 0) + (((this.tintcolor != null ? this.tintcolor.hashCode() : 0) + (((this.saturation != null ? this.saturation.hashCode() : 0) + (((this.contrast != null ? this.contrast.hashCode() : 0) + (((this.brightness != null ? this.brightness.hashCode() : 0) + (((this.unattached_transition != null ? this.unattached_transition.hashCode() : 0) + (((this.transition_item_uuid_msb != null ? this.transition_item_uuid_msb.hashCode() : 0) + (((this.transition_item_uuid_lsb != null ? this.transition_item_uuid_lsb.hashCode() : 0) + (((this.thumb_path != null ? this.thumb_path.hashCode() : 0) + (((this.has_video != null ? this.has_video.hashCode() : 0) + (((this.has_audio != null ? this.has_audio.hashCode() : 0) + (((this.mute_music != null ? this.mute_music.hashCode() : 0) + (((this.mute_audio != null ? this.mute_audio.hashCode() : 0) + (((this.is_image != null ? this.is_image.hashCode() : 0) + (((this.title_style != null ? this.title_style.hashCode() : 0) + (((this.music_volume != null ? this.music_volume.hashCode() : 0) + (((this.clip_volume != null ? this.clip_volume.hashCode() : 0) + (((this.original_height != null ? this.original_height.hashCode() : 0) + (((this.original_width != null ? this.original_width.hashCode() : 0) + (((this.height != null ? this.height.hashCode() : 0) + (((this.width != null ? this.width.hashCode() : 0) + (((this.end_overlap != null ? this.end_overlap.hashCode() : 0) + (((this.start_overlap != null ? this.start_overlap.hashCode() : 0) + (((this.video_duration != null ? this.video_duration.hashCode() : 0) + (((this.audio_duration != null ? this.audio_duration.hashCode() : 0) + (((this.duration != null ? this.duration.hashCode() : 0) + (((this.title_end_time != null ? this.title_end_time.hashCode() : 0) + (((this.title_start_time != null ? this.title_start_time.hashCode() : 0) + (((this.title_effect_id != null ? this.title_effect_id.hashCode() : 0) + (((this.pre_trimmed_duration != null ? this.pre_trimmed_duration.hashCode() : 0) + (((this.trimmed_duration != null ? this.trimmed_duration.hashCode() : 0) + (((this.trim_time_end != null ? this.trim_time_end.hashCode() : 0) + (((this.trim_time_start != null ? this.trim_time_start.hashCode() : 0) + (((this.diff_av_duration != null ? this.diff_av_duration.hashCode() : 0) + (((this.flipv != null ? this.flipv.hashCode() : 0) + (((this.fliph != null ? this.fliph.hashCode() : 0) + (((this.rotation != null ? this.rotation.hashCode() : 0) + (((this.rotated_end_position_top != null ? this.rotated_end_position_top.hashCode() : 0) + (((this.rotated_end_position_right != null ? this.rotated_end_position_right.hashCode() : 0) + (((this.rotated_end_position_bottom != null ? this.rotated_end_position_bottom.hashCode() : 0) + (((this.rotated_end_position_left != null ? this.rotated_end_position_left.hashCode() : 0) + (((this.rotated_start_position_top != null ? this.rotated_start_position_top.hashCode() : 0) + (((this.rotated_start_position_right != null ? this.rotated_start_position_right.hashCode() : 0) + (((this.rotated_start_position_bottom != null ? this.rotated_start_position_bottom.hashCode() : 0) + (((this.rotated_start_position_left != null ? this.rotated_start_position_left.hashCode() : 0) + (((this.end_position_top != null ? this.end_position_top.hashCode() : 0) + (((this.end_position_right != null ? this.end_position_right.hashCode() : 0) + (((this.end_position_bottom != null ? this.end_position_bottom.hashCode() : 0) + (((this.end_position_left != null ? this.end_position_left.hashCode() : 0) + (((this.start_position_top != null ? this.start_position_top.hashCode() : 0) + (((this.start_position_right != null ? this.start_position_right.hashCode() : 0) + (((this.start_position_bottom != null ? this.start_position_bottom.hashCode() : 0) + (((this.start_position_left != null ? this.start_position_left.hashCode() : 0) + (((this.abstract_crop != null ? this.abstract_crop.hashCode() : 0) + (((this.engine_clip_id != null ? this.engine_clip_id.hashCode() : 0) + (((this.capture_filename != null ? this.capture_filename.hashCode() : 0) + (((this.face_bounds_set != null ? this.face_bounds_set.hashCode() : 0) + (((this.face_bounds_bottom != null ? this.face_bounds_bottom.hashCode() : 0) + (((this.face_bounds_right != null ? this.face_bounds_right.hashCode() : 0) + (((this.face_bounds_top != null ? this.face_bounds_top.hashCode() : 0) + (((this.face_bounds_left != null ? this.face_bounds_left.hashCode() : 0) + ((this.media_path != null ? this.media_path.hashCode() : 0) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37) + (this.volume_envelope_level != null ? this.volume_envelope_level.hashCode() : 1)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37) + (this.pitch_factor != null ? this.pitch_factor.hashCode() : 0);
                    this.hashCode = hashCode;
                    return hashCode;
                }
                return i;
            }

            /* loaded from: classes.dex */
            public static final class Builder extends Message.a<VisualClip> {
                public Boolean abstract_crop;
                public Integer audio_duration;
                public ThemeEffectType auto_theme_effect;
                public Integer brightness;
                public String capture_filename;
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
                public Boolean is_image;
                public Boolean is_reverse;
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
                public Integer video_duration;
                public Boolean vignette;
                public Integer voice_changer;
                public List<Integer> volume_envelope_level;
                public List<Integer> volume_envelope_time;
                public Integer width;

                public Builder() {
                }

                public Builder(VisualClip visualClip) {
                    super(visualClip);
                    if (visualClip != null) {
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
                        this.volume_envelope_time = VisualClip.copyOf(visualClip.volume_envelope_time);
                        this.volume_envelope_level = VisualClip.copyOf(visualClip.volume_envelope_level);
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
                    }
                }

                public Builder media_path(String str) {
                    this.media_path = str;
                    return this;
                }

                public Builder face_bounds_left(Float f) {
                    this.face_bounds_left = f;
                    return this;
                }

                public Builder face_bounds_top(Float f) {
                    this.face_bounds_top = f;
                    return this;
                }

                public Builder face_bounds_right(Float f) {
                    this.face_bounds_right = f;
                    return this;
                }

                public Builder face_bounds_bottom(Float f) {
                    this.face_bounds_bottom = f;
                    return this;
                }

                public Builder face_bounds_set(Boolean bool) {
                    this.face_bounds_set = bool;
                    return this;
                }

                public Builder capture_filename(String str) {
                    this.capture_filename = str;
                    return this;
                }

                public Builder engine_clip_id(Integer num) {
                    this.engine_clip_id = num;
                    return this;
                }

                public Builder abstract_crop(Boolean bool) {
                    this.abstract_crop = bool;
                    return this;
                }

                public Builder start_position_left(Integer num) {
                    this.start_position_left = num;
                    return this;
                }

                public Builder start_position_bottom(Integer num) {
                    this.start_position_bottom = num;
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

                public Builder end_position_left(Integer num) {
                    this.end_position_left = num;
                    return this;
                }

                public Builder end_position_bottom(Integer num) {
                    this.end_position_bottom = num;
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

                public Builder rotated_start_position_left(Integer num) {
                    this.rotated_start_position_left = num;
                    return this;
                }

                public Builder rotated_start_position_bottom(Integer num) {
                    this.rotated_start_position_bottom = num;
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

                public Builder rotated_end_position_left(Integer num) {
                    this.rotated_end_position_left = num;
                    return this;
                }

                public Builder rotated_end_position_bottom(Integer num) {
                    this.rotated_end_position_bottom = num;
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

                public Builder rotation(Integer num) {
                    this.rotation = num;
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

                public Builder diff_av_duration(Integer num) {
                    this.diff_av_duration = num;
                    return this;
                }

                public Builder trim_time_start(Integer num) {
                    this.trim_time_start = num;
                    return this;
                }

                public Builder trim_time_end(Integer num) {
                    this.trim_time_end = num;
                    return this;
                }

                public Builder trimmed_duration(Integer num) {
                    this.trimmed_duration = num;
                    return this;
                }

                public Builder pre_trimmed_duration(Integer num) {
                    this.pre_trimmed_duration = num;
                    return this;
                }

                public Builder title_effect_id(String str) {
                    this.title_effect_id = str;
                    return this;
                }

                public Builder title_start_time(Integer num) {
                    this.title_start_time = num;
                    return this;
                }

                public Builder title_end_time(Integer num) {
                    this.title_end_time = num;
                    return this;
                }

                public Builder duration(Integer num) {
                    this.duration = num;
                    return this;
                }

                public Builder audio_duration(Integer num) {
                    this.audio_duration = num;
                    return this;
                }

                public Builder video_duration(Integer num) {
                    this.video_duration = num;
                    return this;
                }

                public Builder start_overlap(Integer num) {
                    this.start_overlap = num;
                    return this;
                }

                public Builder end_overlap(Integer num) {
                    this.end_overlap = num;
                    return this;
                }

                public Builder width(Integer num) {
                    this.width = num;
                    return this;
                }

                public Builder height(Integer num) {
                    this.height = num;
                    return this;
                }

                public Builder original_width(Integer num) {
                    this.original_width = num;
                    return this;
                }

                public Builder original_height(Integer num) {
                    this.original_height = num;
                    return this;
                }

                public Builder clip_volume(Integer num) {
                    this.clip_volume = num;
                    return this;
                }

                public Builder music_volume(Integer num) {
                    this.music_volume = num;
                    return this;
                }

                public Builder title_style(TitleStyle titleStyle) {
                    this.title_style = titleStyle;
                    return this;
                }

                public Builder is_image(Boolean bool) {
                    this.is_image = bool;
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

                public Builder has_audio(Boolean bool) {
                    this.has_audio = bool;
                    return this;
                }

                public Builder has_video(Boolean bool) {
                    this.has_video = bool;
                    return this;
                }

                public Builder thumb_path(String str) {
                    this.thumb_path = str;
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

                public Builder unattached_transition(TimelineItem timelineItem) {
                    this.unattached_transition = timelineItem;
                    return this;
                }

                public Builder brightness(Integer num) {
                    this.brightness = num;
                    return this;
                }

                public Builder contrast(Integer num) {
                    this.contrast = num;
                    return this;
                }

                public Builder saturation(Integer num) {
                    this.saturation = num;
                    return this;
                }

                public Builder tintcolor(Integer num) {
                    this.tintcolor = num;
                    return this;
                }

                public Builder effect_start_time(Integer num) {
                    this.effect_start_time = num;
                    return this;
                }

                public Builder effect_end_time(Integer num) {
                    this.effect_end_time = num;
                    return this;
                }

                public Builder start_matrix(Matrix matrix) {
                    this.start_matrix = matrix;
                    return this;
                }

                public Builder end_matrix(Matrix matrix) {
                    this.end_matrix = matrix;
                    return this;
                }

                public Builder auto_theme_effect(ThemeEffectType themeEffectType) {
                    this.auto_theme_effect = themeEffectType;
                    return this;
                }

                public Builder volume_envelope_time(List<Integer> list) {
                    this.volume_envelope_time = checkForNulls(list);
                    return this;
                }

                public Builder volume_envelope_level(List<Integer> list) {
                    this.volume_envelope_level = checkForNulls(list);
                    return this;
                }

                public Builder clip_width(Float f) {
                    this.clip_width = f;
                    return this;
                }

                public Builder playback_speed(Integer num) {
                    this.playback_speed = num;
                    return this;
                }

                public Builder color_effect(ColorEffect colorEffect) {
                    this.color_effect = colorEffect;
                    return this;
                }

                public Builder effect_options(StringHashMap stringHashMap) {
                    this.effect_options = stringHashMap;
                    return this;
                }

                public Builder media_msid(String str) {
                    this.media_msid = str;
                    return this;
                }

                public Builder transcode_approved(Boolean bool) {
                    this.transcode_approved = bool;
                    return this;
                }

                public Builder clip_state(ClipState clipState) {
                    this.clip_state = clipState;
                    return this;
                }

                public Builder crop_link(Boolean bool) {
                    this.crop_link = bool;
                    return this;
                }

                public Builder is_reverse(Boolean bool) {
                    this.is_reverse = bool;
                    return this;
                }

                public Builder voice_changer(Integer num) {
                    this.voice_changer = num;
                    return this;
                }

                public Builder vignette(Boolean bool) {
                    this.vignette = bool;
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

                public Builder compressor(Integer num) {
                    this.compressor = num;
                    return this;
                }

                public Builder pitch_factor(Integer num) {
                    this.pitch_factor = num;
                    return this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.Message.a
                public VisualClip build() {
                    return new VisualClip(this);
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class StringHashMap extends Message {
            public static final List<StringHashMapEntry> DEFAULT_ENTRIES = Collections.emptyList();
            private static final long serialVersionUID = 0;

            @n(a = 1, c = Message.Label.REPEATED, d = StringHashMapEntry.class)
            public final List<StringHashMapEntry> entries;

            public StringHashMap(List<StringHashMapEntry> list) {
                this.entries = immutableCopyOf(list);
            }

            private StringHashMap(Builder builder) {
                this(builder.entries);
                setBuilder(builder);
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
                    i = this.entries != null ? this.entries.hashCode() : 1;
                    this.hashCode = i;
                }
                return i;
            }

            /* loaded from: classes.dex */
            public static final class Builder extends Message.a<StringHashMap> {
                public List<StringHashMapEntry> entries;

                public Builder() {
                }

                public Builder(StringHashMap stringHashMap) {
                    super(stringHashMap);
                    if (stringHashMap != null) {
                        this.entries = StringHashMap.copyOf(stringHashMap.entries);
                    }
                }

                public Builder entries(List<StringHashMapEntry> list) {
                    this.entries = checkForNulls(list);
                    return this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.Message.a
                public StringHashMap build() {
                    return new StringHashMap(this);
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class StringHashMapEntry extends Message {
            public static final String DEFAULT_KEY = "";
            public static final String DEFAULT_VALUE = "";
            private static final long serialVersionUID = 0;

            @n(a = 1, b = Message.Datatype.STRING)
            public final String key;

            @n(a = 2, b = Message.Datatype.STRING)
            public final String value;

            public StringHashMapEntry(String str, String str2) {
                this.key = str;
                this.value = str2;
            }

            private StringHashMapEntry(Builder builder) {
                this(builder.key, builder.value);
                setBuilder(builder);
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
                if (i == 0) {
                    int hashCode = ((this.key != null ? this.key.hashCode() : 0) * 37) + (this.value != null ? this.value.hashCode() : 0);
                    this.hashCode = hashCode;
                    return hashCode;
                }
                return i;
            }

            /* loaded from: classes.dex */
            public static final class Builder extends Message.a<StringHashMapEntry> {
                public String key;
                public String value;

                public Builder() {
                }

                public Builder(StringHashMapEntry stringHashMapEntry) {
                    super(stringHashMapEntry);
                    if (stringHashMapEntry != null) {
                        this.key = stringHashMapEntry.key;
                        this.value = stringHashMapEntry.value;
                    }
                }

                public Builder key(String str) {
                    this.key = str;
                    return this;
                }

                public Builder value(String str) {
                    this.value = str;
                    return this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.Message.a
                public StringHashMapEntry build() {
                    return new StringHashMapEntry(this);
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class Matrix extends Message {
            public static final List<Float> DEFAULT_ELEMENT = Collections.emptyList();
            private static final long serialVersionUID = 0;

            @n(a = 1, b = Message.Datatype.FLOAT, c = Message.Label.PACKED)
            public final List<Float> element;

            public Matrix(List<Float> list) {
                this.element = immutableCopyOf(list);
            }

            private Matrix(Builder builder) {
                this(builder.element);
                setBuilder(builder);
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
                    i = this.element != null ? this.element.hashCode() : 1;
                    this.hashCode = i;
                }
                return i;
            }

            /* loaded from: classes.dex */
            public static final class Builder extends Message.a<Matrix> {
                public List<Float> element;

                public Builder() {
                }

                public Builder(Matrix matrix) {
                    super(matrix);
                    if (matrix != null) {
                        this.element = Matrix.copyOf(matrix.element);
                    }
                }

                public Builder element(List<Float> list) {
                    this.element = checkForNulls(list);
                    return this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.Message.a
                public Matrix build() {
                    return new Matrix(this);
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class Transition extends Message {
            public static final String DEFAULT_CAPTUREFILENAME = "";
            public static final String DEFAULT_TRANSITION_EFFECT_ID = "";
            private static final long serialVersionUID = 0;

            @n(a = 112, b = Message.Datatype.BOOL)
            public final Boolean allow_overlap;

            @n(a = 102, b = Message.Datatype.ENUM)
            public final ThemeEffectType auto_theme_effect;

            @n(a = 100, b = Message.Datatype.STRING)
            public final String captureFilename;

            @n(a = 107, b = Message.Datatype.BOOL)
            public final Boolean disabled;

            @n(a = 111, b = Message.Datatype.INT32)
            public final Integer duration_limit;

            @n(a = 110)
            public final StringHashMap effect_options;

            @n(a = 109, b = Message.Datatype.INT32)
            public final Integer maximum_duration;

            @n(a = 108, b = Message.Datatype.INT32)
            public final Integer minimum_duration;

            @n(a = 103, b = Message.Datatype.INT32)
            public final Integer transition_duration;

            @n(a = 101, b = Message.Datatype.STRING)
            public final String transition_effect_id;

            @n(a = 104, b = Message.Datatype.INT32)
            public final Integer transition_engine_duration;

            @n(a = 106, b = Message.Datatype.INT32)
            public final Integer transition_offset_percent;

            @n(a = 105, b = Message.Datatype.INT32)
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
                if (i == 0) {
                    int hashCode = (((this.duration_limit != null ? this.duration_limit.hashCode() : 0) + (((this.effect_options != null ? this.effect_options.hashCode() : 0) + (((this.maximum_duration != null ? this.maximum_duration.hashCode() : 0) + (((this.minimum_duration != null ? this.minimum_duration.hashCode() : 0) + (((this.disabled != null ? this.disabled.hashCode() : 0) + (((this.transition_offset_percent != null ? this.transition_offset_percent.hashCode() : 0) + (((this.transition_overlap_percent != null ? this.transition_overlap_percent.hashCode() : 0) + (((this.transition_engine_duration != null ? this.transition_engine_duration.hashCode() : 0) + (((this.transition_duration != null ? this.transition_duration.hashCode() : 0) + (((this.auto_theme_effect != null ? this.auto_theme_effect.hashCode() : 0) + (((this.transition_effect_id != null ? this.transition_effect_id.hashCode() : 0) + ((this.captureFilename != null ? this.captureFilename.hashCode() : 0) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37) + (this.allow_overlap != null ? this.allow_overlap.hashCode() : 0);
                    this.hashCode = hashCode;
                    return hashCode;
                }
                return i;
            }

            /* loaded from: classes.dex */
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

                public Builder(Transition transition) {
                    super(transition);
                    if (transition != null) {
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
                }

                public Builder captureFilename(String str) {
                    this.captureFilename = str;
                    return this;
                }

                public Builder transition_effect_id(String str) {
                    this.transition_effect_id = str;
                    return this;
                }

                public Builder auto_theme_effect(ThemeEffectType themeEffectType) {
                    this.auto_theme_effect = themeEffectType;
                    return this;
                }

                public Builder transition_duration(Integer num) {
                    this.transition_duration = num;
                    return this;
                }

                public Builder transition_engine_duration(Integer num) {
                    this.transition_engine_duration = num;
                    return this;
                }

                public Builder transition_overlap_percent(Integer num) {
                    this.transition_overlap_percent = num;
                    return this;
                }

                public Builder transition_offset_percent(Integer num) {
                    this.transition_offset_percent = num;
                    return this;
                }

                public Builder disabled(Boolean bool) {
                    this.disabled = bool;
                    return this;
                }

                public Builder minimum_duration(Integer num) {
                    this.minimum_duration = num;
                    return this;
                }

                public Builder maximum_duration(Integer num) {
                    this.maximum_duration = num;
                    return this;
                }

                public Builder effect_options(StringHashMap stringHashMap) {
                    this.effect_options = stringHashMap;
                    return this;
                }

                public Builder duration_limit(Integer num) {
                    this.duration_limit = num;
                    return this;
                }

                public Builder allow_overlap(Boolean bool) {
                    this.allow_overlap = bool;
                    return this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.Message.a
                public Transition build() {
                    return new Transition(this);
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class AudioClip extends Message {
            public static final String DEFAULT_MEDIA_PATH = "";
            public static final String DEFAULT_MEDIA_TITLE = "";
            public static final String DEFAULT_ORIGINAL_MEDIA_PATH = "";
            private static final long serialVersionUID = 0;

            @n(a = 111, b = Message.Datatype.INT32)
            public final Integer clip_volume;

            @n(a = 125, b = Message.Datatype.FLOAT)
            public final Float clip_width;

            @n(a = 132, b = Message.Datatype.INT32)
            public final Integer compressor;

            @n(a = 106, b = Message.Datatype.INT32)
            public final Integer duration;

            @n(a = 105, b = Message.Datatype.INT32)
            public final Integer engine_clip_id;

            @n(a = 128, b = Message.Datatype.BOOL)
            public final Boolean extend_to_end;

            @n(a = 100, b = Message.Datatype.INT32)
            public final Integer extra_relative_start_time;

            @n(a = 122, b = Message.Datatype.BOOL)
            public final Boolean is_bg_music;

            @n(a = 119, b = Message.Datatype.BOOL)
            public final Boolean is_extract_audio;

            @n(a = 118, b = Message.Datatype.BOOL)
            public final Boolean is_pending_voice_recording;

            @n(a = 117, b = Message.Datatype.BOOL)
            public final Boolean is_voice_recording;

            @n(a = 116, b = Message.Datatype.BOOL)
            public final Boolean loop;

            @n(a = 112, b = Message.Datatype.STRING)
            public final String media_path;

            @n(a = 114, b = Message.Datatype.STRING)
            public final String media_title;

            @n(a = 115, b = Message.Datatype.BOOL)
            public final Boolean mute_audio;

            @n(a = 113, b = Message.Datatype.STRING)
            public final String original_media_path;

            @n(a = 130, b = Message.Datatype.INT32)
            public final Integer pan_left;

            @n(a = 131, b = Message.Datatype.INT32)
            public final Integer pan_right;

            @n(a = 126, b = Message.Datatype.BOOL)
            public final Boolean pinned;

            @n(a = 133, b = Message.Datatype.INT32)
            public final Integer pitch_factor;

            @n(a = 102, b = Message.Datatype.INT32)
            public final Integer relative_end_time;

            @n(a = 101, b = Message.Datatype.INT32)
            public final Integer relative_start_time;

            @n(a = 127, b = Message.Datatype.INT32)
            public final Integer saved_loop_duration;

            @n(a = 103, b = Message.Datatype.INT32)
            public final Integer saved_relative_end_time;

            @n(a = 104, b = Message.Datatype.INT32)
            public final Integer saved_relative_start_time;

            @n(a = 110, b = Message.Datatype.INT32)
            public final Integer saved_trim_time_end;

            @n(a = 109, b = Message.Datatype.INT32)
            public final Integer saved_trim_time_start;

            @n(a = 108, b = Message.Datatype.INT32)
            public final Integer trim_time_end;

            @n(a = 107, b = Message.Datatype.INT32)
            public final Integer trim_time_start;

            @n(a = 120, b = Message.Datatype.UINT64)
            public final Long video_clip_item_uuid_lsb;

            @n(a = 121, b = Message.Datatype.UINT64)
            public final Long video_clip_item_uuid_msb;

            @n(a = 129, b = Message.Datatype.INT32)
            public final Integer voice_changer;

            @n(a = 124, b = Message.Datatype.INT32, c = Message.Label.PACKED)
            public final List<Integer> volume_envelope_level;

            @n(a = 123, b = Message.Datatype.INT32, c = Message.Label.PACKED)
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

            public AudioClip(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, String str, String str2, String str3, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Long l, Long l2, Boolean bool6, List<Integer> list, List<Integer> list2, Float f, Boolean bool7, Integer num13, Boolean bool8, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18) {
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
                this.volume_envelope_time = immutableCopyOf(list);
                this.volume_envelope_level = immutableCopyOf(list2);
                this.clip_width = f;
                this.pinned = bool7;
                this.saved_loop_duration = num13;
                this.extend_to_end = bool8;
                this.voice_changer = num14;
                this.pan_left = num15;
                this.pan_right = num16;
                this.compressor = num17;
                this.pitch_factor = num18;
            }

            private AudioClip(Builder builder) {
                this(builder.extra_relative_start_time, builder.relative_start_time, builder.relative_end_time, builder.saved_relative_end_time, builder.saved_relative_start_time, builder.engine_clip_id, builder.duration, builder.trim_time_start, builder.trim_time_end, builder.saved_trim_time_start, builder.saved_trim_time_end, builder.clip_volume, builder.media_path, builder.original_media_path, builder.media_title, builder.mute_audio, builder.loop, builder.is_voice_recording, builder.is_pending_voice_recording, builder.is_extract_audio, builder.video_clip_item_uuid_lsb, builder.video_clip_item_uuid_msb, builder.is_bg_music, builder.volume_envelope_time, builder.volume_envelope_level, builder.clip_width, builder.pinned, builder.saved_loop_duration, builder.extend_to_end, builder.voice_changer, builder.pan_left, builder.pan_right, builder.compressor, builder.pitch_factor);
                setBuilder(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof AudioClip)) {
                    return false;
                }
                AudioClip audioClip = (AudioClip) obj;
                return equals(this.extra_relative_start_time, audioClip.extra_relative_start_time) && equals(this.relative_start_time, audioClip.relative_start_time) && equals(this.relative_end_time, audioClip.relative_end_time) && equals(this.saved_relative_end_time, audioClip.saved_relative_end_time) && equals(this.saved_relative_start_time, audioClip.saved_relative_start_time) && equals(this.engine_clip_id, audioClip.engine_clip_id) && equals(this.duration, audioClip.duration) && equals(this.trim_time_start, audioClip.trim_time_start) && equals(this.trim_time_end, audioClip.trim_time_end) && equals(this.saved_trim_time_start, audioClip.saved_trim_time_start) && equals(this.saved_trim_time_end, audioClip.saved_trim_time_end) && equals(this.clip_volume, audioClip.clip_volume) && equals(this.media_path, audioClip.media_path) && equals(this.original_media_path, audioClip.original_media_path) && equals(this.media_title, audioClip.media_title) && equals(this.mute_audio, audioClip.mute_audio) && equals(this.loop, audioClip.loop) && equals(this.is_voice_recording, audioClip.is_voice_recording) && equals(this.is_pending_voice_recording, audioClip.is_pending_voice_recording) && equals(this.is_extract_audio, audioClip.is_extract_audio) && equals(this.video_clip_item_uuid_lsb, audioClip.video_clip_item_uuid_lsb) && equals(this.video_clip_item_uuid_msb, audioClip.video_clip_item_uuid_msb) && equals(this.is_bg_music, audioClip.is_bg_music) && equals((List<?>) this.volume_envelope_time, (List<?>) audioClip.volume_envelope_time) && equals((List<?>) this.volume_envelope_level, (List<?>) audioClip.volume_envelope_level) && equals(this.clip_width, audioClip.clip_width) && equals(this.pinned, audioClip.pinned) && equals(this.saved_loop_duration, audioClip.saved_loop_duration) && equals(this.extend_to_end, audioClip.extend_to_end) && equals(this.voice_changer, audioClip.voice_changer) && equals(this.pan_left, audioClip.pan_left) && equals(this.pan_right, audioClip.pan_right) && equals(this.compressor, audioClip.compressor) && equals(this.pitch_factor, audioClip.pitch_factor);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i == 0) {
                    int hashCode = (((this.compressor != null ? this.compressor.hashCode() : 0) + (((this.pan_right != null ? this.pan_right.hashCode() : 0) + (((this.pan_left != null ? this.pan_left.hashCode() : 0) + (((this.voice_changer != null ? this.voice_changer.hashCode() : 0) + (((this.extend_to_end != null ? this.extend_to_end.hashCode() : 0) + (((this.saved_loop_duration != null ? this.saved_loop_duration.hashCode() : 0) + (((this.pinned != null ? this.pinned.hashCode() : 0) + (((this.clip_width != null ? this.clip_width.hashCode() : 0) + (((((this.volume_envelope_time != null ? this.volume_envelope_time.hashCode() : 1) + (((this.is_bg_music != null ? this.is_bg_music.hashCode() : 0) + (((this.video_clip_item_uuid_msb != null ? this.video_clip_item_uuid_msb.hashCode() : 0) + (((this.video_clip_item_uuid_lsb != null ? this.video_clip_item_uuid_lsb.hashCode() : 0) + (((this.is_extract_audio != null ? this.is_extract_audio.hashCode() : 0) + (((this.is_pending_voice_recording != null ? this.is_pending_voice_recording.hashCode() : 0) + (((this.is_voice_recording != null ? this.is_voice_recording.hashCode() : 0) + (((this.loop != null ? this.loop.hashCode() : 0) + (((this.mute_audio != null ? this.mute_audio.hashCode() : 0) + (((this.media_title != null ? this.media_title.hashCode() : 0) + (((this.original_media_path != null ? this.original_media_path.hashCode() : 0) + (((this.media_path != null ? this.media_path.hashCode() : 0) + (((this.clip_volume != null ? this.clip_volume.hashCode() : 0) + (((this.saved_trim_time_end != null ? this.saved_trim_time_end.hashCode() : 0) + (((this.saved_trim_time_start != null ? this.saved_trim_time_start.hashCode() : 0) + (((this.trim_time_end != null ? this.trim_time_end.hashCode() : 0) + (((this.trim_time_start != null ? this.trim_time_start.hashCode() : 0) + (((this.duration != null ? this.duration.hashCode() : 0) + (((this.engine_clip_id != null ? this.engine_clip_id.hashCode() : 0) + (((this.saved_relative_start_time != null ? this.saved_relative_start_time.hashCode() : 0) + (((this.saved_relative_end_time != null ? this.saved_relative_end_time.hashCode() : 0) + (((this.relative_end_time != null ? this.relative_end_time.hashCode() : 0) + (((this.relative_start_time != null ? this.relative_start_time.hashCode() : 0) + ((this.extra_relative_start_time != null ? this.extra_relative_start_time.hashCode() : 0) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37) + (this.volume_envelope_level != null ? this.volume_envelope_level.hashCode() : 1)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37) + (this.pitch_factor != null ? this.pitch_factor.hashCode() : 0);
                    this.hashCode = hashCode;
                    return hashCode;
                }
                return i;
            }

            /* loaded from: classes.dex */
            public static final class Builder extends Message.a<AudioClip> {
                public Integer clip_volume;
                public Float clip_width;
                public Integer compressor;
                public Integer duration;
                public Integer engine_clip_id;
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

                public Builder(AudioClip audioClip) {
                    super(audioClip);
                    if (audioClip != null) {
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
                        this.volume_envelope_time = AudioClip.copyOf(audioClip.volume_envelope_time);
                        this.volume_envelope_level = AudioClip.copyOf(audioClip.volume_envelope_level);
                        this.clip_width = audioClip.clip_width;
                        this.pinned = audioClip.pinned;
                        this.saved_loop_duration = audioClip.saved_loop_duration;
                        this.extend_to_end = audioClip.extend_to_end;
                        this.voice_changer = audioClip.voice_changer;
                        this.pan_left = audioClip.pan_left;
                        this.pan_right = audioClip.pan_right;
                        this.compressor = audioClip.compressor;
                        this.pitch_factor = audioClip.pitch_factor;
                    }
                }

                public Builder extra_relative_start_time(Integer num) {
                    this.extra_relative_start_time = num;
                    return this;
                }

                public Builder relative_start_time(Integer num) {
                    this.relative_start_time = num;
                    return this;
                }

                public Builder relative_end_time(Integer num) {
                    this.relative_end_time = num;
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

                public Builder engine_clip_id(Integer num) {
                    this.engine_clip_id = num;
                    return this;
                }

                public Builder duration(Integer num) {
                    this.duration = num;
                    return this;
                }

                public Builder trim_time_start(Integer num) {
                    this.trim_time_start = num;
                    return this;
                }

                public Builder trim_time_end(Integer num) {
                    this.trim_time_end = num;
                    return this;
                }

                public Builder saved_trim_time_start(Integer num) {
                    this.saved_trim_time_start = num;
                    return this;
                }

                public Builder saved_trim_time_end(Integer num) {
                    this.saved_trim_time_end = num;
                    return this;
                }

                public Builder clip_volume(Integer num) {
                    this.clip_volume = num;
                    return this;
                }

                public Builder media_path(String str) {
                    this.media_path = str;
                    return this;
                }

                public Builder original_media_path(String str) {
                    this.original_media_path = str;
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

                public Builder loop(Boolean bool) {
                    this.loop = bool;
                    return this;
                }

                public Builder is_voice_recording(Boolean bool) {
                    this.is_voice_recording = bool;
                    return this;
                }

                public Builder is_pending_voice_recording(Boolean bool) {
                    this.is_pending_voice_recording = bool;
                    return this;
                }

                public Builder is_extract_audio(Boolean bool) {
                    this.is_extract_audio = bool;
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

                public Builder is_bg_music(Boolean bool) {
                    this.is_bg_music = bool;
                    return this;
                }

                public Builder volume_envelope_time(List<Integer> list) {
                    this.volume_envelope_time = checkForNulls(list);
                    return this;
                }

                public Builder volume_envelope_level(List<Integer> list) {
                    this.volume_envelope_level = checkForNulls(list);
                    return this;
                }

                public Builder clip_width(Float f) {
                    this.clip_width = f;
                    return this;
                }

                public Builder pinned(Boolean bool) {
                    this.pinned = bool;
                    return this;
                }

                public Builder saved_loop_duration(Integer num) {
                    this.saved_loop_duration = num;
                    return this;
                }

                public Builder extend_to_end(Boolean bool) {
                    this.extend_to_end = bool;
                    return this;
                }

                public Builder voice_changer(Integer num) {
                    this.voice_changer = num;
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

                public Builder compressor(Integer num) {
                    this.compressor = num;
                    return this;
                }

                public Builder pitch_factor(Integer num) {
                    this.pitch_factor = num;
                    return this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.Message.a
                public AudioClip build() {
                    return new AudioClip(this);
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class LayerCommon extends Message {
            public static final String DEFAULT_LAYER_NAME = "";
            private static final long serialVersionUID = 0;

            @n(a = 101, b = Message.Datatype.INT32)
            public final Integer end_time;

            @n(a = 104, b = Message.Datatype.INT32)
            public final Integer end_trim;

            @n(a = 122, b = Message.Datatype.BOOL)
            public final Boolean flip_h;

            @n(a = 123, b = Message.Datatype.BOOL)
            public final Boolean flip_v;

            @n(a = 108, c = Message.Label.REPEATED, d = KeyFrame.class)
            public final List<KeyFrame> keyframes;

            @n(a = 106, b = Message.Datatype.INT32)
            public final Integer layer_expression;

            @n(a = 107, b = Message.Datatype.INT32)
            public final Integer layer_expression_duration;

            @n(a = 109, b = Message.Datatype.INT32)
            public final Integer layer_in_expression;

            @n(a = 110, b = Message.Datatype.INT32)
            public final Integer layer_in_expression_duration;

            @n(a = 127, b = Message.Datatype.STRING)
            public final String layer_name;

            @n(a = 111, b = Message.Datatype.INT32)
            public final Integer layer_out_expression;

            @n(a = 112, b = Message.Datatype.INT32)
            public final Integer layer_out_expression_duration;

            @n(a = 113, b = Message.Datatype.INT32)
            public final Integer layer_overall_expression;

            @n(a = 114, b = Message.Datatype.FLOAT)
            public final Float layer_overall_expression_speed;

            @n(a = 124, b = Message.Datatype.BOOL)
            public final Boolean layermask_enabled;

            @n(a = 126, b = Message.Datatype.INT32)
            public final Integer layermask_index;

            @n(a = 125, b = Message.Datatype.INT32)
            public final Integer layermask_type;

            @n(a = 121, b = Message.Datatype.INT32)
            public final Integer overall_alpha;

            @n(a = 102, b = Message.Datatype.BOOL)
            public final Boolean pinned;

            @n(a = 115)
            public final KeyFrame split_keyframe;

            @n(a = 116, b = Message.Datatype.ENUM)
            public final SplitScreenType split_screen_type;

            @n(a = 120, b = Message.Datatype.INT32)
            public final Integer split_size_bottom;

            @n(a = 117, b = Message.Datatype.INT32)
            public final Integer split_size_left;

            @n(a = 118, b = Message.Datatype.INT32)
            public final Integer split_size_right;

            @n(a = 119, b = Message.Datatype.INT32)
            public final Integer split_size_top;

            @n(a = 100, b = Message.Datatype.INT32)
            public final Integer start_time;

            @n(a = 103, b = Message.Datatype.INT32)
            public final Integer start_trim;

            @n(a = 105, b = Message.Datatype.INT64)
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
            public static final Float DEFAULT_LAYER_OVERALL_EXPRESSION_SPEED = Float.valueOf(0.0f);
            public static final SplitScreenType DEFAULT_SPLIT_SCREEN_TYPE = SplitScreenType.OFF;
            public static final Integer DEFAULT_SPLIT_SIZE_LEFT = 0;
            public static final Integer DEFAULT_SPLIT_SIZE_RIGHT = 0;
            public static final Integer DEFAULT_SPLIT_SIZE_TOP = 0;
            public static final Integer DEFAULT_SPLIT_SIZE_BOTTOM = 0;
            public static final Boolean DEFAULT_FLIP_H = false;
            public static final Boolean DEFAULT_FLIP_V = false;
            public static final List<KeyFrame> DEFAULT_KEYFRAMES = Collections.emptyList();
            public static final Integer DEFAULT_OVERALL_ALPHA = 0;
            public static final Boolean DEFAULT_LAYERMASK_ENABLED = false;
            public static final Integer DEFAULT_LAYERMASK_TYPE = 0;
            public static final Integer DEFAULT_LAYERMASK_INDEX = 0;

            public LayerCommon(Integer num, Integer num2, Boolean bool, Integer num3, Integer num4, Long l, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Float f, SplitScreenType splitScreenType, Integer num12, Integer num13, Integer num14, Integer num15, Boolean bool2, Boolean bool3, KeyFrame keyFrame, List<KeyFrame> list, Integer num16, Boolean bool4, Integer num17, Integer num18, String str) {
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
                this.layer_overall_expression_speed = f;
                this.split_screen_type = splitScreenType;
                this.split_size_left = num12;
                this.split_size_right = num13;
                this.split_size_top = num14;
                this.split_size_bottom = num15;
                this.flip_h = bool2;
                this.flip_v = bool3;
                this.split_keyframe = keyFrame;
                this.keyframes = immutableCopyOf(list);
                this.overall_alpha = num16;
                this.layermask_enabled = bool4;
                this.layermask_type = num17;
                this.layermask_index = num18;
                this.layer_name = str;
            }

            private LayerCommon(Builder builder) {
                this(builder.start_time, builder.end_time, builder.pinned, builder.start_trim, builder.end_trim, builder.z_order, builder.layer_expression, builder.layer_expression_duration, builder.layer_in_expression, builder.layer_in_expression_duration, builder.layer_out_expression, builder.layer_out_expression_duration, builder.layer_overall_expression, builder.layer_overall_expression_speed, builder.split_screen_type, builder.split_size_left, builder.split_size_right, builder.split_size_top, builder.split_size_bottom, builder.flip_h, builder.flip_v, builder.split_keyframe, builder.keyframes, builder.overall_alpha, builder.layermask_enabled, builder.layermask_type, builder.layermask_index, builder.layer_name);
                setBuilder(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof LayerCommon)) {
                    return false;
                }
                LayerCommon layerCommon = (LayerCommon) obj;
                return equals(this.start_time, layerCommon.start_time) && equals(this.end_time, layerCommon.end_time) && equals(this.pinned, layerCommon.pinned) && equals(this.start_trim, layerCommon.start_trim) && equals(this.end_trim, layerCommon.end_trim) && equals(this.z_order, layerCommon.z_order) && equals(this.layer_expression, layerCommon.layer_expression) && equals(this.layer_expression_duration, layerCommon.layer_expression_duration) && equals(this.layer_in_expression, layerCommon.layer_in_expression) && equals(this.layer_in_expression_duration, layerCommon.layer_in_expression_duration) && equals(this.layer_out_expression, layerCommon.layer_out_expression) && equals(this.layer_out_expression_duration, layerCommon.layer_out_expression_duration) && equals(this.layer_overall_expression, layerCommon.layer_overall_expression) && equals(this.layer_overall_expression_speed, layerCommon.layer_overall_expression_speed) && equals(this.split_screen_type, layerCommon.split_screen_type) && equals(this.split_size_left, layerCommon.split_size_left) && equals(this.split_size_right, layerCommon.split_size_right) && equals(this.split_size_top, layerCommon.split_size_top) && equals(this.split_size_bottom, layerCommon.split_size_bottom) && equals(this.flip_h, layerCommon.flip_h) && equals(this.flip_v, layerCommon.flip_v) && equals(this.split_keyframe, layerCommon.split_keyframe) && equals((List<?>) this.keyframes, (List<?>) layerCommon.keyframes) && equals(this.overall_alpha, layerCommon.overall_alpha) && equals(this.layermask_enabled, layerCommon.layermask_enabled) && equals(this.layermask_type, layerCommon.layermask_type) && equals(this.layermask_index, layerCommon.layermask_index) && equals(this.layer_name, layerCommon.layer_name);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i == 0) {
                    int hashCode = (((this.layermask_index != null ? this.layermask_index.hashCode() : 0) + (((this.layermask_type != null ? this.layermask_type.hashCode() : 0) + (((this.layermask_enabled != null ? this.layermask_enabled.hashCode() : 0) + (((this.overall_alpha != null ? this.overall_alpha.hashCode() : 0) + (((this.keyframes != null ? this.keyframes.hashCode() : 1) + (((this.split_keyframe != null ? this.split_keyframe.hashCode() : 0) + (((this.flip_v != null ? this.flip_v.hashCode() : 0) + (((this.flip_h != null ? this.flip_h.hashCode() : 0) + (((this.split_size_bottom != null ? this.split_size_bottom.hashCode() : 0) + (((this.split_size_top != null ? this.split_size_top.hashCode() : 0) + (((this.split_size_right != null ? this.split_size_right.hashCode() : 0) + (((this.split_size_left != null ? this.split_size_left.hashCode() : 0) + (((this.split_screen_type != null ? this.split_screen_type.hashCode() : 0) + (((this.layer_overall_expression_speed != null ? this.layer_overall_expression_speed.hashCode() : 0) + (((this.layer_overall_expression != null ? this.layer_overall_expression.hashCode() : 0) + (((this.layer_out_expression_duration != null ? this.layer_out_expression_duration.hashCode() : 0) + (((this.layer_out_expression != null ? this.layer_out_expression.hashCode() : 0) + (((this.layer_in_expression_duration != null ? this.layer_in_expression_duration.hashCode() : 0) + (((this.layer_in_expression != null ? this.layer_in_expression.hashCode() : 0) + (((this.layer_expression_duration != null ? this.layer_expression_duration.hashCode() : 0) + (((this.layer_expression != null ? this.layer_expression.hashCode() : 0) + (((this.z_order != null ? this.z_order.hashCode() : 0) + (((this.end_trim != null ? this.end_trim.hashCode() : 0) + (((this.start_trim != null ? this.start_trim.hashCode() : 0) + (((this.pinned != null ? this.pinned.hashCode() : 0) + (((this.end_time != null ? this.end_time.hashCode() : 0) + ((this.start_time != null ? this.start_time.hashCode() : 0) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37) + (this.layer_name != null ? this.layer_name.hashCode() : 0);
                    this.hashCode = hashCode;
                    return hashCode;
                }
                return i;
            }

            /* loaded from: classes.dex */
            public static final class Builder extends Message.a<LayerCommon> {
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
                public Long z_order;

                public Builder() {
                }

                public Builder(LayerCommon layerCommon) {
                    super(layerCommon);
                    if (layerCommon != null) {
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
                        this.keyframes = LayerCommon.copyOf(layerCommon.keyframes);
                        this.overall_alpha = layerCommon.overall_alpha;
                        this.layermask_enabled = layerCommon.layermask_enabled;
                        this.layermask_type = layerCommon.layermask_type;
                        this.layermask_index = layerCommon.layermask_index;
                        this.layer_name = layerCommon.layer_name;
                    }
                }

                public Builder start_time(Integer num) {
                    this.start_time = num;
                    return this;
                }

                public Builder end_time(Integer num) {
                    this.end_time = num;
                    return this;
                }

                public Builder pinned(Boolean bool) {
                    this.pinned = bool;
                    return this;
                }

                public Builder start_trim(Integer num) {
                    this.start_trim = num;
                    return this;
                }

                public Builder end_trim(Integer num) {
                    this.end_trim = num;
                    return this;
                }

                public Builder z_order(Long l) {
                    this.z_order = l;
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

                public Builder layer_overall_expression_speed(Float f) {
                    this.layer_overall_expression_speed = f;
                    return this;
                }

                public Builder split_screen_type(SplitScreenType splitScreenType) {
                    this.split_screen_type = splitScreenType;
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

                public Builder split_size_bottom(Integer num) {
                    this.split_size_bottom = num;
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

                public Builder split_keyframe(KeyFrame keyFrame) {
                    this.split_keyframe = keyFrame;
                    return this;
                }

                public Builder keyframes(List<KeyFrame> list) {
                    this.keyframes = checkForNulls(list);
                    return this;
                }

                public Builder overall_alpha(Integer num) {
                    this.overall_alpha = num;
                    return this;
                }

                public Builder layermask_enabled(Boolean bool) {
                    this.layermask_enabled = bool;
                    return this;
                }

                public Builder layermask_type(Integer num) {
                    this.layermask_type = num;
                    return this;
                }

                public Builder layermask_index(Integer num) {
                    this.layermask_index = num;
                    return this;
                }

                public Builder layer_name(String str) {
                    this.layer_name = str;
                    return this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.Message.a
                public LayerCommon build() {
                    return new LayerCommon(this);
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class KeyFrame extends Message {
            private static final long serialVersionUID = 0;

            @n(a = 106, b = Message.Datatype.FLOAT)
            public final Float alpha;

            @n(a = 105, b = Message.Datatype.FLOAT)
            public final Float angle;

            @n(a = 102, b = Message.Datatype.FLOAT)
            public final Float scale;

            @n(a = 101, b = Message.Datatype.FLOAT)
            public final Float time;

            @n(a = 103, b = Message.Datatype.FLOAT)
            public final Float x;

            @n(a = 104, b = Message.Datatype.FLOAT)
            public final Float y;
            public static final Float DEFAULT_TIME = Float.valueOf(0.0f);
            public static final Float DEFAULT_SCALE = Float.valueOf(0.0f);
            public static final Float DEFAULT_X = Float.valueOf(0.0f);
            public static final Float DEFAULT_Y = Float.valueOf(0.0f);
            public static final Float DEFAULT_ANGLE = Float.valueOf(0.0f);
            public static final Float DEFAULT_ALPHA = Float.valueOf(0.0f);

            public KeyFrame(Float f, Float f2, Float f3, Float f4, Float f5, Float f6) {
                this.time = f;
                this.scale = f2;
                this.x = f3;
                this.y = f4;
                this.angle = f5;
                this.alpha = f6;
            }

            private KeyFrame(Builder builder) {
                this(builder.time, builder.scale, builder.x, builder.y, builder.angle, builder.alpha);
                setBuilder(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof KeyFrame)) {
                    return false;
                }
                KeyFrame keyFrame = (KeyFrame) obj;
                return equals(this.time, keyFrame.time) && equals(this.scale, keyFrame.scale) && equals(this.x, keyFrame.x) && equals(this.y, keyFrame.y) && equals(this.angle, keyFrame.angle) && equals(this.alpha, keyFrame.alpha);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i == 0) {
                    int hashCode = (((this.angle != null ? this.angle.hashCode() : 0) + (((this.y != null ? this.y.hashCode() : 0) + (((this.x != null ? this.x.hashCode() : 0) + (((this.scale != null ? this.scale.hashCode() : 0) + ((this.time != null ? this.time.hashCode() : 0) * 37)) * 37)) * 37)) * 37)) * 37) + (this.alpha != null ? this.alpha.hashCode() : 0);
                    this.hashCode = hashCode;
                    return hashCode;
                }
                return i;
            }

            /* loaded from: classes.dex */
            public static final class Builder extends Message.a<KeyFrame> {
                public Float alpha;
                public Float angle;
                public Float scale;
                public Float time;
                public Float x;
                public Float y;

                public Builder() {
                }

                public Builder(KeyFrame keyFrame) {
                    super(keyFrame);
                    if (keyFrame != null) {
                        this.time = keyFrame.time;
                        this.scale = keyFrame.scale;
                        this.x = keyFrame.x;
                        this.y = keyFrame.y;
                        this.angle = keyFrame.angle;
                        this.alpha = keyFrame.alpha;
                    }
                }

                public Builder time(Float f) {
                    this.time = f;
                    return this;
                }

                public Builder scale(Float f) {
                    this.scale = f;
                    return this;
                }

                public Builder x(Float f) {
                    this.x = f;
                    return this;
                }

                public Builder y(Float f) {
                    this.y = f;
                    return this;
                }

                public Builder angle(Float f) {
                    this.angle = f;
                    return this;
                }

                public Builder alpha(Float f) {
                    this.alpha = f;
                    return this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.Message.a
                public KeyFrame build() {
                    return new KeyFrame(this);
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class TextLayer extends Message {
            public static final String DEFAULT_FONT_ID = "";
            public static final String DEFAULT_LAYER_TEXT = "";
            private static final long serialVersionUID = 0;

            @n(a = 120, b = Message.Datatype.INT32)
            public final Integer background_color;

            @n(a = 119, b = Message.Datatype.BOOL)
            public final Boolean enable_background;

            @n(a = 110, b = Message.Datatype.BOOL)
            public final Boolean enable_glow;

            @n(a = 117, b = Message.Datatype.BOOL)
            public final Boolean enable_gradient;

            @n(a = 114, b = Message.Datatype.BOOL)
            public final Boolean enable_outline;

            @n(a = 105, b = Message.Datatype.BOOL)
            public final Boolean enable_shadow;

            @n(a = 121, b = Message.Datatype.BOOL)
            public final Boolean extend_background;

            @n(a = 103, b = Message.Datatype.STRING)
            public final String font_id;

            @n(a = 111, b = Message.Datatype.INT32)
            public final Integer glow_color;

            @n(a = 112, b = Message.Datatype.FLOAT)
            public final Float glow_radius;

            @n(a = 113, b = Message.Datatype.INT32)
            public final Integer glow_type;

            @n(a = 118, b = Message.Datatype.INT32, c = Message.Label.REPEATED)
            public final List<Integer> gradient_colors;

            @n(a = 100)
            public final LayerCommon layer_common;

            @n(a = 101, b = Message.Datatype.STRING)
            public final String layer_text;

            @n(a = 115, b = Message.Datatype.INT32)
            public final Integer outline_color;

            @n(a = 116, b = Message.Datatype.FLOAT)
            public final Float outline_width;

            @n(a = 106, b = Message.Datatype.INT32)
            public final Integer shadow_color;

            @n(a = 108, b = Message.Datatype.FLOAT)
            public final Float shadow_dx;

            @n(a = 109, b = Message.Datatype.FLOAT)
            public final Float shadow_dy;

            @n(a = 107, b = Message.Datatype.FLOAT)
            public final Float shadow_radius;

            @n(a = 122, b = Message.Datatype.INT32)
            public final Integer text_align;

            @n(a = 104, b = Message.Datatype.INT32)
            public final Integer text_color;

            @n(a = 102, b = Message.Datatype.FLOAT)
            public final Float text_size;
            public static final Float DEFAULT_TEXT_SIZE = Float.valueOf(0.0f);
            public static final Integer DEFAULT_TEXT_COLOR = 0;
            public static final Boolean DEFAULT_ENABLE_SHADOW = false;
            public static final Integer DEFAULT_SHADOW_COLOR = 0;
            public static final Float DEFAULT_SHADOW_RADIUS = Float.valueOf(0.0f);
            public static final Float DEFAULT_SHADOW_DX = Float.valueOf(0.0f);
            public static final Float DEFAULT_SHADOW_DY = Float.valueOf(0.0f);
            public static final Boolean DEFAULT_ENABLE_GLOW = false;
            public static final Integer DEFAULT_GLOW_COLOR = 0;
            public static final Float DEFAULT_GLOW_RADIUS = Float.valueOf(0.0f);
            public static final Integer DEFAULT_GLOW_TYPE = 0;
            public static final Boolean DEFAULT_ENABLE_OUTLINE = false;
            public static final Integer DEFAULT_OUTLINE_COLOR = 0;
            public static final Float DEFAULT_OUTLINE_WIDTH = Float.valueOf(0.0f);
            public static final Boolean DEFAULT_ENABLE_GRADIENT = false;
            public static final List<Integer> DEFAULT_GRADIENT_COLORS = Collections.emptyList();
            public static final Boolean DEFAULT_ENABLE_BACKGROUND = false;
            public static final Integer DEFAULT_BACKGROUND_COLOR = 0;
            public static final Boolean DEFAULT_EXTEND_BACKGROUND = false;
            public static final Integer DEFAULT_TEXT_ALIGN = 0;

            public TextLayer(LayerCommon layerCommon, String str, Float f, String str2, Integer num, Boolean bool, Integer num2, Float f2, Float f3, Float f4, Boolean bool2, Integer num3, Float f5, Integer num4, Boolean bool3, Integer num5, Float f6, Boolean bool4, List<Integer> list, Boolean bool5, Integer num6, Boolean bool6, Integer num7) {
                this.layer_common = layerCommon;
                this.layer_text = str;
                this.text_size = f;
                this.font_id = str2;
                this.text_color = num;
                this.enable_shadow = bool;
                this.shadow_color = num2;
                this.shadow_radius = f2;
                this.shadow_dx = f3;
                this.shadow_dy = f4;
                this.enable_glow = bool2;
                this.glow_color = num3;
                this.glow_radius = f5;
                this.glow_type = num4;
                this.enable_outline = bool3;
                this.outline_color = num5;
                this.outline_width = f6;
                this.enable_gradient = bool4;
                this.gradient_colors = immutableCopyOf(list);
                this.enable_background = bool5;
                this.background_color = num6;
                this.extend_background = bool6;
                this.text_align = num7;
            }

            private TextLayer(Builder builder) {
                this(builder.layer_common, builder.layer_text, builder.text_size, builder.font_id, builder.text_color, builder.enable_shadow, builder.shadow_color, builder.shadow_radius, builder.shadow_dx, builder.shadow_dy, builder.enable_glow, builder.glow_color, builder.glow_radius, builder.glow_type, builder.enable_outline, builder.outline_color, builder.outline_width, builder.enable_gradient, builder.gradient_colors, builder.enable_background, builder.background_color, builder.extend_background, builder.text_align);
                setBuilder(builder);
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
                if (i == 0) {
                    int hashCode = (((this.extend_background != null ? this.extend_background.hashCode() : 0) + (((this.background_color != null ? this.background_color.hashCode() : 0) + (((this.enable_background != null ? this.enable_background.hashCode() : 0) + (((this.gradient_colors != null ? this.gradient_colors.hashCode() : 1) + (((this.enable_gradient != null ? this.enable_gradient.hashCode() : 0) + (((this.outline_width != null ? this.outline_width.hashCode() : 0) + (((this.outline_color != null ? this.outline_color.hashCode() : 0) + (((this.enable_outline != null ? this.enable_outline.hashCode() : 0) + (((this.glow_type != null ? this.glow_type.hashCode() : 0) + (((this.glow_radius != null ? this.glow_radius.hashCode() : 0) + (((this.glow_color != null ? this.glow_color.hashCode() : 0) + (((this.enable_glow != null ? this.enable_glow.hashCode() : 0) + (((this.shadow_dy != null ? this.shadow_dy.hashCode() : 0) + (((this.shadow_dx != null ? this.shadow_dx.hashCode() : 0) + (((this.shadow_radius != null ? this.shadow_radius.hashCode() : 0) + (((this.shadow_color != null ? this.shadow_color.hashCode() : 0) + (((this.enable_shadow != null ? this.enable_shadow.hashCode() : 0) + (((this.text_color != null ? this.text_color.hashCode() : 0) + (((this.font_id != null ? this.font_id.hashCode() : 0) + (((this.text_size != null ? this.text_size.hashCode() : 0) + (((this.layer_text != null ? this.layer_text.hashCode() : 0) + ((this.layer_common != null ? this.layer_common.hashCode() : 0) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37) + (this.text_align != null ? this.text_align.hashCode() : 0);
                    this.hashCode = hashCode;
                    return hashCode;
                }
                return i;
            }

            /* loaded from: classes.dex */
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

                public Builder(TextLayer textLayer) {
                    super(textLayer);
                    if (textLayer != null) {
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
                        this.gradient_colors = TextLayer.copyOf(textLayer.gradient_colors);
                        this.enable_background = textLayer.enable_background;
                        this.background_color = textLayer.background_color;
                        this.extend_background = textLayer.extend_background;
                        this.text_align = textLayer.text_align;
                    }
                }

                public Builder layer_common(LayerCommon layerCommon) {
                    this.layer_common = layerCommon;
                    return this;
                }

                public Builder layer_text(String str) {
                    this.layer_text = str;
                    return this;
                }

                public Builder text_size(Float f) {
                    this.text_size = f;
                    return this;
                }

                public Builder font_id(String str) {
                    this.font_id = str;
                    return this;
                }

                public Builder text_color(Integer num) {
                    this.text_color = num;
                    return this;
                }

                public Builder enable_shadow(Boolean bool) {
                    this.enable_shadow = bool;
                    return this;
                }

                public Builder shadow_color(Integer num) {
                    this.shadow_color = num;
                    return this;
                }

                public Builder shadow_radius(Float f) {
                    this.shadow_radius = f;
                    return this;
                }

                public Builder shadow_dx(Float f) {
                    this.shadow_dx = f;
                    return this;
                }

                public Builder shadow_dy(Float f) {
                    this.shadow_dy = f;
                    return this;
                }

                public Builder enable_glow(Boolean bool) {
                    this.enable_glow = bool;
                    return this;
                }

                public Builder glow_color(Integer num) {
                    this.glow_color = num;
                    return this;
                }

                public Builder glow_radius(Float f) {
                    this.glow_radius = f;
                    return this;
                }

                public Builder glow_type(Integer num) {
                    this.glow_type = num;
                    return this;
                }

                public Builder enable_outline(Boolean bool) {
                    this.enable_outline = bool;
                    return this;
                }

                public Builder outline_color(Integer num) {
                    this.outline_color = num;
                    return this;
                }

                public Builder outline_width(Float f) {
                    this.outline_width = f;
                    return this;
                }

                public Builder enable_gradient(Boolean bool) {
                    this.enable_gradient = bool;
                    return this;
                }

                public Builder gradient_colors(List<Integer> list) {
                    this.gradient_colors = checkForNulls(list);
                    return this;
                }

                public Builder enable_background(Boolean bool) {
                    this.enable_background = bool;
                    return this;
                }

                public Builder background_color(Integer num) {
                    this.background_color = num;
                    return this;
                }

                public Builder extend_background(Boolean bool) {
                    this.extend_background = bool;
                    return this;
                }

                public Builder text_align(Integer num) {
                    this.text_align = num;
                    return this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.Message.a
                public TextLayer build() {
                    return new TextLayer(this);
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class HandwritingLayer extends Message {
            private static final long serialVersionUID = 0;

            @n(a = 1, c = Message.Label.REPEATED, d = DrawingAction.class)
            public final List<DrawingAction> drawing_actions;

            @n(a = 100)
            public final LayerCommon layer_common;

            @n(a = 101, b = Message.Datatype.INT32)
            public final Integer pivot_x;

            @n(a = 102, b = Message.Datatype.INT32)
            public final Integer pivot_y;
            public static final Integer DEFAULT_PIVOT_X = 0;
            public static final Integer DEFAULT_PIVOT_Y = 0;
            public static final List<DrawingAction> DEFAULT_DRAWING_ACTIONS = Collections.emptyList();

            public HandwritingLayer(LayerCommon layerCommon, Integer num, Integer num2, List<DrawingAction> list) {
                this.layer_common = layerCommon;
                this.pivot_x = num;
                this.pivot_y = num2;
                this.drawing_actions = immutableCopyOf(list);
            }

            private HandwritingLayer(Builder builder) {
                this(builder.layer_common, builder.pivot_x, builder.pivot_y, builder.drawing_actions);
                setBuilder(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof HandwritingLayer)) {
                    return false;
                }
                HandwritingLayer handwritingLayer = (HandwritingLayer) obj;
                return equals(this.layer_common, handwritingLayer.layer_common) && equals(this.pivot_x, handwritingLayer.pivot_x) && equals(this.pivot_y, handwritingLayer.pivot_y) && equals((List<?>) this.drawing_actions, (List<?>) handwritingLayer.drawing_actions);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i == 0) {
                    int hashCode = (this.drawing_actions != null ? this.drawing_actions.hashCode() : 1) + (((((this.pivot_x != null ? this.pivot_x.hashCode() : 0) + ((this.layer_common != null ? this.layer_common.hashCode() : 0) * 37)) * 37) + (this.pivot_y != null ? this.pivot_y.hashCode() : 0)) * 37);
                    this.hashCode = hashCode;
                    return hashCode;
                }
                return i;
            }

            /* loaded from: classes.dex */
            public static final class Builder extends Message.a<HandwritingLayer> {
                public List<DrawingAction> drawing_actions;
                public LayerCommon layer_common;
                public Integer pivot_x;
                public Integer pivot_y;

                public Builder() {
                }

                public Builder(HandwritingLayer handwritingLayer) {
                    super(handwritingLayer);
                    if (handwritingLayer != null) {
                        this.layer_common = handwritingLayer.layer_common;
                        this.pivot_x = handwritingLayer.pivot_x;
                        this.pivot_y = handwritingLayer.pivot_y;
                        this.drawing_actions = HandwritingLayer.copyOf(handwritingLayer.drawing_actions);
                    }
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

                public Builder drawing_actions(List<DrawingAction> list) {
                    this.drawing_actions = checkForNulls(list);
                    return this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.Message.a
                public HandwritingLayer build() {
                    return new HandwritingLayer(this);
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class StickerLayer extends Message {
            private static final long serialVersionUID = 0;

            @n(a = 102, b = Message.Datatype.INT32)
            public final Integer colorize_color;

            @n(a = 101, b = Message.Datatype.BOOL)
            public final Boolean colorize_enabled;

            @n(a = 100)
            public final LayerCommon layer_common;

            @n(a = 103, b = Message.Datatype.INT32)
            public final Integer sticker_id;
            public static final Boolean DEFAULT_COLORIZE_ENABLED = false;
            public static final Integer DEFAULT_COLORIZE_COLOR = 0;
            public static final Integer DEFAULT_STICKER_ID = 0;

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
                if (i == 0) {
                    int hashCode = (((this.colorize_color != null ? this.colorize_color.hashCode() : 0) + (((this.colorize_enabled != null ? this.colorize_enabled.hashCode() : 0) + ((this.layer_common != null ? this.layer_common.hashCode() : 0) * 37)) * 37)) * 37) + (this.sticker_id != null ? this.sticker_id.hashCode() : 0);
                    this.hashCode = hashCode;
                    return hashCode;
                }
                return i;
            }

            /* loaded from: classes.dex */
            public static final class Builder extends Message.a<StickerLayer> {
                public Integer colorize_color;
                public Boolean colorize_enabled;
                public LayerCommon layer_common;
                public Integer sticker_id;

                public Builder() {
                }

                public Builder(StickerLayer stickerLayer) {
                    super(stickerLayer);
                    if (stickerLayer != null) {
                        this.layer_common = stickerLayer.layer_common;
                        this.colorize_enabled = stickerLayer.colorize_enabled;
                        this.colorize_color = stickerLayer.colorize_color;
                        this.sticker_id = stickerLayer.sticker_id;
                    }
                }

                public Builder layer_common(LayerCommon layerCommon) {
                    this.layer_common = layerCommon;
                    return this;
                }

                public Builder colorize_enabled(Boolean bool) {
                    this.colorize_enabled = bool;
                    return this;
                }

                public Builder colorize_color(Integer num) {
                    this.colorize_color = num;
                    return this;
                }

                public Builder sticker_id(Integer num) {
                    this.sticker_id = num;
                    return this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.Message.a
                public StickerLayer build() {
                    return new StickerLayer(this);
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class EffectLayer extends Message {
            public static final String DEFAULT_EFFECT_ID = "";
            public static final Float DEFAULT_EFFECT_STRENGTH = Float.valueOf(0.0f);
            public static final Float DEFAULT_EFFECT_VARIATION = Float.valueOf(0.0f);
            private static final long serialVersionUID = 0;

            @n(a = 101, b = Message.Datatype.STRING)
            public final String effect_id;

            @n(a = 102, b = Message.Datatype.FLOAT)
            public final Float effect_strength;

            @n(a = 103, b = Message.Datatype.FLOAT)
            public final Float effect_variation;

            @n(a = 100)
            public final LayerCommon layer_common;

            public EffectLayer(LayerCommon layerCommon, String str, Float f, Float f2) {
                this.layer_common = layerCommon;
                this.effect_id = str;
                this.effect_strength = f;
                this.effect_variation = f2;
            }

            private EffectLayer(Builder builder) {
                this(builder.layer_common, builder.effect_id, builder.effect_strength, builder.effect_variation);
                setBuilder(builder);
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
                if (i == 0) {
                    int hashCode = (((this.effect_strength != null ? this.effect_strength.hashCode() : 0) + (((this.effect_id != null ? this.effect_id.hashCode() : 0) + ((this.layer_common != null ? this.layer_common.hashCode() : 0) * 37)) * 37)) * 37) + (this.effect_variation != null ? this.effect_variation.hashCode() : 0);
                    this.hashCode = hashCode;
                    return hashCode;
                }
                return i;
            }

            /* loaded from: classes.dex */
            public static final class Builder extends Message.a<EffectLayer> {
                public String effect_id;
                public Float effect_strength;
                public Float effect_variation;
                public LayerCommon layer_common;

                public Builder() {
                }

                public Builder(EffectLayer effectLayer) {
                    super(effectLayer);
                    if (effectLayer != null) {
                        this.layer_common = effectLayer.layer_common;
                        this.effect_id = effectLayer.effect_id;
                        this.effect_strength = effectLayer.effect_strength;
                        this.effect_variation = effectLayer.effect_variation;
                    }
                }

                public Builder layer_common(LayerCommon layerCommon) {
                    this.layer_common = layerCommon;
                    return this;
                }

                public Builder effect_id(String str) {
                    this.effect_id = str;
                    return this;
                }

                public Builder effect_strength(Float f) {
                    this.effect_strength = f;
                    return this;
                }

                public Builder effect_variation(Float f) {
                    this.effect_variation = f;
                    return this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.Message.a
                public EffectLayer build() {
                    return new EffectLayer(this);
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class ImageLayer extends Message {
            public static final String DEFAULT_IMAGE_MSID = "";
            public static final String DEFAULT_IMAGE_PATH = "";
            private static final long serialVersionUID = 0;

            @n(a = 103, b = Message.Datatype.INT32)
            public final Integer brightness;

            @n(a = 106)
            public final ColorEffect color_effect;

            @n(a = 104, b = Message.Datatype.INT32)
            public final Integer contrast;

            @n(a = 102, b = Message.Datatype.STRING)
            public final String image_msid;

            @n(a = 101, b = Message.Datatype.STRING)
            public final String image_path;

            @n(a = 100)
            public final LayerCommon layer_common;

            @n(a = 105, b = Message.Datatype.INT32)
            public final Integer saturation;
            public static final Integer DEFAULT_BRIGHTNESS = 0;
            public static final Integer DEFAULT_CONTRAST = 0;
            public static final Integer DEFAULT_SATURATION = 0;

            public ImageLayer(LayerCommon layerCommon, String str, String str2, Integer num, Integer num2, Integer num3, ColorEffect colorEffect) {
                this.layer_common = layerCommon;
                this.image_path = str;
                this.image_msid = str2;
                this.brightness = num;
                this.contrast = num2;
                this.saturation = num3;
                this.color_effect = colorEffect;
            }

            private ImageLayer(Builder builder) {
                this(builder.layer_common, builder.image_path, builder.image_msid, builder.brightness, builder.contrast, builder.saturation, builder.color_effect);
                setBuilder(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof ImageLayer)) {
                    return false;
                }
                ImageLayer imageLayer = (ImageLayer) obj;
                return equals(this.layer_common, imageLayer.layer_common) && equals(this.image_path, imageLayer.image_path) && equals(this.image_msid, imageLayer.image_msid) && equals(this.brightness, imageLayer.brightness) && equals(this.contrast, imageLayer.contrast) && equals(this.saturation, imageLayer.saturation) && equals(this.color_effect, imageLayer.color_effect);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i == 0) {
                    int hashCode = (((this.saturation != null ? this.saturation.hashCode() : 0) + (((this.contrast != null ? this.contrast.hashCode() : 0) + (((this.brightness != null ? this.brightness.hashCode() : 0) + (((this.image_msid != null ? this.image_msid.hashCode() : 0) + (((this.image_path != null ? this.image_path.hashCode() : 0) + ((this.layer_common != null ? this.layer_common.hashCode() : 0) * 37)) * 37)) * 37)) * 37)) * 37)) * 37) + (this.color_effect != null ? this.color_effect.hashCode() : 0);
                    this.hashCode = hashCode;
                    return hashCode;
                }
                return i;
            }

            /* loaded from: classes.dex */
            public static final class Builder extends Message.a<ImageLayer> {
                public Integer brightness;
                public ColorEffect color_effect;
                public Integer contrast;
                public String image_msid;
                public String image_path;
                public LayerCommon layer_common;
                public Integer saturation;

                public Builder() {
                }

                public Builder(ImageLayer imageLayer) {
                    super(imageLayer);
                    if (imageLayer != null) {
                        this.layer_common = imageLayer.layer_common;
                        this.image_path = imageLayer.image_path;
                        this.image_msid = imageLayer.image_msid;
                        this.brightness = imageLayer.brightness;
                        this.contrast = imageLayer.contrast;
                        this.saturation = imageLayer.saturation;
                        this.color_effect = imageLayer.color_effect;
                    }
                }

                public Builder layer_common(LayerCommon layerCommon) {
                    this.layer_common = layerCommon;
                    return this;
                }

                public Builder image_path(String str) {
                    this.image_path = str;
                    return this;
                }

                public Builder image_msid(String str) {
                    this.image_msid = str;
                    return this;
                }

                public Builder brightness(Integer num) {
                    this.brightness = num;
                    return this;
                }

                public Builder contrast(Integer num) {
                    this.contrast = num;
                    return this;
                }

                public Builder saturation(Integer num) {
                    this.saturation = num;
                    return this;
                }

                public Builder color_effect(ColorEffect colorEffect) {
                    this.color_effect = colorEffect;
                    return this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.Message.a
                public ImageLayer build() {
                    return new ImageLayer(this);
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class VideoLayer extends Message {
            public static final String DEFAULT_VIDEO_MSID = "";
            public static final String DEFAULT_VIDEO_PATH = "";
            private static final long serialVersionUID = 0;

            @n(a = 103, b = Message.Datatype.INT32)
            public final Integer brightness;

            @n(a = 122, b = Message.Datatype.FLOAT)
            public final Float chroma_key_blend_x0;

            @n(a = 124, b = Message.Datatype.FLOAT)
            public final Float chroma_key_blend_x1;

            @n(a = 123, b = Message.Datatype.FLOAT)
            public final Float chroma_key_blend_y0;

            @n(a = 125, b = Message.Datatype.FLOAT)
            public final Float chroma_key_blend_y1;

            @n(a = 121, b = Message.Datatype.FLOAT)
            public final Float chroma_key_clip_bg;

            @n(a = 120, b = Message.Datatype.FLOAT)
            public final Float chroma_key_clip_fg;

            @n(a = 118, b = Message.Datatype.INT32)
            public final Integer chroma_key_color;

            @n(a = 1, b = Message.Datatype.FLOAT, c = Message.Label.PACKED)
            public final List<Float> chroma_key_divisions;

            @n(a = 119, b = Message.Datatype.BOOL)
            public final Boolean chroma_key_enabled;

            @n(a = 2, b = Message.Datatype.FLOAT, c = Message.Label.PACKED)
            public final List<Float> chroma_key_strengths;

            @n(a = 114, b = Message.Datatype.INT32)
            public final Integer clip_volume;

            @n(a = 106)
            public final ColorEffect color_effect;

            @n(a = 129, b = Message.Datatype.INT32)
            public final Integer compressor;

            @n(a = 104, b = Message.Datatype.INT32)
            public final Integer contrast;

            @n(a = 107, b = Message.Datatype.INT32)
            public final Integer engine_clip_id;

            @n(a = 111, b = Message.Datatype.BOOL)
            public final Boolean has_audio;

            @n(a = 112, b = Message.Datatype.BOOL)
            public final Boolean has_video;

            @n(a = 100)
            public final LayerCommon layer_common;

            @n(a = 113, b = Message.Datatype.BOOL)
            public final Boolean mute_audio;

            @n(a = 108, b = Message.Datatype.INT32)
            public final Integer original_clip_duration;

            @n(a = 110, b = Message.Datatype.INT32)
            public final Integer original_video_height;

            @n(a = 109, b = Message.Datatype.INT32)
            public final Integer original_video_width;

            @n(a = 127, b = Message.Datatype.INT32)
            public final Integer pan_left;

            @n(a = 128, b = Message.Datatype.INT32)
            public final Integer pan_right;

            @n(a = 130, b = Message.Datatype.INT32)
            public final Integer pitch_factor;

            @n(a = 115, b = Message.Datatype.INT32)
            public final Integer playback_speed;

            @n(a = 105, b = Message.Datatype.INT32)
            public final Integer saturation;

            @n(a = 102, b = Message.Datatype.STRING)
            public final String video_msid;

            @n(a = 101, b = Message.Datatype.STRING)
            public final String video_path;

            @n(a = 126, b = Message.Datatype.INT32)
            public final Integer voice_changer;

            @n(a = 117, b = Message.Datatype.INT32, c = Message.Label.PACKED)
            public final List<Integer> volume_envelope_level;

            @n(a = 116, b = Message.Datatype.INT32, c = Message.Label.PACKED)
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
            public static final Float DEFAULT_CHROMA_KEY_CLIP_FG = Float.valueOf(0.0f);
            public static final Float DEFAULT_CHROMA_KEY_CLIP_BG = Float.valueOf(0.0f);
            public static final Float DEFAULT_CHROMA_KEY_BLEND_X0 = Float.valueOf(0.0f);
            public static final Float DEFAULT_CHROMA_KEY_BLEND_Y0 = Float.valueOf(0.0f);
            public static final Float DEFAULT_CHROMA_KEY_BLEND_X1 = Float.valueOf(0.0f);
            public static final Float DEFAULT_CHROMA_KEY_BLEND_Y1 = Float.valueOf(0.0f);
            public static final Integer DEFAULT_VOICE_CHANGER = 0;
            public static final Integer DEFAULT_PAN_LEFT = 0;
            public static final Integer DEFAULT_PAN_RIGHT = 0;
            public static final Integer DEFAULT_COMPRESSOR = 0;
            public static final Integer DEFAULT_PITCH_FACTOR = 0;

            public VideoLayer(LayerCommon layerCommon, String str, String str2, Integer num, Integer num2, Integer num3, ColorEffect colorEffect, Integer num4, Integer num5, Integer num6, Integer num7, Boolean bool, Boolean bool2, Boolean bool3, Integer num8, Integer num9, List<Integer> list, List<Integer> list2, List<Float> list3, List<Float> list4, Integer num10, Boolean bool4, Float f, Float f2, Float f3, Float f4, Float f5, Float f6, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15) {
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
                this.volume_envelope_time = immutableCopyOf(list);
                this.volume_envelope_level = immutableCopyOf(list2);
                this.chroma_key_divisions = immutableCopyOf(list3);
                this.chroma_key_strengths = immutableCopyOf(list4);
                this.chroma_key_color = num10;
                this.chroma_key_enabled = bool4;
                this.chroma_key_clip_fg = f;
                this.chroma_key_clip_bg = f2;
                this.chroma_key_blend_x0 = f3;
                this.chroma_key_blend_y0 = f4;
                this.chroma_key_blend_x1 = f5;
                this.chroma_key_blend_y1 = f6;
                this.voice_changer = num11;
                this.pan_left = num12;
                this.pan_right = num13;
                this.compressor = num14;
                this.pitch_factor = num15;
            }

            private VideoLayer(Builder builder) {
                this(builder.layer_common, builder.video_path, builder.video_msid, builder.brightness, builder.contrast, builder.saturation, builder.color_effect, builder.engine_clip_id, builder.original_clip_duration, builder.original_video_width, builder.original_video_height, builder.has_audio, builder.has_video, builder.mute_audio, builder.clip_volume, builder.playback_speed, builder.volume_envelope_time, builder.volume_envelope_level, builder.chroma_key_divisions, builder.chroma_key_strengths, builder.chroma_key_color, builder.chroma_key_enabled, builder.chroma_key_clip_fg, builder.chroma_key_clip_bg, builder.chroma_key_blend_x0, builder.chroma_key_blend_y0, builder.chroma_key_blend_x1, builder.chroma_key_blend_y1, builder.voice_changer, builder.pan_left, builder.pan_right, builder.compressor, builder.pitch_factor);
                setBuilder(builder);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof VideoLayer)) {
                    return false;
                }
                VideoLayer videoLayer = (VideoLayer) obj;
                return equals(this.layer_common, videoLayer.layer_common) && equals(this.video_path, videoLayer.video_path) && equals(this.video_msid, videoLayer.video_msid) && equals(this.brightness, videoLayer.brightness) && equals(this.contrast, videoLayer.contrast) && equals(this.saturation, videoLayer.saturation) && equals(this.color_effect, videoLayer.color_effect) && equals(this.engine_clip_id, videoLayer.engine_clip_id) && equals(this.original_clip_duration, videoLayer.original_clip_duration) && equals(this.original_video_width, videoLayer.original_video_width) && equals(this.original_video_height, videoLayer.original_video_height) && equals(this.has_audio, videoLayer.has_audio) && equals(this.has_video, videoLayer.has_video) && equals(this.mute_audio, videoLayer.mute_audio) && equals(this.clip_volume, videoLayer.clip_volume) && equals(this.playback_speed, videoLayer.playback_speed) && equals((List<?>) this.volume_envelope_time, (List<?>) videoLayer.volume_envelope_time) && equals((List<?>) this.volume_envelope_level, (List<?>) videoLayer.volume_envelope_level) && equals((List<?>) this.chroma_key_divisions, (List<?>) videoLayer.chroma_key_divisions) && equals((List<?>) this.chroma_key_strengths, (List<?>) videoLayer.chroma_key_strengths) && equals(this.chroma_key_color, videoLayer.chroma_key_color) && equals(this.chroma_key_enabled, videoLayer.chroma_key_enabled) && equals(this.chroma_key_clip_fg, videoLayer.chroma_key_clip_fg) && equals(this.chroma_key_clip_bg, videoLayer.chroma_key_clip_bg) && equals(this.chroma_key_blend_x0, videoLayer.chroma_key_blend_x0) && equals(this.chroma_key_blend_y0, videoLayer.chroma_key_blend_y0) && equals(this.chroma_key_blend_x1, videoLayer.chroma_key_blend_x1) && equals(this.chroma_key_blend_y1, videoLayer.chroma_key_blend_y1) && equals(this.voice_changer, videoLayer.voice_changer) && equals(this.pan_left, videoLayer.pan_left) && equals(this.pan_right, videoLayer.pan_right) && equals(this.compressor, videoLayer.compressor) && equals(this.pitch_factor, videoLayer.pitch_factor);
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i == 0) {
                    int hashCode = (((this.compressor != null ? this.compressor.hashCode() : 0) + (((this.pan_right != null ? this.pan_right.hashCode() : 0) + (((this.pan_left != null ? this.pan_left.hashCode() : 0) + (((this.voice_changer != null ? this.voice_changer.hashCode() : 0) + (((this.chroma_key_blend_y1 != null ? this.chroma_key_blend_y1.hashCode() : 0) + (((this.chroma_key_blend_x1 != null ? this.chroma_key_blend_x1.hashCode() : 0) + (((this.chroma_key_blend_y0 != null ? this.chroma_key_blend_y0.hashCode() : 0) + (((this.chroma_key_blend_x0 != null ? this.chroma_key_blend_x0.hashCode() : 0) + (((this.chroma_key_clip_bg != null ? this.chroma_key_clip_bg.hashCode() : 0) + (((this.chroma_key_clip_fg != null ? this.chroma_key_clip_fg.hashCode() : 0) + (((this.chroma_key_enabled != null ? this.chroma_key_enabled.hashCode() : 0) + (((this.chroma_key_color != null ? this.chroma_key_color.hashCode() : 0) + (((((this.chroma_key_divisions != null ? this.chroma_key_divisions.hashCode() : 1) + (((this.volume_envelope_level != null ? this.volume_envelope_level.hashCode() : 1) + (((this.volume_envelope_time != null ? this.volume_envelope_time.hashCode() : 1) + (((this.playback_speed != null ? this.playback_speed.hashCode() : 0) + (((this.clip_volume != null ? this.clip_volume.hashCode() : 0) + (((this.mute_audio != null ? this.mute_audio.hashCode() : 0) + (((this.has_video != null ? this.has_video.hashCode() : 0) + (((this.has_audio != null ? this.has_audio.hashCode() : 0) + (((this.original_video_height != null ? this.original_video_height.hashCode() : 0) + (((this.original_video_width != null ? this.original_video_width.hashCode() : 0) + (((this.original_clip_duration != null ? this.original_clip_duration.hashCode() : 0) + (((this.engine_clip_id != null ? this.engine_clip_id.hashCode() : 0) + (((this.color_effect != null ? this.color_effect.hashCode() : 0) + (((this.saturation != null ? this.saturation.hashCode() : 0) + (((this.contrast != null ? this.contrast.hashCode() : 0) + (((this.brightness != null ? this.brightness.hashCode() : 0) + (((this.video_msid != null ? this.video_msid.hashCode() : 0) + (((this.video_path != null ? this.video_path.hashCode() : 0) + ((this.layer_common != null ? this.layer_common.hashCode() : 0) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37) + (this.chroma_key_strengths != null ? this.chroma_key_strengths.hashCode() : 1)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37) + (this.pitch_factor != null ? this.pitch_factor.hashCode() : 0);
                    this.hashCode = hashCode;
                    return hashCode;
                }
                return i;
            }

            /* loaded from: classes.dex */
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
                public Boolean has_audio;
                public Boolean has_video;
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

                public Builder(VideoLayer videoLayer) {
                    super(videoLayer);
                    if (videoLayer != null) {
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
                        this.volume_envelope_time = VideoLayer.copyOf(videoLayer.volume_envelope_time);
                        this.volume_envelope_level = VideoLayer.copyOf(videoLayer.volume_envelope_level);
                        this.chroma_key_divisions = VideoLayer.copyOf(videoLayer.chroma_key_divisions);
                        this.chroma_key_strengths = VideoLayer.copyOf(videoLayer.chroma_key_strengths);
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
                    }
                }

                public Builder layer_common(LayerCommon layerCommon) {
                    this.layer_common = layerCommon;
                    return this;
                }

                public Builder video_path(String str) {
                    this.video_path = str;
                    return this;
                }

                public Builder video_msid(String str) {
                    this.video_msid = str;
                    return this;
                }

                public Builder brightness(Integer num) {
                    this.brightness = num;
                    return this;
                }

                public Builder contrast(Integer num) {
                    this.contrast = num;
                    return this;
                }

                public Builder saturation(Integer num) {
                    this.saturation = num;
                    return this;
                }

                public Builder color_effect(ColorEffect colorEffect) {
                    this.color_effect = colorEffect;
                    return this;
                }

                public Builder engine_clip_id(Integer num) {
                    this.engine_clip_id = num;
                    return this;
                }

                public Builder original_clip_duration(Integer num) {
                    this.original_clip_duration = num;
                    return this;
                }

                public Builder original_video_width(Integer num) {
                    this.original_video_width = num;
                    return this;
                }

                public Builder original_video_height(Integer num) {
                    this.original_video_height = num;
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

                public Builder mute_audio(Boolean bool) {
                    this.mute_audio = bool;
                    return this;
                }

                public Builder clip_volume(Integer num) {
                    this.clip_volume = num;
                    return this;
                }

                public Builder playback_speed(Integer num) {
                    this.playback_speed = num;
                    return this;
                }

                public Builder volume_envelope_time(List<Integer> list) {
                    this.volume_envelope_time = checkForNulls(list);
                    return this;
                }

                public Builder volume_envelope_level(List<Integer> list) {
                    this.volume_envelope_level = checkForNulls(list);
                    return this;
                }

                public Builder chroma_key_divisions(List<Float> list) {
                    this.chroma_key_divisions = checkForNulls(list);
                    return this;
                }

                public Builder chroma_key_strengths(List<Float> list) {
                    this.chroma_key_strengths = checkForNulls(list);
                    return this;
                }

                public Builder chroma_key_color(Integer num) {
                    this.chroma_key_color = num;
                    return this;
                }

                public Builder chroma_key_enabled(Boolean bool) {
                    this.chroma_key_enabled = bool;
                    return this;
                }

                public Builder chroma_key_clip_fg(Float f) {
                    this.chroma_key_clip_fg = f;
                    return this;
                }

                public Builder chroma_key_clip_bg(Float f) {
                    this.chroma_key_clip_bg = f;
                    return this;
                }

                public Builder chroma_key_blend_x0(Float f) {
                    this.chroma_key_blend_x0 = f;
                    return this;
                }

                public Builder chroma_key_blend_y0(Float f) {
                    this.chroma_key_blend_y0 = f;
                    return this;
                }

                public Builder chroma_key_blend_x1(Float f) {
                    this.chroma_key_blend_x1 = f;
                    return this;
                }

                public Builder chroma_key_blend_y1(Float f) {
                    this.chroma_key_blend_y1 = f;
                    return this;
                }

                public Builder voice_changer(Integer num) {
                    this.voice_changer = num;
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

                public Builder compressor(Integer num) {
                    this.compressor = num;
                    return this;
                }

                public Builder pitch_factor(Integer num) {
                    this.pitch_factor = num;
                    return this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.Message.a
                public VideoLayer build() {
                    return new VideoLayer(this);
                }
            }
        }

        /* loaded from: classes.dex */
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
        public static final class DrawingAction extends Message {
            private static final long serialVersionUID = 0;

            @n(a = 3, b = Message.Datatype.INT32)
            public final Integer color;

            @n(a = 1, b = Message.Datatype.ENUM)
            public final DrawingActionType drawing_action_type;

            @n(a = 10, b = Message.Datatype.ENUM)
            public final CapDecorationStyle end_cap;

            @n(a = 5, b = Message.Datatype.FLOAT)
            public final Float hardness;

            @n(a = 6, b = Message.Datatype.BOOL)
            public final Boolean is_eraser;

            @n(a = 8, b = Message.Datatype.ENUM)
            public final PathStyle path_style;

            @n(a = 2, b = Message.Datatype.FLOAT, c = Message.Label.REPEATED)
            public final List<Float> points;

            @n(a = 9, b = Message.Datatype.ENUM)
            public final CapDecorationStyle start_cap;

            @n(a = 7, b = Message.Datatype.BOOL)
            public final Boolean straight_line;

            @n(a = 4, b = Message.Datatype.FLOAT)
            public final Float stroke_width;
            public static final DrawingActionType DEFAULT_DRAWING_ACTION_TYPE = DrawingActionType.STROKE;
            public static final List<Float> DEFAULT_POINTS = Collections.emptyList();
            public static final Integer DEFAULT_COLOR = 0;
            public static final Float DEFAULT_STROKE_WIDTH = Float.valueOf(0.0f);
            public static final Float DEFAULT_HARDNESS = Float.valueOf(0.0f);
            public static final Boolean DEFAULT_IS_ERASER = false;
            public static final Boolean DEFAULT_STRAIGHT_LINE = false;
            public static final PathStyle DEFAULT_PATH_STYLE = PathStyle.SMOOTH;
            public static final CapDecorationStyle DEFAULT_START_CAP = CapDecorationStyle.NONE;
            public static final CapDecorationStyle DEFAULT_END_CAP = CapDecorationStyle.NONE;

            public DrawingAction(DrawingActionType drawingActionType, List<Float> list, Integer num, Float f, Float f2, Boolean bool, Boolean bool2, PathStyle pathStyle, CapDecorationStyle capDecorationStyle, CapDecorationStyle capDecorationStyle2) {
                this.drawing_action_type = drawingActionType;
                this.points = immutableCopyOf(list);
                this.color = num;
                this.stroke_width = f;
                this.hardness = f2;
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
                if (i == 0) {
                    int hashCode = (((this.start_cap != null ? this.start_cap.hashCode() : 0) + (((this.path_style != null ? this.path_style.hashCode() : 0) + (((this.straight_line != null ? this.straight_line.hashCode() : 0) + (((this.is_eraser != null ? this.is_eraser.hashCode() : 0) + (((this.hardness != null ? this.hardness.hashCode() : 0) + (((this.stroke_width != null ? this.stroke_width.hashCode() : 0) + (((this.color != null ? this.color.hashCode() : 0) + (((this.points != null ? this.points.hashCode() : 1) + ((this.drawing_action_type != null ? this.drawing_action_type.hashCode() : 0) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37) + (this.end_cap != null ? this.end_cap.hashCode() : 0);
                    this.hashCode = hashCode;
                    return hashCode;
                }
                return i;
            }

            /* loaded from: classes.dex */
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

                public Builder(DrawingAction drawingAction) {
                    super(drawingAction);
                    if (drawingAction != null) {
                        this.drawing_action_type = drawingAction.drawing_action_type;
                        this.points = DrawingAction.copyOf(drawingAction.points);
                        this.color = drawingAction.color;
                        this.stroke_width = drawingAction.stroke_width;
                        this.hardness = drawingAction.hardness;
                        this.is_eraser = drawingAction.is_eraser;
                        this.straight_line = drawingAction.straight_line;
                        this.path_style = drawingAction.path_style;
                        this.start_cap = drawingAction.start_cap;
                        this.end_cap = drawingAction.end_cap;
                    }
                }

                public Builder drawing_action_type(DrawingActionType drawingActionType) {
                    this.drawing_action_type = drawingActionType;
                    return this;
                }

                public Builder points(List<Float> list) {
                    this.points = checkForNulls(list);
                    return this;
                }

                public Builder color(Integer num) {
                    this.color = num;
                    return this;
                }

                public Builder stroke_width(Float f) {
                    this.stroke_width = f;
                    return this;
                }

                public Builder hardness(Float f) {
                    this.hardness = f;
                    return this;
                }

                public Builder is_eraser(Boolean bool) {
                    this.is_eraser = bool;
                    return this;
                }

                public Builder straight_line(Boolean bool) {
                    this.straight_line = bool;
                    return this;
                }

                public Builder path_style(PathStyle pathStyle) {
                    this.path_style = pathStyle;
                    return this;
                }

                public Builder start_cap(CapDecorationStyle capDecorationStyle) {
                    this.start_cap = capDecorationStyle;
                    return this;
                }

                public Builder end_cap(CapDecorationStyle capDecorationStyle) {
                    this.end_cap = capDecorationStyle;
                    return this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.Message.a
                public DrawingAction build() {
                    return new DrawingAction(this);
                }
            }
        }

        /* loaded from: classes.dex */
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

        /* loaded from: classes.dex */
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

        /* loaded from: classes.dex */
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
        public static final class ColorEffect extends Message {
            public static final String DEFAULT_PRESET_NAME = "";
            private static final long serialVersionUID = 0;

            @n(a = 1, b = Message.Datatype.FLOAT)
            public final Float brightness;

            @n(a = 2, b = Message.Datatype.FLOAT)
            public final Float contrast;

            @n(a = 5, b = Message.Datatype.STRING)
            public final String preset_name;

            @n(a = 3, b = Message.Datatype.FLOAT)
            public final Float saturation;

            @n(a = 4, b = Message.Datatype.FIXED32)
            public final Integer tint_color;
            public static final Float DEFAULT_BRIGHTNESS = Float.valueOf(0.0f);
            public static final Float DEFAULT_CONTRAST = Float.valueOf(0.0f);
            public static final Float DEFAULT_SATURATION = Float.valueOf(0.0f);
            public static final Integer DEFAULT_TINT_COLOR = 0;

            public ColorEffect(Float f, Float f2, Float f3, Integer num, String str) {
                this.brightness = f;
                this.contrast = f2;
                this.saturation = f3;
                this.tint_color = num;
                this.preset_name = str;
            }

            private ColorEffect(Builder builder) {
                this(builder.brightness, builder.contrast, builder.saturation, builder.tint_color, builder.preset_name);
                setBuilder(builder);
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
                if (i == 0) {
                    int hashCode = (((this.tint_color != null ? this.tint_color.hashCode() : 0) + (((this.saturation != null ? this.saturation.hashCode() : 0) + (((this.contrast != null ? this.contrast.hashCode() : 0) + ((this.brightness != null ? this.brightness.hashCode() : 0) * 37)) * 37)) * 37)) * 37) + (this.preset_name != null ? this.preset_name.hashCode() : 0);
                    this.hashCode = hashCode;
                    return hashCode;
                }
                return i;
            }

            /* loaded from: classes.dex */
            public static final class Builder extends Message.a<ColorEffect> {
                public Float brightness;
                public Float contrast;
                public String preset_name;
                public Float saturation;
                public Integer tint_color;

                public Builder() {
                }

                public Builder(ColorEffect colorEffect) {
                    super(colorEffect);
                    if (colorEffect != null) {
                        this.brightness = colorEffect.brightness;
                        this.contrast = colorEffect.contrast;
                        this.saturation = colorEffect.saturation;
                        this.tint_color = colorEffect.tint_color;
                        this.preset_name = colorEffect.preset_name;
                    }
                }

                public Builder brightness(Float f) {
                    this.brightness = f;
                    return this;
                }

                public Builder contrast(Float f) {
                    this.contrast = f;
                    return this;
                }

                public Builder saturation(Float f) {
                    this.saturation = f;
                    return this;
                }

                public Builder tint_color(Integer num) {
                    this.tint_color = num;
                    return this;
                }

                public Builder preset_name(String str) {
                    this.preset_name = str;
                    return this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.Message.a
                public ColorEffect build() {
                    return new ColorEffect(this);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class KMProjectHeader extends Message {
        public static final String DEFAULT_BGM_THEME_ID = "";
        public static final String DEFAULT_THEME_ID = "";
        private static final long serialVersionUID = 0;

        @n(a = 102, b = Message.Datatype.STRING)
        public final String bgm_theme_id;

        @n(a = 3, b = Message.Datatype.UINT64)
        public final Long creation_time;

        @n(a = 5, b = Message.Datatype.BYTES)
        public final ByteString jpeg_thumbnail;

        @n(a = 4, b = Message.Datatype.UINT64)
        public final Long last_edit_time;

        @n(a = 100, b = Message.Datatype.BOOL)
        public final Boolean need_update_large_thumbnail;

        @n(a = 6, b = Message.Datatype.UINT64)
        public final Long project_uuid_lsb;

        @n(a = 7, b = Message.Datatype.UINT64)
        public final Long project_uuid_msb;

        @n(a = 1, b = Message.Datatype.UINT32)
        public final Integer project_version;

        @n(a = 2, b = Message.Datatype.UINT32)
        public final Integer saved_with_km_version;

        @n(a = 101, b = Message.Datatype.STRING)
        public final String theme_id;

        @n(a = 8, b = Message.Datatype.UINT32)
        public final Integer total_play_time;
        public static final Integer DEFAULT_PROJECT_VERSION = 0;
        public static final Integer DEFAULT_SAVED_WITH_KM_VERSION = 0;
        public static final Long DEFAULT_CREATION_TIME = 0L;
        public static final Long DEFAULT_LAST_EDIT_TIME = 0L;
        public static final ByteString DEFAULT_JPEG_THUMBNAIL = ByteString.EMPTY;
        public static final Boolean DEFAULT_NEED_UPDATE_LARGE_THUMBNAIL = false;
        public static final Long DEFAULT_PROJECT_UUID_LSB = 0L;
        public static final Long DEFAULT_PROJECT_UUID_MSB = 0L;
        public static final Integer DEFAULT_TOTAL_PLAY_TIME = 0;

        public KMProjectHeader(Integer num, Integer num2, Long l, Long l2, ByteString byteString, Boolean bool, Long l3, Long l4, String str, String str2, Integer num3) {
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
        }

        private KMProjectHeader(Builder builder) {
            this(builder.project_version, builder.saved_with_km_version, builder.creation_time, builder.last_edit_time, builder.jpeg_thumbnail, builder.need_update_large_thumbnail, builder.project_uuid_lsb, builder.project_uuid_msb, builder.theme_id, builder.bgm_theme_id, builder.total_play_time);
            setBuilder(builder);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof KMProjectHeader)) {
                return false;
            }
            KMProjectHeader kMProjectHeader = (KMProjectHeader) obj;
            return equals(this.project_version, kMProjectHeader.project_version) && equals(this.saved_with_km_version, kMProjectHeader.saved_with_km_version) && equals(this.creation_time, kMProjectHeader.creation_time) && equals(this.last_edit_time, kMProjectHeader.last_edit_time) && equals(this.jpeg_thumbnail, kMProjectHeader.jpeg_thumbnail) && equals(this.need_update_large_thumbnail, kMProjectHeader.need_update_large_thumbnail) && equals(this.project_uuid_lsb, kMProjectHeader.project_uuid_lsb) && equals(this.project_uuid_msb, kMProjectHeader.project_uuid_msb) && equals(this.theme_id, kMProjectHeader.theme_id) && equals(this.bgm_theme_id, kMProjectHeader.bgm_theme_id) && equals(this.total_play_time, kMProjectHeader.total_play_time);
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i == 0) {
                int hashCode = (((this.bgm_theme_id != null ? this.bgm_theme_id.hashCode() : 0) + (((this.theme_id != null ? this.theme_id.hashCode() : 0) + (((this.project_uuid_msb != null ? this.project_uuid_msb.hashCode() : 0) + (((this.project_uuid_lsb != null ? this.project_uuid_lsb.hashCode() : 0) + (((this.need_update_large_thumbnail != null ? this.need_update_large_thumbnail.hashCode() : 0) + (((this.jpeg_thumbnail != null ? this.jpeg_thumbnail.hashCode() : 0) + (((this.last_edit_time != null ? this.last_edit_time.hashCode() : 0) + (((this.creation_time != null ? this.creation_time.hashCode() : 0) + (((this.saved_with_km_version != null ? this.saved_with_km_version.hashCode() : 0) + ((this.project_version != null ? this.project_version.hashCode() : 0) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37) + (this.total_play_time != null ? this.total_play_time.hashCode() : 0);
                this.hashCode = hashCode;
                return hashCode;
            }
            return i;
        }

        /* loaded from: classes.dex */
        public static final class Builder extends Message.a<KMProjectHeader> {
            public String bgm_theme_id;
            public Long creation_time;
            public ByteString jpeg_thumbnail;
            public Long last_edit_time;
            public Boolean need_update_large_thumbnail;
            public Long project_uuid_lsb;
            public Long project_uuid_msb;
            public Integer project_version;
            public Integer saved_with_km_version;
            public String theme_id;
            public Integer total_play_time;

            public Builder() {
            }

            public Builder(KMProjectHeader kMProjectHeader) {
                super(kMProjectHeader);
                if (kMProjectHeader != null) {
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
                }
            }

            public Builder project_version(Integer num) {
                this.project_version = num;
                return this;
            }

            public Builder saved_with_km_version(Integer num) {
                this.saved_with_km_version = num;
                return this;
            }

            public Builder creation_time(Long l) {
                this.creation_time = l;
                return this;
            }

            public Builder last_edit_time(Long l) {
                this.last_edit_time = l;
                return this;
            }

            public Builder jpeg_thumbnail(ByteString byteString) {
                this.jpeg_thumbnail = byteString;
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

            public Builder theme_id(String str) {
                this.theme_id = str;
                return this;
            }

            public Builder bgm_theme_id(String str) {
                this.bgm_theme_id = str;
                return this;
            }

            public Builder total_play_time(Integer num) {
                this.total_play_time = num;
                return this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.Message.a
            public KMProjectHeader build() {
                return new KMProjectHeader(this);
            }
        }
    }
}

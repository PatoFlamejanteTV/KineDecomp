package com.google.android.gms.games.internal;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;

/* loaded from: classes.dex */
public final class GamesContract {

    /* loaded from: classes.dex */
    public interface AccountMetadataColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1317a = {"account_name", "external_player_id", "match_sync_token", "last_package_scan_timestamp", "quest_sync_token", "quest_sync_metadata_token", "request_sync_token", "xp_sync_token", "cover_photo_image_id", "cover_photo_image_uri", "cover_photo_image_url"};
    }

    /* loaded from: classes.dex */
    public interface AchievementDefinitionsColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1318a = {"game_id", "external_achievement_id", "type", "name", "description", "unlocked_icon_image_id", "unlocked_icon_image_uri", "unlocked_icon_image_url", "revealed_icon_image_id", "revealed_icon_image_uri", "revealed_icon_image_url", "total_steps", "formatted_total_steps", "initial_state", "sorting_rank", "definition_xp_value"};
    }

    /* loaded from: classes.dex */
    public interface AchievementInstancesColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1319a = {"definition_id", "player_id", "state", "current_steps", "formatted_current_steps", "last_updated_timestamp", "instance_xp_value"};
    }

    /* loaded from: classes.dex */
    public interface AchievementPendingOpsColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1320a = {"client_context_id", "external_achievement_id", "achievement_type", "new_state", "steps_to_increment", "min_steps_to_set", "external_game_id", "external_player_id"};
    }

    /* loaded from: classes.dex */
    public interface AclsColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1321a = {"specified_by_user", "pacl"};
    }

    /* loaded from: classes.dex */
    public interface AppContentActionColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1322a = {"action_id", "action_annotation", "action_conditions", "action_content_description", "action_data", "overflow_text", ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE};
    }

    /* loaded from: classes.dex */
    public interface AppContentAnnotationColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1323a = {"annotation_id", "annotation_description", "annotation_image_default_id", "annotation_image_height", "annotation_image_uri", "annotation_image_width", "annotation_layout_slot", "annotation_modifiers", "annotation_title"};
    }

    /* loaded from: classes.dex */
    public interface AppContentCardColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1324a = {"card_actions", "card_annotations", "card_id", "card_conditions", "card_content_description", "card_current_steps", "card_data", "card_description", "card_subtitle", "card_title", "card_total_steps", "card_type"};
    }

    /* loaded from: classes.dex */
    public interface AppContentColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1325a = {"experiments", "json", "page_token", "screen_name", "server_cookie"};
    }

    /* loaded from: classes.dex */
    public interface AppContentConditionColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1326a = {"condition_id", "condition_default_value", "condition_expected_value", "condition_predicate", "condition_predicate_parameters"};
    }

    /* loaded from: classes.dex */
    public interface AppContentSectionColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1327a = {"section_actions", "section_annotations", "section_card_type", "section_content_description", "section_data", "section_description", "section_id", "section_subtitle", "section_title", "section_type"};
    }

    /* loaded from: classes.dex */
    public interface AppContentTupleColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1328a = {"tuple_name", "tuple_id", "tuple_value"};
    }

    /* loaded from: classes.dex */
    public interface ApplicationSessionColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1329a = {"client_context_id", "end_time", "external_game_id", "session_id", "start_time", "ad_id", "limit_ad_tracking"};
    }

    /* loaded from: classes.dex */
    public interface ClientContextsColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1330a = {"package_name", "package_uid", "account_name"};
    }

    /* loaded from: classes.dex */
    public interface ContactSettingsColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1331a = {"mobile_notifications_enabled", "match_notifications_enabled", "quest_notifications_enabled", "request_notifications_enabled", "level_notifications_enabled"};
    }

    /* loaded from: classes.dex */
    public interface EventDefinitionColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1332a = {"event_definitions_game_id", "external_event_id", "name", "description", "visibility", "icon_image_id", "icon_image_uri", "icon_image_url", "sorting_rank"};
    }

    /* loaded from: classes.dex */
    public interface EventInstancesColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1333a = {"definition_id", "player_id", "formatted_value", "last_updated_timestamp"};
    }

    /* loaded from: classes.dex */
    public interface EventPendingOpsColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1334a = {"client_context_id", "instance_id", "window_start_time", "window_end_time", "increment", "request_id"};
    }

    /* loaded from: classes.dex */
    public interface ExperienceEventColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1335a = {"external_experience_id", "game_id", "created_timestamp", "current_xp", "xp_earned", "display_title", "display_description", "display_string", "type", "icon_id", "icon_url", "icon_uri", "newLevel"};
    }

    /* loaded from: classes.dex */
    public interface GameBadgesColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1336a = {"badge_game_id", "badge_type", "badge_title", "badge_description", "badge_icon_image_id", "badge_icon_image_uri"};
    }

    /* loaded from: classes.dex */
    public interface GameInstancesColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1337a = {"instance_game_id", "real_time_support", "turn_based_support", "platform_type", "instance_display_name", "package_name", "piracy_check", "installed", "preferred", "gamepad_support"};
        public static final String[] b = {"installed", "package_name", "real_time_support", "turn_based_support", "gamepad_support"};
    }

    /* loaded from: classes.dex */
    public interface GameSearchSuggestionsColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1338a = {"suggestion"};
    }

    /* loaded from: classes.dex */
    public interface GamesColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1339a = {"external_game_id", "display_name", "primary_category", "secondary_category", "developer_name", "game_description", "game_icon_image_id", "game_icon_image_uri", "game_icon_image_url", "game_hi_res_image_id", "game_hi_res_image_uri", "game_hi_res_image_url", "featured_image_id", "featured_image_uri", "featured_image_url", "screenshot_image_ids", "video_url", "play_enabled_game", "last_played_server_time", "last_connection_local_time", "last_synced_local_time", "metadata_version", "sync_token", "target_instance", "gameplay_acl_status", "achievement_total_count", "leaderboard_count", "muted", "identity_sharing_confirmed", "snapshots_enabled", "theme_color"};
    }

    /* loaded from: classes.dex */
    public interface ImagesColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1340a = {"url", "local", "filesize", "download_timestamp"};
    }

    /* loaded from: classes.dex */
    public interface InvitationsColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1341a = {"game_id", "external_invitation_id", "external_inviter_id", "creation_timestamp", "last_modified_timestamp", "description", "type", "variant", "has_automatch_criteria", "automatch_min_players", "automatch_max_players", "inviter_in_circles"};
    }

    /* loaded from: classes.dex */
    public interface LeaderboardInstancesColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1342a = {"leaderboard_id", "timespan", "collection", "player_raw_score", "player_display_score", "player_rank", "player_display_rank", "player_score_tag", "total_scores", "top_page_token_next", "window_page_token_prev", "window_page_token_next"};
    }

    /* loaded from: classes.dex */
    public interface LeaderboardScoresColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1343a = {"instance_id", "page_type", "player_id", "default_display_name", "default_display_image_id", "default_display_image_uri", "default_display_image_url", "rank", "display_rank", "raw_score", "display_score", "achieved_timestamp", "score_tag"};
    }

    /* loaded from: classes.dex */
    public interface LeaderboardsColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1344a = {"game_id", "external_leaderboard_id", "name", "board_icon_image_id", "board_icon_image_uri", "board_icon_image_url", "sorting_rank", "score_order"};
    }

    /* loaded from: classes.dex */
    public interface MatchesColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1345a = {"game_id", "external_match_id", "creator_external", "creation_timestamp", "last_updater_external", "last_updated_timestamp", "pending_participant_external", ShareConstants.WEB_DIALOG_PARAM_DATA, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "description", ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "variant", "notification_text", "user_match_status", "has_automatch_criteria", "automatch_min_players", "automatch_max_players", "automatch_bit_mask", "automatch_wait_estimate_sec", "rematch_id", "match_number", "previous_match_data", "upsync_required", "description_participant_id"};
    }

    /* loaded from: classes.dex */
    public interface MatchesPendingOpsColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1346a = {"client_context_id", "type", "external_game_id", "external_match_id", "pending_participant_id", ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "is_turn", "results"};
    }

    /* loaded from: classes.dex */
    public interface MilestoneColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1347a = {"completion_reward_data", "event_instance_id", "external_milestone_id", "initial_value", "quest_id", "milestones_sorting_rank", "milestone_state", "target_value"};
    }

    /* loaded from: classes.dex */
    public interface NotificationsColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1348a = {"notification_id", "game_id", "external_sub_id", "type", "image_id", "ticker", ShareConstants.WEB_DIALOG_PARAM_TITLE, "text", "coalesced_text", "timestamp", "acknowledged", "alert_level"};
    }

    /* loaded from: classes.dex */
    public interface PageType {
    }

    /* loaded from: classes.dex */
    public interface ParticipantsColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1349a = {"match_id", "invitation_id", "external_participant_id", "player_id", "default_display_image_id", "default_display_image_url", "default_display_hi_res_image_id", "default_display_hi_res_image_url", "default_display_name", "player_status", "client_address", "result_type", "placing", "connected", "capabilities"};
    }

    /* loaded from: classes.dex */
    public interface PlayerLevelColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1350a = {"level_value", "level_min_xp", "level_max_xp", ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION};
    }

    /* loaded from: classes.dex */
    public interface PlayerStatsColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1351a = {"ave_session_length_minutes", "churn_probability", "days_since_last_played", "game_id", "num_purchases", "num_sessions", "num_sessions_percentile", "player_id", "spend_percentile"};
    }

    /* loaded from: classes.dex */
    public interface PlayersColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1352a = {"external_player_id", "profile_icon_image_id", "profile_hi_res_image_id", "profile_icon_image_uri", "profile_icon_image_url", "profile_hi_res_image_uri", "profile_hi_res_image_url", "profile_name", "last_updated", "is_in_circles", "has_all_public_acls", "has_debug_access", "is_profile_visible", "current_xp_total", "current_level", "current_level_min_xp", "current_level_max_xp", "next_level", "next_level_max_xp", "last_level_up_timestamp", "player_title", "most_recent_external_game_id", "most_recent_game_name", "most_recent_activity_timestamp", "most_recent_game_icon_id", "most_recent_game_icon_uri", "most_recent_game_hi_res_id", "most_recent_game_hi_res_uri", "most_recent_game_featured_id", "most_recent_game_featured_uri", "gamer_tag", "real_name"};
    }

    /* loaded from: classes.dex */
    public interface ProfileSettingsColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1353a = {"profile_visible", "profile_visibility_explicitly_set"};
    }

    /* loaded from: classes.dex */
    public interface QuestsColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1354a = {"accepted_ts", "quest_banner_image_id", "quest_banner_image_uri", "quest_banner_image_url", "quest_description", "quest_end_ts", "external_quest_id", "game_id", "quest_icon_image_id", "quest_icon_image_uri", "quest_icon_image_url", "quest_last_updated_ts", "quest_name", "notified", "notification_ts", "quest_start_ts", "quest_state", "quest_type"};
    }

    /* loaded from: classes.dex */
    public interface RequestPendingOpsColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1355a = {"client_context_id", "external_request_id", "external_game_id"};
    }

    /* loaded from: classes.dex */
    public interface RequestRecipientsColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1356a = {"request_id", "player_id", "recipient_status"};
    }

    /* loaded from: classes.dex */
    public interface RequestSummaryColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1357a = {"wish_count", "gift_count", "player_count"};
    }

    /* loaded from: classes.dex */
    public interface RequestsColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1358a = {"external_request_id", "game_id", "sender_id", ShareConstants.WEB_DIALOG_PARAM_DATA, "type", "creation_timestamp", "expiration_timestamp", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS};
    }

    /* loaded from: classes.dex */
    public interface SnapshotColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f1359a = {"game_id", "owner_id", "external_snapshot_id", "drive_resolved_id_string", "drive_resource_id_string", "cover_icon_image_id", "cover_icon_image_uri", "cover_icon_image_url", "cover_icon_image_width", "cover_icon_image_height", ShareConstants.WEB_DIALOG_PARAM_TITLE, "description", "last_modified_timestamp", "duration", "unique_name", "visible", "pending_change_count", "progress_value", "device_name"};
    }
}

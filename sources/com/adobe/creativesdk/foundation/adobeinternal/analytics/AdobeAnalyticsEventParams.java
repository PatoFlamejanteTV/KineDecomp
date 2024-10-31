package com.adobe.creativesdk.foundation.adobeinternal.analytics;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public interface AdobeAnalyticsEventParams {

    /* loaded from: classes.dex */
    public enum Consumer implements AdobeAnalyticsEventParams {
        AdobeEventPropertyConsumerClientId("consumer.client_id"),
        AdobeEventPropertyConsumerName("consumer.name"),
        AdobeEventPropertyConsumerVersion("consumer.version"),
        AdobeEventPropertyConsumerPlatform("consumer.platform"),
        AdobeEventPropertyConsumerDevice("consumer.device"),
        AdobeEventPropertyConsumerOSVersion("consumer.os_version"),
        AdobeEventPropertyConsumerAppStoreId("consumer.app_store_id");

        private static Map<String, Consumer> _map = new HashMap();
        private final String value;

        static {
            for (Consumer consumer : values()) {
                _map.put(consumer.value, consumer);
            }
        }

        Consumer(String str) {
            this.value = str;
        }

        static Consumer fromString(String str) {
            return _map.get(str);
        }

        @Override // com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams
        public String getValue() {
            return this.value;
        }
    }

    /* loaded from: classes.dex */
    public enum Content implements AdobeAnalyticsEventParams {
        AdobeEventPropertyContentId("content.id"),
        AdobeEventPropertyContentName("content.name"),
        AdobeEventPropertyContentType("content.type"),
        AdobeEventPropertyContentMimeType("content.mimetype"),
        AdobeEventPropertyContentStatus("content.status"),
        AdobeEventPropertyContentWidth("content.width"),
        AdobeEventPropertyContentHeight("content.height"),
        AdobeEventPropertyContentSize("content.size"),
        AdobeEventPropertyContentCategory("content.category"),
        AdobeEventPropertyContentExtension("content.extension");

        private static Map<String, Content> _map = new HashMap();
        private final String value;

        static {
            for (Content content : values()) {
                _map.put(content.value, content);
            }
        }

        Content(String str) {
            this.value = str;
        }

        static Content fromString(String str) {
            return _map.get(str);
        }

        @Override // com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams
        public String getValue() {
            return this.value;
        }
    }

    /* loaded from: classes.dex */
    public enum Core implements AdobeAnalyticsEventParams {
        AdobeEventPropertyGuid("event.guid"),
        AdobeEventPropertyUser("event.user_guid"),
        AdobeEventPropertyVisitor("event.visitor_guid"),
        AdobeEventPropertyCloud("event.cloud_id"),
        AdobeEventPropertyContext("event.context_guid"),
        AdobeEventPropertyContextSequence("event.context_sequence"),
        AdobeEventPropertyType("event.type"),
        AdobeEventPropertyStart("event.dts_start"),
        AdobeEventPropertyEnd("event.dts_end"),
        AdobeEventPropertyWorkflow("event.workflow"),
        AdobeEventPropertyCategory("event.category"),
        AdobeEventPropertySubCategory("event.subcategory"),
        AdobeEventPropertyOffline("event.offline"),
        AdobeEventPropertyDevice("event.device_guid"),
        AdobeEventPropertyIMSFlow("event.idp"),
        AdobeEventPropertySession("event.session_guid"),
        AdobeEventPropertyError("event.error_code"),
        AdobeEventPropertyLanguage("event.language"),
        AdobeEventPropertySubType("event.subtype"),
        AdobeEventPropertyCollection("event.coll_dts"),
        AdobeEventPropertyIPAddress("event.ip"),
        AdobeEventPropertyPagename("event.pagename"),
        AdobeEventPropertyUserAgent("event.user_agent"),
        AdobeEventPropertyErrorType("event.error_type"),
        AdobeEventPropertyErrorDescription("event.error_desc"),
        AdobeEventPropertyCount("event.count"),
        AdobeEventPropertyValue("event.value");

        private static Map<String, Core> _map = new HashMap();
        private final String value;

        static {
            for (Core core : values()) {
                _map.put(core.value, core);
            }
        }

        Core(String str) {
            this.value = str;
        }

        static Core fromString(String str) {
            return _map.get(str);
        }

        @Override // com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams
        public String getValue() {
            return this.value;
        }
    }

    /* loaded from: classes.dex */
    public enum Environment implements AdobeAnalyticsEventParams {
        AdobeEventPropertyFrameworkName("env.fw.name"),
        AdobeEventPropertyFrameworkVersion("env.fw.version"),
        AdobeEventPropertyComponentName("env.com.name"),
        AdobeEventPropertyComponentVersion("env.com.version"),
        AdobeEventPropertyServiceName("env.svc.name"),
        AdobeEventPropertyServiceVersion("env.svc.version"),
        AdobeEventPropertyServiceAPIName("env.api.name"),
        AdobeEventPropertyServiceAPIVersion("env.api.version");

        private static Map<String, Environment> _map = new HashMap();
        private final String value;

        static {
            for (Environment environment : values()) {
                _map.put(environment.value, environment);
            }
        }

        Environment(String str) {
            this.value = str;
        }

        static Environment fromString(String str) {
            return _map.get(str);
        }

        @Override // com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams
        public String getValue() {
            return this.value;
        }
    }

    /* loaded from: classes.dex */
    public enum Source implements AdobeAnalyticsEventParams {
        AdobeEventPropertyClientId("source.client_id"),
        AdobeEventPropertyAppName("source.name"),
        AdobeEventPropertyAppVersion("source.version"),
        AdobeEventPropertyPlatform("source.platform"),
        AdobeEventPropertyDeviceType("source.device"),
        AdobeEventPropertyOSVersion("source.os_version"),
        AdobeEventPropertyAppStoreId("source.app_store_id"),
        AdobeEventPropertySubPlatform("source.subplatform");

        private static Map<String, Source> _map = new HashMap();
        private final String value;

        static {
            for (Source source : values()) {
                _map.put(source.value, source);
            }
        }

        Source(String str) {
            this.value = str;
        }

        static Source fromString(String str) {
            return _map.get(str);
        }

        @Override // com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams
        public String getValue() {
            return this.value;
        }
    }

    /* loaded from: classes.dex */
    public enum Type implements AdobeAnalyticsEventParams {
        AdobeEventTypeAppLaunch("app.launch"),
        AdobeEventTypeAppInactive("app.inactive"),
        AdobeEventTypeAppActive("app.active"),
        AdobeEventTypeAppOffline("app.offline"),
        AdobeEventTypeAppOnline("app.online"),
        AdobeEventTypeAppLogin("app.login"),
        AdobeEventTypeAppLogout("app.logout"),
        AdobeEventTypeAppSignup("app.signup"),
        AdobeEventTypeAppCapture("app.capture"),
        AdobeEventTypeAppCaptureN("app.captureN"),
        AdobeEventTypeAppCreate("app.create"),
        AdobeEventTypeAppDelete("app.delete"),
        AdobeEventTypeAppDownload("app.download"),
        AdobeEventTypeAppEdit("app.edit"),
        AdobeEventTypeAppEmbed("app.embed"),
        AdobeEventTypeAppEmbedN("app.embedN"),
        AdobeEventTypeAppFilter("app.filter"),
        AdobeEventTypeAppInstall("app.install"),
        AdobeEventTypeAppPreview("app.preview"),
        AdobeEventTypeAppSavePreview("app.save_preview"),
        AdobeEventTypeAppLicense("app.license"),
        AdobeEventTypeAppOpen("app.open"),
        AdobeEventTypeAppPick("app.pick"),
        AdobeEventTypeAppProfile("app.profile"),
        AdobeEventTypeAppSearch("app.search"),
        AdobeEventTypeAppSelect("app.select_app"),
        AdobeEventTypeAppSend("app.send"),
        AdobeEventTypeAppSort("app.sort"),
        AdobeEventTypeAppOrientationFilter("app.orientation_filter"),
        AdobeEventTypeAppUpdate("app.update"),
        AdobeEventTypeAppView("app.view"),
        AdobeEventTypeAppStart("app.start"),
        AdobeEventTypeAppChange("app.change"),
        AdobeEventTypeAppSave("app.save"),
        AdobeEventTypeAppComplete("app.complete"),
        AdobeEventTypeAppCancelAndReturn("app.cancel_return"),
        AdobeEventTypeAppSaveAndReturn("app.save_return"),
        AdobeEventTypeAppStartSecondaryApp("app.start_sec_app"),
        AdobeEventTypeCloudChanged("cloud.changed"),
        AdobeETSEventTypeAppUploadStart("app.upload_start"),
        AdobeETSEventTypeAppUploadSuccess("app.upload_success"),
        AdobeETSEventTypeAppUploadFailure("app.upload_failure"),
        AdobeEventTypeAppStore("app.app_store"),
        AdobeETSEventTypeAppCheckUserContributionEligibilityStart("app.user_contribution_eligibility_check_start"),
        AdobeETSEventTypeAppCheckUserContributionEligibilitySuccess("app.user_contribution_eligibility_check_success"),
        AdobeETSEventTypeAppCheckUserContributionEligibilityFailure("app.user_contribution_eligibility_check_failure"),
        AdobeETSEventTypeAppCheckAssetContributionEligibilityStart("app.asset_contribution_eligibility_check_start"),
        AdobeETSEventTypeAppCheckAssetContributionEligibilitySuccess("app.asset_contribution_eligibility_check_success"),
        AdobeETSEventTypeAppCheckAssetContributionEligibilityFailure("app.asset_contribution_eligibility_check_failure");

        private static Map<String, Type> _map = new HashMap();
        private final String value;

        static {
            for (Type type : values()) {
                _map.put(type.value, type);
            }
        }

        Type(String str) {
            this.value = str;
        }

        static Type fromString(String str) {
            return _map.get(str);
        }

        @Override // com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams
        public String getValue() {
            return this.value;
        }
    }

    /* loaded from: classes.dex */
    public enum UI implements AdobeAnalyticsEventParams {
        AdobeEventPropertyUiViewType("ui.view_type"),
        AdobeEventPropertyUiSearchKeyword("ui.search_keyword"),
        AdobeEventPropertyUiOrientation("ui.orientation"),
        AdobeEventPropertyUiFilter("ui.filter"),
        AdobeEventPropertyUiSortOrder("ui.sort_order");

        private static Map<String, UI> _map = new HashMap();
        private final String value;

        static {
            for (UI ui : values()) {
                _map.put(ui.value, ui);
            }
        }

        UI(String str) {
            this.value = str;
        }

        static UI fromString(String str) {
            return _map.get(str);
        }

        @Override // com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams
        public String getValue() {
            return this.value;
        }
    }

    String getValue();
}

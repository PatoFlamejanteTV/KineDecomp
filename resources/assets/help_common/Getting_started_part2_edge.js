/*jslint */
/*global AdobeEdge: false, window: false, document: false, console:false, alert: false */
(function (compId) {

    "use strict";
    var im='images/',
        aud='media/',
        vid='media/',
        js='js/',
        fonts = {
            'roboto': '',
            '\'roboto regular\'': ''        },
        opts = {
            'gAudioPreloadPreference': 'auto',
            'gVideoPreloadPreference': 'auto'
        },
        resources = [
        ],
        scripts = [
        ],
        symbols = {
            "stage": {
                version: "6.0.0",
                minimumCompatibleVersion: "5.0.0",
                build: "6.0.0.400",
                scaleToFit: "none",
                centerStage: "none",
                resizeInstances: false,
                content: {
                    dom: [
                        {
                            id: 'Symbol_1',
                            symbolName: 'Symbol_1',
                            type: 'rect',
                            rect: ['-710px', '-399px', '1920', '1080', 'auto', 'auto'],
                            transform: [[],[],[],['0.26042','0.26042']]
                        }
                    ],
                    style: {
                        '${Stage}': {
                            isStage: true,
                            rect: ['null', 'null', '500px', '281px', 'auto', 'auto'],
                            overflow: 'hidden',
                            fill: ["rgba(42,42,42,1.00)"]
                        }
                    }
                },
                timeline: {
                    duration: 21250,
                    autoPlay: false,
                    labels: {
                        "loop": 0
                    },
                    data: [
                            [ "eid295", "trigger", 0, function executeSymbolFunction(e, data) { this._executeSymbolAction(e, data); }, ['play', '${Symbol_1}', [0] ] ]
                    ]
                }
            },
            "Symbol_1": {
                version: "6.0.0",
                minimumCompatibleVersion: "5.0.0",
                build: "6.0.0.400",
                scaleToFit: "none",
                centerStage: "none",
                resizeInstances: false,
                content: {
                    dom: [
                        {
                            id: '_03_01_01_Editing_Scene4',
                            type: 'image',
                            rect: ['0px', '0px', '1920px', '1080px', 'auto', 'auto'],
                            fill: ['rgba(0,0,0,0)', 'images/03_01_01_editing_scene.jpg', '0px', '0px']
                        },
                        {
                            id: 'audio_clip_1',
                            type: 'image',
                            rect: ['1062px', '947px', '739px', '62px', 'auto', 'auto'],
                            fill: ['rgba(0,0,0,0)', 'images/audio_clip_1.jpg', '0px', '0px']
                        },
                        {
                            id: 'kinemaster_source_video_clip2',
                            type: 'image',
                            rect: ['176px', '92px', '1140px', '637px', 'auto', 'auto'],
                            fill: ['rgba(0,0,0,0)', 'images/kinemaster_source_video_clip2.png', '0px', '0px']
                        },
                        {
                            id: 'clip_thumbnail_1',
                            type: 'image',
                            rect: ['1062px', '809px', '200px', '124px', 'auto', 'auto'],
                            fill: ['rgba(0,0,0,0)', 'images/clip_thumbnail_1.jpg', '0px', '0px']
                        },
                        {
                            id: 'clip_thumbnail_2',
                            type: 'image',
                            rect: ['1369px', '809px', '200px', '124px', 'auto', 'auto'],
                            fill: ['rgba(0,0,0,0)', 'images/clip_thumbnail_2.jpg', '0px', '0px']
                        },
                        {
                            rect: ['1288px', '843px', '56px', '55px', 'auto', 'auto'],
                            id: 'transition_effect_theme_change_icon2',
                            opacity: '1',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/transition_effect_theme_change_icon.jpg', '0px', '0px']
                        },
                        {
                            rect: ['9px', '474px', '154px', '124px', 'auto', 'auto'],
                            id: 'share_btn_pressed',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/share_btn_pressed.jpg', '0px', '0px']
                        },
                        {
                            rect: ['0px', '0px', '1920px', '1080px', 'auto', 'auto'],
                            id: '_01_04_project_list_Detail_Share',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/01_04_project_list_detail_share.jpg', '0px', '0px']
                        },
                        {
                            rect: ['0px', '0px', '1920px', '1080px', 'auto', 'auto'],
                            id: '_01_07_Project_list_Share_Subscriptions-2_help',
                            opacity: '0.000000',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/01_07_project_list_share_subscriptions_help.jpg', '0px', '0px']
                        },
                        {
                            rect: ['0px', '0px', '1920px', '1080px', 'auto', 'auto'],
                            id: '_01_01_06_Project_list_Share_Export_help',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/01_01_06_project_list_share_export_help.jpg', '0px', '0px']
                        },
                        {
                            rect: ['963px', '580px', '460px', '365px', 'auto', 'auto'],
                            id: 'annual_subscription_btn_pressed3',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/annual_subscription_btn_pressed.jpg', '0px', '0px']
                        },
                        {
                            rect: ['1026px', '340px', '669px', '157px', 'auto', 'auto'],
                            id: 'quality_btn_pressed',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/quality_btn_pressed.jpg', '0px', '0px']
                        },
                        {
                            transform: [[], [], [], ['0.66544']],
                            rect: ['919px', '497px', 'auto', 'auto', 'auto', 'auto'],
                            font: ['roboto', [45, 'px'], 'rgba(0,0,0,1.00)', '100', 'none', '', 'break-word', 'nowrap'],
                            text: 'Summer weekend ',
                            id: 'Text_summer_weekend',
                            opacity: '0',
                            clip: 'rect(0px 133.12890625px 59px 0px)',
                            type: 'text'
                        },
                        {
                            rect: ['1321px', '890px', '384px', '110px', 'auto', 'auto'],
                            id: 'export_share_btn_pressed',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/export_share_btn_pressed.jpg', '0px', '0px']
                        },
                        {
                            rect: ['541px', '384px', '844px', '392px', 'auto', 'auto'],
                            id: 'subscription',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/subscription.jpg', '0px', '0px']
                        },
                        {
                            rect: ['473px', '203px', '1107px', '744px', 'auto', 'auto'],
                            id: '_01_01_08_Project_list_Share_ExportExport_Share_Popup_help',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/01_01_08_project_list_share_export_share_popup_help.jpg', '0px', '0px']
                        },
                        {
                            rect: ['573px', '554px', '906px', '9px', 'auto', 'auto'],
                            stroke: [0, 'rgba(0,0,0,1)', 'none'],
                            id: 'loading_bar',
                            opacity: '0',
                            type: 'rect',
                            fill: ['rgba(251,133,0,1.00)']
                        },
                        {
                            rect: ['574px', '552px', '1px', '11px', 'auto', 'auto'],
                            id: 'export_loading_bar',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/export_loading_bar.jpg', '0px', '0px']
                        },
                        {
                            rect: ['0px', '74px', '1920px', '1008px', 'auto', 'auto'],
                            id: 'youtube_export_ui',
                            opacity: '0.000000',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/youtube_export_ui.png', '0px', '0px']
                        },
                        {
                            rect: ['67px', '340px', 'auto', 'auto', 'auto', 'auto'],
                            font: ['roboto', [45, 'px'], 'rgba(0,0,0,1)', '100', 'none solid rgb(0, 0, 0)', 'normal', 'break-word', 'nowrap'],
                            align: 'left',
                            id: 'Text_Title',
                            opacity: '0',
                            text: 'Title',
                            type: 'text'
                        },
                        {
                            font: ['roboto', [45, 'px'], 'rgba(0,0,0,1)', '100', 'none solid rgb(0, 0, 0)', 'normal', 'break-word', 'nowrap'],
                            rect: ['62px', '340px', 'auto', 'auto', 'auto', 'auto'],
                            align: 'left',
                            text: 'Hello KineMaster!!',
                            id: 'Text_hello_kinemaster',
                            opacity: '0',
                            clip: 'rect(0px 325.4970703125px 59px 0px)',
                            type: 'text'
                        },
                        {
                            rect: ['1062px', '542px', '110px', '110px', 'auto', 'auto'],
                            borderRadius: ['50%', '50%', '50%', '50%'],
                            stroke: [0, 'rgba(0,0,0,1)', 'none'],
                            id: 'Ellipse',
                            opacity: '0',
                            type: 'ellipse',
                            fill: ['rgba(213,213,213,1.00)']
                        },
                        {
                            rect: ['1733px', '158px', '135px', '160px', 'auto', 'auto'],
                            id: 'hand',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/hand.png', '0px', '0px']
                        },
                        {
                            id: 'Group',
                            type: 'group',
                            rect: ['5px', '2px', '1920', '1080', 'auto', 'auto'],
                            c: [
                            {
                                rect: ['-5px', '0px', '1920px', '1080px', 'auto', 'auto'],
                                id: 'black_out',
                                opacity: '0',
                                type: 'image',
                                fill: ['rgba(0,0,0,0)', 'images/black_out.jpg', '0px', '0px']
                            },
                            {
                                rect: ['0px', '0px', '1920px', '1080px', 'auto', 'auto'],
                                stroke: [0, 'rgba(0,0,0,1)', 'none'],
                                id: 'Rectangle',
                                opacity: '0.6016260385513306',
                                type: 'rect',
                                fill: ['rgba(0,0,0,1.00)']
                            },
                            {
                                rect: ['784px', '405px', '341px', '341px', 'auto', 'auto'],
                                id: 'btn_media_detail_play_nor',
                                opacity: '1',
                                type: 'image',
                                fill: ['rgba(0,0,0,0)', 'images/btn_media_detail_play_nor.png', '0px', '0px']
                            }]
                        }
                    ],
                    style: {
                        '${symbolSelector}': {
                            isStage: 'true',
                            rect: [undefined, undefined, '1920px', '1080px']
                        }
                    }
                },
                timeline: {
                    duration: 21250,
                    autoPlay: true,
                    labels: {
                        "loop": 0
                    },
                    data: [
                        [
                            "eid469",
                            "opacity",
                            0,
                            0,
                            "easeOutQuart",
                            "${black_out}",
                            '0',
                            '0'
                        ],
                        [
                            "eid466",
                            "opacity",
                            19500,
                            1750,
                            "easeOutQuart",
                            "${black_out}",
                            '0',
                            '1'
                        ],
                        [
                            "eid17",
                            "opacity",
                            1640,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '0',
                            '0'
                        ],
                        [
                            "eid12",
                            "opacity",
                            1967,
                            573,
                            "easeOutQuad",
                            "${Ellipse}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid37",
                            "opacity",
                            3921,
                            573,
                            "easeOutQuad",
                            "${Ellipse}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid54",
                            "opacity",
                            5097,
                            573,
                            "easeOutQuad",
                            "${Ellipse}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid350",
                            "opacity",
                            7000,
                            573,
                            "easeOutQuad",
                            "${Ellipse}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid367",
                            "opacity",
                            8986,
                            573,
                            "easeOutQuad",
                            "${Ellipse}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid393",
                            "opacity",
                            13335,
                            573,
                            "easeOutQuad",
                            "${Ellipse}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid447",
                            "opacity",
                            17427,
                            573,
                            "easeOutQuad",
                            "${Ellipse}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid279",
                            "opacity",
                            9708,
                            128,
                            "easeOutQuad",
                            "${_01_01_08_Project_list_Share_ExportExport_Share_Popup_help}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid290",
                            "opacity",
                            11726,
                            225,
                            "easeOutQuart",
                            "${_01_01_08_Project_list_Share_ExportExport_Share_Popup_help}",
                            '1',
                            '0'
                        ],
                        [
                            "eid470",
                            "opacity",
                            0,
                            0,
                            "easeOutQuart",
                            "${youtube_export_ui}",
                            '0.000000',
                            '0.000000'
                        ],
                        [
                            "eid377",
                            "opacity",
                            11726,
                            225,
                            "easeOutQuart",
                            "${youtube_export_ui}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid11",
                            "height",
                            1967,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid35",
                            "height",
                            3921,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid52",
                            "height",
                            5097,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid349",
                            "height",
                            7000,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid366",
                            "height",
                            8986,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid392",
                            "height",
                            13335,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid446",
                            "height",
                            17427,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid328",
                            "top",
                            6243,
                            0,
                            "easeOutQuad",
                            "${quality_btn_pressed}",
                            '340px',
                            '340px'
                        ],
                        [
                            "eid7",
                            "left",
                            1090,
                            797,
                            "easeOutCubic",
                            "${hand}",
                            '935px',
                            '68px'
                        ],
                        [
                            "eid31",
                            "left",
                            2970,
                            780,
                            "easeOutQuad",
                            "${hand}",
                            '68px',
                            '1062px'
                        ],
                        [
                            "eid489",
                            "left",
                            6243,
                            470,
                            "easeOutQuad",
                            "${hand}",
                            '1062px',
                            '1234px'
                        ],
                        [
                            "eid67",
                            "left",
                            8127,
                            518,
                            "easeOutQuad",
                            "${hand}",
                            '1234px',
                            '1209px'
                        ],
                        [
                            "eid387",
                            "left",
                            12509,
                            491,
                            "easeOutQuad",
                            "${hand}",
                            '1209px',
                            '762px'
                        ],
                        [
                            "eid441",
                            "left",
                            16636,
                            614,
                            "easeOutCubic",
                            "${hand}",
                            '762px',
                            '1733px'
                        ],
                        [
                            "eid318",
                            "left",
                            1967,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '66px',
                            '66px'
                        ],
                        [
                            "eid320",
                            "left",
                            3921,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '66px',
                            '1061px'
                        ],
                        [
                            "eid472",
                            "left",
                            5097,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '1061px',
                            '1057px'
                        ],
                        [
                            "eid474",
                            "left",
                            7000,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '1057px',
                            '1226px'
                        ],
                        [
                            "eid396",
                            "left",
                            8986,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '1226px',
                            '1206px'
                        ],
                        [
                            "eid399",
                            "left",
                            13335,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '1206px',
                            '756px'
                        ],
                        [
                            "eid450",
                            "left",
                            17427,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '756px',
                            '1730px'
                        ],
                        [
                            "eid409",
                            "clip",
                            13908,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            [0,2.36083984375,59,0],
                            [0,2.36083984375,59,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid410",
                            "clip",
                            14104,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            [0,2.36083984375,59,0],
                            [0,2.36083984375,59,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid411",
                            "clip",
                            14299,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            [0,33.28857421875,59,0],
                            [0,33.28857421875,59,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid413",
                            "clip",
                            14475,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            [0,58.03076171875,59,0],
                            [0,58.03076171875,59,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid414",
                            "clip",
                            14637,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            [0,66.27783203125,59,0],
                            [0,66.27783203125,59,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid415",
                            "clip",
                            14762,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            [0,75.55615234375,59,0],
                            [0,75.55615234375,59,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid416",
                            "clip",
                            14885,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            [0,104.421875,59,0],
                            [0,104.421875,59,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid417",
                            "clip",
                            15014,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            [0,141.53515625,59,0],
                            [0,141.53515625,59,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid418",
                            "clip",
                            15116,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            [0,151.84423828125,59,0],
                            [0,151.84423828125,59,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid419",
                            "clip",
                            15226,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            [0,177.61767578125,59,0],
                            [0,177.61767578125,59,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid420",
                            "clip",
                            15332,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            [0,199.26708984375,59,0],
                            [0,199.26708984375,59,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid422",
                            "clip",
                            15431,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            [0,238.4423828125,59,0],
                            [0,238.4423828125,59,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid423",
                            "clip",
                            15516,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            [0,260.091796875,59,0],
                            [0,260.091796875,59,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid431",
                            "clip",
                            15624,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            [0,260.091796875,59,0],
                            [0,282.314453125,59,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid432",
                            "clip",
                            15724,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            [0,282.314453125,59,0],
                            [0,299.8564453125,59,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid433",
                            "clip",
                            15811,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            [0,299.8564453125,59,0],
                            [0,325.4970703125,59,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid434",
                            "clip",
                            15883,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            [0,325.4970703125,59,0],
                            [0,340.02685546875,59,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid435",
                            "clip",
                            15967,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            [0,340.02685546875,59,0],
                            [0,347.71923828125,59,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid438",
                            "clip",
                            16076,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            [0,347.71923828125,59,0],
                            [0,356.26611328125,59,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid437",
                            "clip",
                            16143,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            [0,356.26611328125,59,0],
                            [0,356.26611328125,59,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid249",
                            "opacity",
                            5670,
                            212,
                            "easeOutQuad",
                            "${subscription}",
                            '0',
                            '1'
                        ],
                        [
                            "eid274",
                            "opacity",
                            7938,
                            189,
                            "easeOutQuad",
                            "${subscription}",
                            '1',
                            '0'
                        ],
                        [
                            "eid304",
                            "opacity",
                            9707,
                            129,
                            "easeOutQuad",
                            "${export_loading_bar}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid313",
                            "opacity",
                            11726,
                            225,
                            "easeOutQuart",
                            "${export_loading_bar}",
                            '1',
                            '0'
                        ],
                        [
                            "eid245",
                            "opacity",
                            8986,
                            147,
                            "linear",
                            "${quality_btn_pressed}",
                            '0',
                            '1'
                        ],
                        [
                            "eid244",
                            "opacity",
                            9273,
                            209,
                            "linear",
                            "${quality_btn_pressed}",
                            '1',
                            '0'
                        ],
                        [
                            "eid9",
                            "scaleY",
                            1967,
                            573,
                            "easeOutQuad",
                            "${Ellipse}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid34",
                            "scaleY",
                            3921,
                            573,
                            "easeOutQuad",
                            "${Ellipse}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid51",
                            "scaleY",
                            5097,
                            573,
                            "easeOutQuad",
                            "${Ellipse}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid347",
                            "scaleY",
                            7000,
                            573,
                            "easeOutQuad",
                            "${Ellipse}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid364",
                            "scaleY",
                            8986,
                            573,
                            "easeOutQuad",
                            "${Ellipse}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid390",
                            "scaleY",
                            13335,
                            573,
                            "easeOutQuad",
                            "${Ellipse}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid444",
                            "scaleY",
                            17427,
                            573,
                            "easeOutQuad",
                            "${Ellipse}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid3",
                            "opacity",
                            511,
                            476,
                            "linear",
                            "${hand}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid315",
                            "opacity",
                            18500,
                            349,
                            "linear",
                            "${hand}",
                            '1',
                            '0'
                        ],
                        [
                            "eid233",
                            "opacity",
                            310,
                            0,
                            "easeOutQuad",
                            "${_01_07_Project_list_Share_Subscriptions-2_help}",
                            '0.000000',
                            '0.000000'
                        ],
                        [
                            "eid45",
                            "opacity",
                            4208,
                            287,
                            "easeOutQuad",
                            "${_01_07_Project_list_Share_Subscriptions-2_help}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid224",
                            "opacity",
                            11726,
                            225,
                            "easeOutQuad",
                            "${_01_07_Project_list_Share_Subscriptions-2_help}",
                            '1',
                            '0'
                        ],
                        [
                            "eid402",
                            "opacity",
                            11726,
                            225,
                            "easeOutQuad",
                            "${Text_Title}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid404",
                            "opacity",
                            13500,
                            170,
                            "easeOutQuad",
                            "${Text_Title}",
                            '1',
                            '0'
                        ],
                        [
                            "eid19",
                            "opacity",
                            2144,
                            172,
                            "easeOutQuad",
                            "${share_btn_pressed}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid28",
                            "opacity",
                            2362,
                            241,
                            "easeOutQuad",
                            "${share_btn_pressed}",
                            '1',
                            '0'
                        ],
                        [
                            "eid222",
                            "opacity",
                            11371,
                            0,
                            "easeOutQuad",
                            "${share_btn_pressed}",
                            '0',
                            '0'
                        ],
                        [
                            "eid227",
                            "opacity",
                            11951,
                            0,
                            "easeOutQuad",
                            "${share_btn_pressed}",
                            '0',
                            '0'
                        ],
                        [
                            "eid301",
                            "opacity",
                            0,
                            310,
                            "linear",
                            "${Rectangle}",
                            '0.601626',
                            '0'
                        ],
                        [
                            "eid239",
                            "opacity",
                            310,
                            0,
                            "easeOutQuad",
                            "${export_share_btn_pressed}",
                            '0',
                            '0'
                        ],
                        [
                            "eid155",
                            "opacity",
                            9398,
                            172,
                            "easeOutQuad",
                            "${export_share_btn_pressed}",
                            '0.000000',
                            '0.000000'
                        ],
                        [
                            "eid219",
                            "opacity",
                            11726,
                            225,
                            "easeOutQuad",
                            "${export_share_btn_pressed}",
                            '1',
                            '0'
                        ],
                        [
                            "eid462",
                            "background-color",
                            13335,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            'rgba(213,213,213,1.00)',
                            'rgba(213,213,213,1.00)'
                        ],
                        [
                            "eid463",
                            "background-color",
                            17427,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            'rgba(213,213,213,1.00)',
                            'rgba(255,255,255,1.00)'
                        ],
                        [
                            "eid471",
                            "opacity",
                            0,
                            0,
                            "easeOutQuart",
                            "${Text_hello_kinemaster}",
                            '0',
                            '0'
                        ],
                        [
                            "eid406",
                            "opacity",
                            13670,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            '0',
                            '0'
                        ],
                        [
                            "eid460",
                            "opacity",
                            13908,
                            0,
                            "easeOutQuad",
                            "${Text_hello_kinemaster}",
                            '0',
                            '1'
                        ],
                        [
                            "eid232",
                            "opacity",
                            310,
                            0,
                            "easeOutQuad",
                            "${_01_04_project_list_Detail_Share}",
                            '0',
                            '0'
                        ],
                        [
                            "eid22",
                            "opacity",
                            2362,
                            241,
                            "linear",
                            "${_01_04_project_list_Detail_Share}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid226",
                            "opacity",
                            11726,
                            225,
                            "easeOutQuad",
                            "${_01_04_project_list_Detail_Share}",
                            '1',
                            '0'
                        ],
                        [
                            "eid14",
                            "width",
                            1967,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid39",
                            "width",
                            3921,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid56",
                            "width",
                            5097,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid352",
                            "width",
                            7000,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid369",
                            "width",
                            8986,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid395",
                            "width",
                            13335,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid449",
                            "width",
                            17427,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid6",
                            "top",
                            1090,
                            797,
                            "easeOutCubic",
                            "${hand}",
                            '479px',
                            '526px'
                        ],
                        [
                            "eid32",
                            "top",
                            2970,
                            780,
                            "easeOutQuad",
                            "${hand}",
                            '526px',
                            '584px'
                        ],
                        [
                            "eid490",
                            "top",
                            6243,
                            470,
                            "easeOutQuad",
                            "${hand}",
                            '584px',
                            '701px'
                        ],
                        [
                            "eid68",
                            "top",
                            8127,
                            518,
                            "easeOutQuad",
                            "${hand}",
                            '701px',
                            '438px'
                        ],
                        [
                            "eid388",
                            "top",
                            12509,
                            491,
                            "easeOutQuad",
                            "${hand}",
                            '438px',
                            '347px'
                        ],
                        [
                            "eid442",
                            "top",
                            16636,
                            614,
                            "easeOutCubic",
                            "${hand}",
                            '347px',
                            '158px'
                        ],
                        [
                            "eid10",
                            "scaleX",
                            1967,
                            573,
                            "easeOutQuad",
                            "${Ellipse}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid36",
                            "scaleX",
                            3921,
                            573,
                            "easeOutQuad",
                            "${Ellipse}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid53",
                            "scaleX",
                            5097,
                            573,
                            "easeOutQuad",
                            "${Ellipse}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid348",
                            "scaleX",
                            7000,
                            573,
                            "easeOutQuad",
                            "${Ellipse}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid365",
                            "scaleX",
                            8986,
                            573,
                            "easeOutQuad",
                            "${Ellipse}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid391",
                            "scaleX",
                            13335,
                            573,
                            "easeOutQuad",
                            "${Ellipse}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid445",
                            "scaleX",
                            17427,
                            573,
                            "easeOutQuad",
                            "${Ellipse}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid311",
                            "width",
                            10336,
                            1140,
                            "easeOutQuart",
                            "${export_loading_bar}",
                            '1px',
                            '905px'
                        ],
                        [
                            "eid319",
                            "top",
                            1967,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '487px',
                            '487px'
                        ],
                        [
                            "eid321",
                            "top",
                            3921,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '487px',
                            '555px'
                        ],
                        [
                            "eid473",
                            "top",
                            5097,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '555px',
                            '545px'
                        ],
                        [
                            "eid475",
                            "top",
                            7000,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '545px',
                            '666px'
                        ],
                        [
                            "eid397",
                            "top",
                            8986,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '666px',
                            '406px'
                        ],
                        [
                            "eid398",
                            "top",
                            13335,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '406px',
                            '309px'
                        ],
                        [
                            "eid451",
                            "top",
                            17427,
                            0,
                            "easeOutQuad",
                            "${Ellipse}",
                            '309px',
                            '135px'
                        ],
                        [
                            "eid234",
                            "opacity",
                            310,
                            0,
                            "easeOutQuad",
                            "${_01_01_06_Project_list_Share_Export_help}",
                            '0',
                            '0'
                        ],
                        [
                            "eid64",
                            "opacity",
                            7938,
                            201,
                            "easeOutQuad",
                            "${_01_01_06_Project_list_Share_Export_help}",
                            '0',
                            '1'
                        ],
                        [
                            "eid225",
                            "opacity",
                            11726,
                            225,
                            "easeOutQuad",
                            "${_01_01_06_Project_list_Share_Export_help}",
                            '1',
                            '0'
                        ],
                        [
                            "eid299",
                            "opacity",
                            0,
                            310,
                            "linear",
                            "${btn_media_detail_play_nor}",
                            '1',
                            '0'
                        ]
                    ]
                }
            }
        };

    AdobeEdge.registerCompositionDefn(compId, symbols, fonts, scripts, resources, opts);

    if (!window.edge_authoring_mode) AdobeEdge.getComposition(compId).load("Getting_started_part2_edgeActions.js");
})("EDGE-927630681");

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
                version: "5.0.1",
                minimumCompatibleVersion: "5.0.0",
                build: "5.0.1.386",
                scaleToFit: "none",
                centerStage: "none",
                resizeInstances: false,
                content: {
                    dom: [
                        {
                            id: 'Getting_started_part1',
                            symbolName: 'Getting_started_part1',
                            type: 'rect',
                            rect: ['-711px', '-552px', '1921', '1493', 'auto', 'auto'],
                            transform: [[],[],[],['0.26028','0.26028']]
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
                    duration: 33507,
                    autoPlay: false,
                    labels: {
                        "loop": 375
                    },
                    data: [

                    ]
                }
            },
            "Getting_started_part1": {
                version: "5.0.1",
                minimumCompatibleVersion: "5.0.0",
                build: "5.0.1.386",
                scaleToFit: "none",
                centerStage: "none",
                resizeInstances: false,
                content: {
                    dom: [
                        {
                            id: '_01_00_project_none_file',
                            type: 'image',
                            rect: ['0px', '0px', '1920px', '1080px', 'auto', 'auto'],
                            fill: ['rgba(0,0,0,0)', 'images/01_00_project_none_file.jpg', '0px', '0px']
                        },
                        {
                            rect: ['0px', '0px', '1920px', '1080px', 'auto', 'auto'],
                            stroke: [0, 'rgb(0, 0, 0)', 'none'],
                            id: 'rectangle',
                            opacity: '0',
                            type: 'rect',
                            fill: ['rgba(0,0,0,1.00)']
                        },
                        {
                            rect: ['813px', '581px', '301px', '301px', 'auto', 'auto'],
                            id: 'btn_v3_newproject_close',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/btn_v3_newproject_close.png', '0px', '0px']
                        },
                        {
                            rect: ['1015px', '252px', '301px', '301px', 'auto', 'auto'],
                            id: 'btn_v3_gettingstarted',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/btn_v3_gettingstarted.png', '0px', '0px']
                        },
                        {
                            id: 'btn_v3_skip',
                            type: 'image',
                            rect: ['1165px', '577px', '219px', '219px', 'auto', 'auto'],
                            fill: ['rgba(0,0,0,0)', 'images/btn_v3_skip.png', '0px', '0px']
                        },
                        {
                            rect: ['0px', '79px', '1920px', '1007px', 'auto', 'auto'],
                            id: 'title_type',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/title_type.jpg', '0px', '0px']
                        },
                        {
                            rect: ['579px', '312px', 'auto', 'auto', 'auto', 'auto'],
                            font: ['Arial, Helvetica, sans-serif', [70, 'px'], 'rgba(255,255,255,1.00)', 'normal', 'none', '', 'break-word', 'nowrap'],
                            text: 'Hello KineMaster!!!<br>',
                            id: 'text_hello_kinemaster',
                            opacity: '0',
                            clip: 'rect(0px 453px 80px 0px)',
                            type: 'text'
                        },
                        {
                            rect: ['0px', '0px', '1920px', '1080px', 'auto', 'auto'],
                            id: '_02_02_Step1_Media',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/02_02_step1_media.jpg', '0px', '0px']
                        },
                        {
                            rect: ['0px', '0px', '1920px', '1080px', 'auto', 'auto'],
                            id: '_02_02_Step1_Media_2Depth',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/02_02_step1_media_depth.jpg', '0px', '0px']
                        },
                        {
                            rect: ['0px', '0px', '1920px', '1080px', 'auto', 'auto'],
                            id: '_02_03_Step_2_Theme',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/02_03_step2_theme.jpg', '0px', '0px']
                        },
                        {
                            rect: ['1033px', '533px', '308', '126', 'auto', 'auto'],
                            id: 'download_symbols',
                            opacity: '0',
                            type: 'group',
                            c: [
                            {
                                id: 'btn_theme_item_down',
                                type: 'image',
                                rect: ['210px', '7px', '98px', '113px', 'auto', 'auto'],
                                fill: ['rgba(0,0,0,0)', 'images/btn_theme_item_down.png', '0px', '0px']
                            },
                            {
                                id: 'btn_theme_item_play',
                                type: 'image',
                                rect: ['0px', '0px', '126px', '126px', 'auto', 'auto'],
                                fill: ['rgba(0,0,0,0)', 'images/btn_theme_item_play.png', '0px', '0px']
                            },
                            {
                                rect: ['164px', '7px', '5px', '105px', 'auto', 'auto'],
                                id: 'Rectangle2',
                                stroke: [0, 'rgb(0, 0, 0)', 'none'],
                                type: 'rect',
                                fill: ['rgba(255,255,255,1)']
                            }]
                        },
                        {
                            transform: [[], [], [], ['1.02289', '0.9777']],
                            rect: ['966px', '467px', '428px', '249px', 'auto', 'auto'],
                            borderRadius: ['10px', '10px', '10px', '10px'],
                            stroke: [8, 'rgba(255,159,52,1.00)', 'solid'],
                            id: 'RoundRect',
                            opacity: '0',
                            type: 'rect',
                            fill: ['rgba(112,67,67,0.00)']
                        },
                        {
                            rect: ['360px', '94px', 'auto', 'auto', 'auto', 'auto'],
                            font: ['roboto', [53, 'px'], 'rgba(222,90,90,1.00)', 'normal', 'none', '', 'break-word', 'nowrap'],
                            id: 'Text2',
                            opacity: '0',
                            text: 'Alien Invasion',
                            type: 'text'
                        },
                        {
                            rect: ['1096px', '592px', '4px', '17px', 'auto', 'auto'],
                            stroke: [0, 'rgb(0, 0, 0)', 'none'],
                            id: 'Rectangle3',
                            opacity: '0',
                            type: 'rect',
                            fill: ['rgba(255,161,42,1.00)']
                        },
                        {
                            rect: ['0px', '0px', '1920px', '1080px', 'auto', 'auto'],
                            id: '_02_04_Step3_Text_Title',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/02_04_step3_text_title.jpg', '0px', '0px']
                        },
                        {
                            id: 'Title_default',
                            type: 'group',
                            rect: ['571px', '340px', '195', '381', 'auto', 'auto'],
                            c: [
                            {
                                rect: ['0px', '311px', 'auto', 'auto', 'auto', 'auto'],
                                font: ['roboto', [53, 'px'], 'rgba(255,255,255,1)', '300', 'none solid rgb(255, 255, 255)', 'normal', 'break-word', 'nowrap'],
                                align: 'left',
                                id: 'Title_Ending',
                                opacity: '0',
                                text: 'Ending',
                                type: 'text'
                            },
                            {
                                rect: ['0px', '158px', 'auto', 'auto', 'auto', 'auto'],
                                font: ['roboto', [53, 'px'], 'rgba(255,255,255,1)', '300', 'none solid rgb(255, 255, 255)', 'normal', 'break-word', 'nowrap'],
                                align: 'left',
                                id: 'Title_Accent',
                                opacity: '0',
                                text: 'Accent<br>',
                                type: 'text'
                            },
                            {
                                rect: ['0px', '0px', 'auto', 'auto', 'auto', 'auto'],
                                font: ['roboto', [53, 'px'], 'rgba(255,255,255,1.00)', '300', 'none solid rgb(222, 90, 90)', 'normal', 'break-word', 'nowrap'],
                                align: 'left',
                                id: 'Title_Opening',
                                opacity: '0',
                                text: 'Opening',
                                type: 'text'
                            }]
                        },
                        {
                            rect: ['579px', '340px', '336', '389', 'auto', 'auto'],
                            id: 'Title_typed',
                            opacity: '0',
                            type: 'group',
                            c: [
                            {
                                rect: ['0px', '0px', 'auto', 'auto', 'auto', 'auto'],
                                font: ['roboto', [53, 'px'], 'rgba(255,255,255,1)', '300', 'none solid rgb(255, 255, 255)', 'normal', 'break-word', 'nowrap'],
                                align: 'left',
                                id: 'Title_Summer',
                                text: 'Summer!',
                                clip: 'rect(0px 203px 70px 0px)',
                                type: 'text'
                            },
                            {
                                rect: ['0px', '165px', 'auto', 'auto', 'auto', 'auto'],
                                font: ['roboto', [53, 'px'], 'rgba(255,255,255,1)', '300', 'none solid rgb(255, 255, 255)', 'normal', 'break-word', 'nowrap'],
                                align: 'left',
                                id: 'Title_Happytimes',
                                text: 'Happy times :)',
                                clip: 'rect(0px 2.07177734375px 70px 0px)',
                                type: 'text'
                            },
                            {
                                rect: ['0px', '319px', 'auto', 'auto', 'auto', 'auto'],
                                font: ['roboto', [53, 'px'], 'rgba(255,255,255,1)', '300', 'none solid rgb(255, 255, 255)', 'normal', 'break-word', 'nowrap'],
                                align: 'left',
                                id: 'Title_Fin',
                                text: 'Fin',
                                clip: 'rect(0px 2.46435546875px 70px 0px)',
                                type: 'text'
                            }]
                        },
                        {
                            rect: ['0px', '0px', '1920px', '1080px', 'auto', 'auto'],
                            id: '_02_05_Step4_Music',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/02_05_step4_music.jpg', '0px', '0px']
                        },
                        {
                            rect: ['360px', '172px', '1561px', '1321px', 'auto', 'auto'],
                            type: 'image',
                            id: 'audio_list',
                            opacity: '0',
                            clip: 'rect(0px 1561px 732.62841796875px 0px)',
                            fill: ['rgba(0,0,0,0)', 'images/audio_list.jpg', '0px', '0px']
                        },
                        {
                            rect: ['360px', '662px', '1558px', '127px', 'auto', 'auto'],
                            id: 'audio_selected',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/audio_selected.jpg', '0px', '0px']
                        },
                        {
                            rect: ['1447px', '690px', '80px', '80px', 'auto', 'auto'],
                            id: 'audio_browser_add_nor',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/audio_browser_add_nor.png', '0px', '0px']
                        },
                        {
                            rect: ['1447px', '690px', '80px', '80px', 'auto', 'auto'],
                            id: 'audio_browser_add_press2',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/audio_browser_add_press.png', '0px', '0px']
                        },
                        {
                            rect: ['0px', '0px', '1920px', '1080px', 'auto', 'auto'],
                            id: '_03_01_01_Editing_Scene',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/03_01_01_editing_scene.jpg', '0px', '0px']
                        },
                        {
                            rect: ['176px', '92px', '1140px', '637px', 'auto', 'auto'],
                            id: 'kinemaster_source_video_clip2',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/kinemaster_source_video_clip2.jpg', '0px', '0px']
                        },
                        {
                            rect: ['676px', '933px', '200px', '124px', 'auto', 'auto'],
                            id: 'clip_thumbnail_2',
                            opacity: '1',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/clip_thumbnail_2.jpg', '0px', '0px']
                        },
                        {
                            rect: ['706px', '99px', 'auto', 'auto', 'auto', 'auto'],
                            font: ['roboto', [45, 'px'], 'rgba(255,100,94,1.00)', 'normal', 'none', '', 'break-word', 'nowrap'],
                            id: 'Text3',
                            opacity: '0',
                            text: '01 How Long\'s A Tear Take To Dry_.wav',
                            type: 'text'
                        },
                        {
                            rect: ['1523px', '102px', '45px', '46px', 'auto', 'auto'],
                            id: 'icon_toolbar_delete',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/icon_toolbar_delete.png', '0px', '0px']
                        },
                        {
                            rect: ['457px', '931px', '200px', '124px', 'auto', 'auto'],
                            id: 'clip_thumbnail_1',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/clip_thumbnail_1.jpg', '0px', '0px']
                        },
                        {
                            rect: ['1288px', '843px', '56px', '55px', 'auto', 'auto'],
                            id: 'transition_effect_theme_change_icon',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/transition_effect_theme_change_icon.jpg', '0px', '0px']
                        },
                        {
                            rect: ['1062px', '947px', '738px', '62px', 'auto', 'auto'],
                            id: 'audio_clip_1',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/audio_clip_1.jpg', '0px', '0px']
                        },
                        {
                            rect: ['1819px', '947px', '110px', '110px', 'auto', 'auto'],
                            borderRadius: ['50%', '50%', '50%', '50%'],
                            stroke: [0, 'rgb(0, 0, 0)', 'none'],
                            id: 'Ellipse3',
                            opacity: '0',
                            type: 'ellipse',
                            fill: ['rgba(255,255,255,1.00)']
                        },
                        {
                            rect: ['904px', '613px', '135px', '161px', 'auto', 'auto'],
                            id: 'hand2',
                            opacity: '0',
                            type: 'image',
                            fill: ['rgba(0,0,0,0)', 'images/hand2.png', '0px', '0px']
                        },
                        {
                            id: 'Group',
                            type: 'group',
                            rect: ['0', '0', '1921', '1080', 'auto', 'auto'],
                            c: [
                            {
                                rect: ['0px', '0px', '1921px', '1080px', 'auto', 'auto'],
                                stroke: [0, 'rgba(0,0,0,1)', 'none'],
                                id: 'Rectangle',
                                opacity: '0',
                                type: 'rect',
                                fill: ['rgba(0,0,0,1.00)']
                            },
                            {
                                rect: ['789px', '407px', '341px', '341px', 'auto', 'auto'],
                                id: 'btn_media_detail_play_nor2',
                                opacity: '1',
                                type: 'image',
                                fill: ['rgba(0,0,0,0)', 'images/btn_media_detail_play_nor.png', '0px', '0px']
                            }]
                        }
                    ],
                    style: {
                        '${symbolSelector}': {
                            isStage: 'true',
                            rect: [undefined, undefined, '1921px', '1493px']
                        }
                    }
                },
                timeline: {
                    duration: 34417,
                    autoPlay: true,
                    labels: {
                        "loop": 0
                    },
                    data: [
                        [
                            "eid264",
                            "opacity",
                            15948,
                            198,
                            "easeOutCubic",
                            "${Rectangle3}",
                            '0',
                            '1'
                        ],
                        [
                            "eid268",
                            "opacity",
                            16614,
                            174,
                            "easeOutCubic",
                            "${Rectangle3}",
                            '1',
                            '0'
                        ],
                        [
                            "eid640",
                            "top",
                            32626,
                            0,
                            "easeOutQuad",
                            "${clip_thumbnail_1}",
                            '931px',
                            '931px'
                        ],
                        [
                            "eid642",
                            "top",
                            32819,
                            0,
                            "easeOutQuad",
                            "${clip_thumbnail_1}",
                            '931px',
                            '809px'
                        ],
                        [
                            "eid341",
                            "opacity",
                            21396,
                            0,
                            "easeOutQuad",
                            "${Title_typed}",
                            '0',
                            '0'
                        ],
                        [
                            "eid342",
                            "opacity",
                            21454,
                            0,
                            "easeOutQuad",
                            "${Title_typed}",
                            '0',
                            '1'
                        ],
                        [
                            "eid30",
                            "height",
                            1963,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid48",
                            "height",
                            3291,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid157",
                            "height",
                            6521,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid174",
                            "height",
                            7950,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid192",
                            "height",
                            10128,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid207",
                            "height",
                            12150,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid222",
                            "height",
                            13695,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid251",
                            "height",
                            15343,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid272",
                            "height",
                            17290,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid294",
                            "height",
                            18892,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid317",
                            "height",
                            20690,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid475",
                            "height",
                            26328,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid509",
                            "height",
                            28041,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid561",
                            "height",
                            30027,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid590",
                            "height",
                            31184,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid617",
                            "height",
                            32521,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid7",
                            "top",
                            1145,
                            655,
                            "easeOutCubic",
                            "${hand2}",
                            '795px',
                            '753px'
                        ],
                        [
                            "eid45",
                            "top",
                            2633,
                            500,
                            "easeOutCubic",
                            "${hand2}",
                            '753px',
                            '446px'
                        ],
                        [
                            "eid153",
                            "top",
                            5791,
                            625,
                            "easeOutCubic",
                            "${hand2}",
                            '446px',
                            '286px'
                        ],
                        [
                            "eid170",
                            "top",
                            7446,
                            300,
                            "linear",
                            "${hand2}",
                            '286px',
                            '343px'
                        ],
                        [
                            "eid188",
                            "top",
                            8731,
                            1250,
                            "easeOutCubic",
                            "${hand2}",
                            '343px',
                            '335px'
                        ],
                        [
                            "eid203",
                            "top",
                            10967,
                            1074,
                            "easeOutCubic",
                            "${hand2}",
                            '335px',
                            '786px'
                        ],
                        [
                            "eid218",
                            "top",
                            12877,
                            664,
                            "easeOutQuad",
                            "${hand2}",
                            '786px',
                            '970px'
                        ],
                        [
                            "eid247",
                            "top",
                            14402,
                            639,
                            "easeOutQuad",
                            "${hand2}",
                            '970px',
                            '613px'
                        ],
                        [
                            "eid290",
                            "top",
                            18041,
                            587,
                            "easeOutQuad",
                            "${hand2}",
                            '613px',
                            '949px'
                        ],
                        [
                            "eid313",
                            "top",
                            19791,
                            676,
                            "easeOutQuad",
                            "${hand2}",
                            '949px',
                            '379px'
                        ],
                        [
                            "eid470",
                            "top",
                            25354,
                            768,
                            "easeOutQuad",
                            "${hand2}",
                            '379px',
                            '930px'
                        ],
                        [
                            "eid503",
                            "top",
                            27291,
                            513,
                            "easeOutQuad",
                            "${hand2}",
                            '930px',
                            '694px'
                        ],
                        [
                            "eid527",
                            "top",
                            28041,
                            937,
                            "easeOutExpo",
                            "${hand2}",
                            '694px',
                            '403px'
                        ],
                        [
                            "eid556",
                            "top",
                            29291,
                            611,
                            "easeOutQuad",
                            "${hand2}",
                            '403px',
                            '721px'
                        ],
                        [
                            "eid586",
                            "top",
                            30740,
                            301,
                            "easeOutQuad",
                            "${hand2}",
                            '721px',
                            '724px'
                        ],
                        [
                            "eid613",
                            "top",
                            31791,
                            575,
                            "easeOutQuad",
                            "${hand2}",
                            '724px',
                            '984px'
                        ],
                        [
                            "eid54",
                            "top",
                            1963,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '716px',
                            '716px'
                        ],
                        [
                            "eid162",
                            "top",
                            3291,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '716px',
                            '404px'
                        ],
                        [
                            "eid179",
                            "top",
                            6521,
                            0,
                            "linear",
                            "${Ellipse3}",
                            '404px',
                            '243px'
                        ],
                        [
                            "eid197",
                            "top",
                            7950,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '235px',
                            '307px'
                        ],
                        [
                            "eid212",
                            "top",
                            10128,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '320px',
                            '294px'
                        ],
                        [
                            "eid227",
                            "top",
                            12150,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '280px',
                            '747px'
                        ],
                        [
                            "eid256",
                            "top",
                            13695,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '731px',
                            '938px'
                        ],
                        [
                            "eid257",
                            "top",
                            15343,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '923px',
                            '575px'
                        ],
                        [
                            "eid300",
                            "top",
                            17290,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '564px',
                            '577px'
                        ],
                        [
                            "eid305",
                            "top",
                            18892,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '578px',
                            '914px'
                        ],
                        [
                            "eid332",
                            "top",
                            20690,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '894px',
                            '342px'
                        ],
                        [
                            "eid516",
                            "top",
                            26328,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '337px',
                            '899px'
                        ],
                        [
                            "eid531",
                            "top",
                            28041,
                            937,
                            "easeOutExpo",
                            "${Ellipse3}",
                            '657px',
                            '371px'
                        ],
                        [
                            "eid595",
                            "top",
                            30027,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '371px',
                            '684px'
                        ],
                        [
                            "eid622",
                            "top",
                            31184,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '671px',
                            '686px'
                        ],
                        [
                            "eid624",
                            "top",
                            32521,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '674px',
                            '947px'
                        ],
                        [
                            "eid605",
                            "opacity",
                            31482,
                            164,
                            "easeOutQuad",
                            "${audio_browser_add_press2}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid626",
                            "opacity",
                            32814,
                            193,
                            "easeOutQuad",
                            "${_03_01_01_Editing_Scene}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid19",
                            "scaleY",
                            1963,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid47",
                            "scaleY",
                            3291,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid155",
                            "scaleY",
                            6521,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid172",
                            "scaleY",
                            7950,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid190",
                            "scaleY",
                            10128,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid205",
                            "scaleY",
                            12150,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid220",
                            "scaleY",
                            13695,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid249",
                            "scaleY",
                            15343,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid270",
                            "scaleY",
                            17290,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid292",
                            "scaleY",
                            18892,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid315",
                            "scaleY",
                            20690,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid473",
                            "scaleY",
                            26328,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid507",
                            "scaleY",
                            28041,
                            937,
                            "easeOutExpo",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid559",
                            "scaleY",
                            30027,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid588",
                            "scaleY",
                            31184,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid615",
                            "scaleY",
                            32521,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid31",
                            "width",
                            1963,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid52",
                            "width",
                            3291,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid160",
                            "width",
                            6521,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid177",
                            "width",
                            7950,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid195",
                            "width",
                            10128,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid210",
                            "width",
                            12150,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid225",
                            "width",
                            13695,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid254",
                            "width",
                            15343,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid275",
                            "width",
                            17290,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid297",
                            "width",
                            18892,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid320",
                            "width",
                            20690,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid479",
                            "width",
                            26328,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid513",
                            "width",
                            28041,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid565",
                            "width",
                            30027,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid593",
                            "width",
                            31184,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid620",
                            "width",
                            32521,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '110px',
                            '110px'
                        ],
                        [
                            "eid601",
                            "opacity",
                            30229,
                            167,
                            "easeOutQuad",
                            "${audio_browser_add_nor}",
                            '0',
                            '1'
                        ],
                        [
                            "eid603",
                            "opacity",
                            31482,
                            164,
                            "easeOutQuad",
                            "${audio_browser_add_nor}",
                            '1',
                            '0'
                        ],
                        [
                            "eid279",
                            "top",
                            17710,
                            0,
                            "easeOutQuad",
                            "${RoundRect}",
                            '467px',
                            '467px'
                        ],
                        [
                            "eid678",
                            "left",
                            32626,
                            0,
                            "easeOutQuad",
                            "${clip_thumbnail_2}",
                            '676px',
                            '676px'
                        ],
                        [
                            "eid680",
                            "left",
                            32819,
                            0,
                            "easeOutQuad",
                            "${clip_thumbnail_2}",
                            '675px',
                            '1369px'
                        ],
                        [
                            "eid184",
                            "opacity",
                            8226,
                            170,
                            "linear",
                            "${_02_02_Step1_Media_2Depth}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid607",
                            "opacity",
                            17542,
                            168,
                            "easeOutQuad",
                            "${icon_toolbar_delete}",
                            '0',
                            '1'
                        ],
                        [
                            "eid609",
                            "opacity",
                            19201,
                            174,
                            "easeOutQuad",
                            "${icon_toolbar_delete}",
                            '1',
                            '0'
                        ],
                        [
                            "eid654",
                            "opacity",
                            31482,
                            164,
                            "easeOutQuad",
                            "${icon_toolbar_delete}",
                            '0',
                            '1'
                        ],
                        [
                            "eid664",
                            "opacity",
                            32814,
                            193,
                            "easeOutQuad",
                            "${icon_toolbar_delete}",
                            '1',
                            '0'
                        ],
                        [
                            "eid679",
                            "top",
                            32626,
                            0,
                            "easeOutQuad",
                            "${clip_thumbnail_2}",
                            '933px',
                            '933px'
                        ],
                        [
                            "eid681",
                            "top",
                            32819,
                            0,
                            "easeOutQuad",
                            "${clip_thumbnail_2}",
                            '931px',
                            '809px'
                        ],
                        [
                            "eid325",
                            "opacity",
                            19201,
                            174,
                            "easeOutQuad",
                            "${Title_Ending}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid337",
                            "opacity",
                            20896,
                            168,
                            "easeOutQuad",
                            "${Title_Ending}",
                            '1',
                            '0'
                        ],
                        [
                            "eid744",
                            "clip",
                            24634,
                            0,
                            "easeOutQuad",
                            "${Title_Fin}",
                            [0,2.46435546875,70,0],
                            [0,2.46435546875,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid745",
                            "clip",
                            24794,
                            0,
                            "easeOutQuad",
                            "${Title_Fin}",
                            [0,2.46435546875,70,0],
                            [0,33,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid746",
                            "clip",
                            24878,
                            0,
                            "easeOutQuad",
                            "${Title_Fin}",
                            [0,33,70,0],
                            [0,45.5,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid747",
                            "clip",
                            25000,
                            0,
                            "easeOutQuad",
                            "${Title_Fin}",
                            [0,45.5,70,0],
                            [0,76.75,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid324",
                            "opacity",
                            19201,
                            174,
                            "easeOutQuad",
                            "${Title_Accent}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid336",
                            "opacity",
                            20896,
                            168,
                            "easeOutQuad",
                            "${Title_Accent}",
                            '1',
                            '0'
                        ],
                        [
                            "eid816",
                            "opacity",
                            0,
                            0,
                            "easeOutQuad",
                            "${text_hello_kinemaster}",
                            '0',
                            '0'
                        ],
                        [
                            "eid799",
                            "opacity",
                            3791,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            '0',
                            '0'
                        ],
                        [
                            "eid800",
                            "opacity",
                            4071,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            '0',
                            '1'
                        ],
                        [
                            "eid805",
                            "opacity",
                            6948,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            '1',
                            '1'
                        ],
                        [
                            "eid806",
                            "opacity",
                            7198,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            '1',
                            '0'
                        ],
                        [
                            "eid166",
                            "opacity",
                            6948,
                            250,
                            "easeOutQuad",
                            "${_02_02_Step1_Media}",
                            '0',
                            '1'
                        ],
                        [
                            "eid759",
                            "opacity",
                            0,
                            309,
                            "easeOutQuad",
                            "${btn_media_detail_play_nor2}",
                            '1',
                            '0'
                        ],
                        [
                            "eid692",
                            "clip",
                            4071,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            [0,2.36376953125,80,0],
                            [0,2.36376953125,80,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid693",
                            "clip",
                            4146,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            [0,2.36376953125,80,0],
                            [0,50,80,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid694",
                            "clip",
                            4292,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            [0,50,80,0],
                            [0,92,80,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid695",
                            "clip",
                            4412,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            [0,92,80,0],
                            [0,107,80,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid696",
                            "clip",
                            4489,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            [0,107,80,0],
                            [0,123,80,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid697",
                            "clip",
                            4575,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            [0,123,80,0],
                            [0,162,80,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid698",
                            "clip",
                            4669,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            [0,162,80,0],
                            [0,231,80,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid699",
                            "clip",
                            4763,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            [0,231,80,0],
                            [0,248,80,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid700",
                            "clip",
                            4857,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            [0,248,80,0],
                            [0,282,80,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid701",
                            "clip",
                            4926,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            [0,282,80,0],
                            [0,323,80,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid702",
                            "clip",
                            5003,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            [0,323,80,0],
                            [0,381,80,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid703",
                            "clip",
                            5080,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            [0,381,80,0],
                            [0,420,80,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid704",
                            "clip",
                            5149,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            [0,420,80,0],
                            [0,453,80,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid705",
                            "clip",
                            5217,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            [0,453,80,0],
                            [0,476,80,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid706",
                            "clip",
                            5286,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            [0,476,80,0],
                            [0,511,80,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid707",
                            "clip",
                            5363,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            [0,511,80,0],
                            [0,536,80,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid708",
                            "clip",
                            5432,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            [0,536,80,0],
                            [0,556,80,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid709",
                            "clip",
                            5509,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            [0,556,80,0],
                            [0,571,80,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid710",
                            "clip",
                            5577,
                            0,
                            "easeOutCubic",
                            "${text_hello_kinemaster}",
                            [0,571,80,0],
                            [0,592,80,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid655",
                            "left",
                            31265,
                            0,
                            "easeOutQuad",
                            "${icon_toolbar_delete}",
                            '697px',
                            '697px'
                        ],
                        [
                            "eid659",
                            "left",
                            31482,
                            0,
                            "easeOutQuad",
                            "${icon_toolbar_delete}",
                            '697px',
                            '1523px'
                        ],
                        [
                            "eid815",
                            "opacity",
                            0,
                            0,
                            "easeOutCubic",
                            "${title_type}",
                            '0',
                            '0'
                        ],
                        [
                            "eid58",
                            "opacity",
                            3791,
                            280,
                            "easeOutCubic",
                            "${title_type}",
                            '0',
                            '1'
                        ],
                        [
                            "eid656",
                            "top",
                            31265,
                            0,
                            "easeOutQuad",
                            "${icon_toolbar_delete}",
                            '102px',
                            '102px'
                        ],
                        [
                            "eid568",
                            "opacity",
                            30229,
                            167,
                            "easeOutQuad",
                            "${audio_selected}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid712",
                            "clip",
                            21623,
                            0,
                            "easeOutQuad",
                            "${Title_Summer}",
                            [0,1.75,70,0],
                            [0,1.75,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid713",
                            "clip",
                            21820,
                            0,
                            "easeOutQuad",
                            "${Title_Summer}",
                            [0,1.75,70,0],
                            [0,33,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid714",
                            "clip",
                            22009,
                            0,
                            "easeOutQuad",
                            "${Title_Summer}",
                            [0,33,70,0],
                            [0,62,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid715",
                            "clip",
                            22161,
                            0,
                            "easeOutQuad",
                            "${Title_Summer}",
                            [0,62,70,0],
                            [0,109,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid716",
                            "clip",
                            22296,
                            0,
                            "easeOutQuad",
                            "${Title_Summer}",
                            [0,109,70,0],
                            [0,154,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid717",
                            "clip",
                            22456,
                            0,
                            "easeOutQuad",
                            "${Title_Summer}",
                            [0,154,70,0],
                            [0,185,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid718",
                            "clip",
                            22575,
                            0,
                            "easeOutQuad",
                            "${Title_Summer}",
                            [0,185,70,0],
                            [0,203,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid719",
                            "clip",
                            22704,
                            0,
                            "easeOutQuad",
                            "${Title_Summer}",
                            [0,203,70,0],
                            [0,213,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid37",
                            "opacity",
                            2180,
                            468,
                            "easeInCubic",
                            "${btn_v3_gettingstarted}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid277",
                            "opacity",
                            17542,
                            168,
                            "easeOutQuad",
                            "${RoundRect}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid648",
                            "opacity",
                            31482,
                            164,
                            "easeOutQuad",
                            "${Text3}",
                            '0',
                            '1'
                        ],
                        [
                            "eid665",
                            "opacity",
                            32814,
                            193,
                            "easeOutQuad",
                            "${Text3}",
                            '1',
                            '0'
                        ],
                        [
                            "eid543",
                            "clip",
                            26646,
                            0,
                            "easeOutQuad",
                            "${audio_list}",
                            [0,1561,732.62841796875,0],
                            [0,1561,732.62841796875,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid53",
                            "left",
                            1963,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '978px',
                            '978px'
                        ],
                        [
                            "eid161",
                            "left",
                            3291,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '978px',
                            '1174px'
                        ],
                        [
                            "eid178",
                            "left",
                            6521,
                            0,
                            "linear",
                            "${Ellipse3}",
                            '1182px',
                            '1684px'
                        ],
                        [
                            "eid196",
                            "left",
                            7950,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1668px',
                            '1796px'
                        ],
                        [
                            "eid211",
                            "left",
                            10128,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1787px',
                            '246px'
                        ],
                        [
                            "eid226",
                            "left",
                            12150,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '233px',
                            '1059px'
                        ],
                        [
                            "eid255",
                            "left",
                            13695,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1047px',
                            '1814px'
                        ],
                        [
                            "eid258",
                            "left",
                            15343,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1801px',
                            '1308px'
                        ],
                        [
                            "eid298",
                            "left",
                            17290,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1292px',
                            '1302px'
                        ],
                        [
                            "eid303",
                            "left",
                            18892,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1296px',
                            '1816px'
                        ],
                        [
                            "eid330",
                            "left",
                            20690,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1802px',
                            '899px'
                        ],
                        [
                            "eid514",
                            "left",
                            26328,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '700px',
                            '1811px'
                        ],
                        [
                            "eid530",
                            "left",
                            28041,
                            937,
                            "easeOutExpo",
                            "${Ellipse3}",
                            '1237px',
                            '1246px'
                        ],
                        [
                            "eid594",
                            "left",
                            30027,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1246px',
                            '1355px'
                        ],
                        [
                            "eid621",
                            "left",
                            31184,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1341px',
                            '1482px'
                        ],
                        [
                            "eid623",
                            "left",
                            32521,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1466px',
                            '1819px'
                        ],
                        [
                            "eid326",
                            "opacity",
                            19201,
                            174,
                            "easeOutQuad",
                            "${Title_Opening}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid338",
                            "opacity",
                            20896,
                            168,
                            "easeOutQuad",
                            "${Title_Opening}",
                            '1',
                            '0'
                        ],
                        [
                            "eid20",
                            "scaleX",
                            1963,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid49",
                            "scaleX",
                            3291,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid156",
                            "scaleX",
                            6521,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid173",
                            "scaleX",
                            7950,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid191",
                            "scaleX",
                            10128,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid206",
                            "scaleX",
                            12150,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid221",
                            "scaleX",
                            13695,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid250",
                            "scaleX",
                            15343,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid271",
                            "scaleX",
                            17290,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid293",
                            "scaleX",
                            18892,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid316",
                            "scaleX",
                            20690,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid474",
                            "scaleX",
                            26328,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid508",
                            "scaleX",
                            28041,
                            937,
                            "easeOutExpo",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid560",
                            "scaleX",
                            30027,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid589",
                            "scaleX",
                            31184,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid616",
                            "scaleX",
                            32521,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '1',
                            '1.21'
                        ],
                        [
                            "eid669",
                            "opacity",
                            32626,
                            0,
                            "easeOutQuad",
                            "${audio_clip_1}",
                            '0',
                            '0'
                        ],
                        [
                            "eid818",
                            "opacity",
                            32819,
                            188,
                            "easeOutQuad",
                            "${audio_clip_1}",
                            '0',
                            '1'
                        ],
                        [
                            "eid497",
                            "opacity",
                            26646,
                            160,
                            "easeOutQuad",
                            "${_02_05_Step4_Music}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid286",
                            "opacity",
                            17542,
                            168,
                            "easeOutQuad",
                            "${Text2}",
                            '0',
                            '1'
                        ],
                        [
                            "eid266",
                            "width",
                            16081,
                            533,
                            "easeOutCubic",
                            "${Rectangle3}",
                            '4px',
                            '200px'
                        ],
                        [
                            "eid27",
                            "opacity",
                            1895,
                            0,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '0',
                            '0'
                        ],
                        [
                            "eid21",
                            "opacity",
                            1963,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid50",
                            "opacity",
                            3291,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid158",
                            "opacity",
                            6521,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid175",
                            "opacity",
                            7950,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid193",
                            "opacity",
                            10128,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid208",
                            "opacity",
                            12150,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid223",
                            "opacity",
                            13695,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid252",
                            "opacity",
                            15343,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid273",
                            "opacity",
                            17290,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid295",
                            "opacity",
                            18892,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid318",
                            "opacity",
                            20690,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid476",
                            "opacity",
                            26328,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid510",
                            "opacity",
                            28041,
                            937,
                            "easeOutExpo",
                            "${Ellipse3}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid562",
                            "opacity",
                            30027,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid591",
                            "opacity",
                            31184,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid618",
                            "opacity",
                            32521,
                            500,
                            "easeOutQuad",
                            "${Ellipse3}",
                            '0.6875',
                            '0'
                        ],
                        [
                            "eid761",
                            "opacity",
                            0,
                            309,
                            "easeOutQuad",
                            "${Rectangle}",
                            '0.601626',
                            '0'
                        ],
                        [
                            "eid38",
                            "opacity",
                            2180,
                            468,
                            "easeInCubic",
                            "${btn_v3_skip}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid3",
                            "opacity",
                            750,
                            248,
                            "easeOutCubic",
                            "${hand2}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid820",
                            "opacity",
                            34062,
                            355,
                            "easeOutQuad",
                            "${hand2}",
                            '1',
                            '0'
                        ],
                        [
                            "eid552",
                            "background-position",
                            28146,
                            937,
                            "easeOutQuad",
                            "${audio_list}",
                            [0,0],
                            [0,-413],
                            {valueTemplate: '@@0@@px @@1@@px'}
                        ],
                        [
                            "eid721",
                            "clip",
                            22947,
                            0,
                            "easeOutQuad",
                            "${Title_Happytimes}",
                            [0,2.07177734375,70,0],
                            [0,2.07177734375,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid740",
                            "clip",
                            23095,
                            0,
                            "easeOutQuad",
                            "${Title_Happytimes}",
                            [0,2.07177734375,70,0],
                            [0,37.7861328125,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid723",
                            "clip",
                            23217,
                            0,
                            "easeOutQuad",
                            "${Title_Happytimes}",
                            [0,37.7861328125,70,0],
                            [0,64.57177734375,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid724",
                            "clip",
                            23340,
                            0,
                            "easeOutQuad",
                            "${Title_Happytimes}",
                            [0,64.57177734375,70,0],
                            [0,96.71484375,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid727",
                            "clip",
                            23471,
                            0,
                            "easeOutQuad",
                            "${Title_Happytimes}",
                            [0,96.71484375,70,0],
                            [0,123.50048828125,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid730",
                            "clip",
                            23606,
                            0,
                            "easeOutQuad",
                            "${Title_Happytimes}",
                            [0,123.50048828125,70,0],
                            [0,158.32177734375,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid731",
                            "clip",
                            23708,
                            0,
                            "easeOutQuad",
                            "${Title_Happytimes}",
                            [0,158.32177734375,70,0],
                            [0,182.42919921875,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid732",
                            "clip",
                            23830,
                            0,
                            "easeOutQuad",
                            "${Title_Happytimes}",
                            [0,182.42919921875,70,0],
                            [0,193.1435546875,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid735",
                            "clip",
                            23936,
                            0,
                            "easeOutQuad",
                            "${Title_Happytimes}",
                            [0,193.1435546875,70,0],
                            [0,241.35791015625,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid736",
                            "clip",
                            24027,
                            0,
                            "easeOutQuad",
                            "${Title_Happytimes}",
                            [0,241.35791015625,70,0],
                            [0,269.92919921875,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid737",
                            "clip",
                            24266,
                            0,
                            "easeOutQuad",
                            "${Title_Happytimes}",
                            [0,269.92919921875,70,0],
                            [0,297.60791015625,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid738",
                            "clip",
                            24346,
                            0,
                            "easeOutQuad",
                            "${Title_Happytimes}",
                            [0,297.60791015625,70,0],
                            [0,319.03662109375,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid739",
                            "clip",
                            24396,
                            0,
                            "easeOutQuad",
                            "${Title_Happytimes}",
                            [0,319.03662109375,70,0],
                            [0,336.89404296875,70,0],
                            {valueTemplate: 'rect(@@0@@px @@1@@px @@2@@px @@3@@px)'}
                        ],
                        [
                            "eid237",
                            "opacity",
                            13974,
                            260,
                            "easeOutQuad",
                            "${_02_03_Step_2_Theme}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid34",
                            "opacity",
                            2180,
                            237,
                            "easeOutQuad",
                            "${btn_v3_newproject_close}",
                            '0',
                            '1'
                        ],
                        [
                            "eid280",
                            "left",
                            17710,
                            0,
                            "easeOutQuad",
                            "${RoundRect}",
                            '966px',
                            '966px'
                        ],
                        [
                            "eid499",
                            "opacity",
                            26646,
                            160,
                            "easeOutQuad",
                            "${audio_list}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid234",
                            "opacity",
                            12325,
                            254,
                            "easeOutQuad",
                            "${clip_thumbnail_2}",
                            '0',
                            '1'
                        ],
                        [
                            "eid635",
                            "opacity",
                            13974,
                            260,
                            "easeOutQuad",
                            "${clip_thumbnail_2}",
                            '1',
                            '0'
                        ],
                        [
                            "eid630",
                            "opacity",
                            32814,
                            193,
                            "easeOutQuad",
                            "${clip_thumbnail_2}",
                            '0',
                            '1'
                        ],
                        [
                            "eid6",
                            "left",
                            1145,
                            655,
                            "easeOutCubic",
                            "${hand2}",
                            '1387px',
                            '984px'
                        ],
                        [
                            "eid44",
                            "left",
                            2633,
                            500,
                            "easeOutCubic",
                            "${hand2}",
                            '984px',
                            '1179px'
                        ],
                        [
                            "eid152",
                            "left",
                            5791,
                            625,
                            "easeOutCubic",
                            "${hand2}",
                            '1179px',
                            '1689px'
                        ],
                        [
                            "eid169",
                            "left",
                            7446,
                            300,
                            "linear",
                            "${hand2}",
                            '1689px',
                            '1805px'
                        ],
                        [
                            "eid187",
                            "left",
                            8731,
                            1250,
                            "easeOutCubic",
                            "${hand2}",
                            '1805px',
                            '254px'
                        ],
                        [
                            "eid202",
                            "left",
                            10967,
                            1074,
                            "easeOutCubic",
                            "${hand2}",
                            '254px',
                            '1067px'
                        ],
                        [
                            "eid217",
                            "left",
                            12877,
                            664,
                            "easeOutQuad",
                            "${hand2}",
                            '1067px',
                            '1816px'
                        ],
                        [
                            "eid246",
                            "left",
                            14402,
                            639,
                            "easeOutQuad",
                            "${hand2}",
                            '1816px',
                            '1309px'
                        ],
                        [
                            "eid289",
                            "left",
                            18041,
                            587,
                            "easeOutQuad",
                            "${hand2}",
                            '1309px',
                            '1821px'
                        ],
                        [
                            "eid312",
                            "left",
                            19791,
                            676,
                            "easeOutQuad",
                            "${hand2}",
                            '1821px',
                            '904px'
                        ],
                        [
                            "eid469",
                            "left",
                            25354,
                            768,
                            "easeOutQuad",
                            "${hand2}",
                            '904px',
                            '1818px'
                        ],
                        [
                            "eid504",
                            "left",
                            27291,
                            513,
                            "easeOutQuad",
                            "${hand2}",
                            '1818px',
                            '1243px'
                        ],
                        [
                            "eid526",
                            "left",
                            28041,
                            937,
                            "easeOutExpo",
                            "${hand2}",
                            '1243px',
                            '1248px'
                        ],
                        [
                            "eid555",
                            "left",
                            29291,
                            611,
                            "easeOutQuad",
                            "${hand2}",
                            '1248px',
                            '1362px'
                        ],
                        [
                            "eid585",
                            "left",
                            30740,
                            301,
                            "easeOutQuad",
                            "${hand2}",
                            '1362px',
                            '1487px'
                        ],
                        [
                            "eid612",
                            "left",
                            31791,
                            575,
                            "easeOutQuad",
                            "${hand2}",
                            '1487px',
                            '1827px'
                        ],
                        [
                            "eid233",
                            "opacity",
                            10336,
                            254,
                            "easeOutQuad",
                            "${clip_thumbnail_1}",
                            '0',
                            '1'
                        ],
                        [
                            "eid636",
                            "opacity",
                            13974,
                            260,
                            "easeOutQuad",
                            "${clip_thumbnail_1}",
                            '1',
                            '0'
                        ],
                        [
                            "eid629",
                            "opacity",
                            32814,
                            193,
                            "easeOutQuad",
                            "${clip_thumbnail_1}",
                            '0',
                            '1'
                        ],
                        [
                            "eid638",
                            "left",
                            32626,
                            0,
                            "easeOutQuad",
                            "${clip_thumbnail_1}",
                            '457px',
                            '457px'
                        ],
                        [
                            "eid641",
                            "left",
                            32819,
                            0,
                            "easeOutQuad",
                            "${clip_thumbnail_1}",
                            '457px',
                            '1062px'
                        ],
                        [
                            "eid243",
                            "opacity",
                            13974,
                            260,
                            "easeOutQuad",
                            "${download_symbols}",
                            '0.000000',
                            '1'
                        ],
                        [
                            "eid260",
                            "opacity",
                            15846,
                            102,
                            "easeOutQuad",
                            "${download_symbols}",
                            '1',
                            '0'
                        ],
                        [
                            "eid677",
                            "opacity",
                            32814,
                            193,
                            "easeOutExpo",
                            "${kinemaster_source_video_clip2}",
                            '0',
                            '1'
                        ],
                        [
                            "eid668",
                            "opacity",
                            32814,
                            193,
                            "easeOutQuad",
                            "${transition_effect_theme_change_icon}",
                            '0',
                            '1'
                        ],
                        [
                            "eid308",
                            "opacity",
                            19201,
                            174,
                            "easeOutQuad",
                            "${_02_04_Step3_Text_Title}",
                            '0',
                            '1'
                        ],
                        [
                            "eid41",
                            "opacity",
                            2180,
                            237,
                            "easeOutQuad",
                            "${rectangle}",
                            '0',
                            '0.6422764658927917'
                        ]
                    ]
                }
            }
        };

    AdobeEdge.registerCompositionDefn(compId, symbols, fonts, scripts, resources, opts);

    if (!window.edge_authoring_mode) AdobeEdge.getComposition(compId).load("Getting_started_part1_edgeActions.js");
})("EDGE-440806496");

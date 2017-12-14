package com.faithyee.androidlearningdemo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Author：yewmf on 2017/12/14 10:16
 * E-mail：faith_yee@163.com
 */
public class MovieDetails implements Serializable {


    /**
     * code : 1
     * data : {"advertisement":{"advList":[{"advTag":"","endDate":1514649599,"isHorizontalScreen":false,"isOpenH5":false,"startDate":1451577600,"tag":"商城乐高+商城暖冬专题","type":"203","typeName":"影片详情页banner2","url":"https://static1.mtime.cn/feature/mobile/banner/2017/1204/lgnd750210m.html"}],"count":1,"error":"","success":true},"basic":{"actors":[{"actorId":900976,"img":"http://img31.mtime.cn/ph/2014/03/16/134402.97761965_1280X720X2.jpg","name":"本·阿弗莱克","nameEn":"Ben Affleck","roleImg":"http://img5.mtime.cn/mg/2017/11/15/110250.72491431.jpg","roleName":"布鲁斯·韦恩 / 蝙蝠侠"},{"actorId":1533592,"img":"http://img5.mtime.cn/ph/2017/06/05/160721.33243856_1280X720X2.jpg","name":"盖尔·加朵","nameEn":"Gal Gadot","roleImg":"http://img5.mtime.cn/mg/2017/11/15/110255.24873752.jpg","roleName":"戴安娜·普林斯 / 神奇女侠"},{"actorId":925259,"img":"http://img31.mtime.cn/ph/2016/03/15/104052.40236629_1280X720X2.jpg","name":"杰森·莫玛","nameEn":"Jason Momoa","roleImg":"http://img5.mtime.cn/mg/2017/11/15/110301.41176587.jpg","roleName":"亚瑟·柯里 / 海王"},{"actorId":1520803,"img":"http://img31.mtime.cn/ph/2014/10/17/164315.73873666_1280X720X2.jpg","name":"埃兹拉·米勒","nameEn":"Ezra Miller","roleImg":"http://img5.mtime.cn/mg/2017/11/15/110307.53607205.jpg","roleName":"巴里·艾伦 / 闪电侠"},{"actorId":2089658,"img":"http://img31.mtime.cn/ph/2016/03/18/150727.69752455_1280X720X2.jpg","name":"雷·费舍","nameEn":"Ray Fisher","roleImg":"http://img5.mtime.cn/mg/2017/11/15/110312.22002486.jpg","roleName":"维克多·斯通 / 钢骨"},{"actorId":941888,"img":"http://img31.mtime.cn/ph/2014/03/14/152814.87360918_1280X720X2.jpg","name":"亨利·卡维尔","nameEn":"Henry Cavill","roleImg":"http://img5.mtime.cn/mg/2017/11/15/110321.90324395.jpg","roleName":"克拉克·肯特 / 超人"},{"actorId":928293,"img":"http://img31.mtime.cn/ph/2016/06/14/104507.72789989_1280X720X2.jpg","name":"塞伦·希德","nameEn":"Ciarán Hinds","roleImg":"","roleName":"荒原狼"},{"actorId":928970,"img":"http://img31.mtime.cn/ph/2014/03/14/152415.48439784_1280X720X2.jpg","name":"艾米·亚当斯","nameEn":"Amy Adams","roleImg":"","roleName":"露易丝·莱恩"},{"actorId":975684,"img":"http://img31.mtime.cn/ph/2014/03/17/065201.59721901_1280X720X2.jpg","name":"艾梅柏·希尔德","nameEn":"Amber Heard","roleImg":"","roleName":"湄拉"},{"actorId":920328,"img":"http://img31.mtime.cn/ph/2015/01/19/105011.72812862_1280X720X2.jpg","name":"J·K·西蒙斯","nameEn":"J.K. Simmons","roleImg":"","roleName":"戈登局长"},{"actorId":914870,"img":"http://img31.mtime.cn/ph/2016/08/25/165306.65515275_1280X720X2.jpg","name":"杰瑞米·艾恩斯","nameEn":"Jeremy Irons","roleImg":"","roleName":"阿尔弗莱德"},{"actorId":914936,"img":"http://img31.mtime.cn/ph/2014/12/08/103009.69425109_1280X720X2.jpg","name":"康妮·尼尔森","nameEn":"Connie Nielsen","roleImg":"","roleName":"希波吕忒女王"},{"actorId":919233,"img":"http://img31.mtime.cn/ph/2015/03/11/104121.89092326_1280X720X2.jpg","name":"黛安·莲恩","nameEn":"Diane Lane","roleImg":"","roleName":"玛莎·肯特"},{"actorId":930338,"img":"http://img31.mtime.cn/ph/2015/11/21/170258.58191457_1280X720X2.jpg","name":"比利·克鲁德普","nameEn":"Billy Crudup","roleImg":"","roleName":"亨利·艾伦"},{"actorId":914798,"img":"http://img31.mtime.cn/ph/2015/01/23/092552.49395334_1280X720X2.jpg","name":"杰西·艾森伯格","nameEn":"Jesse Eisenberg","roleImg":"","roleName":"莱斯·卢瑟"},{"actorId":978106,"img":"http://img31.mtime.cn/ph/2014/05/27/150614.17764795_1280X720X2.jpg","name":"乔·曼根尼罗","nameEn":"Joe Manganiello","roleImg":"","roleName":"丧钟"},{"actorId":908513,"img":"http://img31.mtime.cn/ph/2014/06/10/092531.78145646_1280X720X2.jpg","name":"乔·莫顿","nameEn":"Joe Morton","roleImg":"","roleName":"Silas Stone"},{"actorId":2155464,"img":"http://img31.mtime.cn/ph/2016/04/25/174955.24197416_1280X720X2.jpg","name":"","nameEn":"Karl Farrer","roleImg":"","roleName":"Co-pilot       (uncredited)"},{"actorId":930401,"img":"http://img31.mtime.cn/ph/2016/08/25/165803.73930679_1280X720X2.jpg","name":"","nameEn":"Bruce Johnson","roleImg":"","roleName":"Prison Guard       (as Bruce Lester Johnson)"},{"actorId":2184783,"img":"http://img31.mtime.cn/ph/2016/05/17/145356.55173757_1280X720X2.jpg","name":"","nameEn":"Arthur Wilde","roleImg":"","roleName":"Landing Crew       (uncredited)"}],"award":{"awardList":[],"totalNominateAward":0,"totalWinAward":0},"commentSpecial":"神奇女侠完美海王闪电侠抢戏","community":{},"director":{"directorId":904479,"img":"http://img31.mtime.cn/ph/2014/03/14/152813.57148097_1280X720X2.jpg","name":"扎克·施奈德","nameEn":"Zack Snyder"},"festivals":[],"hotRanking":2,"img":"http://img5.mtime.cn/mt/2017/11/22/115051.54720032_1280X720X2.jpg","is3D":true,"isDMAX":true,"isEggHunt":true,"isFilter":false,"isIMAX":false,"isIMAX3D":true,"isTicket":true,"message":"该操作将清除您对该片的评分！是否确认？","mins":"120分钟","movieId":70233,"name":"正义联盟","nameEn":"Justice League","overallRating":7.4,"personCount":326,"quizGame":{},"releaseArea":"中国","releaseDate":"20171117","showCinemaCount":73,"showDay":1513238400,"showtimeCount":144,"stageImg":{"count":370,"list":[{"imgId":7315234,"imgUrl":"http://img5.mtime.cn/pi/2017/02/07/093632.56783418_1280X720X2.jpg"},{"imgId":7347346,"imgUrl":"http://img5.mtime.cn/pi/2017/07/14/100147.41740632_1280X720X2.jpg"},{"imgId":7412731,"imgUrl":"http://img5.mtime.cn/pi/2017/11/04/102140.43805070_1280X720X2.jpg"},{"imgId":7412732,"imgUrl":"http://img5.mtime.cn/pi/2017/11/04/102140.88265682_1280X720X2.jpg"}]},"story":"在对人性重新燃起的希望所驱使，以及被超人的英勇之举所感染，布鲁斯·韦恩与他最新的盟友戴安娜·普林斯一起，组建了一支超强队伍，应对更强劲敌的来袭。虽然这队联盟的各个超级英雄都大有来头\u2014\u2014蝙蝠侠、神奇女侠、海王、钢骨与闪电侠，他们首度集结，力挽狂澜，拯救地球免遭灭顶之灾。","style":{"isLeadPage":0,"leadImg":"https://img2.mtime.cn/mg/.jpg","leadUrl":""},"totalNominateAward":0,"totalWinAward":0,"type":["动作","冒险","奇幻","科幻"],"url":"https://movie.mtime.com/70233/","video":{"count":53,"hightUrl":"https://vfx.mtime.cn/Video/2017/10/27/mp4/171027025021129698.mp4","img":"http://img5.mtime.cn/mg/2017/10/27/025231.81373368_235X132X4.jpg","title":"正义联盟 中国预告片","url":"https://vfx.mtime.cn/Video/2017/10/27/mp4/171027025021129698_480.mp4","videoId":68177}},"boxOffice":{"movieId":70233,"ranking":8,"todayBox":27003891,"todayBoxDes":"27.0","todayBoxDesUnit":"今日实时(万)","totalBox":68725662352,"totalBoxDes":"6.87","totalBoxUnit":"累计票房(亿)"},"live":{"count":1,"img":"http://img5.mtime.cn/mg/2017/10/26/170916.79034615.jpg","liveId":696,"playNumTag":"98万次播放","playTag":"","status":4,"title":"《正义联盟》\u201c六巨头\u201d北京粉丝见面会"},"related":{"goodsCount":76,"goodsList":[{"background":"#25ACBD","goodsId":106476,"goodsUrl":"https://mall-wv.mtime.cn/#!/commerce/item/106476/","iconText":"新品","image":"http://img5.mtime.cn/mg/2017/11/02/142138.48487027_294X294X4.jpg","longName":"正义联盟 蝙蝠侠战车充电宝 7000mAh ABS+PVC","marketPrice":18800,"marketPriceFormat":"188.00","minSalePrice":18800,"minSalePriceFormat":"188.00","name":"正义联盟蝙蝠侠战车充电宝"},{"background":"#25ACBD","goodsId":106515,"goodsUrl":"https://mall-wv.mtime.cn/#!/commerce/item/106515/","iconText":"新品","image":"http://img5.mtime.cn/mg/2017/10/10/151219.15962309_294X294X4.jpg","longName":"长袖运动休闲帽衫棒球服休闲服卫衣","marketPrice":19900,"marketPriceFormat":"199.00","minSalePrice":19900,"minSalePriceFormat":"199.00","name":"正义联盟超人卫衣"},{"background":"#25ACBD","goodsId":106469,"goodsUrl":"https://mall-wv.mtime.cn/#!/commerce/item/106469/","iconText":"新品","image":"http://img5.mtime.cn/mg/2017/10/09/153449.29807542_294X294X4.jpg","longName":"陶瓷马克杯办公室水杯","marketPrice":7900,"marketPriceFormat":"79.00","minSalePrice":7900,"minSalePriceFormat":"79.00","name":"正义联盟超人马克杯"}],"relateId":0,"relatedUrl":"https://mall-wv.mtime.cn/?mid=70233&relatedNativeType=1&utm_source=app_movie_btn_more#!/commerce/list/","type":0}}
     * msg : 成功
     * showMsg :
     */

    private String code;
    private DataBean data;
    private String msg;
    private String showMsg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getShowMsg() {
        return showMsg;
    }

    public void setShowMsg(String showMsg) {
        this.showMsg = showMsg;
    }

    public static class DataBean {
        /**
         * advertisement : {"advList":[{"advTag":"","endDate":1514649599,"isHorizontalScreen":false,"isOpenH5":false,"startDate":1451577600,"tag":"商城乐高+商城暖冬专题","type":"203","typeName":"影片详情页banner2","url":"https://static1.mtime.cn/feature/mobile/banner/2017/1204/lgnd750210m.html"}],"count":1,"error":"","success":true}
         * basic : {"actors":[{"actorId":900976,"img":"http://img31.mtime.cn/ph/2014/03/16/134402.97761965_1280X720X2.jpg","name":"本·阿弗莱克","nameEn":"Ben Affleck","roleImg":"http://img5.mtime.cn/mg/2017/11/15/110250.72491431.jpg","roleName":"布鲁斯·韦恩 / 蝙蝠侠"},{"actorId":1533592,"img":"http://img5.mtime.cn/ph/2017/06/05/160721.33243856_1280X720X2.jpg","name":"盖尔·加朵","nameEn":"Gal Gadot","roleImg":"http://img5.mtime.cn/mg/2017/11/15/110255.24873752.jpg","roleName":"戴安娜·普林斯 / 神奇女侠"},{"actorId":925259,"img":"http://img31.mtime.cn/ph/2016/03/15/104052.40236629_1280X720X2.jpg","name":"杰森·莫玛","nameEn":"Jason Momoa","roleImg":"http://img5.mtime.cn/mg/2017/11/15/110301.41176587.jpg","roleName":"亚瑟·柯里 / 海王"},{"actorId":1520803,"img":"http://img31.mtime.cn/ph/2014/10/17/164315.73873666_1280X720X2.jpg","name":"埃兹拉·米勒","nameEn":"Ezra Miller","roleImg":"http://img5.mtime.cn/mg/2017/11/15/110307.53607205.jpg","roleName":"巴里·艾伦 / 闪电侠"},{"actorId":2089658,"img":"http://img31.mtime.cn/ph/2016/03/18/150727.69752455_1280X720X2.jpg","name":"雷·费舍","nameEn":"Ray Fisher","roleImg":"http://img5.mtime.cn/mg/2017/11/15/110312.22002486.jpg","roleName":"维克多·斯通 / 钢骨"},{"actorId":941888,"img":"http://img31.mtime.cn/ph/2014/03/14/152814.87360918_1280X720X2.jpg","name":"亨利·卡维尔","nameEn":"Henry Cavill","roleImg":"http://img5.mtime.cn/mg/2017/11/15/110321.90324395.jpg","roleName":"克拉克·肯特 / 超人"},{"actorId":928293,"img":"http://img31.mtime.cn/ph/2016/06/14/104507.72789989_1280X720X2.jpg","name":"塞伦·希德","nameEn":"Ciarán Hinds","roleImg":"","roleName":"荒原狼"},{"actorId":928970,"img":"http://img31.mtime.cn/ph/2014/03/14/152415.48439784_1280X720X2.jpg","name":"艾米·亚当斯","nameEn":"Amy Adams","roleImg":"","roleName":"露易丝·莱恩"},{"actorId":975684,"img":"http://img31.mtime.cn/ph/2014/03/17/065201.59721901_1280X720X2.jpg","name":"艾梅柏·希尔德","nameEn":"Amber Heard","roleImg":"","roleName":"湄拉"},{"actorId":920328,"img":"http://img31.mtime.cn/ph/2015/01/19/105011.72812862_1280X720X2.jpg","name":"J·K·西蒙斯","nameEn":"J.K. Simmons","roleImg":"","roleName":"戈登局长"},{"actorId":914870,"img":"http://img31.mtime.cn/ph/2016/08/25/165306.65515275_1280X720X2.jpg","name":"杰瑞米·艾恩斯","nameEn":"Jeremy Irons","roleImg":"","roleName":"阿尔弗莱德"},{"actorId":914936,"img":"http://img31.mtime.cn/ph/2014/12/08/103009.69425109_1280X720X2.jpg","name":"康妮·尼尔森","nameEn":"Connie Nielsen","roleImg":"","roleName":"希波吕忒女王"},{"actorId":919233,"img":"http://img31.mtime.cn/ph/2015/03/11/104121.89092326_1280X720X2.jpg","name":"黛安·莲恩","nameEn":"Diane Lane","roleImg":"","roleName":"玛莎·肯特"},{"actorId":930338,"img":"http://img31.mtime.cn/ph/2015/11/21/170258.58191457_1280X720X2.jpg","name":"比利·克鲁德普","nameEn":"Billy Crudup","roleImg":"","roleName":"亨利·艾伦"},{"actorId":914798,"img":"http://img31.mtime.cn/ph/2015/01/23/092552.49395334_1280X720X2.jpg","name":"杰西·艾森伯格","nameEn":"Jesse Eisenberg","roleImg":"","roleName":"莱斯·卢瑟"},{"actorId":978106,"img":"http://img31.mtime.cn/ph/2014/05/27/150614.17764795_1280X720X2.jpg","name":"乔·曼根尼罗","nameEn":"Joe Manganiello","roleImg":"","roleName":"丧钟"},{"actorId":908513,"img":"http://img31.mtime.cn/ph/2014/06/10/092531.78145646_1280X720X2.jpg","name":"乔·莫顿","nameEn":"Joe Morton","roleImg":"","roleName":"Silas Stone"},{"actorId":2155464,"img":"http://img31.mtime.cn/ph/2016/04/25/174955.24197416_1280X720X2.jpg","name":"","nameEn":"Karl Farrer","roleImg":"","roleName":"Co-pilot       (uncredited)"},{"actorId":930401,"img":"http://img31.mtime.cn/ph/2016/08/25/165803.73930679_1280X720X2.jpg","name":"","nameEn":"Bruce Johnson","roleImg":"","roleName":"Prison Guard       (as Bruce Lester Johnson)"},{"actorId":2184783,"img":"http://img31.mtime.cn/ph/2016/05/17/145356.55173757_1280X720X2.jpg","name":"","nameEn":"Arthur Wilde","roleImg":"","roleName":"Landing Crew       (uncredited)"}],"award":{"awardList":[],"totalNominateAward":0,"totalWinAward":0},"commentSpecial":"神奇女侠完美海王闪电侠抢戏","community":{},"director":{"directorId":904479,"img":"http://img31.mtime.cn/ph/2014/03/14/152813.57148097_1280X720X2.jpg","name":"扎克·施奈德","nameEn":"Zack Snyder"},"festivals":[],"hotRanking":2,"img":"http://img5.mtime.cn/mt/2017/11/22/115051.54720032_1280X720X2.jpg","is3D":true,"isDMAX":true,"isEggHunt":true,"isFilter":false,"isIMAX":false,"isIMAX3D":true,"isTicket":true,"message":"该操作将清除您对该片的评分！是否确认？","mins":"120分钟","movieId":70233,"name":"正义联盟","nameEn":"Justice League","overallRating":7.4,"personCount":326,"quizGame":{},"releaseArea":"中国","releaseDate":"20171117","showCinemaCount":73,"showDay":1513238400,"showtimeCount":144,"stageImg":{"count":370,"list":[{"imgId":7315234,"imgUrl":"http://img5.mtime.cn/pi/2017/02/07/093632.56783418_1280X720X2.jpg"},{"imgId":7347346,"imgUrl":"http://img5.mtime.cn/pi/2017/07/14/100147.41740632_1280X720X2.jpg"},{"imgId":7412731,"imgUrl":"http://img5.mtime.cn/pi/2017/11/04/102140.43805070_1280X720X2.jpg"},{"imgId":7412732,"imgUrl":"http://img5.mtime.cn/pi/2017/11/04/102140.88265682_1280X720X2.jpg"}]},"story":"在对人性重新燃起的希望所驱使，以及被超人的英勇之举所感染，布鲁斯·韦恩与他最新的盟友戴安娜·普林斯一起，组建了一支超强队伍，应对更强劲敌的来袭。虽然这队联盟的各个超级英雄都大有来头\u2014\u2014蝙蝠侠、神奇女侠、海王、钢骨与闪电侠，他们首度集结，力挽狂澜，拯救地球免遭灭顶之灾。","style":{"isLeadPage":0,"leadImg":"https://img2.mtime.cn/mg/.jpg","leadUrl":""},"totalNominateAward":0,"totalWinAward":0,"type":["动作","冒险","奇幻","科幻"],"url":"https://movie.mtime.com/70233/","video":{"count":53,"hightUrl":"https://vfx.mtime.cn/Video/2017/10/27/mp4/171027025021129698.mp4","img":"http://img5.mtime.cn/mg/2017/10/27/025231.81373368_235X132X4.jpg","title":"正义联盟 中国预告片","url":"https://vfx.mtime.cn/Video/2017/10/27/mp4/171027025021129698_480.mp4","videoId":68177}}
         * boxOffice : {"movieId":70233,"ranking":8,"todayBox":27003891,"todayBoxDes":"27.0","todayBoxDesUnit":"今日实时(万)","totalBox":68725662352,"totalBoxDes":"6.87","totalBoxUnit":"累计票房(亿)"}
         * live : {"count":1,"img":"http://img5.mtime.cn/mg/2017/10/26/170916.79034615.jpg","liveId":696,"playNumTag":"98万次播放","playTag":"","status":4,"title":"《正义联盟》\u201c六巨头\u201d北京粉丝见面会"}
         * related : {"goodsCount":76,"goodsList":[{"background":"#25ACBD","goodsId":106476,"goodsUrl":"https://mall-wv.mtime.cn/#!/commerce/item/106476/","iconText":"新品","image":"http://img5.mtime.cn/mg/2017/11/02/142138.48487027_294X294X4.jpg","longName":"正义联盟 蝙蝠侠战车充电宝 7000mAh ABS+PVC","marketPrice":18800,"marketPriceFormat":"188.00","minSalePrice":18800,"minSalePriceFormat":"188.00","name":"正义联盟蝙蝠侠战车充电宝"},{"background":"#25ACBD","goodsId":106515,"goodsUrl":"https://mall-wv.mtime.cn/#!/commerce/item/106515/","iconText":"新品","image":"http://img5.mtime.cn/mg/2017/10/10/151219.15962309_294X294X4.jpg","longName":"长袖运动休闲帽衫棒球服休闲服卫衣","marketPrice":19900,"marketPriceFormat":"199.00","minSalePrice":19900,"minSalePriceFormat":"199.00","name":"正义联盟超人卫衣"},{"background":"#25ACBD","goodsId":106469,"goodsUrl":"https://mall-wv.mtime.cn/#!/commerce/item/106469/","iconText":"新品","image":"http://img5.mtime.cn/mg/2017/10/09/153449.29807542_294X294X4.jpg","longName":"陶瓷马克杯办公室水杯","marketPrice":7900,"marketPriceFormat":"79.00","minSalePrice":7900,"minSalePriceFormat":"79.00","name":"正义联盟超人马克杯"}],"relateId":0,"relatedUrl":"https://mall-wv.mtime.cn/?mid=70233&relatedNativeType=1&utm_source=app_movie_btn_more#!/commerce/list/","type":0}
         */

        private AdvertisementBean advertisement;
        private BasicBean basic;
        private BoxOfficeBean boxOffice;
        private LiveBean live;
        private RelatedBean related;

        public AdvertisementBean getAdvertisement() {
            return advertisement;
        }

        public void setAdvertisement(AdvertisementBean advertisement) {
            this.advertisement = advertisement;
        }

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public BoxOfficeBean getBoxOffice() {
            return boxOffice;
        }

        public void setBoxOffice(BoxOfficeBean boxOffice) {
            this.boxOffice = boxOffice;
        }

        public LiveBean getLive() {
            return live;
        }

        public void setLive(LiveBean live) {
            this.live = live;
        }

        public RelatedBean getRelated() {
            return related;
        }

        public void setRelated(RelatedBean related) {
            this.related = related;
        }

        public static class AdvertisementBean {
            /**
             * advList : [{"advTag":"","endDate":1514649599,"isHorizontalScreen":false,"isOpenH5":false,"startDate":1451577600,"tag":"商城乐高+商城暖冬专题","type":"203","typeName":"影片详情页banner2","url":"https://static1.mtime.cn/feature/mobile/banner/2017/1204/lgnd750210m.html"}]
             * count : 1
             * error :
             * success : true
             */

            private int count;
            private String error;
            private boolean success;
            private List<AdvListBean> advList;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getError() {
                return error;
            }

            public void setError(String error) {
                this.error = error;
            }

            public boolean isSuccess() {
                return success;
            }

            public void setSuccess(boolean success) {
                this.success = success;
            }

            public List<AdvListBean> getAdvList() {
                return advList;
            }

            public void setAdvList(List<AdvListBean> advList) {
                this.advList = advList;
            }

            public static class AdvListBean {
                /**
                 * advTag :
                 * endDate : 1514649599
                 * isHorizontalScreen : false
                 * isOpenH5 : false
                 * startDate : 1451577600
                 * tag : 商城乐高+商城暖冬专题
                 * type : 203
                 * typeName : 影片详情页banner2
                 * url : https://static1.mtime.cn/feature/mobile/banner/2017/1204/lgnd750210m.html
                 */

                private String advTag;
                private int endDate;
                private boolean isHorizontalScreen;
                private boolean isOpenH5;
                private int startDate;
                private String tag;
                private String type;
                private String typeName;
                private String url;

                public String getAdvTag() {
                    return advTag;
                }

                public void setAdvTag(String advTag) {
                    this.advTag = advTag;
                }

                public int getEndDate() {
                    return endDate;
                }

                public void setEndDate(int endDate) {
                    this.endDate = endDate;
                }

                public boolean isIsHorizontalScreen() {
                    return isHorizontalScreen;
                }

                public void setIsHorizontalScreen(boolean isHorizontalScreen) {
                    this.isHorizontalScreen = isHorizontalScreen;
                }

                public boolean isIsOpenH5() {
                    return isOpenH5;
                }

                public void setIsOpenH5(boolean isOpenH5) {
                    this.isOpenH5 = isOpenH5;
                }

                public int getStartDate() {
                    return startDate;
                }

                public void setStartDate(int startDate) {
                    this.startDate = startDate;
                }

                public String getTag() {
                    return tag;
                }

                public void setTag(String tag) {
                    this.tag = tag;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getTypeName() {
                    return typeName;
                }

                public void setTypeName(String typeName) {
                    this.typeName = typeName;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }

        public static class BasicBean {
            /**
             * actors : [{"actorId":900976,"img":"http://img31.mtime.cn/ph/2014/03/16/134402.97761965_1280X720X2.jpg","name":"本·阿弗莱克","nameEn":"Ben Affleck","roleImg":"http://img5.mtime.cn/mg/2017/11/15/110250.72491431.jpg","roleName":"布鲁斯·韦恩 / 蝙蝠侠"},{"actorId":1533592,"img":"http://img5.mtime.cn/ph/2017/06/05/160721.33243856_1280X720X2.jpg","name":"盖尔·加朵","nameEn":"Gal Gadot","roleImg":"http://img5.mtime.cn/mg/2017/11/15/110255.24873752.jpg","roleName":"戴安娜·普林斯 / 神奇女侠"},{"actorId":925259,"img":"http://img31.mtime.cn/ph/2016/03/15/104052.40236629_1280X720X2.jpg","name":"杰森·莫玛","nameEn":"Jason Momoa","roleImg":"http://img5.mtime.cn/mg/2017/11/15/110301.41176587.jpg","roleName":"亚瑟·柯里 / 海王"},{"actorId":1520803,"img":"http://img31.mtime.cn/ph/2014/10/17/164315.73873666_1280X720X2.jpg","name":"埃兹拉·米勒","nameEn":"Ezra Miller","roleImg":"http://img5.mtime.cn/mg/2017/11/15/110307.53607205.jpg","roleName":"巴里·艾伦 / 闪电侠"},{"actorId":2089658,"img":"http://img31.mtime.cn/ph/2016/03/18/150727.69752455_1280X720X2.jpg","name":"雷·费舍","nameEn":"Ray Fisher","roleImg":"http://img5.mtime.cn/mg/2017/11/15/110312.22002486.jpg","roleName":"维克多·斯通 / 钢骨"},{"actorId":941888,"img":"http://img31.mtime.cn/ph/2014/03/14/152814.87360918_1280X720X2.jpg","name":"亨利·卡维尔","nameEn":"Henry Cavill","roleImg":"http://img5.mtime.cn/mg/2017/11/15/110321.90324395.jpg","roleName":"克拉克·肯特 / 超人"},{"actorId":928293,"img":"http://img31.mtime.cn/ph/2016/06/14/104507.72789989_1280X720X2.jpg","name":"塞伦·希德","nameEn":"Ciarán Hinds","roleImg":"","roleName":"荒原狼"},{"actorId":928970,"img":"http://img31.mtime.cn/ph/2014/03/14/152415.48439784_1280X720X2.jpg","name":"艾米·亚当斯","nameEn":"Amy Adams","roleImg":"","roleName":"露易丝·莱恩"},{"actorId":975684,"img":"http://img31.mtime.cn/ph/2014/03/17/065201.59721901_1280X720X2.jpg","name":"艾梅柏·希尔德","nameEn":"Amber Heard","roleImg":"","roleName":"湄拉"},{"actorId":920328,"img":"http://img31.mtime.cn/ph/2015/01/19/105011.72812862_1280X720X2.jpg","name":"J·K·西蒙斯","nameEn":"J.K. Simmons","roleImg":"","roleName":"戈登局长"},{"actorId":914870,"img":"http://img31.mtime.cn/ph/2016/08/25/165306.65515275_1280X720X2.jpg","name":"杰瑞米·艾恩斯","nameEn":"Jeremy Irons","roleImg":"","roleName":"阿尔弗莱德"},{"actorId":914936,"img":"http://img31.mtime.cn/ph/2014/12/08/103009.69425109_1280X720X2.jpg","name":"康妮·尼尔森","nameEn":"Connie Nielsen","roleImg":"","roleName":"希波吕忒女王"},{"actorId":919233,"img":"http://img31.mtime.cn/ph/2015/03/11/104121.89092326_1280X720X2.jpg","name":"黛安·莲恩","nameEn":"Diane Lane","roleImg":"","roleName":"玛莎·肯特"},{"actorId":930338,"img":"http://img31.mtime.cn/ph/2015/11/21/170258.58191457_1280X720X2.jpg","name":"比利·克鲁德普","nameEn":"Billy Crudup","roleImg":"","roleName":"亨利·艾伦"},{"actorId":914798,"img":"http://img31.mtime.cn/ph/2015/01/23/092552.49395334_1280X720X2.jpg","name":"杰西·艾森伯格","nameEn":"Jesse Eisenberg","roleImg":"","roleName":"莱斯·卢瑟"},{"actorId":978106,"img":"http://img31.mtime.cn/ph/2014/05/27/150614.17764795_1280X720X2.jpg","name":"乔·曼根尼罗","nameEn":"Joe Manganiello","roleImg":"","roleName":"丧钟"},{"actorId":908513,"img":"http://img31.mtime.cn/ph/2014/06/10/092531.78145646_1280X720X2.jpg","name":"乔·莫顿","nameEn":"Joe Morton","roleImg":"","roleName":"Silas Stone"},{"actorId":2155464,"img":"http://img31.mtime.cn/ph/2016/04/25/174955.24197416_1280X720X2.jpg","name":"","nameEn":"Karl Farrer","roleImg":"","roleName":"Co-pilot       (uncredited)"},{"actorId":930401,"img":"http://img31.mtime.cn/ph/2016/08/25/165803.73930679_1280X720X2.jpg","name":"","nameEn":"Bruce Johnson","roleImg":"","roleName":"Prison Guard       (as Bruce Lester Johnson)"},{"actorId":2184783,"img":"http://img31.mtime.cn/ph/2016/05/17/145356.55173757_1280X720X2.jpg","name":"","nameEn":"Arthur Wilde","roleImg":"","roleName":"Landing Crew       (uncredited)"}]
             * award : {"awardList":[],"totalNominateAward":0,"totalWinAward":0}
             * commentSpecial : 神奇女侠完美海王闪电侠抢戏
             * community : {}
             * director : {"directorId":904479,"img":"http://img31.mtime.cn/ph/2014/03/14/152813.57148097_1280X720X2.jpg","name":"扎克·施奈德","nameEn":"Zack Snyder"}
             * festivals : []
             * hotRanking : 2
             * img : http://img5.mtime.cn/mt/2017/11/22/115051.54720032_1280X720X2.jpg
             * is3D : true
             * isDMAX : true
             * isEggHunt : true
             * isFilter : false
             * isIMAX : false
             * isIMAX3D : true
             * isTicket : true
             * message : 该操作将清除您对该片的评分！是否确认？
             * mins : 120分钟
             * movieId : 70233
             * name : 正义联盟
             * nameEn : Justice League
             * overallRating : 7.4
             * personCount : 326
             * quizGame : {}
             * releaseArea : 中国
             * releaseDate : 20171117
             * showCinemaCount : 73
             * showDay : 1513238400
             * showtimeCount : 144
             * stageImg : {"count":370,"list":[{"imgId":7315234,"imgUrl":"http://img5.mtime.cn/pi/2017/02/07/093632.56783418_1280X720X2.jpg"},{"imgId":7347346,"imgUrl":"http://img5.mtime.cn/pi/2017/07/14/100147.41740632_1280X720X2.jpg"},{"imgId":7412731,"imgUrl":"http://img5.mtime.cn/pi/2017/11/04/102140.43805070_1280X720X2.jpg"},{"imgId":7412732,"imgUrl":"http://img5.mtime.cn/pi/2017/11/04/102140.88265682_1280X720X2.jpg"}]}
             * story : 在对人性重新燃起的希望所驱使，以及被超人的英勇之举所感染，布鲁斯·韦恩与他最新的盟友戴安娜·普林斯一起，组建了一支超强队伍，应对更强劲敌的来袭。虽然这队联盟的各个超级英雄都大有来头——蝙蝠侠、神奇女侠、海王、钢骨与闪电侠，他们首度集结，力挽狂澜，拯救地球免遭灭顶之灾。
             * style : {"isLeadPage":0,"leadImg":"https://img2.mtime.cn/mg/.jpg","leadUrl":""}
             * totalNominateAward : 0
             * totalWinAward : 0
             * type : ["动作","冒险","奇幻","科幻"]
             * url : https://movie.mtime.com/70233/
             * video : {"count":53,"hightUrl":"https://vfx.mtime.cn/Video/2017/10/27/mp4/171027025021129698.mp4","img":"http://img5.mtime.cn/mg/2017/10/27/025231.81373368_235X132X4.jpg","title":"正义联盟 中国预告片","url":"https://vfx.mtime.cn/Video/2017/10/27/mp4/171027025021129698_480.mp4","videoId":68177}
             */

            private AwardBean award;
            private String commentSpecial;
            private CommunityBean community;
            private DirectorBean director;
            private int hotRanking;
            private String img;
            private boolean is3D;
            private boolean isDMAX;
            private boolean isEggHunt;
            private boolean isFilter;
            private boolean isIMAX;
            private boolean isIMAX3D;
            private boolean isTicket;
            private String message;
            private String mins;
            private int movieId;
            private String name;
            private String nameEn;
            private double overallRating;
            private int personCount;
            private QuizGameBean quizGame;
            private String releaseArea;
            private String releaseDate;
            private int showCinemaCount;
            private int showDay;
            private int showtimeCount;
            private StageImgBean stageImg;
            private String story;
            private StyleBean style;
            private int totalNominateAward;
            private int totalWinAward;
            private String url;
            private VideoBean video;
            private List<ActorsBean> actors;
            private List<?> festivals;
            private List<String> type;

            public AwardBean getAward() {
                return award;
            }

            public void setAward(AwardBean award) {
                this.award = award;
            }

            public String getCommentSpecial() {
                return commentSpecial;
            }

            public void setCommentSpecial(String commentSpecial) {
                this.commentSpecial = commentSpecial;
            }

            public CommunityBean getCommunity() {
                return community;
            }

            public void setCommunity(CommunityBean community) {
                this.community = community;
            }

            public DirectorBean getDirector() {
                return director;
            }

            public void setDirector(DirectorBean director) {
                this.director = director;
            }

            public int getHotRanking() {
                return hotRanking;
            }

            public void setHotRanking(int hotRanking) {
                this.hotRanking = hotRanking;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public boolean isIs3D() {
                return is3D;
            }

            public void setIs3D(boolean is3D) {
                this.is3D = is3D;
            }

            public boolean isIsDMAX() {
                return isDMAX;
            }

            public void setIsDMAX(boolean isDMAX) {
                this.isDMAX = isDMAX;
            }

            public boolean isIsEggHunt() {
                return isEggHunt;
            }

            public void setIsEggHunt(boolean isEggHunt) {
                this.isEggHunt = isEggHunt;
            }

            public boolean isIsFilter() {
                return isFilter;
            }

            public void setIsFilter(boolean isFilter) {
                this.isFilter = isFilter;
            }

            public boolean isIsIMAX() {
                return isIMAX;
            }

            public void setIsIMAX(boolean isIMAX) {
                this.isIMAX = isIMAX;
            }

            public boolean isIsIMAX3D() {
                return isIMAX3D;
            }

            public void setIsIMAX3D(boolean isIMAX3D) {
                this.isIMAX3D = isIMAX3D;
            }

            public boolean isIsTicket() {
                return isTicket;
            }

            public void setIsTicket(boolean isTicket) {
                this.isTicket = isTicket;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public String getMins() {
                return mins;
            }

            public void setMins(String mins) {
                this.mins = mins;
            }

            public int getMovieId() {
                return movieId;
            }

            public void setMovieId(int movieId) {
                this.movieId = movieId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNameEn() {
                return nameEn;
            }

            public void setNameEn(String nameEn) {
                this.nameEn = nameEn;
            }

            public double getOverallRating() {
                return overallRating;
            }

            public void setOverallRating(double overallRating) {
                this.overallRating = overallRating;
            }

            public int getPersonCount() {
                return personCount;
            }

            public void setPersonCount(int personCount) {
                this.personCount = personCount;
            }

            public QuizGameBean getQuizGame() {
                return quizGame;
            }

            public void setQuizGame(QuizGameBean quizGame) {
                this.quizGame = quizGame;
            }

            public String getReleaseArea() {
                return releaseArea;
            }

            public void setReleaseArea(String releaseArea) {
                this.releaseArea = releaseArea;
            }

            public String getReleaseDate() {
                return releaseDate;
            }

            public void setReleaseDate(String releaseDate) {
                this.releaseDate = releaseDate;
            }

            public int getShowCinemaCount() {
                return showCinemaCount;
            }

            public void setShowCinemaCount(int showCinemaCount) {
                this.showCinemaCount = showCinemaCount;
            }

            public int getShowDay() {
                return showDay;
            }

            public void setShowDay(int showDay) {
                this.showDay = showDay;
            }

            public int getShowtimeCount() {
                return showtimeCount;
            }

            public void setShowtimeCount(int showtimeCount) {
                this.showtimeCount = showtimeCount;
            }

            public StageImgBean getStageImg() {
                return stageImg;
            }

            public void setStageImg(StageImgBean stageImg) {
                this.stageImg = stageImg;
            }

            public String getStory() {
                return story;
            }

            public void setStory(String story) {
                this.story = story;
            }

            public StyleBean getStyle() {
                return style;
            }

            public void setStyle(StyleBean style) {
                this.style = style;
            }

            public int getTotalNominateAward() {
                return totalNominateAward;
            }

            public void setTotalNominateAward(int totalNominateAward) {
                this.totalNominateAward = totalNominateAward;
            }

            public int getTotalWinAward() {
                return totalWinAward;
            }

            public void setTotalWinAward(int totalWinAward) {
                this.totalWinAward = totalWinAward;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public VideoBean getVideo() {
                return video;
            }

            public void setVideo(VideoBean video) {
                this.video = video;
            }

            public List<ActorsBean> getActors() {
                return actors;
            }

            public void setActors(List<ActorsBean> actors) {
                this.actors = actors;
            }

            public List<?> getFestivals() {
                return festivals;
            }

            public void setFestivals(List<?> festivals) {
                this.festivals = festivals;
            }

            public List<String> getType() {
                return type;
            }

            public void setType(List<String> type) {
                this.type = type;
            }

            public static class AwardBean {
            }

            public static class CommunityBean {
            }

            public static class DirectorBean {
            }

            public static class QuizGameBean {
            }

            public static class StageImgBean {
                /**
                 * count : 370
                 * list : [{"imgId":7315234,"imgUrl":"http://img5.mtime.cn/pi/2017/02/07/093632.56783418_1280X720X2.jpg"},{"imgId":7347346,"imgUrl":"http://img5.mtime.cn/pi/2017/07/14/100147.41740632_1280X720X2.jpg"},{"imgId":7412731,"imgUrl":"http://img5.mtime.cn/pi/2017/11/04/102140.43805070_1280X720X2.jpg"},{"imgId":7412732,"imgUrl":"http://img5.mtime.cn/pi/2017/11/04/102140.88265682_1280X720X2.jpg"}]
                 */

                private int count;
                private List<ListBean> list;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public List<ListBean> getList() {
                    return list;
                }

                public void setList(List<ListBean> list) {
                    this.list = list;
                }

                public static class ListBean {
                    /**
                     * imgId : 7315234
                     * imgUrl : http://img5.mtime.cn/pi/2017/02/07/093632.56783418_1280X720X2.jpg
                     */

                    private int imgId;
                    private String imgUrl;

                    public int getImgId() {
                        return imgId;
                    }

                    public void setImgId(int imgId) {
                        this.imgId = imgId;
                    }

                    public String getImgUrl() {
                        return imgUrl;
                    }

                    public void setImgUrl(String imgUrl) {
                        this.imgUrl = imgUrl;
                    }
                }
            }

            public static class StyleBean {
                /**
                 * isLeadPage : 0
                 * leadImg : https://img2.mtime.cn/mg/.jpg
                 * leadUrl :
                 */

                private int isLeadPage;
                private String leadImg;
                private String leadUrl;

                public int getIsLeadPage() {
                    return isLeadPage;
                }

                public void setIsLeadPage(int isLeadPage) {
                    this.isLeadPage = isLeadPage;
                }

                public String getLeadImg() {
                    return leadImg;
                }

                public void setLeadImg(String leadImg) {
                    this.leadImg = leadImg;
                }

                public String getLeadUrl() {
                    return leadUrl;
                }

                public void setLeadUrl(String leadUrl) {
                    this.leadUrl = leadUrl;
                }
            }

            public static class VideoBean {
                /**
                 * count : 53
                 * hightUrl : https://vfx.mtime.cn/Video/2017/10/27/mp4/171027025021129698.mp4
                 * img : http://img5.mtime.cn/mg/2017/10/27/025231.81373368_235X132X4.jpg
                 * title : 正义联盟 中国预告片
                 * url : https://vfx.mtime.cn/Video/2017/10/27/mp4/171027025021129698_480.mp4
                 * videoId : 68177
                 */

                private int count;
                private String hightUrl;
                private String img;
                private String title;
                private String url;
                private int videoId;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public String getHightUrl() {
                    return hightUrl;
                }

                public void setHightUrl(String hightUrl) {
                    this.hightUrl = hightUrl;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getVideoId() {
                    return videoId;
                }

                public void setVideoId(int videoId) {
                    this.videoId = videoId;
                }
            }

            public static class ActorsBean {
                /**
                 * actorId : 900976
                 * img : http://img31.mtime.cn/ph/2014/03/16/134402.97761965_1280X720X2.jpg
                 * name : 本·阿弗莱克
                 * nameEn : Ben Affleck
                 * roleImg : http://img5.mtime.cn/mg/2017/11/15/110250.72491431.jpg
                 * roleName : 布鲁斯·韦恩 / 蝙蝠侠
                 */

                private int actorId;
                private String img;
                private String name;
                private String nameEn;
                private String roleImg;
                private String roleName;

                public int getActorId() {
                    return actorId;
                }

                public void setActorId(int actorId) {
                    this.actorId = actorId;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getNameEn() {
                    return nameEn;
                }

                public void setNameEn(String nameEn) {
                    this.nameEn = nameEn;
                }

                public String getRoleImg() {
                    return roleImg;
                }

                public void setRoleImg(String roleImg) {
                    this.roleImg = roleImg;
                }

                public String getRoleName() {
                    return roleName;
                }

                public void setRoleName(String roleName) {
                    this.roleName = roleName;
                }
            }
        }

        public static class BoxOfficeBean {
            /**
             * movieId : 70233
             * ranking : 8
             * todayBox : 27003891
             * todayBoxDes : 27.0
             * todayBoxDesUnit : 今日实时(万)
             * totalBox : 68725662352
             * totalBoxDes : 6.87
             * totalBoxUnit : 累计票房(亿)
             */

            private int movieId;
            private int ranking;
            private int todayBox;
            private String todayBoxDes;
            private String todayBoxDesUnit;
            private long totalBox;
            private String totalBoxDes;
            private String totalBoxUnit;

            public int getMovieId() {
                return movieId;
            }

            public void setMovieId(int movieId) {
                this.movieId = movieId;
            }

            public int getRanking() {
                return ranking;
            }

            public void setRanking(int ranking) {
                this.ranking = ranking;
            }

            public int getTodayBox() {
                return todayBox;
            }

            public void setTodayBox(int todayBox) {
                this.todayBox = todayBox;
            }

            public String getTodayBoxDes() {
                return todayBoxDes;
            }

            public void setTodayBoxDes(String todayBoxDes) {
                this.todayBoxDes = todayBoxDes;
            }

            public String getTodayBoxDesUnit() {
                return todayBoxDesUnit;
            }

            public void setTodayBoxDesUnit(String todayBoxDesUnit) {
                this.todayBoxDesUnit = todayBoxDesUnit;
            }

            public long getTotalBox() {
                return totalBox;
            }

            public void setTotalBox(long totalBox) {
                this.totalBox = totalBox;
            }

            public String getTotalBoxDes() {
                return totalBoxDes;
            }

            public void setTotalBoxDes(String totalBoxDes) {
                this.totalBoxDes = totalBoxDes;
            }

            public String getTotalBoxUnit() {
                return totalBoxUnit;
            }

            public void setTotalBoxUnit(String totalBoxUnit) {
                this.totalBoxUnit = totalBoxUnit;
            }
        }

        public static class LiveBean {
            /**
             * count : 1
             * img : http://img5.mtime.cn/mg/2017/10/26/170916.79034615.jpg
             * liveId : 696
             * playNumTag : 98万次播放
             * playTag :
             * status : 4
             * title : 《正义联盟》“六巨头”北京粉丝见面会
             */

            private int count;
            private String img;
            private int liveId;
            private String playNumTag;
            private String playTag;
            private int status;
            private String title;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getLiveId() {
                return liveId;
            }

            public void setLiveId(int liveId) {
                this.liveId = liveId;
            }

            public String getPlayNumTag() {
                return playNumTag;
            }

            public void setPlayNumTag(String playNumTag) {
                this.playNumTag = playNumTag;
            }

            public String getPlayTag() {
                return playTag;
            }

            public void setPlayTag(String playTag) {
                this.playTag = playTag;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class RelatedBean {
            /**
             * goodsCount : 76
             * goodsList : [{"background":"#25ACBD","goodsId":106476,"goodsUrl":"https://mall-wv.mtime.cn/#!/commerce/item/106476/","iconText":"新品","image":"http://img5.mtime.cn/mg/2017/11/02/142138.48487027_294X294X4.jpg","longName":"正义联盟 蝙蝠侠战车充电宝 7000mAh ABS+PVC","marketPrice":18800,"marketPriceFormat":"188.00","minSalePrice":18800,"minSalePriceFormat":"188.00","name":"正义联盟蝙蝠侠战车充电宝"},{"background":"#25ACBD","goodsId":106515,"goodsUrl":"https://mall-wv.mtime.cn/#!/commerce/item/106515/","iconText":"新品","image":"http://img5.mtime.cn/mg/2017/10/10/151219.15962309_294X294X4.jpg","longName":"长袖运动休闲帽衫棒球服休闲服卫衣","marketPrice":19900,"marketPriceFormat":"199.00","minSalePrice":19900,"minSalePriceFormat":"199.00","name":"正义联盟超人卫衣"},{"background":"#25ACBD","goodsId":106469,"goodsUrl":"https://mall-wv.mtime.cn/#!/commerce/item/106469/","iconText":"新品","image":"http://img5.mtime.cn/mg/2017/10/09/153449.29807542_294X294X4.jpg","longName":"陶瓷马克杯办公室水杯","marketPrice":7900,"marketPriceFormat":"79.00","minSalePrice":7900,"minSalePriceFormat":"79.00","name":"正义联盟超人马克杯"}]
             * relateId : 0
             * relatedUrl : https://mall-wv.mtime.cn/?mid=70233&relatedNativeType=1&utm_source=app_movie_btn_more#!/commerce/list/
             * type : 0
             */

            private int goodsCount;
            private int relateId;
            private String relatedUrl;
            private int type;
            private List<GoodsListBean> goodsList;

            public int getGoodsCount() {
                return goodsCount;
            }

            public void setGoodsCount(int goodsCount) {
                this.goodsCount = goodsCount;
            }

            public int getRelateId() {
                return relateId;
            }

            public void setRelateId(int relateId) {
                this.relateId = relateId;
            }

            public String getRelatedUrl() {
                return relatedUrl;
            }

            public void setRelatedUrl(String relatedUrl) {
                this.relatedUrl = relatedUrl;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public List<GoodsListBean> getGoodsList() {
                return goodsList;
            }

            public void setGoodsList(List<GoodsListBean> goodsList) {
                this.goodsList = goodsList;
            }

            public static class GoodsListBean {
                /**
                 * background : #25ACBD
                 * goodsId : 106476
                 * goodsUrl : https://mall-wv.mtime.cn/#!/commerce/item/106476/
                 * iconText : 新品
                 * image : http://img5.mtime.cn/mg/2017/11/02/142138.48487027_294X294X4.jpg
                 * longName : 正义联盟 蝙蝠侠战车充电宝 7000mAh ABS+PVC
                 * marketPrice : 18800
                 * marketPriceFormat : 188.00
                 * minSalePrice : 18800
                 * minSalePriceFormat : 188.00
                 * name : 正义联盟蝙蝠侠战车充电宝
                 */

                private String background;
                private int goodsId;
                private String goodsUrl;
                private String iconText;
                private String image;
                private String longName;
                private int marketPrice;
                private String marketPriceFormat;
                private int minSalePrice;
                private String minSalePriceFormat;
                private String name;

                public String getBackground() {
                    return background;
                }

                public void setBackground(String background) {
                    this.background = background;
                }

                public int getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(int goodsId) {
                    this.goodsId = goodsId;
                }

                public String getGoodsUrl() {
                    return goodsUrl;
                }

                public void setGoodsUrl(String goodsUrl) {
                    this.goodsUrl = goodsUrl;
                }

                public String getIconText() {
                    return iconText;
                }

                public void setIconText(String iconText) {
                    this.iconText = iconText;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getLongName() {
                    return longName;
                }

                public void setLongName(String longName) {
                    this.longName = longName;
                }

                public int getMarketPrice() {
                    return marketPrice;
                }

                public void setMarketPrice(int marketPrice) {
                    this.marketPrice = marketPrice;
                }

                public String getMarketPriceFormat() {
                    return marketPriceFormat;
                }

                public void setMarketPriceFormat(String marketPriceFormat) {
                    this.marketPriceFormat = marketPriceFormat;
                }

                public int getMinSalePrice() {
                    return minSalePrice;
                }

                public void setMinSalePrice(int minSalePrice) {
                    this.minSalePrice = minSalePrice;
                }

                public String getMinSalePriceFormat() {
                    return minSalePriceFormat;
                }

                public void setMinSalePriceFormat(String minSalePriceFormat) {
                    this.minSalePriceFormat = minSalePriceFormat;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }
    }
}

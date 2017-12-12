package com.faithyee.androidlearningdemo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 热门电影
 * https://api-m.mtime.cn/PageSubArea/HotPlayMovies.api?locationId=366
 * locationId 请查看app/movieLocJson.txt
 * Author：yewmf on 2017/12/12 14:42
 * E-mail：faith_yee@163.com
 */
public class HotMovies implements Serializable  {


    /**
     * count : 15
     * movies : [{"actorName1":"陈柏霖","actorName2":"林允","btnText":"","commonSpecial":"陈柏霖林允演绎爱情童话","directorName":"王郢","img":"http://img5.mtime.cn/mt/2017/11/30/103502.97070831_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":101,"movieId":246582,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":30,"nearestShowDay":1513065600,"nearestShowtimeCount":42},"preferentialFlag":false,"rDay":8,"rMonth":12,"rYear":2017,"ratingFinal":6.6,"titleCn":"假如王子睡着了","titleEn":"The Dreaming Man","type":"爱情 / 喜剧","wantedCount":552},{"actorName1":"安东尼·冈萨雷兹","actorName2":"盖尔·加西亚·贝纳尔","btnText":"","commonSpecial":"墨西哥男孩亡灵世界寻父记","directorName":"李·昂克里奇","img":"http://img5.mtime.cn/mt/2017/12/02/172158.15874011_1280X720X2.jpg","is3D":true,"isDMAX":true,"isFilter":false,"isHot":true,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":109,"movieId":227434,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":142,"nearestShowDay":1513065600,"nearestShowtimeCount":1865},"preferentialFlag":false,"rDay":24,"rMonth":11,"rYear":2017,"ratingFinal":9,"titleCn":"寻梦环游记","titleEn":"Coco","type":"动画 / 冒险 / 喜剧","wantedCount":2682},{"actorName1":"本·威士肖","actorName2":"休·格兰特","btnText":"","commonSpecial":"呆萌小熊回归开启英式冒险喜剧","directorName":"保罗·金","img":"http://img5.mtime.cn/mt/2017/11/14/102432.20209601_1280X720X2.jpg","is3D":false,"isDMAX":true,"isFilter":false,"isHot":true,"isIMAX":true,"isIMAX3D":false,"isNew":false,"length":103,"movieId":229372,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":144,"nearestShowDay":1513065600,"nearestShowtimeCount":1179},"preferentialFlag":false,"rDay":8,"rMonth":12,"rYear":2017,"ratingFinal":8.1,"titleCn":"帕丁顿熊2","titleEn":"Paddington 2","type":"动画 / 冒险 / 喜剧","wantedCount":1588},{"actorName1":"道格拉斯·布斯","actorName2":"罗伯特·古拉奇克","btnText":"","commonSpecial":"一场流动的梵高作品盛宴","directorName":"多洛塔·科别拉","img":"http://img5.mtime.cn/mt/2017/11/23/100131.42638489_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":95,"movieId":221423,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":140,"nearestShowDay":1513065600,"nearestShowtimeCount":812},"preferentialFlag":false,"rDay":8,"rMonth":12,"rYear":2017,"ratingFinal":8.4,"titleCn":"至爱梵高·星空之谜","titleEn":"Loving Vincent","type":"动画 / 传记 / 犯罪","wantedCount":1325},{"actorName1":"黄轩","actorName2":"苗苗","btnText":"","commonSpecial":"青春少男少女的文工团芳华岁月","directorName":"冯小刚","img":"http://img5.mtime.cn/mt/2017/12/09/120449.13626053_1280X720X2.jpg","is3D":false,"isDMAX":true,"isFilter":false,"isHot":false,"isIMAX":true,"isIMAX3D":false,"isNew":false,"length":136,"movieId":236404,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":39,"nearestShowDay":1513238400,"nearestShowtimeCount":41},"preferentialFlag":false,"rDay":15,"rMonth":12,"rYear":2017,"ratingFinal":7.9,"titleCn":"芳华","titleEn":"Youth","type":"爱情 / 剧情 / 战争","wantedCount":2617},{"actorName1":"大鹏","actorName2":"倪妮","btnText":"","commonSpecial":"","directorName":"袁和平","img":"http://img5.mtime.cn/mt/2017/11/15/094642.97308757_1280X720X2.jpg","is3D":true,"isDMAX":true,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":true,"isNew":false,"length":113,"movieId":229668,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":33,"nearestShowDay":1513238400,"nearestShowtimeCount":36},"preferentialFlag":false,"rDay":15,"rMonth":12,"rYear":2017,"ratingFinal":-1,"titleCn":"奇门遁甲","titleEn":"The Thousand Faces of Dunjia","type":"奇幻 / 动作","wantedCount":1924},{"actorName1":"陈学冬","actorName2":"张孝全","btnText":"","commonSpecial":"揭秘一分钟三百万暴利骗局","directorName":"彭顺","img":"http://img5.mtime.cn/mt/2017/11/20/171508.38236220_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":123,"movieId":242132,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":119,"nearestShowDay":1513065600,"nearestShowtimeCount":349},"preferentialFlag":false,"rDay":8,"rMonth":12,"rYear":2017,"ratingFinal":6,"titleCn":"巨额来电","titleEn":"The Big Call","type":"剧情 / 犯罪","wantedCount":629},{"actorName1":"曼迪·摩尔","actorName2":"克莱尔·霍尔特","btnText":"","commonSpecial":"两姐妹被困深海遭大白鲨疯狂围攻","directorName":"约翰内斯·罗伯茨","img":"http://img5.mtime.cn/mt/2017/11/30/081658.18048935_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":true,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":89,"movieId":235355,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":116,"nearestShowDay":1513065600,"nearestShowtimeCount":342},"preferentialFlag":false,"rDay":8,"rMonth":12,"rYear":2017,"ratingFinal":6.7,"titleCn":"鲨海","titleEn":"47 Meters Down","type":"冒险 / 剧情 / 恐怖","wantedCount":426},{"actorName1":"加里·奥德曼","actorName2":"莉莉·詹姆斯","btnText":"","commonSpecial":"加里·奥德曼\"神还原\"丘吉尔","directorName":"乔·赖特","img":"http://img5.mtime.cn/mt/2017/11/07/094706.43314693_1280X720X2.jpg","is3D":false,"isDMAX":true,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":114,"movieId":232987,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":80,"nearestShowDay":1513065600,"nearestShowtimeCount":259},"preferentialFlag":false,"rDay":1,"rMonth":12,"rYear":2017,"ratingFinal":8.6,"titleCn":"至暗时刻","titleEn":"Darkest Hour","type":"传记 / 剧情 / 历史","wantedCount":1038},{"actorName1":"多布杰","actorName2":"王紫逸","btnText":"","commonSpecial":"","directorName":"杨蕊","img":"http://img5.mtime.cn/mt/2017/11/24/140212.72646910_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":true,"length":97,"movieId":250817,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":104,"nearestShowDay":1513065600,"nearestShowtimeCount":312},"preferentialFlag":false,"rDay":12,"rMonth":12,"rYear":2017,"ratingFinal":-1,"titleCn":"金珠玛米","titleEn":"The Chainbreakers","type":"剧情 / 西部 / 历史","wantedCount":55},{"actorName1":"邓超","actorName2":"阮经天","btnText":"","commonSpecial":"","directorName":"徐纪周","img":"http://img5.mtime.cn/mt/2017/11/28/221957.66137860_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":124,"movieId":235736,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":13,"nearestShowDay":1513411200,"nearestShowtimeCount":13},"preferentialFlag":false,"rDay":22,"rMonth":12,"rYear":2017,"ratingFinal":-1,"titleCn":"心理罪之城市之光","titleEn":"The Liquidator","type":"剧情 / 犯罪 / 动作","wantedCount":2310},{"actorName1":"乔什·布洛林","actorName2":"迈尔斯·特勒","btnText":"","commonSpecial":"20位\u201c大地守卫者\u201d迎战烈焰","directorName":"约瑟夫·科辛斯基","img":"http://img5.mtime.cn/mt/2017/11/29/094840.70667602_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":127,"movieId":241002,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":86,"nearestShowDay":1513065600,"nearestShowtimeCount":163},"preferentialFlag":false,"rDay":8,"rMonth":12,"rYear":2017,"ratingFinal":8.4,"titleCn":"勇往直前","titleEn":"Only the Brave","type":"传记 / 剧情","wantedCount":443},{"actorName1":"涂们","actorName2":"王超北","btnText":"","commonSpecial":"游荡在过去与现实中的\u201c老混蛋\u201d","directorName":"周子阳","img":"http://img5.mtime.cn/mt/2017/12/11/105709.93309546_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":110,"movieId":235158,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":73,"nearestShowDay":1513065600,"nearestShowtimeCount":141},"preferentialFlag":false,"rDay":11,"rMonth":12,"rYear":2017,"ratingFinal":7.6,"titleCn":"老兽","titleEn":"Old Beast","type":"剧情","wantedCount":121},{"actorName1":"本·阿弗莱克","actorName2":"盖尔·加朵","btnText":"","commonSpecial":"神奇女侠完美海王闪电侠抢戏","directorName":"扎克·施奈德","img":"http://img5.mtime.cn/mt/2017/11/22/115051.54720032_1280X720X2.jpg","is3D":true,"isDMAX":true,"isFilter":false,"isHot":true,"isIMAX":false,"isIMAX3D":true,"isNew":false,"length":120,"movieId":70233,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":51,"nearestShowDay":1513065600,"nearestShowtimeCount":135},"preferentialFlag":false,"rDay":17,"rMonth":11,"rYear":2017,"ratingFinal":7.4,"titleCn":"正义联盟","titleEn":"Justice League","type":"动作 / 冒险 / 奇幻","wantedCount":12154},{"actorName1":"成龙","actorName2":"罗志祥","btnText":"","commonSpecial":"","directorName":"张立嘉","img":"http://img5.mtime.cn/mt/2017/11/29/100944.10586049_1280X720X2.jpg","is3D":true,"isDMAX":true,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":true,"isNew":false,"length":110,"movieId":235012,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":8,"nearestShowDay":1513843200,"nearestShowtimeCount":8},"preferentialFlag":false,"rDay":22,"rMonth":12,"rYear":2017,"ratingFinal":-1,"titleCn":"机器之血","titleEn":"Bleeding Steel","type":"科幻 / 动作 / 悬疑","wantedCount":1082}]
     * totalCinemaCount : 203
     * totalComingMovie : 49
     * totalHotMovie : 57
     */

    private int count;
    private int totalCinemaCount;
    private int totalComingMovie;
    private int totalHotMovie;
    private List<MoviesBean> movies;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalCinemaCount() {
        return totalCinemaCount;
    }

    public void setTotalCinemaCount(int totalCinemaCount) {
        this.totalCinemaCount = totalCinemaCount;
    }

    public int getTotalComingMovie() {
        return totalComingMovie;
    }

    public void setTotalComingMovie(int totalComingMovie) {
        this.totalComingMovie = totalComingMovie;
    }

    public int getTotalHotMovie() {
        return totalHotMovie;
    }

    public void setTotalHotMovie(int totalHotMovie) {
        this.totalHotMovie = totalHotMovie;
    }

    public List<MoviesBean> getMovies() {
        return movies;
    }

    public void setMovies(List<MoviesBean> movies) {
        this.movies = movies;
    }

    public static class MoviesBean {
        /**
         * actorName1 : 陈柏霖
         * actorName2 : 林允
         * btnText :
         * commonSpecial : 陈柏霖林允演绎爱情童话
         * directorName : 王郢
         * img : http://img5.mtime.cn/mt/2017/11/30/103502.97070831_1280X720X2.jpg
         * is3D : false
         * isDMAX : false
         * isFilter : false
         * isHot : false
         * isIMAX : false
         * isIMAX3D : false
         * isNew : false
         * length : 101
         * movieId : 246582
         * nearestShowtime : {"isTicket":true,"nearestCinemaCount":30,"nearestShowDay":1513065600,"nearestShowtimeCount":42}
         * preferentialFlag : false
         * rDay : 8
         * rMonth : 12
         * rYear : 2017
         * ratingFinal : 6.6
         * titleCn : 假如王子睡着了
         * titleEn : The Dreaming Man
         * type : 爱情 / 喜剧
         * wantedCount : 552
         */

        private String actorName1;
        private String actorName2;
        private String btnText;
        private String commonSpecial;
        private String directorName;
        private String img;
        private boolean is3D;
        private boolean isDMAX;
        private boolean isFilter;
        private boolean isHot;
        private boolean isIMAX;
        private boolean isIMAX3D;
        private boolean isNew;
        private int length;
        private int movieId;
        private NearestShowtimeBean nearestShowtime;
        private boolean preferentialFlag;
        private int rDay;
        private int rMonth;
        private int rYear;
        private double ratingFinal;
        private String titleCn;
        private String titleEn;
        private String type;
        private int wantedCount;

        public String getActorName1() {
            return actorName1;
        }

        public void setActorName1(String actorName1) {
            this.actorName1 = actorName1;
        }

        public String getActorName2() {
            return actorName2;
        }

        public void setActorName2(String actorName2) {
            this.actorName2 = actorName2;
        }

        public String getBtnText() {
            return btnText;
        }

        public void setBtnText(String btnText) {
            this.btnText = btnText;
        }

        public String getCommonSpecial() {
            return commonSpecial;
        }

        public void setCommonSpecial(String commonSpecial) {
            this.commonSpecial = commonSpecial;
        }

        public String getDirectorName() {
            return directorName;
        }

        public void setDirectorName(String directorName) {
            this.directorName = directorName;
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

        public boolean isIsFilter() {
            return isFilter;
        }

        public void setIsFilter(boolean isFilter) {
            this.isFilter = isFilter;
        }

        public boolean isIsHot() {
            return isHot;
        }

        public void setIsHot(boolean isHot) {
            this.isHot = isHot;
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

        public boolean isIsNew() {
            return isNew;
        }

        public void setIsNew(boolean isNew) {
            this.isNew = isNew;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public NearestShowtimeBean getNearestShowtime() {
            return nearestShowtime;
        }

        public void setNearestShowtime(NearestShowtimeBean nearestShowtime) {
            this.nearestShowtime = nearestShowtime;
        }

        public boolean isPreferentialFlag() {
            return preferentialFlag;
        }

        public void setPreferentialFlag(boolean preferentialFlag) {
            this.preferentialFlag = preferentialFlag;
        }

        public int getRDay() {
            return rDay;
        }

        public void setRDay(int rDay) {
            this.rDay = rDay;
        }

        public int getRMonth() {
            return rMonth;
        }

        public void setRMonth(int rMonth) {
            this.rMonth = rMonth;
        }

        public int getRYear() {
            return rYear;
        }

        public void setRYear(int rYear) {
            this.rYear = rYear;
        }

        public double getRatingFinal() {
            return ratingFinal;
        }

        public void setRatingFinal(double ratingFinal) {
            this.ratingFinal = ratingFinal;
        }

        public String getTitleCn() {
            return titleCn;
        }

        public void setTitleCn(String titleCn) {
            this.titleCn = titleCn;
        }

        public String getTitleEn() {
            return titleEn;
        }

        public void setTitleEn(String titleEn) {
            this.titleEn = titleEn;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getWantedCount() {
            return wantedCount;
        }

        public void setWantedCount(int wantedCount) {
            this.wantedCount = wantedCount;
        }

        public static class NearestShowtimeBean {
            /**
             * isTicket : true
             * nearestCinemaCount : 30
             * nearestShowDay : 1513065600
             * nearestShowtimeCount : 42
             */

            private boolean isTicket;
            private int nearestCinemaCount;
            private int nearestShowDay;
            private int nearestShowtimeCount;

            public boolean isIsTicket() {
                return isTicket;
            }

            public void setIsTicket(boolean isTicket) {
                this.isTicket = isTicket;
            }

            public int getNearestCinemaCount() {
                return nearestCinemaCount;
            }

            public void setNearestCinemaCount(int nearestCinemaCount) {
                this.nearestCinemaCount = nearestCinemaCount;
            }

            public int getNearestShowDay() {
                return nearestShowDay;
            }

            public void setNearestShowDay(int nearestShowDay) {
                this.nearestShowDay = nearestShowDay;
            }

            public int getNearestShowtimeCount() {
                return nearestShowtimeCount;
            }

            public void setNearestShowtimeCount(int nearestShowtimeCount) {
                this.nearestShowtimeCount = nearestShowtimeCount;
            }
        }
    }

    @Override
    public String toString() {
        return "HotMovies{" +
                "count=" + count +
                ", totalCinemaCount=" + totalCinemaCount +
                ", totalComingMovie=" + totalComingMovie +
                ", totalHotMovie=" + totalHotMovie +
                ", movies=" + movies +
                '}';
    }
}

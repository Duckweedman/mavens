package com.test.netdemo.network;

/**
 * Created by meijunqiang on 2017/9/7 0007.
 * 描述：获取版本信息
 */

public class VersionBean {
        /**
         * oid : 51
         * version : 2.2.1
         * content : 本轮更新亮点：
         修复【部分用户不能确认收货】bug
         优化【专享抢购】活动页面
         丰富【开发票】字段
         去除【邮政编码】必填项
         易通 · 每天都不一样！
         * type : 1
         * createTime : 2017-06-30 17:03:33
         * updatelevel : 1
         * url : http://imtt.dd.qq.com/16891/FE5F0C89F0FC409657CD3D20D93E6E46.apk?fsname=com.san.san.etong_2.2.1_19.apk&csr=1bbd
         */

        private int oid;
        private String version;
        private String content;
        private int type;
        private String createTime;
        private String updatelevel;
        private String url;

        public int getOid() {
            return oid;
        }

        public void setOid(int oid) {
            this.oid = oid;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdatelevel() {
            return updatelevel;
        }

        public void setUpdatelevel(String updatelevel) {
            this.updatelevel = updatelevel;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
}

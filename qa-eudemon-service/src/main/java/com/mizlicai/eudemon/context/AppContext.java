package com.mizlicai.eudemon.context;

/**
 * Created by huangyt on 2017/6/6.
 */
public interface AppContext{

    public enum STATUS{
        S("成功"),
        F("失败");


        private STATUS(String label){
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        private String label;
    }

    public enum YES_OR_NO{
        YES("YES"),
        NO("NO");


        private YES_OR_NO(String label){
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public static boolean contains(String name){
            boolean b = false;
            YES_OR_NO[] vals = YES_OR_NO.values();
            for(YES_OR_NO o : vals){
                if(o.name().equals(name)){
                    b =true;

                    break;
                }
            }
            return b;
        }

        private String label;
    }

    public enum ERROR_CODE{
        SYSTEM_ERROR("系统未知错误"),
        DATA_ERROR("数据异常"),
        STATUS_ERROR("状态异常"),
        CODE_ERROR("状态码错误");


        private ERROR_CODE(String label){
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public static boolean contains(String name){
            boolean b = false;
            YES_OR_NO[] vals = YES_OR_NO.values();
            for(YES_OR_NO o : vals){
                if(o.name().equals(name)){
                    b =true;

                    break;
                }
            }
            return b;
        }

        private String label;
    }


}

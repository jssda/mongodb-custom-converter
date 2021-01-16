package pers.jssd.mongodbcostomconverter.entity.constant;

/**
 * 性别枚举
 *
 * @author wangjingjing@bonc.com.cn
 * @date 2021/1/16 14:27
 */
public enum SexEnum {

    /**
     * 男性
     */
    MALE,


    /**
     * 女性
     */
    FEMALE;


    @Override
    public String toString() {
        return this.ordinal() + "";
    }
}

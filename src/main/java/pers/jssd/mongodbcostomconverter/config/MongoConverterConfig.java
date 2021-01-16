package pers.jssd.mongodbcostomconverter.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import pers.jssd.mongodbcostomconverter.entity.constant.SexEnum;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * MongoDB 自定义转换器
 *
 * @author wangjingjing@bonc.com.cn
 * @date 2021/1/16 16:02
 */
@SpringBootConfiguration
public class MongoConverterConfig {

    /**
     * 注册 自定义的mongo转换器
     *
     * @return 返回注册成功的自定义转换器
     */
    @Bean
    public MongoCustomConversions customConversions() {
        return MongoCustomConversions.create(mongoConverterConfigurationAdapter -> {
            mongoConverterConfigurationAdapter.registerConverter(new CustomLocalDateTimeToStringConverter());
            mongoConverterConfigurationAdapter.registerConverter(new CustomStringToLocalDateTimeConverter());
            mongoConverterConfigurationAdapter.registerConverter(new CustomEnumToIntegerConverter());
            mongoConverterConfigurationAdapter.registerConverter(new CustomIntegerToEnumConverter());

        });
    }

    @WritingConverter
    private static class CustomLocalDateTimeToStringConverter implements Converter<LocalDateTime, String> {

        @Override
        public String convert(LocalDateTime source) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return df.format(source);
        }
    }

    @ReadingConverter
    private static class CustomStringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {

        @Override
        public LocalDateTime convert(String source) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            try {
                return LocalDateTime.parse(source, df);
            } catch (Exception e) {
                return null;
            }
        }
    }

    @WritingConverter
    private static class CustomEnumToIntegerConverter implements Converter<SexEnum, Integer> {
        @Override
        public Integer convert(SexEnum source) {
            return source.ordinal();
        }
    }

    @ReadingConverter
    private static class CustomIntegerToEnumConverter implements Converter<Integer, SexEnum> {
        @Override
        public SexEnum convert(Integer source) {
            if (source < 0 || source >= SexEnum.values().length) {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }
            return SexEnum.values()[source];
        }
    }

}

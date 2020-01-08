package com.macro.mall.portal.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;


/**
 * Jackson configuration class
 * Json does not return Null fields
 * Created by macro on 2018/8/2.
 */
@Configuration
public class JacksonConfig {
    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();

        // Set the mapper object by this method, all serialized objects will be serialized according to the rules
        // Include.Include.ALWAYS default
        // Include.NON_DEFAULT Attributes are not serialized by default
        // Include.NON_EMPTY Attributes is not serialized ("") or NULL is not serialized, the returned jsonYes does not have this field. This will give more traffic to the mobile
        // Include.NON_NULL Attributes is NULL and is not serialized, so the field whose Yes is null does not participate in serialization
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // Fields are retained, null values ​​are converted to""
//        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>()
//        {
//            @Override
//            public void serialize(Object o, JsonGenerator jsonGenerator,
//                                  SerializerProvider serializerProvider)
//                    throws IOException, JsonProcessingException
//            {
//                jsonGenerator.writeString("");
//            }
//        });
        return objectMapper;
    }
}

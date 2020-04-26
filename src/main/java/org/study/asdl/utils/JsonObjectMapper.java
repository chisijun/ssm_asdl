package org.study.asdl.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author puyijun
 * @ClassName JsonObjectMapper
 * @date 2017-12-18
 * @time 14:51
 * @Description
 **/

public class JsonObjectMapper extends ObjectMapper {
    private static final long serialVersionUID = 1L;

    public JsonObjectMapper() {
        super();
        // 空值处理为空串
        this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object value, JsonGenerator jg, SerializerProvider sp)
                    throws IOException, JsonProcessingException {
                jg.writeString("");
            }
        });
    }
}

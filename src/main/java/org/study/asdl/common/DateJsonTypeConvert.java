package org.study.asdl.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author puyijun
 * @ClassName DateJsonTypeConvert
 * @date 2017-12-18
 * @time 16:39
 * @Description
 * springmvc返回的json串中，
 * 将Date类型转为long类型，
 * 通过此类继承JsonSerializer来自定义格式，
 * 之后在实体类对应的date类型的字段的
 **/

public class DateJsonTypeConvert extends JsonSerializer<Date> {
    @Override
    public void serialize(Date arg0,
                          JsonGenerator arg1,
                          SerializerProvider arg2)
            throws IOException,
            JsonProcessingException {
        //自己定义日期格式
        SimpleDateFormat sdf=
                new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //将数据以json格式输出
        arg1.writeString(sdf.format(arg0));
    }
}

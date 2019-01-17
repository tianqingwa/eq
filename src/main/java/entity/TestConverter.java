package entity;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianqinghua
 * @date 2018/11/30 11:18
 */
public class TestConverter extends MappingJackson2HttpMessageConverter {
    public TestConverter() {
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.TEXT_PLAIN);
        //加入text/html类型的支持
        mediaTypes.add(MediaType.TEXT_HTML);
        mediaTypes.add(MediaType.APPLICATION_JSON);
        setSupportedMediaTypes(mediaTypes);
    }
}

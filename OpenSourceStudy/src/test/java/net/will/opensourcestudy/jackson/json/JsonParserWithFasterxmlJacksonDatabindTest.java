package net.will.opensourcestudy.jackson.json;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParserWithFasterxmlJacksonDatabindTest {

    @Test
    public void testJsonToMap_Simple() throws Exception {
        String json = "{\"EmailNotificationLevel\":\"yes\"}";
        
        ObjectMapper mapper = new ObjectMapper();
        JavaType expectType = mapper.getTypeFactory().constructParametricType(Map.class, String.class, Object.class);
        Map<String, Object> resultMap = mapper.readValue(json, expectType);
        
        assertEquals(resultMap.get("EmailNotificationLevel"), "yes");
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testJsonToMap_WithArray() throws Exception {
        String json = "{\"EmailNotificationLevel\":[\"ERROR\",\"WARNING\"]}";
        
        ObjectMapper mapper = new ObjectMapper();
        JavaType expectType = mapper.getTypeFactory().constructParametricType(Map.class, String.class, Object.class);
        Map<String, Object> resultMap = mapper.readValue(json, expectType);
        
        assertTrue(resultMap.get("EmailNotificationLevel") instanceof List);
        List<String> levels = (List<String>) resultMap.get("EmailNotificationLevel");
        assertTrue(levels.contains("ERROR"));
        assertTrue(levels.contains("WARNING"));
    }

}

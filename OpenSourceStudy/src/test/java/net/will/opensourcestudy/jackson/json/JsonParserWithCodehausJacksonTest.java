package net.will.opensourcestudy.jackson.json;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;
import org.codehaus.jackson.type.JavaType;
import org.junit.Test;

public class JsonParserWithCodehausJacksonTest {

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
    
    @Test
    public void testJsonToObject_Simple() throws Exception {
        String json = "{\"id\":\"100\",\"name\":\"Will\",\"age\":\"30\"}";
        ObjectMapper mapper = new ObjectMapper();
        Staff obj = mapper.readValue(json, Staff.class);
        
        assertEquals(obj.getName(), "Will");
        assertEquals(obj.getAge(), "30");
        assertNotEquals(obj.getAge(), 30);
        assertEquals(obj.getId(), 100);
    }
    
    @Test(expected = UnrecognizedPropertyException.class)
    public void testJsonToObject_CapitalCaseProperties() throws Exception {
        String json = "{\"Id\":\"100\",\"Name\":\"Will\",\"Age\":\"30\"}";
        ObjectMapper mapper = new ObjectMapper();
        mapper.readValue(json, Staff.class);
    }
    
    @Test
    public void testJsonToObject_WithIgnoredExtraProperties() throws Exception {
        String json = "{\"id\":\"100\",\"name\":\"Will\",\"extra\":\"Some Street\"}";
        ObjectMapper mapper = new ObjectMapper();
        Staff obj = mapper.readValue(json, Staff.class);

        assertEquals(obj.getName(), "Will");
        assertEquals(obj.getId(), 100);
    }

}

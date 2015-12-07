package net.will.javatest.utilstest.beanutils;

import static org.junit.Assert.*;

import org.junit.Test;

public class BeanUtilsTest {
    @Test
    public void testToString_ApacheBeanUtils() throws Exception {
        Product src = createProduct("01", 50d);
//        System.out.println("apache test: " + src.toString());
        
        Product dest = new Product();
        org.apache.commons.beanutils.BeanUtils.copyProperties(dest, src);
//        System.out.println("apache test: " + dest.toString());
        
        assertTrue(src.getProvider() == dest.getProvider());
    }
    
    @Test
    public void testToString_SpringBeanUtils() throws Exception {
        Product src = createProduct("01", 50d);
//        System.out.println("spring test: " + src.toString());
        
        Product dest = new Product();
        org.springframework.beans.BeanUtils.copyProperties(src, dest);
//        System.out.println("spring test: " + dest.toString());

        assertTrue(src.getProvider() == dest.getProvider());
    }
    
    @Test
    public void testToString_Clone() throws Exception {
        Product src = createProduct("01", 50d);
//        System.out.println("clone test: " + src.toString());
        
        Product dest = (Product) src.clone();
//        System.out.println("clone test: " + dest.toString());
        
        assertTrue(src.getProvider() == dest.getProvider());
    }
    
    private Product createProduct(String id, Double price) {
        Product obj = new Product();
        obj.setName("Product" + id);
        obj.setPrice(price);
        obj.setProvider(createProvider(id));
        return obj;
    }
    
    private Provider createProvider(String id) {
        Provider obj = new Provider();
        obj.setName("Provider" + id);
        obj.setAddress("Address" + id);
        return obj;
    }
    
}

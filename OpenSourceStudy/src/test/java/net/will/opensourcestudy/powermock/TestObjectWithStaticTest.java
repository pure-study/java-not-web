package net.will.opensourcestudy.powermock;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TestObjectWithStatic.class)
public class TestObjectWithStaticTest {

    @Test
    public void test() {
        StaticMethodCaller obj = new StaticMethodCaller();
        
        // mock all the static methods
        PowerMockito.mockStatic(TestObjectWithStatic.class);
        // use Mockito to set up your expectation
        Mockito.when(TestObjectWithStatic.firstStaticMethod(anyString())).thenReturn("abc");
        Mockito.when(TestObjectWithStatic.secondStaticMethod()).thenReturn(123);
        
        // execute your test
        obj.execute();
        
        // use PowerMockito.verifyStatic() first to start verifying behavior
        PowerMockito.verifyStatic(times(2));
        // IMPORTANT:  Call the static method you want to verify
        TestObjectWithStatic.firstStaticMethod(anyString());
        
        // IMPORTANT: You need to call verifyStatic() per method verification, so call verifyStatic() again
        PowerMockito.verifyStatic(); // default times is once
        // Again call the static method which is being verified
        TestObjectWithStatic.secondStaticMethod();
        
        // Again, remember to call verifyStatic()
        PowerMockito.verifyStatic(never());
        // And again call the static method.
        TestObjectWithStatic.thirdStaticMethod();
    }

}

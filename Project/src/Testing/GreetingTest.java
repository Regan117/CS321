package src.Testing;
import static org.junit.Assert.*;
import org.junit.Test;
import org.hamcrest.CoreMatchers.*;

public class GreetingTest{
    @Test
    public void test(){
        Greeting greeting = new Greeting("Hello world!");
        assertEquals(greeting.getMessage(), ("Hello world!"));
    }
}
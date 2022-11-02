import org.junit.Test;

import java.lang.reflect.Method;
import java.util.*;

public class Practice {

    @Test
    public void testHashmap(){
        Map map = new HashMap();
        map.put("1","张三");
        map.put("2","李四");
        Iterator entries = map.entrySet().iterator() ;
        while (entries.hasNext()){
            Map.Entry entry = (Map.Entry)entries.next();
            String key = (String) entry.getKey();
            String value = (String)entry.getValue();
            System.out.println(key+"\n"+value);
        }
    }

    @Test
    public void testHashmap2(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"张三");
        map.put(2,"李四");
        Iterator<Map.Entry<Integer,String>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()){
            Map.Entry<Integer,String> entry = entryIterator.next();
            System.out.println(entry.getKey()+"\n"+entry.getValue());
        }
    }

    @Test
    public void testHashCode() throws NoSuchMethodException {
        String a = "m";
        String b = new String("m");
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a.equals(b));
        System.out.println(a==b);
//        System.out.println(Practice.class.getDeclaredMethod(toString()));
        System.out.println(getClass());
        Method[] methods = this.getClass().getDeclaredMethods();

        for (Method m : methods) {
            m.getName();
            System.out.println(m.getName());
        }
//        System.out.println(getClass().getDeclaredMethod(toString()));

    }
    @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
 /*   @Override
    public int hashCode(){
        return super.hashCode()*new Random(100).nextInt();
    }
    @Override
    public boolean equals(Object obj){
        Practice practice = (Practice) obj;
        return (this.a==practice.a);
    }*/
 /*   String a;
    public Practice(String a){
        this.a = a;
    }
    public static void main(String[] args) {
        Practice practice = new Practice("1");
        Practice practice2 = new Practice("1");
        System.out.println(practice.equals(practice2));
        System.out.println(practice.hashCode());
        System.out.println(practice2.hashCode());
    }*/
}

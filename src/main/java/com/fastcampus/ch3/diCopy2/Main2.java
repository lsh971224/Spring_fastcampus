package com.fastcampus.ch3.diCopy2;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class Car{}
class SportsCar extends Car{}
class Engine{}
class AppContext{
    Map map; //객체 저장소
    AppContext() {
        try {
            
            Properties p = new Properties();
            p.load(new FileReader("config.txt"));
            //properties에 있는 저장된 내용을 Map에 저장
            map = new HashMap(p);
            for(Object key : map.keySet()) {
                Class clazz = Class.forName((String)map.get(key));
                map.put(key,clazz.newInstance());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    Object getBean(String key){
        return map.get(key);
    }
}
class Truck extends Car{}
public class Main2 {
    public static void main(String[] args) throws Exception{
        AppContext ac = new AppContext();
        Car car = (Car)ac.getBean("car");
        Engine engine = (Engine)ac.getBean("engine") ;
        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
    }
    static Object getBean(String key) throws Exception{
        Properties p = new Properties();
        p.load(new FileReader("config.txt"));

        Class clazz = Class.forName(p.getProperty(key));

        return clazz.newInstance();
    }
    static Car getCar() throws Exception{
        Properties p = new Properties();
        p.load(new FileReader("config.txt"));

        Class clazz = Class.forName(p.getProperty("car"));

        return (Car)clazz.newInstance();
    }
}

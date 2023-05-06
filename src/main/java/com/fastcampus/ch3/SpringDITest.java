package com.fastcampus.ch3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component("engine") 
class Engine{}
@Component
class SuperEngine extends Engine{}
@Component
class TurboEngine extends Engine{}
@Component
class Door{}
@Component
class Car{
    @Value("blue")
    String color;
    @Value("100")
    int oil;
    @Autowired Engine engine;   //Autowired 도 byType임  하지만 타입으로 먼저 검색, 여러개면 이름으로 검색. ->engine, superEngine, turboEngine
    @Autowired Door[] doors;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOil() {
        return oil;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Door[] getDoors() {
        return doors;
    }

    public void setDoors(Door[] doors) {
        this.doors = doors;
    }
    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", oil=" + oil +
                ", engine=" + engine +
                ", doors=" + Arrays.toString(doors) +
                '}';
    }
}
public class SpringDITest {
    public static void main(String[] args) {
        ApplicationContext ac = new GenericXmlApplicationContext("config1.xml");
        Car car = (Car)ac.getBean("car"); //byName
        Car car2 = ac.getBean("car",Car.class); //byName
        Car car3 = (Car)ac.getBean(Car.class);

//        Engine engine = (Engine)ac.getBean("engine");
//        Engine engine = (Engine)ac.getBean("superEngine");
//
//        Door door = (Door)ac.getBean("door");
//        car.setColor("red");
//        car.setOil(100);
//        car.setEngine(engine);
//        car.setDoors(new Door[]{ac.getBean("door", Door.class),ac.getBean("door",Door.class)});
        System.out.println("car = " + car);
    }
}

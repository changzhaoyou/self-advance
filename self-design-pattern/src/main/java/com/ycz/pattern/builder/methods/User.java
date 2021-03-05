package com.ycz.pattern.builder.methods;

import com.ycz.pattern.builder.Builder;

/**
 * Builder模式创建对象
 */
public class User {
    private String name;
    private Integer age;
    private String address;
    private String city;

    public User(Builder builder) {
        this.name=builder.name;
        this.age=builder.age;
        this.address=builder.address;
        this.city=builder.city;
    }

    public static final class Builder{
        private String name;
        private Integer age;
        private String address;
        private String city;
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

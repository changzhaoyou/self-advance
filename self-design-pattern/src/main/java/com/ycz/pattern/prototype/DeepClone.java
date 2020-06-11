package com.ycz.pattern.prototype;

import java.io.*;

/**
 * 采用序列化方式进行深拷贝
 */
public class DeepClone implements Serializable {
    private String name;
    private int age;
    private DeepCloneDetail deepCloneDetail;

    public DeepClone(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public DeepCloneDetail getDeepCloneDetail() {
        return deepCloneDetail;
    }

    public void setDeepCloneDetail(DeepCloneDetail deepCloneDetail) {
        this.deepCloneDetail = deepCloneDetail;
    }

    /**
     * 序列化方式，进行深拷贝
     *
     * @return
     */
    protected DeepClone deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
        outputStream.writeObject(this);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream);
        return (DeepClone) inputStream.readObject();
    }

    @Override
    public String toString() {
        return "DeepClone{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", deepCloneDetail=" + deepCloneDetail +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DeepClone deepClone = new DeepClone("张三", 10);
        deepClone.setDeepCloneDetail(new DeepCloneDetail("ABC"));
        System.out.println("原类型对象：" + deepClone);
        DeepClone deepClone1 = deepClone.deepClone();
        DeepCloneDetail deepCloneDetail = deepClone1.getDeepCloneDetail();
        deepCloneDetail.setDesc("DEF");
        System.out.println("克隆后对象：" + deepClone1);
        deepClone1.setDeepCloneDetail(deepCloneDetail);
        System.out.println("克隆后修改引用对象后，原类型对象：" + deepClone);
    }
}
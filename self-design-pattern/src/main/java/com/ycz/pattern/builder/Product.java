package com.ycz.pattern.builder;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/5/8 11:02
 * @desc 产品（具体产品或者抽象产品）
 */
public class Product {
    /**
     * 肤色
     */
    private String colour;
    /**
     * 头发
     */
    private String hair;

    public Product() {
    }

    public Product(String colour, String hair) {
        this.colour = colour;
        this.hair = hair;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    @Override
    public String toString() {
        return "Product{" +
                "colour='" + colour + '\'' +
                ", hair='" + hair + '\'' +
                '}';
    }
}

package com.sample.processor;

public enum Alignment {
    LEFT_ALIGN("left"), RIGHT_ALIGN("right"), CENTER("center"), JUSTIFY("justify"), HARD("hard");

    private final String val;

    Alignment(String val){
        this.val = val;
    }

    public String getVal(){
        return this.val;
    }

}

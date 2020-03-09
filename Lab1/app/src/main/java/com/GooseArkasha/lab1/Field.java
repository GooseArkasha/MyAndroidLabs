package com.GooseArkasha.lab1;

public class Field {

    private String number;  //Строка с числом
    private  int imageResource; //Ресурс изображения


    private final static String[] singleDigit = new String[] {
            "ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять",
    };

    private final static String[] doubleDigits = new String[] {
            "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
            "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать",
    };
    private final static String[] decades = new String[] {
            "ноль", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят",
            "семьдесят", "восемьдесят", "девяносто"
    };

    private final static String[] hundreds = new String[] {
            "ноль", "сто", "двести", "триста", "четыреста", "пятьсяот",
            "шестьсот", "семьсот", "восемьсот", "девятьсот"
    };

    private final static String[] thousands = new String[] {
            "тысяч", "одна тысяча", "две тысячи", "три тысячи", "четыре тысячи", "пять тысяч",
            "шесть тысяч", "семь тысяч", "восемь тысяч", "девять тысяч"
    };

    public Field(int number, int imageResource) {
        setNumber(number);
        this.imageResource = imageResource;
    };

    public void setNumber(int number) {

        if(number >= 1 && number <= 9) {
            this.number = singleDigit[number];
        }

        if(number >= 10 && number <= 19) {
            this.number = doubleDigits[number % 10];
        }

        if(number >= 20 && number <= 99) {
            if(number / 10 == 0) {
                this.number = decades[number / 10];
            } else {
                String temp = new String(singleDigit[number % 10]);
                this.number = decades[number / 10] + temp;
            }
        }

        if(number > 99) {
            this.number = "гусь";
        }
    }

    public String getNumber() {
        return number;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getImageResource() {
        return imageResource;
    }
}

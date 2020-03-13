package com.GooseArkasha.lab1;

public class Field {

    private String number;  //Строка с числом
    private  int imageResource; //Ресурс изображения


    private final static String[] singleDigit = new String[] {
            "", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять",
    };

    private final static String[] doubleDigits = new String[] {
            "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
            "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать",
    };
    private final static String[] decades = new String[] {
            "", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят",
            "семьдесят", "восемьдесят", "девяносто"
    };

    private final static String[] hundreds = new String[] {
            "", "сто", "двести", "триста", "четыреста", "пятьсяот",
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

        String temp = Integer.toString(number);
        this.number = "";
        int length = temp.length();

        switch (length) {
            case 7:
                this.number = "миллион";
                break;
            case 6:
                this.number = hundreds[temp.charAt(0) - 48];
            case 5:
                if(temp.charAt(length - 5) - 48 != 1) {
                    this.number = this.number + " " + decades[temp.charAt(length - 5) - 48];
                }
            case 4:
                if(temp.length() > 4) {
                    if(temp.charAt(length - 5) - 48 == 1) {
                        this.number = this.number + " " + doubleDigits[temp.charAt(length - 4) - 48]
                                + " " + thousands[0];
                    } else {
                        this.number = this.number + " " + thousands[temp.charAt(length - 4) - 48];
                    }
                } else {
                    this.number = this.number + " " + thousands[temp.charAt(length - 4) - 48];
                }
            case 3:
                this.number = this.number + " " + hundreds[temp.charAt(length - 3) - 48];
            case 2:
                if(temp.charAt(length - 2) - 48 != 1) {
                    this.number = this.number + " " + decades[temp.charAt(length - 2) - 48];
                }
            case 1:
                if(length > 1) {
                    if(temp.charAt(length - 2) - 48 == 1) {
                        this.number = this.number + " " + doubleDigits[temp.charAt(length - 1) - 48];
                    } else {
                        this.number = this.number + " " + singleDigit[temp.charAt(length - 1) - 48];
                    }
                } else {
                    this.number = this.number + " " + singleDigit[temp.charAt(length - 1) - 48];
                }
                break;
            default:
                this.number = "Error";
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

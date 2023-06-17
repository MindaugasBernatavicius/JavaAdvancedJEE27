package cf.mindaugas._08_enums;

enum LenghtUnit {
    METER,
    CENTIMETER,
    MILE
}

enum SocialStatus {
    SENIOR(5),
    MID(3),
    JUNIOR(0);

    private int yearsOfExperience;

    SocialStatus(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int calculateYearLeftUntilUpgrade(SocialStatus socialStatus){
        return this.yearsOfExperience - socialStatus.yearsOfExperience;
    }
}

class Programmer {
    int age;
    String name;
    // String socialStatus;
    SocialStatus socialStatus;

    // public Programmer(int age, String name, String socialStatus) {
    //     this.age = age;
    //     this.name = name;
    //     this.socialStatus = socialStatus;
    // }


    public Programmer(int age, String name, SocialStatus socialStatus) {
        this.age = age;
        this.name = name;
        this.socialStatus = socialStatus;
    }
}

public class App {
    public static void main(String[] args) {
        // 0. Using strings to model/represent
        // // var dev = new Programmer(55, "John", "Senior");
        // var dev = new Programmer(36, "Peter", "Midd");
        // var discountForKeyboards = 0f;
        // if(dev.socialStatus.equals("Junior")){
        //     discountForKeyboards = .10f;
        // } else if (dev.socialStatus.equals("Mid")) {
        //     discountForKeyboards = .05f;
        // } else {
        //     discountForKeyboards = .01f;
        // }
        // System.out.println("We apply " + discountForKeyboards + " for developer " + dev.name);

        // // 1. With enums
        // var dev = new Programmer(36, "Peter", SocialStatus.SENIOR);
        // var discountForKeyboards = 0f;
        // if(dev.socialStatus == SocialStatus.JUNIOR){
        //     discountForKeyboards = .10f;
        // } else if (dev.socialStatus == SocialStatus.MID) {
        //     discountForKeyboards = .05f;
        // } else if (dev.socialStatus == SocialStatus.SENIOR) {
        //     discountForKeyboards = .01f;
        // } else {
        //     discountForKeyboards = -.01f;
        // }
        // System.out.println("We apply " + discountForKeyboards + " for developer " + dev.name);

        // 1. With enums + switch
        var dev = new Programmer(36, "Peter", SocialStatus.JUNIOR);
        var discountForKeyboards = 0f;
        switch (dev.socialStatus){
            case JUNIOR:
                discountForKeyboards = .10f;
                break;
            case MID:
                discountForKeyboards = .05f;
                break;
            case SENIOR:
                discountForKeyboards = .01f;
                break;
            default:
                discountForKeyboards = -.01f;
                break;
        }
        System.out.println("We apply " + discountForKeyboards + " for developer " + dev.name);

        var dev2 = new Programmer(36, "Peter", SocialStatus.JUNIOR);

        System.out.println(SocialStatus.SENIOR.calculateYearLeftUntilUpgrade(dev2.socialStatus));
        System.out.println(SocialStatus.MID.calculateYearLeftUntilUpgrade(dev2.socialStatus));
    }
}

package com.shivam;

class Test {
        int age;
        public Test(int age) {
            this.age = age;
        }
}

   class B extends Test {

       public B(int age) {
           super(age);
       }
        public void display() {
            System.out.println("hii");
            System.out.println(this.age);
        }
    }


public class Main {
    public static void main(String[] args) {
        B obj = new B(17) ;
        obj.display();

    }
}

package com.p5.adoptions.model;

    public class Cat extends Animal
        {
            public Cat(String name, String photoUrl)
            {
                super(name, photoUrl);
            }

            public void iAmACat()
            {
                System.out.println("Cats are special!");
            }
            @Override

            public void speak()
            {
                System.out.println("Cat speaks!");
            }
        }

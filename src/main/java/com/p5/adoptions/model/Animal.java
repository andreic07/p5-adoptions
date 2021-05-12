package com.p5.adoptions.model;

public abstract class Animal

    {

        protected String name;
        protected String photoUrl;


        public Animal(String name, String photoUrl)

        {
            this.name = name;
            this.photoUrl = photoUrl;
        }

        public void speak()
        {
            System.out.println("Animal speaks!");

        }

        protected abstract void walk();


        public String getName()
        {
            return this.name;
        }

        public Animal setName(String newName)
        {
            this.name=newName;
            return this;

        }

        public String getPhotoUrl() {
            return photoUrl;
        }

        public Animal setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
            return this;
        }
    }

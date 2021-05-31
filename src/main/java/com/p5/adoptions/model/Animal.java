package com.p5.adoptions.model;

public abstract class Animal

    {
        protected Integer id;
        protected String name;
        protected String photoUrl;


        public Animal(String name, String photoUrl, Integer id)

        {
            this.name = name;
            this.photoUrl = photoUrl;
            this.id=id;
        }

        public void speak()
        {
            System.out.println("Animal speaks!");

        }

        protected void walk()
        {
            System.out.println("Animal walks !");
        }


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

        public Integer getId() {
            return id;
        }

        public Animal setId(Integer id) {
            this.id = id;
            return this;
        }
    }

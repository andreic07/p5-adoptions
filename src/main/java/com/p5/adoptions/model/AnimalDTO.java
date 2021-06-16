package com.p5.adoptions.model;

public class AnimalDTO

    {
        protected Integer id;
        protected String name;
        protected String photoUrl;


        public AnimalDTO(String name, String photoUrl, Integer id)

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

        public AnimalDTO setName(String newName)
        {
            this.name=newName;
            return this;

        }

        public String getPhotoUrl() {
            return photoUrl;
        }

        public AnimalDTO setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
            return this;
        }

        public Integer getId() {
            return id;
        }

        public AnimalDTO setId(Integer id) {
            this.id = id;
            return this;
        }
    }

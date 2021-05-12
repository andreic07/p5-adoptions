
package com.p5.adoptions.repository;


import com.p5.adoptions.model.Animal;
import com.p5.adoptions.model.Cat;
import com.p5.adoptions.model.Dog;

import java.util.ArrayList;
import java.util.List;

public class AnimalStore

    {
        public static final List<Animal> available = new ArrayList<Animal>()
        {{
            add(new Dog("Alfi","https://www.colecteaza.ro/wp-content/uploads/2018/05/dog.jpg"));
            add(new Dog("Max","https://cdn.mos.cms.futurecdn.net/QjuZKXnkLQgsYsL98uhL9X-1200-80.jpg"));
            add(new Dog("Luchi","https://thegarnetmine.com/wp-content/uploads/2021/04/Dog.jpeg"));
            add(new Cat("Machi","https://i.ytimg.com/vi/1Ne1hqOXKKI/maxresdefault.jpg"));
            add(new Cat("Luna","https://broradio.fm/wp-content/uploads/2020/06/buying-a-kittne-kitty.jpg"));
            add(new Cat("Zoe","https://static.scientificamerican.com/sciam/cache/file/92E141F8-36E4-4331-BB2EE42AC8674DD3_source.jpg"));
        }};


    }

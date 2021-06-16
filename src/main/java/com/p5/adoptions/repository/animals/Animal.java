package com.p5.adoptions.repository.animals;


import javax.persistence.*;


//Optiunea 1
    //@MappedSuperclass
//Optiunea 2
/*@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//"If not specified, DEFAULT: name of the class (Cat or Dog)"
@DiscriminatorColumn(name = "name", discriminatorType = DiscriminatorType.STRING)
*/
//Optiunea 3
//One table for each entity.Will join tables to compose an entity
//Drawback : Complexity beacause of Join
/*
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
*/
//Optiunea 4
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)


public class Animal
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
    protected String name;
    protected String photoUrl;

    /* ONE TO ONE
    @OneToOne(mappedBy = "animal")
    private AnimalShelter shelter;
    */

    /*MANY TO ONE
    @ManyToOne(name = "shelter_id")
    AnimalShelter shelter;
    */

    //-Bidirectional Many to Many
    /*@ManyToMany(mappedBy = "animals")
    List<AnimalShelter> shelters= new ArrayList<>();
    */


    public Animal()
    {

    }

    public Integer getId() {
        return id;
    }

    public Animal setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
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

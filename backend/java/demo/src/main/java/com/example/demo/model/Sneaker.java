    package com.example.demo.model;
    
    import jakarta.persistence.*;
    
    @Entity
    @Table(name = "sneakers")
    public class Sneaker {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        @Column(name = "sneakers_name")
        private String sneakersName;
    
        @Column(name = "count_of_sneakers")
        private int countOfSneakers;
    
        @Column(name = "sum_sneakers")
        private int sumSneakers;
    

        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public String getSneakersName() {
            return sneakersName;
        }
    
        public void setSneakersName(String sneakersName) {
            this.sneakersName = sneakersName;
        }
    
        public int getCountOfSneakers() {
            return countOfSneakers;
        }
    
        public void setCountOfSneakers(int countOfSneakers) {
            this.countOfSneakers = countOfSneakers;
        }
    
        public int getSumSneakers() {
            return sumSneakers;
        }
    
        public void setSumSneakers(int sumSneakers) {
            this.sumSneakers = sumSneakers;
        }
    }

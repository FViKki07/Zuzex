package org.example.zuzex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseServImpl implements HouseService {

    @Autowired
    HouseRepo houseRepo;

    @Override
    public House createHouse(House house){
        return houseRepo.save(house);
    }

    @Override
    public House getHouse(Long id) {
        return houseRepo.findById(id).orElseThrow(() -> new RuntimeException("House not found"));
    }

    @Override
    public House updateHouse(House house) {
        return houseRepo.saveAndFlush(house);
    }

    @Override
    public void deleteHouse(Long id) {
        houseRepo.deleteById(id);
    }

    @Override
    public House addNeighbor(Long id, House_user new_n, House_user owner) {
        House house = houseRepo.findById(id).orElseThrow(() -> new RuntimeException("House not found"));
        System.out.println("House id"+house.getId_own() + " User id "+owner+new_n);
        // Проверяем, что пользователь, выполняющий операцию, является владельцем дома
        if (house.getId_own() != owner.getId()) {
            throw new RuntimeException("The user is not the owner of the house");
        }


        house.getOccupants().add(new_n);
        return houseRepo.saveAndFlush(house);
/*
        House house = houseRepo.findById(id).get();
        System.out.println("ssdDsdds");
        if(house.getId_own() == owner.getId()){
            System.out.println("sds");
            List<House_user> neighbors = house.getOccupants();
            neighbors.add(new_n);
            house.setOccupants(neighbors);
            houseRepo.saveAndFlush(house);
        }
        return house;*/
    }

}

package org.example.zuzex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HouseController {
    @Autowired
    HouseService houseServ;

    @PostMapping("/house")
    public House createHouse(@RequestBody House house){
       // System.out.println(id_own+" "+address);
        //House house = new House(Long.parseLong(id_own), address);
        return houseServ.createHouse(house);
    }

    @GetMapping("/house/{id}")
    public House getHouse(@PathVariable("id")Long id){
        return houseServ.getHouse(id);
    }

    @PutMapping("/house/update/{id}")
    public House updateHouse(@RequestBody House house){
        return houseServ.updateHouse(house);
    }

    @DeleteMapping("/house/{id}")
    public void deleteHouse(@PathVariable("id")Long id){
        houseServ.deleteHouse(id);
    }

    @PutMapping("/house/{id}/addNeighbor")
    public House addNeighbor(@PathVariable("id")Long id,House_user neig, House_user owner){
        return houseServ.addNeighbor(id, neig, owner);
    }

}

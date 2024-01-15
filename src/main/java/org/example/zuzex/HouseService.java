package org.example.zuzex;

public interface HouseService {

    House createHouse(House house);
    House getHouse(Long id);
    House updateHouse(House house);
    void deleteHouse(Long id);
    House addNeighbor(Long id, House_user nei, House_user owner);

}

package com.gatech.cs6310.control;

import com.gatech.cs6310.dto.DroneResponse;
import com.gatech.cs6310.entites.Drone;
import com.gatech.cs6310.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/drone")
public class DroneController {
    final DroneService droneService;

    @Autowired
    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @PostMapping("/inquiryDronesByStore")
    @ResponseBody
    public DroneResponse inquiryItemsByStore(@RequestBody String store){
        return droneService.inquiryDronesByStore(store);
    }

    @PostMapping("/removeDrone")
    @ResponseBody
    public DroneResponse removeDrone(Integer droneId){
        return droneService.removeDrone(droneId);
    }

    @PostMapping("/addDrone")
    @ResponseBody
    public DroneResponse removeDrone(Drone drone){
        return droneService.addDrone(drone);
    }
}

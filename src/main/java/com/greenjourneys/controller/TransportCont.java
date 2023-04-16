package com.greenjourneys.controller;

import com.greenjourneys.entities.Transport;
import com.greenjourneys.entities.Type_Moyen;
import com.greenjourneys.services.ITransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransportCont {

    @Autowired
    ITransportService transportService;

    @GetMapping(value = "/transport/getAll")
    @ResponseBody
    List<Transport> getAll() {
        return transportService.retrieveAll();
    }

    @GetMapping(value = "/transport/getById/{id}")
    @ResponseBody
    Transport getById(@PathVariable("id") Integer id) {
        return transportService.retrieveById(id);
    }

    @GetMapping(value = "/transport/gasConsumption/{id}")
    @ResponseBody
    double gasConsumption(@PathVariable("id") Integer id) {
        Transport transport = transportService.retrieveById(id);

        switch (transport.getType_moyen()) {
            case Train:
                return transport.getDistance() / 0.006;
            case Bus:
                return transport.getDistance() / 0.4;
            case Metro:
                return 0.0;
            case Avion:
                return transport.getDistance() / 7.57082;
            case Voiture:
                return transport.getDistance() / 0.12;
            default:
                return 0.0;
        }
    }
    @PostMapping(value = "/transport/add")
    @ResponseBody
    Transport add(@RequestBody Transport transport) {
        return transportService.add(transport);
    }

    @PutMapping(value = "/transport/update")
    @ResponseBody
    Transport update(@RequestBody Transport transport) {
        return transportService.update(transport);
    }

    @DeleteMapping(value = "/transport/delete/{id}")
    @ResponseBody
    Boolean delete(@PathVariable("id") Integer id) {
        return transportService.delete(id);
    }
}
